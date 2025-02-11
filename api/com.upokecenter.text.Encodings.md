# com.upokecenter.text.Encodings

    public final class Encodings extends Object

<p>Contains methods for converting text from one character encoding to
 another. This class also contains convenience methods for converting strings
 and other character inputs to sequences of bytes and vice versa. </p><p>The
 WHATWG Encoding Standard defines algorithms for the most common character
 encodings used on Web pages and recommends the UTF-8 encoding for new
 specifications and Web pages. Calling the <code>GetEncoding(name)</code> method
 returns one of the character encodings with the specified name under the
 Encoding Standard.</p> <p>Now let's define some terms.</p> <p><b>Encoding
 Terms</b></p> <ul> <li>A <b>code point</b> is a number that identifies a
 single text character, such as a letter, digit, or symbol. (A collection of
 such characters is also called an <i>abstract character
 repertoire</i>.)</li><li>A <b>coded character set</b> is a set of code
 points which are each assigned to a single text character. As used here,
 coded character sets don't define how code points are laid out in
 memory.</li><li>A <b>character encoding</b> is a mapping from a sequence of
 code points, in one or more specific coded character sets, to a sequence of
 bytes and vice versa. (For brevity, the rest of this documentation may use
 the term <i>encoding</i> instead. RFC 6365 uses the analogous term
 <i>charset</i> instead; in this documentation, however, <i>charset</i> is
 used only to refer to the names that identify a character
 encoding.)</li><li><b>ASCII</b> is a 128-code-point coded character set that
 includes the English letters and digits, common punctuation and symbols, and
 control characters. As used here, its code points match the code points
 within the Basic Latin block (0-127 or U+0000 to U+007F) of the Unicode
 Standard.</li></ul> <p>There are several kinds of character encodings:</p>
 <ul> <li><b>Single-byte encodings</b> define a coded character set that
 assigns one code point to one byte. Thus, they can have a maximum of 256
 code points. For example:</li><li>(a) ISO 8859 encodings and <code>
 windows-1252</code>.</li><li>(b) ASCII is usually used as a single-byte encoding
 where each code point fits in the lower 7 bits of an eight-bit byte (in that
 case, the encoding is often called <code>US-ASCII</code>). In the Encoding
 Standard, all single-byte encodings use the ASCII characters as the first
 128 code points of their coded character sets.</li><li><b>Multi-byte
 encodings</b> include code points from one or more coded character sets and
 assign some or all code points to several bytes. For example:</li><li>(a)
 <code>UTF-16LE</code> and <code>UTF-16BE</code> are two encodings defined in the
 Unicode Standard. They use 2 bytes for the most common code points, and 4
 bytes for supplementary code points.</li><li>(b) <code>UTF-8</code> is another
 encoding defined in the Unicode Standard. It uses 1 byte for ASCII and 2 to
 4 bytes for the other Unicode code points.</li><li>(c) Most legacy East
 Asian encodings, such as <code>Shift_JIS</code>, <code>GBK</code>, and <code>Big5</code>
 use 1 byte for ASCII (or a slightly modified version) and, usually, 2 or
 more bytes for national standard coded character sets. In many of these
 encodings, notably <code>Shift_JIS</code>, characters whose code points use one
 byte traditionally take half the space of characters whose code points use
 two bytes.</li><li><b>Escape-based encodings</b> are combinations of single-
 and/or multi-byte encodings, and use escape sequences and/or shift codes to
 change which encoding to use for the bytes that follow. For
 example:</li><li>(a) <code>ISO-2022-JP</code> supports several escape sequences
 that shift into different encodings, including a Katakana, a Kanji, and an
 ASCII encoding (with ASCII as the default).</li><li>(b) UTF-7 (not included
 in the Encoding Standard) is an encoding that uses the Unicode Standard's
 coded character set, which is encoded using a limited subset of ASCII. The
 plus symbol (U+002B) is used to shift into a UTF-16BE multi-byte encoding
 (converted to a modified version of base-64) to encode other Unicode code
 points.</li><li>The Encoding Standard also defines a <b>replacement
 encoding</b>, which causes a decoding error and is used to alias a few
 problematic or unsupported encoding names, such as <code>
 hz-gb-2312</code>.</li></ul> <p><b>Getting an Encoding</b></p> <p>The Encoding
 Standard includes UTF-8, UTF-16, and many legacy encodings, and gives each
 one of them a name. The <code>GetEncoding(name)</code> method takes a name string
 and returns an ICharacterEncoding object that implements that encoding, or
 <code>null</code> if the name is unrecognized.</p> <p>However, the Encoding
 Standard is designed to include only encodings commonly used on Web pages,
 not in other protocols such as email. For email, the Encoding class includes
 an alternate function <code>GetEncoding(name, forEmail)</code>. Setting <code>
 forEmail</code> to <code>true</code> will use rules modified from the Encoding Standard
 to better suit encoding and decoding text from email messages.</p>
 <p><b>Classes for Character Encodings</b></p> <p>This Encodings class
 provides access to common character encodings through classes as described
 below:</p> <ul> <li>An <b>encoder class</b> is a class that converts a
 sequence of bytes to a sequence of code points in the universal character
 set (otherwise known under the name Unicode). An encoder class implements
 the <code>ICharacterEncoder</code> interface.</li><li>A <b>decoder class</b> is a
 class that converts a sequence of Unicode code points to a sequence of
 bytes. A decoder class implements the <code>ICharacterDecoder</code>
 interface.</li><li>An <b>encoding class</b> allows access to both an encoder
 class and a decoder class and implements the <code>ICharacterEncoding</code>
 interface. The encoder and decoder classes should implement the same
 character encoding.</li></ul> <p><b>Custom Encodings</b></p> <p>Classes that
 implement the ICharacterEncoding interface can provide additional character
 encodings not included in the Encoding Standard. Some examples of these
 include the following:</p> <ul> <li>A modified version of UTF-8 used in
 Java's serialization formats.</li><li>A modified version of UTF-7 used in
 the IMAP email protocol.</li></ul> <p>(Note that this library doesn't
 implement either encoding.)</p>

