package com.upokecenter.text.encoders;
//------
// <auto-generated>
// </auto-generated>
//------

public final class Big5 {
private Big5() {
}
private static final int[] table=new AppResources("Resources")
.GetIntArray("Big5");
private static final int[] indextable= {
  167, 65509, 5024, 256, 711, 65370, 5280, 256, 19981, 31435, 5536, 256,
  20018, 38433, 5792, 256, 20006, 38450, 6048, 256, 22369, 33459, 6304, 256,
  20127, 38750, 6560, 256, 20056, 39321, 6816, 256, 22466, 32607, 7072, 256,
  20094, 39740, 7328, 256, 21207, 33698, 7584, 256, 20608, 40635, 7840, 256,
  21892, 36317, 8096, 256, 20098, 40657, 8352, 256, 29759, 40718, 8608, 256,
  20686, 40736, 8864, 256, 20725, 40778, 9120, 256, 27117, 39662, 9376, 256,
  20752, 40786, 9632, 256, 20767, 40860, 9888, 256, 20787, 40848, 10144,
  256, 20791, 40803, 10400, 256, 9312, 40852, 10656, 256, 168, 65341, 10912,
  256, 248, 161287, 11168, 256, 20269, 38436, 11424, 256, 20019, 38448,
  11680, 256, 20402, 38467, 11936, 256, 24612, 33534, 12192, 256, 20468,
  38484, 12448, 256, 26656, 34387, 12704, 256, 20095, 39727, 12960, 256,
  24753, 31896, 13216, 256, 20584, 39319, 13472, 256, 22555, 28296, 13728,
  256, 28199, 35073, 13984, 256, 20099, 40697, 14240, 256, 25123, 64013,
  14496, 256, 26401, 37507, 14752, 256, 20691, 40701, 15008, 256, 21124,
  34667, 15264, 256, 20726, 40615, 15520, 256, 25704, 34107, 15776, 256,
  34023, 39667, 16032, 256, 20753, 40720, 16288, 256, 30613, 37754, 16544,
  256, 20768, 40765, 16800, 256, 31728, 39752, 17056, 256, 20781, 40864,
  17312, 256, 20788, 40789, 17568, 256, 21303, 40792, 17824, 256, 20793,
  40849, 18080, 256, 20153, 40850, 18336, 256, 20797, 40866, 18592, 256,
  9552, 166622, 18848, 256, 13665, 194708, 19104, 256, 14053, 194726, 19360,
  256, 14021, 168205, 19616, 166
};
public static int CodePointToIndex(int codepoint) {
   if (codepoint<167 || codepoint>194726) {
 return -1;
}
   if (codepoint == 9552) {
 return 18991;
}
   if (codepoint == 9566) {
 return 18975;
}
   if (codepoint == 9569) {
 return 18977;
}
   if (codepoint == 9578) {
 return 18976;
}
   if (codepoint == 21313) {
 return 5512;
}
   if (codepoint == 21317) {
 return 5599;
}
  for (int i = 0;i<indextable.length;i+=4) {
     if (codepoint >= indextable[i] && codepoint <= indextable[i + 1]) {
      int startindex = indextable[i + 2];
       int length = indextable[i + 3];
      for (int j = 0; j < length; ++j) {
         if ((table[j + startindex]) == codepoint) {
 return j + startindex;
}
       }
    }
   }
  return -1;
 }
public static int IndexToCodePoint(int index) {
if (index<0 || index >= 19782) {
 return -1;
}
int cp = table[index];
return (cp == 0) ? -1 : cp;
}
}
