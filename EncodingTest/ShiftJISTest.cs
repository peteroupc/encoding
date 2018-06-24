using System;
using NUnit.Framework;
using PeterO;
using PeterO.Text;
using Test;

namespace EncodingTest {
[TestFixture]
public class ShiftJISTest {
[Test]
public void TestShiftJISDecoder() {
byte[] bytes;
string str;
ICharacterEncoding charset = Encodings.GetEncoding("shift_jis");
bytes = new byte[] { 0x29, 0x6b, (byte)0xd4, 0x71, 0x72, (byte)0xe1, 0x19,
  (byte)0x87, (byte)0xd8, 0x52, 0x3e, 0x6e, 0x4a, 0x71, (byte)0xa5,
  (byte)0xeb, 0x64, (byte)0xbc, 0x68, 0x2c };
str = ")k\uff94qr\ufffd\u0019\ufffdR>nJq\uff65\ufffdd\uff7ch\u002c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0f, 0x1b, 0x5b, 0x6d, (byte)0xe3, 0x67, 0x6f,
  (byte)0xd6 };
str = "\u000f\u001b[m\u7dd8o\uff96";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf3, 0x69, 0x25, 0x58, 0x2e };
str = "\ue25d%X.";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe8, 0x06, (byte)0xa0, (byte)0x9a, 0x2a, 0x65,
  (byte)0xd7, (byte)0xd0, 0x71, 0x48, (byte)0x94, (byte)0x9b, (byte)0xcb,
  (byte)0xa1, 0x51, (byte)0xe8, 0x0a, 0x65, 0x47, (byte)0xca, 0x49, 0x05,
  (byte)0xa4, 0x52, 0x23, (byte)0x80, 0x17, 0x4f, 0x2b, (byte)0x85 };
str =

  "\ufffd\u0006\ufffd\ufffd*e\uff97\uff90qH\u7e1b\uff8b\uff61Q\ufffd\u000aeG\uff8aI\u0005\uff64R#\u0080\u0017O+\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7e, 0x5f, (byte)0x82, (byte)0x8f, (byte)0xd3,
  (byte)0xb8, (byte)0xf4, 0x72, 0x34, 0x33 };
str = "~_\uff4f\uff93\uff78\ufffdr43";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4b, (byte)0x94, (byte)0xca, (byte)0xc0, 0x27,
  (byte)0xbc, 0x4e, (byte)0xa3, 0x5d, (byte)0x86, (byte)0xd0, 0x5a };
str = "K\u822c\uff80'\uff7cN\uff63]\ufffdZ";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa1, 0x7d, (byte)0x98 };
str = "\uff61}\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3e, 0x33 };
str = ">3";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6c, 0x61, 0x55, 0x59, 0x36, (byte)0xd4, (byte)0xc0,
  0x26, (byte)0xf0, (byte)0xc1, 0x06, 0x7f, (byte)0x9a, (byte)0xbb, 0x35,
  (byte)0x92 };
str = "laUY6\uff94\uff80&\ue080\u0006\u007f\u57c65\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x48, (byte)0x8a, 0x36, (byte)0xe3, 0x42, 0x39, 0x5e,
  (byte)0x97, 0x0f, 0x6c, (byte)0xe6, 0x54, 0x4f, 0x36, 0x69, 0x05, 0x31,
  0x70, (byte)0xcf, 0x27, 0x51, 0x22, 0x2d };
str = "H\ufffd6\u7d159^\ufffd\u000fl\u89bdO6i\u00051p\uff8f'Q\"-";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcb, 0x09, (byte)0xe4, 0x5b, (byte)0xf1, 0x50,
  0x2e, 0x5b, (byte)0xe6, 0x35, 0x06, 0x7c, 0x76, 0x75, 0x6d, 0x6b, 0x30,
  0x6e, 0x03, 0x4c };
str = "\uff8b\u0009\u81bd\ufffdP.[\ufffd5\u0006|vumk0n\u0003L";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43, 0x50, 0x4c, 0x11, 0x57, 0x5a, 0x63, 0x4a, 0x4f,
  0x28, 0x21, 0x56, 0x0f, 0x52, 0x2f, (byte)0xe7 };
str = "CPL\u0011WZcJO(!V\u000fR/\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe3, (byte)0x86, 0x1a, 0x21, 0x23, 0x6f, 0x10,
  0x28, (byte)0x99, 0x56, 0x1e, 0x6f, (byte)0xa3, 0x32, 0x37, 0x64,
  (byte)0xeb, 0x3f, (byte)0xb7, 0x24 };
str = "\u7e59\u001a!#o\u0010(\u513c\u001eo\uff6327d\ufffd?\uff77$";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x00, 0x54, (byte)0xb1 };
str = "\u0000T\uff71";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44, 0x1e };
str = "D\u001e";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x86, 0x5e, 0x1e, (byte)0x8f, 0x7b, (byte)0xe0,
  (byte)0xb6, 0x2d, 0x34, (byte)0xe5, (byte)0xe6, 0x0a, 0x74, 0x60, 0x78,
  (byte)0xd6, 0x40, (byte)0xfe, (byte)0xcb };
str = "\ufffd^\u001e\u65ec\u7296-4\u8902\u000at`x\uff96@\ufffd\uff8b";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4c, 0x12, 0x15, (byte)0xe4, 0x74, 0x2a, 0x7f,
  (byte)0x95, (byte)0xad, 0x4f, (byte)0xba, 0x21 };
str = "L\u0012\u0015\u8229*\u007f\u58b3O\uff7a!";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x88, 0x40, (byte)0x8c, 0x30, 0x53, 0x46,
  (byte)0xaa, 0x6f, (byte)0xfb, (byte)0xbb, (byte)0x8c, (byte)0x84, 0x39,
  (byte)0xd5, (byte)0x84, (byte)0xe4, 0x32 };
str = "\ufffd@\ufffd0SF\uff6ao\u91d7\u96999\uff95\ufffd2";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x99, (byte)0xa6, 0x5a, 0x1d, 0x3c, 0x61, 0x5f,
  0x3c, 0x5f, 0x75, 0x29, 0x34, (byte)0xd9, 0x4f, (byte)0x9f, (byte)0xec,
  (byte)0xb5 };
str = "\u52d7Z\u001d<a_<_u)4\uff99O\u6ed5\uff75";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4b, 0x50, (byte)0xf6, (byte)0x92, 0x15, 0x16, 0x01,
  (byte)0x96 };
