using System;
using PeterO;
using PeterO.Text;

namespace EncodingTest {
  /// <summary>A character encoding class that implements a code page
  /// read from the code page file format described in the Windows
  /// Protocols Unicode Reference
  /// (https://msdn.microsoft.com/en-us/library/cc248954.aspx), section
  /// 2.2.2.1. The code page file format supports single-byte encodings
  /// and certain multi-byte encodings in which each character is encoded
  /// in one or two bytes.
  /// <para>The code page format defines a single-byte as a replacement
  /// character and can specify certain "best-fit" mappings from certain
  /// Unicode characters to the code page encoding if the Unicode
  /// character is unsupported in the code page encoding. When decoding,
  /// any invalid bytes or unassigned bytes in the code page encoding are
  /// converted to the specified replacement code point.</para></summary>
  public class CodePageEncoding : ICharacterEncoding {
    private CodePageCoder coder;

    /// <summary>Gets the code page's number.</summary>
    /// <value>The code page&#x27;s number.</value>
    public int Number {
      get {
        return this.coder.Number;
      }
    }

    /// <summary>Initializes a new instance of the CodePageEncoding
    /// class.</summary>
    /// <param name='input'>An ICharacterInput object.</param>
    public CodePageEncoding(ICharacterInput input) {
      this.coder = new CodePageCoder(input);
    }

    /// <summary>Not documented yet.</summary>
    /// <returns>An ICharacterDecoder object.</returns>
    public ICharacterDecoder GetDecoder() {
      return new CodePageCoder(this.coder, false);
    }

    /// <summary>Not documented yet.</summary>
    /// <returns>An ICharacterEncoder object.</returns>
    public ICharacterEncoder GetEncoder() {
      return new CodePageCoder(this.coder, false);
    }

    private sealed class CodePageCoder : ICharacterEncoder, ICharacterDecoder {
      private sealed class InputWithUnget : ICharacterInput {
        private readonly ICharacterInput transform;
        private int lastByte;
        private bool unget;

        public InputWithUnget(ICharacterInput stream) {
          this.lastByte = -1;
          this.transform = stream;
        }

        public int ReadChar() {
          if (this.unget) {
            this.unget = false;
          } else {
            this.lastByte = this.transform.ReadChar();
          }
          return this.lastByte;
        }

        public void Unget() {
          this.unget = true;
        }

        public int Read(int[] chars, int index, int length) {
          if (length == 0) {
            return 0;
          }
          var count = 0;
          for (var i = 0; i < length; ++i) {
            int c = this.ReadChar();
            if (c < 0) {
              break;
            }
            chars[index] = c;
            ++index;
          }
          return (count == 0) ? -1 : count;
        }
      }

      public int Encode(int c, IWriter output) {
        if (c < 0) {
          return -1;
        }
        int mapping = this.ucsToBytes.GetMapping(c);
        if (mapping < 0) {
          // Encode the default byte for this code page
          output.WriteByte((byte)(this.defaultNative & 0xff));
          return 1;
        }
        var ret = 1;
        if (mapping >= 0x100) {
          output.WriteByte((byte)((mapping >> 8) & 0xff));
          ret = 2;
        }
        output.WriteByte((byte)(mapping & 0xff));
        return ret;
      }

      private int lastByte = -1;
      private bool unget = false;
      private bool useGlyphs = false;

      public int ReadChar(IByteReader input) {
        int b1 = this.unget ? this.lastByte : input.ReadByte();
        this.unget = false;
        if (b1 < 0) {
          return -1;
        }
        int b = this.useGlyphs ? this.bytesToGlyphs[b1] : this.bytesToUCS[b1];
        if (b == -2) {
          return this.defaultUCS;
        } else if (b == -3) {
          int b2 = input.ReadByte();
          if (b2 < 0) {
            return this.defaultUCS;
          }
          int ret = this.dbcsToUCS.GetMapping((b1 << 8) | b2);
          if (ret == -2) {
            this.unget = true;
            this.lastByte = b2;
            return this.defaultUCS;
          } else {
            return ret;
          }
        } else {
          return b;
        }
      }

      private enum TokenType {
        Token,

        LineBreak,

        End,
      }

      private sealed class TokenReader {
        private TokenType type;
        private InputWithUnget input;

        public TokenReader(ICharacterInput ci) {
          this.input = new InputWithUnget(ci);
        }

        public void SkipToLine() {
          while (true) {
            this.ReadToTokenChar();
            if (this.type == TokenType.LineBreak || this.type ==
              TokenType.End) {
              return;
            }
          }
        }

