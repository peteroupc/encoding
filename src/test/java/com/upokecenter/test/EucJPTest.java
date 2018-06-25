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
bytes = new byte[] { 0x3c, 0x45, (byte)0xb9, (byte)0xdf, (byte)0xbb, 0x7b };
str = "<E\u964d\ufffd\u007b";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9c, (byte)0x9e, 0x4b, 0x26, (byte)0xd2, 0x0b,
  0x32, 0x6d, 0x60, (byte)0xec, 0x7f, 0x24, (byte)0x83, 0x2c, 0x76, 0x0f };
str = "\ufffd\ufffdK&\ufffd\u000b2m`\ufffd\u007f$\ufffd\u002cv\u000f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd9, (byte)0x8e, 0x63, 0x3f, (byte)0x8e, 0x45,
  0x7f, 0x06, 0x2a, (byte)0xac, 0x13, (byte)0x9f, (byte)0xa3, 0x44,
  (byte)0xac, (byte)0x84, 0x04 };
str = "\ufffdc?\ufffdE\u007f\u0006*\ufffd\u0013\ufffd\ufffdD\ufffd\u0004";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5c, (byte)0xea, 0x4a, (byte)0xff, (byte)0x9a,
  (byte)0xc1, (byte)0xc8, (byte)0xf2, 0x7c, 0x48, (byte)0xcc, (byte)0xd1,
  (byte)0x95, (byte)0xfd, (byte)0xa6, 0x57, 0x43 };
str = "\\\ufffdJ\ufffd\ufffd\u7d44\ufffd|H\u5984\ufffd\ufffdWC";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xfc, 0x07, (byte)0x85, (byte)0xb8, 0x0a, 0x74,
  0x48, 0x55, (byte)0xb5, 0x5f };
str = "\ufffd\u0007\ufffd\ufffd\u000atHU\ufffd_";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x00, 0x52, 0x11, (byte)0xcc, (byte)0xa3, (byte)0xc4,
  0x2b, 0x35, 0x3e, 0x67, (byte)0xb8, (byte)0xcd, 0x64, (byte)0xf5, 0x32,
  0x2a, (byte)0xe6, (byte)0x85, 0x46, (byte)0xc4, 0x3b, 0x60, 0x5b,
  (byte)0x80 };
str = "\u0000R\u0011\u5473\ufffd+5>g\u6238d\ufffd2*\ufffdF\ufffd;`[\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4a, 0x7b, (byte)0xec, (byte)0xe6, (byte)0xaf, 0x20,
  (byte)0xb2, 0x4e, (byte)0x8a, 0x66 };
str = "J\u007b\u8dbe\ufffd \ufffdN\ufffdf";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x77, 0x27, 0x36, 0x55, 0x02, 0x11, (byte)0x89,
  (byte)0xa7, 0x37, 0x44, 0x3e, 0x16, 0x56, (byte)0xbf, 0x7a, 0x52, 0x21,
  0x23, (byte)0xc9, 0x37, (byte)0xb0, 0x10, 0x3c, (byte)0xd7, (byte)0x86,
  (byte)0xd3, 0x30, (byte)0xf8, (byte)0x84, 0x77 };
str =

  "w'6U\u0002\u0011\ufffd\ufffd7D>\u0016V\ufffdzR!#\ufffd7\ufffd\u0010<\ufffd\ufffd0\ufffdw";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9c, 0x04, (byte)0xd1, (byte)0xf9, 0x14, 0x6b,
  (byte)0x9a, (byte)0xc3, 0x25, 0x56, (byte)0xb3, 0x1e, (byte)0xca, 0x7f,
  0x0d, 0x46, 0x2a, (byte)0xad, 0x7f, (byte)0xb4 };
str =

  "\ufffd\u0004\u5294\u0014k\ufffd\ufffd%V\ufffd\u001e\ufffd\u007f\u000dF*\ufffd\u007f\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb5, (byte)0xdc, (byte)0xd1, 0x7b, 0x42, 0x4e,
  (byte)0xf8, 0x4c, (byte)0xcc };
str = "\u5bae\ufffd\u007bBN\ufffdL\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7e, 0x43, 0x72, 0x6b, 0x11, 0x14, (byte)0xd8,
  (byte)0x90, (byte)0xd0, 0x28, 0x26, (byte)0xe9, (byte)0xcd, 0x70,
  (byte)0x94, 0x43, (byte)0xba, 0x17, (byte)0xf8, 0x40, 0x3e, (byte)0xe7,
  0x62, (byte)0xdb, 0x28, 0x6f };
str =

  "~Crk\u0011\u0014\ufffd\ufffd(&\u8671p\ufffdC\ufffd\u0017\ufffd@>\ufffdb\ufffd(o";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xff, 0x04 };
str = "\ufffd\u0004";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x72, (byte)0xf8, (byte)0xc1, (byte)0xef, 0x5b, 0x6f,
  (byte)0xf8, (byte)0xfd, 0x08, 0x1d, (byte)0xb8, 0x28, (byte)0xe0, 0x1d,
  0x3e, 0x52, 0x18, (byte)0xd3 };
str = "r\ufffd\ufffd[o\ufffd\u0008\u001d\ufffd(\ufffd\u001d>R\u0018\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x18, 0x0c, 0x04, 0x1b, 0x61 };
str = "\u0018\u000c\u0004\u001ba";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5c, (byte)0xee, (byte)0xd4, 0x6f, (byte)0x97, 0x63,
  0x3d, 0x44, (byte)0xdf, 0x4a };
str = "\\\u91b4o\ufffdc=D\ufffdJ";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2f, 0x50, (byte)0xcd, (byte)0x99, 0x24, 0x5a,
  (byte)0xe6, (byte)0x85, 0x48, 0x0c, 0x19, 0x5e, (byte)0x85, (byte)0xb8,
  0x70 };
str = "/P\ufffd$Z\ufffdH\u000c\u0019^\ufffd\ufffdp";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x25, (byte)0xaa, 0x41, 0x60, (byte)0xfd, 0x68, 0x5e,
  (byte)0xb9, (byte)0xd7, 0x19, 0x02, 0x47, (byte)0x94, (byte)0xb9, 0x26,
  0x55, (byte)0xa7, 0x1e };
