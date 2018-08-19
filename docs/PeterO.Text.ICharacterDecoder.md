## PeterO.Text.ICharacterDecoder

    public interface ICharacterDecoder

Defines a method that can be implemented by classes that convert a stream f bytes to Unicode code points.

### ReadChar

    int ReadChar(
        PeterO.IByteReader input);

Reads bytes from an input transform until a Unicode code point is decoded r until the end of the stream is reached.If this method returns -2, indicating an error, the caller of this ethod can take one of a variety of actions to handle the error. For xample, it can output one or more replacement code points instead (such s the Replacement Character 0xfffd), or it can throw an exception. In ome cases, where the error won't cause data loss or a security problem, he caller can also ignore the decoder error.

<b>Parameters:</b>

 * <i>input</i>: Source of bytes to decode into code points. The decoder can maintain internal state, including data on bytes already read, so this parameter should not change when using the same character decoder object. It's also possible for the decoder to read no bytes but still return a code point, depending on the encoding it supports and its internal state.

<b>Return Value:</b>

The Unicode code point decoded, from 0-0xd7ff or from 0xe000 to 0x10ffff. eturns -1 if the end of the source is reached or -2 if a decoder error ccurs.