        public int ExpectNumberOnSameLine() {
          this.ReadToTokenChar();
          return this.ExpectNumberInternal();
        }

        public int ExpectNumber() {
          do {
            this.ReadToTokenChar();
          } while (this.type == TokenType.LineBreak);
          return this.ExpectNumberInternal();
        }

        public int ExpectByte() {
          int number = this.ExpectNumber();
          if (number >= 256) {
            throw new ArgumentException("expected number from 0-255, got " +
              number);
          }
          return number;
        }

        public int ExpectByteOnSameLine() {
          int number = this.ExpectNumberOnSameLine();
          if (number >= 256) {
            throw new ArgumentException("expected number from 0-255, got " +
              number);
          }
          return number;
        }

        public int ExpectUInt16OnSameLine() {
          int number = this.ExpectNumberOnSameLine();
          if (number >= 65536) {
            throw new ArgumentException("expected number from 0-65536, got " +
              number);
          }
          return number;
        }

        public int ExpectCodePointOnSameLine() {
          int number = this.ExpectNumberOnSameLine();
          if (number >= 0x110000) {
            throw new ArgumentException("expected number from 0-0x10ffff," +
              "\u0020 got " + number);
          }
          return number;
        }

        public int ExpectCodePoint() {
          int number = this.ExpectNumber();
          if (number >= 0x110000) {
            throw new ArgumentException("expected number from 0-0x10ffff," +
              "\u0020 got " + number);
          }
          return number;
        }

        public int ExpectAnyOneWord(params string[] words) {
          do {
            this.ReadToTokenChar();
          } while (this.type == TokenType.LineBreak);
          var isPossible = new bool[words.Length];
          var wordIndices = new int[words.Length];
          int possibleCount = words.Length;
          for (var i = 0; i < words.Length; ++i) {
            isPossible[i] = true;
            wordIndices[i] = 0;
          }
          while (true) {
            int ch = this.input.ReadChar();
            for (var i = 0; i < words.Length; ++i) {
              int index = wordIndices[i];
              string wordStr = words[i];
              if (isPossible[i]) {
                if (index >= wordStr.Length) {
                  if (IsWordEndChar(ch)) {
                    this.input.Unget();
                    return i;
                  } else {
                    isPossible[i] = false;
                    --possibleCount;
                    if (possibleCount == 0) {
                      if (words.Length == 1) {
                        throw new ArgumentException("Expected nonword " +
                          "character" + "\u0020after '" + wordStr + "'");
                      } else {
                        throw new ArgumentException("unexpected word found");
                      }
                    }
                  }
                }
                string str = wordStr;
                int c = str[index];
                ++index;
                if ((c & 0xfc00) == 0xd800 && index + 1 < str.Length &&
                  (str[index + 1] & 0xfc00) == 0xdc00) {
                  // Get the Unicode code point for the surrogate pair
                  c = 0x10000 + ((c & 0x3ff) << 10) + (str[index + 1] & 0x3ff);
                  ++index;
                } else if ((c & 0xf800) == 0xd800) {
                  // unpaired surrogate
                  c = 0xfffd;
                }
                wordIndices[i] = index;
                if (ch != c) {
                  isPossible[i] = false;
                  --possibleCount;
                  if (possibleCount == 0) {
                    if (words.Length == 1) {
                      throw new ArgumentException("word '" + wordStr +
                        "' expected");
                    } else {
                      throw new ArgumentException("unexpected word found");
                    }
                  }
                }
              }
            }
          }
        }

        private int ExpectNumberInternal() {
          if (this.type != TokenType.Token) {
            throw new ArgumentException("number expected");
          }
          int number = this.ParseNumber();
          int c = this.input.ReadChar();
          this.input.Unget();
          if (!IsWordEndChar(c)) {
            throw new
            ArgumentException("Expected nonword character after '" +
              number + "'");
          }
          return number;
        }

