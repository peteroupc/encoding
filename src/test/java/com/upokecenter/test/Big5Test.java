package com.upokecenter.test; import com.upokecenter.util.*;

import org.junit.Assert;
import org.junit.Test;
import com.upokecenter.util.*;
import com.upokecenter.text.*;

public class Big5Test {
@Test
public void TestBig5Decoder() {
byte[] bytes;
String str;
ICharacterEncoding charset = Encodings.GetEncoding("big5");
bytes = new byte[] { 0x38, 0x1d, (byte)0xd4, (byte)0xf3, 0x0a, (byte)0xed,
  (byte)0xd7, (byte)0xcb, (byte)0xfc, 0x49, 0x03, (byte)0xec, 0x77,
  (byte)0xa5, 0x6d, (byte)0x87, 0x6f };
str = "8\u001d\u5c59\n\u7e49\u5773I\u0003\u9b7e\u53ee\u5aa4";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x15, 0x0b, 0x07, (byte)0x93, 0x69, 0x30, 0x6f, 0x3b,
  0x7e };
str = "\u0015\u000b\u0007\ud85d\uddfd0o;~";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xee, 0x59, (byte)0x92 };
str = "\u87aa\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x50, 0x58 };
str = "PX";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x48, (byte)0x9b, (byte)0x9a, (byte)0xfb, 0x30,
  (byte)0xdc, 0x34, 0x0b, 0x73, (byte)0xbf, (byte)0xc8, 0x70, 0x0b, 0x22,
  (byte)0xf2, 0x26, (byte)0xe9, (byte)0xea, (byte)0xfb, (byte)0xfa,
  (byte)0xa3, 0x5a, (byte)0xb7, 0x19, 0x2f, (byte)0xe2, (byte)0xbb,
  (byte)0xa9 };
str =

  "H\ufffd\ufffd0\ufffd4\u000bs\u8925p\u000b\"\ufffd&\u6fcb\u53a8\u03a8\ufffd\u0019/\u7190\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5a, (byte)0xb5, 0x15, (byte)0xfc, (byte)0x81 };
str = "Z\ufffd\u0015\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbd, (byte)0x92, 0x74, 0x01, 0x59, (byte)0xf9,
  (byte)0xe2, 0x2d };
str = "\ufffdt\u0001Y\u2563-";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfb, 0x12, (byte)0xf5, (byte)0xab, (byte)0xa7,
  (byte)0xa7, (byte)0xd0, 0x40, (byte)0xd8, (byte)0xd2, (byte)0xf3,
  (byte)0xb4, (byte)0x9c, (byte)0x87, (byte)0xac, 0x55, 0x77, (byte)0x8f,
  0x31, 0x12, 0x60, (byte)0xf8, (byte)0xd9, (byte)0xe2, (byte)0xfa,
  (byte)0xfe };
str =

  "\ufffd\u0012\u9da3\u58ef\u7a7e\u5bcb\u9a1a\ufffd\u67ffw\ufffd1\u0012`\u9c62\u798b\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x98, 0x45, 0x3b, 0x75, 0x6d, 0x7d, (byte)0xab,
  0x29 };
str = "\ud85c\udd09;um}\ufffd)";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd5, (byte)0xbc, (byte)0xe8, (byte)0xe3, 0x0b,
  0x43 };
str = "\u68a9\u9b6c\u000bC";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2a, (byte)0x91, 0x40, 0x16, 0x71, (byte)0xec,
  (byte)0x9d, 0x2e, (byte)0x8e };
str = "*\ud855\udf06\u0016q\ufffd.\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcc, 0x6b, 0x54, (byte)0xcd, (byte)0xef,
  (byte)0x8b, 0x1d, 0x17, (byte)0xa3, 0x16, 0x0f, 0x21, (byte)0xd4,
  (byte)0xe3, 0x0b, 0x45, (byte)0xd5, (byte)0xb4, 0x59, (byte)0xcf };
str =

  "\u5cb0T\u4fec\ufffd\u001d\u0017\ufffd\u0016\u000f!\u5a8e\u000bE\u686dY\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x05 };
str = "\u0005";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44, 0x2a, 0x14, (byte)0xd9, 0x37, (byte)0xfd, 0x5d };
str = "D*\u0014\ufffd7\u3bf3";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x36, 0x24, (byte)0xa9, (byte)0x9e, 0x59, 0x77 };
str = "6$\ufffdYw";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x52, 0x38, 0x47, 0x26, 0x43, (byte)0xd4, (byte)0xda,
  0x10, (byte)0x95, (byte)0xc7, 0x6b, 0x4e, 0x25, (byte)0xe9, 0x70,
  (byte)0xc9 };
str = "R8G&C\u5a53\u0010\u36d4kN%\u5ee7\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x71, 0x4c, 0x5d, 0x5b, (byte)0xde, (byte)0xe7,
  (byte)0xe2, (byte)0x93, 0x4d, (byte)0x85, (byte)0xc3, 0x60, (byte)0x92,
  0x66, 0x6d, 0x78, 0x07, 0x73, (byte)0xac, 0x26, (byte)0x83, 0x77,
  (byte)0xd4, (byte)0xa8, 0x23 };
str = "qL][\u788f\ufffdM\ufffd`\u939cmx\u0007s\ufffd&\ufffdw\u553b#";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfc, 0x53, 0x02, 0x56, (byte)0xbc, (byte)0xf4,
  0x47, (byte)0xc7, (byte)0xf4, (byte)0xd4, 0x56, (byte)0x88, (byte)0xd9,
  (byte)0xd2, 0x31, 0x34, 0x34, (byte)0x85, (byte)0xae, (byte)0x95 };
str = "\ud85b\ude6e\u0002V\u719fG\u0411\u504d\ufffd\ufffd144\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x60, 0x5f, (byte)0x80, 0x56, (byte)0xae, (byte)0x99,
  0x29, 0x39, 0x47, 0x27, (byte)0xe6, 0x41 };
str = "`_\ufffdV\ufffd)9G'\u6f89";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xed, 0x5d, (byte)0xf7, (byte)0xa8, (byte)0xb6,
  0x45, 0x26, (byte)0xf6, 0x7a, (byte)0xf2, 0x7c, 0x04, (byte)0xc0,
  (byte)0x8f, (byte)0xb9, 0x16, 0x61, 0x39, (byte)0xed };
str = "\u71f1\u9b56\u8a3a&\u9a46\u77f1\u0004\ufffd\ufffd\u0016a9\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb5, (byte)0xaa, 0x46, 0x34, (byte)0x99,
  (byte)0xef, 0x55, 0x44, 0x20, (byte)0xbd, 0x46 };
str = "\u7b54F4\u8fb7UD\u0020\u7624";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x31, 0x54, 0x5e, (byte)0xe3, 0x4f, (byte)0xb8, 0x6d,
  0x01 };
