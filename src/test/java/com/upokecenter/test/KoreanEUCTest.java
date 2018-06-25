package com.upokecenter.test; import com.upokecenter.util.*;

import org.junit.Assert;
import org.junit.Test;
import com.upokecenter.util.*;
import com.upokecenter.text.*;

public class KoreanEUCTest {
@Test
public void TestKoreanEUCDecoder() {
byte[] bytes;
String str;
ICharacterEncoding charset = Encodings.GetEncoding("euc-kr");
bytes = new byte[] { (byte)0xc0, (byte)0xdf, 0x1e, 0x33, 0x20, (byte)0xac,
  (byte)0xc3, 0x7d, 0x57 };
str = "\uc798\u001e3 \ufffd}W";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x03, 0x5d, 0x06, 0x75, (byte)0x86, 0x21, (byte)0xc9,
  (byte)0x98, 0x13, 0x4a, 0x7e, (byte)0xa2, 0x49, 0x52, (byte)0x84, 0x3f };
str = "\u0003]\u0006u\ufffd!\ufffd\u0013J~\uc91aR\ufffd?";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2a, 0x1c, 0x5f, (byte)0x81, 0x51, (byte)0xb8, 0x51,
  0x6f };
str = "*\u001c_\uac26\ud1e1o";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfc, 0x48, (byte)0xb2, (byte)0xa8, 0x1c, 0x56,
  0x4c, 0x54, 0x67, 0x7f, 0x79, (byte)0x8a, 0x3a, 0x45, 0x6e, 0x4b,
  (byte)0x83, (byte)0xe8 };
str = "\ufffdH\uaebc\u001cVLTg\u007fy\ufffd:EnK\uaec7";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc2, 0x77, 0x2a, 0x4d, (byte)0xeb, 0x5f, 0x4c,
  0x55, (byte)0xef, 0x28, (byte)0xa7, (byte)0xd7, (byte)0x96, 0x31 };
str = "\ud60d*M\ufffd_LU\ufffd(\u3393\ufffd1";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x61, 0x67, 0x29, 0x7e, 0x3d, 0x65, (byte)0xb3, 0x1e,
  0x73, 0x7f, (byte)0xa7, (byte)0xc9 };
str = "ag)~=e\ufffd\u001es\u007f\u3380";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x55, 0x6f, (byte)0xad, 0x42, 0x5d, 0x17, (byte)0xc5,
  0x19, 0x65, 0x6e, 0x03, 0x16, 0x1f, 0x71, (byte)0x9b, (byte)0xe1, 0x40,
  0x40, 0x3a, 0x62, (byte)0xc2, (byte)0xa3 };
str = "Uo\ucd62]\u0017\ufffd\u0019en\u0003\u0016\u001fq\uc3ba@@:b\uc9d9";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x38, (byte)0xf6, 0x00, (byte)0x81, 0x4e, 0x18, 0x48,
  0x70, 0x66, 0x7e, 0x52, (byte)0x97, 0x42, (byte)0x87, 0x35, (byte)0x8b,
  (byte)0xad, (byte)0xf3, 0x7d, (byte)0xf2, (byte)0xa1, 0x3d, 0x5a,
  (byte)0xb2, 0x46, (byte)0xe5, (byte)0x87 };
str =

  "8\ufffd\u0000\uac22\u0018Hpf~R\ubf84\ufffd5\ub597\ufffd}\u54ab=Z\ucf75\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xba, (byte)0xc7, 0x36, (byte)0xc2, 0x21, 0x2d,
  0x77, (byte)0xc1, 0x01, (byte)0xf3, (byte)0xf7, 0x6b, (byte)0xc2, 0x4f,
  (byte)0xca, 0x64, (byte)0x8c, (byte)0xd0, (byte)0xe6, 0x43, (byte)0xd0 };
str = "\ubd496\ufffd!-w\ufffd\u0001\u7db5k\ud5df\ufffdd\ub68d\ufffdC\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x06, (byte)0xc8, 0x61 };
str = "\u0006\ufffda";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x70, (byte)0xb5, 0x16, 0x34 };
str = "p\ufffd\u00164";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf4, 0x5f, 0x5b, 0x2a, (byte)0xb3, 0x42,
  (byte)0xe0, (byte)0x88, (byte)0xe7, 0x41, (byte)0xb3, 0x48, (byte)0xaa,
  (byte)0xfb, (byte)0xd4, (byte)0x87, (byte)0xaa, 0x28, (byte)0xdf, 0x64,
  0x65 };
str = "\ufffd_[*\ucfcd\ufffd\ufffdA\ucfd3\ufffd\ufffd\ufffd(\ufffdde";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x73, (byte)0xb3, 0x2d };
str = "s\ufffd-";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfc, 0x67, 0x43, 0x2b, (byte)0xe4, (byte)0xe6,
  (byte)0xde, (byte)0xe3, (byte)0x95, (byte)0xc8, (byte)0x9c, 0x2f, 0x74,
  0x35, 0x44, 0x39, 0x5d, 0x22, 0x5f, 0x39, (byte)0xe9, 0x07, (byte)0xd1 };
str = "\ufffdgC+\u4ef0\u7802\ube6f\ufffd/t5D9]\"_9\ufffd\u0007\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa0, 0x6f };
str = "\uc7ef";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x52, 0x70, 0x3f, 0x78, 0x75, 0x74, (byte)0xa1, 0x5f,
  0x7f };
str = "Rp?xut\ufffd_\u007f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb1, 0x34, 0x40, 0x7a, 0x12, (byte)0xfa, 0x3c,
  0x1f, (byte)0x85, 0x69, 0x29 };
