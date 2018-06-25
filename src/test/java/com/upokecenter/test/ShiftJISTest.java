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
bytes = new byte[] { 0x7a, (byte)0xb7, 0x30, (byte)0x96, (byte)0xab,
  (byte)0xe1, (byte)0x9b, 0x6c, (byte)0xff, 0x14, (byte)0x94, 0x3f, 0x7d,
  (byte)0xe9, 0x4b, 0x23, 0x43 };
str = "z\uff770\u7a14\u766al\ufffd\u0014\ufffd?}\u98eb#C";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3a, (byte)0x8b, (byte)0xd3, 0x76, 0x19, (byte)0xe9,
  (byte)0xd7 };
str = ":\u6b23v\u0019\u9c0a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x19, (byte)0xa6, 0x1a, 0x16, 0x16, 0x5e, 0x40,
  (byte)0xe9, (byte)0x9f, (byte)0xe4, 0x64, (byte)0xe7, 0x6a, 0x2f, 0x56,
  0x6f, (byte)0x83, (byte)0xae, (byte)0xa1, 0x24, 0x3b, 0x2c, 0x3b };
str =
  "\u0019\uff66\u001a\u0016\u0016^@\u9afb\u81c8\u8f15/Vo\u03a0\uff61$;\u002c;";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x69, 0x64, 0x26, 0x74, 0x07, (byte)0xa0 };
str = "id&t\u0007\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x75, (byte)0xb2, 0x78, (byte)0x8a, 0x7d, 0x5b };
str = "u\uff72x\u7b20[";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x18, (byte)0xa5, 0x30, (byte)0xf7 };
str = "\u0018\uff650\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4d, 0x62, (byte)0x81, 0x3d };
str = "Mb\ufffd=";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x81, (byte)0xb1, 0x7e, 0x3f, (byte)0x97,
  (byte)0x8b, 0x00, 0x66, 0x45, 0x44, 0x29 };
str = "\ufffd~?\u96f7\u0000fED)";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x70, 0x74, 0x5f, 0x6a, (byte)0xd3, (byte)0xef, 0x21,
  (byte)0xb8, 0x51, (byte)0x99, (byte)0xe7, 0x3c, (byte)0x97, 0x49, 0x5d,
  (byte)0x94, 0x37, (byte)0xec, (byte)0x8b, 0x73, 0x62, (byte)0xa4, 0x71,
  0x7e, (byte)0x98, 0x65, 0x1b, 0x2c };
str =

  "pt_j\uff93\ufffd!\uff78Q\u548f<\u60a0]\ufffd7\ufffdsb\uff64q~\u8107\u001b\u002c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x12, 0x2c, 0x21, 0x76, 0x7d, (byte)0x81, (byte)0xb3,
  0x31, 0x63, (byte)0xd9, 0x38 };
str = "\u0012\u002c!v}\ufffd1c\uff998";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x08, 0x6d, (byte)0x9f, 0x54, 0x62, 0x3e };
str = "\u0008m\u9b31b>";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1b, (byte)0xff, 0x51, 0x47, (byte)0xeb, (byte)0xa6,
  0x08, (byte)0xa6, 0x45, 0x29, 0x7e, (byte)0xed, (byte)0x96, 0x47, 0x69,
  (byte)0xdc, (byte)0xd0, (byte)0x8e, (byte)0xe7 };
str = "\u001b\ufffdQG\ufffd\u0008\uff66E)~\u5d42Gi\uff9c\uff90\u5b88";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3b, 0x4d, 0x56, (byte)0xfe, 0x06, (byte)0xcc, 0x3b,
  0x73, (byte)0x87, 0x63, (byte)0xd3, 0x72, (byte)0xbb, (byte)0x99, 0x29,
  0x30, (byte)0xfb, (byte)0x94, 0x00 };
str = ";MV\ufffd\u0006\uff8c;s\u3318\uff93r\uff7b\ufffd)0\u8362\u0000";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8e, 0x54, 0x36, 0x6c, (byte)0xae, 0x4a,
  (byte)0x82, (byte)0x82, (byte)0xe0, (byte)0xcb, 0x70, (byte)0xaa,
  (byte)0xe3, 0x19, 0x5a, 0x67 };
str = "\u64926l\uff6eJ\uff42\u7334p\uff6a\ufffd\u0019Zg";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xca, 0x21, (byte)0xa3, (byte)0xdf, (byte)0xdd,
  (byte)0x89, 0x45, (byte)0xa8, 0x7e, (byte)0x9a, (byte)0x89, (byte)0xa8,
  0x0f, (byte)0xb8, (byte)0xb4, 0x18, 0x03, 0x7a, 0x2e, (byte)0xa0, 0x2d,
  0x1d, 0x5f, 0x32, (byte)0xb3 };
str =

  "\uff8a!\uff63\uff9f\uff9d\u53f3\uff68~\u5694\uff68\u000f\uff78\uff74\u0018\u0003z.\ufffd-\u001d_2\uff73";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x70, (byte)0xdf, (byte)0x97, (byte)0xd4 };
str = "p\uff9f\u7433";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7a, 0x20, 0x51, 0x66, (byte)0xff, (byte)0xda, 0x43 };
str = "z Qf\ufffd\uff9aC";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4a, (byte)0xd5, (byte)0x9e, 0x02, (byte)0xf7, 0x69,
  (byte)0x9d, 0x10, 0x37, 0x45, 0x2e, 0x5b, 0x31, (byte)0xdd, 0x3a,
  (byte)0xae, (byte)0xe0, 0x4d, (byte)0xaf, (byte)0x90, (byte)0x8e,
  (byte)0xa6, 0x47, (byte)0xbc };
str =

  "J\uff95\ufffd\u0002\ue54d\ufffd\u00107E.[1\uff9d:\uff6e\u6f7c\uff6f\u9318\uff66G\uff7c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5e, 0x45, 0x33, 0x5d, 0x3b, 0x58, (byte)0xa3,
  (byte)0xf0, (byte)0xe6, (byte)0xdf, 0x67, 0x56, (byte)0xe8, 0x43,
  (byte)0xce, (byte)0xe8, 0x57, 0x1f, (byte)0xc6, (byte)0xac, 0x52, 0x7d };
