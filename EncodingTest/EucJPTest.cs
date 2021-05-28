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
      bytes = new byte[] {
        0x7d, (byte)0xed, 0x7b, 0x4c, 0x3b, (byte)0xc7, 0x41,
        (byte)0xca, 0x08, (byte)0xa1, (byte)0xc3, (byte)0xe2, (byte)0xc5,
      };
      str = "}\ufffd\u007bL;\ufffdA\ufffd\u0008\uff5c\u7726";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xc5, 0x33, (byte)0xef, (byte)0x80, 0x03, 0x0b,
        (byte)0x82, 0x50, 0x10,
      };
      str = "\ufffd3\ufffd\u0003\u000b\ufffdP\u0010";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x5a, 0x55, (byte)0xcb, (byte)0x9e, (byte)0xa6,
        (byte)0xff, (byte)0xcb, 0x7c, (byte)0xec, 0x52, (byte)0xa9, 0x53,
        (byte)0xca, 0x49, (byte)0xf5, (byte)0xd0, 0x28, (byte)0xe9, (byte)0xaf,
        (byte)0x9c, (byte)0xc1, 0x4e, 0x38, 0x5c, 0x41, 0x40, (byte)0xe6,
      };
      str =

  "ZU\ufffd\ufffd\ufffd|\ufffdR\ufffdS\ufffdI\ufffd(\u8587\ufffd\ufffdN8\\A@\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xa3, 0x5d, 0x2a, 0x0b, 0x6a, (byte)0x8f, 0x21,
        (byte)0xe1, (byte)0xec, 0x27, (byte)0xdc, (byte)0x9d, (byte)0xee, 0x0b,
        0x12, (byte)0xbe, 0x4e, 0x6b, (byte)0xfd, 0x19, (byte)0xb5, (byte)0x8e,
        (byte)0xf3, 0x48, (byte)0xaf, 0x37, 0x37, (byte)0xe6, 0x7d, 0x7c,
      };
      str =

  "\ufffd]*\u000bj\ufffd!\u7621'\ufffd\ufffd\u000b\u0012\ufffdNk\ufffd\u0019\ufffd\ufffdH\ufffd77\ufffd}|";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xba, 0x73, (byte)0xf3, 0x18, 0x03, 0x66,
        (byte)0xaf, 0x0b, (byte)0xd5, 0x6a, (byte)0xa0, 0x72, (byte)0xc8,
      };
      str = "\ufffds\ufffd\u0018\u0003f\ufffd\u000b\ufffdj\ufffdr\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x52, 0x7c, 0x2f, 0x6a, 0x39, (byte)0xc2, 0x4e, 0x66,
        (byte)0xbb, 0x70, (byte)0xe2, (byte)0x86, (byte)0xf9, (byte)0x8a,
        (byte)0xfd, 0x38, 0x3b, 0x6f, 0x24, (byte)0x98, (byte)0xaa, (byte)0x8f,
        0x68,
      };
      str = "R|/j9\ufffdNf\ufffdp\ufffd\ufffd\ufffd8;o$\ufffd\ufffdh";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { 0x68 };
      str = "h";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xc0, 0x3c, (byte)0xa4, (byte)0x89, 0x22,
        (byte)0xbf, (byte)0xc3, 0x77, 0x02, 0x31, 0x0f, (byte)0xc7, (byte)0xee,
        0x1f, (byte)0xca, (byte)0xe6, 0x4a, 0x0d, 0x63, (byte)0x84, 0x07,
      };
      str =
"\ufffd<\ufffd\"\u81e3w\u00021\u000f\u535a\u001f\u7a42J\rc\ufffd\u0007";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x24, 0x65, 0x70, 0x11, (byte)0xbb, 0x70, 0x32,
        (byte)0xb2, (byte)0xbb, (byte)0xe6,
      };
      str = "$ep\u0011\ufffdp2\u97f3\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x2f, 0x08, (byte)0xe9, (byte)0xb5, (byte)0xd5,
        (byte)0xb8, (byte)0xdd, (byte)0xf4, 0x4c, 0x1f, 0x01, (byte)0xe9, 0x32,
        (byte)0x93, (byte)0x97, (byte)0x9a, (byte)0xe3, 0x62, 0x56, 0x42, 0x13,
        (byte)0x8c, 0x5b, 0x6b, 0x57, 0x2a, (byte)0xbb, 0x28, (byte)0xfe,
        0x3e,
      };
      str =

  "/\u0008\u85ba\u5a36\u6c90L\u001f\u0001\ufffd2\ufffd\ufffd\ufffd\ufffdbVB\u0013\ufffd[kW*\ufffd(\ufffd>";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xa5, (byte)0xe8, 0x0e, (byte)0xa6, 0x50, 0x06,
        (byte)0x9b, (byte)0xc9, (byte)0xb7, 0x61, (byte)0x93, 0x2b, 0x01, 0x6c,
        (byte)0xcb, 0x78, 0x43, (byte)0xd1, 0x6f, 0x7f, (byte)0x93, (byte)0xb7,
        (byte)0xd5, 0x6c, (byte)0xc6, 0x55, 0x56, 0x65,
      };
      str =

  "\u30e8\u000e\ufffdP\u0006\ufffd\u5f6aa\ufffd+\u0001l\ufffdxC\ufffdo\u007f\ufffd\u834al\ufffdUVe";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { 0x48, 0x1f, 0x21, 0x5e, 0x1a, 0x7b, (byte)0xff };
      str = "H\u001f!^\u001a\u007b\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xdc, (byte)0xf8, 0x1d, 0x53, (byte)0x9c,
        (byte)0xce, (byte)0xdb, (byte)0xfd, (byte)0xcc, (byte)0xd7,
        (byte)0xb4,
      };
      str = "\u6a22\u001dS\ufffd\u9e9f\ufffd\u5f5c";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x2d, 0x70, (byte)0xb9, 0x73, (byte)0x99, (byte)0xcf,
        (byte)0x90, 0x20,
      };
      str = "-p\ufffds\ufffd\ufffd\u0020";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xa2, 0x24, 0x21, 0x5c, (byte)0xe4, 0x74,
        (byte)0x9e, (byte)0xd7, 0x27, 0x39, (byte)0x85, 0x58,
      };
      str = "\ufffd$!\\\ufffdt\ufffd\ufffd'9\ufffdX";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { (byte)0xf9 };
      str = "\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x64, (byte)0xc0, 0x27, 0x6d, (byte)0xf6, 0x11, 0x2f,
        0x76, (byte)0xec, (byte)0xc4, 0x45, (byte)0x87, (byte)0xee, 0x37, 0x3f,
        0x23,
      };
      str = "d\ufffd'm\ufffd\u0011/v\u8cadE\ufffd\ufffd7?#";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x20, 0x3f, (byte)0xde, (byte)0x94, 0x26, (byte)0xe9,
        (byte)0x98, 0x1b, 0x32, (byte)0x98, (byte)0xe7, 0x7c, 0x3d, (byte)0xd7,
        (byte)0x90, 0x28, 0x6e, (byte)0xad, (byte)0xc2,
      };
      str = "\u0020?\ufffd&\ufffd\u001b2\ufffd\ufffd|\u003d\ufffd(n\u3322";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x78, 0x18, (byte)0xf7, 0x1e, 0x46, 0x77, 0x21,
        (byte)0x98, 0x2d, 0x52, 0x71, (byte)0xa0,
      };
      str = "x\u0018\ufffd\u001eFw!\ufffd-Rq\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xb4, 0x53, (byte)0x97, 0x64, 0x1c, (byte)0xec,
        0x54, (byte)0x88, 0x03, 0x74, (byte)0xa8, 0x3a, 0x56, 0x2a, 0x3a, 0x25,
        0x5c, (byte)0x9c,
      };
      str = "\ufffdS\ufffdd\u001c\ufffdT\ufffd\u0003t\ufffd:V*:%\\\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x01, 0x63, 0x1f, (byte)0xe2, 0x1e, 0x64, 0x74, 0x6d,
        0x3f, (byte)0xd5, 0x26, (byte)0xec, 0x52, (byte)0xa8, 0x78,
      };
      str = "\u0001c\u001f\ufffd\u001edtm?\ufffd&\ufffdR\ufffdx";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x3d, (byte)0xf6, 0x61, 0x41, (byte)0xa8, 0x36, 0x41,
        0x35, 0x63, (byte)0x8f, 0x33, (byte)0xf3, 0x49, 0x1f, 0x65, 0x72,
        (byte)0x88, 0x16, (byte)0xe5, (byte)0x83, 0x73, 0x2d, 0x52, (byte)0xed,
        0x1b, 0x6f, (byte)0x8b, 0x2a,
      };
      str =

  "\u003d\ufffdaA\ufffd6A5c\ufffd3\ufffdI\u001fer\ufffd\u0016\ufffds-R\ufffd\u001bo\ufffd*";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { 0x04, 0x0a, 0x78 };
      str = "\u0004\nx";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0x91, (byte)0xbc, 0x4e, 0x15, (byte)0xdf,
        (byte)0xf7, (byte)0xf4, 0x5f, 0x58, 0x2a, 0x16, 0x26, 0x05, 0x6d,
      };
      str = "\ufffd\ufffdN\u0015\u71c9\ufffd_X*\u0016&\u0005m";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x02, (byte)0xeb, 0x6b, (byte)0xc2, 0x60, 0x30, 0x58,
        0x41, (byte)0xc4, (byte)0xdc, 0x53, 0x37, (byte)0xd1, (byte)0x91,
        (byte)0xb5, 0x3e, (byte)0xe0, 0x3e, 0x1b, (byte)0x84, 0x29, 0x7e,
        (byte)0xf8,
      };
      str =
