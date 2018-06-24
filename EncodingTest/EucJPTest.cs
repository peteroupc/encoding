using System;
using NUnit.Framework;
using PeterO;
using PeterO.Text;
using Test;

namespace EncodingTest {
[TestFixture]
public class EucJPTest {
[Test]
public void TestEucJPDecoder() {
byte[] bytes;
string str;
ICharacterEncoding charset = Encodings.GetEncoding("euc-jp");
bytes = new byte[] { 0x77, 0x49, (byte)0xce, 0x4b, (byte)0xfb, 0x3a, 0x6b,
  0x05, 0x0e, 0x68, (byte)0xdf, 0x33, (byte)0xe1, (byte)0xe5, 0x77, 0x4c,
  (byte)0xf3, (byte)0xd0 };
str = "wI\ufffdK\ufffd:k\u0005\u000eh\ufffd3\u75f3wL\u9eb8";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6f, (byte)0x87, (byte)0xf1, 0x25, 0x1d, (byte)0xb3,
  0x38, (byte)0xca, 0x7d, 0x17, 0x7b, 0x74, (byte)0xe8, 0x29, (byte)0xf6,
  0x73, (byte)0xfa, (byte)0xfe, 0x3c, (byte)0x85, 0x73, 0x6c, 0x00,
  (byte)0x9d, 0x53 };
str =

  "o\ufffd\ufffd%\u001d\ufffd8\ufffd}\u0017\u007bt\ufffd)\ufffds\u72b1<\ufffdsl\u0000\ufffdS";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa9, 0x0a, (byte)0xf2, 0x5c, (byte)0xc6,
  (byte)0xda, 0x2b, 0x0f, (byte)0xf1, 0x33, (byte)0x85, 0x38, (byte)0x8d,
  0x0a, (byte)0xb3, 0x61, (byte)0xf0, 0x65, 0x12, (byte)0xbe, (byte)0xcf,
  0x64, 0x07, 0x2b, (byte)0xb7, 0x01, 0x74, 0x33, 0x67 };
str =

  "\ufffd\u000a\ufffd\\\u8c5a+\u000f\ufffd3\ufffd8\ufffd\u000a\ufffda\ufffde\u0012\u7ae0d\u0007+\ufffd\u0001t3g";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcc, (byte)0xa2, 0x2c, 0x47, 0x5a, (byte)0xf8,
  0x36, 0x34, (byte)0x9f, (byte)0xdc, 0x75, 0x72, 0x17, (byte)0xd5, 0x7d,
  0x13 };
str = "\u8513\u002cGZ\ufffd64\ufffd\ufffdur\u0017\ufffd}\u0013";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb4, 0x7b, 0x3b, (byte)0xa7, (byte)0xb0,
  (byte)0xef, (byte)0xc7 };
str = "\ufffd\u007b;\u041e\u9441";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xde, (byte)0x8c, (byte)0xa5, 0x2f, 0x75, 0x5c,
  (byte)0x8e, 0x5b, 0x06, 0x57, (byte)0x93, 0x54, 0x3d, (byte)0xdb, 0x34,
  0x1a, 0x66, 0x5c, 0x7e, 0x01, 0x5f, 0x4e, (byte)0x8d, 0x75, (byte)0x85 };
str =

  "\ufffd\ufffd/u\\\ufffd[\u0006W\ufffdT=\ufffd4\u001af\\~\u0001_N\ufffdu\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfd, 0x3a, (byte)0x84, 0x6e, (byte)0xdf,
  (byte)0xc1, 0x47, 0x1d, 0x35, (byte)0x84, 0x2e, 0x5d, 0x2a, 0x27,
  (byte)0xcf, 0x3e, 0x6c, (byte)0x96, 0x7f, (byte)0x95, (byte)0xee, 0x33,
  (byte)0xb4, 0x40, 0x4b, (byte)0x9a, 0x54, (byte)0xe5, (byte)0xbc };
str =

  "\ufffd:\ufffdn\u6feeG\u001d5\ufffd.]*'\ufffd>l\ufffd\u007f\ufffd\ufffd3\ufffd@K\ufffdT\u7da3";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x54, (byte)0xc8, (byte)0xd2, 0x6e };
str = "T\u9812n";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x73, 0x10, 0x4a, (byte)0xc3, (byte)0xb7, 0x36,
  (byte)0xdf, (byte)0xa8, (byte)0xde, 0x1d, 0x72, 0x28, 0x56 };
str = "s\u0010J\u6b4e6\u6f80\ufffd\u001dr(V";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc3, (byte)0xdb, 0x33, 0x54, (byte)0x96, 0x19,
  0x37, 0x20, (byte)0xd2, (byte)0xbf, 0x43, (byte)0xdf, 0x35, 0x61,
  (byte)0xca, (byte)0xe3, 0x01, 0x45, (byte)0xc1, (byte)0x93, (byte)0xd9,
  0x1e, (byte)0xe2, (byte)0xce, (byte)0xc4, 0x72, (byte)0xc9 };
str =

  "\u7bc93T\ufffd\u00197 \u5340C\ufffd5a\u752b\u0001E\ufffd\ufffd\u001e\u7765\ufffdr\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x29, (byte)0xe8, 0x1f, 0x19, (byte)0x9f, 0x69, 0x65,
  0x07, (byte)0xb8, (byte)0xe9, 0x42, (byte)0xf0, (byte)0xe2, 0x16, 0x21,
  0x5c, 0x7b, (byte)0xdf, (byte)0x94, 0x20, 0x73, 0x5d, (byte)0xb4,
  (byte)0xb7, 0x30, (byte)0xd3, 0x5b, 0x17 };
str =

  ")\ufffd\u001f\u0019\ufffdie\u0007\u6a8eB\u97a8\u0016!\\\u007b\ufffd s]\u61630\ufffd[\u0017";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf1, 0x72, 0x7c, (byte)0x88, 0x50, 0x33,
  (byte)0x9f, 0x7e, 0x77, (byte)0xde, 0x41, (byte)0xb4, 0x3d, (byte)0xce,
  (byte)0xab };
str = "\ufffdr|\ufffdP3\ufffd~w\ufffdA\ufffd=\u63a0";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x71, (byte)0xde, 0x39, 0x35, (byte)0x8d, 0x69,
  (byte)0xbe, (byte)0x93, (byte)0x9b, (byte)0xad, (byte)0xb2, (byte)0xe7,
  (byte)0xd4, (byte)0xc2, 0x05, 0x68, 0x37, (byte)0x80, (byte)0xad, 0x6a,
  0x5f, (byte)0xd4, (byte)0xdc, 0x46, (byte)0x94, 0x28, (byte)0xbd, 0x21,
  0x48 };
