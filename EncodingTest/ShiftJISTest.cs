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
bytes = new byte[] { 0x72, 0x4b, 0x32, 0x2a, (byte)0xa2, (byte)0xab, 0x51,
  (byte)0xb4, 0x27 };
str = "rK2*\uff62\uff6bQ\uff74'";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb6, (byte)0xd2, 0x7d, 0x48, 0x53, 0x31, 0x1f,
  0x6e, 0x50, (byte)0xcd, 0x67, 0x3f, (byte)0x88, (byte)0xea, 0x3e, 0x70,
  0x6e, (byte)0x93, 0x5b, 0x62 };
str = "\uff76\uff92}HS1\u001fnP\uff8dg?\u4e00>pn\u751cb";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x78, 0x77, 0x4d, 0x51, (byte)0xed, (byte)0xab,
  (byte)0xd9, (byte)0x92, 0x2e, 0x38, 0x2c, 0x59, 0x22, (byte)0xdf,
  (byte)0xed, 0x2e, 0x7f, (byte)0x8a, 0x65, 0x37, (byte)0xfd, (byte)0x9f,
  0x41, 0x63, (byte)0xbe, 0x56, 0x1e, (byte)0xd6, 0x73 };
str =

  "xwMQ\u6213\uff99\ufffd.8\u002cY\"\uff9f\ufffd.\u007f\u54047\ufffd\u8617c\uff7eV\u001e\uff96s";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44, 0x79, 0x74, 0x1e, 0x02, 0x1e, 0x48, 0x79,
  (byte)0x89, 0x10, (byte)0xcf, 0x3c, (byte)0xf4 };
str = "Dyt\u001e\u0002\u001eHy\ufffd\u0010\uff8f<\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x20, 0x29, (byte)0xde, 0x60, 0x78, (byte)0xda, 0x34,
  (byte)0xf4, 0x6b, (byte)0xaf, (byte)0x85, 0x6b, (byte)0xcd, (byte)0xf7,
  0x6b, 0x3d, 0x47 };
str = "\u0020)\uff9e`x\uff9a4\ue31b\uff6f\ufffdk\uff8d\ue54f\u003dG";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb3, (byte)0xbd, (byte)0x9f, (byte)0xb6, 0x5c,
  0x01, (byte)0xd3, 0x17, 0x69, (byte)0xd8, (byte)0xd2, 0x0b, (byte)0xd4,
  (byte)0xe1, 0x18, (byte)0xbb };
str =

  "\uff73\uff7d\u6d95\\\u0001\uff93\u0017i\uff98\uff92\u000b\uff94\ufffd\u0018\uff7b";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2c, (byte)0x87, 0x30, 0x6b, (byte)0x90, 0x27, 0x1a,
  0x70, (byte)0xbf, (byte)0xfa };
str = "\u002c\ufffd0k\ufffd'\u001ap\uff7f\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0b, 0x19, 0x6d, 0x7f, 0x11, (byte)0xa8, (byte)0xaf,
  (byte)0x90, 0x2d, 0x69, (byte)0xca, 0x5b, 0x53, 0x28, (byte)0xef, 0x50,
  0x59, (byte)0x80, (byte)0x9e, 0x72, 0x45, (byte)0xa4 };
str =

  "\u000b\u0019m\u007f\u0011\uff68\uff6f\ufffd-i\uff8a[S(\ufffdPY\u0080\u67eeE\uff64";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44, 0x46, 0x32, 0x55, (byte)0xb3, (byte)0xf1, 0x47,
  0x57, 0x08, (byte)0xfd, 0x59, 0x61, 0x0d, 0x5d, (byte)0x9f, (byte)0x9e };
str = "DF2U\uff73\ue0c3W\u0008\ufffdYa\r]\u6cbe";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8e, (byte)0xa3, 0x03, 0x5e, 0x4f, 0x4c, 0x78,
  0x4a };
str = "\u74bd\u0003^OLxJ";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x63, 0x5f, 0x70, (byte)0xea, (byte)0xed, 0x4c,
  (byte)0xa1, (byte)0xbe, 0x43, 0x3d, (byte)0xff, (byte)0xe0, 0x24,
  (byte)0xf6, 0x0b, 0x1e, 0x58, 0x63, (byte)0xfa };
str = "c_p\ufffdL\uff61\uff7eC\u003d\ufffd\ufffd$\ufffd\u000b\u001eXc\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc1, 0x68, 0x38, (byte)0xb6, (byte)0x8f, 0x21,
  0x72, 0x63, 0x56, 0x35 };
str = "\uff81h8\uff76\ufffd!rcV5";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4a, (byte)0x9e, (byte)0xd4, (byte)0xfe, 0x76, 0x4b,
  0x36, (byte)0x8b, (byte)0xa8, 0x5a, 0x21, 0x35, 0x4d, 0x4c };
str = "J\u699c\ufffdvK6\u537fZ!5ML";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcc, (byte)0xc3, (byte)0xce };
str = "\uff8c\uff83\uff8e";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd9, 0x68, (byte)0xd8 };
str = "\uff99h\uff98";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8d, (byte)0xac, 0x7d, (byte)0xa2, 0x5a,
  (byte)0x8b, (byte)0xb9, 0x42, 0x77, (byte)0xae, 0x28, 0x28, 0x22 };
str = "\u6df7}\uff62Z\u80f8Bw\uff6e((\"";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x53, 0x74, (byte)0x89, (byte)0xc7, 0x25, 0x74, 0x24,
  (byte)0x81, 0x1c, 0x35 };
str = "St\u5be1%t$\ufffd\u001c5";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x51, 0x56, 0x5c, 0x5d, (byte)0xe8, (byte)0xc0, 0x67,
  0x7a, 0x4c, (byte)0xbe, (byte)0xe6, 0x2a, (byte)0x9f, (byte)0xf6, 0x67,
  (byte)0x96, 0x0c, (byte)0x81, 0x62, (byte)0xbb, (byte)0xb5 };
str = "QV\\]\u970fgzL\uff7e\ufffd*\u6efeg\ufffd\u000c\uff5c\uff7b\uff75";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfc, 0x31, (byte)0x88, (byte)0x84, 0x34, 0x79,
  (byte)0xd4, 0x08, 0x34, 0x04, 0x2a, 0x39, 0x78, (byte)0xdc, 0x1c,
  (byte)0xe5, (byte)0x99, 0x7e, 0x17, (byte)0xc7, 0x1e, (byte)0xbd, 0x57,
  (byte)0xa0 };