str = "^E3];X\uff63\ue0a5\uff9fgV\u9323\uff8e\u93dd\u001f\uff86\uff6cR}";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9f, (byte)0x80, (byte)0x95, (byte)0x9f, 0x45,
  0x68, (byte)0x8a, (byte)0xd8, 0x1d, 0x6c, 0x7e, (byte)0xe9, 0x35,
  (byte)0xc3, (byte)0xa5, (byte)0x83, 0x5d, (byte)0xd7, (byte)0xee, 0x4c,
  (byte)0x97, (byte)0xd6, (byte)0xc5, 0x08, (byte)0x93, 0x23, 0x2c, 0x64 };
str =

  "\u9ebe\u798fEh\u97d3\u001dl~\ufffd5\uff83\uff65\u30be\uff97\u742a\u8f2a\uff85\u0008\ufffd#\u002cd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x94, 0x29, 0x7e, 0x2f, (byte)0x94, 0x77, 0x53,
  0x5d, 0x5c, (byte)0xf4, (byte)0xa9, 0x16, 0x33, 0x6f, 0x71, 0x6d, 0x0e,
  0x37, 0x77, 0x7d };
str = "\ufffd)~/\u80ccS]\\\ue358\u00163oqm\u000e7w}";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x54, (byte)0xc1 };
str = "T\uff81";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xce, 0x4b, (byte)0xa3, 0x79, (byte)0xfb,
  (byte)0x93, (byte)0xba, (byte)0x88, (byte)0x81, 0x51, (byte)0xab, 0x13,
  (byte)0xdc, (byte)0xb8, 0x6d, 0x00, (byte)0x87, (byte)0x98, (byte)0x94,
  0x43, (byte)0xaf, (byte)0xc1, 0x0d, (byte)0xe6, 0x36, (byte)0xe4, 0x75,
  0x16, 0x39 };
str =

  "\uff8eK\uff63y\u8301\uff7a\ufffdQ\uff6b\u0013\uff9c\uff78m\u0000\u221f\u4efb\uff6f\uff81\u000d\ufffd6\u822b\u00169";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1b, 0x3d, (byte)0x93, 0x30, 0x3d, (byte)0xaf, 0x6c,
  0x69, (byte)0xd7, (byte)0x94, 0x63, 0x44, 0x5f, 0x12, 0x0a, 0x35,
  (byte)0x96, (byte)0xcd, 0x69, 0x70, 0x51, (byte)0xbd, (byte)0x89, 0x7f,
  0x4b, (byte)0xea };
str =

  "\u001b=\ufffd0=\uff6fli\uff97\u628aD_\u0012\u000a5\u6a21ipQ\uff7d\ufffd\u007fK\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x22, 0x32, (byte)0x96, (byte)0x96, (byte)0xdf,
  (byte)0xfe, 0x4a, (byte)0xf4, 0x7c, 0x51, (byte)0xa9, 0x73, 0x70,
  (byte)0xa3, 0x0d, 0x5b, 0x73, 0x27, 0x49, 0x23, 0x3d, 0x13, (byte)0xdb,
  (byte)0xdb, 0x04, 0x44, 0x17, 0x23, 0x4f, 0x22 };
str =

  "\"2\u672b\uff9f\ufffdJ\ue32cQ\uff69sp\uff63\u000d[s'I#=\u0013\uff9b\uff9b\u0004D\u0017#O\"";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x47, (byte)0xe9, (byte)0xdb, (byte)0xfd, 0x78, 0x7b,
  (byte)0x8f, 0x57, (byte)0xf1, 0x04, (byte)0xe4, (byte)0x83, 0x2d,
  (byte)0xf0, (byte)0xeb, 0x4d, (byte)0xe6, 0x3d, 0x79 };
str = "G\u9c25\ufffdx\u007b\u96c6\ufffd\u0004\u826b-\ue0aaM\ufffd=y";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x41, (byte)0xca, 0x56, 0x16, (byte)0x97, 0x42, 0x07 };
str = "A\uff8aV\u0016\u552f\u0007";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4f, 0x07 };
str = "O\u0007";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa2, 0x6b, (byte)0xa1, (byte)0xf3, 0x1e,
  (byte)0xbe, 0x30, 0x3f, 0x55, (byte)0xd3, (byte)0xa3, (byte)0xce, 0x53,
  0x29, (byte)0xba, (byte)0xfb, (byte)0xa1, (byte)0xf5, (byte)0xf9,
  (byte)0x82, (byte)0xda, (byte)0xd3, (byte)0x82, 0x31, 0x62, (byte)0x84,
  (byte)0x95, 0x22 };
str =

  "\uff62k\uff61\ufffd\u001e\uff7e0?U\uff93\uff63\uff8eS)\uff7a\u8807\ue464\u307c\uff93\ufffd1b\ufffd\"";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa5, 0x46, 0x54, 0x57, (byte)0xa0 };
str = "\uff65FTW\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd8, 0x06, 0x37, (byte)0xff };
str = "\uff98\u00067\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7e, 0x6d, 0x06, 0x64, (byte)0x96, 0x4d, (byte)0x9d,
  (byte)0xff, 0x7d, (byte)0xa3, 0x79, 0x23, (byte)0x91 };
str = "~m\u0006d\u90a6\ufffd}\uff63y#\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x33, (byte)0xa3, (byte)0x8e, (byte)0xfc, (byte)0xf1,
  0x31, 0x00, 0x67, 0x15, 0x53, 0x6d, (byte)0xa4, 0x57, 0x58, 0x53, 0x2c,
  0x6d, (byte)0x98, 0x29, 0x35, (byte)0xac, 0x6d, 0x6a, (byte)0xb5, 0x47,
  0x04, 0x24, (byte)0xc5 };
