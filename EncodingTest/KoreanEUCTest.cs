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
bytes = new byte[] { (byte)0x86, 0x70, (byte)0xd4, (byte)0xce, 0x5d, 0x7e,
  (byte)0x8e, (byte)0xd3, 0x03, 0x7b, (byte)0x87, (byte)0xcc, 0x45, 0x5a,
  (byte)0xfd, 0x20, (byte)0x99, 0x56, 0x51, (byte)0x9e, (byte)0xd6, 0x09,
  (byte)0x86 };
str = "\ub0e6\u4edd]~\ub84d\u0003\u007b\ub236EZ\u56de\uc151Q\uc66e\u0009\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4e, (byte)0xd3, (byte)0xbe };
str = "N\u66c7";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbd, (byte)0xec, 0x1e, (byte)0xc6, (byte)0xd2,
  (byte)0x89, (byte)0xbf, (byte)0x95, 0x27, (byte)0x90, (byte)0x8f, 0x43,
  0x20, 0x7c, 0x29, (byte)0xa3, (byte)0xe2, 0x6f, 0x47, (byte)0xc7, 0x37,
  0x49, 0x74, (byte)0xdb, (byte)0x8c, 0x34, 0x25, 0x61, (byte)0x99 };
str = "\uc38c\u001e\ud32c\ub3fd\ubdb7\ub9afC |)\uff42oG\ud3e1It\ufffd4%a\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x31, 0x72, (byte)0xe2, (byte)0xee, 0x7e, 0x43,
  (byte)0x86, 0x26, (byte)0x82, 0x4b, (byte)0xc7, 0x5d, 0x1e, (byte)0xab,
  (byte)0xf0, (byte)0x80, (byte)0x90 };
str = "1r\u8123~C\ub07a\uad21\ufffd]\u001e\u30f0\ufffd\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x47, (byte)0x93, (byte)0xe3, 0x62, (byte)0x9e,
  (byte)0x8c, 0x5c, (byte)0x83, 0x2c, (byte)0xd7, 0x75, 0x7b, (byte)0x96,
  (byte)0x92, (byte)0xc7, (byte)0xc4, (byte)0x81 };
str = "G\ubcddb\uc5fa\\\uade2\ufffdu\u007b\ubf0a\ud514\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4c, (byte)0xca, 0x25, 0x78, 0x6a, (byte)0x89, 0x6d,
  0x69, (byte)0xa8, (byte)0xe4, (byte)0xc9, 0x59, 0x39, 0x5e, 0x29 };
str = "L\ufffd%xj\ub39ci\u24e7\ufffdY9^)";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x62, 0x63, 0x17, 0x14 };
str = "bc\u0017\u0014";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x46, 0x72, 0x18, 0x15, (byte)0xc7, (byte)0xa5,
  (byte)0xd8, 0x11, 0x7f, (byte)0xcb, 0x24, (byte)0xd6, (byte)0x8e, 0x7a,
  (byte)0xeb, 0x38, (byte)0xd8, 0x59 };
str = "Fr\u0018\u0015\ud45c\u51dc\u007f\u559d\ufffdz\u67da\ufffdY";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe4, 0x30, 0x16, (byte)0x83, 0x1b, (byte)0xb5,
  0x74, (byte)0x8c, 0x6b, (byte)0xef, 0x6f, 0x6e };
str = "\u8398\u0016\uadcc\ud0cf\ub629\ufffdon";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x50, (byte)0xc0, (byte)0xf3, (byte)0xee, 0x4d,
  (byte)0xee, 0x4e, 0x3f, 0x50, (byte)0xd7, (byte)0xce, 0x74, 0x18,
  (byte)0xe3, 0x2b, 0x22, (byte)0xd7, (byte)0xa1, (byte)0xfb, (byte)0x89,
  0x4e, 0x43, (byte)0xd4, 0x38 };
str = "P\uc7ce\ufffdM\ufffdN?P\u808bt\u0018\u73e3\"\u907c\ufffdNC\u5cf6";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x55, 0x6a, (byte)0x85, (byte)0xcf, (byte)0x96, 0x4d,
  0x45, (byte)0xf3, (byte)0xee, 0x72, (byte)0xeb, (byte)0xc3, 0x0b, 0x09,
  0x5d, 0x5f, 0x22, 0x73, 0x5d, 0x34, 0x2c, (byte)0x86, 0x77, (byte)0x8b,
  0x0a, 0x4f, (byte)0xe0, 0x1e, 0x54 };
str =
  "Uj\ub065\ubec4E\u83d6r\u5141\u000b\u0009]_\"s]4\u002c\ub0ed\ub4d7O\u971cT";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa5, (byte)0xc8, (byte)0xb3, (byte)0xec, 0x03,
  0x7d, 0x03, 0x7d, 0x7a, (byte)0xf3, (byte)0xbf, 0x34, (byte)0xaa, 0x43,
  0x4e, (byte)0x9b, 0x13, 0x28, (byte)0x9e, (byte)0x9d, (byte)0x82,
  (byte)0xc2 };
str = "\u0398\ub179\u0003}\u0003}z\u74a84\ucc2aN\uc2ce(\uc617\uadb0";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x82, 0x35, (byte)0xb9, (byte)0xf5, (byte)0x9b,
  0x4b, (byte)0x9a, 0x6e, 0x4a, (byte)0xf4, 0x2d, 0x51, 0x77, (byte)0xbf,
  0x2e, (byte)0x8c, 0x4b, 0x16 };
str = "\uad02\ubc5d\uc31f\uc257J\u7a93Qw\uc5a0\ub60a\u0016";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa5, 0x5c, 0x58, (byte)0xc3, (byte)0xe2, 0x55,
  0x32, (byte)0x9a, (byte)0xa2, (byte)0x8f, 0x0f, (byte)0x8a, 0x61,
  (byte)0x96 };
str = "\ufffd\\X\ucd9cU2\uc293\ub847\ub467\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2e, (byte)0xcd, 0x41, (byte)0xa1, (byte)0xaf, 0x0e,
  (byte)0xe3 };
