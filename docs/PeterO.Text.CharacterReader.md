## PeterO.Text.CharacterReader

    public sealed class CharacterReader :
        PeterO.Text.ICharacterInput

A general-purpose character input for reading text from byte streams and text strings. When reading byte streams, this class supports the UTF-8 character encoding by default, but can be configured to support UTF-16 and UTF-32 as well.

### CharacterReader Constructor

    public CharacterReader(
        string str);

Initializes a new instance of the class using a Unicode 16-bit string; if the string begins with a byte-order mark (U+FEFF), it won't be skipped, and any unpaired surrogate code points (U+D800 to U+DFFF) in the string are replaced with replacement characters (U+FFFD).

<b>Parameters:</b>

 * <i>str</i>: The string to read.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>str</i>
 is null.

### CharacterReader Constructor

    public CharacterReader(
        string str,
        bool skipByteOrderMark);

Initializes a new instance of the class using a Unicode 16-bit string; any unpaired surrogate code points (U+D800 to U+DFFF) in the string are replaced with replacement characters (U+FFFD).

<b>Parameters:</b>

 * <i>str</i>: The string to read.

 * <i>skipByteOrderMark</i>: If true and the string begins with a byte-order mark (U+FEFF), will skip that code point as it reads the string.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>str</i>
 is null.

### CharacterReader Constructor

    public CharacterReader(
        string str,
        bool skipByteOrderMark,
        bool errorThrow);

Initializes a new instance of the class using a Unicode 16-bit string.

<b>Parameters:</b>

 * <i>str</i>: The string to read.

 * <i>skipByteOrderMark</i>: If true and the string begins with a byte-order mark (U+FEFF), will skip that code point as it reads the string.

 * <i>errorThrow</i>: If true, will throw an exception if unpaired surrogate code points (U+D800 to U+DFFF) are found in the string. If false, replaces those byte sequences with replacement characters (U+FFFD) as the stream is read.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>str</i>
 is null.

### CharacterReader Constructor

    public CharacterReader(
        string str,
        int offset,
        int length);

Initializes a new instance of the  class.

<b>Parameters:</b>

 * <i>str</i>: A text string.

 * <i>offset</i>: A 32-bit signed integer.

 * <i>length</i>: Another 32-bit signed integer.

### CharacterReader Constructor

    public CharacterReader(
        string str,
        int offset,
        int length,
        bool skipByteOrderMark,
        bool errorThrow);

Initializes a new instance of the  class.

<b>Parameters:</b>

 * <i>str</i>: A text string.

 * <i>offset</i>: A 32-bit signed integer.

 * <i>length</i>: Another 32-bit signed integer.

 * <i>skipByteOrderMark</i>: A Boolean object.

 * <i>errorThrow</i>: Another Boolean object.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter  <i>str</i>
 is null.

### CharacterReader Constructor

    public CharacterReader(
        System.IO.Stream stream);

Initializes a new instance of the class; will read the stream as UTF-8, skip the byte-order mark (U+FEFF) if it appears first in the stream, and replace invalidly encoded bytes with replacement characters (U+FFFD).

<b>Parameters:</b>

 * <i>stream</i>: A readable data stream.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>stream</i>
 is null.

### CharacterReader Constructor

    public CharacterReader(
        System.IO.Stream stream,
        int mode);

Initializes a new instance of the class; will skip the byte-order mark (U+FEFF) if it appears first in the stream and replace invalidly encoded bytes with replacement characters (U+FFFD).

<b>Parameters:</b>

 * <i>stream</i>: A readable byte stream.

 * <i>mode</i>: The method to use when detecting encodings other than UTF-8 in the byte stream. This usually involves checking whether the stream begins with a byte-order mark (BOM, U+FEFF) or a non-zero basic code point (NZB, U+0001 to U+007F) before reading the rest of the stream. This value can be one of the following:

 * 0: UTF-8 only.

 * 1: Detect UTF-16 using BOM or NZB, otherwise UTF-8.

 * 2: Detect UTF-16/UTF-32 using BOM or NZB, otherwise UTF-8. (Tries to detect UTF-32 first.)

 * 3: Detect UTF-16 using BOM, otherwise UTF-8.

 * 4: Detect UTF-16/UTF-32 using BOM, otherwise UTF-8. (Tries to detect UTF-32 first.)

