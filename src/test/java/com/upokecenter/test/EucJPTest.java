package com.upokecenter.test; import com.upokecenter.util.*;

import org.junit.Assert;
import org.junit.Test;
import com.upokecenter.util.*;
import com.upokecenter.text.*;

public class EucJPTest {
@Test
public void TestEucJPDecoder() {
byte[] bytes;
String str;
ICharacterEncoding charset = Encodings.GetEncoding("euc-jp");
bytes = new byte[] { 0x39, 0x52, (byte)0xa9, (byte)0xaa, 0x20, (byte)0xdf,
  0x64, 0x35 };
str = "9R\ufffd \ufffdd5";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x93, 0x35, 0x07, (byte)0x89 };
str = "\ufffd5\u0007\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7d, (byte)0x93, (byte)0xdb, 0x69, 0x48, 0x2c, 0x7f,
  0x45, 0x7b, 0x1d, (byte)0xf2, 0x54, 0x6a, 0x3c, 0x23, 0x5f, 0x31, 0x35,
  0x0a, (byte)0xf2, (byte)0xb9, (byte)0xd4, 0x5d, (byte)0xda, 0x30, 0x2c,
  0x40 };
str =

  "}\ufffd\ufffdiH\u002c\u007fE\u007b\u001d\ufffdTj<#_15\u000a\u9b83\ufffd]\ufffd0\u002c@";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x10, 0x4a, (byte)0xe3 };
str = "\u0010J\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7d, (byte)0xf8, (byte)0xf8, 0x1e, 0x71, 0x4f,
  (byte)0xe4, (byte)0xd2, 0x37, 0x69, 0x73, 0x61, (byte)0xa1, (byte)0x94,
  0x57, (byte)0xd2, 0x5a, 0x7b, 0x4d, (byte)0x99, 0x29, 0x0f, (byte)0xbd,
  (byte)0xfe, (byte)0x8b, 0x00, 0x4f, (byte)0xd7, (byte)0xcb, 0x3b };
str =

  "}\ufffd\u001eqO\u7c1f7isa\ufffdW\ufffdZ\u007bM\ufffd)\u000f\u511f\ufffd\u0000O\u5f8a;";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4a, (byte)0xf9, (byte)0xf2, (byte)0xea, 0x3a, 0x78,
  0x15, 0x3c, 0x5f, 0x4c, (byte)0x94 };
str = "J\u5cf5\ufffd:x\u0015<_L\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6e, 0x7b, 0x79, 0x48, 0x68, (byte)0x9e, (byte)0xa7,
  0x5c, (byte)0x9b, 0x5c };
str = "n\u007byHh\ufffd\ufffd\\\ufffd\\";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x25, 0x17, (byte)0xed, (byte)0xb4, 0x4a, 0x58, 0x0a,
  (byte)0xbf };
str = "%\u0017\u8e8aJX\u000a\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x21, 0x62, 0x07, 0x76, 0x3d, (byte)0xfa, 0x42,
  (byte)0xe3, (byte)0xa6, (byte)0xcb, (byte)0xbc, (byte)0xb1, 0x68, 0x76,
  (byte)0xa4 };
str = "!b\u0007v=\ufffdB\u7912\u623f\ufffdhv\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x85, (byte)0x90, (byte)0xaa, 0x0f, 0x7c, 0x4c,
  (byte)0xdc, (byte)0xde, (byte)0xce, 0x70, (byte)0xbb, 0x5b };
str = "\ufffd\ufffd\ufffd\u000f|L\u6b0a\ufffdp\ufffd[";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x08, (byte)0x95, (byte)0xda, 0x48, (byte)0xff, 0x54,
  0x41, 0x1c, 0x68, 0x3c, 0x25, 0x55, 0x2c, (byte)0xb9, 0x23, 0x47,
  (byte)0xb9, 0x71 };
str = "\u0008\ufffd\ufffdH\ufffdTA\u001ch<%U\u002c\ufffd#G\ufffdq";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4d, (byte)0xf0, 0x34, (byte)0x99, 0x3c, 0x44,
  (byte)0xa5, 0x58, (byte)0x93, (byte)0xd9, 0x29, (byte)0xd7, 0x70, 0x40,
  (byte)0xa4, 0x45, 0x50, 0x32, (byte)0x9f, (byte)0x99, (byte)0x97, 0x7a,
  (byte)0x94, (byte)0xa8, (byte)0xa6, (byte)0x9d, (byte)0x8d };
str =

  "M\ufffd4\ufffd<D\ufffdX\ufffd\ufffd)\ufffdp@\ufffdEP2\ufffd\ufffd\ufffdz\ufffd\u2514\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa2, (byte)0x80, 0x29, (byte)0xbe, 0x7a,
  (byte)0xae, 0x41, (byte)0xe4, 0x11, 0x4e, (byte)0xff, (byte)0xbc, 0x3a,
  0x23, (byte)0xff, 0x22, (byte)0x9f, (byte)0xec, 0x0f };
str =
  "\ufffd)\ufffdz\ufffdA\ufffd\u0011N\ufffd\ufffd:#\ufffd\"\ufffd\ufffd\u000f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xff, 0x79, (byte)0xb3, 0x32, 0x2e, 0x22,
  (byte)0xd3 };
str = "\ufffdy\ufffd2.\"\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x02, (byte)0xa2, (byte)0x8f, 0x2e, (byte)0x8e,
  (byte)0x81, 0x5a, 0x71, 0x70, (byte)0xd3, (byte)0xcb, (byte)0xc3 };
str = "\u0002\ufffd.\ufffdZqp\u55da\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe2, 0x50, 0x39, 0x05, 0x08, 0x2d, 0x2e, 0x4e,
  0x0b, 0x0f, 0x6a, 0x54, 0x37, (byte)0xd1, 0x2b, 0x33, (byte)0xcd,
  (byte)0xf8, 0x6e, (byte)0xfa, 0x25, (byte)0xfa, (byte)0xf5, (byte)0xf3,
  0x2d, (byte)0xdb, (byte)0xa3 };
str =

  "\ufffdP9\u0005\u0008-.N\u000b\u000fjT7\ufffd+3\u5229n\ufffd%\u70ab\ufffd-\u66d6";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xed, 0x5d, 0x15, 0x51, 0x0d, (byte)0xc1,
  (byte)0xa7, (byte)0xcc };
