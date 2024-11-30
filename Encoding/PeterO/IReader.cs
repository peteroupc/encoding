/*
Written by Peter O.
Any copyright to this work is released to the Public Domain.
In case this is not possible, this work is also
licensed under the Unlicense: https://unlicense.org/

 */
using System;

namespace PeterO {
  /// <summary>A generic interface for reading bytes of data from a data
  /// source.</summary>
  public interface IReader : IByteReader {
    /// <summary>Reads a portion of a byte array from the data
    /// source.</summary>
    /// <param name='bytes'>A byte array which will contain the data that
    /// was read from the data source.</param>
    /// <param name='offset'>An index starting at 0 showing where the
    /// desired portion of <paramref name='bytes'/> begins.</param>
    /// <param name='length'>The number of elements in the desired portion
    /// of <paramref name='bytes'/> (but not more than <paramref
    /// name='bytes'/> 's length).</param>
    /// <returns>The number of bytes read from the data source. Can be less
    /// than <paramref name='length'/> if the end of the stream was
    /// reached.</returns>
    /// <exception cref='ArgumentNullException'>Should be thrown if the
    /// parameter <paramref name='bytes'/> is null.</exception>
    /// <exception cref='ArgumentException'>Should be thrown if either
    /// <paramref name='offset'/> or <paramref name='length'/> is less than
    /// 0 or greater than <paramref name='bytes'/> 's length, or <paramref
    /// name='bytes'/> 's length minus <paramref name='offset'/> is less
    /// than <paramref name='length'/>.</exception>
    int Read(byte[] bytes, int offset, int length);
  }
}
