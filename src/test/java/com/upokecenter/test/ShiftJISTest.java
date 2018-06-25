package com.upokecenter.test; import com.upokecenter.util.*;

import org.junit.Assert;
import org.junit.Test;
import com.upokecenter.util.*;
import com.upokecenter.text.*;

public class ShiftJISTest {
@Test
public void TestShiftJISDecoder() {
byte[] bytes;
String str;
ICharacterEncoding charset = Encodings.GetEncoding("shift_jis");
bytes = new byte[] { (byte)0xde, (byte)0xb6, (byte)0xb3, (byte)0xb0, 0x5c,
  0x3b, 0x41, (byte)0xf4, (byte)0xb0, (byte)0xd9, 0x35 };
str = "\uff9e\uff76\uff73\uff70\\;A\ue35f\uff995";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x45, (byte)0x88, 0x2b, 0x04, 0x7e, 0x59, 0x47,
  (byte)0x9d, 0x0d, 0x32, (byte)0xaf, 0x7a };
str = "E\ufffd+\u0004~YG\ufffd\u000d2\uff6fz";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xba, (byte)0xc7, 0x2c, (byte)0xfd, (byte)0x87,
  (byte)0xb7, (byte)0xd6, (byte)0xd9, (byte)0x8c, 0x4b, 0x22, 0x22, 0x0d,
  0x41, 0x74 };
str = "\uff7a\uff87\u002c\ufffd\ufffd\uff96\uff99\u6851\"\"\u000dAt";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd2, (byte)0xae, 0x50, 0x6f, 0x02, (byte)0x9a,
  0x45, 0x14, 0x68, (byte)0x83, 0x3b, 0x44, (byte)0xd8 };
str = "\uff92\uff6ePo\u0002\u54d8\u0014h\ufffd;D\uff98";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x47, 0x57, 0x7a, 0x33, 0x0f, (byte)0xb4, (byte)0xa2,
  0x55, 0x53, 0x2b, 0x39, (byte)0xb3, 0x27, 0x38, (byte)0xe9, 0x20,
  (byte)0xd7, (byte)0x8d, 0x1c, (byte)0x95, 0x6f, (byte)0xd8, 0x33,
  (byte)0xe2, 0x1d, 0x7a };
str =

  "GWz3\u000f\uff74\uff62US+9\uff73'8\ufffd \uff97\ufffd\u001c\u8cd3\uff983\ufffd\u001dz";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x78, (byte)0xed, (byte)0xe7, (byte)0x9f, 0x54, 0x5d,
  0x33, (byte)0x97, 0x59, (byte)0xba, 0x18, (byte)0xc2, (byte)0xaa, 0x5a,
  0x6c, 0x63, 0x25 };
str = "x\u6e39\u9b31]3\u96c4\uff7a\u0018\uff82\uff6aZlc%";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x54, 0x7e, 0x2b, (byte)0xde, 0x08, 0x70, (byte)0xa7,
  0x66, (byte)0xd1, (byte)0xe6, 0x3c, 0x55, 0x75, 0x27, 0x6d, 0x62,
  (byte)0xa1, 0x7c, 0x78, 0x6e };
str = "T~+\uff9e\u0008p\uff67f\uff91\ufffd<Uu'mb\uff61|xn";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x19, (byte)0x8b, 0x51, 0x74, 0x3f, 0x33, (byte)0xe5,
  0x0e, (byte)0xac, (byte)0xe3, (byte)0xbd, 0x08, (byte)0x98, 0x24, 0x29,
  (byte)0xf1, 0x22, 0x5a };
str = "\u0019\u98e2t?3\ufffd\u000e\uff6c\u7fb6\u0008\ufffd$)\ufffd\"Z";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x62, (byte)0xac, (byte)0x92, 0x40, 0x41, 0x1f,
  (byte)0xd0, 0x53, 0x5f, 0x78, 0x3a, (byte)0x90, 0x77, (byte)0x9d };
str = "b\uff6c\u53e9A\u001f\uff90S_x:\u9663\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xca, (byte)0xd9, 0x7d, 0x7d, 0x1c, 0x46 };
str = "\uff8a\uff99}}\u001cF";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf7, 0x3b, 0x7f, (byte)0x95, (byte)0x9e, 0x1b,
  0x14, 0x66, (byte)0xab, 0x66, 0x07, (byte)0x8a, (byte)0xa7, 0x13,
  (byte)0xad, (byte)0xd0, (byte)0x83, 0x5f, (byte)0x8e, (byte)0xd8 };
str =

  "\ufffd;\u007f\u670d\u001b\u0014f\uff6bf\u0007\u520a\u0013\uff6d\uff90\u30c0\u501f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x79, (byte)0xca, 0x7b, 0x1a, 0x30, 0x06, (byte)0xc8,
  (byte)0xa6, (byte)0xe7, (byte)0xa8, (byte)0xd1 };
str = "y\uff8a\u007b\u001a0\u0006\uff88\uff66\u905e\uff91";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x20, (byte)0xf8, (byte)0xc5, 0x3e, 0x27, 0x28,
  (byte)0xa2, 0x0a, 0x6e, (byte)0xcf, 0x47, (byte)0xb9, 0x13, (byte)0xce,
  0x26, 0x60, (byte)0xe2, 0x7d, 0x7b, (byte)0x81 };
str = " \ue664>'(\uff62\u000an\uff8fG\uff79\u0013\uff8e&`\u7ac8\u007b\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43, 0x21, (byte)0xd3, (byte)0xf6, (byte)0x9c,
  (byte)0xdc, 0x15, 0x03, 0x46, 0x4a, 0x6c, (byte)0xc3, (byte)0x89,
  (byte)0x9c, 0x3e, (byte)0xed, (byte)0xf1, 0x30, (byte)0x88, (byte)0xad,
  0x7a, 0x47 };
str = "C!\uff93\ue4c3\uff9c\u0015\u0003FJl\uff83\u5965>\u70280\u6e25zG";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8b, (byte)0xd9, 0x6d, (byte)0x95, (byte)0xdb,
  (byte)0xc1, 0x0b, (byte)0xc0, (byte)0xbd, 0x5e, 0x65 };
str = "\u7dcam\u4fdd\uff81\u000b\uff80\uff7d^e";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbe, (byte)0x9d, (byte)0x92, 0x33, (byte)0x83,
  0x75, 0x09, 0x22, 0x7a, 0x21, 0x6d, (byte)0x80, 0x23, (byte)0xb9,
  (byte)0xa4, (byte)0xf6, 0x14, 0x67, 0x2d, 0x2c, 0x54, (byte)0x9e, 0x7e,
  0x63, 0x1d, 0x0b, 0x7d };
