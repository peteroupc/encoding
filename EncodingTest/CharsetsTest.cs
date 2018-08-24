/*
Written by Peter O. in 2014.
Any copyright is dedicated to the Public Domain.
http://creativecommons.org/publicdomain/zero/1.0/
If you like this, you should donate to Peter O.
at: http://peteroupc.github.io/
 */
using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;
using PeterO;
using PeterO.Text;
using Test;

namespace EncodingTest {
    [TestFixture]
    public class CharsetsTest {
        [Test]
        public void TestShiftJIS() {
            // Adapted from the public domain Gonk test cases
            byte[] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding("shift_jis");
          bytes = new byte[] { 0x82, 0x58, 0x33, 0x41, 0x61, 0x33, 0x82, 0x60,
        0x82, 0x81, 0x33, 0xb1, 0xaf, 0x33, 0x83, 0x41,
        0x83, 0x96, 0x33, 0x82, 0xa0, 0x33, 0x93, 0xfa,
        0x33, 0x3a, 0x3c, 0x33, 0x81, 0x80, 0x81, 0x8e,
        0x33, 0x31, 0x82, 0x51, 0x41, 0x61, 0x82, 0x51,
        0x82, 0x60, 0x82, 0x81, 0x82, 0x51, 0xb1, 0xaf,
        0x82, 0x51, 0x83, 0x41, 0x83, 0x96, 0x82, 0x51,
        0x82, 0xa0, 0x82, 0x51, 0x93, 0xfa, 0x82, 0x51,
        0x3a, 0x3c, 0x82, 0x51, 0x81, 0x80, 0x81, 0x8e,
        0x82, 0x51 };
            const string ValueExpected =

  "\uFF19\u0033\u0041\u0061\u0033\uFF21\uFF41\u0033\uFF71\uFF6F\u0033\u30A2\u30F6\u0033\u3042\u0033\u65E5\u0033\u003A\u003C\u0033\u00F7\u2103\u0033\u0031\uFF12\u0041\u0061\uFF12\uFF21\uFF41\uFF12\uFF71\uFF6F\uFF12\u30A2\u30F6\uFF12\u3042\uFF12\u65E5\uFF12\u003A\u003C\uFF12\u00F7\u2103\uFF12";

    {
object objectTemp = ValueExpected;
object objectTemp2 = Encodings.DecodeToString(
  charset,
  bytes);
Assert.AreEqual(objectTemp, objectTemp2);
}
        }

        private static void TestEncodingRoundTrip(
      string str,
      ICharacterEncoding encoding) {
            byte[] bytes;
            string str2;
            bytes = Encodings.EncodeToBytes(str, encoding);
            str2 = Encodings.DecodeToString(encoding, bytes);
            Assert.AreEqual(str, str2);
        }

        [Test]
public void TestGB18030() {
            ICharacterEncoding encoding = Encodings.GetEncoding("gb18030");
            TestEncodingRoundTrip("\uffff", encoding);
            TestEncodingRoundTrip("\ud800\udc00", encoding);
            TestEncodingRoundTrip("\udbff\udfff", encoding);
        }