str = "\ufffd4@z\u0012\ufffd<\u001f\uafec)";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x99, 0x7b, 0x22, (byte)0xe7, (byte)0xf0, 0x71,
  (byte)0xcb, (byte)0xcc, (byte)0x92, (byte)0xf8, 0x74, (byte)0xac, 0x69,
  (byte)0xbe, 0x6e, 0x3d, 0x44, 0x5c, (byte)0xe2, (byte)0xd1, 0x1b,
  (byte)0xfc, (byte)0x84, (byte)0xea, (byte)0xfd, (byte)0x81, (byte)0x84 };
str =

  "\ufffd\u007b\"\u55daq\u76d6\ubbf6t\ucd2b\ud463=D\\\u9b1a\u001b\ufffd\u6e38\uac5a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x28, (byte)0x9e, 0x63, (byte)0xa6, 0x0a, (byte)0xfe };
str = "(\uc5bf\ufffd\u000a\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1a, (byte)0x8c, (byte)0xcb, (byte)0x8b, 0x65,
  (byte)0x85, (byte)0x81, (byte)0xa4, (byte)0xd3, 0x5a, 0x79, 0x6e, 0x2f,
  (byte)0xac, (byte)0x98, (byte)0xa7, 0x3b, (byte)0xde, 0x23, 0x34,
  (byte)0xaa, 0x5c, 0x1c, 0x26, (byte)0xac, (byte)0xa1, 0x28 };
str =

  "\u001a\ub688\ub54e\ub005\u3163Zyn/\ucd56\ufffd;\ufffd#4\ufffd\\\u001c&\u0410(";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x41, 0x10, (byte)0xdf, 0x6e, 0x42, 0x0f };
str = "A\u0010\ufffdnB\u000f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x90, 0x11, 0x33, (byte)0x83 };
str = "\ufffd\u00113\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x48, (byte)0xb9, (byte)0xd3, 0x2b, 0x5b, 0x32,
  (byte)0xc8, 0x1f, 0x25, 0x64, (byte)0xf5, 0x17, (byte)0xd4, 0x1d, 0x2c,
  0x51, 0x27, (byte)0x8e, (byte)0xee };
str = "H\ubc09+[2\ufffd\u001f%d\ufffd\u0017\ufffd\u001d\u002cQ'\ub872";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc8, (byte)0xbe, 0x3b, (byte)0xb8, (byte)0x92 };
str = "\ud6a1;\ud21b";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x66, (byte)0xef, 0x37, 0x2f, 0x1f, 0x6e, 0x40, 0x24,
  0x54, 0x5e, 0x6f, (byte)0xef, (byte)0xf0, (byte)0xe0 };
str = "f\ufffd7/\u001fn@$T^o\u7a7d\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe9, 0x56, (byte)0xc4, (byte)0xec, 0x23, 0x01,
  0x2c, 0x36, 0x6d, 0x48 };
str = "\ufffdV\ucfc4#\u0001\u002c6mH";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x74, (byte)0xce, 0x34, 0x2b, 0x42, 0x6b, (byte)0x88,
  0x79, 0x70 };
str = "t\ufffd4+Bk\ub2b6p";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x93, (byte)0x89, 0x26, (byte)0xb7, (byte)0xc0,
  0x78, 0x5a, (byte)0x85, 0x34, (byte)0xba, 0x20, 0x22, 0x38, 0x43, 0x54,
  (byte)0xb3, 0x6b, (byte)0xf1, (byte)0xab, (byte)0xa0, (byte)0xc0, 0x6d,
  (byte)0x9e };
str = "\ubc63&\ub81dxZ\ufffd4\ufffd \"8CT\ucff8\u4e3b\uc853m\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x07 };
str = "\u0007";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbe };
str = "\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9a, 0x26, 0x3c, (byte)0xa5, (byte)0xce, 0x59,
  (byte)0xf3, 0x5b, (byte)0x90, (byte)0x92, (byte)0x8f, (byte)0xef, 0x29,
  0x33 };
str = "\ufffd&<\u039eY\ufffd[\ub9b3\ub945)3";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x02, 0x6c, (byte)0xdb };
str = "\u0002l\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd1, (byte)0xc8, 0x40, 0x77, (byte)0xf7 };
str = "\u9a0e@w\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7d, (byte)0xa3, 0x18, 0x22, (byte)0xf5, (byte)0xb1 };
str = "}\ufffd\u0018\"\u8d85";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5d, 0x3a, (byte)0xcb, (byte)0xc9, 0x0b, 0x5d,
  (byte)0x93, 0x66, 0x53, (byte)0x87, (byte)0xc0, (byte)0xa2, 0x55, 0x63,
  0x55, (byte)0xde, (byte)0xe5, (byte)0x8a, (byte)0x80 };
str = "]:\u6f11\u000b]\ubc3cS\ub229\uc926cU\u7940\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc5, 0x4b, (byte)0xf0, (byte)0xcb, (byte)0xed,
  (byte)0xfa, (byte)0xdc, (byte)0x97, 0x0a, 0x22, 0x16, 0x42, 0x49,
  (byte)0xd8, 0x0b, 0x32, 0x72, 0x30 };
str = "\ud723\u69fd\u85cf\ufffd\u000a\"\u0016BI\ufffd\u000b2r0";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc0, (byte)0xa3, 0x29, 0x44 };
str = "\uc6f0)D";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x21, 0x21, 0x6d, (byte)0xa6, 0x69, 0x66, 0x36, 0x3b,
  (byte)0xeb, 0x67, 0x2c, 0x63, (byte)0xc9, 0x5e, 0x4f, 0x30, (byte)0xef,
  (byte)0xac, 0x66, (byte)0xfc, 0x44, (byte)0xc6, (byte)0xdc };
