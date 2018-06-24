package com.upokecenter.test; import com.upokecenter.util.*;
/*
Written by Peter O. in 2014.
Any copyright is dedicated to the Public Domain.
http://creativecommons.org/publicdomain/zero/1.0/
If you like this, you should donate to Peter O.
at: http://peteroupc.github.io/
 */
import java.util.*;

import org.junit.Assert;
import org.junit.Test;
import com.upokecenter.util.*;
import com.upokecenter.text.*;

    public class CharsetsTest {
        @Test
        public void TestShiftJIS() {
            // Adapted from the public domain Gonk test cases
            byte[] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding("shift_jis");
          bytes = new byte[] { (byte)0x82, 0x58, 0x33, 0x41, 0x61, 0x33, (byte)0x82, 0x60,
        (byte)0x82, (byte)0x81, 0x33, (byte)0xb1, (byte)0xaf, 0x33, (byte)0x83, 0x41,
        (byte)0x83, (byte)0x96, 0x33, (byte)0x82, (byte)0xa0, 0x33, (byte)0x93, (byte)0xfa,
        0x33, 0x3a, 0x3c, 0x33, (byte)0x81, (byte)0x80, (byte)0x81, (byte)0x8e,
        0x33, 0x31, (byte)0x82, 0x51, 0x41, 0x61, (byte)0x82, 0x51,
        (byte)0x82, 0x60, (byte)0x82, (byte)0x81, (byte)0x82, 0x51, (byte)0xb1, (byte)0xaf,
        (byte)0x82, 0x51, (byte)0x83, 0x41, (byte)0x83, (byte)0x96, (byte)0x82, 0x51,
        (byte)0x82, (byte)0xa0, (byte)0x82, 0x51, (byte)0x93, (byte)0xfa, (byte)0x82, 0x51,
        0x3a, 0x3c, (byte)0x82, 0x51, (byte)0x81, (byte)0x80, (byte)0x81, (byte)0x8e,
        (byte)0x82, 0x51 };
            String ValueExpected =

  "\uFF19\u0033\u0041\u0061\u0033\uFF21\uFF41\u0033\uFF71\uFF6F\u0033\u30A2\u30F6\u0033\u3042\u0033\u65E5\u0033\u003A\u003C\u0033\u00F7\u2103\u0033\u0031\uFF12\u0041\u0061\uFF12\uFF21\uFF41\uFF12\uFF71\uFF6F\uFF12\u30A2\u30F6\uFF12\u3042\uFF12\u65E5\uFF12\u003A\u003C\uFF12\u00F7\u2103\uFF12";

    {
Object objectTemp = ValueExpected;
Object objectTemp2 = Encodings.DecodeToString(
  charset,
  bytes);
Assert.assertEquals(objectTemp, objectTemp2);
}
        }

        private static void TestEncodingRoundTrip(
      String str,
      ICharacterEncoding encoding) {
            byte[] bytes;
            String str2;
            bytes = Encodings.EncodeToBytes(str, encoding);
            str2 = Encodings.DecodeToString(encoding, bytes);
            Assert.assertEquals(str, str2);
        }

        @Test
public void TestGB18030() {
            ICharacterEncoding encoding = Encodings.GetEncoding("gb18030");
            TestEncodingRoundTrip("\uffff", encoding);
            TestEncodingRoundTrip("\ud800\udc00", encoding);
            TestEncodingRoundTrip("\udbff\udfff", encoding);
        }

        @Test
public void TestIso2022JP() {
            byte[] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding("iso-2022-jp");
            bytes = new byte[] { 0x20, 0x41, 0x61, 0x5c };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  " Aa\\",
                  stringTemp);
            }
            // Illegal byte in escape middle state
            bytes = new byte[] { 0x1b, 0x28, 0x47, 0x21, 0x41, 0x31, 0x5c };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "\ufffd\u0028\u0047!A1\\",
                stringTemp);
            }
            // Katakana
            bytes = new byte[] { 0x1b, 0x28, 0x49, 0x21, 0x41, 0x31, 0x5c };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "\uff61\uff81\uff71\uff9c",
                stringTemp);
            }
            bytes = new byte[] { 0x1b, 0x28, 0x49, 0x20, 0x41, 0x61, 0x5c };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "\ufffd\uff81\ufffd\uff9c",
                stringTemp);
            }
            // ASCII state via escape
            bytes = new byte[] { 0x1b, 0x28, 0x42, 0x20, 0x41, 0x61, 0x5c };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                " Aa\\",
                stringTemp);
            }
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x20, 0x41, 0x61, 0x5c };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                " Aa\u00a5",
                stringTemp);
            }
            // JIS0208 state
  bytes = new byte[] { 0x1b, 0x24, 0x40, 0x21, 0x21, 0x21, 0x22, 0x21, 0x23 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "\u3000\u3001\u3002",
                stringTemp);
            }
  bytes = new byte[] { 0x1b, 0x24, 0x42, 0x21, 0x21, 0x21, 0x22, 0x21, 0x23 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "\u3000\u3001\u3002",
                stringTemp);
            }
          bytes = new byte[] { 0x1b, 0x24, 0x42, 0x21, 0x21, 0x21, 0x22, 0x0a,
        0x21, 0x23 };
            // Illegal state
  bytes = new byte[] { 0x1b, 0x24, 0x4f, 0x21, 0x21, 0x21, 0x23, 0x21, 0x23 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "\ufffd\u0024\u004f!!!\u0023!#",
                stringTemp);
            }
            // Illegal state
          bytes = new byte[] { 0x1b, 0x24, 0x28, 0x4f, 0x21, 0x21, 0x21, 0x23,
        0x21, 0x23 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "\ufffd\u0024\u0028\u004f!!!\u0023!#",
                stringTemp);
            }
            // Illegal state at end
            bytes = new byte[] { 0x41, 0x1b };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "A\ufffd",
                stringTemp);
            }
            bytes = new byte[] { 0x41, 0x1b, 0x27 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "A\ufffd'",
                stringTemp);
            }
            bytes = new byte[] { 0x41, 0x1b, 0x24 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "A\ufffd$",
                stringTemp);
            }
            bytes = new byte[] { 0x41, 0x1b, 0x24, 0x28 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "A\ufffd$\u0028",
                stringTemp);
            }
        }

        @Test