.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>stream</i>
 is null.

### CharacterReader Constructor

    public CharacterReader(
        System.IO.Stream stream,
        int mode,
        bool errorThrow);

Initializes a new instance of the class; will skip the byte-order mark (U+FEFF) if it appears first in the stream.

<b>Parameters:</b>

 * <i>stream</i>: A readable byte stream.

 * <i>mode</i>: The method to use when detecting encodings other than UTF-8 in the byte stream. This usually involves checking whether the stream begins with a byte-order mark (BOM, U+FEFF) or a non-zero basic code point (NZB, U+0001 to U+007F) before reading the rest of the stream. This value can be one of the following:

 * 0: UTF-8 only.

 * 1: Detect UTF-16 using BOM or NZB, otherwise UTF-8.

 * 2: Detect UTF-16/UTF-32 using BOM or NZB, otherwise UTF-8. (Tries to detect UTF-32 first.)

 * 3: Detect UTF-16 using BOM, otherwise UTF-8.

 * 4: Detect UTF-16/UTF-32 using BOM, otherwise UTF-8. (Tries to detect UTF-32 first.)

.

 * <i>errorThrow</i>: If true, will throw an exception if invalid byte sequences (in the detected encoding) are found in the byte stream. If false, replaces those byte sequences with replacement characters (U+FFFD) as the stream is read.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>stream</i>
 is null.

### CharacterReader Constructor

    public CharacterReader(
        System.IO.Stream stream,
        int mode,
        bool errorThrow,
        bool dontSkipUtf8Bom);

Initializes a new instance of the class.

<b>Parameters:</b>

 * <i>stream</i>: A readable byte stream.

 * <i>mode</i>: The method to use when detecting encodings other than UTF-8 in the byte stream. This usually involves checking whether the stream begins with a byte-order mark (BOM, U+FEFF) or a non-zero basic code point (NZB, U+0001 to U+007F) before reading the rest of the stream. This value can be one of the following:

 * 0: UTF-8 only.

 * 1: Detect UTF-16 using BOM or NZB, otherwise UTF-8.

 * 2: Detect UTF-16/UTF-32 using BOM or NZB, otherwise UTF-8. (Tries to detect UTF-32 first.)

 * 3: Detect UTF-16 using BOM, otherwise UTF-8.

 * 4: Detect UTF-16/UTF-32 using BOM, otherwise UTF-8. (Tries to detect UTF-32 first.)

.

 * <i>errorThrow</i>: If true, will throw an exception if invalid byte sequences (in the detected encoding) are found in the byte stream. If false, replaces those byte sequences with replacement characters (U+FFFD) as the stream is read.

 * <i>dontSkipUtf8Bom</i>: If the stream is detected as UTF-8 and this parameter is  `true` , won't skip the BOM character if it occurs at the start of the stream.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>stream</i>
 is null.

### Read

    public sealed int Read(
        int[] chars,
        int index,
        int length);

Reads a series of code points from a Unicode stream or a string.

<b>Parameters:</b>

 * <i>chars</i>: An array where the code points that were read will be stored.

 * <i>index</i>: A zero-based index showing where the desired portion of  <i>chars</i>
 begins.

 * <i>length</i>: The number of elements in the desired portion of  <i>chars</i>
 (but not more than  <i>chars</i>
 's length).

<b>Returns:</b>

The number of code points read from the stream. This can be less than the  <i>length</i>
 parameter if the end of the stream is reached.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>chars</i>
 is null.

 * System.ArgumentException:
Either  <i>index</i>
 or  <i>length</i>
 is less than 0 or greater than  <i>chars</i>
 's length, or  <i>chars</i>
 's length minus  <i>index</i>
 is less than  <i>length</i>
.

### ReadChar

    public sealed int ReadChar();

Reads the next character from a Unicode stream or a string.

<b>Returns:</b>

The next character, or -1 if the end of the string or stream was reached.