str =

  "\uff7e\u64283\u30d6\u0009\"z!m\u0080#\uff79\uff64\ufffd\u0014g-\u002cT\u684ec\u001d\u000b}";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6d, 0x09, 0x57, 0x47, 0x67, 0x68, 0x06, 0x1e, 0x61,
  (byte)0xa0, (byte)0x8f, 0x7a, (byte)0xcf, 0x4e, (byte)0x93, 0x49, 0x42,
  (byte)0xbb, 0x60, 0x37, (byte)0xaf, 0x62, 0x20, (byte)0x9c, (byte)0xdc,
  (byte)0xfc, 0x6e, (byte)0xb5 };
str =

  "m\u0009WGgh\u0006\u001ea\ufffd\u5faa\uff8fN\u7684B\uff7b`7\uff6fb \u6194\ufffdn\uff75";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1c, 0x76, (byte)0xbc, (byte)0xbe, 0x5b, (byte)0xff,
  0x47, (byte)0x98, 0x16, (byte)0xd1, (byte)0xb2, (byte)0xbb, 0x15, 0x09,
  0x22, 0x57, (byte)0xb3, 0x45, 0x06, (byte)0xc0, (byte)0x8f };
str =

  "\u001cv\uff7c\uff7e[\ufffdG\ufffd\u0016\uff91\uff72\uff7b\u0015\u0009\"W\uff73E\u0006\uff80\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7d, 0x04, (byte)0xb9, 0x2a, (byte)0xa0, 0x2a,
  (byte)0x91, (byte)0x8f, (byte)0x8e, 0x10, (byte)0xfe, 0x58, (byte)0xe7,
  0x2a, (byte)0x9d, 0x5a, 0x36, (byte)0xea, 0x54, (byte)0xd5, 0x4c, 0x67,
  0x6c, (byte)0x86, 0x40, (byte)0xf2, (byte)0xde, 0x66 };
str =

  "}\u0004\uff79*\ufffd*\u8061\ufffd\u0010\ufffdX\ufffd*\u62bb6\u9dba\uff95Lgl\ufffd@\ue215f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3b, (byte)0xa3, 0x66, 0x36, 0x68, (byte)0xcf, 0x71,
  0x0b, (byte)0x84, (byte)0xb8, (byte)0x82, 0x2b, 0x13, 0x45, 0x47,
  (byte)0xb1, 0x7b, (byte)0xf9, 0x04, 0x09, 0x6a, 0x22, (byte)0xbe,
  (byte)0xe1, 0x51, 0x36, 0x37, 0x26 };
str =

  ";\uff63f6h\uff8fq\u000b\u2537\ufffd+\u0013EG\uff71\u007b\ufffd\u0004\u0009j\"\uff7e\u751367&";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5c, (byte)0xe9, (byte)0xe2, 0x3c, (byte)0xbf,
  (byte)0xc9, 0x67, 0x51, (byte)0xb4, (byte)0x94, 0x1c, 0x1b, 0x60,
  (byte)0xc0, 0x59, (byte)0xb8, 0x6c, 0x4c, (byte)0xcb, 0x3a, 0x4d, 0x59,
  (byte)0xc5, 0x78, (byte)0x98, 0x69 };
str =

  "\\\u9c3e<\uff7f\uff89gQ\uff74\ufffd\u001c\u001b`\uff80Y\uff78lL\uff8b:MY\uff85x\u4e99";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x42, 0x78, (byte)0xf1, (byte)0x81, (byte)0x87, 0x6b,
  0x09, 0x68, (byte)0xdb, (byte)0x9c, 0x6e, (byte)0xf4, 0x29, (byte)0xfd,
  0x5b, 0x6c, 0x47, (byte)0xcf, (byte)0x9e, 0x03, 0x55, (byte)0x9b,
  (byte)0xf6, (byte)0xe8, 0x6b, (byte)0xd4, (byte)0xac, 0x53, (byte)0xaa,
  0x69 };
str =

  "Bx\ue0fc\u3323\u0009h\uff9b\u5f9e\ufffd)\ufffd[lG\uff8f\ufffd\u0003U\u5e7f\u9462\uff94\uff6cS\uff6ai";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa4, 0x29, (byte)0xb2, (byte)0xe9, (byte)0xf2,
  0x75, 0x00, 0x6b, (byte)0xfd, 0x44, (byte)0xf9, (byte)0xa9, (byte)0xee,
  0x40, 0x5a, 0x6b, 0x54, 0x6b, 0x5a, 0x4a, 0x16, (byte)0x95, (byte)0xf8,
  (byte)0xd0, (byte)0xa5, 0x0f, 0x4b, (byte)0xd1, (byte)0x97 };
str =

  "\uff64)\uff72\u9dafu\u0000k\ufffdD\ue704\u72beZkTkZJ\u0016\u62b1\uff90\uff65\u000fK\uff91\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1d, (byte)0xba, 0x52, (byte)0xb3, 0x19 };
str = "\u001d\uff7aR\uff73\u0019";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfe, 0x3b, (byte)0xa7, (byte)0x8b, 0x59, 0x21,
  0x17, (byte)0x99, (byte)0xed, (byte)0xc2, 0x68, 0x53, 0x31, 0x6d, 0x63,
  (byte)0xff, (byte)0xdd, (byte)0x99, (byte)0x96, (byte)0xd0, (byte)0xf0,
  0x77, 0x61, (byte)0xa9, 0x41, 0x19, (byte)0x86, (byte)0x8d, (byte)0xfe,
  0x36 };
str =

  "\ufffd;\uff67\u622f!\u0017\u5470\uff82hS1mc\ufffd\uff9d\u527f\uff90\ue037a\uff69A\u0019\ufffd\ufffd6";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6d, 0x5d, 0x1b, 0x74, (byte)0xbb, 0x2e, (byte)0xf0,
  (byte)0x92, 0x40, (byte)0xb6, 0x0f, 0x28, (byte)0xfc };
str = "m]\u001bt\uff7b.\ue051@\uff76\u000f(\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc8, 0x20, (byte)0xe8, 0x4a, 0x66, (byte)0x8f,
  (byte)0xb4, (byte)0x82, (byte)0x82, 0x7f, (byte)0xcd, (byte)0xe4, 0x36 };
