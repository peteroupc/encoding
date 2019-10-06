//------
// <auto-generated>
// </auto-generated>
//------
using System;
namespace PeterO.Text.Encoders {
internal static class Korean {
private static readonly short[] table=new AppResources("Resources")
.GetShortArray("Korean");
private static readonly int[] indextable= {
  44034, 44378, 0, 256, 44379, 44702, 256, 256, 44703, 45002, 512, 256, 45004,
  45306, 768, 256, 45307, 45622, 1024, 256, 45623, 45949, 1280, 256, 45950,
  46229, 1536, 256, 46230, 46547, 1792, 256, 46548, 46811, 2048, 256, 46812,
  47099, 2304, 256, 47102, 47406, 2560, 256, 47407, 47727, 2816, 256, 47730,
  48022, 3072, 256, 48023, 48350, 3328, 256, 48351, 48635, 3584, 256, 48636,
  48935, 3840, 256, 48936, 49196, 4096, 256, 49197, 49518, 4352, 256, 49519,
  49833, 4608, 256, 49834, 50126, 4864, 256, 50127, 50397, 5120, 256, 50398,
  50761, 5376, 256, 50762, 51125, 5632, 256, 51126, 51429, 5888, 256, 161,
  65509, 6144, 256, 174, 65510, 6400, 256, 12593, 51854, 6656, 256, 913,
  51978, 6912, 256, 8467, 52092, 7168, 256, 170, 52238, 7424, 256, 178,
  52371, 7680, 256, 12403, 52506, 7936, 256, 1025, 52668, 8192, 256, 52669,
  52779, 8448, 256, 52780, 52922, 8704, 256, 44032, 53100, 8960, 256, 44300,
  53195, 9216, 256, 45012, 53335, 9472, 256, 45535, 53508, 9728, 256, 45952,
  53613, 9984, 256, 46933, 53754, 10240, 256, 47467, 53900, 10496, 256,
  47933, 54010, 10752, 256, 48712, 54182, 11008, 256, 49381, 54327, 11264,
  256, 49821, 54429, 11520, 256, 50633, 54583, 11776, 256, 50921, 54727,
  12032, 256, 51339, 54849, 12288, 256, 52284, 55028, 12544, 256, 52824,
  55179, 12800, 256, 53488, 55203, 13056, 256, 54280, 54816, 13312, 256,
  54820, 55197, 13568, 256, 20075, 40853, 13824, 256, 20062, 63746, 14080,
  256, 20140, 63747, 14336, 256, 19992, 63749, 14592, 256, 20518, 63750,
  14848, 256, 20120, 63763, 15104, 256, 20035, 63833, 15360, 256, 20025,
  40680, 15616, 256, 20077, 63838, 15872, 256, 20102, 63840, 16128, 256,
  20374, 63842, 16384, 256, 19975, 40629, 16640, 256, 20276, 40692, 16896,
  256, 19993, 63845, 17152, 256, 19981, 63848, 17408, 256, 20045, 63850,
  17664, 256, 19977, 63853, 17920, 256, 19990, 63856, 18176, 256, 21460,
  39706, 18432, 256, 19998, 63859, 18688, 256, 20063, 63874, 18944, 256,
  20134, 63909, 19200, 256, 20034, 63929, 19456, 256, 20110, 63941, 19712,
  256, 20083, 63947, 19968, 256, 20057, 63981, 20224, 256, 19968, 63994,
  20480, 256, 20291, 63995, 20736, 256, 19969, 40778, 20992, 256, 20013,
  40165, 21248, 256, 20356, 63997, 21504, 256, 19988, 63999, 21760, 256,
  19985, 64000, 22016, 256, 19971, 64002, 22272, 256, 20296, 64006, 22528,
  256, 19979, 64007, 22784, 256, 20133, 64010, 23040, 256, 20024, 64011,
  23296, 256, 20241, 40657, 23552, 198
};
public static int CodePointToIndex(int codepoint) {
   if (codepoint<161 || codepoint>65510) {
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
if (index<0 || index >= 23750) {
  return -1;
}
int cp=((int)table[index]) & 0xffff;
return (cp == 0) ? -1 : cp;
}
}
}