str = "\ufffd]\u0015Q\u000d\u8a6e\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x17, (byte)0xe7, (byte)0x9a, 0x74, 0x65, (byte)0xb2,
  0x29, (byte)0xad, (byte)0xac, 0x11 };
str = "\u0017\ufffdte\ufffd)\u246b\u0011";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x04 };
str = "\u0004";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x37 };
str = "7";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x39, (byte)0xe9, 0x66, 0x3d, 0x04, 0x3e, 0x77,
  (byte)0xcd, 0x70, (byte)0xa6, (byte)0xa0, 0x5e };
str = "9\ufffdf=\u0004>w\ufffdp\ufffd^";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x56, (byte)0x94, 0x0b, 0x48, 0x2c, (byte)0xc0, 0x32,
  (byte)0xcc, (byte)0xc4, 0x7a, 0x48, (byte)0x89, 0x69, (byte)0xa1,
  (byte)0x81, (byte)0xb3, (byte)0xa3, (byte)0x9d, (byte)0x99, 0x58,
  (byte)0xcb, (byte)0xd0, (byte)0xdf, (byte)0x89 };
str =

  "V\ufffd\u000bH\u002c\ufffd2\u9cf4zH\ufffdi\ufffd\u68b0\ufffd\ufffdX\u64b2\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8c, (byte)0xe3, (byte)0xf1, 0x75, 0x2d, 0x76,
  0x7b, (byte)0xb7 };
str = "\ufffd\u7aedu-v\u007b\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x70 };
str = "p";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcb, 0x6e, 0x3a, 0x3c, (byte)0xe0, 0x77,
  (byte)0xfa };
str = "\ufffdn:<\ufffdw\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x24, 0x27, (byte)0xa5, 0x1f, (byte)0x8b, 0x74, 0x5b,
  0x66, 0x69, (byte)0xaf, 0x30, 0x50, (byte)0xa0, 0x49, (byte)0xaa,
  (byte)0xfa, 0x33, 0x1e, 0x37, 0x20, (byte)0xbc, 0x32, 0x1f, 0x1c, 0x71,
  (byte)0xfa, (byte)0xf3 };
str =

  "$'\ufffd\u001f\ufffdt[fi\ufffd0P\ufffdI\ufffd3\u001e7 \ufffd2\u001f\u001cq\u7028";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa1, (byte)0xfd, 0x1b, 0x63, 0x65, 0x57,
  (byte)0x87, 0x3d, 0x2a, (byte)0xee, 0x73, 0x7e, 0x6f, 0x3d, (byte)0xb3,
  0x6b, 0x38, 0x3f, 0x6a, 0x4b };
str = "\u25ce\u001bceW\ufffd=*\ufffds~o=\ufffdk8?jK";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x48, 0x5e, (byte)0xb7, (byte)0xd7, 0x3f, (byte)0xd5,
  0x4a, 0x60 };
str = "H^\u8a08?\ufffdJ`";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x57, (byte)0x90, 0x24, (byte)0xbd, (byte)0xaa,
  (byte)0xc6, (byte)0xf3, (byte)0x90 };
str = "W\ufffd$\u7d42\u4e8c\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe4, 0x6c, 0x5d, 0x45, (byte)0xa3, 0x4c, 0x31,
  (byte)0xf6, (byte)0xbe, (byte)0xff, (byte)0xe2, 0x5a, (byte)0xe1,
  (byte)0xbe, 0x4f, 0x30, 0x48, 0x44, (byte)0xc0, (byte)0xee, (byte)0xc4,
  (byte)0xbf, 0x53, 0x3c, 0x50, 0x39 };
str = "\ufffdl]E\ufffdL1\ufffd\ufffd\ufffdZ\u7569O0HD\u5ddd\u6715S<P9";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xae, 0x34, (byte)0xfc, 0x01, 0x41, 0x2c, 0x70,
  0x79, 0x26, 0x04, 0x76, 0x28, 0x75, 0x66, (byte)0xbb, 0x21 };
str = "\ufffd4\ufffd\u0001A\u002cpy&\u0004v(uf\ufffd!";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x21, 0x39, 0x24, (byte)0x9a, 0x73, 0x10, 0x71,
  (byte)0x81, 0x73, (byte)0xc3, (byte)0xbd, 0x5c };
str = "!9$\ufffds\u0010q\ufffds\u7baa\\";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x46, 0x3c };
str = "F<";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa4, (byte)0xa6, 0x3d, 0x3e, (byte)0xfa, 0x66,
  0x74, (byte)0xcd, (byte)0x8d, (byte)0xb7, 0x19, (byte)0xba, 0x4f, 0x69,
  (byte)0xeb, 0x3f, 0x68, (byte)0x84, 0x35, (byte)0xa9, 0x4c, (byte)0x85,
  (byte)0x84, 0x4a, 0x1c, (byte)0xaf, 0x04, 0x18, 0x77 };
str =

  "\u3046=>\ufffdft\ufffd\ufffd\u0019\ufffdOi\ufffd?h\ufffd5\ufffdL\ufffd\ufffdJ\u001c\ufffd\u0004\u0018w";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x34, (byte)0xf4, (byte)0x8b, (byte)0xee, (byte)0xe1,
  0x25, 0x2a, 0x6b, 0x3d, (byte)0xc9 };
str = "4\ufffd\u91f6%*k=\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x06, 0x09, (byte)0xaa, 0x14, 0x50, 0x52, (byte)0xd4,
  0x1f };
str = "\u0006\u0009\ufffd\u0014PR\ufffd\u001f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x74, 0x73, 0x4b, (byte)0x92, (byte)0xb0, 0x5c, 0x76,
  0x43, 0x39, (byte)0xef, 0x10, (byte)0xf5, 0x6f, (byte)0xde, 0x3b,
  (byte)0x98, 0x57, 0x19, 0x09, 0x37, (byte)0xb2, 0x3e };
str =
  "tsK\ufffd\ufffd\\vC9\ufffd\u0010\ufffdo\ufffd;\ufffdW\u0019\u00097\ufffd>";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7f, (byte)0xee, (byte)0x92, 0x34, (byte)0xf8, 0x5e,
  0x1b, 0x4f, 0x5f, 0x2c, 0x09, 0x4c, 0x1e, (byte)0x9b, (byte)0xaa,
  (byte)0xdb };