"\u0002\ufffdk\ufffd`0XA\u5b2cS7\ufffd\ufffd>\ufffd>\u001b\ufffd)~\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x51, (byte)0xe0, 0x6b, (byte)0x9e, 0x37, (byte)0x87,
        0x7c, 0x46, (byte)0xf1, 0x5e, (byte)0xf9, 0x33, (byte)0x9d, 0x5a, 0x53,
        0x72, 0x10, 0x1b, 0x70, 0x45, (byte)0xc3, 0x29, (byte)0xa5, 0x4d,
        (byte)0xb5, (byte)0xeb, 0x58, 0x1e, (byte)0x88, 0x57,
      };
      str =

  "Q\ufffdk\ufffd7\ufffd|F\ufffd^\ufffd3\ufffdZSr\u0010\u001bpE\ufffd)\ufffdM\u7d66X\u001e\ufffdW";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xe4, 0x64, (byte)0xe3, 0x1d, (byte)0xca, 0x77,
        0x5a, (byte)0xb7, 0x55, (byte)0x9a, (byte)0xec, (byte)0xaf, 0x58, 0x60,
        (byte)0xb7, (byte)0x82, 0x5a, 0x28, 0x29, (byte)0x83, 0x59, (byte)0x92,
        0x6a, (byte)0xde, (byte)0xe2, 0x74, 0x7a, (byte)0x8d, 0x0f,
        (byte)0xf2,
      };
      str =

  "\ufffdd\ufffd\u001d\ufffdwZ\ufffdU\ufffd\u8c41X`\ufffdZ()\ufffdY\ufffdj\u6e38tz\ufffd\u000f\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { 0x5f, (byte)0x8e, 0x59 };
      str = "_\ufffdY";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { (byte)0x85, 0x51, 0x7d, 0x7c, 0x19, 0x78 };
      str = "\ufffdQ}|\u0019x";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x23, (byte)0x83, 0x75, 0x22, 0x33, 0x51, 0x64, 0x12,
        (byte)0xa0, 0x6d, (byte)0xb9, 0x68, (byte)0xf4, 0x71, 0x6c, (byte)0xc8,
        (byte)0xe9, 0x65, (byte)0xe2,
      };
      str = "#\ufffdu\"3Qd\u0012\ufffdm\ufffdh\ufffdql\u76aee\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x67, 0x4e, (byte)0x97, (byte)0xc6, 0x2e, (byte)0x9e,
        0x68, 0x40, 0x6e, (byte)0xf7, 0x53, 0x70, 0x11, (byte)0xac, 0x49, 0x71,
        (byte)0xd8, 0x04, 0x5d, (byte)0xaa, (byte)0xb4,
      };
      str = "gN\ufffd\ufffd.\ufffdh@n\ufffdSp\u0011\ufffdIq\ufffd\u0004]\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x62, (byte)0xca, (byte)0xbd, 0x38, 0x16, 0x21, 0x73,
        0x15,
      };
      str = "b\u58408\u0016!s\u0015";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x6f, (byte)0xc8, 0x4e, 0x13, (byte)0xb8, 0x07, 0x2f,
        0x58, (byte)0xb7, (byte)0x83, 0x05, 0x0b, (byte)0x8d, 0x13, 0x66, 0x25,
        (byte)0xaa, (byte)0xbf, (byte)0xb9, (byte)0xdc, 0x05, 0x7f, 0x32, 0x5b,
        (byte)0x84, 0x7c, (byte)0xab,
      };
      str =

  "o\ufffdN\u0013\ufffd\u0007/X\ufffd\u0005\u000b\ufffd\u0013f%\ufffd\u783f\u0005\u007f2[\ufffd|\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x60, (byte)0x8f, 0x24, 0x41, (byte)0xb0, (byte)0xdc,
        (byte)0x8c, (byte)0xb4, (byte)0xa3, 0x6c, (byte)0xad, (byte)0xfc, 0x03,
        (byte)0xa6, (byte)0x81, (byte)0x88, 0x2d, 0x32, 0x38, (byte)0xa5,
        (byte)0xbe, (byte)0xc6, (byte)0xf4, (byte)0xd9,
      };
      str =

  "`\ufffd$A\u79fb\ufffd\u82c5l\u222a\u0003\ufffd\ufffd-28\u30be\u5c3c\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0x80, 0x24, (byte)0xc0, 0x4f, 0x57, 0x52,
        0x52,
      };
      str = "\ufffd$\ufffdOWRR";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xf7, (byte)0xe0, (byte)0xf5, 0x1a, (byte)0x91,
        (byte)0xee, 0x6b, (byte)0xa3,
      };
      str = "\ufffd\ufffd\u001a\ufffd\ufffdk\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xdd, 0x7a, 0x7e, (byte)0xb2, 0x7e,
        (byte)0xd5,
      };
      str = "\ufffdz~\ufffd~\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x47, (byte)0x8f, 0x6e, (byte)0xc3, 0x60,
        (byte)0xfb,
      };
      str = "G\ufffdn\ufffd`\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x23, 0x4b, (byte)0xfb, (byte)0xbe, (byte)0x82,
        (byte)0xaf, 0x72, (byte)0x9a, 0x0a, (byte)0xbe, 0x4b, 0x55, 0x47, 0x0b,
        (byte)0xdf, 0x68, (byte)0xbc, (byte)0x89, (byte)0x89, (byte)0xe8,
        (byte)0xbf, 0x25, 0x75, 0x4f, (byte)0xac, 0x35, 0x43, (byte)0xf2,
        0x0d,
      };
      str =

  "#K\u784e\ufffd\ufffdr\ufffd\n\ufffdKUG\u000b\ufffdh\ufffd\ufffd\u83f4%uO\ufffd5C\ufffd\r";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { (byte)0xc2, (byte)0xe6, (byte)0xbc, 0x5e };
      str = "\u53f0\ufffd^";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x4b, (byte)0xf0, 0x11, 0x5a, (byte)0x9a, 0x35, 0x03,
        (byte)0xf4, 0x59, 0x74, (byte)0xa7, (byte)0xfb, 0x2a, 0x58, (byte)0x89,
        0x52, 0x0e, (byte)0x94, 0x73, 0x0a, 0x23, 0x3b,
      };
      str =
