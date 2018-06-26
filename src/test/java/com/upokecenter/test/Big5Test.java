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
bytes = new byte[] { 0x4c, 0x34, (byte)0x95, 0x18, 0x3b, 0x71, (byte)0xad,
  0x3d, (byte)0xe5, 0x14, 0x3a, (byte)0xd1, (byte)0xef, 0x67, (byte)0xc3,
  0x76 };
str = "L4\ufffd\u0018;q\ufffd=\ufffd\u0014:\u6828g\u701a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x13, (byte)0x85, 0x75, (byte)0xdf, 0x1e, 0x0e,
  (byte)0xb8, (byte)0xaa, 0x0e, (byte)0xd4, (byte)0xac, 0x7e, 0x45,
  (byte)0x83, (byte)0xf6, 0x01, 0x59, 0x42, 0x1e, 0x73, (byte)0xe9,
  (byte)0xb8, (byte)0xa3, (byte)0xb0, 0x27, (byte)0xac };
str =

  "\u0013\ufffdu\ufffd\u001e\u000e\u8475\u000e\u5707~E\ufffd\u0001YB\u001es\u66cf\u311f'\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x04, (byte)0x87, 0x1e, 0x7e, 0x7b, 0x7a, (byte)0xd5,
  (byte)0xf3, (byte)0x9a, 0x57, (byte)0x95, (byte)0xcd, 0x31 };
str = "\u0004\ufffd\u001e~\u007bz\u6ddd\u9633\u42f41";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4c, (byte)0xc8, 0x2a, 0x60, (byte)0x9d, (byte)0xc8,
  (byte)0xf6, (byte)0xa1, (byte)0xf6, (byte)0xba, (byte)0xac, 0x64,
  (byte)0xe6, 0x60, 0x1e, (byte)0xc6, (byte)0x96, (byte)0xe8, (byte)0x84,
  0x73 };
str = "L\ufffd*`\u562d\u9a3f\u9dc5\u67e5\u6f6a\u001e\ufffd\ufffds";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x43, (byte)0xf0, (byte)0xe8, (byte)0xbe, (byte)0xaf,
  (byte)0xeb, 0x75, 0x57, 0x67, (byte)0x8c, 0x69, 0x44, 0x6b, 0x7a,
  (byte)0xc6, 0x1b, 0x7d, 0x74, 0x14, (byte)0xca, 0x72, 0x13, (byte)0xd4 };
str =
  "C\u8b36\u5291\u8927Wg\ud848\udc7eDkz\ufffd\u001b}t\u0014\u5363\u0013\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x34, 0x26, (byte)0x84, 0x6a, (byte)0xa8, 0x56, 0x2c,
  (byte)0xb5, 0x41, 0x51, (byte)0xce, 0x7a, 0x00, 0x14 };
str = "4&\ufffdj\u6c72\u002c\u6e19Q\u5cd8\u0000\u0014";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3a, (byte)0xe1, (byte)0x80, (byte)0x93, 0x39,
  (byte)0xfb, 0x6e, (byte)0x82, (byte)0xfc, 0x7e, (byte)0x97, 0x21, 0x29,
  0x69, 0x64 };
str = ":\ufffd\ufffd9\u585c\ufffd~\ufffd!)id";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x80, 0x4a, 0x65, 0x3c, (byte)0xde, 0x42, 0x3a,
  (byte)0xc4, (byte)0xf7, 0x32, 0x4c, (byte)0x8c, 0x42, 0x55, (byte)0x8e,
  0x2e, 0x5b, 0x21, 0x7e, 0x11, 0x3b, (byte)0xf8, (byte)0xa5 };
str = "\ufffdJe<\u6bf8:\u88232L\ud867\udc73U\ufffd.[!~\u0011;\u56d3";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xeb, 0x2c, (byte)0x9e, 0x3f, 0x7b, (byte)0xc0,
  0x45, (byte)0x80, 0x4c, 0x25, (byte)0xe0, 0x1d };
str = "\ufffd\u002c\ufffd?\u007b\u9319\ufffdL%\ufffd\u001d";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x49, 0x70, (byte)0xa1, 0x5b, (byte)0xe0, (byte)0xa9,
  (byte)0x86 };
str = "Ip\ufe34\u9114\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb8 };
str = "\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5e, 0x21, 0x32, (byte)0xc8, 0x04, 0x3e, 0x2f,
  (byte)0x8e, (byte)0xd0, 0x28, 0x02, (byte)0x80, 0x0e, (byte)0xde, 0x56,
  0x4d, (byte)0xc9, 0x70, (byte)0xac, (byte)0xfb, (byte)0xca, (byte)0xee,
  0x74, 0x34, 0x27 };
str = "^!2\ufffd\u0004>/\u8028(\u0002\ufffd\u000e\u6ecdM\u5917\u7f38\u627bt4'";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd9, (byte)0xf4, (byte)0xd8, 0x7d, 0x46, 0x70,
  0x62, (byte)0xfa, 0x79, (byte)0x90, 0x19, (byte)0xbb, (byte)0xb9, 0x34,
  (byte)0xd7, 0x73, 0x29, (byte)0xfc, (byte)0x9a };
str = "\u6e5d\u5829Fpb\u5b82\ufffd\u0019\u905c4\u8397)\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x75, (byte)0xe7, 0x75, (byte)0x98, 0x48, (byte)0xbc,
  (byte)0x82, 0x2f, 0x71, 0x3f, 0x6a };
str = "u\u84f0\u83ed\ufffd/q?j";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdb, (byte)0xad, 0x6b, (byte)0x9e, 0x75, 0x75,
  0x56, (byte)0x86, (byte)0x80, 0x4b, 0x6c };
str = "\u83e2k\ud869\udea9uV\ufffdKl";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xde, 0x37, (byte)0xbe, 0x3d, (byte)0xa8,
  (byte)0x8c, (byte)0xe1, 0x45, 0x21, 0x5a, 0x55, (byte)0x98, 0x6c, 0x47,
  0x09, (byte)0xf2, (byte)0xd3, 0x22, (byte)0x8a, (byte)0xd8, 0x4d,
  (byte)0xdd, (byte)0x87, 0x4f, (byte)0xcb, 0x08 };
str =

  "\ufffd7\ufffd=\ufffd\u5330!ZU\u6a0cG\u0009\u85e3\"\ud84b\udcb2M\ufffdO\ufffd\u0008";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x82, (byte)0xdf, 0x6f, (byte)0xa0, 0x56, 0x64,
  0x6e, (byte)0xb7, 0x64, 0x2d, 0x7d };
str = "\ufffdo\ud85b\ude05dn\u641e-}";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf9, 0x5a, 0x7c, (byte)0xbf, 0x77, 0x53, 0x57,
  0x51, 0x75, 0x54, (byte)0xad, (byte)0xe9, (byte)0xa8, 0x7b, (byte)0xbc,
  0x4e, 0x5d, (byte)0x97, (byte)0xbb, 0x7e, 0x54, 0x4b, 0x66 };