## Fields

* `static final ICharacterEncoding UTF8`<br>
 Character encoding object for the UTF-8 character encoding, which represents
 each code point in the universal coded character set using 1 to 4 bytes.

## Methods

* `static String DecodeToString(ICharacterEncoding enc,
 byte[] bytes)`<br>
 Reads a byte array from a data source and converts the bytes from a given
 encoding to a text string.

* `static String DecodeToString(ICharacterEncoding enc,
 byte[] bytes,
 int offset,
 int length)`<br>
 Reads a portion of a byte array from a data source and converts the bytes
 from a given encoding to a text string.

* `static String DecodeToString(ICharacterEncoding encoding,
 IByteReader input)`<br>
 Reads bytes from a data source and converts the bytes from a given
 encoding to a text string.

* `static String DecodeToString(ICharacterEncoding enc,
 InputStream input)`<br>
 Decodes data read from a data stream into a text string in the specified
 character encoding.

* `static byte[] EncodeToBytes(ICharacterInput input,
 ICharacterEncoder encoder)`<br>
 Reads Unicode characters from a character input and writes them to a byte
 array encoded using a given character encoding.

* `static byte[] EncodeToBytes(ICharacterInput input,
 ICharacterEncoder encoder,
 boolean htmlFallback)`<br>
 Reads Unicode characters from a character input and writes them to a byte
 array encoded using the specified character encoder and fallback strategy.

* `static byte[] EncodeToBytes(ICharacterInput input,
 ICharacterEncoding encoding)`<br>
 Reads Unicode characters from a character input and writes them to a byte
 array encoded using the specified character encoder.

* `static byte[] EncodeToBytes(String str,
 ICharacterEncoding enc)`<br>
 Reads Unicode characters from a text string and writes them to a byte
 array encoded in a given character encoding.

* `static byte[] EncodeToBytes(String str,
 ICharacterEncoding enc,
 boolean htmlFallback)`<br>
 Reads Unicode characters from a text string and writes them to a byte
 array encoded in a given character encoding and using the specified encoder
 fallback strategy.

* `static void EncodeToWriter(ICharacterInput input,
 ICharacterEncoder encoder,
 IWriter writer)`<br>
 Reads Unicode characters from a character input and writes them to a byte
 array encoded in a given character encoding.

* `static void EncodeToWriter(ICharacterInput input,
 ICharacterEncoder encoder,
 OutputStream output)`<br>
 Reads Unicode characters from a character input and writes them to a byte
 array encoded in a given character encoding.

* `static void EncodeToWriter(ICharacterInput input,
 ICharacterEncoding encoding,
 IWriter writer)`<br>
 Reads Unicode characters from a character input and writes them to a byte
 array encoded using the specified character encoder.

* `static void EncodeToWriter(ICharacterInput input,
 ICharacterEncoding encoding,
 OutputStream output)`<br>
 Reads Unicode characters from a character input and writes them to a byte
 array encoded using the specified character encoder.

* `static void EncodeToWriter(String str,
 ICharacterEncoding enc,
 IWriter writer)`<br>
 Converts a text string to bytes and writes the bytes to an output byte
 writer.

* `static void EncodeToWriter(String str,
 ICharacterEncoding enc,
 OutputStream output)`<br>
 Converts a text string to bytes and writes the bytes to an output data
 stream.

* `static ICharacterInput GetDecoderInput(ICharacterEncoding encoding,
 IByteReader stream)`<br>
 Converts a character encoding into a character input stream, given a
 streamable source of bytes.

* `static ICharacterInput GetDecoderInput(ICharacterEncoding encoding,
 InputStream input)`<br>
 Converts a character encoding into a character input stream, given a data
 stream.

* `static ICharacterInput GetDecoderInputSkipBom(ICharacterEncoding encoding,
 IByteReader stream)`<br>
 Converts a character encoding into a character input stream, given a
 streamable source of bytes.

* `static ICharacterInput GetDecoderInputSkipBom(ICharacterEncoding encoding,
 InputStream input)`<br>
 Converts a character encoding into a character input stream, given a
 readable data stream.

* `static ICharacterEncoding GetEncoding(String name)`<br>
 Returns a character encoding from the specified name.

* `static ICharacterEncoding GetEncoding(String name,
 boolean forEmail)`<br>
 Returns a character encoding from the specified name.

* `static ICharacterEncoding GetEncoding(String name,
 boolean forEmail,
 boolean allowReplacement)`<br>
 Returns a character encoding from the specified name.

* `static String InputToString(ICharacterInput reader)`<br>
 Reads Unicode characters from a character input and converts them to a
 text string.

* `static String ResolveAlias(String name)`<br>
 Resolves a character encoding's name to a standard form.

* `static String ResolveAliasForEmail(String name)`<br>
 Resolves a character encoding's name to a canonical form, using rules more
 suitable for email.

* `static byte[] StringToBytes(ICharacterEncoder encoder,
 String str)`<br>
 Converts a text string to a byte array using the specified character
 encoder.

* `static byte[] StringToBytes(ICharacterEncoding encoding,
 String str)`<br>
 Converts a text string to a byte array encoded in a given character
 encoding.

* `static ICharacterInput StringToInput(String str)`<br>
 Converts a text string to a character input.

* `static ICharacterInput StringToInput(String str,
 int offset,
 int length)`<br>
 Converts a portion of a text string to a character input.

## Field Details

### UTF8

    public static final ICharacterEncoding UTF8

Character encoding object for the UTF-8 character encoding, which represents
 each code point in the universal coded character set using 1 to 4 bytes.

## Method Details

### DecodeToString

    public static String DecodeToString(ICharacterEncoding encoding, IByteReader input)

<p>Reads bytes from a data source and converts the bytes from a given
 encoding to a text string. </p> <p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing
 ICharacterEncoding and can be called as follows:
 "encoding.DecodeString(input)". If the object's class already has a
 DecodeToString method with the same parameters, that method takes precedence
 over this extension method.</p>