str = "\uff88 \u936ef\u6284\uff42\u007f\uff8d\ufffd6";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1a, 0x3f, 0x01, 0x38, (byte)0xe4, (byte)0x93, 0x72,
  (byte)0xd4, 0x64, 0x17, 0x58, (byte)0xac, 0x31, 0x17, (byte)0xbe, 0x08,
  0x6e, (byte)0xc7, (byte)0xe2 };
str =
  "\u001a?\u00018\u82f4r\uff94d\u0017X\uff6c1\u0017\uff7e\u0008n\uff87\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x62, 0x3e, (byte)0x88, 0x6f };
str = "b>\ufffdo";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x49, 0x5d, (byte)0xfc, (byte)0xa4, 0x68, 0x37,
  (byte)0x89, 0x70, 0x52, 0x57, 0x5f, (byte)0x9a, 0x25, 0x37, (byte)0xcb };
str = "I]\ufffdh7\u82f1RW_\ufffd%7\uff8b";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x55, (byte)0xe1, 0x38, 0x24, 0x1a, 0x3c, (byte)0xd3,
  0x4c, (byte)0xc8, (byte)0xed, (byte)0xa2, 0x72, (byte)0xc8, 0x5b,
  (byte)0x9f, 0x4c, (byte)0x8e, 0x7b, (byte)0x82, (byte)0x8e, (byte)0xb0,
  (byte)0xaf, 0x3d, 0x7f, (byte)0x82, 0x76 };
str =

  "U\ufffd8$\u001a<\uff93L\uff88\u608ar\uff88[\u6ada\u65bd\uff4e\uff70\uff6f=\u007f\uff37";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x06, 0x47, 0x0e, 0x7a, (byte)0xa6, 0x41, 0x68, 0x6d,
  (byte)0x96, (byte)0x91, 0x4c, (byte)0x8f, (byte)0xf6, (byte)0xee,
  (byte)0x8f, 0x40, (byte)0xd7, (byte)0xb4, (byte)0xfd, (byte)0x92, 0x27,
  (byte)0xbe, (byte)0xe7, 0x58 };
str =

  "\u0006G\u000ez\uff66Ahm\u685dL\u84b8\u8b53@\uff97\uff74\ufffd\ufffd'\uff7e\u8eaa";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb8, (byte)0xfb, 0x2d, 0x40, (byte)0xea,
  (byte)0xfe, 0x43, 0x16, 0x72, 0x41, 0x6e, (byte)0x94, (byte)0xa8, 0x5b,
  0x5d, (byte)0x8c, 0x7e, 0x48, (byte)0x98, 0x29, (byte)0xe8, (byte)0xa2,
  (byte)0xd7, (byte)0xfb, (byte)0xf6, (byte)0xd7, (byte)0x97, (byte)0xb7 };
str =

  "\uff78\ufffd-@\ufffdC\u0016rAn\u7551[]\u9be8H\ufffd)\u9672\uff97\ufa2a\uff97\u65c5";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x81 };
str = "\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9a, (byte)0xf6, 0x5c, (byte)0xf1, (byte)0xe3,
  0x2f, (byte)0x81, 0x06, 0x0e, (byte)0xb9, 0x12, 0x3e };
str = "\u595a\\\ue15e/\ufffd\u0006\u000e\uff79\u0012>";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbf, (byte)0xd4, 0x72 };
str = "\uff7f\uff94r";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbb, 0x45, (byte)0xe3, 0x41, 0x66, (byte)0xff,
  0x27, 0x6d, 0x24, 0x56, (byte)0x93, 0x4d, 0x1d, (byte)0xf9, 0x1e,
  (byte)0x9f, 0x23, 0x0f, 0x25, 0x6e, (byte)0x8c, 0x1e, 0x72, (byte)0xb3,
  0x79, 0x02, 0x66 };
str =

  "\uff7bE\u7d1cf\ufffd'm$V\u6eba\u001d\ufffd\u001e\ufffd#\u000f%n\ufffd\u001er\uff73y\u0002f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf5, (byte)0xe3, 0x1f, 0x74, (byte)0x94,
  (byte)0xab, (byte)0xff, 0x0c, (byte)0xd9, (byte)0xcf, (byte)0xe0,
  (byte)0xe0, (byte)0xf7, 0x77, 0x69, (byte)0xba, 0x14, (byte)0xe3, 0x26,
  0x2c, 0x44, 0x3e, (byte)0xf2, 0x32, (byte)0xcc, (byte)0xe6 };
str =

  "\ue44e\u001ft\u9262\ufffd\u000c\uff99\uff8f\u73e5\ue55bi\uff7a\u0014\ufffd&\u002cD>\ufffd2\uff8c\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb8, 0x59, (byte)0xff, 0x4b, (byte)0xa9 };
str = "\uff78Y\ufffdK\uff69";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2d, (byte)0xa5, 0x29, (byte)0xb1, 0x05, 0x08, 0x71,
  0x06, 0x17, 0x61, (byte)0xec, 0x4f, (byte)0xfa, (byte)0xe3, (byte)0xdc,
  (byte)0xdd, 0x2b, 0x7b, (byte)0xf7, 0x7e };
str =

  "-\uff65)\uff71\u0005\u0008q\u0006\u0017a\ufffdO\u6852\uff9c\uff9d+\u007b\ue562";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x23, 0x11, (byte)0x88, 0x28, 0x36, 0x3a, 0x51,
  (byte)0x9a, (byte)0xf0, (byte)0xa9, 0x13, 0x45, 0x5d, 0x73, 0x6f, 0x61,
  (byte)0xe2, 0x2f, 0x21, 0x46, (byte)0xc2, 0x28, (byte)0xb9 };
str = "#\u0011\ufffd(6:Q\u5938\uff69\u0013E]soa\ufffd/!F\uff82(\uff79";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7e, (byte)0xda, (byte)0xd4, 0x50, 0x5f, 0x01, 0x56,
  0x27, 0x75, 0x44, 0x24, 0x50, 0x2d, 0x22, (byte)0xff, (byte)0x8a,
  (byte)0xc8, (byte)0xf2, (byte)0xce, 0x12, (byte)0xad, (byte)0xd9, 0x3f };
str = "~\uff9a\uff94P_\u0001V'uD$P-\"\ufffd\u7c21\ue205\u0012\uff6d\uff99?";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4f, 0x5b, (byte)0xa7, (byte)0x9a, (byte)0x93,
  (byte)0xa2, 0x55, 0x59, 0x5d, (byte)0xa9, 0x57, 0x65, (byte)0x9f, 0x09,
  0x58, 0x33, (byte)0xb0, (byte)0x9b, 0x7d, 0x02, 0x72, 0x1d, (byte)0x94,
  (byte)0x93, 0x04, (byte)0xd7 };