public void TestEucJPEncodeSpecific() {
            String str;
            byte[] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding("euc-jp");
            str = "\uff57\u5256";
         bytes = new byte[] { (byte)0xa3, (byte)0xf7, (byte)0xcb, (byte)0xb6
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff3e";
            bytes = new byte[] { (byte)0xa1, (byte)0xb0 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff2a";
            bytes = new byte[] { (byte)0xa3, (byte)0xca };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7984";
            bytes = new byte[] { (byte)0xcf, (byte)0xbd };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff6c\uff2b";
         bytes = new byte[] { (byte)0x8e, (byte)0xac, (byte)0xa3, (byte)0xcb
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff04";
            bytes = new byte[] { (byte)0xa1, (byte)0xf0 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff9c";
            bytes = new byte[] { (byte)0x8e, (byte)0xdc };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u594f";
            bytes = new byte[] { (byte)0xc1, (byte)0xd5 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7670\uff77";
         bytes = new byte[] { (byte)0xe1, (byte)0xfe, (byte)0x8e, (byte)0xb7
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u73f1\u898f";
         bytes = new byte[] { (byte)0xe0, (byte)0xfe, (byte)0xb5, (byte)0xac
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff45";
            bytes = new byte[] { (byte)0xa3, (byte)0xe5 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u25cb\uff4f";
         bytes = new byte[] { (byte)0xa1, (byte)0xfb, (byte)0xa3, (byte)0xef
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7dac";
            bytes = new byte[] { (byte)0xbc, (byte)0xfa };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff8d";
            bytes = new byte[] { (byte)0x8e, (byte)0xcd };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u6148";
            bytes = new byte[] { (byte)0xbb, (byte)0xfc };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u68a7";
            bytes = new byte[] { (byte)0xb8, (byte)0xe8 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u541f";
            bytes = new byte[] { (byte)0xb6, (byte)0xe3 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u608b\u50d5";
         bytes = new byte[] { (byte)0xd8, (byte)0xa7, (byte)0xcb, (byte)0xcd
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff47\uff14";
         bytes = new byte[] { (byte)0xa3, (byte)0xe7, (byte)0xa3, (byte)0xb4
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u5be5";
            bytes = new byte[] { (byte)0xd5, (byte)0xec };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7bb1";
            bytes = new byte[] { (byte)0xc8, (byte)0xa2 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff9e";
            bytes = new byte[] { (byte)0x8e, (byte)0xde };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff7d";
            bytes = new byte[] { (byte)0x8e, (byte)0xbd };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u6e0a";
            bytes = new byte[] { (byte)0xde, (byte)0xbd };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u51f5";
            bytes = new byte[] { (byte)0xd1, (byte)0xe1 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u6756";
            bytes = new byte[] { (byte)0xbe, (byte)0xf3 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u68c9";
            bytes = new byte[] { (byte)0xcc, (byte)0xc9 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff04";
            bytes = new byte[] { (byte)0xa1, (byte)0xf0 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u54a2";
            bytes = new byte[] { (byte)0xd2, (byte)0xf8 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7523";
            bytes = new byte[] { (byte)0xbb, (byte)0xba };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff26";
            bytes = new byte[] { (byte)0xa3, (byte)0xc6 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7407";
            bytes = new byte[] { (byte)0xfb, (byte)0xaa };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff0e";
            bytes = new byte[] { (byte)0xa1, (byte)0xa5 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7a98";
            bytes = new byte[] { (byte)0xe3, (byte)0xdb };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7b8f";
            bytes = new byte[] { (byte)0xe4, (byte)0xb7 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u5e7b\uff38";
         bytes = new byte[] { (byte)0xb8, (byte)0xb8, (byte)0xa3, (byte)0xd8
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff78\u6ebf";
         bytes = new byte[] { (byte)0x8e, (byte)0xb8, (byte)0xfa, (byte)0xed
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u5d84";
            bytes = new byte[] { (byte)0xd6, (byte)0xd0 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff2f";
            bytes = new byte[] { (byte)0xa3, (byte)0xcf };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff69";
            bytes = new byte[] { (byte)0x8e, (byte)0xa9 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff9c";
            bytes = new byte[] { (byte)0x8e, (byte)0xdc };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff24";
            bytes = new byte[] { (byte)0xa3, (byte)0xc4 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uffe5\u226b";
         bytes = new byte[] { (byte)0xa1, (byte)0xef, (byte)0xa2, (byte)0xe4
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff7f";
            bytes = new byte[] { (byte)0x8e, (byte)0xbf };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u65cb";
            bytes = new byte[] { (byte)0xc0, (byte)0xfb };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff5c";
            bytes = new byte[] { (byte)0xa1, (byte)0xc3 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7470\u695a";
         bytes = new byte[] { (byte)0xe0, (byte)0xf3, (byte)0xc1, (byte)0xbf
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff88";
            bytes = new byte[] { (byte)0x8e, (byte)0xc8 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u25a0\u79d5";
         bytes = new byte[] { (byte)0xa2, (byte)0xa3, (byte)0xe3, (byte)0xbe
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u0011";
            bytes = new byte[] { 0x11 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "J";
            bytes = new byte[] { 0x4a };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u53bb\u592e";
         bytes = new byte[] { (byte)0xb5, (byte)0xee, (byte)0xb1, (byte)0xfb
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff2e";
            bytes = new byte[] { (byte)0xa3, (byte)0xce };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u67c4";
            bytes = new byte[] { (byte)0xca, (byte)0xc1 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u6292";
            bytes = new byte[] { (byte)0xd9, (byte)0xb3 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff03";
            bytes = new byte[] { (byte)0xa1, (byte)0xf4 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u000c";
            bytes = new byte[] { 0x0c };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u71ed";
            bytes = new byte[] { (byte)0xbf, (byte)0xa4 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff9f";
            bytes = new byte[] { (byte)0x8e, (byte)0xdf };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u2517\uff5c";
         bytes = new byte[] { (byte)0xa8, (byte)0xb1, (byte)0xa1, (byte)0xc3
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u6500";
            bytes = new byte[] { (byte)0xda, (byte)0xb5 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u770c";
            bytes = new byte[] { (byte)0xb8, (byte)0xa9 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff72";
            bytes = new byte[] { (byte)0x8e, (byte)0xb2 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7591";
            bytes = new byte[] { (byte)0xb5, (byte)0xbf };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff79";
            bytes = new byte[] { (byte)0x8e, (byte)0xb9 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u731f";
            bytes = new byte[] { (byte)0xce, (byte)0xc4 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u6859";
            bytes = new byte[] { (byte)0xdb, (byte)0xe2 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u6a7f";
            bytes = new byte[] { (byte)0xb3, (byte)0xe0 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u2287";
            bytes = new byte[] { (byte)0xa2, (byte)0xbd };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u6b43";
            bytes = new byte[] { (byte)0xdd, (byte)0xbd };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff4b";
            bytes = new byte[] { (byte)0xa3, (byte)0xeb };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u751f";
            bytes = new byte[] { (byte)0xc0, (byte)0xb8 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff85\uff16";
         bytes = new byte[] { (byte)0x8e, (byte)0xc5, (byte)0xa3, (byte)0xb6
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff9d\u6234";
         bytes = new byte[] { (byte)0x8e, (byte)0xdd, (byte)0xc2, (byte)0xd7
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u75d2\u7962";
         bytes = new byte[] { (byte)0xe1, (byte)0xda, (byte)0xc7, (byte)0xaa
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u5b2a";
            bytes = new byte[] { (byte)0xd5, (byte)0xcd };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u251d";
            bytes = new byte[] { (byte)0xa8, (byte)0xbc };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u5c3d";
            bytes = new byte[] { (byte)0xbf, (byte)0xd4 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7ac5";
            bytes = new byte[] { (byte)0xe3, (byte)0xe1 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uffe3";
            bytes = new byte[] { (byte)0xa1, (byte)0xb1 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff61\uff47";
         bytes = new byte[] { (byte)0x8e, (byte)0xa1, (byte)0xa3, (byte)0xe7
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u2640\uff76";
         bytes = new byte[] { (byte)0xa1, (byte)0xea, (byte)0x8e, (byte)0xb6
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u6e19";
            bytes = new byte[] { (byte)0xde, (byte)0xd2 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u69ff";
            bytes = new byte[] { (byte)0xdc, (byte)0xdd };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u5409";
            bytes = new byte[] { (byte)0xb5, (byte)0xc8 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7891";
            bytes = new byte[] { (byte)0xc8, (byte)0xea };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff47";
            bytes = new byte[] { (byte)0xa3, (byte)0xe7 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7409\u6070\uff68";
            bytes = new byte[] { (byte)0xce, (byte)0xb0, (byte)0xb3,
              (byte)0xe6, (byte)0x8e, (byte)0xa8 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u5a41\u5ac2";
         bytes = new byte[] { (byte)0xcf, (byte)0xac, (byte)0xd5, (byte)0xbf
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u253c";
            bytes = new byte[] { (byte)0xa8, (byte)0xab };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff38";
            bytes = new byte[] { (byte)0xa3, (byte)0xd8 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u718a";
            bytes = new byte[] { (byte)0xb7, (byte)0xa7 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff48d";
            bytes = new byte[] { (byte)0xa3, (byte)0xe8, 0x64 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff98\u203b";
         bytes = new byte[] { (byte)0x8e, (byte)0xd8, (byte)0xa2, (byte)0xa8
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff19";
            bytes = new byte[] { (byte)0xa3, (byte)0xb9 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u7fb9\u5149";
         bytes = new byte[] { (byte)0xe6, (byte)0xbd, (byte)0xb8, (byte)0xf7
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u6a5f";
            bytes = new byte[] { (byte)0xb5, (byte)0xa1 };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\u9587\u7dd5";
         bytes = new byte[] { (byte)0xef, (byte)0xda, (byte)0xe5, (byte)0xee
               };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff9d";
            bytes = new byte[] { (byte)0x8e, (byte)0xdd };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
            str = "\uff3a";
            bytes = new byte[] { (byte)0xa3, (byte)0xda };
            TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
        }

        @Test
public void TestEucJPSpecific() {
            byte[] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding("euc-jp");
    bytes = new byte[] { (byte)0x98, (byte)0x87, (byte)0xd7, 0x38, 0x34, 0x57,
  (byte)0xb8, 0x68, (byte)0xd9, (byte)0xbc, (byte)0x97, 0x0c, (byte)0x88,
  0x60, (byte)0xa3, (byte)0xa8, 0x51, 0x1b, 0x08, 0x10, 0x7e, 0x6e, 0x36,
  (byte)0xb1, (byte)0xa4, 0x75, (byte)0xac };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "\ufffd\ufffd\ufffd84W\ufffdh\u62cf\ufffd\u000c\ufffd`\ufffdQ\u001b\u0008\u0010~n6\u97fbu\ufffd",
  stringTemp);
            }
            bytes = new byte[] { (byte)0xda, 0x26, (byte)0xe4, 0x24, 0x23,
              0x40, 0x4e, (byte)0xff, 0x26, 0x49, 0x54, 0x28, (byte)0x9e,
              0x57, 0x49, (byte)0x93, (byte)0xd2, 0x45, 0x6b, (byte)0x91,
              (byte)0xb4, 0x50 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
 "\ufffd&\ufffd$#@N\ufffd&IT(\ufffdWI\ufffd\ufffdEk\ufffd\ufffdP",
                    stringTemp);
            }
            bytes = new byte[] { (byte)0xb8, (byte)0x90, 0x5d, (byte)0xdf,
              0x24, (byte)0xdd, (byte)0xaf, (byte)0xa0, 0x2a, (byte)0x9a,
              0x38, 0x5d, (byte)0xf9, 0x54, 0x26, (byte)0xa8, 0x62, 0x2e,
              (byte)0x80, (byte)0xdf, (byte)0xb7, 0x70, 0x19, (byte)0xa4,
              0x2a };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "\ufffd]\ufffd$\u6afb\ufffd*\ufffd8]\ufffdT&\ufffdb.\ufffd\u6fa4p\u0019\ufffd*",
  stringTemp);
            }
            bytes = new byte[] { (byte)0x94, 0x22, (byte)0xde, 0x28,
              (byte)0x8c, (byte)0xa3, 0x1a, (byte)0xde, 0x4c, (byte)0xc1,
              0x1d, (byte)0xea, 0x41, (byte)0x82, (byte)0xec, 0x7f, 0x5f,
              (byte)0x8a, (byte)0xaa, (byte)0xf6, 0x2c, (byte)0x87, 0x4f,
              (byte)0x92, 0x4a };
            Assert.assertEquals(
  "\ufffd\"\ufffd(\ufffd\ufffd\u001a\ufffdL\ufffd\u001d\ufffdA\ufffd\ufffd\u007f_\ufffd\ufffd,\ufffdO\ufffdJ",

             Encodings.DecodeToString(charset,
 bytes));
            bytes = new byte[] { 0x17, 0x70, 0x06, 0x03, 0x33, 0x1b, 0x3f,
              (byte)0x8a, 0x73, (byte)0x8d, 0x3c, (byte)0x84, 0x69, 0x63,
              0x55, 0x46, (byte)0xa3, 0x40, 0x02, 0x42 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "\u0017p\u0006\u00033\u001b?\ufffds\ufffd<\ufffdicUF\ufffd@\u0002B",
  stringTemp);
            }
            bytes = new byte[] { 0x48, (byte)0x8f, (byte)0xe0, 0x6b, 0x47,
              (byte)0xa9, (byte)0xdd, 0x27, 0x6a, 0x13, (byte)0xb5,
              (byte)0xf2, (byte)0x8b, 0x38, 0x37, (byte)0xc0, (byte)0xeb,
              (byte)0x88, (byte)0xc1, 0x03, (byte)0x94, 0x0c, 0x61,
              (byte)0xbb, 0x06 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "H\ufffdkG\ufffd'j\u0013\u62e0\ufffd87\u5ba3\ufffd\ufffd\u0003\ufffd\u000ca\ufffd\u0006",
  stringTemp);
            }
            bytes = new byte[] { (byte)0xcd, (byte)0xea, (byte)0xe3, 0x22,
              (byte)0xe4, (byte)0xd8, 0x6a, (byte)0xf0, 0x5f, 0x18, 0x02 };
            Assert.assertEquals(
             "\u983c\ufffd\"\u7c54j\ufffd_\u0018\u0002",
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { (byte)0xb4, (byte)0xd8, (byte)0xc0, 0x47,
              (byte)0xc5, (byte)0xf7, (byte)0xe3, (byte)0xc1, 0x2a,
              (byte)0xd6, 0x44 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\u95a2\ufffdG\u75d8\u79e1*\ufffdD",
                  stringTemp);
            }
            bytes = new byte[] { 0x1c };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\u001c",
                  stringTemp);
            }
            bytes = new byte[] { (byte)0xe0, 0x4a, 0x6a, 0x33, 0x64,
              (byte)0xa9, (byte)0xb9, 0x23, 0x49, (byte)0x91, (byte)0xf2,
              0x27, (byte)0x9b, 0x52, (byte)0xc1, (byte)0xca, (byte)0x8e,
              (byte)0xc5, 0x13, 0x16, 0x7c, (byte)0x8a, (byte)0xcf, 0x3a,
              0x3e, (byte)0xd7, 0x54, (byte)0xec, (byte)0xba };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "\ufffdJj3d\ufffd#I\ufffd\ufffd'\ufffdR\u8a34\uff85\u0013\u0016|\ufffd\ufffd:>\ufffdT\u8c82",
  stringTemp);
            }
            bytes = new byte[] { (byte)0xeb, (byte)0xdd, 0x30, 0x79, 0x08,
              (byte)0x94, 0x60, (byte)0xa7, (byte)0xef, (byte)0xf1,
              (byte)0x97, (byte)0xfe, 0x1e, 0x4b, 0x5d, 0x55, 0x04 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\u8aeb0y\u0008\ufffd`\u044d\ufffd\ufffd\u001eK]U\u0004",
                  stringTemp);
            }
            bytes = new byte[] { 0x06, 0x4a, (byte)0xe4, 0x00, (byte)0x8c,
              0x53, 0x3a, (byte)0xbc, 0x4b, (byte)0xff, (byte)0xe0, 0x0b,
              (byte)0x89, 0x29, (byte)0x94, 0x28, 0x76, 0x2d, (byte)0x98,
              (byte)0xbf, (byte)0x92, (byte)0xda, (byte)0x95, 0x0f,
              (byte)0xea, 0x07 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "\u0006J\ufffd\u0000\ufffdS:\ufffdK\ufffd\ufffd\u000b\ufffd)\ufffd(v-\ufffd\ufffd\ufffd\u000f\ufffd\u0007",

                 stringTemp);
            }
            bytes = new byte[] { (byte)0xd5, (byte)0xf7, (byte)0x95, 0x2a,
              0x29, 0x0f, 0x34, 0x16, 0x44, (byte)0x94, 0x3a, 0x4d, 0x5e,
              0x0a, 0x7e, 0x3e, (byte)0xaf, 0x5f, 0x03, 0x20, (byte)0xee,
              0x11, (byte)0xcf, 0x72, 0x63, (byte)0xbd, (byte)0xf5, 0x1b,
              0x2a, (byte)0xb2 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "\u5c22\ufffd*)\u000f4\u0016D\ufffd:M^\u000a~>\ufffd_\u0003 \ufffd\u0011\ufffdrc\u52a9\u001b*\ufffd",

                 stringTemp);
            }
            bytes = new byte[] { 0x39, 0x0f, 0x1d, 0x03, (byte)0xd4, 0x4b,
              0x00, (byte)0xe2, 0x4e, 0x3c, 0x5d, 0x44, 0x2c, 0x7f,
              (byte)0xcf, 0x68, 0x4d, (byte)0xe5, 0x0b, 0x5f, (byte)0x9c,
              0x6c, (byte)0xe9, 0x39, (byte)0x98, 0x5c, (byte)0xb0,
              (byte)0xa8, (byte)0xf8, 0x1d };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                String string2 =

  "9\u000f\u001d\u0003\ufffdK\u0000\ufffdN<]D,\u007f\ufffdhM\ufffd\u000b_\ufffdl\ufffd9\ufffd\\\u59f6\ufffd\u001d";
                Assert.assertEquals(
  string2,
  stringTemp);
            }
            bytes = new byte[] { (byte)0xf0, 0x2a, 0x7d, 0x26, (byte)0xc5,
              (byte)0xa0, (byte)0xbf, 0x7d, 0x1a, 0x1d, 0x1d, (byte)0x81,
              (byte)0xa1, 0x49, (byte)0x99, (byte)0xa6 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "\ufffd*}&\ufffd\ufffd}\u001a\u001d\u001d\ufffd\ufffdI\ufffd\ufffd",
  stringTemp);
            }
            bytes = new byte[] { (byte)0xed, (byte)0xa5, (byte)0xc1,
              (byte)0xbf, 0x6a, 0x03, 0x60, (byte)0x84, 0x06, (byte)0xcf,
              (byte)0xad, (byte)0xe6, 0x5a, 0x2b, (byte)0x9f, (byte)0x99 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\u8e48\u695aj\u0003`\ufffd\u0006\u5eca\ufffdZ+\ufffd\ufffd",
                  stringTemp);
            }
            bytes = new byte[] { 0x11, (byte)0x8c, (byte)0x89, (byte)0xd1,
              0x70, 0x3e, 0x34, 0x67, (byte)0xde, (byte)0xf0, 0x62, 0x06,
              (byte)0xc6, 0x59, (byte)0x9b, 0x6e, (byte)0xcf, 0x52, 0x5e,
              0x56, 0x3f, (byte)0x9d, (byte)0xb5, (byte)0xe1, (byte)0xc2,
              (byte)0xb7, (byte)0x86 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "\u0011\ufffd\ufffd\ufffdp>4g\u6ea5b\u0006\ufffdY\ufffdn\ufffdR^V?\ufffd\u6c42\u63c3\ufffd",
  stringTemp);
            }
            bytes = new byte[] { 0x18, (byte)0xb1, (byte)0xa5, 0x28,
              (byte)0xee, (byte)0xd0, (byte)0xe0, (byte)0xc8, 0x3b, 0x71,
              (byte)0xc2, 0x54, 0x46, (byte)0xd4, 0x74, (byte)0x9b, 0x79 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
              "\u0018\u540b(\u91ab\u7317;q\ufffdTF\ufffdt\ufffdy",
                    stringTemp);
            }
            bytes = new byte[] { 0x6b, (byte)0x87, (byte)0xcd, (byte)0xaf,
              (byte)0x83, 0x2c, 0x60, (byte)0x98, 0x21, (byte)0xd2,
              (byte)0xa7, 0x2f, 0x18, (byte)0xa6, (byte)0xc5 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
           String str34290 = "k\ufffd\u6e67\ufffd,`\ufffd!\u52cd/\u0018\u03b5";

                Assert.assertEquals(
                str34290,
                stringTemp);
            }
            bytes = new byte[] { (byte)0xa9, (byte)0xd9, (byte)0x9a,
              (byte)0xc7, 0x21, (byte)0xc4, (byte)0xe6, 0x12, (byte)0x85,
              (byte)0xd6, 0x40, (byte)0xc5, (byte)0xff, (byte)0x99,
              (byte)0xac, (byte)0xb3, (byte)0x88, 0x71 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "\ufffd\ufffd\ufffd!\u5243\u0012\ufffd\ufffd@\ufffd\ufffd\ufffd\ufffdq",
  stringTemp);
            }
            bytes = new byte[] { (byte)0xbd, 0x01, (byte)0x81, (byte)0x9b,
              (byte)0xc9, 0x5d, 0x08, 0x20, (byte)0xcc, (byte)0x91,
              (byte)0x90, (byte)0x8a, (byte)0xa4 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "\ufffd\u0001\ufffd\ufffd\ufffd]\u0008 \ufffd\ufffd\ufffd\ufffd",
  stringTemp);
            }
            bytes = new byte[] { (byte)0xfe, 0x73, 0x77, (byte)0x85,
              (byte)0xc3, 0x2a, (byte)0xf7, (byte)0xf7, 0x6a, (byte)0x98,
              (byte)0xd6, 0x55, (byte)0xc5, 0x70, 0x16, (byte)0xf0,
              (byte)0x80, 0x0a, 0x38, (byte)0x94, (byte)0xf0, 0x58,
              (byte)0xcf, 0x08, 0x2c, (byte)0x9a, (byte)0xf0, (byte)0xf3 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                String str35668 =

  "\ufffdsw\ufffd\ufffd*\ufffdj\ufffd\ufffdU\ufffdp\u0016\ufffd\u000a8\ufffd\ufffdX\ufffd\u0008,\ufffd\u980c";

                Assert.assertEquals(
                str35668,
                stringTemp);
            }
            bytes = new byte[] { (byte)0x9a, (byte)0x81, 0x5e, (byte)0xa3,
              (byte)0xc6, 0x40, (byte)0x9b, (byte)0xf7, (byte)0xae, 0x06,
              (byte)0xb9, (byte)0x89, 0x4a, (byte)0xb0, 0x20, (byte)0xb5,
              0x74, 0x0d, (byte)0x83, 0x39, (byte)0xab, 0x3b, 0x43 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "\ufffd\ufffd^\uff26@\ufffd\ufffd\u0006\ufffdJ\ufffd \ufffdt\u000d\ufffd9\ufffd;C",
  stringTemp);
            }
            bytes = new byte[] { (byte)0xa6, (byte)0xbd, (byte)0x93,
              (byte)0xd4, 0x7a, (byte)0xc9, (byte)0xb6, (byte)0xc0,
              (byte)0xf3, 0x6a, (byte)0x92, 0x0f, (byte)0xd9, (byte)0xe9,
              0x6e, 0x4a, (byte)0xfd, (byte)0xc4, (byte)0xff };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "\ufffd\ufffd\ufffdz\u4ff5\u6834j\ufffd\u000f\u63c4nJ\ufffd\ufffd",
  stringTemp);
            }
            bytes = new byte[] { 0x1c, (byte)0xf4, 0x47, (byte)0xbd,
              (byte)0x87, (byte)0xee, 0x09, (byte)0xe6, (byte)0x9c,
              (byte)0xdc, (byte)0xa7, 0x65, (byte)0xdc, (byte)0x9a,
              (byte)0xf7, (byte)0xe0, (byte)0xcd, 0x64 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "\u001c\ufffdG\ufffd\ufffd\u0009\ufffd\u68d7e\ufffd\ufffd\ufffdd",
  stringTemp);
            }
            bytes = new byte[] { 0x32, 0x75, (byte)0xa3, 0x09, 0x10,
              (byte)0xe6, (byte)0xda, 0x0a, 0x51, (byte)0xf9, 0x33,
              (byte)0xa9, (byte)0xb1, (byte)0xed, 0x0b, 0x5c, (byte)0xd7,
              0x05, (byte)0xb0, 0x3b, (byte)0x9b, 0x18, (byte)0xef, 0x09,
              (byte)0xed, (byte)0xa2 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
  "2u\ufffd\u0009\u0010\u8052\u000aQ\ufffd3\ufffd\ufffd\u000b\\\ufffd\u0005\ufffd;\ufffd\u0018\ufffd\u0009\u8e49",
  stringTemp);
            }
            bytes = new byte[] { (byte)0xcd, (byte)0xda, 0x60, 0x47,
              (byte)0x8d, (byte)0xc4, 0x00, (byte)0xff };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\u9065`G\ufffd\ufffd\u0000\ufffd",
                  stringTemp);
            }
            bytes = new byte[] { (byte)0xfa, (byte)0xdf, 0x37, 0x21,
              (byte)0x85, 0x58, 0x6a, (byte)0xa0, 0x10, 0x3c, (byte)0xb7,
              0x28, 0x55, 0x7b, (byte)0xf7, (byte)0x88, (byte)0xcc, 0x64,
              0x54, 0x18, (byte)0xb0, 0x3a, 0x76, 0x3f, 0x30, 0x2b, 0x5a,
              0x21, 0x73, (byte)0xee };
            bytes = new byte[] { (byte)0x91, 0x7e, 0x43, (byte)0x85, 0x4b,
              0x60, 0x23, (byte)0xb4, 0x26 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd~C\ufffdK`#\ufffd&",
  stringTemp);
}
            bytes = new byte[] { (byte)0xeb };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x4f, 0x63, 0x51, (byte)0xf9, 0x59,
              (byte)0xba, 0x37, (byte)0xb8, (byte)0x84, (byte)0x9f,
              (byte)0x83, 0x3d, (byte)0xeb, (byte)0xec, 0x6e, 0x69,
              (byte)0xf8, (byte)0xfd, (byte)0x85, 0x53, (byte)0x8b, 0x2d };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "OcQ\ufffdY\ufffd7\ufffd\ufffd\ufffd=\u8b16ni\ufffd\ufffdS\ufffd-",
  stringTemp);
}
            bytes = new byte[] { 0x40, (byte)0x9b, 0x29, 0x38, 0x58, 0x09,
              0x0d, 0x04, 0x14, (byte)0xda, 0x38, 0x46, 0x6e, 0x52, 0x44,
              (byte)0xf9 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "@\ufffd)8X\u0009\u000d\u0004\u0014\ufffd8FnRD\ufffd", stringTemp);
}
            bytes = new byte[] { 0x47, 0x22, 0x33, 0x5f, (byte)0xe3,
              (byte)0x81, 0x55, (byte)0x85, 0x4b, 0x42, 0x37, 0x33, 0x76,
              (byte)0xf5, 0x12, 0x00, 0x51, 0x12, (byte)0xd3, 0x26,
              (byte)0xdb, (byte)0xe9, 0x3d, 0x16, (byte)0xdb, (byte)0xcc,
              0x4c, (byte)0x8d };
            Assert.assertEquals(
  "G\"3_\ufffdU\ufffdKB73v\ufffd\u0012\u0000Q\u0012\ufffd&\u6894=\u0016\u67b3L\ufffd",
  Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { (byte)0xa9, (byte)0x96 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x3a };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  ":",
  stringTemp);
}
            bytes = new byte[] { 0x13, (byte)0x9b, (byte)0xba, 0x3b, 0x72,
              0x39, 0x5b, 0x67, 0x2c, (byte)0xe8, 0x66, 0x32, (byte)0xa1,
              (byte)0xe5, 0x35, (byte)0xe9 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u0013\ufffd\ufffd;r9[g\u002c\ufffdf2\u22665\ufffd",
  stringTemp);
}
            bytes = new byte[] { (byte)0xe1, 0x7d, (byte)0xfc, (byte)0xf3,
              (byte)0xba, (byte)0xe3, 0x50, (byte)0xec, (byte)0xcc, 0x7a,
              0x5b, 0x54, 0x5d, 0x65, (byte)0xbb, 0x5a, 0x3c, 0x27, 0x35,
              (byte)0xaa, 0x6e, 0x44, (byte)0xad, 0x79, (byte)0x9c,
              (byte)0x95, (byte)0xe5, 0x64, (byte)0x85, (byte)0x92 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd}\u2172\u51b4P\u8cc1z.get(T)e\ufffdZ<'5\ufffdnD\ufffdy\ufffd\ufffd\ufffdd\ufffd\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x02, (byte)0xda, 0x24, (byte)0xf7, 0x51,
              0x30, 0x5c, 0x06, (byte)0xfb, (byte)0xea, (byte)0xfd,
              (byte)0x9b, 0x1b, (byte)0x92, 0x5b, (byte)0xac, (byte)0xba };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u0002\ufffd$\ufffdQ0\\\u0006\u8aa7\ufffd\u001b\ufffd[\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x1a, 0x0a, (byte)0x83, 0x69, 0x5d,
              (byte)0xae, 0x4f, 0x01, (byte)0xce, (byte)0xd9, (byte)0xd3,
              (byte)0xc9, 0x2d, 0x0e };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u001a\u000a\ufffdi]\ufffdO\u0001\u96a3\u5587-\u000e",
  stringTemp);
}
            bytes = new byte[] { (byte)0x99, (byte)0xf6, (byte)0xf2, 0x0e,
              (byte)0xee, 0x32, 0x6b, 0x6f, 0x32, 0x1b, (byte)0xc2,
              (byte)0xda, (byte)0xba, (byte)0x98, (byte)0xfa, (byte)0xaf,
              (byte)0xa0, (byte)0xbb, (byte)0xa7, (byte)0x9b, 0x3b,
              (byte)0xe0, 0x32, (byte)0xe2, 0x6d, (byte)0x87 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd\u000e\ufffd2ko2\u001b\u6ede\ufffd\u63f5\ufffd\u85a9\ufffd;\ufffd2\ufffdm\ufffd",
  stringTemp);
}
            bytes = new byte[] { (byte)0xed, 0x2b, 0x59, (byte)0xe3, 0x3f,
              (byte)0xfd, 0x01, 0x72, 0x1b, (byte)0x86, (byte)0x88,
              (byte)0xc8, 0x29, 0x70, 0x4e };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd+Y\ufffd?\ufffd\u0001r\u001b\ufffd\ufffd\ufffd)pN", stringTemp);
}
            bytes = new byte[] { (byte)0xf9 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd",
  stringTemp);
}
            bytes = new byte[] { (byte)0xdf, (byte)0x81, 0x58, 0x42,
              (byte)0xa4, 0x01, 0x0c, (byte)0x8d, 0x06, 0x07, 0x41, 0x6e,
              (byte)0x8e, 0x1d, (byte)0xf6, 0x7a, 0x5a, (byte)0x85, 0x11,
              0x67, 0x11, (byte)0xa5, (byte)0x88, 0x54, 0x0b, 0x2b, 0x7b,
              (byte)0xfa, (byte)0x99, 0x01 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffdXB\ufffd\u0001\u000c\ufffd\u0006\u0007An\ufffd\u001d\ufffdzZ\ufffd\u0011g\u0011\ufffdT\u000b+{\ufffd\u0001",
  stringTemp);
}
            bytes = new byte[] { (byte)0xde, 0x72, 0x51, 0x6d, (byte)0x90,
              0x44, (byte)0xeb, 0x21, 0x53, (byte)0xa4, 0x52, (byte)0x80,
              (byte)0xb7, (byte)0xe5, (byte)0x83, 0x53, (byte)0xa1,
              (byte)0xa9, (byte)0xeb, 0x7d, 0x24 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffdrQm\ufffdD\ufffd!S\ufffdR\ufffd\u6841\ufffdS\uff1f\ufffd}$",
  stringTemp);
}
            bytes = new byte[] { (byte)0xff, 0x52, 0x05, (byte)0xae, 0x6b,
              0x12, 0x19, (byte)0x8c, 0x6b, 0x39, 0x0e, (byte)0xf5, 0x72,
              0x60, (byte)0x96, 0x28, (byte)0xf1, 0x63, (byte)0xd9, 0x56,
              (byte)0x8a, 0x3c, (byte)0x90, (byte)0xa5, 0x69, 0x4b };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffdR\u0005\ufffdk\u0012\u0019\ufffdk9\u000e\ufffdr`\ufffd(\ufffdc\ufffdV\ufffd<\ufffd\ufffdiK",

 stringTemp);
}
            bytes = new byte[] { 0x45, (byte)0xfa, (byte)0xca, 0x59,
              (byte)0xfc, 0x56, (byte)0xbb, (byte)0x95, 0x2b, 0x52, 0x3d,
              (byte)0xaa, 0x1a, 0x3b, (byte)0xba, (byte)0xa2 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "E\u67c0Y\ufffdV\ufffd+R=\ufffd\u001a;\u9803",
  stringTemp);
}
            bytes = new byte[] { 0x3a, 0x13, 0x4b, (byte)0x9a, 0x0b,
              (byte)0xf6, (byte)0xfc, 0x4d, (byte)0xc8, (byte)0xf8, 0x3c,
              0x4e, 0x20 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  ":\u0013K\ufffd\u000b\ufffdM\u5c3e<N ",
  stringTemp);
}
            bytes = new byte[] { (byte)0x8a, 0x01, 0x0c, 0x1b };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd\u0001\u000c\u001b",
  stringTemp);
}
            bytes = new byte[] { 0x7f, 0x28, 0x1e, (byte)0xd9, 0x21,
              (byte)0xc9, (byte)0xe1, (byte)0xbf, (byte)0xc1, 0x39, 0x62,
              0x61, 0x2c, (byte)0xb4, 0x1e, (byte)0xe1, (byte)0x81, 0x33,
              (byte)0x9a, (byte)0x8c, 0x01, (byte)0x84, (byte)0x91,
              (byte)0xdb };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u007f(\u001e\ufffd!\u666e\u79e69ba\u002c\ufffd\u001e\ufffd3\ufffd\ufffd\u0001\ufffd\ufffd\ufffd",

 stringTemp);
}
            bytes = new byte[] { 0x42, (byte)0xa9, 0x18, 0x40, (byte)0xfc,
              0x3c, (byte)0x96, 0x10, (byte)0xdb, 0x02, (byte)0xfb, 0x1f,
              0x6e, 0x2f };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "B\ufffd\u0018@\ufffd<\ufffd\u0010\ufffd\u0002\ufffd\u001fn/",
  stringTemp);
}
            bytes = new byte[] { (byte)0xa7, (byte)0x9d, (byte)0xe6,
              (byte)0xf2, (byte)0xdb, (byte)0xf6, (byte)0xff, (byte)0xc0,
              0x0f, 0x33, (byte)0xe5, (byte)0xed, 0x60, 0x34, 0x2a, 0x26,
              0x44, 0x50, (byte)0xea, 0x67, 0x4a, 0x44 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd\u80d9\u6901\ufffd\ufffd\u000f3\u7e83`4*&DP\ufffdgJD",
  stringTemp);
}
  bytes = new byte[] { (byte)0xff, 0x6d, (byte)0xf0, 0x0f, (byte)0x92, 0x02 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffdm\ufffd\u000f\ufffd\u0002",
  stringTemp);
}
            bytes = new byte[] { 0x34, 0x54, (byte)0xb3, (byte)0x88,
              (byte)0xf8, 0x7f, (byte)0xb1, 0x6f, 0x1d, (byte)0xc3, 0x14,
              0x68, (byte)0xa9, 0x21, 0x42, (byte)0xb9, 0x7d, 0x5f, 0x54,
              (byte)0x8b };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "4T\ufffd\ufffd\u007f\ufffdo\u001d\ufffd\u0014h\ufffd!B\ufffd}_T\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x3c, (byte)0x86, 0x3f, 0x64, 0x58, 0x13,
              0x6d, (byte)0xa5, 0x3e, 0x2e, (byte)0xe8, 0x3c, (byte)0xec,
              (byte)0xbc, 0x42, (byte)0xeb, 0x67, 0x1b, (byte)0xfa,
              (byte)0x84, 0x45, (byte)0xeb, (byte)0x80, 0x51, 0x4c,
              (byte)0xa3, 0x60 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "<\ufffd?dX\u0013m\ufffd>.\ufffd<\u8c85B\ufffdg\u001b\ufffdE\ufffdQL\ufffd`",
  stringTemp);
}
            bytes = new byte[] { (byte)0x87, (byte)0xa8, 0x10, 0x76, 0x3a,
              (byte)0x8e, (byte)0xb8, 0x79, 0x54, (byte)0xc6, (byte)0xb7 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd\u0010v:\uff78yT\u77b3",
  stringTemp);
}
            bytes = new byte[] { 0x52, (byte)0xe6, (byte)0x9e, (byte)0xef,
              0x5e, (byte)0xb8, (byte)0xec, (byte)0xed, (byte)0xbe,
              (byte)0x93, 0x05, (byte)0xe1, 0x49 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "R\ufffd\ufffd^\u8a9e\u8eb1\ufffd\u0005\ufffdI",
  stringTemp);
}
            bytes = new byte[] { 0x41, (byte)0xbc, (byte)0x94, 0x79,
              (byte)0x92, 0x5f, (byte)0x8e };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "A\ufffdy\ufffd_\ufffd",
  stringTemp);
}
            bytes = new byte[] { (byte)0xc1, 0x68, 0x45 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffdhE",
  stringTemp);
}
            bytes = new byte[] { 0x1c, 0x2e, (byte)0x83, (byte)0x85, 0x23,
              (byte)0xac, (byte)0xee, (byte)0xf7, (byte)0x9d, (byte)0x8e,
              0x29, (byte)0xe5, (byte)0xe6, (byte)0x92, 0x3b, (byte)0xb4,
              (byte)0xc2, (byte)0xf6, 0x25, 0x7c, 0x34, 0x1d, 0x68 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u001c.\ufffd\ufffd#\ufffd\ufffd\ufffd)\u7e59\ufffd;\u6f97\ufffd%|4\u001dh",
 stringTemp);
}
            bytes = new byte[] { 0x51, 0x02, (byte)0xef, 0x42, 0x70,
              (byte)0xbc, 0x75, 0x6d, 0x1e, (byte)0xc1, (byte)0xaa, 0x7c,
              (byte)0xb9, 0x3a, 0x6a, 0x7c, (byte)0xb7, (byte)0xf0,
              (byte)0xd2, 0x01, (byte)0xf1, 0x4c, 0x5b, (byte)0xef, 0x42,
              0x66 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "Q\u0002\ufffdBp\ufffdum\u001e\u9078|\ufffd:j|\u5039\ufffd\u0001\ufffdL[\ufffdBf",
  stringTemp);
}
            bytes = new byte[] { (byte)0xdf, (byte)0xd1, 0x59, 0x07, 0x65,
              (byte)0xbf, 0x01, 0x5e, 0x4d, 0x62, 0x43, (byte)0x83 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u703eY\u0007e\ufffd\u0001^MbC\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x6c, (byte)0xc6, (byte)0xb4, (byte)0xe6,
              0x22, 0x71, (byte)0xf0, 0x22, (byte)0xf6, 0x0a, 0x78,
              (byte)0xc1, (byte)0xc8, (byte)0x9d, (byte)0xe8, (byte)0xef,
              0x08, 0x24, 0x35, (byte)0xef, 0x3a, 0x3c, 0x2c, 0x7c,
              (byte)0xcd, 0x47 };
            Assert.assertEquals(
  "l\u61a7\ufffd\"q\ufffd\"\ufffd\u000ax\u7d44\ufffd\u84d6\u0008$5\ufffd:<\u002c|\ufffdG",
  Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { (byte)0xbd, 0x5e, (byte)0xb7, (byte)0xf6 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd^\u55a7",
  stringTemp);
}
            bytes = new byte[] { (byte)0xb8, (byte)0xa5, (byte)0xb9,
              (byte)0xa9, 0x70, 0x7b, 0x26, (byte)0xc4, (byte)0xb9, 0x5e,
              0x40, (byte)0xad, (byte)0xab, (byte)0x99, 0x19, (byte)0xf7,
              (byte)0xeb, 0x64, 0x78, (byte)0xbe, 0x49, (byte)0xc9, 0x36,
              0x6d };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u732e\u5de5p {&\u9577^@\u246a\ufffd\u0019\ufffddx\ufffdI\ufffd6m",
  stringTemp);
}
            bytes = new byte[] { 0x6c, 0x14, 0x42, (byte)0xc4, 0x2a, 0x2d,
              (byte)0xad, 0x69 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "l\u0014B\ufffd*-\ufffdi",
  stringTemp);
}
            bytes = new byte[] { 0x54, (byte)0xb6, 0x74, 0x6b, (byte)0xc6,
              (byte)0xfe, 0x1f, 0x71, 0x1d, (byte)0xaa, 0x2d, (byte)0x8a,
              0x14, (byte)0xdf, 0x4b, (byte)0xa0, 0x60, (byte)0xab, 0x1a,
              0x57, 0x74 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "T\ufffdtk\u5165\u001fq\u001d\ufffd-\ufffd\u0014\ufffdK\ufffd`\ufffd\u001aWt",
  stringTemp);
}
            bytes = new byte[] { 0x49, (byte)0xcc, 0x72, 0x72, 0x2f,
              (byte)0xf8, (byte)0x85, 0x65, 0x2f, 0x70, 0x61, (byte)0xc6,
              (byte)0xc0, 0x75, 0x26 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "I\ufffdrr/\ufffde/pa\u5f97u&",
  stringTemp);
}
            bytes = new byte[] { 0x55, (byte)0xb6, (byte)0xad, 0x5a, 0x26,
              0x54, 0x35, 0x3c, 0x34, 0x7f, 0x71, (byte)0xf7, 0x57, 0x78,
              (byte)0xfc, (byte)0x9c };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "U\u5883Z&T5<4\u007fq\ufffdWx\ufffd",
  stringTemp);
}
            bytes = new byte[] { (byte)0xb8, (byte)0xa4, (byte)0xa6,
              (byte)0xa9, 0x44, (byte)0xba, 0x3b, (byte)0x82, (byte)0xec,
              0x63 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u72ac\u0399D\ufffd;\ufffd\ufffdc",
  stringTemp);
}
            bytes = new byte[] { 0x1a, (byte)0xf1, 0x7f, 0x3a, (byte)0xfa,
              (byte)0x86, (byte)0xcf };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u001a\ufffd\u007f:\ufffd\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x58, 0x24, 0x77, 0x14, 0x4d, (byte)0xf1,
              (byte)0xd7, (byte)0xac, (byte)0xd2, (byte)0xfa, (byte)0xa2,
              0x39, 0x7d, (byte)0x96 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "X$w\u0014M\u9a05\ufffd\u605d9}\ufffd",
  stringTemp);
}
            bytes = new byte[] { (byte)0xc3, 0x4d, 0x0a, 0x1f, 0x41,
              (byte)0xec, (byte)0xf3, 0x4a, 0x13, 0x7d, (byte)0x8b,
              (byte)0xab, (byte)0xb9, 0x49, 0x2e, 0x26, 0x6e, 0x1f,
              (byte)0x99, 0x19, (byte)0x9b, (byte)0x97, 0x07, 0x4d,
              (byte)0xd3, 0x56, 0x0e, (byte)0xde };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffdM\u000a\u001fA\u8e08J\u0013}\ufffd\ufffdI.&n\u001f\ufffd\u0019\ufffd\ufffd\u0007M\ufffdV\u000e\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x3e, (byte)0x84, 0x4b, (byte)0xc6,
              (byte)0x9a, 0x3b, 0x4d, 0x6a, 0x0f };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  ">\ufffdK\ufffd;Mj\u000f",
  stringTemp);
}
        bytes = new byte[] { 0x38, (byte)0xb8, 0x5d, (byte)0xd0, 0x2f, 0x78 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "8\ufffd]\ufffd/x",
  stringTemp);
}
            bytes = new byte[] { 0x2e, 0x3a, (byte)0xfe, (byte)0xc7, 0x6b,
              0x0b, 0x17, 0x46, 0x64, 0x23, 0x47, 0x05, 0x75, 0x19, 0x63,
              0x67 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  ".:\ufffdk\u000b\u0017Fd#G\u0005u\u0019cg",
  stringTemp);
}
            bytes = new byte[] { 0x36, (byte)0xf2, 0x3e, 0x65, (byte)0xab,
              (byte)0xad, 0x11, (byte)0xa3, (byte)0xe6, (byte)0xaa, 0x02,
              0x64, 0x1a, (byte)0xde, 0x79, 0x5e, (byte)0xf8, (byte)0xca };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "6\ufffd>e\ufffd\u0011\uff46\ufffd\u0002d\u001a\ufffdy^\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x64, (byte)0x8e, 0x2b, 0x66, 0x6c, 0x4a,
              0x2a, 0x7b, 0x73, (byte)0xba, 0x7c, 0x57, 0x22, 0x50, 0x7d,
              (byte)0x96, 0x40, (byte)0xbb, 0x6c, 0x10, (byte)0x87, 0x5d,
              (byte)0x96, (byte)0x83, (byte)0xa8, (byte)0x84, 0x7d, 0x7b,
              (byte)0xb7 };
            Assert.assertEquals(
  "d\ufffd+flJ*{s\ufffd|W\"P}\ufffd@\ufffdl\u0010\ufffd]\ufffd\ufffd\ufffd}{\ufffd",
  Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x17, (byte)0xf1, (byte)0xb2, (byte)0xb4,
              0x63, 0x1f, (byte)0xee, 0x53, (byte)0x84, (byte)0x83,
              (byte)0xee, 0x5d, 0x40, (byte)0xb9, 0x06, 0x49, 0x2d,
              (byte)0x82, 0x47, (byte)0xd8 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u0017\u9921\ufffdc\u001f\ufffdS\ufffd\ufffd\ufffd]@\ufffd\u0006I-\ufffdG\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x01, (byte)0x98, 0x2d, (byte)0xc8, 0x63,
              (byte)0x92, 0x20, 0x6b, 0x04, 0x7e, 0x21, 0x53, (byte)0xf9,
              (byte)0xee, 0x51, (byte)0xc9, 0x1a, 0x59, (byte)0xf1,
              (byte)0xdb };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u0001\ufffd-\ufffdc\ufffd k\u0004~!S\u5becQ\ufffd\u001aY\u9a37",
  stringTemp);
}
            bytes = new byte[] { 0x3d, 0x08, 0x79, 0x70, 0x4d, 0x33, 0x76,
              0x1d, (byte)0xd9, 0x22, 0x4e };
            Assert.assertEquals(
             "=\u0008ypM3v\u001d\ufffd\"N",
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x6d, 0x2d, 0x10, (byte)0x97, 0x29, 0x23,
              0x51, (byte)0xa7, 0x78, 0x5e };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "m-\u0010\ufffd)#Q\ufffdx^", stringTemp);
}
            bytes = new byte[] { 0x5e, (byte)0xc2, 0x74, 0x58, 0x5d, 0x40,
              0x5f, (byte)0xdf, (byte)0xa7, 0x5e, (byte)0xe4, 0x4b,
              (byte)0xaf, 0x37, (byte)0x9a, 0x72, (byte)0x8f, (byte)0xec,
              0x4d, (byte)0x82, 0x6e, (byte)0xc0, 0x72, 0x59, (byte)0xfb,
              0x22, (byte)0x9e, (byte)0xbd, 0x69, 0x40 };
            Assert.assertEquals(
  "^\ufffdtX]@_\u6f81^\ufffdK\ufffd7\ufffdr\ufffdM\ufffdn\ufffdrY\ufffd\"\ufffd\ufffdi@",
  Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { (byte)0xf9, 0x6f, 0x5d, (byte)0xa0 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffdo]\ufffd",
  stringTemp);
}
            bytes = new byte[] { (byte)0xf1, (byte)0xdb, 0x29, 0x3d,
              (byte)0xcc, (byte)0xc0, 0x59, 0x09, 0x10, 0x65, (byte)0xbf,
              0x0a, (byte)0xb1, 0x21, 0x2b, 0x68 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u9a37)=\u660eY\u0009\u0010e\ufffd\u000a\ufffd!+h", stringTemp);
}
            bytes = new byte[] { 0x61, 0x2f, (byte)0xdf, (byte)0xe5,
              (byte)0xa0, 0x4c, (byte)0xde, (byte)0xcf, (byte)0xc9,
              (byte)0x91, 0x04, (byte)0xd1, (byte)0x80, 0x6f, 0x39, 0x5b,
              0x30, 0x4e, (byte)0xbc, 0x22, (byte)0xe7, (byte)0xda, 0x3b,
              (byte)0x95, 0x1b, 0x54 };
            Assert.assertEquals(
  "a/\u7165\ufffdL\u6e2d\ufffd\u0004\ufffdo9[0N\ufffd\"\u8259;\ufffd\u001bT",
  Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x22, (byte)0x85, 0x43, 0x51, (byte)0x8a,
              (byte)0xd7, 0x67, 0x0f, (byte)0xf1, 0x39, 0x72, 0x23, 0x4b };
            Assert.assertEquals(
             "\"\ufffdCQ\ufffd\ufffdg\u000f\ufffd9r#K",
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x74, 0x7b, (byte)0xed, (byte)0xd5,
              (byte)0x87, 0x69, 0x7f, (byte)0xfe, 0x51, 0x75, (byte)0xec,
              0x72, (byte)0xfe, (byte)0xe4, 0x0c, (byte)0xbe, 0x15,
              (byte)0xad, 0x01, 0x3a, (byte)0x9b, 0x7a, 0x72, 0x71 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "t {\u8f3b\ufffdi\u007f\ufffdQu\ufffdr\ufffd\u000c\ufffd\u0015\ufffd\u0001:\ufffdzrq",
  stringTemp);
}
            bytes = new byte[] { (byte)0x9d, (byte)0xca, 0x4b, (byte)0xe4,
              0x41, 0x6e, (byte)0xf7, (byte)0xd0, 0x4d, 0x2d, (byte)0x8e,
              0x22, (byte)0xd0, (byte)0xdf, (byte)0xa9, (byte)0x80, 0x07,
              0x32, (byte)0xcf, 0x36, 0x4d, (byte)0xd5, 0x1b, (byte)0xfb,
              (byte)0xe4, 0x24, (byte)0xe7, 0x2b, (byte)0x84 };
            Assert.assertEquals(
  "\ufffd\ufffdK\ufffdAn\ufffdM-\ufffd\"\u4fe4\ufffd\u00072\ufffd6M\ufffd\u001b\ufa21$\ufffd+\ufffd",
  Encodings.DecodeToString(charset, bytes));
        bytes = new byte[] { (byte)0xf9, (byte)0xca, 0x30, 0x36, (byte)0xab };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u52a606\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x57, 0x4a, 0x2a, 0x3f, (byte)0xcf,
              (byte)0xa7, 0x56, (byte)0xbd, (byte)0xfa, 0x6f, (byte)0xb1 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "WJ*?\u7089V\u6055o\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x6b, (byte)0xc7, (byte)0xe9, 0x5d, 0x16,
              0x43, 0x53, (byte)0x8b, 0x5b, 0x30, (byte)0xf4, 0x5d,
              (byte)0xa2, 0x35 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "k\u79e4]\u0016CS\ufffd.get(0\ufffd)\ufffd5",
  stringTemp);
}
            bytes = new byte[] { (byte)0xd6, 0x47, (byte)0xdf, (byte)0xd3,
              (byte)0xb6, (byte)0x9a, (byte)0xc2, 0x78, 0x78, 0x63,
              (byte)0x83, 0x56, 0x69, 0x57 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffdG\u7051\ufffd\ufffdxxc\ufffdViW",
  stringTemp);
}
        bytes = new byte[] { 0x6e, 0x38, 0x5b, 0x71, 0x5f, (byte)0x86, 0x78 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "n8[q_\ufffdx",
  stringTemp);
}
            bytes = new byte[] { (byte)0xe1, 0x67, (byte)0x8c, (byte)0xe8,
              (byte)0xb7, (byte)0xcd, 0x67, 0x63, 0x21, (byte)0xba,
              (byte)0xbe, 0x29, (byte)0xef, 0x44, 0x7a, 0x04, 0x54, 0x12,
              (byte)0xb1, 0x40, 0x12 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffdg\ufffd\u838a\ufffdgc!\u8a50)\ufffdDz\u0004T\u0012\ufffd@\u0012",
  stringTemp);
}
            bytes = new byte[] { 0x65, 0x3d, 0x6d, 0x76, 0x47, (byte)0x90,
              (byte)0xc3, (byte)0xce, (byte)0xc9, (byte)0xa3, (byte)0xb7,
              0x3c, (byte)0xf7, 0x0c, (byte)0x8a, 0x66, 0x52, 0x32 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "e=mvG\ufffd\u77e5\u7a17\ufffd<\ufffd\u000c\ufffdfR2",
  stringTemp);
}
            bytes = new byte[] { (byte)0xe1, 0x07, 0x77, (byte)0xf4,
              (byte)0xb2, 0x4c, (byte)0xf2, 0x2d, 0x23, 0x3f, 0x4e, 0x7f,
              0x28, 0x33, 0x26, (byte)0xfc, 0x3d, (byte)0x92, (byte)0xba };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd\u0007w\ufffdL\ufffd-#?N\u007f(3&\ufffd=\ufffd\ufffd", stringTemp);
}
            bytes = new byte[] { (byte)0xd5, (byte)0xd0, (byte)0x92,
              (byte)0x9e, 0x00, (byte)0xe9, (byte)0x99, (byte)0xf2, 0x06 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u5b43\ufffd\ufffd\u0000\ufffd\ufffd\u0006",
  stringTemp);
}
            bytes = new byte[] { 0x5a, 0x20, (byte)0xf5, 0x61, 0x42, 0x52,
              (byte)0x9f, 0x73, (byte)0xff, 0x54, 0x03, 0x07, (byte)0x92,
              0x4d, (byte)0x84, (byte)0xd2, 0x60, 0x5c, 0x41, 0x78, 0x6f,
              (byte)0xf6, 0x4e, (byte)0xf3, (byte)0xa5 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "Z \ufffdaBR\ufffds\ufffdT\u0003\u0007\ufffdM\ufffd\ufffd`\\Axo\ufffdN\u9d50",
  stringTemp);
}
            bytes = new byte[] { 0x62, (byte)0x96, 0x2f, 0x2e, (byte)0xa7,
              (byte)0xc6, 0x12 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "b\ufffd/.\ufffd\u0012",
  stringTemp);
}
            bytes = new byte[] { 0x45, (byte)0x94, (byte)0xcf, 0x7f, 0x25,
              (byte)0x8d, (byte)0x9a, 0x59, (byte)0x8e };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "E\ufffd\ufffd\u007f%\ufffd\ufffdY\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x6a, (byte)0xfa, 0x32, 0x61, 0x1a, 0x72,
              (byte)0xc4, 0x6f, 0x74, (byte)0xaa, (byte)0xdc, 0x49,
              (byte)0x97, (byte)0xec, (byte)0x8e, (byte)0xad };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "j\ufffd2a\u001ar\ufffdot\ufffdI\ufffd\ufffd\ufffd",
  stringTemp);
}
            bytes = new byte[] { (byte)0xab, 0x58, (byte)0xf6, 0x1d,
              (byte)0xb9, 0x3b, 0x43, 0x3a, 0x69, 0x43, (byte)0xc7,
              (byte)0x9b, (byte)0xf1, 0x18, 0x31, 0x3e, (byte)0xeb,
              (byte)0xa4, (byte)0x8d, 0x7f, (byte)0x93 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffdX\ufffd\u001d\ufffd;C:iC\ufffd\ufffd\u00181>\u896a\ufffd\u007f\ufffd",
  stringTemp);
}
            bytes = new byte[] { (byte)0xa4, 0x06, (byte)0x85, 0x39,
              (byte)0xc5, 0x5f, (byte)0xdc, (byte)0xd8, (byte)0xa8,
              (byte)0xee, (byte)0xe0 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd\u0006\ufffd9\ufffd_\u69b4\ufffd\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x37, 0x29, 0x60, 0x4f, 0x64, (byte)0x81,
              0x64, 0x3d, (byte)0xcc, (byte)0xdd, 0x1b, (byte)0x92, 0x23,
              (byte)0x98, 0x51 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "7)`Od\ufffdd=\u6762\u001b\ufffd#\ufffdQ", stringTemp);
}
            bytes = new byte[] { 0x7d, (byte)0xac, 0x4f, 0x65, (byte)0xe3,
              0x21, (byte)0xff, 0x5a, (byte)0xdd, 0x56, 0x2e, 0x43 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "}\ufffdOe\ufffd!\ufffdZ\ufffdV.C",
  stringTemp);
}
            bytes = new byte[] { (byte)0xe2, (byte)0xd7, (byte)0xe8, 0x2c,
              0x39, 0x4a, (byte)0xd3, (byte)0xa9, 0x79, 0x26 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u77b0\ufffd\u002c9J\u550fy&",
  stringTemp);
}
            bytes = new byte[] { (byte)0xb9, (byte)0xde, 0x39, (byte)0xc1,
              0x4d, 0x0f, (byte)0xcc, (byte)0xfe, (byte)0xba, 0x36,
              (byte)0x99, 0x1c, 0x68, (byte)0x8a, (byte)0xf0 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u95a49\ufffdM\u000f\u7652\ufffd6\ufffd\u001ch\ufffd\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x7b, (byte)0xd0, 0x3b, (byte)0xa3, 0x67,
              0x6e, 0x7f, 0x5a, 0x45, 0x1a, (byte)0xd2, 0x73, (byte)0xd2,
              0x6d, 0x6b, (byte)0xb1, (byte)0xc4, (byte)0xc3, 0x13,
              (byte)0x86, 0x49, 0x38, 0x22, 0x76, 0x3a, 0x3b, (byte)0xbd,
              0x6c };
            Assert.assertEquals(
  "{\ufffd;\ufffdgn\u007fZE\u001a\ufffds\ufffdmk\u55b6\ufffd\u0013\ufffdI8\"v:;\ufffdl",
  Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x76, 0x39, (byte)0x81, 0x28, 0x2c,
              (byte)0xf6, (byte)0xdc, 0x38, (byte)0xf6, (byte)0x9e, 0x4b,
              0x56, 0x20, 0x52, 0x30, (byte)0xe3, 0x3e, (byte)0xef, 0x77,
              0x7f, 0x7a, (byte)0xaa, (byte)0xb1, (byte)0xdf };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "v9\ufffd(\u002c\ufffd8\ufffdKV R0\ufffd>\ufffdw\u007fz\ufffd\ufffd",
  stringTemp);
}
            bytes = new byte[] { (byte)0xd4, 0x40, 0x69, 0x65, (byte)0x89,
              (byte)0xd3, (byte)0xdd, 0x04, (byte)0xee, 0x20, (byte)0xb0,
              (byte)0xbc, (byte)0xe2, (byte)0xe6, 0x36, (byte)0x8b, 0x4a,
              (byte)0x83, (byte)0xa0, (byte)0xf0, (byte)0xe7, 0x3a, 0x3f,
              0x16, (byte)0xed };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd@ie\ufffd\u5636\u0004\ufffd \u7d62\u780c6\ufffdJ\ufffd\ufffd\u97c3:?\u0016\ufffd",
  stringTemp);
}
            bytes = new byte[] { (byte)0xbe, 0x5a, 0x3e, 0x41, 0x22,
              (byte)0xdf, 0x4c, 0x35, (byte)0x92, 0x5b, 0x19, 0x48, 0x02,
              (byte)0x8e, 0x37, 0x2c, (byte)0xbf, (byte)0xa9, (byte)0xc8,
              0x70, 0x49, 0x4f, 0x6d, 0x0b, 0x29 };
            Assert.assertEquals(
  "\ufffdZ>A\"\ufffdL5\ufffd[\u0019H\u0002\ufffd7\u002c\u98df\ufffdpIOm\u000b)",

             Encodings.DecodeToString(charset,
 bytes));
            bytes = new byte[] { (byte)0xe9, 0x17, (byte)0xf5, 0x54,
              (byte)0xe4, (byte)0xd6, (byte)0xe5, (byte)0xea, 0x2a, 0x19,
              (byte)0x95 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd\u0017\ufffdT\u7c4c\u7e69*\u0019\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x65, 0x52, 0x3a, (byte)0xb6, (byte)0xfd };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "eR:\u5c51",
  stringTemp);
}
            bytes = new byte[] { 0x3d, (byte)0x95, (byte)0xc4, (byte)0xe1,
              (byte)0xf9, 0x55, 0x47, 0x48, (byte)0xb6, 0x6b, 0x2e,
              (byte)0x84, (byte)0xe2, 0x46, (byte)0xfb, (byte)0x8e,
              (byte)0xc9, (byte)0xe1 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "=\ufffd\u9db4\ufffdUGH\ufffdk.\ufffd\ufffdF\ufffd\u666e",
  stringTemp);
}
            bytes = new byte[] { (byte)0x8b, 0x2b, 0x1a, (byte)0x90, 0x42,
              0x17, 0x0d, 0x6d, 0x55, 0x25, 0x05, 0x28, (byte)0xb1, 0x03,
              (byte)0xe8, (byte)0xc4, 0x68, 0x36, (byte)0xc2, (byte)0x95,
              (byte)0xf4, 0x51, 0x60 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd+\u001a\ufffdB\u0017\u000dmU%\u0005(\ufffd\u0003\u8403h6\ufffd\ufffdQ`",

 stringTemp);
}
            bytes = new byte[] { 0x12, (byte)0xc7, 0x33, 0x5b, (byte)0x90,
              0x03, (byte)0xec, 0x65, 0x24, 0x5b, 0x31, 0x14, (byte)0xf6,
              0x7f, (byte)0xf7, 0x3b, (byte)0x91, 0x45, 0x49, (byte)0x90 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u0012\ufffd3[\ufffd\u0003\ufffde$[1\u0014\ufffd\u007f\ufffd;\ufffdEI\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x7a, (byte)0xe8, 0x39, (byte)0xb4, 0x4d,
              0x28, 0x4f, 0x7b, 0x4a, (byte)0xc3, (byte)0xe2, (byte)0xee,
              0x54, (byte)0xc8, (byte)0xbe, 0x10, 0x38, (byte)0x90,
              (byte)0xa6, (byte)0xf1, (byte)0xe5, (byte)0xd2, (byte)0xb3,
              0x55, 0x4d, 0x3d, (byte)0xd9, 0x31 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "z\ufffd9\ufffdM(O {J\u7a92\ufffdT\u534a\u00108\ufffd\ufffd\u7e21\ufffdUM=\ufffd1",

 stringTemp);
}
            bytes = new byte[] { (byte)0xa5, 0x24, (byte)0xe0, 0x19,
              (byte)0x8c, 0x7f, 0x14, (byte)0xb9, 0x24, (byte)0x8b, 0x7c,
              (byte)0x84, (byte)0xcc, (byte)0x83, 0x6b, (byte)0x8e };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd$\ufffd\u0019\ufffd\u007f\u0014\ufffd$\ufffd|\ufffd\ufffdk\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x66, 0x49, 0x5b, 0x43, 0x05, 0x53, 0x11,
              0x6f, (byte)0xc6, (byte)0x8c, (byte)0xc8, 0x08, (byte)0xac,
              0x24, 0x1e, 0x63, 0x70, 0x52, 0x55, (byte)0xea, (byte)0xa6,
              0x75, (byte)0xd6, (byte)0xa2, 0x39, (byte)0xcd };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "fI[C\u0005S\u0011o\ufffd\ufffd\u0008\ufffd$\u001ecpRU\u879fu\u5c4f9\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x7c, (byte)0xfc, 0x5a, 0x3a, (byte)0xbb,
              (byte)0xbb, 0x54, 0x35, 0x4a, (byte)0x9b, (byte)0xfa, 0x5c,
              (byte)0xf9, (byte)0xc9, (byte)0x8a, 0x67, 0x4a, 0x79,
              (byte)0x99, (byte)0xdf, 0x6a, (byte)0xd8, 0x00 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "|\ufffdZ:\u7b97T5J\ufffd\ufffd\\\u529c\ufffdgJy\ufffd\ufffdj\ufffd\u0000",
  stringTemp);
}
            bytes = new byte[] { 0x1f, (byte)0xd0, (byte)0x9e, (byte)0xf7,
              (byte)0x88, 0x48, (byte)0x80, 0x7c, 0x11 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u001f\ufffd\ufffdH\ufffd|\u0011",
  stringTemp);
}
            bytes = new byte[] { (byte)0x83, 0x36, 0x7d, 0x21, (byte)0xdf,
              (byte)0x9e, (byte)0xf5, (byte)0xd3, 0x7f, (byte)0x8e, 0x42,
              (byte)0x89, 0x0b, 0x29, 0x73, 0x7a, 0x6c, (byte)0xae, 0x61,
              0x70 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd6}!\ufffd\ufffd\u007f\ufffdB\ufffd\u000b)szl\ufffdap", stringTemp);
}
            bytes = new byte[] { 0x24, 0x71, (byte)0xe3, 0x48, 0x63, 0x7b,
              0x1d, 0x42, 0x72, 0x3e, (byte)0xd0, (byte)0xd4, 0x0d, 0x72,
              0x4f, 0x13, (byte)0xd2, 0x24, (byte)0xcc, (byte)0xf8 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "$q\ufffdHc {\u001dBr>\u4f86\u000drO\u0013\ufffd$\u67f3",
  stringTemp);
}
            bytes = new byte[] { 0x30, (byte)0xd5, 0x5e, 0x0a, (byte)0xe6,
              0x51, (byte)0xb7, (byte)0xd7, 0x2a, 0x74, (byte)0xdd,
              (byte)0xc2, (byte)0x88, 0x73, 0x0f, (byte)0xa4, (byte)0xf0,
              (byte)0x86, 0x23, 0x05, (byte)0x80, 0x05, 0x47, 0x33, 0x26,
              0x02, 0x77, (byte)0xe0, 0x10 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "0\ufffd^\u000a\ufffdQ\u8a08*t\u6b5b\ufffds\u000f\u3090\ufffd#\u0005\ufffd\u0005G3&\u0002w\ufffd\u0010",
  stringTemp);
}
            bytes = new byte[] { (byte)0xfe, 0x68, (byte)0xa8, 0x47,
              (byte)0x91, (byte)0xb2, 0x29, 0x4d, (byte)0xcf, 0x78, 0x13,
              0x5e, 0x4b, 0x73, (byte)0xd0, 0x1a, 0x5f, (byte)0x84,
              (byte)0xa7, 0x1c, (byte)0xf7 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffdh\ufffdG\ufffd\ufffd)M\ufffdx\u0013^Ks\ufffd\u001a_\ufffd\ufffd\u001c\ufffd",

 stringTemp);
}
            bytes = new byte[] { (byte)0xb4, 0x21, 0x4b, (byte)0xca };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\ufffd!K\ufffd",
  stringTemp);
}
            bytes = new byte[] { 0x11, 0x73, (byte)0xf5, 0x47, 0x08,
              (byte)0xea, (byte)0xe5 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u0011s\ufffdG\u0008\u88d9",
  stringTemp);
}
            bytes = new byte[] { 0x03, 0x5e, 0x58, (byte)0xc9, 0x3c,
              (byte)0xbb, 0x63, 0x6f, (byte)0x99, 0x66, (byte)0x9b, 0x37 };
            {
String stringTemp = Encodings.DecodeToString(charset, bytes);
Assert.assertEquals(
  "\u0003^X\ufffd<\ufffdco\ufffdf\ufffd7",
  stringTemp);
}
        }

        @Test
public void TestIso2022JPSpecific() {
            ICharacterEncoding charset = Encodings.GetEncoding("iso-2022-jp");
            byte[] bytes;
      String str;
bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x21, 0x2b, 0x2d, 0x56, 0x3f, 0x6c,
  0x6d, 0x5a, 0x4b, 0x4e, 0x5d, 0x43, 0x5e };
            str = "!+-V?lmZKN]C^";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x45, 0x67, 0x1b, 0x24, 0x40, 0x29, 0x1b,
              0x28, 0x49, 0x6a, 0x24 };
            str = "Eg\ufffd\ufffd\uff64";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x1b, 0x24, 0x40, 0x6a,
              0x57, 0x57, 0x63 };
            str = "\ufffd\u8897\u600e";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x24, 0x40, 0x1b, 0x24, 0x40, 0x52,
              0x40, 0x67, 0x47, 0x72, 0x21, 0x1b, 0x28, 0x49, 0x78, 0x1f,
              0x54, 0x22, 0x57, 0x53, 0x6c, 0x6f, 0x49, 0x48 };
            str =

  "\ufffd\u5346\u81df\u9afb\ufffd\ufffd\uff94\uff62\uff97\uff93\ufffd\ufffd\uff89\uff88";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x42, 0x63, 0x40, 0x38, 0x64,
              0x2b, 0x60, 0x36, 0x2d, 0x47, 0x29, 0x54, 0x2d, 0x29, 0x2f,
              0x45, 0x1b, 0x24, 0x40 };
            str = "c@8d+`6-G)T-)/E";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x53 };
            str = "S";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x48, 0x52, 0x5a, 0x2f, 0x4a,
              0x63, 0x32, 0x2a, 0x40, 0x25, 0x52, 0x55, 0x7b };
            str = "\ufffd(HRZ/Jc2*@%RU {";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x49, 0x47, 0x25, 0x28, 0x1b,
              0x28, 0x49, 0x36, 0x25, 0x4e, 0x23, 0x5d, 0x22, 0x71, 0x65,
              0x78, 0x24, 0x45, 0x7e, 0x76, 0x27, 0x65, 0x58, 0x63, 0x19,
              0x52, 0x35 };
            str =

  "\uff87\uff65\uff68\uff76\uff65\uff8e\uff63\uff9d\uff62\ufffd\ufffd\ufffd\uff64\uff85\ufffd\ufffd\uff67\ufffd\uff98\ufffd\ufffd\uff92\uff75";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x39, 0x27, 0x3f, 0x71, 0x34, 0x75, 0x2e,
              0x52, 0x6e, 0x72, 0x77, 0x25, 0x3e, 0x4f, 0x5a, 0x17, 0x36,
              0x12, 0x49, 0x64, 0x7d };
            str = "9'?q4u.getRnrw()%>OZ\u00176\u0012Id}";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x34, 0x43, 0x60, 0x5d, 0x1b, 0x24, 0x40,
              0x5e, 0x29, 0x36, 0x4a, 0x62, 0x59, 0x72 };
            str = "4C`]\u6d2b\u66f2\u77b9\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
        bytes = new byte[] { 0x24, 0x5c, 0x3e, 0x2c, 0x79, 0x1b, 0x24, 0x40 };
            str = "$\\>\u002cy";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x2f, 0x2c, 0x7d, 0x63, 0x5f, 0x31, 0x70,
              0x40, 0x2d, 0x75, 0x28, 0x71, 0x1b, 0x28, 0x48, 0x62, 0x1b,
              0x24, 0x42, 0x6e, 0x09, 0x4d, 0x1b, 0x24, 0x40, 0x1b, 0x28,
              0x4a, 0x4c, 0x77 };
            str = "/\u002c}c_1p@-u(q\ufffd(Hb\ufffd\ufffd\ufffdLw";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x42, 0x52, 0x5a, 0x76, 0x6e,
              0x51, 0x4f, 0x2a, 0x23 };
            str = "RZvnQO*#";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x48, 0x74 };
            str = "\ufffd(Ht";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x5c };
            str = "\u00a5";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x4b, 0x2f, 0x61, 0x1b,
              0x28, 0x49, 0x70, 0x3d, 0x4a, 0x7d, 0x6f, 0x4f, 0x39, 0x50,
              0x2e };
    str =
  "\u92d2\ufffd\ufffd\uff7d\uff8a\ufffd\ufffd\uff8f\uff79\uff90\uff6e";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x42, 0x4d, 0x5d, 0x5b, 0x54,
              0x30, 0x46, 0x35, 0x12, 0x50, 0x25, 0x37, 0x33, 0x16, 0x1b,
              0x28, 0x48, 0x47, 0x3b, 0x1e, 0x4b, 0x1b, 0x24, 0x42, 0x46,
              0x1b, 0x28, 0x49, 0x2a, 0x77, 0x33, 0x31, 0x42, 0x66, 0x52,
              0x6f };
            str =

  "M][T0F5\u0012P%73\u0016\ufffd(HG;\u001eK\ufffd\uff6a\ufffd\uff73\uff71\uff82\ufffd\uff92\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x48, 0x10, 0x46, 0x67, 0x37,
              0x72, 0x47, 0x36, 0x36, 0x3e, 0x22 };
            str = "\ufffd(H\u0010Fg7rG66>\"";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
  bytes = new byte[] { 0x5c, 0x73, 0x53, 0x39, 0x46, 0x5a, 0x79, 0x42, 0x1e };
            str = "\\sS9FZyB\u001e";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x24, 0x40, 0x49, 0x5e, 0x5c, 0x36 };
            str = "\u6276\u6978";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x74, 0x2b, 0x59, 0x74, 0x2a };
            str = "t+Yt*";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x49, 0x5a, 0x70, 0x3c, 0x1b,
              0x24, 0x42, 0x7e, 0x42, 0x44, 0x1b, 0x28, 0x4a, 0x3a, 0x1b,
              0x28, 0x4a, 0x18, 0x4b, 0x61, 0x21, 0x73, 0x29, 0x1b, 0x28,
              0x48, 0x1b, 0x24, 0x42 };
            str = "\uff9a\ufffd\uff7c\ufffd\ufffd:\u0018Ka!s)\ufffd(H";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x47, 0x31, 0x39, 0x1b,
              0x28, 0x49, 0x55, 0x2c, 0x77, 0x77, 0x61, 0x61, 0x46, 0x42,
              0x60, 0x05, 0x64, 0x75, 0x43, 0x1b, 0x28, 0x49, 0x50, 0x5a,
              0x45, 0x36, 0x3c, 0x63, 0x4b, 0x69, 0x5e, 0x23, 0x6a };
            str =

  "G19\uff95\uff6c\ufffd\ufffd\ufffd\ufffd\uff86\uff82\ufffd\ufffd\ufffd\ufffd\uff83\uff90\uff9a\uff85\uff76\uff7c\ufffd\uff8b\ufffd\uff9e\uff63\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x4d, 0x0f, 0x54, 0x5c, 0x72, 0x5c, 0x6d,
              0x1b, 0x24, 0x40, 0x2d, 0x1b, 0x24, 0x40, 0x3d, 0x65, 0x7e,
              0x7c, 0x7c, 0x67, 0x5d, 0x39, 0x3e, 0x4f, 0x15, 0x7c, 0x1b,
              0x28, 0x4a, 0x2e, 0x7c, 0x6c, 0x1b, 0x24, 0x40, 0x7d };
            str =
  "M\ufffdT\\r\\m\ufffd\u9075\ufffd\u9bb1\u76dc\u7ae0\ufffd\ufffd.|l\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x63, 0x18, 0x50, 0x7a, 0x3f, 0x20, 0x73,
              0x4b, 0x22, 0x76, 0x76, 0x74, 0x3b, 0x67, 0x50, 0x67, 0x76,
              0x51, 0x4c };
            str = "c\u0018Pz? sK\"vvt;gPgvQL";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x49, 0x35, 0x4d, 0x21, 0x33,
              0x6b, 0x5a, 0x1b, 0x28, 0x4a, 0x61, 0x35, 0x50, 0x40, 0x3d,
              0x66, 0x25, 0x0d, 0x3f, 0x3d, 0x4c, 0x1e, 0x2c, 0x1b, 0x24,
              0x42, 0x79, 0x1b, 0x28, 0x49, 0x41 };
            str =

  "\uff75\uff8d\uff61\uff73\ufffd\uff9aa5P@=f%\u000d?=L\u001e\u002c\ufffd\uff81";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
  bytes = new byte[] { 0x73, 0x24, 0x0a, 0x2d, 0x2c, 0x5e, 0x21, 0x27, 0x6b };
            str = "s$\u000a-\u002c^!'k";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x6f, 0x49 };
            str = "oI";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x3c, 0x15, 0x77, 0x1b,
              0x28, 0x42, 0x23, 0x66, 0x7d, 0x60, 0x36, 0x32, 0x41, 0x2b,
              0x65, 0x56, 0x35, 0x10, 0x6b, 0x73, 0x6e, 0x67 };
            str = "<\u0015w#f}`62A+eV5\u0010ksng";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x52, 0x49, 0x1b, 0x28,
              0x4a, 0x56, 0x1b, 0x28, 0x4a, 0x27, 0x51 };
            str = "RIV'Q";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x5a, 0x1b, 0x24, 0x42, 0x75, 0x4e, 0x53,
              0x77, 0x5c, 0x0d, 0x41, 0x76, 0x2e, 0x2e, 0x2b, 0x3d };
            str = "Z\ufffd\u56d3\ufffd\u8d70\ufffd\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x24, 0x6f, 0x3f, 0x49, 0x40, 0x73, 0x2d,
              0x35, 0x22, 0x58, 0x41, 0x5a, 0x68, 0x1b, 0x24, 0x42, 0x35,
              0x25, 0x5a, 0x7b, 0x5b, 0x1b, 0x28, 0x49 };
            str = "$o?I@s-5\"XAZh\u6c7d\u66b9\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x49, 0x3b, 0x2a, 0x68, 0x52,
              0x1b, 0x28, 0x48, 0x47, 0x2a, 0x1b, 0x28, 0x4a, 0x1b, 0x28,
              0x48, 0x33, 0x5d, 0x3f, 0x1b, 0x24, 0x40, 0x59, 0x41, 0x55 };
            str =

  "\uff7b\uff6a\ufffd\uff92\ufffd\uff68\uff88\uff87\uff6a\ufffd(H3]?\u62dc\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x53, 0x43, 0x55, 0x30, 0x1b, 0x28, 0x48,
              0x1b, 0x28, 0x42, 0x33, 0x6a, 0x4c, 0x21, 0x39, 0x74, 0x47,
              0x3e, 0x23, 0x1b, 0x28, 0x48, 0x27, 0x44, 0x26, 0x40, 0x29,
              0x27 };
            str = "SCU0\ufffd(H3jL!9tG>#\ufffd(H'D&@)'";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x49, 0x43, 0x78, 0x6e, 0x66,
              0x59, 0x4b, 0x1b, 0x28, 0x42, 0x62, 0x57, 0x71, 0x13, 0x7a,
              0x32, 0x67, 0x55, 0x34, 0x2b };
            str = "\uff83\ufffd\ufffd\ufffd\uff99\uff8bbWq\u0013z2gU4+";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x1b, 0x28, 0x4a, 0x1b,
              0x28, 0x42, 0x1b, 0x28, 0x42, 0x23, 0x39, 0x77, 0x3e, 0x1b,
              0x28, 0x48, 0x50, 0x5c, 0x0c, 0x7e, 0x4d, 0x3b, 0x66, 0x27,
              0x61, 0x45, 0x56, 0x6c, 0x41, 0x7b, 0x32, 0x48, 0x1b, 0x24,
              0x40, 0x4e, 0x1b, 0x28, 0x48 };