"K\ufffd\u0011Z\ufffd5\u0003\ufffdYt\ufffd*X\ufffdR\u000e\ufffds\n#;";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xbe, 0x21, (byte)0xff, 0x16, 0x29, (byte)0xed,
        (byte)0xa4, 0x10, 0x3a, (byte)0xbf, (byte)0xf8, (byte)0xff, 0x51, 0x57,
        0x3c, (byte)0xf6, (byte)0xd2, (byte)0x9e,
      };
      str = "\ufffd!\ufffd\u0016)\u8e50\u0010:\u636e\ufffdQW<\ufffd\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x66, 0x37, 0x3a, (byte)0xd9, 0x2b, (byte)0xd2, 0x04,
        0x6b, 0x2a, 0x5f, (byte)0xc4, (byte)0xd5, 0x01, (byte)0xd1, 0x20, 0x00,
        0x4c,
      };
      str = "f7:\ufffd+\ufffd\u0004k*_\u8526\u0001\ufffd\u0020\u0000L";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xf7, (byte)0xa8, (byte)0xb3, 0x3d, (byte)0xa0,
        (byte)0xa3, 0x7a, 0x42, (byte)0x9c, 0x55, (byte)0x81, (byte)0xaf,
      };
      str = "\ufffd\ufffd\u003d\ufffd\ufffdzB\ufffdU\ufffd\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { (byte)0xc1 };
      str = "\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { 0x60, 0x53 };
      str = "`S";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0x9f, (byte)0x9f, 0x40, 0x66, 0x6c, 0x13,
        (byte)0xd5, (byte)0x93, 0x38, 0x57, 0x4e, 0x7c, (byte)0xf1, 0x48, 0x2e,
        0x26, 0x13, 0x11, 0x45, 0x42,
      };
      str = "\ufffd\ufffd@fl\u0013\ufffd8WN|\ufffdH.&\u0013\u0011EB";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x36, 0x0a, (byte)0xa1, (byte)0xfc, (byte)0xdd,
        (byte)0xdb, 0x27, (byte)0xd0, 0x35, 0x67, 0x26,
      };
      str = "6\n\u25cf\u6bdf'\ufffd5g&";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x37, (byte)0xdc, (byte)0xd3, 0x12, (byte)0xdc, 0x21,
        (byte)0x82, (byte)0xc5, (byte)0xd0, 0x51, (byte)0x86, (byte)0xf4, 0x2a,
        (byte)0xc9, (byte)0x98, 0x79, 0x6e, 0x64,
      };
      str = "7\u6a2e\u0012\ufffd!\ufffd\u767bQ\ufffd\ufffd*\ufffdynd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { 0x5d, 0x3e, (byte)0xab, (byte)0xe2, 0x50 };
      str = "]>\ufffdP";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x6c, (byte)0xb8, (byte)0x88, 0x7e, (byte)0xf0,
        (byte)0xb2, (byte)0xe0,
      };
      str = "l\ufffd~\u96b9\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { (byte)0x91 };
      str = "\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xe9, (byte)0xdf, 0x6b, 0x52, (byte)0xae, 0x26,
        (byte)0xab, 0x73, 0x74, 0x6b, (byte)0xbc, 0x37, (byte)0xca, 0x43,
        (byte)0xd5, 0x34, 0x24, 0x3c, (byte)0x88, 0x77, 0x44, (byte)0xd3,
        (byte)0xcd, 0x3d, 0x3c, (byte)0xcd,
      };
      str =

  "\u86eckR\ufffd&\ufffdstk\ufffd7\ufffdC\ufffd4$<\ufffdwD\u55df\u003d<\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x04, 0x47, 0x67, 0x6d, 0x62, 0x34, 0x35, 0x6a, 0x79,
        (byte)0xc9, 0x42, (byte)0xa3, 0x3e, (byte)0xef,
      };
      str = "\u0004Ggmb45jy\ufffdB\ufffd>\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xe3, (byte)0xff, (byte)0x84, 0x5a,
        (byte)0xc7,
      };
      str = "\ufffd\ufffdZ\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x41, 0x77, (byte)0xbb, 0x73, (byte)0xf2, (byte)0xd4,
        0x29, (byte)0x89, 0x7c, 0x0f, 0x7c, 0x57, 0x40, (byte)0xa7, 0x00,
        (byte)0xab, (byte)0xda, (byte)0xca, (byte)0x91, (byte)0x99, 0x2a,
      };
      str = "Aw\ufffds\u9c13)\ufffd|\u000f|W@\ufffd\u0000\ufffd\ufffd\ufffd*";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { (byte)0x90, 0x37, (byte)0xe5, 0x53, (byte)0x9d };
      str = "\ufffd7\ufffdS\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { (byte)0x9a, (byte)0xc3, (byte)0xee };
      str = "\ufffd\u866b";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xe2, (byte)0x91, 0x68, (byte)0x89, 0x66, 0x4b,
        0x1d, (byte)0xa3, (byte)0xf2, (byte)0xc7,
      };
      str = "\ufffdh\ufffdfK\u001d\uff52\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x4b, 0x70, 0x0b, 0x01, 0x7e, 0x64, (byte)0x95,
        (byte)0xd3, 0x0a, 0x7b, (byte)0xee, 0x67, (byte)0xa5, 0x31, (byte)0xca,
        0x4b, (byte)0xd2, 0x50, (byte)0x83, 0x6c, (byte)0xef, 0x1d, (byte)0xe9,
        0x27, (byte)0xee, (byte)0xcf, 0x4e,
      };
      str =

  "Kp\u000b\u0001~d\ufffd\ufffd\n\u007b\ufffdg\ufffd1\ufffdK\ufffdP\ufffdl\ufffd\u001d\ufffd'\u91a2N";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x3f, 0x62, (byte)0xb8, 0x0b, 0x24, 0x2d, (byte)0xfa,
        0x5e, 0x7f, 0x20, (byte)0xc2, (byte)0x9f, 0x46, (byte)0x93, (byte)0x9c,
        0x36, (byte)0xea, 0x6a, (byte)0xd5, (byte)0x8e, 0x7b, 0x27, (byte)0x98,
        (byte)0xe7, 0x44, (byte)0xfd, (byte)0xb7,
      };
      str =

  "?b\ufffd\u000b$-\ufffd^\u007f\u0020\ufffdF\ufffd\ufffd6\ufffdj\ufffd\u007b'\ufffd\ufffdD\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0x94, (byte)0xa0, (byte)0xf5, (byte)0xab, 0x1a,
        0x1e, 0x14, 0x3e, (byte)0x89, 0x13, (byte)0xc0, (byte)0x93, (byte)0xfe,
        (byte)0x9f,
      };
      str = "\ufffd\ufffd\ufffd\u001a\u001e\u0014>\ufffd\u0013\ufffd\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { 0x4e, 0x4e, (byte)0xd3 };
      str = "NN\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x3f, 0x76, (byte)0xdc, 0x70, 0x55, (byte)0xd1,
        (byte)0xc7, 0x78, (byte)0xf7, (byte)0xbe, (byte)0xcb, 0x2e, 0x20, 0x66,
        (byte)0xa1, (byte)0x91, 0x25, (byte)0xca, (byte)0xd2, (byte)0xb9,
        (byte)0xc1, (byte)0xa5, 0x7d, 0x6b, 0x50, 0x63, 0x02,
      };
      str =

  "?v\ufffdpU\u5189x\ufffd\ufffd.\u0020f\ufffd%\u7247\u6e2f\ufffd}kPc\u0002";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x35, (byte)0xcf, 0x36, (byte)0xa7, (byte)0xb9, 0x73,
        0x7e, 0x48, 0x33, 0x7b, 0x08,
      };
      str = "5\ufffd6\u0427s~H3\u007b\u0008";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { 0x44, 0x2b, (byte)0xc2 };
      str = "D+\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x4c, (byte)0xd9, (byte)0x96, 0x31, 0x3c, 0x79, 0x1b,
        0x3d, (byte)0xbe, 0x6a,
      };
      str = "L\ufffd1<y\u001b\u003d\ufffdj";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xa7, (byte)0xb9, 0x70, 0x2d, 0x53, (byte)0xba,
        0x44, 0x3d, (byte)0xb5, 0x11, 0x19, 0x11, 0x36, 0x40, (byte)0x84, 0x7f,
        0x66, (byte)0xe9, (byte)0xfa, 0x0b, 0x4b, 0x61,
      };
      str =

  "\u0427p-S\ufffdD\u003d\ufffd\u0011\u0019\u00116@\ufffd\u007ff\u8774\u000bKa";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x42, 0x01, 0x1b, (byte)0xd6, (byte)0x96, 0x20,
        (byte)0x8d, (byte)0xe2, 0x22, 0x14, (byte)0xd7, (byte)0xc0, 0x39,
        (byte)0xbd, 0x08, 0x03, 0x47, (byte)0xd0, 0x2e, (byte)0xe9, 0x7d,
        (byte)0xe5, (byte)0xd2, (byte)0x88, (byte)0xb0,
      };
      str =

  "B\u0001\u001b\ufffd\u0020\ufffd\ufffd\"\u0014\u5f519\ufffd\u0008\u0003G\ufffd.\ufffd}\u7e21\ufffd\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x45, (byte)0xe9, 0x35, (byte)0xab, (byte)0xc6,
        (byte)0x86, (byte)0xff, 0x72, 0x4e, (byte)0xb8, (byte)0xb3, (byte)0x9e,
        (byte)0x89, 0x24, 0x79,
      };
      str = "E\ufffd5\ufffd\ufffd\ufffdrN\u9a13\ufffd\ufffd$y";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x77, 0x2d, 0x43, 0x56, 0x79, (byte)0xc4, 0x46,
        (byte)0xaf, 0x2e, 0x5d, 0x19, 0x3d, 0x5c,
      };
      str = "w-CVy\ufffdF\ufffd.]\u0019\u003d\\";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { 0x22, (byte)0x8a, 0x72 };
      str = "\"\ufffdr";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x26, 0x42, 0x5a, 0x26, (byte)0x99, (byte)0xb5, 0x19,
        0x7d, 0x66, 0x66, (byte)0xd0, (byte)0xd1, (byte)0x9a,
      };
      str = "&BZ&\ufffd\ufffd\u0019}ff\u4f70\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xa6, 0x46, 0x51, (byte)0xbb, (byte)0xcd, 0x7c,
        0x79, (byte)0xcb, 0x5f, (byte)0x92, 0x27,
      };
      str = "\ufffdFQ\u56db|y\ufffd_\ufffd'";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { (byte)0xff, 0x41 };
      str = "\ufffdA";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x31, (byte)0xa7, 0x36, 0x6a, 0x2e, 0x4b, (byte)0xe0,
        0x23, (byte)0xf7, 0x5f, 0x52, (byte)0x96, 0x37,
      };
      str = "1\ufffd6j.K\ufffd#\ufffd_R\ufffd7";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x3a, (byte)0xa8, (byte)0x9d, (byte)0xf3, 0x52,
        (byte)0xe9, (byte)0xca, (byte)0xc3, (byte)0xfe, 0x40, (byte)0xf9, 0x76,
        (byte)0xc2, 0x59, (byte)0xe5, 0x09, 0x51, 0x74, 0x19, (byte)0xe8,
        0x41,
      };
      str =
