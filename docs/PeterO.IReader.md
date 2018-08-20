## PeterO.IReader

    public interface IReader :
        PeterO.IByteReader

A generic interface for reading bytes of data from a data source.

### Read

    int Read(
        byte[] bytes,
        int offset,
        int length);

Reads a portion of a byte array from the data source.

<b>Parameters:</b>

 * <i>bytes</i>: A byte array which will contain the data that was read from the data source.

 * <i>offset</i>: A zero-based index showing where the desired portion of <i>bytes</i>
begins.

 * <i>length</i>: The number of elements in the desired portion of <i>bytes</i>
(but not more than <i>bytes</i>
's length).

<b>Return Value:</b>

The number of bytes read from the data source. Can be less than "length" if the end of the stream was reached.

<b>Exceptions:</b>

 * System.ArgumentNullException:
Should be thrown if the parameter "bytes" is null.

 * System.ArgumentException:
Should be thrown if either "offset" or "length" is less than 0 or greater than "bytes" 's length, or "bytes" 's length minus "offset" is less than "length".