str = ".\ufffdA\u2019\u000e\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x26 };
str = "&";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x52, 0x6d, (byte)0x8f, 0x00, 0x68, (byte)0xa8, 0x46 };
str = "Rm\ub831h\ucb72";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5d, 0x10 };
str = "]\u0010";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x79, 0x42, (byte)0xa4, 0x6c, (byte)0xd5, 0x3e };
str = "yB\uca16\uf95b";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x31, (byte)0xb1, 0x1d, (byte)0xa0, 0x03, 0x3a };
str = "1\uaca1\uc74e:";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb5, (byte)0xa0, 0x4a, (byte)0xee, (byte)0xc6,
  (byte)0xe7, (byte)0xb7, 0x41, 0x50, 0x30, 0x78, (byte)0xf0, 0x7b,
  (byte)0xb2, (byte)0xc7, (byte)0xc9, 0x3c, (byte)0xe9, (byte)0xd3, 0x61,
  0x2f };
str = "\ud104J\u7bb8\u6e36AP0x\ufffd\u007b\uaf41\ud790\u53f3a/";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x58, (byte)0x84, 0x7f, (byte)0xb1, (byte)0xf7,
  (byte)0xac, 0x02, (byte)0x86, 0x32 };
str = "X\ufffd\u007f\uae60\u30c0\ub08a";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7f, (byte)0xa2, (byte)0xfe, (byte)0xa8, 0x06,
  (byte)0xa4, (byte)0x90, (byte)0xfc, 0x7b, (byte)0x9d, 0x2b, 0x76, 0x7c,
  (byte)0xec, (byte)0xa0, (byte)0xce, (byte)0x9c };
str = "\u007f\ufffd\u33b5\uca36\ufffd\u007b\uc492v|\ufffd\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x23, (byte)0xb4, 0x55, 0x5a, 0x08, (byte)0xf3,
  (byte)0xd9, 0x74, 0x34, 0x06, 0x50, (byte)0xf7, 0x67, 0x35, 0x21,
  (byte)0xd2, 0x6e, 0x63, (byte)0x8e, 0x62, (byte)0xd0, (byte)0xc4, 0x62,
  0x79, (byte)0xd0, 0x0d, 0x4d, (byte)0xa2, (byte)0xcb, 0x3f };
str =
  "#\ud04aZ\u0008\u8b96t4\u0006P\ufffdg5!\ufffdnc\ub7c3\u61c3by\u99d2M\u25a6?";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x88, (byte)0xde, 0x32, 0x3a, 0x2a, 0x72, 0x72,
  0x43, 0x70, 0x0f, 0x2c, (byte)0xb0, (byte)0x98, 0x2f, (byte)0x80, 0x79,
  0x39, 0x50, 0x0d, (byte)0xad, (byte)0xf5, 0x2f };
str = "\ub33b2:*rrCp\u000f\u002c\ucef2/\ufffdy9P\u000d\ufffd/";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb6, 0x7a, 0x62, 0x1c, 0x73, (byte)0xc9, 0x40,
  0x37 };
str = "\ud13eb\u001cs\ud79d7";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4c, (byte)0xe9, 0x3f };
str = "L\u7464";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1d, (byte)0x87, 0x5e };
str = "\u001d\ufffd^";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd3, 0x54, 0x04, 0x51, (byte)0xa3, (byte)0x9c,
  (byte)0x83, (byte)0xd0, (byte)0xc1, (byte)0xe4 };
str = "\ufffdT\u0004Q\uc9d2\uaeaa\uc951";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x54, (byte)0x80, 0x06, 0x04, (byte)0xce, (byte)0x8a,
  (byte)0xe2, (byte)0x90, (byte)0xb6, 0x6d, (byte)0xb8, 0x51, (byte)0xf9,
  0x0a, 0x67, (byte)0xb5, (byte)0x94, 0x20, 0x52, 0x61, (byte)0xbc, 0x01,
  (byte)0xa7, (byte)0xe7, (byte)0xad, (byte)0xe0, (byte)0xda, 0x1f, 0x53,
  0x49 };
str =

  "T\ufffd\u0006\u0004\ufffd\ufffd\ud12c\ud1e1\u5ee2g\ud0f7 Ra\ubf01\u33ab\ufffd\u6e3aSI";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x31, 0x3f, 0x5c, 0x4a, (byte)0xf2, 0x20, 0x10,
  (byte)0xeb, (byte)0xf6, 0x32, 0x58, (byte)0xdb, (byte)0xc8, (byte)0x97,
  0x3c, 0x0d, 0x75, (byte)0xc6, 0x64, (byte)0xae, 0x72, 0x70, (byte)0xf1,
  (byte)0xa0, (byte)0xa7, 0x23 };
str = "1?\\J\u6e96\u0010\u6bc52X\u62dc\ubf7e\u000du\ufffdd\ucdf6p\ufffd\u2547";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb9, 0x2f, (byte)0xbb };
str = "\uba85\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb3, (byte)0xad, (byte)0xe2, (byte)0x9c, 0x3b,
  0x4b, (byte)0xdd, 0x26, (byte)0xe7, (byte)0xdd, (byte)0xb6, 0x17, 0x76,
  0x18, (byte)0xc8, (byte)0xc1, (byte)0xdb, 0x22, (byte)0x91, (byte)0xf7,
  0x4e, 0x40, 0x44, (byte)0xa1, (byte)0x9d };
str = "\ub09c\ufffd;K\u4ff8\u85dd\ub465v\u0018\ud6b0\u99c1\ubb1fN@D\uc909";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf2, 0x40, 0x54, 0x6f, 0x13, 0x01, (byte)0xd1,
  (byte)0xb4, 0x3d, (byte)0xac, 0x71, (byte)0xf9, (byte)0xfa, (byte)0xa2,
  (byte)0xd4, 0x59, (byte)0xb6, 0x5c, (byte)0xb8, 0x67, (byte)0x8d, 0x0b,
  (byte)0x82, 0x75, (byte)0xd1, 0x33, 0x2a, (byte)0xc4 };
str =

  "\u53eaTo\u0013\u0001\u78ef=\ucd34\u6c86\u2021Y\ufffd\\\ud1f1\ub686\uad51\u57fa*\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7c, 0x55, (byte)0xa8, 0x1f, 0x1e, 0x4d, (byte)0xc3,
  0x6c, 0x71, 0x66 };
str = "|U\u338b\u001eM\ud66fqf";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6e };
str = "n";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44, 0x54, 0x4f, (byte)0xd3, (byte)0xe6, (byte)0xb6,
  0x63, 0x29, (byte)0xf8, (byte)0xd9, 0x1d, 0x4e, (byte)0xd0, 0x48,
  (byte)0x8c, (byte)0x96, 0x4a };
