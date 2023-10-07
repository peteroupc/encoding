using System;
using System.IO;
using PeterO;
using PeterO.Text;

namespace PeterO.Text.Encoders {
  internal class EncodingGB18030 : ICharacterEncoding {
    private static readonly int[] ValueGb18030table = new int[] {
      0,
      0x0080,
      36, 0x00a5,
      38, 0x00a9,
      45, 0x00b2,
      50, 0x00b8,
      81, 0x00d8,
      89, 0x00e2,
      95, 0x00eb,
      96, 0x00ee,
      100, 0x00f4,
      103, 0x00f8,
      104, 0x00fb,
      105, 0x00fd,
      109, 0x0102,
      126, 0x0114,
      133, 0x011c,
      148, 0x012c,
      172, 0x0145,
      175, 0x0149,
      179, 0x014e,
      208, 0x016c,
      306, 0x01cf,
      307, 0x01d1,
      308, 0x01d3,
      309, 0x01d5,
      310, 0x01d7,
      311, 0x01d9,
      312, 0x01db,
      313, 0x01dd,
      341, 0x01fa,
      428, 0x0252,
      443, 0x0262,
      544, 0x02c8,
      545, 0x02cc,
      558, 0x02da,
      741, 0x03a2,
      742, 0x03aa,
      749, 0x03c2,
      750, 0x03ca,
      805, 0x0402,
      819, 0x0450,
      820, 0x0452,
      7922, 0x2011,
      7924, 0x2017,
      7925, 0x201a,
      7927, 0x201e,
      7934, 0x2027,
      7943, 0x2031,
      7944, 0x2034,
      7945, 0x2036,
      7950, 0x203c,
      8062, 0x20ad,
      8148, 0x2104,
      8149, 0x2106,
      8152, 0x210a,
      8164, 0x2117,
      8174, 0x2122,
      8236, 0x216c,
      8240, 0x217a,
      8262, 0x2194,
      8264, 0x219a,
      8374, 0x2209,
      8380, 0x2210,
      8381, 0x2212,
      8384, 0x2216,
      8388, 0x221b,
      8390, 0x2221,
      8392, 0x2224,
      8393, 0x2226,
      8394, 0x222c,
      8396, 0x222f,
      8401, 0x2238,
      8406, 0x223e,
      8416, 0x2249,
      8419, 0x224d,
      8424, 0x2253,
      8437, 0x2262,
      8439, 0x2268,
      8445, 0x2270,
      8482, 0x2296,
      8485, 0x229a,
      8496, 0x22a6,
      8521, 0x22c0,
      8603, 0x2313,
      8936, 0x246a,
      8946, 0x249c,
      9046, 0x254c,
      9050, 0x2574,
      9063, 0x2590,
      9066, 0x2596,
      9076, 0x25a2,
      9092, 0x25b4,
      9100, 0x25be,
      9108, 0x25c8,
      9111, 0x25cc,
      9113, 0x25d0,
      9131, 0x25e6,
      9162, 0x2607,
      9164, 0x260a,
      9218, 0x2641,
      9219, 0x2643,
      11329, 0x2e82,
      11331, 0x2e85,
      11334, 0x2e89,
      11336, 0x2e8d,
      11346, 0x2e98,
      11361, 0x2ea8,
      11363, 0x2eab,
      11366, 0x2eaf,
      11370, 0x2eb4,
      11372, 0x2eb8,
      11375, 0x2ebc,
      11389, 0x2ecb,
      11682, 0x2ffc,
      11686, 0x3004,
      11687, 0x3018,
      11692, 0x301f,
      11694, 0x302a,
      11714, 0x303f,
      11716, 0x3094,
      11723, 0x309f,
      11725, 0x30f7,
      11730, 0x30ff,
      11736, 0x312a,
      11982, 0x322a,
      11989, 0x3232,
      12102, 0x32a4,
      12336, 0x3390,
      12348, 0x339f,
      12350, 0x33a2,
      12384, 0x33c5,
      12393, 0x33cf,
      12395, 0x33d3,
      12397, 0x33d6,
      12510, 0x3448,
      12553, 0x3474,
      12851, 0x359f,
      12962, 0x360f,
      12973, 0x361b,
      13738, 0x3919,
      13823, 0x396f,
      13919, 0x39d1,
      13933, 0x39e0,
      14080, 0x3a74,
      14298, 0x3b4f,
      14585, 0x3c6f,
      14698, 0x3ce1,
      15583, 0x4057,
      15847, 0x4160,
      16318, 0x4338,
      16434, 0x43ad,
      16438, 0x43b2,
      16481, 0x43de,
      16729, 0x44d7,
      17102, 0x464d,
      17122, 0x4662,
      17315, 0x4724,
      17320, 0x472a,
      17402, 0x477d,
      17418, 0x478e,
      17859, 0x4948,
      17909, 0x497b,
      17911, 0x497e,
      17915, 0x4984,
      17916, 0x4987,
      17936, 0x499c,
      17939, 0x49a0,
      17961, 0x49b8,
      18664, 0x4c78,
      18703, 0x4ca4,
      18814, 0x4d1a,
      18962, 0x4daf,
      19043, 0x9fa6,
      33469, 0xe76c,
      33470, 0xe7c8,
      33471, 0xe7e7,
      33484, 0xe815,
      33485, 0xe819,
      33490, 0xe81f,
      33497, 0xe827,
      33501, 0xe82d,
      33505, 0xe833,
      33513, 0xe83c,
      33520, 0xe844,
      33536, 0xe856,
      33550, 0xe865,
      37845, 0xf92d,
      37921, 0xf97a,
      37948, 0xf996,
      38029, 0xf9e8,
      38038, 0xf9f2,
      38064, 0xfa10,
      38065, 0xfa12,
      38066, 0xfa15,
      38069, 0xfa19,
      38075, 0xfa22,
      38076, 0xfa25,
      38078, 0xfa2a,
      39108, 0xfe32,
      39109, 0xfe45,
      39113, 0xfe53,
      39114, 0xfe58,
      39115, 0xfe67,
      39116, 0xfe6c,
      39265, 0xff5f,
      39394, 0xffe6,
      39419, 0xffff,
    };