**Parameters:**

* <code>encoding</code> - An object that implements a given character encoding. Any
 bytes that can't be decoded are converted to the replacement character
 (U+FFFD).

* <code>input</code> - An object that implements a byte stream.

**Returns:**

* The converted string.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>encoding</code> or <code>
 input</code> is null.

### DecodeToString

    public static String DecodeToString(ICharacterEncoding enc, InputStream input)

<p>Decodes data read from a data stream into a text string in the specified
 character encoding. </p><p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing
 ICharacterEncoding and can be called as follows: <code>
 encoding.DecodeToString(input)</code>. If the object's class already has a
 DecodeToString method with the same parameters, that method takes precedence
 over this extension method.</p> <p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing
 ICharacterEncoding and can be called as follows: <code>
 enc.DecodeToString(input)</code>. If the object's class already has a <code>
 DecodeToString</code> method with the same parameters, that method takes
 precedence over this extension method.</p>

**Parameters:**

* <code>enc</code> - An object implementing a character encoding (gives access to an
 encoder and a decoder).

* <code>input</code> - A readable byte stream.

**Returns:**

* A string consisting of the decoded text.

**Throws:**

* <code>NullPointerException</code> - The parameter "encoding" or <code>input</code> is
 null.

### DecodeToString

    public static String DecodeToString(ICharacterEncoding enc, byte[] bytes)

<p>Reads a byte array from a data source and converts the bytes from a given
 encoding to a text string. Errors in decoding are handled by replacing
 erroneous bytes with the replacement character (U+FFFD). </p><p>In the.NET
 implementation, this method is implemented as an extension method to any
 object implementing ICharacterEncoding and can be called as follows: <code>
 enc.DecodeToString(bytes)</code>. If the object's class already has a
 DecodeToString method with the same parameters, that method takes precedence
 over this extension method.</p> <p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing
 ICharacterEncoding and can be called as follows: <code>
 enc.DecodeToString(bytes)</code>. If the object's class already has a <code>
 DecodeToString</code> method with the same parameters, that method takes
 precedence over this extension method.</p>

**Parameters:**

* <code>enc</code> - An object implementing a character encoding (gives access to an
 encoder and a decoder).

* <code>bytes</code> - A byte array.

**Returns:**

* A string consisting of the decoded text.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>enc</code> or <code>bytes</code> is
 null.

### DecodeToString

    public static String DecodeToString(ICharacterEncoding enc, byte[] bytes, int offset, int length)

<p>Reads a portion of a byte array from a data source and converts the bytes
 from a given encoding to a text string. Errors in decoding are handled by
 replacing erroneous bytes with the replacement character (U+FFFD). </p><p>In
 the.NET implementation, this method is implemented as an extension method to
 any object implementing ICharacterEncoding and can be called as follows:
 <code>enc.DecodeToString(bytes, offset, length)</code>. If the object's class
 already has a DecodeToString method with the same parameters, that method
 takes precedence over this extension method.</p> <p>In the.NET
 implementation, this method is implemented as an extension method to any
 object implementing ICharacterEncoding and can be called as follows: <code>
 enc.DecodeToString(bytes, offset, length)</code>. If the object's class already
 has a <code>DecodeToString</code> method with the same parameters, that method
 takes precedence over this extension method.</p>

**Parameters:**

* <code>enc</code> - An object implementing a character encoding (gives access to an
 encoder and a decoder).

* <code>bytes</code> - A byte array containing the desired portion to read.

* <code>offset</code> - An index starting at 0 showing where the desired portion of
 <code>bytes</code> begins.