str =

  "q\ufffd95\ufffdi\ufffd\ufffd\u2471\u8216\ufffd\u0005h7\ufffd\ufffdj_\u58d7F\ufffd(\ufffd!H";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7b, (byte)0xbe, 0x77, 0x66, (byte)0xb9, (byte)0xd5,
  0x47, 0x71, 0x69, 0x13, (byte)0xaf, (byte)0xf8, (byte)0x83, (byte)0xe7,
  0x7d, 0x77, 0x7e, 0x1c, 0x53, (byte)0xdd, (byte)0xc0, 0x4e, (byte)0xe2,
  (byte)0xdb, 0x5d, 0x3d };
str =
  "\u007b\ufffdwf\u8861Gqi\u0013\ufffd\ufffd\ufffd}w~\u001cS\u6b59N\u77bc]=";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x36, (byte)0xc6, 0x31, 0x3d, (byte)0xdd, 0x5d, 0x36,
  (byte)0xb2, (byte)0x80, 0x16, (byte)0x85, 0x5e, (byte)0x94, (byte)0xd1,
  (byte)0xaa, 0x7b, 0x04, (byte)0xb3, 0x49, 0x19, 0x6a, 0x69 };
str =
  "6\ufffd1=\ufffd]6\ufffd\u0016\ufffd^\ufffd\u50ee\u007b\u0004\ufffdI\u0019ji";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43 };
str = "C";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9e, 0x0e, (byte)0xf8, (byte)0xc3, (byte)0xcd,
  0x04, 0x68, (byte)0xe6, (byte)0xb6, (byte)0xda, 0x13, 0x40, (byte)0xe4,
  (byte)0xeb, 0x77, (byte)0x8d, (byte)0xf0, (byte)0xef, 0x71, 0x50,
  (byte)0xfb, (byte)0xa6, (byte)0x8b, 0x5b, 0x56, 0x06 };
str =

  "\ufffd\u000e\ufffd\ufffd\u0004h\u7f94\ufffd\u0013@\u7cb3w\ufffd\u7adfqP\u73c9\ufffd[V\u0006";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb2, (byte)0xc1, 0x4b, 0x6d, 0x0a, 0x12, 0x55,
  0x33, (byte)0xd2, 0x6a, 0x07, 0x00, 0x79, (byte)0xe8, 0x40 };
str = "\u4fa1Km\u000a\u0012U3\ufffdj\u0007\u0000y\ufffd@";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x02, (byte)0xa8, 0x3d, 0x6c, 0x29, 0x1e, 0x50, 0x2d,
  (byte)0xb3, (byte)0xee, (byte)0xb5, (byte)0x89, 0x47, 0x74, (byte)0x9f,
  0x2a, 0x07, 0x34, (byte)0xc4, (byte)0x9f, 0x2b, 0x2f };
str = "\u0002\ufffd=l)\u001eP-\u4e14\ufffdGt\ufffd*\u00074\ufffd+/";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x57, 0x44, 0x6f, (byte)0x9f, (byte)0xc7, (byte)0x96,
  (byte)0x98, 0x48, (byte)0xd8, (byte)0x9a, 0x14, 0x05, 0x61, 0x77, 0x48,
  (byte)0xf6, 0x5a, (byte)0xa0, (byte)0xf5, (byte)0xad, (byte)0x8f, 0x0a,
  0x1a };
str =

  "WDo\ufffd\ufffd\ufffdH\ufffd\u0014\u0005awH\ufffdZ\ufffd\ufffd\ufffd\u000a\u001a";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5e, (byte)0xac, (byte)0xd9, (byte)0xca, 0x0a, 0x57,
  0x2a, 0x36, 0x20, 0x2d };
str = "^\ufffd\ufffd\u000aW*6 -";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb3, (byte)0x9b, (byte)0xc1, (byte)0xac, 0x2c,
  (byte)0xdb, (byte)0x91 };
str = "\ufffd\u92ad\u002c\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x42, 0x7c, (byte)0xcc, 0x1b, 0x65 };
str = "B|\ufffd\u001be";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x26, 0x4b, 0x10, (byte)0x8a, 0x0f, 0x0b, (byte)0xb9 };
str = "&K\u0010\ufffd\u000f\u000b\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x31, 0x56, 0x04, (byte)0xbd, (byte)0xbf, (byte)0xbc,
  (byte)0x87, (byte)0x94, 0x7c, 0x30, (byte)0xcc, 0x56, (byte)0xdd,
  (byte)0xf5, 0x4a, 0x03 };
str = "1V\u0004\u620e\ufffd\ufffd|0\ufffdV\u6cc4J\u0003";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x66, (byte)0xb8, 0x77, 0x30, 0x40, (byte)0x9c, 0x1a,
  0x5b, 0x49, (byte)0xe3, 0x1b, 0x2a, (byte)0xf6, (byte)0xc8, 0x36, 0x21,
  0x03, 0x27 };
str = "f\ufffdw0@\ufffd\u001a[I\ufffd\u001b*\ufffd6!\u0003'";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x65, (byte)0x82, 0x5d, 0x10, (byte)0xed, 0x7f, 0x3b,
  0x7a, 0x72, 0x05, (byte)0xff, (byte)0x92, (byte)0xb5, (byte)0x98,
  (byte)0xb5, 0x58, 0x79, (byte)0xab, 0x42, 0x22, (byte)0xf5, 0x44, 0x4d,
  0x71, 0x10, (byte)0xab, (byte)0xb7, (byte)0xf3 };
str =

  "e\ufffd]\u0010\ufffd\u007f;zr\u0005\ufffd\ufffd\ufffd\ufffdXy\ufffdB\"\ufffdDMq\u0010\ufffd\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa9, 0x51, (byte)0xde };
str = "\ufffdQ\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc4, (byte)0x91, 0x73, (byte)0xae, (byte)0xb1,
  (byte)0xea, 0x6b, 0x24, (byte)0xa0, 0x76, 0x35, 0x58, 0x3d, 0x0c,
  (byte)0xc4, (byte)0x80, 0x4f, 0x67, (byte)0xc2, 0x67, 0x71 };
str = "\ufffds\ufffd\ufffdk$\ufffdv5X=\u000c\ufffdOg\ufffdgq";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4d, 0x55, 0x05, (byte)0xe0, 0x28, 0x57, (byte)0x86,
  (byte)0xad, (byte)0xa7, (byte)0xad, (byte)0xd1, (byte)0xd0, 0x37,
  (byte)0xe1, 0x46, 0x1d };
str = "MU\u0005\ufffd(W\ufffd\u2466\u339d\ufffd7\ufffdF\u001d";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xec, 0x4f, (byte)0xa8, 0x37, (byte)0xd7 };
str = "\ufffdO\ufffd7\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x29, (byte)0xae, (byte)0xcb, 0x60, (byte)0xfe,
  (byte)0x81, 0x01, 0x27, (byte)0xf2, 0x39, 0x76, (byte)0x90 };