str =

  "O.get(\uff67\u56c0\uff62UY)\uff69We\ufffd\u0009X3\uff70\u5b7a\u0002r\u001d\u7b94\u0004\uff97";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe1, (byte)0xd9, 0x0b, (byte)0xfc, (byte)0xdc,
  (byte)0xca, (byte)0x97, 0x05, 0x43, (byte)0xd3 };
str = "\u77bc\u000b\ufffd\uff8a\ufffd\u0005C\uff93";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa1, (byte)0xf9, 0x76 };
str = "\uff61\ue6d2";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb4, 0x71, 0x7c, (byte)0xfd, (byte)0x8d, 0x44,
  0x1f, 0x08 };
str = "\uff74q|\ufffd\u597d\u001f\u0008";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x59, 0x6a, (byte)0xe4 };
str = "Yj\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa0, 0x7a, 0x2a, 0x16, (byte)0xec, 0x78,
  (byte)0xcb, 0x46, 0x3b, 0x22, (byte)0xd0, 0x60, 0x60, 0x5b, 0x61 };
str = "\ufffdz*\u0016\ufffdx\uff8bF;\"\uff90``[a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x34, (byte)0x87 };
str = "4\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xef, 0x4e, 0x02, (byte)0xe3, (byte)0xe2, 0x7b,
  0x65, (byte)0xc4, 0x48, 0x73, 0x31 };
str = "\ufffdN\u0002\u8079\u007be\uff84Hs1";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf2, (byte)0x80, (byte)0xe9, (byte)0xcd, 0x65,
  (byte)0xd5, 0x37, 0x65, 0x41, (byte)0xa1 };
str = "\ue1b7\u9bf1e\uff957eA\uff61";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfa, 0x5e, (byte)0xa8, (byte)0xdf, 0x30, 0x41,
  (byte)0x9c, 0x4f, 0x2e };
str = "\u9348\uff68\uff9f0A\u5efe.";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x52, (byte)0xb6, 0x5a, 0x35, 0x56, 0x37, 0x56, 0x39,
  0x03, 0x37, 0x6b, (byte)0xac, 0x32, (byte)0xcd, 0x38, 0x42, (byte)0xa9,
  (byte)0x92, 0x0f, 0x6e, (byte)0xbc, (byte)0xae, 0x23, (byte)0xd5,
  (byte)0xb5, 0x4a, 0x5c };
str =

  "R\uff76Z5V7V9\u00037k\uff6c2\uff8d8B\uff69\ufffd\u000fn\uff7c\uff6e#\uff95\uff75J\\";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc4, 0x5a, 0x39, 0x70, 0x74, 0x36, (byte)0x8c,
  0x26 };
str = "\uff84Z9pt6\ufffd&";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x79, 0x7e, 0x08, (byte)0xf9, 0x4d };
str = "y~\u0008\ue6a9";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x74, (byte)0xd1, (byte)0xa5, 0x44, 0x17, 0x52, 0x3d,
  (byte)0xd2, 0x77, (byte)0xc5, 0x30, (byte)0xef, 0x14, (byte)0xd8, 0x32,
  0x66 };
str = "t\uff91\uff65D\u0017R=\uff92w\uff850\ufffd\u0014\uff982f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdb, (byte)0xd7, 0x0f, 0x32 };
str = "\uff9b\uff97\u000f2";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb2 };
str = "\uff72";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb8, 0x7d, 0x39, 0x58, 0x7c, (byte)0xd2, 0x7e,
  (byte)0x8a, (byte)0xa5, (byte)0xe6, (byte)0xd4, (byte)0xec, 0x5c, 0x00,
  (byte)0x90, 0x48, (byte)0xef, 0x0d, 0x60, (byte)0xf7, 0x3f, 0x7f, 0x21,
  0x25, 0x1c, 0x2c, 0x4a, 0x09, (byte)0x87, (byte)0xe8 };
str =

  "\uff78}9X|\uff92~\u51a0\u8d07\ufffd\\\u0000\u98df\ufffd\u000d`\ufffd?\u007f!%\u001c\u002cJ\u0009\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x89, (byte)0x8f, 0x70, 0x47 };
str = "\u7e01pG";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd6, 0x62, (byte)0xd6, 0x33, 0x50, (byte)0xc0 };
str = "\uff96b\uff963P\uff80";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6d, (byte)0xda, 0x2d, (byte)0xc6, 0x1d, 0x21,
  (byte)0xdf, 0x31, (byte)0x89, 0x66, 0x5d, (byte)0xd6, 0x40, 0x53 };
str = "m\uff9a-\uff86\u001d!\uff9f1\u6620]\uff96@S";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdc, (byte)0x96, (byte)0xb1, 0x7a, 0x4f,
  (byte)0x94, 0x64, (byte)0xeb, (byte)0xda, 0x10 };
str = "\uff9c\u52d9zO\u64ad\ufffd\u0010";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf6, (byte)0xc9, 0x3a, (byte)0xfc, 0x74, 0x6e,
  0x53, 0x35, 0x42, 0x74, (byte)0xfb, (byte)0x95, (byte)0xb1, (byte)0xbd,
  0x66, 0x3d, (byte)0x87, 0x53, (byte)0xc9, 0x72, (byte)0xe2, 0x67, 0x6b };
str = "\ue4f0:\ufffdtnS5Bt\u837f\uff71\uff7df=\u2473\uff89r\u7a1fk";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8e, 0x6e, 0x1b, (byte)0x83, (byte)0xfa, 0x5d,
  (byte)0xb7, 0x4a, (byte)0xa3, 0x17, 0x2a, 0x14, (byte)0xc7, 0x24 };
str = "\u59cb\u001b\ufffd]\uff77J\uff63\u0017*\u0014\uff87$";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x11, 0x34, 0x15, 0x53, 0x53, (byte)0xc0, 0x5d, 0x48,
  (byte)0xe6, 0x31, (byte)0x9b, 0x19, (byte)0x9c, 0x36 };
str = "\u00114\u0015SS\uff80]H\ufffd1\ufffd\u0019\ufffd6";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcb, 0x36, (byte)0xa9, 0x0d, (byte)0x89,
  (byte)0x86, 0x53, (byte)0xf8, 0x43, (byte)0x82, 0x29, 0x7e, 0x04, 0x01,
  0x24, 0x42, 0x16, 0x7c, 0x51, 0x7b, 0x7a, 0x12, (byte)0xbe, 0x2c, 0x55,
  0x00, (byte)0xf2, 0x51, 0x64 };