str = "!!m\ucad2f6;\ufffdg\u002cc\ufffd^O0\u8a6ef\ufffdD\ud37d";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x58, 0x7d, 0x2f, (byte)0xdd, 0x51, (byte)0xe3,
  (byte)0xae, 0x34, 0x1c, 0x38, (byte)0xde, (byte)0x85, (byte)0xf2, 0x4d,
  0x23, 0x70, 0x72, 0x73, (byte)0xf8, (byte)0xab, 0x0d };
str = "X}/\ufffdQ\u53474\u001c8\ufffd\ufffdM#prs\u724c\u000d";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3a, (byte)0xcf, (byte)0xd1, 0x6e, 0x78 };
str = ":\u5c40nx";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe7, 0x36, 0x20, 0x7d, 0x67, 0x2c, 0x23, 0x72,
  0x56, 0x66, (byte)0xbd };
str = "\ufffd6 }g\u002c#rVf\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x37, (byte)0xfb, 0x2c, (byte)0xb6, 0x4f, 0x58, 0x4f,
  0x22, (byte)0xc6, (byte)0x9e, 0x4d, 0x1b, (byte)0xd3, 0x56, (byte)0x80,
  (byte)0xb1, 0x5b, 0x35, (byte)0xb1, 0x20, 0x48, (byte)0xcf, 0x75, 0x7d };
str =
  "7\ufffd\u002c\ud114XO\"\ufffdM\u001b\ufffdV\ufffd\ufffd[5\ufffd H\ufffdu}";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3f, (byte)0xbe, (byte)0xe1, 0x38, (byte)0xe8,
  (byte)0xb1, (byte)0xea, 0x09, 0x7c, 0x5a, (byte)0xa3, (byte)0xac,
  (byte)0xbc, (byte)0xf8, (byte)0xe2, 0x5d, (byte)0xcd, 0x31, (byte)0xfb,
  0x56, (byte)0x9e, 0x2a, 0x48, 0x6e, (byte)0x98, 0x76, (byte)0x81,
  (byte)0xa3, 0x79, 0x7c };
str =

  "?\uc5808\u7a69\ufffd\u0009|Z\uff0c\uc21c\ufffd]\ufffd1\ufffdV\ufffd*Hn\uc075\uac82y|";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x35, (byte)0x99, 0x76, (byte)0x8e, (byte)0x85, 0x01,
  0x7e, (byte)0xe6, 0x76, 0x5c, 0x27, 0x25, 0x02 };
str = "5\uc176\ub7e2\u0001~\ufffdv\\'%\u0002";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44 };
str = "D";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43, 0x04, (byte)0xf3, (byte)0xf7, 0x4f, 0x77, 0x22 };
str = "C\u0004\u7db5Ow\"";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb2, (byte)0xd0, (byte)0xe0, 0x2b, (byte)0xc6,
  0x3c, (byte)0x9c, 0x79, 0x3d, 0x52, (byte)0xe9, 0x3d, 0x4d, 0x5b, 0x3f,
  0x26, (byte)0xd8, 0x68, (byte)0xb2, (byte)0xf8, 0x12, (byte)0x89, 0x4c,
  0x2d };
str = "\uaf65\ufffd+\ufffd<\uc419=R\ufffd=M[?&\ufffdh\ub04c\u0012\ub379-";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x22, (byte)0xa1, (byte)0xa4, (byte)0xcd, (byte)0xa8,
  (byte)0xe5, 0x6b, 0x0c, (byte)0xad, (byte)0xc6, 0x2e, 0x58, 0x3c,
  (byte)0x8c };
str = "\"\u00b7\u7e6b\ufffdk\u000c\ufffd.X<\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf0, 0x2e, (byte)0xed, 0x5c, (byte)0xed };
str = "\ufffd.\ufffd\\\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6b, (byte)0xc4, 0x73, 0x55, 0x06, 0x7b, 0x22, 0x12,
  0x67, (byte)0x89, 0x24, 0x2f, (byte)0xe3, 0x38, 0x22, 0x5d, 0x42,
  (byte)0xd2, 0x7c, 0x36, 0x46 };
str = "k\ud6e5U\u0006\u007b\"\u0012g\ufffd$/\ufffd8\"]B\ufffd|6F";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3d, (byte)0xb9, (byte)0xa0, 0x21, (byte)0xef,
  (byte)0xdb, (byte)0xc5 };
str = "=\ud28c!\u65cc\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x83, (byte)0x92, 0x2f };
str = "\uae5a/";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb4, 0x62, 0x69, 0x6a, 0x11, (byte)0x9b,
  (byte)0xe6, (byte)0xcc, 0x28, (byte)0xbf, 0x68, (byte)0xe4, 0x06, 0x3b,
  (byte)0xc2, (byte)0xae, 0x6e };
str = "\ud052ij\u0011\uc3bf\ufffd(\ud4c0\ufffd\u0006;\uc9f0n";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x29 };
str = ")";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc5, (byte)0xe5, (byte)0xc5, 0x02, 0x21,
  (byte)0xdb, 0x66 };
str = "\ud1a1\ufffd\u0002!\ufffdf";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1e, 0x5e, 0x28, (byte)0x92, 0x7f, (byte)0x9d, 0x57,
  (byte)0xd4, 0x45, (byte)0xcd, (byte)0xc6, 0x30, (byte)0xa9, (byte)0x8c,
  0x1c, (byte)0xdc, 0x3b, 0x64, 0x07, 0x73, 0x72, 0x5a };
str = "\u001e^(\ufffd\u007f\uc4c2\ufffdE\u80a10\ucc08\u001c\ufffd;d\u0007srZ";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1b, 0x2a, (byte)0xbb, 0x40, (byte)0x8f, (byte)0xab };
str = "\u001b*\ufffd@\ub8f6";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbe, 0x6f, 0x76, 0x3a, (byte)0xee, (byte)0xe8,
  (byte)0xbe, 0x6b, 0x55, (byte)0xb5, 0x5e, 0x3c, (byte)0xf9, (byte)0xfe,
  (byte)0xae, 0x61, (byte)0x92, 0x3f, (byte)0xf6, 0x11, (byte)0xee,
  (byte)0xff, (byte)0xe4, 0x25, (byte)0xb6, 0x5e };
