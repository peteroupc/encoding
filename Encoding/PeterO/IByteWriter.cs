/*
Written by Peter O.
Any copyright to this work is released to the Public Domain.
In case this is not possible, this work is also
licensed under Creative Commons Zero (CC0):
https://creativecommons.org/publicdomain/zero/1.0/

 */
using System;

namespace PeterO {
  /// <summary>A generic interface for writing bytes of data.</summary>
  public interface IByteWriter {
    /// <summary>Writes an 8-bit byte to a data source.</summary>
    /// <param name='b'>Byte to write to the data source. Only the lower 8
    /// bits of this value are used.</param>
    void WriteByte(int b);
  }
}
