## PeterO.Text.Encodings

    public static class Encodings

Contains methods for converting text from one character encoding to another. This class also contains convenience methods for converting strings and other character inputs to sequences of bytes and vice versa.The Encoding Standard, which is a Candidate Recommendation as of early November 2015, defines algorithms for the most common character encodings used on Web pages and recommends the UTF-8 encoding for new specifications and Web pages. Calling the `GetEncoding(name)
        ` method returns one of the character encodings with the given name under he Encoding Standard.

Now let's define some terms.

<b>Encoding Terms</b>

 * A<b>code point</b>is a number that identifies a single text character, such as a etter, digit, or symbol. (A collection of such characters is also alled an<i>abstract character repertoire</i>.)

 * A<b>coded character set</b>is a set of code points which are each assigned to a single text haracter. As used here, coded character sets don't define how code oints are laid out in memory.

 * A<b>character encoding</b>is a mapping from a sequence of code points, in one or more specific oded character sets, to a sequence of bytes and vice versa. (For revity, the rest of this documentation may use the term<i>encoding</i>instead. RFC 6365 uses the analogous term<i>charset</i>instead; in this documentation, however,<i>charset</i>is used only to refer to the names that identify a character ncoding.)

 * <b>ASCII</b>is a 128-code-point coded character set that includes the English etters and digits, common punctuation and symbols, and control haracters. As used here, its code points match the code points within he Basic Latin block (0-127 or U+0000 to U+007F) of the Unicode tandard.

There are several kinds of character encodings:

 * <b>Single-byte encodings</b>define a coded character set that assigns one code point to one byte. hus, they can have a maximum of 256 code points. For example:

 * (a) ISO 8859 encodings and `windows-1252
          ` .

 * (b) ASCII is usually used as a single-byte encoding where each code point fits in the lower 7 bits of an eight-bit byte (in that case, the encoding is often called `US-ASCII
          ` ). In the Encoding Standard, all single-byte encodings use the ASCII haracters as the first 128 code points of their coded character sets.

 * <b>Multi-byte encodings</b>include code points from one or more coded character sets and assign ome or all code points to several bytes. For example:

 * (a) `UTF-16LE
          ` and `UTF-16BE
          ` are two encodings defined in the Unicode Standard. They use 2 bytes or the most common code points, and 4 bytes for supplementary code oints.

 * (b) `UTF-8
          ` is another encoding defined in the Unicode Standard. It uses 1 byte or ASCII and 2 to 4 bytes for the other Unicode code points.

 * (c) Most legacy East Asian encodings, such as `Shift_JIS
          ` , `GBK
          ` , and `Big5
          ` use 1 byte for ASCII (or a slightly modified version) and, usually, 2 r more bytes for national standard coded character sets. In many of hese encodings, notably `Shift_JIS
          ` , characters whose code points use one byte traditionally take half he space of characters whose code points use two bytes.

 * <b>Escape-based encodings</b>are combinations of single- and/or multi-byte encodings, and use scape sequences and/or shift codes to change which encoding to use or the bytes that follow. For example:

 * (a) `ISO-2022-JP
          ` supports several escape sequences that shift into different ncodings, including a Katakana, a Kanji, and an ASCII encoding (with SCII as the default).

 * (b) UTF-7 (not included in the Encoding Standard) is an encoding that uses the Unicode Standard's coded character set, which is encoded using a limited subset of ASCII. The plus symbol (U+002B) is used to shift into a UTF-16BE multi-byte encoding (converted to a modified version of base-64) to encode other Unicode code points.

 * The Encoding Standard also defines a<b>replacement encoding</b>, which causes a decoding error and is used to alias a few roblematic or unsupported encoding names, such as `hz-gb-2312
          ` .

<b>Getting an Encoding</b>

The Encoding Standard includes UTF-8, UTF-16, and many legacy encodings, and gives each one of them a name. The `GetEncoding(name)
        ` method takes a name string and returns an ICharacterEncoding object hat implements that encoding, or `null
        ` if the name is unrecognized.

However, the Encoding Standard is designed to include only encodings commonly used on Web pages, not in other protocols such as email. For email, the Encoding class includes an alternate function `GetEncoding(name, forEmail)
        ` . Setting `forEmail
        ` to `true
        ` will use rules modified from the Encoding Standard to better suit ncoding and decoding text from email messages.

<b>Classes for Character Encodings</b>

This Encodings class provides access to common character encodings through classes as described below:

 * An<b>encoder class</b>is a class that converts a sequence of bytes to a sequence of code oints in the universal character set (otherwise known under the name nicode). An encoder class implements the `ICharacterEncoder
          ` interface.

 * A<b>decoder class</b>is a class that converts a sequence of Unicode code points to a equence of bytes. A decoder class implements the `ICharacterDecoder
          ` interface.

 * An<b>encoding class</b>allows access to both an encoder class and a decoder class and mplements the `ICharacterEncoding
          ` interface. The encoder and decoder classes should implement the same haracter encoding.

<b>Custom Encodings</b>

Classes that implement the ICharacterEncoding interface can provide additional character encodings not included in the Encoding Standard. Some examples of these include the following:

 * A modified version of UTF-8 used in Java's serialization formats.

 * A modified version of UTF-7 used in the IMAP email protocol.

