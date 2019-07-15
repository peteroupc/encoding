# com.upokecenter.text.CharacterReader

    public final class CharacterReader extends java.lang.Object implements ICharacterInput

A general-purpose character input for reading text from byte streams and
 text strings. When reading byte streams, this class supports the
 UTF-8 character encoding by default, but can be configured to
 support UTF-16 and UTF-32 as well.

## Methods

* `CharacterReader​(java.io.InputStream stream) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.io.InputStream stream,
               int mode) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.io.InputStream stream,
               int mode,
               boolean errorThrow) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.io.InputStream stream,
               int mode,
               boolean errorThrow,
               boolean dontSkipUtf8Bom) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.lang.String str) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.lang.String str,
               boolean skipByteOrderMark) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.lang.String str,
               boolean skipByteOrderMark,
               boolean errorThrow) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.lang.String str,
               int offset,
               int length) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.lang.String str,
               int offset,
               int length,
               boolean skipByteOrderMark,
               boolean errorThrow) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `int Read​(int[] chars,
    int index,
    int length)`<br>
 Reads a series of code points from a Unicode stream or a string.
* `int ReadChar()`<br>
 Reads the next character from a Unicode stream or a string.

## Constructors

* `CharacterReader​(java.io.InputStream stream) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.io.InputStream stream,
               int mode) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.io.InputStream stream,
               int mode,
               boolean errorThrow) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.io.InputStream stream,
               int mode,
               boolean errorThrow,
               boolean dontSkipUtf8Bom) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.lang.String str) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.lang.String str,
               boolean skipByteOrderMark) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.lang.String str,
               boolean skipByteOrderMark,
               boolean errorThrow) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.lang.String str,
               int offset,
               int length) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.
* `CharacterReader​(java.lang.String str,
               int offset,
               int length,
               boolean skipByteOrderMark,
               boolean errorThrow) CharacterReader`<br>
 Initializes a new instance of the CharacterReader.

## Method Details

### CharacterReader
    public CharacterReader​(java.lang.String str)
Initializes a new instance of the <code>CharacterReader</code>.

**Parameters:**

* <code>str</code> - A string object.

### CharacterReader
    public CharacterReader​(java.lang.String str, boolean skipByteOrderMark)
Initializes a new instance of the <code>CharacterReader</code>.

**Parameters:**

* <code>str</code> - A string object.

* <code>skipByteOrderMark</code> - A Boolean object.

### CharacterReader
    public CharacterReader​(java.lang.String str, boolean skipByteOrderMark, boolean errorThrow)
Initializes a new instance of the <code>CharacterReader</code>.

**Parameters:**

* <code>str</code> - A string object.

* <code>skipByteOrderMark</code> - A Boolean object.

* <code>errorThrow</code> - Another Boolean object.

**Throws:**

* <code>java.lang.NullPointerException</code> - The parameter <code>str</code> is null.

### CharacterReader
    public CharacterReader​(java.lang.String str, int offset, int length)
Initializes a new instance of the <code>CharacterReader</code>.

**Parameters:**

* <code>str</code> - A string object.

* <code>offset</code> - A 32-bit signed integer.

* <code>length</code> - Another 32-bit signed integer.

### CharacterReader
    public CharacterReader​(java.lang.String str, int offset, int length, boolean skipByteOrderMark, boolean errorThrow)
Initializes a new instance of the <code>CharacterReader</code>.

**Parameters:**

* <code>str</code> - A string object.

* <code>offset</code> - A 32-bit signed integer.

* <code>length</code> - Another 32-bit signed integer.

* <code>skipByteOrderMark</code> - A Boolean object.

* <code>errorThrow</code> - Another Boolean object.

**Throws:**

* <code>java.lang.NullPointerException</code> - The parameter <code>str</code> is null.

### CharacterReader
    public CharacterReader​(java.io.InputStream stream)
Initializes a new instance of the <code>CharacterReader</code>.

**Parameters:**

* <code>stream</code> - A readable data stream.

### CharacterReader
    public CharacterReader​(java.io.InputStream stream, int mode, boolean errorThrow)
Initializes a new instance of the <code>CharacterReader</code>.

**Parameters:**

* <code>stream</code> - A readable data stream.

* <code>mode</code> - A 32-bit signed integer.

* <code>errorThrow</code> - A Boolean object.

### CharacterReader
    public CharacterReader​(java.io.InputStream stream, int mode)
Initializes a new instance of the <code>CharacterReader</code>.

**Parameters:**

* <code>stream</code> - A readable data stream.

* <code>mode</code> - A 32-bit signed integer.

### CharacterReader
    public CharacterReader​(java.io.InputStream stream, int mode, boolean errorThrow, boolean dontSkipUtf8Bom)
Initializes a new instance of the <code>CharacterReader</code>.

**Parameters:**

* <code>stream</code> - A readable data stream.

* <code>mode</code> - A 32-bit signed integer.

* <code>errorThrow</code> - A Boolean object.

* <code>dontSkipUtf8Bom</code> - Another Boolean object.

**Throws:**

* <code>java.lang.NullPointerException</code> - The parameter <code>stream</code> is null.

### Read
    public int Read​(int[] chars, int index, int length)
Reads a series of code points from a Unicode stream or a string.

**Specified by:**

* <code>Read</code> in interface <code>ICharacterInput</code>

**Parameters:**

* <code>chars</code> - An array where the code points that were read will be stored.

* <code>index</code> - A zero-based index showing where the desired portion of <code>
 chars</code> begins.

* <code>length</code> - The number of elements in the desired portion of <code>chars</code>
 (but not more than <code>chars</code> 's length).

**Returns:**

* The number of code points read from the stream. This can be less
 than the <code>length</code> parameter if the end of the stream is
 reached.

**Throws:**

* <code>java.lang.NullPointerException</code> - The parameter <code>chars</code> is null.

* <code>java.lang.IllegalArgumentException</code> - Either <code>index</code> or <code>length</code> is
 less than 0 or greater than <code>chars</code> 's length, or <code>
 chars</code> 's length minus <code>index</code> is less than <code>length</code>.

* <code>java.lang.IllegalArgumentException</code> - Either "index" or "length" is less than 0 or
  greater than "chars"'s length, or "chars"'s length minus "index" is
  less than "length".

* <code>java.lang.NullPointerException</code> - The parameter <code>chars</code> is null.

### ReadChar
    public int ReadChar()
Reads the next character from a Unicode stream or a string.

**Specified by:**

* <code>ReadChar</code> in interface <code>ICharacterInput</code>

**Returns:**

* The next character, or -1 if the end of the string or stream was
 reached.