str = "DTO\u81fa\ud122)\u62b1\u001dN\ufffdH\ub651J";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb0, 0x0f, (byte)0xaa, 0x3c, (byte)0xf4, 0x7d,
  (byte)0xe0, (byte)0xe1, 0x25, 0x3a, 0x5b };
str = "\ufffd\u000f\u207f\ufffd}\u893b%:[";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x80, (byte)0x98, (byte)0xd7, 0x2d, 0x53,
  (byte)0x97, 0x10, 0x39, (byte)0x96, (byte)0xf8, 0x78, (byte)0xff,
  (byte)0xc0, 0x58, 0x30, 0x70, 0x63 };
str = "\ufffd\uc0f3-S\ubf4f9\ubf7cx\ufffd\ud51b0pc";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xad, 0x28, 0x16, (byte)0x9b, (byte)0xd1, 0x20 };
str = "\u0444\u0016\uc3aa ";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xce, 0x53, (byte)0xda, 0x15, (byte)0xa8, 0x1f,
  (byte)0x90, (byte)0xe5, (byte)0xf8 };
str = "\ufffdS\u5922\u338b\uba28\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3e, (byte)0xa2, (byte)0xd2, (byte)0xb4, (byte)0x88,
  0x47, 0x40 };
str = ">\u00b6\ud079G@";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x53, (byte)0xa9, (byte)0x84, 0x36, 0x55, 0x75,
  (byte)0xdd, (byte)0x9a, 0x45, (byte)0x9b, (byte)0xc4, 0x53, 0x55, 0x7b,
  (byte)0xf5, (byte)0xbc, (byte)0x95, 0x60, 0x5a, (byte)0xcd, 0x4b, 0x3a,
  0x55, (byte)0xbf, (byte)0x89, (byte)0xe8, (byte)0x8a };
str = "S\ucc006Uu\ufffdE\uc39dSU\u007b\u5fd6\ufffd`Z\ufffdK:U\ud4e0\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x58, 0x33, (byte)0xbd, 0x01, (byte)0xb8, 0x08,
  (byte)0xf2, (byte)0xc1, 0x32, 0x17, 0x71, 0x32, 0x31, (byte)0xb1,
  (byte)0xe4, (byte)0x9d, 0x4b, (byte)0x9a };
str = "X3\uc140\ub835\u76f42\u0017q21\uae34\uc4b4\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x18, 0x72, 0x6d, (byte)0xa9, 0x20, 0x3c, (byte)0x82,
  0x4e, (byte)0x8e, 0x5c, (byte)0xd4, 0x60, 0x20, 0x6d, 0x55, (byte)0xc0,
  0x6c, (byte)0x82, 0x48, 0x63, (byte)0xd1, (byte)0xad };
str = "\u0018rm\u24e1<\uad24\ufffd\\\ufffd` mU\ud529\uad1dc\u7426";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0b, 0x5e, 0x64, 0x5d, (byte)0xf0, 0x4c, (byte)0xb7,
  0x0c, 0x25, 0x58, (byte)0xc0, 0x10, 0x36, 0x65, 0x50, 0x2b, 0x5c,
  (byte)0xd9, 0x11, 0x21, (byte)0xf5, 0x2f, (byte)0xa9, 0x38 };
str = "\u000b^d]\ufffdL\ub618%X\uc6416eP+\\\u5fd9!\u9bd6\u00bd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0d, 0x30, 0x76 };
str = "\u000d0v";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x36, 0x58, 0x2d, 0x20, (byte)0xca, (byte)0xec,
  (byte)0xfa, 0x33, (byte)0x93, 0x43, 0x13, (byte)0x9c, 0x65, 0x7a,
  (byte)0x9f, 0x42, (byte)0xf6 };
str = "6X- \u574e\u4ea2\ubc05\u0013\uc403z\uc6aa\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb7, (byte)0xae, 0x75, 0x06, (byte)0xdb, 0x78,
  0x7b, 0x03, 0x73, (byte)0x93, (byte)0xac, 0x22, (byte)0xf8, 0x76,
  (byte)0xb0, (byte)0xb6, 0x3c, (byte)0xa7, (byte)0xd6, 0x73, (byte)0x81,
  (byte)0x96, 0x3c, 0x2d };
str = "\ub7c9u\u0006\ufffdx\u007b\u0003s\ubc89\"\ufffdv\uac24<\u3392s\uac6d<-";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5c, 0x24, (byte)0xdf, 0x3f, (byte)0xfc, 0x17, 0x44,
  (byte)0xae, 0x24, (byte)0xd4, 0x50, (byte)0xf5 };
str = "\\$\u6714\u7ccaD\ufffd$\ufffdP\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdd, (byte)0xa6, (byte)0xa3, 0x22, 0x23,
  (byte)0x82, 0x73, (byte)0xaf, (byte)0xa0, (byte)0xc1, (byte)0xeb, 0x3a,
  0x4c, 0x61, 0x6c, (byte)0xc7, (byte)0xc4, 0x45, (byte)0x8c, (byte)0xd3,
  (byte)0x89, 0x3c };
str = "\u6276\u2116#\uad4e\uce99\uc970:Lal\ud514E\ub690\ub35d";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43, (byte)0xff, 0x79, (byte)0x9b, 0x6a, 0x42, 0x79,
  0x64, (byte)0xf9, (byte)0xc8 };
str = "C\ufffdy\uc33cByd\u9c15";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x26, 0x33 };
str = "&3";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7a, 0x15, 0x6e, (byte)0xf6, 0x0d };
str = "z\u0015n\u5d14";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x74, 0x4f, 0x25, 0x4d, 0x00, (byte)0x84, 0x3b, 0x3c,
  (byte)0xf8, 0x66, (byte)0xa5, (byte)0xba, (byte)0x99, (byte)0xf0,
  (byte)0xfa, 0x5d, 0x6c, (byte)0x8a, 0x43, (byte)0xa1, (byte)0xb4 };
str = "tO%M\u0000\uaee0<\ufffdf\ufffd\uc20e\ufffd]l\ub447\u3008";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2d, (byte)0xcf, (byte)0xd0, 0x36, (byte)0xf0,
  (byte)0x84 };