str = "1T^\u7b9c\u7f6e\u0001";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc8, 0x65, (byte)0xea, 0x6d, 0x69, 0x13, 0x49,
  (byte)0xe1 };
str = "\u043f\u7631i\u0013I\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x88, (byte)0xf4, (byte)0xff, (byte)0xf3, 0x5b,
  0x5f, 0x44, (byte)0x92, 0x71, (byte)0x85, 0x24, 0x2f, (byte)0xe1, 0x35,
  0x5d };
str = "\ufffd\ufffd\u8fb4_D\u5a68\ufffd$/\ufffd5]";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x63, 0x7f, 0x5c, 0x05, (byte)0xbe, (byte)0x8f,
  (byte)0xea, (byte)0x94, 0x4d, 0x15, (byte)0x96, (byte)0xd7, (byte)0xa6,
  0x1d, (byte)0xdd, 0x2d, (byte)0x8e, 0x7a, (byte)0xc8, (byte)0xe5,
  (byte)0xe6, (byte)0xab, 0x28, 0x7f, (byte)0xb1, 0x40, 0x4e };
str =

  "c\u007f\\\u0005\ufffd\ufffdM\u0015\u93db\ufffd\u001d\ufffd-\u7ce6\u2eae\u7479(\u007f\u5a3cN";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x19, 0x6a, 0x35, (byte)0xff, 0x56, 0x51, 0x4c, 0x65,
  0x7d, 0x13, (byte)0xed, 0x3a, 0x09, 0x6f, 0x5f, (byte)0xc9, (byte)0xd9,
  (byte)0x86, 0x19, 0x40, (byte)0x9d, 0x7c };
str = "\u0019j5\ufffdVQLe}\u0013\ufffd:\u0009o_\u5c7e\ufffd\u0019@\ud843\udc9c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x82, (byte)0x9a, (byte)0x83, (byte)0xfb, 0x53,
  (byte)0xa6, (byte)0x9c, 0x4b, (byte)0xc1, 0x34, (byte)0xc1, 0x6d, 0x08,
  0x69, 0x12, (byte)0xd3, 0x33, 0x17, (byte)0xa2, 0x4f, 0x04 };
str = "\ufffd\ufffdS\ufffdK\ufffd4\u8071\u0008i\u0012\ufffd3\u0017\u33d5\u0004";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x07, 0x17, (byte)0xba, 0x50, (byte)0xb5, 0x4a, 0x51,
  (byte)0xd0, (byte)0xb6, 0x32, 0x36, 0x23, 0x4a, 0x74, 0x01, 0x4b,
  (byte)0xc6, 0x3a, 0x13 };
str = "\u0007\u0017\u647a\u7126Q\u8fe026#Jt\u0001K\ufffd:\u0013";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4e, 0x3f, 0x53, (byte)0xee, (byte)0xfb, 0x5f, 0x7b,
  0x40, 0x5c, (byte)0xad, 0x64, 0x6c, 0x73, (byte)0x99, 0x3a, 0x4c, 0x7a,
  (byte)0xb2, 0x48 };
str = "N?S\u9719_\u007b@\\\u82d3ls\ufffd:Lz\u6de1";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4a, 0x74, (byte)0x90, 0x6b, 0x3a, (byte)0x87,
  (byte)0x9e, 0x46, 0x7f, 0x5b, 0x38, (byte)0xf3, (byte)0x80, (byte)0x9f,
  0x59, 0x50, 0x58, 0x7e, (byte)0xf6, 0x53, 0x0f, 0x65, (byte)0xd4 };
str = "Jt\ud861\udee6:\ufffdF\u007f[8\ufffd\u7ba3PX~\u8d14\u000fe\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x54, (byte)0xb9, 0x35, (byte)0xc0, (byte)0x94, 0x4e };
str = "T\ufffd5\ufffdN";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x61, 0x31, 0x69, (byte)0xdf, 0x0a, 0x5e, 0x6e, 0x7e,
  (byte)0x9d, 0x7c, (byte)0x92, 0x24, 0x30, (byte)0xdb, 0x06, 0x21, 0x38,
  (byte)0x8a };
str = "a1i\ufffd\n^n~\ud843\udc9c\ufffd$0\ufffd\u0006!8\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc9, 0x5d, (byte)0x91 };
str = "\u5dff\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x28, (byte)0xfd, (byte)0x8b, (byte)0xd4, 0x79,
  (byte)0x8f, (byte)0x85, 0x40 };
str = "(\ufffd\u5562\ufffd@";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4e, (byte)0xb6, (byte)0xad, (byte)0xc6, (byte)0x8c,
  0x4c, (byte)0x8f, 0x79, (byte)0xaa, 0x5c, (byte)0xfd, (byte)0x8f };
str = "N\u96c1\ufffdL\ud85b\ude99\u6b7f\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4c };
str = "L";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5f, (byte)0x99, 0x3e, 0x73, 0x7b, 0x00, (byte)0xae,
  0x12, (byte)0xfd, 0x3a, 0x59, (byte)0xb8, (byte)0xd0, (byte)0xba, 0x4b,
  (byte)0xfe, 0x7c, 0x56, 0x1d, (byte)0xe0, (byte)0x86, 0x67, 0x52, 0x33,
  (byte)0x91, (byte)0x99, (byte)0xa1 };
str =

  "_\ufffd>s\u007b\u0000\ufffd\u0012\ufffd:Y\u899c\u6458\u7482V\u001d\ufffdgR3\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2b, (byte)0xb9, (byte)0x92, 0x28, (byte)0xf9, 0x24,
  (byte)0xc9, 0x42, 0x7c, 0x13, 0x45, 0x6b, (byte)0xc0, 0x07, 0x5e,
  (byte)0xd2, 0x72, 0x41, (byte)0x82, (byte)0xa9, 0x67, (byte)0xf9, 0x76 };
str = "+\ufffd(\ufffd$\u51f5|\u0013Ek\ufffd\u0007^\u70d2A\ufffdg\u9a60";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd3, 0x79, (byte)0xca, 0x03, 0x1e, (byte)0xee,
  0x22, 0x72, (byte)0xc7, 0x5c, 0x68 };
str = "\u8356\ufffd\u0003\u001e\ufffd\"r\u3075h";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x29, (byte)0xdf, (byte)0xa6, 0x27, (byte)0xff, 0x42,
  (byte)0xbc, (byte)0xee, (byte)0xde, 0x50, (byte)0xf1, 0x3f, (byte)0xef,
  (byte)0xc6, (byte)0xa5, (byte)0xbc, 0x07, 0x53, (byte)0xd3 };