str =

  "\ud465v:\u8fea\ud45fU\ufffd^<\u822a\ucde2\ufffd?\ufffd\u0011\ufffd\ufffd%\ufffd^";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb2, 0x6b, (byte)0x9a, 0x3a, 0x4e, 0x47 };
str = "\ucf98\ufffd:NG";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x76, (byte)0xe3, 0x04, 0x06, 0x40, 0x13, 0x28, 0x1d,
  (byte)0xf0, 0x5f, 0x21, (byte)0xec };
str = "v\ufffd\u0004\u0006@\u0013(\u001d\ufffd_!\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x67, 0x06, (byte)0xbf, (byte)0xb0, (byte)0x9d, 0x0d,
  (byte)0xec, 0x23, (byte)0xd1, 0x02, 0x02, (byte)0x9d, (byte)0xb4,
  (byte)0xea, 0x18, 0x6d, 0x2d, 0x3f, 0x49, 0x61, (byte)0xe2, (byte)0xc7,
  (byte)0xff };
str =

  "g\u0006\uc5fc\ufffd\u000d\ufffd#\ufffd\u0002\u0002\uc520\ufffd\u0018m-?Ia\u9296\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x32, 0x30, 0x25, 0x43 };
str = "20%C";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe5, (byte)0xc6, 0x54, (byte)0xd3, (byte)0xde };
str = "\u6a23T\u5927";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xaa, 0x2d, 0x3e, (byte)0xfe, 0x09, 0x14,
  (byte)0xd0, 0x4a, (byte)0xd8, 0x68, 0x43, 0x48, 0x0b, 0x1d };
str = "\ufffd->\ufffd\u0009\u0014\ufffdJ\ufffdhCH\u000b\u001d";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0e, 0x4e, 0x67, 0x4f };
str = "\u000eNgO";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x64, 0x4a, 0x59, 0x30, (byte)0xb6, 0x06, 0x3a,
  (byte)0xc2, 0x40, 0x75 };
str = "dJY0\ufffd\u0006:\ufffd@u";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbb, (byte)0xce, (byte)0xfb, (byte)0x8d,
  (byte)0xb5, 0x69, (byte)0xf7, (byte)0xb5, (byte)0xd7 };
str = "\ubf94\ufffd\ud0bf\u5b95\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7d, 0x26, 0x01, (byte)0xb4, (byte)0x9c, (byte)0x9c,
  0x2b };
str = "}&\u0001\ud090\ufffd+";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x00, 0x4e, 0x0b, 0x56, 0x20, 0x3f, 0x3e, 0x0b, 0x47,
  (byte)0xc7, (byte)0xc5, 0x26, 0x5f };
str = "\u0000N\u000bV ?>\u000bG\ud515&_";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x07, 0x50, (byte)0xeb, 0x01, (byte)0xe7, 0x28,
  (byte)0xbd, (byte)0x8e, (byte)0x93, 0x39, 0x24 };
str = "\u0007P\ufffd\u0001\ufffd(\ud425\ufffd9$";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc6, 0x48, 0x64, 0x55, 0x35 };
str = "\ud795dU5";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbd, 0x58, (byte)0xf6, 0x13, 0x2e };
str = "\ud3f5\ufffd\u0013.";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x78, (byte)0xae, (byte)0xef, (byte)0xf0, 0x40,
  (byte)0xa0, 0x3e, (byte)0xdf, 0x5f, (byte)0x91, (byte)0xdc, (byte)0xa3,
  0x3c, (byte)0xd7, (byte)0x90, 0x35, 0x70, 0x30, 0x61, 0x66, 0x35 };
str = "x\ufffd\ufffd@\ufffd>\ufffd_\ubafd\ufffd<\ufffd5p0af5";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x87, (byte)0x8e, 0x66, 0x36, 0x6d, 0x79, 0x1a,
  0x49, 0x53, (byte)0xd8, (byte)0xb4, (byte)0xa0, (byte)0xe0, 0x19, 0x34,
  (byte)0xc0, (byte)0x85, (byte)0xe4 };
str = "\ub1e6f6my\u001aIS\u5a29\uc877\u00194\ud53e\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x37, 0x20, (byte)0x9c, 0x4c, 0x3c, (byte)0x91, 0x64,
  0x7a, 0x52, 0x20, (byte)0x97, 0x21, 0x3a, 0x3f, (byte)0xf1, 0x4c, 0x0b,
  0x70, 0x5c, 0x4a, (byte)0xcf, 0x24, (byte)0xdc, (byte)0xcc, 0x73, 0x5e,
  (byte)0xe3, 0x4a, 0x37 };
str = "7 \uc3ec<\uba76zR \ufffd!:?\ufffdL\u000bp\\J\ufffd$\u83e9s^\ufffdJ7";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe2, 0x51, 0x46, 0x4d, (byte)0xa0, (byte)0xfc,
  0x7e };
str = "\ufffdQFM\uc8a2~";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8e, 0x08, 0x64, 0x0b, 0x42 };
str = "\ufffd\u0008d\u000bB";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa4, 0x42, 0x7a, (byte)0xa0, (byte)0x97, 0x19,
  0x33, 0x3a };
str = "\uc9dfz\uc81b\u00193:";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8e, 0x54, 0x10, 0x6e, 0x28, 0x29, (byte)0xbe,
  0x0e, (byte)0xd3, (byte)0xef, (byte)0xe3, (byte)0xf6, 0x28, (byte)0xa5,
  0x71, (byte)0x90, 0x04, (byte)0xfe, 0x35 };
