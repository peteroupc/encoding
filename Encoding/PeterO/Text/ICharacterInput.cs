using System;

namespace PeterO.Text {
    /// <summary>An interface for reading Unicode code points from a data
    /// source.</summary>
  public interface ICharacterInput {
    /// <summary>Reads a Unicode code point from a data source.</summary>
    /// <returns>Either a Unicode code point (from 0-0xd7ff or from 0xe000
    /// to 0x10ffff), or the value -1 indicating the end of the
    /// source.</returns>
    int ReadChar();

    /// <summary>Reads a sequence of Unicode code points from a data
    /// source.</summary>
    /// <param name='chars'>Output buffer.</param>
    /// <param name='index'>An index starting at 0 showing where the
    /// desired portion of <paramref name='chars'/> begins.</param>
    /// <param name='length'>The number of elements in the desired portion
    /// of <paramref name='chars'/> (but not more than <paramref
    /// name='chars'/> 's length).</param>
    /// <returns>Either a Unicode code point (from 0-0xd7ff or from 0xe000
    /// to 0x10ffff), or the value -1 indicating the end of the
    /// source.</returns>
    /// <exception cref='ArgumentNullException'>Should be thrown if
    /// <paramref name='chars'/> is null.</exception>
    /// <exception cref='ArgumentException'>Either &#x22;index&#x22; or
    /// &#x22;length&#x22; is less than 0 or greater than
    /// &#x22;chars&#x22;&#x27;s length, or &#x22;chars&#x22;&#x27;s length
    /// minus &#x22;index&#x22; is less than
    /// &#x22;length&#x22;.</exception>
    int Read(int[] chars, int index, int length);
  }
}
