using System;
using NUnit.Framework;
using PeterO;
using PeterO.Text;
using Test;

namespace EncodingTest {
[TestFixture]
public class KoreanEUCTest {
[Test]
public void TestKoreanEUCDecoder() {
byte[] bytes;
string str;
ICharacterEncoding charset = Encodings.GetEncoding("euc-kr");
bytes = new byte[] { 0x41, (byte)0xc9, 0x43, 0x47, 0x3b, (byte)0xb0, 0x73,
  0x32, 0x54, (byte)0xf5 };
str = "A\ufffdCG;\ucece2T\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x27, (byte)0x8b, 0x7b, (byte)0x84, (byte)0xcc, 0x1d,
  0x07 };
str = "'\ufffd\u007b\uaf83\u001d\u0007";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6e, 0x53, (byte)0xac, 0x2e, (byte)0x9f, (byte)0xa4,
  0x17, 0x52, 0x13, (byte)0xe1, 0x50 };
str = "nS\ufffd.\uc723\u0017R\u0013\ufffdP";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x01, (byte)0xd0, (byte)0xfa, (byte)0xec, 0x3d, 0x45,
  (byte)0xa5, 0x78, 0x29, 0x42, 0x25, (byte)0xd7, 0x29, 0x66, 0x3f, 0x02,
  0x0d, 0x6f, (byte)0x91, 0x61, 0x37, (byte)0xd5, 0x47 };
str = "\u0001\u5e7e\ufffd=E\uca83)B%\ufffd)f?\u0002\u000do\uba727\ufffdG";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x69, 0x24, 0x72, 0x67, (byte)0xcc, 0x22, (byte)0x8f,
  (byte)0x8a, (byte)0xe8, (byte)0xa8, 0x53, 0x43, (byte)0xf9, 0x31, 0x00,
  0x5b, 0x6e, 0x09, (byte)0xfb, 0x47, (byte)0xe7, (byte)0xef, 0x5e, 0x4b,
  0x2a, 0x5d, (byte)0xba, 0x58, 0x49 };
str = "i$rg\ufffd\"\ub8cb\u9f07SC\ufffd1\u0000[n\u0009\ufffdG\u5433^K*]\ud2aaI";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd4, (byte)0xae, (byte)0xa9 };
str = "\u8ced\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4f, (byte)0xf9, 0x7a, 0x1c };
str = "O\ufffdz\u001c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc7, (byte)0xb4, 0x4f, 0x44, 0x53, (byte)0xc4,
  0x65, (byte)0xf7, 0x51, (byte)0x85, (byte)0xd3, (byte)0xfb, 0x49, 0x12,
  0x08, 0x77, 0x2e };
str = "\ud494ODS\ud6d2\ufffdQ\ub069\ufffdI\u0012\u0008w.";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd0, 0x77, 0x48, 0x61, 0x3c, 0x4d, (byte)0xe9,
  0x08, 0x24, (byte)0xdb, 0x48, 0x32, (byte)0xc3, (byte)0x8f, 0x69, 0x41,
  0x45, 0x33, 0x3e, 0x68, (byte)0xcb, 0x57, 0x63, 0x64, (byte)0xc5,
  (byte)0xc5, 0x15 };
str = "\ufffdwHa<M\ufffd\u0008$\ufffdH2\ud695iAE3>h\ufffdWcd\ud0e4\u0015";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0b, 0x55, (byte)0xcc, 0x02, (byte)0xa2, 0x77, 0x48,
  (byte)0xa7, 0x7d, (byte)0xb0, 0x2f, (byte)0xd4, (byte)0xf3, (byte)0xca,
  (byte)0xd5, 0x6e, 0x44, 0x6c, 0x2e, (byte)0xb0, (byte)0xe9, (byte)0xc4,
  0x5c };
str = "\u000bU\ufffd\u0002\uc944H\ufffd}\ufffd/\u71c8\u6f97nDl.\uacc8\ufffd\\";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x70, (byte)0xf4, 0x7a, 0x74, 0x1d, 0x04, 0x5e, 0x4d,
  0x3f, (byte)0xd6, 0x6d, 0x56, (byte)0x89, 0x2c };
str = "p\ufffdzt\u001d\u0004^M?\ufffdmV\ufffd\u002c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xba, 0x17, 0x0a, 0x33, (byte)0xf9, 0x31,
  (byte)0xdb, 0x55, 0x37, 0x70, (byte)0xf6, (byte)0x8e, 0x13, 0x15,
  (byte)0x85, (byte)0xd5, 0x00, 0x27, 0x77, (byte)0x96, (byte)0xe0, 0x72,
  0x3d, 0x18, (byte)0xf2, 0x71, (byte)0xd1, 0x76, (byte)0x95 };
str =

  "\ufffd\u0017\u000a3\ufffd1\ufffdU7p\ufffd\u0013\u0015\ub06b\u0000'w\ubf64r=\u0018\ufffdq\ufffdv\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5f };
str = "_";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x09, 0x2d, (byte)0xfe, (byte)0xee, 0x05, (byte)0xb5,
  (byte)0x8c, 0x54, 0x2d, 0x15, 0x70 };
str = "\u0009-\ufffd\u0005\ud0eaT-\u0015p";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa9, (byte)0xb5, 0x7d, 0x59, 0x64, 0x5e, 0x68,
  (byte)0xad, (byte)0x96, 0x39 };
str = "\u3204}Yd^h\ucdba9";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xff, (byte)0xab, (byte)0x85, 0x76, 0x76, 0x06,
  0x7a, (byte)0xc7, 0x33, 0x7c, 0x15, (byte)0x9b, (byte)0xbc, 0x21,
  (byte)0xe2, (byte)0xda, 0x3e, 0x28, (byte)0xa9 };
str = "\ufffd\uccdfvv\u0006z\ufffd3|\u0015\uc395!\u7421>(\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe2, 0x66, 0x7b, 0x78, 0x50, (byte)0xac, 0x21,
  0x4f, 0x2e, 0x42, (byte)0xfd, (byte)0xe4, 0x59 };
str = "\ufffdf\u007bxP\ufffd!O.B\u6b46Y";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x28, (byte)0xae, 0x6b, (byte)0xf6, (byte)0x8a, 0x3e };
str = "(\ucdee\ufffd>";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5f, (byte)0xf6, (byte)0xc7, 0x0a, 0x35, (byte)0xf8,
  0x72, 0x3d, (byte)0xec };
str = "_\u7f6e\u000a5\ufffdr=\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdd, 0x26, 0x23, (byte)0xe5, 0x41 };
str = "\ufffd&#\ufffdA";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa4, 0x26, 0x47, 0x74 };
str = "\ufffd&Gt";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x27, 0x49, (byte)0xf0, (byte)0xdb, (byte)0xc3,
  (byte)0xe7, 0x51, 0x67, (byte)0xd1, (byte)0xac, 0x0b, 0x74, (byte)0xf9,
  0x13, (byte)0x8b, (byte)0xac, (byte)0xe1, 0x34, (byte)0xfc };