str =
  "\ufffd\ufffd\ufffd#9w>\ufffd(HP\\\u000c~M;f'aEVlA {2H\ufffd\ufffd\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x6a, 0x50, 0x51, 0x1b, 0x24, 0x40, 0x70,
              0x36, 0x27, 0x45, 0x77, 0x5f, 0x58, 0x2a, 0x7e, 0x7b, 0x7a,
              0x22, 0x21, 0x34, 0x74, 0x23, 0x35, 0x70 };
            str = "jPQ\u96cd\ufffd\ufffd\u60e0\ufffd\u605d\u30fe\u9059\u5de8";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x28, 0x61, 0x62, 0x35, 0x29, 0x15, 0x72,
              0x41, 0x56, 0x6f, 0x59, 0x21, 0x77, 0x75, 0x48, 0x60, 0x7e,
              0x5e, 0x79, 0x60, 0x7c, 0x69, 0x73, 0x21, 0x77 };
            str = "(ab5)\u0015rAVoY!wuH`~^y`|is!w";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x5b, 0x7c, 0x17, 0x27,
              0x7c, 0x28, 0x4d, 0x6c, 0x72, 0x43 };
            str = "[|\u0017'|(MlrC";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x5a, 0x32, 0x06, 0x78, 0x4e, 0x3d, 0x1b,
              0x28, 0x49, 0x6c, 0x3b, 0x58, 0x5b, 0x36, 0x4e, 0x66, 0x31 };
            str = "Z2\u0006xN=\ufffd\uff7b\uff98\uff9b\uff76\uff8e\ufffd\uff71";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x26, 0x6e, 0x2f, 0x4c, 0x1f, 0x2b, 0x1b,
              0x28, 0x4a, 0x57, 0x7b, 0x26, 0x66, 0x55, 0x1b, 0x24, 0x42,
              0x37, 0x62, 0x3a, 0x2b, 0x5a, 0x52, 0x7c, 0x54, 0x68, 0x32,
              0x33, 0x31 };
            str = "&n/L\u001f+W {&fU\u6483\u6606\u65b7\u973b\u83a2\u54b3";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x70, 0x75, 0x7b, 0x6c, 0x75, 0x3e, 0x68,
              0x70, 0x5e, 0x1b, 0x24, 0x42, 0x68, 0x49, 0x6f, 0x2a, 0x4a,
              0x17, 0x7a, 0x41, 0x32, 0x41, 0x44, 0x53, 0x43 };
            str = "pu {lu>hp^\u8407\u937c\ufffd\u66a0\u4fa1\u67d8\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x55, 0x35, 0x1b, 0x24, 0x40, 0x67, 0x6e,
              0x65, 0x76, 0x3e, 0x45, 0x51, 0x7a, 0x3b, 0x6a, 0x40, 0x1b,
              0x24, 0x40, 0x1d, 0x4c, 0x76, 0x41 };
            str = "U5\u82ac\u7e90\u6e58\u5292\u81f3\ufffd\ufffd\u8e8d\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x7e, 0x35, 0x3f, 0x4c, 0x31, 0x29, 0x1b,
              0x24, 0x40, 0x7b, 0x22, 0x65, 0x5c, 0x6b, 0x3d, 0x28, 0x61,
              0x41 };
            str = "~5?L1)\u7324\u7e35\u89f8\ufffd\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x4d };
            str = "M";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x75, 0x6f, 0x40, 0x35, 0x78 };
            str = "uo@5x";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x44, 0x66, 0x70, 0x6a,
              0x38, 0x75, 0x4a, 0x53, 0x4f, 0x2c, 0x2b, 0x63, 0x29 };
            str = "\u5243\u97cb\u5019\u7bc7\u5a41\ufffd\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x2d, 0x63, 0x64, 0x62,
              0x7d, 0x4b, 0x68, 0x42, 0x6f, 0x5c, 0x4d, 0x6b, 0x7e, 0x1b,
              0x28, 0x42 };
            str = "-cdb}KhBo\u00a5Mk\u203e";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x31, 0x21, 0x1b, 0x28, 0x48, 0x1b, 0x28,
              0x48, 0x71, 0x56, 0x73, 0x36, 0x1b, 0x24, 0x42, 0x1b, 0x28,
              0x49, 0x65, 0x79, 0x31, 0x4c, 0x40, 0x39, 0x38, 0x59, 0x3e,
              0x4c, 0x64, 0x6a, 0x3c, 0x4c, 0x5f, 0x3a, 0x53, 0x25 };
            str =

  "1!\ufffd(H\ufffd(HqVs6\ufffd\ufffd\ufffd\uff71\uff8c\uff80\uff79\uff78\uff99\uff7e\uff8c\ufffd\ufffd\uff7c\uff8c\uff9f\uff7a\uff93\uff65";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x68, 0x4b, 0x4a, 0x1b,
              0x28, 0x49, 0x46, 0x4c, 0x39, 0x57, 0x66, 0x1b, 0x24, 0x42,
              0x51, 0x4c, 0x6d, 0x25, 0x0b, 0x50, 0x59, 0x60, 0x23, 0x1b,
              0x28, 0x48, 0x44, 0x79, 0x1b, 0x24, 0x42, 0x50, 0x74, 0x51,
              0x78, 0x5e };
            str =

  "hKJ\uff86\uff8c\uff79\uff97\ufffd\u5196\u8e48\ufffd\u4fce\u720d\ufffd\ufffd\u7de0\u5050\u528d\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x68, 0x1b, 0x28, 0x4a,
              0x4b, 0x28, 0x77, 0x43 };
            str = "hK(wC";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x1b, 0x24, 0x42, 0x26,
              0x6c, 0x49, 0x1b, 0x28, 0x4a, 0x59, 0x6c, 0x2b, 0x2b, 0x52,
              0x3d, 0x5f, 0x7c, 0x47, 0x37, 0x4c, 0x57, 0x7a };
            str = "\ufffd\ufffd\ufffdYl++R=_|G7LWz";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x75, 0x6f, 0x45, 0x3b, 0x74, 0x31, 0x6c,
              0x3e, 0x54, 0x36, 0x74, 0x1b, 0x28, 0x48, 0x24, 0x35, 0x3d,
              0x4b, 0x1b, 0x24, 0x40, 0x77, 0x2f, 0x70, 0x71, 0x69, 0x4b,
              0x52, 0x3e, 0x35 };
            str = "uoE;t1l>T6t\ufffd(H$5=K\ufffd\u97f5\u865f\u5338\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x24, 0x40 };
            str = "";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x6c, 0x40, 0x46, 0x52,
              0x2f, 0x49, 0x77, 0x46, 0x41, 0x6b };
            str = "l@FR/IwFAk";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x50, 0x5b, 0x42, 0x4d, 0x23, 0x5e, 0x28,
              0x24, 0x58, 0x67, 0x57, 0x06, 0x7a, 0x62, 0x27, 0x7e };
            str = "P[BM#^($XgW\u0006zb'~";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x67, 0x1b, 0x28, 0x42 };
            str = "g";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x61, 0x76, 0x24, 0x50 };
            str = "av$P";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x24, 0x40, 0x29, 0x26, 0x70, 0x60,
              0x75, 0x37, 0x4d, 0x49, 0x24, 0x1b, 0x24, 0x40 };
            str = "\ufffd\u9790\ufffd\u63fa\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x7e, 0x33, 0x2d, 0x1b, 0x24, 0x40, 0x5f,
              0x48, 0x6b, 0x46, 0x7a, 0x6c, 0x76, 0x26, 0x34, 0x1b, 0x28,
              0x42, 0x36, 0x59, 0x74, 0x16, 0x48, 0x62, 0x63 };
            str = "~3-\u700f\u8a41\u6e3c\ufffd\ufffd6Yt\u0016Hbc";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x24, 0x40, 0x48 };
            str = "\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x27, 0x78, 0x13, 0x78, 0x74, 0x22, 0x24,
              0x1b, 0x28, 0x4a, 0x45, 0x4f, 0x6d, 0x33, 0x2c, 0x37, 0x46,
              0x35, 0x5b, 0x19, 0x3e, 0x49, 0x2f, 0x1b, 0x24, 0x42, 0x37,
              0x5c, 0x6d, 0x29, 0x37, 0x71, 0x69 };
          str = "'x\u0013xt\"$EOm3\u002c7F5[\u0019>I/\u9d8f\u8e2a\u5026\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x42, 0x58, 0x48, 0x67, 0x23,
              0x5d, 0x25, 0x36, 0x3e, 0x7a, 0x75, 0x50, 0x1b, 0x24, 0x42,
              0x21, 0x5d, 0x4d };
            str = "XHg#]%6>zuP\uff0d\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x45, 0x4f, 0x53, 0x39, 0x1b, 0x28, 0x49,
              0x1b, 0x28, 0x42, 0x43, 0x79, 0x1b, 0x24, 0x42, 0x62, 0x3e,
              0x1b, 0x28, 0x48, 0x20, 0x65, 0x1b, 0x28, 0x42, 0x4c, 0x07,
              0x4d, 0x59, 0x2f, 0x73, 0x1b, 0x28, 0x49, 0x75 };
            str = "EOS9\ufffdCy\u7708\ufffd\ufffd\ufffd\ufffdL\u0007MY/s\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x5c, 0x7e, 0x4d, 0x44, 0x71, 0x2b, 0x45,
              0x3f, 0x1b, 0x28, 0x49, 0x5f, 0x7a, 0x5d, 0x48, 0x5f, 0x66,
              0x5e, 0x64, 0x44, 0x52, 0x40, 0x2c, 0x51, 0x54, 0x27, 0x36,
              0x35, 0x25 };
            str =

  "\\~MDq+E?\uff9f\ufffd\uff9d\uff88\uff9f\ufffd\uff9e\ufffd\uff84\uff92\uff80\uff6c\uff91\uff94\uff67\uff76\uff75\uff65";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x5b, 0x6a, 0x68, 0x6c, 0x71, 0x3f, 0x4c,
              0x28, 0x4f, 0x34, 0x39, 0x43, 0x43, 0x6f, 0x44, 0x65, 0x35,
              0x56, 0x23, 0x1b, 0x28, 0x48, 0x60, 0x4e, 0x3d, 0x64, 0x68,
              0x4a, 0x2c, 0x4a, 0x5e, 0x59 };
            str = "[jhlq?L(O49CCoDe5V#\ufffd(H`N=dhJ\u002cJ^Y";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x33, 0x69, 0x2d, 0x73, 0x74, 0x5f, 0x5f,
              0x6c, 0x3a, 0x78, 0x44, 0x73, 0x7b, 0x41, 0x7e, 0x47, 0x1b,
              0x28, 0x48, 0x5a, 0x2b, 0x79, 0x5e, 0x6c, 0x7c, 0x57, 0x67,
              0x77, 0x1e, 0x47, 0x61, 0x64 };
            str = "3i-st__l:xDs {A~G\ufffd(HZ+y^l|Wgw\u001eGad";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x32, 0x34, 0x73, 0x6c, 0x6d, 0x74, 0x1b,
              0x28, 0x4a, 0x58, 0x55, 0x6b, 0x6f, 0x38, 0x23, 0x63, 0x36,
              0x33, 0x3b, 0x60, 0x42, 0x72 };
            str = "24slmtXUko8#c63;`Br";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x54, 0x32, 0x36, 0x2a, 0x53, 0x1b, 0x28,
              0x49, 0x78, 0x1b, 0x28, 0x49, 0x3f, 0x4f, 0x48, 0x6f, 0x35,
              0x28, 0x44, 0x41, 0x7c, 0x38, 0x6b, 0x4e, 0x4c, 0x4b };
            str =

  "T26*S\ufffd\uff7f\uff8f\uff88\ufffd\uff75\uff68\uff84\uff81\ufffd\uff78\ufffd\uff8e\uff8c\uff8b";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x4c, 0x2e, 0x2a, 0x53, 0x30, 0x1b, 0x28,
              0x48, 0x75, 0x29, 0x5b, 0x57, 0x21, 0x29, 0x2e, 0x52 };
            str = "L.*S0\ufffd(Hu)[W!).R";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x71, 0x3e, 0x1b, 0x24, 0x42, 0x7a, 0x3e,
              0x4a, 0x18, 0x30, 0x52, 0x41 };
            str = "q>\ufa12\ufffd\u5a01\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x30, 0x1b, 0x28, 0x49, 0x22, 0x77, 0x7b,
              0x6a, 0x1b, 0x28, 0x48, 0x2e, 0x4d, 0x38, 0x51, 0x2b, 0x55,
              0x2f, 0x74, 0x5a, 0x02 };
            str =

  "0\uff62\ufffd\ufffd\ufffd\ufffd\uff68\uff88\uff6e\uff8d\uff78\uff91\uff6b\uff95\uff6f\ufffd\uff9a\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x35, 0x40, 0x73, 0x70, 0x62, 0x45, 0x45,
              0x49, 0x26, 0x27, 0x44, 0x5c, 0x27, 0x0e, 0x22, 0x5e, 0x61,
              0x22, 0x48, 0x50, 0x43, 0x7b, 0x48, 0x47, 0x33, 0x42, 0x2b,
              0x4d, 0x1b, 0x28, 0x42, 0x74 };
            str = "5@spbEEI&'D\\'\ufffd\"^a\"HPC {HG3B+Mt";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x48, 0x1b, 0x24, 0x40, 0x59,
              0x50, 0x6c, 0x4e, 0x54, 0x57, 0x46, 0x64, 0x2e, 0x43, 0x64,
              0x4b, 0x36, 0x3a, 0x52, 0x3f, 0x3f, 0x60, 0x60, 0x56, 0x58 };
            str =
  "\ufffd(H\u6350\u8ce3\u58b8\u51ea\ufffd\u7bf7\u77ef\u5340\u9017\u736a\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x4a, 0x6d, 0x71, 0x49, 0x60,
              0x70, 0x56, 0x23, 0x53, 0x50, 0x64, 0x1b, 0x28, 0x49, 0x3e,
              0x28, 0x56, 0x49, 0x71, 0x40, 0x1b, 0x28, 0x42, 0x75 };
            str = "mqI`pV#SPd\uff7e\uff68\uff96\uff89\ufffd\uff80u";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x42, 0x00, 0x52, 0x5d };
            str = "\u0000R]";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x74, 0x30, 0x38, 0x2f, 0x38, 0x65, 0x3b,
              0x4e, 0x45, 0x35, 0x60, 0x3f, 0x4b, 0x61, 0x4c, 0x3d, 0x62,
              0x4f, 0x1b, 0x28, 0x42, 0x22, 0x13, 0x25, 0x52, 0x0e, 0x22,
              0x49, 0x56, 0x4a };
            str = "t08/8e;NE5`?KaL=bO\"\u0013%R\ufffd\"IVJ";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x24, 0x71, 0x56, 0x1b, 0x28, 0x4a, 0x4d,
              0x61, 0x42, 0x31, 0x48, 0x7b, 0x42, 0x6a, 0x63, 0x23, 0x73,
              0x5c, 0x35, 0x65, 0x1b, 0x28, 0x48, 0x29 };
            str = "$qVMaB1H {Bjc#s\u00a55e\ufffd(H)";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x49, 0x75, 0x67, 0x3a, 0x48, 0x6b, 0x6c,
              0x1b, 0x24, 0x40, 0x1b, 0x24, 0x40, 0x78, 0x47, 0x3c, 0x27,
              0x4d, 0x23, 0x2e, 0x2b, 0x1b, 0x28, 0x42, 0x48, 0x39, 0x2f,
              0x59, 0x54, 0x26, 0x6a, 0x1b, 0x28, 0x42, 0x35, 0x4c, 0x70 };
            str = "Iug:Hkl\ufffd\ufffd\u78c1\u552f\ufffdH9/YT&j5Lp";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x6c };
            str = "l";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x48, 0x46, 0x34, 0x60, 0x6e,
              0x3d, 0x36, 0x3e, 0x58, 0x39, 0x3c, 0x6c, 0x72, 0x66, 0x7e,
              0x2b, 0x5b, 0x41, 0x46, 0x51, 0x64, 0x22, 0x59, 0x77, 0x45,
              0x1b, 0x28, 0x48, 0x59, 0x20, 0x2d };
            str = "\ufffd(HF4`n=6>X9<lrf~+[AFQd\"YwE\ufffd(HY -";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x48, 0x69, 0x69, 0x53, 0x20, 0x1b, 0x28,
              0x49, 0x25, 0x27 };
            str = "HiiS \uff65\uff67";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x60, 0x63, 0x3d, 0x5b, 0x5a, 0x1b, 0x28,
              0x42, 0x1b, 0x24, 0x40, 0x28, 0x5d, 0x34, 0x3b, 0x1b, 0x24,
              0x42, 0x1b, 0x28, 0x49, 0x41 };
            str = "`c=[Z\ufffd\ufffd\u67d1\ufffd\uff81";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x24, 0x40, 0x4d, 0x3c, 0x46, 0x3d,
              0x6f, 0x31, 0x6f, 0x2b, 0x51, 0x77, 0x76, 0x75, 0x33, 0x77,
              0x5a, 0x6b, 0x35, 0x52, 0x31, 0x79, 0x65, 0x47, 0x6f, 0x1b,
              0x24, 0x42, 0x6f, 0x33, 0x29 };
            str =

  "\u5915\u5ce0\u93b9\u936e\u527d\ufffd\u84b2\u665e\u5ba2\u7525\u7db0\ufffd\u93d7\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x0f, 0x33, 0x44, 0x29, 0x69, 0x57, 0x41,
              0x32, 0x1b, 0x28, 0x4a };
            str = "\ufffd3D)iWA2";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x4d, 0x55, 0x50, 0x42, 0x23, 0x1b, 0x24,
              0x40, 0x5b, 0x48, 0x29, 0x52, 0x7b, 0x67, 0x1b, 0x28, 0x42,
              0x5b, 0x37, 0x44, 0x52, 0x36, 0x45 };
            str = "MUPB#\u67b7\ufffd\u8a12[7DR6E";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
        bytes = new byte[] { 0x5d, 0x42, 0x3f, 0x7d, 0x5e, 0x35, 0x33, 0x47 };
            str = "]B?}^53G";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x5c, 0x68, 0x62, 0x6a, 0x0b, 0x5f, 0x68,
              0x39, 0x5b, 0x64, 0x67, 0x2f, 0x64, 0x6f, 0x7a, 0x4a, 0x7b,
              0x27, 0x1b, 0x28, 0x48, 0x53, 0x72, 0x27, 0x42, 0x29, 0x1b,
              0x28, 0x4a };
            str = "\\hbj\u000b_h9[dg/dozJ {'\ufffd(HSr'B)";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x52, 0x1b, 0x28, 0x49, 0x6b, 0x46, 0x1b,
              0x24, 0x42, 0x44, 0x48 };
            str = "R\ufffd\uff86\u69cc";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x28, 0x48, 0x46, 0x24, 0x1b, 0x28,
              0x49, 0x4e, 0x3b, 0x1b, 0x28, 0x42, 0x70, 0x78, 0x7f, 0x36,
              0x41, 0x50, 0x79, 0x52, 0x76, 0x2c, 0x49, 0x77, 0x63, 0x24,
              0x29, 0x2d, 0x5e, 0x74, 0x2e, 0x6d };
            str = "\ufffd(HF$\uff8e\uff7bpx\u007f6APyRv\u002cIwc$)-^t.m";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x2c, 0x6e, 0x62, 0x3a,
              0x2d, 0x28, 0x1b, 0x24, 0x40, 0x43, 0x31, 0x58, 0x2a, 0x4d,
              0x21, 0x1b, 0x24, 0x40, 0x31, 0x5a, 0x61, 0x1b, 0x28, 0x48,
              0x4a, 0x61 };
    str =
  "\ufffd\u76e7\u2467\u5358\u60e0\u8aed\u8b01\ufffd\ufffd\ufffd\u6355";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x50, 0x4b, 0x1e, 0x5f, 0x78, 0x7b, 0x70,
              0x22, 0x73, 0x1b, 0x24, 0x42, 0x6e, 0x61, 0x45, 0x50, 0x57,
              0x34, 0x28, 0x73, 0x29, 0x23, 0x1b, 0x28, 0x42, 0x1b, 0x28,
              0x48 };
            str = "PK\u001e_x {p\"s\u91f6\u767b\u5f5c\ufffd\ufffd\ufffd(H";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x39, 0x38, 0x1b, 0x28, 0x4a, 0x6b };
            str = "98k";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
        bytes = new byte[] { 0x4a, 0x38, 0x69, 0x4e, 0x1b, 0x28, 0x49, 0x74 };
            str = "J8iN\ufffd";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x61, 0x31, 0x38, 0x63, 0x6c, 0x20, 0x4b,
              0x37, 0x1b, 0x28, 0x4a, 0x1b, 0x28, 0x48, 0x1b, 0x24, 0x42,
              0x3d, 0x49, 0x29, 0x55, 0x7a, 0x5f, 0x7d, 0x69, 0x68, 0x33,
              0x5e, 0x33, 0x53, 0x73 };
            str = "a18cl K7\ufffd(H\u5bbf\ufffd\u6cda\ufffd\u8396\u6d64\u56c0";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x57, 0x1b, 0x28, 0x42, 0x25, 0x54, 0x7b,
              0x4a, 0x48, 0x28, 0x46, 0x67, 0x56, 0x39, 0x2d, 0x10 };
            str = "W%T {JH(FgV9-\u0010";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x2f, 0x29, 0x6a, 0x79, 0x5e, 0x76, 0x7e,
              0x1b, 0x28, 0x42, 0x33, 0x5c, 0x2c, 0x2f, 0x22, 0x1b, 0x24,
              0x42, 0x3a, 0x40, 0x35, 0x3f, 0x39, 0x27, 0x37, 0x77, 0x1b,
              0x0c, 0x67, 0x6c, 0x30, 0x48, 0x42, 0x33 };
            str =
  "/)jy^v~3\\\u002c/\"\u88df\u7591\u5b5d\u570f\ufffd\ufffd\u829f\u978d\u7d9a";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x1b, 0x24, 0x40 };
            str = "";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
            bytes = new byte[] { 0x00, 0x35, 0x6b, 0x40, 0x3a, 0x62, 0x5e,
              0x5d, 0x5b, 0x20, 0x78, 0x6e, 0x79, 0x31, 0x31, 0x59, 0x1b,
              0x28, 0x4a, 0x3d, 0x4b, 0x6d, 0x70, 0x7d, 0x5d, 0x53 };
            str = "\u00005k@:b^][ xny11Y=Kmp}]S";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
  bytes = new byte[] { 0x5e, 0x78, 0x6b, 0x46, 0x31, 0x4e, 0x44, 0x51, 0x21 };
            str = "^xkF1NDQ!";
            Assert.assertEquals(
             str,
             Encodings.DecodeToString(charset, bytes));
    }

    @Test
    public void TestIso2022JPEncodeSpecific() {
      byte[] bytes;
      String str;
      ICharacterEncoding charset = Encodings.GetEncoding("iso-2022-jp");
            str = "\uff13";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x33, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff0b\uff44\u5916\u68ad";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x21, 0x5c, 0x23, 0x64,
              0x33, 0x30, 0x5b, 0x68, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u4e8a";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x50, 0x2f, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff41\uff47\u5bc9\u6b79";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x61, 0x23, 0x67,
              0x55, 0x65, 0x5d, 0x46, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u7960";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x63, 0x2c, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u714c\u7f47\u6753";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x5f, 0x6a, 0x7b, 0x54,
              0x3c, 0x5d, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u578b";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x37, 0x3f, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u9b6f";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x4f, 0x25, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u6cd3\u7a0d\u7926";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x5d, 0x77, 0x63, 0x44,
              0x62, 0x68, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u7911";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x63, 0x27, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff97\u76c8\u2533";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x25, 0x69, 0x31, 0x4e,
              0x28, 0x33, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u7ae7\u9076";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x7b, 0x49, 0x6e, 0x2d,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff4b\u727d\u679d";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x6b, 0x38, 0x23,
              0x3b, 0x5e, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u5680\u60b8\uff4b\u69bf\u55fe";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x53, 0x66, 0x58, 0x29,
              0x23, 0x6b, 0x5c, 0x48, 0x53, 0x55, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u595d\u72be\u7b1e\uff8e\u755d";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x79, 0x66, 0x7b, 0x21,
              0x63, 0x7a, 0x25, 0x5b, 0x40, 0x26, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u6f54\uff64\u5ef0";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x37, 0x69, 0x21, 0x22,
              0x57, 0x2d, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u5e72\u5712";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x34, 0x33, 0x31, 0x60,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u6adb\uff4b\uff6b\u708e";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x36, 0x7b, 0x23, 0x6b,
              0x25, 0x29, 0x31, 0x6a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff3d\u5eec\uff18";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x21, 0x4f, 0x57, 0x2a,
              0x23, 0x38, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff7a\uffe5\uff3f";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x25, 0x33, 0x21, 0x6f,
              0x21, 0x32, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff57\uff43";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x77, 0x23, 0x63,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u7ad2\uff98\u600e";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x54, 0x74, 0x25, 0x6a,
              0x57, 0x63, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff5d\u7ddd\uffe3";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x21, 0x51, 0x65, 0x49,
              0x21, 0x31, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u6e2c\u670e";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x42, 0x2c, 0x7a, 0x45,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u769a\u5230\uff78\u7ae7";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x62, 0x2d, 0x45, 0x7e,
              0x25, 0x2f, 0x7b, 0x49, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u69eb";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x5c, 0x67, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u52c3\uff4a";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x4b, 0x56, 0x23, 0x6a,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff1b\uff4d@";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x21, 0x28, 0x23, 0x6d,
              0x1b, 0x28, 0x42, 0x40 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u62ee";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x59, 0x49, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u66c4\u977c\uff0c";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x5b, 0x21, 0x70, 0x5a,
              0x21, 0x24, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u2169\u98c6\uff38";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x2d, 0x3e, 0x71, 0x2a,
              0x23, 0x58, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u7d20\u5993\u6bbb\u6063\u7537";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x41, 0x47, 0x35, 0x38,
              0x33, 0x4c, 0x57, 0x73, 0x43, 0x4b, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff67";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x25, 0x21, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff6d\uff22";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x25, 0x65, 0x23, 0x42,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff0e";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x21, 0x25, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u727d\u676a";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x38, 0x23, 0x5b, 0x42,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff14\u6545\uff4a";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x34, 0x38, 0x4e,
              0x23, 0x6a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff64\u25bd\u501a";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x21, 0x22, 0x22, 0x26,
              0x50, 0x61, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff37\u2193\uff2a";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x57, 0x22, 0x2d,
              0x23, 0x4a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u745e\uff05\u78c5";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x3f, 0x70, 0x21, 0x73,
              0x62, 0x7c, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u6ac3";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x5d, 0x24, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u6955\u8aa6\u5177\u5c8c";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x42, 0x4a, 0x6b, 0x56,
              0x36, 0x71, 0x56, 0x29, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u7e9c\u5f15";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x65, 0x7c, 0x30, 0x7a,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff2c";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x4c, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u5fcc\uff38\u76de";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x34, 0x77, 0x23, 0x58,
              0x62, 0x37, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u58be\u2463";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x3a, 0x26, 0x2d, 0x24,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff3e\uff06";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x21, 0x30, 0x21, 0x75,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u6731\uff02\uff42";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x3c, 0x6b, 0x7c, 0x7e,
              0x23, 0x62, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u6631\u58ab";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x79, 0x28, 0x54, 0x53,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff19\u53c2";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x39, 0x3b, 0x32,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u507d\uff19";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x35, 0x36, 0x23, 0x39,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u79d8\u2461\uff6c\uff36";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x48, 0x6b, 0x2d, 0x22,
              0x25, 0x63, 0x23, 0x56, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u7693";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x62, 0x2b, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u66e0z";
  bytes = new byte[] { 0x1b, 0x24, 0x42, 0x5b, 0x25, 0x1b, 0x28, 0x42, 0x7a };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff22\u7bad\u7cad";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x42, 0x40, 0x7d,
              0x64, 0x66, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u8098\uff3b\u5b66";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x49, 0x2a, 0x21, 0x4e,
              0x33, 0x58, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u732f";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x60, 0x4e, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u68da\uff76";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x43, 0x2a, 0x25, 0x2b,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff82\uff07\uff4a";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x25, 0x44, 0x7c, 0x7d,
              0x23, 0x6a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff8c\uff45\uff07\uff8a\uff09\uff17\u5d42";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x25, 0x55, 0x23, 0x65,
              0x7c, 0x7d, 0x25, 0x4f, 0x21, 0x4b, 0x23, 0x37, 0x79, 0x76,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff4e\uff25\u66dd";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x6e, 0x23, 0x45,
              0x47, 0x78, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u6f80\u2021\u68ee";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x5f, 0x28, 0x22, 0x78,
              0x3f, 0x39, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u3003\u212b\u7bb1\u72e2";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x21, 0x37, 0x22, 0x72,
              0x48, 0x22, 0x60, 0x42, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff8c\uff16\u66d9";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x25, 0x55, 0x23, 0x36,
              0x3d, 0x6c, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u6cb3\uff66";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x32, 0x4f, 0x25, 0x72,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u64fe\u5c76\u76fb";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x3e, 0x71, 0x56, 0x27,
              0x62, 0x3d, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u6b98";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x5d, 0x4c, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u5dfd";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x43, 0x27, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff8f\u76f2";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x25, 0x5e, 0x4c, 0x55,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff0a\u6176";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x21, 0x76, 0x37, 0x44,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u2503\uff98\u5289";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x28, 0x2d, 0x25, 0x6a,
              0x4e, 0x2d, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u7b54\uff6a\u72fc";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x45, 0x7a, 0x25, 0x27,
              0x4f, 0x35, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff44";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x64, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u7d1b";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x4a, 0x36, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff14\u5bb9";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x34, 0x4d, 0x46,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff24";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x44, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u7b2c\u5538\uff01";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x42, 0x68, 0x53, 0x39,
              0x21, 0x2a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff80\uff5e\u0013";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x25, 0x3f, 0x21, 0x41,
              0x1b, 0x28, 0x42, 0x13 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u8a36\u7b02\u66da";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x6b, 0x45, 0x63, 0x73,
              0x5b, 0x24, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u5f83\u2030\u7188";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x57, 0x48, 0x22, 0x73,
              0x5f, 0x67, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff4b\uff69";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x6b, 0x25, 0x25,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u7cc2";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x64, 0x73, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff7b\u6f41\u68b0\uff95";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x25, 0x35, 0x5e, 0x73,
              0x33, 0x23, 0x25, 0x66, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u7634";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x61, 0x6f, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff57";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x77, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uffe2\u708e\uff15";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x22, 0x4c, 0x31, 0x6a,
              0x23, 0x35, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u5efe\u6848\u2179";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x57, 0x30, 0x30, 0x46,
              0x7c, 0x7a, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff57";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x77, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff34\u8d07\u7e43";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x54, 0x6c, 0x56,
              0x65, 0x5e, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff9d\u5c79\u2473";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x25, 0x73, 0x56, 0x28,
              0x2d, 0x34, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u6850";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x36, 0x4d, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u79c1\u5a49\u5bd3";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x3b, 0x64, 0x55, 0x36,
              0x36, 0x77, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff2e\u59ea\uff2f";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x4e, 0x4c, 0x45,
              0x23, 0x4f, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff14\u5f6a\uff3d";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x34, 0x49, 0x37,
              0x21, 0x4f, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u62db\u63c9";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x3e, 0x37, 0x59, 0x66,
              0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff14";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x34, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\uff56\u5dee\u7368";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x23, 0x76, 0x3a, 0x39,
              0x60, 0x57, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u509a";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x50, 0x7b, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u6426";
        bytes = new byte[] { 0x1b, 0x24, 0x42, 0x59, 0x6e, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
            str = "\u50cf\uff48\u57ac";
            bytes = new byte[] { 0x1b, 0x24, 0x42, 0x41, 0x7c, 0x23, 0x68,
              0x79, 0x5c, 0x1b, 0x28, 0x42 };
            TestCommon.AssertByteArraysEqual(
            bytes,
            Encodings.EncodeToBytes(str, charset));
        }
        @Test
public void TestEucJP() {
            byte[] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding("euc-jp");
            bytes = new byte[] { (byte)0x8e };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "\ufffd",
                stringTemp);
            }
            bytes = new byte[] { (byte)0x8e, 0x21 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "\ufffd!",
                stringTemp);
            }
            bytes = new byte[] { (byte)0x8e, (byte)0x8e, (byte)0xa1 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "\ufffd\ufffd",
                stringTemp);
            }
            bytes = new byte[] { (byte)0x8f };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\ufffd",
                  stringTemp);
            }
            bytes = new byte[] { (byte)0x8f, 0x21 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\ufffd!",
                  stringTemp);
            }
            bytes = new byte[] { (byte)0x8f, (byte)0xa1 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\ufffd",
                  stringTemp);
            }
            bytes = new byte[] { (byte)0x8f, (byte)0xa1, 0x21 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\ufffd!",
                  stringTemp);
            }
            bytes = new byte[] { (byte)0x90 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\ufffd",
                  stringTemp);
            }
            bytes = new byte[] { (byte)0x90, 0x21 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\ufffd!",
                  stringTemp);
            }
            bytes = new byte[] { (byte)0xa1 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\ufffd",
                  stringTemp);
            }
            bytes = new byte[] { (byte)0xa1, (byte)0xa1 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\u3000",
                  stringTemp);
            }
            bytes = new byte[] { (byte)0x90, (byte)0xa1, (byte)0xa1 };
            {
                String stringTemp = Encodings.DecodeToString(
                  charset,
                  bytes);
                Assert.assertEquals(
                  "\ufffd\u3000",
                  stringTemp);
            }
            bytes = new byte[] { (byte)0x90, (byte)0xa1, (byte)0xa1, (byte)0xa1 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                "\ufffd\u3000\ufffd",
                stringTemp);
            }
            bytes = new byte[] { (byte)0xa1, 0x21 };
            {
                String stringTemp = Encodings.DecodeToString(charset, bytes);
                Assert.assertEquals(
                  "\ufffd!",
                  stringTemp);
            }
            String result;
          bytes = new byte[] { 0x15, (byte)0xf2, (byte)0xbf, (byte)0xdd, (byte)0xd7, 0x13, (byte)0xeb, (byte)0xcf,
        (byte)0x8e, (byte)0xd6, (byte)0x8f, (byte)0xec, (byte)0xe9, (byte)0x8f, (byte)0xd6, (byte)0xe6, (byte)0x8f, (byte)0xd3, (byte)0xa3,
        (byte)0x8e, (byte)0xd4, 0x66, (byte)0x8f, (byte)0xb9, (byte)0xfc, (byte)0x8e, (byte)0xb0, (byte)0x8f, (byte)0xea, (byte)0xd8,
        0x29, (byte)0x8e, (byte)0xca, (byte)0x8e, (byte)0xd4, (byte)0xc9, (byte)0xb5, 0x1e, 0x09, (byte)0x8e, (byte)0xab,
        (byte)0xc2, (byte)0xc5, (byte)0x8e, (byte)0xa7, (byte)0x8e, (byte)0xb6, 0x3d, (byte)0xe1, (byte)0xd9, (byte)0xb7, (byte)0xd5,
        0x7b, 0x05, (byte)0xe6, (byte)0xce, 0x1d, (byte)0x8f, (byte)0xbd, (byte)0xbe, (byte)0xd8, (byte)0xae, (byte)0x8e,
        (byte)0xc3, (byte)0x8f, (byte)0xc1, (byte)0xda, (byte)0xd5, (byte)0xbb, (byte)0xb2, (byte)0xa2, (byte)0xcc, (byte)0xd4, 0x42,
        (byte)0x8e, (byte)0xa2, (byte)0xed, (byte)0xd4, (byte)0xc6, (byte)0xe0, (byte)0x8f, (byte)0xe0, (byte)0xd5, (byte)0x8e, (byte)0xd8,
        (byte)0xb0, (byte)0xc8, (byte)0x8f, (byte)0xa2, (byte)0xb8, (byte)0xb9, (byte)0xf1, (byte)0x8e, (byte)0xb0, (byte)0xd9, (byte)0xc0,
        0x13 };
            result =

  "\u0015\u9ba8\u6bbc\u0013\u8a85\uff96\u9ea8\u81f2\u7c67\uff94f\u5aba\uff70\u9b8a)\uff8a\uff94\u8b2c\u001e\u0009\uff6b\u59a5\uff67\uff76=\u75ca\u834a"
              +

  "{\u0005\u8004\u001d\u5fd1\u60bd\uff83\u6595\u5a9a\u65fa\u731bB\uff62\u8f33\u5948\u8ec1\uff98\u978d\u0384\u56fd\uff70\u62c8\u0013";

            Assert.assertEquals(result, Encodings.DecodeToString(charset, bytes));
        }

        public static void TestSingleByteRoundTrip(String name) {
            TestSingleByteRoundTrip(Encodings.GetEncoding(name, true));
        }

        public static void TestSingleByteRoundTrip(ICharacterEncoding enc) {
            int[] codepoints = new int[256];
            int[] codesrc = new int[256];
            ICharacterEncoder encoder = enc.GetEncoder();
            ICharacterDecoder decoder = enc.GetDecoder();
            int codetotal = 0;
            byte[] bytes = new byte[256];
            for (int i = 0; i < 256; ++i) {
                bytes[i] = (byte)i;
            }
            IByteReader ib = DataIO.ToReader(bytes);
            for (int i = 0; i < 256; ++i) {
                int c = decoder.ReadChar(ib);
                if (c == -1) {
                    Assert.fail();
                }
                if (c != -2) {
                    codepoints[codetotal] = c;
                    codesrc[codetotal] = i;
                    ++codetotal;
                }
            }
            ArrayWriter aw = new ArrayWriter();
            for (int i = 0; i < codetotal; ++i) {
                int c = encoder.Encode(codepoints[i], aw);
                if (c < 0) {
                    Assert.fail();
                }
            }
            bytes = aw.ToArray();
            for (int i = 0; i < codetotal; ++i) {
                int b = ((int)bytes[i]) & 0xff;
                if (b != codesrc[i]) {
                    Assert.assertEquals(codesrc[i], b);
                }
            }
        }

        @Test
