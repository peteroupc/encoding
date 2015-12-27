/*
Written by Peter O. in 2014.
Any copyright is dedicated to the Public Domain.
http://creativecommons.org/publicdomain/zero/1.0/
If you like this, you should donate to Peter O.
at: http://upokecenter.dreamhosters.com/articles/donate-now-2/
 */
using System;

namespace PeterO {
    /// <include file='docs.xml'
    /// path='docs/doc[@name="T:PeterO.IReader"]'/>
  public interface IReader : IByteReader {
    /// <include file='docs.xml'
    /// path='docs/doc[@name="M:PeterO.IReader.Read(System.Byte[],System.Int32,System.Int32)"]'
    /// />
    int Read(byte[] bytes, int offset, int length);
  }
}