str = ")\u8240'\ufffdB\u6f97\u6ebd\ufffd?\u5e6e\u672a\u0007S\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2c };
str = "\u002c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x21, (byte)0xcb, 0x5a, (byte)0xfe, (byte)0x8f, 0x49,
  0x08, 0x57, 0x24, 0x2b, (byte)0xdd, 0x49, 0x27 };
str = "!\u6c73\ufffdI\u0008W$+\u5bd8'";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5b, 0x75, 0x0f, 0x1c, 0x33, 0x35, (byte)0xa1, 0x68,
  0x68, 0x68, (byte)0xdd, (byte)0x8e, (byte)0xc5, 0x08, (byte)0xe0, 0x7a,
  (byte)0xb5, (byte)0xb4, 0x00, 0x2d, 0x2d, 0x13, (byte)0xbb, (byte)0xb1 };
str =
  "[u\u000f\u001c35\ufe3ahh\ufffd\ufffd\u0008\u8f08\u7d55\u0000--\u0013\u8dfc";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb8, (byte)0xcb, 0x3b, (byte)0xf9, 0x05,
  (byte)0xf9, 0x5f, (byte)0xfc, (byte)0xe0, 0x51, 0x13, 0x70 };
str = "\u88dd;\ufffd\u0005\u9e10\ud854\udde6Q\u0013p";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x84, 0x4d, (byte)0x9b, 0x53, 0x59, 0x58,
  (byte)0xf3, 0x2c, (byte)0x81, 0x50, 0x46, (byte)0xda, (byte)0x99,
  (byte)0xed, 0x2c, (byte)0xe9, (byte)0xcf, (byte)0x90, (byte)0xf3,
  (byte)0x89, 0x5b, 0x37, (byte)0xb9, 0x21 };
str =

  "\ufffdM\ud84a\udd4fYX\ufffd\u002c\ufffdPF\ufffd\ufffd\u002c\u6a6a\ud865\udc1d\u56e27\ufffd!";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcc, (byte)0xa2, (byte)0xeb, (byte)0xe4, 0x48,
  0x7f, (byte)0xb3, (byte)0xd0, (byte)0x8b, 0x32, 0x33, (byte)0xcd,
  (byte)0xae, 0x71, (byte)0xa8, 0x1b, 0x40, 0x44, (byte)0xf3, (byte)0xea,
  0x6b, (byte)0xd9, 0x1b };
str =
  "\u600a\u9338H\u007f\u5275\ufffd23\u80b8q\ufffd\u001b@D\u9d73k\ufffd\u001b";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x84, (byte)0xae, 0x6e, 0x0d, 0x44, 0x07,
  (byte)0xfe, (byte)0xa5, (byte)0x91, 0x44, 0x7f, (byte)0xc3, 0x56, 0x43,
  (byte)0xc1, (byte)0xbd, 0x33, (byte)0xe0, 0x6c, 0x7c, 0x3f, (byte)0xf0,
  (byte)0xab, 0x10, (byte)0xd9, (byte)0x9b, (byte)0xc7, (byte)0xdf,
  (byte)0xdb };
str =

  "\ufffdn\rD\u0007\ud863\udc03\u98c7\u007f\u9bfdC\u8b173\u8dd0|?\u85bd\u0010\ufffd\u30e3\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x55, (byte)0xc1, 0x33, (byte)0x8b, 0x3e, 0x64,
  (byte)0xe6, (byte)0xf8, (byte)0xfd, (byte)0xb3, 0x4d, 0x14, 0x4d,
  (byte)0x8b, (byte)0xf2, 0x22 };
str = "U\ufffd3\ufffd>d\u7fec\ud85b\ude72M\u0014M\u9963\"";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x16 };
str = "\u0016";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7c, 0x59, (byte)0xb8, (byte)0xd3, 0x61, 0x50,
  (byte)0xa4, (byte)0xe0, 0x07, 0x03, 0x3e, 0x7a, 0x43, 0x32, 0x74, 0x6a,
  (byte)0xcb, (byte)0x96, (byte)0xb4, (byte)0xe6, 0x33, (byte)0x9c, 0x7d,
  0x2d, 0x3c, (byte)0xf6, (byte)0xb3, (byte)0xae };
str =
  "|Y\u8a72aP\u6208\u0007\u0003>zC2tj\ufffd\u6e543\ud85b\uddae-<\u9db6\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc7, (byte)0x88, (byte)0xe5, 0x40, (byte)0xab,
  (byte)0xec, 0x71, 0x22, (byte)0xff, (byte)0xa5, 0x11, (byte)0x87, 0x3e,
  0x15, 0x4f, 0x4d, (byte)0xe8, 0x23, 0x5c, 0x1c, (byte)0x81, 0x75,
  (byte)0x83, 0x60, 0x6f, 0x44, (byte)0xe5 };
str =

  "\ufffd\u565a\u6062q\"\ufffd\ufffd\u0011\ufffd>\u0015OM\ufffd#\\\u001c\ufffdu\ufffd`oD\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd6, 0x09, (byte)0x80, (byte)0x80, 0x0c, 0x33,
  (byte)0xd1 };
str = "\ufffd\u0009\ufffd\ufffd\u000c3\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2f, (byte)0xac, 0x54 };
str = "/\u66f7";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9d, 0x70, (byte)0x8c, (byte)0xbb, 0x26, 0x29,
  (byte)0xfe, 0x61, (byte)0xf9, 0x4b, 0x32, (byte)0x85, (byte)0xeb };
str = "\u7e9f\u9fab&)\ud845\udee7\u897b2\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x75, (byte)0xe3, 0x51, (byte)0xde, (byte)0xf0,
  (byte)0xff, 0x6c, 0x50, (byte)0xa6, 0x34, (byte)0x89, (byte)0xb6, 0x23,
  0x70, 0x27, 0x36, 0x05, (byte)0x92, 0x3b, 0x10, 0x41, 0x4f, (byte)0x95,
  0x23, 0x77, (byte)0xd8, 0x7f, (byte)0xf3, 0x47 };
str =

  "u\u7b91\u7880\ufffdlP\ufffd4\u9ec7#p'6\u0005\ufffd;\u0010AO\ufffd#w\ufffd\u007f\u8c9a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xab, 0x16, (byte)0x99, (byte)0xa1, (byte)0xb6,
  0x5a, 0x3a, (byte)0xed, (byte)0xde };
str = "\ufffd\u0016\u4413\u8ddd:\u7e36";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1a, 0x75, (byte)0xa4, 0x70, (byte)0xcf, 0x02,
  (byte)0xcc, (byte)0xc0, 0x36, (byte)0xd6, 0x7f, (byte)0xf2 };
