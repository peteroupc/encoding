/*
Written by Peter O. in 2014.
Any copyright is dedicated to the Public Domain.
http://creativecommons.org/publicdomain/zero/1.0/
If you like this, you should donate to Peter O.
at: http://peteroupc.github.io/
 */
using System;

namespace PeterO {
    /// <include file='../docs.xml'
    /// path='docs/doc[@name="T:PeterO.ArrayWriter"]/*'/>
  public sealed class ArrayWriter : IWriter {
    private int retvalPos;
    private int retvalMax;
    private byte[] retval;

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.ArrayWriter.Clear"]/*'/>
    public void Clear() {
      this.retvalPos = 0;
      this.retvalMax = 0;
    }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.ArrayWriter.#ctor"]/*'/>
    public ArrayWriter() : this(16) {
    }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.ArrayWriter.#ctor(System.Int32)"]/*'/>
    public ArrayWriter(int initialSize) {
      this.retval = new byte[initialSize];
    }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.ArrayWriter.ToArray"]/*'/>
    public byte[] ToArray() {
      var ret = new byte[this.retvalMax];
      Array.Copy(this.retval, 0, ret, 0, this.retvalMax);
      return ret;
    }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.ArrayWriter.WriteByte(System.Int32)"]/*'/>
    public void WriteByte(int byteValue) {
      if (this.retval.Length <= this.retvalPos) {
        // Array too small, make it grow
        int newLength = Math.Max(
            this.retvalPos + 1000,
            this.retval.Length * 2);
        var newArray = new byte[newLength];
        Array.Copy(this.retval, 0, newArray, 0, this.retvalPos);
        this.retval = newArray;
      }
      this.retval[this.retvalPos] = (byte)(byteValue & 0xff);
      this.retvalPos = checked(this.retvalPos + 1);
      this.retvalMax = Math.Max(this.retvalMax, this.retvalPos);
    }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.ArrayWriter.Write(System.Byte[],System.Int32,System.Int32)"]/*'/>
    public void Write(byte[] src, int offset, int length) {
      if (src == null) {
        throw new ArgumentNullException("src");
      }
      if (offset < 0) {
        throw new ArgumentException("offset (" + offset + ") is less than " +
              "0");
      }
      if (offset > src.Length) {
        throw new ArgumentException("offset (" + offset + ") is more than " +
          src.Length);
      }
      if (length < 0) {
        throw new ArgumentException("length (" + length + ") is less than " +
              "0");
      }
      if (length > src.Length) {
        throw new ArgumentException("length (" + length + ") is more than " +
          src.Length);
      }
      if (src.Length - offset < length) {
        throw new ArgumentException("src's length minus " + offset + " (" +
          (src.Length - offset) + ") is less than " + length);
      }
      if (this.retval.Length - this.retvalPos < length) {
        // Array too small, make it grow
        int newLength = Math.Max(
  this.retvalPos + length + 1000,
  this.retval.Length * 2);
        var newArray = new byte[newLength];
        Array.Copy(this.retval, 0, newArray, 0, this.retvalPos);
        this.retval = newArray;
      }
      Array.Copy(src, offset, this.retval, this.retvalPos, length);
      this.retvalPos = checked(this.retvalPos + length);
      this.retvalMax = Math.Max(this.retvalMax, this.retvalPos);
    }
  }
}
