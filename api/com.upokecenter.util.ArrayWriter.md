# com.upokecenter.util.ArrayWriter

    public final class ArrayWriter extends java.lang.Object implements IWriter

An array of bytes that grows as needed.

## Methods

* `ArrayWriter() ArrayWriter`<br>
 Initializes a new instance of the ArrayWriter class with a default
 backing store size of 16.
* `ArrayWriter​(int initialSize) ArrayWriter`<br>
 Initializes a new instance of the ArrayWriter class.
* `void Clear()`<br>
 Offers a fast way to reset the length of the array writer's data to 0.
* `byte[] ToArray()`<br>
 Generates an array of all bytes written so far to it.
* `void write​(byte[] src,
     int offset,
     int length)`<br>
 Writes a series of bytes to the array.
* `void write​(int byteValue)`<br>
 Writes an 8-bit byte to the array.

## Constructors

* `ArrayWriter() ArrayWriter`<br>
 Initializes a new instance of the ArrayWriter class with a default
 backing store size of 16.
* `ArrayWriter​(int initialSize) ArrayWriter`<br>
 Initializes a new instance of the ArrayWriter class.

## Method Details

### ArrayWriter
    public ArrayWriter()
Initializes a new instance of the <code>ArrayWriter</code> class with a default
 backing store size of 16.
### ArrayWriter
    public ArrayWriter​(int initialSize)
Initializes a new instance of the <code>ArrayWriter</code> class.

**Parameters:**

* <code>initialSize</code> - The initial size of the array writer's backing store.

### Clear
    public void Clear()
Offers a fast way to reset the length of the array writer's data to 0.
### ToArray
    public byte[] ToArray()
Generates an array of all bytes written so far to it.

**Returns:**

* A byte array.

### write
    public void write​(int byteValue)
Writes an 8-bit byte to the array.

**Specified by:**

* <code>write</code> in interface <code>IByteWriter</code>

**Parameters:**

* <code>byteValue</code> - An integer containing the byte to write. Only the lower 8
 bits of this value will be used.

### write
    public void write​(byte[] src, int offset, int length)
Writes a series of bytes to the array.

**Specified by:**

* <code>write</code> in interface <code>IWriter</code>

**Parameters:**

* <code>src</code> - Byte array containing the data to write.

* <code>offset</code> - A zero-based index showing where the desired portion of <code>
 src</code> begins.

* <code>length</code> - The number of elements in the desired portion of <code>src</code>
 (but not more than <code>src</code> 's length).

**Throws:**

* <code>java.lang.NullPointerException</code> - The parameter <code>src</code> is null.

* <code>java.lang.IllegalArgumentException</code> - Either <code>offset</code> or <code>length</code> is
 less than 0 or greater than <code>src</code> 's length, or <code>src</code> ' s
 length minus <code>offset</code> is less than <code>length</code> .