str = "\u001au\u5c0f\ufffd\u0002\u62b86\ufffd\u007f\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd0, 0x4a, (byte)0xad, (byte)0x94, 0x20,
  (byte)0xd0, 0x42, (byte)0xe1, (byte)0x88, 0x73, 0x58, 0x7d, (byte)0x9d,
  0x52, 0x59, (byte)0x91, (byte)0xa7, 0x50, (byte)0x96, 0x34, 0x57,
  (byte)0xb8, 0x5a, (byte)0x99, 0x37, 0x62, 0x03, (byte)0x8a, 0x6b };
str =

  "\u7d03\ufffd\u0020\u7b00\ufffdsX}\ud862\udde8Y\u9d39P\ufffd4W\u7a14\ufffd7b\u0003\u3a67";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x26, 0x76, 0x3f, 0x1f, (byte)0xf8, (byte)0x96,
  (byte)0xb2, 0x20, 0x2b, 0x27, 0x6e, (byte)0xac, 0x30, (byte)0xed, 0x65,
  (byte)0x90, 0x1f, 0x4b, 0x6d, 0x60, 0x7d, 0x42, 0x04, (byte)0xed, 0x43,
  0x20 };
str =

  "&v?\u001f\ufffd\ufffd\u0020+'n\ufffd0\u736f\ufffd\u001fKm`}B\u0004\u6aa4\u0020";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x60, 0x48, 0x39, 0x08, 0x64, 0x14, 0x0f, (byte)0xae,
  0x3e, (byte)0x9c, 0x65, 0x36, (byte)0xdb };
str = "`H9\u0008d\u0014\u000f\ufffd>\ud864\udcc06\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x87, 0x56 };
str = "\ud868\udf51";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xff, 0x2e, (byte)0xd6, (byte)0xef, 0x77,
  (byte)0x80, 0x31, (byte)0x88, (byte)0xd1, (byte)0x99, 0x5b, (byte)0xa1,
  0x74, 0x03, 0x55, 0x5b, (byte)0xef, (byte)0x9f, (byte)0xd4, (byte)0xa9,
  0x23, (byte)0x82 };
str = "\ufffd.\u7d3bw\ufffd1\ufffd\u4294\ufe40\u0003U[\ufffd\u5540#\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x82, 0x2c, 0x7a, 0x48, (byte)0x93, 0x18, 0x39,
  0x61, 0x37, 0x3a, 0x3e, 0x68, 0x47, 0x7e, 0x6e };
str = "\ufffd\u002czH\ufffd\u00189a7:>hG~n";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x04, 0x28, (byte)0xff, (byte)0xda, 0x06, (byte)0x8a,
  0x50, 0x3f, 0x52, 0x20, (byte)0x84, 0x38, 0x28, 0x15, 0x30, (byte)0x99,
  (byte)0xe0, (byte)0xf3, 0x39, (byte)0xb7, (byte)0xba, 0x79, 0x25, 0x62,
  0x70, (byte)0x9f, (byte)0x90 };
str =

  "\u0004(\ufffd\ufffd\u0006\ud84b\udc38?R\u0020\ufffd8(\u00150\u8dc3\ufffd9\u6ed3y%bp\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x68, 0x66, 0x39, 0x34, 0x5d, (byte)0x96, 0x38, 0x24,
  0x20, (byte)0xc1, 0x3b, 0x7d, (byte)0xfb, (byte)0xd1, 0x1d, 0x0b, 0x02,
  0x6c, 0x7b, (byte)0xed, (byte)0x83, 0x28, 0x4e, (byte)0xee, (byte)0xff,
  0x13, (byte)0x88, 0x39, 0x0e, 0x19 };
str =

  "hf94]\ufffd8$\u0020\ufffd;}\u5bf3\u001d\u000b\u0002l\u007b\ufffd(N\ufffd\u0013\ufffd9\u000e\u0019";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd4, (byte)0xdd };
str = "\u5a43";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb1, (byte)0xd0, 0x30, 0x18, 0x3a, 0x10,
  (byte)0x82, (byte)0xde, (byte)0xd0, 0x74, 0x29, (byte)0xf7, (byte)0xbf,
  0x4e, (byte)0xc5, (byte)0xad, 0x56 };
str = "\u65590\u0018:\u0010\ufffd\u82d6)\u9ddfN\u8e91V";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdd, (byte)0xf2, (byte)0xbe, (byte)0xcf,
  (byte)0xf1, 0x6c, 0x52, (byte)0xde, 0x07, 0x31, (byte)0x9d, (byte)0x8b,
  0x37, 0x7e, 0x2d };
str = "\u692f\u61cd\u95d2R\ufffd\u00071\ufffd7~-";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3c, 0x5a, 0x2e, (byte)0xe1, (byte)0xea, (byte)0xd8,
  0x1f, 0x66, 0x5a, (byte)0xd1, (byte)0xb9, 0x2e, 0x01, (byte)0xd2,
  (byte)0xba, 0x52, 0x1d, (byte)0x81, (byte)0x8c, (byte)0xba, 0x13, 0x60 };
str = "<Z.\u6453\ufffd\u001ffZ\u63e4.\u0001\u73d8R\u001d\ufffd\ufffd\u0013`";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x82, (byte)0x94, (byte)0xb7, 0x6f, (byte)0x8e,
  0x42, (byte)0xa5, 0x70, 0x22, 0x1f, 0x6e, 0x2c, (byte)0xf0, (byte)0xdc,
  (byte)0xa5, 0x5c, (byte)0xac, (byte)0xd3, (byte)0xd8, (byte)0xe8, 0x0c,
  0x2d, (byte)0xa8 };
str =

  "\ufffd\u6417\ud85b\uded3\u53fc\"\u001fn\u002c\u8b23\u529f\u7687\u5d59\u000c-\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1c, (byte)0xaf, 0x45, (byte)0xf4, (byte)0xf0,
  (byte)0x90, (byte)0xa5, 0x56, (byte)0xde, 0x50, (byte)0x98, 0x72, 0x22,
  0x68, (byte)0xef, (byte)0xd3, 0x5c, (byte)0xa8, (byte)0xda };
str = "\u001c\u6d69\u9428\ud862\udfebV\u6ebd\u3da5\"h\u64fd\\\u4f96";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x36, (byte)0x8f, (byte)0x98, 0x72, (byte)0xe0,
  (byte)0xc4, (byte)0xc0, (byte)0xbf, (byte)0xff, 0x27, (byte)0xde, 0x2d,
  0x75, 0x74, (byte)0xf3, (byte)0xbc };
str = "6\ufffdr\u9254\u64e6\ufffd'\ufffd-ut\u9a27";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x37 };
str = "7";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbd, 0x74, (byte)0xa1, (byte)0xd3, 0x5e, 0x77,
  (byte)0xd3, 0x40, 0x14, 0x3b };
