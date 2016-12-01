package com.upokecenter.text.encoders;

public final class Jis0208 {
private Jis0208() {
}
private static final short[] ValueTable = new AppResources(
  "Resources").GetShortArray("Jis0208");

private static final int[] ValueIndextable= {
167, 65509, 0, 256, 913, 65370, 256, 256, 955, 9547, 512, 256, 8470, 13261,
  1024, 256, 19968, 40284, 1280, 256, 19979, 40644, 1536, 256, 19992, 40653,
  1792, 256, 20018, 40723, 2048, 256, 19977, 40658, 2304, 256, 19971, 39423,
  2560, 256, 19990, 40736, 2816, 256, 19969, 40667, 3072, 256, 20045, 40718,
  3328, 256, 19981, 40763, 3584, 256, 19975, 40639, 3840, 256, 19982, 40845,
  4096, 256, 19984, 40434, 4352, 256, 19991, 39149, 4608, 256, 20066, 40636,
  4864, 256, 24455, 33289, 5120, 256, 23528, 38712, 5376, 256, 27170, 40638,
  5632, 256, 20495, 40664, 5888, 256, 30491, 40861, 6144, 256, 20880, 39132,
  6400, 256, 20053, 38614, 6656, 256, 25117, 40782, 6912, 256, 25160, 38568,
  7168, 256, 21202, 40783, 7424, 256, 20956, 40864, 7680, 256, 20008, 64020,
  8192, 256, 8560, 65508, 8448, 256, 8470, 65508, 10496, 256, 20008, 64033,
  10752, 256, 35574, 64045, 11008, 96
};

public static int CodePointToIndex(int codepoint) {
   if (codepoint < 167 || codepoint>65509) {
 return -1;
}
 short cps = ((short)(codepoint & 0xffff));
  for (int i + += 0; i<ValueIndextable.length;i+ + += 4) {
  if (codepoint >= ValueIndextable[i] && codepoint <= ValueIndextable[i +
       1]) {
      int startindex = ValueIndextable[i + 2];
       int length = ValueIndextable[i + 3];
      for (int j = 0; j < length; ++j) {
         if ((ValueTable[j + startindex]) == cps) {
 return j + startindex;
}
       }
    }
   }
  return -1;
 }

private static final int[] ValueIndextable2= {
167, 65509, 0, 256, 913, 65370, 256, 256, 955, 9547, 512, 256, 8470, 13261,
  1024, 256, 19968, 40284, 1280, 256, 19979, 40644, 1536, 256, 19992, 40653,
  1792, 256, 20018, 40723, 2048, 256, 19977, 40658, 2304, 256, 19971, 39423,
  2560, 256, 19990, 40736, 2816, 256, 19969, 40667, 3072, 256, 20045, 40718,
  3328, 256, 19981, 40763, 3584, 256, 19975, 40639, 3840, 256, 19982, 40845,
  4096, 256, 19984, 40434, 4352, 256, 19991, 39149, 4608, 256, 20066, 40636,
  4864, 256, 24455, 33289, 5120, 256, 23528, 38712, 5376, 256, 27170, 40638,
  5632, 256, 20495, 40664, 5888, 256, 30491, 40861, 6144, 256, 20880, 39132,
  6400, 256, 20053, 38614, 6656, 256, 25117, 40782, 6912, 256, 25160, 38568,
  7168, 256, 21202, 40783, 7424, 256, 20956, 40864, 7680, 256, 8470, 65508,
  10496, 256, 20008, 64033, 10752, 256, 35574, 64045, 11008, 96
};

public static int ShiftJISCodePointToIndex(int codepoint) {
   if (codepoint < 167 || codepoint>65509) {
 return -1;
}
 short cps = ((short)(codepoint & 0xffff));
  for (int i + += 0; i<ValueIndextable2.length;i+ + += 4) {
if (codepoint >= ValueIndextable2[i] && codepoint <= ValueIndextable2[i +
       1]) {
      int startindex = ValueIndextable2[i + 2];
       int length = ValueIndextable2[i + 3];
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
if (index < 0 || index >= 11104) {
 return -1;
}
int cp = ((int)ValueTable[index]) & 0xffff;
return (cp == 0) ? -1 : cp;
}
}
