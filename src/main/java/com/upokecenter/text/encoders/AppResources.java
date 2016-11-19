package com.upokecenter.text.encoders;

import java.util.*;

  final class AppResources {

    private ResourceBundle mgr;

    public AppResources(String name) {
      this.mgr = ResourceBundle.getBundle(name);
    }

    public short[] GetShortArray(String name) {
      String str = this.mgr.getString(name);
      if(str==null || (str.length()&3) != 0){
         return null;
      }
      short[] ret=new short[str.length()>>2];
      int k=0;
      for(int i=0;i<str.length();i+=4){
        int c=0;
        int shift=12;
        for(int j=0;j<4;j++,shift-=4){
         int d=str.charAt(i+j);
         if(d>='0' && d<='9'){
           d=(int)(d-'0');
         } else if(d>='a' && d<='f'){
           d=(int)(d-'a')+10;
         } else if(d>='A' && d<='F'){
           d=(int)(d-'A')+10;
         } else return null;
         c|=(d<<shift);
        }
        ret[k++]=(short)c;
      }
      return ret;
    }

    public int[] GetIntArray(String name) {
      String str = this.mgr.getString(name);
      if(str==null || (str.length()&7) != 0){
         return null;
      }
      int[] ret=new int[str.length()>>3];
      int k=0;
      for(int i=0;i<str.length();i+=8){
        int c=0;
        int shift=28;
        for(int j=0;j<8;j++,shift-=4){
         int d=str.charAt(i+j);
         if(d>='0' && d<='9'){
           d=(int)(d-'0');
         } else if(d>='a' && d<='f'){
           d=(int)(d-'a')+10;
         } else if(d>='A' && d<='F'){
           d=(int)(d-'A')+10;
         } else return null;
         c|=(d<<shift);
        }
        ret[k++]=c;
      }
      return ret;
    }

    public String GetString(String name) {
      return mgr.getString(name);
    }
  }
