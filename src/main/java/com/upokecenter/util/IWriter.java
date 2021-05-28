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
  public interface IWriter extends IByteWriter {
    /**
     * Writes a portion of a byte array to the data source.
     * @param bytes A byte array containing the data to write.
     * @param offset An index starting at 0 showing where the desired portion of
     * {@code bytes} begins.
     * @param length The number of elements in the desired portion of {@code bytes}
     * (but not more than {@code bytes} 's length).
     * @throws NullPointerException Should be thrown if the parameter {@code
     * bytes} is null.
     * @throws IllegalArgumentException Should be thrown if either {@code offset} or
     * {@code length} is less than 0 or greater than {@code bytes} 's
     * length, or {@code bytes} 's length minus {@code offset} is less than
     * {@code length}.
     */
    void write(byte[] bytes, int offset, int length);
  }
