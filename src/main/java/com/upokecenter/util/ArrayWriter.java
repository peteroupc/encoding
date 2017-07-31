package com.upokecenter.util;
/*
Written by Peter O. in 2014.
Any copyright is dedicated to the Public Domain.
http://creativecommons.org/publicdomain/zero/1.0/
If you like this, you should donate to Peter O.
at: http://peteroupc.github.io/
 */

    /**
     *
     */
  public final class ArrayWriter implements IWriter {
    private int retvalPos;
    private int retvalMax;
    private byte[] retval;

    /**
     *
     */
    public void Clear() {
      this.retvalPos = 0;
      this.retvalMax = 0;
    }

    /**
     *
     */
    public ArrayWriter() {
 this(16);
    }

    /**
     *
     */
    public ArrayWriter(int initialSize) {
      this.retval = new byte[initialSize];
    }

    /**
     *
     */
    public byte[] ToArray() {
      byte[] ret = new byte[this.retvalMax];
      System.arraycopy(this.retval, 0, ret, 0, this.retvalMax);
      return ret;
    }

    /**
     *
     */
    public void write(int byteValue) {
      if (this.retval.length <= this.retvalPos) {
        // Array too small, make it grow
        int newLength = Math.max(
            this.retvalPos + 1000,
            this.retval.length * 2);
        byte[] newArray = new byte[newLength];
        System.arraycopy(this.retval, 0, newArray, 0, this.retvalPos);
        this.retval = newArray;
      }
      this.retval[this.retvalPos] = (byte)(byteValue & 0xff);
      this.retvalPos = (this.retvalPos + 1);
      this.retvalMax = Math.max(this.retvalMax, this.retvalPos);
    }

    /**
     *
     */
    public void write(byte[] src, int offset, int length) {
      if (src == null) {
        throw new NullPointerException("src");
      }
      if (offset < 0) {
        throw new IllegalArgumentException("offset (" + offset + ") is less than " +
              "0");
      }
      if (offset > src.length) {
        throw new IllegalArgumentException("offset (" + offset + ") is more than " +
          src.length);
      }
      if (length < 0) {
        throw new IllegalArgumentException("length (" + length + ") is less than " +
              "0");
      }
      if (length > src.length) {
        throw new IllegalArgumentException("length (" + length + ") is more than " +
          src.length);
      }
      if (src.length - offset < length) {
        throw new IllegalArgumentException("src's length minus " + offset + " (" +
          (src.length - offset) + ") is less than " + length);
      }
      if (this.retval.length - this.retvalPos < length) {
        // Array too small, make it grow
        int newLength = Math.max(
  this.retvalPos + length + 1000,
  this.retval.length * 2);
        byte[] newArray = new byte[newLength];
        System.arraycopy(this.retval, 0, newArray, 0, this.retvalPos);
        this.retval = newArray;
      }
      System.arraycopy(src, offset, this.retval, this.retvalPos, length);
      this.retvalPos = (this.retvalPos + length);
      this.retvalMax = Math.max(this.retvalMax, this.retvalPos);
    }
  }