        [Test]
public void TestIso2022JP() {
            byte[] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding("iso-2022-jp");
            bytes = new byte[] { 0x20, 0x41, 0x61, 0x5c };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                  " Aa\\",
                  stringTemp);
            }
            // Illegal byte in escape middle state
            bytes = new byte[] { 0x1b, 0x28, 0x47, 0x21, 0x41, 0x31, 0x5c };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "\ufffd\u0028\u0047!A1\\",
                stringTemp);
            }
            // Katakana
            bytes = new byte[] { 0x1b, 0x28, 0x49, 0x21, 0x41, 0x31, 0x5c };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "\uff61\uff81\uff71\uff9c",
                stringTemp);
            }
            bytes = new byte[] { 0x1b, 0x28, 0x49, 0x20, 0x41, 0x61, 0x5c };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "\ufffd\uff81\ufffd\uff9c",
                stringTemp);
            }
            // ASCII state via escape
            bytes = new byte[] { 0x1b, 0x28, 0x42, 0x20, 0x41, 0x61, 0x5c };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                " Aa\\",
                stringTemp);
            }
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x20, 0x41, 0x61, 0x5c };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                " Aa\u00a5",
                stringTemp);
            }
            // JIS0208 state
  bytes = new byte[] { 0x1b, 0x24, 0x40, 0x21, 0x21, 0x21, 0x22, 0x21, 0x23 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "\u3000\u3001\u3002",
                stringTemp);
            }
  bytes = new byte[] { 0x1b, 0x24, 0x42, 0x21, 0x21, 0x21, 0x22, 0x21, 0x23 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "\u3000\u3001\u3002",
                stringTemp);
            }
          bytes = new byte[] { 0x1b, 0x24, 0x42, 0x21, 0x21, 0x21, 0x22, 0x0a,
        0x21, 0x23 };
            // Illegal state
  bytes = new byte[] { 0x1b, 0x24, 0x4f, 0x21, 0x21, 0x21, 0x23, 0x21, 0x23 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "\ufffd\u0024\u004f!!!\u0023!#",
                stringTemp);
            }
            // Illegal state
          bytes = new byte[] { 0x1b, 0x24, 0x28, 0x4f, 0x21, 0x21, 0x21, 0x23,
        0x21, 0x23 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "\ufffd\u0024\u0028\u004f!!!\u0023!#",
                stringTemp);
            }
            // Illegal state at end
            bytes = new byte[] { 0x41, 0x1b };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "A\ufffd",
                stringTemp);
            }
            bytes = new byte[] { 0x41, 0x1b, 0x27 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "A\ufffd'",
                stringTemp);
            }
            bytes = new byte[] { 0x41, 0x1b, 0x24 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "A\ufffd$",
                stringTemp);
            }
            bytes = new byte[] { 0x41, 0x1b, 0x24, 0x28 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "A\ufffd$\u0028",
                stringTemp);
            }
        }

        [Test]