* <code>length</code> - The length, in bytes, of the desired portion of <code>bytes</code>
 (but not more than <code>bytes</code> 's length).

**Returns:**

* A string consisting of the decoded text.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>enc</code> or <code>
 bytes</code> is null.

* <code>IllegalArgumentException</code> - Either <code>offset</code> or <code>length</code> is less
 than 0 or greater than <code>bytes</code> 's length, or <code>bytes</code> 's length
 minus <code>offset</code> is less than <code>length</code>.

* <code>NullPointerException</code> - The parameter <code>enc</code> or <code>bytes</code> is
 null.

### EncodeToBytes

    public static byte[] EncodeToBytes(ICharacterInput input, ICharacterEncoding encoding)

<p>Reads Unicode characters from a character input and writes them to a byte
 array encoded using the specified character encoder. When writing to the
 byte array, any characters that can't be encoded are replaced with the byte
 0x3f (the question mark character). </p> <p>In the.NET implementation, this
 method is implemented as an extension method to any object implementing
 ICharacterInput and can be called as follows: <code>
 input.EncodeToBytes(encoding)</code>. If the object's class already has a <code>
 EncodeToBytes</code> method with the same parameters, that method takes precedence
 over this extension method.</p>

**Parameters:**

* <code>input</code> - An object that implements a stream of universal code points.

* <code>encoding</code> - An object that implements a given character encoding.

**Returns:**

* A byte array containing the encoded text.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>encoding</code> is null.

### EncodeToBytes

    public static byte[] EncodeToBytes(ICharacterInput input, ICharacterEncoder encoder)

<p>Reads Unicode characters from a character input and writes them to a byte
 array encoded using a given character encoding. When writing to the byte
 array, any characters that can't be encoded are replaced with the byte 0x3f
 (the question mark character). </p><p>In the.NET implementation, this method
 is implemented as an extension method to any object implementing
 ICharacterInput and can be called as follows: <code>
 input.EncodeToBytes(encoder)</code>. If the object's class already has a
 EncodeToBytes method with the same parameters, that method takes precedence
 over this extension method.</p> <p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing
 ICharacterInput and can be called as follows: <code>
 input.EncodeToBytes(encoder)</code>. If the object's class already has a <code>
 EncodeToBytes</code> method with the same parameters, that method takes precedence
 over this extension method.</p>

**Parameters:**

* <code>input</code> - An object that implements a stream of universal code points.

* <code>encoder</code> - An object that implements a character encoder.

**Returns:**

* A byte array.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>encoder</code> or <code>input</code>
 is null.

### EncodeToBytes

    public static byte[] EncodeToBytes(ICharacterInput input, ICharacterEncoder encoder, boolean htmlFallback)

<p>Reads Unicode characters from a character input and writes them to a byte
 array encoded using the specified character encoder and fallback strategy.
 </p> <p>In the.NET implementation, this method is implemented as an
 extension method to any object implementing ICharacterInput and can be
 called as follows: <code>input.EncodeToBytes(encoder, htmlFallback)</code>. If
 the object's class already has a <code>EncodeToBytes</code> method with the same
 parameters, that method takes precedence over this extension method.</p>

**Parameters:**

* <code>input</code> - An object that implements a stream of universal code points.

* <code>encoder</code> - A character encoder that takes Unicode characters and writes
 them into bytes.

* <code>htmlFallback</code> - If true, when the encoder encounters invalid characters
 that can't be mapped into bytes, writes the HTML decimal escape for the
 invalid characters instead. If false, writes a question mark byte (0x3f)
 upon encountering invalid characters.

**Returns:**

* A byte array containing the encoded characters.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>encoder</code> or <code>
 input</code> is null.

* <code>NullPointerException</code> - The parameter <code>encoder</code> or <code>input</code>
 is null.

### EncodeToBytes

    public static byte[] EncodeToBytes(String str, ICharacterEncoding enc)

<p>Reads Unicode characters from a text string and writes them to a byte
 array encoded in a given character encoding. When reading the string, any
 unpaired surrogate characters are replaced with the replacement character
 (U+FFFD), and when writing to the byte array, any characters that can't be
 encoded are replaced with the byte 0x3f (the question mark character).
 </p><p>In the.NET implementation, this method is implemented as an extension
 method to any string object and can be called as follows: <code>
 str.EncodeToBytes(enc)</code>. If the object's class already has a EncodeToBytes
 method with the same parameters, that method takes precedence over this
 extension method.</p> <p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing string and can
 be called as follows: <code>str.EncodeToBytes(enc)</code>. If the object's class
 already has a <code>EncodeToBytes</code> method with the same parameters, that
 method takes precedence over this extension method.</p>

**Parameters:**

* <code>str</code> - A text string to encode to a byte array.

* <code>enc</code> - An object implementing a character encoding (gives access to an
 encoder and a decoder).

**Returns:**

* A byte array containing the encoded text string.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>str</code> or <code>enc</code> is
 null.

### EncodeToBytes

    public static byte[] EncodeToBytes(String str, ICharacterEncoding enc, boolean htmlFallback)

<p>Reads Unicode characters from a text string and writes them to a byte
 array encoded in a given character encoding and using the specified encoder
 fallback strategy. When reading the string, any unpaired surrogate
 characters are replaced with the replacement character (U+FFFD). </p> <p>In
 the.NET implementation, this method is implemented as an extension method to
 any object implementing string and can be called as follows: <code>
 str.EncodeToBytes(enc, htmlFallback)</code>. If the object's class already has a
 <code>EncodeToBytes</code> method with the same parameters, that method takes
 precedence over this extension method.</p>

**Parameters:**

* <code>str</code> - A text string to encode to a byte array.

* <code>enc</code> - An object implementing a character encoding (gives access to an
 encoder and a decoder).

* <code>htmlFallback</code> - If true, when the encoder encounters invalid characters
 that can't be mapped into bytes, writes the HTML decimal escape for the
 invalid characters instead. If false, writes a question mark byte (0x3f)
 upon encountering invalid characters.

**Returns:**

* A byte array containing the encoded text string.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>str</code> or <code>enc</code> is
 null.

### EncodeToWriter

    public static void EncodeToWriter(ICharacterInput input, ICharacterEncoding encoding, IWriter writer)

<p>Reads Unicode characters from a character input and writes them to a byte
 array encoded using the specified character encoder. When writing to the
 byte array, any characters that can't be encoded are replaced with the byte
 0x3f (the question mark character). </p><p>In the.NET implementation, this
 method is implemented as an extension method to any object implementing
 ICharacterInput and can be called as follows: <code>
 input.EncodeToBytes(encoding)</code>. If the object's class already has a
 EncodeToBytes method with the same parameters, that method takes precedence
 over this extension method.</p> <p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing
 ICharacterInput and can be called as follows: <code>
 input.EncodeToWriter(encoding, writer)</code>. If the object's class already has a
 <code>EncodeToWriter</code> method with the same parameters, that method takes
 precedence over this extension method.</p>

**Parameters:**

* <code>input</code> - An object that implements a stream of universal code points.

* <code>encoding</code> - An object that implements a character encoding.

* <code>writer</code> - A byte writer to write the encoded bytes to.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>encoding</code> is null.

### EncodeToWriter

    public static void EncodeToWriter(ICharacterInput input, ICharacterEncoder encoder, IWriter writer)

<p>Reads Unicode characters from a character input and writes them to a byte
 array encoded in a given character encoding. When writing to the byte array,
 any characters that can't be encoded are replaced with the byte 0x3f (the
 question mark character). </p><p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing
 ICharacterInput and can be called as follows: <code>
 input.EncodeToBytes(encoder)</code>. If the object's class already has a
 EncodeToBytes method with the same parameters, that method takes precedence
 over this extension method.</p> <p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing
 ICharacterInput and can be called as follows: <code>
 input.EncodeToWriter(encoder, writer)</code>. If the object's class already has a
 <code>EncodeToWriter</code> method with the same parameters, that method takes
 precedence over this extension method.</p>

**Parameters:**

* <code>input</code> - An object that implements a stream of universal code points.

* <code>encoder</code> - An object that implements a character encoder.

* <code>writer</code> - A byte writer to write the encoded bytes to.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>encoder</code> or <code>input</code>
 is null.