str = "-\u570b6\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x04, 0x01, 0x4c, 0x68, (byte)0xca, (byte)0xa7, 0x79,
  (byte)0xd4, 0x5b, 0x45, 0x6a, (byte)0xf0, 0x08, (byte)0xfc, 0x11,
  (byte)0xc7, 0x0c, 0x1c, (byte)0x9e, 0x46, (byte)0xba, 0x49, 0x55 };
str = "\u0004\u0001Lh\u5475y\ufffd[Ej\u9b8e\u72d0\ud31c\u001c\uc59e\ud298U";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x73, 0x4e, (byte)0xbf, (byte)0xa4, 0x4f, (byte)0xa6,
  0x6f, 0x29, (byte)0xcc, 0x1c, 0x22, (byte)0xcd, 0x30, (byte)0x92, 0x32,
  (byte)0xe7, 0x21, 0x31, 0x6c, 0x6d, (byte)0x8d, (byte)0xba, (byte)0xdc,
  0x2e };
str = "sN\uc5d8O\ucadb)\u5028\"\u8f15\ubb16\uf9961lm\ub73f\u95a5";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7d, (byte)0xd6, (byte)0xf7, 0x74, 0x54, 0x00, 0x38,
  (byte)0xde, (byte)0xad, (byte)0xac, 0x7c, 0x04, (byte)0x9d, 0x7e,
  (byte)0xd1, 0x31, 0x1f, 0x7b, (byte)0x88 };
str = "}\u5beetT\u00008\u56ac\ufffd|\u0004\ufffd~\u5668\u001f\u007b\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x13, 0x56, (byte)0xbb, 0x70, 0x29, 0x40, (byte)0xf9,
  (byte)0x86, 0x2a, 0x6a, (byte)0xbd, (byte)0xe1, (byte)0xc3, 0x37,
  (byte)0xc5, 0x25, (byte)0xb4, 0x33, 0x49, 0x47, (byte)0x8d };
str = "\u0013V\ud33a)@\ufffd*j\uc368\ucc22\ucf71\ub189IG\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4e, (byte)0x9e, (byte)0xe0, 0x7f, (byte)0xc6, 0x14,
  (byte)0xa4 };
str = "N\uc67d\u007f\ud140\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8c };
str = "\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x35, (byte)0xae, 0x6e, 0x2a, 0x54, (byte)0xa1,
  (byte)0xb9, 0x03, 0x69, 0x37, 0x1a, (byte)0xc1, (byte)0x8d, 0x36,
  (byte)0xaf, (byte)0xa4 };
str = "5\ucdf2*T\u300d\u0003i7\u001a\ud5b46\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6e, 0x5f, 0x21, 0x28, 0x76, 0x68, 0x31, (byte)0xc7,
  (byte)0x99, (byte)0xd1, (byte)0xe0, 0x73, 0x6e, 0x49, 0x54, 0x3f,
  (byte)0x99, (byte)0xfa, (byte)0xa1, 0x59 };
str = "n_!(vh1\ufffd\uf913snIT?\uc21d\uc8c0";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x28, 0x70, 0x0f, 0x65, 0x0f, (byte)0x9c, 0x7d, 0x77,
  0x2e, (byte)0xf4, (byte)0xca, (byte)0xf0, 0x58, 0x2a, (byte)0x98, 0x65,
  0x09, (byte)0xb4, 0x5a, (byte)0xf4 };
str = "(p\u000fe\u000f\ufffd}w.\u5586\ufffdX*\uc062\u0009\ud04f\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x17, (byte)0xe0, (byte)0xd1, 0x46, (byte)0xab, 0x2c,
  (byte)0xd1, 0x61, (byte)0xc0, 0x75, 0x57, 0x64, 0x11, 0x3e, 0x3e,
  (byte)0xf4, (byte)0xad, 0x2a, 0x07, 0x25, 0x5d, (byte)0xd1, 0x55, 0x2c,
  0x38, 0x6a, (byte)0xdd };
str =

  "\u0017\u87ecF\u308a\ufffda\ud532Wd\u0011>>\u64f2*\u0007%]\ufffdU\u002c8j\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1e, 0x64 };
str = "\u001ed";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x87, 0x72, (byte)0x89, (byte)0x82, 0x4b, 0x59,
  0x47, 0x5c, (byte)0xa6, 0x3f, (byte)0xdd, 0x2e };
str = "\ub1ca\ub3afKYG\\\ufffd?\u71a2";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x71, (byte)0xcc, 0x49, (byte)0xd2, (byte)0xc6, 0x16,
  (byte)0x9c, 0x65, 0x19, 0x37, 0x24, 0x39, 0x7b, 0x34, 0x36, 0x71, 0x2a,
  0x53 };
str = "q\ufffdI\uf933\u0016\uc403\u00197$9\u007b46q*S";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa4, 0x22, 0x0f, (byte)0xae, 0x68, (byte)0xa1,
  0x6e, 0x44, (byte)0xfd, 0x3e, (byte)0xd6, 0x5f, 0x21 };
str = "\uff40\u000f\ucdea\uc8d2D\u689f\ufffd_!";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4f, (byte)0xe1, (byte)0x96, 0x1b, (byte)0xdf, 0x70,
  0x0e, (byte)0xe1, 0x64, 0x34, 0x62, 0x09, (byte)0xf0, 0x73, 0x2f, 0x26,
  (byte)0x8e, (byte)0x98, 0x05, (byte)0xd0, (byte)0xd3, (byte)0x81,
  (byte)0xaa, (byte)0x84, 0x49, 0x16, 0x66, 0x57 };
str =

  "O\ufffd\u001b\ufffdp\u000e\ufffdd4b\u0009\ufffds/&\ub7f9\u0005\u64d2\uac92\uaef1\u0016fW";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb5, 0x40, (byte)0xb5, 0x64 };
str = "\ub365\ud0ba";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8e, 0x3d, (byte)0xb1, 0x05, 0x28, (byte)0x91,
  0x67, 0x3e, 0x47, 0x70, 0x67, 0x63, 0x2f, 0x0d, 0x24, (byte)0xf9, 0x38,
  0x62, 0x5c };
str = "\ub79a\uac58(\uba7a>Gpgc/\u000d$\u6a19b\\";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc2, 0x08, 0x73, (byte)0xef, 0x76, 0x1d,
  (byte)0x87, 0x43, 0x27 };
str = "\uc89fs\ufffdv\u001d\ub1a0'";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x50, (byte)0xeb, 0x51, (byte)0xed, (byte)0xac,
  (byte)0x9a, (byte)0xd9, 0x51, (byte)0xee, (byte)0xec, 0x03, 0x63,
  (byte)0x92, 0x23, 0x3f, 0x49, 0x2d };