str = ")\ufffd`\ufffd\u0001'\ufffd9v\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf6, 0x6b, 0x66, 0x36, (byte)0xc8, (byte)0xa1,
  0x7f, (byte)0xf4, 0x32 };
str = "\ufffdkf6\u51fd\u007f\ufffd2";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3c, 0x75, (byte)0xc5, 0x16, 0x32, 0x64, (byte)0xd0,
  0x20, (byte)0xd9, 0x19, (byte)0x93, 0x1e, 0x36, 0x56, (byte)0xc2, 0x55,
  (byte)0xa5, 0x6f, (byte)0xce, (byte)0xc2, 0x26, 0x7f, 0x50, (byte)0xb1,
  (byte)0xae, 0x5a, 0x65, 0x10, (byte)0xa4, 0x41 };
str =

  "<u\ufffd\u00162d\ufffd \ufffd\u0019\ufffd\u001e6V\ufffdU\ufffdo\u6881&\u007fP\u7abaZe\u0010\ufffdA";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfd, (byte)0xcf, 0x1e, 0x36, 0x5a, 0x2b, 0x76,
  (byte)0xb9, (byte)0xf7, 0x63, 0x43, 0x37, 0x7c, (byte)0xcc, (byte)0x8d,
  0x7a, 0x31, 0x22, 0x40, (byte)0xa4 };
str = "\ufffd\u001e6Z+v\u6f09cC7|\ufffdz1\"@\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4d, 0x1e, 0x7c, (byte)0x9e, (byte)0xb2, 0x01, 0x1e,
  0x4e, 0x23, (byte)0xfb, (byte)0xf4, 0x79, 0x31, (byte)0xc3, (byte)0x86 };
str = "M\u001e|\ufffd\ufffd\u0001\u001eN#\u8d76y1\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x22, (byte)0xb6, 0x33, (byte)0xf6, 0x5e, 0x15,
  (byte)0xf2, (byte)0x80, (byte)0x9a, (byte)0xa4, 0x6d, (byte)0xb1,
  (byte)0xe6, (byte)0xab, 0x44, 0x59, 0x3f, 0x5b, 0x14 };
str = "\"\ufffd3\ufffd^\u0015\ufffd\ufffd\ufffdm\u63a9\ufffdDY?[\u0014";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdb, (byte)0x95, (byte)0x96, (byte)0xcd, 0x11,
  (byte)0x87, 0x0f, (byte)0xc4, 0x22, (byte)0xdc, (byte)0xc6, (byte)0xdb,
  (byte)0xe3, 0x3c, (byte)0xdb, (byte)0xc1, 0x5c, 0x20, 0x2c, (byte)0xce,
  0x38, 0x00, 0x3b, 0x5f, (byte)0xdb, 0x5b, 0x0c, (byte)0x8a, 0x37 };
str =

  "\ufffd\ufffd\ufffd\u0011\ufffd\u000f\ufffd\"\u69ae\u6863<\u677c\\ \u002c\ufffd8\u0000;_\ufffd[\u000c\ufffd7";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x58, (byte)0xe3, (byte)0xa0, 0x7e, (byte)0xd9, 0x7d,
  0x02, (byte)0xfa, (byte)0x81 };
str = "X\ufffd~\ufffd}\u0002\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x37, 0x7e, 0x3a, (byte)0xb0, (byte)0x90, 0x43,
  (byte)0xeb, (byte)0xed, (byte)0xf6, (byte)0xce, 0x74, 0x45, 0x1d,
  (byte)0xe4, (byte)0xab, (byte)0xcc, 0x21, 0x2a, 0x66, (byte)0xe5, 0x0c,
  0x06, (byte)0xfc, 0x05, (byte)0xb2, 0x54 };
str =

  "7~:\ufffdC\u8b10\ufffdtE\u001d\u7b70\ufffd!*f\ufffd\u000c\u0006\ufffd\u0005\ufffdT";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0c, 0x5e, 0x5d, 0x24, 0x7e };
str = "\u000c^]$~";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x81, 0x01, 0x37, (byte)0xd3, (byte)0xa6,
  (byte)0x91, 0x43, (byte)0x9f, 0x76, (byte)0xec, 0x20, 0x57, 0x45,
  (byte)0xab, (byte)0xf7, 0x6e, 0x2b, 0x18, 0x66, 0x27, 0x57, 0x02, 0x78,
  (byte)0x88, (byte)0xef, 0x01, 0x44, (byte)0xe1 };
str =

  "\ufffd\u00017\u54d8\ufffdC\ufffdv\ufffd WE\ufffdn+\u0018f'W\u0002x\ufffd\ufffd\u0001D\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x47, 0x78, (byte)0xa1 };
str = "Gx\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb5, 0x17, 0x59, 0x77, (byte)0x91, 0x01, 0x5e,
  0x71, 0x43, 0x71, (byte)0xaf, 0x07, (byte)0x8b, 0x77, (byte)0xe7, 0x1f,
  (byte)0xa1, 0x29, 0x7a, 0x00, (byte)0xcc, (byte)0xa1, 0x74, (byte)0xc3,
  (byte)0xe5, 0x55 };
str =

  "\ufffd\u0017Yw\ufffd\u0001^qCq\ufffd\u0007\ufffdw\ufffd\u001f\ufffd)z\u0000\u6f2bt\u7740U";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x32, 0x32 };
str = "22";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbd, 0x21, (byte)0x8b, 0x66, 0x6c, (byte)0xd3,
  0x47, 0x65, (byte)0xdd };
str = "\ufffd!\ufffdfl\ufffdGe\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x46, (byte)0xc9, (byte)0xc3, 0x6f, (byte)0xd4, 0x3d,
  (byte)0xe6, 0x06, 0x4a, 0x38, (byte)0xcc, (byte)0x9b, (byte)0xfb, 0x54,
  0x5d, (byte)0xa1, (byte)0xae };
str = "F\u79d2o\ufffd=\ufffd\u0006J8\ufffd\ufffdT]\uff40";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4d, 0x22, (byte)0xb5, (byte)0xf8, 0x5e, 0x7d, 0x40,
  (byte)0xb8, 0x47, (byte)0xd8, (byte)0xd6, 0x4e, (byte)0x82, (byte)0xdd,
  (byte)0xb6, 0x35, 0x34, (byte)0xcb, 0x2e, 0x71, (byte)0xbb, (byte)0xf0,
  (byte)0xec, (byte)0xbf, 0x0b, (byte)0x92, 0x70, 0x6e, (byte)0xeb };
str =

  "M\"\u92f8^}@\ufffdG\u615fN\ufffd\u6b1f54\ufffd.q\u8aee\u8c8e\u000b\ufffdpn\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x63, (byte)0xbf, (byte)0x9b, (byte)0xfe, (byte)0xb9,
  (byte)0xaa, (byte)0xc3, (byte)0xae, 0x5f, 0x3e, (byte)0xbe, 0x20,
  (byte)0xd9, 0x53, 0x2c, 0x53, (byte)0x8a, 0x27, 0x3e, 0x21, 0x19,
  (byte)0x8a, 0x29, 0x7f, 0x20, (byte)0xb9 };