str =

  "\ufffd1\ufffd4y\uff94\u00084\u0004*9x\uff9c\u001c\u874e~\u0017\uff87\u001e\uff7dW\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x62, (byte)0xb3, 0x76, 0x1b, 0x27, (byte)0xe1, 0x6c,
  0x3f, 0x44, 0x2b, 0x03, 0x52, 0x41, 0x7f, (byte)0xed, 0x66, 0x17,
  (byte)0xf6, (byte)0xa2, 0x5d, 0x51, (byte)0x80, 0x12 };
str = "b\uff73v\u001b'\u759d?D+\u0003RA\u007f\u51ec\u0017\ue4c9]Q\u0080\u0012";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5d, 0x46, (byte)0x80, 0x20, (byte)0xcc, (byte)0xe4 };
str = "]F\u0080\u0020\uff8c\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x23, 0x7b, (byte)0xc9, (byte)0xc3, (byte)0xdf, 0x30,
  0x52, 0x59, 0x65, 0x2c, (byte)0xce, 0x58, 0x6d, 0x67, 0x2c, (byte)0xb0,
  0x00, (byte)0x9c, 0x63, 0x04, 0x0c, (byte)0xe5, (byte)0xe1, (byte)0x8d,
  0x65, 0x76, (byte)0xd1 };
str =

  "#\u007b\uff89\uff83\uff9f0RYe\u002c\uff8eXmg\u002c\uff70\u0000\u5f61\u0004\u000c\u88d4\u7a3fv\uff91";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6b, 0x5d, (byte)0xce, 0x3e, (byte)0xde, (byte)0xc1,
  (byte)0xcd, (byte)0x8f, 0x38, 0x0d, 0x73, (byte)0xec, (byte)0x94, 0x4c,
  0x20, 0x6f, (byte)0x94, 0x47 };
str = "k]\uff8e>\uff9e\uff81\uff8d\ufffd8\rs\ufffdL\u0020o\u6fe1";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x70, (byte)0xbc, (byte)0xb4, 0x58, (byte)0x98, 0x6a,
  0x33, (byte)0xc6, 0x0c, 0x64, (byte)0xf5, 0x17, (byte)0xc7, 0x56,
  (byte)0xf3, (byte)0xe3, 0x14, (byte)0xd8, 0x66 };
str =
  "p\uff7c\uff74X\u4e983\uff86\u000cd\ufffd\u0017\uff87V\ue2d6\u0014\uff98f";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe5, (byte)0x81, 0x10, 0x4e, (byte)0xa2 };
str = "\u86db\u0010N\uff62";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4a, 0x58, (byte)0x94, 0x03, (byte)0xe7, 0x1e, 0x01,
  0x29, 0x66, (byte)0xec, 0x46, (byte)0xa3, 0x7e, 0x7d, 0x7e, (byte)0xea,
  0x2f, 0x48, 0x2d, (byte)0xcb, (byte)0x9c, 0x63, 0x78 };
str =
  "JX\ufffd\u0003\ufffd\u001e\u0001)f\ufffdF\uff63~}~\ufffd/H-\uff8b\u5f61x";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x27, (byte)0xb7, 0x14, 0x55, 0x45, 0x64, 0x39, 0x2a,
  (byte)0x9c, (byte)0xab, (byte)0xe7, (byte)0xeb, (byte)0xda, (byte)0xdc,
  (byte)0xe6, 0x1d, 0x38, 0x11, (byte)0xcc, (byte)0xf6 };
str =
  "'\uff77\u0014UEd9*\u5ff0\u9248\uff9a\uff9c\ufffd\u001d8\u0011\uff8c\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8d, (byte)0xcc, (byte)0xa3, (byte)0x8d };
str = "\u63a1\uff63\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x08, 0x2d, (byte)0xee, 0x32, 0x5d, (byte)0xa0,
  (byte)0xe9, (byte)0x84, (byte)0xaa, (byte)0xe7, (byte)0xbd, (byte)0xc6,
  (byte)0xcf, 0x70, (byte)0xff, 0x4d, (byte)0x89, 0x29, 0x1a, (byte)0xcf,
  (byte)0xc8, 0x66, 0x7a, 0x0f, (byte)0x8d, (byte)0xa7, (byte)0x9e,
  (byte)0xec, 0x35 };
str =

  "\u0008-\ufffd2]\ufffd\u9a57\uff6a\u9102\uff86\uff8fp\ufffdM\ufffd)\u001a\uff8f\uff88fz\u000f\u61c7\u6a0c5";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe9, 0x3a, 0x1f, (byte)0xae, 0x72, (byte)0xea,
  (byte)0xf0, 0x63, 0x62, (byte)0xf1, (byte)0xda, 0x46, 0x6a, 0x66, 0x27,
  0x2f, 0x15, 0x67, (byte)0xfa, 0x57 };
str = "\ufffd:\u001f\uff6er\ufffdcb\ue155Fjf'/\u0015g\uff02";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xed, 0x2a, 0x38, 0x6d, 0x36, (byte)0xda, 0x50,
  0x2a, 0x56, 0x7a, 0x61, 0x7e, (byte)0x82, 0x65, 0x3d, 0x7e, 0x70, 0x72,
  (byte)0xd1, 0x25, 0x4f, (byte)0xb3 };
str = "\ufffd*8m6\uff9aP*Vza~\uff26\u003d~pr\uff91%O\uff73";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbb, 0x6d, (byte)0xe5, (byte)0xae, (byte)0xa2,
  0x65, 0x26, 0x66, 0x43, 0x54, 0x56, (byte)0xf7, 0x33, (byte)0xf7, 0x71,
  0x5a, (byte)0xa8, 0x04, (byte)0x96, (byte)0xc4, 0x68, (byte)0xa2,
  (byte)0xda, 0x4f, 0x0e };
str =

  "\uff7bm\u87b3\uff62e&fCTV\ufffd3\ue555Z\uff68\u0004\u725dh\uff62\uff9aO\u000e";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xef, (byte)0x9b, (byte)0x91, 0x7e, (byte)0x8e,
  0x6e, (byte)0xbd, (byte)0xc2, (byte)0xcf, 0x6d, 0x2c, 0x43, 0x74,
  (byte)0xec, 0x35, (byte)0x98, 0x41, (byte)0xaa, 0x7f, 0x4f, (byte)0xd4,
  0x33, 0x39, (byte)0xff, 0x62, (byte)0xd3 };
str =

  "\ufffd\u63bb\u59cb\uff7d\uff82\uff8fm\u002cCt\ufffd5\u9023\uff6a\u007fO\uff9439\ufffdb\uff93";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc2, (byte)0x92, 0x3a, (byte)0x96, 0x5e, 0x4e,
  0x14, (byte)0xb0, 0x44, 0x5d, (byte)0xe1, 0x04, 0x60, 0x31, 0x41,
  (byte)0xa3, (byte)0xa0, 0x51, 0x12, 0x51, (byte)0xa7, (byte)0xab, 0x6d,
  0x34, (byte)0xc4, 0x22, 0x63 };