str = "P\ufffdQ\u59ff\uc2d6Q\u4f43\u0003c\ubb03?I-";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x15, 0x6e, (byte)0xf1, (byte)0xd4, (byte)0xa7, 0x3f,
  0x63, 0x40, 0x04, (byte)0xe5, (byte)0xf4, 0x31, 0x44, (byte)0xef, 0x53,
  0x31, (byte)0x92, (byte)0xaf, (byte)0xc6, 0x55, 0x23, 0x72, (byte)0x9a };
str = "\u0015n\u7ca5\ufffd?c@\u0004\u6df91D\ufffdS1\ubba3\ufffdU#r\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x11, 0x7b, (byte)0xf3, 0x30, 0x6e, 0x44, 0x2b, 0x4e,
  0x3c, 0x33, (byte)0xab, 0x6a, 0x43, (byte)0xd9, 0x7b, 0x39, (byte)0xfa,
  0x31 };
str = "\u0011\u007b\u684enD+N<3\uccc6C\ufffd\u007b9\u95d4";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0b, 0x1b, 0x26, 0x32, (byte)0xfc, 0x4d, (byte)0x87,
  0x46, 0x7f, (byte)0xf8, 0x02, (byte)0xe3, 0x77, (byte)0xca, (byte)0xd4 };
str = "\u000b\u001b&2\ufffdM\ub1a3\u007f\u6c70\ufffdw\u687f";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2d, (byte)0xc4, 0x2b, (byte)0xc7, 0x5a, 0x56, 0x61,
  0x5a, (byte)0xbf };
str = "-\ucdcc\ufffdZVaZ\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4d, 0x0e, (byte)0xd9, 0x1f, 0x2c, 0x2e, 0x25,
  (byte)0xf9, (byte)0xec, 0x0f, 0x7b, 0x27 };
str = "M\u000e\u679a\u002c.%\u76d2\u000f\u007b'";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x95, (byte)0xd1, (byte)0xdb, 0x3c, 0x26,
  (byte)0xdd, (byte)0xce, 0x69, (byte)0xa3, 0x52, (byte)0xc6, 0x7f,
  (byte)0x93, (byte)0x9c, (byte)0xd9, 0x34, (byte)0xba, 0x7f, 0x7e,
  (byte)0xd3, 0x02, 0x60 };
str = "\ube81\u52c3&\u76c6i\uc984\ufffd\u007f\ubc76\u8993\ufffd\u007f~\u5f29`";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf8, (byte)0x8e, (byte)0xd9, 0x11, 0x2e, 0x37,
  0x3e, (byte)0x8d, (byte)0xd8, (byte)0x8b, 0x5c, 0x7b, (byte)0x8a, 0x70 };
str = "\ufffd\u5fd9.7>\ub763\ufffd\\\u007b\ub477";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x29, 0x7b, 0x40, 0x04, (byte)0x8c, 0x65, (byte)0xa2,
  0x38, 0x56, (byte)0x9e, 0x66, 0x43, (byte)0xfc, 0x4f, (byte)0xe6,
  (byte)0xf8, 0x67, 0x72, 0x56, 0x35, (byte)0xc6 };
str = ")\u007b@\u0004\ub622\u2286V\uc5c2C\ufffdO\u67d3grV5\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc6, 0x3a };
str = "\ud234";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6f, (byte)0xb4, 0x47, 0x07, 0x0d, 0x22, (byte)0x92,
  0x64, 0x00, 0x76, (byte)0xdb, 0x63, 0x00, (byte)0x80, 0x20, 0x37,
  (byte)0xba, 0x09, 0x3b, (byte)0x9e, (byte)0xdf, 0x7b, 0x30, (byte)0x81,
  0x57 };
str =

  "o\ud036\u0007\u000d\"\ubb57\u0000v\ufffdc\u0000\ufffd 7\ubbc0;\uc67b\u007b0\uac2e";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x30, 0x44, (byte)0x96, (byte)0x81, 0x70, (byte)0xd8,
  0x40, 0x2d, 0x0d, 0x63, 0x20, 0x18, (byte)0xd8, (byte)0xaa, (byte)0xf7,
  0x2e };
str = "0D\ubef6p\u782c-\u000dc \u0018\u9b54\u8235";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc3, 0x5c, (byte)0xab, (byte)0xab, (byte)0xd8,
  (byte)0xfb, 0x34, 0x28, (byte)0xbd, (byte)0x8e, 0x4d, 0x53, 0x31,
  (byte)0x87, 0x58, 0x52 };
str = "\ufffd\\\u30ab\u7dec4(\ud425MS1\ub1b6R";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xab, 0x4e, 0x77, 0x3d, 0x56, (byte)0xe2, 0x48,
  (byte)0xf3, 0x65, (byte)0xbb, 0x6d, 0x17, (byte)0x80, (byte)0xfc,
  (byte)0xc2, 0x76, (byte)0xd0, 0x6f, 0x2e };
str = "\ucca5w=V\ufffdH\ufffde\ud335\u0017\ufffd\u733ev\ufffdo.";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf6, 0x3f, 0x53, 0x60, (byte)0x8b, 0x51, 0x61 };
str = "\u81b5S`\ub537a";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44, 0x71, (byte)0xd3, (byte)0x9d, (byte)0x8f,
  (byte)0xba, 0x29, 0x4b, (byte)0xef, 0x54, 0x22, (byte)0xed, 0x00, 0x78,
  (byte)0xa9, 0x64 };
str = "Dq\ufffd\ub90a)K\ufffdT\"\u82e1x\ucbe3";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3f, (byte)0xc1, 0x68, (byte)0x96, (byte)0xda, 0x2e,
  (byte)0xc0, (byte)0xab, 0x60, 0x7e, (byte)0xfa, 0x22, (byte)0xbb, 0x70,
  (byte)0xa8, 0x72, 0x14, 0x66, (byte)0xf4, 0x43, 0x62, 0x34, 0x25,
  (byte)0xaf, (byte)0xb6, 0x22, 0x28, (byte)0xe7, 0x39, 0x39 };
str =
  "?\ud594\ubf5e.\uc714`~\u54b8\ud33a\ucb9a\u0014f\ufffdCb4%\ufffd\"(\uf9a49";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1f, (byte)0xac };
