## PeterO.DataIO

    public static class DataIO

Convenience class that contains static methods for wrapping byte arrays and streams into byte readers and byte writers.

### Member Summary
* <code>[ToByteReader(this byte[])](#ToByteReader_this_byte)</code> - <b>Deprecated:</b> Use ToReader instead.
* <code>[ToByteReader(this byte[], int, int)](#ToByteReader_this_byte_int_int)</code> - <b>Deprecated:</b> Use ToReader instead.
* <code>[ToByteReader(this System.IO.Stream)](#ToByteReader_this_System_IO_Stream)</code> - <b>Deprecated:</b> Use ToReader instead.
* <code>[ToReader(this byte[])](#ToReader_this_byte)</code> - Wraps a byte array into a byte reader.
* <code>[ToReader(this byte[], int, int)](#ToReader_this_byte_int_int)</code> - Wraps a portion of a byte array into a byte reader object.
* <code>[ToReader(this System.IO.Stream)](#ToReader_this_System_IO_Stream)</code> - Wraps an input stream into a reader object.
* <code>[ToWriter(this PeterO.IByteWriter)](#ToWriter_this_PeterO_IByteWriter)</code> - Wraps a byte writer (one that only implements a ReadByte method) to a writer (one that also implements a three-parameter Read method.
* <code>[ToWriter(this System.IO.Stream)](#ToWriter_this_System_IO_Stream)</code> - Wraps an output stream into a writer object.

<a id="ToByteReader_this_byte_int_int"></a>
### ToByteReader

    public static PeterO.IByteReader ToByteReader(
        this byte[] bytes,
        int offset,
        int length);

<b>Deprecated.</b> Use ToReader instead.

Wraps a portion of a byte array into a byte reader. In the.NET implementation, this method is implemented as an extension method to any object implementing byte[] and can be called as follows:  `bytes.ToByteReader(offset, length)` . If the object's class already has a ToByteReader method with the same parameters, that method takes precedence over this extension method.

<b>Parameters:</b>

 * <i>bytes</i>: The byte array to wrap into a byte reader.

 * <i>offset</i>: An index starting at 0 showing where the desired portion of  <i>bytes</i>
 begins.

 * <i>length</i>: The length, in bytes, of the desired portion of  <i>bytes</i>
 (but not more than  <i>bytes</i>
 's length).

<b>Return Value:</b>

An IByteReader object.

<b>Exceptions:</b>

 *  T:System.ArgumentNullException:
The parameter  <i>bytes</i>
 is null.

 * System.ArgumentException:
Either  <i>offset</i>
 or  <i>length</i>
 is less than 0 or greater than  <i>bytes</i>
 's length, or  <i> bytes</i>
 's length minus  <i>offset</i>
 is less than  <i>length</i>
.

 * System.ArgumentNullException:
The parameter  <i>bytes</i>
 is null.

<a id="ToByteReader_this_byte"></a>
### ToByteReader

    public static PeterO.IByteReader ToByteReader(
        this byte[] bytes);

<b>Deprecated.</b> Use ToReader instead.

Wraps a byte array into a byte reader. In the.NET implementation, this method is implemented as an extension method to any object implementing byte[] and can be called as follows:  `bytes.ToByteReader()` . If the object's class already has a ToByteReader method with the same parameters, that method takes precedence over this extension method.

<b>Parameters:</b>

 * <i>bytes</i>: The byte array to wrap into a byte reader.

<b>Return Value:</b>

An IByteReader object.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter  <i>bytes</i>
 is null.

<a id="ToByteReader_this_System_IO_Stream"></a>
### ToByteReader

    public static PeterO.IByteReader ToByteReader(
        this System.IO.Stream input);

<b>Deprecated.</b> Use ToReader instead.

Wraps a data stream into a byte reader. In the.NET implementation, this method is implemented as an extension method to any object implementing Stream and can be called as follows:  `input.ToByteReader()` . If the object's class already has a ToByteReader method with the same parameters, that method takes precedence over this extension method.

<b>Parameters:</b>

 * <i>input</i>: The data stream to wrap into a byte reader.

<b>Return Value:</b>

An IByteReader object.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter  <i>input</i>
 is null.

<a id="ToReader_this_byte_int_int"></a>
### ToReader

    public static PeterO.IReader ToReader(
        this byte[] bytes,
        int offset,
        int length);

Wraps a portion of a byte array into a byte reader object. In the.NET implementation, this method is implemented as an extension method to any byte array object and can be called as follows:  `bytes.ToByteReader(offset, length)` . If the object's class already has a ToByteReader method with the same parameters, that method takes precedence over this extension method.

<b>Parameters:</b>

 * <i>bytes</i>: The byte array to wrap.

 * <i>offset</i>: An index starting at 0 showing where the desired portion of "bytes" begins.

 * <i>length</i>: The length, in bytes, of the desired portion of "bytes" (but not more than "bytes" 's length).

<b>Return Value:</b>

A byte reader wrapping the byte array.

<b>Exceptions:</b>

 *  T:System.ArgumentNullException:
The parameter  <i>bytes</i>
 is null.

 * System.ArgumentException:
Either  <i>offset</i>
 or  <i>length</i>
 is less than 0 or greater than  <i>bytes</i>
 's length, or  <i> bytes</i>
 's length minus  <i>offset</i>
 is less than  <i>length</i>
.

 * System.ArgumentNullException:
The parameter  <i>bytes</i>
 is null.

<a id="ToReader_this_byte"></a>
### ToReader

    public static PeterO.IReader ToReader(
        this byte[] bytes);

Wraps a byte array into a byte reader. The reader will start at the beginning of the byte array. In the.NET implementation, this method is implemented as an extension method to any byte array object and can be called as follows:  `bytes.ToByteReader()` . If the object's class already has a ToByteReader method with the same parameters, that method takes precedence over this extension method.

<b>Parameters:</b>

 * <i>bytes</i>: The byte array to wrap.

<b>Return Value:</b>

A byte reader wrapping the byte array.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter  <i>bytes</i>
 is null.

<a id="ToReader_this_System_IO_Stream"></a>
### ToReader

    public static PeterO.IReader ToReader(
        this System.IO.Stream input);

Wraps an input stream into a reader object. If an IOException is thrown by the input stream, the reader object throws InvalidOperationException instead. In the.NET implementation, this method is implemented as an extension method to any object implementing Stream and can be called as follows:  `input.ToByteReader()` . If the object's class already has a ToByteReader method with the same parameters, that method takes precedence over this extension method.

<b>Parameters:</b>

 * <i>input</i>: The input stream to wrap.

<b>Return Value:</b>

A byte reader wrapping the input stream.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter  <i>input</i>
 is null.

<a id="ToWriter_this_PeterO_IByteWriter"></a>
### ToWriter

    public static PeterO.IWriter ToWriter(
        this PeterO.IByteWriter output);

Wraps a byte writer (one that only implements a ReadByte method) to a writer (one that also implements a three-parameter Read method.) In the.NET implementation, this method is implemented as an extension method to any object implementing IByteWriter and can be called as follows:  `output.ToWriter()` . If the object's class already has a ToWriter method with the same parameters, that method takes precedence over this extension method.

<b>Parameters:</b>

 * <i>output</i>: A byte stream.

<b>Return Value:</b>

A writer that wraps the given stream.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter  <i>output</i>
 is null.

<a id="ToWriter_this_System_IO_Stream"></a>
### ToWriter

    public static PeterO.IWriter ToWriter(
        this System.IO.Stream output);

Wraps an output stream into a writer object. If an IOException is thrown by the input stream, the writer object throws InvalidOperationException instead. In the.NET implementation, this method is implemented as an extension method to any object implementing Stream and can be called as follows:  `output.ToWriter()` . If the object's class already has a ToWriter method with the same parameters, that method takes precedence over this extension method.

<b>Parameters:</b>

 * <i>output</i>: Output stream to wrap.

<b>Return Value:</b>

A byte writer that wraps the given output stream.

<b>Exceptions:</b>

 * System.ArgumentNullException:
The parameter  <i>output</i>
 is null.
