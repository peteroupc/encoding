package com.upokecenter.text.encoders;

import java.io.*;
import com.upokecenter.util.*;
import com.upokecenter.text.*;

  public class EncodingISO2022JP2 implements ICharacterEncoding {
    private static class Decoder implements ICharacterDecoder {
      private final DecoderState state;
      private int machineState;
      private int outputState;
      private int lead;
      private int output;
      private int leadTrailSet;

      private static final int[] Iso88597 = {
        128, 129, 130,
        131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
        145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
        159, 160, 8216, 8217, 163, 8364, 8367, 166, 167, 168, 169, 890, 171,
        172, 173, -2, 8213, 176, 177, 178, 179, 900, 901, 902, 183, 904, 905,
        906, 187, 908, 189, 910, 911, 912, 913, 914, 915, 916, 917, 918, 919,
        920, 921, 922, 923, 924, 925, 926, 927, 928, 929, -2, 931, 932, 933,
        934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 947,
        948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959, 960, 961,
        962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, -2,
      };

      public Decoder() {
        this.state = new DecoderState(2);
      }

      public int ReadChar(IByteReader stream) {
        while (true) {
          int b = this.state.ReadInputByte(stream);
          switch (this.machineState) {
            case 0:
              // ASCII
              if (b == 0x1b) {
                this.machineState = 1;
              } else if (b < 0) {
                return -1;
              } else if (b <= 0x7f && b != 0x0e && b != 0x0f) {
                this.output = 0;
                return b;
              } else {
                this.output = 0;
                return -2;
              }
              break;
            case 1:
              // Escape start
              if (b == 0x24 || b == 0x28 || b == '.') {
                this.lead = b;
                this.machineState = 2;
              } else {
                this.state.PrependOne(b);
                this.output = 0;
                this.machineState = this.outputState;
                return -2;
              }
              break;
            case 2: {
                // Escape
                int tmpState = -1;
                if (this.lead == 0x24 && (b == 0x40 || b == 0x42)) {
                  tmpState = 4; // JIS0208
                  this.leadTrailSet = 0;
                  this.lead = 0;
                } else if (this.lead == 0x24 && b == 0x41) {
                  tmpState = 4; // GB2312
                  this.leadTrailSet = 1;
                  this.lead = 0;
                } else if (this.lead == 0x28 && b == 0x42) {
                  tmpState = 0; // Ascii
                  this.lead = 0;
                } else if (this.lead == '.' && b == 'A') {
                  tmpState = 7; // ISO-8859-1
                  this.lead = 0;
                } else if (this.lead == '.' && b == 'F') {
                  tmpState = 8; // ISO-8859-7
                  this.lead = 0;
                } else if (this.lead == 0x28 && b == 0x4a) {
                  tmpState = 3; // Roman
                  this.lead = 0;
                } else if (this.lead == 0x24 && b == '(') {
                  tmpState = 9; // Escape final
                  this.lead = 0;
                } else if (this.lead == 0x28 && b == 0x49) {
                  tmpState = 6;
                  this.lead = 0;
                } else {
                  this.state.PrependTwo(this.lead, b);
                  this.lead = 0;
                  this.machineState = this.outputState;
                  return -2;
                }
                this.machineState = this.outputState = tmpState;
                if (this.output != 0) {
                  return -2;
                } else if (tmpState != 9) {
                  this.output = 1;
                }
                break;
              }
            case 9: {
                // Escape final
                int tmpState = -1;
                if (b == 'C') {
                  tmpState = 4; // KSC5601
                  this.leadTrailSet = 3;
                  this.lead = 0;
                } else if (b == 'D') {
                  tmpState = 4; // JIS0212
                  this.leadTrailSet = 2;
                  this.lead = 0;
                } else {
                  this.state.PrependThree(this.lead, 0x28, b);
                  this.lead = 0;
                  this.machineState = this.outputState;
                  return -2;
                }
                this.machineState = this.outputState = tmpState;
                if (this.output != 0) {
                  return -2;
                } else {
                  this.output = 1;
                }
                break;
              }
            case 4:
              // Lead
              if (b == 0x1b) {
                this.machineState = 1;
              } else if (b >= 0x21 && b <= 0x7e) {
                this.output = 0;
                this.lead = b;
                this.machineState = 5;
              } else if (b < 0) {
                return -1;
              } else {
                this.output = 0;
                return -2;
              }
              break;
            case 5: // Trail
              if (b < 0) {
                this.machineState = 4;
                this.state.PrependOne(b);
                return -2;
              } else if (b == 0x1b) {
                this.machineState = 1;
                return -2;
              } else if (b >= 0x21 && b <= 0x7e) {
                this.machineState = 4;
                int p = -1;
                int c = -1;
                if (this.leadTrailSet == 0) {
                  // JIS 0208
                  p = ((this.lead - 0x21) * 94) + (b - 0x21);
                  c = Jis0208.IndexToCodePoint(p);
                } else if (this.leadTrailSet == 1) {
                  // GB2312
                  p = ((this.lead - 0x21) * 190) + (b - 0x21) + 6176;
                  c = Gb18030.IndexToCodePoint(p);
                } else if (this.leadTrailSet == 2) {
                  // JIS 0212
                  p = ((this.lead - 0x21) * 94) + (b - 0x21);
                  c = Jis0212.IndexToCodePoint(p);
                } else if (this.leadTrailSet == 3) {
                  // KSC 5601
                  p = ((this.lead - 0x21) * 190) + (b - 0x21) + 6176;
                  c = Korean.IndexToCodePoint(p);
                }
                return c < 0 ? -2 : c;
              } else {
                this.machineState = 4;
                return -2;
              }
            case 6: // Katakana
              if (b == 0x1b) {
                this.machineState = 1;
              } else if (b >= 0x21 && b <= 0x5f) {
                this.output = 0;
                return 0xff40 + b;
              } else if (b < 0) {
                return -1;
              } else {
                this.output = 0;
                return -2;
              }
              break;
            case 7: // ISO-8859-1
              if (b == 0x1b) {
                this.machineState = 1;
              } else if (b >= 0x20 && b <= 0x7f) {
                this.output = 0;
                return 0x80 + b;
              } else if (b < 0) {
                return -1;
              } else {
                this.output = 0;
                return -2;
              }
              break;
            case 8: // ISO-8859-7
              if (b == 0x1b) {
                this.machineState = 1;
              } else if (b >= 0x20 && b <= 0x7f) {
                this.output = 0;
                return Iso88597[b];
              } else if (b < 0) {
                return -1;
              } else {
                this.output = 0;
                return -2;
              }
              break;
            case 3: // Roman
              if (b == 0x1b) {
                this.machineState = 1;
              } else if (b == 0x5c) {
                this.output = 0;
                return 0xa5;
              } else if (b == 0x7e) {
                this.output = 0;
                return 0x203e;
              } else if (b < 0x7f && b != 0x0e && b != 0x0f) {
                this.output = 0;
                return b;
              } else if (b < 0) {
                return -1;
              } else {
                this.output = 0;
                return -2;
              }
              break;
            default: {
                throw new IllegalStateException("Unexpected state");
              }
          }
        }
      }
    }

    private static class Encoder implements ICharacterEncoder {
      private int encoderState;

      public Encoder() {
      }

      private static int[] katakana = {
        12290, 12300, 12301, 12289, 12539,
        12530, 12449, 12451, 12453, 12455, 12457, 12515, 12517, 12519,
        12483, 12540, 12450, 12452, 12454, 12456, 12458, 12459, 12461,
        12463, 12465, 12467, 12469, 12471, 12473, 12475, 12477, 12479,
        12481, 12484, 12486, 12488, 12490, 12491, 12492, 12493, 12494,
        12495, 12498, 12501, 12504, 12507, 12510, 12511, 12512, 12513,
        12514, 12516, 12518, 12520, 12521, 12522, 12523, 12524, 12525,
        12527, 12531, 12443, 12444,
      };

      public int Encode(int c, IWriter output) {
        int count = 0;
        while (true) {
          if (c < 0) {
            if (this.encoderState != 0) {
              this.encoderState = 0;
              output.write((byte)0x1b);
              output.write((byte)0x28);
              output.write((byte)0x42);
              return count + 3;
            } else {
              return -1;
            }
          }
          if (c <= 0x7f) {
            if ((this.encoderState == 0 || this.encoderState == 3) &&
          (c == 0x0e || c == 0x0f || c == 0x1b)) {
              // TODO: Find a way to convey errors with
              // a different code point, in this case, U + FFFD
              return -2;
            }
            if (this.encoderState == 0) {
              output.write((byte)c);
              return 1 + count;
            } else if (this.encoderState == 3 && c != 0x5c && c != 0x7e) {
              output.write((byte)c);
              return 1 + count;
            } else {
              this.encoderState = 0;
              output.write((byte)0x1b);
              output.write((byte)0x28);
              output.write((byte)0x42);
              count += 3;
              continue;
            }
          }
          if (this.encoderState == 3 && c == 0xa5) {
            output.write((byte)0x5c);
            return 1 + count;
          }
          if (this.encoderState == 3 && c == 0x203e) {
            output.write((byte)0x7e);
            return 1 + count;
          }
          if (this.encoderState != 3 && (c == 0xa5 || c == 0x203e)) {
            this.encoderState = 3;
            output.write((byte)0x1b);
            output.write((byte)0x28);
            output.write((byte)0x4a);
            count += 3;
            continue;
          }
          if (c >= 0xff61 && c < 0xffa0) {
            c = katakana[c - 0xff61];
          }
          if (c == 0x2212) {
            c = 0xff0d;
          }
          int cp = Jis0208.CodePointToIndex(c);
          if (cp < 0) {
            return -2;
          }
          if (this.encoderState != 4) {
            this.encoderState = 4;
            output.write((byte)0x1b);
            output.write((byte)0x24);
            output.write((byte)0x42);
            count += 3;
          }
          int a = cp / 94;
          int b = cp % 94;
          output.write((byte)(a + 0x21));
          output.write((byte)(b + 0x21));
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