str =

  "\uff82\ufffd:\u67d0N\u0014\uff70D]\ufffd\u0004`1A\uff63\ufffdQ\u0012Q\uff67\uff6bm4\uff84\"c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8c, (byte)0xc0, (byte)0xee, (byte)0xc5,
  (byte)0xd7, 0x5c, (byte)0x87, 0x29, (byte)0xf8, 0x54, 0x58, 0x1c,
  (byte)0xa6, (byte)0xed, 0x56, (byte)0xe0, 0x5c, 0x27 };
str = "\u9650\u93a4\uff97\\\ufffd)\ue5f4X\u001c\uff66\u4f94\u6fec'";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x61, 0x2d, (byte)0xbb, (byte)0x9b, 0x70, (byte)0xb9,
  0x59, 0x29, (byte)0xd2, 0x2f, 0x5d, 0x3a, (byte)0xe1, (byte)0xe5, 0x40,
  (byte)0xa5, 0x38, 0x18, 0x06, (byte)0xb5, 0x70, (byte)0xcf };
str = "a-\uff7b\u5b45\uff79Y)\uff92/]:\u7812@\uff658\u0018\u0006\uff75p\uff8f";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x03, 0x6e, (byte)0xa1, 0x78, (byte)0xac, 0x2f, 0x24,
  (byte)0xa2, 0x7c, (byte)0xd9, (byte)0xe7, (byte)0xde, (byte)0xa0,
  (byte)0xe4, 0x51, 0x12, 0x7e, (byte)0xa1, 0x4f, 0x1b, (byte)0xb4,
  (byte)0xc2, (byte)0xaf, (byte)0x90 };
str =

  "\u0003n\uff61x\uff6c/$\uff62|\uff99\u91f5\ufffd\u8195\u0012~\uff61O\u001b\uff74\uff82\uff6f\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x63, 0x28, (byte)0xf0, (byte)0xe3, 0x53, 0x25, 0x04,
  0x24, 0x2f, 0x7b, (byte)0xe7, (byte)0xc4, (byte)0x84, 0x63, (byte)0xf9,
  0x08, 0x79, 0x78, (byte)0xc2, (byte)0xa9, (byte)0x98, (byte)0xb0, 0x6f,
  0x2b, 0x28, 0x66 };
str =
  "c(\ue0a2S%\u0004$/\u007b\u9158\ufffdc\ufffd\u0008yx\uff82\uff69\u4e8eo+(f";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x91, (byte)0xab, 0x3c, (byte)0xf8, 0x16,
  (byte)0x9d, 0x41, 0x3a };
str = "\u8db3<\ufffd\u0016\u6221:";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xeb, 0x52, (byte)0x8b, (byte)0xa6, (byte)0xac,
  (byte)0x9c };
str = "\ufffdR\u5354\uff6c\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x47, 0x10, (byte)0x8c, 0x54, 0x56, 0x12, 0x4f };
str = "G\u0010\u5366V\u0012O";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc9, 0x23, 0x6b, 0x37, 0x28, 0x61, 0x72, 0x38,
  (byte)0xb0, (byte)0xeb, 0x27, 0x4c, (byte)0xd8, 0x6a, 0x2b, (byte)0xe9,
  0x3b, 0x08, 0x0a };
str = "\uff89#k7(ar8\uff70\ufffd'L\uff98j+\ufffd;\u0008\n";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x82, 0x24, (byte)0x9d, 0x3c, (byte)0xe3,
  (byte)0xaa, (byte)0x99, 0x3a, 0x21, (byte)0xa3, (byte)0xe7, 0x43,
  (byte)0xaa, 0x33, (byte)0xad, (byte)0x81, (byte)0xa5, (byte)0x99,
  (byte)0xaf, (byte)0x90, (byte)0xb2, 0x55, 0x76, (byte)0x8a, 0x5f, 0x1b };
str =

  "\ufffd$\ufffd<\u7f68\ufffd:!\uff63\u8e50\uff6a3\uff6d\u25bc\u52f9\u6816Uv\u57a3\u001b";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x70, (byte)0x98, (byte)0xba, (byte)0xde, (byte)0xb0,
  0x4d, 0x60, (byte)0xf0, 0x57, (byte)0xeb, 0x7b, 0x7a, 0x4c };
str = "p\u4ec4\uff9e\uff70M`\ue017\ufffd\u007bzL";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1e, 0x64, 0x26, 0x15, (byte)0xf0, 0x3f, 0x71, 0x5b,
  (byte)0xd2, (byte)0xad, 0x52, 0x6a, (byte)0xa2, 0x18, 0x2f, 0x75,
  (byte)0x9f, (byte)0xad, (byte)0xfa, (byte)0xdc, 0x59, 0x3b, 0x1a,
  (byte)0x92, 0x5b, 0x4d, 0x39, (byte)0xb0, 0x06 };
str =

  "\u001ed&\u0015\ufffd?q[\uff92\uff6dRj\uff62\u0018/u\u6d12\u66b2Y;\u001a\u7aefM9\uff70\u0006";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x71, 0x40, 0x2d, 0x42, 0x21, 0x6e, (byte)0xd1, 0x57,
  (byte)0xe4, (byte)0xf2, (byte)0xa8, (byte)0xac, (byte)0xdf, 0x6a };
str = "q@-B!n\uff91W\u8517\uff68\uff6c\uff9fj";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x21, 0x01, 0x2d };
str = "!\u0001-";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0b, 0x23, (byte)0xbc, (byte)0xd6, (byte)0x8d,
  (byte)0xe6, (byte)0xc5, 0x2c, 0x78, 0x0a, (byte)0xcf, (byte)0x8b, 0x6d,
  (byte)0x9d, (byte)0x93, (byte)0xe0, 0x67, (byte)0x90, (byte)0xf0, 0x6b,
  (byte)0x80 };
str =

  "\u000b#\uff7c\uff96\u80b4\uff85\u002cx\n\uff8f\u7827\u640f\u700f\u6813k\u0080";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x55, 0x7b, 0x21, (byte)0xdd, 0x02, 0x7d, 0x11, 0x7e,
  0x44, (byte)0xf9, 0x30, 0x79, 0x31, (byte)0xc1, 0x3b, (byte)0x93 };