str = "%\ufffdA`\ufffdh^\u8ca2\u0019\u0002G\ufffd\ufffd&U\ufffd\u001e";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2d, (byte)0xab, 0x31, 0x74, (byte)0x87, (byte)0x8c,
  0x41, 0x63, (byte)0xf3 };
str = "-\ufffd1t\ufffd\ufffdAc\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9d, 0x7d, 0x5a, 0x7a, 0x55, (byte)0xc7, 0x43,
  0x37, 0x69 };
str = "\ufffd}ZzU\ufffdC7i";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x32, 0x61, (byte)0xdc, 0x5d, 0x44, (byte)0xdb,
  (byte)0x86, (byte)0x84, 0x31, (byte)0x9d, (byte)0x85, (byte)0x93,
  (byte)0xb5, 0x41, 0x70, (byte)0x97 };
str = "2a\ufffd]D\ufffd\ufffd1\ufffd\ufffd\ufffd\ufffdAp\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf8, (byte)0xb5, 0x48, 0x77, 0x20, (byte)0xa2,
  0x14, 0x60, (byte)0x9f, 0x5a, 0x04, 0x59, (byte)0xb3, 0x1b, 0x42, 0x17,
  0x0a, (byte)0xf8, (byte)0x8e, (byte)0xa1, (byte)0xa6, 0x3b };
str =
  "\ufffdHw \ufffd\u0014`\ufffdZ\u0004Y\ufffd\u001bB\u0017\u000a\ufffd\u30fb;";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x31, 0x6d, (byte)0x82, 0x53 };
str = "1m\ufffdS";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb7, (byte)0xd8, 0x5b, 0x32, 0x68, 0x36, 0x43,
  0x32, 0x77, 0x7a, 0x0b, (byte)0xf3, 0x7c, (byte)0x90, (byte)0xb4,
  (byte)0xb5, 0x74, 0x6d, 0x4f, (byte)0xf2, (byte)0xcc, 0x60, 0x74, 0x3a,
  0x56 };
str = "\u8a63[2h6C2wz\u000b\ufffd|\ufffd\u60a3tmO\u9be1`t:V";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x14, 0x45, 0x33, (byte)0xec, 0x4c, 0x25 };
str = "\u0014E3\ufffdL%";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x73, (byte)0xc2, 0x4a, (byte)0xc9, 0x68, 0x5b,
  (byte)0xd9, (byte)0xfd, 0x7d, (byte)0x94, 0x2a, 0x59, (byte)0xfd,
  (byte)0xc7, 0x52, 0x4f, (byte)0x97, (byte)0xfa };
str = "s\ufffdJ\ufffdh[\u6488}\ufffd*Y\ufffdRO\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x56, (byte)0xda, 0x34, 0x02, (byte)0xcd, 0x5d, 0x22,
  0x72, (byte)0x87, 0x41, 0x6c, 0x36, 0x3d, (byte)0xe3, (byte)0xcf,
  (byte)0xe7, 0x7b, 0x45, 0x01, (byte)0xa2, (byte)0x9e, 0x4a, 0x53 };
str = "V\ufffd4\u0002\ufffd]\"r\ufffdAl6=\u7a57\ufffd\u007bE\u0001\ufffdJS";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x08, 0x68, 0x7c, 0x23, (byte)0xd7, 0x37 };
str = "\u0008h|#\ufffd7";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x08, 0x58, (byte)0x82, (byte)0x95, (byte)0xf1,
  (byte)0xee, 0x3a, 0x13, (byte)0x90 };
str = "\u0008X\ufffd\ufffd\u9abc:\u0013\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd7, 0x25, (byte)0xe6, 0x2f, 0x6a, (byte)0xe7,
  (byte)0x84, (byte)0xe6, 0x23, 0x1f, (byte)0xd1, 0x6c, 0x6b, 0x36, 0x3b,
  0x58, (byte)0xe8, 0x6b, (byte)0xef, 0x02, (byte)0x96, (byte)0x8c };
str =

  "\ufffd%\ufffd/j\ufffd\ufffd#\u001f\ufffdlk6;X\ufffdk\ufffd\u0002\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x39, 0x7b, (byte)0xd8, (byte)0x92, (byte)0xf8, 0x4d,
  0x1e, 0x3a, (byte)0xf6, 0x02, (byte)0x88, 0x54, 0x38 };
str = "9\u007b\ufffd\ufffdM\u001e:\ufffd\u0002\ufffdT8";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x03, (byte)0xe4, (byte)0xac, 0x37, (byte)0x88, 0x69,
  (byte)0xae, (byte)0xdd, 0x0e, (byte)0xdb, 0x78, (byte)0xe5, 0x61, 0x74,
  0x61, 0x36 };
str = "\u0003\u7b717\ufffdi\ufffd\u000e\ufffdx\ufffdata6";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9d, 0x26, (byte)0xc4, 0x3e, (byte)0xeb,
  (byte)0xdd, 0x42, (byte)0xa1, 0x0c };
str = "\ufffd&\ufffd>\u8aebB\ufffd\u000c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x38, 0x29 };
str = "8)";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7e, 0x48, 0x33, (byte)0xcc, 0x4c, 0x48, (byte)0xc8,
  (byte)0xa5, (byte)0xda, 0x2b, 0x55, 0x4d, (byte)0xbe, 0x4a, (byte)0xab,
  0x36, 0x34, (byte)0xc9, 0x7a, (byte)0xac, (byte)0xa0, 0x50, (byte)0x88,
  (byte)0x9b, (byte)0xb4, 0x7c, 0x5c };
str =

  "~H3\ufffdLH\u8087\ufffd+UM\ufffdJ\ufffd64\ufffdz\ufffdP\ufffd\ufffd\ufffd|\\";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x42, (byte)0xda, 0x3f, (byte)0xc1, 0x37, 0x53,
  (byte)0xef, (byte)0xe7, (byte)0xed };
str = "B\ufffd?\ufffd7S\u95be\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x1c, 0x24, 0x5c, 0x5c, 0x1b, (byte)0xe1, 0x2f,
  (byte)0xed, 0x7d, (byte)0xff, 0x55, 0x22, 0x47, 0x7e, 0x6b, (byte)0xcc,
  (byte)0xd4, 0x3c, (byte)0xd6, 0x5b, 0x0f, 0x64 };
