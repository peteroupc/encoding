package com.upokecenter.util;
/*
Written by Peter O.
Any copyright to this work is released to the Public Domain.
In case this is not possible, this work is also
licensed under the Unlicense: https://unlicense.org/

 */

  /**
   * A generic interface for reading bytes of data from a data source.
   */
  public interface IReader extends IByteReader {
    /**
     * Reads a portion of a byte array from the data source.
     * @param bytes A byte array which will contain the data that was read from the
     * data source.
     * @param offset An index starting at 0 showing where the desired portion of
     * {@code bytes} begins.
     * @param length The number of elements in the desired portion of {@code bytes}
     * (but not more than {@code bytes} 's length).
     * @return The number of bytes read from the data source. Can be less than
     * {@code length} if the end of the stream was reached.
     * @throws NullPointerException Should be thrown if the parameter {@code
     * bytes} is null.
     * @throws IllegalArgumentException Should be thrown if either {@code offset} or
     * {@code length} is less than 0 or greater than {@code bytes} 's length, or
     * {@code bytes} 's length minus {@code offset} is less than {@code length}.
     */
    int Read(byte[] bytes, int offset, int length);
  }