str =

  "\uff8b6\uff69\u000d\u63a9S\ue5e3\ufffd)~\u0004\u0001$B\u0016|Q\u007bz\u0012\uff7e\u002cU\u0000\ue189d";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc2, 0x0d, (byte)0xa3 };
str = "\uff82\u000d\uff63";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcc, 0x7d, (byte)0x83, (byte)0xa4, (byte)0xaa,
  (byte)0xcc, (byte)0xe7, (byte)0xfd, 0x6e, 0x5a, 0x12, 0x68, 0x49,
  (byte)0x8e, 0x4e, (byte)0xc9, 0x5f, 0x0f, (byte)0xbd, 0x43 };
str = "\uff8c}\u0396\uff6a\uff8c\ufffdnZ\u0012hI\u6652\uff89_\u000f\uff7dC";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf4, (byte)0x95, 0x2b, (byte)0x82, 0x17, 0x2e,
  0x59 };
str = "\ue344+\ufffd\u0017.Y";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa7, 0x69, 0x35, 0x57, (byte)0xa8, 0x23, 0x77,
  (byte)0xe5, (byte)0xf0 };
str = "\uff67i5W\uff68#w\u891e";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x63, 0x69, 0x63, (byte)0xa0, 0x69, (byte)0x88, 0x54,
  (byte)0xc3, 0x75, 0x4a, (byte)0xfc, 0x11, 0x08, (byte)0xe2 };
str = "cic\ufffdi\ufffdT\uff83uJ\ufffd\u0011\u0008\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbb, 0x1d, (byte)0xac, (byte)0x90, 0x6d,
  (byte)0xd0, (byte)0xae, 0x33, 0x4b, (byte)0xc9, (byte)0xbd, 0x41, 0x28,
  (byte)0xfb, 0x79, 0x70, (byte)0xc5, (byte)0xc6, 0x24, 0x5e, 0x0f,
  (byte)0xac, 0x5f, 0x50 };
str =

  "\uff7b\u001d\uff6c\u4ec1\uff90\uff6e3K\uff89\uff7dA(\u784ep\uff85\uff86$^\u000f\uff6c_P";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc4, 0x69, (byte)0xde, 0x40, (byte)0xab, 0x6a,
  (byte)0xdf };
str = "\uff84i\uff9e@\uff6bj\uff9f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd0, 0x25, 0x06 };
str = "\uff90%\u0006";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcd, 0x1c, (byte)0xcb, (byte)0xdc, (byte)0xeb,
  0x62, (byte)0xf4 };
str = "\uff8d\u001c\uff8b\uff9c\ufffdb\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3f, 0x21, (byte)0xe6, 0x65, 0x27, (byte)0x90, 0x43,
  (byte)0x85, (byte)0xcc, (byte)0x9c, 0x38, 0x10, 0x65, 0x35, 0x5e, 0x12,
  (byte)0xfd, 0x62, 0x46, 0x5e, 0x7a, (byte)0xd1 };
str = "?!\u8a41'\u71ed\ufffd\ufffd8\u0010e5^\u0012\ufffdbF^z\uff91";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x75, 0x0e, 0x43, (byte)0x84, (byte)0x8f, 0x66,
  (byte)0xb4, (byte)0xc1, (byte)0xaa, 0x6d, 0x3d, 0x68, 0x52 };
str = "u\u000eC\u044df\uff74\uff81\uff6am=hR";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcc, 0x2d, 0x0f, (byte)0xd8, 0x67, (byte)0xda,
  (byte)0xb7, 0x2e, 0x22, 0x71, 0x32, (byte)0xa0 };
str = "\uff8c-\u000f\uff98g\uff9a\uff77.\"q2\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x40, (byte)0xb0, 0x5e, (byte)0xef, 0x7b, 0x6b,
  (byte)0xa0, (byte)0xc9, (byte)0x9a, 0x5b, (byte)0xf1, (byte)0x96, 0x77,
  0x4d, (byte)0xa2, 0x51 };
str = "@\uff70^\ufffd\u007bk\ufffd\uff89\u5599\ue111wM\uff62Q";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9e, (byte)0xa0, 0x5e, (byte)0x80, 0x3b,
  (byte)0xc2, 0x26, 0x0c, 0x3b, (byte)0xa0, 0x63, 0x02, 0x49, 0x46, 0x2b,
  0x16 };
str = "\u68e7^\u0080;\uff82&\u000c;\ufffdc\u0002IF+\u0016";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x31, 0x62, 0x5e, 0x36, 0x43, (byte)0xd3, 0x65, 0x77,
  0x16, 0x4f, 0x09, (byte)0x9e };
str = "1b^6C\uff93ew\u0016O\u0009\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9d, 0x2c, (byte)0xdd, 0x49, 0x27, 0x26, 0x3e };
str = "\ufffd\u002c\uff9dI'&>";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa2, 0x2a, 0x31, (byte)0xa2, 0x0e, 0x7b, 0x6c,
  0x40, 0x22, (byte)0xca, 0x6c, 0x3b, (byte)0x91, (byte)0x8d, 0x7c, 0x23,
  (byte)0xf6, (byte)0xdc, 0x50, (byte)0xf4, 0x5a, 0x47, 0x19, 0x45,
  (byte)0xa4, (byte)0xd2, 0x26 };
str =

  "\uff62*1\uff62\u000e\u007bl@\"\uff8al;\u7dcf|#\ue503P\ue30aG\u0019E\uff64\uff92&";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6b, (byte)0xc7, 0x4e, (byte)0xe5, (byte)0xbd, 0x63,
  (byte)0x9c, 0x08, (byte)0xba };
str = "k\uff87N\u8816c\ufffd\u0008\uff7a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x62, (byte)0xd5, 0x72, 0x28, 0x5a, 0x53, 0x28,
  (byte)0xdf, (byte)0xf1, 0x5b, (byte)0xc5, (byte)0xf3, 0x77, (byte)0x94,
  (byte)0xa9, 0x48, 0x53, (byte)0x92, (byte)0xc7 };
str = "b\uff95r(ZS(\uff9f\ue0d7\uff85\ue26b\u7560HS\u8ffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6f, (byte)0xc2, 0x72, (byte)0xe0, (byte)0xe7,
  (byte)0xd1, (byte)0x8b, 0x18, 0x7d, 0x02, (byte)0xdf, (byte)0xb6 };