str = "\ub7bb\u0010n()\ufffd\u000e\u5200\u8fc5(\uca7b\ufffd\u0004\ufffd5";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd8, (byte)0x93, 0x51, (byte)0xab, 0x62,
  (byte)0xae, (byte)0xcc, (byte)0xe5, (byte)0xab, 0x61, 0x26, (byte)0x86,
  (byte)0x9d };
str = "\ufffdQ\uccbb\ufffd\u6930a&\ub114";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x48 };
str = "H";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x24, 0x68, (byte)0xf2, 0x3e, (byte)0xae, (byte)0xb8,
  (byte)0x9b };
str = "$h\ufffd>\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1d, 0x35, 0x2b, 0x72, 0x75, (byte)0xce, (byte)0xb0 };
str = "\u001d5+ru\u5bec";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x54, 0x45, 0x40, 0x72, (byte)0xc9, 0x3d, 0x63,
  (byte)0x8f, (byte)0xc7, 0x75, (byte)0xea, (byte)0xfc, (byte)0xbe, 0x60,
  0x64, 0x3f, 0x79, (byte)0xb5, (byte)0xd6, 0x1b, 0x43, (byte)0xab, 0x0e,
  (byte)0xd4, 0x75, (byte)0xdf, (byte)0xa5 };
str =
  "TE@r\ufffd=c\ub917u\uf9ca\ufffd`d?y\ub46c\u001bC\ufffd\u000e\ufffdu\u6c55";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x84, 0x0e, (byte)0xf2, 0x1f, 0x0b, 0x06, 0x2a,
  0x39, (byte)0xff, 0x3f, 0x3d, 0x03, (byte)0xc7, 0x6e, (byte)0xc8,
  (byte)0xa3, (byte)0xc9 };
str = "\ufffd\u000e\ufffd\u001f\u000b\u0006*9\ufffd?=\u0003\ufffdn\ud638\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xad, (byte)0xba, 0x38, 0x1a, (byte)0xcd,
  (byte)0xf3, 0x51, 0x58, 0x4e, 0x34, (byte)0xed, (byte)0xac, (byte)0x93,
  (byte)0xe3, (byte)0xc5, 0x37, (byte)0x84, (byte)0x96, 0x1a, 0x18, 0x0f,
  (byte)0x8e, (byte)0xb1, (byte)0x82, (byte)0x88, 0x45, 0x21, 0x36 };
str =

  "\ufffd8\u001a\u63a7QXN4\u59ff\ubcdd\ufffd7\uaf44\u001a\u0018\u000f\ub820\uad60E!6";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6c, 0x03, (byte)0x9c, 0x78, (byte)0xbc, 0x69, 0x0a,
  (byte)0xbc, (byte)0xfe, 0x73, (byte)0xfa, 0x5a, 0x50, (byte)0xbd,
  (byte)0x96, (byte)0xf2 };
str = "l\u0003\uc418\ud395\u000a\uc22ds\ufffdZP\ud42d\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfc, 0x4f, 0x6d, 0x7c, (byte)0xf0, (byte)0x9c,
  (byte)0xf9, (byte)0xf6, (byte)0x99, 0x64, (byte)0x8e, 0x54 };
str = "\ufffdOm|\ufffd\u6052\uc15d\ub7bb";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4e, (byte)0xef, 0x13, (byte)0xec };
str = "N\ufffd\u0013\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7c, 0x30, 0x51, (byte)0xbb, 0x32, 0x12, 0x03, 0x71,
  (byte)0xac };
str = "|0Q\ufffd2\u0012\u0003q\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfb, 0x7d, 0x67, 0x2c };
str = "\ufffd}g\u002c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3f, 0x4c, (byte)0x8d, (byte)0x8e, 0x5b, 0x0d,
  (byte)0xc1, (byte)0xea, (byte)0x9e };
str = "?L\ub70b[\u000d\uc96c\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x53, 0x64, 0x71, (byte)0xf1, (byte)0xf1, 0x22,
  (byte)0xa5, 0x29, 0x41, 0x27, 0x79, (byte)0xa5, 0x77, (byte)0xc5,
  (byte)0xe7, (byte)0xbe, 0x66, 0x68, (byte)0x97, 0x42, 0x4f, (byte)0xe1,
  (byte)0xbc, (byte)0x8c, 0x11, 0x4e, (byte)0xfa };
str =
  "Sdq\u847a\"\ufffd)A'y\uca82\ud1a8\ud459h\ubf84O\u6d88\ufffd\u0011N\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf6, (byte)0xa4, 0x6d, (byte)0xdc, (byte)0xcb,
  (byte)0xd3, (byte)0xcf, 0x2a, 0x3d, 0x33, (byte)0xe8, (byte)0x9c, 0x4e,
  0x4d, 0x09, 0x0d, (byte)0xea, (byte)0x81, 0x44, (byte)0xca, 0x7e,
  (byte)0xe2, (byte)0xb7, (byte)0x95 };
str = "\u5634m\u752b\u905d*=3\ufffdNM\u0009\u000d\ufffdD\ufffd~\u7d8f\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbc, 0x09, 0x3c, (byte)0xfc, 0x4b, 0x06, 0x74,
  0x65, 0x5c, (byte)0x9b, 0x4d, (byte)0x8c, 0x74, (byte)0xab, (byte)0xe2,
  0x3e, (byte)0xed, 0x72, (byte)0xf6, 0x1c, 0x6d, 0x21, 0x4b, (byte)0xc7 };