public void TestCodePages() {
            for (int j = 0; j < this.valueSingleByteNames.length; ++j) {
ICharacterEncoding enc = Encodings.GetEncoding(this.valueSingleByteNames [j]);

                ICharacterDecoder dec = enc.GetDecoder();
                byte[] bytes = new byte[256];
                int[] ints = new int[256];
                int count = 0;
                for (int i = 0; i < 256; ++i) {
                    bytes[i] = (byte)i;
                }
                IByteReader reader = DataIO.ToReader(bytes);
                for (int i = 0; i < 256; ++i) {
                    ints[i] = dec.ReadChar(reader);
                    if (ints[i] >= 0) {
                    ++count;
                    }
                }
                if (count != 256) {
                    continue;
                }
                StringBuilder builder = new StringBuilder();
                builder.append("CODEPAGE 1\nCPINFO 1 0x3f 0x3f\nMBTABLE " +
                    TestCommon.IntToString(count) + "\n");
                for (int i = 0; i < 256; ++i) {
                    if (ints[i] >= 0) {
                    builder.append(TestCommon.IntToString(i) + " " +
                    TestCommon.IntToString(ints[i]) + "\n");
                    }
                }
                builder.append("WCTABLE " + count + "\n");
                for (int i = 0; i < 256; ++i) {
                    if (ints[i] >= 0) {
                    builder.append(TestCommon.IntToString(ints[i]) + " " +
                    TestCommon.IntToString(i) + "\n");
                    }
                }
                builder.append("ENDCODEPAGE\n");
CodePageEncoding cpe = new CodePageEncoding(Encodings.StringToInput(builder.toString()));
                TestSingleByteRoundTrip(cpe);
            }
        }

        private final String[] valueSingleByteNames = new String[] {
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

        public static void TestUtfRoundTrip(
           ICharacterEncoder encoder,
           ICharacterDecoder decoder) {
            ArrayWriter aw = new ArrayWriter();
            for (int i = 0; i < 0x110000; ++i) {
                if (i >= 0xd800 && i < 0xe000) {
                    continue;
                }
                int e = encoder.Encode(i, aw);
                if (e == -2) {
                    Assert.fail("Failed to encode " + i);
                }
            }
            IByteReader reader = DataIO.ToReader(aw.ToArray());
            for (int i = 0; i < 0x110000; ++i) {
                if (i >= 0xd800 && i < 0xe000) {
                    continue;
                }
                int c = decoder.ReadChar(reader);
                if (c != i) {
                    Assert.assertEquals(i, c);
                }
            }
        }

        public static void TestCJKRoundTrip(String name) {
            ICharacterEncoding enc = Encodings.GetEncoding(name, true);
            ICharacterEncoder encoder = enc.GetEncoder();
            ICharacterDecoder decoder = enc.GetDecoder();
            ArrayList<Integer> list = new ArrayList<Integer>();
            ArrayWriter aw = new ArrayWriter();
            for (int i = 0; i < 0x110000; ++i) {
                if (i >= 0xd800 && i < 0xe000) {
                    continue;
                }
         if (i == 0xa5 || i == 0x203e || i == 0x0e || i == 0x0f || i == 0x1b ||
                i == 0x2212 || i == 0xe5e5) {
                    // ignore certain characters that intentionally
                    // don't round trip in certain encodings
                    continue;
                }
                int e = encoder.Encode(i, aw);
                if (e >= 0) {
                    list.add(i);
                }
            }
            while (encoder.Encode(-1, aw) >= 0) {
            }
            IReader reader = DataIO.ToReader(aw.ToArray());
            for (int i = 0; i < list.size(); ++i) {
                int ch = list.get(i);
                int c = decoder.ReadChar(reader);
                if (c != ch) {
                    Assert.fail(name + ": ValueExpected " + ch + ", was " + c);
                }
            }
        }
        @Test
        public void TestGBK() {
            TestCJKRoundTrip("gbk");
        }
        @Test
public void TestGB18030RoundTrip() {
            TestCJKRoundTrip("gb18030");
        }
        @Test
public void TestBig5() {
            TestCJKRoundTrip("big5");
        }
        @Test
public void TestKoreanEUC() {
            TestCJKRoundTrip("euc-kr");
        }
        @Test
public void TestShiftJISRoundTrip() {
            TestCJKRoundTrip("shift-jis");
        }
        @Test
public void TestEucJPRoundTrip() {
            TestCJKRoundTrip("euc-jp");
        }
        @Test
public void TestIso2022JPRoundTrip() {
            TestCJKRoundTrip("iso-2022-jp");
        }

        @Test
public void TestReplacementEncoding() {
            if ((Encodings.GetEncoding("replacement")) == null) {
 Assert.fail();
 }
            ICharacterEncoding enc = Encodings.GetEncoding("hz-gb-2312", true);
            ICharacterEncoder encoder = enc.GetEncoder();
            ICharacterDecoder decoder = enc.GetDecoder();
            IByteReader reader = DataIO.ToReader(new byte[] { 0, 0, 0, 0 });
            Assert.assertEquals(-2, decoder.ReadChar(reader));
            Assert.assertEquals(-1, decoder.ReadChar(reader));
            TestUtfRoundTrip(
              encoder,
              Encodings.GetEncoding("utf-8", true).GetDecoder());
        }

        @Test
public void TestSingleByteEncodings() {
            for (int i = 0; i < this.valueSingleByteNames.length; ++i) {
                TestSingleByteRoundTrip(this.valueSingleByteNames[i]);
            }
        }

        @Test
public void TestUtf7RoundTrip() {
            TestUtfRoundTrip(Encodings.GetEncoding("utf-7", true));
        }

        @Test
public void TestUtf8RoundTrip() {
            TestUtfRoundTrip(Encodings.GetEncoding("utf-8", true));
        }

        public static List<byte[]> GenerateIllegalUtf8Sequences() {
            ArrayList<byte[]> list = new ArrayList<byte[]>();
            // Generate illegal single bytes
            for (int i = 0x80; i <= 0xff; ++i) {
                if (i < 0xc2 || i > 0xf4) {
                    list.add(new byte[] { (byte)i, (byte)0x80 });
                }
                list.add(new byte[] { (byte)i });
            }
            list.add(new byte[] { (byte)0xe0, (byte)0xa0 });
            list.add(new byte[] { (byte)0xe1, (byte)0x80 });
            list.add(new byte[] { (byte)0xef, (byte)0x80 });
            list.add(new byte[] { (byte)0xf0, (byte)0x90 });
            list.add(new byte[] { (byte)0xf1, (byte)0x80 });
            list.add(new byte[] { (byte)0xf3, (byte)0x80 });
            list.add(new byte[] { (byte)0xf4, (byte)0x80 });
            list.add(new byte[] { (byte)0xf0, (byte)0x90, (byte)0x80 });
            list.add(new byte[] { (byte)0xf1, (byte)0x80, (byte)0x80 });
            list.add(new byte[] { (byte)0xf3, (byte)0x80, (byte)0x80 });
            list.add(new byte[] { (byte)0xf4, (byte)0x80, (byte)0x80 });
            // Generate illegal multibyte sequences
            for (int i = 0x00; i <= 0xff; ++i) {
                if (i < 0x80 || i > 0xbf) {
                    list.add(new byte[] { (byte)0xc2, (byte)i });
                    list.add(new byte[] { (byte)0xdf, (byte)i });
                    list.add(new byte[] { (byte)0xe1, (byte)i, (byte)0x80 });
                    list.add(new byte[] { (byte)0xef, (byte)i, (byte)0x80 });
                    list.add(new byte[] { (byte)0xf1, (byte)i, (byte)0x80, (byte)0x80 });
                    list.add(new byte[] { (byte)0xf3, (byte)i, (byte)0x80, (byte)0x80 });
                    list.add(new byte[] { (byte)0xe0, (byte)0xa0, (byte)i });
                    list.add(new byte[] { (byte)0xe1, (byte)0x80, (byte)i });
                    list.add(new byte[] { (byte)0xef, (byte)0x80, (byte)i });
                    list.add(new byte[] { (byte)0xf0, (byte)0x90, (byte)i, (byte)0x80 });
                    list.add(new byte[] { (byte)0xf1, (byte)0x80, (byte)i, (byte)0x80 });
                    list.add(new byte[] { (byte)0xf3, (byte)0x80, (byte)i, (byte)0x80 });
                    list.add(new byte[] { (byte)0xf4, (byte)0x80, (byte)i, (byte)0x80 });
                    list.add(new byte[] { (byte)0xf0, (byte)0x90, (byte)0x80, (byte)i });
                    list.add(new byte[] { (byte)0xf1, (byte)0x80, (byte)0x80, (byte)i });
                    list.add(new byte[] { (byte)0xf3, (byte)0x80, (byte)0x80, (byte)i });
                    list.add(new byte[] { (byte)0xf4, (byte)0x80, (byte)0x80, (byte)i });
                }
                if (i < 0xa0 || i > 0xbf) {
                    list.add(new byte[] { (byte)0xe0, (byte)i, (byte)0x80 });
                }
                if (i < 0x90 || i > 0xbf) {
                    list.add(new byte[] { (byte)0xf0, (byte)i, (byte)0x80, (byte)0x80 });
                }
                if (i < 0x80 || i > 0x8f) {
                    list.add(new byte[] { (byte)0xf4, (byte)i, (byte)0x80, (byte)0x80 });
                }
            }
            return list;
        }

        @Test
public void TestUtf8IllegalBytes() {
            for (byte[] seq : GenerateIllegalUtf8Sequences()) {
                String str = Encodings.DecodeToString(Encodings.UTF8, seq);
                if (!(str.length() > 0)) {
 Assert.fail();
 }
                if (!(str.indexOf('\ufffd') == 0)) {
 Assert.fail();
 }
            }
        }

        @Test
public void TestUtf16LERoundTrip() {
            TestUtfRoundTrip(Encodings.GetEncoding("utf-16le", true));
        }

        @Test
public void TestUtf16BERoundTrip() {
            TestUtfRoundTrip(Encodings.GetEncoding("utf-16be", true));
        }

        public static void TestUtf7One(String input, String expect) {
            {
                Object objectTemp = expect;
                Object objectTemp2 = Encodings.DecodeToString(
                    Encodings.GetEncoding("utf-7", true),
                    Encodings.EncodeToBytes(input, Encodings.UTF8));
                Assert.assertEquals(objectTemp, objectTemp2);
            }
        }

        @Test
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
            TestUtf7One("+AMAA4A!Next", "\u00c0\u00e0!Next");
            TestUtf7One("+AMAA4A\u007f", "\u00c0\u00e0\ufffd");
            // Two UTF-16 code units (redundant pad bit)
            TestUtf7One("+AMAA4B?", "\u00c0\u00e0\ufffd?");
            TestUtf7One("+AMAA4B", "\u00c0\u00e0\ufffd");
            TestUtf7One("+AMAA4B-Next", "\u00c0\u00e0\ufffdNext");
            TestUtf7One("+AMAA4B!Next", "\u00c0\u00e0\ufffd!Next");
            TestUtf7One("+AMAA4B\u007f", "\u00c0\u00e0\ufffd\ufffd");
        }
    }