public void TestEucJP() {
            byte[] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding("euc-jp");
            bytes = new byte[] { 0x8e };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "\ufffd",
                stringTemp);
            }
            bytes = new byte[] { 0x8e, 0x21 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "\ufffd!",
                stringTemp);
            }
            bytes = new byte[] { 0x8e, 0x8e, 0xa1 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "\ufffd\ufffd",
                stringTemp);
            }
            bytes = new byte[] { 0x8f };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                  "\ufffd",
                  stringTemp);
            }
            bytes = new byte[] { 0x8f, 0x21 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                  "\ufffd!",
                  stringTemp);
            }
            bytes = new byte[] { 0x8f, 0xa1 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                  "\ufffd",
                  stringTemp);
            }
            bytes = new byte[] { 0x8f, 0xa1, 0x21 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                  "\ufffd!",
                  stringTemp);
            }
            bytes = new byte[] { 0x90 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                  "\ufffd",
                  stringTemp);
            }
            bytes = new byte[] { 0x90, 0x21 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                  "\ufffd!",
                  stringTemp);
            }
            bytes = new byte[] { 0xa1 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                  "\ufffd",
                  stringTemp);
            }
            bytes = new byte[] { 0xa1, 0xa1 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                  "\u3000",
                  stringTemp);
            }
            bytes = new byte[] { 0x90, 0xa1, 0xa1 };
            {
                string stringTemp = Encodings.DecodeToString(
                  charset,
                  bytes);
                Assert.AreEqual(
                  "\ufffd\u3000",
                  stringTemp);
            }
            bytes = new byte[] { 0x90, 0xa1, 0xa1, 0xa1 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                "\ufffd\u3000\ufffd",
                stringTemp);
            }
            bytes = new byte[] { 0xa1, 0x21 };
            {
                string stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.AreEqual(
                  "\ufffd!",
                  stringTemp);
            }
            string result;
          bytes = new byte[] { 0x15, 0xf2, 0xbf, 0xdd, 0xd7, 0x13, 0xeb, 0xcf,
        0x8e, 0xd6, 0x8f, 0xec, 0xe9, 0x8f, 0xd6, 0xe6, 0x8f, 0xd3, 0xa3,
        0x8e, 0xd4, 0x66, 0x8f, 0xb9, 0xfc, 0x8e, 0xb0, 0x8f, 0xea, 0xd8,
        0x29, 0x8e, 0xca, 0x8e, 0xd4, 0xc9, 0xb5, 0x1e, 0x09, 0x8e, 0xab,
        0xc2, 0xc5, 0x8e, 0xa7, 0x8e, 0xb6, 0x3d, 0xe1, 0xd9, 0xb7, 0xd5,
        0x7b, 0x05, 0xe6, 0xce, 0x1d, 0x8f, 0xbd, 0xbe, 0xd8, 0xae, 0x8e,
        0xc3, 0x8f, 0xc1, 0xda, 0xd5, 0xbb, 0xb2, 0xa2, 0xcc, 0xd4, 0x42,
        0x8e, 0xa2, 0xed, 0xd4, 0xc6, 0xe0, 0x8f, 0xe0, 0xd5, 0x8e, 0xd8,
        0xb0, 0xc8, 0x8f, 0xa2, 0xb8, 0xb9, 0xf1, 0x8e, 0xb0, 0xd9, 0xc0,
        0x13 };
            result =

  "\u0015\u9ba8\u6bbc\u0013\u8a85\uff96\u9ea8\u81f2\u7c67\uff94f\u5aba\uff70\u9b8a)\uff8a\uff94\u8b2c\u001e\u0009\uff6b\u59a5\uff67\uff76=\u75ca\u834a"
              +

  "{\u0005\u8004\u001d\u5fd1\u60bd\uff83\u6595\u5a9a\u65fa\u731bB\uff62\u8f33\u5948\u8ec1\uff98\u978d\u0384\u56fd\uff70\u62c8\u0013";

            Assert.AreEqual(result, Encodings.DecodeToString(charset, bytes));
        }

        public static void TestSingleByteRoundTrip(string name) {
      ICharacterEncoding enc = Encodings.GetEncoding(name, false);
      Assert.NotNull(enc, name);
            TestSingleByteRoundTrip(enc);
        }

        public static void TestSingleByteRoundTrip(ICharacterEncoding enc) {
            var codepoints = new int[256];
            var codesrc = new int[256];
            ICharacterEncoder encoder = enc.GetEncoder();
            ICharacterDecoder decoder = enc.GetDecoder();
            var codetotal = 0;
            var bytes = new byte[256];
            for (var i = 0; i < 256; ++i) {
                bytes[i] = (byte)i;
            }
            IByteReader ib = DataIO.ToReader(bytes);
            for (var i = 0; i < 256; ++i) {
                int c = decoder.ReadChar(ib);
                if (c == -1) {
                    Assert.Fail();
                }
                if (c != -2) {
                    codepoints[codetotal] = c;
                    codesrc[codetotal] = i;
                    ++codetotal;
                }
            }
            var aw = new ArrayWriter();
            for (var i = 0; i < codetotal; ++i) {
                int c = encoder.Encode(codepoints[i], aw);
                if (c < 0) {
                    Assert.Fail();
                }
            }
            bytes = aw.ToArray();
            for (var i = 0; i < codetotal; ++i) {
                int b = ((int)bytes[i]) & 0xff;
                if (b != codesrc[i]) {
                    Assert.AreEqual(codesrc[i], b);
                }
            }
        }

        [Test]
