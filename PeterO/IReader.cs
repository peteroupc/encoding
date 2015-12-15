/*
Written by Peter O. in 2014.
Any copyright is dedicated to the Public Domain.
http://creativecommons.org/publicdomain/zero/1.0/
If you like this, you should donate to Peter O.
at: http://upokecenter.dreamhosters.com/articles/donate-now-2/
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
    /// <param name='offset'>A zero-based index showing where the desired
    /// portion of <paramref name='bytes'/> begins.</param>
    /// <param name='length'>The number of elements in the desired portion
    /// of <paramref name='bytes'/> (but not more than <paramref
    /// name='bytes'/> 's length).</param>
    /// <exception cref='ArgumentNullException'>Should be thrown if the
    /// parameter "bytes" is null.</exception>
    /// <exception cref='ArgumentException'>Should be thrown if either
    /// "offset" or "length" is less than 0 or greater than "bytes" 's
    /// length, or "bytes" 's length minus "offset" is less than
    /// "length".</exception>
  /// <returns>Not documented yet.</returns>
    int Read(byte[] bytes, int offset, int length);
  }
}