str = "\u001c$\\\\\u001b\ufffd/\ufffd}\ufffdU\"G~k\u731b<\ufffd[\u000fd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xca, 0x78, 0x27, (byte)0xdd, 0x0b, (byte)0x90,
  0x3a, (byte)0xf2, 0x24, 0x71, 0x08, 0x18, (byte)0x92, (byte)0xb4, 0x67,
  (byte)0xbb, (byte)0x89, 0x60, (byte)0xc2, 0x48, (byte)0xe7, (byte)0xe1,
  (byte)0xbf, 0x77 };
str =

  "\ufffdx'\ufffd\u000b\ufffd:\ufffd$q\u0008\u0018\ufffd\ufffdg\ufffd`\ufffdH\u8268\ufffdw";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x45, (byte)0x82, 0x3a, 0x7d };
str = "E\ufffd:}";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdd, 0x25, (byte)0xa1, (byte)0xa4, 0x5f,
  (byte)0xbc, 0x3f, 0x5d, 0x01, (byte)0xea, 0x06 };
str = "\ufffd%\uff0c_\ufffd?]\u0001\ufffd\u0006";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xc7, 0x40, (byte)0xd8, (byte)0xa9, 0x4a, 0x0a,
  0x6c, 0x3c, 0x3d, 0x31, (byte)0x89, (byte)0xef, 0x31, 0x6f, 0x63, 0x21,
  0x37, (byte)0xb7, 0x7b, 0x1b, (byte)0xc1, (byte)0xc8, 0x2a, 0x4b, 0x58,
  (byte)0xe4, (byte)0xf6, 0x4a, (byte)0xf0, (byte)0x87 };
str =

  "\ufffd@\u60b8J\u000al<= 1\ufffd\ufffd1oc!7\ufffd\u007b\u001b\u7d44*KX\u7cdcJ\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x62, (byte)0x91, (byte)0xc5, 0x52, 0x74, (byte)0xf0,
  0x2a, 0x23, (byte)0xa6, 0x53, 0x76, (byte)0xf6, 0x5a, 0x6b, (byte)0x86 };
str = "b\ufffd\ufffdRt\ufffd*#\ufffdSv\ufffdZk\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x32, 0x4c, 0x4d, 0x7f, (byte)0xb6, (byte)0xf7, 0x0a,
  0x35, (byte)0xb4, (byte)0xcd, (byte)0xea, (byte)0xc0, 0x1f, 0x53, 0x53,
  (byte)0xe5, (byte)0xd1, (byte)0xdf, 0x3b, 0x7d, 0x55, 0x10, 0x19 };
str = "2LM\u007f\u5bd3\u000a5\u7ff0\u8815\u001fSS\u7e23\ufffd;}U\u0010\u0019";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x44, 0x5f, (byte)0x8b };
str = "D_\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x65, (byte)0x9a, (byte)0xc1 };
str = "e\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdc, 0x69, 0x3c, 0x1a, (byte)0xda, 0x6c, 0x26,
  0x61 };
str = "\ufffdi<\u001a\ufffdl&a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa7, (byte)0xb7, 0x61 };
str = "\u0425a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x8d, 0x10, 0x76, 0x7e, 0x7c, (byte)0xf5, 0x21,
  (byte)0xb1, (byte)0xc9, 0x1b, (byte)0x84, 0x62, 0x21, (byte)0xc8,
  (byte)0xc6 };
str = "\ufffd\u0010v~|\ufffd!\u6804\u001b\ufffdb!\u6c4e";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xac, 0x42, (byte)0xe6, (byte)0xbe, 0x59, 0x06,
  (byte)0x90, 0x2d, (byte)0x92, 0x18, (byte)0xd9, 0x73, 0x72, 0x5e, 0x0f,
  0x20 };
str = "\ufffdB\u7faeY\u0006\ufffd-\ufffd\u0018\ufffdsr^\u000f ";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2d, 0x6d, 0x66, 0x1b, (byte)0xfc, 0x57, (byte)0xeb,
  (byte)0xa0, 0x50, 0x05, 0x75, 0x75, 0x27, (byte)0xf3, (byte)0xae, 0x69,
  0x1b, (byte)0x99, 0x37, 0x44 };
str = "-mf\u001b\ufffdW\ufffdP\u0005uu'\u9da4i\u001b\ufffd7D";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa6, (byte)0x95, 0x5d, 0x60, 0x6b, (byte)0x9a,
  0x69 };
str = "\ufffd]`k\ufffdi";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4c, 0x77, (byte)0xee, (byte)0xf3, 0x4a, (byte)0xff,
  (byte)0xc8, (byte)0xf7, 0x2a, 0x3f, (byte)0xf6, (byte)0xb1, 0x10, 0x72,
  0x5d, 0x50, 0x3a, 0x63, 0x76, (byte)0xc4, (byte)0xff, (byte)0x87 };
str = "Lw\u9296J\ufffd\u5099*?\ufffd\u0010r]P:cv\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9d, (byte)0xdb, (byte)0x98, (byte)0xe9, 0x29,
  0x06, (byte)0xc9, 0x73, 0x3b, 0x31, (byte)0xae, (byte)0xde, (byte)0xdb };
str = "\ufffd\ufffd\ufffd)\u0006\ufffds;1\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4c, (byte)0x8d, (byte)0x86, (byte)0xad, (byte)0xce,
  0x27, (byte)0xab, (byte)0xec, 0x52, (byte)0xe4, (byte)0x86, 0x7d,
  (byte)0xa7, 0x48, (byte)0xd5, (byte)0xc3, (byte)0xba, 0x18, (byte)0xb0,
  0x07, 0x7b, 0x45, (byte)0x93 };
str =

  "L\ufffd\ufffd\u334a'\ufffdR\ufffd}\ufffdH\u5ae6\ufffd\u0018\ufffd\u0007\u007bE\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe1, (byte)0x82, (byte)0xcf, 0x74 };
str = "\ufffd\ufffdt";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x31, (byte)0xda };
str = "1\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6b, (byte)0xca, (byte)0xbf, 0x34, 0x29, (byte)0xc8,
  0x16, 0x16, (byte)0x9d, 0x06, (byte)0x88, 0x7a, (byte)0xed, 0x28,
  (byte)0xe2, 0x3f, 0x6d, (byte)0xb2, (byte)0xa7, (byte)0xda, 0x5a, 0x4e,
  0x29, 0x09, 0x5c, (byte)0xc1, (byte)0xa6, 0x26, (byte)0xfe, (byte)0xa2 };