str = "KP\ue4b9\u0015\u0016\u0001\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6b, 0x26, (byte)0xe8, 0x74, 0x6e, 0x72, 0x3c, 0x2d,
  0x08, 0x4f, 0x5a, (byte)0xcd, (byte)0xda, (byte)0x8b, 0x37, 0x51,
  (byte)0xcc, (byte)0xca, 0x74, 0x4d, (byte)0xb1, 0x38, 0x09, 0x29,
  (byte)0xab };
str =
  "k&\u947cnr<-\u0008OZ\uff8d\uff9a\ufffd7Q\uff8c\uff8atM\uff718\u0009)\uff6b";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcb, 0x1d, 0x53, (byte)0xc7, (byte)0x97, 0x5a,
  (byte)0x9e, (byte)0xd6, (byte)0xd0, (byte)0xe4, (byte)0xca, 0x20 };
str = "\uff8b\u001dS\uff87\u878d\u69b4\uff90\u840d ";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x95, (byte)0xe7, 0x62, (byte)0xcf, (byte)0x9c,
  (byte)0x87, (byte)0xd7, 0x68, 0x45, 0x3e, 0x4d, 0x7b, (byte)0x9d };
str = "\u6155b\uff8f\u602b\uff97hE>M\u007b\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x42, 0x04, 0x6e, (byte)0x95, 0x0e, 0x44, 0x49,
  (byte)0x8d, (byte)0xf8, (byte)0x8a, 0x18, 0x04, 0x4a, (byte)0xb2,
  (byte)0xac, 0x62, 0x3d, 0x6f, (byte)0xf2, 0x50, 0x59, (byte)0x82, 0x75,
  (byte)0xc2 };
str =

  "B\u0004n\ufffd\u000eDI\u9bad\ufffd\u0018\u0004J\uff72\uff6cb=o\ue188Y\uff36\uff82";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0a, 0x31, (byte)0xb3, 0x5e, (byte)0xef, 0x4e,
  (byte)0xd4, 0x4f, 0x31, (byte)0xbb, (byte)0xe9, 0x4c, (byte)0xe9,
  (byte)0xb4, (byte)0xa1, (byte)0xfd, 0x79, (byte)0xa5, (byte)0xb4, 0x0b,
  0x72, 0x74, (byte)0x9e };
str =

  "\u000a1\uff73^\ufffdN\uff94O1\uff7b\u9903\u9b58\uff61\ufffdy\uff65\uff74\u000brt\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44, (byte)0x87, (byte)0xe0, 0x7a, 0x19, (byte)0xc9,
  0x0a, 0x36 };
str = "D\ufffdz\u0019\uff89\u000a6";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfb, 0x28, (byte)0x8c, 0x77 };
str = "\ufffd(\u8a63";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x04, 0x33, 0x6d, (byte)0xf1, 0x7b, (byte)0x9c, 0x70,
  (byte)0x98, 0x7a, 0x3f, 0x75, (byte)0xb4, (byte)0x8b, 0x3c, 0x13, 0x50,
  (byte)0xf9, 0x00, 0x56, 0x47, 0x06, (byte)0xfb, 0x33, 0x53, 0x39, 0x69,
  0x53, 0x7f, 0x31, (byte)0xca };
str =

  "\u00043m\ue0f7\u5f98\ufffdz?u\uff74\ufffd<\u0013P\ufffd\u0000VG\u0006\ufffd3S9iS\u007f1\uff8a";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8d, 0x47, (byte)0xc9, (byte)0xf4, 0x0d, 0x76,
  (byte)0xd6, 0x40, 0x57, 0x73 };
str = "\u5b8f\uff89\ufffd\u000dv\uff96@Ws";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe3, 0x69, 0x3a, 0x4b };
str = "\u7de4:K";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x92, 0x4f, (byte)0xe1, 0x4d, (byte)0x9a,
  (byte)0xec, 0x00, (byte)0xd1, 0x30, (byte)0xfa, 0x0b, (byte)0xd6, 0x47,
  (byte)0xce, (byte)0xac };
str = "\u4e39\u750c\u5925\u0000\uff910\ufffd\u000b\uff96G\uff8e\uff6c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe3, 0x25, 0x09, 0x34, (byte)0xfe, 0x0e, 0x68 };
str = "\ufffd%\u00094\ufffd\u000eh";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc0, 0x75, 0x59, 0x76, 0x0d, (byte)0x8a, 0x65,
  (byte)0xb0, (byte)0xd5, 0x30, 0x44, (byte)0xde, (byte)0xe1, 0x36,
  (byte)0x81, (byte)0xdc, (byte)0xdc };
str = "\uff80uYv\u000d\u5404\uff70\uff950D\uff9e\ufffd6\u2312\uff9c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x04, 0x43, (byte)0xe0, 0x21, 0x2f, 0x53, (byte)0xd3,
  (byte)0xc7, (byte)0xfa, (byte)0xa6, (byte)0x93 };
str = "\u0004C\ufffd!/S\uff93\uff87\u5b56\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa2, (byte)0x84 };
str = "\uff62\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2e, (byte)0xe6, (byte)0xa9, 0x6c, (byte)0xe2, 0x13,
  0x73, 0x3a, (byte)0xb5, (byte)0xe7, (byte)0x98, (byte)0xbc, (byte)0xed,
  (byte)0xba, 0x65, 0x5e, 0x3a, 0x3e, 0x48, 0x20, 0x2e, 0x79, (byte)0xfa,
  0x63, (byte)0xfe, 0x3b, (byte)0xf8, 0x11, (byte)0xaa, (byte)0xb1 };
str =

  ".\u8b96l\ufffd\u0013s:\uff75\u9016\uff7c\u6657e^:>H .y\u6631\ufffd;\ufffd\u0011\uff6a\uff71";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5f, 0x49, 0x61, (byte)0xbc, 0x5b, 0x3b, (byte)0xe0,
  0x1b, (byte)0xb9, 0x34, (byte)0xb2, (byte)0xe4, 0x0b, (byte)0xb2,
  (byte)0x8f, (byte)0x96, (byte)0xc8, (byte)0xfc, 0x3f, (byte)0x82, 0x7d,
  0x23, 0x28, 0x39, 0x1a, 0x60, 0x71, 0x1f, 0x53 };