str = "\u7de3\u00b1^w\u7b04\u0014;";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x08, (byte)0xb3, (byte)0xbc, 0x36, (byte)0xc4, 0x3e,
  (byte)0xbe, (byte)0xe9, 0x4b, (byte)0xbf, 0x37, 0x50, 0x34, (byte)0xfa,
  0x60, 0x18, 0x46, (byte)0xab, 0x6e, 0x43, (byte)0x9d, 0x7f, (byte)0xea,
  0x1e, (byte)0xfd, 0x68, 0x6f, 0x0d, 0x08, (byte)0x97 };
str =

  "\u0008\u98036\ufffd>\u66b8K\ufffd7P4\ud840\udf7e\u0018F\u5357C\ufffd\u007f\ufffd\u001e\u6eb5o\r\u0008\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x64, (byte)0x86, (byte)0xbd, (byte)0xb7, 0x6d, 0x08,
  0x2d, (byte)0xcc, 0x48, (byte)0xac, 0x5a, 0x75, 0x28, 0x1a, (byte)0x9d,
  (byte)0x91, 0x55, (byte)0xfa, 0x15, 0x48, (byte)0xff, 0x7c, (byte)0xd4,
  0x6c, (byte)0xc0, 0x39, (byte)0xb6, (byte)0xc4, 0x22, 0x5b };
str =

  "d\ufffd\u6436\u0008-\u59b2\u67ecu(\u001a\ufffdU\ufffd\u0015H\ufffd|\u526e\ufffd9\u50ad\"[";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa6, 0x53, 0x49, 0x3a };
str = "\u5401I:";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4f, 0x60, 0x7b, 0x63, 0x39, 0x74, (byte)0xcc, 0x36,
  0x6e, 0x6b, (byte)0xec, 0x52, 0x55, 0x63, (byte)0xcb, 0x00, (byte)0xc8,
  (byte)0xee, (byte)0xe0, (byte)0xe4, 0x2e, (byte)0xb7, (byte)0xd2, 0x67,
  (byte)0xb0, 0x3e, (byte)0x95, 0x5c, 0x76 };
str =

  "O`\u007bc9t\ufffd6nk\u9712Uc\ufffd\u0000\u2ed6\u99af.\u7149g\ufffd>\ud859\uddadv";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9b };
str = "\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1c, 0x3a, 0x72, (byte)0x9f, 0x06, 0x2d, 0x26,
  (byte)0x8d, (byte)0xc6, 0x30, 0x70, 0x70, 0x3a, (byte)0xee, (byte)0xa5,
  0x1f, (byte)0xb7, 0x5d, (byte)0xa0, (byte)0xfe };
str = "\u001c:r\ufffd\u0006-&\u6a650pp:\u8b0b\u001f\u610d\ud858\ude6b";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x38, 0x65, 0x48, (byte)0x9e, (byte)0x8f, 0x13, 0x17,
  0x69, 0x3b, (byte)0xe8, (byte)0xd8, (byte)0xcb, (byte)0xa1, 0x26,
  (byte)0xc2, 0x5e, (byte)0xec, 0x49, 0x78, (byte)0x85, 0x38, 0x76 };
str = "8eH\ufffd\u0013\u0017i;\u9b46\u828a&\u64f7\u95b9x\ufffd8v";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdb, 0x1e, 0x02, (byte)0xc4, 0x75, (byte)0x86,
  0x2e, (byte)0xe4, 0x57, (byte)0xa8, (byte)0xa1, 0x62, 0x7a, (byte)0xde,
  (byte)0xee, 0x10, (byte)0x8a, (byte)0x90, 0x23, 0x6b, 0x4f, 0x54,
  (byte)0xdc, (byte)0xfe, 0x2c, (byte)0xb2 };
str =

  "\ufffd\u001e\u0002\u7ac7\ufffd.\u8e09\u828bbz\u7879\u0010\ufffd#kOT\u5ac6\u002c\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x78, (byte)0xeb };
str = "x\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x04, 0x25, 0x22, (byte)0x96, 0x4b, 0x74, 0x7b,
  (byte)0x8a, 0x3b, 0x66, (byte)0xfe, 0x17, 0x05, 0x59, (byte)0xae, 0x5c,
  0x13, 0x76, 0x73, 0x0c, 0x77, (byte)0xd2, 0x58, 0x76, (byte)0xe1,
  (byte)0xdc, (byte)0xa3, 0x5a, 0x5a };
str =

  "\u0004%\"\u5b11t\u007b\ufffd;f\ufffd\u0017\u0005Y\u5a09\u0013vs\u000cw\u6d97v\u645d\u03a8Z";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x82, 0x07, (byte)0xeb, 0x06, (byte)0xc0, 0x43,
  0x64, 0x44, 0x5e, 0x2e, (byte)0xbf, 0x79 };
str = "\ufffd\u0007\ufffd\u0006\u9315dD^.\u7be1";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xab, 0x77, 0x0a, (byte)0xae, (byte)0xb3, 0x79,
  (byte)0x99, 0x25, (byte)0xe9, 0x53 };
str = "\u54b8\n\u62ffy\ufffd%\u5b1b";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa9, (byte)0xd0, (byte)0xcf, 0x09, 0x58, 0x76,
  (byte)0xb4, (byte)0xe1, 0x75, (byte)0xd0, 0x69, 0x49, 0x77, (byte)0xf3,
  0x79, (byte)0xc7, (byte)0xe6, (byte)0xf3, (byte)0xa0 };
str = "\u623f\ufffd\u0009Xv\u6c2eu\u8221Iw\u96e1\u30ea\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd1, 0x53, 0x3d, (byte)0x88 };
str = "\u57b6\u003d\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6f, 0x2e, (byte)0xb7, 0x7e, 0x65, 0x69, (byte)0x82,
  (byte)0x80, (byte)0x99, (byte)0x93, 0x52, 0x6e, 0x24, 0x56, 0x4a,
  (byte)0xfc, (byte)0xaf, (byte)0x99, (byte)0x92, (byte)0xda, 0x52,
  (byte)0xc7, (byte)0x8e, 0x3a, 0x3d, 0x5a, (byte)0x82, 0x45, 0x6b, 0x4f };
str =
  "o.\u696dei\ufffd\ufffdRn$VJ\ud845\udf70\ufffd\u6e79\ufffd:\u003dZ\ufffdEkO";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb1, (byte)0xd7, 0x08, 0x5d, (byte)0xc1, 0x32,
  (byte)0xec, (byte)0xf4, 0x2e, 0x70, 0x4d, (byte)0xd5, 0x45, 0x26,
  (byte)0xcf, 0x1b, 0x62, 0x31, (byte)0xd8, (byte)0xaa };
str = "\u659c\u0008]\ufffd2\u6a96.pM\u5e3e&\ufffd\u001bb1\u581b";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf2, 0x23, 0x46, (byte)0x92, (byte)0xf6, 0x03,
  (byte)0x85, (byte)0xe1, (byte)0xd5 };