    private static int GB18030CodePoint(int pointer) {
      if (pointer < 0) {
        throw new ArgumentException("pointer(" + pointer +
          ") is less than 0");
      }
      if ((pointer > 39419 && pointer < 189000) || pointer > 1237575) {
        return -1;
      }
      if (pointer >= 189000) {
        return 0x10000 + pointer - 189000;
      }
      if (pointer == 7457) {
        return 0xe7c7;
      }
      var v = -1;
      for (int i = 0; i < ValueGb18030table.Length; i += 2) {
        if (ValueGb18030table[i] <= pointer) {
          v = i;
        } else {
          break;
        }
      }
      if (v < 0) {
        throw new InvalidOperationException("Internal error");
      }
      if (v >= ValueGb18030table.Length) {
        return -1;
      }
      try {
        int cpoffset = ValueGb18030table[v + 1];
        int offset = ValueGb18030table[v];
        return cpoffset + pointer - offset;
      } catch (Exception ex) {
        throw new InvalidOperationException(
          ex.Message + " " + ex.StackTrace + "\n" + "\npointer=" + pointer +
          "\noffset=" + v + " of " + ValueGb18030table.Length);
      }
    }

    private static int GB18030Pointer(int codepoint) {
      if (codepoint < 0x80 || codepoint >= 0x110000) {
        return -1;
      }
      if (codepoint >= 0x10000) {
        return 189000 + codepoint - 0x10000;
      }
      if (codepoint == 0xffff) {
        return 39419;
      }
      if (codepoint == 0xe7c7) {
        return 7457;
      }
      var v = -1;
      for (int i = 0; i < ValueGb18030table.Length; i += 2) {
        if (ValueGb18030table[i + 1] <= codepoint) {
          v = i;
        } else {
          break;
        }
      }
      if (v >= ValueGb18030table.Length) {
        return -1;
      }
      int cpoffset = ValueGb18030table[v + 1];
      int offset = ValueGb18030table[v];
      return offset + codepoint - cpoffset;
    }