str = "'I\u7e70\ucdb0Qg\u7398\u000bt\ufffd\u0013\ub596\ufffd4\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc3, (byte)0x83, (byte)0xdf, 0x21, (byte)0xd9,
  0x60, (byte)0xa3, 0x0d, 0x75, (byte)0x97, 0x06, (byte)0xc8, 0x7d,
  (byte)0xeb, (byte)0xd8, (byte)0xfa };
str = "\ud684\ufffd!\ufffd`\ufffd\u000du\ufffd\u0006\ufffd}\uf9dc\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x91, (byte)0xa0, (byte)0xa1, 0x24, (byte)0xfc,
  0x2d, (byte)0xa7, 0x53, (byte)0xf6, 0x6a, 0x11, (byte)0x94, 0x48,
  (byte)0xca, (byte)0x8d, 0x2e, (byte)0xa6, (byte)0x8c, (byte)0xf3, 0x2e,
  (byte)0xd7, (byte)0x8b, 0x37, 0x6d, (byte)0x86, (byte)0x9d, 0x03,
  (byte)0xca, 0x58 };
str =

  "\ubaba\ufffd$\ufffd-\ucb22\ufffdj\u0011\ubd08\ufffd.\ucaf5\ufffd.\ufffd7m\ub114\u0003\ufffdX";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5f, 0x49, (byte)0xae, 0x5a, 0x04, 0x57, 0x48,
  (byte)0xce, (byte)0xd3, (byte)0x94, (byte)0xb2, (byte)0xbd, 0x56, 0x5e,
  0x42, (byte)0xd6, (byte)0xd7, 0x5e, (byte)0x94, (byte)0xc8, 0x07,
  (byte)0x9b, (byte)0xf3, (byte)0xf0, (byte)0xe3, 0x17, (byte)0xcd, 0x01 };
str =

  "_I\ucde1\u0004WH\u5080\ubd74\ud3f2^B\u865c^\ubd94\u0007\uc3cd\u9020\u0017\ufffd\u0001";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x27, (byte)0xd9, 0x2b, 0x06, 0x6c, (byte)0xd5, 0x4d,
  (byte)0xf5, (byte)0xea, 0x5b, (byte)0x81, 0x1b, (byte)0xe8, (byte)0x8b,
  (byte)0x8c, (byte)0xd4, (byte)0xde, (byte)0xbf, (byte)0xbb, 0x29,
  (byte)0xbc, 0x30 };
str =
  "'\ufffd+\u0006l\ufffdM\u7e2e[\ufffd\u001b\ufffd\ub691\u4e4d\ufffd)\ufffd0";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x67, 0x29, 0x36, 0x49, 0x66 };
str = "g)6If";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x96, (byte)0xdf, 0x7e, (byte)0xd2, 0x19,
  (byte)0x9f, 0x7c, 0x54, 0x72, 0x21, 0x60, 0x18, 0x23, (byte)0x9e,
  (byte)0xaf, 0x2e, 0x06, 0x01, (byte)0x80 };
str = "\ubf63~\ufffd\u0019\ufffd|Tr!`\u0018#\uc638.\u0006\u0001\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7a, (byte)0xe9, (byte)0xe7, (byte)0xce, (byte)0xda,
  (byte)0x83, (byte)0xd0, 0x58, (byte)0x8f, (byte)0xc3, 0x70, 0x02, 0x4c,
  0x37, 0x02, 0x6c, 0x63, (byte)0xe7, (byte)0xd9, 0x5d, 0x52, 0x57, 0x69,
  0x71, (byte)0xd4 };
str = "z\u9047\u9b41\uaeaaX\ub913p\u0002L7\u0002lc\u730a]RWiq\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa0, 0x14, 0x60, 0x47, 0x23, (byte)0xbf, 0x16,
  0x41, 0x16, (byte)0xa8, (byte)0x98, 0x11, 0x47, 0x79, (byte)0x9f, 0x3c,
  (byte)0xe6, (byte)0xc2, 0x3d, 0x2a, 0x5e, (byte)0xe8, 0x2c, 0x28,
  (byte)0x8c };
str =

  "\ufffd\u0014`G#\ufffd\u0016A\u0016\ucbbc\u0011Gy\ufffd<\u5a1f=*^\ufffd\u002c(\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe0, (byte)0xa4, 0x46, (byte)0xb3, 0x69, 0x79,
  (byte)0xed, (byte)0xf5, 0x3a, 0x7b, 0x18, (byte)0xbb, 0x0c, (byte)0xf0,
  0x10, (byte)0xe2, (byte)0xd7, 0x75, 0x06, 0x78, 0x2e };
str =
  "\u897fF\ucff6y\u81e7:\u007b\u0018\ufffd\u000c\ufffd\u0010\u6dd1u\u0006x.";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf8, 0x25, (byte)0xa9, 0x54, (byte)0x8e, 0x42,
  0x1b, 0x3b, (byte)0xb8, 0x6e, (byte)0x86, (byte)0x90 };
str = "\ufffd%\ucbd9\ub7a1\u001b;\ud1fa\ub100";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xea, 0x2c, (byte)0xe3, 0x64 };
str = "\ufffd\u002c\ufffdd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfe, (byte)0x91, (byte)0xe3, (byte)0xf8,
  (byte)0xe6, (byte)0xfa, 0x58, (byte)0x9f, 0x10, 0x68, (byte)0xa2, 0x07,
  (byte)0xec, (byte)0xcb, 0x0f };
str = "\ufffd\u5ba4\u708eX\ufffd\u0010h\ufffd\u0007\u7037\u000f";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x78, (byte)0xc1, 0x6b, 0x6c, 0x59, 0x67, (byte)0xb8,
  0x74, 0x62, (byte)0xb8, 0x66, 0x29, (byte)0x91, 0x56, (byte)0xb3,
  (byte)0x9a, (byte)0x96, 0x79, (byte)0x8f, 0x21, 0x04, (byte)0xf3,
  (byte)0xf0, (byte)0xfd, (byte)0xc7, (byte)0x83, 0x6a };
str =
  "x\ud597lYg\ud200b\ud1f0)\uba6b\ud026\ubef4\ufffd!\u0004\u50b5\u6689\uae26";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x47, 0x6c };
str = "Gl";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5c, (byte)0xd4, (byte)0xcb, (byte)0xd7, (byte)0xab,
  (byte)0xfb, (byte)0xbe, 0x02, 0x56, (byte)0xe7, (byte)0xaa, 0x36,
  (byte)0x95, (byte)0xd8, 0x63, (byte)0xfb, 0x71, 0x2d, (byte)0x98, 0x15,
  0x69, (byte)0xb6, 0x36, (byte)0xc1, 0x1d, (byte)0xc5, 0x75, 0x3c, 0x2c };