str = "U\u007b!\uff9d\u0002}\u0011~D\ufffd0y1\uff81;\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x68, 0x75, 0x6f, 0x38, 0x00, (byte)0x8b, 0x44,
  (byte)0xaa, (byte)0xea, (byte)0xf6, 0x5e, 0x6b, 0x0a, 0x28, 0x3f, 0x30,
  (byte)0xcd, (byte)0xb8, 0x1e, 0x02 };
str = "huo8\u0000\u6c7d\uff6a\ufffd^k\n(?0\uff8d\uff78\u001e\u0002";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x95, (byte)0xd7, 0x2d, 0x46, 0x38, (byte)0xb0,
  0x00, (byte)0xc0, (byte)0x8b, 0x1b, 0x6f, (byte)0xee, 0x31, 0x23, 0x47,
  0x2c, (byte)0xe3, 0x1b, 0x5a, 0x1d };
str =
  "\u52c9-F8\uff70\u0000\uff80\ufffd\u001bo\ufffd1#G\u002c\ufffd\u001bZ\u001d";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x70, 0x5d, (byte)0xc9, 0x3f, (byte)0x84, (byte)0xdb,
  (byte)0xbb, 0x61, (byte)0xa5, 0x63, 0x3b, 0x61, (byte)0xc9, (byte)0x83 };
str = "p]\uff89?\ufffd\uff7ba\uff65c;a\uff89\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5f, 0x53 };
str = "_S";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3f, 0x65, 0x39, 0x7e, 0x39, (byte)0xb5, (byte)0x9f,
  0x43, (byte)0xf7, (byte)0xa1, (byte)0xa6, (byte)0xc5, 0x6c, 0x78,
  (byte)0xea, (byte)0xe7, 0x66, 0x61, 0x4c, (byte)0xfb, (byte)0xa4 };
str = "?e9~9\uff75\u6ac3\ue584\uff66\uff85lx\ufffdfaL\u8a37";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x15 };
str = "\u0015";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x91, 0x67, (byte)0xa1, 0x01, 0x09, 0x49, 0x49,
  (byte)0xd0, 0x29, (byte)0xe2, 0x28, (byte)0xaa, 0x3b, 0x7f, 0x09, 0x22,
  (byte)0x97, 0x69, 0x0f, (byte)0xd6 };
str =

  "\u7d44\uff61\u0001\u0009II\uff90)\ufffd(\uff6a;\u007f\u0009\"\u64c1\u000f\uff96";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x36, 0x27, 0x79, (byte)0xbf, 0x6d, 0x30, 0x5c,
  (byte)0xaf };
str = "6'y\uff7fm0\\\uff6f";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x77, 0x44, 0x68, 0x0b, (byte)0xb8, 0x55, 0x58,
  (byte)0xdd, (byte)0xba, 0x50, 0x27, 0x0c, 0x65, 0x44, (byte)0xb5,
  (byte)0xf8, (byte)0xde, (byte)0xb3, (byte)0xe5, (byte)0xb8, (byte)0xe5,
  (byte)0x8c, 0x45, (byte)0xee, (byte)0x8b, 0x07, (byte)0xb6, (byte)0xd1 };
str =

  "wDh\u000b\uff78UX\uff9d\uff7aP'\u000ceD\uff75\ue67d\uff73\u87f6\u86f9E\u8abe\u0007\uff76\uff91";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa8, (byte)0x8f, (byte)0xa1, (byte)0xc2, 0x79,
  0x61, 0x46, (byte)0xb9, 0x00, 0x10, (byte)0xc8, 0x72, 0x70, (byte)0xd6,
  (byte)0xdc, 0x22, 0x73, 0x74, (byte)0x87, 0x6a, (byte)0xed, 0x22,
  (byte)0xd1, (byte)0xa9, (byte)0xd5, 0x10, 0x6b, 0x20 };
str =

  "\uff68\u5347\uff82yaF\uff79\u0000\u0010\uff88rp\uff96\uff9c\"st\u3326\ufffd\"\uff91\uff69\uff95\u0010k\u0020";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x49, 0x47, 0x2a, 0x6d, 0x51, 0x71, (byte)0xb1, 0x28,
  0x52 };
str = "IG*mQq\uff71(R";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2c, (byte)0x83, (byte)0xeb };
str = "\u002c\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x83, 0x4c, 0x0b, 0x58, (byte)0xd2, (byte)0xd9,
  (byte)0xd5, (byte)0xa2, (byte)0xad, (byte)0xed, 0x31, (byte)0xf6, 0x2a,
  0x1d };
str = "\u30ad\u000bX\uff92\uff99\uff95\uff62\uff6d\ufffd1\ufffd*\u001d";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x47, (byte)0xf4, (byte)0xfe, (byte)0xa7, 0x58 };
str = "G\ufffd\uff67X";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf7, (byte)0xfe, 0x21, 0x6c, (byte)0xf2, 0x2c };
str = "\ufffd!l\ufffd\u002c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa5, 0x4f, 0x3b, 0x4e, 0x5a, (byte)0xdd, 0x5b,
  (byte)0xbf, 0x00, (byte)0x80, (byte)0x94, 0x3f, 0x39, 0x23, 0x49,
  (byte)0x8d, (byte)0x91, 0x3b, 0x37, (byte)0xcd, (byte)0xbe, (byte)0xf4 };
str = "\uff65O;NZ\uff9d[\uff7f\u0000\u0080\ufffd?9#I\u56fd;7\uff8d\uff7e\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x30, 0x00, 0x39, 0x16, 0x06, (byte)0xab, (byte)0x8a,
  0x2b, 0x4f, 0x0a, 0x3d, 0x24, (byte)0xee, 0x6c, 0x48 };
str = "0\u00009\u0016\u0006\uff6b\ufffd+O\n\u003d$\ufa1dH";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5e, (byte)0x98, (byte)0xce, 0x38, 0x6b, 0x1c,
  (byte)0xf4, 0x63, (byte)0xac, 0x7f, (byte)0xd8, 0x5c, 0x62, 0x33,
  (byte)0xc1, 0x05 };
str = "^\u4f698k\u001c\ue313\uff6c\u007f\uff98\\b3\uff81\u0005";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9c, (byte)0xa0, 0x48, 0x73, 0x66, (byte)0xd1,
  0x79 };
str = "\u609bHsf\uff91y";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4f, (byte)0x95, (byte)0xf3, (byte)0x88, 0x70,
  (byte)0xd7, (byte)0x80, 0x03, 0x20, (byte)0xc7, (byte)0xec, (byte)0x9c,
  (byte)0xe0, 0x76, (byte)0xb5, 0x42, 0x79, 0x4a, 0x12, 0x70, 0x42 };