public void TestCodePages() {
            for (var j = 0; j < this.valueSingleByteNames.Length; ++j) {
ICharacterEncoding enc = Encodings.GetEncoding(this.valueSingleByteNames[j]);

                ICharacterDecoder dec = enc.GetDecoder();
                var bytes = new byte[256];
                var ints = new int[256];
                var count = 0;
                for (var i = 0; i < 256; ++i) {
                    bytes[i] = (byte)i;
                }
                IByteReader reader = DataIO.ToReader(bytes);
                for (var i = 0; i < 256; ++i) {
                    ints[i] = dec.ReadChar(reader);
                    if (ints[i] >= 0) {
                    ++count;
                    }
                }
                if (count != 256) {
                    continue;
                }
                var builder = new StringBuilder();
                builder.Append("CODEPAGE 1\nCPINFO 1 0x3f 0x3f\nMBTABLE " +
                    TestCommon.IntToString(count) + "\n");
                for (var i = 0; i < 256; ++i) {
                    if (ints[i] >= 0) {
                    builder.Append(TestCommon.IntToString(i) + " " +
                    TestCommon.IntToString(ints[i]) + "\n");
                    }
                }
                builder.Append("WCTABLE " + count + "\n");
                for (var i = 0; i < 256; ++i) {
                    if (ints[i] >= 0) {
                    builder.Append(TestCommon.IntToString(ints[i]) + " " +
                    TestCommon.IntToString(i) + "\n");
                    }
                }
                builder.Append("ENDCODEPAGE\n");
var cpe = new CodePageEncoding(Encodings.StringToInput(builder.ToString()));
                TestSingleByteRoundTrip(cpe);
            }
        }

        private readonly string[] valueSingleByteNames = new string[] {
      "windows-1252",
      "us-ascii",
      "x-user-defined",
      "iso-8859-1",
      "iso-8859-2",
      "iso-8859-10",
      "windows-1250",
      "iso-8859-4",
      "windows-1257",
      "iso-8859-13",
      "iso-8859-14",
      "iso-8859-16",
      "windows-1255",
      "iso-8859-8",
      "iso-8859-8-i",
      "iso-8859-5",
      "ibm866",
      "koi8-r",
      "windows-1251",
      "x-mac-cyrillic",
      "koi8-u",
      "iso-8859-7",
      "windows-1253",
      "iso-8859-6",
      "windows-1256",
      "iso-8859-3",
      "iso-8859-15",
      "windows-1254",
      "windows-874",
      "windows-1258",
      "macintosh"
    };

        public static void TestUtfRoundTrip(
           ICharacterEncoding enc) {
            ICharacterEncoder encoder = enc.GetEncoder();
            ICharacterDecoder decoder = enc.GetDecoder();
            TestUtfRoundTrip(encoder, decoder);
        }

    private sealed class ByteCounterReader : IByteReader {
      private readonly byte[] bytes;
      private readonly IByteReader reader;

      public ByteCounterReader(byte[] bytes) {
        this.Position = 0;
        this.bytes = bytes;
        this.reader = DataIO.ToReader(bytes);
      }

      public int Position { get; set; }

      public int ReadByte() {
        int ret = this.reader.ReadByte();
        if (ret >= 0) {
int newPosition = this.Position + 1;
 this.Position = newPosition;
}
        return ret;
      }

      public byte[] GetBytes(int count) {
        int left = this.bytes.Length - this.Position;
        if (left < count) {
 count = left;
}
        var ret = new byte[count];
        Array.Copy(this.bytes, this.Position, ret, 0, count);
        return ret;
      }
    }

        public static void TestUtfRoundTrip(
           ICharacterEncoder encoder,
           ICharacterDecoder decoder) {
            var aw = new ArrayWriter();
            for (var i = 0; i < 0x110000; ++i) {
                if (i >= 0xd800 && i < 0xe000) {
                    continue;
                }
                int e = encoder.Encode(i, aw);
                if (e == -2) {
                    Assert.Fail("Failed to encode " + i);
                }
            }
      encoder.Encode(-1, aw);
            var reader = new ByteCounterReader(aw.ToArray());
            for (var i = 0; i < 0x110000; ++i) {
                if (i >= 0xd800 && i < 0xe000) {
                    continue;
                }
        int pos = reader.Position;
                int c = decoder.ReadChar(reader);
                if (c != i) {
          reader.Position = pos;
          byte[] context = reader.GetBytes(10);
          string bytestr = TestCommon.ToByteArrayString(context);
                    Assert.AreEqual(i, c, bytestr);
                }
            }
        }

        public static void TestCJKRoundTrip(string name) {
            ICharacterEncoding enc = Encodings.GetEncoding(name, true);
      Assert.NotNull(enc, name);
            ICharacterEncoder encoder = enc.GetEncoder();
            ICharacterDecoder decoder = enc.GetDecoder();
            var list = new List<int>();
            var aw = new ArrayWriter();
            for (var i = 0; i < 0x110000; ++i) {
                if (i >= 0xd800 && i < 0xe000) {
                    continue;
                }
        if (i == 0xa5 || i == 0x203e || i == 0x0e || i == 0x0f || i == 0x1b ||
            i == 0x2212 || i == 0xe5e5 || (i >= 0xff61 && i <= 0xff9f)) {
                    // ignore certain characters that intentionally
                    // don't round trip in certain encodings
                    continue;
                }
                int e = encoder.Encode(i, aw);
                if (e >= 0) {
                    list.Add(i);
                }
            }
            while (encoder.Encode(-1, aw) >= 0) {
            }
            IReader reader = DataIO.ToReader(aw.ToArray());
            for (var i = 0; i < list.Count; ++i) {
                int ch = list[i];
                int c = decoder.ReadChar(reader);
                if (c != ch) {
                    Assert.Fail(name + ": ValueExpected " + ch + ", was " + c);
                }
            }
        }
        [Test]
        public void TestGBK() {
            TestCJKRoundTrip("gbk");
      TestCJKRoundTrip("GBK");
    }
        [Test]