### EncodeToWriter

    public static void EncodeToWriter(String str, ICharacterEncoding enc, IWriter writer)

<p>Converts a text string to bytes and writes the bytes to an output byte
 writer. When reading the string, any unpaired surrogate characters are
 replaced with the replacement character (U+FFFD), and when writing to the
 byte stream, any characters that can't be encoded are replaced with the byte
 0x3f (the question mark character). </p><p>In the.NET implementation, this
 method is implemented as an extension method to any string object and can be
 called as follows: <code>str.EncodeToBytes(enc, writer)</code>. If the object's
 class already has a EncodeToBytes method with the same parameters, that
 method takes precedence over this extension method.</p> <p>In the.NET
 implementation, this method is implemented as an extension method to any
 object implementing string and can be called as follows: <code>
 str.EncodeToWriter(enc, writer)</code>. If the object's class already has a <code>
 EncodeToWriter</code> method with the same parameters, that method takes
 precedence over this extension method.</p>

**Parameters:**

* <code>str</code> - A text string to encode.

* <code>enc</code> - An object implementing a character encoding (gives access to an
 encoder and a decoder).

* <code>writer</code> - A byte writer where the encoded bytes will be written to.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>str</code> or <code>enc</code> is
 null.

### EncodeToWriter

    public static void EncodeToWriter(ICharacterInput input, ICharacterEncoding encoding, OutputStream output) throws IOException

<p>Reads Unicode characters from a character input and writes them to a byte
 array encoded using the specified character encoder. When writing to the
 byte array, any characters that can't be encoded are replaced with the byte
 0x3f (the question mark character). </p><p>In the.NET implementation, this
 method is implemented as an extension method to any object implementing
 ICharacterInput and can be called as follows: <code>
 input.EncodeToBytes(encoding)</code>. If the object's class already has a
 EncodeToBytes method with the same parameters, that method takes precedence
 over this extension method.</p> <p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing
 ICharacterInput and can be called as follows: <code>
 input.EncodeToWriter(encoding, output)</code>. If the object's class already has a
 <code>EncodeToWriter</code> method with the same parameters, that method takes
 precedence over this extension method.</p>

**Parameters:**

* <code>input</code> - An object that implements a stream of universal code points.

* <code>encoding</code> - An object that implements a character encoding.

* <code>output</code> - A writable data stream.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>encoding</code> is null.

* <code>IOException</code>

### EncodeToWriter

    public static void EncodeToWriter(ICharacterInput input, ICharacterEncoder encoder, OutputStream output) throws IOException

<p>Reads Unicode characters from a character input and writes them to a byte
 array encoded in a given character encoding. When writing to the byte array,
 any characters that can't be encoded are replaced with the byte 0x3f (the
 question mark character). </p><p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing
 ICharacterInput and can be called as follows: <code>
 input.EncodeToBytes(encoder)</code>. If the object's class already has a
 EncodeToBytes method with the same parameters, that method takes precedence
 over this extension method.</p> <p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing
 ICharacterInput and can be called as follows: <code>
 input.EncodeToWriter(encoder, output)</code>. If the object's class already has a
 <code>EncodeToWriter</code> method with the same parameters, that method takes
 precedence over this extension method.</p>

**Parameters:**

* <code>input</code> - An object that implements a stream of universal code points.

* <code>encoder</code> - An object that implements a character encoder.

* <code>output</code> - A writable data stream.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>encoder</code> or <code>input</code>
 is null.

* <code>IOException</code>

### EncodeToWriter

    public static void EncodeToWriter(String str, ICharacterEncoding enc, OutputStream output) throws IOException

<p>Converts a text string to bytes and writes the bytes to an output data
 stream. When reading the string, any unpaired surrogate characters are
 replaced with the replacement character (U+FFFD), and when writing to the
 byte stream, any characters that can't be encoded are replaced with the byte
 0x3f (the question mark character). </p><p>In the.NET implementation, this
 method is implemented as an extension method to any string object and can be
 called as follows: <code>str.EncodeToBytes(enc, writer)</code>. If the object's
 class already has a EncodeToBytes method with the same parameters, that
 method takes precedence over this extension method.</p> <p>In the.NET
 implementation, this method is implemented as an extension method to any
 object implementing string and can be called as follows: <code>
 str.EncodeToWriter(enc, output)</code>. If the object's class already has a <code>
 EncodeToWriter</code> method with the same parameters, that method takes
 precedence over this extension method.</p>

**Parameters:**

* <code>str</code> - A text string to encode.

* <code>enc</code> - An object implementing a character encoding (gives access to an
 encoder and a decoder).

* <code>output</code> - A writable data stream.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>str</code> or <code>enc</code> is
 null.

* <code>IOException</code>

### GetDecoderInput

    public static ICharacterInput GetDecoderInput(ICharacterEncoding encoding, IByteReader stream)

<p>Converts a character encoding into a character input stream, given a
 streamable source of bytes. The input stream doesn't check the first few
 bytes for a byte-order mark indicating a Unicode encoding such as UTF-8
 before using the character encoding's decoder. </p> <p>In the.NET
 implementation, this method is implemented as an extension method to any
 object implementing ICharacterEncoding and can be called as follows:
 "encoding.GetDecoderInput(input)". If the object's class already has a
 GetDecoderInput method with the same parameters, that method takes
 precedence over this extension method.</p>

**Parameters:**

* <code>encoding</code> - Encoding that exposes a decoder to be converted into a
 character input stream. If the decoder returns -2 (indicating a decode
 error), the character input stream handles the error by returning a
 replacement character in its place.

* <code>stream</code> - Byte stream to convert into Unicode characters.

**Returns:**

* An ICharacterInput object.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>encoding</code> is null.

### GetDecoderInput

    public static ICharacterInput GetDecoderInput(ICharacterEncoding encoding, InputStream input)