str = "\u007f\ufffd4\ufffd^\u001bO_\u002c\u0009L\u001e\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc7, 0x4a, (byte)0xea, 0x27, 0x0a, 0x37, 0x63,
  0x46, 0x49, 0x5f, 0x56, (byte)0xec, 0x1c, 0x56, (byte)0x94, 0x05, 0x44,
  (byte)0xa5, (byte)0xb7 };
str = "\ufffdJ\ufffd'\u000a7cFI_V\ufffd\u001cV\ufffd\u0005D\u30b7";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3e, (byte)0x9c, 0x4a, 0x5f, (byte)0xcd, (byte)0xef,
  (byte)0xe3, 0x65, (byte)0xe2 };
str = ">\ufffdJ_\u916a\ufffde\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x54, (byte)0xc8, (byte)0x90, 0x1a, 0x17, 0x72,
  (byte)0xd1, (byte)0xaa, 0x21, (byte)0x8d, 0x76, 0x3b, 0x23, 0x4c,
  (byte)0xf2, (byte)0xac, (byte)0x80, 0x26, 0x4b, 0x4c, (byte)0xa2, 0x23 };
str = "T\ufffd\u001a\u0017r\u50ee!\ufffdv;#L\u9b2a\ufffd&KL\ufffd#";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x11, 0x32, 0x56, 0x2d, 0x43, (byte)0x99, (byte)0x81,
  (byte)0xe2, 0x02, 0x42, 0x33, (byte)0x95, 0x71, 0x15, (byte)0x87, 0x68,
  0x45, 0x40 };
str = "\u00112V-C\ufffd\ufffd\ufffd\u0002B3\ufffdq\u0015\ufffdhE@";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4f, 0x60, (byte)0xe5, (byte)0xd3, (byte)0x8b, 0x26,
  0x02, 0x6b, (byte)0x8b, 0x38, 0x29, (byte)0x97, 0x31, 0x56, 0x5d, 0x52,
  (byte)0xc8, 0x4c };
str = "O`\u7e12\ufffd&\u0002k\ufffd8)\ufffd1V]R\ufffdL";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5c, (byte)0xf1, 0x6e };
str = "\\\ufffdn";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x79, 0x5f, 0x3b };
str = "y_;";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x35, (byte)0x9e, 0x65, 0x32, 0x70, 0x0d, 0x44, 0x5d,
  0x3d, 0x10 };
str = "5\ufffde2p\u000dD]=\u0010";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7d, 0x5f, (byte)0xa5 };
str = "}_\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5c, (byte)0xd2, 0x4f, 0x4c, 0x5c, 0x58, 0x7f, 0x3a,
  (byte)0xc7, 0x2b, 0x3f, (byte)0xce, 0x54, (byte)0xca, 0x3c, (byte)0xd0,
  0x48, (byte)0xd6, 0x40, (byte)0xe7, 0x49, 0x27 };
str = "\\\ufffdOL\\X\u007f:\ufffd+?\ufffdT\ufffd<\ufffdH\ufffd@\ufffdI'";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf0, (byte)0xe9, 0x37, 0x1a, 0x0b, (byte)0x86,
  0x0a, 0x2d, (byte)0xc7, 0x0e, (byte)0xac, 0x26, 0x3e, 0x07, 0x51, 0x43,
  0x15, 0x6c, 0x66, (byte)0xd6, 0x04, 0x19, (byte)0x87, 0x61, 0x40, 0x44,
  0x26, 0x6d, (byte)0xbe };
str =

  "\u97c87\u001a\u000b\ufffd\u000a-\ufffd\u000e\ufffd&>\u0007QC\u0015lf\ufffd\u0004\u0019\ufffda@D&m\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xda, (byte)0xd3, 0x67, 0x32, (byte)0xd1,
  (byte)0x96, (byte)0xff, (byte)0xf2, (byte)0xaa, 0x56, 0x06, 0x67 };
str = "\u65c3g2\ufffd\ufffd\u9b28V\u0006g";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xea, (byte)0x84, 0x3e, 0x36, (byte)0xda,
  (byte)0x9a, (byte)0xd7, 0x45, 0x02, 0x6f, (byte)0xdf };
str = "\ufffd>6\ufffd\ufffdE\u0002o\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x03, (byte)0x86, 0x7c, 0x3a, (byte)0xb1, (byte)0xe0,
  0x01, (byte)0x80, 0x4e, (byte)0x97, (byte)0xce, 0x33, (byte)0xcd,
  (byte)0xaa, 0x77 };
str = "\u0003\ufffd|:\u5712\u0001\ufffdN\ufffd\ufffd3\u60a0w";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x07, 0x35, 0x31, 0x40, 0x51, 0x6c, (byte)0x8a,
  (byte)0x93, 0x6d, 0x33, 0x69, 0x2d, (byte)0xf4, 0x42, 0x21, (byte)0x96,
  0x68, 0x05, (byte)0xfa, (byte)0xd6, (byte)0x9b, 0x2b, (byte)0xf0, 0x46,
  (byte)0xdf, 0x14, (byte)0xcf, (byte)0xb3, 0x2c };
str =

  "\u000751@Ql\ufffd\ufffdm3i-\ufffdB!\ufffdh\u0005\u6a73\ufffd+\ufffdF\ufffd\u0014\u6f0f\u002c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44, 0x52, 0x3b, 0x0f, 0x23, 0x40, (byte)0x82,
  (byte)0x85, 0x62, 0x12, 0x63, (byte)0xe2, 0x46, (byte)0xb0, (byte)0xe9,
  0x7c, (byte)0xd9, (byte)0xa0, (byte)0x87, 0x1d, 0x3a };
str = "DR;\u000f#@\ufffd\ufffdb\u0012c\ufffdF\u80b2|\ufffd\ufffd\u001d:";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb9, 0x56, (byte)0xc1, 0x37, (byte)0xe2, 0x16,
  0x55, (byte)0x84, (byte)0xff, 0x48, 0x59, 0x78, 0x4a, 0x57, (byte)0xe5,
  0x44, (byte)0xfa, 0x20, 0x0f, 0x6b, (byte)0xa5 };
