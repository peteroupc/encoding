## PeterO.IReader

    public interface IReader :
        PeterO.IByteReader

A generic interface for reading bytes of data from a data source.

### Member Summary
* <code>[Read(byte[], int, int)](#Read_byte_int_int)</code> - Reads a portion of a byte array from the data source.

<a id="Read_byte_int_int"></a>
### Read

    int Read(
        byte[] bytes,
        int offset,
        int length);

Reads a portion of a byte array from the data source.

<b>Parameters:</b>

 * <i>bytes</i>: A byte array which will contain the data that was read from the data source.

 * <i>offset</i>: An index starting at 0 showing where the desired portion of  <i>bytes</i>
 begins.

 * <i>length</i>: The number of elements in the desired portion of  <i>bytes</i>
 (but not more than  <i>bytes</i>
 's length).

<b>Return Value:</b>

The number of bytes read from the data source. Can be less than  <i>length</i>
 if the end of the stream was reached.

<b>Exceptions:</b>

 * System.ArgumentNullException:
Should be thrown if the parameter  <i>bytes</i>
 is null.

 * System.ArgumentException:
Should be thrown if either  <i>offset</i>
 or  <i>length</i>
 is less than 0 or greater than  <i>bytes</i>
 's length, or  <i>bytes</i>
 's length minus  <i>offset</i>
 is less than  <i>length</i>
.
