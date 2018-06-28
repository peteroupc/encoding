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
bytes = new byte[] { 0x65, 0x5f, 0x16, 0x47, (byte)0x83, (byte)0xf4,
  (byte)0x80, (byte)0x90, (byte)0x97, 0x36, 0x6e, 0x76, (byte)0xbc,
  (byte)0xf6, 0x37, (byte)0xa2, (byte)0xb4, 0x4a, 0x19, 0x79, (byte)0xc4,
  (byte)0x99, 0x7a };
str = "e_\u0016G\uaeda\ufffd\ub9b96nv\uc2187\u00a4J\u0019y\ud70cz";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd4, 0x6d, 0x1b, 0x0f, 0x39, 0x3e, 0x33 };
str = "\ufffdm\u001b\u000f9>3";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfc };
str = "\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x20, (byte)0xa8, 0x47, 0x47, (byte)0x80, (byte)0xc3,
  (byte)0x8c, 0x59, (byte)0xd1, 0x73, 0x25, 0x1a, 0x74, (byte)0xaf, 0x74,
  0x4e, (byte)0xcd, 0x51, 0x3a, (byte)0xf6, (byte)0xab, (byte)0xb2, 0x42,
  (byte)0xae, (byte)0xb0, (byte)0x96, (byte)0xfe };
str =

  "\u0020\ucb73G\ufffd\ud691Y\ufffds%\u001at\uce63N\ufffdQ:\u81ed\ucf6e\ufffd\ubf82";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2e, 0x5d, (byte)0xbc, (byte)0xbb, (byte)0xc5, 0x1b,
  0x13, (byte)0xfa, 0x43, (byte)0x80, (byte)0xe4, 0x11, (byte)0xb0,
  (byte)0xd2, (byte)0xa2, 0x1b, (byte)0x86 };
str =
  ".]\uc136\ufffd\u001b\u0013\ufffdC\ufffd\ufffd\u0011\uac8a\ufffd\u001b\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb9, 0x34, 0x25 };
str = "\ufffd4%";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7a, 0x23, (byte)0xdb, 0x7c, (byte)0xb1, (byte)0xa2,
  (byte)0x84, 0x65, (byte)0xb0, 0x1e, (byte)0xe7, 0x3e, (byte)0xf2,
  (byte)0x80, 0x36, (byte)0x87, 0x78, 0x4d, 0x32, 0x68, 0x4c, (byte)0xc0,
  0x09, 0x5d, (byte)0xe7, 0x36, (byte)0x92, (byte)0xc9, 0x5a };
str =

  "z#\ufffd|\uad0d\uaf0c\ufffd\u001e\ufffd>\ufffd6\ub1d2M2hL\ufffd\u0009]\ufffd6\ubbc3Z";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd5, 0x07, (byte)0xcd, 0x67, (byte)0xe7,
  (byte)0xb7, (byte)0x9a, 0x1c, (byte)0xee, (byte)0xec, 0x33, 0x25,
  (byte)0xbe, (byte)0xe3, 0x0c, 0x1e, 0x4b, (byte)0xfa, 0x41, 0x77, 0x50,
  0x62, 0x0c, 0x49, 0x42, (byte)0x95, (byte)0x99, (byte)0x82, (byte)0xa3 };
str =

  "\ufffd\u0007\ufffdg\u6e36\ufffd\u001c\u4f433%\uc587\u000c\u001eK\ufffdAwPb\u000cIB\ube30\uad8d";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x14, (byte)0x87, 0x68, 0x43, 0x5a, 0x28, 0x42, 0x63,
  0x08, 0x52, (byte)0x8d, (byte)0xee, 0x1e, (byte)0xe3, (byte)0xe6, 0x62,
  (byte)0xf7, 0x63, 0x40, (byte)0x9b, 0x2f, (byte)0x9e, 0x69, (byte)0xa4,
  0x2f, 0x2a, 0x51 };
str =
  "\u0014\ub1c0CZ(Bc\u0008R\ub782\u001e\u65b0b\ufffdc@\ufffd/\uc5cd\ufffd/*Q";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x94, 0x33, 0x10, 0x7f, 0x2c, 0x5f, 0x37,
  (byte)0xfd, (byte)0xcc, 0x37, 0x4c, 0x50, 0x7a, 0x7d, 0x5a, 0x0d,
  (byte)0xa0, 0x42, (byte)0xa6, (byte)0xe1 };
str = "\ufffd3\u0010\u007f\u002c_7\u4f117LPz}Z\r\uc7b9\u2547";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf8, (byte)0xa2, 0x40, (byte)0xc3, 0x6d, 0x52,
  0x27, 0x21, 0x20, (byte)0xbe, (byte)0xcf, (byte)0xcc, (byte)0x9b, 0x59,
  (byte)0xfc, 0x6a, (byte)0xca, 0x4d, 0x46, (byte)0xf2, 0x22, (byte)0xc2,
  (byte)0x8c, 0x53, 0x4e };
str = "\u516b@\ud672R'!\u0020\uc554\ufffdY\ufffdj\ufffdMF\ufffd\"\ud623SN";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x42, (byte)0xd4, 0x48, (byte)0xcd, 0x24, 0x61, 0x64,
  0x7d, 0x17, 0x5f, (byte)0xdc, 0x5f, 0x5f, 0x20, 0x43, 0x3a, 0x2e,
  (byte)0x9b, 0x1d, (byte)0xbb, (byte)0xbf };
str = "B\ufffdH\ufffd$ad}\u0017_\ufffd__\u0020C:.\ufffd\u001d\ubf01";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc0, (byte)0xe9, 0x53, (byte)0xe3, 0x73, 0x6e,
  (byte)0x8d, 0x58, (byte)0xda, 0x35, (byte)0xb7, 0x2b, 0x6e, (byte)0xcc,
  0x72, 0x67, 0x41, (byte)0x8e, 0x29, (byte)0x80, (byte)0xdd, 0x78,
  (byte)0xca, 0x7a, 0x7a };
str =
  "\uc7b0S\ufffdsn\ub6db\ufffd5\ufffd+n\ufffdrgA\ufffd)\ufffd\ufffdx\ufffdzz";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5a, 0x12, (byte)0xde, 0x22, 0x71, (byte)0xe8, 0x28,
  (byte)0xe6, (byte)0xe4, 0x72, 0x72, (byte)0xc2, (byte)0xef, 0x70, 0x60,
  0x5b };