str = "\ufffdV\ufffd7\ufffd\u0016U\ufffd\ufffdHYxJW\ufffdD\ufffd \u000fk\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x24, 0x14 };
str = "$\u0014";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x32, 0x70, 0x61, (byte)0xb1, 0x36, 0x16, 0x3a };
str = "2pa\ufffd6\u0016:";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x17, (byte)0xf2, (byte)0xbb, 0x42, 0x00, 0x09,
  (byte)0xa2, 0x10, 0x1e, (byte)0x99, 0x1b, (byte)0x9f, (byte)0xb2, 0x45,
  0x7a, 0x66, 0x61 };
str = "\u0017\u9b96B\u0000\u0009\ufffd\u0010\u001e\ufffd\u001b\ufffd\ufffdEzfa";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb5, 0x6a, 0x43, 0x0d, 0x70, 0x16, (byte)0x92,
  0x5f, (byte)0xe2, 0x71, 0x5d, (byte)0xfe, 0x7f, (byte)0xc7, (byte)0x87,
  0x4e, (byte)0xf1, 0x5b, 0x35, 0x45, (byte)0xaa, (byte)0x8f, (byte)0xed,
  (byte)0x81, 0x1a, 0x41, 0x53 };
str =

  "\ufffdjC\u000dp\u0016\ufffd_\ufffdq]\ufffd\u007f\ufffdN\ufffd[5E\ufffd\ufffd\u001aAS";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x06, (byte)0xd8, 0x53, 0x0b, 0x6a, (byte)0xfc,
  (byte)0xbb, 0x71, (byte)0xd9, (byte)0x8e, (byte)0xda, 0x53, 0x0b,
  (byte)0xee, (byte)0xee, 0x18, 0x5d, 0x79, 0x5b };
str = "\u0006\ufffdS\u000bj\u92e0q\ufffd\ufffdS\u000b\u9295\u0018]y[";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43, 0x71, (byte)0xa5, 0x23, 0x43, 0x3d, 0x74 };
str = "Cq\ufffd#C=t";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8a, 0x4b, (byte)0x9b };
str = "\ufffdK\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x87, (byte)0x94, 0x5f, 0x7c, (byte)0xec, 0x5c,
  0x53, 0x50, (byte)0xa5, (byte)0xed, 0x43 };
str = "\ufffd\ufffd_|\ufffd\\SP\u30edC";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x29, 0x02, (byte)0xfb, 0x75, 0x51, (byte)0xed, 0x54,
  0x54, (byte)0xf2, 0x4a, 0x0e, 0x0a, 0x39, 0x7b, (byte)0xb3, (byte)0x9a,
  0x56, 0x5b };
str = ")\u0002\ufffduQ\ufffdTT\ufffdJ\u000e\u000a9\u007b\ufffdV[";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44, (byte)0xf2, (byte)0xcd, 0x29, 0x4f, 0x31,
  (byte)0xc3, 0x04, 0x24, 0x45, (byte)0xec, (byte)0xb1, (byte)0xcc,
  (byte)0x81, (byte)0xe4, 0x20, (byte)0xb7, 0x77, (byte)0xbd, (byte)0x84,
  0x3d, (byte)0xab, (byte)0xa7, (byte)0xf6, 0x67, 0x09, (byte)0x93, 0x5b,
  (byte)0xff };
str =

  "D\u9c3a)O1\ufffd\u0004$E\u8c48\ufffd\ufffd \ufffdw\ufffd=\ufffd\ufffdg\u0009\ufffd[\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc6, (byte)0x93, 0x0e, 0x46, 0x21, 0x63, 0x27,
  0x67, 0x79 };
str = "\ufffd\u000eF!c'gy";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4a, (byte)0x98, (byte)0xe0 };
str = "J\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x39, 0x6f, 0x6b, 0x18, (byte)0xd3, (byte)0xba,
  (byte)0xc9, 0x25, 0x65, 0x73, (byte)0x81, 0x66, 0x31, 0x7a, 0x35, 0x24,
  (byte)0xb3, (byte)0xe0, 0x33, (byte)0xf2, (byte)0x9c, (byte)0xf9, 0x33,
  (byte)0xdd, 0x22, (byte)0x8b, 0x3e, (byte)0xef, (byte)0x84, 0x1f };
str =

  "9ok\u0018\u5533\ufffd%es\ufffdf1z5$\u6a7f3\ufffd\ufffd3\ufffd\"\ufffd>\ufffd\u001f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x59, (byte)0xae, 0x51, 0x5d, (byte)0xba, (byte)0x92,
  0x58, (byte)0x92 };
str = "Y\ufffdQ]\ufffdX\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x14, 0x7b, 0x5c, 0x14, (byte)0xf2, (byte)0xde, 0x43,
  0x3c, 0x51, (byte)0xcd, 0x0d, (byte)0xe8, 0x6f, 0x38, 0x06, 0x31, 0x2a,
  0x52, (byte)0x9b, 0x43, 0x72, (byte)0xad };
str =
  "\u0014\u007b\\\u0014\u9c24C<Q\ufffd\u000d\ufffdo8\u00061*R\ufffdCr\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb1, (byte)0xdd, (byte)0x98, 0x77, (byte)0xa5,
  0x60, 0x4d, (byte)0xd9, 0x75, 0x1d, 0x7e, 0x70, 0x4f };
str = "\u698e\ufffdw\ufffd`M\ufffdu\u001d~pO";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x33, 0x2b, 0x67, (byte)0xe9, (byte)0xe0, (byte)0xeb,
  (byte)0xc8, 0x26, 0x56, 0x1e, 0x60, 0x67, 0x45, 0x37, 0x6c };
str = "3+g\u86df\u8a52&V\u001e`gE7l";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x22, 0x53, 0x37, (byte)0xc1, (byte)0xaa, 0x19, 0x48,
  (byte)0xbe, (byte)0xda, 0x72, 0x4f, 0x3c, (byte)0xfc, (byte)0x94,
  (byte)0xca, 0x7a, (byte)0xac, 0x74, (byte)0xca, 0x7b, (byte)0xc3, 0x5d,
  0x6e, (byte)0xc8, 0x34, 0x36, 0x24, 0x1f, (byte)0xd4, (byte)0xeb };
str =

  "\"S7\u9078\u0019H\u8a3crO<\ufffd\ufffdz\ufffdt\ufffd\u007b\ufffd]n\ufffd46$\u001f\u5910";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbc, 0x5c, 0x07, (byte)0x87, (byte)0xbf,
  (byte)0xc5, 0x51, (byte)0xe0, 0x18, 0x21 };