str =

  "_Ia\uff7c[;\ufffd\u001b\uff794\uff72\ufffd\u000b\uff72\u53d9\uff88\ufffd?\ufffd}#(9\u001a`q\u001fS";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5a, 0x6e, 0x6e, 0x7c, 0x15, 0x52, 0x3d, 0x10,
  (byte)0xcc, 0x4c, 0x71, 0x48, 0x25, 0x13, (byte)0xe8, (byte)0x8d,
  (byte)0xd6, (byte)0xe3, 0x46, 0x1f, 0x26, (byte)0xe0, (byte)0xbe, 0x4a,
  (byte)0xdd, 0x7f, (byte)0xb6, 0x79, 0x7c };
str =

  "Znn|\u0015R=\u0010\uff8cLqH%\u0013\u95d5\uff96\u7d2e\u001f&\u72ceJ\uff9d\u007f\uff76y|";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x18, 0x56, 0x4c, 0x2c, (byte)0x80, 0x74, 0x2b, 0x3e };
str = "\u0018VL\u002c\u0080t+>";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x28, 0x73, 0x73, (byte)0xb8, 0x18, (byte)0xc1, 0x3a,
  0x69, (byte)0x9b, (byte)0xf2, (byte)0x9a, 0x4b };
str = "(ss\uff78\u0018\uff81:i\u5e75\u54ee";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x86, (byte)0xb4, 0x73, 0x58, 0x5f, (byte)0xb1,
  0x32, 0x49, 0x37, 0x18, (byte)0xc8, 0x67, 0x64 };
str = "\ufffdsX_\uff712I7\u0018\uff88gd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x53, 0x31, (byte)0x87, 0x23, (byte)0x99, 0x39, 0x14,
  (byte)0xba, (byte)0x91, (byte)0x95, 0x36, (byte)0xa7, (byte)0xf1,
  (byte)0x96, 0x44, 0x30, 0x43, 0x10, 0x39, 0x31, (byte)0x8b, 0x07, 0x14,
  0x10, 0x6b, 0x3b, 0x50, (byte)0xb1, (byte)0x8a, (byte)0xb2 };
str =

  "S1\ufffd#\ufffd9\u0014\uff7a\u88c56\uff67\ufffdD0C\u001091\ufffd\u0007\u0014\u0010k;P\uff71\u5e79";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x41, 0x6b, 0x53, 0x6a, (byte)0xce, 0x64 };
str = "AkSj\uff8ed";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x70, 0x71, 0x22, 0x37, 0x2e, 0x31, (byte)0x92, 0x7c,
  0x5c, 0x1b, (byte)0xcf, 0x7c, (byte)0x9c, (byte)0xf9, 0x2f, (byte)0xb9,
  0x11, (byte)0xd8, (byte)0x98, (byte)0x81, 0x4b };
str = "pq\"7.1\u7af9\\\u001b\uff8f|\u620d/\uff79\u0011\uff98\ufffdK";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x97, (byte)0xac, 0x5c, (byte)0xf0, 0x24, 0x22,
  0x45, (byte)0x9e, (byte)0xdf, (byte)0xbc, 0x7b, 0x76, (byte)0xe4,
  (byte)0xde, 0x2e, 0x44, 0x79, 0x64, 0x14 };
str = "\u6d41\\\ufffd$\"E\u69e7\uff7c\u007bv\u846f.Dyd\u0014";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5f, (byte)0xdd, (byte)0xf6, 0x42, 0x11, (byte)0xf4,
  0x29, 0x67, 0x20, 0x36, 0x3d, (byte)0x85, (byte)0x85, 0x62, 0x41, 0x21,
  0x5b, (byte)0xbb, 0x0d, 0x5e, 0x55, (byte)0xb8, 0x21, 0x17, (byte)0xc6,
  0x7d, (byte)0x82 };
str =

  "_\uff9d\ue46a\u0011\ufffd)g 6=\ufffdbA![\uff7b\u000d^U\uff78!\u0017\uff86}\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x49 };
str = "I";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfe, (byte)0xf9, 0x01, 0x58, (byte)0xcb,
  (byte)0x8a, (byte)0xc9, (byte)0x97, (byte)0xf8, (byte)0xf0, (byte)0xcb,
  (byte)0xfb, 0x6d, (byte)0xcf, 0x09, (byte)0xc9, (byte)0xfc, (byte)0xda,
  0x26 };
str =
  "\ufffd\ufffd\u0001X\uff8b\u7de9\u6f23\ufffd\u749f\uff8f\u0009\uff89\ufffd&";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x27, (byte)0x91 };
str = "'\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x21, 0x15, (byte)0xa9, 0x79, (byte)0xca, 0x28, 0x63,
  0x50, 0x73, (byte)0x9e, 0x26, (byte)0xc0, 0x7e, (byte)0xe8, 0x59,
  (byte)0xcf, (byte)0xaa, (byte)0x83, 0x6c, (byte)0xce, (byte)0xbe, 0x72,
  (byte)0x86, 0x6a };
str =

  "!\u0015\uff69y\uff8a(cPs\ufffd&\uff80~\u93c8\uff8f\uff6a\u30cd\uff8e\uff7er\ufffdj";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43, 0x60, (byte)0xff, 0x49, 0x75, (byte)0x9e,
  (byte)0xbd, 0x29, 0x34, 0x33, 0x4c, 0x63, 0x7e, (byte)0xff, (byte)0x98,
  (byte)0xd5, 0x3b, 0x59, 0x6d, (byte)0x8b, 0x12, 0x42, (byte)0x84, 0x6a,
  0x5a, (byte)0xf9, 0x1d, 0x4d, 0x06, 0x5c };
str =

  "C`\ufffdIu\u6930)43Lc~\ufffd\u4fd4;Ym\ufffd\u0012B\ufffdjZ\ufffd\u001dM\u0006\\";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3e, (byte)0x9e, 0x7e, 0x62, 0x79, 0x43, 0x50, 0x60,
  0x2d, 0x48, (byte)0xd4, 0x65, 0x43, (byte)0xa1, 0x30, (byte)0xab, 0x7e,
  0x6e, 0x5d, (byte)0xf8, 0x61, (byte)0xa4, (byte)0xfa, 0x06, (byte)0x80,
  (byte)0xc5, (byte)0xf2, (byte)0x95, 0x66, (byte)0xc6 };
