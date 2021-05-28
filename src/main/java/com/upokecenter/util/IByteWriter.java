package com.upokecenter.util;
/*
Written by Peter O.
Any copyright to this work is released to the Public Domain.
In case this is not possible, this work is also
licensed under Creative Commons Zero (CC0):
https://creativecommons.org/publicdomain/zero/1.0/

 */

  /**
   * A generic interface for writing bytes of data.
   */
  public interface IByteWriter {
    /**
     * Writes an 8-bit byte to a data source.
     * @param b Byte to write to the data source. Only the lower 8 bits of this
     * value are used.
     */
    void write(int b);
  }