str = "\ufffd\\\u0007\ufffd\u85aaQ\ufffd\u0018!";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x21, 0x6f, (byte)0xb2, 0x13, 0x71, 0x72, 0x49, 0x05,
  (byte)0xb7, (byte)0xb5, 0x26, (byte)0xb0, 0x5b, 0x33 };
str = "!o\ufffd\u0013qrI\u0005\u5366&\ufffd[3";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x68, 0x45, (byte)0xf4, (byte)0xf6, 0x53, 0x6a,
  (byte)0xab, 0x0d };
str = "hE\ufffdSj\ufffd\u000d";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb1, (byte)0xd7, 0x4f, 0x12 };
str = "\u76caO\u0012";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbd, 0x1f, (byte)0xec, 0x5c, (byte)0xf0, 0x46,
  0x77, (byte)0xba, (byte)0xdc, 0x7a, (byte)0xfc, (byte)0x82 };
str = "\ufffd\u001f\ufffd\\\ufffdFw\u8f09z\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x53, 0x32, (byte)0x8e, 0x43, 0x58, 0x00, 0x3e,
  (byte)0xd7, 0x03, (byte)0x85, (byte)0xc2, 0x35, (byte)0xa8, (byte)0x9f,
  0x17, (byte)0xd7, (byte)0xde, 0x3e, (byte)0xa6, 0x4f, 0x11, (byte)0x86,
  0x15, (byte)0xc9, (byte)0xef, 0x72, 0x08, (byte)0xf4, (byte)0xfa };
str =

  "S2\ufffdCX\u0000>\ufffd\u0003\ufffd\ufffd5\ufffd\u0017\u6021>\ufffdO\u0011\ufffd\u0015\u64abr\u0008\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x07, 0x7b, (byte)0xfb, 0x54, 0x6a, 0x78, (byte)0xaa,
  (byte)0x9f, (byte)0x95, (byte)0xdb, 0x78, (byte)0xa2, 0x33, (byte)0xc5,
  0x51, 0x51, (byte)0x85, (byte)0xee, (byte)0xe7, (byte)0xe0, 0x01, 0x6d };
str =

  "\u0007\u007b\ufffdTjx\ufffd\ufffd\ufffdx\ufffd3\ufffdQQ\ufffd\u9211\ufffd\u0001m";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x29, 0x2f, (byte)0x90, (byte)0x8e, 0x14, 0x27,
  (byte)0x86, (byte)0xb4, 0x2d, 0x54, 0x0a, 0x09, 0x02, 0x60, 0x28,
  (byte)0xe3, (byte)0xd9, 0x57, (byte)0xa1, 0x04, 0x54, 0x4b, 0x36, 0x74 };
str =

  ")/\ufffd\ufffd\u0014'\ufffd\ufffd-T\u000a\u0009\u0002`(\u7a97W\ufffd\u0004TK6t";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xab, 0x3e };
str = "\ufffd>";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xff, 0x64, (byte)0x9e, 0x62 };
str = "\ufffdd\ufffdb";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd5, 0x28, (byte)0x9a, 0x20, (byte)0x8b };
str = "\ufffd(\ufffd \ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0f, (byte)0xaf };
str = "\u000f\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x45, (byte)0xb0, 0x3a };
str = "E\ufffd:";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x63, 0x4e, 0x76, 0x64, 0x4c };
str = "cNvdL";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1e, 0x45, 0x27, 0x57, (byte)0xc0, 0x0e, 0x66,
  (byte)0xfe, (byte)0xdd, (byte)0xbd, 0x0f, 0x6e, (byte)0x85, (byte)0xae,
  (byte)0xf6, 0x11, 0x44, (byte)0xc0, (byte)0xf6, 0x4c, (byte)0xb5, 0x5d,
  (byte)0xbd, 0x15, (byte)0xbe, 0x47, 0x38, (byte)0xa1, (byte)0xa5 };
str =

  "\u001eE'W\ufffd\u000ef\ufffd\ufffd\u000fn\ufffd\ufffd\u0011D\u6d17L\ufffd]\ufffd\u0015\ufffdG8\uff0e";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe3, 0x08, (byte)0xf8, (byte)0x85, 0x52,
  (byte)0xba, 0x28, 0x7a, 0x32, 0x20, 0x41, 0x4f, 0x0a, (byte)0xc6, 0x77,
  (byte)0xfe };
str = "\ufffd\u0008\ufffdR\ufffd(z2 AO\u000a\ufffdw\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2f, (byte)0xa8, 0x65, 0x67, (byte)0xa9, (byte)0xa2,
  (byte)0x8b, (byte)0xb4, (byte)0xce, (byte)0xfd, 0x6a, 0x2f, (byte)0xea,
  0x42 };
str = "/\ufffdeg\ufffd\ufffd\u809d\ufffdj/\ufffdB";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfe, 0x5b, 0x18, 0x56, 0x19, (byte)0xff, 0x5f,
  (byte)0xb1 };
str = "\ufffd[\u0018V\u0019\ufffd_\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3f, (byte)0xb4, (byte)0xc4 };
str = "?\u74b0";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9d, 0x7e, (byte)0xc7, (byte)0x99, (byte)0xcf,
  (byte)0xaf, 0x21, (byte)0x9e, 0x67, (byte)0x88, (byte)0xd6, (byte)0xe3,
  0x08, 0x56, 0x78, 0x78, 0x39, (byte)0x94, 0x63, (byte)0xdd, 0x74,
  (byte)0x92 };
str = "\ufffd~\ufffd\u6717!\ufffdg\ufffd\u5e0b\u0008Vxx9\ufffdc\ufffdt\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa2, 0x18, 0x2b, 0x76, (byte)0xd1, (byte)0xa7,
  (byte)0xf2, 0x6d, 0x35, 0x4f, (byte)0x99, (byte)0xc0, (byte)0xc9, 0x0d,
  0x22, (byte)0xd6, 0x3e, 0x25 };
str = "\ufffd\u0018+v\u50e5\ufffdm5O\ufffd\u96bb\u000d\"\ufffd>%";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x78, 0x50, (byte)0xe8, (byte)0xdf, (byte)0xc9, 0x3e,
  (byte)0xf5, (byte)0xb8, (byte)0xfa, (byte)0xae, 0x7a, (byte)0xad,
  (byte)0xad, 0x76, 0x76, (byte)0x90, (byte)0x94, 0x26, (byte)0x95,
  (byte)0xc1, (byte)0x8d, (byte)0xa4 };