public void TestGB18030RoundTrip() {
            TestCJKRoundTrip("gb18030");
      TestCJKRoundTrip("GB18030");
    }
        [Test]
public void TestBig5() {
            TestCJKRoundTrip("big5");
        }
        [Test]
public void TestKoreanEUC() {
            TestCJKRoundTrip("euc-kr");
        }
        [Test]
public void TestShiftJISRoundTrip() {
            TestCJKRoundTrip("shift_jis");
        }
        [Test]
public void TestEucJPRoundTrip() {
            TestCJKRoundTrip("euc-jp");
        }
        [Test]
public void TestIso2022JPRoundTrip() {
            TestCJKRoundTrip("iso-2022-jp");
        }

        [Test]
public void TestReplacementEncoding() {
            if (Encodings.GetEncoding("replacement") == null) {
 Assert.Fail();
 }
            ICharacterEncoding enc = Encodings.GetEncoding("hz-gb-2312", false);
            ICharacterEncoder encoder = enc.GetEncoder();
            ICharacterDecoder decoder = enc.GetDecoder();
            IByteReader reader = DataIO.ToReader(new byte[] { 0, 0, 0, 0 });
            Assert.AreEqual(-2, decoder.ReadChar(reader));
            Assert.AreEqual(-1, decoder.ReadChar(reader));
            TestUtfRoundTrip(
              encoder,
              Encodings.GetEncoding("utf-8", true).GetDecoder());
        }

        [Test]
public void TestSingleByteEncodings() {
            for (var i = 0; i < this.valueSingleByteNames.Length; ++i) {
                TestSingleByteRoundTrip(this.valueSingleByteNames[i]);
            }
        }

        [Test]
    [Timeout(30000)]
public void TestUtf7RoundTrip() {
            TestUtfRoundTrip(Encodings.GetEncoding("utf-7", true));
        }

        [Test]
public void TestUtf8RoundTrip() {
            TestUtfRoundTrip(Encodings.GetEncoding("utf-8", true));
        }

        public static IList<byte[]> GenerateIllegalUtf8Sequences() {
            List<byte[]> list = new List<byte[]>();
            // Generate illegal single bytes
            for (int i = 0x80; i <= 0xff; ++i) {
                if (i < 0xc2 || i > 0xf4) {
                    list.Add(new byte[] { (byte)i, 0x80 });
                }
                list.Add(new[] { (byte)i });
            }
            list.Add(new byte[] { 0xe0, 0xa0 });
            list.Add(new byte[] { 0xe1, 0x80 });
            list.Add(new byte[] { 0xef, 0x80 });
            list.Add(new byte[] { 0xf0, 0x90 });
            list.Add(new byte[] { 0xf1, 0x80 });
            list.Add(new byte[] { 0xf3, 0x80 });
            list.Add(new byte[] { 0xf4, 0x80 });
            list.Add(new byte[] { 0xf0, 0x90, 0x80 });
            list.Add(new byte[] { 0xf1, 0x80, 0x80 });
            list.Add(new byte[] { 0xf3, 0x80, 0x80 });
            list.Add(new byte[] { 0xf4, 0x80, 0x80 });
            // Generate illegal multibyte sequences
            for (int i = 0x00; i <= 0xff; ++i) {
                if (i < 0x80 || i > 0xbf) {
                    list.Add(new byte[] { 0xc2, (byte)i });
                    list.Add(new byte[] { 0xdf, (byte)i });
                    list.Add(new byte[] { 0xe1, (byte)i, 0x80 });
                    list.Add(new byte[] { 0xef, (byte)i, 0x80 });
                    list.Add(new byte[] { 0xf1, (byte)i, 0x80, 0x80 });
                    list.Add(new byte[] { 0xf3, (byte)i, 0x80, 0x80 });
                    list.Add(new byte[] { 0xe0, 0xa0, (byte)i });
                    list.Add(new byte[] { 0xe1, 0x80, (byte)i });
                    list.Add(new byte[] { 0xef, 0x80, (byte)i });
                    list.Add(new byte[] { 0xf0, 0x90, (byte)i, 0x80 });
                    list.Add(new byte[] { 0xf1, 0x80, (byte)i, 0x80 });
                    list.Add(new byte[] { 0xf3, 0x80, (byte)i, 0x80 });
                    list.Add(new byte[] { 0xf4, 0x80, (byte)i, 0x80 });
                    list.Add(new byte[] { 0xf0, 0x90, 0x80, (byte)i });
                    list.Add(new byte[] { 0xf1, 0x80, 0x80, (byte)i });
                    list.Add(new byte[] { 0xf3, 0x80, 0x80, (byte)i });
                    list.Add(new byte[] { 0xf4, 0x80, 0x80, (byte)i });
                }
                if (i < 0xa0 || i > 0xbf) {
                    list.Add(new byte[] { 0xe0, (byte)i, 0x80 });
                }
                if (i < 0x90 || i > 0xbf) {
                    list.Add(new byte[] { 0xf0, (byte)i, 0x80, 0x80 });
                }
                if (i < 0x80 || i > 0x8f) {
                    list.Add(new byte[] { 0xf4, (byte)i, 0x80, 0x80 });
                }
            }
            return list;
        }

        [Test]