<p>Converts a character encoding into a character input stream, given a data
 stream. The input stream doesn't check the first few bytes for a byte-order
 mark indicating a Unicode encoding such as UTF-8 before using the character
 encoding's decoder. </p><p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing
 ICharacterEncoding and can be called as follows: <code>
 encoding.GetDecoderInput(input)</code>. If the object's class already has a
 GetDecoderInput method with the same parameters, that method takes
 precedence over this extension method.</p> <p>In the.NET implementation,
 this method is implemented as an extension method to any object implementing
 ICharacterEncoding and can be called as follows: <code>
 encoding.GetDecoderInput(input)</code>. If the object's class already has a <code>
 GetDecoderInput</code> method with the same parameters, that method takes
 precedence over this extension method.</p>

**Parameters:**

* <code>encoding</code> - Encoding object that exposes a decoder to be converted into
 a character input stream. If the decoder returns -2 (indicating a decode
 error), the character input stream handles the error by returning a
 replacement character in its place.

* <code>input</code> - Byte stream to convert into Unicode characters.

**Returns:**

* An ICharacterInput object.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>encoding</code> is null.

### GetDecoderInputSkipBom

    public static ICharacterInput GetDecoderInputSkipBom(ICharacterEncoding encoding, IByteReader stream)

<p>Converts a character encoding into a character input stream, given a
 streamable source of bytes. But if the input stream starts with a UTF-8 or
 UTF-16 byte order mark, the input is decoded as UTF-8 or UTF-16, as the case
 may be, rather than the specified character encoding. </p><p>This method
 implements the "decode" algorithm specified in the Encoding standard.</p>
 <p>In the.NET implementation, this method is implemented as an extension
 method to any object implementing ICharacterEncoding and can be called as
 follows: <code>encoding.GetDecoderInputSkipBom(input)</code>. If the object's
 class already has a <code>GetDecoderInputSkipBom</code> method with the same
 parameters, that method takes precedence over this extension method.</p>

**Parameters:**

* <code>encoding</code> - Encoding object that exposes a decoder to be converted into
 a character input stream. If the decoder returns -2 (indicating a decode
 error), the character input stream handles the error by returning a
 replacement character in its place.

* <code>stream</code> - Byte stream to convert into Unicode characters.

**Returns:**

* An ICharacterInput object.

### GetDecoderInputSkipBom

    public static ICharacterInput GetDecoderInputSkipBom(ICharacterEncoding encoding, InputStream input)

<p>Converts a character encoding into a character input stream, given a
 readable data stream. But if the input stream starts with a UTF-8 or UTF-16
 byte order mark, the input is decoded as UTF-8 or UTF-16, as the case may
 be, rather than the specified character encoding.This method implements the
 "decode" algorithm specified in the Encoding standard. </p> <p>In the.NET
 implementation, this method is implemented as an extension method to any
 object implementing ICharacterEncoding and can be called as follows: <code>
 encoding.GetDecoderInputSkipBom(input)</code>. If the object's class already has a
 <code>GetDecoderInputSkipBom</code> method with the same parameters, that method
 takes precedence over this extension method.</p>

**Parameters:**

* <code>encoding</code> - Encoding object that exposes a decoder to be converted into
 a character input stream. If the decoder returns -2 (indicating a decode
 error), the character input stream handles the error by returning a
 replacement character in its place.

* <code>input</code> - Byte stream to convert into Unicode characters.

**Returns:**

* An ICharacterInput object.

### GetEncoding

    public static ICharacterEncoding GetEncoding(String name)

Returns a character encoding from the specified name.

**Parameters:**

* <code>name</code> - A string naming a character encoding. See the ResolveAlias
 method. Can be null.

**Returns:**

* An object implementing a character encoding (gives access to an
 encoder and a decoder).

### GetEncoding

    public static ICharacterEncoding GetEncoding(String name, boolean forEmail, boolean allowReplacement)

Returns a character encoding from the specified name.

**Parameters:**

* <code>name</code> - A string naming a character encoding. See the ResolveAlias
 method. Can be null.

* <code>forEmail</code> - If false, uses the encoding resolution rules in the Encoding
 Standard. If true, uses modified rules as described in the
 ResolveAliasForEmail method.

* <code>allowReplacement</code> - Has no effect.

**Returns:**

* An object that enables encoding and decoding text in the specified
 character encoding. Returns null if the name is null or empty, or if it
 names an unrecognized or unsupported encoding.

### GetEncoding

    public static ICharacterEncoding GetEncoding(String name, boolean forEmail)

Returns a character encoding from the specified name.

**Parameters:**

* <code>name</code> - A string naming a character encoding. See the ResolveAlias
 method. Can be null.

* <code>forEmail</code> - If false, uses the encoding resolution rules in the Encoding
 Standard. If true, uses modified rules as described in the
 ResolveAliasForEmail method. If the resolved encoding is "GB18030" or "GBK"
 (in any combination of case), uses either an encoding intended to conform to
 the 2022 version of GB18030 if 'forEmail' is true, or the definition of the
 encoding in the WHATWG Encoding Standard (as of July 7, 2023) if 'forEmail'
 is false.

**Returns:**

* An object that enables encoding and decoding text in the specified
 character encoding. Returns null if the name is null or empty, or if it
 names an unrecognized or unsupported encoding.

### InputToString

    public static String InputToString(ICharacterInput reader)

<p>Reads Unicode characters from a character input and converts them to a
 text string. </p> <p>In the.NET implementation, this method is implemented
 as an extension method to any object implementing ICharacterInput and can be
 called as follows: <code>reader.InputToString()</code>. If the object's class
 already has a InputToString method with the same parameters, that method
 takes precedence over this extension method.</p>

**Parameters:**

* <code>reader</code> - A character input whose characters will be converted to a text
 string.

**Returns:**

* A text string containing the characters read.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>reader</code> is null.

### ResolveAlias

    public static String ResolveAlias(String name)

