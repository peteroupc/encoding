## PeterO.ArrayWriter

    public sealed class ArrayWriter :
        PeterO.IByteWriter,
        PeterO.IWriter

 An array of bytes that grows as needed.  ### Member Summary
* <code>[Clear()](#Clear)</code> - Offers a fast way to reset the length of the array writer's data to 0.
* <code>[ToArray()](#ToArray)</code> - Generates an array of all bytes written so far to it.
* <code>[Write(byte[], int, int)](#Write_byte_int_int)</code> - Writes a series of bytes to the array.
* <code>[WriteByte(int)](#WriteByte_int)</code> - Writes an 8-bit byte to the array.

<a id="Void_ctor_Int32"></a>
### ArrayWriter Constructor

    public ArrayWriter(
        int initialSize);

 Initializes a new instance of the [PeterO.ArrayWriter](PeterO.ArrayWriter.md) class.   <b>Parameters:</b>

 * <i>initialSize</i>:  The initial size of the array writer's backing store.

<a id="Void_ctor"></a>
### ArrayWriter Constructor

    public ArrayWriter();

 Initializes a new instance of the [PeterO.ArrayWriter](PeterO.ArrayWriter.md) class with a default backing store size of 16.  <a id="Clear"></a>
### Clear

    public void Clear();

 Offers a fast way to reset the length of the array writer's data to 0.  <a id="ToArray"></a>
### ToArray

    public byte[] ToArray();

 Generates an array of all bytes written so far to it.  <b>Return Value:</b>

A byte array.

<a id="Write_byte_int_int"></a>
### Write

    public sealed void Write(
        byte[] src,
        int offset,
        int length);

 Writes a series of bytes to the array.  <b>Parameters:</b>

 * <i>src</i>: Byte array containing the data to write.

 * <i>offset</i>: A zero-based index showing where the desired portion of  <i>src</i>
 begins.

 * <i>length</i>: The number of elements in the desired portion of  <i>src</i>
 (but not more than  <i>src</i>
 's length).

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter  <i>src</i>
 is null.

 * System.ArgumentException:
Either  <i>offset</i>
 or  <i>length</i>
 is less than 0 or greater than  <i>src</i>
 's length, or  <i>src</i>
 ' s length minus  <i>offset</i>
 is less than  <i>length</i>
 .

<a id="WriteByte_int"></a>
### WriteByte

    public sealed void WriteByte(
        int byteValue);

 Writes an 8-bit byte to the array.  <b>Parameters:</b>

 * <i>byteValue</i>: An integer containing the byte to write. Only the lower 8 bits of this value will be used.