str = "Z\u0012\ufffd\"q\ufffd(\uf998rr\ucc0dp`[";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5d, 0x3e, (byte)0xae, 0x35, (byte)0xf7, 0x38,
  (byte)0xc3, (byte)0xba, (byte)0x9d, 0x7f, 0x6d, (byte)0xe6, 0x5c, 0x08,
  (byte)0xcf, (byte)0x9c, (byte)0xb6, 0x1d, 0x30, 0x5a, (byte)0x88, 0x05,
  (byte)0xa1, (byte)0xb1 };
str =

  "]>\ufffd5\ufffd8\uccac\ufffd\u007fm\ufffd\\\u0008\ufffd\ufffd\u001d0Z\ufffd\u0005\u201d";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x74, 0x61, 0x1e, 0x67, 0x67, 0x7b };
str = "ta\u001egg\u007b";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xea, 0x73, (byte)0xe6, 0x13, (byte)0xd7,
  (byte)0xf4, (byte)0x9f, 0x64 };
str = "\ufffds\ufffd\u0013\u85fa\uc6d3";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x71, (byte)0x8c, 0x34, (byte)0xa4, 0x1b, 0x11,
  (byte)0xb4, 0x2c };
str = "q\ufffd4\ufffd\u001b\u0011\ufffd\u002c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x13, 0x0b, (byte)0xeb, (byte)0x84, 0x3e, 0x40, 0x60,
  (byte)0xd4, 0x54, (byte)0xb1, (byte)0xad, 0x15, 0x7b, (byte)0xf2, 0x51,
  0x21, (byte)0xa6, 0x30, (byte)0xdd, (byte)0x82, (byte)0x9b, (byte)0xb4,
  0x6b, (byte)0x86, 0x3e, (byte)0x93, (byte)0xb5 };
str =

  "\u0013\u000b\ufffd>@`\ufffdT\uad38\u0015\u007b\ufffdQ!\ufffd0\ufffd\uc38dk\ufffd>\ubc98";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3a, 0x6e, 0x32, 0x6f };
str = ":n2o";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x66, (byte)0xd8, (byte)0xab, 0x2c, 0x62, 0x55, 0x0e,
  0x6f, (byte)0xe5, 0x3f, 0x23, 0x41, 0x3e, 0x5e, (byte)0xfa, 0x49, 0x15,
  0x28, 0x6b, (byte)0xa6, (byte)0xe2, (byte)0xbb };
str = "f\u9ebb\u002cbU\u000eo\ufffd?#A>^\ufffdI\u0015(k\u2548\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb3, (byte)0x95, (byte)0x8e, 0x6f, 0x74, 0x4e,
  (byte)0x8a, (byte)0x84, 0x67, (byte)0xc0, 0x7b, (byte)0x91, 0x68,
  (byte)0xcf, (byte)0xb0, (byte)0xcb, 0x3a, 0x5c };
str = "\ud021\ub7d2tN\ub486g\ufffd\u007b\uba7b\u69cb\ufffd:\\";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf9, 0x6e, 0x70, (byte)0xc8, (byte)0x87,
  (byte)0xc3, 0x74, 0x01, 0x76, 0x31, 0x01, 0x60, (byte)0xaa, 0x6d, 0x0c,
  0x58, 0x70, (byte)0xff, 0x1a };
str = "\ufffdnp\ufffd\ud67a\u0001v1\u0001`\ucc61\u000cXp\ufffd\u001a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xce, 0x53, 0x5f, (byte)0xea, 0x7b, (byte)0xfc,
  0x2e };
str = "\ufffdS_\ufffd\u007b\ufffd.";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x38, (byte)0xdd, 0x0a, (byte)0xd6, 0x22, (byte)0xbc,
  0x22, 0x2d, 0x18, 0x12, 0x32, 0x3e, (byte)0x9c, (byte)0xf7, 0x3d, 0x1f,
  (byte)0xa6 };
str = "8\ufffd\n\ufffd\"\ufffd\"-\u0018\u00122>\uc4a2\u003d\u001f\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x91, 0x2a, 0x30, 0x47, (byte)0x8c, 0x4b, 0x24,
  0x76, 0x7e, 0x71, (byte)0x8e, 0x42, 0x0f, 0x5a, (byte)0xbc, 0x3e,
  (byte)0xe4, (byte)0x9f, (byte)0xb2, (byte)0xd7, (byte)0xc2, 0x5a, 0x58,
  0x52, 0x1c };
str = "\ufffd*0G\ub60a$v~q\ub7a1\u000fZ\ufffd>\ufffd\uaf95\ud5eeXR\u001c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x13 };
str = "\u0013";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7e, (byte)0x8f, 0x5b, 0x23, 0x40, 0x6e, (byte)0x87,
  (byte)0xca, 0x3a, (byte)0xe5, 0x38, 0x04, 0x1a };
str = "~\ufffd[#@n\ub233:\ufffd8\u0004\u001a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd9, (byte)0xeb, 0x23, (byte)0x94, (byte)0xd3,
  (byte)0xe8, 0x4f, (byte)0xd0, 0x2f, (byte)0xae, 0x38, 0x42, 0x74 };
str = "\u6b66#\ubda3\ufffdO\ufffd/\ufffd8Bt";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x58, 0x1f };
str = "X\u001f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2a, 0x3c, (byte)0xc4, (byte)0x89, 0x70, 0x2a };
str = "*<\ud6f8p*";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa6, 0x14 };
str = "\ufffd\u0014";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x56, (byte)0xb2, 0x3c, (byte)0x87, 0x12, (byte)0xc5,
  0x6c, (byte)0x8c, 0x61, 0x4d, 0x5f, (byte)0xfb, 0x35, (byte)0x94, 0x2a,
  0x1e, (byte)0xd5, (byte)0xf6, 0x37, 0x3e, (byte)0xa0, 0x6f, 0x73, 0x62,
  0x5b, 0x60, (byte)0xb5 };
str =

  "V\ufffd<\ufffd\u0012\ud748\ub61eM_\ufffd5\ufffd*\u001e\u6b777>\uc7efsb[`\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe9, (byte)0xdd, 0x29, (byte)0x92, 0x78, 0x39,
  (byte)0x9e, 0x1f };
str = "\u76c2)\ubb6f9\ufffd\u001f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x83, (byte)0xfb, (byte)0x86, (byte)0x81,
  (byte)0xad, (byte)0xe4, 0x08, 0x57, 0x39, (byte)0xaa, 0x67, 0x47, 0x4c,
  0x48, (byte)0x93, (byte)0x89, 0x6f };
str = "\uaee2\ub0f1\ufffd\u0008W9\ucc5aGLH\ubc63o";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb9, 0x56, 0x4d, 0x36, 0x2b, 0x19, (byte)0xc0,
  (byte)0xa0, (byte)0xb2, (byte)0xe7, (byte)0xde, (byte)0xa5, 0x31,
  (byte)0xea };