str =
  "O\u5b9d\ufffdp\uff97\u0080\u0003\u0020\uff87\ufffd\u70af\uff75ByJ\u0012pB";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x17, (byte)0xa8, 0x40, 0x65, 0x2f, 0x50, (byte)0xad,
  (byte)0xed, 0x4b, 0x7f, 0x3d, (byte)0xf3, 0x15, 0x25 };
str = "\u0017\uff68@e/P\uff6d\u5f45\u007f\u003d\ufffd\u0015%";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfa, 0x72, 0x7c, 0x0f };
str = "\u4f94|\u000f";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x26, 0x47, 0x75, (byte)0xb6, (byte)0xbb, (byte)0xba,
  0x18, 0x08, 0x39, 0x08, (byte)0x9c, 0x77, (byte)0x91, 0x00, (byte)0xca,
  0x0f, 0x6e, 0x5d, 0x3b, (byte)0xef, 0x20, 0x5f, 0x3e, (byte)0xf1, 0x19,
  (byte)0x8c, 0x52, 0x60, 0x35 };
str =

  "&Gu\uff76\uff7b\uff7a\u0018\u00089\u0008\u5fe4\ufffd\u0000\uff8a\u000fn];\ufffd\u0020_>\ufffd\u0019\u8ecd`5";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc5, (byte)0xda, 0x5e };
str = "\uff85\uff9a^";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xab, 0x75, 0x63, 0x5c, 0x79, (byte)0xf3, 0x31,
  0x46, 0x1e, (byte)0x83, (byte)0xfd, (byte)0xb4, (byte)0xb7, 0x07,
  (byte)0x93 };
str = "\uff6buc\\y\ufffd1F\u001e\ufffd\uff74\uff77\u0007\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9c, 0x13, 0x51, 0x5d, 0x6c, 0x3a, 0x4d, 0x56,
  (byte)0xb3, (byte)0xa3, (byte)0xfe, (byte)0x94, (byte)0x87, 0x02,
  (byte)0xba, 0x4e, (byte)0xae, (byte)0xa0, 0x3c, (byte)0x88 };
str =
  "\ufffd\u0013Q]l:MV\uff73\uff63\ufffd\u9019\u0002\uff7aN\uff6e\ufffd<\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x56, (byte)0xce, 0x2c, (byte)0xa7, (byte)0x8e, 0x30,
  0x7d, 0x52, 0x09, (byte)0x8c, (byte)0xbf, (byte)0xc3, (byte)0xab, 0x31,
  0x66, 0x41, (byte)0xe6, (byte)0xe4, 0x07 };
str = "V\uff8e\u002c\uff67\ufffd0}R\u0009\u8afa\uff83\uff6b1fA\u8dbe\u0007";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1f, (byte)0xe6, (byte)0xf8, 0x7b, 0x3b, 0x0f, 0x4a,
  (byte)0x97 };
str = "\u001f\u8e42\u007b;\u000fJ\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x62, 0x41, (byte)0x9a };
str = "bA\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x95, 0x19, (byte)0xd1, (byte)0xdf, 0x55,
  (byte)0x88, 0x18 };
str = "\ufffd\u0019\uff91\uff9fU\ufffd\u0018";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x38, 0x6f, 0x2c, (byte)0x97, 0x16, (byte)0xb8, 0x7c,
  0x0a, 0x5d, (byte)0xce, (byte)0xd5, 0x36, (byte)0xa3, 0x5f, (byte)0xeb,
  (byte)0xb5, (byte)0xa6, 0x00, (byte)0xba, 0x07, (byte)0x9f, (byte)0xfd,
  (byte)0xbc, (byte)0x88, (byte)0x87 };
str =

  "8o\u002c\ufffd\u0016\uff78|\n]\uff8e\uff956\uff63_\ufffd\uff66\u0000\uff7a\u0007\ufffd\uff7c\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x08, 0x63, 0x51, (byte)0xad, 0x77, (byte)0x84,
  (byte)0xb6, (byte)0xfc, 0x21, 0x5c };
str = "\u0008cQ\uff6dw\u252f\ufffd!\\";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb1, (byte)0xf1, 0x7f, 0x2d, 0x6e, (byte)0xdf,
  (byte)0xbd, (byte)0xef, (byte)0xd0, (byte)0x80, (byte)0x8b, (byte)0xcd,
  0x12, 0x4b, 0x77, 0x06, (byte)0xed, (byte)0xdb, 0x0c, (byte)0x82, 0x72 };
str =

  "\uff71\ufffd\u007f-n\uff9f\uff7d\ufffd\u0080\u50c5\u0012Kw\u0006\u6c86\u000c\uff33";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x58, (byte)0xfe, (byte)0x93 };
str = "X\ufffd\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x28, 0x2b, (byte)0xb1, 0x2a, 0x45, (byte)0x87, 0x53,
  0x42, 0x06, 0x20, (byte)0xee, 0x62, 0x7c, (byte)0xbf, 0x3f, 0x54, 0x4b,
  0x43, (byte)0xab, 0x77, 0x5a, 0x2a, (byte)0x89 };
str = "(+\uff71*E\u2473B\u0006\u0020\ufa19|\uff7f?TKC\uff6bwZ*\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf2, 0x29, (byte)0xa0, 0x31, (byte)0xf3,
  (byte)0x88, (byte)0x98, 0x5a, (byte)0xca, 0x5e, (byte)0xd0, 0x6e, 0x28,
  (byte)0x83, 0x56, (byte)0x80, 0x16, (byte)0x8b, (byte)0xb6, 0x59,
  (byte)0xa6, 0x70, (byte)0x8d, 0x37, (byte)0xe7, (byte)0xef, 0x42, 0x43,
  (byte)0x84 };
str =

  "\ufffd)\ufffd1\ue27b\u516d\uff8a^\uff90n(\u30b7\u0080\u0016\u72c2Y\uff66p\ufffd7\u9250BC\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0c, 0x38, (byte)0xcb, (byte)0xc2, (byte)0x9c,
  (byte)0xce, (byte)0xbc };
str = "\u000c8\uff8b\uff82\u615a\uff7c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x83, 0x45, (byte)0xfb, (byte)0xca, 0x6d,
  (byte)0xdb, 0x2a, (byte)0xd1, 0x43, 0x4f, (byte)0xf2, (byte)0xb1,
  (byte)0xca, (byte)0xfe, 0x25, 0x6b, (byte)0xc1, 0x59, 0x26, 0x63 };
str = "\u30a6\u9239m\uff9b*\uff91CO\ue1e8\uff8a\ufffd%k\uff81Y&c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe2, (byte)0x84, 0x56, (byte)0xf3, 0x25,
  (byte)0xad };