str =

  "3\uff63\u5468\ufffd1\u0000g\u0015Sm\uff64WXS\u002cm\ufffd)5\uff6cmj\uff75G\u0004$\uff85";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6b, (byte)0x91, 0x6c, 0x3e, 0x0e, (byte)0xfe, 0x7e };
str = "k\u9f20>\u000e\ufffd~";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x99, 0x7b, (byte)0xf9, (byte)0xaa, 0x36,
  (byte)0x90, (byte)0x9d, (byte)0xe4, (byte)0x85, (byte)0xa9 };
str = "\u51e0\ue7056\u96c0\u8271\uff69";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xed };
str = "\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x35 };
str = "5";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x12, 0x47, (byte)0xd9, 0x29, 0x06, (byte)0xc6,
  (byte)0xe2, (byte)0x9b, (byte)0xaa, 0x12, (byte)0x8d, (byte)0x99,
  (byte)0xbe, (byte)0xd1, 0x20, 0x4e, 0x35, 0x4e, 0x10, (byte)0xb2,
  (byte)0x84, 0x22, (byte)0xbf, (byte)0xcc };
str =

  "\u0012G\uff99)\u0006\uff86\u7b35\uff6a\u0012\u7511\uff7e\uff91 N5N\u0010\uff72\ufffd\"\uff7f\uff8c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x65, 0x59, (byte)0xb9, (byte)0xca };
str = "eY\uff79\uff8a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf4, (byte)0x89, 0x25, 0x0c, 0x26, (byte)0xab,
  0x0f, (byte)0xf6, 0x5a, (byte)0x83, (byte)0x8e, 0x0a, (byte)0xb6,
  (byte)0xa8, (byte)0xbf, (byte)0xdf, 0x5f, 0x5a, 0x43, 0x32 };
str =
  "\ue338%\u000c&\uff6b\u000f\ue482\u30ee\u000a\uff76\uff68\uff7f\uff9f_ZC2";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43, 0x4c, 0x02, 0x66, 0x20, 0x7b, 0x7f, 0x6f,
  (byte)0x83, (byte)0x90, (byte)0xdb, (byte)0xfc, 0x67, 0x6a, 0x24 };
str = "CL\u0002f \u007b\u007fo\u30f0\uff9b\ufffdgj$";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb2, (byte)0x8a, 0x7f, 0x67, (byte)0x9d };
str = "\uff72\ufffd\u007fg\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6c, 0x34, (byte)0xe7, 0x02, 0x42, (byte)0x86, 0x1a,
  (byte)0xb4, 0x43, 0x73, (byte)0x81, (byte)0xd5, 0x08, (byte)0xd0, 0x4e,
  0x45, (byte)0x82, 0x72, 0x29, 0x75, 0x79, (byte)0xee, 0x37, 0x44, 0x5e,
  (byte)0xeb, (byte)0x90, (byte)0xd6, 0x21, 0x3a };
str =

  "l4\ufffd\u0002B\ufffd\u001a\uff74Cs\ufffd\u0008\uff90NE\uff33)uy\ufffd7D^\ufffd\uff96!:";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5f, (byte)0x94, (byte)0xe3 };
str = "_\u6590";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcf, (byte)0xbd, (byte)0x8e, 0x03, 0x3f, 0x34,
  0x29, (byte)0xb4, (byte)0xd3, (byte)0x80, 0x5d, 0x77, (byte)0xe7, 0x24,
  0x62, 0x15, (byte)0x9d, 0x5d, 0x66, (byte)0xc1, (byte)0xc3, 0x5c, 0x6f,
  (byte)0xa5, (byte)0xdd, 0x4a };
str =

  "\uff8f\uff7d\ufffd\u0003?4)\uff74\uff93\u0080]w\ufffd$b\u0015\u62c6f\uff81\uff83\\o\uff65\uff9dJ";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x29, 0x4d, 0x42, (byte)0xda };
str = ")MB\uff9a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb3, 0x59, (byte)0xd7, (byte)0x8f, 0x7b,
  (byte)0xb0, 0x4f, (byte)0xc5, (byte)0x86, 0x12, 0x6d, 0x27, 0x52, 0x60,
  (byte)0xae, (byte)0x99, (byte)0xcb, 0x38 };
str = "\uff73Y\uff97\u65ec\uff70O\uff85\ufffd\u0012m'R`\uff6e\u53968";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x38, 0x7b, 0x72, 0x37, 0x6c, (byte)0xc5, 0x0a,
  (byte)0xb2, 0x39, (byte)0xf6, (byte)0xf5 };
str = "8\u007br7l\uff85\u000a\uff729\ue51c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xef, 0x49, 0x5e, (byte)0xe2, 0x68, (byte)0x96,
  (byte)0xb6, (byte)0xe7 };
str = "\ufffdI^\u7980\u9727\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x55, 0x50, (byte)0xa5, (byte)0xf2, 0x47, 0x3c, 0x78,
  0x6c, 0x76, 0x21, (byte)0x8b, (byte)0xff, 0x5a, 0x1f, 0x1c, (byte)0xe3,
  0x3a, (byte)0xb9, 0x00, 0x13, 0x23, (byte)0xd7, (byte)0xde, (byte)0xc7,
  0x22, (byte)0x9a, (byte)0xeb };
str =

  "UP\uff65\ue17f<xlv!\ufffdZ\u001f\u001c\ufffd:\uff79\u0000\u0013#\uff97\uff9e\uff87\"\u68a6";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2c, 0x69, 0x2b, 0x10, 0x52, (byte)0xe6, (byte)0xe2,
  0x6b, (byte)0xbe, 0x6f };
str = "\u002ci+\u0010R\u8d99k\uff7eo";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x32, (byte)0x94, 0x71, 0x7b, 0x22, 0x62, (byte)0xbf,
  0x54, (byte)0x89, 0x22, (byte)0xdf, (byte)0xec, 0x5c };
str = "2\u62dd\u007b\"b\uff7fT\ufffd\"\uff9f\ufffd\\";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf9, (byte)0xbe, 0x50, 0x5b, 0x59, 0x1f, 0x1f,
  0x70, (byte)0xd3, 0x37, (byte)0xa5, (byte)0xc9, 0x17, (byte)0x87 };