str = "\u9c68|\u7be4SWQuT\u525d\u809a\u5653]\u925f~TKf";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xee, 0x60, 0x7f, 0x50, 0x6e, (byte)0x9b, 0x11,
  0x36, (byte)0xed, 0x7e, (byte)0xad, 0x54, 0x52, (byte)0xa6, (byte)0x93,
  (byte)0xfb, (byte)0xa4, 0x6e, (byte)0xf2, (byte)0xf1, (byte)0x95,
  (byte)0xc3, (byte)0xe0, 0x5e, 0x0f, (byte)0x8b };
str =

  "\u87bc\u007fPn\ufffd\u00116\u77b6\u8305R\ufffd\ud845\ude92n\u8959\u599a\u8d91\u000f\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6e, (byte)0xc9, 0x62, (byte)0xda, (byte)0xab, 0x52,
  (byte)0xb8, 0x74, 0x6f, 0x71, 0x02, 0x49, (byte)0x82, (byte)0xb8, 0x79,
  0x32, 0x1f, 0x70, (byte)0xe9, (byte)0xf7, 0x73, (byte)0xe5, (byte)0xf1,
  0x2a, (byte)0xb7, 0x70, (byte)0x96, (byte)0xed };
str = "n\u723f\u74fbR\u8056oq\u0002I\ufffdy2\u001fp\u6fa5s\u6ba5*\u6406\u701e";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa3 };
str = "\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x75, 0x61, 0x4e, 0x76, 0x54, (byte)0x8f };
str = "uaNvT\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xde, 0x03, (byte)0xf6, 0x28, 0x51, (byte)0x83,
  0x3e, (byte)0xfd, (byte)0xd9, (byte)0x82, 0x50, 0x53, 0x31, 0x50,
  (byte)0xbc, 0x34, 0x70, (byte)0xc7, (byte)0xe2, 0x67, 0x20, 0x4c, 0x4f,
  (byte)0xfa, (byte)0xa1, 0x2b, 0x77, (byte)0xb2 };
str =

  "\ufffd\u0003\ufffd(Q\ufffd>\ud84f\udfb4\ufffdPS1P\ufffd4p\u30e6g LO\u9d34+w\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd0 };
str = "\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x29, 0x7e, 0x58, 0x47, (byte)0x89, 0x2f, 0x7e, 0x0d,
  0x39, (byte)0xca, 0x2f, (byte)0xda, (byte)0xa3, 0x04 };
str = ")~XG\ufffd/~\u000d9\ufffd/\u742d\u0004";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x69, 0x2a, (byte)0x82, (byte)0x92, 0x24, (byte)0xe3,
  0x37, (byte)0xd5, 0x15 };
str = "i*\ufffd$\ufffd7\ufffd\u0015";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0a, 0x72, 0x15, 0x75, (byte)0x8d, 0x31, (byte)0x9e,
  0x65, 0x75, (byte)0xd8, 0x67, (byte)0xa1, 0x36, 0x70, (byte)0xdd, 0x15,
  0x5c, (byte)0xd7 };
str = "\u000ar\u0015u\ufffd1\u7304u\u55a8\ufffd6p\ufffd\u0015\\\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5f, (byte)0xac, (byte)0x95, 0x44, (byte)0xd6, 0x02,
  0x0f, 0x27, (byte)0xe8, 0x35, (byte)0xa8, 0x7f, (byte)0xaf, 0x77, 0x66,
  0x71, 0x6b, (byte)0x9a, 0x4d, 0x4a, 0x62, 0x1b, 0x67, 0x0f };
str =

  "_\ufffdD\ufffd\u0002\u000f'\ufffd5\ufffd\u007f\u7728fqk\u941dJb\u001bg\u000f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa2, 0x40, 0x4c, 0x11, (byte)0x8f, 0x43, 0x23,
  0x42, (byte)0xd6, 0x5f, (byte)0xb4, 0x1c, (byte)0xe8, 0x64, 0x6e, 0x71,
  0x65, (byte)0x81, (byte)0xfc, (byte)0xd3, 0x6a, 0x5b, (byte)0xf8, 0x47,
  0x3e };
str =
  "\uff3cL\u0011\ud843\ude16#B\u727f\ufffd\u001c\u92c4nqe\ufffd\u80f2[\u8f64>";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdb, (byte)0xa1, 0x15, (byte)0xda, 0x76, 0x6d,
  0x21, 0x25, (byte)0xd5, 0x0a, 0x31, 0x3b, (byte)0xe9, 0x44, (byte)0xe8,
  0x47, (byte)0xb5, 0x69, (byte)0xb0, (byte)0xa6, (byte)0x8e, (byte)0xac,
  (byte)0xb7, 0x74, 0x2a, (byte)0xa4, 0x71, (byte)0x99, 0x52, 0x08 };
str =

  "\u83d5\u0015\u7326m!%\ufffd\u000a1;\u5672\u8f2c\u75e3\u96bb\ud850\udc57\u6697*\u5c22\u7b7b\u0008";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb2, 0x30, (byte)0xec, 0x29, 0x29, (byte)0x94,
  0x47, 0x1a, (byte)0xdf, (byte)0xcc, 0x7f, 0x1e, (byte)0xfa, 0x66,
  (byte)0xc0, 0x5e, 0x79, (byte)0xad, 0x77, (byte)0xa2, (byte)0xf3,
  (byte)0x9a, 0x54, 0x5b, (byte)0xab, 0x79, 0x7d, (byte)0xe4 };
str =

  "\ufffd0\ufffd))\u6d67\u001a\u842d\u007f\u001e\u507d\u991ey\u8db4\uff4b\u95a2[\u54b3}\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5c, (byte)0x8e, (byte)0xb5, 0x28, (byte)0xff,
  (byte)0x9b, 0x55, (byte)0xd3, 0x5e, 0x3a, 0x1b, 0x40, 0x02, (byte)0xc4,
  0x2f, 0x76, 0x20, 0x5e, 0x2d, 0x25, (byte)0xaf, 0x10, (byte)0xfe, 0x75,
  0x61, 0x20, 0x26, 0x60, 0x68 };
str =

  "\\\ud858\udd21(\ufffd\ud84a\udd67\u7f60:\u001b@\u0002\ufffd/v ^-%\ufffd\u0010\u7476a &`h";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7c, 0x71, 0x04 };
str = "|q\u0004";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x30, 0x51, (byte)0x86, (byte)0x90, (byte)0xa6,
  (byte)0xdf, 0x0f, 0x65, 0x37, (byte)0x9c, (byte)0x80, (byte)0xa5, 0x18,
  0x16, 0x2e, 0x5c, 0x5e, 0x38, (byte)0xa0, (byte)0xc9, (byte)0x93, 0x6c,
  (byte)0xf0, (byte)0xaf, 0x78 };
str =

  "0Q\ufffd\u821b\u000fe7\ufffd\ufffd\u0018\u0016.\\^8\u878c\ud84a\udc60\u85cbx";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x0a, 0x4a, (byte)0xe1, (byte)0xf2, 0x64, 0x2d, 0x41,
  0x08, 0x54, 0x4a, (byte)0x9c, 0x4c, 0x2e, 0x4f, (byte)0xe8, 0x11, 0x18,
  (byte)0x92 };