str =

  "k\u5e734)\ufffd\u0016\u0016\ufffd\u0006\ufffdz\ufffd(\ufffd?m\u7fc1\ufffdZN)\u0009\\\u85a6&\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdd, 0x5a, (byte)0xff, (byte)0x9c, 0x0f, 0x70,
  (byte)0xe0, (byte)0xc7, (byte)0xee, (byte)0xa1, 0x40, 0x15, 0x62, 0x1d,
  (byte)0x9a, (byte)0x91 };
str = "\ufffdZ\ufffd\ufffd\u000fp\u500f\u904f@\u0015b\u001d\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xba };
str = "\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf9, (byte)0x84, (byte)0xf9, (byte)0x82,
  (byte)0xd0, 0x04, 0x62, 0x35, 0x5a, 0x3b, (byte)0x80, (byte)0x80,
  (byte)0x85, 0x49, 0x28, 0x70, (byte)0xcc, (byte)0x8f, 0x50, (byte)0xd4,
  0x2e, 0x6e, (byte)0x83, 0x1b, (byte)0xd8, 0x6b };
str =

  "\ufffd\ufffd\ufffd\u0004b5Z;\ufffd\ufffd\ufffdI(p\ufffdP\ufffd.n\ufffd\u001b\ufffdk";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe8, (byte)0xe2, 0x23, (byte)0xfc, 0x54,
  (byte)0xd8, (byte)0xa3, (byte)0xcf, (byte)0xa9, 0x00, (byte)0x8d, 0x79,
  (byte)0xea, 0x4c, 0x62, (byte)0xf6, (byte)0x8b };
str = "\u8435#\ufffdT\u6096\u8def\u0000\ufffdy\ufffdLb\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x20, 0x2d, (byte)0xd6, 0x4d, 0x38, 0x5a, 0x12,
  (byte)0xc9, 0x2e, 0x65, 0x2b, 0x54, (byte)0x8e };
str = " -\ufffdM8Z\u0012\ufffd.e+T\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3d, 0x46, (byte)0xc4, 0x0e, 0x39, (byte)0xc0, 0x22,
  (byte)0xf8, 0x43, 0x65, (byte)0xa8, 0x5c, (byte)0xdc, 0x41, 0x0d,
  (byte)0xe6, 0x0d, (byte)0xf1, 0x69, 0x56, 0x22, (byte)0xec, (byte)0xb3 };
str =

  "=F\ufffd\u000e9\ufffd\"\ufffdCe\ufffd\\\ufffdA\u000d\ufffd\u000d\ufffdiV\"\u8c4e";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x25, 0x5f, (byte)0x86, 0x1b, (byte)0xe6, (byte)0x9d,
  0x5d, 0x77, (byte)0x9a, (byte)0xe2, 0x1d, (byte)0x8c, 0x30, 0x34,
  (byte)0xeb, 0x2c, 0x2e, (byte)0xa5, (byte)0xf0, 0x34, (byte)0x9d, 0x5a,
  (byte)0x9d };
str =

  "%_\ufffd\u001b\ufffd]w\ufffd\ufffd\u001d\ufffd04\ufffd\u002c.\u30f04\ufffdZ\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xab, 0x36, (byte)0xc7, 0x69, (byte)0xc2, 0x5c,
  0x0b, (byte)0x9a, (byte)0xb2, 0x4b, 0x34, 0x32, (byte)0xa9, 0x42, 0x73,
  (byte)0xc0, 0x46, (byte)0xbc, 0x1b, 0x6e, 0x35, 0x42, 0x24, (byte)0x9e,
  (byte)0xbb, 0x29, (byte)0x8d, (byte)0xe0, (byte)0xb2, (byte)0xe5 };
str =

  "\ufffd6\ufffdi\ufffd\\\u000b\ufffd\ufffdK42\ufffdBs\ufffdF\ufffd\u001bn5B$\ufffd\ufffd)\ufffd\u7274\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdf, 0x70, (byte)0xbc, 0x78, 0x4f, 0x08, 0x3c,
  0x4f, (byte)0xc3 };
str = "\ufffdp\ufffdxO\u0008<O\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x64, 0x56, (byte)0x99, 0x36, 0x37, 0x5f, 0x3a, 0x3c,
  (byte)0xd2, (byte)0xc6, (byte)0xa7, (byte)0xbf, (byte)0xd0 };
str = "dV\ufffd67_:<\u535e\u042d\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x40, 0x53, (byte)0xd8, (byte)0xe1, 0x4d, 0x35, 0x1f,
  0x6c, 0x39, (byte)0x9d };
str = "@S\u6191M5\u001fl9\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb9, 0x4e, (byte)0xd5, 0x67, 0x21, 0x73,
  (byte)0x8e, 0x47, (byte)0xbd, (byte)0xcc, (byte)0x92, 0x6e, (byte)0xbc,
  (byte)0xeb, 0x36 };
str = "\ufffdN\ufffdg!s\ufffdG\u7e2e\ufffdn\u67316";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x95, 0x3d, (byte)0xf9, 0x65, 0x22, 0x6f, 0x23,
  0x44, 0x13, (byte)0x9c };
str = "\ufffd=\ufffde\"o#D\u0013\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb6, 0x75, 0x34, (byte)0xac, (byte)0xe6,
  (byte)0xea, (byte)0xb9, 0x7f, (byte)0x8c, 0x50, (byte)0x96, 0x5d, 0x51,
  0x51, 0x60, 0x6b, 0x25, (byte)0xc6, 0x79, (byte)0xc9, 0x78, 0x40,
  (byte)0x84, (byte)0x9d };
str =
  "\ufffdu4\ufffd\u87fe\u007f\ufffdP\ufffd]QQ`k%\ufffdy\ufffdx@\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa1, (byte)0xc6, (byte)0xa2, (byte)0xfa, 0x22,
  (byte)0xae, (byte)0xed, (byte)0xc5, 0x65, 0x56, 0x50, (byte)0xdc, 0x25,
  0x56, 0x48, (byte)0x92, (byte)0xec, 0x55, 0x38, 0x0e, 0x07, 0x6e, 0x15,
  0x49, 0x5f, (byte)0xa6 };
str =

  "\u2018\ufffd\"\ufffd\ufffdeVP\ufffd%VH\ufffd\ufffdU8\u000e\u0007n\u0015I_\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x40, (byte)0xd2, (byte)0xbd };
