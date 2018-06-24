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

      Assert.assertEquals(ValueExpected, Encodings.DecodeToString(charset, bytes));
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
      ICharacterEncoding encoding = Encodings.GetEncoding ("gb18030");
      TestEncodingRoundTrip ("\uffff", encoding);
      TestEncodingRoundTrip ("\ud800\udc00", encoding);
      TestEncodingRoundTrip ("\udbff\udfff", encoding);
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
      byte [] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding ("euc-jp");
            str = "\uff57\u5256";
        bytes = new byte [] { (byte)0xa3, (byte)0xf7, (byte)0xcb, (byte)0xb6
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff3e";
            bytes = new byte [] { (byte)0xa1, (byte)0xb0 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff2a";
            bytes = new byte [] { (byte)0xa3, (byte)0xca };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7984";
            bytes = new byte [] { (byte)0xcf, (byte)0xbd };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff6c\uff2b";
        bytes = new byte [] { (byte)0x8e, (byte)0xac, (byte)0xa3, (byte)0xcb
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff04";
            bytes = new byte [] { (byte)0xa1, (byte)0xf0 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff9c";
            bytes = new byte [] { (byte)0x8e, (byte)0xdc };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u594f";
            bytes = new byte [] { (byte)0xc1, (byte)0xd5 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7670\uff77";
        bytes = new byte [] { (byte)0xe1, (byte)0xfe, (byte)0x8e, (byte)0xb7
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u73f1\u898f";
        bytes = new byte [] { (byte)0xe0, (byte)0xfe, (byte)0xb5, (byte)0xac
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff45";
            bytes = new byte [] { (byte)0xa3, (byte)0xe5 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u25cb\uff4f";
        bytes = new byte [] { (byte)0xa1, (byte)0xfb, (byte)0xa3, (byte)0xef
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7dac";
            bytes = new byte [] { (byte)0xbc, (byte)0xfa };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff8d";
            bytes = new byte [] { (byte)0x8e, (byte)0xcd };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6148";
            bytes = new byte [] { (byte)0xbb, (byte)0xfc };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u68a7";
            bytes = new byte [] { (byte)0xb8, (byte)0xe8 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u541f";
            bytes = new byte [] { (byte)0xb6, (byte)0xe3 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u608b\u50d5";
        bytes = new byte [] { (byte)0xd8, (byte)0xa7, (byte)0xcb, (byte)0xcd
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff47\uff14";
        bytes = new byte [] { (byte)0xa3, (byte)0xe7, (byte)0xa3, (byte)0xb4
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5be5";
            bytes = new byte [] { (byte)0xd5, (byte)0xec };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7bb1";
            bytes = new byte [] { (byte)0xc8, (byte)0xa2 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff9e";
            bytes = new byte [] { (byte)0x8e, (byte)0xde };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff7d";
            bytes = new byte [] { (byte)0x8e, (byte)0xbd };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6e0a";
            bytes = new byte [] { (byte)0xde, (byte)0xbd };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u51f5";
            bytes = new byte [] { (byte)0xd1, (byte)0xe1 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6756";
            bytes = new byte [] { (byte)0xbe, (byte)0xf3 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u68c9";
            bytes = new byte [] { (byte)0xcc, (byte)0xc9 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff04";
            bytes = new byte [] { (byte)0xa1, (byte)0xf0 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u54a2";
            bytes = new byte [] { (byte)0xd2, (byte)0xf8 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7523";
            bytes = new byte [] { (byte)0xbb, (byte)0xba };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff26";
            bytes = new byte [] { (byte)0xa3, (byte)0xc6 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7407";
            bytes = new byte [] { (byte)0xfb, (byte)0xaa };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff0e";
            bytes = new byte [] { (byte)0xa1, (byte)0xa5 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7a98";
            bytes = new byte [] { (byte)0xe3, (byte)0xdb };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7b8f";
            bytes = new byte [] { (byte)0xe4, (byte)0xb7 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5e7b\uff38";
        bytes = new byte [] { (byte)0xb8, (byte)0xb8, (byte)0xa3, (byte)0xd8
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff78\u6ebf";
        bytes = new byte [] { (byte)0x8e, (byte)0xb8, (byte)0xfa, (byte)0xed
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5d84";
            bytes = new byte [] { (byte)0xd6, (byte)0xd0 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff2f";
            bytes = new byte [] { (byte)0xa3, (byte)0xcf };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff69";
            bytes = new byte [] { (byte)0x8e, (byte)0xa9 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff9c";
            bytes = new byte [] { (byte)0x8e, (byte)0xdc };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff24";
            bytes = new byte [] { (byte)0xa3, (byte)0xc4 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uffe5\u226b";
        bytes = new byte [] { (byte)0xa1, (byte)0xef, (byte)0xa2, (byte)0xe4
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff7f";
            bytes = new byte [] { (byte)0x8e, (byte)0xbf };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u65cb";
            bytes = new byte [] { (byte)0xc0, (byte)0xfb };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff5c";
            bytes = new byte [] { (byte)0xa1, (byte)0xc3 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7470\u695a";
        bytes = new byte [] { (byte)0xe0, (byte)0xf3, (byte)0xc1, (byte)0xbf
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff88";
            bytes = new byte [] { (byte)0x8e, (byte)0xc8 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u25a0\u79d5";
        bytes = new byte [] { (byte)0xa2, (byte)0xa3, (byte)0xe3, (byte)0xbe
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u0011";
            bytes = new byte [] { 0x11 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "J";
            bytes = new byte [] { 0x4a };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u53bb\u592e";
        bytes = new byte [] { (byte)0xb5, (byte)0xee, (byte)0xb1, (byte)0xfb
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff2e";
            bytes = new byte [] { (byte)0xa3, (byte)0xce };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u67c4";
            bytes = new byte [] { (byte)0xca, (byte)0xc1 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6292";
            bytes = new byte [] { (byte)0xd9, (byte)0xb3 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff03";
            bytes = new byte [] { (byte)0xa1, (byte)0xf4 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u000c";
            bytes = new byte [] { 0x0c };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u71ed";
            bytes = new byte [] { (byte)0xbf, (byte)0xa4 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff9f";
            bytes = new byte [] { (byte)0x8e, (byte)0xdf };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u2517\uff5c";
        bytes = new byte [] { (byte)0xa8, (byte)0xb1, (byte)0xa1, (byte)0xc3
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6500";
            bytes = new byte [] { (byte)0xda, (byte)0xb5 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u770c";
            bytes = new byte [] { (byte)0xb8, (byte)0xa9 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff72";
            bytes = new byte [] { (byte)0x8e, (byte)0xb2 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7591";
            bytes = new byte [] { (byte)0xb5, (byte)0xbf };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff79";
            bytes = new byte [] { (byte)0x8e, (byte)0xb9 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u731f";
            bytes = new byte [] { (byte)0xce, (byte)0xc4 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6859";
            bytes = new byte [] { (byte)0xdb, (byte)0xe2 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6a7f";
            bytes = new byte [] { (byte)0xb3, (byte)0xe0 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u2287";
            bytes = new byte [] { (byte)0xa2, (byte)0xbd };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6b43";
            bytes = new byte [] { (byte)0xdd, (byte)0xbd };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff4b";
            bytes = new byte [] { (byte)0xa3, (byte)0xeb };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u751f";
            bytes = new byte [] { (byte)0xc0, (byte)0xb8 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff85\uff16";
        bytes = new byte [] { (byte)0x8e, (byte)0xc5, (byte)0xa3, (byte)0xb6
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff9d\u6234";
        bytes = new byte [] { (byte)0x8e, (byte)0xdd, (byte)0xc2, (byte)0xd7
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u75d2\u7962";
        bytes = new byte [] { (byte)0xe1, (byte)0xda, (byte)0xc7, (byte)0xaa
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5b2a";
            bytes = new byte [] { (byte)0xd5, (byte)0xcd };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u251d";
            bytes = new byte [] { (byte)0xa8, (byte)0xbc };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5c3d";
            bytes = new byte [] { (byte)0xbf, (byte)0xd4 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7ac5";
            bytes = new byte [] { (byte)0xe3, (byte)0xe1 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uffe3";
            bytes = new byte [] { (byte)0xa1, (byte)0xb1 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff61\uff47";
        bytes = new byte [] { (byte)0x8e, (byte)0xa1, (byte)0xa3, (byte)0xe7
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u2640\uff76";
        bytes = new byte [] { (byte)0xa1, (byte)0xea, (byte)0x8e, (byte)0xb6
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6e19";
            bytes = new byte [] { (byte)0xde, (byte)0xd2 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u69ff";
            bytes = new byte [] { (byte)0xdc, (byte)0xdd };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5409";
            bytes = new byte [] { (byte)0xb5, (byte)0xc8 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7891";
            bytes = new byte [] { (byte)0xc8, (byte)0xea };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff47";
            bytes = new byte [] { (byte)0xa3, (byte)0xe7 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7409\u6070\uff68";
            bytes = new byte [] { (byte)0xce, (byte)0xb0, (byte)0xb3,
              (byte)0xe6, (byte)0x8e, (byte)0xa8 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u5a41\u5ac2";
        bytes = new byte [] { (byte)0xcf, (byte)0xac, (byte)0xd5, (byte)0xbf
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u253c";
            bytes = new byte [] { (byte)0xa8, (byte)0xab };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff38";
            bytes = new byte [] { (byte)0xa3, (byte)0xd8 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u718a";
            bytes = new byte [] { (byte)0xb7, (byte)0xa7 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff48d";
            bytes = new byte [] { (byte)0xa3, (byte)0xe8, 0x64 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff98\u203b";
        bytes = new byte [] { (byte)0x8e, (byte)0xd8, (byte)0xa2, (byte)0xa8
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff19";
            bytes = new byte [] { (byte)0xa3, (byte)0xb9 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u7fb9\u5149";
        bytes = new byte [] { (byte)0xe6, (byte)0xbd, (byte)0xb8, (byte)0xf7
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u6a5f";
            bytes = new byte [] { (byte)0xb5, (byte)0xa1 };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\u9587\u7dd5";
        bytes = new byte [] { (byte)0xef, (byte)0xda, (byte)0xe5, (byte)0xee
              };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff9d";
            bytes = new byte [] { (byte)0x8e, (byte)0xdd };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
            str = "\uff3a";
            bytes = new byte [] { (byte)0xa3, (byte)0xda };
            Assert.assertEquals (
            bytes,
            Encodings.EncodeToBytes (str, charset));
        }

    @Test
    public void TestEucJPSpecific() {
      byte [] bytes;
            ICharacterEncoding charset = Encodings.GetEncoding ("euc-jp");
bytes = new byte [] { (byte)0x98, (byte)0x87, (byte)0xd7, 0x38, 0x34, 0x57,
  (byte)0xb8, 0x68, (byte)0xd9, (byte)0xbc, (byte)0x97, 0x0c, (byte)0x88,
  0x60, (byte)0xa3, (byte)0xa8, 0x51, 0x1b, 0x08, 0x10, 0x7e, 0x6e, 0x36,
  (byte)0xb1, (byte)0xa4, 0x75, (byte)0xac };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd\ufffd84W\ufffdh\u62cf\ufffd\u000c\ufffd`\ufffdQ\u001b\u0008\u0010~n6\u97fbu\ufffd",
  stringTemp);
}
            bytes = new byte [] { (byte)0xda, 0x26, (byte)0xe4, 0x24, 0x23,
              0x40, 0x4e, (byte)0xff, 0x26, 0x49, 0x54, 0x28, (byte)0x9e,
              0x57, 0x49, (byte)0x93, (byte)0xd2, 0x45, 0x6b, (byte)0x91,
              (byte)0xb4, 0x50 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd&\ufffd$#@N\ufffd&IT(\ufffdWI\ufffd\ufffdEk\ufffd\ufffdP", stringTemp);
}
            bytes = new byte [] { (byte)0xb8, (byte)0x90, 0x5d, (byte)0xdf,
              0x24, (byte)0xdd, (byte)0xaf, (byte)0xa0, 0x2a, (byte)0x9a,
              0x38, 0x5d, (byte)0xf9, 0x54, 0x26, (byte)0xa8, 0x62, 0x2e,
              (byte)0x80, (byte)0xdf, (byte)0xb7, 0x70, 0x19, (byte)0xa4,
              0x2a };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd]\ufffd$\u6afb\ufffd*\ufffd8]\ufffdT&\ufffdb.\ufffd\u6fa4p\u0019\ufffd*",
  stringTemp);
}
            bytes = new byte [] { (byte)0x94, 0x22, (byte)0xde, 0x28,
              (byte)0x8c, (byte)0xa3, 0x1a, (byte)0xde, 0x4c, (byte)0xc1,
              0x1d, (byte)0xea, 0x41, (byte)0x82, (byte)0xec, 0x7f, 0x5f,
              (byte)0x8a, (byte)0xaa, (byte)0xf6, 0x2c, (byte)0x87, 0x4f,
              (byte)0x92, 0x4a };
            Assert.assertEquals (
  "\ufffd\"\ufffd(\ufffd\ufffd\u001a\ufffdL\ufffd\u001d\ufffdA\ufffd\ufffd\u007f_\ufffd\ufffd,\ufffdO\ufffdJ",

             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x17, 0x70, 0x06, 0x03, 0x33, 0x1b, 0x3f,
              (byte)0x8a, 0x73, (byte)0x8d, 0x3c, (byte)0x84, 0x69, 0x63,
              0x55, 0x46, (byte)0xa3, 0x40, 0x02, 0x42 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u0017p\u0006\u00033\u001b?\ufffds\ufffd<\ufffdicUF\ufffd@\u0002B",
  stringTemp);
}
            bytes = new byte [] { 0x48, (byte)0x8f, (byte)0xe0, 0x6b, 0x47,
              (byte)0xa9, (byte)0xdd, 0x27, 0x6a, 0x13, (byte)0xb5,
              (byte)0xf2, (byte)0x8b, 0x38, 0x37, (byte)0xc0, (byte)0xeb,
              (byte)0x88, (byte)0xc1, 0x03, (byte)0x94, 0x0c, 0x61,
              (byte)0xbb, 0x06 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "H\ufffdkG\ufffd'j\u0013\u62e0\ufffd87\u5ba3\ufffd\ufffd\u0003\ufffd\u000ca\ufffd\u0006",
  stringTemp);
}
            bytes = new byte [] { (byte)0xcd, (byte)0xea, (byte)0xe3, 0x22,
              (byte)0xe4, (byte)0xd8, 0x6a, (byte)0xf0, 0x5f, 0x18, 0x02 };
            Assert.assertEquals (
             "\u983c\ufffd\"\u7c54j\ufffd_\u0018\u0002",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xb4, (byte)0xd8, (byte)0xc0, 0x47,
              (byte)0xc5, (byte)0xf7, (byte)0xe3, (byte)0xc1, 0x2a,
              (byte)0xd6, 0x44 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u95a2\ufffdG\u75d8\u79e1*\ufffdD",
  stringTemp);
}
            bytes = new byte [] { 0x1c };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u001c",
  stringTemp);
}
            bytes = new byte [] { (byte)0xe0, 0x4a, 0x6a, 0x33, 0x64,
              (byte)0xa9, (byte)0xb9, 0x23, 0x49, (byte)0x91, (byte)0xf2,
              0x27, (byte)0x9b, 0x52, (byte)0xc1, (byte)0xca, (byte)0x8e,
              (byte)0xc5, 0x13, 0x16, 0x7c, (byte)0x8a, (byte)0xcf, 0x3a,
              0x3e, (byte)0xd7, 0x54, (byte)0xec, (byte)0xba };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdJj3d\ufffd#I\ufffd\ufffd'\ufffdR\u8a34\uff85\u0013\u0016|\ufffd\ufffd:>\ufffdT\u8c82",
  stringTemp);
}
            bytes = new byte [] { (byte)0xeb, (byte)0xdd, 0x30, 0x79, 0x08,
              (byte)0x94, 0x60, (byte)0xa7, (byte)0xef, (byte)0xf1,
              (byte)0x97, (byte)0xfe, 0x1e, 0x4b, 0x5d, 0x55, 0x04 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u8aeb0y\u0008\ufffd`\u044d\ufffd\ufffd\u001eK]U\u0004",
  stringTemp);
}
            bytes = new byte [] { 0x06, 0x4a, (byte)0xe4, 0x00, (byte)0x8c,
              0x53, 0x3a, (byte)0xbc, 0x4b, (byte)0xff, (byte)0xe0, 0x0b,
              (byte)0x89, 0x29, (byte)0x94, 0x28, 0x76, 0x2d, (byte)0x98,
              (byte)0xbf, (byte)0x92, (byte)0xda, (byte)0x95, 0x0f,
              (byte)0xea, 0x07 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u0006J\ufffd\u0000\ufffdS:\ufffdK\ufffd\ufffd\u000b\ufffd)\ufffd(v-\ufffd\ufffd\ufffd\u000f\ufffd\u0007",
 stringTemp);
}
            bytes = new byte [] { (byte)0xd5, (byte)0xf7, (byte)0x95, 0x2a,
              0x29, 0x0f, 0x34, 0x16, 0x44, (byte)0x94, 0x3a, 0x4d, 0x5e,
              0x0a, 0x7e, 0x3e, (byte)0xaf, 0x5f, 0x03, 0x20, (byte)0xee,
              0x11, (byte)0xcf, 0x72, 0x63, (byte)0xbd, (byte)0xf5, 0x1b,
              0x2a, (byte)0xb2 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u5c22\ufffd*)\u000f4\u0016D\ufffd:M^\u000a~>\ufffd_\u0003 \ufffd\u0011\ufffdrc\u52a9\u001b*\ufffd",
 stringTemp);
}
            bytes = new byte [] { 0x39, 0x0f, 0x1d, 0x03, (byte)0xd4, 0x4b,
              0x00, (byte)0xe2, 0x4e, 0x3c, 0x5d, 0x44, 0x2c, 0x7f,
              (byte)0xcf, 0x68, 0x4d, (byte)0xe5, 0x0b, 0x5f, (byte)0x9c,
              0x6c, (byte)0xe9, 0x39, (byte)0x98, 0x5c, (byte)0xb0,
              (byte)0xa8, (byte)0xf8, 0x1d };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(stringTemp,"9\u000f\u001d\u0003\ufffdK\u0000\ufffdN<]D,\u007f\ufffdhM\ufffd\u000b_\ufffdl\ufffd9\ufffd\\\u59f6\ufffd\u001d");
}
            bytes = new byte [] { (byte)0xf0, 0x2a, 0x7d, 0x26, (byte)0xc5,
              (byte)0xa0, (byte)0xbf, 0x7d, 0x1a, 0x1d, 0x1d, (byte)0x81,
              (byte)0xa1, 0x49, (byte)0x99, (byte)0xa6 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd*}&\ufffd\ufffd}\u001a\u001d\u001d\ufffd\ufffdI\ufffd\ufffd",
  stringTemp);
}
            bytes = new byte [] { (byte)0xed, (byte)0xa5, (byte)0xc1,
              (byte)0xbf, 0x6a, 0x03, 0x60, (byte)0x84, 0x06, (byte)0xcf,
              (byte)0xad, (byte)0xe6, 0x5a, 0x2b, (byte)0x9f, (byte)0x99 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u8e48\u695aj\u0003`\ufffd\u0006\u5eca\ufffdZ+\ufffd\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x11, (byte)0x8c, (byte)0x89, (byte)0xd1,
              0x70, 0x3e, 0x34, 0x67, (byte)0xde, (byte)0xf0, 0x62, 0x06,
              (byte)0xc6, 0x59, (byte)0x9b, 0x6e, (byte)0xcf, 0x52, 0x5e,
              0x56, 0x3f, (byte)0x9d, (byte)0xb5, (byte)0xe1, (byte)0xc2,
              (byte)0xb7, (byte)0x86 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u0011\ufffd\ufffd\ufffdp>4g\u6ea5b\u0006\ufffdY\ufffdn\ufffdR^V?\ufffd\u6c42\u63c3\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x18, (byte)0xb1, (byte)0xa5, 0x28,
              (byte)0xee, (byte)0xd0, (byte)0xe0, (byte)0xc8, 0x3b, 0x71,
              (byte)0xc2, 0x54, 0x46, (byte)0xd4, 0x74, (byte)0x9b, 0x79 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u0018\u540b(\u91ab\u7317;q\ufffdTF\ufffdt\ufffdy", stringTemp);
}
            bytes = new byte [] { 0x6b, (byte)0x87, (byte)0xcd, (byte)0xaf,
              (byte)0x83, 0x2c, 0x60, (byte)0x98, 0x21, (byte)0xd2,
              (byte)0xa7, 0x2f, 0x18, (byte)0xa6, (byte)0xc5 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(stringTemp,"k\ufffd\u6e67\ufffd,`\ufffd!\u52cd/\u0018\u03b5");
}
            bytes = new byte [] { (byte)0xa9, (byte)0xd9, (byte)0x9a,
              (byte)0xc7, 0x21, (byte)0xc4, (byte)0xe6, 0x12, (byte)0x85,
              (byte)0xd6, 0x40, (byte)0xc5, (byte)0xff, (byte)0x99,
              (byte)0xac, (byte)0xb3, (byte)0x88, 0x71 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd\ufffd!\u5243\u0012\ufffd\ufffd@\ufffd\ufffd\ufffd\ufffdq",
  stringTemp);
}
            bytes = new byte [] { (byte)0xbd, 0x01, (byte)0x81, (byte)0x9b,
              (byte)0xc9, 0x5d, 0x08, 0x20, (byte)0xcc, (byte)0x91,
              (byte)0x90, (byte)0x8a, (byte)0xa4 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\u0001\ufffd\ufffd\ufffd]\u0008 \ufffd\ufffd\ufffd\ufffd",
  stringTemp);
}
            bytes = new byte [] { (byte)0xfe, 0x73, 0x77, (byte)0x85,
              (byte)0xc3, 0x2a, (byte)0xf7, (byte)0xf7, 0x6a, (byte)0x98,
              (byte)0xd6, 0x55, (byte)0xc5, 0x70, 0x16, (byte)0xf0,
              (byte)0x80, 0x0a, 0x38, (byte)0x94, (byte)0xf0, 0x58,
              (byte)0xcf, 0x08, 0x2c, (byte)0x9a, (byte)0xf0, (byte)0xf3 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(stringTemp,"\ufffdsw\ufffd\ufffd*\ufffdj\ufffd\ufffdU\ufffdp\u0016\ufffd\u000a8\ufffd\ufffdX\ufffd\u0008,\ufffd\u980c");
}
            bytes = new byte [] { (byte)0x9a, (byte)0x81, 0x5e, (byte)0xa3,
              (byte)0xc6, 0x40, (byte)0x9b, (byte)0xf7, (byte)0xae, 0x06,
              (byte)0xb9, (byte)0x89, 0x4a, (byte)0xb0, 0x20, (byte)0xb5,
              0x74, 0x0d, (byte)0x83, 0x39, (byte)0xab, 0x3b, 0x43 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd^\uff26@\ufffd\ufffd\u0006\ufffdJ\ufffd \ufffdt\u000d\ufffd9\ufffd;C",
  stringTemp);
}
            bytes = new byte [] { (byte)0xa6, (byte)0xbd, (byte)0x93,
              (byte)0xd4, 0x7a, (byte)0xc9, (byte)0xb6, (byte)0xc0,
              (byte)0xf3, 0x6a, (byte)0x92, 0x0f, (byte)0xd9, (byte)0xe9,
              0x6e, 0x4a, (byte)0xfd, (byte)0xc4, (byte)0xff };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd\ufffdz\u4ff5\u6834j\ufffd\u000f\u63c4nJ\ufffd\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x1c, (byte)0xf4, 0x47, (byte)0xbd,
              (byte)0x87, (byte)0xee, 0x09, (byte)0xe6, (byte)0x9c,
              (byte)0xdc, (byte)0xa7, 0x65, (byte)0xdc, (byte)0x9a,
              (byte)0xf7, (byte)0xe0, (byte)0xcd, 0x64 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u001c\ufffdG\ufffd\ufffd\u0009\ufffd\u68d7e\ufffd\ufffd\ufffdd",
  stringTemp);
}
            bytes = new byte [] { 0x32, 0x75, (byte)0xa3, 0x09, 0x10,
              (byte)0xe6, (byte)0xda, 0x0a, 0x51, (byte)0xf9, 0x33,
              (byte)0xa9, (byte)0xb1, (byte)0xed, 0x0b, 0x5c, (byte)0xd7,
              0x05, (byte)0xb0, 0x3b, (byte)0x9b, 0x18, (byte)0xef, 0x09,
              (byte)0xed, (byte)0xa2 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "2u\ufffd\u0009\u0010\u8052\u000aQ\ufffd3\ufffd\ufffd\u000b\\\ufffd\u0005\ufffd;\ufffd\u0018\ufffd\u0009\u8e49",
  stringTemp);
}
            bytes = new byte [] { (byte)0xcd, (byte)0xda, 0x60, 0x47,
              (byte)0x8d, (byte)0xc4, 0x00, (byte)0xff };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u9065`G\ufffd\ufffd\u0000\ufffd",
  stringTemp);
}
            bytes = new byte [] { (byte)0xfa, (byte)0xdf, 0x37, 0x21,
              (byte)0x85, 0x58, 0x6a, (byte)0xa0, 0x10, 0x3c, (byte)0xb7,
              0x28, 0x55, 0x7b, (byte)0xf7, (byte)0x88, (byte)0xcc, 0x64,
              0x54, 0x18, (byte)0xb0, 0x3a, 0x76, 0x3f, 0x30, 0x2b, 0x5a,
              0x21, 0x73, (byte)0xee };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u6cda7!\ufffdXj\ufffd\u0010<\ufffd(U {\ufffd\ufffddT\u0018\ufffd:v?0+Z!s\ufffd",
 stringTemp);
}
            bytes = new byte [] { 0x7a, 0x70, (byte)0xad, (byte)0x8f, 0x57,
              0x30, 0x06, 0x75, (byte)0xa1, 0x22, (byte)0xa6, 0x52, 0x11,
              0x05, 0x7e, (byte)0xa1, 0x39, (byte)0xbf, 0x2b, (byte)0xc0,
              (byte)0xb6, (byte)0xa6, (byte)0x87, (byte)0x91, (byte)0xe4,
              0x3e, (byte)0x96, 0x3e };
            Assert.assertEquals (
  "zp\ufffdW0\u0006u\ufffd\"\ufffdR\u0011\u0005~\ufffd9\ufffd+\u6e05\ufffd\ufffd\ufffd>\ufffd>",
  Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x05, 0x6a, 0x71, (byte)0xbc, (byte)0xbc,
              0x22, (byte)0xef, 0x0a, (byte)0xc0, 0x66, 0x0a, (byte)0x85,
              0x1d, (byte)0xbd, (byte)0xbd, (byte)0xf0, 0x39, 0x27,
              (byte)0x8b, (byte)0xd5, 0x32, 0x00, 0x11, 0x40, (byte)0xcb };
            Assert.assertEquals (
  "\u0005jq\u5ba4\"\ufffd\u000a\ufffdf\u000a\ufffd\u001d\u5341\ufffd9'\ufffd\ufffd2\u0000\u0011@\ufffd",
  Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xc0, (byte)0x9c, (byte)0xb7,
              (byte)0xd5, 0x61, 0x2e, (byte)0xcb, 0x34, 0x4d, (byte)0xae,
              0x73, 0x1d, 0x6c, 0x19, (byte)0xfc, 0x40 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\u834aa.\ufffd4M\ufffds\u001dl\u0019\ufffd@",
  stringTemp);
}
            bytes = new byte [] { 0x23, 0x4a, 0x5c, 0x7a, 0x06, (byte)0x84,
              (byte)0x9c, 0x36, 0x63, 0x28, (byte)0xcf, (byte)0xfd, 0x3f,
              0x52, 0x27, (byte)0xe8, (byte)0xe0, 0x32, 0x2c, (byte)0xd1,
              0x76, 0x2c, (byte)0x90 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "#J\\z\u0006\ufffd\ufffd6c(\ufffd?R'\u846f2,\ufffdv,\ufffd", stringTemp);
}
            bytes = new byte [] { 0x51, (byte)0x9c, 0x5d, 0x30, (byte)0x8b,
              0x08, (byte)0xd7, (byte)0xb4, 0x17, (byte)0xb0, (byte)0xa0,
              (byte)0xd8, (byte)0xe1, 0x30, 0x5a, (byte)0xe8, (byte)0x9d,
              (byte)0xc3, 0x1c, 0x78, 0x65 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "Q\ufffd]0\ufffd\u0008\u5f5c\u0017\ufffd\u61910Z\ufffd\ufffd\u001cxe",
  stringTemp);
}
            bytes = new byte [] { 0x6d, 0x47, 0x07, 0x02, 0x30, 0x73, 0x74,
              (byte)0xe5, (byte)0xad, 0x2e, 0x57, 0x38, (byte)0x9e,
              (byte)0xc7, 0x2d, 0x0b, 0x65, 0x21 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "mG\u0007\u00020st\u7d56.getW8()\ufffd\ufffd-\u000be!",
  stringTemp);
}
            bytes = new byte [] { (byte)0xeb, 0x69, (byte)0xb7, (byte)0xb6,
              0x31, 0x0c, 0x43, 0x34, 0x09, 0x0f, (byte)0xd5, (byte)0xeb,
              0x3a, 0x5f, (byte)0xd7, 0x05, (byte)0x98, 0x44, 0x0c };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdi\u88881\u000cC4\u0009\u000f\u5bde:_\ufffd\u0005\ufffdD\u000c",
  stringTemp);
}
            bytes = new byte [] { (byte)0x81, (byte)0xb0, 0x2f, 0x04,
              (byte)0xab, (byte)0xbf, (byte)0xe5, (byte)0xb4, 0x18,
              (byte)0xe3, (byte)0xb7, (byte)0xc6, (byte)0xc0, 0x0d,
              (byte)0xb1, (byte)0x81, (byte)0xd0, 0x33, 0x24, 0x31, 0x12 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd/\u0004\ufffd\u7d93\u0018\u9f4b\u5f97\u000d\ufffd\ufffd3$1\u0012",
  stringTemp);
}
            bytes = new byte [] { 0x7d, 0x73, 0x64, 0x7d, 0x65, (byte)0xcc,
              (byte)0xeb, 0x00, (byte)0xa3, (byte)0xcb, (byte)0x84, 0x2e,
              0x3b, (byte)0xfe, (byte)0x9b, 0x75, 0x14, (byte)0x92, 0x1d,
              (byte)0xa1, 0x71, (byte)0xdd, (byte)0xb5, (byte)0xfc,
              (byte)0xc7, 0x33, (byte)0x98, (byte)0xcf, 0x64, 0x7d };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "}sd}e\u591c\u0000\uff2b\ufffd.;\ufffdu\u0014\ufffd\u001d\ufffdq\u9b31\u93a43\ufffd\ufffdd}",
  stringTemp);
}
            bytes = new byte [] { (byte)0xa0, (byte)0xe8, (byte)0xe4,
              (byte)0xbc, 0x5b, 0x68, (byte)0x95, 0x21, 0x76, (byte)0xfc };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\u8462\ufffd[h\ufffd!v\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x77 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "w",
  stringTemp);
}
            bytes = new byte [] { (byte)0xd2, (byte)0x89, (byte)0x83, 0x08,
              0x63, (byte)0x84, (byte)0xfa, 0x2d, 0x5f, 0x2d, (byte)0xb1,
              0x10, 0x15, 0x08, 0x5d, (byte)0xff, (byte)0xae, 0x16, 0x54,
              (byte)0xc5, 0x50, (byte)0x84 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd\u0008c\ufffd\ufffd-_-\ufffd\u0010\u0015\u0008]\ufffd\ufffd\u0016T\ufffdP\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x71, 0x45, (byte)0xac, (byte)0xab,
              (byte)0xca, (byte)0xf8, (byte)0xaa, (byte)0xc4, (byte)0xe0,
              0x0b };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "qE\ufffd\u5d29\ufffd\ufffd\u000b",
  stringTemp);
}
            bytes = new byte [] { 0x28, 0x32, (byte)0xf1, (byte)0xec,
              (byte)0xb0, (byte)0x9e, (byte)0xe3, 0x48, (byte)0x8e, 0x4d,
              (byte)0xe0, 0x2d, 0x26, (byte)0x85, (byte)0xa1, (byte)0xe1,
              0x43, (byte)0xa2, 0x5a, 0x58, (byte)0xf4 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "(2\u9aad\ufffd\ufffdH\ufffdM\ufffd-&\ufffd\uff1dC\ufffdZX\ufffd", stringTemp);
}
            bytes = new byte [] { 0x27, (byte)0xbc, (byte)0x92, (byte)0x92,
              0x11, 0x5a, 0x74, 0x21, (byte)0xb4, (byte)0xfe, (byte)0xd1,
              0x72, (byte)0xc0, (byte)0x9d, 0x13, 0x77, (byte)0xec,
              (byte)0x8c, 0x36, 0x7f, 0x68, 0x5b };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "'\ufffd\ufffd\u0011Zt!\u68c4\ufffdr\ufffd\u0013w\ufffd6\u007fh[",
  stringTemp);
}
            bytes = new byte [] { (byte)0x99, 0x4f, 0x16, (byte)0xdf, 0x4f,
              (byte)0xc3, (byte)0xca, (byte)0xdc, (byte)0xc7, 0x19,
              (byte)0xe7, (byte)0xf8, 0x0b, (byte)0xb8, (byte)0x8d, 0x32,
              (byte)0xf0, (byte)0x85, 0x16, 0x1a, 0x50, 0x35, (byte)0xec,
              (byte)0xc8, (byte)0xb3, 0x1b, (byte)0xfb };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdO\u0016\ufffdO\u6bb5\u69d0\u0019\u82fb\u000b\ufffd2\ufffd\u0016\u001aP5\u8cb3\ufffd\u001b\ufffd",
  stringTemp);
}
            bytes = new byte [] { (byte)0xe7, (byte)0x80, (byte)0x9c, 0x53,
              (byte)0xcc, (byte)0xe2, (byte)0x9e, 0x75, 0x51, (byte)0xd7,
              (byte)0x91 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffdS\u7c7e\ufffduQ\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x0c, (byte)0xa6, 0x01, 0x7f, 0x31, 0x1a,
              (byte)0x93, (byte)0x84, (byte)0xfa, 0x28, 0x74, 0x77,
              (byte)0xcb, 0x3b, (byte)0xe6 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u000c\ufffd\u0001\u007f1\u001a\ufffd\ufffd\ufffd(tw\ufffd;\ufffd",
  stringTemp);
}
            bytes = new byte [] { (byte)0xf0, (byte)0xb6, 0x37, 0x18,
              (byte)0xa0, 0x08, 0x21, 0x00, 0x66, (byte)0xdc, 0x72, 0x1e,
              0x26, (byte)0xf4, (byte)0xae, (byte)0x9c, 0x08, (byte)0xc2,
              (byte)0xc4, 0x16, 0x5a, 0x04, 0x57, (byte)0xa9, 0x5d, 0x70,
              (byte)0x95 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u96cd7\u0018\ufffd\u0008!\u0000f\ufffdr\u001e&\ufffd\ufffd\u0008\u5815\u0016Z\u0004W\ufffd]p\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x68, (byte)0x83, (byte)0xe0, (byte)0x91,
              0x48, 0x47, (byte)0xfd, 0x03, 0x55, 0x25, (byte)0xa3,
              (byte)0xeb, (byte)0xfd };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "h\ufffd\ufffdHG\ufffd\u0003U%\uff4b\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x33, 0x12, 0x2c, 0x02, 0x2b, 0x64, 0x45,
              (byte)0xf0, (byte)0xd6, 0x5c, 0x2c, 0x4b, (byte)0xf8, 0x29,
              (byte)0xd5, (byte)0xd3, 0x5a, (byte)0xb7 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(K\ufffd,"3\u0012,\u0002+dE\u976b\\)\u5b51Z\ufffd", stringTemp);
}
            bytes = new byte [] { 0x40, 0x0b };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "@\u000b",
  stringTemp);
}
            bytes = new byte [] { (byte)0xf7, (byte)0xdf, (byte)0xfc,
              (byte)0x82, (byte)0xfe, 0x64, (byte)0xd3, 0x69, (byte)0xf9,
              (byte)0xfa, 0x19 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd\ufffdd\ufffdi\u5dd0\u0019",
  stringTemp);
}
            bytes = new byte [] { (byte)0x9f, (byte)0xe7, 0x53, 0x70, 0x59,
              (byte)0xa9, (byte)0xef, (byte)0xb1, (byte)0xb9, (byte)0xfb,
              (byte)0xa0, 0x3a, 0x6c };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffdSpY\ufffd\u53a9\ufffd:l",
  stringTemp);
}
            bytes = new byte [] { 0x16 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u0016",
  stringTemp);
}
            bytes = new byte [] { (byte)0xa7, 0x48 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdH",
  stringTemp);
}
            bytes = new byte [] { 0x7b, 0x6c, 0x4e, (byte)0xd3 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "{lN\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x0d, (byte)0xd8, 0x40, 0x42, 0x6f, 0x3c };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u000d\ufffd@Bo<",
  stringTemp);
}
            bytes = new byte [] { 0x52, (byte)0xc2, 0x43, 0x6e, (byte)0xd5,
              (byte)0xd4, 0x23, 0x59, 0x6c, 0x7f, 0x4e, 0x73, 0x72, 0x14,
              (byte)0xb1, 0x5e, 0x17, (byte)0xe0, (byte)0xdf, 0x24,
              (byte)0xe7, (byte)0xae, 0x56, (byte)0xd9, (byte)0xc9,
              (byte)0xe9, (byte)0xad, (byte)0xf6 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "R\ufffdCn\u5b55#Yl\u007fNsr\u0014\ufffd^\u0017\u73ce$\u818aV\u62ee\u859b\ufffd",
  stringTemp);
}
            bytes = new byte [] { (byte)0xfa, (byte)0xa9, (byte)0xa4,
              (byte)0xed, (byte)0xcd, 0x00, 0x0c, 0x07, 0x31, (byte)0xa3,
              (byte)0xe6, 0x67, (byte)0xce, 0x2f, 0x03 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u6111\u308d\ufffd\u0000\u000c\u00071\uff46g\ufffd/\u0003",
  stringTemp);
}
            bytes = new byte [] { (byte)0x8b, 0x52, (byte)0xe6, (byte)0x9b,
              0x04, 0x3d, 0x29, 0x6e, 0x5c, 0x76, 0x53, (byte)0xba,
              (byte)0xfa, 0x24, 0x6e, 0x5b, 0x4f, 0x7a, (byte)0xd9, 0x63 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdR\ufffd\u0004=)n\\vS\u9bad$n[Oz\ufffdc", stringTemp);
}
            bytes = new byte [] { (byte)0x9a, 0x54, 0x1a, (byte)0xd5,
              (byte)0xb1, (byte)0x9f, (byte)0xe5, (byte)0x8f, (byte)0x84,
              (byte)0x9f, (byte)0xa7, 0x7e, 0x1c, (byte)0x85, (byte)0xc2,
              (byte)0xec };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdT\u001a\u5a1c\ufffd\ufffd\ufffd\ufffd\ufffd~\u001c\ufffd\u6edd",
  stringTemp);
}
            bytes = new byte [] { (byte)0xa9, 0x3e, (byte)0x95, 0x47, 0x26,
              (byte)0xfc, (byte)0xd5, (byte)0x93, (byte)0xa2, (byte)0xad,
              (byte)0xd2, (byte)0xd0, (byte)0xa7, 0x66, (byte)0xf8,
              (byte)0xb3, 0x4e, 0x64, (byte)0xc9, (byte)0xfe };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd>\ufffdG&\u9743\ufffd\u2193\u53a5\ufffdf\ufffdNd\u670d",
  stringTemp);
}
            bytes = new byte [] { (byte)0xbf, (byte)0xe7, 0x6a, (byte)0x8c,
              (byte)0xd7, 0x17, 0x6d, (byte)0xc1, (byte)0x83 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u7761j\ufffd\ufffd\u0017m\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x2e, (byte)0xc4, 0x5d, (byte)0xc8,
              (byte)0xe2, (byte)0xe9, 0x55, (byte)0xa2, (byte)0x97, 0x1a,
              (byte)0xfa, 0x09, 0x66, 0x1a, 0x35, (byte)0xf5, (byte)0xa7,
              0x22, (byte)0xfa, (byte)0xf3, 0x1c, (byte)0xe6, 0x0f,
              (byte)0x94, 0x65, (byte)0xd7 };
            Assert.assertEquals (
  ".\ufffd]\u6249\ufffdU\ufffd\u001a\ufffd\u0009f\u001a5\ufffd\"\u7028\u001c\ufffd\u000f\ufffde\ufffd",
  Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xad, (byte)0xb6, 0x4a, 0x03, 0x2a,
              0x7d, 0x08, (byte)0xce, (byte)0x83, (byte)0xec, (byte)0xfb,
              (byte)0xa3, (byte)0xca, (byte)0x93, 0x47, 0x46, (byte)0xe2,
              0x55, 0x7d };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u2161J\u0003*}\u0008\ufffd\u8e35\uff2a\ufffdGF\ufffdU}",
  stringTemp);
}
            bytes = new byte [] { (byte)0x95, (byte)0x90, (byte)0xc5, 0x40,
              0x4d, 0x41, 0x0f };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd\ufffd@MA\u000f",
  stringTemp);
}
            bytes = new byte [] { (byte)0xec, (byte)0x90, (byte)0x92, 0x1f,
              0x00, (byte)0xac, (byte)0xba, 0x7a, (byte)0xb3, (byte)0xda,
              (byte)0xba, (byte)0xa6, 0x53, (byte)0xa6, (byte)0xde };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd\u001f\u0000\ufffdz\u697d\u58beS\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x35, 0x44, (byte)0xe6, 0x48, 0x43, 0x58,
              (byte)0xbd, (byte)0xf4, (byte)0x85, 0x02, (byte)0xfa,
              (byte)0x9f, 0x71, 0x0c, 0x5f, (byte)0x92, 0x6d, (byte)0x88,
              (byte)0x88, (byte)0xfe, 0x7f, (byte)0xca, 0x53, (byte)0x82,
              0x7f, (byte)0xf0, (byte)0xd8, 0x2e, (byte)0x97, 0x5a };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "5D\ufffdHCX\u8af8\ufffd\u0002\ufffdq\u000c_\ufffdm\ufffd\ufffd\ufffd\u007f\ufffdS\ufffd\u007f\u9779.\ufffdZ",
  stringTemp);
}
            bytes = new byte [] { (byte)0xc2, (byte)0xa6, 0x76, (byte)0xd7,
              (byte)0x84, 0x62, (byte)0x88, (byte)0xb9, (byte)0xac,
              (byte)0xd6, (byte)0xe1, (byte)0xd8, 0x20, 0x59, 0x6f, 0x35,
              0x0a, 0x0f, 0x0d, (byte)0xdb, 0x3d, 0x22, (byte)0xaa,
              (byte)0x82 };
            Assert.assertEquals (
  "\u5074v\ufffdb\ufffd\u5e78\u5df2\ufffd Yo5\u000a\u000f\u000d\ufffd=\"\ufffd",
  Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { 0x45, 0x25, (byte)0x86, 0x01, 0x6f, 0x1f,
              (byte)0xf5, (byte)0xfe, (byte)0xa9, (byte)0xa3, 0x31,
              (byte)0xab, 0x10, 0x70, (byte)0xda, 0x23, (byte)0xda, 0x35,
              (byte)0xe5 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "E%\ufffd\u0001o\u001f\ufffd\ufffd1\ufffd\u0010p\ufffd#\ufffd5\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x31, (byte)0x8a, (byte)0xf2, 0x12, 0x2b,
              0x1b, 0x6b, (byte)0x98, (byte)0xb0, 0x1c, 0x16, 0x21, 0x3c,
              0x41, (byte)0x86, 0x0c, (byte)0xaa, 0x62, 0x58, (byte)0x9a,
              (byte)0xd1, 0x00, 0x2a, (byte)0xed };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "1\ufffd\ufffd\u0012+\u001bk\ufffd\ufffd\u001c\u0016!<A\ufffd\u000c\ufffdbX\ufffd\ufffd\u0000*\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x3c, (byte)0x9c, (byte)0xb6, 0x04, 0x45,
              0x2b, (byte)0x95, 0x5d, 0x57, 0x7b, (byte)0x8a, (byte)0xad,
              0x52, (byte)0xe7, (byte)0xdd, (byte)0x90, (byte)0xc9, 0x0a,
              0x50 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "<\ufffd\ufffd\u0004E+\ufffd]W {\ufffd\ufffdR\u825a\ufffd\ufffd\u000aP",
  stringTemp);
}
            bytes = new byte [] { (byte)0xca, 0x64, (byte)0x9e, (byte)0xcf,
              0x46, 0x4e, (byte)0x90, (byte)0xbf, 0x0c, 0x54, 0x4d,
              (byte)0xc5, 0x52, (byte)0xe8, 0x06, 0x0f, 0x25, (byte)0xa6,
              (byte)0xd9, (byte)0xe0, 0x33, (byte)0xb3, (byte)0xf6, 0x45,
              0x77, 0x45, 0x44 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdd\ufffd\ufffdFN\ufffd\ufffd\u000cTM\ufffdR\ufffd\u0006\u000f%\ufffd\ufffd3\u7ac3EwED",
  stringTemp);
}
            bytes = new byte [] { 0x2e, (byte)0xbe, 0x06, (byte)0xd0, 0x57,
              (byte)0xbd, (byte)0xe7, 0x5e, 0x2f, (byte)0xee, 0x40,
              (byte)0xb4, (byte)0xfc, (byte)0xb2, (byte)0xa2, (byte)0x87,
              0x6f, 0x18 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  ".\ufffd\u0006\ufffdW\u9806^/\ufffd@\u671f\u65fa\ufffdo\u0018",
  stringTemp);
}
            bytes = new byte [] { (byte)0xf4, (byte)0xf5, (byte)0x9a,
              (byte)0xf6, (byte)0xa2, 0x18, 0x66, (byte)0xb0, (byte)0xef,
              0x39, (byte)0xe0, 0x2d, (byte)0x9e, (byte)0xb9, 0x6c,
              (byte)0xa2 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd\ufffd\u0018f\u90389\ufffd-\ufffd\ufffdl\ufffd",
  stringTemp);
}
            bytes = new byte [] { (byte)0xda, (byte)0xad, (byte)0x99, 0x32,
              0x21, (byte)0x99, (byte)0x83, 0x22, (byte)0xd1 };
            Assert.assertEquals (
             "\u62ac\ufffd2!\ufffd\ufffd\"\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0xc6, 0x3b, (byte)0xe8, 0x7d,
              (byte)0xdb, 0x78, 0x6c, (byte)0xc8, 0x6b, (byte)0xb4,
              (byte)0xfb, (byte)0xb1, 0x5b, 0x60, (byte)0xe7, 0x78, 0x2c,
              0x3a, 0x5d, 0x10, 0x0d, 0x6c, (byte)0xe7, (byte)0xaa, 0x44,
              (byte)0xb4, 0x61, (byte)0xc4 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(stringTemp,"\ufffd;\ufffd}\ufffdxl\ufffdk\u65e2\ufffd[`\ufffdx,:]\u0010\u000dl\u8166D\ufffda\ufffd");
}
            bytes = new byte [] { 0x69, 0x1c, (byte)0xcf, 0x34, 0x4d,
              (byte)0xef, (byte)0xb2, (byte)0x86 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "i\u001c\ufffd4M\u93d6\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x52, 0x14, 0x6a, (byte)0xae, 0x78, 0x3e,
              (byte)0xea, 0x01, (byte)0x86, 0x1b, 0x45, (byte)0x9a,
              (byte)0xe5, (byte)0x96, (byte)0xdf, (byte)0xe7, 0x73,
              (byte)0xb2, (byte)0xeb, (byte)0xca, (byte)0xce, (byte)0xf5,
              0x2c, (byte)0xed, 0x7a, (byte)0xa7 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(stringTemp,"R\u0014j\ufffdx>\ufffd\u0001\ufffd\u001bE\ufffd\ufffd\u7188s\u86fe\u8511\ufffd,\ufffdz\ufffd");
}
            bytes = new byte [] { (byte)0x84, (byte)0x98, (byte)0xaa, 0x00,
              0x15, 0x33, (byte)0xa6, (byte)0x95, 0x3d, 0x2e, (byte)0xfc };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd\ufffd\u0000\u00153\ufffd=.\ufffd",
  stringTemp);
}
            bytes = new byte [] { (byte)0xe9, (byte)0x8f, (byte)0xd3, 0x28,
              (byte)0x92, (byte)0xad, 0x25, 0x7c, (byte)0xdc, 0x6d,
              (byte)0x82, 0x53, 0x49, 0x73, (byte)0xf0, (byte)0xd5 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd(\ufffd\ufffd%|\ufffdm\ufffdSIs\u52d2", stringTemp);
}
            bytes = new byte [] { (byte)0x9c, 0x53 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdS",
  stringTemp);
}
            bytes = new byte [] { 0x46, (byte)0xa8, 0x2e, (byte)0xe7,
              (byte)0x97, 0x3e, 0x56, (byte)0xa2, (byte)0x8a, 0x09,
              (byte)0x80, (byte)0xca, 0x19, 0x04, 0x68, (byte)0xc6, 0x3d,
              0x4e, (byte)0xf4, 0x55, (byte)0x90, 0x2c, 0x25 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(stringTemp,"F\ufffd.\ufffd>V\ufffd\u0009\ufffd\ufffd\u0019\u0004h\ufffd=N\ufffdU\ufffd,%");
}
            bytes = new byte [] { (byte)0xc2, (byte)0xd9, 0x34, (byte)0xa9,
              0x28, (byte)0xe5 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u6cf04\ufffd(\ufffd", stringTemp);
}
            bytes = new byte [] { (byte)0x87, 0x50, 0x44, 0x2b, (byte)0xdc,
              0x30, (byte)0x97, 0x5f, 0x55, (byte)0x8a, 0x13, (byte)0xa6,
              0x5e };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdPD+\ufffd0\ufffd_U\ufffd\u0013\ufffd^",
  stringTemp);
}
            bytes = new byte [] { (byte)0x81, 0x62, 0x3c, 0x57, (byte)0x95,
              (byte)0xf1, 0x4d, 0x17, 0x13, (byte)0xab, (byte)0xd7 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdb<W\ufffd\ufffdM\u0017\u0013\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x03, (byte)0x8f, 0x1d, (byte)0xd3,
              (byte)0xed, 0x5f, (byte)0xf7, 0x2c, (byte)0x9f, 0x5e,
              (byte)0xa9, 0x5b, 0x65, 0x1e, 0x30, (byte)0xf4, 0x0c,
              (byte)0xc8, 0x0e, 0x37, 0x1d, (byte)0xf3, (byte)0xc7 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(stringTemp,"\u0003\ufffd\u001d\u56b6_\ufffd,\ufffd^\ufffd[e\u001e0\ufffd\u000c\ufffd\u000e7\u001d\u9e88");
}
            bytes = new byte [] { (byte)0xf4, 0x56, (byte)0xcb, (byte)0x85,
              (byte)0xfb, (byte)0xbc, (byte)0xe1, 0x0b };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdV\ufffd\u52af\ufffd\u000b",
  stringTemp);
}
            bytes = new byte [] { (byte)0xe1, (byte)0xce, 0x74, 0x23, 0x5b,
              (byte)0xcb, 0x40, (byte)0x97, (byte)0x95, 0x3b, 0x6f,
              (byte)0xfc, (byte)0xbb, 0x23, 0x05, (byte)0xf5, (byte)0xfd,
              0x7b, (byte)0xee, 0x6e, (byte)0xdd, (byte)0x9d, 0x31, 0x25,
              (byte)0x8b, (byte)0xb0, 0x0e };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u75a5t#[\ufffd@\ufffd\ufffd;o\u92e0#\u0005\ufffd {\ufffdn\ufffd1%\ufffd\ufffd\u000e",
  stringTemp);
}
            bytes = new byte [] { (byte)0xa0, (byte)0x90, (byte)0xc0,
              (byte)0x8a, 0x21, 0x6a, 0x5e, (byte)0xd5, 0x08, 0x29, 0x6e,
              (byte)0xce, (byte)0xf2, (byte)0xe3, 0x5a, (byte)0xab,
              (byte)0x87, 0x57, (byte)0xaf, 0x7f, 0x00, 0x62, (byte)0xca,
              (byte)0x83 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd\ufffd!j^\ufffd\u0008)n\u6b74\ufffdZ\ufffdW\ufffd\u007f\u0000b\ufffd",
 stringTemp);
}
            bytes = new byte [] { 0x1f, (byte)0xc4, 0x69, (byte)0xb8, 0x07,
              0x5a, 0x5d, (byte)0xac, 0x38, (byte)0x88, 0x00, (byte)0xa1 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u001f\ufffdi\ufffd\u0007Z]\ufffd8\ufffd\u0000\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x06, 0x07, (byte)0xbb, 0x26, (byte)0x96,
              (byte)0x95, (byte)0xf0, 0x65, 0x2b, (byte)0xf3, 0x3c, 0x32,
              0x22, 0x4b, 0x6b, (byte)0xf0 };
            Assert.assertEquals (
             "\u0006\u0007\ufffd&\ufffd\ufffd\ufffde+\ufffd<2\"Kk\ufffd",
             Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0x96, (byte)0x86, (byte)0x9b, 0x11,
              0x03, (byte)0xaa, (byte)0xfd, (byte)0xba, (byte)0xd2, 0x78,
              0x4d, 0x49, 0x40, 0x0f, (byte)0xfb, 0x7c, 0x60, 0x54,
              (byte)0x91, 0x3e, (byte)0xd5, (byte)0x98 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd\ufffd\u0011\u0003\ufffd\u707dxMI@\u000f\ufffd|`T\ufffd>\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x00, 0x43, (byte)0x93, 0x4d, 0x7a,
              (byte)0x8b, 0x38, 0x5a, (byte)0xdd, 0x0c, 0x5b, (byte)0xb6,
              (byte)0x84, 0x0f, (byte)0xcb, (byte)0xb9, 0x21, (byte)0x85,
              (byte)0xb1 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u0000C\ufffdMz\ufffd8Z\ufffd\u000c[\ufffd\u000f\u5e3d!\ufffd\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x1b, (byte)0xc9, (byte)0xe8, (byte)0x86,
              0x00, 0x62, (byte)0xde, (byte)0xde, (byte)0x93, (byte)0xb8,
              (byte)0xa3, (byte)0xc9, (byte)0x91, 0x26, 0x1c, (byte)0xd1,
              (byte)0xe8, (byte)0xa2, (byte)0x88, 0x1b, 0x78, (byte)0xc5,
              (byte)0x87 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u001b\u8b5c\ufffd\u0000b\u6e4e\ufffd\u727d\ufffd&\u001c\u522a\ufffd\u001bx\ufffd",
  stringTemp);
}
            bytes = new byte [] { (byte)0xdb, 0x38, (byte)0xdd, (byte)0xc3,
              0x45, (byte)0xe6, 0x10, (byte)0xa2, (byte)0xe6, (byte)0x9f,
              (byte)0xad, (byte)0xbf, 0x57, 0x32, (byte)0xea, 0x6d,
              (byte)0x90, (byte)0xf1, 0x32, 0x65, (byte)0x80, (byte)0xa7,
              (byte)0x8a, (byte)0xda, (byte)0xf1, 0x54 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd8\u6b5fE\ufffd\u0010\u223d\ufffd\ufffdW2\ufffdm\ufffd\ufffd2e\ufffd\ufffd\u6662T",
  stringTemp);
}
            bytes = new byte [] { 0x75, (byte)0xbd, (byte)0xab, 0x7f,
              (byte)0xcf, 0x34, (byte)0xc4, (byte)0xc6, 0x65, (byte)0xaa,
              0x43, (byte)0x85, 0x2a, 0x03, 0x02, 0x38, (byte)0xfe,
              (byte)0xdd, 0x1c, 0x46, (byte)0xe3, (byte)0xf2, 0x1e, 0x38,
              (byte)0xd6 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "u\u7e4d\u007f\ufffd4\u589ce\ufffdC\ufffd*\u0003\u00028\ufffd\u001cF\u7af0\u001e8\ufffd",
  stringTemp);
}
            bytes = new byte [] { 0x55, (byte)0xed, 0x0a, (byte)0xa5, 0x30,
              0x6e, 0x5d, (byte)0xca, (byte)0x98, 0x4c, (byte)0x97,
              (byte)0xb8, (byte)0xdf, (byte)0xb1, 0x44, (byte)0xa0,
              (byte)0xfd, 0x2a, 0x09, 0x34, 0x13, (byte)0x8b, 0x2c, 0x4a,
              0x2a, 0x10 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(stringTemp,"U\ufffd\u000a\ufffd0n]\ufffdL\ufffd\u4e92\ufffdD\ufffd\ufffd*\u00094\u0013\ufffd,J*\u0010");
}
            bytes = new byte [] { (byte)0x8a, 0x44, (byte)0x88, (byte)0xf4,
              0x57, (byte)0x9c, (byte)0xd2, 0x6f, 0x15, 0x74, (byte)0xf2,
              0x7a, (byte)0xb1, (byte)0xad, 0x4d, (byte)0xd7, (byte)0xbc,
              (byte)0xd4, (byte)0xd1, (byte)0xdb, (byte)0xb8, 0x39 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdD\ufffd\ufffdW\ufffd\ufffdo\u0015t\ufffdz\u9d5cM\u5f48\u58b9\u67469",
  stringTemp);
}
  bytes = new byte [] { (byte)0xb3, 0x76, (byte)0x92, (byte)0x9d, 0x79, 0x0f
              };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdv\ufffd\ufffdy\u000f",
  stringTemp);
}
            bytes = new byte [] { (byte)0x9d, 0x6c, (byte)0xa1, (byte)0xbb,
              0x5b, 0x40, (byte)0xf2, (byte)0xdc, (byte)0xdc, 0x46,
              (byte)0xff, (byte)0xc5, (byte)0x97, (byte)0x80, (byte)0xe7,
              (byte)0xe3, 0x62, 0x13, 0x3e, 0x0a, 0x43, 0x26 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdl\u3007[@\u9c1b\ufffdF\ufffd\ufffd\ufffd\u826bb\u0013>\u000aC&",
  stringTemp);
}
            bytes = new byte [] { 0x18, 0x56, 0x04 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\u0018V\u0004",
  stringTemp);
}
            bytes = new byte [] { 0x53 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "S",
  stringTemp);
}
            bytes = new byte [] { 0x4d, 0x51, (byte)0xe0, (byte)0xfc,
              (byte)0x97, (byte)0xee, (byte)0xa7, (byte)0xab, 0x25, 0x37,
              0x2c, (byte)0x94 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(stringTemp,"MQ\u74cf\ufffd\u903e\ufffd%7,\ufffd");
}
            bytes = new byte [] { (byte)0xad, 0x53 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdS",
  stringTemp);
}
            bytes = new byte [] { (byte)0xe2, (byte)0x8d, (byte)0xcb, 0x25,
              0x08, 0x3c, 0x6c, 0x00, (byte)0x91, (byte)0x90 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd\ufffd%\u0008<l\u0000\ufffd\ufffd",
  stringTemp);
}
            bytes = new byte [] { (byte)0xf0, 0x7e, (byte)0x8f, 0x38, 0x05,
              (byte)0xf1, 0x09, (byte)0xdc, (byte)0xae, 0x7e, 0x0f };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffd~\ufffd8\u0005\ufffd\u0009\u692a~\u000f",
  stringTemp);
}
            bytes = new byte [] { (byte)0xd9, (byte)0x99, 0x76, 0x27, 0x5f,
              0x38, 0x00, (byte)0x82, (byte)0x80, (byte)0xf8, (byte)0xe4,
              (byte)0x8d, 0x3e, 0x15, (byte)0xf6 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdv'_8\u0000\ufffd\ufffd\ufffd\ufffd>\u0015\ufffd",
  stringTemp);
}
            bytes = new byte [] { (byte)0xd3, (byte)0xf4, (byte)0x95, 0x30,
              (byte)0xab, 0x7e, (byte)0xc0, (byte)0xc1, (byte)0xc8,
              (byte)0x96, (byte)0xb3, (byte)0xe1, (byte)0xf4, 0x06, 0x75,
              0x5a, 0x11, (byte)0xca, 0x19, 0x7b, 0x2c, (byte)0xf6,
              (byte)0xd8, 0x63, (byte)0xb7 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(stringTemp,"\u56c8\ufffd0\ufffd~\u8acb\ufffd\u68b6\ufffd\u0006uZ\u0011\ufffd\u0019 {,\ufffdc\ufffd");
}
            bytes = new byte [] { 0x22, 0x09, (byte)0x95, 0x5f, 0x0d,
              (byte)0xed, 0x6c, 0x07, 0x17, (byte)0xaa, (byte)0xc4,
              (byte)0x99, (byte)0x8b, (byte)0x84, 0x62, 0x33 };
            Assert.assertEquals (
  "\"\u0009\ufffd_\u000d\ufffdl\u0007\u0017\ufffd\ufffd\ufffd\ufffdb3",
  Encodings.DecodeToString (charset, bytes));
            bytes = new byte [] { (byte)0x85, 0x6b, (byte)0x82, (byte)0x96,
              (byte)0xbd, (byte)0xcb, 0x51, 0x7f, (byte)0xc4, (byte)0xc0,
              0x79, (byte)0xe6, 0x1c, 0x7c, (byte)0xb4, 0x06, 0x3a, 0x0b,
              0x15 };
            {
String stringTemp = Encodings.DecodeToString (charset, bytes);
Assert.assertEquals(
  "\ufffdk\ufffd\ufffd\u795dQ\u007f\u6c88y\ufffd\u001c|\ufffd\u0006:\u000b\u0015",
  stringTemp);
}
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
  ICharacterEncoding enc = Encodings.GetEncoding(this.valueSingleByteNames[j]);
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
      if ((Encodings.GetEncoding ("replacement"))==null) {
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
