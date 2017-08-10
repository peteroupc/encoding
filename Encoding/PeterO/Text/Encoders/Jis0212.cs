using System;

namespace PeterO.Text.Encoders {
internal static class Jis0212 {
private static readonly short[] ValueTable = new AppResources(
  "Resources").GetShortArray("Jis0212");

private static readonly int[] ValueIndextable = {
161, 65374, 0, 256, 198, 1119, 512, 256, 192, 501, 768, 256, 378, 382, 1024,
  256, 19970, 20434, 1280, 256, 20444, 21276, 1536, 256, 21278, 22213, 1792,
  256, 22217, 34369, 2048, 256, 23058, 24150, 2304, 256, 24152, 25057, 2560,
  256, 25058, 26030, 2816, 256, 26034, 26967, 3072, 256, 26971, 27911, 3328,
  256, 27751, 28977, 3584, 256, 28984, 29849, 3840, 256, 29850, 30659, 4096,
  256, 30665, 31540, 4352, 256, 31549, 32405, 4608, 256, 32408, 33470, 4864,
  256, 33471, 34360, 5120, 256, 34362, 35169, 5376, 256, 35170, 36281, 5632,
  256, 36283, 37150, 5888, 256, 37152, 37770, 6144, 256, 23986, 38884, 6400,
  256, 38895, 39808, 6656, 256, 39812, 40756, 6912, 256, 40759, 40869, 7168,
  43
};

public static int CodePointToIndex(int codepoint) {
   if (codepoint < 161 || codepoint > 65374) {
 return -1;
}
 short cps = unchecked((short)(codepoint & 0xffff));
  for (int i = 0; i < ValueIndextable.Length; i += 4) {
  if (codepoint >= ValueIndextable[i] && codepoint <= ValueIndextable[i +
       1]) {
      int startindex = ValueIndextable[i + 2];
       int length = ValueIndextable[i + 3];
      for (int j = 0; j < length; ++j) {
         if (ValueTable[j + startindex] == cps) {
 return j + startindex;
}
       }
    }
   }
  return -1;
 }

public static int IndexToCodePoint(int index) {
if (index < 0 || index >= 7211) {
 return -1;
}
int cp = ((int)ValueTable[index]) & 0xffff;
return (cp == 0) ? -1 : cp;
}
}
}