str = "@\u5333";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x26, (byte)0xaa, 0x5f, 0x12, 0x3d, (byte)0xc0,
  (byte)0xff, 0x6d, (byte)0x87, (byte)0xfe, 0x59, 0x41, 0x36, 0x0a,
  (byte)0xb6, 0x3b, 0x37, 0x5b, (byte)0xd6, 0x0f, (byte)0xe8 };
str = "&\ufffd_\u0012=\ufffdm\ufffd\ufffdYA6\u000a\ufffd;7[\ufffd\u000f\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x54, 0x09, 0x7c, (byte)0xf5, (byte)0xae, (byte)0x86,
  (byte)0xa3, 0x2f, 0x73 };
str = "T\u0009|\ufffd\ufffd\ufffd/s";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa6, 0x1c, 0x51, (byte)0xad, 0x22, (byte)0xc6,
  0x4c, (byte)0xc6, 0x7e, (byte)0x9e, (byte)0x9f, 0x17, 0x62 };
str = "\ufffd\u001cQ\ufffd\"\ufffdL\ufffd~\ufffd\ufffd\u0017b";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x25, 0x7a, 0x4c, 0x4f, (byte)0xe6, (byte)0x92, 0x68,
  (byte)0xa8, (byte)0xf3, 0x30, (byte)0xd7, (byte)0xf7, 0x55, (byte)0xa4,
  (byte)0xe0, (byte)0xad, (byte)0x9c, 0x09, (byte)0xfd, 0x53, (byte)0xdb,
  0x6c };
str = "%zLO\ufffdh\ufffd0\u606cU\u3080\ufffd\u0009\ufffdS\ufffdl";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x21, (byte)0x88, (byte)0xa6, 0x7f, 0x47, (byte)0xf3,
  (byte)0xda, 0x37, 0x3e, 0x41, 0x2c, 0x49, 0x4e, (byte)0xbb, 0x50,
  (byte)0xbf, 0x1a, (byte)0xc6, (byte)0xd8, (byte)0x99 };
str = "!\ufffd\ufffd\u007fG\u9ede7>A\u002cIN\ufffdP\ufffd\u001a\u6566\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x20, (byte)0xfa, (byte)0xfc, 0x37, 0x03, 0x61,
  (byte)0xbb, 0x4e, 0x5e, (byte)0xb3, 0x74, (byte)0xa4, 0x47, (byte)0xca,
  0x53, (byte)0xd3, (byte)0xb1, (byte)0xc4, (byte)0xd9, 0x4b, 0x11, 0x44,
  (byte)0x81, 0x42 };
str = " \u71c17\u0003a\ufffdN^\ufffdt\ufffdG\ufffdS\u5540\u6f70K\u0011D\ufffdB";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x97, 0x1d, 0x4e, 0x7d, (byte)0x98, 0x60, 0x24,
  (byte)0xa6, 0x55, 0x3a };
str = "\ufffd\u001dN}\ufffd`$\ufffdU:";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xae, (byte)0xdb };
str = "\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x34 };
str = "4";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x21, (byte)0xfa, (byte)0xe7, (byte)0xe0, 0x76, 0x05,
  (byte)0xf8, (byte)0xdd };
str = "!\u6df2\ufffdv\u0005\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xae, 0x28, 0x5a, (byte)0xcd, (byte)0x95, 0x40,
  (byte)0xac, (byte)0xea, (byte)0x85, (byte)0x8c, 0x0e, 0x17, 0x6d, 0x74,
  0x1e };
str = "\ufffd(Z\ufffd@\ufffd\ufffd\ufffd\u000e\u0017mt\u001e";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9b };
str = "\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x77, 0x3d, (byte)0xb8, (byte)0xd1, (byte)0xb6, 0x1e,
  0x28, (byte)0xeb, (byte)0xae, 0x06, (byte)0xc5, 0x66, 0x26, 0x25, 0x7b,
  (byte)0xab, 0x12, (byte)0x86, 0x47, (byte)0x87 };
str =
  "w=\u72d0\ufffd\u001e(\u89a1\u0006\ufffdf&%\u007b\ufffd\u0012\ufffdG\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6e, 0x52, (byte)0xc3, 0x57, (byte)0xb5, (byte)0xba,
  0x76, (byte)0x8b, 0x3b, 0x51, (byte)0xb8, 0x57, 0x12, 0x4f, 0x3d,
  (byte)0x8e, 0x4a, 0x2b, (byte)0xda, 0x4b, 0x5e, 0x5b };
str = "nR\ufffdW\u622fv\ufffd;Q\ufffdW\u0012O=\ufffdJ+\ufffdK^[";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xcf, 0x28, (byte)0xf6, (byte)0xfe, 0x78,
  (byte)0xb9, (byte)0xef, (byte)0xa9, 0x67, 0x43, 0x26, (byte)0xf6, 0x0e,
  0x31, (byte)0xd5, 0x35, (byte)0x93, (byte)0x90 };
str = "\ufffd(\ufffdx\u523b\ufffdgC&\ufffd\u000e1\ufffd5\ufffd\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7b, 0x0f, 0x0c, 0x45, (byte)0xed, 0x35, 0x4b, 0x52,
  0x79, 0x49, 0x01, (byte)0xb3, (byte)0xc6, 0x36, 0x03, (byte)0x8e, 0x72,
  (byte)0xfd, (byte)0x8a, (byte)0x83, (byte)0x80, 0x2e, 0x74, (byte)0xe4,
  0x6d, 0x7e, 0x1b, 0x6f };
str =

  "\u007b\u000f\u000cE\ufffd5KRyI\u0001\u54046\u0003\ufffdr\ufffd\ufffd\ufffd.t\ufffdm~\u001bo";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbd, (byte)0x90, 0x42, (byte)0x96 };
str = "\ufffdB\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb2, 0x61, 0x53, (byte)0x92, (byte)0xa7, 0x56,
  0x72, 0x49, 0x7b, (byte)0xe3, 0x3d, (byte)0x86, 0x67, (byte)0x86, 0x44,
  (byte)0xca, 0x2f, (byte)0xa4, 0x5b };
