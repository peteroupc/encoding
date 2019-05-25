## PeterO.Text.CharacterReader

    public sealed class CharacterReader :
        PeterO.Text.ICharacterInput

A general-purpose character input for reading text from byte streams and text strings. When reading byte streams, this class supports the UTF-8 character encoding by default, but can be configured to support UTF-16 and UTF-32 as well.

### Member Summary
* <code>[ReadChar()](#ReadChar)</code> - Reads the next character from a Unicode stream or a string.
* <code>[Read(int[], int, int)](#Read_int_int_int)</code> - Reads a series of code points from a Unicode stream or a string.

<a id="Void_ctor_String"></a>
### CharacterReader Constructor

    public CharacterReader(
        string str);

Initializes a new instance of the [PeterO.Text.CharacterReader](PeterO.Text.CharacterReader.md) class.

<b>Parameters:</b>

 * <i>str</i>: The parameter <i>str</i>
is a text string.

<a id="Void_ctor_String_Boolean"></a>
### CharacterReader Constructor

    public CharacterReader(
        string str,
        bool skipByteOrderMark);

Initializes a new instance of the [PeterO.Text.CharacterReader](PeterO.Text.CharacterReader.md) class.

<b>Parameters:</b>

 * <i>str</i>: The parameter <i>str</i>
is a text string.

 * <i>skipByteOrderMark</i>: Either `true
      ` or `false
      ` .

<a id="Void_ctor_String_Boolean_Boolean"></a>
### CharacterReader Constructor

    public CharacterReader(
        string str,
        bool skipByteOrderMark,
        bool errorThrow);

Initializes a new instance of the [PeterO.Text.CharacterReader](PeterO.Text.CharacterReader.md) class.

<b>Parameters:</b>

 * <i>str</i>: The parameter <i>str</i>
is a text string.

 * <i>skipByteOrderMark</i>: Either `true
      ` or `false
      ` .

 * <i>errorThrow</i>: Either `true
      ` or `false
      ` .

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>str</i>
is null.

<a id="Void_ctor_String_Int32_Int32"></a>
### CharacterReader Constructor

    public CharacterReader(
        string str,
        int offset,
        int length);

Initializes a new instance of the [PeterO.Text.CharacterReader](PeterO.Text.CharacterReader.md) class.

<b>Parameters:</b>

 * <i>str</i>: The parameter <i>str</i>
is a text string.

 * <i>offset</i>: The parameter <i>offset</i>
is a 32-bit signed integer.

 * <i>length</i>: The parameter <i>length</i>
is a 32-bit signed integer.

<a id="Void_ctor_String_Int32_Int32_Boolean_Boolean"></a>
### CharacterReader Constructor

    public CharacterReader(
        string str,
        int offset,
        int length,
        bool skipByteOrderMark,
        bool errorThrow);

Initializes a new instance of the [PeterO.Text.CharacterReader](PeterO.Text.CharacterReader.md) class.

<b>Parameters:</b>

 * <i>str</i>: The parameter <i>str</i>
is a text string.

 * <i>offset</i>: The parameter <i>offset</i>
is a 32-bit signed integer.

 * <i>length</i>: The parameter <i>length</i>
is a 32-bit signed integer.

 * <i>skipByteOrderMark</i>: Either `true
      ` or `false
      ` .

 * <i>errorThrow</i>: Either `true
      ` or `false
      ` .

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>str</i>
is null.

<a id="Void_ctor_Stream"></a>
### CharacterReader Constructor

    public CharacterReader(
        System.IO.Stream stream);

Initializes a new instance of the [PeterO.Text.CharacterReader](PeterO.Text.CharacterReader.md) class.

<b>Parameters:</b>

 * <i>stream</i>: A readable data stream.

<a id="Void_ctor_Stream_Int32"></a>
### CharacterReader Constructor

    public CharacterReader(
        System.IO.Stream stream,
        int mode);

Initializes a new instance of the [PeterO.Text.CharacterReader](PeterO.Text.CharacterReader.md) class.

<b>Parameters:</b>

 * <i>stream</i>: A readable data stream.

 * <i>mode</i>: The parameter <i>mode</i>
is a 32-bit signed integer.

<a id="Void_ctor_Stream_Int32_Boolean"></a>
### CharacterReader Constructor

    public CharacterReader(
        System.IO.Stream stream,
        int mode,
        bool errorThrow);

Initializes a new instance of the [PeterO.Text.CharacterReader](PeterO.Text.CharacterReader.md) class.

<b>Parameters:</b>

 * <i>stream</i>: A readable data stream.

 * <i>mode</i>: The parameter <i>mode</i>
is a 32-bit signed integer.

 * <i>errorThrow</i>: Either `true
      ` or `false
      ` .

<a id="Void_ctor_Stream_Int32_Boolean_Boolean"></a>
### CharacterReader Constructor

    public CharacterReader(
        System.IO.Stream stream,
        int mode,
        bool errorThrow,
        bool dontSkipUtf8Bom);

Initializes a new instance of the [PeterO.Text.CharacterReader](PeterO.Text.CharacterReader.md) class.

<b>Parameters:</b>

 * <i>stream</i>: A readable data stream.

 * <i>mode</i>: The parameter <i>mode</i>
is a 32-bit signed integer.

 * <i>errorThrow</i>: Either `true
      ` or `false
      ` .

 * <i>dontSkipUtf8Bom</i>: Either `true
      ` or `false
      ` .

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>stream</i>
is null.

<a id="Read_int_int_int"></a>
### Read

    public sealed int Read(
        int[] chars,
        int index,
        int length);

Reads a series of code points from a Unicode stream or a string.

<b>Parameters:</b>

 * <i>chars</i>: An array where the code points that were read will be stored.

 * <i>index</i>: A zero-based index showing where the desired portion of <i>chars</i>
begins.

 * <i>length</i>: The number of elements in the desired portion of <i>chars</i>
(but not more than <i>chars</i>
's length).

<b>Return Value:</b>

The number of code points read from the stream. This can be less than the <i>length</i>
parameter if the end of the stream is reached.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>chars</i>
is null.

 * System.ArgumentException:
Either <i>index</i>
or <i>length</i>
is less than 0 or greater than <i>chars</i>
's length, or <i>chars</i>
's length minus <i>index</i>
is less than <i>length</i>
.

<a id="ReadChar"></a>
### ReadChar

    public sealed int ReadChar();

Reads the next character from a Unicode stream or a string.

<b>Return Value:</b>

The next character, or -1 if the end of the string or stream was reached.
