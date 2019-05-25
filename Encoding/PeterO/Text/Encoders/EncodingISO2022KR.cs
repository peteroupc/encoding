using System;
using System.IO;
using PeterO;
using PeterO.Text;

namespace PeterO.Text.Encoders {
  internal class EncodingISO2022KR : ICharacterEncoding {
    private class Decoder : ICharacterDecoder {
      private readonly DecoderState state;
      private int machineState;
      private int lead;
      private bool escapeState;

      public Decoder() {
        this.state = new DecoderState(2);
      }

      public int ReadChar(IByteReader stream) {
        int cc = this.state.GetChar();
        if (cc >= 0) {
          return cc;
        }
        var tempState = 0;
        while (true) {
          int b = this.state.ReadInputByte(stream);
          switch (this.machineState) {
            case 0:
              // Beginning of line
              if (b == 0x1b) {
                this.machineState = 1;
              } else if (b < 0) {
                return -1;
              } else if (b <= 0x7f && b != 0x0e && b != 0x0f) {
                this.machineState = 4;
                return b;
              } else {
                return -2;
              }
              break;
            case 10:
              // Beginning of line, after escape
              if (b == 0x1b) {
                this.machineState = 1;
              } else if (b < 0) {
                return -1;
              } else if (b == 0x0d) {
                tempState = machineState;
                machineState = 9;
                break;
              } else if (b == 0x0e) {
                this.machineState = 6;
              } else if (b <= 0x7f && b != 0x0e && b != 0x0f) {
                this.machineState = 4;
                return b;
              } else {
                return -2;
              }
              break;
            case 1:
              // Escape start
              if (b == '$') {
                this.machineState = 2;
              } else {
                state.PrependOne(b);
                machineState = 4;
                return -2;
              }
              break;
            case 2:
              // Escape middle
              if (b == ')') {
                this.machineState = 3;
              } else {
                state.PrependTwo((int)'$', b);
                machineState = 4;
                return -2;
              }
              break;
            case 3:
              // Escape final
              if (b == 'C') {
                this.machineState = 5;
                this.lead = 0;
                this.escapeState = true;
              } else {
                state.PrependThree((int)'$', (int)')', b);
                machineState = 4;
                return -2;
              }
              break;
            case 4:
              // In middle of line, no escape
              if (b == 0x1b) {
                return -2;
              } else if (b < 0) {
                return -1;
              } else if (b == 0x0d) {
                tempState = machineState;
                machineState = 9;
                break;
              } else if (b <= 0x7f && b != 0x0e && b != 0x0f) {
                return b;
              } else {
                return -2;
              }
            case 5:
              // In middle of line, escape, ASCII
              if (b == 0x1b) {
                return -2;
              } else if (b < 0) {
                return -1;
              } else if (b == 0x0d) {
                tempState = machineState;
                machineState = 9;
                break;
              } else if (b == 0x0e) {
                this.machineState = 6;
              } else if (b <= 0x7f && b != 0x0e && b != 0x0f) {
                return b;
              } else {
                return -2;
              }
              break;
            case 6:
              // In middle of line, escape, first lead
              if (b >= 0x21 && b <= 0x7e) {
                this.lead = b;
                this.machineState = 8;
              } else if (b == 0x0d) {
                tempState = machineState;
                machineState = 9;
              } else {
                return -2;
              }
              break;
            case 7:
              // In middle of line, escape, other lead
              if (b >= 0x21 && b <= 0x7e) {
                this.lead = b;
                this.machineState = 8;
                break;
              } else if (b == 0x0f) {
                machineState = 5;
                break;
              } else if (b == 0x0d) {
                tempState = machineState;
                machineState = 9;
                break;
              } else {
                return -2;
              }
            case 8:
              // In middle of line, escape, trail
              if (b >= 0x21 && b <= 0x7e) {
                int p = ((this.lead - 0x21) * 190) + (b - 0x21) + 6176;
                int cp = Korean.IndexToCodePoint(p);
                this.lead = 0;
                this.machineState = 7;
                if (cp < 0) {
                  return -2;
                } else {
                  return cp;
                }
              } else if (b == 0x0f) {
                machineState = 5;
                break;
              } else {
                machineState = 7;
                return -2;
              }
            case 9:
              // CR
              if (b == 0x0a) {
                this.state.AppendChar(0x0a);
                this.machineState = this.escapeState ? 10 : 0;
                return 0x0d;
              } else if (tempState == 4 || tempState == 5) {
                // Merely in middle of line in ASCII mode
                this.state.PrependOne(b);
                machineState = tempState;
                return 0x0d;
              } else {
                this.state.PrependOne(b);
                machineState = tempState;
                return -2;
              }
            default: {
                // NOTE: Escape final state is no longer used
                throw new InvalidOperationException("Unexpected state");
              }
          }
        }
      }
    }

    private class Encoder : ICharacterEncoder {
      private bool starting;
      private bool shiftout;

      private int WritePreamble(IWriter output) {
        if (this.starting) {
          output.WriteByte(0x1b);
          output.WriteByte(0x24);
          output.WriteByte(0x29);
          output.WriteByte(0x43);
          this.starting = false;
          return 4;
        }
        return 0;
      }

      private int WriteShiftin(IWriter output) {
        if (this.shiftout) {
          output.WriteByte(0x0f);
          this.shiftout = false;
          return 1;
        }
        return 0;
      }

      private int WriteShiftout(IWriter output) {
        if (!this.shiftout) {
          output.WriteByte(0x0e);
          this.shiftout = true;
          return 1;
        }
        return 0;
      }

      public int Encode(int c, IWriter output) {
        var count = 0;
        if (c < 0) {
          count += this.WriteShiftout(output);
          return count > 0 ? count : -1;
        }
        if (c == 0x0f || c == 0x0e || c == 0x1b) {
          return -2;
        } else if (c < 0x80) {
          count += this.WritePreamble(output);
          count += this.WriteShiftin(output);
          output.WriteByte(c);
          return count + 1;
        }
        int pointer = Korean.CodePointToIndex(c);
        if (pointer < 0) {
          return -2;
        }
        if (pointer < (26 + 26 + 126) * (0xc7 - 0x81)) {
          int lead = (pointer / (26 + 26 + 126)) + 1;
          int trail = (pointer % (26 + 26 + 126)) - 26 - 26 + 1;
          if (lead < 0x21 || trail < 0x21) {
            return -2;
          }
          count += this.WritePreamble(output);
          count += this.WriteShiftout(output);
          output.WriteByte(lead);
          output.WriteByte(trail);
          return count + 2;
        } else {
          pointer -= (26 + 26 + 126) * (0xc7 - 0x81);
          int lead = (pointer / 94) + 0x47;
          int trail = (pointer % 94) + 0x21;
          count += this.WritePreamble(output);
          count += this.WriteShiftout(output);
          output.WriteByte(lead);
          output.WriteByte(trail);
          return count + 2;
        }
      }
    }

    public ICharacterDecoder GetDecoder() {
      return new Decoder();
    }

    public ICharacterEncoder GetEncoder() {
      return new Encoder();
    }
  }
}