str = "\u000aJ\u6465d-A\u0008TJ\ud859\udeb5.O\ufffd\u0011\u0018\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x76, 0x78, 0x76, (byte)0x83, (byte)0x8c, (byte)0xce,
  (byte)0xa4, 0x66, (byte)0xe7, (byte)0xf5, (byte)0xcf, (byte)0x8d,
  (byte)0xed, (byte)0xc7, 0x55, 0x22, (byte)0xbd, (byte)0xf8, 0x0b, 0x0b,
  0x72, (byte)0x89 };
str = "vxv\ufffd\u5cc7f\u8e25\ufffd\u7c01U\"\u8f1b\u000b\u000br\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6e, 0x0c };
str = "n\u000c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2f, 0x79, (byte)0xfe, 0x35, (byte)0x97, (byte)0xb6,
  0x5f, (byte)0xb9, (byte)0x9d };
str = "/y\ufffd5\ud85d\udc84_\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xae, (byte)0x96, (byte)0xaf, (byte)0x9e, 0x36,
  0x35, (byte)0xb9, 0x4e, 0x60, 0x0a, 0x51, 0x2c, (byte)0x84, 0x7f, 0x4b,
  0x3b, 0x3c, 0x42, 0x7b, (byte)0xa5, 0x7a, 0x7e, 0x26, (byte)0xe7, 0x62,
  (byte)0xf0, 0x6b };
str =

  "\ufffd\ufffd65\u9051`\u000aQ\u002c\ufffd\u007fK;<B\u007b\u53ed~&\u84eb\u7c25";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x3a, 0x60, (byte)0xf2 };
str = ":`\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb8 };
str = "\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xec, (byte)0xb4, (byte)0xec, 0x1e, (byte)0x86,
  (byte)0xca, (byte)0xe8, 0x1c, 0x6c, 0x30, (byte)0x8d, 0x6e };
str = "\u9ed5\ufffd\u001e\ufffd\ufffd\u001cl0\u3914";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb5, (byte)0xe6, 0x0a, 0x4c };
str = "\u83dc\u000aL";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x75, 0x3c, 0x70, 0x65, (byte)0x8a, (byte)0xd3, 0x11,
  (byte)0xa6, (byte)0xe5, 0x2e, 0x4a, (byte)0xfb, 0x3f, 0x22, (byte)0xe2,
  0x31, (byte)0xf9, 0x27, 0x46, 0x09, 0x27, (byte)0x9e, (byte)0xd0, 0x15,
  (byte)0xd4, 0x0d, 0x15, 0x61, (byte)0xcd, 0x76 };
str =

  "u<pe\u3578\u0011\u8840.J\ufffd?\"\ufffd1\ufffd'F\u0009'\ud867\udfde\u0015\ufffd\u000d\u0015a\u76f3";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2b, (byte)0xb8, (byte)0x9c, 0x6a, (byte)0xdb,
  (byte)0x96, 0x3a, 0x77, (byte)0xd7, 0x39, (byte)0x8d };
str = "+\ufffdj\ufffd:w\ufffd9\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xca, 0x1e, 0x12, 0x30, (byte)0xc1, 0x67,
  (byte)0xfe, 0x31, (byte)0xdb, 0x7d, 0x60, (byte)0x9e, (byte)0xba,
  (byte)0xdb, (byte)0xac, (byte)0x83, (byte)0xa0, 0x20, 0x71, (byte)0x9b,
  (byte)0xed, (byte)0xb7, (byte)0xb5, (byte)0xbc, 0x32 };
str =

  "\ufffd\u001e\u00120\u7e35\ufffd1\u83c2`\u537d\u83d7\ufffd q\ud856\udd03\u6bbf\ufffd2";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd4, 0x0e, 0x17, (byte)0xc3, (byte)0x8c,
  (byte)0xad, 0x2b, 0x65, 0x66, 0x36, 0x1a, 0x14, (byte)0x92, (byte)0xd2,
  (byte)0xdc, 0x24, (byte)0x99, 0x75, (byte)0x8c, 0x1c, 0x3b, 0x2a,
  (byte)0xbf, (byte)0xaa, (byte)0xbd, 0x54, (byte)0x88, 0x5e, 0x09 };
str =

  "\ufffd\u000e\u0017\ufffd\ufffd+ef6\u001a\u0014\u3ede\ufffd$\u732a\ufffd\u001c;*\u7fb2\u78ba\u014c\u0009";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xaf, 0x6b, 0x4f, 0x01, 0x67, (byte)0xf8,
  (byte)0xea, 0x24, (byte)0xd6 };
str = "\u75bcO\u0001g\u9f46$\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x89, 0x13, (byte)0xbd, 0x44, 0x46, (byte)0xcd,
  (byte)0x9f, 0x25, (byte)0xf3, 0x58, 0x54 };
str = "\ufffd\u0013\u7629F\ufffd%\u8f4fT";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xec, 0x65, (byte)0xcb, 0x44, (byte)0x82, 0x72,
  (byte)0xb1, (byte)0xf6, (byte)0xd7, 0x6a, 0x57, 0x38, (byte)0x89,
  (byte)0xd1, 0x6b, 0x2d, 0x4a, (byte)0xde, 0x39, 0x7f };
str = "\u99f0\u675d\ufffdr\u6885\u838cW8\u4e87k-J\ufffd9\u007f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x47, 0x29, 0x1a, (byte)0xd4, 0x1d, 0x1f, 0x64,
  (byte)0x86, (byte)0xfa, 0x60, 0x5f };
str = "G)\u001a\ufffd\u001d\u001fd\ufffd`_";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x76, (byte)0xb0, (byte)0xc2, (byte)0xdb, 0x26, 0x1b,
  (byte)0x82, 0x1c, 0x65, (byte)0xda, 0x4b, (byte)0x8d, 0x46, (byte)0xd5,
  (byte)0xfb, 0x39, 0x3c, 0x47, 0x2d, 0x1f, (byte)0xa1, 0x14, 0x77 };
str =

  "v\u515c\ufffd&\u001b\ufffd\u001ce\u6e53\ud864\udc79\u6dd59<G-\u001f\ufffd\u0014w";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xb4, 0x65, (byte)0xf9, 0x29, 0x2a };
str = "\u60b6\ufffd)*";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x75, (byte)0x8c, (byte)0x8b, (byte)0x94, 0x22, 0x3a,
  (byte)0xe5, 0x39, 0x08, 0x5f, 0x4f, (byte)0xb3, (byte)0xe3, 0x08,
  (byte)0x95, 0x40, (byte)0xae, (byte)0xf1, 0x6b };
str = "u\ufffd\ufffd\":\ufffd9\u0008_O\u558b\u0008\ud858\udd5c\u6c27k";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x95, (byte)0xb7, (byte)0xc4, 0x28, 0x0c, 0x48,
  (byte)0xfd, 0x33, (byte)0xc0, (byte)0xfc, (byte)0xf4, 0x35, (byte)0xb7,
  0x78, (byte)0xc3 };