":\ufffd\ufffdR\u8654\u5bf5@\ufffdv\ufffdY\ufffd\u0009Qt\u0019\ufffdA";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x38, 0x36, 0x51, (byte)0xc7, 0x2d, 0x02, 0x69, 0x59,
        0x6f, (byte)0xf1, (byte)0xe2,
      };
      str = "86Q\ufffd-\u0002iYo\u9a4d";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x13, (byte)0x83, 0x68, (byte)0xe4, 0x08, 0x36, 0x2b,
        (byte)0xa7, (byte)0xe7, 0x51, (byte)0xac, 0x74, (byte)0xf0, 0x2b,
        (byte)0xc2, 0x5d, (byte)0xe6, (byte)0xcf, (byte)0xde, 0x60, 0x2c,
        (byte)0xef, 0x30, 0x20, 0x44, 0x35,
      };
      str =

  "\u0013\ufffdh\ufffd\u00086+\u0445Q\ufffdt\ufffd+\ufffd]\u800b\ufffd`\u002c\ufffd0\u0020D5";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xcb, (byte)0xdd, (byte)0xdc, (byte)0xdc, 0x5a,
        0x0e, (byte)0xf1, (byte)0xf6, (byte)0x93, (byte)0xe1, 0x21, (byte)0x93,
        (byte)0xcb, 0x16,
      };
      str = "\u7ffb\u6a1bZ\u000e\u9ae2\ufffd\ufffd!\ufffd\ufffd\u0016";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xc6, 0x69, (byte)0xb0, (byte)0xa5, 0x2c, 0x3e,
        0x0a, (byte)0x9b, 0x12, (byte)0x9e, (byte)0x9d, 0x6a, (byte)0x9e,
      };
      str = "\ufffdi\u54c0\u002c>\n\ufffd\u0012\ufffd\ufffdj\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xbb, (byte)0xc3, (byte)0xa0, 0x1d, 0x70, 0x77,
        0x31, 0x31, (byte)0x92,
      };
      str = "\u66ab\ufffd\u001dpw11\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { (byte)0xb5, 0x58 };
      str = "\ufffdX";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xc2, (byte)0xef, 0x22, 0x5e, 0x46, 0x6f, 0x2e,
        (byte)0xa9, 0x61, 0x68, 0x7e, (byte)0xde, 0x3b, (byte)0xc0, 0x0e, 0x1c,
        (byte)0x9c, 0x35, (byte)0xb9, (byte)0x8c, (byte)0xd2, (byte)0xa1,
        (byte)0xbf, 0x77, 0x77, (byte)0xb8,
      };
      str =

  "\u5544\"^Fo.\ufffdah~\ufffd;\ufffd\u000e\u001c\ufffd5\ufffd\u8fa7\ufffdww\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x4a, 0x34, (byte)0xc2, (byte)0xed, (byte)0xad, 0x6f,
        0x3e, 0x1c, 0x64,
      };
      str = "J4\u7027\ufffdo>\u001cd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xae, 0x4a, 0x57, 0x3e, (byte)0xbb, (byte)0xe7,
        (byte)0x99, (byte)0xe8, 0x7a, (byte)0xa8,
      };
      str = "\ufffdJW>\u7d2b\ufffd\ufffdz\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x37, 0x01, (byte)0xda, 0x5c, 0x5b, (byte)0x9f,
        (byte)0xb1, (byte)0x94, (byte)0xc6, 0x03, (byte)0xae, (byte)0x8b, 0x48,
        (byte)0x85, (byte)0xd9, 0x10, (byte)0x97, (byte)0xe5, 0x39, 0x53,
        (byte)0xf2, 0x35, 0x0e, 0x62, (byte)0xe8,
      };
      str =

  "7\u0001\ufffd\\[\ufffd\ufffd\ufffd\u0003\ufffdH\ufffd\ufffd\u0010\ufffd\ufffd9S\ufffd5\u000eb\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xc9, 0x62, (byte)0xdc, (byte)0xda, 0x21, 0x64,
        0x31, 0x3a, 0x78, 0x58, (byte)0xcb, 0x53, (byte)0xf9, 0x20, 0x2f, 0x60,
        0x3d, (byte)0xf1, (byte)0xd7, (byte)0xd4, 0x74, (byte)0x94, 0x7b,
        (byte)0x96, (byte)0xdf, 0x7e, (byte)0xb7, (byte)0xa1,
      };
      str =

  "\ufffdb\u69e8!d1:xX\ufffdS\ufffd\u0020/`\u003d\u9a05\ufffdt\ufffd\u007b\ufffd\ufffd~\u6398";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] { 0x50, (byte)0xb2, (byte)0xe6, 0x71 };
      str = "P\u6211q";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xe3, 0x76, (byte)0xae, 0x64, 0x37, 0x2a, 0x69,
        0x25, (byte)0xfd, (byte)0xad, (byte)0xb9, 0x70, 0x05, 0x03, 0x63, 0x38,
        (byte)0xcb, (byte)0xd2, 0x4f, 0x70, 0x48,
      };
      str = "\ufffdv\ufffdd7*i%\ufffd\ufffdp\u0005\u0003c8\u7267OpH";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x7e, (byte)0xf1, (byte)0xd0, 0x52, (byte)0xca,
        (byte)0xf2, 0x2c, 0x21, 0x2b, (byte)0xf0, 0x5f, (byte)0x83, (byte)0xea,
        0x62, (byte)0xcd, (byte)0xc9, 0x52, (byte)0xde, (byte)0x9b, (byte)0x9a,
        (byte)0xc2, 0x0c, 0x51,
      };
      str =

  "~\u99eeR\u5446\u002c!+\ufffd_\ufffd\ufffdb\u63faR\ufffd\ufffd\ufffd\u000cQ";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0x98, (byte)0x8c, (byte)0xa1, (byte)0xd0, 0x18,
        0x6a, 0x08, 0x63, 0x2c, 0x32, 0x17, (byte)0xf3, 0x16, 0x41, (byte)0xda,
        0x01, 0x20, (byte)0x81, 0x78, 0x4c, (byte)0x9c,
      };
      str =

  "\ufffd\ufffd\uff5b\u0018j\u0008c\u002c2\u0017\ufffd\u0016A\ufffd\u0001\u0020\ufffdxL\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x06, (byte)0xf4, (byte)0xb8, 0x4e, 0x67, (byte)0xa6,
        0x2e, 0x11, 0x7c, 0x52, (byte)0xeb, (byte)0x81, 0x3e, (byte)0x96,
        (byte)0x95, (byte)0x90, (byte)0x92, (byte)0xb6, 0x5e, 0x25, 0x25,
        (byte)0x87, (byte)0xa5, (byte)0x81, (byte)0xa0, 0x77, (byte)0x9f,
        (byte)0xa7,
      };
      str =

  "\u0006\ufffdNg\ufffd.\u0011|R\ufffd>\ufffd\ufffd\ufffd\ufffd\ufffd^%%\ufffd\ufffd\ufffdw\ufffd\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0x80, 0x17, (byte)0xce, (byte)0xb9, 0x02,
        (byte)0xce, 0x20, 0x7e, (byte)0xa6, 0x5e,
      };
      str = "\ufffd\u0017\u65c5\u0002\ufffd\u0020~\ufffd^";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x2f, 0x41, (byte)0x9a, 0x04, (byte)0xe0, 0x75,
        (byte)0xab, 0x18, (byte)0xc8, (byte)0xb6, 0x6a, (byte)0xd1, (byte)0xaf,
        (byte)0xe2, (byte)0xa6, (byte)0xc9,
      };
      str = "/A\ufffd\u0004\ufffdu\ufffd\u0018\u95a5j\u5102\u7683\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        (byte)0xe7, (byte)0xf4, 0x51, (byte)0xc9, 0x0a, 0x33,
        (byte)0xf3, 0x13, 0x67, 0x52, 0x24, 0x2d, 0x64, (byte)0x93, (byte)0xba,
        0x25, (byte)0xa8, 0x41, (byte)0xda, 0x7e, 0x47, 0x29, (byte)0xe8,
        (byte)0xb0, (byte)0x9f, 0x45, (byte)0xd7,
      };
      str =

  "\u82f3Q\ufffd\n3\ufffd\u0013gR$-d\ufffd\ufffd%\ufffdA\ufffd~G)\u83aa\ufffdE\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x57, 0x6d, 0x32, 0x3f, 0x78, 0x0b, 0x77, 0x5f,
        (byte)0xb8, 0x0a, 0x55, 0x0b, (byte)0xca, (byte)0xb6, (byte)0x99, 0x13,
        (byte)0xd8, (byte)0x8e, 0x36, 0x41, 0x6d, 0x27, 0x5a, (byte)0x81, 0x53,
        (byte)0xc6, (byte)0x87,
      };
      str =
