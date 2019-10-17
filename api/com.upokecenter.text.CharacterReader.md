# com.upokecenter.text.CharacterReader

    public final class CharacterReader extends java.lang.Object implements ICharacterInput

A general-purpose character input for reading text from byte streams and
 text strings. When reading byte streams, this class supports the UTF-8
 character encoding by default, but can be configured to support UTF-16
 and UTF-32 as well.

## Methods

* `CharacterReader​(java.io.InputStream stream) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class; will read the stream as
 UTF-8, skip the byte-order mark (U+FEFF) if it appears first in the
 stream, and replace invalid byte sequences with replacement
 characters (U+FFFD).
* `CharacterReader​(java.io.InputStream stream,
               int mode) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class; will skip the
 byte-order mark (U+FEFF) if it appears first in the stream and
 replace invalid byte sequences with replacement characters (U+FFFD).
* `CharacterReader​(java.io.InputStream stream,
               int mode,
               boolean errorThrow) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class; will skip the
 byte-order mark (U+FEFF) if it appears first in the stream and a
 UTF-8 stream is detected.
* `CharacterReader​(java.io.InputStream stream,
               int mode,
               boolean errorThrow,
               boolean dontSkipUtf8Bom) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class.
* `CharacterReader​(java.lang.String str) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class.
* `CharacterReader​(java.lang.String str,
               boolean skipByteOrderMark) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class.
* `CharacterReader​(java.lang.String str,
               boolean skipByteOrderMark,
               boolean errorThrow) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class.
* `CharacterReader​(java.lang.String str,
               int offset,
               int length) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class.
* `CharacterReader​(java.lang.String str,
               int offset,
               int length,
               boolean skipByteOrderMark,
               boolean errorThrow) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class.
* `int Read​(int[] chars,
    int index,
    int length)`<br>
 Reads a series of code points from a Unicode stream or a string.
* `int ReadChar()`<br>
 Reads the next character from a Unicode stream or a string.

## Constructors

* `CharacterReader​(java.io.InputStream stream) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class; will read the stream as
 UTF-8, skip the byte-order mark (U+FEFF) if it appears first in the
 stream, and replace invalid byte sequences with replacement
 characters (U+FFFD).
* `CharacterReader​(java.io.InputStream stream,
               int mode) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class; will skip the
 byte-order mark (U+FEFF) if it appears first in the stream and
 replace invalid byte sequences with replacement characters (U+FFFD).
* `CharacterReader​(java.io.InputStream stream,
               int mode,
               boolean errorThrow) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class; will skip the
 byte-order mark (U+FEFF) if it appears first in the stream and a
 UTF-8 stream is detected.
* `CharacterReader​(java.io.InputStream stream,
               int mode,
               boolean errorThrow,
               boolean dontSkipUtf8Bom) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class.
* `CharacterReader​(java.lang.String str) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class.
* `CharacterReader​(java.lang.String str,
               boolean skipByteOrderMark) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class.
* `CharacterReader​(java.lang.String str,
               boolean skipByteOrderMark,
               boolean errorThrow) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class.
