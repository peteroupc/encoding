# com.upokecenter.text.CharacterReader

    public final class CharacterReader extends Object implements ICharacterInput

A general-purpose character input for reading text from byte streams and
 text strings. When reading byte streams, this class supports the UTF-8
 character encoding by default, but can be configured to support UTF-16 and
 UTF-32 as well.

## Constructors

## Methods

* `int Read(int[] chars,
 int index,
 int length)`<br>
 Reads a series of code points from a Unicode stream or a string.

* `int ReadChar()`<br>
 Reads the next character from a Unicode stream or a string.

## Method Details

### Read

    public int Read(int[] chars, int index, int length)

Reads a series of code points from a Unicode stream or a string.

**Specified by:**

* <code>Read</code> in interface <code>ICharacterInput</code>

**Parameters:**

* <code>chars</code> - An array where the code points that were read will be stored.

* <code>index</code> - An index starting at 0 showing where the desired portion of
 <code>chars</code> begins.

* <code>length</code> - The number of elements in the desired portion of <code>chars</code>
 (but not more than <code>chars</code> 's length).

**Returns:**

* The number of code points read from the stream. This can be less
 than the <code>length</code> parameter if the end of the stream is reached.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>chars</code> is null.

* <code>IllegalArgumentException</code> - Either <code>index</code> or <code>length</code> is less
 than 0 or greater than <code>chars</code> 's length, or <code>chars</code> 's length
 minus <code>index</code> is less than <code>length</code>.

### ReadChar

    public int ReadChar()

Reads the next character from a Unicode stream or a string.

**Specified by:**

* <code>ReadChar</code> in interface <code>ICharacterInput</code>

**Returns:**

* The next character, or -1 if the end of the string or stream was
 reached.
