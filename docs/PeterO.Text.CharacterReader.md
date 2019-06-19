## PeterO.Text.CharacterReader

    public sealed class CharacterReader :
        PeterO.Text.ICharacterInput

 A general-purpose character input for reading text from byte streams and text strings. When reading byte streams, this class supports the UTF-8 character encoding by default, but can be configured to support UTF-16 and UTF-32 as well.  ### Member Summary
* <code>[Read(int[], int, int)](#Read_int_int_int)</code> - Reads a series of code points from a Unicode stream or a string.
* <code>[ReadChar()](#ReadChar)</code> - Reads the next character from a Unicode stream or a string.

<a id="Read_int_int_int"></a>
### Read

    public sealed int Read(
        int[] chars,
        int index,
        int length);

 Reads a series of code points from a Unicode stream or a string.  <b>Parameters:</b>

 * <i>chars</i>: An array where the code points that were read will be stored.

 * <i>index</i>: A zero-based index showing where the desired portion of  <i>chars</i>
 begins.

 * <i>length</i>: The number of elements in the desired portion of  <i>chars</i>
 (but not more than  <i>chars</i>
 's length).

<b>Return Value:</b>

The number of code points read from the stream. This can be less than the  <i>length</i>
 parameter if the end of the stream is reached.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter  <i>chars</i>
 is null.

 * System.ArgumentException:
Either  <i>index</i>
 or  <i>length</i>
 is less than 0 or greater than  <i>chars</i>
 's length, or  <i>chars</i>
 's length minus  <i>index</i>
 is less than  <i>length</i>
 .

<a id="ReadChar"></a>
### ReadChar

    public sealed int ReadChar();

 Reads the next character from a Unicode stream or a string.  <b>Return Value:</b>

The next character, or -1 if the end of the string or stream was reached.