str =

  "\ufffd\u0009<\ufffdK\u0006te\\\uc321\ub633\u30e2>\ufffdr\ufffd\u001cm!K\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa0, 0x05, (byte)0x86, 0x65, (byte)0xe7,
  (byte)0xa1, 0x50, 0x3f, 0x02, (byte)0x9d, 0x67, (byte)0x9e, (byte)0xf0,
  0x35, 0x23 };
str = "\ufffd\u0005\ub0d9\uf9a6P?\u0002\uc4cc\uc6925#";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1f, (byte)0xb9 };
str = "\u001f\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe9, 0x2a, 0x2c, (byte)0xb6, (byte)0xa8,
  (byte)0xfa, (byte)0x82, (byte)0xc7, 0x3d, (byte)0xc5, 0x1a, 0x43, 0x54,
  (byte)0xf9, (byte)0x9a, (byte)0xba, 0x20 };
str = "\ufffd*\u002c\ub54d\ufffd\ufffd=\ufffd\u001aCT\ufffd\ufffd ";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x51, 0x7a, (byte)0x95, 0x17, (byte)0xa9, (byte)0x82,
  0x62, 0x5f, (byte)0xe2, 0x14, 0x68, 0x48 };
str = "Qz\ufffd\u0017\ucbfeb_\ufffd\u0014hH";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x53, (byte)0x94, 0x19, 0x24, 0x52, 0x1c, (byte)0x91,
  0x02 };