str = "\ufffd#F\ud856\udd46\u0003\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x81, 0x3c, 0x25, (byte)0xb4, (byte)0xd2,
  (byte)0xf9, (byte)0xe1, (byte)0x9e, (byte)0xf0, (byte)0xcd, 0x63, 0x25,
  0x16, (byte)0xd7, 0x55, (byte)0xb5, 0x74, 0x7c, 0x48 };
str = "\ufffd<%\u68cd\u256c\u37fb\u72da%\u0016\u823a\u774f|H";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x39, (byte)0x95, (byte)0xd2, (byte)0xa9, (byte)0xf4,
  0x35, 0x37, (byte)0x86, (byte)0x9c, 0x70, 0x43, (byte)0x81 };
str = "9\u6f79\u65fa57\ufffdpC\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf3, 0x70, 0x03, 0x70, 0x25, (byte)0x82,
  (byte)0xf8, 0x43, 0x31, (byte)0xa6, (byte)0xf8, (byte)0xb8, 0x3c, 0x42,
  (byte)0x8d, 0x50, 0x35, 0x78, 0x24 };
str = "\u93d5\u0003p%\ufffdC1\u4f3a\ufffd<B\ud85c\udfff5x$";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x74, 0x21, (byte)0xfd, 0x4b, (byte)0x9e, (byte)0xe7,
  0x74 };
str = "t!\ud84d\ude3c\u40bft";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x21, 0x6b, 0x03, 0x53, 0x5b, 0x2f, 0x2f, (byte)0xec,
  0x69, (byte)0xf4, 0x60, 0x7e, 0x69, 0x2c, (byte)0xf6, (byte)0xfa, 0x04,
  0x08, (byte)0xc7, 0x3b, (byte)0xb6, 0x60, 0x72, (byte)0xe1, (byte)0xf8,
  0x74, 0x72, 0x6a, 0x49, 0x40 };
str =
  "!k\u0003S[//\u99e7\u7031~i\u002c\u7c57\u0004\u0008\ufffd;\u8dc6r\u669ftrjI@";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4f, 0x50, 0x46, (byte)0xb2, (byte)0xa6, 0x1f, 0x6c,
  (byte)0xa3, 0x3c, 0x02, (byte)0xdc, (byte)0xa9 };
str = "OPF\u7562\u001fl\ufffd<\u0002\u976c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe0, (byte)0xaf };
str = "\u9252";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x90, 0x23, (byte)0xea, 0x22, (byte)0xaf };
str = "\ufffd#\ufffd\"\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb7, 0x3e, 0x4c, (byte)0xe2, 0x4c, (byte)0xec,
  0x57, (byte)0xea, (byte)0xf5, (byte)0xef, 0x3b };
