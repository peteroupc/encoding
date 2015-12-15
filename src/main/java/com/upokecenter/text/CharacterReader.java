package com.upokecenter.text;
/*
Written in 2014 by Peter O.
Any copyright is dedicated to the Public Domain.
http://creativecommons.org/publicdomain/zero/1.0/
If you like this, you should donate to Peter O.
at: http://upokecenter.dreamhosters.com/articles/donate-now-2/
 */

import java.io.*;

    /**
     * A general-purpose character input for reading text from byte streams and
     * text strings. When reading byte streams, this class supports the
     * UTF-8 character encoding by default, but can be configured to support
     * UTF-16 and UTF-32 as well.
     */
  public final class CharacterReader implements ICharacterInput {
    private final int mode;
    private final boolean errorThrow;
    private int offset;
    private final boolean dontSkipUtf8Bom;

    private ICharacterInput reader;

    private final String str;
    private final IByteReader stream;

    /**
     * Initializes a new instance of the CharacterReader class.
     * @param str A string object.
     */
    public CharacterReader (String str) {
 this(str, false, false);
    }

    /**
     * Initializes a new instance of the CharacterReader class.
     * @param str A string object.
     * @param skipByteOrderMark A Boolean object.
     */
    public CharacterReader (String str, boolean skipByteOrderMark) {
 this(str, skipByteOrderMark, false);
    }

    /**
     * Initializes a new instance of the CharacterReader class.
     * @param str A string object.
     * @param skipByteOrderMark A Boolean object.
     * @param errorThrow Another Boolean object.
     * @throws NullPointerException The parameter {@code str} is null.
     */
  public CharacterReader (
String str,
boolean skipByteOrderMark,
boolean errorThrow) {
      if (str == null) {
        throw new NullPointerException("str");
      }
      this.offset = (skipByteOrderMark && str.length() > 0 && str.charAt(0) ==
        0xfeff) ? 1 : 0;
      this.str = str;
      this.errorThrow = errorThrow;
      this.mode = -1;
      this.dontSkipUtf8Bom = false;
      this.stream = null;
    }

    /**
     * Initializes a new instance of the CharacterReader class.
     * @param stream A readable data stream.
     */
    public CharacterReader (InputStream stream) {
 this(stream, 0, false);
    }

    /**
     * Initializes a new instance of the CharacterReader class.
     * @param stream A readable data stream.
     * @param mode A 32-bit signed integer.
     * @param errorThrow A Boolean object.
     */
    public CharacterReader (InputStream stream, int mode, boolean errorThrow) {
 this(stream, mode, errorThrow, false);
    }

    /**
     * Initializes a new instance of the CharacterReader class.
     * @param stream A readable data stream.
     * @param mode A 32-bit signed integer.
     */
    public CharacterReader (InputStream stream, int mode) {
 this(stream, mode, false, false);
    }

    /**
     * Initializes a new instance of the CharacterReader class.
     * @param stream Not documented yet.
     * @param mode Not documented yet.
     * @param errorThrow If true, will throw an exception if invalid byte sequences
     * (in the detected encoding) are found in the byte stream.
     * @param dontSkipUtf8Bom If the stream is detected as UTF-8 and this parameter
     * is {@code true}, won't skip the BOM character if it occurs at the
     * start of the stream.
     * @throws NullPointerException The parameter {@code stream} is null.
     */
    public CharacterReader (
InputStream stream,
int mode,
boolean errorThrow,
boolean dontSkipUtf8Bom) {
      if (stream == null) {
        throw new NullPointerException("stream");
      }
      this.stream = new WrappedStream(stream);
      this.mode = mode;
      this.errorThrow = errorThrow;
      this.dontSkipUtf8Bom = dontSkipUtf8Bom;
      this.str = "";
    }

    private interface IByteReader {
      int read();
    }

    /**
     * Reads a series of characters from a Unicode stream or a string.
     * @param chars Not documented yet.
     * @param index A zero-based index showing where the desired portion of {@code
     * chars} begins.
     * @param length The number of elements in the desired portion of {@code chars}
     * (but not more than {@code chars} 's length).
     * @return A 32-bit signed integer.
     * @throws NullPointerException The parameter {@code chars} is null.
     * @throws IllegalArgumentException Either "index" or "length" is less than 0 or
     * greater than "chars"'s length, or "chars"'s length minus "index" is
     * less than "length".
     */
    public int Read(int[] chars, int index, int length) {
      if (chars == null) {
        throw new NullPointerException("chars");
      }
      if (index < 0) {
        throw new IllegalArgumentException("index (" + index +
          ") is less than " + 0);
      }
      if (index > chars.length) {
        throw new IllegalArgumentException("index (" + index +
          ") is more than " + chars.length);
      }
      if (length < 0) {
        throw new IllegalArgumentException("length (" + length +
          ") is less than " + 0);
      }
      if (length > chars.length) {
        throw new IllegalArgumentException("length (" + length +
          ") is more than " + chars.length);
      }
      if (chars.length - index < length) {
        throw new IllegalArgumentException("chars's length minus " + index + " (" +
          (chars.length - index) + ") is less than " + length);
      }
      int count = 0;
      for (int i = 0; i < length; ++i) {
        int c = this.ReadChar();
        if (c < 0) {
          return count;
        }
        chars[index + i] = c;
        ++count;
      }
      return count;
    }

    /**
     * Reads the next character from a Unicode stream or a string.
     * @return The next character, or -1 if the end of the string or stream was
     * reached.
     */
    public int ReadChar() {
      if (this.reader != null) {
        return this.reader.ReadChar();
      }
      if (this.stream != null) {
        return this.DetectUnicodeEncoding();
      } else {
        int c = (this.offset < this.str.length()) ? this.str.charAt(this.offset) : -1;
        if ((c & 0xfc00) == 0xd800 && this.offset + 1 < this.str.length() &&
                this.str.charAt(this.offset + 1) >= 0xdc00 && this.str.charAt(this.offset + 1)
                <= 0xdfff) {
          // Get the Unicode code point for the surrogate pair
          c = 0x10000 + ((c - 0xd800) << 10) + (this.str.charAt(this.offset + 1) -
          0xdc00);
          ++this.offset;
        } else if ((c & 0xf800) == 0xd800) {
          // unpaired surrogate
          if (this.errorThrow) {
 throw new IllegalStateException("Unpaired surrogate code point");
} else {
 c = 0xfffd;
}
        }
        ++this.offset;
        return c;
      }
    }

    private int DetectUtf8Or16Or32(int c1) {
      int c2, c3, c4;
      if (c1 == 0xff || c1 == 0xfe) {
        // Start of a possible byte-order mark
        // FF FE 0 0 --> UTF-32LE
        // FF FE ... --> UTF-16LE
        // FE FF --> UTF-16BE
        c2 = this.stream.read();
        boolean bigEndian = c1 == 0xfe;
        int otherbyte = bigEndian ? 0xff : 0xfe;
        if (c2 == otherbyte) {
          c3 = this.stream.read();
          c4 = this.stream.read();
          if (!bigEndian && c3 == 0 && c4 == 0) {
            this.reader = new Utf32Reader(this.stream, false, this.errorThrow);
            return this.reader.ReadChar();
          } else {
      Utf16Reader newReader = new Utf16Reader(
this.stream,
bigEndian,
this.errorThrow);
            newReader.Unget(c3, c4);
            this.reader = newReader;
            return newReader.ReadChar();
          }
        }
        // Assume UTF-8 here, so the 0xff or 0xfe is invalid
        if (this.errorThrow) {
          throw new IllegalStateException("Invalid Unicode stream");
        } else {
          Utf8Reader utf8reader = new Utf8Reader(this.stream, this.errorThrow);
          utf8reader.Unget(c2);
          this.reader = utf8reader;
          return 0xfffd;
        }
      } else if (c1 == 0 && this.mode == 4) {
        // Here, the relevant cases are:
        // 0 0 0 NZA --> UTF-32BE (if mode is 4)
        // 0 0 FE FF --> UTF-32BE
        // Anything else is treated as UTF-8
        c2 = this.stream.read();
        c3 = this.stream.read();
        c4 = this.stream.read();
        if (c2 == 0 &&
           ((c3 == 0xfe && c4 == 0xff) ||
            (c3 == 0 && c4 >= 0x01 && c4 <= 0x7f))) {
          this.reader = new Utf32Reader(this.stream, true, this.errorThrow);
          return c3 == 0 ? c4 : this.reader.ReadChar();
        } else {
          Utf8Reader utf8reader = new Utf8Reader(this.stream, this.errorThrow);
          utf8reader.UngetThree(c2, c3, c4);
          this.reader = utf8reader;
          return c1;
        }
      } else if (this.mode == 2) {
        if (c1 >= 0x01 && c1 <= 0x7f) {
          // Nonzero ASCII character
          c2 = this.stream.read();
          if (c2 == 0) {
            // NZA 0, so UTF-16LE or UTF-32LE
            c3 = this.stream.read();
            c4 = this.stream.read();
            if (c3 == 0 && c4 == 0) {
            this.reader = new Utf32Reader(
this.stream,
false,
this.errorThrow);
              return c1;
            } else {
          Utf16Reader newReader = new Utf16Reader(
this.stream,
false,
this.errorThrow);
              newReader.Unget(c3, c4);
              this.reader = newReader;
              return c1;
            }
          } else {
            // NZA NZ, so UTF-8
            Utf8Reader utf8reader = new Utf8Reader(this.stream, this.errorThrow);
            utf8reader.Unget(c2);
            this.reader = utf8reader;
            return c1;
          }
        } else if (c1 == 0) {
          // Zero
          c2 = this.stream.read();
          if (c2 >= 0x01 && c2 <= 0x7f) {
            // 0 NZA, so UTF-16BE
            Utf16Reader newReader = new Utf16Reader(this.stream, true, this.errorThrow);
            this.reader = newReader;
            return c2;
          } else if (c2 == 0) {
            // 0 0, so maybe UTF-32BE
            c3 = this.stream.read();
            c4 = this.stream.read();
            if (c3 == 0 && c4 >= 0x01 && c4 <= 0x7f) {
              // 0 0 0 NZA
              this.reader = new Utf32Reader(this.stream, true, this.errorThrow);
              return c4;
            } else if (c3 == 0xfe && c4 == 0xff) {
              // 0 0 FE FF
              this.reader = new Utf32Reader(this.stream, true, this.errorThrow);
              return this.reader.ReadChar();
            } else {
              // 0 0 ...
              Utf8Reader newReader = new Utf8Reader(this.stream, this.errorThrow);
              newReader.UngetThree(c2, c3, c4);
              this.reader = newReader;
              return c1;
            }
          } else {
            // 0 NonAscii, so UTF-8
            Utf8Reader utf8reader = new Utf8Reader(this.stream, this.errorThrow);
            utf8reader.Unget(c2);
            this.reader = utf8reader;
            return c1;
          }
        }
      }
      // Use default of UTF-8
      return -2;
    }

    private int DetectUtf8OrUtf16(int c1) {
      int mode = this.mode;
      int c2;
      if (c1 == 0xff || c1 == 0xfe) {
        c2 = this.stream.read();
        boolean bigEndian = c1 == 0xfe;
        int otherbyte = bigEndian ? 0xff : 0xfe;
        if (c2 == otherbyte) {
      Utf16Reader newReader = new Utf16Reader(
this.stream,
bigEndian,
this.errorThrow);
          this.reader = newReader;
          return newReader.ReadChar();
        }
        // Assume UTF-8 here, so the 0xff or 0xfe is invalid
        if (this.errorThrow) {
          throw new IllegalStateException("Invalid Unicode stream");
        } else {
          Utf8Reader utf8reader = new Utf8Reader(this.stream, this.errorThrow);
          utf8reader.Unget(c2);
          this.reader = utf8reader;
          return 0xfffd;
        }
      } else if (mode == 1) {
        if (c1 >= 0x01 && c1 <= 0x7f) {
          // Nonzero ASCII character
          c2 = this.stream.read();
          if (c2 == 0) {
            // NZA 0, so UTF-16LE
          Utf16Reader newReader = new Utf16Reader(
this.stream,
false,
this.errorThrow);
            this.reader = newReader;
          } else {
            // NZA NZ
            Utf8Reader utf8reader = new Utf8Reader(this.stream, this.errorThrow);
            utf8reader.Unget(c2);
            this.reader = utf8reader;
          }
          return c1;
        } else if (c1 == 0) {
          // Zero
          c2 = this.stream.read();
          if (c2 >= 0x01 && c2 <= 0x7f) {
            // 0 NZA, so UTF-16BE
            Utf16Reader newReader = new Utf16Reader(this.stream, true, this.errorThrow);
            this.reader = newReader;
            return c2;
          } else {
            Utf8Reader utf8reader = new Utf8Reader(this.stream, this.errorThrow);
            utf8reader.Unget(c2);
            this.reader = utf8reader;
            return c1;
          }
        }
      }
      // Use default of UTF-8
      return -2;
    }

    // Detects a Unicode encoding
    private int DetectUnicodeEncoding() {
      int mode = this.mode;
      int c1 = this.stream.read();
      int c2;
      if (c1 < 0) {
        return -1;
      }
      Utf8Reader utf8reader;
      if (mode == 0) {
        // UTF-8 only
        utf8reader = new Utf8Reader(this.stream, this.errorThrow);
        this.reader = utf8reader;
        c1 = utf8reader.ReadChar();
        if (c1 == 0xfeff) {
          // Skip BOM
          c1 = utf8reader.ReadChar();
        }
        return c1;
      } else if (mode == 1 || mode == 3) {
        c2 = this.DetectUtf8OrUtf16(c1);
        if (c2 >= -1) {
 return c2;
}
      } else if (mode == 2 || mode == 4) {
        // UTF-8, UTF-16, or UTF-32
        c2 = this.DetectUtf8Or16Or32(c1);
        if (c2 >= -1) {
 return c2;
}
      }
      // Default case: assume UTF-8
      utf8reader = new Utf8Reader(this.stream, this.errorThrow);
      this.reader = utf8reader;
      utf8reader.Unget(c1);
      c1 = utf8reader.ReadChar();
      if (!this.dontSkipUtf8Bom && c1 == 0xfeff) {
        // Skip BOM
        c1 = utf8reader.ReadChar();
      }
      return c1;
    }

    private static final class SavedState {
      private int[] saved;
      private int savedLength;

      private void Ensure(int size) {
        this.saved = (this.saved == null) ? ((new int[this.savedLength + size])) : this.saved;
        if (this.savedLength + size < this.saved.length) {
          int[] newsaved = new int[this.savedLength + size + 4];
          System.arraycopy(this.saved, 0, newsaved, 0, this.savedLength);
          this.saved = newsaved;
        }
      }

      public void AddOne(int a) {
        this.Ensure(1);
        this.saved[this.savedLength++] = a;
      }

      public void AddTwo(int a, int b) {
        this.Ensure(2);
        this.saved[this.savedLength + 1] = a;
        this.saved[this.savedLength] = b;
        this.savedLength += 2;
      }

      public void AddThree(int a, int b, int c) {
        this.Ensure(3);
        this.saved[this.savedLength + 2] = a;
        this.saved[this.savedLength + 1] = b;
        this.saved[this.savedLength] = c;
        this.savedLength += 3;
      }

      public int Read(IByteReader input) {
        if (this.savedLength > 0) {
          int ret = this.saved[--this.savedLength];
          return ret;
        }
        return input.read();
      }
    }

    private static final class Utf16Reader implements ICharacterInput {
      private final boolean bigEndian;
      private final IByteReader stream;
      private final SavedState state;
      private final boolean errorThrow;

      public Utf16Reader (IByteReader stream, boolean bigEndian, boolean errorThrow) {
        this.stream = stream;
        this.bigEndian = bigEndian;
        this.state = new SavedState();
        this.errorThrow = errorThrow;
      }

      public void Unget(int c1, int c2) {
        this.state.AddTwo(c1, c2);
      }

      public int ReadChar() {
        int c1 = this.state.Read(this.stream);
        if (c1 < 0) {
          return -1;
        }
        int c2 = this.state.Read(this.stream);
        if (c2 < 0) {
          this.state.AddOne(-1);
          if (this.errorThrow) {
 throw new IllegalStateException("Invalid UTF-16");
} else {
 return 0xfffd;
}
        }
        c1 = this.bigEndian ? ((c1 << 8) | c2) : ((c2 << 8) | c1);
        int surr = c1 & 0xfc00;
        if (surr == 0xd800) {
          surr = c1;
          c1 = this.state.Read(this.stream);
          c2 = this.state.Read(this.stream);
          if (c1 < 0 || c2 < 0) {
            this.state.AddOne(-1);
            if (this.errorThrow) {
 throw new IllegalStateException("Invalid UTF-16");
} else {
 return 0xfffd;
}
          }
          int unit2 = this.bigEndian ? ((c1 << 8) | c2) : ((c2 << 8) | c1);
          if ((unit2 & 0xfc00) == 0xdc00) {
            return 0x10000 + ((surr - 0xd800) << 10) + (unit2 - 0xdc00);
          }
          this.Unget(c1, c2);
          if (this.errorThrow) {
 throw new IllegalStateException("Invalid UTF-16");
} else {
 return 0xfffd;
}
        }
        if (surr == 0xdc00) {
          if (this.errorThrow) {
 throw new IllegalStateException("Invalid UTF-16");
} else {
 return 0xfffd;
}
        }
        return c1;
      }

      public int Read(int[] chars, int index, int length) {
        int count = 0;
        for (int i = 0; i < length; ++i) {
          int c = this.ReadChar();
          if (c < 0) {
            return count;
          }
          chars[index + i] = c;
          ++count;
        }
        return count;
      }
    }

    private static final class Utf32Reader implements ICharacterInput {
      private final boolean bigEndian;
      private final IByteReader stream;
      private final boolean errorThrow;
      private final SavedState state;

      public Utf32Reader (IByteReader stream, boolean bigEndian, boolean errorThrow) {
        this.stream = stream;
        this.bigEndian = bigEndian;
        this.state = new SavedState();
        this.errorThrow = errorThrow;
      }

      public int ReadChar() {
        int c1 = this.state.Read(this.stream);
        if (c1 < 0) {
          return -1;
        }
        int c2 = this.state.Read(this.stream);
        int c3 = this.state.Read(this.stream);
        int c4 = this.state.Read(this.stream);
        if (c2 < 0 || c3 < 0 || c4 < 0) {
          this.state.AddOne(-1);
          if (this.errorThrow) {
 throw new IllegalStateException("Invalid UTF-32");
} else {
 return 0xfffd;
}
        }
        c1 = this.bigEndian ? ((c1 << 24) | (c2 << 16) | (c3 << 8) | c4) :
          ((c4 << 24) | (c3 << 16) | (c2 << 8) | c1);
        if (c1 < 0 || c1 >= 0x110000 || (c1 & 0xfff800) == 0xd800) {
          if (this.errorThrow) {
 throw new IllegalStateException("Invalid UTF-32");
} else {
 return 0xfffd;
}
        }
        return c1;
      }

      public int Read(int[] chars, int index, int length) {
        int count = 0;
        for (int i = 0; i < length; ++i) {
          int c = this.ReadChar();
          if (c < 0) {
            return count;
          }
          chars[index + i] = c;
          ++count;
        }
        return count;
      }
    }

    private static final class Utf8Reader implements ICharacterInput {
      private final IByteReader stream;
      private int lastChar;
      private final SavedState state;
      private final boolean errorThrow;

      public Utf8Reader (IByteReader stream, boolean errorThrow) {
        this.stream = stream;
        this.lastChar = -1;
        this.state = new SavedState();
        this.errorThrow = errorThrow;
      }

      public void Unget(int ch) {
        this.state.AddOne(ch);
      }

      public void UngetThree(int a, int b, int c) {
        this.state.AddThree(a, b, c);
      }

      public int ReadChar() {
        int cp = 0;
        int bytesSeen = 0;
        int bytesNeeded = 0;
        int lower = 0;
        int upper = 0;
        while (true) {
          int b;
          if (this.lastChar != -1) {
            b = this.lastChar;
            this.lastChar = -1;
          } else {
            b = this.state.Read(this.stream);
          }
          if (b < 0) {
            if (bytesNeeded != 0) {
              bytesNeeded = 0;
              if (this.errorThrow) {
 throw new IllegalStateException("Invalid UTF-8");
} else {
 return 0xfffd;
}
            }
            return -1;
          }
          if (bytesNeeded == 0) {
            if ((b & 0x7f) == b) {
              return b;
            }
            if (b >= 0xc2 && b <= 0xdf) {
              bytesNeeded = 1;
              lower = 0x80;
              upper = 0xbf;
              cp = (b - 0xc0) << 6;
            } else if (b >= 0xe0 && b <= 0xef) {
              lower = (b == 0xe0) ? 0xa0 : 0x80;
              upper = (b == 0xed) ? 0x9f : 0xbf;
              bytesNeeded = 2;
              cp = (b - 0xe0) << 12;
            } else if (b >= 0xf0 && b <= 0xf4) {
              lower = (b == 0xf0) ? 0x90 : 0x80;
              upper = (b == 0xf4) ? 0x8f : 0xbf;
              bytesNeeded = 3;
              cp = (b - 0xf0) << 18;
            } else {
              if (this.errorThrow) {
 throw new IllegalStateException("Invalid UTF-8");
} else {
 return 0xfffd;
}
            }
            continue;
          }
          if (b < lower || b > upper) {
            cp = bytesNeeded = bytesSeen = 0;
            this.state.AddOne(b);
            if (this.errorThrow) {
 throw new IllegalStateException("Invalid UTF-8");
} else {
 return 0xfffd;
}
          }
          lower = 0x80;
          upper = 0xbf;
          ++bytesSeen;
          cp += (b - 0x80) << (6 * (bytesNeeded - bytesSeen));
          if (bytesSeen != bytesNeeded) {
            continue;
          }
          int ret = cp;
          cp = 0;
          bytesSeen = 0;
          bytesNeeded = 0;
          return ret;
        }
      }

      public int Read(int[] chars, int index, int length) {
        int count = 0;
        for (int i = 0; i < length; ++i) {
          int c = this.ReadChar();
          if (c < 0) {
            return count;
          }
          chars[index + i] = c;
          ++count;
        }
        return count;
      }
    }

    private static final class WrappedStream implements IByteReader {
      private final InputStream stream;

      public WrappedStream (InputStream stream) {
        this.stream = stream;
      }

      public int read() {
        try {
          return this.stream.read();
        } catch (IOException ex) {
          throw new IllegalStateException(ex.getMessage(), ex);
        }
      }
    }
  }