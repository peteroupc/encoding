# com.upokecenter.text.CharacterReader

    public final class CharacterReader extends Object implements ICharacterInput

A general-purpose character input for reading text from byte streams and
 text strings. When reading byte streams, this class supports the
 UTF-8 character encoding by default, but can be configured to support
 UTF-16 and UTF-32 as well.

## Methods

* `CharacterReader(InputStream stream)`<br>
 Initializes a new instance of the  class; will read the stream as
 UTF-8, skip the byte-order mark (U + FEFF) if it appears first in the
 stream, and replace invalid byte sequences with replacement
 characters (U + FFFD).
* `CharacterReader(InputStream stream,
               int mode)`<br>
 Initializes a new instance of the  class; will skip the
 byte-order mark (U + FEFF) if it appears first in the stream and
 replace invalid byte sequences with replacement characters (U + FFFD).
* `CharacterReader(InputStream stream,
               int mode,
               boolean errorThrow)`<br>
 Initializes a new instance of the  class; will skip the
 byte-order mark (U + FEFF) if it appears first in the stream.
* `CharacterReader(InputStream stream,
               int mode,
               boolean errorThrow,
               boolean dontSkipUtf8Bom)`<br>
 Initializes a new instance of the  class.
* `CharacterReader(String str)`<br>
 Initializes a new instance of the  class using a Unicode 16-bit
 string; if the string begins with a byte-order mark (U + FEFF), it
 won't be skipped, and any unpaired surrogate code points (U+D800 to
 U + DFFF) in the string are replaced with replacement characters
 (U + FFFD).
* `CharacterReader(String str,
               boolean skipByteOrderMark)`<br>
 Initializes a new instance of the  class using a Unicode 16-bit
 string; any unpaired surrogate code points (U + D800 to U + DFFF) in the
 string are replaced with replacement characters (U + FFFD).
* `CharacterReader(String str,
               boolean skipByteOrderMark,
               boolean errorThrow)`<br>
 Initializes a new instance of the  class using a Unicode 16-bit
 string.
* `CharacterReader(String str,
               int offset,
               int length)`<br>
 Initializes a new instance of the  class.
* `CharacterReader(String str,
               int offset,
               int length,
               boolean skipByteOrderMark,
               boolean errorThrow)`<br>
 Initializes a new instance of the  class.
* `int Read(int[] chars,
    int index,
    int length)`<br>
 Reads a series of code points from a Unicode stream or a string.
* `int ReadChar()`<br>
 Reads the next character from a Unicode stream or a string.

## Constructors

* `CharacterReader(InputStream stream)`<br>
 Initializes a new instance of the  class; will read the stream as
 UTF-8, skip the byte-order mark (U + FEFF) if it appears first in the
 stream, and replace invalid byte sequences with replacement
 characters (U + FFFD).
* `CharacterReader(InputStream stream,
               int mode)`<br>
 Initializes a new instance of the  class; will skip the
 byte-order mark (U + FEFF) if it appears first in the stream and
 replace invalid byte sequences with replacement characters (U + FFFD).
* `CharacterReader(InputStream stream,
               int mode,
               boolean errorThrow)`<br>
 Initializes a new instance of the  class; will skip the
 byte-order mark (U + FEFF) if it appears first in the stream.
* `CharacterReader(InputStream stream,
               int mode,
               boolean errorThrow,
               boolean dontSkipUtf8Bom)`<br>
 Initializes a new instance of the  class.
* `CharacterReader(String str)`<br>
 Initializes a new instance of the  class using a Unicode 16-bit
 string; if the string begins with a byte-order mark (U + FEFF), it
 won't be skipped, and any unpaired surrogate code points (U+D800 to
 U + DFFF) in the string are replaced with replacement characters
 (U + FFFD).
* `CharacterReader(String str,
               boolean skipByteOrderMark)`<br>
 Initializes a new instance of the  class using a Unicode 16-bit
 string; any unpaired surrogate code points (U + D800 to U + DFFF) in the
 string are replaced with replacement characters (U + FFFD).
* `CharacterReader(String str,
               boolean skipByteOrderMark,
               boolean errorThrow)`<br>
 Initializes a new instance of the  class using a Unicode 16-bit
 string.
* `CharacterReader(String str,
               int offset,
               int length)`<br>
 Initializes a new instance of the  class.
* `CharacterReader(String str,
               int offset,
               int length,
               boolean skipByteOrderMark,
               boolean errorThrow)`<br>
 Initializes a new instance of the  class.