str = "\u001f\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x67, 0x2a, (byte)0xcd, (byte)0xb2, 0x2b, (byte)0xa4,
  0x4c, 0x46, (byte)0x81, 0x38, 0x5a, 0x60, (byte)0x85, (byte)0xf3,
  (byte)0xb3, 0x03, 0x5e, (byte)0x80, (byte)0xd0, (byte)0xaa, 0x51, 0x7d,
  (byte)0xef, 0x1c, 0x4b, 0x3e, (byte)0xea };
str = "g*\u5471+\uc9f2F\ufffd8Z`\ub090\uaf30^\ufffd\u7abaQ}\u72c4K>\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x30, 0x2e, (byte)0xc5, 0x2a, (byte)0xb0, 0x37, 0x5d,
  0x5e, (byte)0xd6, (byte)0xf1, (byte)0xff, (byte)0xcc, (byte)0x95,
  (byte)0xbc, 0x3b, 0x60, 0x43, (byte)0x84, (byte)0xe4 };
str = "0.\ucf8c\ufffd7]^\u8cc2\ufffd\ufffd\uc0d8`C\uafa1";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x93, (byte)0x9f, 0x52, 0x72 };
str = "\ubc79Rr";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x70, 0x4c, (byte)0xb6, 0x0c, (byte)0xf4, 0x22, 0x6e,
  0x48, (byte)0xaf, 0x37, 0x4e, 0x64, 0x7e, (byte)0x99, 0x51, 0x2f,
  (byte)0xe1, 0x7d, 0x2b, (byte)0xeb, (byte)0xdf, 0x78, 0x3f, (byte)0x8b };
str = "pL\ub428\u5f70nH\ufffd7Nd~\uc147/\ufffd}+\u96b1x?\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xef, 0x3c, (byte)0xe7, 0x27, (byte)0xd0,
  (byte)0xd9, 0x52, (byte)0xde, 0x75, (byte)0xce, (byte)0xf1, 0x26 };
str = "\u6230\uf999\u82a9R\ufffdu\u86df&";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcc, 0x14, 0x6e, 0x33, (byte)0x82 };
str = "\u958bn3\ufffd";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe0, 0x0e, 0x76, 0x79, (byte)0xed, 0x7b, 0x3c,
  (byte)0x91, (byte)0xa9, 0x33, (byte)0xa4, 0x79, 0x7a, 0x11, 0x70,
  (byte)0xd1, (byte)0xc5, 0x0e, (byte)0xc3, 0x19, 0x20, (byte)0xa4,
  (byte)0xa5, 0x0a, (byte)0xd2, 0x31 };
str =

  "\u60f3vy\ufffd\u007b<\ubac63\uca24z\u0011p\u9324\u000e\ucb08 \u3135\u000a\uf91e";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x62, (byte)0x8d, 0x5e, 0x17, 0x3b, 0x48, (byte)0xb7,
  0x2b, 0x37, 0x22, (byte)0xaf, 0x24, (byte)0xf4, 0x59, 0x46 };
