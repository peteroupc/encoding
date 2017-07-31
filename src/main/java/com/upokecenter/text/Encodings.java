package com.upokecenter.text;

import java.util.*;
import java.io.*;

import com.upokecenter.util.*;
import com.upokecenter.text.encoders.*;

    /**
     *
     */
  public final class Encodings {
private Encodings() {
}
    /**
     *
     */
    public static final ICharacterEncoding UTF8 = new EncodingUtf8();

    private static final Map<String, String> ValueCharsetAliases =
        CreateAliasMap();

    /**
     *
     */
    public static String DecodeToString(
     ICharacterEncoding encoding,
     IByteReader input) {
      if (encoding == null) {
        throw new NullPointerException("encoding");
      }
      if (input == null) {
        throw new NullPointerException("input");
      }
      return InputToString(
         GetDecoderInput(encoding, input));
    }

    /**
     *
     */
    public static String DecodeToString(
     ICharacterEncoding enc,
     InputStream input) {
      if (enc == null) {
        throw new NullPointerException("enc");
      }
      if (input == null) {
        throw new NullPointerException("input");
      }
      return InputToString(
         GetDecoderInput(enc, DataIO.ToReader(input)));
    }

    /**
     *
     */
    public static String DecodeToString(
  ICharacterEncoding enc,
  byte[] bytes) {
      if (enc == null) {
        throw new NullPointerException("enc");
      }
      if (bytes == null) {
        throw new NullPointerException("bytes");
      }
      return DecodeToString(enc, DataIO.ToReader(bytes));
    }

    /**
     *
     */
    public static String DecodeToString(
  ICharacterEncoding enc,
  byte[] bytes,
  int offset,
  int length) {
      if (enc == null) {
        throw new NullPointerException("enc");
      }
      if (bytes == null) {
        throw new NullPointerException("bytes");
      }
      if (offset < 0) {
        throw new IllegalArgumentException("offset (" + offset +
          ") is less than 0");
      }
      if (offset > bytes.length) {
        throw new IllegalArgumentException("offset (" + offset +
          ") is more than " + bytes.length);
      }
      if (length < 0) {
        throw new IllegalArgumentException("length (" + length +
          ") is less than 0");
      }
      if (length > bytes.length) {
        throw new IllegalArgumentException("length (" + length +
          ") is more than " + bytes.length);
      }
      if (bytes.length - offset < length) {
        throw new IllegalArgumentException("bytes's length minus " + offset + " (" +
          (bytes.length - offset) + ") is less than " + length);
      }
      return DecodeToString(enc, DataIO.ToReader(bytes, offset, length));
    }

    /**
     *
     */
    public static byte[] EncodeToBytes(
      ICharacterInput input,
      ICharacterEncoding encoding) {
      if (encoding == null) {
        throw new NullPointerException("enc");
      }
      return EncodeToBytes(input, encoding.GetEncoder());
    }

    /**
     *
     */
    public static byte[] EncodeToBytes(
      ICharacterInput input,
      ICharacterEncoder encoder) {
      if (encoder == null) {
        throw new NullPointerException("encoder");
      }
      if (input == null) {
        throw new NullPointerException("input");
      }
      ArrayWriter writer = new ArrayWriter();
      while (true) {
        int cp = input.ReadChar();
        int enc = encoder.Encode(cp, writer);
        if (enc == -2) {
          // Not encodable, write a question mark instead
          writer.write((byte)0x3f);
        }
        if (enc == -1) {
          break;
        }
      }
      return writer.ToArray();
    }

    /**
     *
     */
    public static byte[] EncodeToBytes(
  String str,
  ICharacterEncoding enc) {
      if (str == null) {
        throw new NullPointerException("str");
      }
      if (enc == null) {
        throw new NullPointerException("enc");
      }
      return EncodeToBytes(new CharacterReader(str), enc);
    }

    /**
     *
     */
    public static void EncodeToWriter(
      ICharacterInput input,
      ICharacterEncoding encoding,
      IWriter writer) {
      if (encoding == null) {
        throw new NullPointerException("enc");
      }
      EncodeToWriter(input, encoding.GetEncoder(), writer);
    }

    /**
     *
     */
    public static void EncodeToWriter(
      ICharacterInput input,
      ICharacterEncoder encoder,
      IWriter writer) {
      if (encoder == null) {
        throw new NullPointerException("encoder");
      }
      if (input == null) {
        throw new NullPointerException("input");
      }
      if (writer == null) {
        throw new NullPointerException("writer");
      }
      while (true) {
        int cp = input.ReadChar();
        int enc = encoder.Encode(cp, writer);
        if (enc == -2) {
          // Not encodable, write a question mark instead
          writer.write((byte)0x3f);
        }
        if (enc == -1) {
          break;
        }
      }
    }

    /**
     *
     */
    public static void EncodeToWriter(
  String str,
  ICharacterEncoding enc,
  IWriter writer) {
      if (str == null) {
        throw new NullPointerException("str");
      }
      if (enc == null) {
        throw new NullPointerException("enc");
      }
      EncodeToWriter(new CharacterReader(str), enc, writer);
    }

    /**
     *
     */
    public static void EncodeToWriter(
      ICharacterInput input,
      ICharacterEncoding encoding,
      OutputStream output) throws java.io.IOException {
      if (encoding == null) {
        throw new NullPointerException("enc");
      }
      EncodeToWriter(input, encoding.GetEncoder(), DataIO.ToWriter(output));
    }

    /**
     *
     */
    public static void EncodeToWriter(
      ICharacterInput input,
      ICharacterEncoder encoder,
      OutputStream output) throws java.io.IOException {
      IWriter writer = DataIO.ToWriter(output);
        EncodeToWriter(input, encoder, writer);
    }

    /**
     *
     */
    public static void EncodeToWriter(
  String str,
  ICharacterEncoding enc,
  OutputStream output) throws java.io.IOException {
      if (str == null) {
        throw new NullPointerException("str");
      }
      if (enc == null) {
        throw new NullPointerException("enc");
      }
   EncodeToWriter(
  new CharacterReader(str),
  enc,
  DataIO.ToWriter(output));
    }

    /**
     *
     */
    public static ICharacterInput GetDecoderInput(
      ICharacterEncoding encoding,
      IByteReader stream) {
      return new DecoderToInputClass(
        encoding.GetDecoder(),
        stream);
    }

    /**
     *
     */
    public static ICharacterInput GetDecoderInput(
      ICharacterEncoding encoding,
      InputStream input) {
      return new DecoderToInputClass(
        encoding.GetDecoder(),
        DataIO.ToReader(input));
    }

    /**
     *
     */
    public static ICharacterInput GetDecoderInputSkipBom(
      ICharacterEncoding encoding,
      IByteReader stream) {
      return EncoderAlgorithms.DecodeAlgorithmInput(stream, encoding);
    }

    /**
     *
     */
    public static ICharacterInput GetDecoderInputSkipBom(
      ICharacterEncoding encoding,
      InputStream input) {
      return EncoderAlgorithms.DecodeAlgorithmInput(
        DataIO.ToReader(input),
        encoding);
    }

    /**
     *
     */
    public static ICharacterEncoding GetEncoding(String name) {
      return GetEncoding(name, false, false);
    }

    /**
     *
     */
    public static ICharacterEncoding GetEncoding(String name, boolean forEmail) {
      return GetEncoding(name, forEmail, false);
    }

    /**
     *
     */
    public static ICharacterEncoding GetEncoding(
  String name,
  boolean forEmail,
  boolean allowReplacement) {
      if (((name) == null || (name).length() == 0)) {
        return null;
      }
      if (allowReplacement) {
        name = TrimAsciiWhite(name);
        name = ToLowerCaseAscii(name);
        if (name.equals("replacement")) {
          return new EncodingReplacement();
        }
      }
      name = forEmail ? ResolveAliasForEmail(name) :
        ResolveAlias(name);
      if (name.equals("UTF-8")) {
        return UTF8;
      }
      if (name.equals("US-ASCII")) {
        return (ICharacterEncoding)(new EncodingAscii());
      }
      if (name.equals("ISO-8859-1")) {
        return (ICharacterEncoding)(new EncodingLatinOne());
      }
      if (name.equals("UTF-7")) {
        return (ICharacterEncoding)(new EncodingUtf7());
      }
if (name.equals("windows-1252")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129, 8218,
    402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143,
    144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250,
    339, 157, 382, 376, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169,
    170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183,
    184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197,
    198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211,
    212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225,
    226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239,
    240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253,
    254, 255 });
}
if (name.equals("windows-1253")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129, 8218,
    402, 8222, 8230, 8224, 8225, 136, 8240, 138, 8249, 140, 141, 142, 143,
    144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 152, 8482, 154, 8250,
    156, 157, 158, 159, 160, 901, 902, 163, 164, 165, 166, 167, 168, 169,
    -2, 171, 172, 173, 174, 8213, 176, 177, 178, 179, 900, 181, 182, 183,
    904, 905, 906, 187, 908, 189, 910, 911, 912, 913, 914, 915, 916, 917,
    918, 919, 920, 921, 922, 923, 924, 925, 926, 927, 928, 929, -2, 931,
    932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945,
    946, 947, 948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959,
    960, 961, 962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973,
    974, -2 });
}
if (name.equals("ISO-8859-15")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
    131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
    145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
    159, 160, 161, 162, 163, 8364, 165, 352, 167, 353, 169, 170, 171, 172,
    173, 174, 175, 176, 177, 178, 179, 381, 181, 182, 183, 382, 185, 186,
    187, 338, 339, 376, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200,
    201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214,
    215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228,
    229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242,
    243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255 });
}
if (name.equals("ISO-8859-3")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
    131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
    145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
    159, 160, 294, 728, 163, 164, -2, 292, 167, 168, 304, 350, 286, 308,
    173, -2, 379, 176, 295, 178, 179, 180, 181, 293, 183, 184, 305, 351,
    287, 309, 189, -2, 380, 192, 193, 194, -2, 196, 266, 264, 199, 200, 201,
    202, 203, 204, 205, 206, 207, -2, 209, 210, 211, 212, 288, 214, 215,
    284, 217, 218, 219, 220, 364, 348, 223, 224, 225, 226, -2, 228, 267,
    265, 231, 232, 233, 234, 235, 236, 237, 238, 239, -2, 241, 242, 243,
    244, 289, 246, 247, 285, 249, 250, 251, 252, 365, 349, 729 });
}
if (name.equals("windows-1258")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129, 8218,
    402, 8222, 8230, 8224, 8225, 710, 8240, 138, 8249, 338, 141, 142, 143,
    144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 154, 8250,
    339, 157, 158, 376, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169,
    170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183,
    184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 258, 196, 197,
    198, 199, 200, 201, 202, 203, 768, 205, 206, 207, 272, 209, 777, 211,
    212, 416, 214, 215, 216, 217, 218, 219, 220, 431, 771, 223, 224, 225,
    226, 259, 228, 229, 230, 231, 232, 233, 234, 235, 769, 237, 238, 239,
    273, 241, 803, 243, 244, 417, 246, 247, 248, 249, 250, 251, 252, 432,
    8363, 255 });
}
if (name.equals("ISO-8859-2")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
    131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
    145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
    159, 160, 260, 728, 321, 164, 317, 346, 167, 168, 352, 350, 356, 377,
    173, 381, 379, 176, 261, 731, 322, 180, 318, 347, 711, 184, 353, 351,
    357, 378, 733, 382, 380, 340, 193, 194, 258, 196, 313, 262, 199, 268,
    201, 280, 203, 282, 205, 206, 270, 272, 323, 327, 211, 212, 336, 214,
    215, 344, 366, 218, 368, 220, 221, 354, 223, 341, 225, 226, 259, 228,
    314, 263, 231, 269, 233, 281, 235, 283, 237, 238, 271, 273, 324, 328,
    243, 244, 337, 246, 247, 345, 367, 250, 369, 252, 253, 355, 729 });
}
if (name.equals("ISO-8859-5")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
    131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
    145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
    159, 160, 1025, 1026, 1027, 1028, 1029, 1030, 1031, 1032, 1033, 1034,
    1035, 1036, 173, 1038, 1039, 1040, 1041, 1042, 1043, 1044, 1045, 1046,
    1047, 1048, 1049, 1050, 1051, 1052, 1053, 1054, 1055, 1056, 1057, 1058,
    1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068, 1069, 1070,
    1071, 1072, 1073, 1074, 1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082,
    1083, 1084, 1085, 1086, 1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094,
    1095, 1096, 1097, 1098, 1099, 1100, 1101, 1102, 1103, 8470, 1105, 1106,
    1107, 1108, 1109, 1110, 1111, 1112, 1113, 1114, 1115, 1116, 167, 1118,
    1119 });
}
if (name.equals("windows-874")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129, 130,
    131, 132, 8230, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
    8216, 8217, 8220, 8221, 8226, 8211, 8212, 152, 153, 154, 155, 156, 157,
    158, 159, 160, 3585, 3586, 3587, 3588, 3589, 3590, 3591, 3592, 3593,
    3594, 3595, 3596, 3597, 3598, 3599, 3600, 3601, 3602, 3603, 3604, 3605,
    3606, 3607, 3608, 3609, 3610, 3611, 3612, 3613, 3614, 3615, 3616, 3617,
    3618, 3619, 3620, 3621, 3622, 3623, 3624, 3625, 3626, 3627, 3628, 3629,
    3630, 3631, 3632, 3633, 3634, 3635, 3636, 3637, 3638, 3639, 3640, 3641,
    3642, -2, -2, -2, -2, 3647, 3648, 3649, 3650, 3651, 3652, 3653, 3654,
    3655, 3656, 3657, 3658, 3659, 3660, 3661, 3662, 3663, 3664, 3665, 3666,
    3667, 3668, 3669, 3670, 3671, 3672, 3673, 3674, 3675, -2, -2, -2, -2 });
}
if (name.equals("macintosh")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 196, 197, 199,
    201, 209, 214, 220, 225, 224, 226, 228, 227, 229, 231, 233, 232, 234,
    235, 237, 236, 238, 239, 241, 243, 242, 244, 246, 245, 250, 249, 251,
    252, 8224, 176, 162, 163, 167, 8226, 182, 223, 174, 169, 8482, 180, 168,
    8800, 198, 216, 8734, 177, 8804, 8805, 165, 181, 8706, 8721, 8719, 960,
    8747, 170, 186, 937, 230, 248, 191, 161, 172, 8730, 402, 8776, 8710,
    171, 187, 8230, 160, 192, 195, 213, 338, 339, 8211, 8212, 8220, 8221,
    8216, 8217, 247, 9674, 255, 376, 8260, 8364, 8249, 8250, 64257, 64258,
    8225, 183, 8218, 8222, 8240, 194, 202, 193, 203, 200, 205, 206, 207,
    204, 211, 212, 63743, 210, 218, 219, 217, 305, 710, 732, 175, 728, 729,
    730, 184, 733, 731, 711 });
}
if (name.equals("ISO-8859-10")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
    131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
    145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
    159, 160, 260, 274, 290, 298, 296, 310, 167, 315, 272, 352, 358, 381,
    173, 362, 330, 176, 261, 275, 291, 299, 297, 311, 183, 316, 273, 353,
    359, 382, 8213, 363, 331, 256, 193, 194, 195, 196, 197, 198, 302, 268,
    201, 280, 203, 278, 205, 206, 207, 208, 325, 332, 211, 212, 213, 214,
    360, 216, 370, 218, 219, 220, 221, 222, 223, 257, 225, 226, 227, 228,
    229, 230, 303, 269, 233, 281, 235, 279, 237, 238, 239, 240, 326, 333,
    243, 244, 245, 246, 361, 248, 371, 250, 251, 252, 253, 254, 312 });
}
if (name.equals("windows-1257")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129, 8218,
    131, 8222, 8230, 8224, 8225, 136, 8240, 138, 8249, 140, 168, 711, 184,
    144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 152, 8482, 154, 8250,
    156, 175, 731, 159, 160, -2, 162, 163, 164, -2, 166, 167, 216, 169, 342,
    171, 172, 173, 174, 198, 176, 177, 178, 179, 180, 181, 182, 183, 248,
    185, 343, 187, 188, 189, 190, 230, 260, 302, 256, 262, 196, 197, 280,
    274, 268, 201, 377, 278, 290, 310, 298, 315, 352, 323, 325, 211, 332,
    213, 214, 215, 370, 321, 346, 362, 220, 379, 381, 223, 261, 303, 257,
    263, 228, 229, 281, 275, 269, 233, 378, 279, 291, 311, 299, 316, 353,
    324, 326, 243, 333, 245, 246, 247, 371, 322, 347, 363, 252, 380, 382,
    729 });
}
if (name.equals("windows-1250")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129, 8218,
    131, 8222, 8230, 8224, 8225, 136, 8240, 352, 8249, 346, 356, 381, 377,
    144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 152, 8482, 353, 8250,
    347, 357, 382, 378, 160, 711, 728, 321, 164, 260, 166, 167, 168, 169,
    350, 171, 172, 173, 174, 379, 176, 177, 731, 322, 180, 181, 182, 183,
    184, 261, 351, 187, 317, 733, 318, 380, 340, 193, 194, 258, 196, 313,
    262, 199, 268, 201, 280, 203, 282, 205, 206, 270, 272, 323, 327, 211,
    212, 336, 214, 215, 344, 366, 218, 368, 220, 221, 354, 223, 341, 225,
    226, 259, 228, 314, 263, 231, 269, 233, 281, 235, 283, 237, 238, 271,
    273, 324, 328, 243, 244, 337, 246, 247, 345, 367, 250, 369, 252, 253,
    355, 729 });
}
if (name.equals("ISO-8859-14")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
    131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
    145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
    159, 160, 7682, 7683, 163, 266, 267, 7690, 167, 7808, 169, 7810, 7691,
    7922, 173, 174, 376, 7710, 7711, 288, 289, 7744, 7745, 182, 7766, 7809,
    7767, 7811, 7776, 7923, 7812, 7813, 7777, 192, 193, 194, 195, 196, 197,
    198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 372, 209, 210, 211,
    212, 213, 214, 7786, 216, 217, 218, 219, 220, 221, 374, 223, 224, 225,
    226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239,
    373, 241, 242, 243, 244, 245, 246, 7787, 248, 249, 250, 251, 252, 253,
    375, 255 });
}
if (name.equals("ISO-8859-4")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
    131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
    145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
    159, 160, 260, 312, 342, 164, 296, 315, 167, 168, 352, 274, 290, 358,
    173, 381, 175, 176, 261, 731, 343, 180, 297, 316, 711, 184, 353, 275,
    291, 359, 330, 382, 331, 256, 193, 194, 195, 196, 197, 198, 302, 268,
    201, 280, 203, 278, 205, 206, 298, 272, 325, 332, 310, 212, 213, 214,
    215, 216, 370, 218, 219, 220, 360, 362, 223, 257, 225, 226, 227, 228,
    229, 230, 303, 269, 233, 281, 235, 279, 237, 238, 299, 273, 326, 333,
    311, 244, 245, 246, 247, 248, 371, 250, 251, 252, 361, 363, 729 });
}
if (name.equals("ISO-8859-8") || name.equals("ISO-8859-8-I")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
    131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
    145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
    159, 160, -2, 162, 163, 164, 165, 166, 167, 168, 169, 215, 171, 172,
    173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 247,
    187, 188, 189, 190, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
    -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
    -2, 8215, 1488, 1489, 1490, 1491, 1492, 1493, 1494, 1495, 1496, 1497,
    1498, 1499, 1500, 1501, 1502, 1503, 1504, 1505, 1506, 1507, 1508, 1509,
    1510, 1511, 1512, 1513, 1514, -2, -2, 8206, 8207, -2 });
}
if (name.equals("KOI8-R")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 9472, 9474,
    9484, 9488, 9492, 9496, 9500, 9508, 9516, 9524, 9532, 9600, 9604, 9608,
    9612, 9616, 9617, 9618, 9619, 8992, 9632, 8729, 8730, 8776, 8804, 8805,
    160, 8993, 176, 178, 183, 247, 9552, 9553, 9554, 1105, 9555, 9556, 9557,
    9558, 9559, 9560, 9561, 9562, 9563, 9564, 9565, 9566, 9567, 9568, 9569,
    1025, 9570, 9571, 9572, 9573, 9574, 9575, 9576, 9577, 9578, 9579, 9580,
    169, 1102, 1072, 1073, 1094, 1076, 1077, 1092, 1075, 1093, 1080, 1081,
    1082, 1083, 1084, 1085, 1086, 1087, 1103, 1088, 1089, 1090, 1091, 1078,
    1074, 1100, 1099, 1079, 1096, 1101, 1097, 1095, 1098, 1070, 1040, 1041,
    1062, 1044, 1045, 1060, 1043, 1061, 1048, 1049, 1050, 1051, 1052, 1053,
    1054, 1055, 1071, 1056, 1057, 1058, 1059, 1046, 1042, 1068, 1067, 1047,
    1064, 1069, 1065, 1063, 1066 });
}
if (name.equals("ISO-8859-6")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
    131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
    145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
    159, 160, -2, -2, -2, 164, -2, -2, -2, -2, -2, -2, -2, 1548, 173, -2,
    -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, 1563, -2, -2, -2, 1567,
    -2, 1569, 1570, 1571, 1572, 1573, 1574, 1575, 1576, 1577, 1578, 1579,
    1580, 1581, 1582, 1583, 1584, 1585, 1586, 1587, 1588, 1589, 1590, 1591,
    1592, 1593, 1594, -2, -2, -2, -2, -2, 1600, 1601, 1602, 1603, 1604,
    1605, 1606, 1607, 1608, 1609, 1610, 1611, 1612, 1613, 1614, 1615, 1616,
    1617, 1618, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2 });
}
if (name.equals("windows-1254")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129, 8218,
    402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 142, 143,
    144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250,
    339, 157, 158, 376, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169,
    170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183,
    184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197,
    198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 286, 209, 210, 211,
    212, 213, 214, 215, 216, 217, 218, 219, 220, 304, 350, 223, 224, 225,
    226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239,
    287, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 305,
    351, 255 });
}
if (name.equals("windows-1255")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129, 8218,
    402, 8222, 8230, 8224, 8225, 710, 8240, 138, 8249, 140, 141, 142, 143,
    144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 154, 8250,
    156, 157, 158, 159, 160, 161, 162, 163, 8362, 165, 166, 167, 168, 169,
    215, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183,
    184, 185, 247, 187, 188, 189, 190, 191, 1456, 1457, 1458, 1459, 1460,
    1461, 1462, 1463, 1464, 1465, 1466, 1467, 1468, 1469, 1470, 1471, 1472,
    1473, 1474, 1475, 1520, 1521, 1522, 1523, 1524, -2, -2, -2, -2, -2, -2,
    -2, 1488, 1489, 1490, 1491, 1492, 1493, 1494, 1495, 1496, 1497, 1498,
    1499, 1500, 1501, 1502, 1503, 1504, 1505, 1506, 1507, 1508, 1509, 1510,
    1511, 1512, 1513, 1514, -2, -2, 8206, 8207, -2 });
}
if (name.equals("ISO-8859-16")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
    131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
    145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
    159, 160, 260, 261, 321, 8364, 8222, 352, 167, 353, 169, 536, 171, 377,
    173, 378, 379, 176, 177, 268, 322, 381, 8221, 182, 183, 382, 269, 537,
    187, 338, 339, 376, 380, 192, 193, 194, 258, 196, 262, 198, 199, 200,
    201, 202, 203, 204, 205, 206, 207, 272, 323, 210, 211, 212, 336, 214,
    346, 368, 217, 218, 219, 220, 280, 538, 223, 224, 225, 226, 259, 228,
    263, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 273, 324, 242,
    243, 244, 337, 246, 347, 369, 249, 250, 251, 252, 281, 539, 255 });
}
if (name.equals("IBM866")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 1040, 1041,
    1042, 1043, 1044, 1045, 1046, 1047, 1048, 1049, 1050, 1051, 1052, 1053,
    1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065,
    1066, 1067, 1068, 1069, 1070, 1071, 1072, 1073, 1074, 1075, 1076, 1077,
    1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085, 1086, 1087, 9617, 9618,
    9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565, 9564,
    9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562, 9556,
    9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560, 9554,
    9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 1088, 1089,
    1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097, 1098, 1099, 1100, 1101,
    1102, 1103, 1025, 1105, 1028, 1108, 1031, 1111, 1038, 1118, 176, 8729,
    183, 8730, 8470, 164, 9632, 160 });
}
if (name.equals("x-mac-cyrillic")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 1040, 1041,
    1042, 1043, 1044, 1045, 1046, 1047, 1048, 1049, 1050, 1051, 1052, 1053,
    1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065,
    1066, 1067, 1068, 1069, 1070, 1071, 8224, 176, 1168, 163, 167, 8226,
    182, 1030, 174, 169, 8482, 1026, 1106, 8800, 1027, 1107, 8734, 177,
    8804, 8805, 1110, 181, 1169, 1032, 1028, 1108, 1031, 1111, 1033, 1113,
    1034, 1114, 1112, 1029, 172, 8730, 402, 8776, 8710, 171, 187, 8230, 160,
    1035, 1115, 1036, 1116, 1109, 8211, 8212, 8220, 8221, 8216, 8217, 247,
    8222, 1038, 1118, 1039, 1119, 8470, 1025, 1105, 1103, 1072, 1073, 1074,
    1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085, 1086,
    1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097, 1098,
    1099, 1100, 1101, 1102, 8364 });
}
if (name.equals("windows-1251")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 1026, 1027,
    8218, 1107, 8222, 8230, 8224, 8225, 8364, 8240, 1033, 8249, 1034, 1036,
    1035, 1039, 1106, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 152, 8482,
    1113, 8250, 1114, 1116, 1115, 1119, 160, 1038, 1118, 1032, 164, 1168,
    166, 167, 1025, 169, 1028, 171, 172, 173, 174, 1031, 176, 177, 1030,
    1110, 1169, 181, 182, 183, 1105, 8470, 1108, 187, 1112, 1029, 1109,
    1111, 1040, 1041, 1042, 1043, 1044, 1045, 1046, 1047, 1048, 1049, 1050,
    1051, 1052, 1053, 1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062,
    1063, 1064, 1065, 1066, 1067, 1068, 1069, 1070, 1071, 1072, 1073, 1074,
    1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085, 1086,
    1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097, 1098,
    1099, 1100, 1101, 1102, 1103 });
}
if (name.equals("windows-1256")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 1662,
    8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 1657, 8249, 338, 1670,
    1688, 1672, 1711, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 1705, 8482,
    1681, 8250, 339, 8204, 8205, 1722, 160, 1548, 162, 163, 164, 165, 166,
    167, 168, 169, 1726, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180,
    181, 182, 183, 184, 185, 1563, 187, 188, 189, 190, 1567, 1729, 1569,
    1570, 1571, 1572, 1573, 1574, 1575, 1576, 1577, 1578, 1579, 1580, 1581,
    1582, 1583, 1584, 1585, 1586, 1587, 1588, 1589, 1590, 215, 1591, 1592,
    1593, 1594, 1600, 1601, 1602, 1603, 224, 1604, 226, 1605, 1606, 1607,
    1608, 231, 232, 233, 234, 235, 1609, 1610, 238, 239, 1611, 1612, 1613,
    1614, 244, 1615, 1616, 247, 1617, 249, 1618, 251, 252, 8206, 8207, 1746
    });
}
if (name.equals("KOI8-U")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 9472, 9474,
    9484, 9488, 9492, 9496, 9500, 9508, 9516, 9524, 9532, 9600, 9604, 9608,
    9612, 9616, 9617, 9618, 9619, 8992, 9632, 8729, 8730, 8776, 8804, 8805,
    160, 8993, 176, 178, 183, 247, 9552, 9553, 9554, 1105, 1108, 9556, 1110,
    1111, 9559, 9560, 9561, 9562, 9563, 1169, 1118, 9566, 9567, 9568, 9569,
    1025, 1028, 9571, 1030, 1031, 9574, 9575, 9576, 9577, 9578, 1168, 1038,
    169, 1102, 1072, 1073, 1094, 1076, 1077, 1092, 1075, 1093, 1080, 1081,
    1082, 1083, 1084, 1085, 1086, 1087, 1103, 1088, 1089, 1090, 1091, 1078,
    1074, 1100, 1099, 1079, 1096, 1101, 1097, 1095, 1098, 1070, 1040, 1041,
    1062, 1044, 1045, 1060, 1043, 1061, 1048, 1049, 1050, 1051, 1052, 1053,
    1054, 1055, 1071, 1056, 1057, 1058, 1059, 1046, 1042, 1068, 1067, 1047,
    1064, 1069, 1065, 1063, 1066 });
}
if (name.equals("ISO-8859-7")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
    131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
    145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
    159, 160, 8216, 8217, 163, 8364, 8367, 166, 167, 168, 169, 890, 171,
    172, 173, -2, 8213, 176, 177, 178, 179, 900, 901, 902, 183, 904, 905,
    906, 187, 908, 189, 910, 911, 912, 913, 914, 915, 916, 917, 918, 919,
    920, 921, 922, 923, 924, 925, 926, 927, 928, 929, -2, 931, 932, 933,
    934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 947,
    948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959, 960, 961,
    962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, -2 });
}
if (name.equals("ISO-8859-13")) {
  return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
    131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
    145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
    159, 160, 8221, 162, 163, 164, 8222, 166, 167, 216, 169, 342, 171, 172,
    173, 174, 198, 176, 177, 178, 179, 8220, 181, 182, 183, 248, 185, 343,
    187, 188, 189, 190, 230, 260, 302, 256, 262, 196, 197, 280, 274, 268,
    201, 377, 278, 290, 310, 298, 315, 352, 323, 325, 211, 332, 213, 214,
    215, 370, 321, 346, 362, 220, 379, 381, 223, 261, 303, 257, 263, 228,
    229, 281, 275, 269, 233, 378, 279, 291, 311, 299, 316, 353, 324, 326,
    243, 333, 245, 246, 247, 371, 322, 347, 363, 252, 380, 382, 8217 });
     } else if (name.equals("EUC-JP")) {
        return (ICharacterEncoding)(new EncodingEUCJP());
      } else if (name.equals("EUC-KR")) {
        return (ICharacterEncoding)(new EncodingKoreanEUC());
      } else if (name.equals("Big5")) {
        return (ICharacterEncoding)(new EncodingBig5());
      } else if (name.equals("Shift_JIS")) {
        return (ICharacterEncoding)(new EncodingShiftJIS());
      } else if (name.equals("x-user-defined")) {
        return (ICharacterEncoding)(new EncodingXUserDefined());
      } else if (name.equals("GBK")) {
        return (ICharacterEncoding)(new EncodingGBK());
      } else if (name.equals("gb18030")) {
        return (ICharacterEncoding)(new EncodingGB18030());
      } else if (name.equals("UTF-16LE")) {
        return (ICharacterEncoding)(new EncodingUtf16());
      } else if (name.equals("UTF-16BE")) {
        return (ICharacterEncoding)(new EncodingUtf16BE());
      }
      return name.equals("ISO-2022-JP") ? (ICharacterEncoding)(new
        EncodingISO2022JP()) :
        (name.equals("replacement") ? (ICharacterEncoding)(new
          EncodingReplacement()) : null);
    }

    /**
     *
     */
    public static String InputToString(ICharacterInput reader) {
      StringBuilder builder = new StringBuilder();
      while (true) {
        int c = reader.ReadChar();
        if (c < 0) {
          break;
        }
        if (c <= 0xffff) {
          builder.append((char)c);
        } else if (c <= 0x10ffff) {
          builder.append((char)((((c - 0x10000) >> 10) & 0x3ff) + 0xd800));
          builder.append((char)(((c - 0x10000) & 0x3ff) + 0xdc00));
        }
      }
      return builder.toString();
    }

    /**
     *
     */
    public static String ResolveAlias(String name) {
      if (((name) == null || (name).length() == 0)) {
        return "";
      }
      name = TrimAsciiWhite(name);
      name = ToLowerCaseAscii(name);
      return ValueCharsetAliases.containsKey(name) ? ValueCharsetAliases.get(name) :
             "";
    }

    /**
     *
     */
    public static String ResolveAliasForEmail(String name) {
      if (((name) == null || (name).length() == 0)) {
        return "";
      }
      name = TrimAsciiWhite(name);
      name = ToLowerCaseAscii(name);
      if (name.equals("utf-8")) {
        return "UTF-8";
      }
      if (name.equals("iso-8859-1")) {
        return "ISO-8859-1";
      }
      if (name.equals("us-ascii") || name.equals("ascii") ||
        name.equals("ansi_x3.4-1968")) {
        // DEVIATION: "ascii" is not an IANA-registered name,
        // but occurs quite frequently
        return "US-ASCII";
      }
      if (ValueCharsetAliases.containsKey(name)) {
        return ValueCharsetAliases.get(name);
      }
      if (name.equals("iso-2022-jp-2")) {
        // NOTE: Treat as the same as iso-2022-jp
        return "ISO-2022-JP";
      }
      if (name.equals("utf-7") || name.equals("unicode-1-1-utf-7")) {
        return "UTF-7";
      }
      if (name.length() > 9 && name.substring(0,9).equals("iso-8859-")) {
        // NOTE: For conformance to MIME, treat unknown iso-8859-* encodings
        // as ASCII
        return "US-ASCII";
      }
      return "";
    }

    /**
     *
     */
    public static byte[] StringToBytes(
      ICharacterEncoding encoding,
      String str) {
      if (encoding == null) {
        throw new NullPointerException("enc");
      }
      return StringToBytes(encoding.GetEncoder(), str);
    }

    /**
     *
     */
    public static byte[] StringToBytes(
      ICharacterEncoder encoder,
      String str) {
      if (encoder == null) {
        throw new NullPointerException("encoder");
      }
      if (str == null) {
        throw new NullPointerException("str");
      }
      return EncodeToBytes(
          new CharacterReader(str),
          encoder);
    }

    /**
     *
     */
    public static ICharacterInput StringToInput(String str) {
      if (str == null) {
        throw new NullPointerException("str");
      }
      return StringToInput(str, 0, str.length());
    }

    /**
     *
     */
    public static ICharacterInput StringToInput(
  String str,
  int offset,
  int length) {
      if (str == null) {
        throw new NullPointerException("str");
      }
      if (offset < 0) {
        throw new IllegalArgumentException("offset (" + offset +
          ") is less than 0");
      }
      if (offset > str.length()) {
        throw new IllegalArgumentException("offset (" + offset +
          ") is more than " + str.length());
      }
      if (length < 0) {
        throw new IllegalArgumentException("length (" + length +
          ") is less than 0");
      }
      if (length > str.length()) {
        throw new IllegalArgumentException("length (" + length +
          ") is more than " + str.length());
      }
      if (str.length() - offset < length) {
        throw new IllegalArgumentException("str's length minus " + offset + " (" +
          (str.length() - offset) + ") is less than " + length);
      }
      return new CharacterReader(str, offset, length);
    }

    private static Map<String, String> CreateAliasMap() {
      HashMap<String, String> aliases = new HashMap<String, String>();
  aliases.put("unicode-1-1-utf-8","UTF-8");
aliases.put("utf-8","UTF-8");
aliases.put("utf8","UTF-8");
aliases.put("866","IBM866");
aliases.put("cp866","IBM866");
aliases.put("csibm866","IBM866");
aliases.put("ibm866","IBM866");
aliases.put("csisolatin2","ISO-8859-2");
aliases.put("iso-8859-2","ISO-8859-2");
aliases.put("iso-ir-101","ISO-8859-2");
aliases.put("iso8859-2","ISO-8859-2");
aliases.put("iso88592","ISO-8859-2");
aliases.put("iso_8859-2","ISO-8859-2");
aliases.put("iso_8859-2:1987","ISO-8859-2");
aliases.put("l2","ISO-8859-2");
aliases.put("latin2","ISO-8859-2");
aliases.put("csisolatin3","ISO-8859-3");
aliases.put("iso-8859-3","ISO-8859-3");
aliases.put("iso-ir-109","ISO-8859-3");
aliases.put("iso8859-3","ISO-8859-3");
aliases.put("iso88593","ISO-8859-3");
aliases.put("iso_8859-3","ISO-8859-3");
aliases.put("iso_8859-3:1988","ISO-8859-3");
aliases.put("l3","ISO-8859-3");
aliases.put("latin3","ISO-8859-3");
aliases.put("csisolatin4","ISO-8859-4");
aliases.put("iso-8859-4","ISO-8859-4");
aliases.put("iso-ir-110","ISO-8859-4");
aliases.put("iso8859-4","ISO-8859-4");
aliases.put("iso88594","ISO-8859-4");
aliases.put("iso_8859-4","ISO-8859-4");
aliases.put("iso_8859-4:1988","ISO-8859-4");
aliases.put("l4","ISO-8859-4");
aliases.put("latin4","ISO-8859-4");
aliases.put("csisolatincyrillic","ISO-8859-5");
aliases.put("cyrillic","ISO-8859-5");
aliases.put("iso-8859-5","ISO-8859-5");
aliases.put("iso-ir-144","ISO-8859-5");
aliases.put("iso8859-5","ISO-8859-5");
aliases.put("iso88595","ISO-8859-5");
aliases.put("iso_8859-5","ISO-8859-5");
aliases.put("iso_8859-5:1988","ISO-8859-5");
aliases.put("arabic","ISO-8859-6");
aliases.put("asmo-708","ISO-8859-6");
aliases.put("csiso88596e","ISO-8859-6");
aliases.put("csiso88596i","ISO-8859-6");
aliases.put("csisolatinarabic","ISO-8859-6");
aliases.put("ecma-114","ISO-8859-6");
aliases.put("iso-8859-6","ISO-8859-6");
aliases.put("iso-8859-6-e","ISO-8859-6");
aliases.put("iso-8859-6-i","ISO-8859-6");
aliases.put("iso-ir-127","ISO-8859-6");
aliases.put("iso8859-6","ISO-8859-6");
aliases.put("iso88596","ISO-8859-6");
aliases.put("iso_8859-6","ISO-8859-6");
aliases.put("iso_8859-6:1987","ISO-8859-6");
aliases.put("csisolatingreek","ISO-8859-7");
aliases.put("ecma-118","ISO-8859-7");
aliases.put("elot_928","ISO-8859-7");
aliases.put("greek","ISO-8859-7");
aliases.put("greek8","ISO-8859-7");
aliases.put("iso-8859-7","ISO-8859-7");
aliases.put("iso-ir-126","ISO-8859-7");
aliases.put("iso8859-7","ISO-8859-7");
aliases.put("iso88597","ISO-8859-7");
aliases.put("iso_8859-7","ISO-8859-7");
aliases.put("iso_8859-7:1987","ISO-8859-7");
aliases.put("sun_eu_greek","ISO-8859-7");
aliases.put("csiso88598e","ISO-8859-8");
aliases.put("csisolatinhebrew","ISO-8859-8");
aliases.put("hebrew","ISO-8859-8");
aliases.put("iso-8859-8","ISO-8859-8");
aliases.put("iso-8859-8-e","ISO-8859-8");
aliases.put("iso-ir-138","ISO-8859-8");
aliases.put("iso8859-8","ISO-8859-8");
aliases.put("iso88598","ISO-8859-8");
aliases.put("iso_8859-8","ISO-8859-8");
aliases.put("iso_8859-8:1988","ISO-8859-8");
aliases.put("visual","ISO-8859-8");
aliases.put("csiso88598i","ISO-8859-8-I");
aliases.put("iso-8859-8-i","ISO-8859-8-I");
aliases.put("logical","ISO-8859-8-I");
aliases.put("csisolatin6","ISO-8859-10");
aliases.put("iso-8859-10","ISO-8859-10");
aliases.put("iso-ir-157","ISO-8859-10");
aliases.put("iso8859-10","ISO-8859-10");
aliases.put("iso885910","ISO-8859-10");
aliases.put("l6","ISO-8859-10");
aliases.put("latin6","ISO-8859-10");
aliases.put("iso-8859-13","ISO-8859-13");
aliases.put("iso8859-13","ISO-8859-13");
aliases.put("iso885913","ISO-8859-13");
aliases.put("iso-8859-14","ISO-8859-14");
aliases.put("iso8859-14","ISO-8859-14");
aliases.put("iso885914","ISO-8859-14");
aliases.put("csisolatin9","ISO-8859-15");
aliases.put("iso-8859-15","ISO-8859-15");
aliases.put("iso8859-15","ISO-8859-15");
aliases.put("iso885915","ISO-8859-15");
aliases.put("iso_8859-15","ISO-8859-15");
aliases.put("l9","ISO-8859-15");
aliases.put("iso-8859-16","ISO-8859-16");
aliases.put("cskoi8r","KOI8-R");
aliases.put("koi","KOI8-R");
aliases.put("koi8","KOI8-R");
aliases.put("koi8-r","KOI8-R");
aliases.put("koi8_r","KOI8-R");
aliases.put("koi8-ru","KOI8-U");
aliases.put("koi8-u","KOI8-U");
aliases.put("csmacintosh","macintosh");
aliases.put("mac","macintosh");
aliases.put("macintosh","macintosh");
aliases.put("x-mac-roman","macintosh");
aliases.put("dos-874","windows-874");
aliases.put("iso-8859-11","windows-874");
aliases.put("iso8859-11","windows-874");
aliases.put("iso885911","windows-874");
aliases.put("tis-620","windows-874");
aliases.put("windows-874","windows-874");
aliases.put("cp1250","windows-1250");
aliases.put("windows-1250","windows-1250");
aliases.put("x-cp1250","windows-1250");
aliases.put("cp1251","windows-1251");
aliases.put("windows-1251","windows-1251");
aliases.put("x-cp1251","windows-1251");
aliases.put("ansi_x3.4-1968","windows-1252");
aliases.put("ascii","windows-1252");
aliases.put("cp1252","windows-1252");
aliases.put("cp819","windows-1252");
aliases.put("csisolatin1","windows-1252");
aliases.put("ibm819","windows-1252");
aliases.put("iso-8859-1","windows-1252");
aliases.put("iso-ir-100","windows-1252");
aliases.put("iso8859-1","windows-1252");
aliases.put("iso88591","windows-1252");
aliases.put("iso_8859-1","windows-1252");
aliases.put("iso_8859-1:1987","windows-1252");
aliases.put("l1","windows-1252");
aliases.put("latin1","windows-1252");
aliases.put("us-ascii","windows-1252");
aliases.put("windows-1252","windows-1252");
aliases.put("x-cp1252","windows-1252");
aliases.put("cp1253","windows-1253");
aliases.put("windows-1253","windows-1253");
aliases.put("x-cp1253","windows-1253");
aliases.put("cp1254","windows-1254");
aliases.put("csisolatin5","windows-1254");
aliases.put("iso-8859-9","windows-1254");
aliases.put("iso-ir-148","windows-1254");
aliases.put("iso8859-9","windows-1254");
aliases.put("iso88599","windows-1254");
aliases.put("iso_8859-9","windows-1254");
aliases.put("iso_8859-9:1989","windows-1254");
aliases.put("l5","windows-1254");
aliases.put("latin5","windows-1254");
aliases.put("windows-1254","windows-1254");
aliases.put("x-cp1254","windows-1254");
aliases.put("cp1255","windows-1255");
aliases.put("windows-1255","windows-1255");
aliases.put("x-cp1255","windows-1255");
aliases.put("cp1256","windows-1256");
aliases.put("windows-1256","windows-1256");
aliases.put("x-cp1256","windows-1256");
aliases.put("cp1257","windows-1257");
aliases.put("windows-1257","windows-1257");
aliases.put("x-cp1257","windows-1257");
aliases.put("cp1258","windows-1258");
aliases.put("windows-1258","windows-1258");
aliases.put("x-cp1258","windows-1258");
aliases.put("x-mac-cyrillic","x-mac-cyrillic");
aliases.put("x-mac-ukrainian","x-mac-cyrillic");
aliases.put("chinese","GBK");
aliases.put("csgb2312","GBK");
aliases.put("csiso58gb231280","GBK");
aliases.put("gb2312","GBK");
aliases.put("gb_2312","GBK");
aliases.put("gb_2312-80","GBK");
aliases.put("gbk","GBK");
aliases.put("iso-ir-58","GBK");
aliases.put("x-gbk","GBK");
aliases.put("gb18030","gb18030");
aliases.put("big5","Big5");
aliases.put("big5-hkscs","Big5");
aliases.put("cn-big5","Big5");
aliases.put("csbig5","Big5");
aliases.put("x-x-big5","Big5");
aliases.put("cseucpkdfmtjapanese","EUC-JP");
aliases.put("euc-jp","EUC-JP");
aliases.put("x-euc-jp","EUC-JP");
aliases.put("csiso2022jp","ISO-2022-JP");
aliases.put("iso-2022-jp","ISO-2022-JP");
aliases.put("csshiftjis","Shift_JIS");
aliases.put("ms932","Shift_JIS");
aliases.put("ms_kanji","Shift_JIS");
aliases.put("shift-jis","Shift_JIS");
aliases.put("shift_jis","Shift_JIS");
aliases.put("sjis","Shift_JIS");
aliases.put("windows-31j","Shift_JIS");
aliases.put("x-sjis","Shift_JIS");
aliases.put("cseuckr","EUC-KR");
aliases.put("csksc56011987","EUC-KR");
aliases.put("euc-kr","EUC-KR");
aliases.put("iso-ir-149","EUC-KR");
aliases.put("korean","EUC-KR");
aliases.put("ks_c_5601-1987","EUC-KR");
aliases.put("ks_c_5601-1989","EUC-KR");
aliases.put("ksc5601","EUC-KR");
aliases.put("ksc_5601","EUC-KR");
aliases.put("windows-949","EUC-KR");
aliases.put("csiso2022kr","replacement");
aliases.put("hz-gb-2312","replacement");
aliases.put("iso-2022-cn","replacement");
aliases.put("iso-2022-cn-ext","replacement");
aliases.put("iso-2022-kr","replacement");
aliases.put("utf-16be","UTF-16BE");
aliases.put("utf-16","UTF-16LE");
aliases.put("utf-16le","UTF-16LE");
aliases.put("x-user-defined","x-user-defined");
   return aliases;
    }

    /**
     *
     */
    private static String ToLowerCaseAscii(String str) {
      if (str == null) {
        return null;
      }
      int len = str.length();
      char c = (char)0;
      boolean hasUpperCase = false;
      for (int i = 0; i < len; ++i) {
        c = str.charAt(i);
        if (c >= 'A' && c <= 'Z') {
          hasUpperCase = true;
          break;
        }
      }
      if (!hasUpperCase) {
        return str;
      }
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < len; ++i) {
        c = str.charAt(i);
        if (c >= 'A' && c <= 'Z') {
          builder.append((char)(c + 0x20));
        } else {
          builder.append(c);
        }
      }
      return builder.toString();
    }

    private static String TrimAsciiWhite(String str) {
      if (((str) == null || (str).length() == 0)) {
        return str;
      }
      int index = 0;
      int valueSLength = str.length();
      while (index < valueSLength) {
        char c = str.charAt(index);
        if (c != 0x09 && c != 0x20 && c != 0x0c && c != 0x0d && c != 0x0a) {
          break;
        }
        ++index;
      }
      if (index == valueSLength) {
 return "";
}
      int indexStart = index;
      index = str.length() - 1;
      while (index >= 0) {
        char c = str.charAt(index);
        if (c != 0x09 && c != 0x20 && c != 0x0c && c != 0x0d && c != 0x0a) {
          int indexEnd = index + 1;
          if (indexEnd == indexStart) {
 return "";
}
          return (indexEnd == str.length() && indexStart == 0) ? str :
            str.substring(indexStart, (indexStart)+(indexEnd - indexStart));
        }
        --index;
      }
      return "";
    }

    private static class DecoderToInputClass implements ICharacterInput {
      private final IByteReader stream;
      private final ICharacterDecoder reader;

      public DecoderToInputClass(ICharacterDecoder reader, IByteReader stream) {
        this.reader = reader;
        this.stream = stream;
      }

    /**
     *
     */
      public int ReadChar() {
        int c = this.reader.ReadChar(this.stream);
        return (c == -2) ? 0xfffd : c;
      }

    /**
     *
     */
      public int Read(int[] buffer, int offset, int length) {
        if (buffer == null) {
          throw new NullPointerException("buffer");
        }
        if (offset < 0) {
          throw new IllegalArgumentException("offset (" + offset +
            ") is less than 0");
        }
        if (offset > buffer.length) {
          throw new IllegalArgumentException("offset (" + offset + ") is more than " +
            buffer.length);
        }
        if (length < 0) {
          throw new IllegalArgumentException("length (" + length +
            ") is less than 0");
        }
        if (length > buffer.length) {
          throw new IllegalArgumentException("length (" + length + ") is more than " +
            buffer.length);
        }
        if (buffer.length - offset < length) {
          throw new IllegalArgumentException("buffer's length minus " + offset + " (" +
            (buffer.length - offset) + ") is less than " + length);
        }
        int count = 0;
        for (int i = 0; i < length; ++i) {
          int c = this.ReadChar();
          if (c == -1) {
            break;
          }
          buffer[offset] = c;
          ++count;
          ++offset;
        }
        return count;
      }
    }
  }
