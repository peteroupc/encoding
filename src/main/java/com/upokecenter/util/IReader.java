package com.upokecenter.util;
/*
Written by Peter O. in 2014.
Any copyright is dedicated to the Public Domain.
http://creativecommons.org/publicdomain/zero/1.0/
If you like this, you should donate to Peter O.
at: http://upokecenter.dreamhosters.com/articles/donate-now-2/
 */

    /**
     * A generic interface for reading bytes of data from a data source.
     */
  public interface IReader extends IByteReader {
    /**
     * Reads a portion of a byte array from the data source.
     * @param bytes A byte array which will contain the data that was read from the
     * data source.
     * @param offset A zero-based index showing where the desired portion of {@code
     * bytes} begins.
     * @param length The number of elements in the desired portion of {@code bytes}
     * (but not more than {@code bytes} 's length).
     * @return The number of bytes read from the data source. Can be less than
     * "length" if the end of the stream was reached.
     * @throws java.lang.NullPointerException Should be thrown if the parameter
     * "bytes" is null.
     * @throws IllegalArgumentException Should be thrown if either "offset" or
     * "length" is less than 0 or greater than "bytes" 's length, or "bytes"
     * 's length minus "offset" is less than "length".
     */
    int Read(byte[] bytes, int offset, int length);
  }