str =

  "c\ufffd\ufffd\ufffd\ufffd_>\ufffd \ufffdS\u002cS\ufffd'>!\u0019\ufffd)\u007f \ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x61, (byte)0xaf, 0x37 };
str = "a\ufffd7";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xef, 0x57, (byte)0x87, 0x20, (byte)0x97,
  (byte)0xfc, (byte)0xa1, 0x34, 0x54, (byte)0xee, 0x61, 0x74, 0x46,
  (byte)0xce, (byte)0xbc, (byte)0xe0, (byte)0x8a, (byte)0xa2, 0x3b,
  (byte)0xf6, 0x10, 0x7a, 0x18 };
str =
  "\ufffdW\ufffd \ufffd\u91d74T\ufffdatF\u4eae\ufffd\ufffd;\ufffd\u0010z\u0018";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x18, 0x40, 0x5d, 0x28, (byte)0xd5, (byte)0x8c,
  (byte)0xc1, 0x6b, (byte)0xe1 };
str = "\u0018@](\ufffd\ufffdk\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x56, 0x4b, (byte)0xfe, (byte)0xf8, (byte)0xc2, 0x6d,
  (byte)0xd8, (byte)0xda, 0x71, 0x4e, (byte)0xc8 };
str = "VK\ufffd\ufffdm\u6199qN\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xad, 0x5e, (byte)0x98, 0x5f, 0x4b, (byte)0x83,
  0x1c, (byte)0xdb, 0x57, (byte)0xbf, 0x2d, 0x23, (byte)0x8f, 0x7d, 0x51,
  0x41, (byte)0xb5, 0x3c, 0x26, (byte)0xf6, 0x35, 0x77, 0x6e, (byte)0xb6 };
str =
  "\ufffd^\ufffd_K\ufffd\u001c\ufffdW\ufffd-#\ufffd}QA\ufffd<&\ufffd5wn\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb5, (byte)0xbd, 0x35, (byte)0xa6, 0x00,
  (byte)0xe6, 0x3c, 0x66, 0x54, (byte)0xc3, 0x51, (byte)0x9b, (byte)0x9a,
  0x13 };
str = "\u6b3a5\ufffd\u0000\ufffd<fT\ufffdQ\ufffd\ufffd\u0013";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x62, 0x44, 0x20 };
str = "bD ";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x06, 0x5d, 0x2f, (byte)0xda, 0x4a, 0x40, 0x6b, 0x31,
  (byte)0xfd, (byte)0xf1, 0x79, (byte)0xb5, 0x12, 0x66, 0x16, (byte)0xd8,
  0x25, (byte)0x98, (byte)0xbb };
str = "\u0006]/\ufffdJ@k1\ufffdy\ufffd\u0012f\u0016\ufffd%\ufffd\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x83, 0x12, 0x33, 0x24, (byte)0xc2 };
str = "\ufffd\u00123$\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9c, 0x0e, (byte)0x88, 0x69, 0x28, (byte)0x98,
  0x25, 0x67, 0x40, 0x06, (byte)0x95, 0x22, 0x08, 0x2b, 0x15, (byte)0xf5,
  0x06, 0x24, 0x00, 0x19, (byte)0xcb, (byte)0x9f, 0x6e, (byte)0xa6,
  (byte)0xc3 };
str =

  "\ufffd\u000e\ufffdi(\ufffd%g@\u0006\ufffd\"\u0008+\u0015\ufffd\u0006$\u0000\u0019\ufffdn\u03b3";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x56, 0x4b, (byte)0xc7, (byte)0xd3 };
str = "VK\u6392";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x61, (byte)0xee, (byte)0xb4, (byte)0xbf, (byte)0xdc,
  0x57, (byte)0xab, 0x28, 0x1c, (byte)0x80, 0x4d, 0x22, 0x6d, (byte)0xc9,
  0x61, 0x50, 0x59, (byte)0xc6, 0x4f, (byte)0xb2, (byte)0xdd, 0x78, 0x1b,
  (byte)0xb4, (byte)0x87, (byte)0xd0, 0x2e, (byte)0xec };
str =

  "a\u908a\u9808W\ufffd(\u001c\ufffdM\"m\ufffdaPY\ufffdO\u8ab2x\u001b\ufffd\ufffd.\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x08, 0x11, 0x40, 0x06, 0x2d, 0x39, 0x08, 0x76,
  (byte)0xef, 0x7a, 0x7d, 0x57, 0x13, (byte)0xd5, (byte)0xa7, 0x75,
  (byte)0x99, (byte)0x99, 0x42, 0x6d, 0x19, 0x6c, (byte)0xa5, 0x12, 0x49,
  0x01, 0x7d, (byte)0x94, (byte)0xdc };
str =

  "\u0008\u0011@\u0006-9\u0008v\ufffdz}W\u0013\u59b2u\ufffd\ufffdBm\u0019l\ufffd\u0012I\u0001}\ufffd\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x76, 0x69, (byte)0xc6, 0x21, (byte)0x83, 0x7b,
  (byte)0xa1, (byte)0xc0, (byte)0xcd, (byte)0xb4, 0x77 };
str = "vi\ufffd!\ufffd\u007b\uff3c\u7950w";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa1, 0x63, 0x2d, (byte)0xbc, (byte)0x85,
  (byte)0xd0, 0x3d, (byte)0x96, (byte)0xe3, 0x22, (byte)0xbb, (byte)0xeb,
  (byte)0xcb, 0x31, (byte)0xc0 };
str = "\ufffdc-\ufffd\ufffd=\ufffd\ufffd\"\u8996\ufffd1\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xab, (byte)0xf1, 0x1b, 0x1d, 0x40, 0x48, 0x65,
  (byte)0xbd, 0x27, 0x07 };
str = "\ufffd\u001b\u001d@He\ufffd'\u0007";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf3, 0x70, (byte)0xd7, (byte)0x84, 0x0b,
  (byte)0xe5, 0x25, 0x4b, 0x24, 0x3c, 0x00, 0x4a, 0x79 };
str = "\ufffdp\ufffd\u000b\ufffd%K$<\u0000Jy";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4b, (byte)0xea, 0x42, 0x62, 0x2f, 0x12, 0x6f, 0x15,
  (byte)0xe3 };
str = "K\ufffdBb/\u0012o\u0015\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc0, 0x66, 0x69, (byte)0xd4, 0x63, (byte)0xa6,
  (byte)0xa8, (byte)0x80, (byte)0x8e, 0x66, 0x38, (byte)0xd8, (byte)0x9f,
  (byte)0x81, 0x07, (byte)0xaf, 0x45, 0x30, 0x3b, 0x0a, (byte)0xcb };