str = "\ufffdaS\ufffd\ufffdVrI\u007b\ufffd=\ufffdg\ufffdD\ufffd/\ufffd[";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2a, 0x45, (byte)0xda, 0x35, (byte)0xfe, 0x79,
  (byte)0xbb, 0x48, 0x04, (byte)0xb5, 0x61, (byte)0x82, 0x0f, 0x58, 0x5b,
  0x76, 0x3f, 0x5d, (byte)0xc1, (byte)0xcd, 0x59, 0x78, 0x34, 0x57, 0x26 };
str = "*E\ufffd5\ufffdy\ufffdH\u0004\ufffda\ufffd\u000fX.get(v?)\u9f20Yx4W&";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbb, (byte)0xc0, 0x7b, 0x47, 0x0c, 0x5c,
  (byte)0xac, (byte)0xc7, 0x51, 0x7b, 0x73, 0x38 };
str = "\u9178\u007bG\u000c\\\ufffdQ\u007bs8";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4d, 0x46, 0x35, 0x38, 0x34, (byte)0x8c, (byte)0xfd,
  (byte)0xed, 0x65, (byte)0xd4, 0x29, 0x67, (byte)0x8d, 0x3e, 0x18,
  (byte)0xb7, 0x68, 0x38 };
str = "MF584\ufffd\ufffde\ufffd)g\ufffd>\u0018\ufffdh8";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6d, 0x4d, (byte)0x82, 0x4c, 0x61, (byte)0xb0,
  (byte)0x9c, 0x12, (byte)0xf1, 0x09, 0x79, 0x67, 0x7d, 0x5c, 0x6c,
  (byte)0x87, (byte)0xfc, 0x66, (byte)0xb9, (byte)0x91, 0x4b, 0x05,
  (byte)0xa8, 0x58, 0x3b, 0x2d, (byte)0xd0 };
str =

  "mM\ufffdLa\ufffd\u0012\ufffd\u0009yg}\\l\ufffd\ufffdf\ufffdK\u0005\ufffdX;-\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5e, (byte)0xe8 };
str = "^\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x36 };
str = "6";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xda, (byte)0xb4, 0x7e, (byte)0x99, (byte)0xfd,
  (byte)0xeb, (byte)0xb2, (byte)0xd7 };
str = "\u64fa~\ufffd\ufffd\u82db";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xbb, (byte)0xdc, (byte)0xbb, (byte)0xea,
  (byte)0x8c, 0x71, (byte)0xb2, (byte)0x92, 0x4c, (byte)0x9c, 0x42, 0x21,
  0x44, 0x51, (byte)0xf3, (byte)0xf8, 0x33 };
str = "\u65bd\u81f3\ufffdq\ufffdL\ufffdB!DQ\u9f6a3";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x90, 0x2e, 0x61, (byte)0xe1, 0x19, 0x42, 0x6b,
  0x29, 0x56, 0x15, (byte)0xef, (byte)0xe6, 0x04, (byte)0xac, (byte)0xac,
  0x6f, 0x78, (byte)0xf3, 0x23, 0x2c, (byte)0xd7 };
str = "\ufffd.a\ufffd\u0019Bk)V\u0015\u95b9\u0004\ufffdox\ufffd#\u002c\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x04, 0x62, 0x2b, 0x3e, 0x3a, (byte)0xd2, (byte)0xe0,
  (byte)0xf5, (byte)0xa0, (byte)0xf3, (byte)0x90, (byte)0xd6, 0x44, 0x00,
  0x73, 0x3c, 0x25, (byte)0xea, 0x52, (byte)0xa7, (byte)0xed, (byte)0xb0,
  0x6f };