str =

  "\\\u9813\u7d2f\u58fa\u0002V\uf9a96\ube89c\ufffdq-\ufffd\u0015i\ufffd6\ufffd\u001d\ud755<\u002c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x70, (byte)0xe8, 0x7a, 0x2f };
str = "p\ufffdz/";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x50, (byte)0xdf, 0x39, (byte)0xb3 };
str = "P\ufffd9\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1c, 0x39, 0x7f, 0x6a, 0x2a, (byte)0xf7, 0x67, 0x10,
  (byte)0xa8, 0x6f, 0x16, 0x2a, (byte)0xbf, (byte)0x84, 0x12, 0x2b, 0x43,
  0x44, 0x5f, 0x6f };
str = "\u001c9\u007fj*\ufffdg\u0010\ucb97\u0016*\ud4d9\u0012+CD_o";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf0, (byte)0x86, (byte)0xe7, 0x05, 0x07, 0x67,
  0x00, (byte)0xe6, 0x12, (byte)0xc5, (byte)0xdc, (byte)0x8a, 0x25, 0x5e,
  0x31, 0x07, (byte)0x84 };
str = "\ufffd\ufffd\u0005\u0007g\u0000\ufffd\u0012\ud15d\ufffd%^1\u0007\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb5, 0x25, 0x00, 0x74, 0x43, 0x3c, 0x7e,
  (byte)0xc5, (byte)0xa8, (byte)0xf3, (byte)0xf4, 0x55 };
str = "\ufffd%\u0000tC<~\ud060\u5f69U";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x06, 0x78, (byte)0xae, (byte)0xef, 0x78, (byte)0xcf,
  (byte)0xd4, (byte)0xe2 };
str = "\u0006x\ufffdx\u97ab\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x39, (byte)0xf2, (byte)0x97, 0x25, 0x45, (byte)0xa9,
  (byte)0xc9, 0x1b, 0x6e, 0x37, 0x5a, (byte)0x89, 0x1b };
str = "9\ufffd%E\u3218\u001bn7Z\ufffd\u001b";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x22, (byte)0xbf, 0x00, (byte)0xf7, 0x15, (byte)0xdb,
  0x3b, (byte)0xd0, 0x08, 0x60, 0x5b, (byte)0xfb, (byte)0x96, (byte)0xfc,
  0x37, (byte)0xb0, 0x2d, 0x62, 0x06, (byte)0x95, 0x33, (byte)0x91, 0x71,
  (byte)0x93, 0x05, (byte)0xb6, 0x6a, 0x2a, (byte)0xf3 };
str =

  "\"\ufffd\u0000\ufffd\u0015\ufffd;\ufffd\u0008`[\ufffd\ufffd7\ufffd-b\u0006\ufffd3\uba88\ufffd\u0005\ud129*\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x55, (byte)0xab, (byte)0xfd, 0x40, (byte)0xfc,
  (byte)0xd6, (byte)0xa4, 0x0b };
str = "U\ufffd@\u7bc1\ufffd\u000b";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x21, 0x6b, 0x2e, 0x22 };
str = "!k.\"";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x66, 0x39, 0x56, 0x1c, 0x6a, 0x79, (byte)0xdc,
  (byte)0xb2, 0x50, 0x26, (byte)0xec };
str = "f9V\u001cjy\u5175P&\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5e, (byte)0x96, 0x75, 0x2b, 0x37, (byte)0x8a,
  (byte)0xba, 0x15, 0x04, (byte)0x8e, (byte)0xe4, 0x31, (byte)0x89, 0x35,
  0x4f, (byte)0xcd, (byte)0xfb, (byte)0x83, 0x30, 0x63, 0x11 };
str = "^\ubef0+7\ub4c6\u0015\u0004\ub8631\ufffd5O\u5be1\ufffd0c\u0011";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x31, 0x2a, 0x2d, 0x5c, 0x60, (byte)0xfe, 0x20, 0x06,
  0x62, 0x5f, 0x73, (byte)0xeb, 0x03, 0x20, (byte)0xe8, (byte)0x98 };
str = "1*-\\`\ufffd \u0006b_s\ufffd\u0003 \ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3c };
str = "<";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfa, 0x7a, 0x5a, 0x42, (byte)0x8e, 0x75,
  (byte)0xe1, 0x3d, 0x26, (byte)0xb2, 0x5c, (byte)0xed, 0x79, 0x7f,
  (byte)0xf8, 0x4d, 0x26, 0x3a };
str = "\ufffdzZB\ub7d8\ufffd=&\ufffd\\\ufffdy\u007f\ufffdM&:";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5c, (byte)0xe4, 0x46, 0x37, 0x2b, (byte)0x99, 0x37,
  0x78, 0x19, 0x37, 0x79, (byte)0xca, 0x5a, (byte)0xe1, (byte)0xa8,
  (byte)0xdc, 0x62, (byte)0xd5, 0x2e, 0x08, 0x45, 0x57, (byte)0xc8, 0x2a,
  (byte)0xc0, 0x32, 0x40, (byte)0xd4, (byte)0x9c, 0x5d };
str =

  "\\\ufffdF7+\ufffd7x\u00197y\ufffdZ\u6b72\ufffdb\ufffd.\u0008EW\ufffd*\ufffd2@\ufffd]";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1f, 0x32, 0x62, 0x34, 0x75, (byte)0xf5 };
str = "\u001f2b4u\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x40, 0x4a, (byte)0x84, 0x22, (byte)0x8f, (byte)0xdd,
  0x49, (byte)0xea, (byte)0x95, (byte)0xd7, (byte)0xe2, 0x46, 0x47, 0x30,
  0x55, 0x4f, (byte)0xde, (byte)0xfa };
str = "@J\ufffd\"\ub92fI\ufffd\u7406FG0UO\u9e9d";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xac, 0x51 };
str = "\ucd13";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd2, 0x33, (byte)0xa0, 0x5d, 0x35, 0x31,
  (byte)0x96, (byte)0xec, 0x42, 0x4f, (byte)0xa3, 0x02, 0x23, 0x74, 0x46,
  (byte)0xc0, (byte)0x9b, (byte)0x9a, (byte)0xe2, 0x46, 0x35, 0x61, 0x63 };
str = "\ufffd3\ufffd]51\ubf70BO\ufffd\u0002#tF\ud55d\uc2e2F5ac";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc8, (byte)0x8d, 0x5c, 0x4e, (byte)0x8a,
  (byte)0xb1, (byte)0xc2, 0x39, (byte)0x99, 0x7a, (byte)0xf9, (byte)0xc2,
  (byte)0xdc };