<p>Resolves a character encoding's name to a standard form. This involves
 changing aliases of a character encoding to a standardized name. </p> <p>In
 several Internet specifications, this name is known as a "charset"
 parameter. In HTML and HTTP, for example, the "charset" parameter indicates
 the encoding used to represent text in the HTML page, text file, or other
 document.</p>

**Parameters:**

* <code>name</code> - <p>A string that names a given character encoding. Can be null.
 Any leading and trailing whitespace (U+0009, U+000c, U+000D, U+000A, U+0010)
 is removed before resolving the encoding's name, and encoding names are
 matched using a basic case-insensitive comparison. (Two strings are equal in
 such a comparison, if they match after converting the basic uppercase
 letters A to Z (U+0041 to U+005A) in both strings to basic lowercase
 letters.) The Encoding Standard supports only the following encodings (and
 defines aliases for most of them). </p><ul> <li> <code>UTF-8</code> - UTF-8 (8-bit
 encoding of the universal coded character set, the encoding recommended by
 the Encoding Standard for new data formats)</li><li> <code>UTF-16LE</code> -
 UTF-16 little-endian (16-bit UCS)</li><li> <code>UTF-16BE</code> - UTF-16
 big-endian (16-bit UCS)</li><li>The special-purpose encoding <code>
 x-user-defined</code></li><li>The special-purpose encoding <code>
 replacement</code>.</li><li>28 legacy single-byte encodings: <ul> <li> <code>
 windows-1252</code> : Western Europe (Note: The Encoding Standard aliases the
 names <code>US-ASCII</code> and <code>ISO-8859-1</code> to <code>windows-1252</code>, which
 uses a different coded character set from either; it differs from <code>
 ISO-8859-1</code> by assigning different characters to some bytes from 0x80 to
 0x9F. The Encoding Standard does this for compatibility with existing Web
 pages.)</li><li> <code>ISO-8859-2</code>, <code>windows-1250</code> : Central
 Europe</li><li> <code>ISO-8859-10</code> : Northern Europe</li><li> <code>
 ISO-8859-4</code>, <code>windows-1257</code> : Baltic</li><li> <code>ISO-8859-13</code> :
 Estonian</li><li> <code>ISO-8859-14</code> : Celtic</li><li> <code>ISO-8859-16</code> :
 Romanian</li><li> <code>ISO-8859-5</code>, <code>IBM-866</code>, <code>KOI8-R</code>, <code>
 windows-1251</code>, <code>x-mac-cyrillic</code> : Cyrillic</li><li> <code>KOI8-U</code> :
 Ukrainian</li><li> <code>ISO-8859-7</code>, <code>windows-1253</code> :
 Greek</li><li> <code>ISO-8859-6</code>, <code>windows-1256</code> :
 Arabic</li><li> <code>ISO-8859-8</code>, <code>ISO-8859-8-I</code>, <code>
 windows-1255</code> : Hebrew</li><li> <code>ISO-8859-3</code> : Latin 3</li><li> <code>
 ISO-8859-15</code>, <code>windows-1254</code> : Turkish</li><li> <code>windows-874</code> :
 Thai</li><li> <code>windows-1258</code> : Vietnamese</li><li> <code>macintosh</code> :
 Mac Roman</li></ul></li><li>Three legacy Japanese encodings: <code>
 Shift_JIS</code>, <code>EUC-JP</code>, <code>ISO-2022-JP</code></li><li>Two legacy
 simplified Chinese encodings: <code>GBK</code> and <code>gb18030</code></li><li> <code>
 Big5</code> : legacy traditional Chinese encoding</li><li> <code>EUC-KR</code> : legacy
 Korean encoding</li></ul> <p>The <code>UTF-8</code>, <code>UTF-16LE</code>, and <code>
 UTF-16BE</code> encodings don't encode a byte-order mark at the start of the text
 (doing so is not recommended for <code>UTF-8</code>, while in <code>UTF-16LE</code>
 and <code>UTF-16BE</code>, the byte-order mark character U+FEFF is treated as an
 ordinary character, unlike in the UTF-16 encoding form). The Encoding
 Standard aliases <code>UTF-16</code> to <code>UTF-16LE</code> "to deal with deployed
 content".</p>.

**Returns:**

* A standardized name for the encoding. Returns the empty string if
 <code>name</code> is null or empty, or if the encoding name is unsupported.

### ResolveAliasForEmail

    public static String ResolveAliasForEmail(String name)

Resolves a character encoding's name to a canonical form, using rules more
 suitable for email.

**Parameters:**

* <code>name</code> - <p>A string naming a character encoding. Can be null. Any
 leading and trailing whitespace (U+0009, U+000c, U+000D, U+000A, U+0010) is
 removed before resolving the encoding's name, and encoding names are matched
 using a basic case-insensitive comparison. (Two strings are equal in such a
 comparison, if they match after converting the basic uppercase letters A to
 Z (U+0041 to U+005A) in both strings to basic lowercase letters.) Uses a
 modified version of the rules in the Encoding Standard to better conform, in
 some cases, to email standards like MIME. Encoding names and aliases not
 registered with the Internet Assigned Numbers Authority (IANA) are not
 supported, with the exception of <code>ascii</code>, <code>utf8</code>, <code>
 cp1252</code>, and names 10 characters or longer starting with <code>iso-8859-</code>.
 Also, the following additional encodings are supported. Note that the case
 combination <code>GB18030</code>, the combination registered with IANA, rather
 than <code>gb18030</code>, can be returned by this method. </p> <ul> <li> <code>
 US-ASCII</code> - ASCII single-byte encoding, rather than an alias to <code>
 windows-1252</code> as specified in the Encoding Standard. The coded character
 set's code points match those in the Unicode Standard's Basic Latin block
 (0-127 or U+0000 to U+007F). This method name <code>ascii</code> is treated as an
 alias to <code>US-ASCII</code> even though it is not registered with IANA as a
 charset name and RFC 2046 (part of MIME) reserves the name "ASCII". A future
 version of this method may stop supporting the alias <code>
 ascii</code>.</li><li> <code>ISO-8859-1</code> - Latin-1 single-byte encoding, rather
 than an alias to <code>windows-1252</code> as specified in the Encoding Standard.
 The coded character set's code points match those in the Unicode Standard's
 Basic Latin and Latin-1 Supplement blocks (0-255 or U+0000 to
 U+00FF).</li><li> <code>UTF-16</code> - UTF-16 without a fixed byte order, rather
 than an alias to <code>UTF-16LE</code> as specified in the Encoding Standard. The
 byte order is little-endian if the byte stream starts with 0xff 0xfe;
 otherwise, big-endian. A leading 0xff 0xfe or 0xfe 0xff in the byte stream
 is skipped.</li><li> <code>UTF-7</code> - UTF-7 (7-bit universal coded character
 set). The name <code>unicode-1-1-utf-7</code> is not supported and is not treated
 as an alias to <code>UTF-7</code>, even though it uses the same character
 encoding scheme as UTF-7, because RFC 1642, which defined the former UTF-7,
 is linked to a different Unicode version with an incompatible character
 repertoire (notably, the Hangul syllables have different code point
 assignments in Unicode 1.1 and earlier than in Unicode 2.0 and
 later).</li><li><code>ISO-2022-JP-2</code> - similar to "ISO-2022-JP", except
 that the decoder supports additional coded character sets.</li></ul>