str = "\u9083V\ufffd%\uff6d";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7e, 0x76, 0x05, (byte)0x95, (byte)0xc3, 0x38,
  (byte)0x81, (byte)0xbd, (byte)0xf9, (byte)0xb5, (byte)0xf6, 0x28,
  (byte)0xd7 };
str = "~v\u0005\u965b8\u2283\ue710\ufffd(\uff97";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44, (byte)0xcc, 0x35, 0x00 };
str = "D\uff8c5\u0000";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb8, (byte)0xdd, (byte)0xc8, 0x13, (byte)0xf5,
  0x0a, 0x71, (byte)0xc4, (byte)0xfe, 0x31, 0x02, (byte)0xb2, 0x2a, 0x4a,
  (byte)0xfe, (byte)0xed };
str =
  "\uff78\uff9d\uff88\u0013\ufffd\nq\uff84\ufffd1\u0002\uff72*J\ufffd\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x54, (byte)0xe1, (byte)0xc0, 0x4d, 0x74, 0x06,
  (byte)0x9a, 0x48, 0x38, 0x47, (byte)0x97, 0x10, 0x7e, (byte)0x99, 0x4d,
  (byte)0xfb, 0x7c, (byte)0xaf, 0x27, 0x7f, (byte)0x9c, (byte)0xdf,
  (byte)0x99, 0x19 };
str =

  "T\u7724Mt\u0006\u550f8G\ufffd\u0010~\u5101\u7930\uff6f'\u007f\u6191\ufffd\u0019";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x51, (byte)0x92, (byte)0x99, 0x12, 0x24, 0x00, 0x20,
  0x05, 0x49, 0x67, (byte)0xbf, 0x4a, (byte)0xc6, 0x15, 0x52, 0x45,
  (byte)0xab, 0x61, 0x73, (byte)0x8d, 0x6e, 0x0d, 0x4b, (byte)0xd1, 0x67,
  (byte)0xa5 };
str =

  "Q\u8caf\u0012$\u0000\u0020\u0005Ig\uff7fJ\uff86\u0015RE\uff6bas\u80b1\rK\uff91g\uff65";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa6, 0x3d, 0x11, (byte)0x8e, 0x3f };
str = "\uff66\u003d\u0011\ufffd?";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x99, (byte)0xe5, 0x1d, (byte)0xb5, (byte)0xd6,
  0x21, (byte)0x8d, 0x5f, 0x67, (byte)0xc8, (byte)0x80, 0x40, (byte)0xb6,
  0x45, (byte)0xfd, (byte)0xee, 0x2a, (byte)0xd7, (byte)0xb7, (byte)0x88,
  (byte)0xae, 0x47 };
str =

  "\u541d\u001d\uff75\uff96!\u6d69g\uff88\u0080@\uff76E\ufffd\ufffd*\uff97\uff77\u65edG";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xee, (byte)0x88 };
str = "\u8a37";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x67, 0x52, (byte)0xe6, 0x7e, 0x59, 0x4f, 0x4e, 0x56,
  0x0a, (byte)0xe4, 0x63, 0x61, 0x2a, (byte)0xe5, 0x29, 0x10, 0x05,
  (byte)0xe3, 0x52 };
str = "gR\u8ae7YONV\n\u81d8a*\ufffd)\u0010\u0005\u7d63";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x18, (byte)0xf5, (byte)0xac, 0x2c, 0x57, 0x26, 0x40,
  (byte)0x92, 0x70, (byte)0xf3 };
str = "\u0018\ue417\u002cW&@\u6065\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x18, (byte)0xc5, 0x04, 0x32, 0x56, 0x53, 0x59,
  (byte)0xfe, (byte)0xf3, 0x4f, 0x0f, (byte)0xfb, 0x7a, 0x7b, 0x5f,
  (byte)0xec, 0x6f, 0x74, (byte)0xd8, 0x15, 0x55, (byte)0xef, (byte)0x8a,
  (byte)0xc4, 0x49, 0x7e, 0x52, (byte)0xf2 };
str =

  "\u0018\uff85\u00042VSY\ufffd\ue243\u000f\u7864\u007b_\ufffdot\uff98\u0015U\ufffd\uff84I~R\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x13, (byte)0xd1, (byte)0xc3, 0x66, 0x49, (byte)0xe5,
  0x56, 0x71, (byte)0xe0, (byte)0x97, (byte)0xa3, 0x55, (byte)0xdb, 0x76,
  0x48, 0x5c, 0x09, (byte)0xac, (byte)0x80 };
