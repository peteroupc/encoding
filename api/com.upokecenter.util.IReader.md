# com.upokecenter.util.IReader

    public interface IReader extends IByteReader

A generic interface for reading bytes of data from a data source.

## Methods

* `int Read​(byte[] bytes,
    int offset,
    int length)`<br>
 Reads a portion of a byte array from the data source.

## Method Details

### Read
    int Read​(byte[] bytes, int offset, int length)
Reads a portion of a byte array from the data source.

**Parameters:**

* <code>bytes</code> - A byte array which will contain the data that was read from the
 data source.

* <code>offset</code> - A zero-based index showing where the desired portion of <code>
 bytes</code> begins.

* <code>length</code> - The number of elements in the desired portion of <code>bytes</code>
 (but not more than <code>bytes</code> 's length).

**Returns:**

* The number of bytes read from the data source. Can be less than
 "length" if the end of the stream was reached.

**Throws:**

* <code>NullPointerException</code> - Should be thrown if the parameter
 "bytes" is null.

* <code>IllegalArgumentException</code> - Should be thrown if either "offset" or
 "length" is less than 0 or greater than "bytes" 's length, or "bytes"
 's length minus "offset" is less than "length".

### Read
    int Read​(byte[] bytes, int offset, int length)
Reads a portion of a byte array from the data source.

**Parameters:**

* <code>bytes</code> - A byte array which will contain the data that was read from the
 data source.

* <code>offset</code> - A zero-based index showing where the desired portion of <code>
 bytes</code> begins.

* <code>length</code> - The number of elements in the desired portion of <code>bytes</code>
 (but not more than <code>bytes</code> 's length).

**Returns:**

* The number of bytes read from the data source. Can be less than
 "length" if the end of the stream was reached.

**Throws:**

* <code>NullPointerException</code> - Should be thrown if the parameter
 "bytes" is null.

* <code>IllegalArgumentException</code> - Should be thrown if either "offset" or
 "length" is less than 0 or greater than "bytes" 's length, or "bytes"
 's length minus "offset" is less than "length".