str = "\ufffd\\N\ub4bb\ufffd9\uc17b\u7455\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xaa, 0x6e, 0x75, 0x3b, 0x7f, (byte)0xb7,
  (byte)0xb7, 0x60, 0x34, 0x29, 0x5d, 0x44, 0x01, (byte)0x84, (byte)0xcf,
  (byte)0xa2, 0x6d, (byte)0xc9, (byte)0xeb, 0x43, (byte)0xe0, (byte)0xa3,
  (byte)0xb8, (byte)0xd0, 0x63 };
str = "\ucc62u;\u007f\ub801`4)]D\u0001\uaf87\uc93a\ufffdC\u85af\uba01c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x33, 0x68, 0x59, (byte)0xed, 0x39, (byte)0x9e,
  (byte)0xdd, 0x36, 0x37, (byte)0xec, 0x07, 0x0e, 0x23, 0x22, (byte)0xbb,
  (byte)0xf0, (byte)0xac, (byte)0xf0, 0x7b, 0x2e, 0x02, (byte)0xbf, 0x31,
  0x4f };
str =
  "3hY\ufffd9\uc67767\ufffd\u0007\u000e#\"\uc0bd\u044e\u007b.\u0002\ufffd1O";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcc, (byte)0x81, (byte)0xba, 0x6e, 0x23 };
str = "\ufffd\ud2c1#";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x24, 0x1b, (byte)0x94, (byte)0xcb, 0x4c, (byte)0xf8,
  0x5b, (byte)0xbb, 0x4f, 0x33, 0x54, 0x2f, (byte)0xa7, 0x28 };
str = "$\u001b\ubd98L\ufffd[\ud3113T/\ufffd(";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc0, (byte)0xa4, 0x72, (byte)0xe0, (byte)0xf7,
  (byte)0x8a, 0x34, 0x7f, 0x2d, 0x53, (byte)0xe9, (byte)0xab, 0x79, 0x3b,
  (byte)0x81, 0x2a, 0x6b, (byte)0xae, (byte)0xdc };
str = "\uc6f8r\u6210\ufffd4\u007f-S\u9059y;\ufffd*k\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x69, 0x56, 0x10, 0x7e, (byte)0xb5, (byte)0xc9,
  (byte)0xc3, 0x55, (byte)0xb8, 0x59, 0x11, 0x0a, (byte)0xd4, 0x6c, 0x39,
  0x74, (byte)0xd3, 0x0a, 0x71, 0x4d, (byte)0xfe, (byte)0xda, 0x29, 0x3a,
  0x63, 0x7e, (byte)0xe4, 0x32 };
str =

  "iV\u0010~\ub420\ud65b\ud1e9\u0011\u000a\ufffdl9t\ufffd\u000aqM\ufffd):c~\ufffd2";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x46, (byte)0xa1, (byte)0xbf, (byte)0xfe, 0x71, 0x62,
  0x3a, (byte)0xaa, (byte)0xe1, 0x4e, (byte)0xc5, (byte)0xf9, (byte)0xef,
  0x55, (byte)0xa0, (byte)0xf8, (byte)0x96, 0x0d, (byte)0x85, (byte)0xea,
  0x08, 0x36, 0x6d, 0x55, (byte)0xa1 };
str =
  "F\u00d7\ufffdqb:\u3081N\ud23c\ufffdU\uc89b\ufffd\u000d\ub083\u00086mU\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x28, 0x1f, (byte)0xe8, (byte)0xf1, 0x40, 0x1b, 0x61,
  0x26, 0x2d, 0x17, 0x23, (byte)0x9a, 0x25, 0x6c, 0x5e, 0x6b, 0x6a, 0x39,
  0x5b, 0x7c, (byte)0xfe, (byte)0xbd, 0x47, (byte)0x9e, (byte)0xa1, 0x56,
  0x6b, 0x59, 0x2b };
str = "(\u001f\uf9bd@\u001ba&-\u0017#\ufffd%l^kj9[|\ufffdG\uc61fVkY+";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x83, 0x74, (byte)0xa2, 0x79, (byte)0xe8, 0x77,
  (byte)0x8f, (byte)0xc3, (byte)0xf4, 0x6a, 0x30, (byte)0xcf, (byte)0xe1,
  0x6e, (byte)0xc2, (byte)0x9a, 0x26, 0x7b, (byte)0x85, 0x1a, (byte)0xac,
  0x38, 0x79, 0x65, (byte)0xda, (byte)0xca, (byte)0xe2, (byte)0xb4 };
str =

  "\uae32\uc946\ufffdw\ub913\ufffdj0\u5f13n\ud633&\u007b\ufffd\u001a\ufffd8ye\u9594\u7a57";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbd, (byte)0xcb, 0x71, 0x3e, (byte)0xc3, 0x7f,
  0x78, 0x08, (byte)0xea, (byte)0xc1, 0x12, 0x14, (byte)0xe6, 0x20, 0x60,
  0x03, (byte)0xd5, (byte)0xe1, 0x12 };
str = "\uc2efq>\ufffd\u007fx\u0008\uf9c6\u0012\u0014\ufffd `\u0003\u91cf\u0012";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcf, (byte)0xc6, (byte)0x92, (byte)0xab, 0x21,
  0x48, 0x02, (byte)0x95, 0x4d, (byte)0xf4, 0x09, (byte)0x9e, (byte)0xae,
  (byte)0xdf, (byte)0x9c };
str = "\u8ec0\ubb9f!H\u0002\ubde2\ufffd\u0009\uc636\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9e, (byte)0xbf, 0x2d, 0x74, (byte)0x8c, 0x03,
  0x07, (byte)0x94, 0x52, (byte)0x89, 0x3f, 0x39, (byte)0xa7, 0x2f, 0x1c,
  0x7b, (byte)0xab, (byte)0xef, 0x50, 0x31, (byte)0xea, 0x31, (byte)0xb7,
  (byte)0xb0, (byte)0xb4, (byte)0xa7, (byte)0x86, (byte)0x85, 0x2d };
str =

  "\uc64e-t\ufffd\u0003\u0007\ubd15\ufffd?9\ufffd/\u001c\u007b\u30efP1\ufffd1\ub7ed\ub1fb\ub0f5-";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe4, 0x3d, (byte)0x8b, (byte)0xbc, 0x37,
  (byte)0xe0, 0x27, (byte)0xb8, 0x3b, (byte)0xd2, (byte)0xd8, (byte)0xff,
  (byte)0xd5 };
str = "\ufffd=\ub5ac7\ufffd'\ufffd;\u6fc3\ufffd\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8f, (byte)0x99, (byte)0xc2, 0x30, (byte)0xcf,
  (byte)0xef, (byte)0xc2, (byte)0xcf, (byte)0xa4, 0x30, 0x60, (byte)0xde,
  (byte)0xb6 };