        private int ParseNumber() {
          int c = this.input.ReadChar();
          if (c < '0' || c > '9') {
            throw new ArgumentException("Expected number");
          }
          var hex = false;
          var value = 0;
          if (c == '0') {
            c = this.input.ReadChar();
            if (c == 'x') {
              hex = true;
            } else if (c < '0' || c > '9') {
              this.input.Unget();
              return 0;
            } else {
              value += c - '0';
            }
          } else {
            value = c - '0';
          }
          if (hex) {
            while (true) {
              c = this.input.ReadChar();
              if (c >= '0' && c <= '9') {
                if ((value >> 28) != 0) {
                  throw new ArgumentException("Overflow");
                }
                value <<= 4;
                value |= c - '0';
              } else if (c >= 'a' && c <= 'f') {
                if ((value >> 28) != 0) {
                  throw new ArgumentException("Overflow");
                }
                value <<= 4;
                value |= (c - 'a') + 10;
              } else if (c >= 'A' && c <= 'F') {
                if ((value >> 28) != 0) {
                  throw new ArgumentException("Overflow");
                }
                value <<= 4;
                value |= (c - 'A') + 10;
              } else {
                this.input.Unget();
                return value;
              }
            }
          } else {
            while (true) {
              c = this.input.ReadChar();
              if (c >= '0' && c <= '9') {
                if (value > Int32.MaxValue / 10) {
                  throw new ArgumentException("Overflow");
                }
                value *= 10;
                int add = c - '0';
                if (value > Int32.MaxValue - add) {
                  throw new ArgumentException("Overflow");
                }
                value += add;
              } else {
                this.input.Unget();
                return value;
              }
            }
          }
        }

        private void ReadToTokenChar() {
          while (true) {
            int c = this.input.ReadChar();
            if (c == 0x0a) {
              this.type = TokenType.LineBreak;
              break;
            } else if (c == 0x0d) {
              c = this.input.ReadChar();
              if (c == 0x0a) {
                this.type = TokenType.LineBreak;
              } else {
                this.input.Unget();
              }
              break;
            } else if (c == -1) {
              this.type = TokenType.End;
              break;
            } else if (c == 0x20 || c == 0x09) {
              continue; // whitespace
            } else if (c == (int)';') {
              // comment
              while (true) {
                c = this.input.ReadChar();
                if (c == -1 || c == 0x0d || c == 0x0a) {
                  this.input.Unget();
                  break;
                }
              }
              continue;
            } else {
              this.input.Unget();
              this.type = TokenType.Token;
              break;
            }
          }
        }

        private static bool IsWordEndChar(int c) {
          return c == -1 || c == 0x0d || c == 0x0a || c == 0x09 || c ==
            0x20 || c == (int)';';
        }
      }

      private int[] bytesToUCS;
      private int[] bytesToGlyphs;
      private UCSMapping dbcsToUCS;
      private UCSMapping ucsToBytes;
      private int codepageNumber;
      private int defaultNative;
      private int defaultUCS;

      private sealed class UCSMapping {
        private int[] array;

        public UCSMapping() {
          this.array = new int[256];
          for (var i = 0; i < this.array.Length; ++i) {
            this.array[i] = -2;
          }
        }

        public int GetMapping(int ucs) {
          return (ucs < 0 || ucs > this.array.Length) ? (-2) :
            this.array[ucs];
        }

        public void AddMapping(int ucs, int value) {
          if (ucs >= this.array.Length) {
            int[] newarray = null;
            if (ucs >= 0x30000) {
              newarray = new int[Math.Max(ucs + 0x1000, 0x110000)];
            } else if (ucs >= 0x10000) {
              newarray = new int[0x30000];
            } else if (ucs >= 0x3000) {
              newarray = new int[0x10000];
            } else if (ucs >= 0x100) {
              newarray = new int[0x3000];
            }
            Array.Copy(
              this.array,
              0,
              newarray,
              0,
              this.array.Length);
            int i;
            for (i = this.array.Length; i < newarray.Length; ++i) {
              newarray[i] = -2;
            }
            this.array = newarray;
          }
          this.array[ucs] = value;
        }
      }

      public int Number {
        get {
          return this.codepageNumber;
        }
      }

      public CodePageCoder(CodePageCoder other, bool useGlyphs) {
        this.bytesToUCS = other.bytesToUCS;
        this.bytesToGlyphs = other.bytesToGlyphs;
        this.dbcsToUCS = other.dbcsToUCS;
        this.lastByte = -1;
        this.unget = false;
        this.codepageNumber = other.codepageNumber;
        this.defaultNative = other.defaultNative;
        this.defaultUCS = other.defaultUCS;
        this.ucsToBytes = other.ucsToBytes;
        this.useGlyphs = useGlyphs && this.bytesToGlyphs != null;
      }