(Note that this library doesn't implement either encoding.)

### Member Summary
* <code>[DecodeToString(this PeterO.Text.ICharacterEncoding, PeterO.IByteReader)](#DecodeToString_this_PeterO_Text_ICharacterEncoding_PeterO_IByteReader)</code> - Reads bytes from a data source and converts the bytes from a given encoding to a text string.
* <code>[DecodeToString(this PeterO.Text.ICharacterEncoding, System.IO.Stream)](#DecodeToString_this_PeterO_Text_ICharacterEncoding_System_IO_Stream)</code> - Decodes data read from a data stream into a text string in the given character encoding.
* <code>[DecodeToString(this PeterO.Text.ICharacterEncoding, byte[])](#DecodeToString_this_PeterO_Text_ICharacterEncoding_byte)</code> - Reads a byte array from a data source and converts the bytes from a given encoding to a text string.
* <code>[DecodeToString(this PeterO.Text.ICharacterEncoding, byte[], int, int)](#DecodeToString_this_PeterO_Text_ICharacterEncoding_byte_int_int)</code> - Reads a portion of a byte array from a data source and converts the bytes from a given encoding to a text string.
* <code>[EncodeToBytes(this PeterO.Text.ICharacterInput, PeterO.Text.ICharacterEncoder)](#EncodeToBytes_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoder)</code> - Reads Unicode characters from a character input and writes them to a byte array encoded using a given character encoding.
* <code>[EncodeToBytes(this PeterO.Text.ICharacterInput, PeterO.Text.ICharacterEncoder, bool)](#EncodeToBytes_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoder_bool)</code> - Reads Unicode characters from a character input and writes them to a byte array encoded using the given character encoder and fallback strategy.
* <code>[EncodeToBytes(this PeterO.Text.ICharacterInput, PeterO.Text.ICharacterEncoding)](#EncodeToBytes_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoding)</code> - Reads Unicode characters from a character input and writes them to a byte array encoded using the given character encoder.
* <code>[EncodeToBytes(this string, PeterO.Text.ICharacterEncoding)](#EncodeToBytes_this_string_PeterO_Text_ICharacterEncoding)</code> - Reads Unicode characters from a text string and writes them to a byte array encoded in a given character encoding.
* <code>[EncodeToBytes(this string, PeterO.Text.ICharacterEncoding, bool)](#EncodeToBytes_this_string_PeterO_Text_ICharacterEncoding_bool)</code> - Reads Unicode characters from a text string and writes them to a byte array encoded in a given character encoding and using the given encoder fallback strategy.
* <code>[EncodeToWriter(this PeterO.Text.ICharacterInput, PeterO.Text.ICharacterEncoder, PeterO.IWriter)](#EncodeToWriter_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoder_PeterO_IWriter)</code> - Reads Unicode characters from a character input and writes them to a byte array encoded in a given character encoding.
* <code>[EncodeToWriter(this PeterO.Text.ICharacterInput, PeterO.Text.ICharacterEncoder, System.IO.Stream)](#EncodeToWriter_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoder_System_IO_Stream)</code> - Reads Unicode characters from a character input and writes them to a byte array encoded in a given character encoding.
* <code>[EncodeToWriter(this PeterO.Text.ICharacterInput, PeterO.Text.ICharacterEncoding, PeterO.IWriter)](#EncodeToWriter_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoding_PeterO_IWriter)</code> - Reads Unicode characters from a character input and writes them to a byte array encoded using the given character encoder.
* <code>[EncodeToWriter(this PeterO.Text.ICharacterInput, PeterO.Text.ICharacterEncoding, System.IO.Stream)](#EncodeToWriter_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoding_System_IO_Stream)</code> - Reads Unicode characters from a character input and writes them to a byte array encoded using the given character encoder.
* <code>[EncodeToWriter(this string, PeterO.Text.ICharacterEncoding, PeterO.IWriter)](#EncodeToWriter_this_string_PeterO_Text_ICharacterEncoding_PeterO_IWriter)</code> - Converts a text string to bytes and writes the bytes to an output byte writer.
* <code>[EncodeToWriter(this string, PeterO.Text.ICharacterEncoding, System.IO.Stream)](#EncodeToWriter_this_string_PeterO_Text_ICharacterEncoding_System_IO_Stream)</code> - Converts a text string to bytes and writes the bytes to an output data stream.
* <code>[GetDecoderInputSkipBom(this PeterO.Text.ICharacterEncoding, PeterO.IByteReader)](#GetDecoderInputSkipBom_this_PeterO_Text_ICharacterEncoding_PeterO_IByteReader)</code> - Converts a character encoding into a character input stream, given a streamable source of bytes.
* <code>[GetDecoderInputSkipBom(this PeterO.Text.ICharacterEncoding, System.IO.Stream)](#GetDecoderInputSkipBom_this_PeterO_Text_ICharacterEncoding_System_IO_Stream)</code> - Converts a character encoding into a character input stream, given a readable data stream.
* <code>[GetDecoderInput(this PeterO.Text.ICharacterEncoding, PeterO.IByteReader)](#GetDecoderInput_this_PeterO_Text_ICharacterEncoding_PeterO_IByteReader)</code> - Converts a character encoding into a character input stream, given a streamable source of bytes.
* <code>[GetDecoderInput(this PeterO.Text.ICharacterEncoding, System.IO.Stream)](#GetDecoderInput_this_PeterO_Text_ICharacterEncoding_System_IO_Stream)</code> - Converts a character encoding into a character input stream, given a data stream.
* <code>[GetEncoding(string)](#GetEncoding_string)</code> - Returns a character encoding from the given name.
* <code>[GetEncoding(string, bool)](#GetEncoding_string_bool)</code> - Returns a character encoding from the given name.
* <code>[GetEncoding(string, bool, bool)](#GetEncoding_string_bool_bool)</code> - Returns a character encoding from the given name.
* <code>[InputToString(this PeterO.Text.ICharacterInput)](#InputToString_this_PeterO_Text_ICharacterInput)</code> - Reads Unicode characters from a character input and converts them to a text string.
* <code>[ResolveAliasForEmail(string)](#ResolveAliasForEmail_string)</code> - Resolves a character encoding's name to a canonical form, using rules more suitable for email.
* <code>[ResolveAlias(string)](#ResolveAlias_string)</code> - Resolves a character encoding's name to a standard form.
* <code>[StringToBytes(this PeterO.Text.ICharacterEncoder, string)](#StringToBytes_this_PeterO_Text_ICharacterEncoder_string)</code> - Converts a text string to a byte array using the given character encoder.
* <code>[StringToBytes(this PeterO.Text.ICharacterEncoding, string)](#StringToBytes_this_PeterO_Text_ICharacterEncoding_string)</code> - Converts a text string to a byte array encoded in a given character encoding.
* <code>[StringToInput(this string)](#StringToInput_this_string)</code> - Converts a text string to a character input.
* <code>[StringToInput(this string, int, int)](#StringToInput_this_string_int_int)</code> - Converts a portion of a text string to a character input.
* <code>[public static readonly PeterO.Text.ICharacterEncoding UTF8;](#UTF8)</code> - Character encoding object for the UTF-8 character encoding, which represents each code point in the universal coded character set using 1 to 4 bytes.

<a id="UTF8"></a>
### UTF8

    public static readonly PeterO.Text.ICharacterEncoding UTF8;

Character encoding object for the UTF-8 character encoding, which represents each code point in the universal coded character set using 1 to 4 bytes.

<a id="DecodeToString_this_PeterO_Text_ICharacterEncoding_byte"></a>
### DecodeToString

    public static string DecodeToString(
        this PeterO.Text.ICharacterEncoding enc,
        byte[] bytes);

Reads a byte array from a data source and converts the bytes from a given encoding to a text string. Errors in decoding are handled by replacing erroneous bytes with the replacement character (U+FFFD).In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: `enc.DecodeToString(bytes)
        ` . If the object's class already has a DecodeToString method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: `enc.DecodeToString(bytes)
        ` . If the object's class already has a `DecodeToString
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>enc</i>: An object implementing a character encoding (gives access to an encoder and a decoder).

 * <i>bytes</i>: A byte array.

<b>Return Value:</b>

A string consisting of the decoded text.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>enc</i>
or <i>bytes</i>
is null.

<a id="DecodeToString_this_PeterO_Text_ICharacterEncoding_byte_int_int"></a>
### DecodeToString

    public static string DecodeToString(
        this PeterO.Text.ICharacterEncoding enc,
        byte[] bytes,
        int offset,
        int length);

Reads a portion of a byte array from a data source and converts the bytes from a given encoding to a text string. Errors in decoding are handled by replacing erroneous bytes with the replacement character (U+FFFD).In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: `enc.DecodeToString(bytes, offset, length)
        ` . If the object's class already has a DecodeToString method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: `enc.DecodeToString(bytes, offset, length)
        ` . If the object's class already has a `DecodeToString
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>enc</i>: An object implementing a character encoding (gives access to an encoder and a decoder).

 * <i>bytes</i>: A byte array containing the desired portion to read.

 * <i>offset</i>: A zero-based index showing where the desired portion of <i>bytes</i>
begins.

 * <i>length</i>: The length, in bytes, of the desired portion of <i>bytes</i>
(but not more than <i>bytes</i>
's length).

<b>Return Value:</b>

A string consisting of the decoded text.

<b>Exceptions:</b>

 *  T:System.ArgumentNullException:
The parameter <i>enc</i>
or <i>bytes</i>
is null.

 * System.ArgumentException:
Either <i>offset</i>
or <i>length</i>
is less than 0 or greater than <i>bytes</i>
's length, or <i> bytes</i>
' s length minus <i>offset</i>
is less than <i>length</i>
.

 * System.ArgumentNullException:
The parameter <i>enc</i>
or <i>bytes</i>
is null.

<a id="DecodeToString_this_PeterO_Text_ICharacterEncoding_System_IO_Stream"></a>
### DecodeToString

    public static string DecodeToString(
        this PeterO.Text.ICharacterEncoding enc,
        System.IO.Stream input);

Decodes data read from a data stream into a text string in the given character encoding.In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: `encoding.DecodeToString(input)
        ` . If the object's class already has a DecodeToString method with the same parameters, that method takes precedence over this extension method.

In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: `enc.DecodeToString(input)
        ` . If the object's class already has a `DecodeToString
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>enc</i>: An object implementing a character encoding (gives access to an encoder and a decoder).

 * <i>input</i>: A readable byte stream.

<b>Return Value:</b>

A string consisting of the decoded text.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter "encoding" or <i>input</i>
is null.

<a id="DecodeToString_this_PeterO_Text_ICharacterEncoding_PeterO_IByteReader"></a>
### DecodeToString

    public static string DecodeToString(
        this PeterO.Text.ICharacterEncoding encoding,
        PeterO.IByteReader input);

Reads bytes from a data source and converts the bytes from a given encoding to a text string.In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: "encoding.DecodeString(input)". If the object's class already has a DecodeToString method with the same parameters, that method takes precedence over this extension method.

<b>Parameters:</b>

 * <i>encoding</i>: An object that implements a given character encoding. Any bytes that can't be decoded are converted to the replacement character (U+FFFD).

 * <i>input</i>: An object that implements a byte stream.

<b>Return Value:</b>

The converted string.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>encoding</i>
or <i>input</i>
is null.

<a id="EncodeToBytes_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoder"></a>
### EncodeToBytes

    public static byte[] EncodeToBytes(
        this PeterO.Text.ICharacterInput input,
        PeterO.Text.ICharacterEncoder encoder);

Reads Unicode characters from a character input and writes them to a byte array encoded using a given character encoding. When writing to the byte array, any characters that can't be encoded are replaced with the byte 0x3f (the question mark character).In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `input.EncodeToBytes(encoder)
        ` . If the object's class already has a EncodeToBytes method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `input.EncodeToBytes(encoder)
        ` . If the object's class already has a `EncodeToBytes
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>input</i>: An object that implements a stream of universal code points.

 * <i>encoder</i>: An object that implements a character encoder.

<b>Return Value:</b>

A byte array.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>encoder</i>
or <i>input</i>
is null.

<a id="EncodeToBytes_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoder_bool"></a>
### EncodeToBytes

    public static byte[] EncodeToBytes(
        this PeterO.Text.ICharacterInput input,
        PeterO.Text.ICharacterEncoder encoder,
        bool htmlFallback);

Reads Unicode characters from a character input and writes them to a byte array encoded using the given character encoder and fallback strategy.In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `input.EncodeToBytes(encoder, htmlFallback)
        ` . If the object's class already has a `EncodeToBytes
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>input</i>: An object that implements a stream of universal code points.

 * <i>encoder</i>: A character encoder that takes Unicode characters and writes them into bytes.

 * <i>htmlFallback</i>: If true, when the encoder encounters invalid characters that can't be mapped into bytes, writes the HTML decimal escape for the invalid characters instead. If false, writes a question mark byte (0x3f) upon encountering invalid characters.

<b>Return Value:</b>

A byte array containing the encoded characters.

<b>Exceptions:</b>

 *  T:System.ArgumentNullException:
The parameter <i> encoder</i>
or <i> input</i>
is null.

 * System.ArgumentNullException:
The parameter <i>encoder</i>
or <i>input</i>
is null.

<a id="EncodeToBytes_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoding"></a>
### EncodeToBytes

    public static byte[] EncodeToBytes(
        this PeterO.Text.ICharacterInput input,
        PeterO.Text.ICharacterEncoding encoding);

Reads Unicode characters from a character input and writes them to a byte array encoded using the given character encoder. When writing to the byte array, any characters that can't be encoded are replaced with the byte 0x3f (the question mark character).In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `input.EncodeToBytes(encoding)
        ` . If the object's class already has a `EncodeToBytes
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>input</i>: An object that implements a stream of universal code points.

 * <i>encoding</i>: An object that implements a given character encoding.

<b>Return Value:</b>

A byte array containing the encoded text.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>encoding</i>
is null.

<a id="EncodeToBytes_this_string_PeterO_Text_ICharacterEncoding"></a>
### EncodeToBytes

    public static byte[] EncodeToBytes(
        this string str,
        PeterO.Text.ICharacterEncoding enc);

Reads Unicode characters from a text string and writes them to a byte array encoded in a given character encoding. When reading the string, any unpaired surrogate characters are replaced with the replacement character (U+FFFD), and when writing to the byte array, any characters that can't be encoded are replaced with the byte 0x3f (the question mark character).In the .NET implementation, this method is implemented as an extension method to any String object and can be called as follows: `str.EncodeToBytes(enc)
        ` . If the object's class already has a EncodeToBytes method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing string and can be called as follows: `str.EncodeToBytes(enc)
        ` . If the object's class already has a `EncodeToBytes
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>str</i>: A text string to encode to a byte array.

 * <i>enc</i>: An object implementing a character encoding (gives access to an encoder and a decoder).

<b>Return Value:</b>

A byte array containing the encoded text string.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>str</i>
or <i>enc</i>
is null.

<a id="EncodeToBytes_this_string_PeterO_Text_ICharacterEncoding_bool"></a>
### EncodeToBytes

    public static byte[] EncodeToBytes(
        this string str,
        PeterO.Text.ICharacterEncoding enc,
        bool htmlFallback);

Reads Unicode characters from a text string and writes them to a byte array encoded in a given character encoding and using the given encoder fallback strategy. When reading the string, any unpaired surrogate characters are replaced with the replacement character (U+FFFD).In the .NET implementation, this method is implemented as an extension method to any object implementing string and can be called as follows: `str.EncodeToBytes(enc, htmlFallback)
        ` . If the object's class already has a `EncodeToBytes
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>str</i>: A text string to encode to a byte array.

 * <i>enc</i>: An object implementing a character encoding (gives access to an encoder and a decoder).

 * <i>htmlFallback</i>: If true, when the encoder encounters invalid characters that can't be mapped into bytes, writes the HTML decimal escape for the invalid characters instead. If false, writes a question mark byte (0x3f) upon encountering invalid characters.

<b>Return Value:</b>

A byte array containing the encoded text string.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>str</i>
or <i>enc</i>
is null.

<a id="EncodeToWriter_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoder_PeterO_IWriter"></a>
### EncodeToWriter

    public static void EncodeToWriter(
        this PeterO.Text.ICharacterInput input,
        PeterO.Text.ICharacterEncoder encoder,
        PeterO.IWriter writer);

Reads Unicode characters from a character input and writes them to a byte array encoded in a given character encoding. When writing to the byte array, any characters that can't be encoded are replaced with the byte 0x3f (the question mark character).In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `input.EncodeToBytes(encoder)
        ` . If the object's class already has a EncodeToBytes method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `input.EncodeToWriter(encoder, writer)
        ` . If the object's class already has a `EncodeToWriter
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>input</i>: An object that implements a stream of universal code points.

 * <i>encoder</i>: An object that implements a character encoder.

 * <i>writer</i>: A byte writer to write the encoded bytes to.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>encoder</i>
or <i>input</i>
is null.

<a id="EncodeToWriter_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoder_System_IO_Stream"></a>
### EncodeToWriter

    public static void EncodeToWriter(
        this PeterO.Text.ICharacterInput input,
        PeterO.Text.ICharacterEncoder encoder,
        System.IO.Stream output);

Reads Unicode characters from a character input and writes them to a byte array encoded in a given character encoding. When writing to the byte array, any characters that can't be encoded are replaced with the byte 0x3f (the question mark character).In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `input.EncodeToBytes(encoder)
        ` . If the object's class already has a EncodeToBytes method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `input.EncodeToWriter(encoder, output)
        ` . If the object's class already has a `EncodeToWriter
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>input</i>: An object that implements a stream of universal code points.

 * <i>encoder</i>: An object that implements a character encoder.

 * <i>output</i>: A writable data stream.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>encoder</i>
or <i>input</i>
is null.

<a id="EncodeToWriter_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoding_PeterO_IWriter"></a>
### EncodeToWriter

    public static void EncodeToWriter(
        this PeterO.Text.ICharacterInput input,
        PeterO.Text.ICharacterEncoding encoding,
        PeterO.IWriter writer);

Reads Unicode characters from a character input and writes them to a byte array encoded using the given character encoder. When writing to the byte array, any characters that can't be encoded are replaced with the byte 0x3f (the question mark character).In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `input.EncodeToBytes(encoding)
        ` . If the object's class already has a EncodeToBytes method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `input.EncodeToWriter(encoding, writer)
        ` . If the object's class already has a `EncodeToWriter
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>input</i>: An object that implements a stream of universal code points.

 * <i>encoding</i>: An object that implements a character encoding.

 * <i>writer</i>: A byte writer to write the encoded bytes to.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>encoding</i>
is null.

<a id="EncodeToWriter_this_PeterO_Text_ICharacterInput_PeterO_Text_ICharacterEncoding_System_IO_Stream"></a>
### EncodeToWriter

    public static void EncodeToWriter(
        this PeterO.Text.ICharacterInput input,
        PeterO.Text.ICharacterEncoding encoding,
        System.IO.Stream output);

Reads Unicode characters from a character input and writes them to a byte array encoded using the given character encoder. When writing to the byte array, any characters that can't be encoded are replaced with the byte 0x3f (the question mark character).In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `input.EncodeToBytes(encoding)
        ` . If the object's class already has a EncodeToBytes method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `input.EncodeToWriter(encoding, output)
        ` . If the object's class already has a `EncodeToWriter
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>input</i>: An object that implements a stream of universal code points.

 * <i>encoding</i>: An object that implements a character encoding.

 * <i>output</i>: A writable data stream.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>encoding</i>
is null.

<a id="EncodeToWriter_this_string_PeterO_Text_ICharacterEncoding_PeterO_IWriter"></a>
### EncodeToWriter

    public static void EncodeToWriter(
        this string str,
        PeterO.Text.ICharacterEncoding enc,
        PeterO.IWriter writer);

Converts a text string to bytes and writes the bytes to an output byte writer. When reading the string, any unpaired surrogate characters are replaced with the replacement character (U+FFFD), and when writing to the byte stream, any characters that can't be encoded are replaced with the byte 0x3f (the question mark character).In the .NET implementation, this method is implemented as an extension method to any String object and can be called as follows: `str.EncodeToBytes(enc, writer)
        ` . If the object's class already has a EncodeToBytes method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing string and can be called as follows: `str.EncodeToWriter(enc, writer)
        ` . If the object's class already has a `EncodeToWriter
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>str</i>: A text string to encode.

 * <i>enc</i>: An object implementing a character encoding (gives access to an encoder and a decoder).

 * <i>writer</i>: A byte writer where the encoded bytes will be written to.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>str</i>
or <i>enc</i>
is null.

<a id="EncodeToWriter_this_string_PeterO_Text_ICharacterEncoding_System_IO_Stream"></a>
### EncodeToWriter

    public static void EncodeToWriter(
        this string str,
        PeterO.Text.ICharacterEncoding enc,
        System.IO.Stream output);

Converts a text string to bytes and writes the bytes to an output data stream. When reading the string, any unpaired surrogate characters are replaced with the replacement character (U+FFFD), and when writing to the byte stream, any characters that can't be encoded are replaced with the byte 0x3f (the question mark character).In the .NET implementation, this method is implemented as an extension method to any String object and can be called as follows: `str.EncodeToBytes(enc, writer)
        ` . If the object's class already has a EncodeToBytes method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing string and can be called as follows: `str.EncodeToWriter(enc, output)
        ` . If the object's class already has a `EncodeToWriter
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>str</i>: A text string to encode.

 * <i>enc</i>: An object implementing a character encoding (gives access to an encoder and a decoder).

 * <i>output</i>: A writable data stream.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>str</i>
or <i>enc</i>
is null.

<a id="GetDecoderInput_this_PeterO_Text_ICharacterEncoding_PeterO_IByteReader"></a>
### GetDecoderInput

    public static PeterO.Text.ICharacterInput GetDecoderInput(
        this PeterO.Text.ICharacterEncoding encoding,
        PeterO.IByteReader stream);

Converts a character encoding into a character input stream, given a streamable source of bytes. The input stream doesn't check the first few bytes for a byte-order mark indicating a Unicode encoding such as UTF-8 before using the character encoding's decoder.In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: "encoding.GetDecoderInput(input)". If the object's class already has a GetDecoderInput method with the same parameters, that method takes precedence over this extension method.

<b>Parameters:</b>

 * <i>encoding</i>: Encoding that exposes a decoder to be converted into a character input stream. If the decoder returns -2 (indicating a decode error), the character input stream handles the error by returning a replacement character in its place.

 * <i>stream</i>: Byte stream to convert into Unicode characters.

<b>Return Value:</b>

An ICharacterInput object.

<a id="GetDecoderInput_this_PeterO_Text_ICharacterEncoding_System_IO_Stream"></a>
### GetDecoderInput

    public static PeterO.Text.ICharacterInput GetDecoderInput(
        this PeterO.Text.ICharacterEncoding encoding,
        System.IO.Stream input);

Converts a character encoding into a character input stream, given a data stream. The input stream doesn't check the first few bytes for a byte-order mark indicating a Unicode encoding such as UTF-8 before using the character encoding's decoder.In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: `encoding.GetDecoderInput(input)
        ` . If the object's class already has a GetDecoderInput method with the same parameters, that method takes precedence over this extension method.

In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: `encoding.GetDecoderInput(input)
        ` . If the object's class already has a `GetDecoderInput
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>encoding</i>: Encoding object that exposes a decoder to be converted into a character input stream. If the decoder returns -2 (indicating a decode error), the character input stream handles the error by returning a replacement character in its place.

 * <i>input</i>: Byte stream to convert into Unicode characters.

<b>Return Value:</b>

An ICharacterInput object.

<a id="GetDecoderInputSkipBom_this_PeterO_Text_ICharacterEncoding_PeterO_IByteReader"></a>
### GetDecoderInputSkipBom

    public static PeterO.Text.ICharacterInput GetDecoderInputSkipBom(
        this PeterO.Text.ICharacterEncoding encoding,
        PeterO.IByteReader stream);

Converts a character encoding into a character input stream, given a streamable source of bytes. But if the input stream starts with a UTF-8 or UTF-16 byte order mark, the input is decoded as UTF-8 or UTF-16, as the case may be, rather than the given character encoding.This method implements the "decode" algorithm specified in the Encoding standard.

In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: `encoding.GetDecoderInputSkipBom(input)
        ` . If the object's class already has a `GetDecoderInputSkipBom
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>encoding</i>: Encoding object that exposes a decoder to be converted into a character input stream. If the decoder returns -2 (indicating a decode error), the character input stream handles the error by returning a replacement character in its place.

 * <i>stream</i>: Byte stream to convert into Unicode characters.

<b>Return Value:</b>

An ICharacterInput object.

<a id="GetDecoderInputSkipBom_this_PeterO_Text_ICharacterEncoding_System_IO_Stream"></a>
### GetDecoderInputSkipBom

    public static PeterO.Text.ICharacterInput GetDecoderInputSkipBom(
        this PeterO.Text.ICharacterEncoding encoding,
        System.IO.Stream input);

Converts a character encoding into a character input stream, given a readable data stream. But if the input stream starts with a UTF-8 or UTF-16 byte order mark, the input is decoded as UTF-8 or UTF-16, as the case may be, rather than the given character encoding.This method implements the "decode" algorithm specified in the Encoding standard.In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: `encoding.GetDecoderInputSkipBom(input)
        ` . If the object's class already has a `GetDecoderInputSkipBom
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>encoding</i>: Encoding object that exposes a decoder to be converted into a character input stream. If the decoder returns -2 (indicating a decode error), the character input stream handles the error by returning a replacement character in its place.

 * <i>input</i>: Byte stream to convert into Unicode characters.

<b>Return Value:</b>

An ICharacterInput object.

<a id="GetEncoding_string"></a>
### GetEncoding

    public static PeterO.Text.ICharacterEncoding GetEncoding(
        string name);

Returns a character encoding from the given name.

<b>Parameters:</b>

 * <i>name</i>: A string naming a character encoding. See the ResolveAlias method. Can be null.

<b>Return Value:</b>

An object implementing a character encoding (gives access to an encoder and a decoder).

<a id="GetEncoding_string_bool"></a>
### GetEncoding

    public static PeterO.Text.ICharacterEncoding GetEncoding(
        string name,
        bool forEmail);

Returns a character encoding from the given name.

<b>Parameters:</b>

 * <i>name</i>: A string naming a character encoding. See the ResolveAlias method. Can be null.

 * <i>forEmail</i>: If false, uses the encoding resolution rules in the Encoding Standard. If true, uses modified rules as described in the ResolveAliasForEmail method.

<b>Return Value:</b>

An object that enables encoding and decoding text in the given character encoding. Returns null if the name is null or empty, or if it names an unrecognized or unsupported encoding.

<a id="GetEncoding_string_bool_bool"></a>
### GetEncoding

    public static PeterO.Text.ICharacterEncoding GetEncoding(
        string name,
        bool forEmail,
        bool allowReplacement);

Returns a character encoding from the given name.

<b>Parameters:</b>

 * <i>name</i>: A string naming a character encoding. See the ResolveAlias method. Can be null.

 * <i>forEmail</i>: If false, uses the encoding resolution rules in the Encoding Standard. If true, uses modified rules as described in the ResolveAliasForEmail method.

 * <i>allowReplacement</i>: Has no effect.

<b>Return Value:</b>

An object that enables encoding and decoding text in the given character encoding. Returns null if the name is null or empty, or if it names an unrecognized or unsupported encoding.

<a id="InputToString_this_PeterO_Text_ICharacterInput"></a>
### InputToString

    public static string InputToString(
        this PeterO.Text.ICharacterInput reader);

Reads Unicode characters from a character input and converts them to a text string.In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `reader.InputToString()
        ` . If the object's class already has a InputToString method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterInput and can be called as follows: `reader.InputToString()
        ` . If the object's class already has a `InputToString
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>reader</i>: A character input whose characters will be converted to a text string.

<b>Return Value:</b>

A text string containing the characters read.

<a id="ResolveAlias_string"></a>
### ResolveAlias

    public static string ResolveAlias(
        string name);

Resolves a character encoding's name to a standard form. This involves changing aliases of a character encoding to a standardized name.In several Internet specifications, this name is known as a "charset" parameter. In HTML and HTTP, for example, the "charset" parameter indicates the encoding used to represent text in the HTML page, text file, etc.

<b>Parameters:</b>

 * <i>name</i>: A string that names a given character encoding. Can be null. Any leading and trailing whitespace is removed and the name converted to lowercase before resolving the encoding's name. The Encoding Standard supports only the following encodings (and defines aliases for most of them).

 *  `UTF-8
          ` - UTF-8 (8-bit encoding of the universal coded character set, the ncoding recommended by the Encoding Standard for new data formats)

 *  `UTF-16LE
          ` - UTF-16 little-endian (16-bit UCS)

 *  `UTF-16BE
          ` - UTF-16 big-endian (16-bit UCS)

 * The special-purpose encoding `x-user-defined
          `

 * The special-purpose encoding `replacement
          ` .

 * 28 legacy single-byte encodings:

 *  `windows-1252
              ` : Western Europe (Note: The Encoding Standard aliases the names `US-ASCII
              ` and `ISO-8859-1
              ` to `windows-1252
              ` , which uses a different coded character set from either; it iffers from `ISO-8859-1
              ` by assigning different characters to some bytes from 0x80 to x9F. The Encoding Standard does this for compatibility with xisting Web pages.)

 *  `ISO-8859-2
              ` , `windows-1250
              ` : Central Europe

 *  `ISO-8859-10
              ` : Northern Europe

 *  `ISO-8859-4
              ` , `windows-1257
              ` : Baltic

 *  `ISO-8859-13
              ` : Estonian

 *  `ISO-8859-14
              ` : Celtic

 *  `ISO-8859-16
              ` : Romanian

 *  `ISO-8859-5
              ` , `IBM-866
              ` , `KOI8-R
              ` , `windows-1251
              ` , `x-mac-cyrillic
              ` : Cyrillic

 *  `KOI8-U
              ` : Ukrainian

 *  `ISO-8859-7
              ` , `windows-1253
              ` : Greek

 *  `ISO-8859-6
              ` , `windows-1256
              ` : Arabic

 *  `ISO-8859-8
              ` , `ISO-8859-8-I
              ` , `windows-1255
              ` : Hebrew

 *  `ISO-8859-3
              ` : Latin 3

 *  `ISO-8859-15
              ` , `windows-1254
              ` : Turkish

 *  `windows-874
              ` : Thai

 *  `windows-1258
              ` : Vietnamese

 *  `macintosh
              ` : Mac Roman

 * Three legacy Japanese encodings: `Shift_JIS
          ` , `EUC-JP
          ` , `ISO-2022-JP
          `

 * Two legacy simplified Chinese encodings: `GBK
          ` and `gb18030
          `

 *  `Big5
          ` : legacy traditional Chinese encoding

 *  `EUC-KR
          ` : legacy Korean encoding

The `UTF-8
        ` , `UTF-16LE
        ` , and `UTF-16BE
        ` encodings don't encode a byte-order mark at the start of the text doing so is not recommended for `UTF-8
        ` , while in `UTF-16LE
        ` and `UTF-16BE
        ` , the byte-order mark character U+FEFF is treated as an ordinary haracter, unlike in the UTF-16 encoding form). The Encoding Standard liases `UTF-16
        ` to `UTF-16LE
        ` "to deal with deployed content".

.

<b>Return Value:</b>

A standardized name for the encoding. Returns the empty string if <i>name</i>
is null or empty, or if the encoding name is unsupported.

<a id="ResolveAliasForEmail_string"></a>
### ResolveAliasForEmail

    public static string ResolveAliasForEmail(
        string name);

Resolves a character encoding's name to a canonical form, using rules more suitable for email.

<b>Parameters:</b>

 * <i>name</i>: A string naming a character encoding. Can be null. Uses a modified version of the rules in the Encoding Standard to better conform, in some cases, to email standards like MIME. Encoding names and aliases not registered with the Internet Assigned Numbers Authority (IANA) are not supported, with the exception of `ascii
      ` , `utf8
      ` , `cp1252
      ` , and names 10 characters or longer starting with `iso-8859-
      ` . Also, the following additional encodings are supported. Note that the ase combination `GB18030
      ` , the combination registered with IANA, rather than `gb18030
      ` can be retured by this method.

 *  `US-ASCII
          ` - ASCII single-byte encoding, rather than an alias to `windows-1252
          ` as specified in the Encoding Standard. The coded character set's code oints match those in the Unicode Standard's Basic Latin block (0-127 r U+0000 to U+007F). The name `ascii
          ` is an alias.

 *  `ISO-8859-1
          ` - Latin-1 single-byte encoding, rather than an alias to `windows-1252
          ` as specified in the Encoding Standard. The coded character set's code oints match those in the Unicode Standard's Basic Latin and Latin-1 upplement blocks (0-255 or U+0000 to U+00FF).

 *  `UTF-16
          ` - UTF-16 without a fixed byte order, rather than an alias to `UTF-16LE
          ` as specified in the Encoding Standard. The byte order is little ndian if the byte stream starts with 0xff 0xfe; otherwise, big ndian. A leading 0xff 0xfe or 0xFE 0xff in the byte stream is kipped.

 *  `UTF-7
          ` - UTF-7 (7-bit universal coded character set). The name `unicode-1-1-utf-7
          ` is not supported and is not treated as an alias to `UTF-7
          ` , even though it uses the same character encoding scheme as UTF-7, ecause RFC 1642, which defined the former UTF-7, is linked to a ifferent Unicode version with an incompatible character repertoire notably, the Hangul syllables have different code point assignments n Unicode 1.1 and earlier than in Unicode 2.0 and later).

 *  `ISO-2022-JP-2
          ` - similar to "ISO-2022-JP", except that the decoder supports dditional character sets.

.

<b>Return Value:</b>

A standardized name for the encoding. Returns the empty string if <i>name</i>
is null or empty, or if the encoding name is unsupported.

<a id="StringToBytes_this_PeterO_Text_ICharacterEncoder_string"></a>
### StringToBytes

    public static byte[] StringToBytes(
        this PeterO.Text.ICharacterEncoder encoder,
        string str);

Converts a text string to a byte array using the given character encoder. When reading the string, any unpaired surrogate characters are replaced with the replacement character (U+FFFD), and when writing to the byte array, any characters that can't be encoded are replaced with the byte 0x3f (the question mark character).In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoder and can be called as follows: `encoder.StringToBytes(str)
        ` . If the object's class already has a StringToBytes method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoder and can be called as follows: `encoder.StringToBytes(str)
        ` . If the object's class already has a `StringToBytes
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>encoder</i>: An object that implements a character encoder.

 * <i>str</i>: A text string to encode into a byte array.

<b>Return Value:</b>

A byte array.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>encoder</i>
or <i>str</i>
is null.

<a id="StringToBytes_this_PeterO_Text_ICharacterEncoding_string"></a>
### StringToBytes

    public static byte[] StringToBytes(
        this PeterO.Text.ICharacterEncoding encoding,
        string str);

Converts a text string to a byte array encoded in a given character encoding. When reading the string, any unpaired surrogate characters are replaced with the replacement character (U+FFFD), and when writing to the byte array, any characters that can't be encoded are replaced with the byte 0x3f (the question mark character).In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: `encoding.StringToBytes(str)
        ` . If the object's class already has a StringToBytes method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing ICharacterEncoding and can be called as follows: `encoding.StringToBytes(str)
        ` . If the object's class already has a `StringToBytes
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>encoding</i>: An object that implements a character encoding.

 * <i>str</i>: A string to be encoded into a byte array.

<b>Return Value:</b>

A byte array containing the string encoded in the given text encoding.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>encoding</i>
is null.

<a id="StringToInput_this_string"></a>
### StringToInput

    public static PeterO.Text.ICharacterInput StringToInput(
        this string str);

Converts a text string to a character input. The resulting input can then be used to encode the text to bytes, or to read the string code point by code point, among other things. When reading the string, any unpaired surrogate characters are replaced with the replacement character (U+FFFD).In the .NET implementation, this method is implemented as an extension method to any String object and can be called as follows: `str.StringToInput(offset, length)
        ` . If the object's class already has a StringToInput method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing string and can be called as follows: `str.StringToInput()
        ` . If the object's class already has a `StringToInput
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>str</i>: The parameter <i>str</i>
is a text string.

<b>Return Value:</b>

An ICharacterInput object.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter <i>str</i>
is null.

<a id="StringToInput_this_string_int_int"></a>
### StringToInput

    public static PeterO.Text.ICharacterInput StringToInput(
        this string str,
        int offset,
        int length);

Converts a portion of a text string to a character input. The resulting input can then be used to encode the text to bytes, or to read the string code point by code point, among other things. When reading the string, any unpaired surrogate characters are replaced with the replacement character (U+FFFD).In the .NET implementation, this method is implemented as an extension method to any String object and can be called as follows: `str.StringToInput(offset, length)
        ` . If the object's class already has a StringToInput method with the ame parameters, that method takes precedence over this extension ethod.

In the .NET implementation, this method is implemented as an extension method to any object implementing string and can be called as follows: `str.StringToInput(offset, length)
        ` . If the object's class already has a `StringToInput
        ` method with the same parameters, that method takes precedence over this xtension method.

<b>Parameters:</b>

 * <i>str</i>: The parameter <i>str</i>
is a text string.

 * <i>offset</i>: A zero-based index showing where the desired portion of <i>str</i>
begins.

 * <i>length</i>: The length, in code units, of the desired portion of <i>str</i>
(but not more than <i>str</i>
's length).

<b>Return Value:</b>

An ICharacterInput object.

<b>Exceptions:</b>

 *  T:System.ArgumentNullException:
The parameter <i>str</i>
is null.

 * System.ArgumentException:
Either <i>offset</i>
or <i>length</i>
is less than 0 or greater than <i>str</i>
's length, or <i>             str</i>
' s length minus <i>offset</i>
is less than <i>length</i>
.

 * System.ArgumentNullException:
The parameter <i>str</i>
is null.