str = "b\ufffd^\u0017;H\ub74c7\"\ufffd$\ufffdYF";
Assert.AreEqual(
 str,
 Encodings.DecodeToString(charset, bytes));
}[Test]
public void TestKoreanEUCEncoder() {
byte[] bytes;
string str;
ICharacterEncoding charset = Encodings.GetEncoding("euc-kr");
str = "\u7e70\uff08\u6e2c";
bytes = new byte[] { (byte)0xf0, (byte)0xdb, (byte)0xa3, (byte)0xa8,
  (byte)0xf6, (byte)0xb4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff32\u5da0\uff29";
bytes = new byte[] { (byte)0xa3, (byte)0xd2, (byte)0xce, (byte)0xe4,
  (byte)0xa3, (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7368\u7a93j";
bytes = new byte[] { (byte)0xd4, (byte)0xbc, (byte)0xf3, (byte)0xeb, 0x6a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u0008\uff45\u688f";
bytes = new byte[] { 0x08, (byte)0xa3, (byte)0xe5, (byte)0xcd, (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u779e";
bytes = new byte[] { (byte)0xd8, (byte)0xbe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u70f9\u2164";
bytes = new byte[] { (byte)0xf8, (byte)0xb2, (byte)0xa5, (byte)0xb4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u221a\u5b05\u6848";
bytes = new byte[] { (byte)0xa1, (byte)0xee, (byte)0xfb, (byte)0xfb,
  (byte)0xe4, (byte)0xd0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5a\u5742\u24d9";
bytes = new byte[] { (byte)0xa3, (byte)0xfa, (byte)0xf7, (byte)0xf8,
  (byte)0xa8, (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4b\u54ac\ubb47\ub8ea";
bytes = new byte[] { (byte)0xa3, (byte)0xeb, (byte)0xce, (byte)0xe1,
  (byte)0xb9, (byte)0xb5, (byte)0x8f, (byte)0xa1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5be5\uff5b";
bytes = new byte[] { (byte)0xe8, (byte)0xef, (byte)0xa3, (byte)0xfb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6fb9\u253d\u58fa";
bytes = new byte[] { (byte)0xd3, (byte)0xc2, (byte)0xa6, (byte)0xd9,
  (byte)0xfb, (byte)0xbe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5c\u5d0d\uff0f";
bytes = new byte[] { (byte)0xa3, (byte)0xfc, (byte)0xd5, (byte)0xcf,
  (byte)0xa3, (byte)0xaf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff20\u7e6d";
bytes = new byte[] { (byte)0xa3, (byte)0xc0, (byte)0xcc, (byte)0xb6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7738\u5be8";
bytes = new byte[] { (byte)0xd9, (byte)0xc2, (byte)0xf3, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2480\u78bc\ubb64";
bytes = new byte[] { (byte)0xa9, (byte)0xf3, (byte)0xd8, (byte)0xa7,
  (byte)0x92, 0x6e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u66dc\uff3e\uae99\u5305";
bytes = new byte[] { (byte)0xe8, (byte)0xf8, (byte)0xa3, (byte)0xde,
  (byte)0x83, (byte)0xbf, (byte)0xf8, (byte)0xd0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u223c";
bytes = new byte[] { (byte)0xa1, (byte)0xad };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u24d9\u5be5";
bytes = new byte[] { (byte)0xa8, (byte)0xd6, (byte)0xe8, (byte)0xef };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7afa\u30dd\u6b98";
bytes = new byte[] { (byte)0xf5, (byte)0xe7, (byte)0xab, (byte)0xdd,
  (byte)0xed, (byte)0xd1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u559a\ub75d\uff47";
bytes = new byte[] { (byte)0xfc, (byte)0xb0, (byte)0x8d, (byte)0xd3,
  (byte)0xa3, (byte)0xe7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2521";
bytes = new byte[] { (byte)0xa6, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7c3f\uff4a\u5ed0";
bytes = new byte[] { (byte)0xdd, (byte)0xad, (byte)0xa3, (byte)0xea,
  (byte)0xcf, (byte)0xaa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u215b\u5f62\u58fd";
bytes = new byte[] { (byte)0xa8, (byte)0xfb, (byte)0xfb, (byte)0xa1,
  (byte)0xe1, (byte)0xf8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u69ff\u69d0\u79c9";
bytes = new byte[] { (byte)0xd0, (byte)0xc7, (byte)0xce, (byte)0xd9,
  (byte)0xdc, (byte)0xbc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff49";
bytes = new byte[] { (byte)0xa3, (byte)0xe9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff13";
bytes = new byte[] { (byte)0xa3, (byte)0xb3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff33\ubb59\u6812";
bytes = new byte[] { (byte)0xa3, (byte)0xd3, (byte)0x92, 0x65, (byte)0xe2,
  (byte)0xe3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u74a3\u797a\uca4e";
bytes = new byte[] { (byte)0xd1, (byte)0xb0, (byte)0xd1, (byte)0xb8,
  (byte)0xa5, 0x46 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u24b3\ud016\u2220";
bytes = new byte[] { (byte)0xa9, (byte)0xe4, (byte)0xb3, (byte)0x8b,
  (byte)0xa1, (byte)0xd0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2d\uff2f\ubf64";
bytes = new byte[] { (byte)0xa3, (byte)0xcd, (byte)0xa3, (byte)0xcf,
  (byte)0x96, (byte)0xe0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ubd90";
bytes = new byte[] { (byte)0xba, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u50b7\u5c38\u6383";
bytes = new byte[] { (byte)0xdf, (byte)0xbf, (byte)0xe3, (byte)0xb9,
  (byte)0xe1, (byte)0xb7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff36\u5e40";
bytes = new byte[] { (byte)0xa3, (byte)0xd6, (byte)0xef, (byte)0xd3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6ac2";
bytes = new byte[] { (byte)0xd4, (byte)0xa2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6ec2\u95bb\uff1c";
bytes = new byte[] { (byte)0xdb, (byte)0xb5, (byte)0xe7, (byte)0xa2,
  (byte)0xa3, (byte)0xbc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff48\u2640\uff07";
bytes = new byte[] { (byte)0xa3, (byte)0xe8, (byte)0xa1, (byte)0xcf,
  (byte)0xa3, (byte)0xa7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6f54\uff4d\uce41\u24a3\uffe1";
bytes = new byte[] { (byte)0xcc, (byte)0xbe, (byte)0xa3, (byte)0xed,
  (byte)0xaf, 0x52, (byte)0xa9, (byte)0xd4, (byte)0xa1, (byte)0xcc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u252b";
bytes = new byte[] { (byte)0xa6, (byte)0xb4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u56b4\u6843\u534d";
bytes = new byte[] { (byte)0xe5, (byte)0xf1, (byte)0xd3, (byte)0xfe,
  (byte)0xd8, (byte)0xb3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2c\uff20";
bytes = new byte[] { (byte)0xa3, (byte)0xcc, (byte)0xa3, (byte)0xc0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u696f";
bytes = new byte[] { (byte)0xe2, (byte)0xe4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u24d2";
bytes = new byte[] { (byte)0xa8, (byte)0xcf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff50\u797f";
bytes = new byte[] { (byte)0xa3, (byte)0xf0, (byte)0xd6, (byte)0xdf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5ae6";
bytes = new byte[] { (byte)0xf9, (byte)0xf4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7156\uff47\ub9a0\u223d";
bytes = new byte[] { (byte)0xd1, (byte)0xee, (byte)0xa3, (byte)0xe7,
  (byte)0x90, (byte)0x82, (byte)0xa1, (byte)0xef };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u53a6\u754c\uffe0\uff28\u9cf3";
bytes = new byte[] { (byte)0xf9, (byte)0xbd, (byte)0xcd, (byte)0xa3,
  (byte)0xa1, (byte)0xcb, (byte)0xa3, (byte)0xc8, (byte)0xdc, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7ac5\uafc2\uff47";
bytes = new byte[] { (byte)0xd0, (byte)0xab, (byte)0x85, 0x43, (byte)0xa3,
  (byte)0xe7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e8f\uff0f\u7791";
bytes = new byte[] { (byte)0xef, (byte)0xab, (byte)0xa3, (byte)0xaf,
  (byte)0xd9, (byte)0xaa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e3d\u5f04";
bytes = new byte[] { (byte)0xf5, (byte)0xc5, (byte)0xd6, (byte)0xe7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u0003";
bytes = new byte[] { 0x03 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u77dc\u6cae\u25a8";
bytes = new byte[] { (byte)0xd0, (byte)0xe8, (byte)0xee, (byte)0xc1,
  (byte)0xa2, (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5c";
bytes = new byte[] { (byte)0xa3, (byte)0xfc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5288\uff37\u000a";
bytes = new byte[] { (byte)0xdb, (byte)0xf9, (byte)0xa3, (byte)0xd7, 0x0a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uc5c5\u7c83\u3156";
bytes = new byte[] { (byte)0xbe, (byte)0xf7, (byte)0xdd, (byte)0xfb,
  (byte)0xa4, (byte)0xc6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2d";
bytes = new byte[] { (byte)0xa3, (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u00fe\ub7f1";
bytes = new byte[] { (byte)0xa9, (byte)0xad, (byte)0x8e, (byte)0x91 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6e9c";
bytes = new byte[] { (byte)0xd7, (byte)0xb6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5de7q\u6d3e";
bytes = new byte[] { (byte)0xce, (byte)0xe5, 0x71, (byte)0xf7, (byte)0xef };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ub506\uff1d\u75ab}";
bytes = new byte[] { (byte)0x8a, (byte)0xec, (byte)0xa3, (byte)0xbd,
  (byte)0xe6, (byte)0xb9, 0x7d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u656c\uff0e\u745a";
bytes = new byte[] { (byte)0xcc, (byte)0xd7, (byte)0xa3, (byte)0xae,
  (byte)0xfb, (byte)0xd1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6fe0";
bytes = new byte[] { (byte)0xfb, (byte)0xcc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u597d\u25cf";
bytes = new byte[] { (byte)0xfb, (byte)0xbf, (byte)0xa1, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5011\u673d\uff29\u6163";
bytes = new byte[] { (byte)0xd9, (byte)0xfa, (byte)0xfd, (byte)0xae,
  (byte)0xa3, (byte)0xc9, (byte)0xce, (byte)0xb1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u543e";
bytes = new byte[] { (byte)0xe7, (byte)0xee };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u222e\uff1f\u7bc1\u5947";
bytes = new byte[] { (byte)0xa2, (byte)0xb1, (byte)0xa3, (byte)0xbf,
  (byte)0xfc, (byte)0xd6, (byte)0xd0, (byte)0xf4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6b77\uff17\uff19";
bytes = new byte[] { (byte)0xd5, (byte)0xf6, (byte)0xa3, (byte)0xb7,
  (byte)0xa3, (byte)0xb9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ud0cf\uff59";
bytes = new byte[] { (byte)0xb5, 0x74, (byte)0xa3, (byte)0xf9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ud105\uff28";
bytes = new byte[] { (byte)0xb6, 0x41, (byte)0xa3, (byte)0xc8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5168\u64e1\u695a";
bytes = new byte[] { (byte)0xee, (byte)0xef, (byte)0xd3, (byte)0xe4,
  (byte)0xf5, (byte)0xa2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff13\uff1e\u6194";
bytes = new byte[] { (byte)0xa3, (byte)0xb3, (byte)0xa3, (byte)0xbe,
  (byte)0xf4, (byte)0xfb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe2\u574e\u24a1";
bytes = new byte[] { (byte)0xa1, (byte)0xfe, (byte)0xca, (byte)0xec,
  (byte)0xa9, (byte)0xd2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7f3a";
bytes = new byte[] { (byte)0xcc, (byte)0xc0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\ub4a8";
bytes = new byte[] { (byte)0xb5, (byte)0xdb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7766";
bytes = new byte[] { (byte)0xd9, (byte)0xce };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u78bc\u5065\u7440";
bytes = new byte[] { (byte)0xd8, (byte)0xa7, (byte)0xcb, (byte)0xed,
  (byte)0xe9, (byte)0xdc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5b58\ub5b8";
bytes = new byte[] { (byte)0xf0, (byte)0xed, (byte)0x8b, (byte)0xc3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7a95\u0011\ubae9";
bytes = new byte[] { (byte)0xf0, (byte)0xd7, 0x11, (byte)0x91, (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff35\u8429\u7c1e\u3149";
bytes = new byte[] { (byte)0xa3, (byte)0xd5, (byte)0xf5, (byte)0xd7,
  (byte)0xd3, (byte)0xaf, (byte)0xa4, (byte)0xb9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7dbf\u65f4\u7b0f";
bytes = new byte[] { (byte)0xd8, (byte)0xfa, (byte)0xe9, (byte)0xd9,
  (byte)0xfb, (byte)0xee };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4b\u693d\u808c";
bytes = new byte[] { (byte)0xa3, (byte)0xeb, (byte)0xe6, (byte)0xcb,
  (byte)0xd1, (byte)0xbf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5da0\uad67\u203b";
bytes = new byte[] { (byte)0xce, (byte)0xe4, (byte)0x82, (byte)0x8d,
  (byte)0xa1, (byte)0xd8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5d17";
bytes = new byte[] { (byte)0xcb, (byte)0xab };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0a\uff0d\ub013";
bytes = new byte[] { (byte)0xa3, (byte)0xaa, (byte)0xa3, (byte)0xad,
  (byte)0x85, (byte)0x8d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1d";
bytes = new byte[] { (byte)0xa3, (byte)0xbd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u52cd";
bytes = new byte[] { (byte)0xcc, (byte)0xce };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2667\uff41\uce28";
bytes = new byte[] { (byte)0xa2, (byte)0xbf, (byte)0xa3, (byte)0xe1,
  (byte)0xc3, (byte)0xfa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5893\u7422\u55a9\uff39\ubde5\u7a19";
bytes = new byte[] { (byte)0xd9, (byte)0xd7, (byte)0xf6, (byte)0xfc,
  (byte)0xea, (byte)0xe7, (byte)0xa3, (byte)0xd9, (byte)0x95, 0x50,
  (byte)0xf2, (byte)0xc2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5973\u24df\ucf20";
bytes = new byte[] { (byte)0xd2, (byte)0xb3, (byte)0xa8, (byte)0xdc,
  (byte)0xc4, (byte)0xd2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u247e\uff1b";
bytes = new byte[] { (byte)0xa9, (byte)0xf1, (byte)0xa3, (byte)0xbb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff22";
bytes = new byte[] { (byte)0xa3, (byte)0xc2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff45\ubda5";
bytes = new byte[] { (byte)0xa3, (byte)0xe5, (byte)0x94, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7737";
bytes = new byte[] { (byte)0xcf, (byte)0xef };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5b8b";
bytes = new byte[] { (byte)0xe1, (byte)0xe4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2e\uc518\u7a08\uffe1";
bytes = new byte[] { (byte)0xa3, (byte)0xce, (byte)0x9d, (byte)0xad,
  (byte)0xca, (byte)0xd9, (byte)0xa1, (byte)0xcc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff22";
bytes = new byte[] { (byte)0xa3, (byte)0xc2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3a\uc431\uc309";
bytes = new byte[] { (byte)0xa3, (byte)0xda, (byte)0x9c, (byte)0x94,
  (byte)0xbd, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff45\u6f3f";
bytes = new byte[] { (byte)0xa3, (byte)0xe5, (byte)0xed, (byte)0xec };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2170";
bytes = new byte[] { (byte)0xa5, (byte)0xa1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2e\uc6e6";
bytes = new byte[] { (byte)0xa3, (byte)0xce, (byte)0x9f, 0x72 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6c93\uff3f\u67b7";
bytes = new byte[] { (byte)0xd3, (byte)0xcb, (byte)0xa3, (byte)0xdf,
  (byte)0xca, (byte)0xae };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
}
}
}
