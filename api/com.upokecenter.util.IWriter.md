# com.upokecenter.util.IWriter

    public interface IWriter extends IByteWriter

A generic interface for writing bytes of data.

## Methods

* `void write(byte[] bytes,
 int offset,
 int length)`<br>
 Writes a portion of a byte array to the data source.

## Method Details

### write
    void write(byte[] bytes, int offset, int length)
Writes a portion of a byte array to the data source.

**Parameters:**

* <code>bytes</code> - A byte array containing the data to write.

* <code>offset</code> - An index starting at 0 showing where the desired portion of
 <code>bytes</code> begins.

* <code>length</code> - The number of elements in the desired portion of <code>bytes</code>
 (but not more than <code>bytes</code> 's length).

**Throws:**

* <code>NullPointerException</code> - Should be thrown if the parameter <code>
 bytes</code> is null.

* <code>IllegalArgumentException</code> - Should be thrown if either <code>offset</code> or
 <code>length</code> is less than 0 or greater than <code>bytes</code> 's length, or
 <code>bytes</code> 's length minus <code>offset</code> is less than <code>length</code>.
