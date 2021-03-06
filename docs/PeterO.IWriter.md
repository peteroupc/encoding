## PeterO.IWriter

    public interface IWriter :
        PeterO.IByteWriter

A generic interface for writing bytes of data.

### Member Summary
* <code>[Write(byte[], int, int)](#Write_byte_int_int)</code> - Writes a portion of a byte array to the data source.

<a id="Write_byte_int_int"></a>
### Write

    void Write(
        byte[] bytes,
        int offset,
        int length);

Writes a portion of a byte array to the data source.

<b>Parameters:</b>

 * <i>bytes</i>: A byte array containing the data to write.

 * <i>offset</i>: An index starting at 0 showing where the desired portion of  <i>bytes</i>
 begins.

 * <i>length</i>: The number of elements in the desired portion of  <i>bytes</i>
 (but not more than  <i>bytes</i>
 's length).

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