str = "\ud865\udc48\ufffd(\u000cH\ufffd3\u77aa\ufffd5\u6696\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x49, 0x74, 0x14, 0x7b, 0x37, 0x18, (byte)0xcb, 0x74,
  0x2d, 0x2e, 0x6d, 0x45, (byte)0xcd, (byte)0xa3, (byte)0xf4, (byte)0xd7,
  (byte)0xf3, 0x51, 0x57, 0x6b };
str = "It\u0014\u007b7\u0018\u8095-.mE\u793f\u8e86\u8e73Wk";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x58, 0x7c, 0x31, 0x5a, 0x3d, 0x02, 0x38, (byte)0x87,
  0x7a, (byte)0xa6, 0x6f, (byte)0x8a, (byte)0xa8, 0x55, (byte)0xf5,
  (byte)0xd1, (byte)0x82, 0x59 };
str = "X|1Z=\u00028\u3875\u5979\ud848\udda1U\u6af8\ufffdY";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4f, (byte)0xfb, 0x75, 0x51, 0x2f, 0x00, 0x64,
  (byte)0x95, (byte)0xf3, 0x66, 0x60, 0x0d, 0x55, 0x4d, 0x60, 0x4d,
  (byte)0x85, 0x47, 0x6f, (byte)0xee, (byte)0xfb, 0x34, 0x57 };
str = "O\u5bffQ/\u0000d\ud863\udee7f`\u000dUM`M\ufffdGo\u97194W";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf6 };
str = "\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdd, (byte)0x88, (byte)0xb1, (byte)0xde, 0x2b,
  0x5a, 0x39, (byte)0x8c, (byte)0xb0 };
str = "\ufffd\u665d+Z9\ud855\ude95";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xeb, (byte)0xa1, (byte)0xdd, (byte)0xf7,
  (byte)0x8e, 0x79, 0x2a, 0x4e, (byte)0xae, (byte)0xba, (byte)0xe4,
  (byte)0xb1, (byte)0xef, 0x02, (byte)0xc3, (byte)0xa5, 0x63, 0x33,
  (byte)0xbb };
str = "\u8ae2\u6b43\u7cc7*N\u634f\u9286\ufffd\u0002\u7587c3\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5e, 0x61, 0x62, 0x3e, 0x33, 0x78, 0x56, (byte)0xf6,
  (byte)0xc9, 0x7c, 0x69, (byte)0x80, 0x52, (byte)0x9a, (byte)0xc3,
  (byte)0xdd, 0x6e, (byte)0xce, (byte)0xcd, (byte)0xce, 0x78, (byte)0xbf,
  0x3e, 0x6a, (byte)0x84, 0x2e, (byte)0x94, 0x62, (byte)0xa9, 0x20 };
str =

  "^ab>3xV\u9e7a|i\ufffdR\u7173\u612f\u6024\u5c4c\ufffd>j\ufffd.\ud857\udfe1\ufffd ";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd5, (byte)0x92, 0x54, 0x7d, 0x3c, (byte)0xb0,
  0x34, 0x62, 0x00, (byte)0xdd, 0x7d, 0x7d, 0x13, (byte)0xb9, (byte)0xf1,
  0x5d, 0x1a, 0x12, 0x79, (byte)0x8d, (byte)0x8c, (byte)0xf1, (byte)0xc2,
  0x61 };
str = "\ufffdT}<\ufffd4b\u0000\u6420}\u0013\u5d84]\u001a\u0012y\ufffd\u9b4ba";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2e, 0x12, (byte)0xa2, 0x3d, (byte)0x81, 0x61, 0x55,
  0x41, 0x7c, 0x63, 0x27, (byte)0xff, 0x15, 0x0f, 0x36, (byte)0xe6, 0x36,
  0x68, 0x2d, 0x64, (byte)0xcc, 0x37, 0x2d };
str = ".\u0012\ufffd=\ufffdaUA|c'\ufffd\u0015\u000f6\ufffd6h-d\ufffd7-";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x82, (byte)0xfa, 0x35, (byte)0xc6, 0x53, 0x37,
  0x43, 0x01, (byte)0xc9, 0x7c, 0x63, 0x6c, (byte)0xe3, 0x58, 0x20,
  (byte)0xa9, 0x51, (byte)0xdb, 0x7c, 0x76, (byte)0xe4, (byte)0x9e, 0x7d,
  0x50, 0x2c };
str = "\ufffd5\u9f777C\u0001\u6209cl\u7b85 \u548b\u8406v\ufffd}P\u002c";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x52, (byte)0xc2, 0x1b, (byte)0xb4, 0x60, 0x4e,
  (byte)0xab, (byte)0x9c, (byte)0xbc, 0x6b, (byte)0xec, (byte)0xbe };
str = "R\ufffd\u001b\u5faaN\ufffd\u5d94\u5129";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x28, 0x52, 0x0e, (byte)0xc8, (byte)0x82, (byte)0x90,
  0x71, 0x0c, 0x6e, (byte)0x9f };
str = "(R\u000e\ufffd\u91c4\u000cn\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x38, 0x63, (byte)0xa1, (byte)0x96, 0x4e, (byte)0x9a,
  0x11, (byte)0x9c, 0x6c, (byte)0xda, 0x2e, (byte)0xf7, 0x54, 0x5e,
  (byte)0xd8 };
str = "8c\ufffdN\ufffd\u0011\ud85a\uddfa\ufffd.\u89be^\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x46, (byte)0xfc, 0x5c, 0x2d, (byte)0xa0, (byte)0xc1,
  0x5d, 0x43, (byte)0x9a, (byte)0xe7, 0x2f, (byte)0x8c };
str = "F\ud85c\udcf8-\u7724]C\ud844\udc76/\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x5e, 0x6c, (byte)0xf6, (byte)0xaa, 0x4c, (byte)0x9b,
  (byte)0x87, 0x79, 0x01, (byte)0xfe, 0x6e, 0x50, (byte)0xba };
str = "^l\u9c1dL\ufffdy\u0001\u3ed7P\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x2d, (byte)0xde, (byte)0xf4, 0x5b, (byte)0x84, 0x60,
  (byte)0x84, 0x1c, (byte)0xf7, 0x12, 0x52, (byte)0xbc, (byte)0x87,
  (byte)0xd9, 0x7e, (byte)0x94, 0x2c, 0x22, 0x6f, 0x3f, 0x1b, (byte)0xa3,
  0x47, 0x3d, (byte)0xda, (byte)0xb1 };
str =

  "-\u7982[\ufffd`\ufffd\u001c\ufffd\u0012R\ufffd\u65d2\ufffd\u002c\"o?\u001b\u0394=\u75e1";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe3, (byte)0xd9, (byte)0xeb, 0x4e, (byte)0xa7,
  0x69, 0x52, (byte)0xd3, 0x30, 0x7c, 0x56, 0x42, 0x2a, 0x24, 0x76, 0x0b,
  0x16 };
