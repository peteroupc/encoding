package com.upokecenter.util;
/*
Written by Peter O.
Any copyright to this work is released to the Public Domain.
In case this is not possible, this work is also
licensed under Creative Commons Zero (CC0):
https://creativecommons.org/publicdomain/zero/1.0/

 */

  /**
   * A generic interface for reading data one byte at a time.
   */
  public interface IByteReader {
    /**
     * Reads a byte from the data source.
     * @return The byte read (from 0 through 255), or -1 if the end of the source
     * is reached.
     */
    int read();
  }