str = "\ud247M6+\u0019\ud563\uaff0\u88e81\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x34, 0x06, 0x1a, 0x6f, (byte)0xd3, 0x3d, 0x6e, 0x5c,
  (byte)0xc0 };
str = "4\u0006\u001ao\ufffd\u003dn\\\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x70, 0x0f, 0x62, 0x5e, 0x44, (byte)0x9f, 0x5c, 0x0a };
str = "p\u000fb^D\ufffd\\\n";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7c, (byte)0xcb, 0x36, 0x67, (byte)0xf1, 0x24,
  (byte)0xa1, 0x44, 0x16, 0x2d, (byte)0x8b, (byte)0xe7, (byte)0x91,
  (byte)0xae, 0x38, 0x4f, (byte)0xd8, 0x2b, (byte)0x9c, 0x08, 0x17,
  (byte)0x87, (byte)0x97 };
str =
  "|\ufffd6g\ufffd$\uc8a9\u0016-\ub5e7\ubacc8O\ufffd+\ufffd\u0008\u0017\ub1f3";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcd, 0x22, 0x40, 0x79, 0x5c, (byte)0xc0, 0x38,
  0x53, 0x72, 0x7a };
str = "\ufffd\"@y\\\ufffd8Srz";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x57, 0x5b, 0x74, 0x34, 0x25, 0x3e, 0x3f, (byte)0x8a,
  0x4f, 0x61, (byte)0xda, 0x32, 0x3d, 0x73 };
str = "W[t4%>?\ub456a\ufffd2\u003ds";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x57, (byte)0xbe, (byte)0xde, 0x75, 0x76, 0x27,
  (byte)0xe9, (byte)0xa4, 0x48, 0x43, 0x2d, (byte)0xd8, (byte)0xc2, 0x77,
  (byte)0xb2, (byte)0xf0, 0x77, (byte)0x8e, (byte)0x8b, (byte)0xbf,
  (byte)0xa8, (byte)0xe3, 0x46, 0x43, 0x49 };
str = "W\uc575uv'\u7e5eHC-\u8f13w\ub014w\ub7e8\uc5e5\ufffdFCI";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9a, 0x30, (byte)0xb5, (byte)0xaa, 0x16, 0x5a,
  (byte)0xcb, 0x0f, 0x37, 0x59, (byte)0xd9, 0x1d, (byte)0x91, 0x53, 0x0e,
  0x50, 0x68, 0x29, 0x7d, (byte)0x9b };
str = "\ufffd0\ub381\u0016Z\ufffd\u000f7Y\ufffd\u001d\uba63\u000ePh)}\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa9, (byte)0x86, 0x7c, (byte)0x83, (byte)0xe5,
  0x59, 0x5d, (byte)0xcf, 0x05, (byte)0xe3, (byte)0xda, 0x05, (byte)0x87,
  0x5a, (byte)0xdc, 0x2b, (byte)0x88, (byte)0xe4, 0x6b, (byte)0xfa, 0x6b,
  (byte)0xf6 };
str =
  "\ucc02|\uaec3Y]\ufffd\u0005\u8755\u0005\ub1b8\ufffd+\ub341k\ufffdk\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x87, 0x66, 0x44, (byte)0xf9, 0x03, (byte)0xd7,
  0x15, (byte)0x9d, 0x6f, (byte)0xd2, 0x3b, 0x76, 0x4b, 0x04, 0x1b,
  (byte)0xde, 0x49, (byte)0x8a };
str = "\ub1beD\ufffd\u0003\ufffd\u0015\uc4d4\ufffd;vK\u0004\u001b\ufffdI\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd8, (byte)0xcc, (byte)0xb5, (byte)0x86 };
str = "\u4ea1\ud0e3";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc0, (byte)0x90, (byte)0xc6, (byte)0xfb, 0x21,
  (byte)0xad, 0x6f, (byte)0xbc, 0x50 };
str = "\ud54b\ud3fc!\ucd90\ud379";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4e, (byte)0xad, 0x5c, 0x17, 0x34, (byte)0xf5, 0x14,
  0x72, 0x5e, 0x40, (byte)0xb1, (byte)0xe0, 0x32, 0x40 };
str = "N\ufffd\\\u00174\ufffd\u0014r^@\uae0d2@";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x27, 0x2b, (byte)0xfe, 0x69, 0x25, (byte)0xcc,
  (byte)0x8f, (byte)0xa6, (byte)0xe7, 0x39, (byte)0x8c, (byte)0x81,
  (byte)0xac, (byte)0xcb, (byte)0xdd, (byte)0x9c, (byte)0x8e, 0x32,
  (byte)0xd1, (byte)0x93, 0x7c, 0x5a, 0x6b, 0x2b, (byte)0xe5, (byte)0xd1 };
str = "'+\ufffdi%\ufffd\ufffd9\ub63b\ufffd\ufffd\ufffd2\ufffd|Zk+\u8944";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe9, 0x48, (byte)0xe6, 0x77, 0x2c, (byte)0xef,
  (byte)0xa2, (byte)0xb8, 0x46, (byte)0xf0, (byte)0x82, (byte)0xd9,
  (byte)0xb8, 0x58, 0x17, 0x5a, (byte)0xc6, 0x20, 0x6f };
str = "\ufffdH\ufffdw\u002c\u7420\ud1d5\ufffd\u6478X\u0017Z\ufffd\u0020o";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6c, 0x2d, 0x18, (byte)0xb6, 0x7f, 0x0d, 0x44,
  (byte)0x8e, 0x52, 0x4b, 0x2e, 0x07, (byte)0xc3, 0x6e, 0x2f, (byte)0xf4,
  0x16, (byte)0xaa, 0x4c, 0x41, 0x06, (byte)0x8c };
str =
  "l-\u0018\ufffd\u007f\rD\ub7b9K.\u0007\ud673/\ufffd\u0016\ucc36A\u0006\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf8, 0x49, (byte)0xe8, 0x46, (byte)0xf1,
  (byte)0xb2, 0x66, (byte)0xae, (byte)0xa6, 0x51, 0x61, 0x6f, 0x57, 0x4d,
  (byte)0xb8, 0x0a };
str = "\ufffdI\ufffdF\u5468f\ufffdQaoWM\ufffd\n";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x57, 0x4f, 0x53, (byte)0xf2, 0x6f, 0x3b, (byte)0xe5,
  0x64, 0x6e, 0x67, 0x53, 0x73, 0x67, (byte)0x88, 0x73, 0x01, (byte)0xe0,
  (byte)0xce, 0x7f };
