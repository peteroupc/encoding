## PeterO.Text.ICharacterInput

    public interface ICharacterInput

 An interface for reading Unicode code points from a data source.

### Member Summary
* <code>[Read(int[], int, int)](#Read_int_int_int)</code> - Reads a sequence of Unicode code points from a data source.
* <code>[ReadChar()](#ReadChar)</code> - Reads a Unicode code point from a data source.

<a id="Read_int_int_int"></a>
### Read

    int Read(
        int[] chars,
        int index,
        int length);

 Reads a sequence of Unicode code points from a data source.

 <b>Parameters:</b>

 * <i>chars</i>: Output buffer.

 * <i>index</i>: A zero-based index showing where the desired portion of  <i>chars</i>
 begins.

 * <i>length</i>: The number of elements in the desired portion of  <i>chars</i>
 (but not more than  <i>chars</i>
 's length).

<b>Return Value:</b>

Either a Unicode code point (from 0-0xd7ff or from 0xe000 to 0x10ffff), or the value -1 indicating the end of the source.

<b>Exceptions:</b>

 * System.ArgumentNullException:
Should be thrown if "chars" is null.

<a id="ReadChar"></a>
### ReadChar

    int ReadChar();

 Reads a Unicode code point from a data source.

 <b>Return Value:</b>

Either a Unicode code point (from 0-0xd7ff or from 0xe000 to 0x10ffff), or the value -1 indicating the end of the source.
