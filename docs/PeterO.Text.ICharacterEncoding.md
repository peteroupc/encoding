## PeterO.Text.ICharacterEncoding

    public interface ICharacterEncoding

Defines methods that can be implemented by classes that convert to and from bytes and character code points.

### GetDecoder

    PeterO.Text.ICharacterDecoder GetDecoder();

Creates a decoder for this character encoding with initial state. If the ecoder is stateless, multiple calls of this method can return the same ecoder.

<b>Return Value:</b>

A character decoder object.

### GetEncoder

    PeterO.Text.ICharacterEncoder GetEncoder();

Creates an encoder for this character encoding with initial state. If the ncoder is stateless, multiple calls of this method can return the same ncoder.

<b>Return Value:</b>

A character encoder object.