    private class Decoder : ICharacterDecoder {
      private readonly DecoderState state;
      private int gbk1;
      private int gbk2;
      private int gbk3;
      private bool gb2022;

      public Decoder(bool gb2022) {
        this.state = new DecoderState(3);
        this.gb2022 = gb2022;
      }

      public Decoder() : this(true) {
      }

      public int ReadChar(IByteReader stream) {
        int c;
        while (true) {
          int b;
          b = this.state.ReadInputByte(stream);
          if (b < 0) {
            if ((this.gbk1 | this.gbk2 | this.gbk3) == 0) {
              return -1;
            }
            this.gbk1 = this.gbk2 = this.gbk3 = 0;
            return -2;
          }
          if (this.gbk3 != 0) {
            c = -1;
            #if DEBUG
            if (this.gbk1 < 0x81) {
              throw new ArgumentException("this.gbk1(" + this.gbk1 +
                ") is less than " + 0x81);
            }
            if (this.gbk2 < 0x30) {
              throw new ArgumentException("this.gbk2(" + this.gbk2 +
                ") is less than " + 0x30);
            }
            if (this.gbk3 < 0x81) {
              throw new ArgumentException("this.gbk3(" + this.gbk3 +
                ") is less than " + 0x81);
            }
            #endif

            if (b >= 0x30 && b <= 0x39) {
              #if DEBUG
              if (b < 0x30) {
                throw new ArgumentException("b(" + b + ") is less than " +
                  0x30);
              }
              #endif

              int ap = ((((((this.gbk1 - 0x81) * 10) + this.gbk2 - 0x30) *
                      126) + this.gbk3 - 0x81) * 10) + b - 0x30;
              c = GB18030CodePoint(ap);
              if (this.gb2022 && ap >= 19057 && ap <= 19064) {
                int[]
cs = {0xe81e, 0xe826, 0xe82b, 0xe82c, 0xe832, 0xe843, 0xe854, 0xe864 };
                c = cs[ap - 19057];
              }
              if (this.gb2022 && ap >= 39076 && ap <= 39085) {
                int[]
cs = {
  0xe78d, 0xe78f, 0xe78e, 0xe790, 0xe791, 0xe792, 0xe793, 0xe794,
  0xe795, 0xe796,
};
                c = cs[ap - 39076];
              }
              this.gbk1 = this.gbk2 = this.gbk3 = 0;
              return (c < 0) ? (-2) : c;
            } else {
              this.state.PrependThree(this.gbk2, this.gbk3, b);
              this.gbk1 = this.gbk2 = this.gbk3 = 0;
              return -2;
            }
          }
          if (this.gbk2 != 0) {
            if (b >= 0x81 && b <= 0xfe) {
              this.gbk3 = b;
              continue;
            }
            this.state.PrependTwo(this.gbk2, b);
            this.gbk1 = this.gbk2 = 0;
            return -2;
          }
          if (this.gbk1 != 0) {
            if (b >= 0x30 && b <= 0x39) {
              this.gbk2 = b;
              continue;
            }
            int a1 = this.gbk1;
            var ap = -1;
            this.gbk1 = 0;
            c = -1;
            int a2 = (b < 0x7f) ? 0x40 : 0x41;
            if ((b >= 0x40 && b <= 0x7e) || (b >= 0x80 && b <= 0xfe)) {
              ap = ((a1 - 0x81) * 190) + (b - a2);
              c = Gb18030.IndexToCodePoint(ap);
              if (this.gb2022) {
                if (ap >= 6555 && ap <= 7208) {
if (ap == 6555) {
  c = 0xe5e5;
}
if (ap == 7201) {
  c = 0xfe17;
}
if (ap == 7202) {
  c = 0xfe18;
}
if (ap == 7208) {
  c = 0xfe19;
}
              if (ap >= 7182 && ap <= 7188) {
                int[] cs = {
                  0xfe10, 0xfe12, 0xfe11, 0xfe13, 0xfe14, 0xfe15, 0xfe16,
                };
                c = cs[ap - 7182];
              }
              } else if (ap >= 23775) {
if (ap == 23775) {
  c = 0x9fb4;
}
if (ap == 23783) {
  c = 0x9fb5;
}
if (ap == 23788) {
  c = 0x9fb6;
}
if (ap == 23789) {
  c = 0x9fb7;
}
if (ap == 23795) {
  c = 0x9fb8;
}
if (ap == 23812) {
  c = 0x9fb9;
}
if (ap == 23829) {
  c = 0x9fba;
}
if (ap == 23845) {
  c = 0x9fbb;
}
              }
              }
            }
            if (c < 0) {
              if (b < 0x80) {
                this.state.PrependOne(b);
              }
              return -2;
            }
            return c;
          }
          if (b < 0x80) {
            return b;
          } else if (b == 0x80) {
            return 0x20ac;
          } else if (b == 0xff) {
            return -2;
          } else {
            this.gbk1 = b;
          }
        }
      }
    }