"Wm2?x\u000bw_\ufffd\nU\u000b\u7d1b\ufffd\u0013\ufffd6Am'Z\ufffdS\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x0e, (byte)0x8f, 0x6f, (byte)0x81, 0x63, (byte)0x8c,
        0x05, (byte)0xbd, 0x0e, 0x68, 0x7c, (byte)0xd9, 0x7f, 0x0f,
        (byte)0xb7,
      };
      str =
"\u000e\ufffdo\ufffdc\ufffd\u0005\ufffd\u000eh|\ufffd\u007f\u000f\ufffd";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x59, (byte)0xaa, 0x1b, 0x1b, 0x71, (byte)0xb4,
        (byte)0xc7, 0x39, (byte)0xc6, (byte)0x99, (byte)0x94, 0x7f, (byte)0x9f,
        0x72, (byte)0xe9, (byte)0xb4, (byte)0x8b, 0x7d, (byte)0x8f, 0x59, 0x01,
        0x65, (byte)0xa2, (byte)0xf6, (byte)0xdb, 0x57, 0x33, 0x60, 0x54,
        0x64,
      };
      str =

  "Y\ufffd\u001b\u001bq\u770b9\ufffd\ufffd\u007f\ufffdr\u85c9\ufffd}\ufffdY\u0001e\u266a\ufffdW3`Td";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
      bytes = new byte[] {
        0x44, (byte)0xaf, (byte)0xe4, 0x2f, (byte)0xff, 0x22,
        (byte)0x97, (byte)0xb7, 0x0b, 0x42, 0x05, 0x48, (byte)0x8a, 0x1a,
        (byte)0x9f, (byte)0x9b, 0x6f, 0x27, 0x5c, 0x55, 0x5c, 0x5b, (byte)0xc3,
        0x1b,
      };
      str =

  "D\ufffd/\ufffd\"\ufffd\ufffd\u000bB\u0005H\ufffd\u001a\ufffd\ufffdo'\\U\\[\ufffd\u001b";
      Assert.AreEqual(
        str,
        Encodings.DecodeToString(charset, bytes));
    }
    [Test]
    public void TestEucJPEncoder() {
      byte[] bytes;
      string str;
      ICharacterEncoding charset = Encodings.GetEncoding("euc-jp");
      str = "\uff11\u7377\u7e6a";
      bytes = new byte[] {
        (byte)0xa3, (byte)0xb1, (byte)0xfb, (byte)0xa4,
        (byte)0xe5, (byte)0xe9,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u7546\u591b\u52df";
      bytes = new byte[] {
        (byte)0xe1, (byte)0xbc, (byte)0xd4, (byte)0xec,
        (byte)0xca, (byte)0xe7,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u8515\uffe4\u5f27\uff8c";
      bytes = new byte[] {
        (byte)0xe8, (byte)0xf8, (byte)0xfc, (byte)0xfc,
        (byte)0xb8, (byte)0xcc, (byte)0x8e, (byte)0xcc,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u5922\u7dd2\u7149\u7594\uff68\u750e";
      bytes = new byte[] {
        (byte)0xcc, (byte)0xb4, (byte)0xbd, (byte)0xef,
        (byte)0xce, (byte)0xfb, (byte)0xe1, (byte)0xcb, (byte)0x8e, (byte)0xa8,
        (byte)0xe1, (byte)0xaf,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u2473";
      bytes = new byte[] { (byte)0xad, (byte)0xb4 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u2175\u5830\u6d74\uff12";
      bytes = new byte[] {
        (byte)0xfc, (byte)0xf6, (byte)0xb1, (byte)0xe1,
        (byte)0xcd, (byte)0xe1, (byte)0xa3, (byte)0xb2,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u6025";
      bytes = new byte[] { (byte)0xb5, (byte)0xde };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u7b02\uff21\u6863";
      bytes = new byte[] {
        (byte)0xe3, (byte)0xf3, (byte)0xa3, (byte)0xc1,
        (byte)0xdb, (byte)0xe3,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u8de3\uff16\u8b10";
      bytes = new byte[] {
        (byte)0xec, (byte)0xf1, (byte)0xa3, (byte)0xb6,
        (byte)0xeb, (byte)0xed,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff71\u60d8\u5dba";
      bytes = new byte[] {
        (byte)0x8e, (byte)0xb1, (byte)0xd8, (byte)0xb1,
        (byte)0xce, (byte)0xe6,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u223d\uff04\uff82";
      bytes = new byte[] {
        (byte)0xa2, (byte)0xe6, (byte)0xa1, (byte)0xf0,
        (byte)0x8e, (byte)0xc2,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff75;\uff8b";
      bytes = new byte[] {
        (byte)0x8e, (byte)0xb5, 0x3b, (byte)0x8e,
        (byte)0xcb,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff18\u8ed2\uff19\u58df";
      bytes = new byte[] {
        (byte)0xa3, (byte)0xb8, (byte)0xb8, (byte)0xae,
        (byte)0xa3, (byte)0xb9, (byte)0xd4, (byte)0xe2,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u641c\uff69\uff07";
      bytes = new byte[] {
        (byte)0xd9, (byte)0xd3, (byte)0x8e, (byte)0xa9,
        (byte)0xfc, (byte)0xfd,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u822b\uff88\u688f";
      bytes = new byte[] {
        (byte)0xe7, (byte)0xd6, (byte)0x8e, (byte)0xc8,
        (byte)0xdb, (byte)0xe7,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u7696\u60e0\uff13";
      bytes = new byte[] {
        (byte)0xe2, (byte)0xaa, (byte)0xd8, (byte)0xaa,
        (byte)0xa3, (byte)0xb3,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff6b\uff18";
      bytes = new byte[] { (byte)0x8e, (byte)0xab, (byte)0xa3, (byte)0xb8 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff5d\uff5a\uff65";
      bytes = new byte[] {
        (byte)0xa1, (byte)0xd1, (byte)0xa3, (byte)0xfa,
        (byte)0x8e, (byte)0xa5,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff2f";
      bytes = new byte[] { (byte)0xa3, (byte)0xcf };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff98";
      bytes = new byte[] { (byte)0x8e, (byte)0xd8 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u9724\uff35\u59d4";
      bytes = new byte[] {
        (byte)0xf0, (byte)0xc5, (byte)0xa3, (byte)0xd5,
        (byte)0xb0, (byte)0xd1,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u7a14\uff50";
      bytes = new byte[] { (byte)0xcc, (byte)0xad, (byte)0xa3, (byte)0xf0 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u75fe\u7609";
      bytes = new byte[] { (byte)0xe1, (byte)0xde, (byte)0xe1, (byte)0xe8 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff7c\uff78\u69d9\uff43\uff51";
      bytes = new byte[] {
        (byte)0x8e, (byte)0xbc, (byte)0x8e, (byte)0xb8,
        (byte)0xcb, (byte)0xea, (byte)0xa3, (byte)0xe3, (byte)0xa3,
        (byte)0xf1,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff0a\u542c\u539f\uff3a\uff3d";
      bytes = new byte[] {
        (byte)0xa1, (byte)0xf6, (byte)0xd2, (byte)0xe1,
        (byte)0xb8, (byte)0xb6, (byte)0xa3, (byte)0xda, (byte)0xa1,
        (byte)0xcf,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u0015";
      bytes = new byte[] { 0x15 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u630c\u7985\u2502";
      bytes = new byte[] {
        (byte)0xd9, (byte)0xc8, (byte)0xc1, (byte)0xb5,
        (byte)0xa8, (byte)0xa2,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "l\uff8f\u55fd";
      bytes = new byte[] {
        0x6c, (byte)0x8e, (byte)0xcf, (byte)0xd3,
        (byte)0xd6,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u601c\uff0b";
      bytes = new byte[] { (byte)0xce, (byte)0xe7, (byte)0xa1, (byte)0xdc };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff2f\u9f76\u7345\uff67";
      bytes = new byte[] {
        (byte)0xa3, (byte)0xcf, (byte)0xf3, (byte)0xfb,
        (byte)0xbb, (byte)0xe2, (byte)0x8e, (byte)0xa7,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u7adc";
      bytes = new byte[] { (byte)0xce, (byte)0xb5 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u748b";
      bytes = new byte[] { (byte)0xe0, (byte)0xf8 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u5291\u719f\u6a44";
      bytes = new byte[] {
        (byte)0xd1, (byte)0xfd, (byte)0xbd, (byte)0xcf,
        (byte)0xdc, (byte)0xed,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uffe2";
      bytes = new byte[] { (byte)0xa2, (byte)0xcc };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u307a\u5be8";
      bytes = new byte[] { (byte)0xa4, (byte)0xda, (byte)0xdc, (byte)0xcd };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u67deg\u7bdd";
      bytes = new byte[] {
        (byte)0xdb, (byte)0xd0, 0x67, (byte)0xe4,
        (byte)0xc0,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u518f\uff5c";
      bytes = new byte[] { (byte)0xd1, (byte)0xc8, (byte)0xa1, (byte)0xc3 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u98b6";
      bytes = new byte[] { (byte)0xf1, (byte)0xa7 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff12\u9a62\u786c\u5dbc";
      bytes = new byte[] {
        (byte)0xa3, (byte)0xb2, (byte)0xf1, (byte)0xe6,
        (byte)0xb9, (byte)0xc5, (byte)0xd6, (byte)0xd9,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff42\u67d3\uff0b";
      bytes = new byte[] {
        (byte)0xa3, (byte)0xe2, (byte)0xc0, (byte)0xf7,
        (byte)0xa1, (byte)0xdc,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u6f11";
      bytes = new byte[] { (byte)0xde, (byte)0xf4 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff9e\uff24\uff64";
      bytes = new byte[] {
        (byte)0x8e, (byte)0xde, (byte)0xa3, (byte)0xc4,
        (byte)0x8e, (byte)0xa4,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u6e4a\uff4a\uff55";
      bytes = new byte[] {
        (byte)0xcc, (byte)0xab, (byte)0xa3, (byte)0xea,
        (byte)0xa3, (byte)0xf5,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff76\u53b3";
      bytes = new byte[] { (byte)0x8e, (byte)0xb6, (byte)0xb8, (byte)0xb7 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u6e29\u983c\uff1d";
      bytes = new byte[] {
        (byte)0xb2, (byte)0xb9, (byte)0xcd, (byte)0xea,
        (byte)0xa1, (byte)0xe1,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u5de8\u72c4\u5055";
      bytes = new byte[] {
        (byte)0xb5, (byte)0xf0, (byte)0xe0, (byte)0xbf,
        (byte)0xd0, (byte)0xf3,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u615f\uff34\u8e59";
      bytes = new byte[] {
        (byte)0xd8, (byte)0xd6, (byte)0xa3, (byte)0xd4,
        (byte)0xed, (byte)0xa6,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u732a\u71e7\u5f66";
      bytes = new byte[] {
        (byte)0xc3, (byte)0xf6, (byte)0xdf, (byte)0xfc,
        (byte)0xc9, (byte)0xa7,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u72c2";
      bytes = new byte[] { (byte)0xb6, (byte)0xb8 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u5d15";
      bytes = new byte[] { (byte)0xd6, (byte)0xbd };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u9397\u6bb7\u553e";
      bytes = new byte[] {
        (byte)0xc1, (byte)0xf9, (byte)0xdd, (byte)0xd6,
        (byte)0xc2, (byte)0xc3,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff18\uff74";
      bytes = new byte[] { (byte)0xa3, (byte)0xb8, (byte)0x8e, (byte)0xb4 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff9d\u803d";
      bytes = new byte[] { (byte)0x8e, (byte)0xdd, (byte)0xc3, (byte)0xbf };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff14\uff8d\uff58";
      bytes = new byte[] {
        (byte)0xa3, (byte)0xb4, (byte)0x8e, (byte)0xcd,
        (byte)0xa3, (byte)0xf8,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u6afa\u7b6c\uff5b\uff0b";
      bytes = new byte[] {
        (byte)0xdd, (byte)0xb2, (byte)0xe4, (byte)0xad,
        (byte)0xa1, (byte)0xd0, (byte)0xa1, (byte)0xdc,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff83\u524c";
      bytes = new byte[] { (byte)0x8e, (byte)0xc3, (byte)0xd1, (byte)0xef };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u7b4b\u5294";
      bytes = new byte[] { (byte)0xb6, (byte)0xda, (byte)0xd1, (byte)0xf9 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u9ed9\u6bd8\uff61";
      bytes = new byte[] {
        (byte)0xcc, (byte)0xdb, (byte)0xc8, (byte)0xfb,
        (byte)0x8e, (byte)0xa1,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "U";
      bytes = new byte[] { 0x55 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u58b9";
      bytes = new byte[] { (byte)0xd4, (byte)0xd1 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u7dca\u514c";
      bytes = new byte[] { (byte)0xb6, (byte)0xdb, (byte)0xd1, (byte)0xbc };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff42\uff7d\u670f";
      bytes = new byte[] {
        (byte)0xa3, (byte)0xe2, (byte)0x8e, (byte)0xbd,
        (byte)0xdb, (byte)0xac,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u5039\uff51\u5046\uff45\u585e";
      bytes = new byte[] {
        (byte)0xb7, (byte)0xf0, (byte)0xa3, (byte)0xf1,
        (byte)0xf9, (byte)0xbd, (byte)0xa3, (byte)0xe5, (byte)0xba,
        (byte)0xc9,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u7c95\u542d";
      bytes = new byte[] { (byte)0xc7, (byte)0xf4, (byte)0xd2, (byte)0xe2 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff7d\u54a4\u73e3";
      bytes = new byte[] {
        (byte)0x8e, (byte)0xbd, (byte)0xd3, (byte)0xa3,
        (byte)0xfb, (byte)0xa8,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff02\uff6cT";
      bytes = new byte[] {
        (byte)0xfc, (byte)0xfe, (byte)0x8e, (byte)0xac,
        0x54,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u592a\u75e2\uff10";
      bytes = new byte[] {
        (byte)0xc2, (byte)0xc0, (byte)0xce, (byte)0xa1,
        (byte)0xa3, (byte)0xb0,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u64fe\u7370\uff30";
      bytes = new byte[] {
        (byte)0xbe, (byte)0xf1, (byte)0xe0, (byte)0xd8,
        (byte)0xa3, (byte)0xd0,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u66c9\u6a8d\uff8d";
      bytes = new byte[] {
        (byte)0xda, (byte)0xfc, (byte)0xdc, (byte)0xfa,
        (byte)0x8e, (byte)0xcd,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u65e5";
      bytes = new byte[] { (byte)0xc6, (byte)0xfc };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff1d\uffe2\u68fa";
      bytes = new byte[] {
        (byte)0xa1, (byte)0xe1, (byte)0xa2, (byte)0xcc,
        (byte)0xb4, (byte)0xbd,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff8f\uff4e\uff96\u5e4c\u787c";
      bytes = new byte[] {
        (byte)0x8e, (byte)0xcf, (byte)0xa3, (byte)0xee,
        (byte)0x8e, (byte)0xd6, (byte)0xcb, (byte)0xda, (byte)0xe2,
        (byte)0xef,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff06\u91cb\u96f2\u6625";
      bytes = new byte[] {
        (byte)0xa1, (byte)0xf5, (byte)0xee, (byte)0xd9,
        (byte)0xb1, (byte)0xc0, (byte)0xbd, (byte)0xd5,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u5a35";
      bytes = new byte[] { (byte)0xd5, (byte)0xb7 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff23\u2525";
      bytes = new byte[] { (byte)0xa3, (byte)0xc3, (byte)0xa8, (byte)0xbe };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u6dec";
      bytes = new byte[] { (byte)0xde, (byte)0xc3 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u6258\uff9f";
      bytes = new byte[] { (byte)0xc2, (byte)0xf1, (byte)0x8e, (byte)0xdf };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u5473";
      bytes = new byte[] { (byte)0xcc, (byte)0xa3 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u222e\uff05\uff8e";
      bytes = new byte[] {
        (byte)0xad, (byte)0xf3, (byte)0xa1, (byte)0xf3,
        (byte)0x8e, (byte)0xce,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff0b";
      bytes = new byte[] { (byte)0xa1, (byte)0xdc };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u75d5\u2116\uff84\uff74\u5040";
      bytes = new byte[] {
        (byte)0xba, (byte)0xaf, (byte)0xad, (byte)0xe2,
        (byte)0x8e, (byte)0xc4, (byte)0x8e, (byte)0xb4, (byte)0xf9,
        (byte)0xb9,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u697d\uff54\uff27\uff66";
      bytes = new byte[] {
        (byte)0xb3, (byte)0xda, (byte)0xa3, (byte)0xf4,
        (byte)0xa3, (byte)0xc7, (byte)0x8e, (byte)0xa6,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u6d9b\uff2b\uff3b";
      bytes = new byte[] {
        (byte)0xc5, (byte)0xf3, (byte)0xa3, (byte)0xcb,
        (byte)0xa1, (byte)0xce,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff87\u628a\uff05";
      bytes = new byte[] {
        (byte)0x8e, (byte)0xc7, (byte)0xc7, (byte)0xc4,
        (byte)0xa1, (byte)0xf3,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u66dc\u5468\uff55";
      bytes = new byte[] {
        (byte)0xcd, (byte)0xcb, (byte)0xbc, (byte)0xfe,
        (byte)0xa3, (byte)0xf5,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u6e56\u51aa\uff14";
      bytes = new byte[] {
        (byte)0xb8, (byte)0xd0, (byte)0xd1, (byte)0xd1,
        (byte)0xa3, (byte)0xb4,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u9bb9\u6bbb\u88b0";
      bytes = new byte[] {
        (byte)0xf2, (byte)0xc3, (byte)0xb3, (byte)0xcc,
        (byte)0xea, (byte)0xde,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u5e2d\u5a40\u6350";
      bytes = new byte[] {
        (byte)0xc0, (byte)0xca, (byte)0xd5, (byte)0xb4,
        (byte)0xd9, (byte)0xd0,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u7167";
      bytes = new byte[] { (byte)0xbe, (byte)0xc8 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u68fa";
      bytes = new byte[] { (byte)0xb4, (byte)0xbd };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "[\uff68\uff47";
      bytes = new byte[] {
        0x5b, (byte)0x8e, (byte)0xa8, (byte)0xa3,
        (byte)0xe7,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff03\uff32\u7fc5";
      bytes = new byte[] {
        (byte)0xa1, (byte)0xf4, (byte)0xa3, (byte)0xd2,
        (byte)0xe6, (byte)0xc2,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff81";
      bytes = new byte[] { (byte)0x8e, (byte)0xc1 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u7d20\u644e\u5902";
      bytes = new byte[] {
        (byte)0xc1, (byte)0xc7, (byte)0xd9, (byte)0xf7,
        (byte)0xd4, (byte)0xe9,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u6ec5\u800c\uff61\uff56";
      bytes = new byte[] {
        (byte)0xcc, (byte)0xc7, (byte)0xbc, (byte)0xa9,
        (byte)0x8e, (byte)0xa1, (byte)0xa3, (byte)0xf6,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff34\uff76\u5712";
      bytes = new byte[] {
        (byte)0xa3, (byte)0xd4, (byte)0x8e, (byte)0xb6,
        (byte)0xb1, (byte)0xe0,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u7005\u75a3\u9b22";
      bytes = new byte[] {
        (byte)0xfa, (byte)0xf1, (byte)0xe1, (byte)0xcf,
        (byte)0xf2, (byte)0xa6,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "t\uff04";
      bytes = new byte[] { 0x74, (byte)0xa1, (byte)0xf0 };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\uff07";
      bytes = new byte[] { (byte)0xfc, (byte)0xfd };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
      str = "\u6657\u7d71\u67ff";
      bytes = new byte[] {
        (byte)0xfa, (byte)0xbc, (byte)0xc5, (byte)0xfd,
        (byte)0xb3, (byte)0xc1,
      };
      TestCommon.AssertByteArraysEqual(
        bytes,
        Encodings.EncodeToBytes(str, charset));
    }
  }
}