str =
  "\ufffdfi\ufffdc\u0398\ufffd\ufffdf8\ufffd\ufffd\u0007\ufffdE0;\u000a\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfd, 0x50, 0x05, (byte)0xc4, 0x43, (byte)0xf6,
  (byte)0xc8, 0x76, 0x76, 0x57, (byte)0xd7, (byte)0xe6, (byte)0xf0, 0x33,
  (byte)0xee };
str = "\ufffdP\u0005\ufffdC\ufffdvvW\u6015\ufffd3\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7b, (byte)0xf3, 0x4d, (byte)0xad, 0x33, 0x39, 0x35,
  (byte)0xdb, 0x18, 0x6f, (byte)0xdf };
str = "\u007b\ufffdM\ufffd395\ufffd\u0018o\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43, 0x57, 0x2e, 0x25, (byte)0xa7, 0x5e, (byte)0xd5,
  (byte)0x8e, 0x7a, (byte)0xb5, 0x7e, 0x53, 0x65, (byte)0x8d };
str = "CW.%\ufffd^\ufffdz\ufffd~Se\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xde, 0x32, (byte)0x8c, (byte)0x8e, 0x0d, 0x5e };
str = "\ufffd2\ufffd\ufffd\u000d^";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe7, 0x42, (byte)0xa3, 0x5a, 0x07, (byte)0xed,
  0x13, 0x1d, (byte)0xbc, 0x2b, (byte)0xd4, 0x5d, 0x07, 0x1f, (byte)0x8d };
str = "\ufffdB\ufffdZ\u0007\ufffd\u0013\u001d\ufffd+\ufffd]\u0007\u001f\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xef, 0x67, 0x4d };
str = "\ufffdgM";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf4, 0x75, (byte)0xfc, (byte)0xf8, 0x79,
  (byte)0xec, (byte)0xf3 };
str = "\ufffdu\u2177y\u8e08";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4f, (byte)0xaf, 0x6a, 0x43, (byte)0xaf, 0x1d, 0x51,
  0x13, (byte)0xc5, (byte)0xe0 };
str = "O\ufffdjC\ufffd\u001dQ\u0013\u51cd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1a, 0x06, (byte)0xab, 0x28, (byte)0xae, 0x4d,
  (byte)0xe4, 0x61, 0x2c, (byte)0xee, (byte)0xce, (byte)0x98, (byte)0xa8,
  (byte)0xb8, 0x17, 0x6e, (byte)0xea, (byte)0xcc };
str = "\u001a\u0006\ufffd(\ufffdM\ufffda\u002c\u9182\ufffd\u252f\u0017n\u885e";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf8, (byte)0xac, 0x24, 0x23, 0x0e, (byte)0xef,
  0x6a, 0x26, 0x04 };
str = "\ufffd$#\u000e\ufffdj&\u0004";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6d, 0x01, (byte)0x91, (byte)0xf8, 0x74, (byte)0x95,
  0x6e, 0x5b, (byte)0xe8, (byte)0x9e, 0x7f, (byte)0xdf, 0x36, (byte)0xb9,
  0x61, 0x04, (byte)0xbe, 0x64, (byte)0x9b, 0x26, 0x73, 0x40, 0x2c };
str =

  "m\u0001\ufffd\ufffdt\ufffdn[\ufffd\u007f\ufffd6\ufffda\u0004\ufffdd\ufffd&s@\u002c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x67, 0x32, 0x30, (byte)0xc9, (byte)0x90, (byte)0xda };
str = "g20\ufffd\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbb, 0x28, (byte)0x87, (byte)0x94, 0x53, 0x60,
  (byte)0xc3, 0x32, 0x60, 0x49, 0x2c, (byte)0x93, (byte)0xbf, (byte)0xfc,
  (byte)0xda, 0x2e, 0x40, 0x08, (byte)0x81, 0x22, 0x43, (byte)0xb1 };
str =

  "\ufffd(\ufffd\ufffdS`\ufffd2`I\u002c\ufffd\u9817\ufffd.@\u0008\ufffd\"C\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe0, 0x2a, (byte)0xf2, (byte)0xe1, 0x2a, 0x69,
  (byte)0xbb, 0x2a, (byte)0x99, 0x62, (byte)0xb3, 0x62, 0x29, (byte)0xec,
  0x3f, (byte)0xbb, 0x58, 0x3c, (byte)0xf3, (byte)0xac, (byte)0xa5,
  (byte)0xd8, 0x4b, 0x6b, 0x58, 0x1a, (byte)0xfb, 0x35, 0x3f, 0x4c };
str =

  "\ufffd*\u9c47*i\ufffd*\ufffdb\ufffdb)\ufffd?\ufffdX<\u9d7a\u30d8KkX\u001a\ufffd5?L";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x75, (byte)0xfe, 0x69, 0x4b, 0x1a, 0x14, 0x0c, 0x7c };
str = "u\ufffdiK\u001a\u0014\u000c|";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7f, 0x4d, (byte)0xcf, 0x67, 0x6e, (byte)0xd0,
  (byte)0xd7, 0x1b, 0x50, (byte)0xea, 0x0c, 0x0f, 0x10, 0x7d, (byte)0x8d,
  0x39, (byte)0xca, (byte)0xd5, (byte)0xaf, 0x6a, 0x1c, (byte)0x8f,
  (byte)0xbc, 0x5d, (byte)0xf7 };
str =

  "\u007fM\ufffdgn\u4fd4\u001bP\ufffd\u000c\u000f\u0010}\ufffd9\u8fba\ufffdj\u001c\ufffd]\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x71, 0x05, 0x6e, (byte)0xb4, (byte)0xe6, (byte)0xa8,
  0x7a, (byte)0x9e, 0x3a };
str = "q\u0005n\u8d0b\ufffdz\ufffd:";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfc, 0x11, (byte)0xf8, (byte)0x81, 0x53,
  (byte)0x98, 0x2e, (byte)0xcd, 0x3f, (byte)0xfc, (byte)0x95, (byte)0xe2,
  0x61, 0x06, 0x60, 0x21, 0x4c, 0x6c, 0x36, (byte)0xd2, 0x6b, 0x0e, 0x6d,
  (byte)0xf3, (byte)0xb5, 0x54 };
str =

  "\ufffd\u0011\ufffdS\ufffd.\ufffd?\ufffd\ufffda\u0006`!Ll6\ufffdk\u000em\u9dbaT";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x32, (byte)0x95, 0x32, (byte)0xb5, 0x4b, 0x31,
  (byte)0xc4, (byte)0xfc, 0x1d, 0x30, (byte)0xaa, (byte)0xfc, 0x0d,
  (byte)0x99, (byte)0xa2, (byte)0xca, (byte)0xeb, (byte)0xfc, 0x3d, 0x3e };