str = "\u8740\u8575\u544aR\ufffd0|VB*$v\u000b\u0016";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4a, (byte)0xfa, (byte)0x9e, 0x58, (byte)0xbf, 0x66,
  0x44, (byte)0xe1, 0x62, (byte)0x94, (byte)0xd1, (byte)0xf5, (byte)0xe6,
  0x08 };
str = "J\ufffdX\u779eD\u588e\u416e\u7cf2\u0008";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9e, (byte)0xb8, (byte)0xa9, (byte)0xf8,
  (byte)0xeb, (byte)0xdd, 0x3c, (byte)0xd9, 0x6f, (byte)0xb5, 0x5f, 0x4b,
  (byte)0xb5, 0x1b, 0x7a, 0x44, (byte)0x80, (byte)0x89, (byte)0xdd,
  (byte)0xa1, 0x60, 0x12, 0x3e, 0x6c, 0x77, (byte)0xb8, 0x29, 0x3d,
  (byte)0x99 };
str =

  "\u36ac\u6606\u9327<\u63f0\u742fK\ufffd\u001bzD\ufffd\u5186\ufe36\u0012>lw\ufffd)=\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe4, (byte)0xaa, (byte)0xc5, (byte)0xe6,
  (byte)0xfd, 0x65, 0x2e, 0x1f, (byte)0xff, 0x7e, 0x43, 0x4d, (byte)0xe5,
  0x2c, 0x2a, (byte)0xe9, (byte)0xb0, 0x60, 0x48 };
str = "\u9282\u9a5b\u6b35.\u001f\ufffd~CM\ufffd\u002c*\u657f`H";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x23, 0x28, (byte)0xb9, 0x6e, 0x44, 0x00, 0x0c, 0x32,
  0x57, 0x2b, 0x66, (byte)0xdd, (byte)0xfd, 0x53, (byte)0xf1, 0x3a, 0x73,
  (byte)0x9e, (byte)0xcd, 0x72, (byte)0x93, 0x4d, (byte)0x84 };
str = "#(\u96c9D\u0000\u000c2W+f\u6bfbS\ufffd:s\u4c5br\u5c9e\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x67, 0x3e, 0x68, 0x4c, 0x51, (byte)0xa2, (byte)0xed,
  (byte)0xe1 };
str = "g>hLQ\uff45\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd0, 0x31, 0x66, 0x76, 0x4b, (byte)0xb6, 0x7a,
  (byte)0xe6, 0x35, 0x54, 0x67, (byte)0x84, 0x50 };
str = "\ufffd1fvK\u9211\ufffd5Tg\ufffdP";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x45, 0x7e, (byte)0xe2, 0x23, 0x1f, 0x22, (byte)0xed,
  0x35, 0x6e, (byte)0x80, 0x38, 0x23, (byte)0xfe, (byte)0xd2, 0x40, 0x3e,
  0x54 };
str = "E~\ufffd#\u001f\"\ufffd5n\ufffd8#\u7726@>T";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x41, (byte)0xc4, (byte)0x97, 0x20, 0x4b, 0x19,
  (byte)0xf4, (byte)0xb8, (byte)0xb9, 0x4e, 0x61, (byte)0xf1, 0x75, 0x45,
  0x01 };
str = "A\ufffd K\u0019\u8622\u9051a\u96ddE\u0001";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x98, (byte)0x97, (byte)0x8b, 0x6f, (byte)0xe5,
  0x1c, 0x7e, (byte)0xca, (byte)0xb3, (byte)0x8a, (byte)0xbb, 0x06 };
str = "\ufffd\ud843\ude10\ufffd\u001c~\u5998\u4ab4\u0006";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4d, 0x48, (byte)0x9b, 0x60, 0x37, (byte)0xc3,
  (byte)0xc9, 0x6b, 0x2a, 0x36, 0x05, (byte)0xe8, (byte)0xba, (byte)0x84,
  0x0e, (byte)0xe1, 0x2c, 0x4d, (byte)0xc9, 0x7f, 0x67, 0x6f, (byte)0xf5,
  0x74, (byte)0xf3, (byte)0xe2, 0x7f, 0x6d, 0x7f, 0x31 };
str =

  "MH\ud84b\udc4c7\u87f9k*6\u0005\u9828\ufffd\u000e\ufffd\u002cM\ufffd\u007fgo\u9c17\u9d8c\u007fm\u007f1";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa9, 0x08, (byte)0x90, (byte)0xbc, 0x3e };
str = "\ufffd\u0008\u49df>";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xaa, 0x6d, (byte)0x94, (byte)0xa8, (byte)0x95,
  (byte)0xb4, (byte)0xbe, (byte)0xb4, 0x7f, 0x76, (byte)0xce, 0x42, 0x58,
  0x7a, (byte)0xa5, 0x51, 0x3b };
str = "\u6cb8\u9342\u37f2\u5679\u007fv\u54b7Xz\u4ede;";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xe0, 0x41, (byte)0x84, (byte)0xe5, 0x07, 0x64,
  (byte)0xe8, 0x2c, 0x1e, (byte)0xd5, 0x5c, 0x44, (byte)0xe8, 0x70, 0x6e,
  0x78, (byte)0xca, 0x74, (byte)0xd3, (byte)0xb4, 0x40, 0x19, 0x60,
  (byte)0xa2, 0x25 };
str =

  "\u89e0\ufffd\u0007d\ufffd\u002c\u001e\u60ddD\u92efnx\u538e\u834b@\u0019`\ufffd%";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x4c };
str = "L";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x51, (byte)0x97, 0x37, 0x34, 0x35, 0x2b, (byte)0x8e,
  (byte)0x86, 0x2f, 0x3f, (byte)0x8d, 0x5c, 0x2b, 0x56, (byte)0xdd,
  (byte)0xff, 0x79, (byte)0xa7, (byte)0x8c, 0x67, 0x45, (byte)0xd9, 0x47,
  0x79, (byte)0xba, 0x5f, 0x36 };
str = "Q\ufffd745+\ufffd/?\u3661+V\ufffdy\ufffdgE\u60fcy\u69956";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xf2, 0x65, (byte)0xef, 0x1f, (byte)0xac,
  (byte)0x97, 0x4e, (byte)0xe6, (byte)0xc8, 0x6b, 0x78, 0x4c, (byte)0x96,
  (byte)0xeb, 0x67, 0x40, 0x5f, (byte)0xeb, 0x21, (byte)0xcd, 0x4a, 0x33,
  0x1e, 0x2f, 0x66, (byte)0x82, 0x4e };
str =
  "\u7017\ufffd\u001f\ufffdN\u78c3kxL\u6fdag@_\ufffd!\u6cc73\u001e/f\ufffdN";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x6a, 0x00, (byte)0xa2, (byte)0xd3, (byte)0xa6, 0x62,
  (byte)0xcb, 0x28, 0x5a, 0x7c, 0x78, 0x6a, 0x21, (byte)0xe2, (byte)0xff,
  0x18, (byte)0xad, (byte)0x92, 0x3e, 0x2c, (byte)0x89, 0x02 };