str = "\u0004b+>:\u5440\ufffd\ufffd\ufffdD\u0000s<%\ufffdR\u044b\ufffdo";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
}@Test
public void TestEucJPEncoder() {
byte[] bytes;
String str;
ICharacterEncoding charset = Encodings.GetEncoding("euc-jp");
str = "\u6d35\uff1d";
bytes = new byte[] { (byte)0xde, (byte)0xad, (byte)0xa1, (byte)0xe1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff10\u7155\u57df";
bytes = new byte[] { (byte)0xa3, (byte)0xb0, (byte)0xdf, (byte)0xe6,
  (byte)0xb0, (byte)0xe8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6cd3\uff34\uff81";
bytes = new byte[] { (byte)0xdd, (byte)0xf7, (byte)0xa3, (byte)0xd4,
  (byte)0x8e, (byte)0xc1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5370\u6247\uff71";
bytes = new byte[] { (byte)0xb0, (byte)0xf5, (byte)0xc0, (byte)0xf0,
  (byte)0x8e, (byte)0xb1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7b11\uff6b\u56a5";
bytes = new byte[] { (byte)0xbe, (byte)0xd0, (byte)0x8e, (byte)0xab,
  (byte)0xd3, (byte)0xeb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe0\u6e6f\uff7b";
bytes = new byte[] { (byte)0xa1, (byte)0xf1, (byte)0xc5, (byte)0xf2,
  (byte)0x8e, (byte)0xbb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5d";
bytes = new byte[] { (byte)0xa1, (byte)0xd1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "v";
bytes = new byte[] { 0x76 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7368\uff94\u000a";
bytes = new byte[] { (byte)0xe0, (byte)0xd7, (byte)0x8e, (byte)0xd4, 0x0a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4a\uff57\u7c8d";
bytes = new byte[] { (byte)0xa3, (byte)0xea, (byte)0xa3, (byte)0xf7,
  (byte)0xcc, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff54p\uff2b";
bytes = new byte[] { (byte)0xa3, (byte)0xf4, 0x70, (byte)0xa3, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u57cb\u51f1\u2520";
bytes = new byte[] { (byte)0xcb, (byte)0xe4, (byte)0xb3, (byte)0xae,
  (byte)0xa8, (byte)0xb7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff62\u7ac3";
bytes = new byte[] { (byte)0x8e, (byte)0xa2, (byte)0xb3, (byte)0xf6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u91aa\u7f67\u53d9";
bytes = new byte[] { (byte)0xee, (byte)0xd2, (byte)0xe6, (byte)0xae,
  (byte)0xbd, (byte)0xf6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5d";
bytes = new byte[] { (byte)0xa1, (byte)0xd1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u65c6\uff2c\uff86";
bytes = new byte[] { (byte)0xda, (byte)0xd4, (byte)0xa3, (byte)0xcc,
  (byte)0x8e, (byte)0xc6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff07";
bytes = new byte[] { (byte)0xfc, (byte)0xfd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u643e\uff25\u64d8";
bytes = new byte[] { (byte)0xba, (byte)0xf1, (byte)0xa3, (byte)0xc5,
  (byte)0xda, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5d15\u52f3\uff35";
bytes = new byte[] { (byte)0xd6, (byte)0xbd, (byte)0xd2, (byte)0xae,
  (byte)0xa3, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u000a\u5b3e\uff10";
bytes = new byte[] { 0x0a, (byte)0xd5, (byte)0xcf, (byte)0xa3, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6766";
bytes = new byte[] { (byte)0xfa, (byte)0xc7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u53d9";
bytes = new byte[] { (byte)0xbd, (byte)0xf6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u60df";
bytes = new byte[] { (byte)0xb0, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u0010";
bytes = new byte[] { 0x10 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5c\uff12";
bytes = new byte[] { (byte)0xa1, (byte)0xc3, (byte)0xa3, (byte)0xb2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u848b\u88c4\u65cf";
bytes = new byte[] { (byte)0xbe, (byte)0xd5, (byte)0xea, (byte)0xe2,
  (byte)0xc2, (byte)0xb2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7b08\uff26";
bytes = new byte[] { (byte)0xb5, (byte)0xe8, (byte)0xa3, (byte)0xc6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff12";
bytes = new byte[] { (byte)0xa3, (byte)0xb2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u63a3\u6832";
bytes = new byte[] { (byte)0xd9, (byte)0xda, (byte)0xdb, (byte)0xde };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7b52";
bytes = new byte[] { (byte)0xc5, (byte)0xfb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e54\uff32\u5e9a\uff52";
bytes = new byte[] { (byte)0xbf, (byte)0xa5, (byte)0xa3, (byte)0xd2,
  (byte)0xb9, (byte)0xae, (byte)0xa3, (byte)0xf2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d72\u6ff3\u976b";
bytes = new byte[] { (byte)0xe5, (byte)0xaf, (byte)0xdf, (byte)0xab,
  (byte)0xf0, (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7166\u7fb2";
bytes = new byte[] { (byte)0xdf, (byte)0xe8, (byte)0xe6, (byte)0xbc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5f04\uff7b";
bytes = new byte[] { (byte)0xcf, (byte)0xae, (byte)0x8e, (byte)0xbb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6010\u631f\u212b";
bytes = new byte[] { (byte)0xd7, (byte)0xe1, (byte)0xb6, (byte)0xb4,
  (byte)0xa2, (byte)0xf2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff85\u67a0\u7007";
bytes = new byte[] { (byte)0x8e, (byte)0xc5, (byte)0xcf, (byte)0xc8,
  (byte)0xfa, (byte)0xf2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4e\uff63\u67a0";
bytes = new byte[] { (byte)0xa3, (byte)0xee, (byte)0x8e, (byte)0xa3,
  (byte)0xcf, (byte)0xc8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2f";
bytes = new byte[] { (byte)0xa3, (byte)0xcf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2220\uff9e";
bytes = new byte[] { (byte)0xa2, (byte)0xdc, (byte)0x8e, (byte)0xde };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff2d";
bytes = new byte[] { (byte)0xa3, (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff8b";
bytes = new byte[] { (byte)0x8e, (byte)0xcb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff79";
bytes = new byte[] { (byte)0x8e, (byte)0xb9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u722co\u6843\uff61";
bytes = new byte[] { (byte)0xe0, (byte)0xa8, 0x6f, (byte)0xc5, (byte)0xed,
  (byte)0x8e, (byte)0xa1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u51db";
bytes = new byte[] { (byte)0xd1, (byte)0xdb };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff74\u7fe6\uff2f";
bytes = new byte[] { (byte)0x8e, (byte)0xb4, (byte)0xe6, (byte)0xc8,
  (byte)0xa3, (byte)0xcf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff77";
bytes = new byte[] { (byte)0x8e, (byte)0xb7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u701d\uff3d\u7a7a\uff52\uff45\uff56";
bytes = new byte[] { (byte)0xdf, (byte)0xcd, (byte)0xa1, (byte)0xcf,
  (byte)0xb6, (byte)0xf5, (byte)0xa3, (byte)0xf2, (byte)0xa3, (byte)0xe5,
  (byte)0xa3, (byte)0xf6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff87";
bytes = new byte[] { (byte)0x8e, (byte)0xc7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5e11\uff77";
bytes = new byte[] { (byte)0xd6, (byte)0xe6, (byte)0x8e, (byte)0xb7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff01";
bytes = new byte[] { (byte)0xa1, (byte)0xaa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6d19\uff12";
bytes = new byte[] { (byte)0xde, (byte)0xac, (byte)0xa3, (byte)0xb2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "#\u5eb5\u64bc";
bytes = new byte[] { 0x23, (byte)0xb0, (byte)0xc3, (byte)0xd9, (byte)0xfe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff92";
bytes = new byte[] { (byte)0x8e, (byte)0xd2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff53";
bytes = new byte[] { (byte)0xa3, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u69a0\u5c50";
bytes = new byte[] { (byte)0xdc, (byte)0xd5, (byte)0xd6, (byte)0xa1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2503\uff32\uff1c";
bytes = new byte[] { (byte)0xa8, (byte)0xad, (byte)0xa3, (byte)0xd2,
  (byte)0xa1, (byte)0xe3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2235";
bytes = new byte[] { (byte)0xa2, (byte)0xe8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6199";
bytes = new byte[] { (byte)0xd8, (byte)0xda };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u589c\u533f\uff0e";
bytes = new byte[] { (byte)0xc4, (byte)0xc6, (byte)0xc6, (byte)0xbf,
  (byte)0xa1, (byte)0xa5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5f7c\uff87\uff96";
bytes = new byte[] { (byte)0xc8, (byte)0xe0, (byte)0x8e, (byte)0xc7,
  (byte)0x8e, (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7faf\u7ac7\u6548\uff96";
bytes = new byte[] { (byte)0xe6, (byte)0xbb, (byte)0xe3, (byte)0xe5,
  (byte)0xda, (byte)0xc3, (byte)0x8e, (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u75fe\uff0a\uff0b\u5f99";
bytes = new byte[] { (byte)0xe1, (byte)0xde, (byte)0xa1, (byte)0xf6,
  (byte)0xa1, (byte)0xdc, (byte)0xd7, (byte)0xd0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff96\uff7f\uff06\u780c";
bytes = new byte[] { (byte)0x8e, (byte)0xd6, (byte)0x8e, (byte)0xbf,
  (byte)0xa1, (byte)0xf5, (byte)0xe2, (byte)0xe6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5480\u9bbb\uff5c\u5e7b\uff52";
bytes = new byte[] { (byte)0xd2, (byte)0xf2, (byte)0xfc, (byte)0xe8,
  (byte)0xa1, (byte)0xc3, (byte)0xb8, (byte)0xb8, (byte)0xa3, (byte)0xf2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6881\u5f82\u526f\uff30";
bytes = new byte[] { (byte)0xce, (byte)0xc2, (byte)0xd7, (byte)0xc9,
  (byte)0xc9, (byte)0xfb, (byte)0xa3, (byte)0xd0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff86\uff96\uff69";
bytes = new byte[] { (byte)0x8e, (byte)0xc6, (byte)0x8e, (byte)0xd6,
  (byte)0x8e, (byte)0xa9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u68e3";
bytes = new byte[] { (byte)0xdc, (byte)0xa8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u55ab\u56da";
bytes = new byte[] { (byte)0xb5, (byte)0xca, (byte)0xbc, (byte)0xfc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "7\u5a20\u6c93";
bytes = new byte[] { 0x37, (byte)0xbf, (byte)0xb1, (byte)0xb7, (byte)0xa3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u043d\uff8c\uff95";
bytes = new byte[] { (byte)0xa7, (byte)0xdf, (byte)0x8e, (byte)0xcc,
  (byte)0x8e, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u8831\uff69\u51e6";
bytes = new byte[] { (byte)0xea, (byte)0xc3, (byte)0x8e, (byte)0xa9,
  (byte)0xbd, (byte)0xe8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5b5f\u5396";
bytes = new byte[] { (byte)0xcc, (byte)0xd2, (byte)0xd2, (byte)0xcd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff5d\u671f\uff11";
bytes = new byte[] { (byte)0xa1, (byte)0xd1, (byte)0xb4, (byte)0xfc,
  (byte)0xa3, (byte)0xb1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5436\uff6f\u53c3";
bytes = new byte[] { (byte)0xd2, (byte)0xe5, (byte)0x8e, (byte)0xaf,
  (byte)0xd2, (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "p";
bytes = new byte[] { 0x70 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff50A\u6669";
bytes = new byte[] { (byte)0xa3, (byte)0xf0, 0x41, (byte)0xc8, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u62cd\uff7e\u78a9";
bytes = new byte[] { (byte)0xc7, (byte)0xef, (byte)0x8e, (byte)0xbe,
  (byte)0xc0, (byte)0xd9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5680\uff65\u6b89";
bytes = new byte[] { (byte)0xd3, (byte)0xe6, (byte)0x8e, (byte)0xa5,
  (byte)0xbd, (byte)0xde };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u8f3b";
bytes = new byte[] { (byte)0xed, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff55\u8dda\uff59\u67ce";
bytes = new byte[] { (byte)0xa3, (byte)0xf5, (byte)0xec, (byte)0xe9,
  (byte)0xa3, (byte)0xf9, (byte)0xdb, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u57c6\uff23\uff03";
bytes = new byte[] { (byte)0xd4, (byte)0xbd, (byte)0xa3, (byte)0xc3,
  (byte)0xa1, (byte)0xf4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7c3f\u559a\u6b69";
bytes = new byte[] { (byte)0xca, (byte)0xed, (byte)0xb4, (byte)0xad,
  (byte)0xca, (byte)0xe2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u52b5\uff1a\uff6f";
bytes = new byte[] { (byte)0xd2, (byte)0xa5, (byte)0xa1, (byte)0xa7,
  (byte)0x8e, (byte)0xaf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u72c6\u6995\u5f11";
bytes = new byte[] { (byte)0xe0, (byte)0xbe, (byte)0xdc, (byte)0xd7,
  (byte)0xd7, (byte)0xb6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u592d\u77e5\u50f5";
bytes = new byte[] { (byte)0xd4, (byte)0xf0, (byte)0xc3, (byte)0xce,
  (byte)0xd1, (byte)0xac };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u86cb\u6434\u87c7\uff83";
bytes = new byte[] { (byte)0xc3, (byte)0xc1, (byte)0xd9, (byte)0xeb,
  (byte)0xea, (byte)0xb1, (byte)0x8e, (byte)0xc3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6d17";
bytes = new byte[] { (byte)0xc0, (byte)0xf6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5e7f\u7947\u7f5f";
bytes = new byte[] { (byte)0xd6, (byte)0xf8, (byte)0xb5, (byte)0xc0,
  (byte)0xe6, (byte)0xaa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u65c4";
bytes = new byte[] { (byte)0xda, (byte)0xd6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5f27";
bytes = new byte[] { (byte)0xb8, (byte)0xcc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff67\u221ei";
bytes = new byte[] { (byte)0x8e, (byte)0xa7, (byte)0xa1, (byte)0xe7, 0x69 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u578b\uffe4\uff86";
bytes = new byte[] { (byte)0xb7, (byte)0xbf, (byte)0xfc, (byte)0xfc,
  (byte)0x8e, (byte)0xc6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2225\u5346";
bytes = new byte[] { (byte)0xa1, (byte)0xc2, (byte)0xd2, (byte)0xc0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5302\uff08\uff14";
bytes = new byte[] { (byte)0xc6, (byte)0xf7, (byte)0xa1, (byte)0xca,
  (byte)0xa3, (byte)0xb4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0d";
bytes = new byte[] { (byte)0xa1, (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff23\uff8a\u5477";
bytes = new byte[] { (byte)0xa3, (byte)0xc3, (byte)0x8e, (byte)0xca,
  (byte)0xd2, (byte)0xee };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u627f.";
bytes = new byte[] { (byte)0xbe, (byte)0xb5, 0x2e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6674T";
bytes = new byte[] { (byte)0xc0, (byte)0xb2, 0x54 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u51cd\u5ca6";
bytes = new byte[] { (byte)0xc5, (byte)0xe0, (byte)0xf9, (byte)0xf0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff06\uff6f\u96b7";
bytes = new byte[] { (byte)0xa1, (byte)0xf5, (byte)0x8e, (byte)0xaf,
  (byte)0xce, (byte)0xec };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
}
}