str =

  ">\u684ebyCP`-H\uff94eC\uff610\uff6b~n]\ufffda\uff64\ufffd\u0006\u0080\uff85\ue1ccf\uff86";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x32, (byte)0xa4, (byte)0x98, (byte)0xb2, 0x3d, 0x42,
  0x30, (byte)0xd6, 0x21, (byte)0xc2, 0x29, 0x58, 0x04, (byte)0x92,
  (byte)0xea, 0x66, (byte)0x84, 0x75, (byte)0xc6, 0x2c, 0x00, (byte)0xde,
  0x75, (byte)0x93 };
str =

  "2\uff64\u4e9f=B0\uff96!\uff82)X\u0004\u5e95f\u0435\uff86\u002c\u0000\uff9eu\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe4, 0x34, 0x67, (byte)0xbd };
str = "\ufffd4g\uff7d";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa2, 0x08, 0x1e, (byte)0x96, (byte)0xc3,
  (byte)0xa0, 0x20, 0x78, 0x6b, (byte)0xe6 };
str = "\uff62\u0008\u001e\u59ea\ufffd xk\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x66, (byte)0x9a, 0x31, (byte)0xcb, (byte)0xda,
  (byte)0xca, 0x5e, 0x63, 0x4b, (byte)0x8b, (byte)0x80, 0x56, 0x7a,
  (byte)0x87, (byte)0x96, (byte)0x8d, 0x0d, (byte)0xba, 0x5c, (byte)0x8a,
  (byte)0xc7 };
str = "f\ufffd1\uff8b\uff9a\uff8a^cK\u673dVz\u22a5\ufffd\u000d\uff7a\\\u7ba1";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x49, (byte)0xdf, 0x62, 0x56, 0x21, 0x5d, 0x18,
  (byte)0xc9, (byte)0xbc, (byte)0x90, (byte)0x8f, (byte)0xaf, 0x6a,
  (byte)0xfa, (byte)0xf4, (byte)0xba, 0x46, 0x73, 0x4c, 0x4f, 0x51 };
str = "I\uff9fbV!]\u0018\uff89\uff7c\u968f\uff6fj\u6bd6\uff7aFsLOQ";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf3, (byte)0x81, 0x2e, 0x5d, (byte)0xf4,
  (byte)0x99, 0x0f, (byte)0xf3, 0x11, 0x3f, 0x44, 0x66, 0x6b, 0x2a, 0x35,
  (byte)0x85, (byte)0xfb, (byte)0xb0 };
str = "\ue274.]\ue348\u000f\ufffd\u0011?Dfk*5\ufffd\uff70";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5f, (byte)0xd6, 0x2b, 0x7f, 0x21, (byte)0xeb, 0x14,
  0x50, 0x19, 0x2a, 0x7b, (byte)0xe2, 0x37, 0x47, 0x31, 0x19, (byte)0xb3,
  0x16, 0x56, 0x2f };
str = "_\uff96+\u007f!\ufffd\u0014P\u0019*\u007b\ufffd7G1\u0019\uff73\u0016V/";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb2, (byte)0xca, 0x74, (byte)0xa4, 0x79 };
str = "\uff72\uff8at\uff64y";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x04, 0x12, 0x31, (byte)0xe9, 0x14, 0x3b, 0x5a,
  (byte)0xf7, (byte)0xc1, 0x4a, (byte)0xf1, (byte)0x96, 0x0b, 0x69,
  (byte)0xac, 0x02, 0x4a, (byte)0xfc, (byte)0xd8, 0x08, 0x75 };
str =
  "\u0004\u00121\ufffd\u0014;Z\ue5a4J\ue111\u000bi\uff6c\u0002J\ufffd\u0008u";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x56, 0x32, (byte)0x95, 0x54, (byte)0x96, 0x69, 0x2a,
  (byte)0x91, (byte)0xd7, 0x2c, (byte)0xaa, (byte)0x82, 0x2f, (byte)0x8f,
  0x5f, 0x1b, 0x1a, 0x45, 0x7c, 0x61, 0x06 };
str = "V2\u8b2c\u5420*\u6cf0\u002c\uff6a\ufffd/\u67d4\u001b\u001aE|a\u0006";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x92, 0x44, 0x54, (byte)0x8c, 0x45, 0x43, 0x31,
  0x5d, 0x31, 0x2d, (byte)0xee, 0x25, 0x5b, (byte)0xe2, 0x35, 0x64, 0x7f,
  0x40, 0x28, (byte)0xc0, (byte)0xcd, 0x7d, (byte)0xe3, 0x57, 0x3e,
  (byte)0x83, (byte)0xc6, 0x7d, (byte)0xb5 };
str =
  "\u596aT\u7aaaC1]1-\ufffd%[\ufffd5d\u007f@(\uff80\uff8d}\u7d7d>\u03b8}\uff75";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5b, 0x2d, 0x47, (byte)0x84, (byte)0xef, 0x38, 0x0c,
  (byte)0x82, (byte)0xcc, 0x25, (byte)0xe0, (byte)0xa1, (byte)0xbf,
  (byte)0x85, 0x20, 0x5b, (byte)0xac, (byte)0x8d, 0x36, 0x14, 0x23, 0x6c,
  0x40, 0x52 };
str = "[-G\ufffd8\u000c\u306e%\u720d\uff7f\ufffd [\uff6c\ufffd6\u0014#l@R";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x39, 0x1a, (byte)0xe7, (byte)0x88, 0x7c, 0x45,
  (byte)0xb5, (byte)0xf6, (byte)0xa6, 0x73, (byte)0xe1 };
str = "9\u001a\u8fb7|E\uff75\ufffds\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x56, (byte)0x9b, 0x67, 0x0c, 0x57, 0x7e, (byte)0xff,
  (byte)0xaf, 0x33, (byte)0x9d, 0x5a, (byte)0xa7, 0x5d, (byte)0xa0, 0x67,
  0x03, (byte)0xfb, 0x0e, (byte)0xa9, 0x21, (byte)0xa4, (byte)0xad };
str =

  "V\u5b0c\u000cW~\ufffd\uff6f3\u62bb\uff67]\ufffdg\u0003\ufffd\u000e\uff69!\uff64\uff6d";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x40, (byte)0x9d, 0x6d, 0x54, 0x58, (byte)0x8f, 0x6a,
  0x27, 0x37, (byte)0x8f, (byte)0xaa, 0x20, 0x6b, 0x7a, (byte)0xb4, 0x57,
  0x2d, (byte)0x90, (byte)0xfd, 0x11, 0x54, 0x05, (byte)0x81, (byte)0xdc,
  0x2a, 0x29, 0x17, 0x3c, 0x2f };