str = "\ue719P[Y\u001f\u001fp\uff937\uff65\uff89\u0017\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x26, 0x50, 0x27, (byte)0xdc, 0x05, 0x63, (byte)0xf6,
  0x40, (byte)0xf7, 0x6d, (byte)0xfe, (byte)0xd8, (byte)0xa1 };
str = "&P'\uff9c\u0005c\ue468\ue551\ufffd\uff98\uff61";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfb, (byte)0x88, 0x57, 0x5e, 0x3f, 0x2d, 0x75,
  0x55, 0x2b, (byte)0x90, 0x43, (byte)0x82, (byte)0x94, (byte)0x92, 0x64 };
str = "\u7b9eW^?-uU+\u71ed\uff54\u58c7";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9f, 0x4f, 0x72, (byte)0xb0, 0x33, (byte)0xeb,
  0x0d, 0x07, (byte)0x9c, 0x7d };
str = "\u6b05r\uff703\ufffd\u000d\u0007\u6021";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x68, (byte)0x83, (byte)0xdd, 0x71 };
str = "h\ufffdq";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa8, (byte)0xe9, (byte)0xf6, 0x20, 0x26,
  (byte)0xde, 0x12 };
str = "\uff68\u9d15 &\uff9e\u0012";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf2, 0x27, (byte)0xeb, 0x08, 0x3e, (byte)0xa3,
  0x02, (byte)0xce, (byte)0xa6, (byte)0x9c, 0x4a, (byte)0xa6, (byte)0xa3 };
str = "\ufffd'\ufffd\u0008>\uff63\u0002\uff8e\uff66\u5ef1\uff66\uff63";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc5, (byte)0xdb, 0x23, 0x54, 0x7a, (byte)0xc6 };
str = "\uff85\uff9b#Tz\uff86";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4f, 0x57, 0x4f, 0x49, (byte)0xe9, (byte)0xbd, 0x23,
  0x41, 0x62, (byte)0x9a, 0x66, (byte)0x87, 0x56 };
str = "OWOI\u9ba8#Ab\u5583\u2162";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc1, (byte)0xb5, 0x6e, (byte)0xe6, 0x2f, 0x47,
  0x50, 0x38, (byte)0xfe, 0x18, 0x0b, 0x4a, 0x4b, 0x66, 0x5d, 0x36, 0x24,
  0x04, 0x1e, 0x3b, 0x02 };
str = "\uff81\uff75n\ufffd/GP8\ufffd\u0018\u000bJKf]6$\u0004\u001e;\u0002";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x74, (byte)0xbf, (byte)0xa7, 0x14, 0x22, 0x4b,
  (byte)0xdf, (byte)0xa2, 0x57, 0x0f, 0x4a, 0x64, 0x5c };
str = "t\uff7f\uff67\u0014\"K\uff9f\uff62W\u000fJd\\";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4f, (byte)0xb8, (byte)0xa4, 0x23, 0x5a, (byte)0x8e,
  0x43, (byte)0x88, (byte)0xd7, 0x24, 0x65, 0x4c, 0x61, 0x26, 0x75, 0x42,
  (byte)0xff };
str = "O\uff78\uff64#Z\u64e6\u70ba$eLa&uB\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5e, (byte)0xaa, 0x02, (byte)0xa3, (byte)0xab };
str = "^\uff6a\u0002\uff63\uff6b";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbe, 0x30, (byte)0x9c, 0x50, 0x44, 0x5d, 0x75,
  0x66, 0x5b, 0x74, (byte)0x91 };
str = "\uff7e0\u5f03D]uf[t\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x61 };
str = "a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfa, 0x01, 0x57, (byte)0xf5, 0x43, 0x02, 0x27,
  0x4c, 0x11, (byte)0x99 };
str = "\ufffd\u0001W\ue3af\u0002'L\u0011\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0b, (byte)0xe3, 0x3b, 0x54, (byte)0xfe, 0x38,
  (byte)0xb7, (byte)0xbd, 0x71, 0x32, (byte)0x89, 0x31, 0x34, 0x51, 0x66,
  0x00, 0x3c, 0x1c };
str = "\u000b\ufffd;T\ufffd8\uff77\uff7dq2\ufffd14Qf\u0000<\u001c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x38, (byte)0xfa, (byte)0x8c, 0x61, 0x60, 0x20, 0x5f,
  0x7a, 0x2f, 0x23 };
str = "8\u5372a` _z/#";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x08, (byte)0xa1, 0x0f, 0x75, (byte)0xcd, 0x76 };
str = "\u0008\uff61\u000fu\uff8dv";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x36, (byte)0xbe, 0x2c, (byte)0xe3, (byte)0x8f, 0x3f,
  (byte)0xbd, (byte)0x9c, (byte)0xc5, 0x4c, (byte)0x92, (byte)0xf9, 0x24,
  0x53, (byte)0xed, 0x36, (byte)0x81, (byte)0xa9, 0x7c, (byte)0xa5,
  (byte)0xcc, 0x67, (byte)0xb2, 0x4f };
str =
  "6\uff7e\u002c\u7e7d?\uff7d\u612cL\u8a02$S\ufffd6\u2190|\uff65\uff8cg\uff72O";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc7, (byte)0xd1, (byte)0xf7 };
str = "\uff87\uff91\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4c, 0x71, 0x6e, (byte)0xaa, 0x32, 0x47 };
str = "Lqn\uff6a2G";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x77, (byte)0xc0, 0x5a, 0x67, 0x66, 0x5b, 0x76 };
str = "w\uff80Zgf[v";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0c, (byte)0xef, (byte)0xe1, 0x6c, 0x24, 0x27,
  (byte)0xfe, (byte)0xa8, 0x35, 0x32, 0x1c, 0x2e, (byte)0xa7, (byte)0xfa,
  0x39, 0x77, 0x6e, 0x01, (byte)0xc2, 0x77, (byte)0xf1, 0x12, 0x48,
  (byte)0xfa, 0x55, (byte)0xf9, (byte)0xc8, 0x00, 0x76 };
