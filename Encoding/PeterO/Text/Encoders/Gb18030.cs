//------
// <auto-generated>
// </auto-generated>
//------
using System;
namespace PeterO.Text.Encoders {
internal static class Gb18030 {
private static readonly short[] table=new AppResources("Resources")
.GetShortArray("Gb18030");
private static readonly int[] indextable= {
19970, 20496, 0, 256, 20497, 20833, 256, 256, 20835, 21278, 512, 256, 21279,
  21818, 768, 256, 21819, 22210, 1024, 256, 22211, 22608, 1280, 256, 22610,
  22979, 1536, 256, 22980, 23321, 1792, 256, 23322, 23758, 2048, 256, 23759,
  24100, 2304, 256, 24101, 24511, 2560, 256, 24512, 24945, 2816, 256, 24946,
  25367, 3072, 256, 25368, 25778, 3328, 256, 25779, 26160, 3584, 256, 26162,
  26562, 3840, 256, 26565, 26952, 4096, 256, 26953, 27285, 4352, 256, 27286,
  27601, 4608, 256, 27608, 28090, 4864, 256, 28091, 28474, 5120, 256, 28475,
  28778, 5376, 256, 28782, 29137, 5632, 256, 29138, 58629, 5888, 256, 164,
  65505, 6144, 256, 8364, 65509, 6400, 256, 12353, 59260, 6656, 256, 913,
  59276, 6912, 256, 714, 65092, 7168, 256, 224, 65508, 7424, 256, 9472,
  59407, 7680, 256, 29554, 57531, 7936, 256, 29717, 57625, 8192, 256, 29929,
  57777, 8448, 256, 30088, 57907, 8704, 256, 20276, 39041, 8960, 256, 19981,
  40763, 9216, 256, 19985, 40831, 9472, 256, 19995, 38604, 9728, 256, 19969,
  40718, 9984, 256, 20016, 40517, 10240, 256, 20010, 40858, 10496, 256,
  20054, 40863, 10752, 256, 20046, 40644, 11008, 256, 20214, 40481, 11264,
  256, 20030, 40515, 11520, 256, 20111, 39745, 11776, 256, 20004, 40654,
  12032, 256, 20020, 40857, 12288, 256, 20040, 40483, 12544, 256, 20035,
  40664, 12800, 256, 19971, 40784, 13056, 256, 19988, 40660, 13312, 256,
  19977, 40843, 13568, 256, 19990, 40736, 13824, 256, 19997, 39635, 14080,
  256, 20141, 40501, 14336, 256, 19975, 39759, 14592, 256, 19979, 40092,
  14848, 256, 20005, 40493, 15104, 256, 19968, 40495, 15360, 256, 19982,
  40560, 15616, 256, 19976, 40499, 15872, 256, 20013, 39588, 16128, 256,
  19980, 59412, 16384, 256, 20022, 40864, 16640, 256, 20147, 38576, 16896,
  256, 20981, 40729, 17152, 256, 22535, 36676, 17408, 256, 21263, 36987,
  17664, 256, 21343, 37188, 17920, 256, 21956, 37351, 18176, 256, 22786,
  39317, 18432, 256, 20012, 38579, 18688, 256, 21675, 39739, 18944, 256,
  22935, 39591, 19200, 256, 24027, 39036, 19456, 256, 26544, 38365, 19712,
  256, 25099, 38672, 19968, 256, 21014, 40785, 20224, 256, 24528, 40859,
  20480, 256, 30010, 39171, 20736, 256, 23879, 40655, 20992, 256, 30091,
  39451, 21248, 256, 34381, 39686, 21504, 256, 25929, 39803, 21760, 256,
  26011, 40632, 22016, 256, 30655, 40844, 22272, 256, 32315, 57985, 22528,
  256, 40259, 58095, 22784, 256, 40405, 58209, 23040, 256, 40619, 58369,
  23296, 256, 11905, 64041, 23552, 256, 11978, 59492, 23808, 132
};
public static int CodePointToIndex(int codepoint) {
   if (codepoint<164 || codepoint>65509) {
 return -1;
}
 short cps = unchecked((short)(codepoint & 0xffff));
  for (int i = 0;i<indextable.Length;i+=4) {
     if (codepoint >= indextable[i] && codepoint <= indextable[i + 1]) {
      int startindex = indextable[i + 2];
       int length = indextable[i + 3];
      for (int j = 0; j < length; ++j) {
         if ((table[j + startindex]) == cps) {
 return j + startindex;
}
       }
    }
   }
  return -1;
 }
public static int IndexToCodePoint(int index) {
if (index<0 || index >= 23940) {
 return -1;
}
int cp=((int)table[index]) & 0xffff;
return (cp == 0) ? -1 : cp;
}
}
}