str = "@\u62efTX\u795d'7\u5bb5 kz\uff74W-\ufffd\u0011T\u0005\u2312*)\u0017</";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x01, 0x63, 0x34, (byte)0xc8, (byte)0xc7, 0x56, 0x16,
  0x2b, 0x7b, (byte)0xac };
str = "\u0001c4\uff88\uff87V\u0016+\u007b\uff6c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x81, 0x20, 0x2c, 0x09, (byte)0xcf, (byte)0xe6,
  (byte)0xfd, 0x6d, (byte)0xc7, 0x67, 0x77, (byte)0xfe, 0x0e, (byte)0xc6,
  0x3e };
str = "\ufffd \u002c\u0009\uff8f\ufffdm\uff87gw\ufffd\u000e\uff86>";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x72, 0x3b, (byte)0x80, 0x31, 0x7c, 0x76, (byte)0xb2,
  0x78, 0x1d, 0x37, (byte)0xf4, 0x25, 0x04, (byte)0xac, 0x16, (byte)0xec,
  0x76, (byte)0xac, 0x1b, 0x7b, 0x27, 0x7b, (byte)0x90, 0x11, 0x0a, 0x28,
  0x73, (byte)0xac, (byte)0x9a, 0x06 };
str =

  "r;\u00801|v\uff72x\u001d7\ufffd%\u0004\uff6c\u0016\ufffdv\uff6c\u001b\u007b'\u007b\ufffd\u0011\u000a(s\uff6c\ufffd\u0006";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7a, (byte)0xdd, (byte)0xca, 0x5b, 0x0b, (byte)0xe3,
  0x6f, (byte)0xfc, 0x46, (byte)0xf7, 0x54, 0x67, (byte)0xb4, 0x6e, 0x35,
  (byte)0xac };
str = "z\uff9d\uff8a[\u000b\u7e0a\u9c00\ufffdTg\uff74n5\uff6c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8c, 0x74, 0x28, 0x71, 0x1a, 0x11, 0x4c,
  (byte)0xcc, 0x73, 0x2f, (byte)0xeb, 0x1c, 0x39, 0x16 };
str = "\u834a(q\u001a\u0011L\uff8cs/\ufffd\u001c9\u0016";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2f, 0x2a, 0x77, 0x58, 0x6d, 0x2f, 0x69, 0x63 };
str = "/*wXm/ic";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd2, 0x46, 0x1b, 0x18, 0x36, 0x6b, 0x6e,
  (byte)0x89, (byte)0x9f, 0x16, (byte)0x89, (byte)0xfb, (byte)0xc1,
  (byte)0xf7, (byte)0x8c, 0x55, (byte)0xcf, 0x61, 0x66, 0x0a, (byte)0x8b,
  0x4c, 0x5b, (byte)0x9a, 0x6f, (byte)0xe9, 0x2c, 0x79, (byte)0x89, 0x50 };
str =

  "\uff92F\u001b\u00186kn\u62bc\u0016\u62d0\uff81\ufffdU\uff8faf\u000a\u8a18[\u55e4\ufffd\u002cy\u81fc";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb2, 0x22, (byte)0xb7, 0x37, 0x53 };
str = "\uff72\"\uff777S";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x16, 0x74, 0x3e, (byte)0xa9, 0x2d, 0x70, (byte)0xe1,
  0x67, (byte)0xcc, (byte)0xb5, 0x33, 0x76, (byte)0x8c, 0x69, 0x08, 0x57,
  (byte)0xfb, (byte)0x9b, (byte)0xf5, (byte)0xac, 0x42 };
str = "\u0016t>\uff69-p\u758a\uff8c\uff753v\u666f\u0008W\u8559\ufffdB";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xea, (byte)0xa3, 0x2b, 0x5c, 0x4f, (byte)0xce,
  (byte)0xab, (byte)0x9b, 0x37, 0x18, 0x65, 0x69 };
str = "\u51dc+\\O\uff8e\uff6b\ufffd7\u0018ei";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3f, 0x47, (byte)0xae, 0x6d, (byte)0x8e, 0x4f, 0x1d,
  0x50, 0x53, 0x0b, 0x0b, (byte)0xe9, 0x12, 0x27, (byte)0xca, 0x49, 0x4b,
  0x08, 0x24, (byte)0xf0, (byte)0xaa, (byte)0xb9, (byte)0xde, (byte)0xbd,
  (byte)0xc5, (byte)0x99, (byte)0xf2, (byte)0xe1 };
str =

  "?G\uff6em\u4e09\u001dPS\u000b\u000b\ufffd\u0012'\uff8aIK\u0008$\ue069\uff79\uff9e\uff7d\uff85\u5484\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0c, 0x07, (byte)0xd2, (byte)0xc9, (byte)0x97, 0x18,
  (byte)0xa8, 0x5f, (byte)0xb8, 0x08, (byte)0xd1, 0x4f, (byte)0x8a, 0x31,
  (byte)0x83, (byte)0xff, 0x37, 0x3f, 0x37, (byte)0xc3, 0x26, 0x25, 0x70 };
str =

  "\u000c\u0007\uff92\uff89\ufffd\u0018\uff68_\uff78\u0008\uff91O\ufffd1\ufffd7?7\uff83&%p";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa4, 0x0f, 0x16, 0x20, 0x7c, (byte)0xa4 };
str = "\uff64\u000f\u0016 |\uff64";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa6, (byte)0xa3, (byte)0xde, 0x01, 0x38, 0x0c,
  0x77, (byte)0x8d, 0x07, (byte)0xf0 };
str = "\uff66\uff63\uff9e\u00018\u000cw\ufffd\u0007\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7d, (byte)0xee, (byte)0x8d, 0x77, (byte)0xb0 };
str = "}\ufa22w\uff70";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x97, 0x75, (byte)0xf9, (byte)0x85, 0x49,
  (byte)0xc8, (byte)0xee, (byte)0x80, 0x5e, 0x3d, (byte)0x8d, 0x7d, 0x3e,
  (byte)0xdf, (byte)0x9d, (byte)0xbd, 0x57, (byte)0x9b, (byte)0xaf, 0x11,
  0x64 };
