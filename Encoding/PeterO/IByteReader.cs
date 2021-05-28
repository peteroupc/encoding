/*
Written by Peter O.
Any copyright to this work is released to the Public Domain.
In case this is not possible, this work is also
licensed under Creative Commons Zero (CC0):
https://creativecommons.org/publicdomain/zero/1.0/

 */
using System;

namespace PeterO {
  /// <summary>A generic interface for reading data one byte at a
  /// time.</summary>
  public interface IByteReader {
    /// <summary>Reads a byte from the data source.</summary>
    /// <returns>The byte read (from 0 through 255), or -1 if the end of
    /// the source is reached.</returns>
    int ReadByte();
  }
}