str = "\ub8de\ufffd0\u7737\ucacf\ufffd0`\u725d";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4b, 0x07, 0x1d, (byte)0xd6, 0x68, (byte)0xe3,
  (byte)0xaf, 0x2b, 0x40, 0x24, 0x4d, (byte)0x9a, (byte)0xda, 0x22, 0x21,
  0x3e, (byte)0xe2, (byte)0xb6 };
str = "K\u0007\u001d\ufffdh\u627f+@$M\uc2d7\"!>\u7cb9";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x37, 0x3d, 0x68, 0x71, (byte)0x83, (byte)0xfa, 0x6c,
  (byte)0xe4, 0x3b, 0x2e, 0x7b, (byte)0xfd, (byte)0xac, (byte)0xb0,
  (byte)0xe7, (byte)0xcf, (byte)0xfd, 0x51, 0x36 };
str = "7=hq\uaee1l\ufffd;.\u007b\u5e3f\uacc1\u6b78Q6";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc3, (byte)0xee, 0x1e, 0x13, 0x52, 0x3a,
  (byte)0xa0, (byte)0x95, (byte)0xd7, (byte)0xea, 0x65, (byte)0x8b, 0x43,
  0x36, 0x48, (byte)0xe8 };
str = "\ucdf8\u001e\u0013R:\uc819\u88cfe\ub5206H\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb4, 0x5d, (byte)0xae, (byte)0x97, (byte)0xc7,
  (byte)0xb7, (byte)0xe0, 0x59 };
str = "\ufffd]\uce1e\ud4d0\ufffdY";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe9, (byte)0xb6, 0x28, 0x7b, 0x0e, (byte)0xff,
  (byte)0xb9, 0x22, 0x36, (byte)0x98, (byte)0xe4, (byte)0x8d, (byte)0xdd,
  (byte)0xbd, (byte)0xea, 0x56, 0x33, (byte)0xd4 };
str = "\u50ad(\u007b\u000e\ufffd\ufffd\"6\uc106\ub76a\uc384V3\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4e, 0x63, 0x67, 0x1e, 0x6f, 0x08, (byte)0xa0,
  (byte)0x8d, 0x7f, 0x02, 0x4b, (byte)0xaf, (byte)0x9a, 0x4f, 0x2b, 0x50 };
str = "Ncg\u001eo\u0008\uc80c\u007f\u0002K\uce8fO+P";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8d, (byte)0xed, 0x52, (byte)0xe0, 0x3b, 0x2a,
  0x57, 0x6d };
str = "\ub781R\ufffd;*Wm";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7b, 0x65, (byte)0xb4, (byte)0xe4, (byte)0x87, 0x18,
  (byte)0x89, (byte)0x9c, (byte)0xe3, (byte)0xe5, (byte)0x95, (byte)0xd5,
  0x50, (byte)0xac, (byte)0xa8, (byte)0xf1 };
str = "\u007be\ub2f5\ufffd\u0018\ub3cf\u613c\ube86P\u0416\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfd, (byte)0xa9, 0x5f, (byte)0xfb, (byte)0xaf,
  0x59, (byte)0xb4, (byte)0xfe, (byte)0xda, (byte)0x8e, 0x2e, 0x78, 0x68,
  (byte)0xce, (byte)0x81, (byte)0xf2, 0x42, (byte)0xbc, (byte)0xf6, 0x68,
  0x65, (byte)0x82, (byte)0xde, 0x71, (byte)0xb6, 0x3b, 0x6c };
str = "\u543c_\u93a3Y\ub365\ufffd.xh\ufffd\ufffdB\uc218he\uadd4q\ufffd;l";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa5, (byte)0xe9, (byte)0xf5, (byte)0x98, 0x1e,
  0x18, (byte)0xaf, (byte)0x92, (byte)0xa8, (byte)0x99, (byte)0xed,
  (byte)0x88, 0x55, 0x66, 0x2d, 0x4a, (byte)0x93, (byte)0xbe };
str = "\u03b9\ufffd\u001e\u0018\uce83\ucbbd\ufffdUf-J\ubca6";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd8, 0x79, 0x68, (byte)0xa4, 0x5c, 0x33,
  (byte)0x84, (byte)0x98, 0x37, (byte)0xb4, 0x46, 0x62, (byte)0xbe,
  (byte)0xfe };
str = "\ufffdyh\ufffd\\3\uaf467\ud033b\uc5ce";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0c, 0x05, 0x69, (byte)0xae, (byte)0xf3, 0x6a, 0x23,
  (byte)0xe7, (byte)0xb2, (byte)0x8c, (byte)0x8a, 0x4f, (byte)0x95, 0x7a,
  0x3f, 0x19, (byte)0x8c, 0x50, 0x52, (byte)0xa1, 0x0f, 0x23, 0x33,
  (byte)0xe4, 0x63, (byte)0xd8, 0x53, (byte)0xc6 };
str =

  "\u000c\u0005i\ufffdj#\u668e\ub644O\ube13?\u0019\ub60fR\ufffd\u000f#3\ufffdc\ufffdS\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xaa, 0x78, 0x2b, 0x49, 0x64, (byte)0xbb, 0x27,
  0x51, 0x14, (byte)0x94, 0x11, (byte)0xa8, 0x67, 0x34, 0x4e, (byte)0xde };
str = "\ucc6f+Id\ufffd'Q\u0014\ufffd\u0011\ucb8f4N\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x68, 0x5b, (byte)0xd0, 0x03, (byte)0xcc, 0x6a, 0x10,
  (byte)0xcc, (byte)0xfc, 0x15, 0x44, 0x79 };
str = "h[\ufffd\u0003\ufffdj\u0010\u6212\u0015Dy";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6a, 0x38, 0x35, (byte)0xe7, 0x41 };
str = "j85\ufffdA";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb5, 0x27, (byte)0xa6, (byte)0xdd, (byte)0xa3,
  (byte)0xe5, 0x67, 0x7e, (byte)0xd6, 0x1d, 0x67, 0x51, (byte)0xa9, 0x64,
  (byte)0xb4, 0x27, (byte)0x8b, 0x0b };
str = "\ufffd'\u2543\uff45g~\ufffd\u001dgQ\ucbe3\ufffd'\ufffd\u000b";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9e, 0x06, 0x7a, (byte)0x83, (byte)0xd1,
  (byte)0xbe, 0x2c, 0x2f, (byte)0x9b, 0x52, (byte)0x8b, 0x43, (byte)0x97,
  (byte)0x87, (byte)0x8b, (byte)0xa5, 0x6a, 0x17, 0x0b, (byte)0x89, 0x58,
  (byte)0xa3, 0x7b, (byte)0xa8, (byte)0xe2, 0x7a, 0x1a, (byte)0xfc, 0x5d };