public void TestUtf8IllegalBytes() {
            foreach (byte[] seq in GenerateIllegalUtf8Sequences()) {
                string str = Encodings.DecodeToString(Encodings.UTF8, seq);
                Assert.IsTrue(str.Length > 0);
                Assert.IsTrue(str.IndexOf('\ufffd') == 0);
            }
        }

        [Test]
public void TestUtf16LERoundTrip() {
            TestUtfRoundTrip(Encodings.GetEncoding("utf-16le", true));
        }

        [Test]
public void TestUtf16BERoundTrip() {
            TestUtfRoundTrip(Encodings.GetEncoding("utf-16be", true));
        }
    [Test]
    public void TestUtf16() {
      ICharacterEncoding enc = Encodings.GetEncoding("utf-16", true);
      byte[] bytes;
      bytes = new byte[] { 0xff, 0xfe, 0x41, 0, 0x42, 0, 0x43, 0 };
      {
string stringTemp = Encodings.DecodeToString(enc, bytes);
Assert.AreEqual(
  "ABC",
  stringTemp);
}
      bytes = new byte[] { 0xfe, 0xff, 0, 0x41, 0, 0x42, 0, 0x43 };
      {
string stringTemp = Encodings.DecodeToString(enc, bytes);
Assert.AreEqual(
  "ABC",
  stringTemp);
}
      bytes = new byte[] { 0xfe, 0xff, 0, 0x41, 0, 0x42, 0, 0x43 };
      {
string stringTemp = Encodings.DecodeToString(enc, bytes);
Assert.AreEqual(
  "ABC",
  stringTemp);
}
      bytes = new byte[] { 0xfe, 0xff, 0, 0x41, 0 };
      {
string stringTemp = Encodings.DecodeToString(enc, bytes);
Assert.AreEqual(
  "A\ufffd",
  stringTemp);
}
      bytes = new byte[] { 0xfe, 0xff };
      Assert.AreEqual(
        String.Empty,
        Encodings.DecodeToString(enc, bytes));
      bytes = new byte[] { 0xff, 0xfe };
      Assert.AreEqual(
        String.Empty,
        Encodings.DecodeToString(enc, bytes));
      bytes = new byte[] { 0, 0x41 };
      {
string stringTemp = Encodings.DecodeToString(enc, bytes);
Assert.AreEqual(
  "A",
  stringTemp);
}
      bytes = new byte[] { 0xfe, 0xff, 0 };
      {
string stringTemp = Encodings.DecodeToString(enc, bytes);
Assert.AreEqual(
  "\ufffd",
  stringTemp);
}
      bytes = new byte[] { 0xfe };
      {
string stringTemp = Encodings.DecodeToString(enc, bytes);
Assert.AreEqual(
  "\ufffd",
  stringTemp);
}
      bytes = new byte[] { 0xdc, 0 };
      {
string stringTemp = Encodings.DecodeToString(enc, bytes);
Assert.AreEqual(
  "\ufffd",
  stringTemp);
}
    }

    public static void TestUtf7One(string input, string expect) {
            {
                object objectTemp = expect;
                object objectTemp2 = Encodings.DecodeToString(
                    Encodings.GetEncoding("utf-7", true),
                    Encodings.EncodeToBytes(input, Encodings.UTF8));
                Assert.AreEqual(objectTemp, objectTemp2);
            }
        }

        [Test]