str =

  "\u000c\ufffdl$'\ufffd\uff6852\u001c.\uff67\ufffd9wn\u0001\uff82w\ufffd\u0012H\uffe4\ue723\u0000v";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5f, (byte)0xef, (byte)0xf7, (byte)0xc8, 0x4b,
  (byte)0xa6, (byte)0xb7, 0x06, (byte)0xf1, 0x3c, 0x5b, 0x39, 0x38, 0x34,
  (byte)0xa7, (byte)0xb6, 0x3f };
str = "_\ufffd\uff88K\uff66\uff77\u0006\ufffd<[984\uff67\uff76?";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc4, (byte)0xe6, (byte)0xed, (byte)0x9c,
  (byte)0xe8, 0x0d, 0x7d, 0x47, 0x7e, 0x32, 0x30, (byte)0x98, (byte)0x8d,
  (byte)0xfc, 0x78, (byte)0xad, (byte)0xbe, 0x53, 0x51, 0x79, (byte)0xc3,
  (byte)0x87, 0x30, (byte)0xe2, (byte)0xcd, 0x6e, (byte)0xf5, 0x10,
  (byte)0x83 };
str =

  "\uff84\u8deb\u61c6\u000d}G~20\ufffd\ufffdx\uff6d\uff7eSQy\uff83\ufffd0\u7c23n\ufffd\u0010\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x68, (byte)0x84, (byte)0xca, (byte)0x8e, (byte)0xfc,
  0x4b, (byte)0xe1, 0x1f };
str = "h\ufffd\u5468K\ufffd\u001f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x02, 0x4b, 0x4c, 0x7e, 0x2c, 0x33, 0x60, (byte)0xda,
  0x58, (byte)0x80, (byte)0xa5, 0x5a, (byte)0xfa, 0x1e, (byte)0xb1,
  (byte)0xf0, 0x00, 0x03, 0x4c, (byte)0xe5 };
str =

  "\u0002KL~\u002c3`\uff9aX\u0080\uff65Z\ufffd\u001e\uff71\ufffd\u0000\u0003L\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6d, (byte)0xf2, (byte)0xb8, (byte)0x8f, 0x0d,
  (byte)0x85, (byte)0xa1, (byte)0xb0, (byte)0xb8, (byte)0xb5, (byte)0xea,
  0x6b };
str = "m\ue1ef\ufffd\u000d\ufffd\uff70\uff78\uff75\u9e91";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf5, 0x6b, (byte)0xcf, (byte)0xe4, 0x23, 0x47,
  0x72, (byte)0xcd, (byte)0x84, 0x3d, 0x6b, 0x78, (byte)0xc5, (byte)0xce };
str = "\ue3d7\uff8f\ufffd#Gr\uff8d\ufffd=kx\uff85\uff8e";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4f, (byte)0xb7, 0x6c, 0x47, (byte)0xfa, 0x46,
  (byte)0xd0, 0x32, (byte)0xa6, 0x24, 0x54, (byte)0xe5, 0x3e, (byte)0xeb,
  (byte)0xc0, 0x14, (byte)0xf8, 0x5f, 0x0e, 0x50, 0x07, 0x2f, 0x5f, 0x7f,
  (byte)0x86, 0x44, (byte)0x88 };
str =

  "O\uff77lG\u2176\uff902\uff66$T\ufffd>\ufffd\u0014\ue5ff\u000eP\u0007/_\u007f\ufffdD\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8c, 0x75, 0x28, 0x07, 0x1f };
str = "\u86cd(\u0007\u001f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x72, (byte)0xbd, (byte)0xf1, 0x3c, 0x21, 0x78, 0x17,
  (byte)0xf5, (byte)0xa9, 0x3f, (byte)0xf7, 0x6c, 0x28, 0x7b, 0x0f, 0x7e,
  0x1f, (byte)0xf3, (byte)0x86, 0x60, (byte)0xed, (byte)0xd5, 0x38, 0x06,
  0x1a, 0x33 };
str =

  "r\uff7d\ufffd<!x\u0017\ue414?\ue550(\u007b\u000f~\u001f\ue279`\u6a7e8\u0006\u001a3";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x46, 0x27, 0x55, (byte)0xd2, 0x62, 0x42, 0x65, 0x35,
  0x75, (byte)0xb3, (byte)0x8e, 0x31, (byte)0xa2, 0x58 };
str = "F'U\uff92bBe5u\uff73\ufffd1\uff62X";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x20, (byte)0xd5, 0x6f, 0x01, (byte)0xad, (byte)0xff,
  (byte)0xf3, 0x2c, (byte)0xec, 0x5d, 0x1d, 0x79, (byte)0xc0, 0x72 };
str = " \uff95o\u0001\uff6d\ufffd\ufffd\u002c\ufffd]\u001dy\uff80r";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x34, 0x6e, (byte)0xa0, 0x38, 0x48, (byte)0xda,
  (byte)0xbd, (byte)0x91, (byte)0xdb, 0x6e, 0x74, 0x5d, (byte)0xd6,
  (byte)0xc6, (byte)0xcd, 0x34, 0x33, (byte)0x96, (byte)0xe7, 0x6d };
str = "4n\ufffd8H\uff9a\uff7d\u82d4nt]\uff96\uff86\uff8d43\u4e5fm";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x72, 0x5b, 0x50, 0x05, 0x3d, (byte)0xdc, (byte)0xd8,
  (byte)0xa5, 0x7e, 0x2e, (byte)0xd8, 0x44, 0x65, 0x14, 0x6b, 0x25,
  (byte)0xd7, (byte)0xf1 };
str = "r[P\u0005=\uff9c\uff98\uff65~.\uff98De\u0014k%\uff97\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x81, 0x79, 0x76, (byte)0x89, (byte)0xe4,
  (byte)0xbf, 0x0e, 0x24, 0x46, (byte)0x9d, (byte)0x84, 0x56, (byte)0xc3,
  (byte)0x8e, (byte)0xba, 0x36, 0x4a, 0x3c, (byte)0x9e, 0x02, (byte)0xad,
  (byte)0xcb, 0x05, 0x40, 0x64 };
