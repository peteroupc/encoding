package com.upokecenter.text;

  /**
   * An interface for reading Unicode code points from a data source.
   */
  public interface ICharacterInput {
    /**
     * Reads a Unicode code point from a data source.
     * @return Either a Unicode code point (from 0-0xd7ff or from 0xe000 to
     * 0x10ffff), or the value -1 indicating the end of the source.
     */
    int ReadChar();

    /**
     * Reads a sequence of Unicode code points from a data source.
     * @param chars Output buffer.
     * @param index An index starting at 0 showing where the desired portion of
     * {@code chars} begins.
     * @param length The number of elements in the desired portion of {@code chars}
     * (but not more than {@code chars} 's length).
     * @return Either a Unicode code point (from 0-0xd7ff or from 0xe000 to
     * 0x10ffff), or the value -1 indicating the end of the source.
     * @throws NullPointerException Should be thrown if {@code chars} is null.
     * @throws IllegalArgumentException Either "index" or "length" is less than 0 or
     * greater than "chars"'s length, or "chars"'s length minus "index" is less
     * than "length".
     */
    int Read(int[] chars, int index, int length);
  }