str = "\u84c9\ufffdI\uff88\u856b^=\u95a4>\uff9f\u6537W\u5cb7\u0011d";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xca, (byte)0xb8, 0x65, (byte)0xd8, (byte)0xb2,
  0x27, 0x45, (byte)0x8c, (byte)0xf0, 0x75, 0x5d, (byte)0x8c };
str = "\uff8a\uff78e\uff98\uff72'E\u4ea4u]\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa1, 0x4f, 0x0a, 0x11, (byte)0xb6, (byte)0xa2,
  (byte)0xd0, 0x42, (byte)0xe1, 0x4b, (byte)0x9e, 0x44, 0x04, 0x33, 0x10,
  (byte)0xc2, 0x06, (byte)0xec, 0x71, (byte)0xb5, 0x34, (byte)0xcf, 0x03,
  0x77, 0x20, 0x5b, 0x26 };
str =

  "\uff61O\u000a\u0011\uff76\uff62\uff90B\u7503\u66e0\u00043\u0010\uff82\u0006\ufffdq\uff754\uff8f\u0003w [&";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x81, (byte)0xf3, (byte)0xeb, 0x13, (byte)0x87,
  0x0c, 0x12, (byte)0xfd, 0x51, 0x45, (byte)0xee, 0x31, 0x7e, 0x5e, 0x42,
  0x5c, 0x42 };
str = "\u266d\ufffd\u0013\ufffd\u000c\u0012\ufffdQE\ufffd1~^B\\B";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa1, 0x48, (byte)0xa5, 0x3f, 0x65, 0x65, 0x7b,
  (byte)0x9d, 0x4f, 0x18, (byte)0xe8, (byte)0xbf };
str = "\uff61H\uff65?ee\u007b\u6282\u0018\u9711";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf6, (byte)0xc6, 0x64, (byte)0xbc, (byte)0x9d,
  0x41, 0x7e, (byte)0x97, 0x71, 0x19 };
str = "\ue4edd\uff7c\u6221~\u7aaf\u0019";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc5, (byte)0xdd, (byte)0xf9, (byte)0x87,
  (byte)0xd2, 0x76, 0x3e, 0x77, (byte)0xe8, (byte)0xbb, (byte)0xaa,
  (byte)0xe2, (byte)0xfc, 0x08, (byte)0xac, 0x24, (byte)0xff, 0x71,
  (byte)0xc6, (byte)0x9d, 0x60, 0x05, (byte)0xb7, (byte)0xbf, 0x6d, 0x66,
  0x35, 0x7a, 0x4e, (byte)0xdd };
str =

  "\uff85\uff9d\ufffd\uff92v>w\u9706\uff6a\u7d06\u0008\uff6c$\ufffdq\uff86\u62dc\u0005\uff77\uff7fmf5zN\uff9d";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6c, (byte)0xf6, 0x60, 0x37, 0x3f, 0x31, (byte)0x8b,
  (byte)0xed, 0x14, (byte)0xf5, (byte)0xf5, (byte)0x88, (byte)0x86,
  (byte)0xcc };
str = "l\ue4887?1\u99c8\u0014\ufffd\ufffd\uff8c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb8, (byte)0xe2, 0x6a, (byte)0xdb, (byte)0xdf };
str = "\uff78\u7a3b\uff9b\uff9f";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb9, 0x70, (byte)0xc2, 0x6d, 0x0a, 0x2b,
  (byte)0xf3, 0x5d, (byte)0xb1, 0x38 };
str = "\uff79p\uff82m\u000a+\ue251\uff718";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xda, 0x0b };
str = "\uff9a\u000b";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd6, (byte)0xa4, (byte)0xb6, (byte)0xb3,
  (byte)0xa9, 0x40, (byte)0xe4, 0x17, (byte)0xed, (byte)0xad, (byte)0xef,
  (byte)0x84, (byte)0xf2, 0x71, 0x5e, 0x47, (byte)0xbd };
str = "\uff96\uff64\uff76\uff73\uff69@\ufffd\u0017\u63f5\ufffd\ue1a9^G\uff7d";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x72, 0x6a, 0x3e, (byte)0xcf, 0x0c, (byte)0x83, 0x1b,
  (byte)0x82, (byte)0xe8, 0x60, 0x46, (byte)0xf5, 0x37, (byte)0xd5 };
str = "rj>\uff8f\u000c\ufffd\u001b\u308a`F\ufffd7\uff95";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe2, (byte)0x80 };
str = "\u7ab6";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xed, (byte)0x9f, 0x4c, (byte)0xf7, 0x51, 0x61,
  (byte)0x9a, 0x36, (byte)0x87, (byte)0xbf, 0x59, 0x2a, 0x7f, 0x5b, 0x3f,
  (byte)0x85, (byte)0xc7 };
str = "\u5fdeL\ufffdQa\ufffd6\ufffdY*\u007f[?\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7e, 0x02 };
str = "~\u0002";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8f, 0x2e, (byte)0xa8, (byte)0xe4, 0x25, 0x21,
  0x47 };