str = "\ufffd>L\u69be\u97f0\u8255\ufffd;";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
}
@Test
public void TestBig5Encoder() {
byte[] bytes;
String str;
ICharacterEncoding charset = Encodings.GetEncoding("big5");
str = "\u56b5\u78da\u6a11";
bytes = new byte[] { (byte)0xf4, 0x40, (byte)0xbf, 0x6a, (byte)0xbc,
  (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d73";
bytes = new byte[] { (byte)0xb5, (byte)0xbc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff49";
bytes = new byte[] { (byte)0xa2, (byte)0xf1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u616b\u5e68\u6d12";
bytes = new byte[] { (byte)0xbc, (byte)0xa3, (byte)0xe9, 0x6c, (byte)0xcf,
  0x73 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6a5e\u5c90\uff11";
bytes = new byte[] { (byte)0xe9, (byte)0xd8, (byte)0xa7, (byte)0xc1,
  (byte)0xa2, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4e\u2109\u68b2";
bytes = new byte[] { (byte)0xa2, (byte)0xf6, (byte)0xa2, 0x4b, (byte)0xd5,
  (byte)0xbf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0a";
bytes = new byte[] { (byte)0xa1, (byte)0xaf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = ":\u69f3\u6703\u5354";
bytes = new byte[] { 0x3a, (byte)0xbc, (byte)0xd5, (byte)0xb7, 0x7c,
  (byte)0xa8, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u78e2\u7cd2";
bytes = new byte[] { (byte)0xea, (byte)0xaa, (byte)0xea, (byte)0xc7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u58ef\u7417";
bytes = new byte[] { (byte)0xa7, (byte)0xa7, (byte)0xfb, 0x45 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5445\u69fc\u70f4";
bytes = new byte[] { (byte)0xca, 0x7a, (byte)0xe5, (byte)0xe4, (byte)0xd6,
  0x4c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5b80\u6756\u7a1b\u6e2a\u5c6f\u7787";
bytes = new byte[] { (byte)0xc6, (byte)0xcb, (byte)0xa7, (byte)0xfa,
  (byte)0xdf, 0x40, (byte)0xfe, (byte)0xf9, (byte)0xa4, (byte)0xd9,
  (byte)0xbd, 0x4e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2193\u7449\uff1e";
bytes = new byte[] { (byte)0xa1, (byte)0xf5, (byte)0xfe, 0x5f, (byte)0xa1,
  (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d15\u7213\uff09";
bytes = new byte[] { (byte)0xaf, (byte)0xc4, (byte)0xf4, 0x6a, (byte)0xa1,
  0x5e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u61fb\u6eaa\u222b\u678d";
bytes = new byte[] { (byte)0xf2, 0x41, (byte)0xb7, (byte)0xcb, (byte)0xa1,
  (byte)0xec, (byte)0xcc, (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff57\u2410\u2170\u2e80";
bytes = new byte[] { (byte)0xa3, 0x40, (byte)0xa3, (byte)0xd0, (byte)0xc6,
  (byte)0xb5, (byte)0xc8, (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9406\u5945\u6c4d";
bytes = new byte[] { (byte)0xf5, 0x44, (byte)0xcc, 0x43, (byte)0xa6,
  (byte)0xc5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u73fdO\u758b\uff16\u6f73";
bytes = new byte[] { (byte)0xd6, 0x70, 0x4f, (byte)0xa5, (byte)0xd4,
  (byte)0xa2, (byte)0xb5, (byte)0xe2, (byte)0xa2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7490\uff5b\u5dad(";
bytes = new byte[] { (byte)0xed, 0x69, (byte)0xa1, 0x61, (byte)0xe9, 0x68,
  0x28 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5427\u7d7c\u78ca\uff4a\u69ab";
bytes = new byte[] { (byte)0xa7, 0x61, (byte)0xdf, 0x61, (byte)0xbd, 0x55,
  (byte)0xa2, (byte)0xf2, (byte)0xba, 0x67 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u54a2\u624d";
bytes = new byte[] { (byte)0xce, 0x4b, (byte)0xa4, 0x7e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff28\uff2b\u53b6";
bytes = new byte[] { (byte)0xa2, (byte)0xd6, (byte)0xa2, (byte)0xd9,
  (byte)0xc6, (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff43\u5801\uff51";
bytes = new byte[] { (byte)0xa2, (byte)0xeb, (byte)0xd4, (byte)0xc6,
  (byte)0xa2, (byte)0xf9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u77f2";
bytes = new byte[] { (byte)0xf4, 0x78 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u62c2";
bytes = new byte[] { (byte)0xa9, (byte)0xd8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u690c\u5684\u71ee\u6441";
bytes = new byte[] { (byte)0xd9, (byte)0xaa, (byte)0xec, (byte)0xc4,
  (byte)0xc0, (byte)0xe8, (byte)0xdd, (byte)0xae };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u0016\u589e\u70fc";
bytes = new byte[] { 0x16, (byte)0xbc, 0x57, (byte)0xd6, 0x52 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5347\u6b38\u5bc6\u63c9";
bytes = new byte[] { (byte)0xa4, (byte)0xc9, (byte)0xd5, (byte)0xd9,
  (byte)0xb1, 0x4b, (byte)0xb4, 0x7c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u54bc";
bytes = new byte[] { (byte)0xce, 0x4a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u76ca\u694c";
bytes = new byte[] { (byte)0xaf, 0x71, (byte)0xdd, (byte)0xe9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u77ca\u592c\u7471";
bytes = new byte[] { (byte)0xf2, 0x7a, (byte)0xc9, 0x5b, (byte)0xe2,
  (byte)0xd0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u665f\uff3d\u7a12\uff33";
bytes = new byte[] { (byte)0xd1, (byte)0xd4, (byte)0xc6, (byte)0xe5,
  (byte)0xde, (byte)0xfa, (byte)0xa2, (byte)0xe1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u8460\u72f9\u241a";
bytes = new byte[] { (byte)0xdf, (byte)0xde, (byte)0xaf, 0x55, (byte)0xa3,
  (byte)0xda };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5031\u2e95";
bytes = new byte[] { (byte)0xd0, (byte)0xdc, (byte)0xc8, (byte)0xde };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0f";
bytes = new byte[] { (byte)0xa1, (byte)0xfe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u81d1\u5b73\u5b4d\u72cc";
bytes = new byte[] { (byte)0xf0, 0x7d, (byte)0xb4, 0x46, (byte)0xf7,
  (byte)0xd5, (byte)0xcd, 0x64 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e6d";
bytes = new byte[] { (byte)0xc3, (byte)0xb5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7cfb\u6b2d\u6a94";
bytes = new byte[] { (byte)0xa8, 0x74, (byte)0xd1, (byte)0xf7, (byte)0xc0,
  (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7762\u5bea\u75dd";
bytes = new byte[] { (byte)0xb8, 0x46, (byte)0xd8, (byte)0xd0, (byte)0xda,
  (byte)0xb3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7def\u797a";
bytes = new byte[] { (byte)0xbd, 0x6e, (byte)0xb8, 0x52 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u0017\u5f63y\u6b49\u8468";
bytes = new byte[] { 0x17, (byte)0xfc, 0x51, 0x79, (byte)0xba, 0x70,
  (byte)0xdf, (byte)0xda };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u72f7\u71d5\u60b5";
bytes = new byte[] { (byte)0xaf, 0x58, (byte)0xbf, 0x50, (byte)0xb1,
  (byte)0xa3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u70ad\uff10";
bytes = new byte[] { (byte)0xac, (byte)0xb4, (byte)0xa2, (byte)0xaf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u523a";
bytes = new byte[] { (byte)0xa8, (byte)0xeb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e51\u25b3\u6dc4";
bytes = new byte[] { (byte)0xf0, 0x74, (byte)0xa1, (byte)0xb5, (byte)0xb2,
  0x64 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e6f\u7288\u7475";
bytes = new byte[] { (byte)0xf2, (byte)0xb4, (byte)0xda, 0x68, (byte)0xe2,
  (byte)0xd1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6603";
bytes = new byte[] { (byte)0xcc, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9dcf\u2514\u7cd7\u7f73\uff02";
bytes = new byte[] { (byte)0xf6, (byte)0xb8, (byte)0xa2, 0x7c, (byte)0xea,
  (byte)0xc9, (byte)0xe3, 0x7a, (byte)0xc8, (byte)0xd0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u708b\u5ddd\u2ea7";
bytes = new byte[] { (byte)0xfb, 0x63, (byte)0xa4, 0x74, (byte)0xc8,
  (byte)0xe2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6087\u7223\u7a57";
bytes = new byte[] { (byte)0xd1, (byte)0xac, (byte)0xf8, (byte)0xb1,
  (byte)0xc1, 0x4a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u64ac\u6084\u7fe9\u7c11\u6427";
bytes = new byte[] { (byte)0xbc, (byte)0xc0, (byte)0xae, (byte)0xa8,
  (byte)0xbd, (byte)0xa1, (byte)0xbf, 0x75, (byte)0xdd, (byte)0xb5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5feb\u6bd3`\u779a";
bytes = new byte[] { (byte)0xa7, (byte)0xd6, (byte)0xb7, (byte)0xb6, 0x60,
  (byte)0xea, 0x76 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u928d\u6728\u7c0a\u256a";
bytes = new byte[] { (byte)0xe4, 0x7e, (byte)0xa4, (byte)0xec, (byte)0xed,
  (byte)0xce, (byte)0xf9, (byte)0xea };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6e71\u7788";
bytes = new byte[] { (byte)0xda, 0x46, (byte)0xe6, (byte)0xbf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6831\u766a\u57fc\u2198\u5ffd\u000f";
bytes = new byte[] { (byte)0xd1, (byte)0xe2, (byte)0xf5, (byte)0xdf,
  (byte)0xd4, (byte)0xc3, (byte)0xa1, (byte)0xfb, (byte)0xa9, (byte)0xbf,
  0x0f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7c6b\uff5c\uff2c";
bytes = new byte[] { (byte)0xf8, (byte)0xfc, (byte)0xa1, 0x55, (byte)0xa2,
  (byte)0xda };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6f27\u5f4e\u7820";
bytes = new byte[] { (byte)0xe2, 0x79, (byte)0xc5, 0x73, (byte)0xaf,
  (byte)0xa3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u75cc\u6fb1";
bytes = new byte[] { (byte)0xd6, (byte)0xa2, (byte)0xbe, (byte)0xfd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u66f6\u7779\u6fef";
bytes = new byte[] { (byte)0xcc, (byte)0xd1, (byte)0xb8, 0x40, (byte)0xc0,
  (byte)0xde };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6c8b\u76e3T";
bytes = new byte[] { (byte)0xcb, 0x4f, (byte)0xba, (byte)0xca, 0x54 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7f75\u7755\u59b1";
bytes = new byte[] { (byte)0xbd, 0x7c, (byte)0xde, (byte)0xd8, (byte)0xcc,
  0x4f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u8516";
bytes = new byte[] { (byte)0xe7, 0x68 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7880\uff30\u5012";
bytes = new byte[] { (byte)0xde, (byte)0xf0, (byte)0xa2, (byte)0xde,
  (byte)0xad, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6e38\u75f2\uff26\uff44D";
bytes = new byte[] { (byte)0xb4, (byte)0xe5, (byte)0xb7, (byte)0xf2,
  (byte)0xa2, (byte)0xd4, (byte)0xa2, (byte)0xec, 0x44 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u22bf\u6e58\u5e41";
bytes = new byte[] { (byte)0xa1, (byte)0xe9, (byte)0xb4, (byte)0xf0,
  (byte)0xd8, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5308\u5f02\u794b";
bytes = new byte[] { (byte)0xa6, 0x49, (byte)0xc9, (byte)0xdd, (byte)0xcf,
  (byte)0xf6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u71d6\u6c7e\uff34";
bytes = new byte[] { (byte)0xea, 0x4b, (byte)0xa8, 0x57, (byte)0xa2,
  (byte)0xe2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5a41";
bytes = new byte[] { (byte)0xb0, (byte)0xfa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff05\u64eb";
bytes = new byte[] { (byte)0xa2, 0x48, (byte)0xec, (byte)0xeb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u69af\u2193\u9d53\uff4f";
bytes = new byte[] { (byte)0xe2, 0x4d, (byte)0xa1, (byte)0xf5, (byte)0xf1,
  (byte)0xd0, (byte)0xa2, (byte)0xf7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u511c\u6450\u7948";
bytes = new byte[] { (byte)0xe8, (byte)0xf4, (byte)0xe1, (byte)0xec,
  (byte)0xac, (byte)0xe8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7614\u661f\u62c6";
bytes = new byte[] { (byte)0xe2, (byte)0xe0, (byte)0xac, 0x50, (byte)0xa9,
  (byte)0xee };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6f44\u634f\uff05";
bytes = new byte[] { (byte)0xfd, (byte)0xcc, (byte)0xae, (byte)0xba,
  (byte)0xa2, 0x48 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d39";
bytes = new byte[] { (byte)0xb2, (byte)0xd0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u56e1\u6c9c\u7389";
bytes = new byte[] { (byte)0xc9, (byte)0xc6, (byte)0xcb, 0x58, (byte)0xa5,
  (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5e\u6897\u59b9";
bytes = new byte[] { (byte)0xa1, (byte)0xe3, (byte)0xb1, (byte)0xf0,
  (byte)0xa9, 0x66 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u71a5\u64c2";
bytes = new byte[] { (byte)0xe6, 0x6b, (byte)0xbe, (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2418\u71a0\u6e24\u6296";
bytes = new byte[] { (byte)0xa3, (byte)0xd8, (byte)0xe6, 0x66, (byte)0xb4,
  (byte)0xf1, (byte)0xa7, (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "H\u2eca\u5037";
bytes = new byte[] { 0x48, (byte)0xc8, (byte)0xea, (byte)0xd0, (byte)0xd2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u702f\u6783\u5476\u64af";
bytes = new byte[] { (byte)0xf4, 0x5d, (byte)0xcc, (byte)0xe3, (byte)0xa9,
  0x4c, (byte)0xfe, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2574\u71d0\u703b";
bytes = new byte[] { (byte)0xa1, 0x5a, (byte)0xbf, 0x4d, (byte)0xf4, 0x67 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9c36\u74a3";
bytes = new byte[] { (byte)0xf7, (byte)0xb6, (byte)0xbf, 0x59 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d6b";
bytes = new byte[] { (byte)0xda, (byte)0xf5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe2\u2419";
bytes = new byte[] { (byte)0xc8, (byte)0xcd, (byte)0xa3, (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u676a\u5c48\u6a1f";
bytes = new byte[] { (byte)0xaa, 0x57, (byte)0xa9, 0x7d, (byte)0xbc,
  (byte)0xcc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u792b\u655d";
bytes = new byte[] { (byte)0xc4, 0x74, (byte)0xb1, (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u86c0\u6689\u6a55\u6797";
bytes = new byte[] { (byte)0xb3, 0x45, (byte)0xb7, 0x75, (byte)0xe9,
  (byte)0xda, (byte)0xaa, 0x4c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u756e\u53e4\u9706";
bytes = new byte[] { (byte)0xfe, (byte)0xb4, (byte)0xa5, 0x6a, (byte)0xbe,
  0x5e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff54\u5b05";
bytes = new byte[] { (byte)0xa2, (byte)0xfc, (byte)0xe5, 0x5f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5cb8\uff14\u5d2e";
bytes = new byte[] { (byte)0xa9, (byte)0xa4, (byte)0xa2, (byte)0xb3,
  (byte)0xd5, 0x44 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6e25\u5197\u5abf";
bytes = new byte[] { (byte)0xb4, (byte)0xec, (byte)0xa4, (byte)0xbe,
  (byte)0xdc, (byte)0xfb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6e1c\u9175\u71e1";
bytes = new byte[] { (byte)0xd9, (byte)0xf6, (byte)0xbb, (byte)0xc3,
  (byte)0xed, 0x5c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3c\u530e\u5b2e";
bytes = new byte[] { (byte)0xa2, 0x40, (byte)0xd0, (byte)0xee, (byte)0xec,
  (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7838\u72a4\u65aa\u6070\u5261";
bytes = new byte[] { (byte)0xaf, 0x7b, (byte)0xf2, 0x70, (byte)0xce,
  (byte)0xe9, (byte)0xab, (byte)0xea, (byte)0xd0, (byte)0xe6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6295\u754f";
bytes = new byte[] { (byte)0xa7, (byte)0xeb, (byte)0xac, (byte)0xc8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u56de";
bytes = new byte[] { (byte)0xa6, 0x5e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u8b68\u6b67\u99c1\u7c5f";
bytes = new byte[] { (byte)0xf4, (byte)0xd1, (byte)0xaa, 0x5b, (byte)0xbb,
  (byte)0xe9, (byte)0xc5, (byte)0xa3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6a41\u653d\uff56\u501f";
bytes = new byte[] { (byte)0xe9, (byte)0xce, (byte)0xcc, (byte)0xc1,
  (byte)0xa2, (byte)0xfe, (byte)0xad, (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff44\u673e";
bytes = new byte[] { (byte)0xa2, (byte)0xec, (byte)0xc9, (byte)0xef };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u56ea\u5aa6";
bytes = new byte[] { (byte)0xa7, 0x77, (byte)0xd8, (byte)0xbc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
}
}