str = "WOS\ufffdo;\ufffddngSsg\ub2ae\u0001\u81b3\u007f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x68, 0x32, (byte)0xb8, 0x4a, 0x20, (byte)0xbe,
  (byte)0xbf, 0x79, (byte)0xe5 };
str = "h2\ud1da\u0020\uc529y\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc5, 0x6e, 0x5b, 0x02, (byte)0x9d, (byte)0x93,
  (byte)0x91, (byte)0xeb, 0x6e, (byte)0xd0, (byte)0x8a, 0x02, 0x66,
  (byte)0xe6, (byte)0xcd, (byte)0xa5, (byte)0xaf, 0x39, 0x2e, 0x71,
  (byte)0x8d, 0x0a, 0x26, 0x78, (byte)0xc2, 0x75, (byte)0x8b };
str =

  "\ud74b[\u0002\uc4f6\ubb10n\ufffd\u0002f\u6cbf\ufffd9.q\ufffd\n&x\ud60b\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x92, 0x6c, 0x1b, 0x31, (byte)0xd4, (byte)0x87,
  (byte)0xa0, 0x43, 0x79, (byte)0xcf, (byte)0xb6, 0x45, 0x16 };
str = "\ubb60\u001b1\ufffd\uc7bay\u7078E\u0016";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x79, (byte)0xff, 0x51, 0x54, 0x58, (byte)0x86, 0x47,
  (byte)0xff, (byte)0x90, (byte)0xb9, 0x62, 0x74, 0x10, (byte)0xc0,
  (byte)0xed, (byte)0xc2, 0x7a, 0x71, (byte)0xb9 };
str = "y\ufffdQTX\ub0b6\ufffd\ub9f2bt\u0010\uc7bf\ud612q\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4c, 0x3a, (byte)0x90, (byte)0xca, (byte)0xb2, 0x57,
  (byte)0xc6, 0x06, (byte)0xc9, (byte)0xb9, 0x28, (byte)0x86, 0x48,
  (byte)0xee, (byte)0xee };
str = "L:\uba0c\ucf89\ufffd\u0006\ufffd(\ub0b7\u50b3";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5c, (byte)0x9e, 0x6b, (byte)0xf4, (byte)0xfa,
  (byte)0xe0, 0x4b };
str = "\\\uc5d2\u54e8\ufffdK";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x37, (byte)0xce, (byte)0xfc, (byte)0xdf, (byte)0xe4,
  0x54, 0x65, (byte)0xc9, 0x22, 0x5c, (byte)0xc7, 0x71, 0x14, 0x22,
  (byte)0xdf, (byte)0xf8, 0x29, 0x0f, 0x1d, (byte)0xc4, (byte)0x9f,
  (byte)0xc1 };
str = "7\u4ff1\u8272Te\ufffd\"\\\ufffdq\u0014\"\u68f2)\u000f\u001d\ud713\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc2, 0x17, (byte)0xf1, 0x0b, 0x0c, (byte)0xf1,
  (byte)0xc8, 0x12, 0x7a, 0x43, 0x6b, 0x34, (byte)0xd0, 0x29, 0x6a };
str = "\ufffd\u0017\ufffd\u000b\u000c\u86db\u0012zCk4\ufffd)j";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc5, 0x67, 0x67, (byte)0xe1, (byte)0xb4,
  (byte)0x9c, 0x54, (byte)0xb9, 0x4c, 0x7e, 0x2a, 0x57, 0x29, 0x3b, 0x31,
  0x27, 0x13, 0x4a, (byte)0xd1, (byte)0xda, 0x09, 0x65 };
str = "\ud741g\u5c11\uc3f7\ud239~*W);1'\u0013J\u62ff\u0009e";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2e, 0x77, (byte)0x9e, 0x16, 0x7f, (byte)0xdc,
  (byte)0xc3, 0x6a, 0x51, 0x25, 0x38, 0x39, (byte)0xe3, (byte)0x97, 0x56,
  (byte)0xe9, (byte)0xa3, 0x26, 0x2f, 0x0f, 0x38, 0x11, (byte)0xff, 0x75,
  0x65, (byte)0xf9, 0x35, 0x47, (byte)0xc3 };
str =

  ".w\ufffd\u0016\u007f\u5831jQ%89\ufffdV\u7e47&/\u000f8\u0011\ufffdue\ufffd5G\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3a };
str = ":";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe3, (byte)0xa5, 0x35, (byte)0xfd };
str = "\u6fd55\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6a, 0x3a, 0x7a, 0x5c, (byte)0x8a, 0x2b, 0x4d, 0x5a,
  0x12, 0x32, (byte)0x83, (byte)0xe9, (byte)0xb1, 0x68, 0x47, 0x7b,
  (byte)0xee, 0x5c };
str = "j:z\\\ufffd+MZ\u00122\uaec8\ucf2eG\u007b\ufffd\\";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1a, 0x6c, 0x0d, (byte)0xf6, (byte)0xf2, 0x3f,
  (byte)0xee, 0x48, (byte)0xe7, 0x3d, 0x2f, (byte)0xf3, 0x57, (byte)0xfd,
  (byte)0xc5, 0x55, (byte)0xda, 0x6d, 0x26, (byte)0xa4, 0x30, (byte)0xb6 };
str = "\u001al\r\u5544?\ufffdH\ufffd\u003d/\ufffdW\u5fbdU\ufffdm&\ufffd0\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6d, 0x2b, 0x2a, 0x02, 0x09, (byte)0xd2, (byte)0xa1,
  0x67, 0x5f, 0x72, 0x09, (byte)0x9f, (byte)0x86, (byte)0xd5, (byte)0xd6,
  (byte)0xae, (byte)0xbb };
str = "m+*\u0002\u0009\u7d0dg_r\u0009\uc6fa\u5006\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x70, (byte)0xd4, 0x78, 0x6e, 0x48, 0x6a, 0x62, 0x0b,
  (byte)0xef, 0x00, (byte)0xde, 0x68, (byte)0xa8, (byte)0xba, (byte)0xce,
  0x24, (byte)0x80 };
str = "p\ufffdxnHjb\u000b\ufffd\u0000\ufffdh\u3269\ufffd$\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x77, 0x04, 0x0a, (byte)0xad, 0x3f, (byte)0xa1,
  (byte)0x95 };