str =

  "\ufffd\u0006z\uaeab\ufffd\u002c/\uc32a\ub520\ubfbf\ub58fj\u0017\u000b\ub38a\ufffd\u007b\u24e5z\u001a\ufffd]";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x50, 0x39, (byte)0xfc, 0x78, (byte)0xdf, (byte)0xe8,
  (byte)0x9b, 0x09, (byte)0xab, 0x5b, 0x4b, 0x45, 0x43, 0x05, (byte)0xe3,
  0x58, (byte)0x8c, 0x1e, 0x37, (byte)0xa2, 0x00, (byte)0xf6, 0x6a };
str =

  "P9\ufffdx\uf96d\ufffd\u0009\ufffd[KEC\u0005\ufffdX\ufffd\u001e7\ufffd\u0000\ufffdj";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd3, (byte)0x8e, (byte)0xf0 };
str = "\ufffd\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6d, (byte)0xcf, 0x4e, 0x3a, (byte)0xb3, 0x78, 0x2c,
  0x4e, (byte)0xcb, (byte)0xc1, 0x58, 0x06, 0x65, 0x48, 0x59, (byte)0xce,
  (byte)0xa1, (byte)0xdc, 0x4b, 0x79, (byte)0xf0, (byte)0xf7, (byte)0xbe };
str = "m\ufffdN:\ud008\u002cN\u500bX\u0006eHY\u79d1\ufffdKy\u68d5\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4b, 0x23, 0x7f, (byte)0xe3, 0x72, 0x77, 0x7c,
  (byte)0xf7, 0x46, (byte)0xb5, (byte)0xb7, 0x0a, (byte)0x94, 0x4d, 0x1c,
  0x55, (byte)0xfd, 0x56, (byte)0xa1, 0x04 };
str = "K#\u007f\ufffdrw|\ufffdF\ub3c8\u000a\ubd0e\u001cU\ufffdV\ufffd\u0004";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x23, (byte)0x9d, 0x2d, 0x54, (byte)0xb7, 0x6b,
  (byte)0xcc, 0x21, 0x7d, 0x63 };
str = "#\ufffd-T\ud195\ufffd!}c";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf5, 0x69, (byte)0xd1, 0x7b, 0x0f, (byte)0xfb,
  0x10, (byte)0xe2, 0x33, 0x55, 0x7e, (byte)0x98, (byte)0x8f, 0x20, 0x78,
  (byte)0x95, (byte)0xf0, 0x4a, (byte)0x85, 0x49, 0x7d, 0x6a, 0x61,
  (byte)0xb1, 0x70, 0x77, (byte)0x93, (byte)0xf4 };
str =

  "\ufffdi\ufffd\u007b\u000f\ufffd\u0010\ufffd3U~\uc088 x\ubea9J\uafcc}ja\ucf3aw\ubcee";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2c, (byte)0xb5, (byte)0xb4, (byte)0x88, (byte)0xe6,
  (byte)0xc2, 0x68, 0x7e, (byte)0xc1, 0x3e, 0x6a, 0x3d, 0x2e, 0x71 };
str = "\u002c\ub3ac\ub343\ud5fa~\ufffd>j=.q";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc4, (byte)0x83, (byte)0xd3, (byte)0xe8,
  (byte)0xe5, 0x1d, (byte)0xe9, 0x4d, (byte)0xb4, 0x3a, 0x42, 0x49,
  (byte)0xb5, (byte)0xc2, (byte)0xae, 0x74, 0x70, 0x34, 0x40 };
str = "\ud6f1\u8cb8\ufffd\u001d\ufffdM\ufffd:BI\ub3e0\ucdfap4@";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc9, (byte)0xab, (byte)0xea, (byte)0xb0, 0x54,
  0x17, 0x69, 0x39, 0x3b, (byte)0x8e, 0x72, 0x51, 0x16, (byte)0x8d, 0x10,
  (byte)0xdc, (byte)0xb3, (byte)0x9c, 0x7d, 0x75 };
str = "\ufffd\u5a9bT\u0017i9;\ub7d5Q\u0016\ufffd\u0010\u5c5b\ufffd}u";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc1, (byte)0x87, (byte)0xe6, 0x39, (byte)0xa5,
  0x51, 0x0b, 0x6a, 0x2d, 0x4d, 0x18, 0x27, 0x6a, 0x41, (byte)0xb9,
  (byte)0xac };
str = "\ud5ae\ufffd9\uca5b\u000bj-M\u0018'jA\ubb35";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x31, (byte)0xc1, (byte)0xf2, (byte)0x90, (byte)0xd3,
  0x2f, (byte)0xc2, (byte)0x9a, (byte)0x82, (byte)0xfc, (byte)0xc1,
  (byte)0x95, (byte)0xa9, 0x30, (byte)0xd7, 0x21, 0x1e, 0x21, (byte)0x86,
  0x48, (byte)0x93, (byte)0xcd, 0x6e, 0x33 };