str = "\u0013\uff91\uff83fI\u85b9q\u71c9\uff63U\uff9bvH\\\u0009\uff6c\u0080";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
}
[Test]
public void TestShiftJISEncoder() {
byte[] bytes;
string str;
ICharacterEncoding charset = Encodings.GetEncoding("shift_jis");
str = "\uff67\u8eeb\uff25\u542e";
bytes = new byte[] { (byte)0xa7, (byte)0xe7, 0x66, (byte)0x82, 0x64,
  (byte)0x99, (byte)0xe2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff46\u7676";
bytes = new byte[] { (byte)0x82, (byte)0x86, (byte)0xe1, (byte)0xa0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5e1d";
bytes = new byte[] { (byte)0x92, (byte)0xe9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff63";
bytes = new byte[] { (byte)0xa3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6c92\u829f\u7a18\uff2f\uff3d";
bytes = new byte[] { (byte)0x9f, (byte)0x93, (byte)0xe4, (byte)0x8c,
  (byte)0xe2, 0x64, (byte)0x82, 0x6e, (byte)0x81, 0x6e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff95\uff26\u59bb";
bytes = new byte[] { (byte)0xd5, (byte)0x82, 0x65, (byte)0x8d, (byte)0xc8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5ee9";
bytes = new byte[] { (byte)0x9c, 0x48 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u63b5\u78e7";
bytes = new byte[] { (byte)0x9d, 0x7d, (byte)0xe2, 0x40 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u598d";
bytes = new byte[] { (byte)0x9b, 0x4a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6e07\u7ddc\uff1b";
bytes = new byte[] { (byte)0x8a, (byte)0x89, (byte)0xe3, 0x63, (byte)0x81,
  0x47 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u0013\u62d7\uffe3";
bytes = new byte[] { 0x13, (byte)0x9d, 0x58, (byte)0x81, 0x50 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe2\u59c9\u7e3d";
bytes = new byte[] { (byte)0x81, (byte)0xca, (byte)0x8e, 0x6f, (byte)0xe3,
  0x60 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5b";
bytes = new byte[] { (byte)0x81, 0x6f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u67bb\uff13";
bytes = new byte[] { (byte)0xfa, (byte)0xe2, (byte)0x82, 0x52 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3e\uff98\u2252";
bytes = new byte[] { (byte)0x81, 0x4f, (byte)0xd8, (byte)0x81, (byte)0xe0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6881\u6021";
bytes = new byte[] { (byte)0x97, (byte)0xc0, (byte)0x9c, 0x7d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6baa\u78ba";
bytes = new byte[] { (byte)0x9f, 0x6f, (byte)0x8a, 0x6d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff61\u5ff5\u624e\u2211";
bytes = new byte[] { (byte)0xa1, (byte)0x94, 0x4f, (byte)0x9d, 0x48,
  (byte)0x87, (byte)0x94 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u001d\u8eb0\uff8b";
bytes = new byte[] { 0x1d, (byte)0xe7, 0x5b, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u71ee\u5230\u5d18\u6e6f";
bytes = new byte[] { (byte)0x99, (byte)0xd7, (byte)0x93, (byte)0x9e,
  (byte)0x9b, (byte)0xc5, (byte)0x93, (byte)0x92 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff03\u7b1b\uff5a\uffe2\u0014\u8b26";
bytes = new byte[] { (byte)0x81, (byte)0x94, (byte)0x93, 0x4a, (byte)0x82,
  (byte)0x9a, (byte)0x81, (byte)0xca, 0x14, (byte)0xe6, (byte)0x92 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u22bf\uff03\u73d6";
bytes = new byte[] { (byte)0x87, (byte)0x99, (byte)0x81, (byte)0x94,
  (byte)0xfb, 0x62 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d2c";
bytes = new byte[] { (byte)0x92, (byte)0xdb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5147\uff79\uff83\uff85";
bytes = new byte[] { (byte)0x8b, (byte)0xa2, (byte)0xb9, (byte)0xc3,
  (byte)0xc5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7634\u50d5";
bytes = new byte[] { (byte)0xe1, (byte)0x8f, (byte)0x96, 0x6c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u51b5\u5acc\uff66";
bytes = new byte[] { (byte)0x99, 0x76, (byte)0x8c, (byte)0x99, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9c\u6bcd\u742a\u5abd";
bytes = new byte[] { (byte)0xdc, (byte)0x95, (byte)0xea, (byte)0xfb, 0x68,
  (byte)0x9b, 0x5f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u30d9\uff24\u7be0\u5c39";
bytes = new byte[] { (byte)0x83, 0x78, (byte)0x82, 0x63, (byte)0x8e,
  (byte)0xc2, (byte)0x9b, (byte)0x9a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7296\u628a\uff3b\uff91";
bytes = new byte[] { (byte)0xe0, (byte)0xb6, (byte)0x94, 0x63, (byte)0x81,
  0x6d, (byte)0xd1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u79d5";
bytes = new byte[] { (byte)0xe2, 0x5d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u75e2\uff5c\uff95\uff0b";
bytes = new byte[] { (byte)0x97, (byte)0x9f, (byte)0x81, 0x62, (byte)0xd5,
  (byte)0x81, 0x7b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2208";
bytes = new byte[] { (byte)0x81, (byte)0xb8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u60da\uff8d\u7d18";
bytes = new byte[] { (byte)0x8d, (byte)0x9b, (byte)0xcd, (byte)0x8d, 0x68 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff94\u738b\u2534\uffe4";
bytes = new byte[] { (byte)0xd4, (byte)0x89, (byte)0xa4, (byte)0x84,
  (byte)0xa8, (byte)0xfa, 0x55 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe4\uff36\uff4e";
bytes = new byte[] { (byte)0xfa, 0x55, (byte)0x82, 0x75, (byte)0x82,
  (byte)0x8e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6649";
bytes = new byte[] { (byte)0x9d, (byte)0xe7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff7f\u5132\uff3f";
bytes = new byte[] { (byte)0xbf, (byte)0x96, (byte)0xd7, (byte)0x81, 0x51 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5df1\uff43\uff73";
bytes = new byte[] { (byte)0x8c, (byte)0xc8, (byte)0x82, (byte)0x83,
  (byte)0xb3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7b39\u5bc2";
bytes = new byte[] { (byte)0x8d, (byte)0xf9, (byte)0x8e, (byte)0xe2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7f9a\uff40\uff3e\u5feb\u7977";
bytes = new byte[] { (byte)0xe3, (byte)0xb7, (byte)0x81, 0x4d, (byte)0x81,
  0x4f, (byte)0x89, (byte)0xf5, (byte)0x93, (byte)0x98 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u68a8\u5e7c";
bytes = new byte[] { (byte)0x97, (byte)0x9c, (byte)0x97, 0x63 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u222a\u5c5e";
bytes = new byte[] { (byte)0x81, (byte)0xbe, (byte)0x91, (byte)0xae };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6715";
bytes = new byte[] { (byte)0x92, (byte)0xbd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff88\u2266";
bytes = new byte[] { (byte)0xc8, (byte)0x81, (byte)0x85 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff73";
bytes = new byte[] { (byte)0xb3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u550f\u7bf7\uff58\uff46";
bytes = new byte[] { (byte)0x9a, 0x48, (byte)0xe2, (byte)0xc9, (byte)0x82,
  (byte)0x98, (byte)0x82, (byte)0x86 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7737\uff2c\uff22";
bytes = new byte[] { (byte)0xe1, (byte)0xc5, (byte)0x82, 0x6b, (byte)0x82,
  0x61 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3e";
bytes = new byte[] { (byte)0x81, 0x4f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5960\u61b6\u246b";
bytes = new byte[] { (byte)0x9a, (byte)0xf9, (byte)0x89, (byte)0xaf,
  (byte)0x87, 0x4b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff54\u2234\uff14";
bytes = new byte[] { (byte)0x82, (byte)0x94, (byte)0x81, (byte)0x88,
  (byte)0x82, 0x53 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff54\uff57\uff49";
bytes = new byte[] { (byte)0x82, (byte)0x94, (byte)0x82, (byte)0x97,
  (byte)0x82, (byte)0x89 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5f0c\u6f97";
bytes = new byte[] { (byte)0x98, (byte)0x9f, (byte)0x8a, (byte)0xc0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3a\u7b92\uff22\uff6a\u72a7\u7a84";
bytes = new byte[] { (byte)0x82, 0x79, (byte)0xe2, (byte)0xb4, (byte)0x82,
  0x61, (byte)0xaa, (byte)0xe0, (byte)0xb8, (byte)0x8d, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6de4\u5ef0\uff8f\u78a3";
bytes = new byte[] { (byte)0x9f, (byte)0xc9, (byte)0x9c, 0x4c, (byte)0xcf,
  (byte)0xe1, (byte)0xf0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff40";
bytes = new byte[] { (byte)0x81, 0x4d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u66f4\u59be";
bytes = new byte[] { (byte)0x8d, 0x58, (byte)0x8f, (byte)0xa8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7984\u212b\u5192\u9c24";
bytes = new byte[] { (byte)0x98, 0x5c, (byte)0x81, (byte)0xf0, (byte)0x96,
  0x60, (byte)0xe9, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = ")\uff73\uff86\u76fb";
bytes = new byte[] { 0x29, (byte)0xb3, (byte)0xc6, (byte)0xe1, (byte)0xbb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6f91";
bytes = new byte[] { (byte)0xe0, 0x50 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1c\u61a7\u7d89\u7c4c";
bytes = new byte[] { (byte)0x81, (byte)0x83, (byte)0x93, (byte)0xb2,
  (byte)0xe3, 0x54, (byte)0xe2, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe0";
bytes = new byte[] { (byte)0x81, (byte)0x91 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff16";
bytes = new byte[] { (byte)0x82, 0x55 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff42\u52d5\uff32";
bytes = new byte[] { (byte)0x82, (byte)0x82, (byte)0x93, (byte)0xae,
  (byte)0x82, 0x71 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff16\u6dac";
bytes = new byte[] { (byte)0x82, 0x55, (byte)0xfb, 0x41 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7907\uff82";
bytes = new byte[] { (byte)0xe2, 0x44, (byte)0xc2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u8983\uff62";
bytes = new byte[] { (byte)0xe6, 0x48, (byte)0xa2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1a\u7c1f\uff8b";
bytes = new byte[] { (byte)0x81, 0x46, (byte)0xe2, (byte)0xd0, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u56f0\u574a\uff15";
bytes = new byte[] { (byte)0x8d, (byte)0xa2, (byte)0x96, 0x56, (byte)0x82,
  0x54 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u246f\u777e\u5506\u6703\uff19";
bytes = new byte[] { (byte)0x87, 0x4f, (byte)0xe1, (byte)0xce, (byte)0x8d,
  (byte)0xb4, (byte)0x98, (byte)0xf0, (byte)0x82, 0x58 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "b\uff5c\uff78";
bytes = new byte[] { 0x62, (byte)0x81, 0x62, (byte)0xb8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e9c\uff20\uff35";
bytes = new byte[] { (byte)0xe3, (byte)0x9c, (byte)0x81, (byte)0x97,
  (byte)0x82, 0x74 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3f\uff65\uff84";
bytes = new byte[] { (byte)0x81, 0x51, (byte)0xa5, (byte)0xc4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6a0c";
bytes = new byte[] { (byte)0x9e, (byte)0xec };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9b";
bytes = new byte[] { (byte)0xdb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1e\u246d";
bytes = new byte[] { (byte)0x81, (byte)0x84, (byte)0x87, 0x4d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3e\uff89\u7985";
bytes = new byte[] { (byte)0x81, 0x4f, (byte)0xc9, (byte)0x91, 0x54 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "9\uff95\u266d";
bytes = new byte[] { 0x39, (byte)0xd5, (byte)0x81, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u25c6\uff05\u6bbf";
bytes = new byte[] { (byte)0x81, (byte)0x9f, (byte)0x81, (byte)0x93,
  (byte)0x93, 0x61 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6e9c\u5c05\uff0c";
bytes = new byte[] { (byte)0x97, (byte)0xad, (byte)0x9b, (byte)0x91,
  (byte)0x81, 0x43 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff25\u531a";
bytes = new byte[] { (byte)0x82, 0x64, (byte)0x99, (byte)0xb7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u254b\u7bb4\uff29";
bytes = new byte[] { (byte)0x84, (byte)0xb4, (byte)0xe2, (byte)0xbc,
  (byte)0x82, 0x68 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff53\u7ab0O";
bytes = new byte[] { (byte)0x82, (byte)0x93, (byte)0xe2, 0x7e, 0x4f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u67a1\uffe1\u685f";
bytes = new byte[] { (byte)0x9e, 0x65, (byte)0x81, (byte)0x92, (byte)0x8e,
  0x56 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5968\u52c0\u668e";
bytes = new byte[] { (byte)0x8f, (byte)0xa7, (byte)0xfa, (byte)0x87,
  (byte)0x9d, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6c8d";
bytes = new byte[] { (byte)0x9f, (byte)0x8c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u64da\u6e98\uff2d";
bytes = new byte[] { (byte)0x9d, (byte)0x9f, (byte)0x9f, (byte)0xe3,
  (byte)0x82, 0x6c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5631";
bytes = new byte[] { (byte)0x8f, (byte)0xfa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u856d\uffe4\u81a9";
bytes = new byte[] { (byte)0xe5, 0x4a, (byte)0xfa, 0x55, (byte)0xe4, 0x56 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff23\uff9b\uff33\u61ca";
bytes = new byte[] { (byte)0x82, 0x62, (byte)0xdb, (byte)0x82, 0x72,
  (byte)0x9c, (byte)0xe3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u753a\u5c22\uff44";
bytes = new byte[] { (byte)0x92, (byte)0xac, (byte)0x9b, (byte)0x97,
  (byte)0x82, (byte)0x84 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6684\uff0c\u570d";
bytes = new byte[] { (byte)0x9d, (byte)0xf5, (byte)0x81, 0x43, (byte)0x9a,
  (byte)0xa1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff95";
bytes = new byte[] { (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4e\u8a1d\uff7e";
bytes = new byte[] { (byte)0x82, (byte)0x8e, (byte)0xe6, 0x62, (byte)0xbe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6083\u6d35\u525b";
bytes = new byte[] { (byte)0x9c, (byte)0x9d, (byte)0x9f, (byte)0xab,
  (byte)0x8d, (byte)0x84 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff81";
bytes = new byte[] { (byte)0xc1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6e1b\u542b\u707c";
bytes = new byte[] { (byte)0x8c, (byte)0xb8, (byte)0x8a, (byte)0xdc,
  (byte)0x8e, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7a81";
bytes = new byte[] { (byte)0x93, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5b32\u2312\uff9c";
bytes = new byte[] { (byte)0x9b, 0x6a, (byte)0x81, (byte)0xdc, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u222c\uff39\uff7e";
bytes = new byte[] { (byte)0x81, (byte)0xe8, (byte)0x82, 0x78, (byte)0xbe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff9d\u52fa\uff08";
bytes = new byte[] { (byte)0xdd, (byte)0x8e, (byte)0xd9, (byte)0x81, 0x69 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
}
}
}