str = "\ufffd.\uff68\ufffd%!G";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43, 0x0e, (byte)0xf4, (byte)0xe5, (byte)0xd3, 0x6f };
str = "C\u000e\ue394\uff93o";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
}[Test]
public void TestShiftJISEncoder() {
byte[] bytes;
string str;
ICharacterEncoding charset = Encodings.GetEncoding("shift_jis");
str = "\u0006\u2010\u6212";
bytes = new byte[] { 0x06, (byte)0x81, 0x5d, (byte)0x89, (byte)0xfa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0b\u7aff\uff66";
bytes = new byte[] { (byte)0x81, 0x7b, (byte)0x8a, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6b";
bytes = new byte[] { (byte)0xab };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d42";
bytes = new byte[] { (byte)0x8f, 0x49 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "/\uff55\u754a";
bytes = new byte[] { 0x2f, (byte)0x82, (byte)0x95, (byte)0xe1, 0x58 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u582a\u7c9b\u57e0\u8201";
bytes = new byte[] { (byte)0x8a, (byte)0xac, (byte)0x8f, 0x6c, (byte)0x95,
  0x75, (byte)0xe4, 0x6c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5922\u6a17\uff44";
bytes = new byte[] { (byte)0x96, (byte)0xb2, (byte)0x92, (byte)0x94,
  (byte)0x82, (byte)0x84 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u570f\u7fc6\u5765";
bytes = new byte[] { (byte)0x8c, (byte)0x97, (byte)0xe3, (byte)0xc1,
  (byte)0xfa, (byte)0x97 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6fe1\u6e6b\u5544";
bytes = new byte[] { (byte)0x94, 0x47, (byte)0x9f, (byte)0xd5, (byte)0x91,
  (byte)0xed };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe2";
bytes = new byte[] { (byte)0x81, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff77\u5b80";
bytes = new byte[] { (byte)0xb7, (byte)0x9b, 0x7e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7670\u69d0\u6eb6";
bytes = new byte[] { (byte)0xe1, (byte)0x9e, (byte)0x9e, (byte)0xc5,
  (byte)0x97, 0x6e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5b\u6821";
bytes = new byte[] { (byte)0x81, 0x6f, (byte)0x8d, 0x5a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u654f\uff99\uff81";
bytes = new byte[] { (byte)0x95, (byte)0xc1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7f94\uff6d\u6545";
bytes = new byte[] { (byte)0xe3, (byte)0xad, (byte)0x8c, (byte)0xcc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5963\u25cf\uff5d";
bytes = new byte[] { (byte)0xfa, (byte)0xa3, (byte)0x81, (byte)0x9c,
  (byte)0x81, 0x70 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u254b\u6df7\uff34";
bytes = new byte[] { (byte)0x84, (byte)0xb4, (byte)0x8d, (byte)0xac,
  (byte)0x82, 0x73 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6428\u96b1\uff17\u5821";
bytes = new byte[] { (byte)0x9d, (byte)0x92, (byte)0xe8, (byte)0xaa,
  (byte)0x82, 0x56, (byte)0x9a, (byte)0xc6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5e7a";
bytes = new byte[] { (byte)0x9b, (byte)0xf4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4f\uff6d\uff90\uff37\uff34";
bytes = new byte[] { (byte)0x82, (byte)0xd0, (byte)0x82, 0x76, (byte)0x82,
  0x73 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff29\uff57\u6031\uff58\u77ef";
bytes = new byte[] { (byte)0x82, 0x68, (byte)0x82, (byte)0x97, (byte)0x9c,
  (byte)0x84, (byte)0x82, (byte)0x98, (byte)0x8b, (byte)0xb8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u61be\u6faa\uff4a\u77d7";
bytes = new byte[] { (byte)0x8a, (byte)0xb6, (byte)0xe0, 0x59, (byte)0x82,
  (byte)0x8a, (byte)0xe1, (byte)0xde };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "28\u63da";
bytes = new byte[] { 0x32, 0x38, (byte)0x97, 0x67 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6f";
bytes = new byte[] { (byte)0xaf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u540c\uff26\u74f8";
bytes = new byte[] { (byte)0x93, (byte)0xaf, (byte)0x82, 0x65, (byte)0xe1,
  0x48 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u69d8";
bytes = new byte[] { (byte)0x97, 0x6c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5d53";
bytes = new byte[] { (byte)0xfa, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "d";
bytes = new byte[] { 0x64 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff53\u7aaa\uff86";
bytes = new byte[] { (byte)0x82, (byte)0x93, (byte)0x8c, (byte)0xc6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0c";
bytes = new byte[] { (byte)0x81, 0x43 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff88\uff6f";
bytes = new byte[] { (byte)0xaf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u64f2\uff81";
bytes = new byte[] { (byte)0x9d, (byte)0xc1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff69\u514b";
bytes = new byte[] { (byte)0xa9, (byte)0x8d, (byte)0x8e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u67d1";
bytes = new byte[] { (byte)0x8a, (byte)0xb9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4d\u7977\uff2b\u76bf";
bytes = new byte[] { (byte)0x82, (byte)0x8d, (byte)0x93, (byte)0x98,
  (byte)0x82, 0x6a, (byte)0x8e, 0x4d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6c\u5022\uff66";
bytes = new byte[] { (byte)0xac, (byte)0xfa, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u77dc\u57c3";
bytes = new byte[] { (byte)0xe1, (byte)0xe0, (byte)0x9a, (byte)0xba };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff44\uff895\uff53";
bytes = new byte[] { (byte)0x82, (byte)0xc9, 0x35, (byte)0x82, (byte)0x93 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u644e";
bytes = new byte[] { (byte)0x9d, (byte)0x97 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "J\u2234";
bytes = new byte[] { 0x4a, (byte)0x81, (byte)0x88 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5150\u7337\uff64\uff33";
bytes = new byte[] { (byte)0x8e, (byte)0x99, (byte)0x97, (byte)0xa4,
  (byte)0x82, 0x72 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2162\u0019\u783a";
bytes = new byte[] { (byte)0x87, 0x56, 0x19, (byte)0x93, 0x76 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u4fab\u2179\u8a87\u933b";
bytes = new byte[] { (byte)0x9b, 0x44, (byte)0xfa, 0x49, (byte)0x8c,
  (byte)0xd6, (byte)0xe8, 0x46 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff59\uff17\uff7f";
bytes = new byte[] { (byte)0x82, (byte)0x99, (byte)0x82, (byte)0xbf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3d\u6fec\u5fdc";
bytes = new byte[] { (byte)0x81, 0x6e, (byte)0xe0, 0x5c, (byte)0x89,
  (byte)0x9e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff28\uff6c\uff50";
bytes = new byte[] { (byte)0x82, (byte)0xac, (byte)0x82, (byte)0x90 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u613c\uff03\u75c5";
bytes = new byte[] { (byte)0x9c, (byte)0xc4, (byte)0x81, (byte)0x94,
  (byte)0x95, 0x61 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u25b2";
bytes = new byte[] { (byte)0x81, (byte)0xa3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7940";
bytes = new byte[] { (byte)0xe2, 0x4a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6aea\uff89\u6210";
bytes = new byte[] { (byte)0x9f, (byte)0xc9, (byte)0x90, (byte)0xac };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u0005\u9688";
bytes = new byte[] { 0x05, (byte)0x8c, 0x47 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff55\u7015\uff42";
bytes = new byte[] { (byte)0x82, (byte)0x95, (byte)0x95, 0x6d, (byte)0x82,
  (byte)0x82 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff7c\uff95";
bytes = new byte[] { (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u76c2\u6681\uff4d";
bytes = new byte[] { (byte)0xe1, (byte)0xb1, (byte)0x8b, (byte)0xc5,
  (byte)0x82, (byte)0x8d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u25bd\uff71\u79e3";
bytes = new byte[] { (byte)0x81, (byte)0xb1, (byte)0xe2, 0x61 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff30\u736a\uff07";
bytes = new byte[] { (byte)0x82, 0x6f, (byte)0xe0, (byte)0xd4, (byte)0xfa,
  0x56 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff56\u57e0\u518a";
bytes = new byte[] { (byte)0x82, (byte)0x96, (byte)0x95, 0x75, (byte)0x8d,
  (byte)0xfb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff59\u6736";
bytes = new byte[] { (byte)0x82, (byte)0x99, (byte)0x9e, 0x53 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff28\uff85\uff38";
bytes = new byte[] { (byte)0x82, (byte)0xc5, (byte)0x82, 0x77 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u63aa\u6beb\u6134";
bytes = new byte[] { (byte)0x91, 0x5b, (byte)0x9f, 0x7c, (byte)0x9c,
  (byte)0xc6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff05\uff2b\u6012";
bytes = new byte[] { (byte)0x81, (byte)0x93, (byte)0x82, 0x6a, (byte)0x93,
  0x7b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff80\u6309\u5f31";
bytes = new byte[] { (byte)0xc0, (byte)0x88, (byte)0xc2, (byte)0x8e,
  (byte)0xe3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9bb4";
bytes = new byte[] { (byte)0xe9, (byte)0xbe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1e\u5143";
bytes = new byte[] { (byte)0x81, (byte)0x84, (byte)0x8c, (byte)0xb3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9348";
bytes = new byte[] { (byte)0xfa, 0x5e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff97\uff04\uff9d";
bytes = new byte[] { (byte)0xd7, (byte)0x81, (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff87";
bytes = new byte[] { (byte)0xc7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5944\uff02";
bytes = new byte[] { (byte)0x89, (byte)0x82, (byte)0xfa, 0x57 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9c\uff94\uff9c";
bytes = new byte[] { (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe3\u557e\u5870";
bytes = new byte[] { (byte)0x81, 0x50, (byte)0x9a, 0x61, (byte)0x9a,
  (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff20\uff2f\uff62";
bytes = new byte[] { (byte)0x81, (byte)0x97, (byte)0x82, (byte)0xa2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u597d";
bytes = new byte[] { (byte)0x8d, 0x44 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff32\uff27";
bytes = new byte[] { (byte)0x82, 0x71, (byte)0x82, 0x66 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe4\u6d36\u7699";
bytes = new byte[] { (byte)0xfa, 0x55, (byte)0x9f, (byte)0xa6, (byte)0xe1,
  (byte)0xaa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5eec\u7827\u5f4a";
bytes = new byte[] { (byte)0x9c, 0x49, (byte)0x8b, 0x6d, (byte)0x8b,
  (byte)0xae };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2b\u535e\u6bbc";
bytes = new byte[] { (byte)0x82, 0x6a, (byte)0x99, (byte)0xc4, (byte)0x9f,
  0x76 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff6b\uff54";
bytes = new byte[] { (byte)0xab, (byte)0x82, (byte)0x94 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff20";
bytes = new byte[] { (byte)0x81, (byte)0x97 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u76e3\uff0c\u756b";
bytes = new byte[] { (byte)0x8a, (byte)0xc4, (byte)0x81, 0x43, (byte)0xe1,
  0x60 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u70c8";
bytes = new byte[] { (byte)0x97, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u59bb\u77d7\uff17\u7e70\u0016";
bytes = new byte[] { (byte)0x8d, (byte)0xc8, (byte)0xe1, (byte)0xde,
  (byte)0x82, 0x56, (byte)0x8c, 0x4a, 0x16 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff59\uff0c\u9803\u5300\u5f2f";
bytes = new byte[] { (byte)0x82, (byte)0x99, (byte)0x81, 0x43, (byte)0x8d,
  (byte)0xa0, (byte)0xfa, (byte)0x89, (byte)0x9c, 0x5e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff93\uff03\uff6d";
bytes = new byte[] { (byte)0xd3, (byte)0x81, (byte)0xad };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7f6e\u9748\u25b3";
bytes = new byte[] { (byte)0x92, 0x75, (byte)0xe8, (byte)0xcb, (byte)0x81,
  (byte)0xa2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5f97\u5e1b\u79a6";
bytes = new byte[] { (byte)0x93, (byte)0xbe, (byte)0x9b, (byte)0xe5,
  (byte)0x8b, (byte)0x9a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2021\uff4e\u5168";
bytes = new byte[] { (byte)0x81, (byte)0xf6, (byte)0x82, (byte)0x8e,
  (byte)0x91, 0x53 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6765\u6bbc\u51cd";
bytes = new byte[] { (byte)0x97, (byte)0x88, (byte)0x9f, 0x76, (byte)0x93,
  (byte)0x80 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5d29\uff61`";
bytes = new byte[] { (byte)0x95, (byte)0xa1, 0x60 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u54e6";
bytes = new byte[] { (byte)0x9a, 0x47 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u75f0";
bytes = new byte[] { (byte)0xe1, (byte)0x82 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff8d";
bytes = new byte[] { (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9d\uff2e\u67ee";
bytes = new byte[] { (byte)0xdd, (byte)0x82, 0x6d, (byte)0x9e, 0x72 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d9a\u5fd9\u59ff";
bytes = new byte[] { (byte)0x91, (byte)0xb1, (byte)0x96, 0x5a, (byte)0x8e,
  0x70 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1b\uff6b\uff25";
bytes = new byte[] { (byte)0x81, (byte)0xab, (byte)0x82, 0x64 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9d";
bytes = new byte[] { (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7bcb\u5347\u6bbf";
bytes = new byte[] { (byte)0xe2, (byte)0xb8, (byte)0x8f, (byte)0xa1,
  (byte)0x93, 0x61 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "^\u6d5c";
bytes = new byte[] { 0x5e, (byte)0x95, 0x6c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff15\uff99\u7802";
bytes = new byte[] { (byte)0x82, (byte)0xd9, (byte)0x8d, (byte)0xbb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u59c6\u691c\uff80";
bytes = new byte[] { (byte)0x9b, 0x47, (byte)0x8c, (byte)0xc0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "m\uff28\u74cf";
bytes = new byte[] { 0x6d, (byte)0x82, 0x67, (byte)0xe0, (byte)0xfa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
}
}
}
