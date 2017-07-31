# com.upokecenter.util.DataIO

    public final class DataIO extends Object

## Methods

* `static IByteReader ToByteReader(byte[] bytes)`<br>
 Deprecated.
Use ToReader instead.
 Use ToReader instead.
* `static IByteReader ToByteReader(byte[] bytes,
            int offset,
            int length)`<br>
 Deprecated.
Use ToReader instead.
 Use ToReader instead.
* `static IByteReader ToByteReader(InputStream input)`<br>
 Deprecated.
Use ToReader instead.
 Use ToReader instead.
* `static IReader ToReader(byte[] bytes)`<br>
* `static IReader ToReader(byte[] bytes,
        int offset,
        int length)`<br>
* `static IReader ToReader(InputStream input)`<br>
* `static IWriter ToWriter(IByteWriter output)`<br>
* `static IWriter ToWriter(OutputStream output)`<br>

## Method Details

### ToReader
    public static IReader ToReader(byte[] bytes)
### ToReader
    public static IReader ToReader(byte[] bytes, int offset, int length)
### ToReader
    public static IReader ToReader(InputStream input)
### ToByteReader
    @Deprecated public static IByteReader ToByteReader(byte[] bytes, int offset, int length)
Deprecated.&nbsp;Use ToReader instead.
### ToByteReader
    @Deprecated public static IByteReader ToByteReader(InputStream input)
Deprecated.&nbsp;Use ToReader instead.
### ToByteReader
    @Deprecated public static IByteReader ToByteReader(byte[] bytes)
Deprecated.&nbsp;Use ToReader instead.
### ToWriter
    public static IWriter ToWriter(OutputStream output)
### ToWriter
    public static IWriter ToWriter(IByteWriter output)