str = "o\uff82r\u73f8\uff91\ufffd\u0018}\u0002\uff9f\uff76";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xaa, 0x40, 0x12, 0x4b, (byte)0xb2, (byte)0xa6,
  0x04, 0x66, 0x2a, 0x33, (byte)0xc4, (byte)0x95, 0x50, 0x7a, (byte)0xec,
  0x5a, 0x75, 0x14, 0x4e, 0x3d, 0x7e, 0x26, 0x7d, 0x71, 0x63, (byte)0xff,
  0x52 };
str =

  "\uff6a@\u0012K\uff72\uff66\u0004f*3\uff84\u59ebz\ufffdZu\u0014N=~&}qc\ufffdR";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2f, (byte)0x87, (byte)0xfb, (byte)0xa9, 0x77, 0x77,
  0x74, 0x1c, 0x61, 0x1c, (byte)0xda, (byte)0xa1, 0x64, (byte)0xe6, 0x67,
  (byte)0xa2, 0x4a, 0x2a, (byte)0xe8 };
str = "/\ufffd\uff69wwt\u001ca\u001c\uff9a\uff61d\u8a52\uff62J*\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9b, 0x6c };
str = "\u5b2a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xac, (byte)0x97, (byte)0xba, (byte)0xb6,
  (byte)0xb4, (byte)0xa7, 0x68, (byte)0x9f, (byte)0x87, 0x62, 0x05,
  (byte)0x9d };
str = "\uff6c\u4eae\uff76\uff74\uff67h\u6c5eb\u0005\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xce, 0x57, (byte)0xb8 };
str = "\uff8eW\uff78";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9e, 0x7e, (byte)0xbe, (byte)0x9f, (byte)0xc4,
  0x0f, (byte)0xf1, (byte)0xd5, (byte)0xfa, (byte)0x96, 0x60, (byte)0x96,
  (byte)0x9c, (byte)0xd9, 0x3a, 0x00, 0x67, 0x3b, 0x08, (byte)0xfc,
  (byte)0xed, (byte)0xdb, (byte)0xb3, (byte)0xd5, 0x1a, (byte)0xe4,
  (byte)0xa4, 0x5d, 0x70 };
str =

  "\u684e\uff7e\u6de8\u000f\ue150\u5759`\u4e07\uff99:\u0000g;\u0008\ufffd\uff9b\uff73\uff95\u001a\u8340]p";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcc, 0x77, (byte)0xbb, (byte)0xb1, 0x03,
  (byte)0xba, (byte)0xec, (byte)0xa0, 0x5e, 0x14, (byte)0xb7, 0x2d,
  (byte)0x8e, (byte)0xa4, 0x5f, (byte)0xc5, 0x15, 0x15 };
str =

  "\uff8cw\uff7b\uff71\u0003\uff7a\ufffd^\u0014\uff77-\u75d4_\uff85\u0015\u0015";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xaf, (byte)0x81, 0x3b, (byte)0xa4, 0x00,
  (byte)0xed, 0x10, (byte)0x9d, (byte)0x85, (byte)0xaa, (byte)0xdf, 0x48,
  0x55, 0x2f, (byte)0x9d, (byte)0xae, (byte)0xca, 0x67, 0x35, 0x7c, 0x7c };
str =
  "\uff6f\ufffd;\uff64\u0000\ufffd\u0010\u63e3\uff6a\uff9fHU/\u652c\uff8ag5||";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9f, (byte)0xb7, 0x23, 0x7e, 0x5f, (byte)0xd0,
  0x35, 0x48, (byte)0xde, 0x77, 0x3b, 0x4e, 0x2c, (byte)0xf0, 0x7b,
  (byte)0xe8, 0x04, (byte)0xda, (byte)0xdf, (byte)0xf9, 0x35, 0x28 };
str = "\u6fe4#~_\uff905H\uff9ew;N\u002c\ue03b\ufffd\u0004\uff9a\uff9f\ufffd5(";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9a, 0x79, (byte)0xc1 };
str = "\u5650\uff81";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43, 0x34, 0x75, (byte)0x90, (byte)0xdf, 0x5b,
  (byte)0xd4, 0x19, (byte)0x99, 0x6e, 0x4e, 0x02, (byte)0xaa, 0x15,
  (byte)0x99, 0x2a, 0x4f, (byte)0xc4, 0x43, 0x75, (byte)0xe7 };
str = "C4u\u7bc0[\uff94\u0019\u51a2N\u0002\uff6a\u0015\ufffd*O\uff84Cu\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x23, 0x2d, (byte)0xb2, 0x35, (byte)0xbd, (byte)0xb7,
  0x57, 0x58, 0x77, 0x10, 0x6d, 0x5a, (byte)0x82, (byte)0x85, 0x28, 0x72,
  0x76, 0x0e, (byte)0xee, 0x13, 0x2b, 0x4c, 0x0b };
str = "#-\uff725\uff7d\uff77WXw\u0010mZ\uff45(rv\u000e\ufffd\u0013+L\u000b";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5a, (byte)0xc1, 0x53, (byte)0xd6, 0x23, (byte)0x82,
  (byte)0xd5, (byte)0xda, 0x6a, 0x01, (byte)0x97, (byte)0xd4, 0x70,
  (byte)0xe8, (byte)0xaf, 0x59, 0x61, 0x55, 0x65, (byte)0x8f, 0x66,
  (byte)0xd3, 0x47, 0x68, 0x45, (byte)0xac, (byte)0x9f, 0x5c };