str = "xP\u842c\ufffd>\ufffd\u62a6z\u246cvv\ufffd\ufffd&\ufffd\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x86, 0x7c, (byte)0x9c, 0x10, 0x52, (byte)0xd5,
  (byte)0xaf, (byte)0xe7, (byte)0x95, (byte)0xe1, (byte)0xd9, 0x2f, 0x25,
  (byte)0xb5, 0x75, 0x52, 0x72, 0x7a, 0x5f, 0x2a, 0x74 };
str = "\ufffd|\ufffd\u0010R\u5a1f\ufffd\u75ca/%\ufffduRrz_*t";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x27, 0x1e, (byte)0xf8, 0x7f };
str = "'\u001e\ufffd\u007f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x12, 0x60, 0x03, 0x57, 0x5d, 0x71, 0x11, 0x0d, 0x46,
  0x43, (byte)0xcd, (byte)0x96, (byte)0xfe, (byte)0x99, (byte)0xde, 0x33 };
str = "\u0012`\u0003W]q\u0011\u000dFC\ufffd\ufffd\ufffd3";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd7, (byte)0xcd, 0x47, 0x23, 0x4d, 0x19,
  (byte)0xa7, (byte)0xc7, (byte)0x80, 0x30, (byte)0x96, (byte)0x92, 0x32,
  0x2c, 0x19, (byte)0xb8, 0x71, (byte)0xaa, 0x12, (byte)0x80, (byte)0xe9,
  (byte)0xf8, (byte)0xb1, (byte)0x83, 0x62 };
str =

  "\u5f91G#M\u0019\ufffd\ufffd0\ufffd\ufffd2\u002c\u0019\ufffdq\ufffd\u0012\ufffd\u874c\ufffdb";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44, 0x3f, (byte)0xd3, (byte)0xc8, (byte)0xc6,
  (byte)0x91, 0x4c, 0x41, 0x2a, (byte)0xfe, 0x61, (byte)0xd6, 0x02, 0x51,
  (byte)0xef, 0x2b, 0x13, (byte)0xc4, 0x10, (byte)0xa9, (byte)0xe6 };
