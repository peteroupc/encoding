package com.upokecenter.text;

import java.io.*;
import com.upokecenter.util.*;

    /**
     *
     */
  public interface ICharacterEncoder {
    /**
     *
     */
    int Encode(int c, IWriter output);
  }
