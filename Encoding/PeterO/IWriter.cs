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
  /// path='docs/doc[@name="T:PeterO.IWriter"]/*'/>
  public interface IWriter : IByteWriter {
    /// <include file='../docs.xml'
  /// path='docs/doc[@name="M:PeterO.IWriter.Write(System.Byte[],System.Int32,System.Int32)"]/*'/>
    void Write(byte[] bytes, int offset, int length);
  }
}