str = "S\ufffd\u0019$R\u001c\ufffd\u0002";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
}@Test
public void TestKoreanEUCEncoder() {
byte[] bytes;
String str;
ICharacterEncoding charset = Encodings.GetEncoding("euc-kr");
str = "\u61f2";
bytes = new byte[] { (byte)0xf3, (byte)0xa4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uc426\u2179\uff53\uff5b";
bytes = new byte[] { (byte)0x9c, (byte)0x8b, (byte)0xa5, (byte)0xaa,
  (byte)0xa3, (byte)0xf3, (byte)0xa3, (byte)0xfb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uaf9d";
bytes = new byte[] { (byte)0x84, (byte)0xe0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "mb\u33ae";
bytes = new byte[] { 0x6d, 0x62, (byte)0xa7, (byte)0xe2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0d\u5bd2\uff51";
bytes = new byte[] { (byte)0xa3, (byte)0xad, (byte)0xf9, (byte)0xce,
  (byte)0xa3, (byte)0xf1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u00115\uff53\u696e\u5e25";
bytes = new byte[] { 0x11, 0x35, (byte)0xa3, (byte)0xf3, (byte)0xee,
  (byte)0xbf, (byte)0xe1, (byte)0xfd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u56db\u6dc0\u7acb";
bytes = new byte[] { (byte)0xde, (byte)0xcc, (byte)0xef, (byte)0xe3,
  (byte)0xd8, (byte)0xa1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u887f";
bytes = new byte[] { (byte)0xd0, (byte)0xdb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7005";
bytes = new byte[] { (byte)0xfb, (byte)0xa4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6968\u5ddd";
bytes = new byte[] { (byte)0xef, (byte)0xdf, (byte)0xf4, (byte)0xb9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u55e4";
bytes = new byte[] { (byte)0xf6, (byte)0xb8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6aa2\u7e1d\u50c9";
bytes = new byte[] { (byte)0xcb, (byte)0xfe, (byte)0xf2, (byte)0xdc,
  (byte)0xf4, (byte)0xd2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u67fe\u5cab\u001a";
bytes = new byte[] { (byte)0xef, (byte)0xde, (byte)0xe1, (byte)0xfb, 0x1a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff04";
bytes = new byte[] { (byte)0xa3, (byte)0xa4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6ce1";
bytes = new byte[] { (byte)0xf8, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0c";
bytes = new byte[] { (byte)0xa3, (byte)0xac };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6df7\u6f51\u53ec";
bytes = new byte[] { (byte)0xfb, (byte)0xe8, (byte)0xda, (byte)0xfe,
  (byte)0xe1, (byte)0xaf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u21d4";
bytes = new byte[] { (byte)0xa2, (byte)0xa2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ucc6d";
bytes = new byte[] { (byte)0xaa, 0x76 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ub219\u6842\u24e8";
bytes = new byte[] { (byte)0xb4, (byte)0xb1, (byte)0xcc, (byte)0xfd,
  (byte)0xa8, (byte)0xe5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1d\u7119";
bytes = new byte[] { (byte)0xa3, (byte)0xbd, (byte)0xdb, (byte)0xcc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7050\uadf1\u76ba\u67ef";
bytes = new byte[] { (byte)0xfb, (byte)0xa5, (byte)0x82, (byte)0xf8,
  (byte)0xf5, (byte)0xd4, (byte)0xca, (byte)0xaf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u559c\uff3c";
bytes = new byte[] { (byte)0xfd, (byte)0xec, (byte)0xa1, (byte)0xac };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff34\uff0a\uff1c";
bytes = new byte[] { (byte)0xa3, (byte)0xd4, (byte)0xa3, (byte)0xaa,
  (byte)0xa3, (byte)0xbc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u66f7\uff17";
bytes = new byte[] { (byte)0xca, (byte)0xe3, (byte)0xa3, (byte)0xb7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u51fd";
bytes = new byte[] { (byte)0xf9, (byte)0xde };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6536\u8b49\u75d4";
bytes = new byte[] { (byte)0xe2, (byte)0xa5, (byte)0xf1, (byte)0xfb,
  (byte)0xf6, (byte)0xc0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff27\u6c41\u72c2";
bytes = new byte[] { (byte)0xa3, (byte)0xc7, (byte)0xf1, (byte)0xf0,
  (byte)0xce, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff34\ub49a\ubbe9";
bytes = new byte[] { (byte)0xa3, (byte)0xd4, (byte)0x8a, (byte)0x97,
  (byte)0x92, (byte)0xeb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff51\u6d88";
bytes = new byte[] { (byte)0xa3, (byte)0xf1, (byte)0xe1, (byte)0xbc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7aaa";
bytes = new byte[] { (byte)0xe8, (byte)0xc1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7426\ud16a";
bytes = new byte[] { (byte)0xd1, (byte)0xad, (byte)0xb6, (byte)0x9e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff55\u689d\uff2f";
bytes = new byte[] { (byte)0xa3, (byte)0xf5, (byte)0xf0, (byte)0xc9,
  (byte)0xa3, (byte)0xcf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u67f0\ub599\ubcf2";
bytes = new byte[] { (byte)0xd2, (byte)0xb0, (byte)0x8b, (byte)0xaf,
  (byte)0x93, (byte)0xf8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u511f\uff4f\u5504";
bytes = new byte[] { (byte)0xdf, (byte)0xc1, (byte)0xa3, (byte)0xef,
  (byte)0xf8, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9a0e";
bytes = new byte[] { (byte)0xd1, (byte)0xc8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff25";
bytes = new byte[] { (byte)0xa3, (byte)0xc5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6094\u6545\u688f?";
bytes = new byte[] { (byte)0xfc, (byte)0xe2, (byte)0xcd, (byte)0xba,
  (byte)0xcd, (byte)0xd9, 0x3f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5535\uffe5\ubfe6";
bytes = new byte[] { (byte)0xe4, (byte)0xda, (byte)0xa1, (byte)0xcd,
  (byte)0x97, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u572d";
bytes = new byte[] { (byte)0xd0, (byte)0xa4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ud195\u55d4\uff14";
bytes = new byte[] { (byte)0xb7, 0x6b, (byte)0xf2, (byte)0xc7, (byte)0xa3,
  (byte)0xb4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6c5a";
bytes = new byte[] { (byte)0xe7, (byte)0xfd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7401\u6c5f\ub34d";
bytes = new byte[] { (byte)0xe0, (byte)0xc4, (byte)0xcb, (byte)0xb0,
  (byte)0x88, (byte)0xf0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u795b";
bytes = new byte[] { (byte)0xcb, (byte)0xe4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff49\u56f0";
bytes = new byte[] { (byte)0xa3, (byte)0xe9, (byte)0xcd, (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u688f\uff11\ud3e8";
bytes = new byte[] { (byte)0xcd, (byte)0xd9, (byte)0xa3, (byte)0xb1,
  (byte)0xbd, 0x4f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6840";
bytes = new byte[] { (byte)0xcb, (byte)0xfa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uc439";
bytes = new byte[] { (byte)0x9c, (byte)0x9b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5b51\uff10\u0451\u656c";
bytes = new byte[] { (byte)0xfa, (byte)0xea, (byte)0xa3, (byte)0xb0,
  (byte)0xac, (byte)0xd7, (byte)0xcc, (byte)0xd7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3f\u25a8\uff5e\uc244";
bytes = new byte[] { (byte)0xa3, (byte)0xdf, (byte)0xa2, (byte)0xc9,
  (byte)0xa2, (byte)0xa6, (byte)0x9a, 0x59 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ud69f\u67f0";
bytes = new byte[] { (byte)0xc8, (byte)0xbd, (byte)0xd2, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe2\uc6a9";
bytes = new byte[] { (byte)0xa1, (byte)0xfe, (byte)0xbf, (byte)0xeb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff49\uff23\u5f31";
bytes = new byte[] { (byte)0xa3, (byte)0xe9, (byte)0xa3, (byte)0xc3,
  (byte)0xe5, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6c76";
bytes = new byte[] { (byte)0xda, (byte)0xa1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff18\u7e41\uff09";
bytes = new byte[] { (byte)0xa3, (byte)0xb8, (byte)0xdb, (byte)0xe5,
  (byte)0xa3, (byte)0xa9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u66f2\u8fc2\ub565\u7d44";
bytes = new byte[] { (byte)0xcd, (byte)0xd8, (byte)0xe9, (byte)0xe6,
  (byte)0x8b, 0x75, (byte)0xf0, (byte)0xda };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uf98c";
bytes = new byte[] { (byte)0xe6, (byte)0xb8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7459";
bytes = new byte[] { (byte)0xd2, (byte)0xc5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ubaa5\uff54\u6355";
bytes = new byte[] { (byte)0x91, (byte)0x93, (byte)0xa3, (byte)0xf4,
  (byte)0xf8, (byte)0xda };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u76df";
bytes = new byte[] { (byte)0xd8, (byte)0xef };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u64e2\u253a5\u25c7";
bytes = new byte[] { (byte)0xf6, (byte)0xf7, (byte)0xa6, (byte)0xd8, 0x35,
  (byte)0xa1, (byte)0xde };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7701\u247c\u7f85";
bytes = new byte[] { (byte)0xe0, (byte)0xfd, (byte)0xa9, (byte)0xef,
  (byte)0xd4, (byte)0xfe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff59\uff38\u253a\uccd9\u2026";
bytes = new byte[] { (byte)0xa3, (byte)0xf9, (byte)0xa3, (byte)0xd8,
  (byte)0xa6, (byte)0xd8, (byte)0xab, 0x79, (byte)0xa1, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7078\u7b39";
bytes = new byte[] { (byte)0xcf, (byte)0xb6, (byte)0xe1, (byte)0xab };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff52\u683c\uc60c\uaf88";
bytes = new byte[] { (byte)0xa3, (byte)0xf2, (byte)0xcc, (byte)0xab,
  (byte)0xbf, (byte)0xba, (byte)0xb2, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7006\u5704\uc3f3";
bytes = new byte[] { (byte)0xd4, (byte)0xb9, (byte)0xe5, (byte)0xd8,
  (byte)0x9c, 0x52 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ud264\u63db\u5bc4\u7a2e";
bytes = new byte[] { (byte)0xc6, (byte)0xa1, (byte)0xfc, (byte)0xb5,
  (byte)0xd0, (byte)0xf6, (byte)0xf0, (byte)0xfa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u53f3\uff21\u665f";
bytes = new byte[] { (byte)0xe9, (byte)0xd3, (byte)0xa3, (byte)0xc1,
  (byte)0xe0, (byte)0xf9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6dda\uff02\u868a";
bytes = new byte[] { (byte)0xd7, (byte)0xa8, (byte)0xa3, (byte)0xa2,
  (byte)0xda, (byte)0xa5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uba1e\uff17\u7891";
bytes = new byte[] { (byte)0x90, (byte)0xdb, (byte)0xa3, (byte)0xb7,
  (byte)0xdd, (byte)0xf8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d9c\uff4b\u5fb7";
bytes = new byte[] { (byte)0xf0, (byte)0xfc, (byte)0xa3, (byte)0xeb,
  (byte)0xd3, (byte)0xec };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5ead\u653e\uffe6";
bytes = new byte[] { (byte)0xef, (byte)0xd4, (byte)0xdb, (byte)0xaf,
  (byte)0xa3, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff22";
bytes = new byte[] { (byte)0xa3, (byte)0xc2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff33\u261c\u5371";
bytes = new byte[] { (byte)0xa3, (byte)0xd3, (byte)0xa2, (byte)0xd0,
  (byte)0xea, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u4e8e\uff11\uff2b";
bytes = new byte[] { (byte)0xe9, (byte)0xcd, (byte)0xa3, (byte)0xb1,
  (byte)0xa3, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5d11\uff29";
bytes = new byte[] { (byte)0xcd, (byte)0xdf, (byte)0xa3, (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff58\u5984\u774d";
bytes = new byte[] { (byte)0xa3, (byte)0xf8, (byte)0xd8, (byte)0xcd,
  (byte)0xfa, (byte)0xe0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6d36\uff03\u73e6";
bytes = new byte[] { (byte)0xfd, (byte)0xd7, (byte)0xa3, (byte)0xa3,
  (byte)0xfa, (byte)0xc0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "4\u77e9";
bytes = new byte[] { 0x34, (byte)0xcf, (byte)0xbb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2500";
bytes = new byte[] { (byte)0xa6, (byte)0xa1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff39\u7a7d\u7965";
bytes = new byte[] { (byte)0xa3, (byte)0xd9, (byte)0xef, (byte)0xf0,
  (byte)0xdf, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff08";
bytes = new byte[] { (byte)0xa3, (byte)0xa8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u532a";
bytes = new byte[] { (byte)0xdd, (byte)0xe3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff57\u74b5\u7db4";
bytes = new byte[] { (byte)0xa3, (byte)0xf7, (byte)0xe6, (byte)0xa5,
  (byte)0xf4, (byte)0xce };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6faf\u78e8";
bytes = new byte[] { (byte)0xf3, (byte)0xbd, (byte)0xd8, (byte)0xa8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uc66e\u534d\uff34\uff0b\u50d5\u716e";
bytes = new byte[] { (byte)0x9e, (byte)0xd6, (byte)0xd8, (byte)0xb3,
  (byte)0xa3, (byte)0xd4, (byte)0xa3, (byte)0xab, (byte)0xdc, (byte)0xd2,
  (byte)0xed, (byte)0xb4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5288\u768e";
bytes = new byte[] { (byte)0xdb, (byte)0xf9, (byte)0xce, (byte)0xeb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5883\uff40\uff19\u679a";
bytes = new byte[] { (byte)0xcc, (byte)0xd1, (byte)0xa3, (byte)0xe0,
  (byte)0xa3, (byte)0xb9, (byte)0xd8, (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ud36d\u518a\uff16";
bytes = new byte[] { (byte)0xbc, 0x44, (byte)0xf3, (byte)0xfc, (byte)0xa3,
  (byte)0xb6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4b";
bytes = new byte[] { (byte)0xa3, (byte)0xeb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9865\uff03";
bytes = new byte[] { (byte)0xfb, (byte)0xe2, (byte)0xa3, (byte)0xa3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ucec9";
bytes = new byte[] { (byte)0xb0, 0x6e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5269\uf9c9\u91c0";
bytes = new byte[] { (byte)0xed, (byte)0xa5, (byte)0xea, (byte)0xf7,
  (byte)0xe5, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5e7e";
bytes = new byte[] { (byte)0xd0, (byte)0xfa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "f\uc518\u6e21\u25cbf";
bytes = new byte[] { 0x66, (byte)0x9d, (byte)0xad, (byte)0xd4, (byte)0xa4,
  (byte)0xa1, (byte)0xdb, 0x66 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5d69\uff19\u5fa1";
bytes = new byte[] { (byte)0xe3, (byte)0xa1, (byte)0xa3, (byte)0xb9,
  (byte)0xe5, (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ucaaa";
bytes = new byte[] { (byte)0xa6, 0x43 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff57";
bytes = new byte[] { (byte)0xa3, (byte)0xf7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u55df\u5c55\u63da\ube43";
bytes = new byte[] { (byte)0xf3, (byte)0xaa, (byte)0xee, (byte)0xf7,
  (byte)0xe5, (byte)0xc0, (byte)0x95, (byte)0xac };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ubaca\uff08\u5b99\u2479";
bytes = new byte[] { (byte)0x91, (byte)0xac, (byte)0xa3, (byte)0xa8,
  (byte)0xf1, (byte)0xb5, (byte)0xa9, (byte)0xec };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
}
}