str =

  "\u3010v\u6211\uff7f\u000e$F\u63c6V\uff83\u5ba46J<\ufffd\u0002\uff6d\uff8b\u0005@d";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7b, (byte)0xb4, 0x51, 0x0c, 0x2c, 0x4b, 0x33, 0x6b,
  0x0f, (byte)0xcd, 0x4a, (byte)0xf0, 0x15, 0x6e, 0x29, 0x7c, 0x57,
  (byte)0xca, 0x23 };
str = "\u007b\uff74Q\u000c\u002cK3k\u000f\uff8dJ\ufffd\u0015n)|W\uff8a#";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x66, (byte)0xf4, (byte)0xf7, (byte)0xad, (byte)0xf9,
  0x3e, 0x73, 0x1f, 0x3a, (byte)0xbd, 0x5e, 0x3f, 0x20 };
str = "f\ue3a6\uff6d\ufffd>s\u001f:\uff7d^? ";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4c, (byte)0x83, (byte)0x81, 0x6c, 0x7e, 0x63, 0x30,
  0x54, (byte)0xe6, 0x39, 0x55, 0x6a, (byte)0xc4, (byte)0xf7, 0x13, 0x24,
  (byte)0xc3, (byte)0x8e, 0x2d, 0x26, (byte)0x82, (byte)0xd0, 0x2b, 0x0c,
  (byte)0xe6, 0x0e, (byte)0xff, (byte)0x86 };
str =

  "L\u30e1l~c0T\ufffd9Uj\uff84\ufffd\u0013$\uff83\ufffd-&\u3072+\u000c\ufffd\u000e\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x73, 0x49, (byte)0xd0, 0x6d, (byte)0xfb };
str = "sI\uff90m\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2b };
str = "+";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x99, 0x00, 0x5f, (byte)0xfb, 0x08, (byte)0xcf };
str = "\ufffd\u0000_\ufffd\u0008\uff8f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x29, 0x3e, (byte)0xbd, (byte)0x92, (byte)0x92,
  (byte)0xcf, 0x39, 0x54, (byte)0xa4, (byte)0xc6 };
str = ")>\uff7d\u92f3\uff8f9T\uff64\uff86";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9c, 0x7e, (byte)0xf1, 0x28, 0x15, 0x48,
  (byte)0xa0, 0x23, 0x15, (byte)0xc0, 0x2c, 0x6b, (byte)0xa2, (byte)0xf7,
  0x24, (byte)0xe6, (byte)0x8c, 0x77, 0x0c, (byte)0xdb, 0x55, 0x02, 0x26,
  0x76, (byte)0xc2 };
str =

  "\u6060\ufffd(\u0015H\ufffd#\u0015\uff80\u002ck\uff62\ufffd$\u8b16w\u000c\uff9bU\u0002&v\uff82";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x56, (byte)0xca, 0x5d, (byte)0xd3, (byte)0xbe,
  (byte)0x89, (byte)0xb3, (byte)0x8e, 0x4c, 0x48, (byte)0x8c, 0x08, 0x50,
  0x51, 0x21 };
str = "V\uff8a]\uff93\uff7e\u4e59\u9babH\ufffd\u0008PQ!";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5b, 0x6b, (byte)0xa3, (byte)0x9e, (byte)0xc6,
  (byte)0x83, (byte)0xbf, 0x67, 0x24, (byte)0xbe, (byte)0xb1, 0x25,
  (byte)0x94, (byte)0xf5, 0x4d, (byte)0x9a, 0x4f, (byte)0xd0, 0x2b };
