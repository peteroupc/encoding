/*
Written by Peter O. in 2014.
Any copyright is dedicated to the Public Domain.
http://creativecommons.org/publicdomain/zero/1.0/
If you like this, you should donate to Peter O.
at: http://peteroupc.github.io/
 */
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;
using PeterO;
using PeterO.Text;
using Test;

namespace EncodingTest
{
    [TestFixture]
    public class CharsetsTest
    {
        [Test]
        public void TestShiftJIS ()
        {
            // Adapted from the public domain Gonk test cases
            byte [] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding ("shift_jis");
            bytes = new byte [] { 0x82, 0x58, 0x33, 0x41, 0x61, 0x33, 0x82, 0x60,
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

            Assert.AreEqual (ValueExpected, Encodings.DecodeToString (charset, bytes));
        }

        private static void TestEncodingRoundTrip (
      string str,
      ICharacterEncoding encoding)
        {
            byte [] bytes;
            string str2;
            bytes = Encodings.EncodeToBytes (str, encoding);
            str2 = Encodings.DecodeToString (encoding, bytes);
            Assert.AreEqual (str, str2);
        }

        [Test]
        public void TestGB18030 ()
        {
            ICharacterEncoding encoding = Encodings.GetEncoding ("gb18030");
            TestEncodingRoundTrip ("\uffff", encoding);
            TestEncodingRoundTrip ("\ud800\udc00", encoding);
            TestEncodingRoundTrip ("\udbff\udfff", encoding);
        }

        [Test]
        public void TestIso2022JP ()
        {
            byte [] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding ("iso-2022-jp");
            bytes = new byte [] { 0x20, 0x41, 0x61, 0x5c };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  " Aa\\",
                  stringTemp);
            }
            // Illegal byte in escape middle state
            bytes = new byte [] { 0x1b, 0x28, 0x47, 0x21, 0x41, 0x31, 0x5c };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "\ufffd\u0028\u0047!A1\\",
                stringTemp);
            }
            // Katakana
            bytes = new byte [] { 0x1b, 0x28, 0x49, 0x21, 0x41, 0x31, 0x5c };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "\uff61\uff81\uff71\uff9c",
                stringTemp);
            }
            bytes = new byte [] { 0x1b, 0x28, 0x49, 0x20, 0x41, 0x61, 0x5c };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "\ufffd\uff81\ufffd\uff9c",
                stringTemp);
            }
            // ASCII state via escape
            bytes = new byte [] { 0x1b, 0x28, 0x42, 0x20, 0x41, 0x61, 0x5c };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                " Aa\\",
                stringTemp);
            }
            bytes = new byte [] { 0x1b, 0x28, 0x4a, 0x20, 0x41, 0x61, 0x5c };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                " Aa\u00a5",
                stringTemp);
            }
            // JIS0208 state
            bytes = new byte [] { 0x1b, 0x24, 0x40, 0x21, 0x21, 0x21, 0x22, 0x21, 0x23 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "\u3000\u3001\u3002",
                stringTemp);
            }
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x21, 0x21, 0x21, 0x22, 0x21, 0x23 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "\u3000\u3001\u3002",
                stringTemp);
            }
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x21, 0x21, 0x21, 0x22, 0x0a,
        0x21, 0x23 };
            // Illegal state
            bytes = new byte [] { 0x1b, 0x24, 0x4f, 0x21, 0x21, 0x21, 0x23, 0x21, 0x23 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "\ufffd\u0024\u004f!!!\u0023!#",
                stringTemp);
            }
            // Illegal state
            bytes = new byte [] { 0x1b, 0x24, 0x28, 0x4f, 0x21, 0x21, 0x21, 0x23,
        0x21, 0x23 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "\ufffd\u0024\u0028\u004f!!!\u0023!#",
                stringTemp);
            }
            // Illegal state at end
            bytes = new byte [] { 0x41, 0x1b };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "A\ufffd",
                stringTemp);
            }
            bytes = new byte [] { 0x41, 0x1b, 0x27 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "A\ufffd'",
                stringTemp);
            }
            bytes = new byte [] { 0x41, 0x1b, 0x24 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "A\ufffd$",
                stringTemp);
            }
            bytes = new byte [] { 0x41, 0x1b, 0x24, 0x28 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "A\ufffd$\u0028",
                stringTemp);
            }
        }

        [Test]
        public void TestEucJPEncodeSpecific ()
        {
            string str;
            byte [] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding ("euc-jp");
            str = "\uff57\u5256";
            bytes = new byte [] { (byte)0xa3, (byte)0xf7, (byte)0xcb, (byte)0xb6
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff3e";
            bytes = new byte [] { (byte)0xa1, (byte)0xb0 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff2a";
            bytes = new byte [] { (byte)0xa3, (byte)0xca };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7984";
            bytes = new byte [] { (byte)0xcf, (byte)0xbd };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff6c\uff2b";
            bytes = new byte [] { (byte)0x8e, (byte)0xac, (byte)0xa3, (byte)0xcb
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff04";
            bytes = new byte [] { (byte)0xa1, (byte)0xf0 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff9c";
            bytes = new byte [] { (byte)0x8e, (byte)0xdc };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u594f";
            bytes = new byte [] { (byte)0xc1, (byte)0xd5 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7670\uff77";
            bytes = new byte [] { (byte)0xe1, (byte)0xfe, (byte)0x8e, (byte)0xb7
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u73f1\u898f";
            bytes = new byte [] { (byte)0xe0, (byte)0xfe, (byte)0xb5, (byte)0xac
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff45";
            bytes = new byte [] { (byte)0xa3, (byte)0xe5 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u25cb\uff4f";
            bytes = new byte [] { (byte)0xa1, (byte)0xfb, (byte)0xa3, (byte)0xef
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7dac";
            bytes = new byte [] { (byte)0xbc, (byte)0xfa };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff8d";
            bytes = new byte [] { (byte)0x8e, (byte)0xcd };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6148";
            bytes = new byte [] { (byte)0xbb, (byte)0xfc };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u68a7";
            bytes = new byte [] { (byte)0xb8, (byte)0xe8 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u541f";
            bytes = new byte [] { (byte)0xb6, (byte)0xe3 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u608b\u50d5";
            bytes = new byte [] { (byte)0xd8, (byte)0xa7, (byte)0xcb, (byte)0xcd
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff47\uff14";
            bytes = new byte [] { (byte)0xa3, (byte)0xe7, (byte)0xa3, (byte)0xb4
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5be5";
            bytes = new byte [] { (byte)0xd5, (byte)0xec };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7bb1";
            bytes = new byte [] { (byte)0xc8, (byte)0xa2 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff9e";
            bytes = new byte [] { (byte)0x8e, (byte)0xde };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff7d";
            bytes = new byte [] { (byte)0x8e, (byte)0xbd };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6e0a";
            bytes = new byte [] { (byte)0xde, (byte)0xbd };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u51f5";
            bytes = new byte [] { (byte)0xd1, (byte)0xe1 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6756";
            bytes = new byte [] { (byte)0xbe, (byte)0xf3 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u68c9";
            bytes = new byte [] { (byte)0xcc, (byte)0xc9 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff04";
            bytes = new byte [] { (byte)0xa1, (byte)0xf0 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u54a2";
            bytes = new byte [] { (byte)0xd2, (byte)0xf8 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7523";
            bytes = new byte [] { (byte)0xbb, (byte)0xba };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff26";
            bytes = new byte [] { (byte)0xa3, (byte)0xc6 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7407";
            bytes = new byte [] { (byte)0xfb, (byte)0xaa };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff0e";
            bytes = new byte [] { (byte)0xa1, (byte)0xa5 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7a98";
            bytes = new byte [] { (byte)0xe3, (byte)0xdb };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7b8f";
            bytes = new byte [] { (byte)0xe4, (byte)0xb7 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5e7b\uff38";
            bytes = new byte [] { (byte)0xb8, (byte)0xb8, (byte)0xa3, (byte)0xd8
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff78\u6ebf";
            bytes = new byte [] { (byte)0x8e, (byte)0xb8, (byte)0xfa, (byte)0xed
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5d84";
            bytes = new byte [] { (byte)0xd6, (byte)0xd0 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff2f";
            bytes = new byte [] { (byte)0xa3, (byte)0xcf };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff69";
            bytes = new byte [] { (byte)0x8e, (byte)0xa9 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff9c";
            bytes = new byte [] { (byte)0x8e, (byte)0xdc };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff24";
            bytes = new byte [] { (byte)0xa3, (byte)0xc4 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uffe5\u226b";
            bytes = new byte [] { (byte)0xa1, (byte)0xef, (byte)0xa2, (byte)0xe4
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff7f";
            bytes = new byte [] { (byte)0x8e, (byte)0xbf };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u65cb";
            bytes = new byte [] { (byte)0xc0, (byte)0xfb };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff5c";
            bytes = new byte [] { (byte)0xa1, (byte)0xc3 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7470\u695a";
            bytes = new byte [] { (byte)0xe0, (byte)0xf3, (byte)0xc1, (byte)0xbf
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff88";
            bytes = new byte [] { (byte)0x8e, (byte)0xc8 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u25a0\u79d5";
            bytes = new byte [] { (byte)0xa2, (byte)0xa3, (byte)0xe3, (byte)0xbe
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u0011";
            bytes = new byte [] { 0x11 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "J";
            bytes = new byte [] { 0x4a };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u53bb\u592e";
            bytes = new byte [] { (byte)0xb5, (byte)0xee, (byte)0xb1, (byte)0xfb
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff2e";
            bytes = new byte [] { (byte)0xa3, (byte)0xce };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u67c4";
            bytes = new byte [] { (byte)0xca, (byte)0xc1 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6292";
            bytes = new byte [] { (byte)0xd9, (byte)0xb3 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff03";
            bytes = new byte [] { (byte)0xa1, (byte)0xf4 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u000c";
            bytes = new byte [] { 0x0c };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u71ed";
            bytes = new byte [] { (byte)0xbf, (byte)0xa4 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff9f";
            bytes = new byte [] { (byte)0x8e, (byte)0xdf };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u2517\uff5c";
            bytes = new byte [] { (byte)0xa8, (byte)0xb1, (byte)0xa1, (byte)0xc3
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6500";
            bytes = new byte [] { (byte)0xda, (byte)0xb5 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u770c";
            bytes = new byte [] { (byte)0xb8, (byte)0xa9 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff72";
            bytes = new byte [] { (byte)0x8e, (byte)0xb2 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7591";
            bytes = new byte [] { (byte)0xb5, (byte)0xbf };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff79";
            bytes = new byte [] { (byte)0x8e, (byte)0xb9 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u731f";
            bytes = new byte [] { (byte)0xce, (byte)0xc4 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6859";
            bytes = new byte [] { (byte)0xdb, (byte)0xe2 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6a7f";
            bytes = new byte [] { (byte)0xb3, (byte)0xe0 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u2287";
            bytes = new byte [] { (byte)0xa2, (byte)0xbd };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6b43";
            bytes = new byte [] { (byte)0xdd, (byte)0xbd };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff4b";
            bytes = new byte [] { (byte)0xa3, (byte)0xeb };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u751f";
            bytes = new byte [] { (byte)0xc0, (byte)0xb8 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff85\uff16";
            bytes = new byte [] { (byte)0x8e, (byte)0xc5, (byte)0xa3, (byte)0xb6
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff9d\u6234";
            bytes = new byte [] { (byte)0x8e, (byte)0xdd, (byte)0xc2, (byte)0xd7
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u75d2\u7962";
            bytes = new byte [] { (byte)0xe1, (byte)0xda, (byte)0xc7, (byte)0xaa
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5b2a";
            bytes = new byte [] { (byte)0xd5, (byte)0xcd };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u251d";
            bytes = new byte [] { (byte)0xa8, (byte)0xbc };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5c3d";
            bytes = new byte [] { (byte)0xbf, (byte)0xd4 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7ac5";
            bytes = new byte [] { (byte)0xe3, (byte)0xe1 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uffe3";
            bytes = new byte [] { (byte)0xa1, (byte)0xb1 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff61\uff47";
            bytes = new byte [] { (byte)0x8e, (byte)0xa1, (byte)0xa3, (byte)0xe7
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u2640\uff76";
            bytes = new byte [] { (byte)0xa1, (byte)0xea, (byte)0x8e, (byte)0xb6
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6e19";
            bytes = new byte [] { (byte)0xde, (byte)0xd2 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u69ff";
            bytes = new byte [] { (byte)0xdc, (byte)0xdd };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5409";
            bytes = new byte [] { (byte)0xb5, (byte)0xc8 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7891";
            bytes = new byte [] { (byte)0xc8, (byte)0xea };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff47";
            bytes = new byte [] { (byte)0xa3, (byte)0xe7 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7409\u6070\uff68";
            bytes = new byte [] { (byte)0xce, (byte)0xb0, (byte)0xb3,
              (byte)0xe6, (byte)0x8e, (byte)0xa8 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5a41\u5ac2";
            bytes = new byte [] { (byte)0xcf, (byte)0xac, (byte)0xd5, (byte)0xbf
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u253c";
            bytes = new byte [] { (byte)0xa8, (byte)0xab };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff38";
            bytes = new byte [] { (byte)0xa3, (byte)0xd8 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u718a";
            bytes = new byte [] { (byte)0xb7, (byte)0xa7 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff48d";
            bytes = new byte [] { (byte)0xa3, (byte)0xe8, 0x64 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff98\u203b";
            bytes = new byte [] { (byte)0x8e, (byte)0xd8, (byte)0xa2, (byte)0xa8
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff19";
            bytes = new byte [] { (byte)0xa3, (byte)0xb9 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7fb9\u5149";
            bytes = new byte [] { (byte)0xe6, (byte)0xbd, (byte)0xb8, (byte)0xf7
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6a5f";
            bytes = new byte [] { (byte)0xb5, (byte)0xa1 };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u9587\u7dd5";
            bytes = new byte [] { (byte)0xef, (byte)0xda, (byte)0xe5, (byte)0xee
              };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff9d";
            bytes = new byte [] { (byte)0x8e, (byte)0xdd };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff3a";
            bytes = new byte [] { (byte)0xa3, (byte)0xda };
            TestCommon.AssertByteArraysEqual (
bytes,
            Encodings.EncodeToBytes (str, charset));
        }

        [Test]
        public void TestEucJPSpecific ()
        {
            byte [] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding ("euc-jp");
            bytes = new byte [] { (byte)0x98, (byte)0x87, (byte)0xd7, 0x38, 0x34, 0x57,
  (byte)0xb8, 0x68, (byte)0xd9, (byte)0xbc, (byte)0x97, 0x0c, (byte)0x88,
  0x60, (byte)0xa3, (byte)0xa8, 0x51, 0x1b, 0x08, 0x10, 0x7e, 0x6e, 0x36,
  (byte)0xb1, (byte)0xa4, 0x75, (byte)0xac };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd\ufffd\ufffd84W\ufffdh\u62cf\ufffd\u000c\ufffd`\ufffdQ\u001b\u0008\u0010~n6\u97fbu\ufffd",
                  stringTemp);
            }
            bytes = new byte [] { (byte)0xda, 0x26, (byte)0xe4, 0x24, 0x23,
              0x40, 0x4e, (byte)0xff, 0x26, 0x49, 0x54, 0x28, (byte)0x9e,
              0x57, 0x49, (byte)0x93, (byte)0xd2, 0x45, 0x6b, (byte)0x91,
              (byte)0xb4, 0x50 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd&\ufffd$#@N\ufffd&IT(\ufffdWI\ufffd\ufffdEk\ufffd\ufffdP", stringTemp);
            }
            bytes = new byte [] { (byte)0xb8, (byte)0x90, 0x5d, (byte)0xdf,
              0x24, (byte)0xdd, (byte)0xaf, (byte)0xa0, 0x2a, (byte)0x9a,
              0x38, 0x5d, (byte)0xf9, 0x54, 0x26, (byte)0xa8, 0x62, 0x2e,
              (byte)0x80, (byte)0xdf, (byte)0xb7, 0x70, 0x19, (byte)0xa4,
              0x2a };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd]\ufffd$\u6afb\ufffd*\ufffd8]\ufffdT&\ufffdb.\ufffd\u6fa4p\u0019\ufffd*",
                  stringTemp);
            }
            bytes = new byte [] { (byte)0x94, 0x22, (byte)0xde, 0x28,
              (byte)0x8c, (byte)0xa3, 0x1a, (byte)0xde, 0x4c, (byte)0xc1,
              0x1d, (byte)0xea, 0x41, (byte)0x82, (byte)0xec, 0x7f, 0x5f,
              (byte)0x8a, (byte)0xaa, (byte)0xf6, 0x2c, (byte)0x87, 0x4f,
              (byte)0x92, 0x4a };
            Assert.AreEqual (
  "\ufffd\"\ufffd(\ufffd\ufffd\u001a\ufffdL\ufffd\u001d\ufffdA\ufffd\ufffd\u007f_\ufffd\ufffd,\ufffdO\ufffdJ",

             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x17, 0x70, 0x06, 0x03, 0x33, 0x1b, 0x3f,
              (byte)0x8a, 0x73, (byte)0x8d, 0x3c, (byte)0x84, 0x69, 0x63,
              0x55, 0x46, (byte)0xa3, 0x40, 0x02, 0x42 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\u0017p\u0006\u00033\u001b?\ufffds\ufffd<\ufffdicUF\ufffd@\u0002B",
                  stringTemp);
            }
            bytes = new byte [] { 0x48, (byte)0x8f, (byte)0xe0, 0x6b, 0x47,
              (byte)0xa9, (byte)0xdd, 0x27, 0x6a, 0x13, (byte)0xb5,
              (byte)0xf2, (byte)0x8b, 0x38, 0x37, (byte)0xc0, (byte)0xeb,
              (byte)0x88, (byte)0xc1, 0x03, (byte)0x94, 0x0c, 0x61,
              (byte)0xbb, 0x06 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "H\ufffdkG\ufffd'j\u0013\u62e0\ufffd87\u5ba3\ufffd\ufffd\u0003\ufffd\u000ca\ufffd\u0006",
                  stringTemp);
            }
            bytes = new byte [] { (byte)0xcd, (byte)0xea, (byte)0xe3, 0x22,
              (byte)0xe4, (byte)0xd8, 0x6a, (byte)0xf0, 0x5f, 0x18, 0x02 };
            Assert.AreEqual (
             "\u983c\ufffd\"\u7c54j\ufffd_\u0018\u0002",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xb4, (byte)0xd8, (byte)0xc0, 0x47,
              (byte)0xc5, (byte)0xf7, (byte)0xe3, (byte)0xc1, 0x2a,
              (byte)0xd6, 0x44 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\u95a2\ufffdG\u75d8\u79e1*\ufffdD",
                  stringTemp);
            }
            bytes = new byte [] { 0x1c };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\u001c",
                  stringTemp);
            }
            bytes = new byte [] { (byte)0xe0, 0x4a, 0x6a, 0x33, 0x64,
              (byte)0xa9, (byte)0xb9, 0x23, 0x49, (byte)0x91, (byte)0xf2,
              0x27, (byte)0x9b, 0x52, (byte)0xc1, (byte)0xca, (byte)0x8e,
              (byte)0xc5, 0x13, 0x16, 0x7c, (byte)0x8a, (byte)0xcf, 0x3a,
              0x3e, (byte)0xd7, 0x54, (byte)0xec, (byte)0xba };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffdJj3d\ufffd#I\ufffd\ufffd'\ufffdR\u8a34\uff85\u0013\u0016|\ufffd\ufffd:>\ufffdT\u8c82",
                  stringTemp);
            }
            bytes = new byte [] { (byte)0xeb, (byte)0xdd, 0x30, 0x79, 0x08,
              (byte)0x94, 0x60, (byte)0xa7, (byte)0xef, (byte)0xf1,
              (byte)0x97, (byte)0xfe, 0x1e, 0x4b, 0x5d, 0x55, 0x04 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\u8aeb0y\u0008\ufffd`\u044d\ufffd\ufffd\u001eK]U\u0004",
                  stringTemp);
            }
            bytes = new byte [] { 0x06, 0x4a, (byte)0xe4, 0x00, (byte)0x8c,
              0x53, 0x3a, (byte)0xbc, 0x4b, (byte)0xff, (byte)0xe0, 0x0b,
              (byte)0x89, 0x29, (byte)0x94, 0x28, 0x76, 0x2d, (byte)0x98,
              (byte)0xbf, (byte)0x92, (byte)0xda, (byte)0x95, 0x0f,
              (byte)0xea, 0x07 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\u0006J\ufffd\u0000\ufffdS:\ufffdK\ufffd\ufffd\u000b\ufffd)\ufffd(v-\ufffd\ufffd\ufffd\u000f\ufffd\u0007",
                 stringTemp);
            }
            bytes = new byte [] { (byte)0xd5, (byte)0xf7, (byte)0x95, 0x2a,
              0x29, 0x0f, 0x34, 0x16, 0x44, (byte)0x94, 0x3a, 0x4d, 0x5e,
              0x0a, 0x7e, 0x3e, (byte)0xaf, 0x5f, 0x03, 0x20, (byte)0xee,
              0x11, (byte)0xcf, 0x72, 0x63, (byte)0xbd, (byte)0xf5, 0x1b,
              0x2a, (byte)0xb2 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\u5c22\ufffd*)\u000f4\u0016D\ufffd:M^\u000a~>\ufffd_\u0003 \ufffd\u0011\ufffdrc\u52a9\u001b*\ufffd",
                 stringTemp);
            }
            bytes = new byte [] { 0x39, 0x0f, 0x1d, 0x03, (byte)0xd4, 0x4b,
              0x00, (byte)0xe2, 0x4e, 0x3c, 0x5d, 0x44, 0x2c, 0x7f,
              (byte)0xcf, 0x68, 0x4d, (byte)0xe5, 0x0b, 0x5f, (byte)0x9c,
              0x6c, (byte)0xe9, 0x39, (byte)0x98, 0x5c, (byte)0xb0,
              (byte)0xa8, (byte)0xf8, 0x1d };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                string string2 = "9\u000f\u001d\u0003\ufffdK\u0000\ufffdN<]D,\u007f\ufffdhM\ufffd\u000b_\ufffdl\ufffd9\ufffd\\\u59f6\ufffd\u001d";
                Assert.AreEqual (string2,
          stringTemp);
            }
            bytes = new byte [] { (byte)0xf0, 0x2a, 0x7d, 0x26, (byte)0xc5,
              (byte)0xa0, (byte)0xbf, 0x7d, 0x1a, 0x1d, 0x1d, (byte)0x81,
              (byte)0xa1, 0x49, (byte)0x99, (byte)0xa6 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd*}&\ufffd\ufffd}\u001a\u001d\u001d\ufffd\ufffdI\ufffd\ufffd",
                  stringTemp);
            }
            bytes = new byte [] { (byte)0xed, (byte)0xa5, (byte)0xc1,
              (byte)0xbf, 0x6a, 0x03, 0x60, (byte)0x84, 0x06, (byte)0xcf,
              (byte)0xad, (byte)0xe6, 0x5a, 0x2b, (byte)0x9f, (byte)0x99 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\u8e48\u695aj\u0003`\ufffd\u0006\u5eca\ufffdZ+\ufffd\ufffd",
                  stringTemp);
            }
            bytes = new byte [] { 0x11, (byte)0x8c, (byte)0x89, (byte)0xd1,
              0x70, 0x3e, 0x34, 0x67, (byte)0xde, (byte)0xf0, 0x62, 0x06,
              (byte)0xc6, 0x59, (byte)0x9b, 0x6e, (byte)0xcf, 0x52, 0x5e,
              0x56, 0x3f, (byte)0x9d, (byte)0xb5, (byte)0xe1, (byte)0xc2,
              (byte)0xb7, (byte)0x86 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\u0011\ufffd\ufffd\ufffdp>4g\u6ea5b\u0006\ufffdY\ufffdn\ufffdR^V?\ufffd\u6c42\u63c3\ufffd",
                  stringTemp);
            }
            bytes = new byte [] { 0x18, (byte)0xb1, (byte)0xa5, 0x28,
              (byte)0xee, (byte)0xd0, (byte)0xe0, (byte)0xc8, 0x3b, 0x71,
              (byte)0xc2, 0x54, 0x46, (byte)0xd4, 0x74, (byte)0x9b, 0x79 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\u0018\u540b(\u91ab\u7317;q\ufffdTF\ufffdt\ufffdy", stringTemp);
            }
            bytes = new byte [] { 0x6b, (byte)0x87, (byte)0xcd, (byte)0xaf,
              (byte)0x83, 0x2c, 0x60, (byte)0x98, 0x21, (byte)0xd2,
              (byte)0xa7, 0x2f, 0x18, (byte)0xa6, (byte)0xc5 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                string str34290 = "k\ufffd\u6e67\ufffd,`\ufffd!\u52cd/\u0018\u03b5";

                Assert.AreEqual (
                str34290,
                  stringTemp);
            }
            bytes = new byte [] { (byte)0xa9, (byte)0xd9, (byte)0x9a,
              (byte)0xc7, 0x21, (byte)0xc4, (byte)0xe6, 0x12, (byte)0x85,
              (byte)0xd6, 0x40, (byte)0xc5, (byte)0xff, (byte)0x99,
              (byte)0xac, (byte)0xb3, (byte)0x88, 0x71 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd\ufffd\ufffd!\u5243\u0012\ufffd\ufffd@\ufffd\ufffd\ufffd\ufffdq",
                  stringTemp);
            }
            bytes = new byte [] { (byte)0xbd, 0x01, (byte)0x81, (byte)0x9b,
              (byte)0xc9, 0x5d, 0x08, 0x20, (byte)0xcc, (byte)0x91,
              (byte)0x90, (byte)0x8a, (byte)0xa4 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd\u0001\ufffd\ufffd\ufffd]\u0008 \ufffd\ufffd\ufffd\ufffd",
                  stringTemp);
            }
            bytes = new byte [] { (byte)0xfe, 0x73, 0x77, (byte)0x85,
              (byte)0xc3, 0x2a, (byte)0xf7, (byte)0xf7, 0x6a, (byte)0x98,
              (byte)0xd6, 0x55, (byte)0xc5, 0x70, 0x16, (byte)0xf0,
              (byte)0x80, 0x0a, 0x38, (byte)0x94, (byte)0xf0, 0x58,
              (byte)0xcf, 0x08, 0x2c, (byte)0x9a, (byte)0xf0, (byte)0xf3 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                string str35668 = "\ufffdsw\ufffd\ufffd*\ufffdj\ufffd\ufffdU\ufffdp\u0016\ufffd\u000a8\ufffd\ufffdX\ufffd\u0008,\ufffd\u980c";

                Assert.AreEqual (
                str35668,
                  stringTemp);
            }
            bytes = new byte [] { (byte)0x9a, (byte)0x81, 0x5e, (byte)0xa3,
              (byte)0xc6, 0x40, (byte)0x9b, (byte)0xf7, (byte)0xae, 0x06,
              (byte)0xb9, (byte)0x89, 0x4a, (byte)0xb0, 0x20, (byte)0xb5,
              0x74, 0x0d, (byte)0x83, 0x39, (byte)0xab, 0x3b, 0x43 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd\ufffd^\uff26@\ufffd\ufffd\u0006\ufffdJ\ufffd \ufffdt\u000d\ufffd9\ufffd;C",
                  stringTemp);
            }
            bytes = new byte [] { (byte)0xa6, (byte)0xbd, (byte)0x93,
              (byte)0xd4, 0x7a, (byte)0xc9, (byte)0xb6, (byte)0xc0,
              (byte)0xf3, 0x6a, (byte)0x92, 0x0f, (byte)0xd9, (byte)0xe9,
              0x6e, 0x4a, (byte)0xfd, (byte)0xc4, (byte)0xff };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd\ufffd\ufffdz\u4ff5\u6834j\ufffd\u000f\u63c4nJ\ufffd\ufffd",
                  stringTemp);
            }
            bytes = new byte [] { 0x1c, (byte)0xf4, 0x47, (byte)0xbd,
              (byte)0x87, (byte)0xee, 0x09, (byte)0xe6, (byte)0x9c,
              (byte)0xdc, (byte)0xa7, 0x65, (byte)0xdc, (byte)0x9a,
              (byte)0xf7, (byte)0xe0, (byte)0xcd, 0x64 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\u001c\ufffdG\ufffd\ufffd\u0009\ufffd\u68d7e\ufffd\ufffd\ufffdd",
                  stringTemp);
            }
            bytes = new byte [] { 0x32, 0x75, (byte)0xa3, 0x09, 0x10,
              (byte)0xe6, (byte)0xda, 0x0a, 0x51, (byte)0xf9, 0x33,
              (byte)0xa9, (byte)0xb1, (byte)0xed, 0x0b, 0x5c, (byte)0xd7,
              0x05, (byte)0xb0, 0x3b, (byte)0x9b, 0x18, (byte)0xef, 0x09,
              (byte)0xed, (byte)0xa2 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "2u\ufffd\u0009\u0010\u8052\u000aQ\ufffd3\ufffd\ufffd\u000b\\\ufffd\u0005\ufffd;\ufffd\u0018\ufffd\u0009\u8e49",
                  stringTemp);
            }
            bytes = new byte [] { (byte)0xcd, (byte)0xda, 0x60, 0x47,
              (byte)0x8d, (byte)0xc4, 0x00, (byte)0xff };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\u9065`G\ufffd\ufffd\u0000\ufffd",
                  stringTemp);
            }
            bytes = new byte [] { (byte)0xfa, (byte)0xdf, 0x37, 0x21,
              (byte)0x85, 0x58, 0x6a, (byte)0xa0, 0x10, 0x3c, (byte)0xb7,
              0x28, 0x55, 0x7b, (byte)0xf7, (byte)0x88, (byte)0xcc, 0x64,
              0x54, 0x18, (byte)0xb0, 0x3a, 0x76, 0x3f, 0x30, 0x2b, 0x5a,
              0x21, 0x73, (byte)0xee };
            bytes = new byte [] { (byte)0x91, 0x7e, 0x43, (byte)0x85, 0x4b, 0x60, 0x23, (byte)0xb4, 0x26 };
            Assert.AreEqual (
             "\ufffd~C\ufffdK`#\ufffd&",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xeb };
            Assert.AreEqual (
             "\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x4f, 0x63, 0x51, (byte)0xf9, 0x59, (byte)0xba, 0x37, (byte)0xb8, (byte)0x84, (byte)0x9f, (byte)0x83, 0x3d, (byte)0xeb, (byte)0xec, 0x6e, 0x69, (byte)0xf8, (byte)0xfd, (byte)0x85, 0x53, (byte)0x8b, 0x2d };
            Assert.AreEqual (
             "OcQ\ufffdY\ufffd7\ufffd\ufffd\ufffd=\u8b16ni\ufffd\ufffdS\ufffd-",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x40, (byte)0x9b, 0x29, 0x38, 0x58, 0x09, 0x0d, 0x04, 0x14, (byte)0xda, 0x38, 0x46, 0x6e, 0x52, 0x44, (byte)0xf9 };
            Assert.AreEqual (
             "@\ufffd)8X\u0009\u000d\u0004\u0014\ufffd8FnRD\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x47, 0x22, 0x33, 0x5f, (byte)0xe3, (byte)0x81, 0x55, (byte)0x85, 0x4b, 0x42, 0x37, 0x33, 0x76, (byte)0xf5, 0x12, 0x00, 0x51, 0x12, (byte)0xd3, 0x26, (byte)0xdb, (byte)0xe9, 0x3d, 0x16, (byte)0xdb, (byte)0xcc, 0x4c, (byte)0x8d };
            Assert.AreEqual (
             "G\"3_\ufffdU\ufffdKB73v\ufffd\u0012\u0000Q\u0012\ufffd&\u6894=\u0016\u67b3L\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xa9, (byte)0x96 };
            Assert.AreEqual (
             "\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x3a };
            Assert.AreEqual (
             ":",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x13, (byte)0x9b, (byte)0xba, 0x3b, 0x72, 0x39, 0x5b, 0x67, 0x2c, (byte)0xe8, 0x66, 0x32, (byte)0xa1, (byte)0xe5, 0x35, (byte)0xe9 };
            Assert.AreEqual (
             "\u0013\ufffd\ufffd;r9[g\u002c\ufffdf2\u22665\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xe1, 0x7d, (byte)0xfc, (byte)0xf3, (byte)0xba, (byte)0xe3, 0x50, (byte)0xec, (byte)0xcc, 0x7a, 0x5b, 0x54, 0x5d, 0x65, (byte)0xbb, 0x5a, 0x3c, 0x27, 0x35, (byte)0xaa, 0x6e, 0x44, (byte)0xad, 0x79, (byte)0x9c, (byte)0x95, (byte)0xe5, 0x64, (byte)0x85, (byte)0x92 };
            Assert.AreEqual (
             "\ufffd}\u2172\u51b4P\u8cc1z[T]e\ufffdZ<'5\ufffdnD\ufffdy\ufffd\ufffd\ufffdd\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x02, (byte)0xda, 0x24, (byte)0xf7, 0x51, 0x30, 0x5c, 0x06, (byte)0xfb, (byte)0xea, (byte)0xfd, (byte)0x9b, 0x1b, (byte)0x92, 0x5b, (byte)0xac, (byte)0xba };
            Assert.AreEqual (
             "\u0002\ufffd$\ufffdQ0\\\u0006\u8aa7\ufffd\u001b\ufffd[\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1a, 0x0a, (byte)0x83, 0x69, 0x5d, (byte)0xae, 0x4f, 0x01, (byte)0xce, (byte)0xd9, (byte)0xd3, (byte)0xc9, 0x2d, 0x0e };
            Assert.AreEqual (
             "\u001a\u000a\ufffdi]\ufffdO\u0001\u96a3\u5587-\u000e",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0x99, (byte)0xf6, (byte)0xf2, 0x0e, (byte)0xee, 0x32, 0x6b, 0x6f, 0x32, 0x1b, (byte)0xc2, (byte)0xda, (byte)0xba, (byte)0x98, (byte)0xfa, (byte)0xaf, (byte)0xa0, (byte)0xbb, (byte)0xa7, (byte)0x9b, 0x3b, (byte)0xe0, 0x32, (byte)0xe2, 0x6d, (byte)0x87 };
            Assert.AreEqual (
             "\ufffd\ufffd\u000e\ufffd2ko2\u001b\u6ede\ufffd\u63f5\ufffd\u85a9\ufffd;\ufffd2\ufffdm\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xed, 0x2b, 0x59, (byte)0xe3, 0x3f, (byte)0xfd, 0x01, 0x72, 0x1b, (byte)0x86, (byte)0x88, (byte)0xc8, 0x29, 0x70, 0x4e };
            Assert.AreEqual (
             "\ufffd+Y\ufffd?\ufffd\u0001r\u001b\ufffd\ufffd\ufffd)pN",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xf9 };
            Assert.AreEqual (
             "\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xdf, (byte)0x81, 0x58, 0x42, (byte)0xa4, 0x01, 0x0c, (byte)0x8d, 0x06, 0x07, 0x41, 0x6e, (byte)0x8e, 0x1d, (byte)0xf6, 0x7a, 0x5a, (byte)0x85, 0x11, 0x67, 0x11, (byte)0xa5, (byte)0x88, 0x54, 0x0b, 0x2b, 0x7b, (byte)0xfa, (byte)0x99, 0x01 };
            Assert.AreEqual (
             "\ufffdXB\ufffd\u0001\u000c\ufffd\u0006\u0007An\ufffd\u001d\ufffdzZ\ufffd\u0011g\u0011\ufffdT\u000b+{\ufffd\u0001",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xde, 0x72, 0x51, 0x6d, (byte)0x90, 0x44, (byte)0xeb, 0x21, 0x53, (byte)0xa4, 0x52, (byte)0x80, (byte)0xb7, (byte)0xe5, (byte)0x83, 0x53, (byte)0xa1, (byte)0xa9, (byte)0xeb, 0x7d, 0x24 };
            Assert.AreEqual (
             "\ufffdrQm\ufffdD\ufffd!S\ufffdR\ufffd\u6841\ufffdS\uff1f\ufffd}$",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xff, 0x52, 0x05, (byte)0xae, 0x6b, 0x12, 0x19, (byte)0x8c, 0x6b, 0x39, 0x0e, (byte)0xf5, 0x72, 0x60, (byte)0x96, 0x28, (byte)0xf1, 0x63, (byte)0xd9, 0x56, (byte)0x8a, 0x3c, (byte)0x90, (byte)0xa5, 0x69, 0x4b };
            Assert.AreEqual (
             "\ufffdR\u0005\ufffdk\u0012\u0019\ufffdk9\u000e\ufffdr`\ufffd(\ufffdc\ufffdV\ufffd<\ufffd\ufffdiK",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x45, (byte)0xfa, (byte)0xca, 0x59, (byte)0xfc, 0x56, (byte)0xbb, (byte)0x95, 0x2b, 0x52, 0x3d, (byte)0xaa, 0x1a, 0x3b, (byte)0xba, (byte)0xa2 };
            Assert.AreEqual (
             "E\u67c0Y\ufffdV\ufffd+R=\ufffd\u001a;\u9803",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x3a, 0x13, 0x4b, (byte)0x9a, 0x0b, (byte)0xf6, (byte)0xfc, 0x4d, (byte)0xc8, (byte)0xf8, 0x3c, 0x4e, 0x20 };
            Assert.AreEqual (
             ":\u0013K\ufffd\u000b\ufffdM\u5c3e<N ",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0x8a, 0x01, 0x0c, 0x1b };
            Assert.AreEqual (
             "\ufffd\u0001\u000c\u001b",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x7f, 0x28, 0x1e, (byte)0xd9, 0x21, (byte)0xc9, (byte)0xe1, (byte)0xbf, (byte)0xc1, 0x39, 0x62, 0x61, 0x2c, (byte)0xb4, 0x1e, (byte)0xe1, (byte)0x81, 0x33, (byte)0x9a, (byte)0x8c, 0x01, (byte)0x84, (byte)0x91, (byte)0xdb };
            Assert.AreEqual (
             "\u007f(\u001e\ufffd!\u666e\u79e69ba\u002c\ufffd\u001e\ufffd3\ufffd\ufffd\u0001\ufffd\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x42, (byte)0xa9, 0x18, 0x40, (byte)0xfc, 0x3c, (byte)0x96, 0x10, (byte)0xdb, 0x02, (byte)0xfb, 0x1f, 0x6e, 0x2f };
            Assert.AreEqual (
             "B\ufffd\u0018@\ufffd<\ufffd\u0010\ufffd\u0002\ufffd\u001fn/",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xa7, (byte)0x9d, (byte)0xe6, (byte)0xf2, (byte)0xdb, (byte)0xf6, (byte)0xff, (byte)0xc0, 0x0f, 0x33, (byte)0xe5, (byte)0xed, 0x60, 0x34, 0x2a, 0x26, 0x44, 0x50, (byte)0xea, 0x67, 0x4a, 0x44 };
            Assert.AreEqual (
             "\ufffd\u80d9\u6901\ufffd\ufffd\u000f3\u7e83`4*&DP\ufffdgJD",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xff, 0x6d, (byte)0xf0, 0x0f, (byte)0x92, 0x02 };
            Assert.AreEqual (
             "\ufffdm\ufffd\u000f\ufffd\u0002",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x34, 0x54, (byte)0xb3, (byte)0x88, (byte)0xf8, 0x7f, (byte)0xb1, 0x6f, 0x1d, (byte)0xc3, 0x14, 0x68, (byte)0xa9, 0x21, 0x42, (byte)0xb9, 0x7d, 0x5f, 0x54, (byte)0x8b };
            Assert.AreEqual (
             "4T\ufffd\ufffd\u007f\ufffdo\u001d\ufffd\u0014h\ufffd!B\ufffd}_T\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x3c, (byte)0x86, 0x3f, 0x64, 0x58, 0x13, 0x6d, (byte)0xa5, 0x3e, 0x2e, (byte)0xe8, 0x3c, (byte)0xec, (byte)0xbc, 0x42, (byte)0xeb, 0x67, 0x1b, (byte)0xfa, (byte)0x84, 0x45, (byte)0xeb, (byte)0x80, 0x51, 0x4c, (byte)0xa3, 0x60 };
            Assert.AreEqual (
             "<\ufffd?dX\u0013m\ufffd>.\ufffd<\u8c85B\ufffdg\u001b\ufffdE\ufffdQL\ufffd`",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0x87, (byte)0xa8, 0x10, 0x76, 0x3a, (byte)0x8e, (byte)0xb8, 0x79, 0x54, (byte)0xc6, (byte)0xb7 };
            Assert.AreEqual (
             "\ufffd\ufffd\u0010v:\uff78yT\u77b3",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x52, (byte)0xe6, (byte)0x9e, (byte)0xef, 0x5e, (byte)0xb8, (byte)0xec, (byte)0xed, (byte)0xbe, (byte)0x93, 0x05, (byte)0xe1, 0x49 };
            Assert.AreEqual (
             "R\ufffd\ufffd^\u8a9e\u8eb1\ufffd\u0005\ufffdI",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x41, (byte)0xbc, (byte)0x94, 0x79, (byte)0x92, 0x5f, (byte)0x8e };
            Assert.AreEqual (
             "A\ufffdy\ufffd_\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xc1, 0x68, 0x45 };
            Assert.AreEqual (
             "\ufffdhE",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1c, 0x2e, (byte)0x83, (byte)0x85, 0x23, (byte)0xac, (byte)0xee, (byte)0xf7, (byte)0x9d, (byte)0x8e, 0x29, (byte)0xe5, (byte)0xe6, (byte)0x92, 0x3b, (byte)0xb4, (byte)0xc2, (byte)0xf6, 0x25, 0x7c, 0x34, 0x1d, 0x68 };
            Assert.AreEqual (
             "\u001c.\ufffd\ufffd#\ufffd\ufffd\ufffd)\u7e59\ufffd;\u6f97\ufffd%|4\u001dh",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x51, 0x02, (byte)0xef, 0x42, 0x70, (byte)0xbc, 0x75, 0x6d, 0x1e, (byte)0xc1, (byte)0xaa, 0x7c, (byte)0xb9, 0x3a, 0x6a, 0x7c, (byte)0xb7, (byte)0xf0, (byte)0xd2, 0x01, (byte)0xf1, 0x4c, 0x5b, (byte)0xef, 0x42, 0x66 };
            Assert.AreEqual (
             "Q\u0002\ufffdBp\ufffdum\u001e\u9078|\ufffd:j|\u5039\ufffd\u0001\ufffdL[\ufffdBf",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xdf, (byte)0xd1, 0x59, 0x07, 0x65, (byte)0xbf, 0x01, 0x5e, 0x4d, 0x62, 0x43, (byte)0x83 };
            Assert.AreEqual (
             "\u703eY\u0007e\ufffd\u0001^MbC\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x6c, (byte)0xc6, (byte)0xb4, (byte)0xe6, 0x22, 0x71, (byte)0xf0, 0x22, (byte)0xf6, 0x0a, 0x78, (byte)0xc1, (byte)0xc8, (byte)0x9d, (byte)0xe8, (byte)0xef, 0x08, 0x24, 0x35, (byte)0xef, 0x3a, 0x3c, 0x2c, 0x7c, (byte)0xcd, 0x47 };
            Assert.AreEqual (
             "l\u61a7\ufffd\"q\ufffd\"\ufffd\u000ax\u7d44\ufffd\u84d6\u0008$5\ufffd:<\u002c|\ufffdG",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xbd, 0x5e, (byte)0xb7, (byte)0xf6 };
            Assert.AreEqual (
             "\ufffd^\u55a7",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xb8, (byte)0xa5, (byte)0xb9, (byte)0xa9, 0x70, 0x7b, 0x26, (byte)0xc4, (byte)0xb9, 0x5e, 0x40, (byte)0xad, (byte)0xab, (byte)0x99, 0x19, (byte)0xf7, (byte)0xeb, 0x64, 0x78, (byte)0xbe, 0x49, (byte)0xc9, 0x36, 0x6d };
            Assert.AreEqual (
             "\u732e\u5de5p{&\u9577^@\u246a\ufffd\u0019\ufffddx\ufffdI\ufffd6m",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x6c, 0x14, 0x42, (byte)0xc4, 0x2a, 0x2d, (byte)0xad, 0x69 };
            Assert.AreEqual (
             "l\u0014B\ufffd*-\ufffdi",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x54, (byte)0xb6, 0x74, 0x6b, (byte)0xc6, (byte)0xfe, 0x1f, 0x71, 0x1d, (byte)0xaa, 0x2d, (byte)0x8a, 0x14, (byte)0xdf, 0x4b, (byte)0xa0, 0x60, (byte)0xab, 0x1a, 0x57, 0x74 };
            Assert.AreEqual (
             "T\ufffdtk\u5165\u001fq\u001d\ufffd-\ufffd\u0014\ufffdK\ufffd`\ufffd\u001aWt",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x49, (byte)0xcc, 0x72, 0x72, 0x2f, (byte)0xf8, (byte)0x85, 0x65, 0x2f, 0x70, 0x61, (byte)0xc6, (byte)0xc0, 0x75, 0x26 };
            Assert.AreEqual (
             "I\ufffdrr/\ufffde/pa\u5f97u&",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x55, (byte)0xb6, (byte)0xad, 0x5a, 0x26, 0x54, 0x35, 0x3c, 0x34, 0x7f, 0x71, (byte)0xf7, 0x57, 0x78, (byte)0xfc, (byte)0x9c };
            Assert.AreEqual (
             "U\u5883Z&T5<4\u007fq\ufffdWx\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xb8, (byte)0xa4, (byte)0xa6, (byte)0xa9, 0x44, (byte)0xba, 0x3b, (byte)0x82, (byte)0xec, 0x63 };
            Assert.AreEqual (
             "\u72ac\u0399D\ufffd;\ufffd\ufffdc",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1a, (byte)0xf1, 0x7f, 0x3a, (byte)0xfa, (byte)0x86, (byte)0xcf };
            Assert.AreEqual (
             "\u001a\ufffd\u007f:\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x58, 0x24, 0x77, 0x14, 0x4d, (byte)0xf1, (byte)0xd7, (byte)0xac, (byte)0xd2, (byte)0xfa, (byte)0xa2, 0x39, 0x7d, (byte)0x96 };
            Assert.AreEqual (
             "X$w\u0014M\u9a05\ufffd\u605d9}\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xc3, 0x4d, 0x0a, 0x1f, 0x41, (byte)0xec, (byte)0xf3, 0x4a, 0x13, 0x7d, (byte)0x8b, (byte)0xab, (byte)0xb9, 0x49, 0x2e, 0x26, 0x6e, 0x1f, (byte)0x99, 0x19, (byte)0x9b, (byte)0x97, 0x07, 0x4d, (byte)0xd3, 0x56, 0x0e, (byte)0xde };
            Assert.AreEqual (
             "\ufffdM\u000a\u001fA\u8e08J\u0013}\ufffd\ufffdI.&n\u001f\ufffd\u0019\ufffd\ufffd\u0007M\ufffdV\u000e\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x3e, (byte)0x84, 0x4b, (byte)0xc6, (byte)0x9a, 0x3b, 0x4d, 0x6a, 0x0f };
            Assert.AreEqual (
             ">\ufffdK\ufffd;Mj\u000f",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x38, (byte)0xb8, 0x5d, (byte)0xd0, 0x2f, 0x78 };
            Assert.AreEqual (
             "8\ufffd]\ufffd/x",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x2e, 0x3a, (byte)0xfe, (byte)0xc7, 0x6b, 0x0b, 0x17, 0x46, 0x64, 0x23, 0x47, 0x05, 0x75, 0x19, 0x63, 0x67 };
            Assert.AreEqual (
             ".:\ufffdk\u000b\u0017Fd#G\u0005u\u0019cg",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x36, (byte)0xf2, 0x3e, 0x65, (byte)0xab, (byte)0xad, 0x11, (byte)0xa3, (byte)0xe6, (byte)0xaa, 0x02, 0x64, 0x1a, (byte)0xde, 0x79, 0x5e, (byte)0xf8, (byte)0xca };
            Assert.AreEqual (
             "6\ufffd>e\ufffd\u0011\uff46\ufffd\u0002d\u001a\ufffdy^\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x64, (byte)0x8e, 0x2b, 0x66, 0x6c, 0x4a, 0x2a, 0x7b, 0x73, (byte)0xba, 0x7c, 0x57, 0x22, 0x50, 0x7d, (byte)0x96, 0x40, (byte)0xbb, 0x6c, 0x10, (byte)0x87, 0x5d, (byte)0x96, (byte)0x83, (byte)0xa8, (byte)0x84, 0x7d, 0x7b, (byte)0xb7 };
            Assert.AreEqual (
             "d\ufffd+flJ*{s\ufffd|W\"P}\ufffd@\ufffdl\u0010\ufffd]\ufffd\ufffd\ufffd}{\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x17, (byte)0xf1, (byte)0xb2, (byte)0xb4, 0x63, 0x1f, (byte)0xee, 0x53, (byte)0x84, (byte)0x83, (byte)0xee, 0x5d, 0x40, (byte)0xb9, 0x06, 0x49, 0x2d, (byte)0x82, 0x47, (byte)0xd8 };
            Assert.AreEqual (
             "\u0017\u9921\ufffdc\u001f\ufffdS\ufffd\ufffd\ufffd]@\ufffd\u0006I-\ufffdG\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x01, (byte)0x98, 0x2d, (byte)0xc8, 0x63, (byte)0x92, 0x20, 0x6b, 0x04, 0x7e, 0x21, 0x53, (byte)0xf9, (byte)0xee, 0x51, (byte)0xc9, 0x1a, 0x59, (byte)0xf1, (byte)0xdb };
            Assert.AreEqual (
             "\u0001\ufffd-\ufffdc\ufffd k\u0004~!S\u5becQ\ufffd\u001aY\u9a37",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x3d, 0x08, 0x79, 0x70, 0x4d, 0x33, 0x76, 0x1d, (byte)0xd9, 0x22, 0x4e };
            Assert.AreEqual (
             "=\u0008ypM3v\u001d\ufffd\"N",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x6d, 0x2d, 0x10, (byte)0x97, 0x29, 0x23, 0x51, (byte)0xa7, 0x78, 0x5e };
            Assert.AreEqual (
             "m-\u0010\ufffd)#Q\ufffdx^",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x5e, (byte)0xc2, 0x74, 0x58, 0x5d, 0x40, 0x5f, (byte)0xdf, (byte)0xa7, 0x5e, (byte)0xe4, 0x4b, (byte)0xaf, 0x37, (byte)0x9a, 0x72, (byte)0x8f, (byte)0xec, 0x4d, (byte)0x82, 0x6e, (byte)0xc0, 0x72, 0x59, (byte)0xfb, 0x22, (byte)0x9e, (byte)0xbd, 0x69, 0x40 };
            Assert.AreEqual (
             "^\ufffdtX]@_\u6f81^\ufffdK\ufffd7\ufffdr\ufffdM\ufffdn\ufffdrY\ufffd\"\ufffd\ufffdi@",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xf9, 0x6f, 0x5d, (byte)0xa0 };
            Assert.AreEqual (
             "\ufffdo]\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xf1, (byte)0xdb, 0x29, 0x3d, (byte)0xcc, (byte)0xc0, 0x59, 0x09, 0x10, 0x65, (byte)0xbf, 0x0a, (byte)0xb1, 0x21, 0x2b, 0x68 };
            Assert.AreEqual (
             "\u9a37)=\u660eY\u0009\u0010e\ufffd\u000a\ufffd!+h",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x61, 0x2f, (byte)0xdf, (byte)0xe5, (byte)0xa0, 0x4c, (byte)0xde, (byte)0xcf, (byte)0xc9, (byte)0x91, 0x04, (byte)0xd1, (byte)0x80, 0x6f, 0x39, 0x5b, 0x30, 0x4e, (byte)0xbc, 0x22, (byte)0xe7, (byte)0xda, 0x3b, (byte)0x95, 0x1b, 0x54 };
            Assert.AreEqual (
             "a/\u7165\ufffdL\u6e2d\ufffd\u0004\ufffdo9[0N\ufffd\"\u8259;\ufffd\u001bT",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x22, (byte)0x85, 0x43, 0x51, (byte)0x8a, (byte)0xd7, 0x67, 0x0f, (byte)0xf1, 0x39, 0x72, 0x23, 0x4b };
            Assert.AreEqual (
             "\"\ufffdCQ\ufffd\ufffdg\u000f\ufffd9r#K",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x74, 0x7b, (byte)0xed, (byte)0xd5, (byte)0x87, 0x69, 0x7f, (byte)0xfe, 0x51, 0x75, (byte)0xec, 0x72, (byte)0xfe, (byte)0xe4, 0x0c, (byte)0xbe, 0x15, (byte)0xad, 0x01, 0x3a, (byte)0x9b, 0x7a, 0x72, 0x71 };
            Assert.AreEqual (
             "t{\u8f3b\ufffdi\u007f\ufffdQu\ufffdr\ufffd\u000c\ufffd\u0015\ufffd\u0001:\ufffdzrq",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0x9d, (byte)0xca, 0x4b, (byte)0xe4, 0x41, 0x6e, (byte)0xf7, (byte)0xd0, 0x4d, 0x2d, (byte)0x8e, 0x22, (byte)0xd0, (byte)0xdf, (byte)0xa9, (byte)0x80, 0x07, 0x32, (byte)0xcf, 0x36, 0x4d, (byte)0xd5, 0x1b, (byte)0xfb, (byte)0xe4, 0x24, (byte)0xe7, 0x2b, (byte)0x84 };
            Assert.AreEqual (
             "\ufffd\ufffdK\ufffdAn\ufffdM-\ufffd\"\u4fe4\ufffd\u00072\ufffd6M\ufffd\u001b\ufa21$\ufffd+\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xf9, (byte)0xca, 0x30, 0x36, (byte)0xab };
            Assert.AreEqual (
             "\u52a606\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x57, 0x4a, 0x2a, 0x3f, (byte)0xcf, (byte)0xa7, 0x56, (byte)0xbd, (byte)0xfa, 0x6f, (byte)0xb1 };
            Assert.AreEqual (
             "WJ*?\u7089V\u6055o\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x6b, (byte)0xc7, (byte)0xe9, 0x5d, 0x16, 0x43, 0x53, (byte)0x8b, 0x5b, 0x30, (byte)0xf4, 0x5d, (byte)0xa2, 0x35 };
            Assert.AreEqual (
             "k\u79e4]\u0016CS\ufffd[0\ufffd]\ufffd5",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xd6, 0x47, (byte)0xdf, (byte)0xd3, (byte)0xb6, (byte)0x9a, (byte)0xc2, 0x78, 0x78, 0x63, (byte)0x83, 0x56, 0x69, 0x57 };
            Assert.AreEqual (
             "\ufffdG\u7051\ufffd\ufffdxxc\ufffdViW",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x6e, 0x38, 0x5b, 0x71, 0x5f, (byte)0x86, 0x78 };
            Assert.AreEqual (
             "n8[q_\ufffdx",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xe1, 0x67, (byte)0x8c, (byte)0xe8, (byte)0xb7, (byte)0xcd, 0x67, 0x63, 0x21, (byte)0xba, (byte)0xbe, 0x29, (byte)0xef, 0x44, 0x7a, 0x04, 0x54, 0x12, (byte)0xb1, 0x40, 0x12 };
            Assert.AreEqual (
             "\ufffdg\ufffd\u838a\ufffdgc!\u8a50)\ufffdDz\u0004T\u0012\ufffd@\u0012",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x65, 0x3d, 0x6d, 0x76, 0x47, (byte)0x90, (byte)0xc3, (byte)0xce, (byte)0xc9, (byte)0xa3, (byte)0xb7, 0x3c, (byte)0xf7, 0x0c, (byte)0x8a, 0x66, 0x52, 0x32 };
            Assert.AreEqual (
             "e=mvG\ufffd\u77e5\u7a17\ufffd<\ufffd\u000c\ufffdfR2",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xe1, 0x07, 0x77, (byte)0xf4, (byte)0xb2, 0x4c, (byte)0xf2, 0x2d, 0x23, 0x3f, 0x4e, 0x7f, 0x28, 0x33, 0x26, (byte)0xfc, 0x3d, (byte)0x92, (byte)0xba };
            Assert.AreEqual (
             "\ufffd\u0007w\ufffdL\ufffd-#?N\u007f(3&\ufffd=\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xd5, (byte)0xd0, (byte)0x92, (byte)0x9e, 0x00, (byte)0xe9, (byte)0x99, (byte)0xf2, 0x06 };
            Assert.AreEqual (
             "\u5b43\ufffd\ufffd\u0000\ufffd\ufffd\u0006",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x5a, 0x20, (byte)0xf5, 0x61, 0x42, 0x52, (byte)0x9f, 0x73, (byte)0xff, 0x54, 0x03, 0x07, (byte)0x92, 0x4d, (byte)0x84, (byte)0xd2, 0x60, 0x5c, 0x41, 0x78, 0x6f, (byte)0xf6, 0x4e, (byte)0xf3, (byte)0xa5 };
            Assert.AreEqual (
             "Z \ufffdaBR\ufffds\ufffdT\u0003\u0007\ufffdM\ufffd\ufffd`\\Axo\ufffdN\u9d50",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x62, (byte)0x96, 0x2f, 0x2e, (byte)0xa7, (byte)0xc6, 0x12 };
            Assert.AreEqual (
             "b\ufffd/.\ufffd\u0012",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x45, (byte)0x94, (byte)0xcf, 0x7f, 0x25, (byte)0x8d, (byte)0x9a, 0x59, (byte)0x8e };
            Assert.AreEqual (
             "E\ufffd\ufffd\u007f%\ufffd\ufffdY\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x6a, (byte)0xfa, 0x32, 0x61, 0x1a, 0x72, (byte)0xc4, 0x6f, 0x74, (byte)0xaa, (byte)0xdc, 0x49, (byte)0x97, (byte)0xec, (byte)0x8e, (byte)0xad };
            Assert.AreEqual (
             "j\ufffd2a\u001ar\ufffdot\ufffdI\ufffd\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xab, 0x58, (byte)0xf6, 0x1d, (byte)0xb9, 0x3b, 0x43, 0x3a, 0x69, 0x43, (byte)0xc7, (byte)0x9b, (byte)0xf1, 0x18, 0x31, 0x3e, (byte)0xeb, (byte)0xa4, (byte)0x8d, 0x7f, (byte)0x93 };
            Assert.AreEqual (
             "\ufffdX\ufffd\u001d\ufffd;C:iC\ufffd\ufffd\u00181>\u896a\ufffd\u007f\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xa4, 0x06, (byte)0x85, 0x39, (byte)0xc5, 0x5f, (byte)0xdc, (byte)0xd8, (byte)0xa8, (byte)0xee, (byte)0xe0 };
            Assert.AreEqual (
             "\ufffd\u0006\ufffd9\ufffd_\u69b4\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x37, 0x29, 0x60, 0x4f, 0x64, (byte)0x81, 0x64, 0x3d, (byte)0xcc, (byte)0xdd, 0x1b, (byte)0x92, 0x23, (byte)0x98, 0x51 };
            Assert.AreEqual (
             "7)`Od\ufffdd=\u6762\u001b\ufffd#\ufffdQ",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x7d, (byte)0xac, 0x4f, 0x65, (byte)0xe3, 0x21, (byte)0xff, 0x5a, (byte)0xdd, 0x56, 0x2e, 0x43 };
            Assert.AreEqual (
             "}\ufffdOe\ufffd!\ufffdZ\ufffdV.C",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xe2, (byte)0xd7, (byte)0xe8, 0x2c, 0x39, 0x4a, (byte)0xd3, (byte)0xa9, 0x79, 0x26 };
            Assert.AreEqual (
             "\u77b0\ufffd\u002c9J\u550fy&",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xb9, (byte)0xde, 0x39, (byte)0xc1, 0x4d, 0x0f, (byte)0xcc, (byte)0xfe, (byte)0xba, 0x36, (byte)0x99, 0x1c, 0x68, (byte)0x8a, (byte)0xf0 };
            Assert.AreEqual (
             "\u95a49\ufffdM\u000f\u7652\ufffd6\ufffd\u001ch\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x7b, (byte)0xd0, 0x3b, (byte)0xa3, 0x67, 0x6e, 0x7f, 0x5a, 0x45, 0x1a, (byte)0xd2, 0x73, (byte)0xd2, 0x6d, 0x6b, (byte)0xb1, (byte)0xc4, (byte)0xc3, 0x13, (byte)0x86, 0x49, 0x38, 0x22, 0x76, 0x3a, 0x3b, (byte)0xbd, 0x6c };
            Assert.AreEqual (
             "{\ufffd;\ufffdgn\u007fZE\u001a\ufffds\ufffdmk\u55b6\ufffd\u0013\ufffdI8\"v:;\ufffdl",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x76, 0x39, (byte)0x81, 0x28, 0x2c, (byte)0xf6, (byte)0xdc, 0x38, (byte)0xf6, (byte)0x9e, 0x4b, 0x56, 0x20, 0x52, 0x30, (byte)0xe3, 0x3e, (byte)0xef, 0x77, 0x7f, 0x7a, (byte)0xaa, (byte)0xb1, (byte)0xdf };
            Assert.AreEqual (
             "v9\ufffd(\u002c\ufffd8\ufffdKV R0\ufffd>\ufffdw\u007fz\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xd4, 0x40, 0x69, 0x65, (byte)0x89, (byte)0xd3, (byte)0xdd, 0x04, (byte)0xee, 0x20, (byte)0xb0, (byte)0xbc, (byte)0xe2, (byte)0xe6, 0x36, (byte)0x8b, 0x4a, (byte)0x83, (byte)0xa0, (byte)0xf0, (byte)0xe7, 0x3a, 0x3f, 0x16, (byte)0xed };
            Assert.AreEqual (
             "\ufffd@ie\ufffd\u5636\u0004\ufffd \u7d62\u780c6\ufffdJ\ufffd\ufffd\u97c3:?\u0016\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xbe, 0x5a, 0x3e, 0x41, 0x22, (byte)0xdf, 0x4c, 0x35, (byte)0x92, 0x5b, 0x19, 0x48, 0x02, (byte)0x8e, 0x37, 0x2c, (byte)0xbf, (byte)0xa9, (byte)0xc8, 0x70, 0x49, 0x4f, 0x6d, 0x0b, 0x29 };
            Assert.AreEqual (
             "\ufffdZ>A\"\ufffdL5\ufffd[\u0019H\u0002\ufffd7\u002c\u98df\ufffdpIOm\u000b)",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xe9, 0x17, (byte)0xf5, 0x54, (byte)0xe4, (byte)0xd6, (byte)0xe5, (byte)0xea, 0x2a, 0x19, (byte)0x95 };
            Assert.AreEqual (
             "\ufffd\u0017\ufffdT\u7c4c\u7e69*\u0019\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x65, 0x52, 0x3a, (byte)0xb6, (byte)0xfd };
            Assert.AreEqual (
             "eR:\u5c51",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x3d, (byte)0x95, (byte)0xc4, (byte)0xe1, (byte)0xf9, 0x55, 0x47, 0x48, (byte)0xb6, 0x6b, 0x2e, (byte)0x84, (byte)0xe2, 0x46, (byte)0xfb, (byte)0x8e, (byte)0xc9, (byte)0xe1 };
            Assert.AreEqual (
             "=\ufffd\u9db4\ufffdUGH\ufffdk.\ufffd\ufffdF\ufffd\u666e",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0x8b, 0x2b, 0x1a, (byte)0x90, 0x42, 0x17, 0x0d, 0x6d, 0x55, 0x25, 0x05, 0x28, (byte)0xb1, 0x03, (byte)0xe8, (byte)0xc4, 0x68, 0x36, (byte)0xc2, (byte)0x95, (byte)0xf4, 0x51, 0x60 };
            Assert.AreEqual (
             "\ufffd+\u001a\ufffdB\u0017\u000dmU%\u0005(\ufffd\u0003\u8403h6\ufffd\ufffdQ`",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x12, (byte)0xc7, 0x33, 0x5b, (byte)0x90, 0x03, (byte)0xec, 0x65, 0x24, 0x5b, 0x31, 0x14, (byte)0xf6, 0x7f, (byte)0xf7, 0x3b, (byte)0x91, 0x45, 0x49, (byte)0x90 };
            Assert.AreEqual (
             "\u0012\ufffd3[\ufffd\u0003\ufffde$[1\u0014\ufffd\u007f\ufffd;\ufffdEI\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x7a, (byte)0xe8, 0x39, (byte)0xb4, 0x4d, 0x28, 0x4f, 0x7b, 0x4a, (byte)0xc3, (byte)0xe2, (byte)0xee, 0x54, (byte)0xc8, (byte)0xbe, 0x10, 0x38, (byte)0x90, (byte)0xa6, (byte)0xf1, (byte)0xe5, (byte)0xd2, (byte)0xb3, 0x55, 0x4d, 0x3d, (byte)0xd9, 0x31 };
            Assert.AreEqual (
             "z\ufffd9\ufffdM(O{J\u7a92\ufffdT\u534a\u00108\ufffd\ufffd\u7e21\ufffdUM=\ufffd1",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xa5, 0x24, (byte)0xe0, 0x19, (byte)0x8c, 0x7f, 0x14, (byte)0xb9, 0x24, (byte)0x8b, 0x7c, (byte)0x84, (byte)0xcc, (byte)0x83, 0x6b, (byte)0x8e };
            Assert.AreEqual (
             "\ufffd$\ufffd\u0019\ufffd\u007f\u0014\ufffd$\ufffd|\ufffd\ufffdk\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x66, 0x49, 0x5b, 0x43, 0x05, 0x53, 0x11, 0x6f, (byte)0xc6, (byte)0x8c, (byte)0xc8, 0x08, (byte)0xac, 0x24, 0x1e, 0x63, 0x70, 0x52, 0x55, (byte)0xea, (byte)0xa6, 0x75, (byte)0xd6, (byte)0xa2, 0x39, (byte)0xcd };
            Assert.AreEqual (
             "fI[C\u0005S\u0011o\ufffd\ufffd\u0008\ufffd$\u001ecpRU\u879fu\u5c4f9\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x7c, (byte)0xfc, 0x5a, 0x3a, (byte)0xbb, (byte)0xbb, 0x54, 0x35, 0x4a, (byte)0x9b, (byte)0xfa, 0x5c, (byte)0xf9, (byte)0xc9, (byte)0x8a, 0x67, 0x4a, 0x79, (byte)0x99, (byte)0xdf, 0x6a, (byte)0xd8, 0x00 };
            Assert.AreEqual (
             "|\ufffdZ:\u7b97T5J\ufffd\ufffd\\\u529c\ufffdgJy\ufffd\ufffdj\ufffd\u0000",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1f, (byte)0xd0, (byte)0x9e, (byte)0xf7, (byte)0x88, 0x48, (byte)0x80, 0x7c, 0x11 };
            Assert.AreEqual (
             "\u001f\ufffd\ufffdH\ufffd|\u0011",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0x83, 0x36, 0x7d, 0x21, (byte)0xdf, (byte)0x9e, (byte)0xf5, (byte)0xd3, 0x7f, (byte)0x8e, 0x42, (byte)0x89, 0x0b, 0x29, 0x73, 0x7a, 0x6c, (byte)0xae, 0x61, 0x70 };
            Assert.AreEqual (
             "\ufffd6}!\ufffd\ufffd\u007f\ufffdB\ufffd\u000b)szl\ufffdap",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x24, 0x71, (byte)0xe3, 0x48, 0x63, 0x7b, 0x1d, 0x42, 0x72, 0x3e, (byte)0xd0, (byte)0xd4, 0x0d, 0x72, 0x4f, 0x13, (byte)0xd2, 0x24, (byte)0xcc, (byte)0xf8 };
            Assert.AreEqual (
             "$q\ufffdHc{\u001dBr>\u4f86\u000drO\u0013\ufffd$\u67f3",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x30, (byte)0xd5, 0x5e, 0x0a, (byte)0xe6, 0x51, (byte)0xb7, (byte)0xd7, 0x2a, 0x74, (byte)0xdd, (byte)0xc2, (byte)0x88, 0x73, 0x0f, (byte)0xa4, (byte)0xf0, (byte)0x86, 0x23, 0x05, (byte)0x80, 0x05, 0x47, 0x33, 0x26, 0x02, 0x77, (byte)0xe0, 0x10 };
            Assert.AreEqual (
             "0\ufffd^\u000a\ufffdQ\u8a08*t\u6b5b\ufffds\u000f\u3090\ufffd#\u0005\ufffd\u0005G3&\u0002w\ufffd\u0010",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xfe, 0x68, (byte)0xa8, 0x47, (byte)0x91, (byte)0xb2, 0x29, 0x4d, (byte)0xcf, 0x78, 0x13, 0x5e, 0x4b, 0x73, (byte)0xd0, 0x1a, 0x5f, (byte)0x84, (byte)0xa7, 0x1c, (byte)0xf7 };
            Assert.AreEqual (
             "\ufffdh\ufffdG\ufffd\ufffd)M\ufffdx\u0013^Ks\ufffd\u001a_\ufffd\ufffd\u001c\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xb4, 0x21, 0x4b, (byte)0xca };
            Assert.AreEqual (
             "\ufffd!K\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x11, 0x73, (byte)0xf5, 0x47, 0x08, (byte)0xea, (byte)0xe5 };
            Assert.AreEqual (
             "\u0011s\ufffdG\u0008\u88d9",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x03, 0x5e, 0x58, (byte)0xc9, 0x3c, (byte)0xbb, 0x63, 0x6f, (byte)0x99, 0x66, (byte)0x9b, 0x37 };
            Assert.AreEqual (
             "\u0003^X\ufffd<\ufffdco\ufffdf\ufffd7",
             Encodings.DecodeToString (charset, bytes));
        }

        [Test]
        public void TestIso2022JPSpecific ()
        {
            ICharacterEncoding charset = Encodings.GetEncoding ("iso-2022-jp");
            byte [] bytes;
            bytes = new byte [] { 0x1b, 0x28, 0x49, 0x6c, 0x2c, 0x62, 0x25, 0x3c, 0x69, 0x1b, 0x28, 0x42, 0x16, 0x51, 0x5f, 0x72 };
            Assert.AreEqual (
             "\ufffd\uff6c\ufffd\uff65\uff7c\ufffd\u0016Q_r",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x73, 0x5b, 0x5a, 0x4f, 0x73, 0x7c, 0x79, 0x7b, 0x5d, 0x47 };
            Assert.AreEqual (
             "s[ZOs|y{]G",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x3c };
            Assert.AreEqual (
             "<",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x48, 0x4b, 0x1b, 0x28, 0x48, 0x3b, 0x68, 0x1b, 0x28, 0x49, 0x5f, 0x78, 0x51, 0x2d, 0x54, 0x1b, 0x28, 0x49, 0x46, 0x1b, 0x24, 0x42, 0x7b, 0x40, 0x45, 0x5f, 0x1b, 0x24, 0x40, 0x2c, 0x5f, 0x1b, 0x28, 0x48, 0x5b, 0x35, 0x6d, 0x35, 0x67, 0x40 };
            Assert.AreEqual (
             "\ufffdH(K\ufffdH(;h\uff9f\ufffd\uff91\uff6d\uff94\uff86\u787a\u51ac\ufffd\ufffd\u5e61\u6741\u8e93\u81c9",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x47, 0x21, 0x43, 0x77, 0x3e, 0x32, 0x1b, 0x24, 0x40, 0x39, 0x69, 0x23, 0x55, 0x24, 0x60, 0x24, 0x58, 0x6d, 0x6b, 0x1b, 0x28, 0x49, 0x33, 0x5c, 0x44, 0x1b, 0x28, 0x49, 0x40, 0x5f, 0x38 };
            Assert.AreEqual (
             "G!Cw>2\u62f7\uff35\u3080\u3078\u8fe2\uff73\uff9c\uff84\uff80\uff9f\uff78",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x7e, 0x6a, 0x2c, 0x2f, 0x29, 0x34, 0x45, 0x5f, 0x2d, 0x3f, 0x77, 0x1e, 0x6a };
            Assert.AreEqual (
             "~j,/)4E_-?w\u001ej",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x48, 0x6e, 0x60, 0x46, 0x59, 0x5a, 0x29, 0x5f, 0x51, 0x38, 0x1b, 0x24, 0x42, 0x1b, 0x28, 0x49, 0x38, 0x3a, 0x73, 0x4d, 0x4c, 0x5d, 0x1b, 0x28, 0x49, 0x37, 0x27, 0x1b, 0x28, 0x48 };
            Assert.AreEqual (
             "\ufffdH(n`FYZ)_Q8\ufffd\uff78\uff7a\ufffd\uff8d\uff8c\uff9d\uff77\uff67\ufffd\uff88\uff68",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x42, 0x3e, 0x5f, 0x44, 0x56, 0x38, 0x54, 0x75, 0x24, 0x35, 0x4c, 0x66, 0x11, 0x35, 0x68, 0x1b, 0x24, 0x42, 0x76, 0x7a, 0x3c, 0x33, 0x2a, 0x39, 0x44, 0x3b, 0x26, 0x7f, 0x32 };
            Assert.AreEqual (
             ">_DV8Tu$5Lf\u00115h\ufffd\u7afa\ufffd\u9ce5\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x62, 0x7e, 0x37, 0x4c, 0x57, 0x64, 0x23, 0x2d, 0x6d, 0x67, 0x1b, 0x24, 0x42, 0x35, 0x02, 0x78, 0x55, 0x3c, 0x7c, 0x4b, 0x2e, 0x70 };
            Assert.AreEqual (
             "b~7LWd#-mg\ufffd\ufffd\u56da\u90a6\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x49, 0x3d };
            Assert.AreEqual (
             "\uff7d",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x42, 0x4c, 0x59, 0x63, 0x5f, 0x2b, 0x7c, 0x4a, 0x1b, 0x24, 0x40, 0x1b, 0x28, 0x49, 0x62, 0x48, 0x69, 0x47, 0x7b, 0x74 };
            Assert.AreEqual (
             "LYc_+|J\ufffd\ufffd\uff88\ufffd\uff87\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x49, 0x2d, 0x3f, 0x41, 0x1b, 0x28, 0x49, 0x4d, 0x4d, 0x1b, 0x28, 0x49, 0x5c, 0x4c, 0x2b, 0x6a, 0x57, 0x49, 0x73, 0x3f, 0x68, 0x55, 0x71, 0x21, 0x7e, 0x6a };
            Assert.AreEqual (
             "\uff6d\uff7f\uff81\uff8d\uff8d\uff9c\uff8c\uff6b\ufffd\uff97\uff89\ufffd\uff7f\ufffd\uff95\ufffd\uff61\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x73, 0x72, 0x6f, 0x1b, 0x28, 0x48, 0x41, 0x35, 0x2f, 0x36, 0x3a, 0x31, 0x50, 0x1b, 0x28, 0x48, 0x78, 0x53, 0x68, 0x64 };
            Assert.AreEqual (
             "sro\ufffdH(A5/6:1P\ufffdH(xShd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x74, 0x51, 0x33, 0x1b, 0x28, 0x48 };
            Assert.AreEqual (
             "tQ3\ufffdH(",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x2c, 0x1b, 0x24, 0x42, 0x23, 0x1b, 0x24, 0x40, 0x31, 0x6a, 0x79, 0x3b, 0x1b, 0x28, 0x48, 0x44, 0x69, 0x3d, 0x25, 0x5d, 0x48, 0x29, 0x66, 0x1b, 0x24, 0x40, 0x2c };
            Assert.AreEqual (
             ",\ufffd\u708e\u4fff\ufffd\u5e61\u5824\u6101\u6b80\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x4d, 0x7d, 0x45, 0x28, 0x2e, 0x4c, 0x3a, 0x10 };
            Assert.AreEqual (
             "M}E(.L:\u0010",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x4d, 0x3a };
            Assert.AreEqual (
             "M:",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x49, 0x36, 0x7c, 0x3d, 0x20, 0x39, 0x47, 0x5a, 0x53, 0x1b, 0x28, 0x42, 0x6f, 0x6b, 0x79, 0x56, 0x65, 0x47, 0x6c, 0x03 };
            Assert.AreEqual (
             "\uff76\ufffd\uff7d\ufffd\uff79\uff87\uff9a\uff93okyVeGl\u0003",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x64, 0x41, 0x63, 0x67, 0x26, 0x75 };
            Assert.AreEqual (
             "dAcg&u",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x3a, 0x1b, 0x28, 0x42, 0x63, 0x1b, 0x28, 0x48, 0x40, 0x2b, 0x7a, 0x27, 0x67, 0x35, 0x78, 0x60, 0x54, 0x25, 0x27, 0x1b, 0x28, 0x49, 0x37, 0x36, 0x1b, 0x24, 0x40, 0x2e, 0x36 };
            Assert.AreEqual (
             ":c\ufffdH(@+z'g5x`T%'\uff77\uff76\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x49, 0x76, 0x61, 0x25, 0x1b, 0x24, 0x40, 0x63, 0x79, 0x20, 0x34, 0x2c, 0x1b, 0x24, 0x40, 0x4e, 0x4a, 0x68, 0x1b, 0x28, 0x42, 0x46, 0x7d, 0x61, 0x3f, 0x7e, 0x2f, 0x59, 0x66, 0x6c, 0x2f, 0x2b, 0x34, 0x3c, 0x72, 0x25 };
            Assert.AreEqual (
             "\ufffd\ufffd\uff65\u7b19\ufffd\u5dfb\u8ad2\ufffdF}a?~/Yfl/+4<r%",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x30, 0x46, 0x4a, 0x23, 0x46, 0x19, 0x26, 0x20, 0x7c, 0x4d, 0x30, 0x6a };
            Assert.AreEqual (
             "0FJ#F\u0019& |M0j",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x4d, 0x71, 0x3b, 0x7b, 0x5b, 0x1b, 0x24, 0x42, 0x1b, 0x24, 0x40, 0x61, 0x1b, 0x28, 0x42, 0x1b, 0x28, 0x48, 0x3e, 0x50, 0x2a, 0x79 };
            Assert.AreEqual (
             "Mq;{[\ufffd\ufffd\ufffdH(>P*y",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x48, 0x5b };
            Assert.AreEqual (
             "\ufffdH([",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x3f, 0x74, 0x74, 0x3e, 0x4d, 0x3a, 0x54, 0x37, 0x6c, 0x4b, 0x1b, 0x28, 0x48, 0x48, 0x72, 0x73, 0x35, 0x73, 0x5f, 0x6f, 0x47, 0x2b, 0x50, 0x62, 0x28 };
            Assert.AreEqual (
             "?tt>M:T7lK\ufffdH(Hrs5s_oG+Pb(",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x71, 0x1b, 0x28, 0x49, 0x50, 0x1b, 0x24, 0x40, 0x26, 0x1b, 0x28, 0x42, 0x3a, 0x05, 0x65, 0x47, 0x71, 0x46, 0x69, 0x5f, 0x42, 0x46, 0x7c, 0x1b, 0x28, 0x42, 0x09, 0x57, 0x29, 0x2e, 0x6d, 0x1b, 0x28, 0x49, 0x29, 0x7a };
            Assert.AreEqual (
             "q\uff90\ufffd:\u0005eGqFi_BF|\u0009W).m\uff69\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x23, 0x7d, 0x3e, 0x52, 0x2d, 0x7c, 0x73, 0x6d, 0x58, 0x2a, 0x27, 0x1a };
            Assert.AreEqual (
             "#}>R-|smX*'\u001a",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x35, 0x40, 0x24, 0x77, 0x43, 0x45, 0x76, 0x63, 0x1b, 0x28, 0x49, 0x35, 0x2e, 0x21, 0x06, 0x24, 0x1f, 0x3d, 0x45, 0x5d, 0x21, 0x70, 0x70, 0x31, 0x33, 0x3d, 0x4c, 0x4b };
            Assert.AreEqual (
             "\u7947\ufffd\u58c7\ufffd\uff75\uff6e\uff61\ufffd\uff64\ufffd\uff7d\uff85\uff9d\uff61\ufffd\ufffd\uff71\uff73\uff7d\uff8c\uff8b",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x57, 0x20, 0x28, 0x1b, 0x24, 0x42, 0x48, 0x27, 0x58, 0x7c, 0x21, 0x79, 0x67 };
            Assert.AreEqual (
             "W (\u6ae8\u620c\u2606\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x49, 0x61, 0x62, 0x25, 0x3d, 0x20, 0x1b, 0x28, 0x49, 0x23, 0x53, 0x59, 0x5d, 0x57, 0x77, 0x62, 0x38, 0x21, 0x60, 0x73, 0x52 };
            Assert.AreEqual (
             "\ufffd\ufffd\uff65\uff7d\ufffd\uff63\uff93\uff99\uff9d\uff97\ufffd\ufffd\uff78\uff61\ufffd\ufffd\uff92",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x1b, 0x28, 0x49, 0x5c, 0x1b, 0x24, 0x40, 0x1b, 0x28, 0x48, 0x39, 0x30 };
            Assert.AreEqual (
             "\ufffd\uff9c\ufffd\u5e61\u5f18",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x4f, 0x54, 0x59 };
            Assert.AreEqual (
             "OTY",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x24, 0x40, 0x62, 0x3b, 0x4c, 0x21, 0x48, 0x75, 0x57 };
            Assert.AreEqual (
             "\u76ea\u6f2b\u6a0b\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x24, 0x40, 0x31, 0x69, 0x3a, 0x2b, 0x49, 0x5e, 0x47, 0x42, 0x19, 0x77, 0x76, 0x50, 0x67 };
            Assert.AreEqual (
             "\u6f14\u6606\u6276\u86a4\ufffd\ufffd\u4f1c",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x29, 0x29, 0x46, 0x62, 0x70 };
            Assert.AreEqual (
             "))Fbp",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x4c, 0x6c, 0x3a, 0x31, 0x20, 0x62, 0x68, 0x3c, 0x27, 0x2f, 0x2e, 0x21, 0x70, 0x7b, 0x61, 0x60, 0x4c, 0x58 };
            Assert.AreEqual (
             "Ll:1 bh<'/.!p{a`LX",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x48, 0x3b, 0x6f, 0x29, 0x4f, 0x2b, 0x21 };
            Assert.AreEqual (
             "\ufffdH(;o)O+!",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x22, 0x60, 0x33, 0x3d, 0x35, 0x70 };
            Assert.AreEqual (
             "\u2207\u6d6c\u5de8",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x75, 0x27, 0x7a, 0x74, 0x29, 0x75, 0x74, 0x7b };
            Assert.AreEqual (
             "u'zt)ut{",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x48, 0x76, 0x64, 0x1b, 0x24, 0x42, 0x2c, 0x40, 0x53, 0x54, 0x35, 0x67, 0x1b, 0x28, 0x48, 0x3c, 0x49, 0x04, 0x58, 0x73, 0x27, 0x53, 0x31, 0x1b, 0x28, 0x48, 0x1b, 0x28, 0x42, 0x7b, 0x5e, 0x1b, 0x28, 0x42 };
            Assert.AreEqual (
             "\ufffdH(vd\ufffd\u5616\u7aae\ufffd\u5e61\u854a\ufffd\u61f4\u0432\ufffd\ufffd\u5e61{^",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x2a, 0x68, 0x36, 0x46, 0x7e, 0x77, 0x72, 0x72, 0x49, 0x6c, 0x43, 0x7e, 0x59, 0x57, 0x73, 0x62 };
            Assert.AreEqual (
             "*h6F~wrrIlC~YWsb",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x46 };
            Assert.AreEqual (
             "F",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x76, 0x35, 0x51, 0x22, 0x2d, 0x29, 0x5d, 0x73, 0x3d, 0x47, 0x1b, 0x28, 0x48, 0x3e, 0x3d, 0x54, 0x79, 0x1b, 0x24, 0x40, 0x41, 0x1b, 0x24, 0x40, 0x7a, 0x32, 0x44, 0x22, 0x66, 0x51, 0x5f, 0x7c, 0x53 };
            Assert.AreEqual (
             "v5Q\"-)]s=G\ufffdH(>=Ty\ufffd\u64ce\u5e33\u8018\u71e7\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x42, 0x36, 0x3f, 0x22, 0x72, 0x1b, 0x28, 0x49, 0x58, 0x1b, 0x28, 0x49 };
            Assert.AreEqual (
             "6?\"r\uff98",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x6d, 0x2c, 0x65, 0x56, 0x1b, 0x75, 0x1b, 0x24, 0x40, 0x20, 0x1b, 0x28, 0x49 };
            Assert.AreEqual (
             "m,eV\ufffdu\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x7b, 0x2a, 0x1b, 0x24, 0x42, 0x54, 0x50, 0x4c, 0x5e, 0x1b, 0x24, 0x42, 0x1b, 0x28, 0x48, 0x1b, 0x24, 0x42, 0x45, 0x2b, 0x5a, 0x70, 0x3c, 0x61, 0x55, 0x38, 0x5d, 0x24, 0x48, 0x77, 0x66, 0x77, 0x4b };
            Assert.AreEqual (
             "{*\u5885\u52ff\ufffd\u5e61\u7b1b\u665f\u91c8\u5a36\u6ac3\u5099\u8109\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x4f, 0x6a, 0x76, 0x70, 0x4b, 0x65, 0x68, 0x67, 0x4e, 0x25 };
            Assert.AreEqual (
             "OjvpKehgN%",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x67, 0x60, 0x46, 0x1b, 0x28, 0x48, 0x1b, 0x28, 0x42, 0x5d, 0x30, 0x7e, 0x73, 0x3b, 0x26, 0x7e, 0x57, 0x1b, 0x28, 0x49, 0x4c, 0x4c, 0x61, 0x6f, 0x5a, 0x30 };
            Assert.AreEqual (
             "g`F\ufffdH(]0~s;&~W\uff8c\uff8c\ufffd\ufffd\uff9a\uff70",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x56, 0x7e, 0x32, 0x3e, 0x3a, 0x42, 0x1b, 0x24, 0x42, 0x1b, 0x28, 0x42, 0x1b, 0x28, 0x48, 0x1b, 0x28, 0x49, 0x78, 0x43, 0x36, 0x2d, 0x35, 0x79, 0x73, 0x30, 0x37, 0x5b, 0x0f, 0x1b, 0x24, 0x42, 0x30, 0x63, 0x1b, 0x1b, 0x24, 0x42 };
            Assert.AreEqual (
             "V~2>:B\ufffd\ufffdH(\ufffd\uff83\uff76\uff6d\uff75\ufffd\ufffd\uff70\uff77\uff9b\ufffd\u9055\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x48, 0x1b, 0x28, 0x42, 0x1b, 0x28, 0x42, 0x6c, 0x2e, 0x31, 0x32, 0x60, 0x37, 0x72, 0x27, 0x22, 0x52, 0x7a, 0x28, 0x56, 0x4c, 0x5c };
            Assert.AreEqual (
             "\ufffdH(\ufffdl.12`7r'\"Rz(VL\\",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x66, 0x35, 0x5c, 0x1b, 0x24, 0x40, 0x6b, 0x48, 0x64, 0x30, 0x24, 0x27, 0x5a, 0x64, 0x63, 0x69, 0x4d, 0x5d, 0x6b, 0x43, 0x50, 0x1b, 0x24, 0x42, 0x2d, 0x2e, 0x4c, 0x38 };
            Assert.AreEqual (
             "f5\\\u8a52\u7b98\u3047\u6636\u7ad5\u617e\u8a1d\ufffd\u246d\u9727",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x6c, 0x6a, 0x5b, 0x44, 0x1b, 0x28, 0x42, 0x53, 0x22, 0x46, 0x27, 0x3c, 0x77, 0x63, 0x67, 0x1b, 0x28, 0x42, 0x3a, 0x50, 0x6d, 0x3f, 0x63 };
            Assert.AreEqual (
             "lj[DS\"F'<wcg:Pm?c",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x26, 0x46, 0x3c, 0x77, 0x36, 0x43, 0x7a, 0x6f, 0x29, 0x58, 0x1b, 0x28, 0x42, 0x4f, 0x71, 0x7e, 0x42 };
            Assert.AreEqual (
             "&F<w6Czo)XOq~B",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x48, 0x3d, 0x5f, 0x52, 0x52, 0x5e, 0x77, 0x30, 0x6a, 0x3a, 0x50, 0x2e, 0x34, 0x4f, 0x21, 0x71, 0x1b, 0x24, 0x42, 0x45, 0x25, 0x63 };
            Assert.AreEqual (
             "\ufffdH(=_RR^w0j:P.4O!q\u6ce5\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x42, 0x4f, 0x21, 0x52, 0x6e, 0x44, 0x3e, 0x3a, 0x6c, 0x5d, 0x49, 0x51, 0x53, 0x49, 0x26, 0x1b, 0x28, 0x48, 0x1b, 0x24, 0x42, 0x58, 0x46, 0x6f, 0x72, 0x6c, 0x65, 0x4a, 0x1b, 0x28, 0x48, 0x24, 0x1b, 0x28, 0x49, 0x35, 0x43, 0x5a };
            Assert.AreEqual (
             "O!RnD>:l]IQSI&\ufffdH(\u613c\u95e5\u8dc2\ufffd\ufffd\u5e61\ufffd\uff75\uff83\uff9a",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x3a, 0x26, 0x28 };
            Assert.AreEqual (
             ":&(",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x57, 0x26, 0x61, 0x34, 0x48, 0x3f, 0x5e, 0x1b, 0x28, 0x42, 0x41, 0x41, 0x52, 0x2f, 0x1b, 0x24, 0x40, 0x55, 0x34, 0x41, 0x5a, 0x3f, 0x4e, 0x55, 0x73, 0x4f, 0x1a, 0x01, 0x4d, 0x1b, 0x28, 0x49 };
            Assert.AreEqual (
             "W&a4H?^AAR/\u5a40\u60e3\u4ec1\u5c08\ufffd\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x49, 0x5a, 0x78, 0x2b, 0x31, 0x15, 0x3d, 0x21, 0x1b, 0x24, 0x40, 0x63, 0x5e, 0x73, 0x77, 0x49, 0x4f, 0x45, 0x38, 0x17, 0x49, 0x1b, 0x28, 0x48, 0x40, 0x4a, 0x28, 0x67, 0x5b, 0x41, 0x78, 0x53 };
            Assert.AreEqual (
             "\uff9a\ufffd\uff6b\uff71\ufffd\uff7d\uff61\u7ac8\u9f6c\u8ca7\u5c55\ufffd\ufffd\ufffd\u5e61\u5e2d\ufffd\u677c\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x48, 0x56, 0x46, 0x2e, 0x4e, 0x68, 0x25, 0x2d, 0x22, 0x4a, 0x41, 0x49, 0x47, 0x26, 0x6e, 0x6a, 0x1b, 0x28, 0x42, 0x63, 0x3f, 0x61, 0x5d };
            Assert.AreEqual (
             "\ufffdH(VF.Nh%-\"JAIG&njc?a]",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x42, 0x28, 0x27, 0x75, 0x35 };
            Assert.AreEqual (
             "('u5",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x75, 0x27, 0x53, 0x75, 0x59, 0x6b, 0x3a, 0x6a, 0x2d, 0x6b, 0x67, 0x1b, 0x24, 0x40, 0x7e, 0x1b, 0x28, 0x42, 0x33, 0x27, 0x3b, 0x5e, 0x49, 0x24, 0x1b, 0x28, 0x42, 0x63, 0x4e, 0x7b, 0x0f, 0x62 };
            Assert.AreEqual (
             "u'SuYk:j-kg\ufffd3';^I$cN{\ufffdb",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x5f };
            Assert.AreEqual (
             "_",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x46, 0x55 };
            Assert.AreEqual (
             "FU",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x52, 0x4e, 0x1b, 0x28, 0x42 };
            Assert.AreEqual (
             "RN",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x30, 0x34, 0x7c, 0x0b, 0x7b, 0x35, 0x1b, 0x24, 0x40, 0x58, 0x3a, 0x47, 0x1b, 0x28, 0x48, 0x35, 0x27, 0x57, 0x6f, 0x1b, 0x24, 0x40, 0x28, 0x25, 0x29, 0x25, 0x39, 0x6b, 0x44, 0x1b, 0x24, 0x42, 0x6a, 0x07, 0x1b, 0x28, 0x49, 0x70 };
            Assert.AreEqual (
             "04|\u000b{5\u6103\ufffd\ufffd\u5e61\u7948\u605f\u2518\ufffd\u8c6a\ufffd\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x42, 0x27, 0x32, 0x2f, 0x4d, 0x78, 0x67, 0x4b, 0x40, 0x23, 0x62, 0x65, 0x1b, 0x24, 0x42, 0x21, 0x29, 0x39, 0x2c, 0x78, 0x52, 0x28 };
            Assert.AreEqual (
             "'2/MxgK@#be\uff1f\u5e78\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x64, 0x33, 0x22, 0x1b, 0x24, 0x42, 0x35, 0x57, 0x44, 0x24, 0x4d, 0x60, 0x2b };
            Assert.AreEqual (
             "d3\"\u4e45\u5f14\u6c83\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x55, 0x5d, 0x44, 0x3d, 0x2d, 0x1b, 0x24, 0x40, 0x2f, 0x5c };
            Assert.AreEqual (
             "U]D=-\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x6a, 0x20, 0x26 };
            Assert.AreEqual (
             "j &",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x3e, 0x4a };
            Assert.AreEqual (
             ">J",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x7d, 0x73, 0x43, 0x57, 0x36, 0x7e, 0x53, 0x4b, 0x35, 0x6e, 0x7d, 0x1b, 0x24, 0x42, 0x1b, 0x28, 0x49, 0x44, 0x3e, 0x6e, 0x77, 0x76, 0x1b, 0x28, 0x48 };
            Assert.AreEqual (
             "}sCW6~SK5n}\ufffd\uff84\uff7e\ufffd\ufffd\ufffd\ufffd\uff88\uff68",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x2b, 0x66, 0x3b, 0x2c, 0x6a, 0x02, 0x35, 0x1b, 0x28, 0x49, 0x64, 0x6e, 0x7e, 0x5c, 0x1b, 0x28, 0x42, 0x71, 0x2c, 0x7d };
            Assert.AreEqual (
             "+f;,j\u00025\ufffd\ufffd\ufffd\uff9cq,}",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x48, 0x5a, 0x70, 0x25, 0x40, 0x5a, 0x38, 0x66, 0x4d, 0x40, 0x47, 0x3b, 0x56, 0x7d };
            Assert.AreEqual (
             "\ufffdH(Zp%@Z8fM@G;V}",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x42, 0x1b, 0x28, 0x49, 0x22, 0x4e, 0x6d, 0x7b, 0x79, 0x55, 0x5a, 0x4f, 0x6e, 0x69, 0x25, 0x13, 0x29, 0x79, 0x1b, 0x28, 0x48 };
            Assert.AreEqual (
             "B\uff62\uff8e\ufffd\ufffd\ufffd\uff95\uff9a\uff8f\ufffd\ufffd\uff65\ufffd\uff69\ufffd\ufffd\uff88\uff68",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x7e, 0x1a, 0x7b, 0x1b, 0x28, 0x49, 0x3c, 0x73, 0x1b, 0x24, 0x42, 0x3f, 0x4d, 0x56, 0x47, 0x6f, 0x2e, 0x76, 0x7e, 0x39, 0x37, 0x4b, 0x3f, 0x24, 0x2c, 0x3f, 0x41, 0x75, 0x53, 0x40 };
            Assert.AreEqual (
             "\ufffd\ufffd\uff7c\ufffd\u4eba\u5d18\u93ac\ufffd\u6602\u67d0\u304c\u79e6\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x5b, 0x37 };
            Assert.AreEqual (
             "[7",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x36, 0x51, 0x2f, 0x66, 0x2b, 0x47 };
            Assert.AreEqual (
             "6Q/f+G",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x6e, 0x5d, 0x1b, 0x28, 0x42, 0x1b, 0x24, 0x40, 0x2b, 0x7b, 0x4d, 0x3e, 0x2c, 0x1b, 0x24, 0x42 };
            Assert.AreEqual (
             "n]\ufffd\ufffd\u4f59\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x24, 0x40, 0x44, 0x2a, 0x3f, 0x79, 0x24, 0x31, 0x5f, 0x2f, 0x32, 0x69, 0x3b, 0x5b, 0x1b, 0x24, 0x42, 0x53, 0x3a, 0x21, 0x65, 0x3f, 0x6a, 0x7d, 0x2e, 0x4e, 0x64, 0x54, 0x76 };
            Assert.AreEqual (
             "\u66a2\u6749\u3051\u6f58\u81e5\u65af\u5533\u2266\u8870\ufffd\u51b7\u5950",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x49 };
            Assert.AreEqual (
             "",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x24, 0x40, 0x25, 0x6f, 0x61, 0x26, 0x50, 0x4c, 0x28, 0x4d, 0x3b, 0x54, 0x54, 0x3e, 0x79, 0x2f };
            Assert.AreEqual (
             "\u30ef\u74f2\u4f88\ufffd\u5e02\u57d4\u4efc",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x43, 0x03, 0x14 };
            Assert.AreEqual (
             "C\u0003\u0014",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x7e, 0x20, 0x1b, 0x28, 0x48, 0x46, 0x1b, 0x28, 0x42, 0x4a, 0x15, 0x2e, 0x3b, 0x5b, 0x54, 0x63 };
            Assert.AreEqual (
             "~ \ufffdH(FJ\u0015.;[Tc",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x52, 0x54, 0x44, 0x6e, 0x21, 0x2c, 0x07, 0x7c, 0x38, 0x74, 0x70, 0x3b, 0x6f, 0x47, 0x3c, 0x3c, 0x51, 0x4a, 0x56, 0x1b, 0x24, 0x42, 0x55, 0x2b, 0x1b, 0x28, 0x48, 0x57, 0x4a, 0x4b, 0x42, 0x61, 0x6c };
            Assert.AreEqual (
             "RTDn!,\u0007|8tp;oG<<QJV\u598d\ufffd\u5e61\u5f7f\u7d21\u7621",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x69, 0x47, 0x67, 0x6d, 0x3e, 0x6c, 0x3e, 0x4e, 0x16 };
            Assert.AreEqual (
             "iGgm>l>N\u0016",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x79, 0x5e, 0x3d, 0x2d, 0x31, 0x78, 0x3b, 0x22, 0x77, 0x39, 0x66, 0x7d, 0x45, 0x40, 0x25, 0x67, 0x45, 0x63, 0x53 };
            Assert.AreEqual (
             "y^=-1x;\"w9f}E@%gEcS",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x6b, 0x4a, 0x2c, 0x68, 0x5b };
            Assert.AreEqual (
             "\u8a48\ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x2d, 0x77, 0x6c, 0x5c, 0x34, 0x60, 0x30, 0x52, 0x5b, 0x40, 0x1b, 0x28, 0x48, 0x5c, 0x37, 0x28, 0x59, 0x39, 0x77, 0x4a, 0x75, 0x37, 0x30, 0x59, 0x5c, 0x73, 0x20, 0x1b, 0x24, 0x42, 0x25, 0x0a, 0x28 };
            Assert.AreEqual (
             "-wl\\4`0R[@\ufffdH(\\7(Y9wJu70Y\\s \ufffd\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x43, 0x7c, 0x37, 0x71, 0x27, 0x6a, 0x34, 0x1d, 0x46, 0x77, 0x56, 0x38, 0x2c, 0x7c, 0x36, 0x25, 0x52, 0x4c, 0x6f, 0x26, 0x7b, 0x5a };
            Assert.AreEqual (
             "\u51cb\u5026\u0448\ufffd\u5302\u5cfa\ufffd\u7af6\u5382\u9335\u83c7",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x1b, 0x28, 0x42, 0x3a, 0x7c, 0x56, 0x61, 0x27, 0x3e, 0x74, 0x2f, 0x1b, 0x24, 0x42, 0x79, 0x44, 0x75, 0x2d, 0x69, 0x6a, 0x52, 0x7b, 0x25, 0x7d, 0x1b, 0x28, 0x48, 0x1b, 0x24, 0x42, 0x68 };
            Assert.AreEqual (
             ":|Va'>t/\u5164\ufffd\u8709\u54ac\ufffd\ufffd\u5e61\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x78, 0x5e, 0x74 };
            Assert.AreEqual (
             "x^t",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x60, 0x75, 0x1b, 0x24, 0x40, 0x5e, 0x60, 0x63, 0x5e, 0x48, 0x1b, 0x28, 0x48, 0x33, 0x6e, 0x45, 0x30, 0x7c, 0x22, 0x6f, 0x6e, 0x4c, 0x3b, 0x7c };
            Assert.AreEqual (
             "`u\u6eff\u7ac8\ufffd\ufffd\u5e61\u4e14\u5fb9\u91de\u95d4\u5a7f\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x66, 0x71, 0x50, 0x6b };
            Assert.AreEqual (
             "fqPk",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x2e, 0x58, 0x7c, 0x4b, 0x34, 0x69, 0x29, 0x1b, 0x24, 0x42, 0x67, 0x78, 0x7c, 0x4f, 0x66, 0x64 };
            Assert.AreEqual (
             ".X|K4i)\u82fb\uf9dc\u8079",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x7c, 0x2e, 0x70, 0x2c, 0x52, 0x1b, 0x24, 0x42, 0x2d, 0x51, 0x40, 0x3b, 0x21, 0x58, 0x65, 0x2e, 0x21, 0x41, 0x4a, 0x75, 0x6a, 0x32, 0x36 };
            Assert.AreEqual (
             "|.p,R\u339d\u8056\u300e\u7d4e\uff5e\u5b9d\u87c6\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x28, 0x67, 0x34, 0x3c, 0x30, 0x3f };
            Assert.AreEqual (
             "(g4<0?",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x23, 0x28, 0x1b, 0x24, 0x40, 0x58, 0x53, 0x5a, 0x62, 0x1b, 0x28, 0x48, 0x7a, 0x1b, 0x28, 0x48, 0x75, 0x7d, 0x48, 0x5e };
            Assert.AreEqual (
             "#(\u616f\u6773\ufffd\u5e61\ufffd\ufffd\u5e61\ufffd\u5983",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x4f, 0x47, 0x5d, 0x65, 0x6b, 0x1b, 0x28, 0x42, 0x3d, 0x1b, 0x28, 0x42, 0x3e, 0x1b, 0x28, 0x49, 0x31 };
            Assert.AreEqual (
             "OG]ek=>\uff71",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x27, 0x7e, 0x69, 0x33, 0x54, 0x27, 0x43 };
            Assert.AreEqual (
             "'~i3T'C",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x73, 0x4c, 0x50, 0x70, 0x41, 0x63, 0x1b, 0x28, 0x42, 0x75, 0x1b, 0x28, 0x42, 0x60 };
            Assert.AreEqual (
             "sLPpAcu`",
             Encodings.DecodeToString (charset, bytes));
        }

    [Test]
    public void TestIso2022JPEncodeSpecific ()
    {
      byte [] bytes;
      string str;
      ICharacterEncoding charset = Encodings.GetEncoding ("iso-2022-jp");
            str = "\uff13";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x33, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff0b\uff44\u5916\u68ad";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x21, 0x5c, 0x23, 0x64, 0x33, 0x30, 0x5b, 0x68, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u4e8a";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x50, 0x2f, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff41\uff47\u5bc9\u6b79";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x61, 0x23, 0x67, 0x55, 0x65, 0x5d, 0x46, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u7960";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x63, 0x2c, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u714c\u7f47\u6753";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x5f, 0x6a, 0x7b, 0x54, 0x3c, 0x5d, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u578b";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x37, 0x3f, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u9b6f";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x4f, 0x25, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u6cd3\u7a0d\u7926";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x5d, 0x77, 0x63, 0x44, 0x62, 0x68, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u7911";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x63, 0x27, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff97\u76c8\u2533";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x25, 0x69, 0x31, 0x4e, 0x28, 0x33, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u7ae7\u9076";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x7b, 0x49, 0x6e, 0x2d, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff4b\u727d\u679d";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x6b, 0x38, 0x23, 0x3b, 0x5e, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u5680\u60b8\uff4b\u69bf\u55fe";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x53, 0x66, 0x58, 0x29, 0x23, 0x6b, 0x5c, 0x48, 0x53, 0x55, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u595d\u72be\u7b1e\uff8e\u755d";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x79, 0x66, 0x7b, 0x21, 0x63, 0x7a, 0x25, 0x5b, 0x40, 0x26, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u6f54\uff64\u5ef0";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x37, 0x69, 0x21, 0x22, 0x57, 0x2d, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u5e72\u5712";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x34, 0x33, 0x31, 0x60, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u6adb\uff4b\uff6b\u708e";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x36, 0x7b, 0x23, 0x6b, 0x25, 0x29, 0x31, 0x6a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff3d\u5eec\uff18";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x21, 0x4f, 0x57, 0x2a, 0x23, 0x38, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff7a\uffe5\uff3f";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x25, 0x33, 0x21, 0x6f, 0x21, 0x32, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff57\uff43";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x77, 0x23, 0x63, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u7ad2\uff98\u600e";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x54, 0x74, 0x25, 0x6a, 0x57, 0x63, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff5d\u7ddd\uffe3";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x21, 0x51, 0x65, 0x49, 0x21, 0x31, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u6e2c\u670e";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x42, 0x2c, 0x7a, 0x45, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u769a\u5230\uff78\u7ae7";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x62, 0x2d, 0x45, 0x7e, 0x25, 0x2f, 0x7b, 0x49, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u69eb";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x5c, 0x67, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u52c3\uff4a";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x4b, 0x56, 0x23, 0x6a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff1b\uff4d@";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x21, 0x28, 0x23, 0x6d, 0x1b, 0x28, 0x42, 0x40 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u62ee";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x59, 0x49, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u66c4\u977c\uff0c";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x5b, 0x21, 0x70, 0x5a, 0x21, 0x24, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u2169\u98c6\uff38";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x2d, 0x3e, 0x71, 0x2a, 0x23, 0x58, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u7d20\u5993\u6bbb\u6063\u7537";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x41, 0x47, 0x35, 0x38, 0x33, 0x4c, 0x57, 0x73, 0x43, 0x4b, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff67";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x25, 0x21, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff6d\uff22";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x25, 0x65, 0x23, 0x42, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff0e";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x21, 0x25, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u727d\u676a";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x38, 0x23, 0x5b, 0x42, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff14\u6545\uff4a";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x34, 0x38, 0x4e, 0x23, 0x6a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff64\u25bd\u501a";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x21, 0x22, 0x22, 0x26, 0x50, 0x61, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff37\u2193\uff2a";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x57, 0x22, 0x2d, 0x23, 0x4a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u745e\uff05\u78c5";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x3f, 0x70, 0x21, 0x73, 0x62, 0x7c, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u6ac3";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x5d, 0x24, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u6955\u8aa6\u5177\u5c8c";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x42, 0x4a, 0x6b, 0x56, 0x36, 0x71, 0x56, 0x29, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u7e9c\u5f15";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x65, 0x7c, 0x30, 0x7a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff2c";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x4c, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u5fcc\uff38\u76de";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x34, 0x77, 0x23, 0x58, 0x62, 0x37, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u58be\u2463";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x3a, 0x26, 0x2d, 0x24, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff3e\uff06";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x21, 0x30, 0x21, 0x75, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u6731\uff02\uff42";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x3c, 0x6b, 0x7c, 0x7e, 0x23, 0x62, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u6631\u58ab";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x79, 0x28, 0x54, 0x53, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff19\u53c2";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x39, 0x3b, 0x32, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u507d\uff19";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x35, 0x36, 0x23, 0x39, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u79d8\u2461\uff6c\uff36";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x48, 0x6b, 0x2d, 0x22, 0x25, 0x63, 0x23, 0x56, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u7693";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x62, 0x2b, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u66e0z";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x5b, 0x25, 0x1b, 0x28, 0x42, 0x7a };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff22\u7bad\u7cad";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x42, 0x40, 0x7d, 0x64, 0x66, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u8098\uff3b\u5b66";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x49, 0x2a, 0x21, 0x4e, 0x33, 0x58, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u732f";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x60, 0x4e, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u68da\uff76";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x43, 0x2a, 0x25, 0x2b, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff82\uff07\uff4a";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x25, 0x44, 0x7c, 0x7d, 0x23, 0x6a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff8c\uff45\uff07\uff8a\uff09\uff17\u5d42";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x25, 0x55, 0x23, 0x65, 0x7c, 0x7d, 0x25, 0x4f, 0x21, 0x4b, 0x23, 0x37, 0x79, 0x76, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff4e\uff25\u66dd";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x6e, 0x23, 0x45, 0x47, 0x78, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u6f80\u2021\u68ee";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x5f, 0x28, 0x22, 0x78, 0x3f, 0x39, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u3003\u212b\u7bb1\u72e2";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x21, 0x37, 0x22, 0x72, 0x48, 0x22, 0x60, 0x42, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff8c\uff16\u66d9";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x25, 0x55, 0x23, 0x36, 0x3d, 0x6c, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u6cb3\uff66";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x32, 0x4f, 0x25, 0x72, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u64fe\u5c76\u76fb";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x3e, 0x71, 0x56, 0x27, 0x62, 0x3d, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u6b98";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x5d, 0x4c, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u5dfd";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x43, 0x27, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff8f\u76f2";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x25, 0x5e, 0x4c, 0x55, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff0a\u6176";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x21, 0x76, 0x37, 0x44, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u2503\uff98\u5289";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x28, 0x2d, 0x25, 0x6a, 0x4e, 0x2d, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u7b54\uff6a\u72fc";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x45, 0x7a, 0x25, 0x27, 0x4f, 0x35, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff44";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x64, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u7d1b";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x4a, 0x36, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff14\u5bb9";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x34, 0x4d, 0x46, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff24";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x44, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u7b2c\u5538\uff01";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x42, 0x68, 0x53, 0x39, 0x21, 0x2a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff80\uff5e\u0013";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x25, 0x3f, 0x21, 0x41, 0x1b, 0x28, 0x42, 0x13 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u8a36\u7b02\u66da";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x6b, 0x45, 0x63, 0x73, 0x5b, 0x24, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u5f83\u2030\u7188";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x57, 0x48, 0x22, 0x73, 0x5f, 0x67, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff4b\uff69";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x6b, 0x25, 0x25, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u7cc2";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x64, 0x73, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff7b\u6f41\u68b0\uff95";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x25, 0x35, 0x5e, 0x73, 0x33, 0x23, 0x25, 0x66, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u7634";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x61, 0x6f, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff57";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x77, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uffe2\u708e\uff15";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x22, 0x4c, 0x31, 0x6a, 0x23, 0x35, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u5efe\u6848\u2179";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x57, 0x30, 0x30, 0x46, 0x7c, 0x7a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff57";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x77, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff34\u8d07\u7e43";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x54, 0x6c, 0x56, 0x65, 0x5e, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff9d\u5c79\u2473";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x25, 0x73, 0x56, 0x28, 0x2d, 0x34, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u6850";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x36, 0x4d, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u79c1\u5a49\u5bd3";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x3b, 0x64, 0x55, 0x36, 0x36, 0x77, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff2e\u59ea\uff2f";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x4e, 0x4c, 0x45, 0x23, 0x4f, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff14\u5f6a\uff3d";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x34, 0x49, 0x37, 0x21, 0x4f, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u62db\u63c9";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x3e, 0x37, 0x59, 0x66, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff14";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x34, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\uff56\u5dee\u7368";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x23, 0x76, 0x3a, 0x39, 0x60, 0x57, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u509a";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x50, 0x7b, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u6426";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x59, 0x6e, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
            str = "\u50cf\uff48\u57ac";
            bytes = new byte [] { 0x1b, 0x24, 0x42, 0x41, 0x7c, 0x23, 0x68, 0x79, 0x5c, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual (
            bytes,
             Encodings.EncodeToBytes (str, charset));
        }
        [Test]
        public void TestEucJP ()
        {
            byte [] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding ("euc-jp");
            bytes = new byte [] { 0x8e };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "\ufffd",
                stringTemp);
            }
            bytes = new byte [] { 0x8e, 0x21 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "\ufffd!",
                stringTemp);
            }
            bytes = new byte [] { 0x8e, 0x8e, 0xa1 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "\ufffd\ufffd",
                stringTemp);
            }
            bytes = new byte [] { 0x8f };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd",
                  stringTemp);
            }
            bytes = new byte [] { 0x8f, 0x21 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd!",
                  stringTemp);
            }
            bytes = new byte [] { 0x8f, 0xa1 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd",
                  stringTemp);
            }
            bytes = new byte [] { 0x8f, 0xa1, 0x21 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd!",
                  stringTemp);
            }
            bytes = new byte [] { 0x90 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd",
                  stringTemp);
            }
            bytes = new byte [] { 0x90, 0x21 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd!",
                  stringTemp);
            }
            bytes = new byte [] { 0xa1 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd",
                  stringTemp);
            }
            bytes = new byte [] { 0xa1, 0xa1 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\u3000",
                  stringTemp);
            }
            bytes = new byte [] { 0x90, 0xa1, 0xa1 };
            {
                string stringTemp = Encodings.DecodeToString (
                  charset,
                  bytes);
                Assert.AreEqual (
                  "\ufffd\u3000",
                  stringTemp);
            }
            bytes = new byte [] { 0x90, 0xa1, 0xa1, 0xa1 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                "\ufffd\u3000\ufffd",
                stringTemp);
            }
            bytes = new byte [] { 0xa1, 0x21 };
            {
                string stringTemp = Encodings.DecodeToString (charset, bytes);
                Assert.AreEqual (
                  "\ufffd!",
                  stringTemp);
            }
            string result;
            bytes = new byte [] { 0x15, 0xf2, 0xbf, 0xdd, 0xd7, 0x13, 0xeb, 0xcf,
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

            Assert.AreEqual (result, Encodings.DecodeToString (charset, bytes));
        }

        public static void TestSingleByteRoundTrip (string name)
        {
            TestSingleByteRoundTrip (Encodings.GetEncoding (name, true));
        }

        public static void TestSingleByteRoundTrip (ICharacterEncoding enc)
        {
            var codepoints = new int [256];
            var codesrc = new int [256];
            ICharacterEncoder encoder = enc.GetEncoder ();
            ICharacterDecoder decoder = enc.GetDecoder ();
            var codetotal = 0;
            var bytes = new byte [256];
            for (var i = 0; i < 256; ++i) {
                bytes [i] = (byte)i;
            }
            IByteReader ib = DataIO.ToReader (bytes);
            for (var i = 0; i < 256; ++i) {
                int c = decoder.ReadChar (ib);
                if (c == -1) {
                    Assert.Fail ();
                }
                if (c != -2) {
                    codepoints [codetotal] = c;
                    codesrc [codetotal] = i;
                    ++codetotal;
                }
            }
            var aw = new ArrayWriter ();
            for (var i = 0; i < codetotal; ++i) {
                int c = encoder.Encode (codepoints [i], aw);
                if (c < 0) {
                    Assert.Fail ();
                }
            }
            bytes = aw.ToArray ();
            for (var i = 0; i < codetotal; ++i) {
                int b = ((int)bytes [i]) & 0xff;
                if (b != codesrc [i]) {
                    Assert.AreEqual (codesrc [i], b);
                }
            }
        }

        [Test]
        public void TestCodePages ()
        {
            for (var j = 0; j < this.valueSingleByteNames.Length; ++j) {
                ICharacterEncoding enc = Encodings.GetEncoding (this.valueSingleByteNames [j]);
                ICharacterDecoder dec = enc.GetDecoder ();
                var bytes = new byte [256];
                var ints = new int [256];
                var count = 0;
                for (var i = 0; i < 256; ++i) {
                    bytes [i] = (byte)i;
                }
                IByteReader reader = DataIO.ToReader (bytes);
                for (var i = 0; i < 256; ++i) {
                    ints [i] = dec.ReadChar (reader);
                    if (ints [i] >= 0) {
                        ++count;
                    }
                }
                if (count != 256) {
                    continue;
                }
                var builder = new StringBuilder ();
                builder.Append ("CODEPAGE 1\nCPINFO 1 0x3f 0x3f\nMBTABLE " +
                     TestCommon.IntToString (count) + "\n");
                for (var i = 0; i < 256; ++i) {
                    if (ints [i] >= 0) {
                        builder.Append (TestCommon.IntToString (i) + " " +
                          TestCommon.IntToString (ints [i]) + "\n");
                    }
                }
                builder.Append ("WCTABLE " + count + "\n");
                for (var i = 0; i < 256; ++i) {
                    if (ints [i] >= 0) {
                        builder.Append (TestCommon.IntToString (ints [i]) + " " +
                          TestCommon.IntToString (i) + "\n");
                    }
                }
                builder.Append ("ENDCODEPAGE\n");
                var cpe = new CodePageEncoding (Encodings.StringToInput (builder.ToString ()));
                TestSingleByteRoundTrip (cpe);
            }
        }

        private readonly string [] valueSingleByteNames = new string [] {
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

        public static void TestUtfRoundTrip (
           ICharacterEncoding enc)
        {
            ICharacterEncoder encoder = enc.GetEncoder ();
            ICharacterDecoder decoder = enc.GetDecoder ();
            TestUtfRoundTrip (encoder, decoder);
        }

        public static void TestUtfRoundTrip (
           ICharacterEncoder encoder,
           ICharacterDecoder decoder)
        {
            var aw = new ArrayWriter ();
            for (var i = 0; i < 0x110000; ++i) {
                if (i >= 0xd800 && i < 0xe000) {
                    continue;
                }
                int e = encoder.Encode (i, aw);
                if (e == -2) {
                    Assert.Fail ("Failed to encode " + i);
                }
            }
            IByteReader reader = DataIO.ToReader (aw.ToArray ());
            for (var i = 0; i < 0x110000; ++i) {
                if (i >= 0xd800 && i < 0xe000) {
                    continue;
                }
                int c = decoder.ReadChar (reader);
                if (c != i) {
                    Assert.AreEqual (i, c);
                }
            }
        }

        public static void TestCJKRoundTrip (string name)
        {
            ICharacterEncoding enc = Encodings.GetEncoding (name, true);
            ICharacterEncoder encoder = enc.GetEncoder ();
            ICharacterDecoder decoder = enc.GetDecoder ();
            var list = new List<int> ();
            var aw = new ArrayWriter ();
            for (var i = 0; i < 0x110000; ++i) {
                if (i >= 0xd800 && i < 0xe000) {
                    continue;
                }
                if (i == 0xa5 || i == 0x203e || i == 0x0e || i == 0x0f || i == 0x1b ||
                  i == 0x2212 || i == 0xe5e5) {
                    // ignore certain characters that intentionally
                    // don't round trip in certain encodings
                    continue;
                }
                int e = encoder.Encode (i, aw);
                if (e >= 0) {
                    list.Add (i);
                }
            }
            while (encoder.Encode (-1, aw) >= 0) {
            }
            IReader reader = DataIO.ToReader (aw.ToArray ());
            for (var i = 0; i < list.Count; ++i) {
                int ch = list [i];
                int c = decoder.ReadChar (reader);
                if (c != ch) {
                    Assert.Fail (name + ": ValueExpected " + ch + ", was " + c);
                }
            }
        }
        [Test]
        public void TestGBK ()
        {
            TestCJKRoundTrip ("gbk");
        }
        [Test]
        public void TestGB18030RoundTrip ()
        {
            TestCJKRoundTrip ("gb18030");
        }
        [Test]
        public void TestBig5 ()
        {
            TestCJKRoundTrip ("big5");
        }
        [Test]
        public void TestKoreanEUC ()
        {
            TestCJKRoundTrip ("euc-kr");
        }
        [Test]
        public void TestShiftJISRoundTrip ()
        {
            TestCJKRoundTrip ("shift-jis");
        }
        [Test]
        public void TestEucJPRoundTrip ()
        {
            TestCJKRoundTrip ("euc-jp");
        }
        [Test]
        public void TestIso2022JPRoundTrip ()
        {
            TestCJKRoundTrip ("iso-2022-jp");
        }

        [Test]
        public void TestReplacementEncoding ()
        {
            Assert.NotNull (Encodings.GetEncoding ("replacement"));
            ICharacterEncoding enc = Encodings.GetEncoding ("hz-gb-2312", true);
            ICharacterEncoder encoder = enc.GetEncoder ();
            ICharacterDecoder decoder = enc.GetDecoder ();
            IByteReader reader = DataIO.ToReader (new byte [] { 0, 0, 0, 0 });
            Assert.AreEqual (-2, decoder.ReadChar (reader));
            Assert.AreEqual (-1, decoder.ReadChar (reader));
            TestUtfRoundTrip (
              encoder,
              Encodings.GetEncoding ("utf-8", true).GetDecoder ());
        }

        [Test]
        public void TestSingleByteEncodings ()
        {
            for (var i = 0; i < this.valueSingleByteNames.Length; ++i) {
                TestSingleByteRoundTrip (this.valueSingleByteNames [i]);
            }
        }

        [Test]
        public void TestUtf7RoundTrip ()
        {
            TestUtfRoundTrip (Encodings.GetEncoding ("utf-7", true));
        }

        [Test]
        public void TestUtf8RoundTrip ()
        {
            TestUtfRoundTrip (Encodings.GetEncoding ("utf-8", true));
        }

        public static IList<byte []> GenerateIllegalUtf8Sequences ()
        {
            List<byte []> list = new List<byte []> ();
            // Generate illegal single bytes
            for (int i = 0x80; i <= 0xff; ++i) {
                if (i < 0xc2 || i > 0xf4) {
                    list.Add (new byte [] { (byte)i, 0x80 });
                }
                list.Add (new [] { (byte)i });
            }
            list.Add (new byte [] { 0xe0, 0xa0 });
            list.Add (new byte [] { 0xe1, 0x80 });
            list.Add (new byte [] { 0xef, 0x80 });
            list.Add (new byte [] { 0xf0, 0x90 });
            list.Add (new byte [] { 0xf1, 0x80 });
            list.Add (new byte [] { 0xf3, 0x80 });
            list.Add (new byte [] { 0xf4, 0x80 });
            list.Add (new byte [] { 0xf0, 0x90, 0x80 });
            list.Add (new byte [] { 0xf1, 0x80, 0x80 });
            list.Add (new byte [] { 0xf3, 0x80, 0x80 });
            list.Add (new byte [] { 0xf4, 0x80, 0x80 });
            // Generate illegal multibyte sequences
            for (int i = 0x00; i <= 0xff; ++i) {
                if (i < 0x80 || i > 0xbf) {
                    list.Add (new byte [] { 0xc2, (byte)i });
                    list.Add (new byte [] { 0xdf, (byte)i });
                    list.Add (new byte [] { 0xe1, (byte)i, 0x80 });
                    list.Add (new byte [] { 0xef, (byte)i, 0x80 });
                    list.Add (new byte [] { 0xf1, (byte)i, 0x80, 0x80 });
                    list.Add (new byte [] { 0xf3, (byte)i, 0x80, 0x80 });
                    list.Add (new byte [] { 0xe0, 0xa0, (byte)i });
                    list.Add (new byte [] { 0xe1, 0x80, (byte)i });
                    list.Add (new byte [] { 0xef, 0x80, (byte)i });
                    list.Add (new byte [] { 0xf0, 0x90, (byte)i, 0x80 });
                    list.Add (new byte [] { 0xf1, 0x80, (byte)i, 0x80 });
                    list.Add (new byte [] { 0xf3, 0x80, (byte)i, 0x80 });
                    list.Add (new byte [] { 0xf4, 0x80, (byte)i, 0x80 });
                    list.Add (new byte [] { 0xf0, 0x90, 0x80, (byte)i });
                    list.Add (new byte [] { 0xf1, 0x80, 0x80, (byte)i });
                    list.Add (new byte [] { 0xf3, 0x80, 0x80, (byte)i });
                    list.Add (new byte [] { 0xf4, 0x80, 0x80, (byte)i });
                }
                if (i < 0xa0 || i > 0xbf) {
                    list.Add (new byte [] { 0xe0, (byte)i, 0x80 });
                }
                if (i < 0x90 || i > 0xbf) {
                    list.Add (new byte [] { 0xf0, (byte)i, 0x80, 0x80 });
                }
                if (i < 0x80 || i > 0x8f) {
                    list.Add (new byte [] { 0xf4, (byte)i, 0x80, 0x80 });
                }
            }
            return list;
        }

        [Test]
        public void TestUtf8IllegalBytes ()
        {
            foreach (byte [] seq in GenerateIllegalUtf8Sequences ()) {
                string str = Encodings.DecodeToString (Encodings.UTF8, seq);
                Assert.IsTrue (str.Length > 0);
                Assert.IsTrue (str.IndexOf ('\ufffd') == 0);
            }
        }

        [Test]
        public void TestUtf16LERoundTrip ()
        {
            TestUtfRoundTrip (Encodings.GetEncoding ("utf-16le", true));
        }

        [Test]
        public void TestUtf16BERoundTrip ()
        {
            TestUtfRoundTrip (Encodings.GetEncoding ("utf-16be", true));
        }

        public static void TestUtf7One (string input, string expect)
        {
            {
                object objectTemp = expect;
                object objectTemp2 = Encodings.DecodeToString (
                        Encodings.GetEncoding ("utf-7", true),
                        Encodings.EncodeToBytes (input, Encodings.UTF8));
                Assert.AreEqual (objectTemp, objectTemp2);
            }
        }

        [Test]
        public void TestUtf7 ()
        {
            TestUtf7One ("\\", "\ufffd");
            TestUtf7One ("~", "\ufffd");
            TestUtf7One (",", ",");
            TestUtf7One ("\u0001", "\ufffd");
            TestUtf7One ("\u007f", "\ufffd");
            TestUtf7One (
        "\r\n\t '!\"#'()$-%@[]^&=<>;*_`{}./:|?",
        "\r\n\t '!\"#'()$-%@[]^&=<>;*_`{}./:|?");
            TestUtf7One ("x+--", "x+-");
            TestUtf7One ("x+-y", "x+y");
            // Illegal byte after plus
            TestUtf7One ("+!", "\ufffd!");
            TestUtf7One ("+\n", "\ufffd\n");
            TestUtf7One ("+\u007f", "\ufffd\ufffd");
            TestUtf7One ("+", "\ufffd");
            // Incomplete byte
            TestUtf7One ("+D?", "\ufffd?");
            TestUtf7One ("+D\u007f", "\ufffd\ufffd");
            TestUtf7One ("+D", "\ufffd");
            // Only one UTF-16 byte
            TestUtf7One ("+DE?", "\ufffd?");
            TestUtf7One ("+DE", "\ufffd");
            TestUtf7One ("+DE\u007f", "\ufffd\ufffd");
            // UTF-16 code unit
            TestUtf7One ("+DEE?", "\u0c41?");
            TestUtf7One ("+DEE", "\u0c41");
            TestUtf7One ("+DEE\u007f", "\u0c41\ufffd");
            // UTF-16 code unit (redundant pad bit)
            TestUtf7One ("+DEF?", "\u0c41\ufffd?");
            TestUtf7One ("+DEF", "\u0c41\ufffd");
            TestUtf7One ("+DEF\u007f", "\u0c41\ufffd\ufffd");
            // High surrogate code unit
            TestUtf7One ("+2AA?", "\ufffd?");
            TestUtf7One ("+2AA", "\ufffd");
            TestUtf7One ("+2AA\u007f", "\ufffd\ufffd");
            // Low surrogate code unit
            TestUtf7One ("+3AA?", "\ufffd?");
            TestUtf7One ("+3AA", "\ufffd");
            TestUtf7One ("+3AA\u007f", "\ufffd\ufffd");
            // Surrogate pair
            TestUtf7One ("+2ADcAA?", "\ud800\udc00?");
            TestUtf7One ("+2ADcAA", "\ud800\udc00");
            TestUtf7One ("+2ADcAA\u007f", "\ud800\udc00\ufffd");
            // High surrogate followed by surrogate pair
            TestUtf7One ("+2ADYANwA?", "\ufffd\ud800\udc00?");
            TestUtf7One ("+2ADYANwA", "\ufffd\ud800\udc00");
            TestUtf7One ("+2ADYANwA\u007f", "\ufffd\ud800\udc00\ufffd");
            // High surrogate followed by non-surrogate
            TestUtf7One ("+2AAAwA?", "\ufffd\u00c0?");
            TestUtf7One ("+2AAAwA", "\ufffd\u00c0");
            TestUtf7One ("+2AAAwA\u007f", "\ufffd\u00c0\ufffd");
            // Two UTF-16 code units
            TestUtf7One ("+AMAA4A?", "\u00c0\u00e0?");
            TestUtf7One ("+AMAA4A", "\u00c0\u00e0");
            TestUtf7One ("+AMAA4A-Next", "\u00c0\u00e0Next");
            TestUtf7One ("+AMAA4A!Next", "\u00c0\u00e0!Next");
            TestUtf7One ("+AMAA4A\u007f", "\u00c0\u00e0\ufffd");
            // Two UTF-16 code units (redundant pad bit)
            TestUtf7One ("+AMAA4B?", "\u00c0\u00e0\ufffd?");
            TestUtf7One ("+AMAA4B", "\u00c0\u00e0\ufffd");
            TestUtf7One ("+AMAA4B-Next", "\u00c0\u00e0\ufffdNext");
            TestUtf7One ("+AMAA4B!Next", "\u00c0\u00e0\ufffd!Next");
            TestUtf7One ("+AMAA4B\u007f", "\u00c0\u00e0\ufffd\ufffd");
        }
    }
}