      public CodePageCoder(ICharacterInput input) {
        var token = new TokenReader(input);
        var state = 0;
        var byteCount = 0;
        this.defaultNative = 0;
        this.defaultUCS = 0;
        var lineCount = 0;
        var ranges = 0;
        var rangeLow = 0;
        var rangeHigh = 0;
        var done = false;
        var haveMbTable = false;
        var haveWcTable = false;
        var haveGlyphTable = false;
        this.dbcsToUCS = new UCSMapping();
        this.ucsToBytes = new UCSMapping();
        this.bytesToUCS = new int[256];
        this.bytesToGlyphs = new int[256];
        for (var i = 0; i < 256; ++i) {
          this.bytesToUCS[i] = -2;
          this.bytesToGlyphs[i] = -2;
        }
        while (!done) {
          switch (state) {
            case 0: {
              token.ExpectAnyOneWord("CODEPAGE");
              this.codepageNumber = token.ExpectNumberOnSameLine();
              token.SkipToLine();
              token.ExpectAnyOneWord("CPINFO");
              byteCount = token.ExpectNumberOnSameLine();
              if (byteCount != 1 && byteCount != 2) {
                throw new ArgumentException("Expected byte count 1 or 2");
              }
              this.defaultNative = token.ExpectByteOnSameLine();
              this.defaultUCS = token.ExpectCodePointOnSameLine();
              token.SkipToLine();
              state = 1;
            }
            break;
            case 1: {
              int wordIndex = token.ExpectAnyOneWord(
                  "MBTABLE",
                  "DBCSRANGE",
                  "WCTABLE",
                  "GLYPHTABLE",
                  "ENDCODEPAGE");
              if (wordIndex == 0) {
                lineCount = token.ExpectNumberOnSameLine();
                token.SkipToLine();
                state = 2;
                haveMbTable = true;
              } else if (wordIndex == 1) {
                ranges = token.ExpectNumberOnSameLine();
                if (ranges == 0) {
                  throw new ArgumentException("ranges is 0");
                }
                token.SkipToLine();
                state = 4;
              } else if (wordIndex == 2) {
                lineCount = token.ExpectNumberOnSameLine();
                token.SkipToLine();
                state = 3;
                haveWcTable = true;
              } else if (wordIndex == 3) {
                // Alternate characters for some bytes, for
                // display purposes.
                lineCount = token.ExpectNumberOnSameLine();
                token.SkipToLine();
                state = 5;
                haveGlyphTable = true;
              } else if (wordIndex == 4 && haveMbTable &&
                haveWcTable) {
                done = true;
              } else {
                throw new ArgumentException("Unexpected word");
              }
            }
            break;
            case 2: {
              for (int i = 0; i < lineCount; ++i) {
                int nativeValue = token.ExpectByte();
                int ucs = token.ExpectCodePointOnSameLine();
                this.bytesToUCS[nativeValue] = ucs;
                token.SkipToLine();
              }
              state = 1;
            }
            break;
            case 3: {
              for (int i = 0; i < lineCount; ++i) {
                int ucs = token.ExpectCodePoint();
                int nativeValue = (byteCount == 1) ?
                  token.ExpectByteOnSameLine() : token.ExpectUInt16OnSameLine();
                this.ucsToBytes.AddMapping(ucs, nativeValue);
                token.SkipToLine();
              }
              state = 1;
            }
            break;
            case 4: {
              rangeLow = token.ExpectByte();
              rangeHigh = token.ExpectByteOnSameLine();
              if (rangeLow > rangeHigh) {
                throw new ArgumentException("invalid range");
              }
              token.SkipToLine();
              for (int i = rangeLow; i <= rangeHigh; ++i) {
                this.bytesToUCS[i] = -3;
                token.ExpectAnyOneWord("DBCSTABLE");
                lineCount = token.ExpectNumberOnSameLine();
                token.SkipToLine();
                int range = i << 8;
                for (int j = 0; j < lineCount; ++j) {
                  int nativeValue = token.ExpectByte() | range;
                  int ucs = token.ExpectCodePointOnSameLine();
                  this.dbcsToUCS.AddMapping(nativeValue, ucs);
                  token.SkipToLine();
                }
              }
              --ranges;
              if (ranges <= 0) {
                state = 1;
              }
            }
            break;
            case 5: {
              for (int i = 0; i < lineCount; ++i) {
                int nativeValue = token.ExpectByte();
                int ucs = token.ExpectCodePointOnSameLine();
                this.bytesToGlyphs[nativeValue] = ucs;
                token.SkipToLine();
              }
              state = 1;
            }
            break;
          }
        }
        if (haveGlyphTable) {
          for (var i = 0; i < 256; ++i) {
            if (this.bytesToGlyphs[i] == -2) {
              this.bytesToGlyphs[i] = this.bytesToUCS[i];
            }
          }
        }
      }
    }
  }
}
