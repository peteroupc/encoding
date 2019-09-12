## PeterO.Text.ICharacterEncoding

    public interface ICharacterEncoding

 Defines methods that can be implemented by classes that convert to and from bytes and character code points.

### Member Summary
* <code>[GetDecoder()](#GetDecoder)</code> - Creates a decoder for this character encoding with initial state.
* <code>[GetEncoder()](#GetEncoder)</code> - Creates an encoder for this character encoding with initial state.

<a id="GetDecoder"></a>
### GetDecoder

    PeterO.Text.ICharacterDecoder GetDecoder();

Creates a decoder for this character encoding with initial state. If the decoder is stateless, multiple calls of this method can return the same decoder.

<b>Return Value:</b>

A character decoder object.

<a id="GetEncoder"></a>
### GetEncoder

    PeterO.Text.ICharacterEncoder GetEncoder();

Creates an encoder for this character encoding with initial state. If the encoder is stateless, multiple calls of this method can return the same encoder.

<b>Return Value:</b>

A character encoder object.
