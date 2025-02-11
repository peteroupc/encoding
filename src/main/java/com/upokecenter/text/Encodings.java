package com.upokecenter.text;

import java.util.*;
import java.io.*;

import com.upokecenter.util.*;
import com.upokecenter.text.encoders.*;

  /**
   * <p>Contains methods for converting text from one character encoding to
   * another. This class also contains convenience methods for converting strings
   * and other character inputs to sequences of bytes and vice versa. </p><p>The
   * WHATWG Encoding Standard defines algorithms for the most common character
   * encodings used on Web pages and recommends the UTF-8 encoding for new
   * specifications and Web pages. Calling the {@code GetEncoding(name)} method
   * returns one of the character encodings with the specified name under the
   * Encoding Standard.</p> <p>Now let's define some terms.</p> <p><b>Encoding
   * Terms</b></p> <ul> <li>A <b>code point</b> is a number that identifies a
   * single text character, such as a letter, digit, or symbol. (A collection of
   * such characters is also called an <i>abstract character
   * repertoire</i>.)</li><li>A <b>coded character set</b> is a set of code
   * points which are each assigned to a single text character. As used here,
   * coded character sets don't define how code points are laid out in
   * memory.</li><li>A <b>character encoding</b> is a mapping from a sequence of
   * code points, in one or more specific coded character sets, to a sequence of
   * bytes and vice versa. (For brevity, the rest of this documentation may use
   * the term <i>encoding</i> instead. RFC 6365 uses the analogous term
   * <i>charset</i> instead; in this documentation, however, <i>charset</i> is
   * used only to refer to the names that identify a character
   * encoding.)</li><li><b>ASCII</b> is a 128-code-point coded character set that
   * includes the English letters and digits, common punctuation and symbols, and
   * control characters. As used here, its code points match the code points
   * within the Basic Latin block (0-127 or U+0000 to U+007F) of the Unicode
   * Standard.</li></ul> <p>There are several kinds of character encodings:</p>
   * <ul> <li><b>Single-byte encodings</b> define a coded character set that
   * assigns one code point to one byte. Thus, they can have a maximum of 256
   * code points. For example:</li><li>(a) ISO 8859 encodings and {@code
   * windows-1252}.</li><li>(b) ASCII is usually used as a single-byte encoding
   * where each code point fits in the lower 7 bits of an eight-bit byte (in that
   * case, the encoding is often called {@code US-ASCII}). In the Encoding
   * Standard, all single-byte encodings use the ASCII characters as the first
   * 128 code points of their coded character sets.</li><li><b>Multi-byte
   * encodings</b> include code points from one or more coded character sets and
   * assign some or all code points to several bytes. For example:</li><li>(a)
   * {@code UTF-16LE} and {@code UTF-16BE} are two encodings defined in the
   * Unicode Standard. They use 2 bytes for the most common code points, and 4
   * bytes for supplementary code points.</li><li>(b) {@code UTF-8} is another
   * encoding defined in the Unicode Standard. It uses 1 byte for ASCII and 2 to
   * 4 bytes for the other Unicode code points.</li><li>(c) Most legacy East
   * Asian encodings, such as {@code Shift_JIS}, {@code GBK}, and {@code Big5}
   * use 1 byte for ASCII (or a slightly modified version) and, usually, 2 or
   * more bytes for national standard coded character sets. In many of these
   * encodings, notably {@code Shift_JIS}, characters whose code points use one
   * byte traditionally take half the space of characters whose code points use
   * two bytes.</li><li><b>Escape-based encodings</b> are combinations of single-
   * and/or multi-byte encodings, and use escape sequences and/or shift codes to
   * change which encoding to use for the bytes that follow. For
   * example:</li><li>(a) {@code ISO-2022-JP} supports several escape sequences
   * that shift into different encodings, including a Katakana, a Kanji, and an
   * ASCII encoding (with ASCII as the default).</li><li>(b) UTF-7 (not included
   * in the Encoding Standard) is an encoding that uses the Unicode Standard's
   * coded character set, which is encoded using a limited subset of ASCII. The
   * plus symbol (U+002B) is used to shift into a UTF-16BE multi-byte encoding
   * (converted to a modified version of base-64) to encode other Unicode code
   * points.</li><li>The Encoding Standard also defines a <b>replacement
   * encoding</b>, which causes a decoding error and is used to alias a few
   * problematic or unsupported encoding names, such as {@code
   * hz-gb-2312}.</li></ul> <p><b>Getting an Encoding</b></p> <p>The Encoding
   * Standard includes UTF-8, UTF-16, and many legacy encodings, and gives each
   * one of them a name. The {@code GetEncoding(name)} method takes a name string
   * and returns an ICharacterEncoding object that implements that encoding, or
   * {@code null} if the name is unrecognized.</p> <p>However, the Encoding
   * Standard is designed to include only encodings commonly used on Web pages,
   * not in other protocols such as email. For email, the Encoding class includes
   * an alternate function {@code GetEncoding(name, forEmail)}. Setting {@code
   * forEmail} to {@code true} will use rules modified from the Encoding Standard
   * to better suit encoding and decoding text from email messages.</p>
   * <p><b>Classes for Character Encodings</b></p> <p>This Encodings class
   * provides access to common character encodings through classes as described
   * below:</p> <ul> <li>An <b>encoder class</b> is a class that converts a
   * sequence of bytes to a sequence of code points in the universal character
   * set (otherwise known under the name Unicode). An encoder class implements
   * the {@code ICharacterEncoder} interface.</li><li>A <b>decoder class</b> is a
   * class that converts a sequence of Unicode code points to a sequence of
   * bytes. A decoder class implements the {@code ICharacterDecoder}
   * interface.</li><li>An <b>encoding class</b> allows access to both an encoder
   * class and a decoder class and implements the {@code ICharacterEncoding}
   * interface. The encoder and decoder classes should implement the same
   * character encoding.</li></ul> <p><b>Custom Encodings</b></p> <p>Classes that
   * implement the ICharacterEncoding interface can provide additional character
   * encodings not included in the Encoding Standard. Some examples of these
   * include the following:</p> <ul> <li>A modified version of UTF-8 used in
   * Java's serialization formats.</li><li>A modified version of UTF-7 used in
   * the IMAP email protocol.</li></ul> <p>(Note that this library doesn't
   * implement either encoding.)</p>
   */
  public final class Encodings {
private Encodings() {
}
    /**
     * Character encoding object for the UTF-8 character encoding, which represents
     * each code point in the universal coded character set using 1 to 4 bytes.
     */
    public static final ICharacterEncoding UTF8 = new EncodingUtf8();

    private static final Map<String, String> ValueCharsetAliases =
      CreateAliasMap();

    private static final Map<String, String> EmailAliases =
      CreateEmailAliasMap();

    /**
     * <p>Reads bytes from a data source and converts the bytes from a given
     * encoding to a text string. </p> <p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing
     * ICharacterEncoding and can be called as follows:
     * "encoding.DecodeString(input)". If the object's class already has a
     * DecodeToString method with the same parameters, that method takes precedence
     * over this extension method.</p>
     * @param encoding An object that implements a given character encoding. Any
     * bytes that can't be decoded are converted to the replacement character
     * (U+FFFD).
     * @param input An object that implements a byte stream.
     * @return The converted string.
     * @throws NullPointerException The parameter {@code encoding} or {@code
     * input} is null.
     */
    public static String DecodeToString(
      ICharacterEncoding encoding,
      IByteReader input) {
      if (encoding == null) {
        throw new NullPointerException("encoding");
      }
      if (input == null) {
        throw new NullPointerException("input");
      }
      return InputToString(
          GetDecoderInput(encoding, input));
    }

    /**
     * <p>Decodes data read from a data stream into a text string in the specified
     * character encoding. </p><p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing
     * ICharacterEncoding and can be called as follows: {@code
     * encoding.DecodeToString(input)}. If the object's class already has a
     * DecodeToString method with the same parameters, that method takes precedence
     * over this extension method.</p> <p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing
     * ICharacterEncoding and can be called as follows: {@code
     * enc.DecodeToString(input)}. If the object's class already has a {@code
     * DecodeToString} method with the same parameters, that method takes
     * precedence over this extension method.</p>
     * @param enc An object implementing a character encoding (gives access to an
     * encoder and a decoder).
     * @param input A readable byte stream.
     * @return A string consisting of the decoded text.
     * @throws NullPointerException The parameter "encoding" or {@code input} is
     * null.
     */
    public static String DecodeToString(
      ICharacterEncoding enc,
      InputStream input) {
      if (enc == null) {
        throw new NullPointerException("enc");
      }
      if (input == null) {
        throw new NullPointerException("input");
      }
      return InputToString(
          GetDecoderInput(enc, DataIO.ToReader(input)));
    }

    /**
     * <p>Reads a byte array from a data source and converts the bytes from a given
     * encoding to a text string. Errors in decoding are handled by replacing
     * erroneous bytes with the replacement character (U+FFFD). </p><p>In the.NET
     * implementation, this method is implemented as an extension method to any
     * object implementing ICharacterEncoding and can be called as follows: {@code
     * enc.DecodeToString(bytes)}. If the object's class already has a
     * DecodeToString method with the same parameters, that method takes precedence
     * over this extension method.</p> <p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing
     * ICharacterEncoding and can be called as follows: {@code
     * enc.DecodeToString(bytes)}. If the object's class already has a {@code
     * DecodeToString} method with the same parameters, that method takes
     * precedence over this extension method.</p>
     * @param enc An object implementing a character encoding (gives access to an
     * encoder and a decoder).
     * @param bytes A byte array.
     * @return A string consisting of the decoded text.
     * @throws NullPointerException The parameter {@code enc} or {@code bytes} is
     * null.
     */
    public static String DecodeToString(
      ICharacterEncoding enc,
      byte[] bytes) {
      if (enc == null) {
        throw new NullPointerException("enc");
      }
      if (bytes == null) {
        throw new NullPointerException("bytes");
      }
      return DecodeToString(enc, DataIO.ToReader(bytes));
    }

    /**
     * <p>Reads a portion of a byte array from a data source and converts the bytes
     * from a given encoding to a text string. Errors in decoding are handled by
     * replacing erroneous bytes with the replacement character (U+FFFD). </p><p>In
     * the.NET implementation, this method is implemented as an extension method to
     * any object implementing ICharacterEncoding and can be called as follows:
     * {@code enc.DecodeToString(bytes, offset, length)}. If the object's class
     * already has a DecodeToString method with the same parameters, that method
     * takes precedence over this extension method.</p> <p>In the.NET
     * implementation, this method is implemented as an extension method to any
     * object implementing ICharacterEncoding and can be called as follows: {@code
     * enc.DecodeToString(bytes, offset, length)}. If the object's class already
     * has a {@code DecodeToString} method with the same parameters, that method
     * takes precedence over this extension method.</p>
     * @param enc An object implementing a character encoding (gives access to an
     * encoder and a decoder).
     * @param bytes A byte array containing the desired portion to read.
     * @param offset An index starting at 0 showing where the desired portion of
     * {@code bytes} begins.
     * @param length The length, in bytes, of the desired portion of {@code bytes}
     * (but not more than {@code bytes} 's length).
     * @return A string consisting of the decoded text.
     * @throws NullPointerException The parameter {@code enc} or {@code
     * bytes} is null.
     * @throws IllegalArgumentException Either {@code offset} or {@code length} is less
     * than 0 or greater than {@code bytes} 's length, or {@code bytes} 's length
     * minus {@code offset} is less than {@code length}.
     * @throws NullPointerException The parameter {@code enc} or {@code bytes} is
     * null.
     */
    public static String DecodeToString(
      ICharacterEncoding enc,
      byte[] bytes,
      int offset,
      int length) {
      if (enc == null) {
        throw new NullPointerException("enc");
      }
      if (bytes == null) {
        throw new NullPointerException("bytes");
      }
      if (offset < 0) {
        throw new IllegalArgumentException("offset(" + offset +
          ") is less than 0");
      }
      if (offset > bytes.length) {
        throw new IllegalArgumentException("offset(" + offset +
          ") is more than " + bytes.length);
      }
      if (length < 0) {
        throw new IllegalArgumentException("length(" + length +
          ") is less than 0");
      }
      if (length > bytes.length) {
        throw new IllegalArgumentException("length(" + length +
          ") is more than " + bytes.length);
      }
      if (bytes.length - offset < length) {
        throw new IllegalArgumentException("bytes's length minus " + offset + "(" +
          (bytes.length - offset) + ") is less than " + length);
      }
      return DecodeToString(enc, DataIO.ToReader(bytes, offset, length));
    }

    /**
     * <p>Reads Unicode characters from a character input and writes them to a byte
     * array encoded using the specified character encoder. When writing to the
     * byte array, any characters that can't be encoded are replaced with the byte
     * 0x3f (the question mark character). </p> <p>In the.NET implementation, this
     * method is implemented as an extension method to any object implementing
     * ICharacterInput and can be called as follows: {@code
     * input.EncodeToBytes(encoding)}. If the object's class already has a {@code
     * EncodeToBytes} method with the same parameters, that method takes precedence
     * over this extension method.</p>
     * @param input An object that implements a stream of universal code points.
     * @param encoding An object that implements a given character encoding.
     * @return A byte array containing the encoded text.
     * @throws NullPointerException The parameter {@code encoding} is null.
     */
    public static byte[] EncodeToBytes(
      ICharacterInput input,
      ICharacterEncoding encoding) {
      if (encoding == null) {
        throw new NullPointerException("encoding");
      }
      return EncodeToBytes(input, encoding.GetEncoder());
    }

    /**
     * <p>Reads Unicode characters from a character input and writes them to a byte
     * array encoded using a given character encoding. When writing to the byte
     * array, any characters that can't be encoded are replaced with the byte 0x3f
     * (the question mark character). </p><p>In the.NET implementation, this method
     * is implemented as an extension method to any object implementing
     * ICharacterInput and can be called as follows: {@code
     * input.EncodeToBytes(encoder)}. If the object's class already has a
     * EncodeToBytes method with the same parameters, that method takes precedence
     * over this extension method.</p> <p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing
     * ICharacterInput and can be called as follows: {@code
     * input.EncodeToBytes(encoder)}. If the object's class already has a {@code
     * EncodeToBytes} method with the same parameters, that method takes precedence
     * over this extension method.</p>
     * @param input An object that implements a stream of universal code points.
     * @param encoder An object that implements a character encoder.
     * @return A byte array.
     * @throws NullPointerException The parameter {@code encoder} or {@code input}
     * is null.
     */
    public static byte[] EncodeToBytes(
      ICharacterInput input,
      ICharacterEncoder encoder) {
      return EncodeToBytes(input, encoder, false);
    }

    /**
     * <p>Reads Unicode characters from a character input and writes them to a byte
     * array encoded using the specified character encoder and fallback strategy.
     * </p> <p>In the.NET implementation, this method is implemented as an
     * extension method to any object implementing ICharacterInput and can be
     * called as follows: {@code input.EncodeToBytes(encoder, htmlFallback)}. If
     * the object's class already has a {@code EncodeToBytes} method with the same
     * parameters, that method takes precedence over this extension method.</p>
     * @param input An object that implements a stream of universal code points.
     * @param encoder A character encoder that takes Unicode characters and writes
     * them into bytes.
     * @param htmlFallback If true, when the encoder encounters invalid characters
     * that can't be mapped into bytes, writes the HTML decimal escape for the
     * invalid characters instead. If false, writes a question mark byte (0x3f)
     * upon encountering invalid characters.
     * @return A byte array containing the encoded characters.
     * @throws NullPointerException The parameter {@code encoder} or {@code
     * input} is null.
     * @throws NullPointerException The parameter {@code encoder} or {@code input}
     * is null.
     */
    public static byte[] EncodeToBytes(
      ICharacterInput input,
      ICharacterEncoder encoder,
      boolean htmlFallback) {
      if (encoder == null) {
        throw new NullPointerException("encoder");
      }
      if (input == null) {
        throw new NullPointerException("input");
      }
      ArrayWriter writer = new ArrayWriter();
      if (htmlFallback) {
        EncoderAlgorithms.EncodeAlgorithm(input, encoder, writer);
      } else {
        while (true) {
          int cp = input.ReadChar();
          int enc = encoder.Encode(cp, writer);
          if (enc == -2) {
            // Not encodable, write a question mark instead
            writer.write((byte)0x3f);
          }
          if (enc == -1) {
            break;
          }
        }
      }
      return writer.ToArray();
    }

    /**
     * <p>Reads Unicode characters from a text string and writes them to a byte
     * array encoded in a given character encoding. When reading the string, any
     * unpaired surrogate characters are replaced with the replacement character
     * (U+FFFD), and when writing to the byte array, any characters that can't be
     * encoded are replaced with the byte 0x3f (the question mark character).
     * </p><p>In the.NET implementation, this method is implemented as an extension
     * method to any string object and can be called as follows: {@code
     * str.EncodeToBytes(enc)}. If the object's class already has a EncodeToBytes
     * method with the same parameters, that method takes precedence over this
     * extension method.</p> <p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing string and can
     * be called as follows: {@code str.EncodeToBytes(enc)}. If the object's class
     * already has a {@code EncodeToBytes} method with the same parameters, that
     * method takes precedence over this extension method.</p>
     * @param str A text string to encode to a byte array.
     * @param enc An object implementing a character encoding (gives access to an
     * encoder and a decoder).
     * @return A byte array containing the encoded text string.
     * @throws NullPointerException The parameter {@code str} or {@code enc} is
     * null.
     */
    public static byte[] EncodeToBytes(
      String str,
      ICharacterEncoding enc) {
      if (str == null) {
        throw new NullPointerException("str");
      }
      if (enc == null) {
        throw new NullPointerException("enc");
      }
      return EncodeToBytes(
          new CharacterReader(str),
          enc.GetEncoder(),
          false);
    }

    /**
     * <p>Reads Unicode characters from a text string and writes them to a byte
     * array encoded in a given character encoding and using the specified encoder
     * fallback strategy. When reading the string, any unpaired surrogate
     * characters are replaced with the replacement character (U+FFFD). </p> <p>In
     * the.NET implementation, this method is implemented as an extension method to
     * any object implementing string and can be called as follows: {@code
     * str.EncodeToBytes(enc, htmlFallback)}. If the object's class already has a
     * {@code EncodeToBytes} method with the same parameters, that method takes
     * precedence over this extension method.</p>
     * @param str A text string to encode to a byte array.
     * @param enc An object implementing a character encoding (gives access to an
     * encoder and a decoder).
     * @param htmlFallback If true, when the encoder encounters invalid characters
     * that can't be mapped into bytes, writes the HTML decimal escape for the
     * invalid characters instead. If false, writes a question mark byte (0x3f)
     * upon encountering invalid characters.
     * @return A byte array containing the encoded text string.
     * @throws NullPointerException The parameter {@code str} or {@code enc} is
     * null.
     */
    public static byte[] EncodeToBytes(
      String str,
      ICharacterEncoding enc,
      boolean htmlFallback) {
      if (str == null) {
        throw new NullPointerException("str");
      }
      if (enc == null) {
        throw new NullPointerException("enc");
      }
      return EncodeToBytes(
          new CharacterReader(str),
          enc.GetEncoder(),
          htmlFallback);
    }

    /**
     * <p>Reads Unicode characters from a character input and writes them to a byte
     * array encoded using the specified character encoder. When writing to the
     * byte array, any characters that can't be encoded are replaced with the byte
     * 0x3f (the question mark character). </p><p>In the.NET implementation, this
     * method is implemented as an extension method to any object implementing
     * ICharacterInput and can be called as follows: {@code
     * input.EncodeToBytes(encoding)}. If the object's class already has a
     * EncodeToBytes method with the same parameters, that method takes precedence
     * over this extension method.</p> <p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing
     * ICharacterInput and can be called as follows: {@code
     * input.EncodeToWriter(encoding, writer)}. If the object's class already has a
     * {@code EncodeToWriter} method with the same parameters, that method takes
     * precedence over this extension method.</p>
     * @param input An object that implements a stream of universal code points.
     * @param encoding An object that implements a character encoding.
     * @param writer A byte writer to write the encoded bytes to.
     * @throws NullPointerException The parameter {@code encoding} is null.
     */
    public static void EncodeToWriter(
      ICharacterInput input,
      ICharacterEncoding encoding,
      IWriter writer) {
      if (encoding == null) {
        throw new NullPointerException("encoding");
      }
      EncodeToWriter(input, encoding.GetEncoder(), writer);
    }

    /**
     * <p>Reads Unicode characters from a character input and writes them to a byte
     * array encoded in a given character encoding. When writing to the byte array,
     * any characters that can't be encoded are replaced with the byte 0x3f (the
     * question mark character). </p><p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing
     * ICharacterInput and can be called as follows: {@code
     * input.EncodeToBytes(encoder)}. If the object's class already has a
     * EncodeToBytes method with the same parameters, that method takes precedence
     * over this extension method.</p> <p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing
     * ICharacterInput and can be called as follows: {@code
     * input.EncodeToWriter(encoder, writer)}. If the object's class already has a
     * {@code EncodeToWriter} method with the same parameters, that method takes
     * precedence over this extension method.</p>
     * @param input An object that implements a stream of universal code points.
     * @param encoder An object that implements a character encoder.
     * @param writer A byte writer to write the encoded bytes to.
     * @throws NullPointerException The parameter {@code encoder} or {@code input}
     * is null.
     */
    public static void EncodeToWriter(
      ICharacterInput input,
      ICharacterEncoder encoder,
      IWriter writer) {
      if (encoder == null) {
        throw new NullPointerException("encoder");
      }
      if (input == null) {
        throw new NullPointerException("input");
      }
      if (writer == null) {
        throw new NullPointerException("writer");
      }
      while (true) {
        int cp = input.ReadChar();
        int enc = encoder.Encode(cp, writer);
        if (enc == -2) {
          // Not encodable, write a question mark instead
          writer.write((byte)0x3f);
        }
        if (enc == -1) {
          break;
        }
      }
    }

    /**
     * <p>Converts a text string to bytes and writes the bytes to an output byte
     * writer. When reading the string, any unpaired surrogate characters are
     * replaced with the replacement character (U+FFFD), and when writing to the
     * byte stream, any characters that can't be encoded are replaced with the byte
     * 0x3f (the question mark character). </p><p>In the.NET implementation, this
     * method is implemented as an extension method to any string object and can be
     * called as follows: {@code str.EncodeToBytes(enc, writer)}. If the object's
     * class already has a EncodeToBytes method with the same parameters, that
     * method takes precedence over this extension method.</p> <p>In the.NET
     * implementation, this method is implemented as an extension method to any
     * object implementing string and can be called as follows: {@code
     * str.EncodeToWriter(enc, writer)}. If the object's class already has a {@code
     * EncodeToWriter} method with the same parameters, that method takes
     * precedence over this extension method.</p>
     * @param str A text string to encode.
     * @param enc An object implementing a character encoding (gives access to an
     * encoder and a decoder).
     * @param writer A byte writer where the encoded bytes will be written to.
     * @throws NullPointerException The parameter {@code str} or {@code enc} is
     * null.
     */
    public static void EncodeToWriter(
      String str,
      ICharacterEncoding enc,
      IWriter writer) {
      if (str == null) {
        throw new NullPointerException("str");
      }
      if (enc == null) {
        throw new NullPointerException("enc");
      }
      EncodeToWriter(new CharacterReader(str), enc, writer);
    }

    /**
     * <p>Reads Unicode characters from a character input and writes them to a byte
     * array encoded using the specified character encoder. When writing to the
     * byte array, any characters that can't be encoded are replaced with the byte
     * 0x3f (the question mark character). </p><p>In the.NET implementation, this
     * method is implemented as an extension method to any object implementing
     * ICharacterInput and can be called as follows: {@code
     * input.EncodeToBytes(encoding)}. If the object's class already has a
     * EncodeToBytes method with the same parameters, that method takes precedence
     * over this extension method.</p> <p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing
     * ICharacterInput and can be called as follows: {@code
     * input.EncodeToWriter(encoding, output)}. If the object's class already has a
     * {@code EncodeToWriter} method with the same parameters, that method takes
     * precedence over this extension method.</p>
     * @param input An object that implements a stream of universal code points.
     * @param encoding An object that implements a character encoding.
     * @param output A writable data stream.
     * @throws NullPointerException The parameter {@code encoding} is null.
     */
    public static void EncodeToWriter(
      ICharacterInput input,
      ICharacterEncoding encoding,
      OutputStream output) throws java.io.IOException {
      if (encoding == null) {
        throw new NullPointerException("encoding");
      }
      EncodeToWriter(input, encoding.GetEncoder(), DataIO.ToWriter(output));
    }

    /**
     * <p>Reads Unicode characters from a character input and writes them to a byte
     * array encoded in a given character encoding. When writing to the byte array,
     * any characters that can't be encoded are replaced with the byte 0x3f (the
     * question mark character). </p><p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing
     * ICharacterInput and can be called as follows: {@code
     * input.EncodeToBytes(encoder)}. If the object's class already has a
     * EncodeToBytes method with the same parameters, that method takes precedence
     * over this extension method.</p> <p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing
     * ICharacterInput and can be called as follows: {@code
     * input.EncodeToWriter(encoder, output)}. If the object's class already has a
     * {@code EncodeToWriter} method with the same parameters, that method takes
     * precedence over this extension method.</p>
     * @param input An object that implements a stream of universal code points.
     * @param encoder An object that implements a character encoder.
     * @param output A writable data stream.
     * @throws NullPointerException The parameter {@code encoder} or {@code input}
     * is null.
     */
    public static void EncodeToWriter(
      ICharacterInput input,
      ICharacterEncoder encoder,
      OutputStream output) throws java.io.IOException {
      IWriter writer = DataIO.ToWriter(output);
      EncodeToWriter(input, encoder, writer);
    }

    /**
     * <p>Converts a text string to bytes and writes the bytes to an output data
     * stream. When reading the string, any unpaired surrogate characters are
     * replaced with the replacement character (U+FFFD), and when writing to the
     * byte stream, any characters that can't be encoded are replaced with the byte
     * 0x3f (the question mark character). </p><p>In the.NET implementation, this
     * method is implemented as an extension method to any string object and can be
     * called as follows: {@code str.EncodeToBytes(enc, writer)}. If the object's
     * class already has a EncodeToBytes method with the same parameters, that
     * method takes precedence over this extension method.</p> <p>In the.NET
     * implementation, this method is implemented as an extension method to any
     * object implementing string and can be called as follows: {@code
     * str.EncodeToWriter(enc, output)}. If the object's class already has a {@code
     * EncodeToWriter} method with the same parameters, that method takes
     * precedence over this extension method.</p>
     * @param str A text string to encode.
     * @param enc An object implementing a character encoding (gives access to an
     * encoder and a decoder).
     * @param output A writable data stream.
     * @throws NullPointerException The parameter {@code str} or {@code enc} is
     * null.
     */
    public static void EncodeToWriter(
      String str,
      ICharacterEncoding enc,
      OutputStream output) throws java.io.IOException {
      if (str == null) {
        throw new NullPointerException("str");
      }
      if (enc == null) {
        throw new NullPointerException("enc");
      }
      EncodeToWriter(
        new CharacterReader(str),
        enc,
        DataIO.ToWriter(output));
    }

    /**
     * <p>Converts a character encoding into a character input stream, given a
     * streamable source of bytes. The input stream doesn't check the first few
     * bytes for a byte-order mark indicating a Unicode encoding such as UTF-8
     * before using the character encoding's decoder. </p> <p>In the.NET
     * implementation, this method is implemented as an extension method to any
     * object implementing ICharacterEncoding and can be called as follows:
     * "encoding.GetDecoderInput(input)". If the object's class already has a
     * GetDecoderInput method with the same parameters, that method takes
     * precedence over this extension method.</p>
     * @param encoding Encoding that exposes a decoder to be converted into a
     * character input stream. If the decoder returns -2 (indicating a decode
     * error), the character input stream handles the error by returning a
     * replacement character in its place.
     * @param stream Byte stream to convert into Unicode characters.
     * @return An ICharacterInput object.
     * @throws NullPointerException The parameter {@code encoding} is null.
     */
    public static ICharacterInput GetDecoderInput(
      ICharacterEncoding encoding,
      IByteReader stream) {
      if (encoding == null) {
        throw new NullPointerException("encoding");
      }

      return new DecoderToInputClass(encoding.GetDecoder(),
        stream);
    }

    /**
     * <p>Converts a character encoding into a character input stream, given a data
     * stream. The input stream doesn't check the first few bytes for a byte-order
     * mark indicating a Unicode encoding such as UTF-8 before using the character
     * encoding's decoder. </p><p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing
     * ICharacterEncoding and can be called as follows: {@code
     * encoding.GetDecoderInput(input)}. If the object's class already has a
     * GetDecoderInput method with the same parameters, that method takes
     * precedence over this extension method.</p> <p>In the.NET implementation,
     * this method is implemented as an extension method to any object implementing
     * ICharacterEncoding and can be called as follows: {@code
     * encoding.GetDecoderInput(input)}. If the object's class already has a {@code
     * GetDecoderInput} method with the same parameters, that method takes
     * precedence over this extension method.</p>
     * @param encoding Encoding object that exposes a decoder to be converted into
     * a character input stream. If the decoder returns -2 (indicating a decode
     * error), the character input stream handles the error by returning a
     * replacement character in its place.
     * @param input Byte stream to convert into Unicode characters.
     * @return An ICharacterInput object.
     * @throws NullPointerException The parameter {@code encoding} is null.
     */
    public static ICharacterInput GetDecoderInput(
      ICharacterEncoding encoding,
      InputStream input) {
      if (
        encoding == null) {
        throw new NullPointerException("encoding");
      }
      return new DecoderToInputClass(
          encoding.GetDecoder(),
          DataIO.ToReader(input));
    }

    /**
     * <p>Converts a character encoding into a character input stream, given a
     * streamable source of bytes. But if the input stream starts with a UTF-8 or
     * UTF-16 byte order mark, the input is decoded as UTF-8 or UTF-16, as the case
     * may be, rather than the specified character encoding. </p><p>This method
     * implements the "decode" algorithm specified in the Encoding standard.</p>
     * <p>In the.NET implementation, this method is implemented as an extension
     * method to any object implementing ICharacterEncoding and can be called as
     * follows: {@code encoding.GetDecoderInputSkipBom(input)}. If the object's
     * class already has a {@code GetDecoderInputSkipBom} method with the same
     * parameters, that method takes precedence over this extension method.</p>
     * @param encoding Encoding object that exposes a decoder to be converted into
     * a character input stream. If the decoder returns -2 (indicating a decode
     * error), the character input stream handles the error by returning a
     * replacement character in its place.
     * @param stream Byte stream to convert into Unicode characters.
     * @return An ICharacterInput object.
     */
    public static ICharacterInput GetDecoderInputSkipBom(
      ICharacterEncoding encoding,
      IByteReader stream) {
      return EncoderAlgorithms.DecodeAlgorithmInput(stream, encoding);
    }

    /**
     * <p>Converts a character encoding into a character input stream, given a
     * readable data stream. But if the input stream starts with a UTF-8 or UTF-16
     * byte order mark, the input is decoded as UTF-8 or UTF-16, as the case may
     * be, rather than the specified character encoding.This method implements the
     * "decode" algorithm specified in the Encoding standard. </p> <p>In the.NET
     * implementation, this method is implemented as an extension method to any
     * object implementing ICharacterEncoding and can be called as follows: {@code
     * encoding.GetDecoderInputSkipBom(input)}. If the object's class already has a
     * {@code GetDecoderInputSkipBom} method with the same parameters, that method
     * takes precedence over this extension method.</p>
     * @param encoding Encoding object that exposes a decoder to be converted into
     * a character input stream. If the decoder returns -2 (indicating a decode
     * error), the character input stream handles the error by returning a
     * replacement character in its place.
     * @param input Byte stream to convert into Unicode characters.
     * @return An ICharacterInput object.
     */
    public static ICharacterInput GetDecoderInputSkipBom(
      ICharacterEncoding encoding,
      InputStream input) {
      return EncoderAlgorithms.DecodeAlgorithmInput(
          DataIO.ToReader(input),
          encoding);
    }

    /**
     * Returns a character encoding from the specified name.
     * @param name A string naming a character encoding. See the ResolveAlias
     * method. Can be null.
     * @return An object implementing a character encoding (gives access to an
     * encoder and a decoder).
     */
    public static ICharacterEncoding GetEncoding(String name) {
      return GetEncoding(name, false, true);
    }

    /**
     * Returns a character encoding from the specified name.
     * @param name A string naming a character encoding. See the ResolveAlias
     * method. Can be null.
     * @param forEmail If false, uses the encoding resolution rules in the Encoding
     * Standard. If true, uses modified rules as described in the
     * ResolveAliasForEmail method.
     * @param allowReplacement Has no effect.
     * @return An object that enables encoding and decoding text in the specified
     * character encoding. Returns null if the name is null or empty, or if it
     * names an unrecognized or unsupported encoding.
     */
    public static ICharacterEncoding GetEncoding(
      String name,
      boolean forEmail,
      boolean allowReplacement) {
      return (!allowReplacement && name != null &&
          ToLowerCaseAscii(name).equals("replacement")) ? null : GetEncoding(name, forEmail);
    }

    /**
     * Returns a character encoding from the specified name.
     * @param name A string naming a character encoding. See the ResolveAlias
     * method. Can be null.
     * @param forEmail If false, uses the encoding resolution rules in the Encoding
     * Standard. If true, uses modified rules as described in the
     * ResolveAliasForEmail method. If the resolved encoding is "GB18030" or "GBK"
     * (in any combination of case), uses either an encoding intended to conform to
     * the 2022 version of GB18030 if 'forEmail' is true, or the definition of the
     * encoding in the WHATWG Encoding Standard (as of July 7, 2023) if 'forEmail'
     * is false.
     * @return An object that enables encoding and decoding text in the specified
     * character encoding. Returns null if the name is null or empty, or if it
     * names an unrecognized or unsupported encoding.
     */
    public static ICharacterEncoding GetEncoding(
      String name,
      boolean forEmail) {
      if (((name) == null || (name).length() == 0)) {
        return null;
      }
      name = forEmail ? ResolveAliasForEmail(name) :
        ResolveAlias(name);
      if (name.equals("UTF-8")) {
        return UTF8;
      }
      if (name.equals("US-ASCII")) {
        return (ICharacterEncoding)new EncodingAscii();
      }
      if (name.equals("ISO-8859-1")) {
        return (ICharacterEncoding)new EncodingLatinOne();
      }
      if (name.equals("UTF-7")) {
        return (ICharacterEncoding)new EncodingUtf7();
      }
      if (name.equals("windows-1252")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129,
          8218,
          402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143,
          144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250,
          339, 157, 382, 376, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169,
          170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183,
          184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197,
          198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211,
          212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225,
          226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239,
          240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253,
          254, 255,
        });
      }
      if (name.equals("windows-1253")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129,
          8218,
          402, 8222, 8230, 8224, 8225, 136, 8240, 138, 8249, 140, 141, 142, 143,
          144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 152, 8482, 154, 8250,
          156, 157, 158, 159, 160, 901, 902, 163, 164, 165, 166, 167, 168, 169,
          -2, 171, 172, 173, 174, 8213, 176, 177, 178, 179, 900, 181, 182, 183,
          904, 905, 906, 187, 908, 189, 910, 911, 912, 913, 914, 915, 916, 917,
          918, 919, 920, 921, 922, 923, 924, 925, 926, 927, 928, 929, -2, 931,
          932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945,
          946, 947, 948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959,
          960, 961, 962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973,
          974, -2,
        });
      }
      if (name.equals("ISO-8859-15")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
          131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
          145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
          159, 160, 161, 162, 163, 8364, 165, 352, 167, 353, 169, 170, 171, 172,
          173, 174, 175, 176, 177, 178, 179, 381, 181, 182, 183, 382, 185, 186,
          187, 338, 339, 376, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200,
          201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214,
          215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228,
          229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242,
          243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255,
        });
      }
      if (name.equals("ISO-8859-3")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
          131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
          145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
          159, 160, 294, 728, 163, 164, -2, 292, 167, 168, 304, 350, 286, 308,
          173, -2, 379, 176, 295, 178, 179, 180, 181, 293, 183, 184, 305, 351,
          287, 309, 189, -2, 380, 192, 193, 194, -2, 196, 266, 264, 199,
          200, 201,
          202, 203, 204, 205, 206, 207, -2, 209, 210, 211, 212, 288, 214, 215,
          284, 217, 218, 219, 220, 364, 348, 223, 224, 225, 226, -2, 228, 267,
          265, 231, 232, 233, 234, 235, 236, 237, 238, 239, -2, 241, 242, 243,
          244, 289, 246, 247, 285, 249, 250, 251, 252, 365, 349, 729,
        });
      }
      if (name.equals("windows-1258")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129,
          8218,
          402, 8222, 8230, 8224, 8225, 710, 8240, 138, 8249, 338, 141, 142, 143,
          144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 154, 8250,
          339, 157, 158, 376, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169,
          170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183,
          184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 258, 196, 197,
          198, 199, 200, 201, 202, 203, 768, 205, 206, 207, 272, 209, 777, 211,
          212, 416, 214, 215, 216, 217, 218, 219, 220, 431, 771, 223, 224, 225,
          226, 259, 228, 229, 230, 231, 232, 233, 234, 235, 769, 237, 238, 239,
          273, 241, 803, 243, 244, 417, 246, 247, 248, 249, 250, 251, 252, 432,
          8363, 255,
        });
      }
      if (name.equals("ISO-8859-2")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
          131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
          145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
          159, 160, 260, 728, 321, 164, 317, 346, 167, 168, 352, 350, 356, 377,
          173, 381, 379, 176, 261, 731, 322, 180, 318, 347, 711, 184, 353, 351,
          357, 378, 733, 382, 380, 340, 193, 194, 258, 196, 313, 262, 199, 268,
          201, 280, 203, 282, 205, 206, 270, 272, 323, 327, 211, 212, 336, 214,
          215, 344, 366, 218, 368, 220, 221, 354, 223, 341, 225, 226, 259, 228,
          314, 263, 231, 269, 233, 281, 235, 283, 237, 238, 271, 273, 324, 328,
          243, 244, 337, 246, 247, 345, 367, 250, 369, 252, 253, 355, 729,
        });
      }
      if (name.equals("ISO-8859-5")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
          131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
          145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
          159, 160, 1025, 1026, 1027, 1028, 1029, 1030, 1031, 1032, 1033, 1034,
          1035, 1036, 173, 1038, 1039, 1040, 1041, 1042, 1043, 1044, 1045, 1046,
          1047, 1048, 1049, 1050, 1051, 1052, 1053, 1054, 1055, 1056, 1057,
          1058,
          1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068, 1069,
          1070,
          1071, 1072, 1073, 1074, 1075, 1076, 1077, 1078, 1079, 1080, 1081,
          1082,
          1083, 1084, 1085, 1086, 1087, 1088, 1089, 1090, 1091, 1092, 1093,
          1094,
          1095, 1096, 1097, 1098, 1099, 1100, 1101, 1102, 1103, 8470, 1105,
          1106,
          1107, 1108, 1109, 1110, 1111, 1112, 1113, 1114, 1115, 1116, 167, 1118,
          1119,
        });
      }
      if (name.equals("windows-874") ||
        name.equals("TIS-620")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129,
          130,
          131, 132, 8230, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
          8216, 8217, 8220, 8221, 8226, 8211, 8212, 152, 153, 154, 155, 156,
          157,
          158, 159, 160, 3585, 3586, 3587, 3588, 3589, 3590, 3591, 3592, 3593,
          3594, 3595, 3596, 3597, 3598, 3599, 3600, 3601, 3602, 3603, 3604,
          3605,
          3606, 3607, 3608, 3609, 3610, 3611, 3612, 3613, 3614, 3615, 3616,
          3617,
          3618, 3619, 3620, 3621, 3622, 3623, 3624, 3625, 3626, 3627, 3628,
          3629,
          3630, 3631, 3632, 3633, 3634, 3635, 3636, 3637, 3638, 3639, 3640,
          3641,
          3642, -2, -2, -2, -2, 3647, 3648, 3649, 3650, 3651, 3652, 3653, 3654,
          3655, 3656, 3657, 3658, 3659, 3660, 3661, 3662, 3663, 3664, 3665,
          3666,
          3667, 3668, 3669, 3670, 3671, 3672, 3673, 3674, 3675, -2, -2, -2, -2,
        });
      }
      if (name.equals("macintosh")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 196, 197, 199,
          201, 209, 214, 220, 225, 224, 226, 228, 227, 229, 231, 233, 232, 234,
          235, 237, 236, 238, 239, 241, 243, 242, 244, 246, 245, 250, 249, 251,
          252, 8224, 176, 162, 163, 167, 8226, 182, 223, 174, 169, 8482,
          180, 168,
          8800, 198, 216, 8734, 177, 8804, 8805, 165, 181, 8706, 8721, 8719,
          960,
          8747, 170, 186, 937, 230, 248, 191, 161, 172, 8730, 402, 8776, 8710,
          171, 187, 8230, 160, 192, 195, 213, 338, 339, 8211, 8212, 8220, 8221,
          8216, 8217, 247, 9674, 255, 376, 8260, 8364, 8249, 8250, 64257, 64258,
          8225, 183, 8218, 8222, 8240, 194, 202, 193, 203, 200, 205, 206, 207,
          204, 211, 212, 63743, 210, 218, 219, 217, 305, 710, 732, 175, 728,
          729,
          730, 184, 733, 731, 711,
        });
      }
      if (name.equals("ISO-8859-10")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
          131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
          145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
          159, 160, 260, 274, 290, 298, 296, 310, 167, 315, 272, 352, 358, 381,
          173, 362, 330, 176, 261, 275, 291, 299, 297, 311, 183, 316, 273, 353,
          359, 382, 8213, 363, 331, 256, 193, 194, 195, 196, 197, 198, 302, 268,
          201, 280, 203, 278, 205, 206, 207, 208, 325, 332, 211, 212, 213, 214,
          360, 216, 370, 218, 219, 220, 221, 222, 223, 257, 225, 226, 227, 228,
          229, 230, 303, 269, 233, 281, 235, 279, 237, 238, 239, 240, 326, 333,
          243, 244, 245, 246, 361, 248, 371, 250, 251, 252, 253, 254, 312,
        });
      }
      if (name.equals("windows-1257")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129,
          8218,
          131, 8222, 8230, 8224, 8225, 136, 8240, 138, 8249, 140, 168, 711, 184,
          144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 152, 8482, 154, 8250,
          156, 175, 731, 159, 160, -2, 162, 163, 164, -2, 166, 167, 216, 169,
          342,
          171, 172, 173, 174, 198, 176, 177, 178, 179, 180, 181, 182, 183, 248,
          185, 343, 187, 188, 189, 190, 230, 260, 302, 256, 262, 196, 197, 280,
          274, 268, 201, 377, 278, 290, 310, 298, 315, 352, 323, 325, 211, 332,
          213, 214, 215, 370, 321, 346, 362, 220, 379, 381, 223, 261, 303, 257,
          263, 228, 229, 281, 275, 269, 233, 378, 279, 291, 311, 299, 316, 353,
          324, 326, 243, 333, 245, 246, 247, 371, 322, 347, 363, 252, 380, 382,
          729,
        });
      }
      if (name.equals("windows-1250")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129,
          8218,
          131, 8222, 8230, 8224, 8225, 136, 8240, 352, 8249, 346, 356, 381, 377,
          144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 152, 8482, 353, 8250,
          347, 357, 382, 378, 160, 711, 728, 321, 164, 260, 166, 167, 168, 169,
          350, 171, 172, 173, 174, 379, 176, 177, 731, 322, 180, 181, 182, 183,
          184, 261, 351, 187, 317, 733, 318, 380, 340, 193, 194, 258, 196, 313,
          262, 199, 268, 201, 280, 203, 282, 205, 206, 270, 272, 323, 327, 211,
          212, 336, 214, 215, 344, 366, 218, 368, 220, 221, 354, 223, 341, 225,
          226, 259, 228, 314, 263, 231, 269, 233, 281, 235, 283, 237, 238, 271,
          273, 324, 328, 243, 244, 337, 246, 247, 345, 367, 250, 369, 252, 253,
          355, 729,
        });
      }
      if (name.equals("ISO-8859-14")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
          131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
          145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
          159, 160, 7682, 7683, 163, 266, 267, 7690, 167, 7808, 169, 7810, 7691,
          7922, 173, 174, 376, 7710, 7711, 288, 289, 7744, 7745, 182, 7766,
          7809,
          7767, 7811, 7776, 7923, 7812, 7813, 7777, 192, 193, 194, 195, 196,
          197,
          198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 372, 209, 210, 211,
          212, 213, 214, 7786, 216, 217, 218, 219, 220, 221, 374, 223, 224, 225,
          226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239,
          373, 241, 242, 243, 244, 245, 246, 7787, 248, 249, 250, 251, 252, 253,
          375, 255,
        });
      }
      if (name.equals("ISO-8859-4")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
          131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
          145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
          159, 160, 260, 312, 342, 164, 296, 315, 167, 168, 352, 274, 290, 358,
          173, 381, 175, 176, 261, 731, 343, 180, 297, 316, 711, 184, 353, 275,
          291, 359, 330, 382, 331, 256, 193, 194, 195, 196, 197, 198, 302, 268,
          201, 280, 203, 278, 205, 206, 298, 272, 325, 332, 310, 212, 213, 214,
          215, 216, 370, 218, 219, 220, 360, 362, 223, 257, 225, 226, 227, 228,
          229, 230, 303, 269, 233, 281, 235, 279, 237, 238, 299, 273, 326, 333,
          311, 244, 245, 246, 247, 248, 371, 250, 251, 252, 361, 363, 729,
        });
      }
      if (name.equals("ISO-8859-8") ||
        name.equals("ISO-8859-8-I")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
          131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
          145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
          159, 160, -2, 162, 163, 164, 165, 166, 167, 168, 169, 215, 171, 172,
          173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 247,
          187, 188, 189, 190, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
          -2, -2,
          -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
          -2, -2,
          -2, 8215, 1488, 1489, 1490, 1491, 1492, 1493, 1494, 1495, 1496, 1497,
          1498, 1499, 1500, 1501, 1502, 1503, 1504, 1505, 1506, 1507, 1508,
          1509,
          1510, 1511, 1512, 1513, 1514, -2, -2, 8206, 8207, -2,
        });
      }
      if (name.equals("KOI8-R")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 9472, 9474,
          9484, 9488, 9492, 9496, 9500, 9508, 9516, 9524, 9532, 9600, 9604,
          9608,
          9612, 9616, 9617, 9618, 9619, 8992, 9632, 8729, 8730, 8776, 8804,
          8805,
          160, 8993, 176, 178, 183, 247, 9552, 9553, 9554, 1105, 9555, 9556,
          9557,
          9558, 9559, 9560, 9561, 9562, 9563, 9564, 9565, 9566, 9567, 9568,
          9569,
          1025, 9570, 9571, 9572, 9573, 9574, 9575, 9576, 9577, 9578, 9579,
          9580,
          169, 1102, 1072, 1073, 1094, 1076, 1077, 1092, 1075, 1093, 1080, 1081,
          1082, 1083, 1084, 1085, 1086, 1087, 1103, 1088, 1089, 1090, 1091,
          1078,
          1074, 1100, 1099, 1079, 1096, 1101, 1097, 1095, 1098, 1070, 1040,
          1041,
          1062, 1044, 1045, 1060, 1043, 1061, 1048, 1049, 1050, 1051, 1052,
          1053,
          1054, 1055, 1071, 1056, 1057, 1058, 1059, 1046, 1042, 1068, 1067,
          1047,
          1064, 1069, 1065, 1063, 1066,
        });
      }
      if (name.equals("ISO-8859-6")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
          131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
          145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
          159, 160, -2, -2, -2, 164, -2, -2, -2, -2, -2, -2, -2, 1548, 173, -2,
          -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, 1563, -2, -2, -2,
          1567,
          -2, 1569, 1570, 1571, 1572, 1573, 1574, 1575, 1576, 1577, 1578, 1579,
          1580, 1581, 1582, 1583, 1584, 1585, 1586, 1587, 1588, 1589, 1590,
          1591,
          1592, 1593, 1594, -2, -2, -2, -2, -2, 1600, 1601, 1602, 1603, 1604,
          1605, 1606, 1607, 1608, 1609, 1610, 1611, 1612, 1613, 1614, 1615,
          1616,
          1617, 1618, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
        });
      }
      if (name.equals("windows-1254")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129,
          8218,
          402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 142, 143,
          144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250,
          339, 157, 158, 376, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169,
          170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183,
          184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197,
          198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 286, 209, 210, 211,
          212, 213, 214, 215, 216, 217, 218, 219, 220, 304, 350, 223, 224, 225,
          226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239,
          287, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 305,
          351, 255,
        });
      }
      if (name.equals("windows-1255")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 129,
          8218,
          402, 8222, 8230, 8224, 8225, 710, 8240, 138, 8249, 140, 141, 142, 143,
          144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 154, 8250,
          156, 157, 158, 159, 160, 161, 162, 163, 8362, 165, 166, 167, 168, 169,
          215, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183,
          184, 185, 247, 187, 188, 189, 190, 191, 1456, 1457, 1458, 1459, 1460,
          1461, 1462, 1463, 1464, 1465, 1466, 1467, 1468, 1469, 1470, 1471,
          1472,
          1473, 1474, 1475, 1520, 1521, 1522, 1523, 1524, -2, -2, -2, -2, -2,
          -2,
          -2, 1488, 1489, 1490, 1491, 1492, 1493, 1494, 1495, 1496, 1497, 1498,
          1499, 1500, 1501, 1502, 1503, 1504, 1505, 1506, 1507, 1508, 1509,
          1510,
          1511, 1512, 1513, 1514, -2, -2, 8206, 8207, -2,
        });
      }
      if (name.equals("ISO-8859-16")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
          131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
          145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
          159, 160, 260, 261, 321, 8364, 8222, 352, 167, 353, 169, 536, 171,
          377,
          173, 378, 379, 176, 177, 268, 322, 381, 8221, 182, 183, 382, 269, 537,
          187, 338, 339, 376, 380, 192, 193, 194, 258, 196, 262, 198, 199, 200,
          201, 202, 203, 204, 205, 206, 207, 272, 323, 210, 211, 212, 336, 214,
          346, 368, 217, 218, 219, 220, 280, 538, 223, 224, 225, 226, 259, 228,
          263, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 273, 324, 242,
          243, 244, 337, 246, 347, 369, 249, 250, 251, 252, 281, 539, 255,
        });
      }
      if (name.equals("IBM866")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 1040, 1041,
          1042, 1043, 1044, 1045, 1046, 1047, 1048, 1049, 1050, 1051, 1052,
          1053,
          1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064,
          1065,
          1066, 1067, 1068, 1069, 1070, 1071, 1072, 1073, 1074, 1075, 1076,
          1077,
          1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085, 1086, 1087, 9617,
          9618,
          9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565,
          9564,
          9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562,
          9556,
          9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560,
          9554,
          9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 1088,
          1089,
          1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097, 1098, 1099, 1100,
          1101,
          1102, 1103, 1025, 1105, 1028, 1108, 1031, 1111, 1038, 1118, 176, 8729,
          183, 8730, 8470, 164, 9632, 160,
        });
      }
      if (name.equals("x-mac-cyrillic")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 1040, 1041,
          1042, 1043, 1044, 1045, 1046, 1047, 1048, 1049, 1050, 1051, 1052,
          1053,
          1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064,
          1065,
          1066, 1067, 1068, 1069, 1070, 1071, 8224, 176, 1168, 163, 167, 8226,
          182, 1030, 174, 169, 8482, 1026, 1106, 8800, 1027, 1107, 8734, 177,
          8804, 8805, 1110, 181, 1169, 1032, 1028, 1108, 1031, 1111, 1033, 1113,
          1034, 1114, 1112, 1029, 172, 8730, 402, 8776, 8710, 171, 187,
          8230, 160,
          1035, 1115, 1036, 1116, 1109, 8211, 8212, 8220, 8221, 8216, 8217, 247,
          8222, 1038, 1118, 1039, 1119, 8470, 1025, 1105, 1103, 1072, 1073,
          1074,
          1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085,
          1086,
          1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097,
          1098,
          1099, 1100, 1101, 1102, 8364,
        });
      }
      if (name.equals("windows-1251")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 1026, 1027,
          8218, 1107, 8222, 8230, 8224, 8225, 8364, 8240, 1033, 8249, 1034,
          1036,
          1035, 1039, 1106, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 152, 8482,
          1113, 8250, 1114, 1116, 1115, 1119, 160, 1038, 1118, 1032, 164, 1168,
          166, 167, 1025, 169, 1028, 171, 172, 173, 174, 1031, 176, 177, 1030,
          1110, 1169, 181, 182, 183, 1105, 8470, 1108, 187, 1112, 1029, 1109,
          1111, 1040, 1041, 1042, 1043, 1044, 1045, 1046, 1047, 1048, 1049,
          1050,
          1051, 1052, 1053, 1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061,
          1062,
          1063, 1064, 1065, 1066, 1067, 1068, 1069, 1070, 1071, 1072, 1073,
          1074,
          1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085,
          1086,
          1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097,
          1098,
          1099, 1100, 1101, 1102, 1103,
        });
      }
      if (name.equals("windows-1256")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 8364, 1662,
          8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 1657, 8249, 338, 1670,
          1688, 1672, 1711, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 1705,
          8482,
          1681, 8250, 339, 8204, 8205, 1722, 160, 1548, 162, 163, 164, 165, 166,
          167, 168, 169, 1726, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180,
          181, 182, 183, 184, 185, 1563, 187, 188, 189, 190, 1567, 1729, 1569,
          1570, 1571, 1572, 1573, 1574, 1575, 1576, 1577, 1578, 1579, 1580,
          1581,
          1582, 1583, 1584, 1585, 1586, 1587, 1588, 1589, 1590, 215, 1591, 1592,
          1593, 1594, 1600, 1601, 1602, 1603, 224, 1604, 226, 1605, 1606, 1607,
          1608, 231, 232, 233, 234, 235, 1609, 1610, 238, 239, 1611, 1612, 1613,
          1614, 244, 1615, 1616, 247, 1617, 249, 1618, 251, 252, 8206, 8207,
          1746,
        });
      }
      if (name.equals("KOI8-U")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 9472, 9474,
          9484, 9488, 9492, 9496, 9500, 9508, 9516, 9524, 9532, 9600, 9604,
          9608,
          9612, 9616, 9617, 9618, 9619, 8992, 9632, 8729, 8730, 8776, 8804,
          8805,
          160, 8993, 176, 178, 183, 247, 9552, 9553, 9554, 1105, 1108, 9556,
          1110,
          1111, 9559, 9560, 9561, 9562, 9563, 1169, 1118, 9566, 9567, 9568,
          9569,
          1025, 1028, 9571, 1030, 1031, 9574, 9575, 9576, 9577, 9578, 1168,
          1038,
          169, 1102, 1072, 1073, 1094, 1076, 1077, 1092, 1075, 1093, 1080, 1081,
          1082, 1083, 1084, 1085, 1086, 1087, 1103, 1088, 1089, 1090, 1091,
          1078,
          1074, 1100, 1099, 1079, 1096, 1101, 1097, 1095, 1098, 1070, 1040,
          1041,
          1062, 1044, 1045, 1060, 1043, 1061, 1048, 1049, 1050, 1051, 1052,
          1053,
          1054, 1055, 1071, 1056, 1057, 1058, 1059, 1046, 1042, 1068, 1067,
          1047,
          1064, 1069, 1065, 1063, 1066,
        });
      }
      if (name.equals("ISO-8859-7")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
          131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
          145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
          159, 160, 8216, 8217, 163, 8364, 8367, 166, 167, 168, 169, 890, 171,
          172, 173, -2, 8213, 176, 177, 178, 179, 900, 901, 902, 183, 904, 905,
          906, 187, 908, 189, 910, 911, 912, 913, 914, 915, 916, 917, 918, 919,
          920, 921, 922, 923, 924, 925, 926, 927, 928, 929, -2, 931, 932, 933,
          934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 947,
          948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959, 960, 961,
          962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, -2,
        });
      }
      if (name.equals("ISO-8859-13")) {
        return (ICharacterEncoding)new EncodingSingleByte(new int[] { 128, 129, 130,
          131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144,
          145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158,
          159, 160, 8221, 162, 163, 164, 8222, 166, 167, 216, 169, 342, 171,
          172,
          173, 174, 198, 176, 177, 178, 179, 8220, 181, 182, 183, 248, 185, 343,
          187, 188, 189, 190, 230, 260, 302, 256, 262, 196, 197, 280, 274, 268,
          201, 377, 278, 290, 310, 298, 315, 352, 323, 325, 211, 332, 213, 214,
          215, 370, 321, 346, 362, 220, 379, 381, 223, 261, 303, 257, 263, 228,
          229, 281, 275, 269, 233, 378, 279, 291, 311, 299, 316, 353, 324, 326,
          243, 333, 245, 246, 247, 371, 322, 347, 363, 252, 380, 382, 8217,
        });
      } else if (name.equals("EUC-JP")) {
        return (ICharacterEncoding)new EncodingEUCJP();
      } else if (name.equals("EUC-KR")) {
        return (ICharacterEncoding)new EncodingKoreanEUC();
      } else if (name.equals("Big5")) {
        return (ICharacterEncoding)new EncodingBig5();
      } else if (name.equals("Shift_JIS")) {
        return (ICharacterEncoding)new EncodingShiftJIS();
      } else if (name.equals("x-user-defined")) {
        return (ICharacterEncoding)new EncodingXUserDefined();
      } else if (name.equals("GBK")) {
        return forEmail ? (ICharacterEncoding)new EncodingGBK2() :
          (ICharacterEncoding)new EncodingGBK();
      } else if (name.equals("GB2312") ||
        name.equals("gb2312")) {
        return forEmail ? (ICharacterEncoding)new EncodingGBK2() :
          (ICharacterEncoding)new EncodingGBK();
      } else if (name.equals("gb18030") ||
        name.equals("GB18030")) {
        return forEmail ? (ICharacterEncoding)new EncodingGB180302() :
          (ICharacterEncoding)new EncodingGB18030();
      } else if (name.equals("UTF-16")) {
        return (ICharacterEncoding)new EncodingUtf16();
      } else if (name.equals("UTF-16LE")) {
        return (ICharacterEncoding)new EncodingUtf16LE();
      } else if (name.equals("UTF-16BE")) {
        return (ICharacterEncoding)new EncodingUtf16BE();
      } else if (name.equals("ISO-2022-JP-2")) {
        return (ICharacterEncoding)new EncodingISO2022JP2();
      } else if (name.equals("ISO-2022-KR")) {
        return (ICharacterEncoding)new EncodingISO2022KR();
      }
      return name.equals("ISO-2022-JP") ?
        (ICharacterEncoding)new EncodingISO2022JP() :
        (name.equals("replacement") ?

        (ICharacterEncoding)new EncodingReplacement() : null);
    }

    /**
     * <p>Reads Unicode characters from a character input and converts them to a
     * text string. </p> <p>In the.NET implementation, this method is implemented
     * as an extension method to any object implementing ICharacterInput and can be
     * called as follows: {@code reader.InputToString()}. If the object's class
     * already has a InputToString method with the same parameters, that method
     * takes precedence over this extension method.</p>
     * @param reader A character input whose characters will be converted to a text
     * string.
     * @return A text string containing the characters read.
     * @throws NullPointerException The parameter {@code reader} is null.
     */
    public static String InputToString(
       ICharacterInput reader) {
      StringBuilder builder = new StringBuilder();
      while (true) {
        if (reader == null) {
          throw new NullPointerException("reader");
        }
        int c = reader.ReadChar();
        if (c < 0) {
          break;
        }
        if (c <= 0xffff) {
          builder.append((char)c);
        } else if (c <= 0x10ffff) {
          builder.append((char)((((c - 0x10000) >> 10) & 0x3ff) | 0xd800));
          builder.append((char)(((c - 0x10000) & 0x3ff) | 0xdc00));
        }
      }
      return builder.toString();
    }

    /**
     * <p>Resolves a character encoding's name to a standard form. This involves
     * changing aliases of a character encoding to a standardized name. </p> <p>In
     * several Internet specifications, this name is known as a "charset"
     * parameter. In HTML and HTTP, for example, the "charset" parameter indicates
     * the encoding used to represent text in the HTML page, text file, or other
     * document.</p>
     * @param name <p>A string that names a given character encoding. Can be null.
     * Any leading and trailing whitespace (U+0009, U+000c, U+000D, U+000A, U+0010)
     * is removed before resolving the encoding's name, and encoding names are
     * matched using a basic case-insensitive comparison. (Two strings are equal in
     * such a comparison, if they match after converting the basic uppercase
     * letters A to Z (U+0041 to U+005A) in both strings to basic lowercase
     * letters.) The Encoding Standard supports only the following encodings (and
     * defines aliases for most of them). </p><ul> <li> {@code UTF-8} - UTF-8 (8-bit
     * encoding of the universal coded character set, the encoding recommended by
     * the Encoding Standard for new data formats)</li><li> {@code UTF-16LE} -
     * UTF-16 little-endian (16-bit UCS)</li><li> {@code UTF-16BE} - UTF-16
     * big-endian (16-bit UCS)</li><li>The special-purpose encoding {@code
     * x-user-defined}</li><li>The special-purpose encoding {@code
     * replacement}.</li><li>28 legacy single-byte encodings: <ul> <li> {@code
     * windows-1252} : Western Europe (Note: The Encoding Standard aliases the
     * names {@code US-ASCII} and {@code ISO-8859-1} to {@code windows-1252}, which
     * uses a different coded character set from either; it differs from {@code
     * ISO-8859-1} by assigning different characters to some bytes from 0x80 to
     * 0x9F. The Encoding Standard does this for compatibility with existing Web
     * pages.)</li><li> {@code ISO-8859-2}, {@code windows-1250} : Central
     * Europe</li><li> {@code ISO-8859-10} : Northern Europe</li><li> {@code
     * ISO-8859-4}, {@code windows-1257} : Baltic</li><li> {@code ISO-8859-13} :
     * Estonian</li><li> {@code ISO-8859-14} : Celtic</li><li> {@code ISO-8859-16} :
     * Romanian</li><li> {@code ISO-8859-5}, {@code IBM-866}, {@code KOI8-R}, {@code
     * windows-1251}, {@code x-mac-cyrillic} : Cyrillic</li><li> {@code KOI8-U} :
     * Ukrainian</li><li> {@code ISO-8859-7}, {@code windows-1253} :
     * Greek</li><li> {@code ISO-8859-6}, {@code windows-1256} :
     * Arabic</li><li> {@code ISO-8859-8}, {@code ISO-8859-8-I}, {@code
     * windows-1255} : Hebrew</li><li> {@code ISO-8859-3} : Latin 3</li><li> {@code
     * ISO-8859-15}, {@code windows-1254} : Turkish</li><li> {@code windows-874} :
     * Thai</li><li> {@code windows-1258} : Vietnamese</li><li> {@code macintosh} :
     * Mac Roman</li></ul></li><li>Three legacy Japanese encodings: {@code
     * Shift_JIS}, {@code EUC-JP}, {@code ISO-2022-JP}</li><li>Two legacy
     * simplified Chinese encodings: {@code GBK} and {@code gb18030}</li><li> {@code
     * Big5} : legacy traditional Chinese encoding</li><li> {@code EUC-KR} : legacy
     * Korean encoding</li></ul> <p>The {@code UTF-8}, {@code UTF-16LE}, and {@code
     * UTF-16BE} encodings don't encode a byte-order mark at the start of the text
     * (doing so is not recommended for {@code UTF-8}, while in {@code UTF-16LE}
     * and {@code UTF-16BE}, the byte-order mark character U+FEFF is treated as an
     * ordinary character, unlike in the UTF-16 encoding form). The Encoding
     * Standard aliases {@code UTF-16} to {@code UTF-16LE} "to deal with deployed
     * content".</p>.
     * @return A standardized name for the encoding. Returns the empty string if
     * {@code name} is null or empty, or if the encoding name is unsupported.
     */
    public static String ResolveAlias(String name) {
      if (((name) == null || (name).length() == 0)) {
        return "";
      }
      name = TrimAsciiWhite(name);
      name = ToLowerCaseAscii(name);
      return ValueCharsetAliases.containsKey(name) ?
        ValueCharsetAliases.get(name) : "";
    }

    /**
     * Resolves a character encoding's name to a canonical form, using rules more
     * suitable for email.
     * @param name <p>A string naming a character encoding. Can be null. Any
     * leading and trailing whitespace (U+0009, U+000c, U+000D, U+000A, U+0010) is
     * removed before resolving the encoding's name, and encoding names are matched
     * using a basic case-insensitive comparison. (Two strings are equal in such a
     * comparison, if they match after converting the basic uppercase letters A to
     * Z (U+0041 to U+005A) in both strings to basic lowercase letters.) Uses a
     * modified version of the rules in the Encoding Standard to better conform, in
     * some cases, to email standards like MIME. Encoding names and aliases not
     * registered with the Internet Assigned Numbers Authority (IANA) are not
     * supported, with the exception of {@code ascii}, {@code utf8}, {@code
     * cp1252}, and names 10 characters or longer starting with {@code iso-8859-}.
     * Also, the following additional encodings are supported. Note that the case
     * combination {@code GB18030}, the combination registered with IANA, rather
     * than {@code gb18030}, can be returned by this method. </p> <ul> <li> {@code
     * US-ASCII} - ASCII single-byte encoding, rather than an alias to {@code
     * windows-1252} as specified in the Encoding Standard. The coded character
     * set's code points match those in the Unicode Standard's Basic Latin block
     * (0-127 or U+0000 to U+007F). This method name {@code ascii} is treated as an
     * alias to {@code US-ASCII} even though it is not registered with IANA as a
     * charset name and RFC 2046 (part of MIME) reserves the name "ASCII". A future
     * version of this method may stop supporting the alias {@code
     * ascii}.</li><li> {@code ISO-8859-1} - Latin-1 single-byte encoding, rather
     * than an alias to {@code windows-1252} as specified in the Encoding Standard.
     * The coded character set's code points match those in the Unicode Standard's
     * Basic Latin and Latin-1 Supplement blocks (0-255 or U+0000 to
     * U+00FF).</li><li> {@code UTF-16} - UTF-16 without a fixed byte order, rather
     * than an alias to {@code UTF-16LE} as specified in the Encoding Standard. The
     * byte order is little-endian if the byte stream starts with 0xff 0xfe;
     * otherwise, big-endian. A leading 0xff 0xfe or 0xfe 0xff in the byte stream
     * is skipped.</li><li> {@code UTF-7} - UTF-7 (7-bit universal coded character
     * set). The name {@code unicode-1-1-utf-7} is not supported and is not treated
     * as an alias to {@code UTF-7}, even though it uses the same character
     * encoding scheme as UTF-7, because RFC 1642, which defined the former UTF-7,
     * is linked to a different Unicode version with an incompatible character
     * repertoire (notably, the Hangul syllables have different code point
     * assignments in Unicode 1.1 and earlier than in Unicode 2.0 and
     * later).</li><li>{@code ISO-2022-JP-2} - similar to "ISO-2022-JP", except
     * that the decoder supports additional coded character sets.</li></ul>
     * @return A standardized name for the encoding. Returns the empty string if
     * {@code name} is null or empty, or if the encoding name is unsupported.
     */
    public static String ResolveAliasForEmail(String name) {
      if (((name) == null || (name).length() == 0)) {
        return "";
      }
      name = TrimAsciiWhite(name);
      name = ToLowerCaseAscii(name);
      if (name.equals("ascii")) {
        // DEVIATION: "ascii" is not an IANA-registered name,
        // but occurs not rarely
        return "US-ASCII";
      }
      if (EmailAliases.containsKey(name)) {
        return EmailAliases.get(name);
      }
      if (name.length() > 9 && name.substring(0,9).equals("iso-8859-")) {
        // NOTE: For conformance to RFC 2049, treat unknown iso-8859-* encodings
        // as ASCII
        return "US-ASCII";
      }
      return "";
    }

    /**
     * <p>Converts a text string to a byte array encoded in a given character
     * encoding. When reading the string, any unpaired surrogate characters are
     * replaced with the replacement character (U+FFFD), and when writing to the
     * byte array, any characters that can't be encoded are replaced with the byte
     * 0x3f (the question mark character). </p> <p>In the.NET implementation, this
     * method is implemented as an extension method to any object implementing
     * ICharacterEncoding and can be called as follows: {@code
     * encoding.StringToBytes(str)}. If the object's class already has a
     * StringToBytes method with the same parameters, that method takes precedence
     * over this extension method.</p>
     * @param encoding An object that implements a character encoding.
     * @param str A string to be encoded into a byte array.
     * @return A byte array containing the string encoded in the specified text
     * encoding.
     * @throws NullPointerException The parameter {@code encoding} is null.
     */
    public static byte[] StringToBytes(
      ICharacterEncoding encoding,
      String str) {
      if (encoding == null) {
        throw new NullPointerException("encoding");
      }
      return StringToBytes(encoding.GetEncoder(), str);
    }

    /**
     * <p>Converts a text string to a byte array using the specified character
     * encoder. When reading the string, any unpaired surrogate characters are
     * replaced with the replacement character (U+FFFD), and when writing to the
     * byte array, any characters that can't be encoded are replaced with the byte
     * 0x3f (the question mark character). </p><p>In the.NET implementation, this
     * method is implemented as an extension method to any object implementing
     * ICharacterEncoder and can be called as follows: {@code
     * encoder.StringToBytes(str)}. If the object's class already has a
     * StringToBytes method with the same parameters, that method takes precedence
     * over this extension method.</p> <p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing
     * ICharacterEncoder and can be called as follows: {@code
     * encoder.StringToBytes(str)}. If the object's class already has a {@code
     * StringToBytes} method with the same parameters, that method takes precedence
     * over this extension method.</p>
     * @param encoder An object that implements a character encoder.
     * @param str A text string to encode into a byte array.
     * @return A byte array.
     * @throws NullPointerException The parameter {@code encoder} or {@code str}
     * is null.
     */
    public static byte[] StringToBytes(
      ICharacterEncoder encoder,
      String str) {
      if (encoder == null) {
        throw new NullPointerException("encoder");
      }
      if (str == null) {
        throw new NullPointerException("str");
      }
      return EncodeToBytes(
          new CharacterReader(str),
          encoder);
    }

    /**
     * <p>Converts a text string to a character input. The resulting input can then
     * be used to encode the text to bytes, or to read the string code point by
     * code point, among other things. When reading the string, any unpaired
     * surrogate characters are replaced with the replacement character (U+FFFD).
     * </p><p>In the.NET implementation, this method is implemented as an extension
     * method to any string object and can be called as follows: {@code
     * str.StringToInput(offset, length)}. If the object's class already has a
     * StringToInput method with the same parameters, that method takes precedence
     * over this extension method.</p> <p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing string and can
     * be called as follows: {@code str.StringToInput()}. If the object's class
     * already has a {@code StringToInput} method with the same parameters, that
     * method takes precedence over this extension method.</p>
     * @param str The parameter {@code str} is a text string.
     * @return An ICharacterInput object.
     * @throws NullPointerException The parameter {@code str} is null.
     */
    public static ICharacterInput StringToInput(
      String str) {
      if (str == null) {
        throw new NullPointerException("str");
      }
      return StringToInput(str, 0, str.length());
    }

    /**
     * <p>Converts a portion of a text string to a character input. The resulting
     * input can then be used to encode the text to bytes, or to read the string
     * code point by code point, among other things. When reading the string, any
     * unpaired surrogate characters are replaced with the replacement character
     * (U+FFFD). </p><p>In the.NET implementation, this method is implemented as an
     * extension method to any string object and can be called as follows: {@code
     * str.StringToInput(offset, length)}. If the object's class already has a
     * StringToInput method with the same parameters, that method takes precedence
     * over this extension method.</p> <p>In the.NET implementation, this method is
     * implemented as an extension method to any object implementing string and can
     * be called as follows: {@code str.StringToInput(offset, length)}. If the
     * object's class already has a {@code StringToInput} method with the same
     * parameters, that method takes precedence over this extension method.</p>
     * @param str The parameter {@code str} is a text string.
     * @param offset An index starting at 0 showing where the desired portion of
     * {@code str} begins.
     * @param length The length, in code units, of the desired portion of {@code
     * str} (but not more than {@code str} 's length).
     * @return An ICharacterInput object.
     * @throws NullPointerException The parameter {@code str} is null.
     * @throws IllegalArgumentException Either {@code offset} or {@code length} is less
     * than 0 or greater than {@code str} 's length, or {@code str} 's length minus
     * {@code offset} is less than {@code length}.
     * @throws NullPointerException The parameter {@code str} is null.
     */
    public static ICharacterInput StringToInput(
      String str,
      int offset,
      int length) {
      if (str == null) {
        throw new NullPointerException("str");
      }
      if (offset < 0) {
        throw new IllegalArgumentException("offset(" + offset +
          ") is less than 0");
      }
      if (offset > str.length()) {
        throw new IllegalArgumentException("offset(" + offset +
          ") is more than " + str.length());
      }
      if (length < 0) {
        throw new IllegalArgumentException("length(" + length +
          ") is less than 0");
      }
      if (length > str.length()) {
        throw new IllegalArgumentException("length(" + length +
          ") is more than " + str.length());
      }
      if (str.length() - offset < length) {
        throw new IllegalArgumentException("str's length minus " + offset + "(" +
          (str.length() - offset) + ") is less than " + length);
      }
      return new CharacterReader(str, offset, length);
    }

    private static Map<String, String> CreateAliasMap() {
      HashMap<String, String> aliases = new HashMap<String, String>();
      aliases.put("unicode-1-1-utf-8","UTF-8");
      aliases.put("utf-8","UTF-8");
      aliases.put("utf8","UTF-8");
      aliases.put("866","IBM866");
      aliases.put("cp866","IBM866");
      aliases.put("csibm866","IBM866");
      aliases.put("ibm866","IBM866");
      aliases.put("csisolatin2","ISO-8859-2");
      aliases.put("iso-8859-2","ISO-8859-2");
      aliases.put("iso-ir-101","ISO-8859-2");
      aliases.put("iso8859-2","ISO-8859-2");
      aliases.put("iso88592","ISO-8859-2");
      aliases.put("iso_8859-2","ISO-8859-2");
      aliases.put("iso_8859-2:1987","ISO-8859-2");
      aliases.put("l2","ISO-8859-2");
      aliases.put("latin2","ISO-8859-2");
      aliases.put("csisolatin3","ISO-8859-3");
      aliases.put("iso-8859-3","ISO-8859-3");
      aliases.put("iso-ir-109","ISO-8859-3");
      aliases.put("iso8859-3","ISO-8859-3");
      aliases.put("iso88593","ISO-8859-3");
      aliases.put("iso_8859-3","ISO-8859-3");
      aliases.put("iso_8859-3:1988","ISO-8859-3");
      aliases.put("l3","ISO-8859-3");
      aliases.put("latin3","ISO-8859-3");
      aliases.put("csisolatin4","ISO-8859-4");
      aliases.put("iso-8859-4","ISO-8859-4");
      aliases.put("iso-ir-110","ISO-8859-4");
      aliases.put("iso8859-4","ISO-8859-4");
      aliases.put("iso88594","ISO-8859-4");
      aliases.put("iso_8859-4","ISO-8859-4");
      aliases.put("iso_8859-4:1988","ISO-8859-4");
      aliases.put("l4","ISO-8859-4");
      aliases.put("latin4","ISO-8859-4");
      aliases.put("csisolatincyrillic","ISO-8859-5");
      aliases.put("cyrillic","ISO-8859-5");
      aliases.put("iso-8859-5","ISO-8859-5");
      aliases.put("iso-ir-144","ISO-8859-5");
      aliases.put("iso8859-5","ISO-8859-5");
      aliases.put("iso88595","ISO-8859-5");
      aliases.put("iso_8859-5","ISO-8859-5");
      aliases.put("iso_8859-5:1988","ISO-8859-5");
      aliases.put("arabic","ISO-8859-6");
      aliases.put("asmo-708","ISO-8859-6");
      aliases.put("csiso88596e","ISO-8859-6");
      aliases.put("csiso88596i","ISO-8859-6");
      aliases.put("csisolatinarabic","ISO-8859-6");
      aliases.put("ecma-114","ISO-8859-6");
      aliases.put("iso-8859-6","ISO-8859-6");
      aliases.put("iso-8859-6-e","ISO-8859-6");
      aliases.put("iso-8859-6-i","ISO-8859-6");
      aliases.put("iso-ir-127","ISO-8859-6");
      aliases.put("iso8859-6","ISO-8859-6");
      aliases.put("iso88596","ISO-8859-6");
      aliases.put("iso_8859-6","ISO-8859-6");
      aliases.put("iso_8859-6:1987","ISO-8859-6");
      aliases.put("csisolatingreek","ISO-8859-7");
      aliases.put("ecma-118","ISO-8859-7");
      aliases.put("elot_928","ISO-8859-7");
      aliases.put("greek","ISO-8859-7");
      aliases.put("greek8","ISO-8859-7");
      aliases.put("iso-8859-7","ISO-8859-7");
      aliases.put("iso-ir-126","ISO-8859-7");
      aliases.put("iso8859-7","ISO-8859-7");
      aliases.put("iso88597","ISO-8859-7");
      aliases.put("iso_8859-7","ISO-8859-7");
      aliases.put("iso_8859-7:1987","ISO-8859-7");
      aliases.put("sun_eu_greek","ISO-8859-7");
      aliases.put("csiso88598e","ISO-8859-8");
      aliases.put("csisolatinhebrew","ISO-8859-8");
      aliases.put("hebrew","ISO-8859-8");
      aliases.put("iso-8859-8","ISO-8859-8");
      aliases.put("iso-8859-8-e","ISO-8859-8");
      aliases.put("iso-ir-138","ISO-8859-8");
      aliases.put("iso8859-8","ISO-8859-8");
      aliases.put("iso88598","ISO-8859-8");
      aliases.put("iso_8859-8","ISO-8859-8");
      aliases.put("iso_8859-8:1988","ISO-8859-8");
      aliases.put("visual","ISO-8859-8");
      aliases.put("csiso88598i","ISO-8859-8-I");
      aliases.put("iso-8859-8-i","ISO-8859-8-I");
      aliases.put("logical","ISO-8859-8-I");
      aliases.put("csisolatin6","ISO-8859-10");
      aliases.put("iso-8859-10","ISO-8859-10");
      aliases.put("iso-ir-157","ISO-8859-10");
      aliases.put("iso8859-10","ISO-8859-10");
      aliases.put("iso885910","ISO-8859-10");
      aliases.put("l6","ISO-8859-10");
      aliases.put("latin6","ISO-8859-10");
      aliases.put("iso-8859-13","ISO-8859-13");
      aliases.put("iso8859-13","ISO-8859-13");
      aliases.put("iso885913","ISO-8859-13");
      aliases.put("iso-8859-14","ISO-8859-14");
      aliases.put("iso8859-14","ISO-8859-14");
      aliases.put("iso885914","ISO-8859-14");
      aliases.put("csisolatin9","ISO-8859-15");
      aliases.put("iso-8859-15","ISO-8859-15");
      aliases.put("iso8859-15","ISO-8859-15");
      aliases.put("iso885915","ISO-8859-15");
      aliases.put("iso_8859-15","ISO-8859-15");
      aliases.put("l9","ISO-8859-15");
      aliases.put("iso-8859-16","ISO-8859-16");
      aliases.put("cskoi8r","KOI8-R");
      aliases.put("koi","KOI8-R");
      aliases.put("koi8","KOI8-R");
      aliases.put("koi8-r","KOI8-R");
      aliases.put("koi8_r","KOI8-R");
      aliases.put("koi8-ru","KOI8-U");
      aliases.put("koi8-u","KOI8-U");
      aliases.put("csmacintosh","macintosh");
      aliases.put("mac","macintosh");
      aliases.put("macintosh","macintosh");
      aliases.put("x-mac-roman","macintosh");
      aliases.put("dos-874","windows-874");
      aliases.put("iso-8859-11","windows-874");
      aliases.put("iso8859-11","windows-874");
      aliases.put("iso885911","windows-874");
      aliases.put("tis-620","windows-874");
      aliases.put("windows-874","windows-874");
      aliases.put("cp1250","windows-1250");
      aliases.put("windows-1250","windows-1250");
      aliases.put("x-cp1250","windows-1250");
      aliases.put("cp1251","windows-1251");
      aliases.put("windows-1251","windows-1251");
      aliases.put("x-cp1251","windows-1251");
      aliases.put("ansi_x3.4-1968","windows-1252");
      aliases.put("ascii","windows-1252");
      aliases.put("cp1252","windows-1252");
      aliases.put("cp819","windows-1252");
      aliases.put("csisolatin1","windows-1252");
      aliases.put("ibm819","windows-1252");
      aliases.put("iso-8859-1","windows-1252");
      aliases.put("iso-ir-100","windows-1252");
      aliases.put("iso8859-1","windows-1252");
      aliases.put("iso88591","windows-1252");
      aliases.put("iso_8859-1","windows-1252");
      aliases.put("iso_8859-1:1987","windows-1252");
      aliases.put("l1","windows-1252");
      aliases.put("latin1","windows-1252");
      aliases.put("us-ascii","windows-1252");
      aliases.put("windows-1252","windows-1252");
      aliases.put("x-cp1252","windows-1252");
      aliases.put("cp1253","windows-1253");
      aliases.put("windows-1253","windows-1253");
      aliases.put("x-cp1253","windows-1253");
      aliases.put("cp1254","windows-1254");
      aliases.put("csisolatin5","windows-1254");
      aliases.put("iso-8859-9","windows-1254");
      aliases.put("iso-ir-148","windows-1254");
      aliases.put("iso8859-9","windows-1254");
      aliases.put("iso88599","windows-1254");
      aliases.put("iso_8859-9","windows-1254");
      aliases.put("iso_8859-9:1989","windows-1254");
      aliases.put("l5","windows-1254");
      aliases.put("latin5","windows-1254");
      aliases.put("windows-1254","windows-1254");
      aliases.put("x-cp1254","windows-1254");
      aliases.put("cp1255","windows-1255");
      aliases.put("windows-1255","windows-1255");
      aliases.put("x-cp1255","windows-1255");
      aliases.put("cp1256","windows-1256");
      aliases.put("windows-1256","windows-1256");
      aliases.put("x-cp1256","windows-1256");
      aliases.put("cp1257","windows-1257");
      aliases.put("windows-1257","windows-1257");
      aliases.put("x-cp1257","windows-1257");
      aliases.put("cp1258","windows-1258");
      aliases.put("windows-1258","windows-1258");
      aliases.put("x-cp1258","windows-1258");
      aliases.put("x-mac-cyrillic","x-mac-cyrillic");
      aliases.put("x-mac-ukrainian","x-mac-cyrillic");
      aliases.put("ISO-2022-KR","ISO-2022-KR");
      aliases.put("chinese","GBK");
      aliases.put("csgb2312","GBK");
      aliases.put("csiso58gb231280","GBK");
      aliases.put("gb2312","GBK");
      aliases.put("gb_2312","GBK");
      aliases.put("gb_2312-80","GBK");
      aliases.put("gbk","GBK");
      aliases.put("iso-ir-58","GBK");
      aliases.put("x-gbk","GBK");
      aliases.put("gb18030","gb18030");
      aliases.put("big5","Big5");
      aliases.put("big5-hkscs","Big5");
      aliases.put("cn-big5","Big5");
      aliases.put("csbig5","Big5");
      aliases.put("x-x-big5","Big5");
      aliases.put("cseucpkdfmtjapanese","EUC-JP");
      aliases.put("euc-jp","EUC-JP");
      aliases.put("x-euc-jp","EUC-JP");
      aliases.put("csiso2022jp","ISO-2022-JP");
      aliases.put("iso-2022-jp","ISO-2022-JP");
      aliases.put("csshiftjis","Shift_JIS");
      aliases.put("ms932","Shift_JIS");
      aliases.put("ms_kanji","Shift_JIS");
      aliases.put("shift-jis","Shift_JIS");
      aliases.put("shift_jis","Shift_JIS");
      aliases.put("sjis","Shift_JIS");
      aliases.put("windows-31j","Shift_JIS");
      aliases.put("x-sjis","Shift_JIS");
      aliases.put("cseuckr","EUC-KR");
      aliases.put("csksc56011987","EUC-KR");
      aliases.put("euc-kr","EUC-KR");
      aliases.put("iso-ir-149","EUC-KR");
      aliases.put("korean","EUC-KR");
      aliases.put("ks_c_5601-1987","EUC-KR");
      aliases.put("ks_c_5601-1989","EUC-KR");
      aliases.put("ksc5601","EUC-KR");
      aliases.put("ksc_5601","EUC-KR");
      aliases.put("windows-949","EUC-KR");
      aliases.put("csiso2022kr","replacement");
      aliases.put("hz-gb-2312","replacement");
      aliases.put("iso-2022-cn","replacement");
      aliases.put("iso-2022-cn-ext","replacement");
      aliases.put("iso-2022-kr","replacement");
      aliases.put("replacement","replacement");
      aliases.put("utf-16be","UTF-16BE");
      aliases.put("utf-16","UTF-16LE");
      aliases.put("utf-16le","UTF-16LE");
      aliases.put("x-user-defined","x-user-defined");
      return aliases;
    }

    private static Map<String, String> CreateEmailAliasMap() {
      HashMap<String, String> aliases = new HashMap<String, String>();
      aliases.put("utf-7","UTF-7"); // TODO: Remove from this list eventually
      aliases.put("utf-8","UTF-8");
      aliases.put("utf8","UTF-8");
      aliases.put("866","IBM866");
      aliases.put("cp866","IBM866");
      aliases.put("csibm866","IBM866");
      aliases.put("ibm866","IBM866");
      aliases.put("csisolatin2","ISO-8859-2");
      aliases.put("iso-8859-2","ISO-8859-2");
      aliases.put("iso-ir-101","ISO-8859-2");
      aliases.put("iso_8859-2","ISO-8859-2");
      aliases.put("iso_8859-2:1987","ISO-8859-2");
      aliases.put("l2","ISO-8859-2");
      aliases.put("latin2","ISO-8859-2");
      aliases.put("csisolatin3","ISO-8859-3");
      aliases.put("iso-8859-3","ISO-8859-3");
      aliases.put("iso-ir-109","ISO-8859-3");
      aliases.put("iso_8859-3","ISO-8859-3");
      aliases.put("iso_8859-3:1988","ISO-8859-3");
      aliases.put("l3","ISO-8859-3");
      aliases.put("latin3","ISO-8859-3");
      aliases.put("csisolatin4","ISO-8859-4");
      aliases.put("iso-8859-4","ISO-8859-4");
      aliases.put("iso-ir-110","ISO-8859-4");
      aliases.put("iso_8859-4","ISO-8859-4");
      aliases.put("iso_8859-4:1988","ISO-8859-4");
      aliases.put("l4","ISO-8859-4");
      aliases.put("latin4","ISO-8859-4");
      aliases.put("csisolatincyrillic","ISO-8859-5");
      aliases.put("cyrillic","ISO-8859-5");
      aliases.put("iso-8859-5","ISO-8859-5");
      aliases.put("iso-ir-144","ISO-8859-5");
      aliases.put("iso_8859-5","ISO-8859-5");
      aliases.put("iso_8859-5:1988","ISO-8859-5");
      aliases.put("arabic","ISO-8859-6");
      aliases.put("asmo-708","ISO-8859-6");
      aliases.put("csisolatinarabic","ISO-8859-6");
      aliases.put("ecma-114","ISO-8859-6");
      aliases.put("iso-8859-6","ISO-8859-6");
      aliases.put("iso-ir-127","ISO-8859-6");
      aliases.put("iso_8859-6","ISO-8859-6");
      aliases.put("iso_8859-6:1987","ISO-8859-6");
      aliases.put("csiso88596i","ISO-8859-6-I");
      aliases.put("iso-8859-6-i","ISO-8859-6-I");
      aliases.put("csisolatingreek","ISO-8859-7");
      aliases.put("ecma-118","ISO-8859-7");
      aliases.put("elot_928","ISO-8859-7");
      aliases.put("greek","ISO-8859-7");
      aliases.put("greek8","ISO-8859-7");
      aliases.put("iso-8859-7","ISO-8859-7");
      aliases.put("iso-ir-126","ISO-8859-7");
      aliases.put("iso_8859-7","ISO-8859-7");
      aliases.put("iso_8859-7:1987","ISO-8859-7");
      aliases.put("csisolatinhebrew","ISO-8859-8");
      aliases.put("hebrew","ISO-8859-8");
      aliases.put("iso-8859-8","ISO-8859-8");
      aliases.put("iso-ir-138","ISO-8859-8");
      aliases.put("iso_8859-8","ISO-8859-8");
      aliases.put("iso_8859-8:1988","ISO-8859-8");
      aliases.put("csiso88598i","ISO-8859-8-I");
      aliases.put("iso-8859-8-i","ISO-8859-8-I");
      aliases.put("csisolatin6","ISO-8859-10");
      aliases.put("iso-8859-10","ISO-8859-10");
      aliases.put("iso-ir-157","ISO-8859-10");
      aliases.put("l6","ISO-8859-10");
      aliases.put("latin6","ISO-8859-10");
      aliases.put("iso-8859-13","ISO-8859-13");
      aliases.put("iso-8859-14","ISO-8859-14");
      aliases.put("iso-8859-15","ISO-8859-15");
      aliases.put("iso_8859-15","ISO-8859-15");
      aliases.put("iso-8859-16","ISO-8859-16");
      aliases.put("cskoi8r","KOI8-R");
      aliases.put("koi8-r","KOI8-R");
      aliases.put("koi8-u","KOI8-U");
      aliases.put("csmacintosh","macintosh");
      aliases.put("mac","macintosh");
      aliases.put("macintosh","macintosh");
      aliases.put("iso-8859-11","TIS-620");
      aliases.put("tis-620","TIS-620");
      aliases.put("windows-874","windows-874");
      aliases.put("windows-1250","windows-1250");
      aliases.put("windows-1251","windows-1251");
      aliases.put("ascii","US-ASCII");
      aliases.put("cp1252","windows-1252");
      aliases.put("cp819","ISO-8859-1");
      aliases.put("csisolatin1","ISO-8859-1");
      aliases.put("ibm819","ISO-8859-1");
      aliases.put("iso-8859-1","ISO-8859-1");
      aliases.put("iso-ir-100","ISO-8859-1");
      aliases.put("iso_8859-1","ISO-8859-1");
      aliases.put("iso_8859-1:1987","ISO-8859-1");
      aliases.put("l1","ISO-8859-1");
      aliases.put("latin1","ISO-8859-1");
      aliases.put("ansi_x3.4-1968","US-ASCII");
      aliases.put("us-ascii","US-ASCII");
      aliases.put("windows-1252","windows-1252");
      aliases.put("windows-1253","windows-1253");
      aliases.put("csisolatin5","ISO-8859-9");
      aliases.put("iso-8859-9","ISO-8859-9");
      aliases.put("iso-ir-148","ISO-8859-9");
      aliases.put("iso_8859-9","ISO-8859-9");
      aliases.put("iso_8859-9:1989","ISO-8859-9");
      aliases.put("l5","ISO-8859-9");
      aliases.put("latin5","ISO-8859-9");
      aliases.put("windows-1254","windows-1254");
      aliases.put("windows-1255","windows-1255");
      aliases.put("windows-1256","windows-1256");
      aliases.put("windows-1257","windows-1257");
      aliases.put("windows-1258","windows-1258");
      aliases.put("iso-2022-jp-2","ISO-2022-JP-2");
      aliases.put("csiso2022kr","ISO-2022-KR");
      aliases.put("iso-2022-kr","ISO-2022-KR");
      aliases.put("csgb2312","GB2312");
      aliases.put("gb2312","GB2312");
      aliases.put("gbk","GBK");
      aliases.put("gb18030","GB18030");
      aliases.put("big5","Big5");
      aliases.put("csbig5","Big5");
      aliases.put("cseucpkdfmtjapanese","EUC-JP");
      aliases.put("euc-jp","EUC-JP");
      aliases.put("csiso2022jp","ISO-2022-JP");
      aliases.put("iso-2022-jp","ISO-2022-JP");
      aliases.put("csshiftjis","Shift_JIS");
      aliases.put("ms_kanji","Shift_JIS");
      aliases.put("shift_jis","Shift_JIS");
      aliases.put("cseuckr","EUC-KR");
      aliases.put("euc-kr","EUC-KR");
      aliases.put("utf-16be","UTF-16BE");
      aliases.put("utf-16","UTF-16");
      aliases.put("utf-16le","UTF-16LE");
      return aliases;
    }

    private static String ToLowerCaseAscii(String str) {
      if (str == null) {
        return null;
      }
      int len = str.length();
      char c = (char)0;
      boolean hasUpperCase = false;
      for (int i = 0; i < len; ++i) {
        c = str.charAt(i);
        if (c >= 'A' && c <= 'Z') {
          hasUpperCase = true;
          break;
        }
      }
      if (!hasUpperCase) {
        return str;
      }
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < len; ++i) {
        c = str.charAt(i);
        if (c >= 'A' && c <= 'Z') {
          builder.append((char)(c + 0x20));
        } else {
          builder.append(c);
        }
      }
      return builder.toString();
    }

    private static String TrimAsciiWhite(String str) {
      if (((str) == null || (str).length() == 0)) {
        return str;
      }
      int index = 0;
      int valueSLength = str.length();
      while (index < valueSLength) {
        char c = str.charAt(index);
        if (c != 0x09 && c != 0x20 && c != 0x0c && c != 0x0d && c != 0x0a) {
          break;
        }
        ++index;
      }
      if (index == valueSLength) {
        return "";
      }
      int indexStart = index;
      index = str.length() - 1;
      while (index >= 0) {
        char c = str.charAt(index);
        if (c != 0x09 && c != 0x20 && c != 0x0c && c != 0x0d && c != 0x0a) {
          int indexEnd = index + 1;
          if (indexEnd == indexStart) {
            return "";
          }
          return (indexEnd == str.length() && indexStart == 0) ? str :
            str.substring(indexStart, (indexStart)+(indexEnd - indexStart));
        }
        --index;
      }
      return "";
    }

    private static class DecoderToInputClass implements ICharacterInput {
      private final IByteReader stream;
      private final ICharacterDecoder reader;

      public DecoderToInputClass(ICharacterDecoder reader, IByteReader
        stream) {
        this.reader = reader;
        this.stream = stream;
      }

      /**
       * This is an internal method.
       * @return A 32-bit signed integer.
       */
      public int ReadChar() {
        int c = this.reader.ReadChar(this.stream);
        return (c == -2) ? 0xfffd : c;
      }

      /**
       * This is an internal method.
       * @param buffer An array of 32-bit unsigned integers.
       * @param offset An index starting at 0 showing where the desired portion of
       * {@code buffer} begins.
       * @param length The number of elements in the desired portion of {@code
       * buffer} (but not more than {@code buffer} 's length).
       * @return A 32-bit signed integer.
       * @throws NullPointerException The parameter {@code buffer} is null.
       * @throws IllegalArgumentException Either {@code offset} or {@code length} is less
       * than 0 or greater than {@code buffer} 's length, or {@code buffer} 's length
       * minus {@code offset} is less than {@code length}.
       * @throws NullPointerException The parameter {@code buffer} is null.
       */
      public int Read(int[] buffer, int offset, int length) {
        if (buffer == null) {
          throw new NullPointerException("buffer");
        }
        if (offset < 0) {
          throw new IllegalArgumentException("offset(" + offset +
            ") is less than 0");
        }
        if (offset > buffer.length) {
          throw new IllegalArgumentException("offset(" + offset + ") is more than " +
            buffer.length);
        }
        if (length < 0) {
          throw new IllegalArgumentException("length(" + length +
            ") is less than 0");
        }
        if (length > buffer.length) {
          throw new IllegalArgumentException("length(" + length + ") is more than " +
            buffer.length);
        }
        if (buffer.length - offset < length) {
          throw new IllegalArgumentException("buffer's length minus " + offset +
            "" + "\u0020(" +
            (buffer.length - offset) + ") is less than " + length);
        }
        int count = 0;
        for (int i = 0; i < length; ++i) {
          int c = this.ReadChar();
          if (c == -1) {
            break;
          }
          buffer[offset] = c;
          ++count;
          ++offset;
        }
        return count;
      }
    }
  }