str = "2\ufffd2\ufffdK1\u8ae6\u001d0\ufffd\u000d\ufffd\u2227\u8b5b=>";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43, (byte)0xc8, 0x35, 0x61, 0x0e, 0x22, 0x43, 0x2c };
str = "C\ufffd5a\u000e\"C\u002c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbf, (byte)0xe1, (byte)0xc7, (byte)0x97,
  (byte)0x80, (byte)0xec, 0x14, (byte)0xaa, 0x4c, 0x4b, 0x30, 0x6e,
  (byte)0xcc };
str = "\u5439\ufffd\ufffd\ufffd\u0014\ufffdLK0n\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x49, 0x6e, 0x76, (byte)0xf4, 0x7c, 0x7d, (byte)0x9e,
  (byte)0xdf, (byte)0x8d, 0x55, (byte)0xcf, (byte)0xfa, (byte)0xa1,
  (byte)0xfa, 0x38, 0x41, (byte)0xda, (byte)0xb5, 0x76, (byte)0xd9,
  (byte)0xf6, (byte)0x92 };
str = "Inv\ufffd|}\ufffd\ufffdU\ufffd\u26058A\u6500v\u6476\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x62, (byte)0xd9, 0x46, 0x71, 0x48, (byte)0x82, 0x4b,
  0x3a, 0x0a, 0x3c, (byte)0xe6, 0x7f, (byte)0xa8, (byte)0xff, 0x40,
  (byte)0xa6, 0x65, (byte)0xa6, 0x79, (byte)0xe2 };
str = "b\ufffdFqH\ufffdK:\u000a<\ufffd\u007f\ufffd@\ufffde\ufffdy\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x90, 0x2c, (byte)0xf6, (byte)0xaa, (byte)0x82,
  0x78, 0x31, 0x6b, (byte)0xf0, 0x2b, 0x2f, (byte)0x89, 0x78, (byte)0x96,
  0x4a, 0x2d, 0x15, (byte)0xac, 0x60, 0x02, 0x3f };
str = "\ufffd\u002c\ufffd\ufffdx1k\ufffd+/\ufffdx\ufffdJ-\u0015\ufffd`\u0002?";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2e, (byte)0x87, (byte)0x93, 0x47, (byte)0xe8 };
str = ".\ufffd\ufffdG\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2e, (byte)0xac, 0x0b, (byte)0xe0, 0x7b, (byte)0x9a,
  (byte)0x80, 0x09, 0x0c, 0x65, 0x2c, 0x23, 0x57, 0x30, (byte)0xd6, 0x29,
  0x50, (byte)0xd4, 0x6e, 0x7b, 0x53, (byte)0xc7, 0x1e, 0x25, 0x7f, 0x32,
  (byte)0xc7 };
str =

  ".\ufffd\u000b\ufffd\u007b\ufffd\ufffd\u0009\u000ce\u002c#W0\ufffd)P\ufffdn\u007bS\ufffd\u001e%\u007f2\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x66, 0x41, 0x4a, (byte)0xd4, (byte)0xf4, 0x0c,
  (byte)0xcc, (byte)0xab };
str = "fAJ\u7ad2\u000c\u6e4a";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd9, (byte)0xbc, (byte)0xee };
str = "\u62cf\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43, 0x42, 0x4b, 0x37, (byte)0xa3, (byte)0xdb, 0x3f,
  0x34, 0x22, 0x18, 0x16, (byte)0xc8, (byte)0xc7, (byte)0xb3, (byte)0xb6,
  (byte)0xc4, 0x49, (byte)0xac, (byte)0xf3, 0x39, (byte)0xd0, 0x21,
  (byte)0xb8 };
str = "CBK7\ufffd?4\"\u0018\u0016\u7248\u6daf\ufffdI\ufffd9\ufffd!\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0f, 0x73, (byte)0x9c, (byte)0xbe, 0x41, 0x1d, 0x1f,
  0x41, (byte)0x8c, 0x29, (byte)0x8c, 0x72, (byte)0xec };
str = "\u000fs\ufffd\ufffdA\u001d\u001fA\ufffd)\ufffdr\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x77, 0x3e, (byte)0xb0, 0x55, (byte)0xc4, 0x34,
  (byte)0xd9, 0x00, 0x22 };
str = "w>\ufffdU\ufffd4\ufffd\u0000\"";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa7, (byte)0xb4, (byte)0x83, 0x33, (byte)0xb5,
  0x64, (byte)0xed, 0x6b, 0x67, (byte)0xa1, 0x63, (byte)0xf0 };