str = "D?\u55a9\ufffdLA*\ufffda\ufffd\u0002Q\ufffd+\u0013\ufffd\u0010\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
}
@Test
public void TestEucJPEncoder() {
byte[] bytes;
String str;
ICharacterEncoding charset = Encodings.GetEncoding("euc-jp");
str = "\uff9f\uff4a";
bytes = new byte[] { (byte)0x8e, (byte)0xdf, (byte)0xa3, (byte)0xea };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5ffb";
bytes = new byte[] { (byte)0xd7, (byte)0xd7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6838";
bytes = new byte[] { (byte)0xb3, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff8f\u67a2\uff29";
bytes = new byte[] { (byte)0x8e, (byte)0xcf, (byte)0xbf, (byte)0xf5,
  (byte)0xa3, (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff98\u72d7\u90ed";
bytes = new byte[] { (byte)0x8e, (byte)0xd8, (byte)0xb6, (byte)0xe9,
  (byte)0xb3, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff44\u5be6\uff7e";
bytes = new byte[] { (byte)0xa3, (byte)0xe4, (byte)0xd5, (byte)0xe9,
  (byte)0x8e, (byte)0xbe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u58a8";
bytes = new byte[] { (byte)0xcb, (byte)0xcf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9913\u5e96\u6127";
bytes = new byte[] { (byte)0xb2, (byte)0xee, (byte)0xca, (byte)0xf9,
  (byte)0xd8, (byte)0xc3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2a\u663c\u7d75";
bytes = new byte[] { (byte)0xa3, (byte)0xca, (byte)0xc3, (byte)0xeb,
  (byte)0xb3, (byte)0xa8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6b\uff76\uff2a";
bytes = new byte[] { (byte)0x8e, (byte)0xab, (byte)0x8e, (byte)0xb6,
  (byte)0xa3, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff39\u246b\u5f25";
bytes = new byte[] { (byte)0xa3, (byte)0xd9, (byte)0xad, (byte)0xac,
  (byte)0xcc, (byte)0xef };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u653f\u25a0\uff9e\uff20";
bytes = new byte[] { (byte)0xc0, (byte)0xaf, (byte)0xa2, (byte)0xa3,
  (byte)0x8e, (byte)0xde, (byte)0xa1, (byte)0xf7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff26\uff94\uff2b";
bytes = new byte[] { (byte)0xa3, (byte)0xc6, (byte)0x8e, (byte)0xd4,
  (byte)0xa3, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u4f34";
bytes = new byte[] { (byte)0xc8, (byte)0xbc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff89\uff04\u5b75\uff71";
bytes = new byte[] { (byte)0x8e, (byte)0xc9, (byte)0xa1, (byte)0xf0,
  (byte)0xd5, (byte)0xdb, (byte)0x8e, (byte)0xb1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u715c";
bytes = new byte[] { (byte)0xfa, (byte)0xf8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5c3b\uff45\u7a4f";
bytes = new byte[] { (byte)0xbf, (byte)0xac, (byte)0xa3, (byte)0xe5,
  (byte)0xb2, (byte)0xba };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff7c\u6c82\uff19";
bytes = new byte[] { (byte)0x8e, (byte)0xbc, (byte)0xdd, (byte)0xeb,
  (byte)0xa3, (byte)0xb9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u67d8\u5e72";
bytes = new byte[] { (byte)0xc4, (byte)0xd3, (byte)0xb4, (byte)0xb3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6a02\u71fe\u60e0\uff1b";
bytes = new byte[] { (byte)0xdc, (byte)0xdb, (byte)0xfa, (byte)0xfd,
  (byte)0xd8, (byte)0xaa, (byte)0xa1, (byte)0xa8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "3\uff74\u898f";
bytes = new byte[] { 0x33, (byte)0x8e, (byte)0xb4, (byte)0xb5, (byte)0xac };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff33\u5306";
bytes = new byte[] { (byte)0xa3, (byte)0xd3, (byte)0xd2, (byte)0xb2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6731\uff9d\uff76";
bytes = new byte[] { (byte)0xbc, (byte)0xeb, (byte)0x8e, (byte)0xdd,
  (byte)0x8e, (byte)0xb6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7f36\uff05\uff58\u5339";
bytes = new byte[] { (byte)0xb4, (byte)0xcc, (byte)0xa1, (byte)0xf3,
  (byte)0xa3, (byte)0xf8, (byte)0xc9, (byte)0xa4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff64\u64ce\uff7f";
bytes = new byte[] { (byte)0x8e, (byte)0xa4, (byte)0xfa, (byte)0xb2,
  (byte)0x8e, (byte)0xbf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "7\u68d7\u6171";
bytes = new byte[] { 0x37, (byte)0xdc, (byte)0xa7, (byte)0xd8, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1f\uff8f";
bytes = new byte[] { (byte)0xa1, (byte)0xa9, (byte)0x8e, (byte)0xcf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u529b\u2234\u62f7";
bytes = new byte[] { (byte)0xce, (byte)0xcf, (byte)0xa1, (byte)0xe8,
  (byte)0xb9, (byte)0xe9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2d\u5ef1";
bytes = new byte[] { (byte)0xa3, (byte)0xcd, (byte)0xd7, (byte)0xab };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3a\u7953\u2260";
bytes = new byte[] { (byte)0xa3, (byte)0xda, (byte)0xe3, (byte)0xb1,
  (byte)0xa1, (byte)0xe2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6e2b\uff12";
bytes = new byte[] { (byte)0xde, (byte)0xd8, (byte)0xa3, (byte)0xb2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u639f\u6070\u7e93";
bytes = new byte[] { (byte)0xd9, (byte)0xdd, (byte)0xb3, (byte)0xe6,
  (byte)0xe5, (byte)0xf7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff34\uff3e\u66f7\u50be";
bytes = new byte[] { (byte)0xa3, (byte)0xd4, (byte)0xa1, (byte)0xb0,
  (byte)0xdb, (byte)0xab, (byte)0xb7, (byte)0xb9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6213\uff99\uff37";
bytes = new byte[] { (byte)0xfa, (byte)0xad, (byte)0x8e, (byte)0xd9,
  (byte)0xa3, (byte)0xd7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2b\uff56\uffe3";
bytes = new byte[] { (byte)0xa3, (byte)0xcb, (byte)0xa3, (byte)0xf6,
  (byte)0xa1, (byte)0xb1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6c";
bytes = new byte[] { (byte)0x8e, (byte)0xac };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff96\uff13\u711a";
bytes = new byte[] { (byte)0x8e, (byte)0xd6, (byte)0xa3, (byte)0xb3,
  (byte)0xca, (byte)0xb2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u64ab\u6854\u7b8d";
bytes = new byte[] { (byte)0xc9, (byte)0xef, (byte)0xb5, (byte)0xcb,
  (byte)0xe4, (byte)0xb2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff59\u51f6\u608b";
bytes = new byte[] { (byte)0xa3, (byte)0xf9, (byte)0xb6, (byte)0xa7,
  (byte)0xd8, (byte)0xa7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7ca5\u7a1c\u7e22";
bytes = new byte[] { (byte)0xb4, (byte)0xa1, (byte)0xce, (byte)0xc7,
  (byte)0xe5, (byte)0xd8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff01\uff34H";
bytes = new byte[] { (byte)0xa1, (byte)0xaa, (byte)0xa3, (byte)0xd4, 0x48 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff95\u6597";
bytes = new byte[] { (byte)0x8e, (byte)0xd5, (byte)0xc5, (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff26\uff71\u5d16\uffe0";
bytes = new byte[] { (byte)0xa3, (byte)0xc6, (byte)0x8e, (byte)0xb1,
  (byte)0xb3, (byte)0xb3, (byte)0xa1, (byte)0xf1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2520";
bytes = new byte[] { (byte)0xa8, (byte)0xb7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u63ab\u5b3e\uff33";
bytes = new byte[] { (byte)0xd9, (byte)0xd8, (byte)0xd5, (byte)0xcf,
  (byte)0xa3, (byte)0xd3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff57";
bytes = new byte[] { (byte)0xa3, (byte)0xf7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6c1b\u5370";
bytes = new byte[] { (byte)0xdd, (byte)0xe4, (byte)0xb0, (byte)0xf5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff37\u64a5\uff6e\u625b\u755c";
bytes = new byte[] { (byte)0xa3, (byte)0xd7, (byte)0xd9, (byte)0xfb,
  (byte)0x8e, (byte)0xae, (byte)0xd9, (byte)0xac, (byte)0xc3, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff8d\u66fe\u67a6\uff43";
bytes = new byte[] { (byte)0x8e, (byte)0xcd, (byte)0xc1, (byte)0xbd,
  (byte)0xdb, (byte)0xc5, (byte)0xa3, (byte)0xe3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e9c\uff68\u66da";
bytes = new byte[] { (byte)0xe5, (byte)0xfc, (byte)0x8e, (byte)0xa8,
  (byte)0xdb, (byte)0xa4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe3\u0413\u7ce2";
bytes = new byte[] { (byte)0xa1, (byte)0xb1, (byte)0xa7, (byte)0xa4,
  (byte)0xe4, (byte)0xf7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7f78\u9249\u52a6";
bytes = new byte[] { (byte)0xe6, (byte)0xaf, (byte)0xee, (byte)0xeb,
  (byte)0xf9, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6153\u5cb3\uff0b";
bytes = new byte[] { (byte)0xd8, (byte)0xd8, (byte)0xb3, (byte)0xd9,
  (byte)0xa1, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5e";
bytes = new byte[] { (byte)0xa1, (byte)0xc1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u74f1\uff7f";
bytes = new byte[] { (byte)0xe1, (byte)0xa8, (byte)0x8e, (byte)0xbf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7f54";
bytes = new byte[] { (byte)0xe6, (byte)0xa8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff52\uff3a";
bytes = new byte[] { (byte)0xa3, (byte)0xf2, (byte)0xa3, (byte)0xda };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff7a\u731f\uff24";
bytes = new byte[] { (byte)0x8e, (byte)0xba, (byte)0xce, (byte)0xc4,
  (byte)0xa3, (byte)0xc4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6afb\u6c14\uff5c\uff44";
bytes = new byte[] { (byte)0xdd, (byte)0xaf, (byte)0xdd, (byte)0xe3,
  (byte)0xa1, (byte)0xc3, (byte)0xa3, (byte)0xe4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff51\uff4a\u9169\u7344\u7005";
bytes = new byte[] { (byte)0xa3, (byte)0xf1, (byte)0xa3, (byte)0xea,
  (byte)0xee, (byte)0xc9, (byte)0xb9, (byte)0xf6, (byte)0xfa, (byte)0xf1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6042\uff0a\u5883";
bytes = new byte[] { (byte)0xd7, (byte)0xf6, (byte)0xa1, (byte)0xf6,
  (byte)0xb6, (byte)0xad };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7912\uff8d\u669d";
bytes = new byte[] { (byte)0xe3, (byte)0xa6, (byte)0x8e, (byte)0xcd,
  (byte)0xda, (byte)0xf9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5d\uff23\uff70";
bytes = new byte[] { (byte)0xa1, (byte)0xd1, (byte)0xa3, (byte)0xc3,
  (byte)0x8e, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7821";
bytes = new byte[] { (byte)0xfb, (byte)0xbd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7b9a";
bytes = new byte[] { (byte)0xe4, (byte)0xb4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0d";
bytes = new byte[] { (byte)0xa1, (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d71\u7cd6";
bytes = new byte[] { (byte)0xc5, (byte)0xfd, (byte)0xc5, (byte)0xfc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6a62";
bytes = new byte[] { (byte)0xdc, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff89";
bytes = new byte[] { (byte)0x8e, (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff37\uff5c\u5036\u720d";
bytes = new byte[] { (byte)0xa3, (byte)0xd7, (byte)0xa1, (byte)0xc3,
  (byte)0xb6, (byte)0xe6, (byte)0xe0, (byte)0xa3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u50be\u5b57\u246b";
bytes = new byte[] { (byte)0xb7, (byte)0xb9, (byte)0xbb, (byte)0xfa,
  (byte)0xad, (byte)0xac };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff96";
bytes = new byte[] { (byte)0x8e, (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff01\uff95\u5d07";
bytes = new byte[] { (byte)0xa1, (byte)0xaa, (byte)0x8e, (byte)0xd5,
  (byte)0xbf, (byte)0xf2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6d32\u58ae\uff83";
bytes = new byte[] { (byte)0xbd, (byte)0xa7, (byte)0xd4, (byte)0xd8,
  (byte)0x8e, (byte)0xc3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff35\u203b\uff16\u5dfd";
bytes = new byte[] { (byte)0xa3, (byte)0xd5, (byte)0xa2, (byte)0xa8,
  (byte)0xa3, (byte)0xb6, (byte)0xc3, (byte)0xa7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7704\uff8f";
bytes = new byte[] { (byte)0xe2, (byte)0xc0, (byte)0x8e, (byte)0xcf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5403\u221a\uff90";
bytes = new byte[] { (byte)0xb5, (byte)0xc9, (byte)0xa2, (byte)0xe5,
  (byte)0x8e, (byte)0xd0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff13\u68f9\uff41";
bytes = new byte[] { (byte)0xa3, (byte)0xb3, (byte)0xdc, (byte)0xaa,
  (byte)0xa3, (byte)0xe1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u56ee\uff11\u6308";
bytes = new byte[] { (byte)0xd3, (byte)0xf9, (byte)0xa3, (byte)0xb1,
  (byte)0xd9, (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7bc7\uff2f";
bytes = new byte[] { (byte)0xca, (byte)0xd3, (byte)0xa3, (byte)0xcf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5ae9\uffe5\u60aa";
bytes = new byte[] { (byte)0xd5, (byte)0xc4, (byte)0xa1, (byte)0xef,
  (byte)0xb0, (byte)0xad };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u62ca";
bytes = new byte[] { (byte)0xd9, (byte)0xc3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "2\uff75\uff25\u724b";
bytes = new byte[] { 0x32, (byte)0x8e, (byte)0xb5, (byte)0xa3, (byte)0xc5,
  (byte)0xe0, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2460\uff4d";
bytes = new byte[] { (byte)0xad, (byte)0xa1, (byte)0xa3, (byte)0xed };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6e\u5750\uff44";
bytes = new byte[] { (byte)0x8e, (byte)0xae, (byte)0xba, (byte)0xc1,
  (byte)0xa3, (byte)0xe4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff44\u601d\u518c";
bytes = new byte[] { (byte)0xa3, (byte)0xe4, (byte)0xbb, (byte)0xd7,
  (byte)0xd1, (byte)0xc6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7dcf";
bytes = new byte[] { (byte)0xc1, (byte)0xed };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5925\u70ad";
bytes = new byte[] { (byte)0xd4, (byte)0xee, (byte)0xc3, (byte)0xba };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6fc2\uff47";
bytes = new byte[] { (byte)0xdf, (byte)0xb2, (byte)0xa3, (byte)0xe7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u60b3\u50e5\uffe5\u7955";
bytes = new byte[] { (byte)0xd7, (byte)0xdc, (byte)0xd1, (byte)0xa7,
  (byte)0xa1, (byte)0xef, (byte)0xe3, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2020\u2467\u0013";
bytes = new byte[] { (byte)0xa2, (byte)0xf7, (byte)0xad, (byte)0xa8, 0x13 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6d\uff2ev";
bytes = new byte[] { (byte)0x8e, (byte)0xad, (byte)0xa3, (byte)0xce, 0x76 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9c";
bytes = new byte[] { (byte)0x8e, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2208\u92ea";
bytes = new byte[] { (byte)0xa2, (byte)0xba, (byte)0xca, (byte)0xdf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff40\uff4e";
bytes = new byte[] { (byte)0xa1, (byte)0xae, (byte)0xa3, (byte)0xee };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff87\u2266";
bytes = new byte[] { (byte)0x8e, (byte)0xc7, (byte)0xa1, (byte)0xe5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6050";
bytes = new byte[] { (byte)0xb6, (byte)0xb2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1d";
bytes = new byte[] { (byte)0xa1, (byte)0xe1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0e\u75f0\u77e7";
bytes = new byte[] { (byte)0xa1, (byte)0xa5, (byte)0xe1, (byte)0xe2,
  (byte)0xc7, (byte)0xea };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7a69";
bytes = new byte[] { (byte)0xe3, (byte)0xd3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
}
}