str = "w\u0004\n\ufffd?\uc8fb";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x37, 0x2a, 0x6e, (byte)0xb3, 0x29 };
str = "7*n\ufffd)";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc0, 0x78, 0x6d, 0x7e, (byte)0xb8, 0x32, 0x22,
  (byte)0x96, 0x3c, 0x49, (byte)0x85, (byte)0xa6, (byte)0xdc, 0x37, 0x3f,
  0x63, (byte)0xe9, (byte)0xde, (byte)0xd4, (byte)0x97 };
str = "\ud535m~\ufffd2\"\ufffd<I\ub030\ufffd7?c\u7950\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x66, (byte)0x9b, 0x57, 0x0f, (byte)0x92, 0x3d,
  (byte)0x97, 0x32, (byte)0xa7, 0x62, (byte)0xa8, 0x72, (byte)0xf4, 0x1e,
  0x1e, 0x36, 0x71, (byte)0x95, 0x6b, (byte)0xf2, 0x33, 0x4f, 0x54, 0x0a,
  0x52, (byte)0xcc };
str =

  "f\uc32f\u000f\ufffd\u003d\ufffd2\ucb2b\ucb9a\ufffd\u001e\u001e6q\ubdfe\ufffd3OT\nR\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x20, 0x51, 0x39, 0x62, (byte)0x82, 0x53, (byte)0xfa,
  0x1b, 0x4f };
str = "\u0020Q9b\uad2a\ufffd\u001bO";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x65, 0x4c, (byte)0xe2, 0x74, 0x31, (byte)0xa5, 0x00,
  0x3e, 0x59, 0x42, 0x62, (byte)0xc3, 0x7b, 0x65, 0x36, 0x0b, 0x6a,
  (byte)0xbb, 0x09, 0x26, (byte)0xc7, 0x3a, 0x77, 0x70, (byte)0xd8, 0x64,
  0x31, (byte)0x92 };
str =

  "eL\ufffdt1\ufffd\u0000>YBb\ufffd\u007be6\u000bj\ufffd\u0009&\ufffd:wp\ufffdd1\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9c, (byte)0x98, (byte)0xef, 0x38, (byte)0xb0,
  (byte)0x8f, 0x7c, (byte)0xc6 };
str = "\uc436\ufffd8\ucee6|\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x07, 0x5f, 0x47, 0x4e, 0x75, 0x7a, 0x6b, 0x1f,
  (byte)0xcc, 0x5c, 0x3d, 0x29, 0x4b, 0x60, (byte)0xe8, 0x2a, 0x2c, 0x20,
  (byte)0xa9, (byte)0xc4, 0x67, 0x63, (byte)0xa2, 0x3f, 0x7e, (byte)0x90,
  (byte)0xd0, 0x31 };
str =

  "\u0007_GNuzk\u001f\ufffd\\\u003d)K`\ufffd*\u002c\u0020\u3213gc\ufffd?~\uba121";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb1, (byte)0xab, (byte)0xbe, 0x52, 0x25,
  (byte)0xea, 0x6a, 0x28, 0x3a, (byte)0xe3, 0x2a, 0x69, 0x59, (byte)0xeb,
  (byte)0xf0, 0x1d };
str = "\uad34\ud44b%\ufffdj(:\ufffd*iY\u5100\u001d";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x98, 0x1c, 0x77, 0x70, (byte)0xec, 0x61, 0x36,
  0x5f, 0x48, 0x6d, 0x1b, (byte)0xa7, 0x15, 0x7a, 0x4d };
str = "\ufffd\u001cwp\ufffda6_Hm\u001b\ufffd\u0015zM";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb9, 0x3e, 0x48, 0x49, 0x5b, (byte)0x92, 0x34,
  0x72, 0x7b, 0x35, 0x38, 0x46, (byte)0xc7, 0x61, (byte)0xb2, (byte)0xb8,
  0x64, (byte)0xd2, 0x5b, 0x0f };
str = "\ufffd>HI[\ufffd4r\u007b58F\ufffda\uaef4d\ufffd[\u000f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x54, 0x74, (byte)0xf4, 0x1c, 0x77, 0x18, (byte)0xa5,
  (byte)0xd9, 0x0b, (byte)0xa8, (byte)0x99, (byte)0xf3, 0x28, (byte)0xe5,
  0x7a, (byte)0x82, 0x23, 0x26, 0x6e, 0x4d, 0x47, (byte)0xcc, 0x46, 0x48,
  0x36, 0x73, 0x13 };
str =

  "Tt\ufffd\u001cw\u0018\ufffd\u000b\ucbbd\ufffd(\ufffdz\ufffd#&nMG\ufffdFH6s\u0013";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xec, 0x32, 0x40, (byte)0xf8, (byte)0x8b,
  (byte)0x8b, 0x19, 0x26 };
str = "\ufffd2@\ufffd\ufffd\u0019&";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x66, (byte)0x89, (byte)0x94, (byte)0xf5, 0x1a, 0x28,
  (byte)0xbf, 0x35, 0x74, (byte)0x8f, (byte)0xee, (byte)0xb7, 0x13, 0x34,
  0x47, 0x58, 0x71, (byte)0xc0, 0x3e };
str = "f\ub3c1\ufffd\u001a(\ufffd5t\ub943\ufffd\u00134GXq\ufffd>";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbb, (byte)0xef, (byte)0x92, (byte)0xc4,
  (byte)0xc8, (byte)0xce, (byte)0xe0, 0x48, 0x5e, (byte)0xee, (byte)0xba };
str = "\uc0bc\ubbbd\ud6e8\ufffdH^\u5480";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x63, 0x48, 0x60, (byte)0x87, (byte)0xf4, (byte)0x83,
  0x72, (byte)0xdd, 0x4d, 0x6b, 0x7f, 0x6e, 0x1a, (byte)0xf8, 0x70, 0x19,
  (byte)0xa1, 0x6c, 0x76, 0x13 };
str = "cH`\ub262\uae2e\ufffdMk\u007fn\u001a\ufffdp\u0019\uc8d0v\u0013";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6d, 0x05, 0x55, 0x6b, (byte)0xb2, 0x45, 0x0f,
  (byte)0xd9, 0x39, 0x5b, 0x30, 0x4f, (byte)0x97, 0x0b, (byte)0xe9,
  (byte)0xbd, 0x66, 0x24, 0x0f, (byte)0xe8, 0x4e, (byte)0xf4, (byte)0xe6,
  0x2c, 0x21, (byte)0x86, (byte)0x99, 0x60 };