    private class Encoder : ICharacterEncoder {
      private readonly bool gbk;
      private readonly bool gb2022;

      public Encoder(bool gbk) : this(gbk, true) {
      }

      public Encoder(bool gbk, bool gb2022) {
        this.gbk = gbk;
        this.gb2022 = gb2022;
      }

      private int Write2(IWriter output, int a, int b) {
        output.WriteByte((byte)a);
        output.WriteByte((byte)b);
        return 2;
      }

      private int Write4(IWriter output, int a, int b, int c, int d) {
        output.WriteByte((byte)a);
        output.WriteByte((byte)b);
        output.WriteByte((byte)c);
        output.WriteByte((byte)d);
        return 4;
      }

      public int Encode(
        int c,
        IWriter output) {
        if (c < 0) {
          return -1;
        }
        if (c < 0x80) {
          output.WriteByte((byte)c);
          return 1;
        } else if (c == 0xe5e5 && !this.gb2022) {
          // Can't round trip under current WHATWG version
          // of specification; the bytes this code point corresponds
          // to map to U+3000 instead
          return -2;
        } else if (c == 0x20ac && this.gbk) {
          output.WriteByte((byte)0x80);
          return 1;
        }
        if (this.gb2022 && (c >= 0x9fb4 && c <= 0xa000) ||
               (c >= 0xe5e5 && c <= 0xfe19)) {
          if (c == 0xe81e) {
            return this.Write4(output, 130, 53, 144, 55);
          }
          if (c == 0xe826) {
            return this.Write4(output, 130, 53, 144, 56);
          }
          if (c == 0xe82b) {
            return this.Write4(output, 130, 53, 144, 57);
          }
          if (c == 0xe82c) {
            return this.Write4(output, 130, 53, 145, 48);
          }
          if (c == 0xe832) {
            return this.Write4(output, 130, 53, 145, 49);
          }
          if (c == 0xe843) {
            return this.Write4(output, 130, 53, 145, 50);
          }
          if (c == 0xe854) {
            return this.Write4(output, 130, 53, 145, 51);
          }
          if (c == 0xe864) {
            return this.Write4(output, 130, 53, 145, 52);
          }
          if (c == 0xe5e5) {
            return this.Write2(output, 163, 160);
          }
          if (c == 0xfe10) {
            return this.Write2(output, 166, 217);
          }
          if (c == 0xfe12) {
            return this.Write2(output, 166, 218);
          }
          if (c == 0xfe11) {
            return this.Write2(output, 166, 219);
          }
          if (c == 0xfe13) {
            return this.Write2(output, 166, 220);
          }
if (c == 0xfe14) {
            return this.Write2(output, 166, 221);
          }
if (c == 0xfe15) {
  return this.Write2(output, 166, 222);
}
if (c == 0xfe16) {
  return this.Write2(output, 166, 223);
}
if (c == 0xfe17) {
  return this.Write2(output, 166, 236);
}
if (c == 0xfe18) {
  return this.Write2(output, 166, 237);
}
if (c == 0xfe19) {
  return this.Write2(output, 166, 243);
}
if (c == 0x9fb4) {
  return this.Write2(output, 254, 89);
}
if (c == 0x9fb5) {
  return this.Write2(output, 254, 97);
}
if (c == 0x9fb6) {
  return this.Write2(output, 254, 102);
}
if (c == 0x9fb7) {
  return this.Write2(output, 254, 103);
}
if (c == 0x9fb8) {
  return this.Write2(output, 254, 109);
}
if (c == 0x9fb9) {
  return this.Write2(output, 254, 126);
}
if (c == 0x9fba) {
  return this.Write2(output, 254, 144);
}
if (c == 0x9fbb) {
  return this.Write2(output, 254, 160);
}
if (c == 0xe78d) {
  return this.Write4(output, 132, 49, 130, 54);
}
if (c == 0xe78f) {
  return this.Write4(output, 132, 49, 130, 55);
}
if (c == 0xe78e) {
  return this.Write4(output, 132, 49, 130, 56);
}
if (c == 0xe790) {
  return this.Write4(output, 132, 49, 130, 57);
}
if (c == 0xe791) {
  return this.Write4(output, 132, 49, 131, 48);
}
if (c == 0xe792) {
  return this.Write4(output, 132, 49, 131, 49);
}
if (c == 0xe793) {
  return this.Write4(output, 132, 49, 131, 50);
}
if (c == 0xe794) {
  return this.Write4(output, 132, 49, 131, 51);
}
if (c == 0xe795) {
  return this.Write4(output, 132, 49, 131, 52);
}
if (c == 0xe796) {
  return this.Write4(output, 132, 49, 131, 53);
}
        }
        int cp = Gb18030.CodePointToIndex(c);
        if (cp >= 0) {
          int a = cp / 190;
          int b = cp % 190;
          int cc = (b < 0x3f) ? 0x40 : 0x41;
          output.WriteByte((byte)(a + 0x81));
          output.WriteByte((byte)(b + cc));
          return 2;
        }
        if (this.gbk) {
          return -2;
        }
        cp = GB18030Pointer(c);
        int m = 10 * 126 * 10;
        int b1 = cp / m;
        cp -= b1 * m;
        m = 10 * 126;
        int b2 = cp / m;
        cp -= b2 * m;
        int b3 = cp / 10;
        int b4 = cp - (b3 * 10);
        b1 += 0x81;
        b2 += 0x30;
        b3 += 0x81;
        b4 += 0x30;
        output.WriteByte((byte)b1);
        output.WriteByte((byte)b2);
        output.WriteByte((byte)b3);
        output.WriteByte((byte)b4);
        return 4;
      }
    }

    internal static ICharacterDecoder GetDecoder2() {
      return new Decoder(false);
    }

    internal static ICharacterEncoder GetEncoder2(bool gbk) {
      return new Encoder(gbk, false);
    }

    internal static ICharacterDecoder GetDecoder3() {
      return new Decoder(true);
    }

    internal static ICharacterEncoder GetEncoder3(bool gbk) {
      return new Encoder(gbk, true);
    }

    private readonly ICharacterEncoder enc = GetEncoder2(false);

    public ICharacterDecoder GetDecoder() {
      return EncodingGB18030.GetDecoder2();
    }

    public ICharacterEncoder GetEncoder() {
      return this.enc;
    }
  }
}
