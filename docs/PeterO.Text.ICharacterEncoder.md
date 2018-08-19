## PeterO.Text.ICharacterEncoder

    public interface ICharacterEncoder

Defines a method that can be implemented by classes that convert Unicode ode points to bytes.

### Encode

    int Encode(
        int c,
        PeterO.IWriter output);

Converts a Unicode code point to bytes and writes the bytes to an output tream.If this method returns -2, indicating an error, the caller of this ethod can take one of a variety of actions to handle the error. For xample, it can write an escape sequence using the code point (such as he HTML error mode in the Encoding Standard), it can replace the code oint with a "best fit" to that code point (which can consist of one or ore bytes) and write the "best fit" instead, it can replace the code oint with an arbitrary byte or sequence of bytes, or it can throw an xception. In some cases, where the error won't cause data loss or a ecurity problem, the caller can also ignore the encoding error.

<b>Parameters:</b>

 * <i>c</i>: Either a Unicode code point (from 0-0xd7ff or from 0xe000 to 0x10ffff), r the value -1 indicating the end of the stream.

 * <i>output</i>: Output stream where the converted bytes will be written. The decoder can aintain internal state, including data on code points already passed as nput, so this parameter should not change when using the same character ncoder object.

<b>Return Value:</b>

The number of bytes written to the stream; -1 if no further code points emain (for example, if _c_ is -1 indicating the end of the stream), or -2 f an encoding error occurs. (Note that it's possible for this method to eturn 0 if, for example, it can't generate new bytes yet based on the urrent input.). If this method returns -2, it should not write any bytes o the output stream.