public void TestUtf7() {
            TestUtf7One("\\", "\ufffd");
            TestUtf7One("~", "\ufffd");
            TestUtf7One(",", ",");
            TestUtf7One("\u0001", "\ufffd");
            TestUtf7One("\u007f", "\ufffd");
            TestUtf7One(
        "\r\n\t '!\"#'()$-%@[]^&=<>;*_`{}./:|?",
        "\r\n\t '!\"#'()$-%@[]^&=<>;*_`{}./:|?");
            TestUtf7One("x+--", "x+-");
            TestUtf7One("x+-y", "x+y");
            // Illegal byte after plus
            TestUtf7One("+!", "\ufffd!");
            TestUtf7One("+\n", "\ufffd\n");
            TestUtf7One("+\u007f", "\ufffd\ufffd");
            TestUtf7One("+", "\ufffd");
            // Incomplete byte
            TestUtf7One("+D?", "\ufffd?");
            TestUtf7One("+D\u007f", "\ufffd\ufffd");
            TestUtf7One("+D", "\ufffd");
            // Only one UTF-16 byte
            TestUtf7One("+DE?", "\ufffd?");
            TestUtf7One("+DE", "\ufffd");
            TestUtf7One("+DE\u007f", "\ufffd\ufffd");
            // UTF-16 code unit
            TestUtf7One("+DEE?", "\u0c41?");
            TestUtf7One("+DEE", "\u0c41");
            TestUtf7One("+DEE\u007f", "\u0c41\ufffd");
            // UTF-16 code unit (redundant pad bit)
            TestUtf7One("+DEF?", "\u0c41\ufffd?");
            TestUtf7One("+DEF", "\u0c41\ufffd");
            TestUtf7One("+DEF\u007f", "\u0c41\ufffd\ufffd");
            // High surrogate code unit
            TestUtf7One("+2AA?", "\ufffd?");
            TestUtf7One("+2AA", "\ufffd");
            TestUtf7One("+2AA\u007f", "\ufffd\ufffd");
            // Low surrogate code unit
            TestUtf7One("+3AA?", "\ufffd?");
            TestUtf7One("+3AA", "\ufffd");
            TestUtf7One("+3AA\u007f", "\ufffd\ufffd");
            // Surrogate pair
            TestUtf7One("+2ADcAA?", "\ud800\udc00?");
            TestUtf7One("+2ADcAA", "\ud800\udc00");
            TestUtf7One("+2ADcAA\u007f", "\ud800\udc00\ufffd");
            // High surrogate followed by surrogate pair
            TestUtf7One("+2ADYANwA?", "\ufffd\ud800\udc00?");
            TestUtf7One("+2ADYANwA", "\ufffd\ud800\udc00");
            TestUtf7One("+2ADYANwA\u007f", "\ufffd\ud800\udc00\ufffd");
            // High surrogate followed by non-surrogate
            TestUtf7One("+2AAAwA?", "\ufffd\u00c0?");
            TestUtf7One("+2AAAwA", "\ufffd\u00c0");
            TestUtf7One("+2AAAwA\u007f", "\ufffd\u00c0\ufffd");
            // Two UTF-16 code units
            TestUtf7One("+AMAA4A?", "\u00c0\u00e0?");
            TestUtf7One("+AMAA4A", "\u00c0\u00e0");
      TestUtf7One("+AMAA4A-Next", "\u00c0\u00e0Next");
      TestUtf7One("+AMAA4A--Next", "\u00c0\u00e0-Next");
      TestUtf7One("+AMAA4A!Next", "\u00c0\u00e0!Next");
            TestUtf7One("+AMAA4A\u007f", "\u00c0\u00e0\ufffd");
            // Two UTF-16 code units (redundant pad bit)
            TestUtf7One("+AMAA4B?", "\u00c0\u00e0\ufffd?");
            TestUtf7One("+AMAA4B", "\u00c0\u00e0\ufffd");
      TestUtf7One("+AMAA4B-Next", "\u00c0\u00e0\ufffdNext");
      TestUtf7One("+AMAA4B--Next", "\u00c0\u00e0\ufffd-Next");
      TestUtf7One("+AMAA4B!Next", "\u00c0\u00e0\ufffd!Next");
            TestUtf7One("+AMAA4B\u007f", "\u00c0\u00e0\ufffd\ufffd");
        }
    }
}
