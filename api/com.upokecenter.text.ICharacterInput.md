# com.upokecenter.text.ICharacterInput

    public interface ICharacterInput

An interface for reading Unicode code points from a data source.

## Methods

* `int Read​(int[] chars,
    int index,
    int length)`<br>
 Reads a sequence of Unicode code points from a data source.
* `int ReadChar()`<br>
 Reads a Unicode code point from a data source.

## Method Details

### ReadChar
    int ReadChar()
Reads a Unicode code point from a data source.

**Returns:**

* Either a Unicode code point (from 0-0xd7ff or from 0xe000 to
 0x10ffff), or the value -1 indicating the end of the source.

### Read
    int Read​(int[] chars, int index, int length)
Reads a sequence of Unicode code points from a data source.

**Parameters:**

* <code>chars</code> - Output buffer.

* <code>index</code> - An index starting at 0 showing where the desired portion of
 <code>chars</code> begins.

* <code>length</code> - The number of elements in the desired portion of <code>chars</code>
 (but not more than <code>chars</code> 's length).

**Returns:**

* Either a Unicode code point (from 0-0xd7ff or from 0xe000 to
 0x10ffff), or the value -1 indicating the end of the source.

**Throws:**

* <code>java.lang.NullPointerException</code> - Should be thrown if <code>chars</code> is null.

* <code>java.lang.IllegalArgumentException</code> - Either "index" or "length" is less than 0 or
  greater than "chars"'s length, or "chars"'s length minus "index" is
  less than "length".