str = "j\u0000\uff25\u5728\ufffd(Z|xj!\ufffd\u0018\ufffd>\u002c\ufffd\u0002";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x46, (byte)0xa7, 0x22, (byte)0xa4, (byte)0x87,
  (byte)0xcb, (byte)0xb2, (byte)0x81, (byte)0xfc, (byte)0xcf, 0x79 };
str = "F\ufffd\"\ufffd\u4f98\ufffd\u6d3a";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x62, 0x54 };
str = "bT";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x69 };
str = "i";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xdf, 0x62, (byte)0xd8, 0x59, 0x79, (byte)0xb0 };
str = "\u7d8c\u508ey\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x7d, (byte)0x9c, 0x59, (byte)0x8e, (byte)0xd1, 0x09,
  (byte)0x90, 0x24, (byte)0xbb, 0x66, 0x10, 0x43, (byte)0xbb };
str = "}\u9656\u802f\u0009\ufffd$\u873b\u0010C\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x58, (byte)0xa2, 0x50, (byte)0xda, (byte)0xce, 0x68,
  (byte)0xe7, (byte)0xa0, 0x1b, 0x1e, (byte)0xc9, 0x3e, (byte)0x9a, 0x21,
  0x58 };
str = "X\u339c\u7869h\ufffd\u001b\u001e\ufffd>\ufffd!X";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x9b, 0x3f, (byte)0xd0, (byte)0xbd, 0x21, 0x78,
  0x66, 0x76, (byte)0x9c, 0x38, 0x53, (byte)0xbd, 0x65, 0x78, 0x7c,
  (byte)0xf5, 0x7d, (byte)0xdd, (byte)0xe0, 0x4c, 0x67, (byte)0xec, 0x2c,
  0x56, 0x25, (byte)0xfd, 0x57 };
str = "\ufffd?\u90c7!xfv\ufffd8S\u7bb4x|\u9d90\u6934Lg\ufffd\u002cV%\u69f9";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { 0x72, 0x3d, (byte)0x92 };
str = "r=\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xa6, 0x6f, (byte)0xe0, 0x46, (byte)0xf8, 0x13,
  0x14, 0x2b, 0x1e, 0x5d, 0x7f, (byte)0x83, 0x3a, (byte)0xcd, 0x55,
  (byte)0xa0, (byte)0x8b, 0x70, 0x39, (byte)0xb6, 0x1f };
str =

  "\u5979\u8a86\ufffd\u0013\u0014+\u001e]\u007f\ufffd:\u7084\ufffdp9\ufffd\u001f";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0xd3, (byte)0x98, 0x21, 0x18 };
str = "\ufffd!\u0018";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
bytes = new byte[] { (byte)0x81, (byte)0xd5, (byte)0xdd, 0x00, (byte)0xa0,
  (byte)0xa5 };