str =

  "m\u0005Uk\ucf73\u000f\ufffd9[0O\ufffd\u000b\u6142f$\u000f\ufffdN\u5ef3\u002c!\ub10d`";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x68, 0x44, 0x3e, 0x24, 0x4e, 0x4a, 0x6a, (byte)0xb0,
  0x29, 0x32, 0x69, (byte)0x8c, 0x21, 0x69, (byte)0x87, 0x6c, 0x47,
  (byte)0x99, (byte)0xcf, (byte)0xaa, 0x1d, 0x26, (byte)0x9f, (byte)0x86,
  0x2c, 0x1f, 0x67, (byte)0xeb, 0x43, (byte)0xae };
str =

  "hD>$NJj\ufffd)2i\ufffd!i\ub1c4G\uc1e2\ufffd\u001d&\uc6fa\u002c\u001fg\ufffdC\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x67, 0x02, 0x2c, 0x50, 0x73, (byte)0xda, (byte)0xcf,
  0x59, 0x78, 0x28, 0x72, (byte)0xa4, 0x74, 0x74, (byte)0x8b, (byte)0xdc,
  0x55, (byte)0xfb, 0x51, (byte)0xf4, 0x27, 0x76, (byte)0xa6, (byte)0xad,
  (byte)0xcb, (byte)0xba, 0x48, 0x6e };
str = "g\u0002\u002cPs\u535aYx(r\uca1ft\ub5dcU\ufffdQ\ufffd'v\u2503\u8941Hn";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x20, 0x61, 0x4c, 0x3e, 0x2e, 0x54, (byte)0x88, 0x29,
  0x51, (byte)0xe1, (byte)0xe0, (byte)0xe6, (byte)0xdc, (byte)0xe9, 0x1e,
  0x7c, (byte)0xe3, 0x68, (byte)0xce, (byte)0xb9, 0x6a, 0x55, (byte)0xcd,
  0x41 };
str = "\u0020aL>.T\ufffd)Q\u84c0\uf995\ufffd\u001e|\ufffdh\u83c5jU\ufffdA";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcc, 0x1e, 0x00, (byte)0x82, (byte)0xd8, 0x4d,
  0x47, (byte)0xf5, (byte)0xd1, 0x37, (byte)0xb7, (byte)0x98, (byte)0x90,
  0x79, 0x2f };
str = "\ufffd\u001e\u0000\uadcbMG\u69787\ud1c7\ub99d/";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd1, (byte)0xb1, 0x7d, 0x1b, 0x2b, 0x41, 0x66,
  (byte)0xe6, 0x3a, (byte)0xe1, (byte)0xb3, (byte)0xd9, 0x7a, (byte)0xbe,
  0x62, 0x41, 0x21, 0x62, (byte)0xab, 0x79, 0x2d };
str = "\u7578}\u001b+Af\ufffd:\u5c0f\ufffdz\ud455A!b\uccd9-";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8a, 0x1b, (byte)0xa2, (byte)0xff, (byte)0xd2,
  0x09 };
str = "\ufffd\u001b\ufffd\ufffd\u0009";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7e, (byte)0xe4, 0x31, 0x70, 0x53, (byte)0xbe,
  (byte)0xea, 0x79, (byte)0xe5, (byte)0xfa, (byte)0xbb };
str = "~\ufffd1pS\uc598y\uf97f\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x94, (byte)0xcc, 0x48, (byte)0xa6, (byte)0xcd,
  (byte)0xcb, 0x43, 0x20, 0x53, 0x44, (byte)0xad, 0x1f, 0x6e, 0x3e, 0x3c,
  (byte)0xb3, (byte)0xf9, (byte)0xea, 0x7e, 0x1a, (byte)0xf7, 0x58, 0x66,
  0x12 };
str =

  "\ubd9bH\u2526\ufffdC\u0020SD\ufffd\u001fn><\ub1a8\ufffd~\u001a\ufffdXf\u0012";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x39, 0x54, (byte)0xa5, 0x67, (byte)0xc9, (byte)0x95,
  0x72, (byte)0xee, 0x3a, (byte)0xf6, (byte)0xd2, (byte)0x8e, 0x5d,
  (byte)0x80, (byte)0xba, 0x4e, (byte)0xf0, (byte)0xb2, 0x22, 0x23, 0x6d,
  (byte)0xa2, 0x57, 0x60, 0x7b, 0x7b };
str =

  "9T\uca71\ufffdr\ufffd:\u4e03\ufffd]\ufffd\ud29e\u88fd\"#m\uc928`\u007b\u007b";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa1, (byte)0xf1 };
str = "\u2235";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x36, 0x6e, 0x2c, 0x58, 0x1a, 0x6b, (byte)0xfa, 0x0c,
  (byte)0x9c, (byte)0xeb };
str = "6n\u002cX\u001ak\ufffd\u000c\uc495";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44, 0x40, 0x55, 0x15, 0x36, (byte)0xd5, 0x73,
  (byte)0x8e, (byte)0xd8, 0x52, 0x23, 0x7d, 0x32, 0x44, (byte)0xf1, 0x61 };
str = "D@U\u00156\ufffds\ub854R#}2D\ufffda";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xee, 0x1b };
str = "\ufffd\u001b";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa2, (byte)0xdd, 0x68, 0x15, (byte)0xfa, 0x4b,
  0x66, (byte)0xa4, (byte)0xbc, (byte)0xc1, 0x25, 0x2d };
