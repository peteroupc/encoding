/*
Written by Peter O. in 2014.
Any copyright is dedicated to the Public Domain.
http://creativecommons.org/publicdomain/zero/1.0/
If you like this, you should donate to Peter O.
at: http://peteroupc.github.io/
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