## Method Details

### CharacterReader
    public CharacterReader(String str)
Initializes a new instance of the <see cref='T:PeterO.Text.CharacterReader'/> class using a Unicode 16-bit
 string; if the string begins with a byte-order mark (U + FEFF), it
 won't be skipped, and any unpaired surrogate code points (U+D800 to
 U + DFFF) in the string are replaced with replacement characters
 (U + FFFD).

**Parameters:**

* <code>str</code> - The string to read.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>str</code> is null.

### CharacterReader
    public CharacterReader(String str, boolean skipByteOrderMark)
Initializes a new instance of the <see cref='T:PeterO.Text.CharacterReader'/> class using a Unicode 16-bit
 string; any unpaired surrogate code points (U + D800 to U + DFFF) in the
 string are replaced with replacement characters (U + FFFD).

**Parameters:**

* <code>str</code> - The string to read.

* <code>skipByteOrderMark</code> - If true and the string begins with a byte-order
 mark (U + FEFF), will skip that code point as it reads the string.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>str</code> is null.

### CharacterReader
    public CharacterReader(String str, boolean skipByteOrderMark, boolean errorThrow)
Initializes a new instance of the <see cref='T:PeterO.Text.CharacterReader'/> class using a Unicode 16-bit
 string.

**Parameters:**

* <code>str</code> - The string to read.

* <code>skipByteOrderMark</code> - If true and the string begins with a byte-order
 mark (U + FEFF), will skip that code point as it reads the string.

* <code>errorThrow</code> - If true, will throw an exception if unpaired surrogate
 code points (U + D800 to U + DFFF) are found in the string. If false,
 replaces those byte sequences with replacement characters (U + FFFD) as
 the stream is read.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>str</code> is null.

### CharacterReader
    public CharacterReader(String str, int offset, int length)
Initializes a new instance of the <see cref='T:PeterO.Text.CharacterReader'/> class.

**Parameters:**

* <code>str</code> - A text string.

* <code>offset</code> - A zero-based index showing where the desired portion of <code>str</code> begins.

