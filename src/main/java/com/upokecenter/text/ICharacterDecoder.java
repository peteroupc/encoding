package com.upokecenter.text;

import java.io.*;
import com.upokecenter.util.*;

    /**
     * Defines a method that can be implemented by classes that convert a stream of
     * bytes to Unicode code points.
     */
public interface ICharacterDecoder {
    /**
     *
     */
  int ReadChar(IByteReader input);
}