**Returns:**

* A standardized name for the encoding. Returns the empty string if
 <code>name</code> is null or empty, or if the encoding name is unsupported.

### StringToBytes

    public static byte[] StringToBytes(ICharacterEncoding encoding, String str)

<p>Converts a text string to a byte array encoded in a given character
 encoding. When reading the string, any unpaired surrogate characters are
 replaced with the replacement character (U+FFFD), and when writing to the
 byte array, any characters that can't be encoded are replaced with the byte
 0x3f (the question mark character). </p> <p>In the.NET implementation, this
 method is implemented as an extension method to any object implementing
 ICharacterEncoding and can be called as follows: <code>
 encoding.StringToBytes(str)</code>. If the object's class already has a
 StringToBytes method with the same parameters, that method takes precedence
 over this extension method.</p>

**Parameters:**

* <code>encoding</code> - An object that implements a character encoding.

* <code>str</code> - A string to be encoded into a byte array.

**Returns:**

* A byte array containing the string encoded in the specified text
 encoding.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>encoding</code> is null.

### StringToBytes

    public static byte[] StringToBytes(ICharacterEncoder encoder, String str)

<p>Converts a text string to a byte array using the specified character
 encoder. When reading the string, any unpaired surrogate characters are
 replaced with the replacement character (U+FFFD), and when writing to the
 byte array, any characters that can't be encoded are replaced with the byte
 0x3f (the question mark character). </p><p>In the.NET implementation, this
 method is implemented as an extension method to any object implementing
 ICharacterEncoder and can be called as follows: <code>
 encoder.StringToBytes(str)</code>. If the object's class already has a
 StringToBytes method with the same parameters, that method takes precedence
 over this extension method.</p> <p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing
 ICharacterEncoder and can be called as follows: <code>
 encoder.StringToBytes(str)</code>. If the object's class already has a <code>
 StringToBytes</code> method with the same parameters, that method takes precedence
 over this extension method.</p>

**Parameters:**

* <code>encoder</code> - An object that implements a character encoder.

* <code>str</code> - A text string to encode into a byte array.

**Returns:**

* A byte array.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>encoder</code> or <code>str</code>
 is null.

### StringToInput

    public static ICharacterInput StringToInput(String str)

<p>Converts a text string to a character input. The resulting input can then
 be used to encode the text to bytes, or to read the string code point by
 code point, among other things. When reading the string, any unpaired
 surrogate characters are replaced with the replacement character (U+FFFD).
 </p><p>In the.NET implementation, this method is implemented as an extension
 method to any string object and can be called as follows: <code>
 str.StringToInput(offset, length)</code>. If the object's class already has a
 StringToInput method with the same parameters, that method takes precedence
 over this extension method.</p> <p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing string and can
 be called as follows: <code>str.StringToInput()</code>. If the object's class
 already has a <code>StringToInput</code> method with the same parameters, that
 method takes precedence over this extension method.</p>

**Parameters:**

* <code>str</code> - The parameter <code>str</code> is a text string.

**Returns:**

* An ICharacterInput object.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>str</code> is null.

### StringToInput

    public static ICharacterInput StringToInput(String str, int offset, int length)

<p>Converts a portion of a text string to a character input. The resulting
 input can then be used to encode the text to bytes, or to read the string
 code point by code point, among other things. When reading the string, any
 unpaired surrogate characters are replaced with the replacement character
 (U+FFFD). </p><p>In the.NET implementation, this method is implemented as an
 extension method to any string object and can be called as follows: <code>
 str.StringToInput(offset, length)</code>. If the object's class already has a
 StringToInput method with the same parameters, that method takes precedence
 over this extension method.</p> <p>In the.NET implementation, this method is
 implemented as an extension method to any object implementing string and can
 be called as follows: <code>str.StringToInput(offset, length)</code>. If the
 object's class already has a <code>StringToInput</code> method with the same
 parameters, that method takes precedence over this extension method.</p>

**Parameters:**

* <code>str</code> - The parameter <code>str</code> is a text string.

* <code>offset</code> - An index starting at 0 showing where the desired portion of
 <code>str</code> begins.

* <code>length</code> - The length, in code units, of the desired portion of <code>
 str</code> (but not more than <code>str</code> 's length).

**Returns:**

* An ICharacterInput object.

**Throws:**

* <code>NullPointerException</code> - The parameter <code>str</code> is null.

* <code>IllegalArgumentException</code> - Either <code>offset</code> or <code>length</code> is less
 than 0 or greater than <code>str</code> 's length, or <code>str</code> 's length minus
 <code>offset</code> is less than <code>length</code>.

* <code>NullPointerException</code> - The parameter <code>str</code> is null.