str = "\u266ch\u0015\ufffdKf\u314c\ufffd%-";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
}
@Test
public void TestKoreanEUCEncoder() {
byte[] bytes;
String str;
ICharacterEncoding charset = Encodings.GetEncoding("euc-kr");
str = "\u7a2e\uff44\u2531";
bytes = new byte[] { (byte)0xf0, (byte)0xfa, (byte)0xa3, (byte)0xe4,
  (byte)0xa6, (byte)0xd3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5e1d\u7518\u250d";
bytes = new byte[] { (byte)0xf0, (byte)0xa8, (byte)0xca, (byte)0xf6,
  (byte)0xa6, (byte)0xc8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u58d3\uff55\ucf73";
bytes = new byte[] { (byte)0xe4, (byte)0xe2, (byte)0xa3, (byte)0xf5,
  (byte)0xb2, 0x45 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5eec";
bytes = new byte[] { (byte)0xd5, (byte)0xe6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u79b3\u2519";
bytes = new byte[] { (byte)0xe5, (byte)0xcc, (byte)0xa6, (byte)0xc4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6043\ucc23\u5553";
bytes = new byte[] { (byte)0xe3, (byte)0xbe, (byte)0xa9, (byte)0x9f,
  (byte)0xcc, (byte)0xf6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ud3f1";
bytes = new byte[] { (byte)0xbd, 0x55 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff28\uc928\uadb9";
bytes = new byte[] { (byte)0xa3, (byte)0xc8, (byte)0xa2, 0x57, (byte)0x82,
  (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uc107";
bytes = new byte[] { (byte)0x98, (byte)0xe5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uafbf\ubbde\u5b6b";
bytes = new byte[] { (byte)0x85, 0x41, (byte)0x92, (byte)0xe0, (byte)0xe1,
  (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6c13";
bytes = new byte[] { (byte)0xd8, (byte)0xec };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff03\uff14\u7ae5";
bytes = new byte[] { (byte)0xa3, (byte)0xa3, (byte)0xa3, (byte)0xb4,
  (byte)0xd4, (byte)0xdb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "]\u2511\ubda7";
bytes = new byte[] { 0x5d, (byte)0xa6, (byte)0xc2, (byte)0x94, (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff35";
bytes = new byte[] { (byte)0xa3, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u775b\u7901\u7fc1\uc64c";
bytes = new byte[] { (byte)0xef, (byte)0xec, (byte)0xf5, (byte)0xa7,
  (byte)0xe8, (byte)0xba, (byte)0x9e, (byte)0xbd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uc3c7\uff45\u25b6\u6746";
bytes = new byte[] { (byte)0x9b, (byte)0xed, (byte)0xa3, (byte)0xe5,
  (byte)0xa2, (byte)0xba, (byte)0xca, (byte)0xd2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e93+\uff50";
bytes = new byte[] { (byte)0xe7, (byte)0xc5, 0x2b, (byte)0xa3, (byte)0xf0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff35\uff3f\u88fd\uff01\u7554";
bytes = new byte[] { (byte)0xa3, (byte)0xd5, (byte)0xa3, (byte)0xdf,
  (byte)0xf0, (byte)0xb2, (byte)0xa3, (byte)0xa1, (byte)0xda, (byte)0xed };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7901";
bytes = new byte[] { (byte)0xf5, (byte)0xa7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u71fc";
bytes = new byte[] { (byte)0xe3, (byte)0xe8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff46\u30d1";
bytes = new byte[] { (byte)0xa3, (byte)0xe6, (byte)0xab, (byte)0xd1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u00b7";
bytes = new byte[] { (byte)0xa1, (byte)0xa4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff36";
bytes = new byte[] { (byte)0xa3, (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2193\ubd32\uff07";
bytes = new byte[] { (byte)0xa1, (byte)0xe9, (byte)0x94, 0x73, (byte)0xa3,
  (byte)0xa7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7db1w\u79d5";
bytes = new byte[] { (byte)0xcb, (byte)0xb5, 0x77, (byte)0xdd, (byte)0xf9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "u\ucc5a\u6c87";
bytes = new byte[] { 0x75, (byte)0xaa, 0x67, (byte)0xe6, (byte)0xcc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff52\u7d04\u6b61";
bytes = new byte[] { (byte)0xa3, (byte)0xf2, (byte)0xe5, (byte)0xb3,
  (byte)0xfc, (byte)0xb6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5766";
bytes = new byte[] { (byte)0xf7, (byte)0xa4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff36\uff38";
bytes = new byte[] { (byte)0xa3, (byte)0xd6, (byte)0xa3, (byte)0xd8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uaeee\u67b6";
bytes = new byte[] { (byte)0x84, 0x46, (byte)0xca, (byte)0xad };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u0005\u2468\uff26";
bytes = new byte[] { 0x05, (byte)0xa8, (byte)0xef, (byte)0xa3, (byte)0xc6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff39";
bytes = new byte[] { (byte)0xa3, (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uc285\uffe1\u2534\uff2c";
bytes = new byte[] { (byte)0x9a, (byte)0x97, (byte)0xa1, (byte)0xcc,
  (byte)0xa6, (byte)0xaa, (byte)0xa3, (byte)0xcc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ubaa6";
bytes = new byte[] { (byte)0x91, (byte)0x94 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5fb5\ud73f\u792b";
bytes = new byte[] { (byte)0xf3, (byte)0xa3, (byte)0xc5, 0x65, (byte)0xd5,
  (byte)0xf8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u551c";
bytes = new byte[] { (byte)0xd8, (byte)0xc5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u000b";
bytes = new byte[] { 0x0b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ub27b";
bytes = new byte[] { (byte)0x88, 0x4b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ud3ad\u7e31";
bytes = new byte[] { (byte)0xc6, (byte)0xeb, (byte)0xf0, (byte)0xfd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u4f09";
bytes = new byte[] { (byte)0xf9, (byte)0xf2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6b78\u7dde\uff43\u6c90";
bytes = new byte[] { (byte)0xcf, (byte)0xfd, (byte)0xd3, (byte)0xb0,
  (byte)0xa3, (byte)0xe3, (byte)0xd9, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5be8";
bytes = new byte[] { (byte)0xf3, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6a53\ub6e6\u6cbb";
bytes = new byte[] { (byte)0xe2, (byte)0xe5, (byte)0x8d, 0x69, (byte)0xf6,
  (byte)0xbd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d76\u501f\ud25d";
bytes = new byte[] { (byte)0xef, (byte)0xbe, (byte)0xf3, (byte)0xa8,
  (byte)0xb9, 0x70 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1d\u7d44\u7130";
bytes = new byte[] { (byte)0xa3, (byte)0xbd, (byte)0xf0, (byte)0xda,
  (byte)0xe6, (byte)0xfb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u751a";
bytes = new byte[] { (byte)0xe4, (byte)0xa4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff55\u65ed";
bytes = new byte[] { (byte)0xa3, (byte)0xf5, (byte)0xe9, (byte)0xef };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5e";
bytes = new byte[] { (byte)0xa2, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u659c\u7729\u7430";
bytes = new byte[] { (byte)0xde, (byte)0xd8, (byte)0xfa, (byte)0xdf,
  (byte)0xe6, (byte)0xfc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7881\u2476";
bytes = new byte[] { (byte)0xd1, (byte)0xb3, (byte)0xa9, (byte)0xe9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2479\uc4e0";
bytes = new byte[] { (byte)0xa9, (byte)0xec, (byte)0x9d, (byte)0x81 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff34\uc8a5\uff15";
bytes = new byte[] { (byte)0xa3, (byte)0xd4, (byte)0xa1, 0x41, (byte)0xa3,
  (byte)0xb5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff53";
bytes = new byte[] { (byte)0xa3, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5728\u7c27";
bytes = new byte[] { (byte)0xee, (byte)0xa4, (byte)0xfc, (byte)0xd7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff36";
bytes = new byte[] { (byte)0xa3, (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff53";
bytes = new byte[] { (byte)0xa3, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff29";
bytes = new byte[] { (byte)0xa3, (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u62cf\u619a\u56bc";
bytes = new byte[] { (byte)0xd1, (byte)0xd9, (byte)0xf7, (byte)0xa6,
  (byte)0xed, (byte)0xc4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff46";
bytes = new byte[] { (byte)0xa3, (byte)0xe6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5d0d\uff22\uff43";
bytes = new byte[] { (byte)0xd5, (byte)0xcf, (byte)0xa3, (byte)0xc2,
  (byte)0xa3, (byte)0xe3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7441";
bytes = new byte[] { (byte)0xd9, (byte)0xc1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff24";
bytes = new byte[] { (byte)0xa3, (byte)0xc4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff49";
bytes = new byte[] { (byte)0xa3, (byte)0xe9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5716";
bytes = new byte[] { (byte)0xd3, (byte)0xf1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7bc0\u254b\uff34\u246c\uff2b\u2116";
bytes = new byte[] { (byte)0xef, (byte)0xbd, (byte)0xa6, (byte)0xb6,
  (byte)0xa3, (byte)0xd4, (byte)0xa8, (byte)0xf3, (byte)0xa3, (byte)0xcb,
  (byte)0xa2, (byte)0xe0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d2e\u7be9\u59ee";
bytes = new byte[] { (byte)0xf3, (byte)0xcf, (byte)0xde, (byte)0xe8,
  (byte)0xf9, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff31";
bytes = new byte[] { (byte)0xa3, (byte)0xd1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff27\u6aa2\u69ff\u7f75\u69b4\u5e63\u0001";
bytes = new byte[] { (byte)0xa3, (byte)0xc7, (byte)0xcb, (byte)0xfe,
  (byte)0xd0, (byte)0xc7, (byte)0xd8, (byte)0xe1, (byte)0xd7, (byte)0xb4,
  (byte)0xf8, (byte)0xc7, 0x01 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5b58";
bytes = new byte[] { (byte)0xf0, (byte)0xed };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7ae3\uff45";
bytes = new byte[] { (byte)0xf1, (byte)0xe2, (byte)0xa3, (byte)0xe5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uce12\uff3d";
bytes = new byte[] { (byte)0xae, (byte)0x8d, (byte)0xa3, (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6258\u7530\u6817";
bytes = new byte[] { (byte)0xf6, (byte)0xf5, (byte)0xef, (byte)0xa3,
  (byte)0xd7, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e82";
bytes = new byte[] { (byte)0xf3, (byte)0xc3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff23";
bytes = new byte[] { (byte)0xa3, (byte)0xc3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ucdf0\uffe1\u5dde";
bytes = new byte[] { (byte)0xc3, (byte)0xed, (byte)0xa1, (byte)0xcc,
  (byte)0xf1, (byte)0xb6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5398";
bytes = new byte[] { (byte)0xd7, (byte)0xd8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5e";
bytes = new byte[] { (byte)0xa2, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff50\u53e1";
bytes = new byte[] { (byte)0xa3, (byte)0xf0, (byte)0xe7, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d93\uff54\uffe5";
bytes = new byte[] { (byte)0xcc, (byte)0xe8, (byte)0xa3, (byte)0xf4,
  (byte)0xa1, (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u72e9\u5a5a";
bytes = new byte[] { (byte)0xe2, (byte)0xad, (byte)0xfb, (byte)0xe6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uc17bG\u253f\ub05d";
bytes = new byte[] { (byte)0x99, 0x7a, 0x47, (byte)0xa6, (byte)0xbb,
  (byte)0xb3, (byte)0xa1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d1a\u6dde\u78bb\u57ce";
bytes = new byte[] { (byte)0xd0, (byte)0xe4, (byte)0xe1, (byte)0xe7,
  (byte)0xfc, (byte)0xad, (byte)0xe0, (byte)0xf2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff08";
bytes = new byte[] { (byte)0xa3, (byte)0xa8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6050\u252e";
bytes = new byte[] { (byte)0xcd, (byte)0xf0, (byte)0xa6, (byte)0xd2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e6b\u2663\uff09";
bytes = new byte[] { (byte)0xcd, (byte)0xa8, (byte)0xa2, (byte)0xc0,
  (byte)0xa3, (byte)0xa9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uc9f2";
bytes = new byte[] { (byte)0xa4, 0x4c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7f79";
bytes = new byte[] { (byte)0xd7, (byte)0xe7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u64ab";
bytes = new byte[] { (byte)0xd9, (byte)0xe8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uce03\ub201\ub45a";
bytes = new byte[] { (byte)0xae, (byte)0x81, (byte)0x87, (byte)0xa2,
  (byte)0x8a, 0x52 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ub31a\u8b2b\uff4c\uaf8a+";
bytes = new byte[] { (byte)0x88, (byte)0xbe, (byte)0xee, (byte)0xe3,
  (byte)0xa3, (byte)0xec, (byte)0x84, (byte)0xd1, 0x2b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u58ae\u2475\u007b";
bytes = new byte[] { (byte)0xf6, (byte)0xe5, (byte)0xa9, (byte)0xe8, 0x7b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uc041";
bytes = new byte[] { (byte)0x98, 0x42 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5eb8\ub7fd\ub348";
bytes = new byte[] { (byte)0xe9, (byte)0xbc, (byte)0xb7, (byte)0xb4,
  (byte)0x88, (byte)0xeb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2501";
bytes = new byte[] { (byte)0xa6, (byte)0xac };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0b\u73c9\uff58";
bytes = new byte[] { (byte)0xa3, (byte)0xab, (byte)0xda, (byte)0xc8,
  (byte)0xa3, (byte)0xf8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uaec0";
bytes = new byte[] { (byte)0xb2, (byte)0xab };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1e\u7b9a\u2170";
bytes = new byte[] { (byte)0xa3, (byte)0xbe, (byte)0xf3, (byte)0xb0,
  (byte)0xa5, (byte)0xa1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u000c\u201c\u6234b";
bytes = new byte[] { 0x0c, (byte)0xa1, (byte)0xb0, (byte)0xd3, (byte)0xe3,
  0x62 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff04\ub74d\u5b97";
bytes = new byte[] { (byte)0xa3, (byte)0xa4, (byte)0x8d, (byte)0xc5,
  (byte)0xf0, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5ed0\u5a18\uff04\uaf65";
bytes = new byte[] { (byte)0xcf, (byte)0xaa, (byte)0xd2, (byte)0xa6,
  (byte)0xa3, (byte)0xa4, (byte)0xb2, (byte)0xd0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
}
}