str = "[k\uff63\u69bf\u03b1g$\uff7e\uff71%\u5099M\u5539\uff90+";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
}@Test
public void TestShiftJISEncoder() {
byte[] bytes;
String str;
ICharacterEncoding charset = Encodings.GetEncoding("shift_jis");
str = "\uff99\u5de1\uff95\u6b50";
bytes = new byte[] { (byte)0xd9, (byte)0x8f, (byte)0x84, (byte)0xd5,
  (byte)0x9f, 0x5e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff06\u727e\uff9c";
bytes = new byte[] { (byte)0x81, (byte)0x95, (byte)0xe0, (byte)0xb1,
  (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff66\u734f\uff0a";
bytes = new byte[] { (byte)0xa6, (byte)0xe0, (byte)0xd1, (byte)0x81,
  (byte)0x96 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9413";
bytes = new byte[] { (byte)0xe8, 0x5d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5025\uff2c\u874b";
bytes = new byte[] { (byte)0x98, (byte)0xe3, (byte)0x82, 0x6b, (byte)0x98,
  0x58 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6587\u5b64\u6f20";
bytes = new byte[] { (byte)0x95, (byte)0xb6, (byte)0x8c, (byte)0xc7,
  (byte)0x94, (byte)0x99 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff78";
bytes = new byte[] { (byte)0xb8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u623f";
bytes = new byte[] { (byte)0x96, 0x5b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u0013\uff43\u6c42";
bytes = new byte[] { 0x13, (byte)0x82, (byte)0x83, (byte)0x8b, (byte)0x81 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u58c1\uff46\u6dc5\uff19\uff61";
bytes = new byte[] { (byte)0x95, (byte)0xc7, (byte)0x82, (byte)0x86,
  (byte)0x9f, (byte)0xc6, (byte)0x82, 0x58, (byte)0xa1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7c82";
bytes = new byte[] { (byte)0x8c, 0x48 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u70ad\u8862\u253b";
bytes = new byte[] { (byte)0x92, 0x59, (byte)0xe5, (byte)0xcb, (byte)0x84,
  (byte)0xb3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "9\uff5e\uff66";
bytes = new byte[] { 0x39, (byte)0x81, 0x60, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "V\uff6f\u000a";
bytes = new byte[] { 0x56, (byte)0xaf, 0x0a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5104\u2234\u8218";
bytes = new byte[] { (byte)0x89, (byte)0xad, (byte)0x81, (byte)0x88,
  (byte)0x8a, (byte)0xda };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u796d";
bytes = new byte[] { (byte)0x8d, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6bb2\uff2e\u251b";
bytes = new byte[] { (byte)0x9f, 0x72, (byte)0x82, 0x6d, (byte)0x84,
  (byte)0xae };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7b67\uff33\uff7e";
bytes = new byte[] { (byte)0xe2, (byte)0xa8, (byte)0x82, 0x72, (byte)0xbe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u759d\uffe5\uff15\uffe4";
bytes = new byte[] { (byte)0xe1, 0x6c, (byte)0x81, (byte)0x8f, (byte)0x82,
  0x54, (byte)0xfa, 0x55 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6081\u6e6e\u7325";
bytes = new byte[] { (byte)0x9c, (byte)0x9a, (byte)0x9f, (byte)0xce,
  (byte)0xe0, (byte)0xce };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u25b2\u693d\u6248\uff6b";
bytes = new byte[] { (byte)0x81, (byte)0xa3, (byte)0x9e, (byte)0xbb,
  (byte)0xe7, (byte)0xbb, (byte)0xab };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5e9c\u59be\uffe4";
bytes = new byte[] { (byte)0x95, 0x7b, (byte)0x8f, (byte)0xa8, (byte)0xfa,
  0x55 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff06\uff8f\uff49";
bytes = new byte[] { (byte)0x81, (byte)0x95, (byte)0xcf, (byte)0x82,
  (byte)0x89 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6f13";
bytes = new byte[] { (byte)0xe0, 0x41 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u769c\u6bb2\u6d99";
bytes = new byte[] { (byte)0xfb, 0x71, (byte)0x9f, 0x72, (byte)0x97,
  (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff27\u80d9\u5ed3";
bytes = new byte[] { (byte)0x82, 0x66, (byte)0xe3, (byte)0xf0, (byte)0x8a,
  0x66 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u79e4";
bytes = new byte[] { (byte)0x94, (byte)0x89 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u66fc\u504f\u615a";
bytes = new byte[] { (byte)0x99, (byte)0xd6, (byte)0x95, (byte)0xce,
  (byte)0x9c, (byte)0xce };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9d\u68ef";
bytes = new byte[] { (byte)0xdd, (byte)0x9e, (byte)0xaa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6753\u7aba\u613e";
bytes = new byte[] { (byte)0x8e, (byte)0xdb, (byte)0x89, 0x4d, (byte)0x9c,
  (byte)0xbf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7f5f";
bytes = new byte[] { (byte)0xe3, (byte)0xa8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6baf";
bytes = new byte[] { (byte)0x9f, 0x71 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe2\u630c\uff0e";
bytes = new byte[] { (byte)0x81, (byte)0xca, (byte)0x9d, 0x67, (byte)0x81,
  0x44 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4a";
bytes = new byte[] { (byte)0x82, (byte)0x8a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff24";
bytes = new byte[] { (byte)0x82, 0x63 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff11";
bytes = new byte[] { (byte)0x82, 0x50 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "%";
bytes = new byte[] { 0x25 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u53df\u65e5\u78ca";
bytes = new byte[] { (byte)0x99, (byte)0xd5, (byte)0x93, (byte)0xfa,
  (byte)0xe1, (byte)0xfb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u53cc\uff28\u5958";
bytes = new byte[] { (byte)0x91, 0x6f, (byte)0x82, 0x67, (byte)0x9a,
  (byte)0xf7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9698\uff50\u544a\u5737";
bytes = new byte[] { (byte)0xe8, (byte)0xa5, (byte)0x82, (byte)0x90,
  (byte)0x8d, (byte)0x90, (byte)0x9a, (byte)0xa8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6174";
bytes = new byte[] { (byte)0x9c, (byte)0xd0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u52d7";
bytes = new byte[] { (byte)0x99, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5116";
bytes = new byte[] { (byte)0x99, 0x4f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u621f\uff62#";
bytes = new byte[] { (byte)0x8c, (byte)0x81, (byte)0xa2, 0x23 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6495\u7262";
bytes = new byte[] { (byte)0x9d, (byte)0x99, (byte)0x98, 0x53 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6460\u8988\u7cab";
bytes = new byte[] { (byte)0xfa, (byte)0xca, (byte)0xe6, 0x49, (byte)0xe2,
  (byte)0xe6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u609a";
bytes = new byte[] { (byte)0x9c, (byte)0x9e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e93\u54b2\u70f1";
bytes = new byte[] { (byte)0xe3, (byte)0x97, (byte)0x8d, (byte)0xe7,
  (byte)0xe0, 0x77 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff45";
bytes = new byte[] { (byte)0x82, (byte)0x85 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6928\uff80\u7470";
bytes = new byte[] { (byte)0x9e, (byte)0xab, (byte)0xc0, (byte)0xe0,
  (byte)0xf1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6f\u7316\uff59";
bytes = new byte[] { (byte)0xaf, (byte)0xe0, (byte)0xc9, (byte)0x82,
  (byte)0x99 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d39";
bytes = new byte[] { (byte)0x8f, (byte)0xd0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6d25\u537b\u246b\uff55";
bytes = new byte[] { (byte)0x92, (byte)0xc3, (byte)0x99, (byte)0xc8,
  (byte)0x87, 0x4b, (byte)0x82, (byte)0x95 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff08\uff4a";
bytes = new byte[] { (byte)0x81, 0x69, (byte)0x82, (byte)0x8a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe4\u5346";
bytes = new byte[] { (byte)0xfa, 0x55, (byte)0x99, (byte)0xbe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1c\uff8a";
bytes = new byte[] { (byte)0x81, (byte)0x83, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff14";
bytes = new byte[] { (byte)0x82, 0x53 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5840\u266f\u51d6";
bytes = new byte[] { (byte)0x95, (byte)0xbb, (byte)0x81, (byte)0xf2,
  (byte)0x99, (byte)0xc3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5636";
bytes = new byte[] { (byte)0x9a, 0x7c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff80\u2220\u5401";
bytes = new byte[] { (byte)0xc0, (byte)0x81, (byte)0xda, (byte)0x99,
  (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u68a2\uff96\u6f544";
bytes = new byte[] { (byte)0x8f, (byte)0xbd, (byte)0xd6, (byte)0x8c,
  (byte)0x89, 0x34 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5bb3\u5c22";
bytes = new byte[] { (byte)0x8a, 0x51, (byte)0x9b, (byte)0x97 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff10\u6664\u2234";
bytes = new byte[] { (byte)0x82, 0x4f, (byte)0x9d, (byte)0xeb, (byte)0x81,
  (byte)0x88 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u57a3";
bytes = new byte[] { (byte)0x8a, 0x5f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9a\u7f51\u88c4";
bytes = new byte[] { (byte)0xda, (byte)0xe3, (byte)0xa4, (byte)0xe5,
  (byte)0xe0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6536\uff1e\uff62";
bytes = new byte[] { (byte)0x9d, (byte)0xbe, (byte)0x81, (byte)0x84,
  (byte)0xa2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff8b\uff5a";
bytes = new byte[] { (byte)0xcb, (byte)0x82, (byte)0x9a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff09\u5177";
bytes = new byte[] { (byte)0x81, 0x6a, (byte)0x8b, (byte)0xef };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9d\uff44\uff1f";
bytes = new byte[] { (byte)0xdd, (byte)0x82, (byte)0x84, (byte)0x81, 0x48 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff04\uff69\uff14";
bytes = new byte[] { (byte)0x81, (byte)0x90, (byte)0xa9, (byte)0x82, 0x53 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe0\u67a6\uff8f";
bytes = new byte[] { (byte)0x81, (byte)0x91, (byte)0x9e, 0x64, (byte)0xcf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u221e\uff2a\u67c1";
bytes = new byte[] { (byte)0x81, (byte)0x87, (byte)0x82, 0x69, (byte)0x91,
  (byte)0xc6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff77";
bytes = new byte[] { (byte)0xb7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7a37";
bytes = new byte[] { (byte)0xe2, 0x6c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff34";
bytes = new byte[] { (byte)0x82, 0x73 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6248\uff0a\u7680";
bytes = new byte[] { (byte)0xe7, (byte)0xbb, (byte)0x81, (byte)0x96,
  (byte)0xe1, (byte)0xa3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6eb6\uff93\u51a5";
bytes = new byte[] { (byte)0x97, 0x6e, (byte)0xd3, (byte)0x96, (byte)0xbb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6ae2\uff73\u665d";
bytes = new byte[] { (byte)0xfa, (byte)0xf2, (byte)0xb3, (byte)0x9d,
  (byte)0xea };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5a40\u6ab3";
bytes = new byte[] { (byte)0x9b, 0x53, (byte)0x9f, 0x46 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u527d\uff51\uff2f\uff87";
bytes = new byte[] { (byte)0x99, (byte)0x97, (byte)0x82, (byte)0x91,
  (byte)0x82, 0x6e, (byte)0xc7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e92";
bytes = new byte[] { (byte)0xe3, (byte)0x95 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "_\uff65\uff4d";
bytes = new byte[] { 0x5f, (byte)0xa5, (byte)0x82, (byte)0x8d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5283\uff52\u6213";
bytes = new byte[] { (byte)0x8a, 0x63, (byte)0x82, (byte)0x92, (byte)0xfa,
  (byte)0xc7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u520b";
bytes = new byte[] { (byte)0x99, (byte)0x84 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5191\u608d\u6df8L";
bytes = new byte[] { (byte)0x99, 0x68, (byte)0x9c, (byte)0x9b, (byte)0xfb,
  0x43, 0x4c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u623f\u7b97\uff54\u68b9";
bytes = new byte[] { (byte)0x96, 0x5b, (byte)0x8e, 0x5a, (byte)0x82,
  (byte)0x94, (byte)0x9e, (byte)0x8e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff82\u6c23";
bytes = new byte[] { (byte)0xc2, (byte)0x9f, (byte)0x86 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7092\uff0a\u53f0";
bytes = new byte[] { (byte)0xe0, 0x75, (byte)0x81, (byte)0x96, (byte)0x91,
  (byte)0xe4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0d";
bytes = new byte[] { (byte)0x81, 0x7c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6d\u2174\u0004\u65d9";
bytes = new byte[] { (byte)0xad, (byte)0xfa, 0x44, 0x04, (byte)0x9d,
  (byte)0xd8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7b9f";
bytes = new byte[] { (byte)0xe2, (byte)0xaf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6a7e\uffe0\u79bf\u6daf\u7e1f";
bytes = new byte[] { (byte)0xfa, (byte)0xf1, (byte)0x81, (byte)0x91,
  (byte)0x93, (byte)0xc3, (byte)0x8a, 0x55, (byte)0xe3, 0x74 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6ec9\u6614\uffe0";
bytes = new byte[] { (byte)0x9f, (byte)0xe4, (byte)0x90, (byte)0xcc,
  (byte)0x81, (byte)0x91 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u62fe";
bytes = new byte[] { (byte)0x8f, 0x45 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff79\u5c11";
bytes = new byte[] { (byte)0xb9, (byte)0x8f, (byte)0xad };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6853\u2227\u7429";
bytes = new byte[] { (byte)0x8a, (byte)0xba, (byte)0x81, (byte)0xc8,
  (byte)0xfb, 0x69 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9d";
bytes = new byte[] { (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff02\uff12\uff4ad\u6d29";
bytes = new byte[] { (byte)0xfa, 0x57, (byte)0x82, 0x51, (byte)0x82,
  (byte)0x8a, 0x64, (byte)0x89, 0x6b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u550f\u6199\u4ea0";
bytes = new byte[] { (byte)0x9a, 0x48, (byte)0x9c, (byte)0xd8, (byte)0x98,
  (byte)0xb3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff12";
bytes = new byte[] { (byte)0x82, 0x51 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
}
}