str = "\ufffd\ufffd\u0000\ufffd";
Assert.assertEquals(
 str,
 Encodings.DecodeToString(charset, bytes));
}
@Test
public void TestBig5Encoder() {
byte[] bytes;
String str;
ICharacterEncoding charset = Encodings.GetEncoding("big5");
str = "\u5013\u6351%\u77e3";
bytes = new byte[] { (byte)0xd0, (byte)0xcb, (byte)0xd1, (byte)0xc8, 0x25,
  (byte)0xa8, 0x6f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u696b-";
bytes = new byte[] { (byte)0xb7, (byte)0xaa, 0x2d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff1c\u543c\u749f";
bytes = new byte[] { (byte)0xa1, (byte)0xd5, (byte)0xa7, 0x71, (byte)0xbf,
  0x5b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u73d7";
bytes = new byte[] { (byte)0xd2, (byte)0xb9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u79cb\u671b";
bytes = new byte[] { (byte)0xac, (byte)0xee, (byte)0xb1, (byte)0xe6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6dfd\u4e59\u71ec";
bytes = new byte[] { (byte)0xd6, 0x43, (byte)0xa4, 0x41, (byte)0xc0,
  (byte)0xec };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u59be\u52ef\u7e8f";
bytes = new byte[] { (byte)0xa9, 0x63, (byte)0xe4, (byte)0xf5, (byte)0xc4,
  (byte)0xf1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u99fd";
bytes = new byte[] { (byte)0xef, 0x60 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5aa6\u5282\u6572";
bytes = new byte[] { (byte)0xd8, (byte)0xbc, (byte)0xb9, (byte)0xbb,
  (byte)0xba, 0x56 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u72a2\u5490\uff2f";
bytes = new byte[] { (byte)0xc3, 0x7d, (byte)0xa9, 0x4a, (byte)0xa2,
  (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u793a\u65a5\u59c1\u7207";
bytes = new byte[] { (byte)0xa5, (byte)0xdc, (byte)0xa5, (byte)0xb8,
  (byte)0xcc, 0x4a, (byte)0xf2, 0x6b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u652b";
bytes = new byte[] { (byte)0xc5, (byte)0xcc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2175\u64d6\u7598";
bytes = new byte[] { (byte)0xc6, (byte)0xba, (byte)0xe9, (byte)0xa5,
  (byte)0xcd, 0x74 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4d\u88f6\u6fa0";
bytes = new byte[] { (byte)0xa2, (byte)0xf5, (byte)0xe3, (byte)0xfd,
  (byte)0xbf, 0x49 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u68e1\u7063\uff58";
bytes = new byte[] { (byte)0xd9, (byte)0xbb, (byte)0xc6, 0x57, (byte)0xa3,
  0x41 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7bc9\uff34\u6a47\u59b1";
bytes = new byte[] { (byte)0xbf, 0x76, (byte)0xa2, (byte)0xe2, (byte)0xbe,
  (byte)0xf5, (byte)0xcc, 0x4f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u551a";
bytes = new byte[] { (byte)0xd0, (byte)0xf7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uffe0\u7601";
bytes = new byte[] { (byte)0xa2, 0x46, (byte)0xb7, (byte)0xf1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7f67\u5a38\u7998";
bytes = new byte[] { (byte)0xdf, 0x69, (byte)0xd4, (byte)0xd3, (byte)0xe2,
  (byte)0xf8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5aa9\u7709\u7735\u5198\u526b";
bytes = new byte[] { (byte)0xd8, (byte)0xc8, (byte)0xac, (byte)0xdc,
  (byte)0xd6, (byte)0xb2, (byte)0xc9, 0x55, (byte)0xd4, 0x69 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9783";
bytes = new byte[] { (byte)0xe4, (byte)0xc2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u526e";
bytes = new byte[] { (byte)0xd4, 0x6c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u51f9\u7c4d\uff42";
bytes = new byte[] { (byte)0xa5, 0x57, (byte)0xc4, 0x79, (byte)0xa2,
  (byte)0xea };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u888e\u87c4\u67f2\u79a7\u5adc";
bytes = new byte[] { (byte)0xd7, (byte)0xc4, (byte)0xee, 0x68, (byte)0xce,
  (byte)0xfc, (byte)0xc1, 0x48, (byte)0xe1, 0x6b };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u66bb\u5829\u241f\u69bb";
bytes = new byte[] { (byte)0xe9, (byte)0xba, (byte)0xd8, 0x7d, (byte)0xa3,
  (byte)0xdf, (byte)0xba, 0x66 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7aa0\uff1c";
bytes = new byte[] { (byte)0xb8, 0x5e, (byte)0xa1, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2eae\u6b1a\u6147";
bytes = new byte[] { (byte)0xc8, (byte)0xe5, (byte)0xf8, (byte)0xf4,
  (byte)0xb9, (byte)0xfe };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u557c";
bytes = new byte[] { (byte)0xb3, (byte)0xda };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6489\u77fb\u7bc7";
bytes = new byte[] { (byte)0xe9, (byte)0xaa, (byte)0xcd, 0x7d, (byte)0xbd,
  0x67 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5708\u5c56\u5439";
bytes = new byte[] { (byte)0xb0, (byte)0xe9, (byte)0xd1, 0x6a, (byte)0xa7,
  0x6a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u8036\uff03\u7de9\u5f76";
bytes = new byte[] { (byte)0xad, 0x43, (byte)0xa1, (byte)0xad, (byte)0xbd,
  0x77, (byte)0xca, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6a41\u54a6";
bytes = new byte[] { (byte)0xe9, (byte)0xce, (byte)0xab, 0x78 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2407\u6f55\uff35\u7f69\u5dd6";
bytes = new byte[] { (byte)0xa3, (byte)0xc7, (byte)0xe6, 0x4b, (byte)0xa2,
  (byte)0xe3, (byte)0xb8, 0x6e, (byte)0xc5, (byte)0xc9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6aea\u6f60\uff04";
bytes = new byte[] { (byte)0xf4, 0x55, (byte)0xbc, (byte)0xf2, (byte)0xa2,
  0x43 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7189";
bytes = new byte[] { (byte)0xe2, (byte)0xbc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff34\u78df\u893e";
bytes = new byte[] { (byte)0xa2, (byte)0xe2, (byte)0xea, (byte)0xac,
  (byte)0xee, 0x74 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7a30\u2642\uff4f";
bytes = new byte[] { (byte)0xe3, 0x46, (byte)0xa1, (byte)0xf1, (byte)0xa2,
  (byte)0xf7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6f19";
bytes = new byte[] { (byte)0xe2, 0x77 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u21963";
bytes = new byte[] { (byte)0xa1, (byte)0xf8, 0x33 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6cc3\u5ee9\u6575";
bytes = new byte[] { (byte)0xcc, (byte)0xfb, (byte)0xe9, 0x6f, (byte)0xbc,
  (byte)0xc4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5885\uff0c\uff30";
bytes = new byte[] { (byte)0xb9, (byte)0xd6, (byte)0xa1, 0x41, (byte)0xa2,
  (byte)0xde };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u695f\u771a\u6f87";
bytes = new byte[] { (byte)0xdd, (byte)0xca, (byte)0xd2, (byte)0xd6,
  (byte)0xe5, (byte)0xfc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5bc0\u5783\u51a5";
bytes = new byte[] { (byte)0xd4, (byte)0xf2, (byte)0xa9, 0x55, (byte)0xad,
  (byte)0xdf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2ed7\u5027\u6f26";
bytes = new byte[] { (byte)0xc8, (byte)0xef, (byte)0xd0, (byte)0xd9,
  (byte)0xe5, (byte)0xfa };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u745b\u7b33\u96c2\u6010\u7318";
bytes = new byte[] { (byte)0xb7, (byte)0xeb, (byte)0xd6, (byte)0xd2,
  (byte)0xdc, (byte)0xa4, (byte)0xcc, (byte)0xaa, (byte)0xd6, 0x64 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5912\u002c";
bytes = new byte[] { (byte)0xf1, (byte)0xf9, 0x2c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6e2c\u7d06\uff35";
bytes = new byte[] { (byte)0xb4, (byte)0xfa, (byte)0xac, (byte)0xfa,
  (byte)0xa2, (byte)0xe3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6957\u68ce\u7503";
bytes = new byte[] { (byte)0xdd, (byte)0xd4, (byte)0xd9, (byte)0xcd,
  (byte)0xe2, (byte)0xd7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u54a1\u7a99\u6e73\u5ecb";
bytes = new byte[] { (byte)0xcd, (byte)0xfb, (byte)0xda, (byte)0xdb,
  (byte)0xd9, (byte)0xf5, (byte)0xdd, 0x60 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7a89\u7076\uff1a";
bytes = new byte[] { (byte)0xd2, (byte)0xf7, (byte)0xa8, 0x5f, (byte)0xa1,
  0x47 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u9017\u5821\u6172";
bytes = new byte[] { (byte)0xb3, 0x72, (byte)0xb3, (byte)0xf9, (byte)0xe1,
  (byte)0xca };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff49\u7377\u0005";
bytes = new byte[] { (byte)0xa2, (byte)0xf1, (byte)0xc2, 0x78, 0x05 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u73cc\u728d\u5747";
bytes = new byte[] { (byte)0xcf, (byte)0xc7, (byte)0xde, (byte)0xa5,
  (byte)0xa7, (byte)0xa1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2266\u59ba\u71b8";
bytes = new byte[] { (byte)0xa1, (byte)0xd8, (byte)0xcc, 0x45, (byte)0xea,
  0x4a };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u67eay\u7dad\u7a98";
bytes = new byte[] { (byte)0xcf, 0x62, 0x79, (byte)0xba, (byte)0xfb,
  (byte)0xb5, 0x7e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u001c\u74a6\u258f\u7f7f";
bytes = new byte[] { 0x1c, (byte)0xc0, (byte)0xf5, (byte)0xa2, 0x6a,
  (byte)0xed, (byte)0xe2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff0f\u2557\uff27";
bytes = new byte[] { (byte)0xa1, (byte)0xfe, (byte)0xf9, (byte)0xdf,
  (byte)0xa2, (byte)0xd5 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7d9c\u6dcd";
bytes = new byte[] { (byte)0xba, (byte)0xee, (byte)0xd6, 0x45 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7c4d\u6f78\u504e";
bytes = new byte[] { (byte)0xc4, 0x79, (byte)0xbc, (byte)0xe8, (byte)0xb0,
  (byte)0xb9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u59d8\u6460\u958b";
bytes = new byte[] { (byte)0xab, (byte)0xb9, (byte)0xe1, (byte)0xeb,
  (byte)0xb6, 0x7d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6501\u6cd3=\u7904";
bytes = new byte[] { (byte)0xef, (byte)0xd5, (byte)0xaa, 0x6c, 0x3d,
  (byte)0xed, (byte)0xae };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u50ed";
bytes = new byte[] { (byte)0xb9, (byte)0xb0 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5206\u6e65\uff0c\u7e3d";
bytes = new byte[] { (byte)0xa4, (byte)0xc0, (byte)0xda, 0x4c, (byte)0xa1,
  0x41, (byte)0xc1, 0x60 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6521\u63d5\uff0a";
bytes = new byte[] { (byte)0xf6, (byte)0xe0, (byte)0xd9, 0x5f, (byte)0xa1,
  (byte)0xaf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff51\u56f0\u5614";
bytes = new byte[] { (byte)0xa2, (byte)0xf9, (byte)0xa7, 0x78, (byte)0xb9,
  (byte)0xc3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6631\uff44\u595c\u7631";
bytes = new byte[] { (byte)0xac, 0x52, (byte)0xa2, (byte)0xec, (byte)0xd4,
  (byte)0xcd, (byte)0xea, 0x6d };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u77bc\u6515\u50af\u61c2";
bytes = new byte[] { (byte)0xc2, (byte)0xa5, (byte)0xf4, 0x4d, (byte)0xb6,
  (byte)0xcd, (byte)0xc0, (byte)0xb4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u67c2\u7cde";
bytes = new byte[] { (byte)0xcf, 0x51, (byte)0xc1, 0x54 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u8810\u7009\u6209";
bytes = new byte[] { (byte)0xf4, (byte)0xc5, (byte)0xc2, 0x6d, (byte)0xc9,
  0x7c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u247a\u7d5c";
bytes = new byte[] { (byte)0xc6, (byte)0xb1, (byte)0xda, (byte)0xf4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5e28\u7e99\u742e\uff04\u576f\u7440\u8e6c";
bytes = new byte[] { (byte)0xd1, 0x74, (byte)0xf9, 0x42, (byte)0xda, 0x7a,
  (byte)0xa2, 0x43, (byte)0xcb, (byte)0xf2, (byte)0xde, (byte)0xb7,
  (byte)0xc3, (byte)0xde };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5bea\u50fd\uff1fe";
bytes = new byte[] { (byte)0xd8, (byte)0xd0, (byte)0xe4, (byte)0xf0,
  (byte)0xa1, 0x48, 0x65 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e0f\u5efb";
bytes = new byte[] { (byte)0xea, (byte)0xd9, (byte)0xfc, 0x41 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6a96";
bytes = new byte[] { (byte)0xec, (byte)0xf4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u74fb\u7141";
bytes = new byte[] { (byte)0xda, (byte)0xab, (byte)0xde, 0x70 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u72ca\u7a1a\u7e9c\u60b4";
bytes = new byte[] { (byte)0xcf, (byte)0xbe, (byte)0xb8, 0x58, (byte)0xc6,
  0x6c, (byte)0xb1, 0x7c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7e12\u56d7\u66c8\uff36";
bytes = new byte[] { (byte)0xea, (byte)0xcc, (byte)0xc9, 0x49, (byte)0xe9,
  (byte)0xb3, (byte)0xa2, (byte)0xe4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5dd5\uff17\u7dcc";
bytes = new byte[] { (byte)0xf6, (byte)0xdd, (byte)0xa2, (byte)0xb6,
  (byte)0xe3, 0x6f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6e1c\uff4b";
bytes = new byte[] { (byte)0xd9, (byte)0xf6, (byte)0xa2, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff16\u6541\u64a6";
bytes = new byte[] { (byte)0xa2, (byte)0xb5, (byte)0xce, (byte)0xe7,
  (byte)0xe1, (byte)0xe4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u75da\u5f89\u937e";
bytes = new byte[] { (byte)0xda, (byte)0xb0, (byte)0xab, (byte)0xe2,
  (byte)0xc1, (byte)0xe9 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff3f\uff0e\u6912";
bytes = new byte[] { (byte)0xa1, (byte)0xc4, (byte)0xa1, 0x44, (byte)0xb4,
  (byte)0xd4 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5556\u79be";
bytes = new byte[] { (byte)0xb0, (byte)0xdc, (byte)0xa5, (byte)0xdd };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u573b\u7083\u55d4\u2595";
bytes = new byte[] { (byte)0xa7, (byte)0xa6, (byte)0xcd, 0x5a, (byte)0xdc,
  (byte)0xd2, (byte)0xa2, 0x79 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u79d2\u2404\u5ca6";
bytes = new byte[] { (byte)0xac, (byte)0xed, (byte)0xa3, (byte)0xc4,
  (byte)0xcc, 0x6c };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2502\u6979\u5476\u610a";
bytes = new byte[] { (byte)0xa2, 0x78, (byte)0xb7, (byte)0xad, (byte)0xa9,
  0x4c, (byte)0xd9, 0x41 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6539\u74c2\u6969\uff5b\u7c4d";
bytes = new byte[] { (byte)0xa7, (byte)0xef, (byte)0xf0, 0x47, (byte)0xdd,
  (byte)0xe1, (byte)0xa1, 0x61, (byte)0xc4, 0x79 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "A\u0016\u6891";
bytes = new byte[] { 0x41, 0x16, (byte)0xd5, (byte)0xd2 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2179\u7bda\u70be\u7955\uff54";
bytes = new byte[] { (byte)0xc6, (byte)0xbe, (byte)0xea, (byte)0xbd,
  (byte)0xcf, (byte)0xb0, (byte)0xaf, (byte)0xa6, (byte)0xa2, (byte)0xfc };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u59d6";
bytes = new byte[] { (byte)0xcc, 0x4e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5e36\u6026\u78e7\uff50";
bytes = new byte[] { (byte)0xb1, 0x61, (byte)0xcc, 0x7b, (byte)0xbf, 0x6c,
  (byte)0xa2, (byte)0xf8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u7082\u5122\uff21";
bytes = new byte[] { (byte)0xcd, 0x58, (byte)0xec, (byte)0xbb, (byte)0xa2,
  (byte)0xcf };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u627a\u68ae\u2299";
bytes = new byte[] { (byte)0xca, (byte)0xef, (byte)0xd5, (byte)0xb6,
  (byte)0xa1, (byte)0xf3 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u79cb\u66eb\u5293\uff39";
bytes = new byte[] { (byte)0xac, (byte)0xee, (byte)0xf7, (byte)0xdf,
  (byte)0xbe, (byte)0xb0, (byte)0xa2, (byte)0xe7 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\uff4a\uff2d\u6ea2";
bytes = new byte[] { (byte)0xa2, (byte)0xf2, (byte)0xa2, (byte)0xdb,
  (byte)0xb7, (byte)0xb8 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6cee\u622d\u6c79";
bytes = new byte[] { (byte)0xcc, (byte)0xf1, (byte)0xe5, (byte)0xac,
  (byte)0xfd, 0x78 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u5cd6";
bytes = new byte[] { (byte)0xce, (byte)0xa6 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u2589\u71af\u52a9\u6627";
bytes = new byte[] { (byte)0xa2, 0x70, (byte)0xe6, 0x63, (byte)0xa7, 0x55,
  (byte)0xac, 0x4e };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u258a\u6948\u2ee3";
bytes = new byte[] { (byte)0xa2, 0x6f, (byte)0xdd, (byte)0xd7, (byte)0xc8,
  (byte)0xf1 };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
str = "\u6063\u57c6";
bytes = new byte[] { (byte)0xae, (byte)0xa1, (byte)0xd1, 0x4f };
TestCommon.AssertByteArraysEqual(
  bytes,
  Encodings.EncodeToBytes(str, charset));
}
}
