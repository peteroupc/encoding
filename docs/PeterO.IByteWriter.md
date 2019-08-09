## PeterO.IByteWriter

    public interface IByteWriter

 A generic interface for writing bytes of data.

### Member Summary
* <code>[WriteByte(int)](#WriteByte_int)</code> - Writes an 8-bit byte to a data source.

<a id="WriteByte_int"></a>
### WriteByte

    void WriteByte(
        int b);

 Writes an 8-bit byte to a data source.

   <b>Parameters:</b>

 * <i>b</i>: Byte to write to the data source. Only the lower 8 bits of this value are used.