* <code>length</code> - The number of elements in the desired portion of <code>str</code>
 (but not more than <code>str</code> 's length).

### CharacterReader
    public CharacterReader(String str, int offset, int length, boolean skipByteOrderMark, boolean errorThrow)
Initializes a new instance of the <see cref='T:PeterO.Text.CharacterReader'/> class.

**Parameters:**

* <code>str</code> - A text string.

* <code>offset</code> - A zero-based index showing where the desired portion of <code>str</code> begins.

* <code>length</code> - The number of elements in the desired portion of <code>str</code>
 (but not more than <code>str</code> 's length).

* <code>skipByteOrderMark</code> - If true and the string begins with a byte-order
 mark (U + FEFF), will skip that code point as it reads the string.

* <code>errorThrow</code> - If true, will throw an exception if unpaired surrogate
 code points (U + D800 to U + DFFF) are found in the string. If false,
 replaces those byte sequences with replacement characters (U + FFFD) as
 the stream is read.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>str</code> is null.

### CharacterReader
    public CharacterReader(InputStream stream)
Initializes a new instance of the <see cref='T:PeterO.Text.CharacterReader'/> class; will read the stream as
 UTF-8, skip the byte-order mark (U + FEFF) if it appears first in the
 stream, and replace invalid byte sequences with replacement
 characters (U + FFFD).

**Parameters:**

* <code>stream</code> - A readable data stream.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>stream</code> is null.

### CharacterReader
    public CharacterReader(InputStream stream, int mode, boolean errorThrow)
Initializes a new instance of the <see cref='T:PeterO.Text.CharacterReader'/> class; will skip the
 byte-order mark (U + FEFF) if it appears first in the stream.

**Parameters:**

* <code>stream</code> - A readable byte stream.

* <code>mode</code> - The method to use when detecting encodings other than UTF-8 in
 the byte stream. This usually involves checking whether the stream
 begins with a byte-order mark (BOM, U + FEFF) or a non-zero basic code
 point (NZB, U + 0001 to U + 007F) before reading the rest of the stream.
 This value can be one of the following: <ul> <li>0: UTF-8 only.</li>
 <li>1: Detect UTF-16 using BOM or NZB, otherwise UTF-8.</li> <li>2:
 Detect UTF-16/UTF-32 using BOM or NZB, otherwise UTF-8. (Tries to
 detect UTF-32 first.)</li> <li>3: Detect UTF-16 using BOM, otherwise
 UTF-8.</li> <li>4: Detect UTF-16/UTF-32 using BOM, otherwise UTF-8.
 (Tries to detect UTF-32 first.)</li></ul>.

* <code>errorThrow</code> - If true, will throw an exception if invalid byte sequences
 (in the detected encoding) are found in the byte stream. If false,
 replaces those byte sequences with replacement characters (U + FFFD) as
 the stream is read.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>stream</code> is null.

### CharacterReader
    public CharacterReader(InputStream stream, int mode)
Initializes a new instance of the <see cref='T:PeterO.Text.CharacterReader'/> class; will skip the
 byte-order mark (U + FEFF) if it appears first in the stream and
 replace invalid byte sequences with replacement characters (U + FFFD).

**Parameters:**

* <code>stream</code> - A readable byte stream.

* <code>mode</code> - The method to use when detecting encodings other than UTF-8 in
 the byte stream. This usually involves checking whether the stream
 begins with a byte-order mark (BOM, U + FEFF) or a non-zero basic code
 point (NZB, U + 0001 to U + 007F) before reading the rest of the stream.
 This value can be one of the following: <ul> <li>0: UTF-8 only.</li>
 <li>1: Detect UTF-16 using BOM or NZB, otherwise UTF-8.</li> <li>2:
 Detect UTF-16/UTF-32 using BOM or NZB, otherwise UTF-8. (Tries to
 detect UTF-32 first.)</li> <li>3: Detect UTF-16 using BOM, otherwise
 UTF-8.</li> <li>4: Detect UTF-16/UTF-32 using BOM, otherwise UTF-8.
 (Tries to detect UTF-32 first.)</li></ul>.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>stream</code> is null.

### CharacterReader
    public CharacterReader(InputStream stream, int mode, boolean errorThrow, boolean dontSkipUtf8Bom)
Initializes a new instance of the <see cref='T:PeterO.Text.CharacterReader'/> class.

**Parameters:**

* <code>stream</code> - A readable byte stream.

* <code>mode</code> - The method to use when detecting encodings other than UTF-8 in
 the byte stream. This usually involves checking whether the stream
 begins with a byte-order mark (BOM, U + FEFF) or a non-zero basic code
 point (NZB, U + 0001 to U + 007F) before reading the rest of the stream.
 This value can be one of the following: <ul> <li>0: UTF-8 only.</li>
 <li>1: Detect UTF-16 using BOM or NZB, otherwise UTF-8.</li> <li>2:
 Detect UTF-16/UTF-32 using BOM or NZB, otherwise UTF-8. (Tries to
 detect UTF-32 first.)</li> <li>3: Detect UTF-16 using BOM, otherwise
 UTF-8.</li> <li>4: Detect UTF-16/UTF-32 using BOM, otherwise UTF-8.
 (Tries to detect UTF-32 first.)</li></ul>.

* <code>errorThrow</code> - If true, will throw an exception if invalid byte sequences
 (in the detected encoding) are found in the byte stream. If false,
 replaces those byte sequences with replacement characters (U + FFFD) as
 the stream is read.

* <code>dontSkipUtf8Bom</code> - If the stream is detected as UTF-8 and this parameter
 is <code>true</code>, won't skip the BOM character if it occurs at the
 start of the stream.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>stream</code> is null.

### Read
    public int Read(int[] chars, int index, int length)
Reads a series of code points from a Unicode stream or a string.

**Specified by:**

* <code>Read</code>&nbsp;in interface&nbsp;<code>ICharacterInput</code>

**Parameters:**

* <code>chars</code> - An array where the code points that were read will be stored.

* <code>index</code> - A zero-based index showing where the desired portion of <code>chars</code> begins.

* <code>length</code> - The number of elements in the desired portion of <code>chars</code>
 (but not more than <code>chars</code> 's length).

**Returns:**

* The number of code points read from the stream. This can be less
 than the <code>length</code> parameter if the end of the stream is
 reached.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>chars</code> is null.

* <code>IllegalArgumentException</code> - Either <code>index</code> or <code>length</code> is
 less than 0 or greater than <code>chars</code> 's length, or <code>chars</code>
 's length minus <code>index</code> is less than <code>length</code>.

### ReadChar
    public int ReadChar()
Reads the next character from a Unicode stream or a string.

**Specified by:**

* <code>ReadChar</code>&nbsp;in interface&nbsp;<code>ICharacterInput</code>

**Returns:**

* The next character, or -1 if the end of the string or stream was
 reached.