str =

  "Z\uff81S\uff96#\u3077\uff9aj\u0001\u7433p\u96b8YaUe\u53d4\uff93GhE\uff6c\u6b43";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
}
@Test
public void TestShiftJISEncoder() {
byte[] bytes;
String str;
ICharacterEncoding charset = Encodings.GetEncoding("shift_jis");
str = "\uff03";
bytes = new byte[] { (byte)0x81, (byte)0x94 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u8b39\u755c\u5b89";
bytes = new byte[] { (byte)0x8b, (byte)0xde, (byte)0x92, 0x7b, (byte)0x88,
  (byte)0xc0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5238\u702c\u2465";
bytes = new byte[] { (byte)0x8c, (byte)0x94, (byte)0x90, (byte)0xa3,
  (byte)0x87, 0x45 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff35\u2538";
bytes = new byte[] { (byte)0x82, 0x74, (byte)0x84, (byte)0xbd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7676\ufa25\u60f1";
bytes = new byte[] { (byte)0xe1, (byte)0xa0, (byte)0xfb, (byte)0xb4,
  (byte)0x9c, (byte)0xbb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5f70\u624d";
bytes = new byte[] { (byte)0x8f, (byte)0xb2, (byte)0x8d, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7a61";
bytes = new byte[] { (byte)0xe2, 0x70 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff39\u6108\uff52";
bytes = new byte[] { (byte)0x82, 0x78, (byte)0x96, (byte)0xfa, (byte)0x82,
  (byte)0x92 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff07\u605f\u5171";
bytes = new byte[] { (byte)0xfa, 0x56, (byte)0x9c, (byte)0x8f, (byte)0x8b,
  (byte)0xa4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u59eb";
bytes = new byte[] { (byte)0x95, 0x50 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6c\uff50\u30f6";
bytes = new byte[] { (byte)0xac, (byte)0x82, (byte)0x90, (byte)0x83,
  (byte)0x96 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff97\u5023\u751e";
bytes = new byte[] { (byte)0xd7, (byte)0x95, (byte)0xed, (byte)0xe1, 0x52 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u749e";
bytes = new byte[] { (byte)0xe0, (byte)0xf7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u66fc\u7b67\uff31";
bytes = new byte[] { (byte)0x99, (byte)0xd6, (byte)0xe2, (byte)0xa8,
  (byte)0x82, 0x70 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0f";
bytes = new byte[] { (byte)0x81, 0x5e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5e\u63c9\u2640\u000e";
bytes = new byte[] { (byte)0x81, 0x60, (byte)0x9d, (byte)0x86, (byte)0x81,
  (byte)0x8a, 0x0e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9e\u767e\u604b";
bytes = new byte[] { (byte)0xde, (byte)0x95, 0x53, (byte)0x97, (byte)0xf6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6b64";
bytes = new byte[] { (byte)0x8d, (byte)0x9f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9e\uff62";
bytes = new byte[] { (byte)0xde, (byte)0xa2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9c";
bytes = new byte[] { (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6b1f";
bytes = new byte[] { (byte)0x9f, 0x55 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u76cd";
bytes = new byte[] { (byte)0xe1, (byte)0xb2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6a38";
bytes = new byte[] { (byte)0x9e, (byte)0xf5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4c\u5ae6\uff88\uffe5";
bytes = new byte[] { (byte)0x82, (byte)0x8c, (byte)0x9b, 0x62, (byte)0xc8,
  (byte)0x81, (byte)0x8f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u8897\u2192\u7511";
bytes = new byte[] { (byte)0xe5, (byte)0xd5, (byte)0x81, (byte)0xa8,
  (byte)0x8d, (byte)0x99 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff53";
bytes = new byte[] { (byte)0x82, (byte)0x93 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff7a";
bytes = new byte[] { (byte)0xba };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6fd5";
bytes = new byte[] { (byte)0xe0, 0x5b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5c1a\u7e3e\u796d";
bytes = new byte[] { (byte)0x8f, (byte)0xae, (byte)0x90, (byte)0xd1,
  (byte)0x8d, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u74ca\uff7b\u71ff\uff18";
bytes = new byte[] { (byte)0xe0, (byte)0xf9, (byte)0xbb, (byte)0xe0,
  (byte)0xa0, (byte)0x82, 0x57 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6bef\uff08\uff9c";
bytes = new byte[] { (byte)0x9f, 0x7e, (byte)0x81, 0x69, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6388\u2103\uff3b\uff92";
bytes = new byte[] { (byte)0x8e, (byte)0xf6, (byte)0x81, (byte)0x8e,
  (byte)0x81, 0x6d, (byte)0xd2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe2";
bytes = new byte[] { (byte)0x81, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u212b\uffe4\uff63";
bytes = new byte[] { (byte)0x81, (byte)0xf0, (byte)0xfa, 0x55, (byte)0xa3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff75\uff1c\u7279\uff6d";
bytes = new byte[] { (byte)0xb5, (byte)0x81, (byte)0x83, (byte)0x93,
  (byte)0xc1, (byte)0xad };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u001c";
bytes = new byte[] { 0x1c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff58";
bytes = new byte[] { (byte)0x82, (byte)0x98 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7662\u6998\uff83";
bytes = new byte[] { (byte)0xe1, (byte)0x98, (byte)0xfa, (byte)0xeb,
  (byte)0xc3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff32\u5f79";
bytes = new byte[] { (byte)0x82, 0x71, (byte)0x96, (byte)0xf0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7460\u7647\uff63";
bytes = new byte[] { (byte)0x97, (byte)0xda, (byte)0xe1, (byte)0x92,
  (byte)0xa3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5b40";
bytes = new byte[] { (byte)0x9b, 0x71 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3c\uff22\uff70";
bytes = new byte[] { (byte)0x81, 0x5f, (byte)0x82, 0x61, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff32\u6c7d\uff0b";
bytes = new byte[] { (byte)0x82, 0x71, (byte)0x8b, 0x44, (byte)0x81, 0x7b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u516d\u62d1\u699c\uff3a";
bytes = new byte[] { (byte)0x98, 0x5a, (byte)0x9d, 0x59, (byte)0x9e,
  (byte)0xd4, (byte)0x82, 0x79 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u55fe\u7fbd\uff45\u5bf0";
bytes = new byte[] { (byte)0x9a, 0x74, (byte)0x89, 0x48, (byte)0x82,
  (byte)0x85, (byte)0x9b, (byte)0x8e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4d\uff54\u649e\u6848";
bytes = new byte[] { (byte)0x82, (byte)0x8d, (byte)0x82, (byte)0x94,
  (byte)0x93, (byte)0xb3, (byte)0x88, (byte)0xc4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u75c7";
bytes = new byte[] { (byte)0x8f, (byte)0xc7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5ce0\u6556\uff23\uff5d";
bytes = new byte[] { (byte)0x93, (byte)0xbb, (byte)0x9d, (byte)0xc2,
  (byte)0x82, 0x62, (byte)0x81, 0x70 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u67ee\u252cN";
bytes = new byte[] { (byte)0x9e, 0x72, (byte)0x84, (byte)0xa6, 0x4e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5584\u0010\u554c\uff26";
bytes = new byte[] { (byte)0x91, 0x50, 0x10, (byte)0x9a, 0x52, (byte)0x82,
  0x65 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff89\u69d8\uff6f";
bytes = new byte[] { (byte)0xc9, (byte)0x97, 0x6c, (byte)0xaf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u69c1\u22bf\uff08";
bytes = new byte[] { (byte)0x9e, (byte)0xc7, (byte)0x87, (byte)0x99,
  (byte)0x81, 0x69 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6f0f\uff75\u5cbb";
bytes = new byte[] { (byte)0x98, 0x52, (byte)0xb5, (byte)0x9b, (byte)0xac };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5f90\u69dd";
bytes = new byte[] { (byte)0x8f, (byte)0x99, (byte)0x9e, (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6ec4\uff54";
bytes = new byte[] { (byte)0x9f, (byte)0xe9, (byte)0x82, (byte)0x94 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff52";
bytes = new byte[] { (byte)0x82, (byte)0x92 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7815\uff10\uff95";
bytes = new byte[] { (byte)0x8d, (byte)0xd3, (byte)0x82, 0x4f, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6c24";
bytes = new byte[] { (byte)0x9f, (byte)0x85 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u74f2\u6e4e";
bytes = new byte[] { (byte)0xe1, 0x45, (byte)0x9f, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u53ea\u2528";
bytes = new byte[] { (byte)0x91, (byte)0xfc, (byte)0x84, (byte)0xb7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff88\u66ab";
bytes = new byte[] { (byte)0xc8, (byte)0x8e, 0x62 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u601d";
bytes = new byte[] { (byte)0x8e, 0x76 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff75z";
bytes = new byte[] { (byte)0xb5, 0x7a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u706bX\uff41";
bytes = new byte[] { (byte)0x89, (byte)0xce, 0x58, (byte)0x82, (byte)0x81 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6255\u7fb6\u7537";
bytes = new byte[] { (byte)0x95, (byte)0xa5, (byte)0xe3, (byte)0xbd,
  (byte)0x92, 0x6a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6ca2\uff1a\u6025";
bytes = new byte[] { (byte)0x91, (byte)0xf2, (byte)0x81, 0x46, (byte)0x8b,
  0x7d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u663f";
bytes = new byte[] { (byte)0x9e, 0x45 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6d74";
bytes = new byte[] { (byte)0x97, (byte)0x81 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff32\uff7f\uff84";
bytes = new byte[] { (byte)0x82, 0x71, (byte)0xbf, (byte)0xc4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u66f8\u6367Z";
bytes = new byte[] { (byte)0x8f, (byte)0x91, (byte)0x95, (byte)0xf9, 0x5a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2020\uff25\u2033\u7621";
bytes = new byte[] { (byte)0x81, (byte)0xf5, (byte)0x82, 0x64, (byte)0x81,
  (byte)0x8d, (byte)0xe1, (byte)0x8c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u67b3\u7591";
bytes = new byte[] { (byte)0x9e, 0x6b, (byte)0x8b, 0x5e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u62c5";
bytes = new byte[] { (byte)0x92, 0x53 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u69be\uff20\u53e8";
bytes = new byte[] { (byte)0x9e, (byte)0xc9, (byte)0x81, (byte)0x97,
  (byte)0x99, (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6ec5\u7965\u6dd5";
bytes = new byte[] { (byte)0x96, (byte)0xc5, (byte)0x8f, (byte)0xcb,
  (byte)0x9f, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff19\u5f0a\u51f0";
bytes = new byte[] { (byte)0x82, 0x58, (byte)0x95, (byte)0xbe, (byte)0x99,
  (byte)0x80 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff82\uff06\u58de";
bytes = new byte[] { (byte)0xc2, (byte)0x81, (byte)0x95, (byte)0x9a,
  (byte)0xd3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff38\uff23";
bytes = new byte[] { (byte)0x82, 0x77, (byte)0x82, 0x62 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6258\uff77";
bytes = new byte[] { (byte)0x91, (byte)0xef, (byte)0xb7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff80\u7c23\u7bc4";
bytes = new byte[] { (byte)0xc0, (byte)0xe2, (byte)0xcd, (byte)0x94,
  (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5c02\u6368\uff01\u7737";
bytes = new byte[] { (byte)0x90, (byte)0xea, (byte)0x8e, (byte)0xcc,
  (byte)0x81, 0x49, (byte)0xe1, (byte)0xc5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff7b";
bytes = new byte[] { (byte)0xbb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7670\u52be\u5f0b\uff94";
bytes = new byte[] { (byte)0xe1, (byte)0x9e, (byte)0x8a, 0x4e, (byte)0x9c,
  0x54, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7bf7\u5118\u75ab";
bytes = new byte[] { (byte)0xe2, (byte)0xc9, (byte)0x98, (byte)0xd4,
  (byte)0x89, 0x75 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6ab8";
bytes = new byte[] { (byte)0x9f, 0x45 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7648";
bytes = new byte[] { (byte)0xe1, (byte)0x93 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u52db\u6588\u68c9";
bytes = new byte[] { (byte)0xfa, (byte)0x88, (byte)0x9b, 0x7c, (byte)0x96,
  (byte)0xc7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u58d7\uff70\uff5e";
bytes = new byte[] { (byte)0x9a, (byte)0xda, (byte)0xb0, (byte)0x81, 0x60 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff76";
bytes = new byte[] { (byte)0xb6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u93b9\u5190\u4fc2";
bytes = new byte[] { (byte)0xe8, 0x50, (byte)0xe3, (byte)0xec, (byte)0x8c,
  0x57 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff77\u595d\uff43";
bytes = new byte[] { (byte)0xb7, (byte)0xfa, (byte)0xa2, (byte)0x82,
  (byte)0x83 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff55\uff72";
bytes = new byte[] { (byte)0x82, (byte)0x95, (byte)0xb2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u57d6\u68d4";
bytes = new byte[] { (byte)0x9a, (byte)0xc0, (byte)0x9e, (byte)0x9f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff56";
bytes = new byte[] { (byte)0x82, (byte)0x96 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2b";
bytes = new byte[] { (byte)0x82, 0x6a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u0000";
bytes = new byte[] { 0x00 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0c";
bytes = new byte[] { (byte)0x81, 0x43 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff74\uff7f\u5eb8";
bytes = new byte[] { (byte)0xb4, (byte)0xbf, (byte)0x97, 0x66 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5f31\uff9a\u7f3a";
bytes = new byte[] { (byte)0x8e, (byte)0xe3, (byte)0xda, (byte)0xe3,
  (byte)0x9e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u30ea\u6050";
bytes = new byte[] { (byte)0x83, (byte)0x8a, (byte)0x8b, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
}
}