* `CharacterReader​(java.lang.String str,
               int offset,
               int length) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class.
* `CharacterReader​(java.lang.String str,
               int offset,
               int length,
               boolean skipByteOrderMark,
               boolean errorThrow) CharacterReader`<br>
 Initializes a new instance of the CharacterReader class.

## Method Details

### CharacterReader
    public CharacterReader​(java.lang.String str)
Initializes a new instance of the <code>CharacterReader</code> class.

**Parameters:**

* <code>str</code> - The parameter <code>str</code> is a text string.

### CharacterReader
    public CharacterReader​(java.lang.String str, boolean skipByteOrderMark)
Initializes a new instance of the <code>CharacterReader</code> class.

**Parameters:**

* <code>str</code> - The parameter <code>str</code> is a text string.

* <code>skipByteOrderMark</code> - If true and the first character in the string is
 U+FEFF, skip that character.

**Throws:**

* <code>java.lang.NullPointerException</code> - The parameter <code>str</code> is null.

### CharacterReader
    public CharacterReader​(java.lang.String str, boolean skipByteOrderMark, boolean errorThrow)
Initializes a new instance of the <code>CharacterReader</code> class.

**Parameters:**

* <code>str</code> - The parameter <code>str</code> is a text string.

* <code>skipByteOrderMark</code> - If true and the first character in the string is
 U+FEFF, skip that character.

* <code>errorThrow</code> - When encountering invalid encoding, throw an exception if
 this parameter is true, or replace it with U+FFFD (replacement
 character) if this parameter is false.

**Throws:**

* <code>java.lang.NullPointerException</code> - The parameter <code>str</code> is null.

### CharacterReader
    public CharacterReader​(java.lang.String str, int offset, int length)
Initializes a new instance of the <code>CharacterReader</code> class.

**Parameters:**

* <code>str</code> - The parameter <code>str</code> is a text string.

* <code>offset</code> - An index, starting at 0, showing where the desired portion of
 <code>str</code> begins.

* <code>length</code> - The length, in code units, of the desired portion of <code>
 str</code> (but not more than <code>str</code> 's length).

**Throws:**

* <code>java.lang.IllegalArgumentException</code> - Either "offset" or "length" is less than 0 or
  greater than "str"'s length, or "str"'s length minus "offset" is
  less than "length".

* <code>java.lang.NullPointerException</code> - The parameter <code>str</code> is null.

### CharacterReader
    public CharacterReader​(java.lang.String str, int offset, int length, boolean skipByteOrderMark, boolean errorThrow)
Initializes a new instance of the <code>CharacterReader</code> class.

**Parameters:**

* <code>str</code> - The parameter <code>str</code> is a text string.

* <code>offset</code> - An index, starting at 0, showing where the desired portion of
 <code>str</code> begins.

* <code>length</code> - The length, in code units, of the desired portion of <code>
 str</code> (but not more than <code>str</code> 's length).

* <code>skipByteOrderMark</code> - If true and the first character in the string
 portion is U+FEFF, skip that character.

* <code>errorThrow</code> - When encountering invalid encoding, throw an exception if
 this parameter is true, or replace it with U+FFFD (replacement
 character) if this parameter is false.

**Throws:**

* <code>java.lang.NullPointerException</code> - The parameter <code>str</code> is null.

* <code>java.lang.IllegalArgumentException</code> - Either <code>offset</code> or <code>length</code> is less
 than 0 or greater than <code>str</code> 's length, or <code>str</code> 's
 length minus <code>offset</code> is less than <code>length</code>.

### CharacterReader
    public CharacterReader​(java.io.InputStream stream)
Initializes a new instance of the <code>CharacterReader</code> class; will read the stream as
 UTF-8, skip the byte-order mark (U+FEFF) if it appears first in the
 stream, and replace invalid byte sequences with replacement
 characters (U+FFFD).

**Parameters:**

* <code>stream</code> - A readable data stream.

**Throws:**

* <code>java.lang.NullPointerException</code> - The parameter <code>stream</code> is null.

### CharacterReader
    public CharacterReader​(java.io.InputStream stream, int mode, boolean errorThrow)
Initializes a new instance of the <code>CharacterReader</code> class; will skip the
 byte-order mark (U+FEFF) if it appears first in the stream and a
 UTF-8 stream is detected.

**Parameters:**

* <code>stream</code> - A readable data stream.

* <code>mode</code> - The method to use when detecting encodings other than UTF-8 in
 the byte stream. This usually involves checking whether the stream
 begins with a byte-order mark (BOM, U+FEFF) or a non-zero basic code
 point (U+0001 to U+007F) before reading the rest of the stream. This
 value can be one of the following: <ul> <li>0: UTF-8 only.</li>
 <li>1: Detect UTF-16 using BOM or non-zero basic code point,
 otherwise UTF-8.</li> <li>2: Detect UTF-16/UTF-32 using BOM or
 non-zero basic code point, otherwise UTF-8. (Tries to detect UTF-32
 first.)</li> <li>3: Detect UTF-16 using BOM, otherwise UTF-8.</li>
 <li>4: Detect UTF-16/UTF-32 using BOM, otherwise UTF-8. (Tries to
 detect UTF-32 first.)</li></ul>.

* <code>errorThrow</code> - When encountering invalid encoding, throw an exception if
 this parameter is true, or replace it with U+FFFD (replacement
 character) if this parameter is false.

### CharacterReader
    public CharacterReader​(java.io.InputStream stream, int mode)
Initializes a new instance of the <code>CharacterReader</code> class; will skip the
 byte-order mark (U+FEFF) if it appears first in the stream and
 replace invalid byte sequences with replacement characters (U+FFFD).

**Parameters:**

* <code>stream</code> - A readable byte stream.

* <code>mode</code> - The method to use when detecting encodings other than UTF-8 in
 the byte stream. This usually involves checking whether the stream
 begins with a byte-order mark (BOM, U+FEFF) or a non-zero basic code
 point (U+0001 to U+007F) before reading the rest of the stream. This
 value can be one of the following: <ul> <li>0: UTF-8 only.</li>
 <li>1: Detect UTF-16 using BOM or non-zero basic code point,
 otherwise UTF-8.</li> <li>2: Detect UTF-16/UTF-32 using BOM or
 non-zero basic code point, otherwise UTF-8. (Tries to detect UTF-32
 first.)</li> <li>3: Detect UTF-16 using BOM, otherwise UTF-8.</li>
 <li>4: Detect UTF-16/UTF-32 using BOM, otherwise UTF-8. (Tries to
 detect UTF-32 first.)</li></ul>.

**Throws:**

* <code>java.lang.NullPointerException</code> - The parameter <code>stream</code> is null.

### CharacterReader
    public CharacterReader​(java.io.InputStream stream, int mode, boolean errorThrow, boolean dontSkipUtf8Bom)
Initializes a new instance of the <code>CharacterReader</code> class.

**Parameters:**

* <code>stream</code> - A readable byte stream.

* <code>mode</code> - The method to use when detecting encodings other than UTF-8 in
 the byte stream. This usually involves checking whether the stream
 begins with a byte-order mark (BOM, U+FEFF) or a non-zero basic code
 point (U+0001 to U+007F) before reading the rest of the stream. This
 value can be one of the following: <ul> <li>0: UTF-8 only.</li>
 <li>1: Detect UTF-16 using BOM or non-zero basic code point,
 otherwise UTF-8.</li> <li>2: Detect UTF-16/UTF-32 using BOM or
 non-zero basic code point, otherwise UTF-8. (Tries to detect UTF-32
 first.)</li> <li>3: Detect UTF-16 using BOM, otherwise UTF-8.</li>
 <li>4: Detect UTF-16/UTF-32 using BOM, otherwise UTF-8. (Tries to
 detect UTF-32 first.)</li></ul>.

* <code>errorThrow</code> - If true, will throw an exception if invalid byte sequences
 (in the detected encoding) are found in the byte stream. If false,
 replaces those byte sequences with replacement characters (U+FFFD)
 as the stream is read.

* <code>dontSkipUtf8Bom</code> - If the stream is detected as UTF-8 and this parameter
 is <code>true</code>, won't skip the BOM character if it occurs at the
 start of the stream.

**Throws:**

* <code>java.lang.NullPointerException</code> - The parameter <code>stream</code> is null.

### Read
    public int Read​(int[] chars, int index, int length)
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
 than the <code>length</code> parameter if the end of the stream is
 reached.

**Throws:**

* <code>java.lang.NullPointerException</code> - The parameter <code>chars</code> is null.

* <code>java.lang.IllegalArgumentException</code> - Either <code>index</code> or <code>length</code> is less
 than 0 or greater than <code>chars</code> 's length, or <code>chars</code> 's
 length minus <code>index</code> is less than <code>length</code>.

### ReadChar
    public int ReadChar()
Reads the next character from a Unicode stream or a string.

**Specified by:**

* <code>ReadChar</code> in interface <code>ICharacterInput</code>

**Returns:**

* The next character, or -1 if the end of the string or stream was
 reached.
