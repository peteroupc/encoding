using System;
using System.IO;
using PeterO;
using PeterO.Text;

namespace PeterO.Text.Encoders {
  internal class EncodingUtf16 : ICharacterEncoding {
    private class EndianFreeEncoder : ICharacterEncoder {
      private ICharacterEncoder encoder;
      private bool start;

      public EndianFreeEncoder() {
        this.start = true;
        this.encoder = new Encoder(false); // little-endian
      }

      public int Encode(int c, IWriter output) {
        if (this.start) {
          if (c < 0) {
            return -1;
          }
          var aw = new ArrayWriter();
          aw.WriteByte((byte)0xff);
          aw.WriteByte((byte)0xfe);
          int ret = this.encoder.Encode(c, aw);
          if (ret >= 0) {
            byte[] bytes = aw.ToArray();
            aw.Write(bytes, 0, bytes.Length);
            this.start = false;
            return ret + 2;
          }
          return ret;
        } else {
          return this.encoder.Encode(c, output);
        }
      }
    }

    private class EndianFreeDecoder : ICharacterDecoder {
      private ICharacterDecoder decoder;
      private bool start;

      public EndianFreeDecoder() {
        this.start = true;
      }

      public int ReadChar(IByteReader stream) {
        if (!this.start) {
          return this.decoder.ReadChar(stream);
        }
        int c = stream.ReadByte();
        if (c < 0) {
          return -1;
        }
        int c2 = stream.ReadByte();
        if (c2 < 0) {
          return -2; // Only one byte
        }
        this.start = false;
        if (c == 0xff && c2 == 0xfe) {
          this.decoder = new Decoder(false);
          return this.decoder.ReadChar(stream);
        } else {
          // Anything else, including FE FF, is
          // treated as big-endian (see RFC 2781 sec. 4.3)
          if (c == 0xfe && c2 == 0xff) {
            // absorb BOM
            this.decoder = new Decoder(true);
            return this.decoder.ReadChar(stream);
          } else if (c >= 0xd8 && c <= 0xdb) {
            // surrogate
            this.decoder = new Decoder(true, (c << 8) | c2);
            return this.decoder.ReadChar(stream);
          } else if (c >= 0xdc && c <= 0xdf) {
            // unpaired surrogate
            this.decoder = new Decoder(true);
            return -2;
          } else {
            // anything else {
            this.decoder = new Decoder(true);
          }
          return (c << 8) | c2;
        }
      }
    }

    private class Decoder : ICharacterDecoder {
      private readonly DecoderState state;
      private readonly bool bigEndian;
      private int lead;
      private int surrogate;

      public Decoder(bool bigEndian, int surrogate) {
        this.bigEndian = bigEndian;
        this.state = new DecoderState(1);
        this.lead = -1;
        this.surrogate = surrogate;
      }

      public Decoder(bool bigEndian) : this(bigEndian, -1) {
      }

      public int ReadChar(IByteReader stream) {
        while (true) {
          int b = this.state.ReadInputByte(stream);
          if (b < 0) {
            if (this.lead >= 0 || this.surrogate >= 0) {
              this.lead = this.surrogate = -1;
              return -2;
            }
            return -1;
          }
          if (this.lead < 0) {
            this.lead = b;
            continue;
          }
          int code = this.bigEndian ? b + (this.lead << 8) : this.lead + (b <<
              8);
          this.lead = -1;
          if (this.surrogate >= 0) {
            if ((code & 0xfc00) == 0xdc00) {
              code = 0x10000 + (code & 0x3ff) + ((this.surrogate & 0x3ff) <<
                  10);
              this.surrogate = -1;
              return code;
            }
            this.lead = -1;
            int b1 = (code >> 8) & 0xff;
            int b2 = code & 0xff;
            if (this.bigEndian) {
              this.state.PrependTwo(b1, b2);
            } else {
              this.state.PrependTwo(b2, b1);
            }
            this.surrogate = -1;
            return -2;
          }
          if ((code & 0xfc00) == 0xd800) {
            this.surrogate = code;
          } else {
            return (code & 0xfc00) == 0xdc00 ? -2 : code;
          }
        }
      }
    }

    private class Encoder : ICharacterEncoder {
      private readonly bool bigEndian;

      public Encoder(bool bigEndian) {
        this.bigEndian = bigEndian;
      }

      public int Encode(
        int c,
        IWriter output) {
        if (c < 0) {
          return -1;
        }
        if (c > 0x10ffff || ((c & 0x1ff800) == 0xd800)) {
          return -2;
        }
        int b1, b2;
        if (c <= 0xffff) {
          b1 = (c >> 8) & 0xff;
          b2 = c & 0xff;
          if (this.bigEndian) {
            output.WriteByte((byte)b1);
            output.WriteByte((byte)b2);
          } else {
            output.WriteByte((byte)b2);
            output.WriteByte((byte)b1);
          }
          return 2;
        }
        var buf = new byte[4];
        int c1 = ((c - 0x10000) >> 10) + 0xd800;
        int c2 = ((c - 0x10000) & 0x3ff) + 0xdc00;
        b1 = (c1 >> 8) & 0xff;
        b2 = c1 & 0xff;
        if (this.bigEndian) {
          buf[0] = (byte)b1;
          buf[1] = (byte)b2;
        } else {
          buf[0] = (byte)b2;
          buf[1] = (byte)b1;
        }
        b1 = (c2 >> 8) & 0xff;
        b2 = c2 & 0xff;
        if (this.bigEndian) {
          buf[2] = (byte)b1;
          buf[3] = (byte)b2;
        } else {
          buf[2] = (byte)b2;
          buf[3] = (byte)b1;
        }
        output.Write(buf, 0, 4);
        return 4;
      }
    }

    internal static ICharacterDecoder GetDecoder2(int kind) {
      // kind: 0-little-endian, 1-big-endian, 2-unlabeled
      return (kind == 2) ? ((ICharacterDecoder)new EndianFreeDecoder()) :
((ICharacterDecoder)new Decoder(kind == 1));
    }

    internal static ICharacterEncoder GetEncoder2(int kind) {
      // kind: 0-little-endian, 1-big-endian, 2-unlabeled
      return (kind == 2) ? ((ICharacterEncoder)new EndianFreeEncoder()) :
((ICharacterEncoder)new Encoder(kind == 1));
    }

    public ICharacterDecoder GetDecoder() {
      return GetDecoder2(2);
    }

    public ICharacterEncoder GetEncoder() {
      return GetEncoder2(2);
    }
  }
}