str = "\u0422\ufffd3\ufffdd\ufffdkg\ufffdc\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
}[Test]
public void TestEucJPEncoder() {
byte[] bytes;
string str;
ICharacterEncoding charset = Encodings.GetEncoding("euc-jp");
str = "\u5eda";
bytes = new byte[] { (byte)0xd7, (byte)0xa4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7cde\u69b2";
bytes = new byte[] { (byte)0xca, (byte)0xb5, (byte)0xdc, (byte)0xc5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u71ec\u2010";
bytes = new byte[] { (byte)0xdf, (byte)0xfb, (byte)0xa1, (byte)0xbe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0c#\uff48";
bytes = new byte[] { (byte)0xa1, (byte)0xa4, 0x23, (byte)0xa3, (byte)0xe8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7b36\uff0a\u5c8c";
bytes = new byte[] { (byte)0xe3, (byte)0xfd, (byte)0xa1, (byte)0xf6,
  (byte)0xd6, (byte)0xa9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff49\u6cb8";
bytes = new byte[] { (byte)0xa3, (byte)0xe9, (byte)0xca, (byte)0xa8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3f\u51f5\u5b66\uff39";
bytes = new byte[] { (byte)0xa1, (byte)0xb2, (byte)0xd1, (byte)0xe1,
  (byte)0xb3, (byte)0xd8, (byte)0xa3, (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u66fd\u696e\u590b";
bytes = new byte[] { (byte)0xc1, (byte)0xbe, (byte)0xdc, (byte)0xba,
  (byte)0xf9, (byte)0xe3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9a5b";
bytes = new byte[] { (byte)0xf1, (byte)0xe3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5a\uff49\uff66\uff66";
bytes = new byte[] { (byte)0xa3, (byte)0xfa, (byte)0xa3, (byte)0xe9,
  (byte)0x8e, (byte)0xa6, (byte)0x8e, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "g\uff95\u5e7f";
bytes = new byte[] { 0x67, (byte)0x8e, (byte)0xd5, (byte)0xd6, (byte)0xf8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff93\u5e37\u7ae1";
bytes = new byte[] { (byte)0x8e, (byte)0xd3, (byte)0xd6, (byte)0xe9,
  (byte)0xe3, (byte)0xee };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9027";
bytes = new byte[] { (byte)0xed, (byte)0xfa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2d";
bytes = new byte[] { (byte)0xa3, (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u798e\uff31";
bytes = new byte[] { (byte)0xc4, (byte)0xf7, (byte)0xa3, (byte)0xd1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u61fc";
bytes = new byte[] { (byte)0xd8, (byte)0xf6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6f5c";
bytes = new byte[] { (byte)0xc0, (byte)0xf8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0e\uff2d";
bytes = new byte[] { (byte)0xa1, (byte)0xa5, (byte)0xa3, (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff89\u5080";
bytes = new byte[] { (byte)0x8e, (byte)0xc9, (byte)0xd0, (byte)0xfa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff58";
bytes = new byte[] { (byte)0xa3, (byte)0xf8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "z\uff66";
bytes = new byte[] { 0x7a, (byte)0x8e, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u752c\u79bd\uff25";
bytes = new byte[] { (byte)0xe1, (byte)0xb5, (byte)0xb6, (byte)0xd9,
  (byte)0xa3, (byte)0xc5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u25ef\u72fd\u6fe4";
bytes = new byte[] { (byte)0xa2, (byte)0xfe, (byte)0xc7, (byte)0xe2,
  (byte)0xde, (byte)0xb9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff72\u6ede\u5360";
bytes = new byte[] { (byte)0x8e, (byte)0xb2, (byte)0xc2, (byte)0xda,
  (byte)0xc0, (byte)0xea };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff52\uff46\uff1f\uff3a\uff56";
bytes = new byte[] { (byte)0xa3, (byte)0xf2, (byte)0xa3, (byte)0xe6,
  (byte)0xa1, (byte)0xa9, (byte)0xa3, (byte)0xda, (byte)0xa3, (byte)0xf6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6a\uff68\uff7d";
bytes = new byte[] { (byte)0x8e, (byte)0xaa, (byte)0x8e, (byte)0xa8,
  (byte)0x8e, (byte)0xbd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u546a\u7f6eT";
bytes = new byte[] { (byte)0xbc, (byte)0xf6, (byte)0xc3, (byte)0xd6, 0x54 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5b95";
bytes = new byte[] { (byte)0xc5, (byte)0xe6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u67a9\u53b3\u2030";
bytes = new byte[] { (byte)0xdb, (byte)0xc0, (byte)0xb8, (byte)0xb7,
  (byte)0xa2, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff71\u807d\u52f3";
bytes = new byte[] { (byte)0x8e, (byte)0xb1, (byte)0xe6, (byte)0xe5,
  (byte)0xd2, (byte)0xae };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff74\u222a\uff4c\uff1d";
bytes = new byte[] { (byte)0x8e, (byte)0xb4, (byte)0xa2, (byte)0xc0,
  (byte)0xa3, (byte)0xec, (byte)0xa1, (byte)0xe1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6562\u512a\u5c0b";
bytes = new byte[] { (byte)0xb4, (byte)0xba, (byte)0xcd, (byte)0xa5,
  (byte)0xbf, (byte)0xd2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff72\u671f\uff4f";
bytes = new byte[] { (byte)0x8e, (byte)0xb2, (byte)0xb4, (byte)0xfc,
  (byte)0xa3, (byte)0xef };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3d";
bytes = new byte[] { (byte)0xa1, (byte)0xcf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u659c\u9055\u5264";
bytes = new byte[] { (byte)0xbc, (byte)0xd0, (byte)0xb0, (byte)0xe3,
  (byte)0xba, (byte)0xde };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u53f7\u6926\uff82";
bytes = new byte[] { (byte)0xb9, (byte)0xe6, (byte)0xdb, (byte)0xfb,
  (byte)0x8e, (byte)0xc2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7bc4_\uff5c";
bytes = new byte[] { (byte)0xc8, (byte)0xcf, 0x5f, (byte)0xa1, (byte)0xc3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u79d5\u832b";
bytes = new byte[] { (byte)0xe3, (byte)0xbe, (byte)0xe8, (byte)0xab };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6b\uff0e\uff4a";
bytes = new byte[] { (byte)0x8e, (byte)0xab, (byte)0xa1, (byte)0xa5,
  (byte)0xa3, (byte)0xea };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6492\u7e96\u6ec9";
bytes = new byte[] { (byte)0xbb, (byte)0xb5, (byte)0xe5, (byte)0xf9,
  (byte)0xde, (byte)0xe6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u007f\u5e96\u52fa\uff08\u721bt\u652f";
bytes = new byte[] { 0x7f, (byte)0xca, (byte)0xf9, (byte)0xbc, (byte)0xdb,
  (byte)0xa1, (byte)0xca, (byte)0xe0, (byte)0xa5, 0x74, (byte)0xbb,
  (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u745c\u68c4\u5351";
bytes = new byte[] { (byte)0xe0, (byte)0xf1, (byte)0xb4, (byte)0xfe,
  (byte)0xc8, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff8c\u5a35";
bytes = new byte[] { (byte)0x8e, (byte)0xcc, (byte)0xd5, (byte)0xb7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff19\u6210";
bytes = new byte[] { (byte)0xa3, (byte)0xb9, (byte)0xc0, (byte)0xae };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff23\u91e1\u7011";
bytes = new byte[] { (byte)0xa3, (byte)0xc3, (byte)0xee, (byte)0xdd,
  (byte)0xdf, (byte)0xc6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u71c9";
bytes = new byte[] { (byte)0xdf, (byte)0xf7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6e98";
bytes = new byte[] { (byte)0xde, (byte)0xe5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4f";
bytes = new byte[] { (byte)0xa3, (byte)0xef };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff99\uff9b";
bytes = new byte[] { (byte)0x8e, (byte)0xd9, (byte)0x8e, (byte)0xdb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u73ed\uff8f\uff13";
bytes = new byte[] { (byte)0xc8, (byte)0xc9, (byte)0x8e, (byte)0xcf,
  (byte)0xa3, (byte)0xb3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "'\u788d";
bytes = new byte[] { 0x27, (byte)0xb3, (byte)0xb7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff24\u5be9\u67dd\u5761";
bytes = new byte[] { (byte)0xa3, (byte)0xc4, (byte)0xbf, (byte)0xb3,
  (byte)0xdb, (byte)0xd1, (byte)0xd4, (byte)0xb3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff74";
bytes = new byte[] { (byte)0x8e, (byte)0xb4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff93\uff84\u7b99";
bytes = new byte[] { (byte)0x8e, (byte)0xd3, (byte)0x8e, (byte)0xc4,
  (byte)0xe4, (byte)0xb9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4e";
bytes = new byte[] { (byte)0xa3, (byte)0xee };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7897\uff1d";
bytes = new byte[] { (byte)0xcf, (byte)0xd2, (byte)0xa1, (byte)0xe1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6d88";
bytes = new byte[] { (byte)0xbe, (byte)0xc3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u633e\uffe1\uff0f";
bytes = new byte[] { (byte)0xd9, (byte)0xd1, (byte)0xa1, (byte)0xf2,
  (byte)0xa1, (byte)0xbf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u58a8\uff55";
bytes = new byte[] { (byte)0xcb, (byte)0xcf, (byte)0xa3, (byte)0xf5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff28";
bytes = new byte[] { (byte)0xa3, (byte)0xc8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff97";
bytes = new byte[] { (byte)0x8e, (byte)0xd7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6e";
bytes = new byte[] { (byte)0x8e, (byte)0xae };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3a";
bytes = new byte[] { (byte)0xa3, (byte)0xda };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u69eb\uffe5\uff9b";
bytes = new byte[] { (byte)0xdc, (byte)0xe7, (byte)0xa1, (byte)0xef,
  (byte)0x8e, (byte)0xdb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u63a8";
bytes = new byte[] { (byte)0xbf, (byte)0xe4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "T\u7d72\uff2b";
bytes = new byte[] { 0x54, (byte)0xe5, (byte)0xaf, (byte)0xa3, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u000f\u51ed\u6659";
bytes = new byte[] { 0x0f, (byte)0xd1, (byte)0xdf, (byte)0xfa, (byte)0xbd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u59e5";
bytes = new byte[] { (byte)0xb1, (byte)0xb8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e0b\u5ef4\uff42\u9d28";
bytes = new byte[] { (byte)0xe5, (byte)0xd7, (byte)0xd7, (byte)0xae,
  (byte)0xa3, (byte)0xe2, (byte)0xb3, (byte)0xfb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7582\uff0a\u6216";
bytes = new byte[] { (byte)0xe1, (byte)0xca, (byte)0xa1, (byte)0xf6,
  (byte)0xb0, (byte)0xbf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7425\u59ac";
bytes = new byte[] { (byte)0xe0, (byte)0xe8, (byte)0xc5, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff96";
bytes = new byte[] { (byte)0x8e, (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6d\u7ae1";
bytes = new byte[] { (byte)0x8e, (byte)0xad, (byte)0xe3, (byte)0xee };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5716\uff8c\u2469";
bytes = new byte[] { (byte)0xd4, (byte)0xa6, (byte)0x8e, (byte)0xcc,
  (byte)0xad, (byte)0xaa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u226b\uff62\uff3e\uff97\uff40";
bytes = new byte[] { (byte)0xa2, (byte)0xe4, (byte)0x8e, (byte)0xa2,
  (byte)0xa1, (byte)0xb0, (byte)0x8e, (byte)0xd7, (byte)0xa1, (byte)0xae };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u56d8\u2025\u524d";
bytes = new byte[] { (byte)0xd1, (byte)0xc5, (byte)0xa1, (byte)0xc5,
  (byte)0xc1, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5a9b";
bytes = new byte[] { (byte)0xc9, (byte)0xb2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u74ca\uff9b";
bytes = new byte[] { (byte)0xe0, (byte)0xfb, (byte)0x8e, (byte)0xdb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe2";
bytes = new byte[] { (byte)0xa2, (byte)0xcc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff24\uff53";
bytes = new byte[] { (byte)0xa3, (byte)0xc4, (byte)0xa3, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2266\uff8f\u79fb";
bytes = new byte[] { (byte)0xa1, (byte)0xe5, (byte)0x8e, (byte)0xcf,
  (byte)0xb0, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6991\u5713\uff81";
bytes = new byte[] { (byte)0xdc, (byte)0xd4, (byte)0xd4, (byte)0xa4,
  (byte)0x8e, (byte)0xc1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "|\uff6b\u2502";
bytes = new byte[] { 0x7c, (byte)0x8e, (byte)0xab, (byte)0xa8, (byte)0xa2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6027\u7136\u53ad";
bytes = new byte[] { (byte)0xc0, (byte)0xad, (byte)0xc1, (byte)0xb3,
  (byte)0xb1, (byte)0xde };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff99\u5bc5\uffe2";
bytes = new byte[] { (byte)0x8e, (byte)0xd9, (byte)0xc6, (byte)0xd2,
  (byte)0xa2, (byte)0xcc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "h\uff12\u5bcc";
bytes = new byte[] { 0x68, (byte)0xa3, (byte)0xb2, (byte)0xc9, (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6536\uff6e\u6216";
bytes = new byte[] { (byte)0xda, (byte)0xc0, (byte)0x8e, (byte)0xae,
  (byte)0xb0, (byte)0xbf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5d29\uff9f\u7b9f\uff99";
bytes = new byte[] { (byte)0xca, (byte)0xf8, (byte)0x8e, (byte)0xdf,
  (byte)0xe4, (byte)0xb1, (byte)0x8e, (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff02\uff36\uff2a";
bytes = new byte[] { (byte)0xfc, (byte)0xfe, (byte)0xa3, (byte)0xd6,
  (byte)0xa3, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7f36\uff0d\u654e\uff0b";
bytes = new byte[] { (byte)0xb4, (byte)0xcc, (byte)0xa1, (byte)0xdd,
  (byte)0xfa, (byte)0xb3, (byte)0xa1, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u506c\u2015";
bytes = new byte[] { (byte)0xd0, (byte)0xf8, (byte)0xa1, (byte)0xbd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u671b";
bytes = new byte[] { (byte)0xcb, (byte)0xbe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff74\u6736\uff19\u5869\uff53\uff94";
bytes = new byte[] { (byte)0x8e, (byte)0xb4, (byte)0xdb, (byte)0xb4,
  (byte)0xa3, (byte)0xb9, (byte)0xb1, (byte)0xf6, (byte)0xa3, (byte)0xf3,
  (byte)0x8e, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2f\u751c\u7a43";
bytes = new byte[] { (byte)0xa3, (byte)0xcf, (byte)0xc5, (byte)0xbc,
  (byte)0xe3, (byte)0xce };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u66dc\uff81\uff1b\u6db8";
bytes = new byte[] { (byte)0xcd, (byte)0xcb, (byte)0x8e, (byte)0xc1,
  (byte)0xa1, (byte)0xa8, (byte)0xde, (byte)0xc1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u671f\uff2d\u5616";
bytes = new byte[] { (byte)0xb4, (byte)0xfc, (byte)0xa3, (byte)0xcd,
  (byte)0xd3, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5ef8";
bytes = new byte[] { (byte)0xd7, (byte)0xaf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5317\uff19\uff91";
bytes = new byte[] { (byte)0xcb, (byte)0xcc, (byte)0xa3, (byte)0xb9,
  (byte)0x8e, (byte)0xd1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6659\uff3b\uff7a";
bytes = new byte[] { (byte)0xfa, (byte)0xbd, (byte)0xa1, (byte)0xce,
  (byte)0x8e, (byte)0xba };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u56a2\u79e7\uff0c";
bytes = new byte[] { (byte)0xc7, (byte)0xb9, (byte)0xe3, (byte)0xbf,
  (byte)0xa1, (byte)0xa4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
}
}
}
