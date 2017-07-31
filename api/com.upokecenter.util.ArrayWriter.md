# com.upokecenter.util.ArrayWriter

    public final class ArrayWriter extends Object implements IWriter

## Methods

* `ArrayWriter()`<br>
* `ArrayWriter(int initialSize)`<br>
* `void Clear()`<br>
* `byte[] ToArray()`<br>
* `void write(byte[] src,
     int offset,
     int length)`<br>
* `void write(int byteValue)`<br>

## Constructors

* `ArrayWriter()`<br>
* `ArrayWriter(int initialSize)`<br>

## Method Details

### ArrayWriter
    public ArrayWriter()
### ArrayWriter
    public ArrayWriter(int initialSize)
### Clear
    public void Clear()
### ToArray
    public byte[] ToArray()
### write
    public void write(int byteValue)

**Specified by:**

* <code>write</code>&nbsp;in interface&nbsp;<code>IByteWriter</code>

### write
    public void write(byte[] src, int offset, int length)

**Specified by:**

* <code>write</code>&nbsp;in interface&nbsp;<code>IWriter</code>