str = "1\uc998\uba16/\ud633\uadf5\ud5bc\ufffd0\ufffd!\u001e!\ub0b7\ubcben3";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
}
[Test]
public void TestKoreanEUCEncoder() {
byte[] bytes;
string str;
ICharacterEncoding charset = Encodings.GetEncoding("euc-kr");
str = "\ud544";
bytes = new byte[] { (byte)0xc7, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff50\uff1b\uc2ef";
bytes = new byte[] { (byte)0xa3, (byte)0xf0, (byte)0xa3, (byte)0xbb,
  (byte)0xbd, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff49";
bytes = new byte[] { (byte)0xa3, (byte)0xe9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ub6b6\uff51";
bytes = new byte[] { (byte)0x8c, (byte)0xf2, (byte)0xa3, (byte)0xf1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u78cb\ub162\u7dbd";
bytes = new byte[] { (byte)0xf3, (byte)0xaf, (byte)0x86, (byte)0xd1,
  (byte)0xed, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1c\u74b0";
bytes = new byte[] { (byte)0xa3, (byte)0xbc, (byte)0xfc, (byte)0xbb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1a";
bytes = new byte[] { (byte)0xa3, (byte)0xba };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u61a4\u5433";
bytes = new byte[] { (byte)0xdd, (byte)0xc9, (byte)0xe7, (byte)0xef };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff33\u6142\u5bf8";
bytes = new byte[] { (byte)0xa3, (byte)0xd3, (byte)0xe9, (byte)0xbd,
  (byte)0xf5, (byte)0xbb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "2\uc316\u5f59";
bytes = new byte[] { 0x32, (byte)0x9b, 0x44, (byte)0xfd, (byte)0xc4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff47\u65ec\u8cda";
bytes = new byte[] { (byte)0xa3, (byte)0xe7, (byte)0xe2, (byte)0xe2,
  (byte)0xd6, (byte)0xf2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff27\u7428\u77ed";
bytes = new byte[] { (byte)0xa3, (byte)0xc7, (byte)0xcd, (byte)0xe4,
  (byte)0xd3, (byte)0xad };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "b\u5275";
bytes = new byte[] { 0x62, (byte)0xf3, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff42";
bytes = new byte[] { (byte)0xa3, (byte)0xe2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u527fy";
bytes = new byte[] { (byte)0xf4, (byte)0xf9, 0x79 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6106\u212b";
bytes = new byte[] { (byte)0xcb, (byte)0xf0, (byte)0xa1, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u793e\uff15";
bytes = new byte[] { (byte)0xde, (byte)0xe4, (byte)0xa3, (byte)0xb5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ub6db\u7444\uff15";
bytes = new byte[] { (byte)0x8d, 0x58, (byte)0xe0, (byte)0xc5, (byte)0xa3,
  (byte)0xb5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u251b\u5728\u5b40\u63da";
bytes = new byte[] { (byte)0xa6, (byte)0xb0, (byte)0xee, (byte)0xa4,
  (byte)0xdf, (byte)0xc5, (byte)0xe5, (byte)0xc0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "4";
bytes = new byte[] { 0x34 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3e\u2235\u79d5";
bytes = new byte[] { (byte)0xa3, (byte)0xde, (byte)0xa1, (byte)0xf1,
  (byte)0xdd, (byte)0xf9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u79df\uf9f8\u7dbd";
bytes = new byte[] { (byte)0xf0, (byte)0xd5, (byte)0xed, (byte)0xa2,
  (byte)0xed, (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uae34\uff2e\u594f";
bytes = new byte[] { (byte)0xb1, (byte)0xe4, (byte)0xa3, (byte)0xce,
  (byte)0xf1, (byte)0xb4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2540\u65ac";
bytes = new byte[] { (byte)0xa6, (byte)0xdb, (byte)0xf3, (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff55\u570d\u6b32";
bytes = new byte[] { (byte)0xa3, (byte)0xf5, (byte)0xea, (byte)0xcc,
  (byte)0xe9, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff17\uadf6\u7ca5\ubce7";
bytes = new byte[] { (byte)0xa3, (byte)0xb7, (byte)0x82, (byte)0xfd,
  (byte)0xf1, (byte)0xd4, (byte)0x93, (byte)0xed };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ub069";
bytes = new byte[] { (byte)0x85, (byte)0xd3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u25a8\u247a\uff5c";
bytes = new byte[] { (byte)0xa2, (byte)0xc9, (byte)0xa9, (byte)0xed,
  (byte)0xa3, (byte)0xfc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ub6b9";
bytes = new byte[] { (byte)0x8c, (byte)0xf5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u57cb\ubde4\u6f7d";
bytes = new byte[] { (byte)0xd8, (byte)0xd8, (byte)0x95, 0x4f, (byte)0xdc,
  (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff31";
bytes = new byte[] { (byte)0xa3, (byte)0xd1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u715e\u67d3\u7642";
bytes = new byte[] { (byte)0xdf, (byte)0xb0, (byte)0xe6, (byte)0xf8,
  (byte)0xd6, (byte)0xfb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "l\uff3d";
bytes = new byte[] { 0x6c, (byte)0xa3, (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2020\ud618\u5edf";
bytes = new byte[] { (byte)0xa2, (byte)0xd3, (byte)0xc2, (byte)0x83,
  (byte)0xd9, (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u24db";
bytes = new byte[] { (byte)0xa8, (byte)0xd8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uc251\u7166\u24dc";
bytes = new byte[] { (byte)0xbd, (byte)0xa7, (byte)0xfd, (byte)0xaf,
  (byte)0xa8, (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6eaf\u6dcbp";
bytes = new byte[] { (byte)0xe1, (byte)0xbd, (byte)0xd7, (byte)0xfa, 0x70 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ud058\uff06";
bytes = new byte[] { (byte)0xc5, (byte)0xa7, (byte)0xa3, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\\\uff0f\uff51";
bytes = new byte[] { 0x5c, (byte)0xa3, (byte)0xaf, (byte)0xa3, (byte)0xf1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ub965\u7e79";
bytes = new byte[] { (byte)0x90, 0x4a, (byte)0xe6, (byte)0xba };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ubbfd";
bytes = new byte[] { (byte)0x92, (byte)0xfc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9db4\u6414\u6198";
bytes = new byte[] { (byte)0xf9, (byte)0xcd, (byte)0xe1, (byte)0xb8,
  (byte)0xfd, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "v";
bytes = new byte[] { 0x76 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "e\uff21\u7b4f";
bytes = new byte[] { 0x65, (byte)0xa3, (byte)0xc1, (byte)0xdb, (byte)0xea };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff21";
bytes = new byte[] { (byte)0xa3, (byte)0xc1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0b\ucabf\u68cb";
bytes = new byte[] { (byte)0xa3, (byte)0xab, (byte)0xa6, 0x56, (byte)0xd1,
  (byte)0xa4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u672b\u7c4d\u5026";
bytes = new byte[] { (byte)0xd8, (byte)0xc7, (byte)0xee, (byte)0xdf,
  (byte)0xcf, (byte)0xe6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2116";
bytes = new byte[] { (byte)0xa2, (byte)0xe0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u75fc\ubd71\u5011";
bytes = new byte[] { (byte)0xcd, (byte)0xc0, (byte)0x94, (byte)0xaf,
  (byte)0xd9, (byte)0xfa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff18\uff2f";
bytes = new byte[] { (byte)0xa3, (byte)0xb8, (byte)0xa3, (byte)0xcf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u79ae\u686d\ub877";
bytes = new byte[] { (byte)0xd6, (byte)0xc9, (byte)0xf2, (byte)0xcd,
  (byte)0x8e, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5dfd\uff09";
bytes = new byte[] { (byte)0xe1, (byte)0xde, (byte)0xa3, (byte)0xa9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4f";
bytes = new byte[] { (byte)0xa3, (byte)0xef };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2528\u7a00\u247e\uafc6\u6abb";
bytes = new byte[] { (byte)0xa6, (byte)0xb9, (byte)0xfd, (byte)0xfc,
  (byte)0xa9, (byte)0xf1, (byte)0x85, 0x47, (byte)0xf9, (byte)0xe3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff10\uff52\u7dd8";
bytes = new byte[] { (byte)0xa3, (byte)0xb0, (byte)0xa3, (byte)0xf2,
  (byte)0xf9, (byte)0xe5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6d0b";
bytes = new byte[] { (byte)0xe5, (byte)0xc7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6539\u6fb3\uff45";
bytes = new byte[] { (byte)0xcb, (byte)0xc7, (byte)0xe7, (byte)0xfe,
  (byte)0xa3, (byte)0xe5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3f\uff07\uff21";
bytes = new byte[] { (byte)0xa3, (byte)0xdf, (byte)0xa3, (byte)0xa7,
  (byte)0xa3, (byte)0xc1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u57f7";
bytes = new byte[] { (byte)0xf2, (byte)0xfb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6284\uff29\u7add";
bytes = new byte[] { (byte)0xf4, (byte)0xfc, (byte)0xa3, (byte)0xc9,
  (byte)0xdc, (byte)0xbd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6a21\u8f2a\u716e";
bytes = new byte[] { (byte)0xd9, (byte)0xbc, (byte)0xd7, (byte)0xc7,
  (byte)0xed, (byte)0xb4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff02\u52dd\u2200";
bytes = new byte[] { (byte)0xa3, (byte)0xa2, (byte)0xe3, (byte)0xad,
  (byte)0xa2, (byte)0xa3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7501\u7f6b\u5cef";
bytes = new byte[] { (byte)0xdc, (byte)0xba, (byte)0xce, (byte)0xd1,
  (byte)0xdc, (byte)0xe7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u67ef\u723e";
bytes = new byte[] { (byte)0xca, (byte)0xaf, (byte)0xec, (byte)0xb3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ufa07\uff0e\ud443";
bytes = new byte[] { (byte)0xf8, (byte)0xf0, (byte)0xa3, (byte)0xae,
  (byte)0xbe, 0x4b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7701";
bytes = new byte[] { (byte)0xe0, (byte)0xfd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe1\ucd89";
bytes = new byte[] { (byte)0xa1, (byte)0xcc, (byte)0xad, 0x68 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe2\u661e\u5d0d";
bytes = new byte[] { (byte)0xa1, (byte)0xfe, (byte)0xdc, (byte)0xb5,
  (byte)0xd5, (byte)0xcf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7f8c\uff3f\u2122";
bytes = new byte[] { (byte)0xcb, (byte)0xb6, (byte)0xa3, (byte)0xdf,
  (byte)0xa2, (byte)0xe2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff38\u5827";
bytes = new byte[] { (byte)0xa3, (byte)0xd8, (byte)0xe6, (byte)0xc0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ubd62\u6d3b";
bytes = new byte[] { (byte)0x94, (byte)0xa2, (byte)0xfc, (byte)0xc0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5085\u5c0a\u6096\uff58";
bytes = new byte[] { (byte)0xdc, (byte)0xf7, (byte)0xf0, (byte)0xee,
  (byte)0xf8, (byte)0xa7, (byte)0xa3, (byte)0xf8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6c8c\u7dc7\u711a";
bytes = new byte[] { (byte)0xd4, (byte)0xc7, (byte)0xf6, (byte)0xc5,
  (byte)0xdd, (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6e5e\uff25\u30e4";
bytes = new byte[] { (byte)0xef, (byte)0xe6, (byte)0xa3, (byte)0xc5,
  (byte)0xab, (byte)0xe4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u798d";
bytes = new byte[] { (byte)0xfc, (byte)0xa1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6610\ub378\u55e4";
bytes = new byte[] { (byte)0xdd, (byte)0xcb, (byte)0xb5, (byte)0xa8,
  (byte)0xf6, (byte)0xb8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ucb88\uff34";
bytes = new byte[] { (byte)0xa8, 0x5a, (byte)0xa3, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ufa06\u2163\u60b4";
bytes = new byte[] { (byte)0xf8, (byte)0xdb, (byte)0xa5, (byte)0xb3,
  (byte)0xf5, (byte)0xfc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u8f1b";
bytes = new byte[] { (byte)0xd5, (byte)0xe0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u207f\uff24\uff1f";
bytes = new byte[] { (byte)0xa9, (byte)0xfa, (byte)0xa3, (byte)0xc4,
  (byte)0xa3, (byte)0xbf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5730\u580a";
bytes = new byte[] { (byte)0xf2, (byte)0xa2, (byte)0xe4, (byte)0xbe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u71e5\u5fff\uc0ca";
bytes = new byte[] { (byte)0xf0, (byte)0xcf, (byte)0xdd, (byte)0xc8,
  (byte)0x98, (byte)0xb9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff17";
bytes = new byte[] { (byte)0xa3, (byte)0xb7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uc882\uff25";
bytes = new byte[] { (byte)0xa0, (byte)0xe7, (byte)0xa3, (byte)0xc5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uc9ad\u54b8\uc01c";
bytes = new byte[] { (byte)0xa3, 0x79, (byte)0xf9, (byte)0xe0, (byte)0x97,
  (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u25a8\u5949\uff05\u5149";
bytes = new byte[] { (byte)0xa2, (byte)0xc9, (byte)0xdc, (byte)0xe5,
  (byte)0xa3, (byte)0xa5, (byte)0xce, (byte)0xc3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u24d8\u9aee\uffe2";
bytes = new byte[] { (byte)0xa8, (byte)0xd5, (byte)0xdb, (byte)0xa5,
  (byte)0xa1, (byte)0xfe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u65b9\u6a13";
bytes = new byte[] { (byte)0xdb, (byte)0xb0, (byte)0xd7, (byte)0xa7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5d\u6bd2\u7e8c";
bytes = new byte[] { (byte)0xa3, (byte)0xfd, (byte)0xd4, (byte)0xb8,
  (byte)0xe1, (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u51f9\u266a\u8cf4";
bytes = new byte[] { (byte)0xe8, (byte)0xea, (byte)0xa2, (byte)0xdc,
  (byte)0xd6, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff33\u79e7\uff2d";
bytes = new byte[] { (byte)0xa3, (byte)0xd3, (byte)0xe4, (byte)0xeb,
  (byte)0xa3, (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7b2c";
bytes = new byte[] { (byte)0xf0, (byte)0xaf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7a98\u770b\u50cf\u84a1";
bytes = new byte[] { (byte)0xcf, (byte)0xd7, (byte)0xca, (byte)0xd7,
  (byte)0xdf, (byte)0xc0, (byte)0xdb, (byte)0xbc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2203\u6106";
bytes = new byte[] { (byte)0xa2, (byte)0xa4, (byte)0xcb, (byte)0xf0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u24ae\uff01\uff1d";
bytes = new byte[] { (byte)0xa9, (byte)0xdf, (byte)0xa3, (byte)0xa1,
  (byte)0xa3, (byte)0xbd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u628a\uff14\uafd8";
bytes = new byte[] { (byte)0xf7, (byte)0xea, (byte)0xa3, (byte)0xb4,
  (byte)0x85, 0x52 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6d74";
bytes = new byte[] { (byte)0xe9, (byte)0xb1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff22\u596b";
bytes = new byte[] { (byte)0xa3, (byte)0xc2, (byte)0xeb, (byte)0xc4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2d8\ud2f6";
bytes = new byte[] { (byte)0xa3, (byte)0xcd, 0x38, (byte)0xba, (byte)0x9d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3c\uff11\u2018";
bytes = new byte[] { (byte)0xa1, (byte)0xac, (byte)0xa3, (byte)0xb1,
  (byte)0xa1, (byte)0xae };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
}
}
}
