/*
Written by Peter O. in 2014.
Any copyright is dedicated to the Public Domain.
http://creativecommons.org/publicdomain/zero/1.0/
If you like this, you should donate to Peter O.
at: http://peteroupc.github.io/
 */
using System;
using System.IO;

namespace PeterO {
    /// <include file='../docs.xml'
    /// path='docs/doc[@name="T:PeterO.DataIO"]/*'/>
  public static class DataIO {
    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.ToReader(System.Byte[])"]/*'/>
    public static IReader ToReader(
  #if !NET20
this
#endif
byte[] bytes) {
      if (bytes == null) {
        throw new ArgumentNullException(nameof(bytes));
      }
      return new ByteArrayTransform(bytes, 0, bytes.Length);
    }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.ToReader(System.Byte[],System.Int32,System.Int32)"]/*'/>
    public static IReader ToReader(
  #if !NET20
this
#endif
byte[] bytes,
int offset,
int length) {
      if (bytes == null) {
        throw new ArgumentNullException(nameof(bytes));
      }
      if (offset < 0) {
        throw new ArgumentException("offset (" + offset +
          ") is less than 0");
      }
      if (offset > bytes.Length) {
        throw new ArgumentException("offset (" + offset + ") is more than " +
          bytes.Length);
      }
      if (length < 0) {
        throw new ArgumentException("length (" + length +
          ") is less than 0");
      }
      if (length > bytes.Length) {
        throw new ArgumentException("length (" + length + ") is more than " +
          bytes.Length);
      }
      if (bytes.Length - offset < length) {
        throw new ArgumentException("bytes's length minus " + offset + " (" +
          (bytes.Length - offset) + ") is less than " + length);
      }
      return new ByteArrayTransform(bytes, offset, length);
    }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.ToReader(System.IO.Stream)"]/*'/>
    public static IReader ToReader(
  #if !NET20
this
#endif
Stream input) {
      if (input == null) {
        throw new ArgumentNullException(nameof(input));
      }
      return new WrappedStream(input);
    }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.ToByteReader(System.Byte[],System.Int32,System.Int32)"]/*'/>
    [Obsolete("Use ToReader instead.")]
    public static IByteReader ToByteReader(
  #if !NET20
this
#endif
byte[] bytes,
int offset,
int length) {
      return (IByteReader)ToReader(bytes, offset, length);
    }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.ToByteReader(System.IO.Stream)"]/*'/>
    [Obsolete("Use ToReader instead.")]
    public static IByteReader ToByteReader(
  #if !NET20
this
#endif
Stream input) {
      return (IByteReader)ToReader(input);
    }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.ToByteReader(System.Byte[])"]/*'/>
    [Obsolete("Use ToReader instead.")]
    public static IByteReader ToByteReader(
  #if !NET20
this
#endif
byte[] bytes) {
      return (IByteReader)ToReader(bytes);
    }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.ToWriter(System.IO.Stream)"]/*'/>
    public static IWriter ToWriter(
  #if !NET20
this
#endif
Stream output) {
      if (output == null) {
        throw new ArgumentNullException(nameof(output));
      }
      return new WrappedOutputStream(output);
    }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.ToWriter(PeterO.IByteWriter)"]/*'/>
    public static IWriter ToWriter(
  #if !NET20
this
#endif
IByteWriter output) {
      if (output == null) {
        throw new ArgumentNullException(nameof(output));
      }
      return new WrappedOutputStreamFromByteWriter(output);
    }

    private sealed class ByteArrayTransform : IReader {
      private readonly byte[] bytes;
      private readonly int endOffset;
      private int offset;

      public ByteArrayTransform(byte[] bytes, int offset, int length) {
        this.bytes = bytes;
        this.offset = offset;
        this.endOffset = offset + length;
      }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.ByteArrayTransform.ReadByte"]/*'/>
      public int ReadByte() {
        if (this.offset >= this.endOffset) {
          return -1;
        }
        int b = this.bytes[this.offset];
        ++this.offset;
        return ((int)b) & 0xff;
      }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.ByteArrayTransform.Read(System.Byte[],System.Int32,System.Int32)"]/*'/>
      public int Read(byte[] bytes, int offset, int length) {
        if (bytes == null) {
          throw new ArgumentNullException(nameof(bytes));
        }
        if (offset < 0) {
          throw new ArgumentException("offset (" + offset +
            ") is less than 0");
        }
        if (offset > bytes.Length) {
          throw new ArgumentException("offset (" + offset +
            ") is more than " + bytes.Length);
        }
        if (length < 0) {
          throw new ArgumentException("length (" + length +
            ") is less than 0");
        }
        if (length > bytes.Length) {
          throw new ArgumentException("length (" + length +
            ") is more than " + bytes.Length);
        }
        if (bytes.Length - offset < length) {
          throw new ArgumentException("bytes's length minus " + offset + " (" +
            (bytes.Length - offset) + ") is less than " + length);
        }
        var count = 0;
        for (var i = 0; i < length; ++i) {
          int c = this.ReadByte();
          if (c == -1) {
            break;
          }
          bytes[offset] = (byte)(c & 0xff);
          ++count;
          ++offset;
        }
        return count;
      }
    }

    private sealed class WrappedOutputStream : IWriter {
      private readonly Stream output;

      public WrappedOutputStream(Stream output) {
        this.output = output;
      }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.WrappedOutputStream.WriteByte(System.Int32)"]/*'/>
      public void WriteByte(int byteValue) {
        try {
          this.output.WriteByte((byte)byteValue);
        } catch (IOException ex) {
          throw new InvalidOperationException(ex.Message, ex);
        }
      }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.WrappedOutputStream.Write(System.Byte[],System.Int32,System.Int32)"]/*'/>
      public void Write(byte[] bytes, int offset, int length) {
        try {
          this.output.Write(bytes, offset, length);
        } catch (IOException ex) {
          throw new InvalidOperationException(ex.Message, ex);
        }
      }
    }

    private sealed class WrappedOutputStreamFromByteWriter : IWriter {
      private readonly IByteWriter output;

      public WrappedOutputStreamFromByteWriter(IByteWriter output) {
        this.output = output;
      }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.WrappedOutputStreamFromByteWriter.WriteByte(System.Int32)"]/*'/>
      public void WriteByte(int byteValue) {
        this.output.WriteByte((byte)byteValue);
      }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.WrappedOutputStreamFromByteWriter.Write(System.Byte[],System.Int32,System.Int32)"]/*'/>
      public void Write(byte[] bytes, int offset, int length) {
        if (bytes == null) {
          throw new ArgumentNullException(nameof(bytes));
        }
        if (offset < 0) {
          throw new ArgumentException("offset (" + offset +
            ") is less than 0");
        }
        if (offset > bytes.Length) {
          throw new ArgumentException("offset (" + offset + ") is more than " +
            bytes.Length);
        }
        if (length < 0) {
          throw new ArgumentException("length (" + length +
            ") is less than 0");
        }
        if (length > bytes.Length) {
          throw new ArgumentException("length (" + length + ") is more than " +
            bytes.Length);
        }
        if (bytes.Length - offset < length) {
          throw new ArgumentException("bytes's length minus " + offset + " (" +
            (bytes.Length - offset) + ") is less than " + length);
        }
        for (int i = 0; i < length; ++i) {
          this.output.WriteByte((byte)bytes[i]);
        }
      }
    }

    private sealed class WrappedStream : IReader {
      private readonly Stream stream;

      public WrappedStream(Stream stream) {
        this.stream = stream;
      }

    /// <include file='../docs.xml'
    /// path='docs/doc[@name="M:PeterO.DataIO.WrappedStream.ReadByte"]/*'/>
      public int ReadByte() {
        try {
          return this.stream.ReadByte();
        } catch (IOException ex) {
          throw new InvalidOperationException(ex.Message, ex);
        }
      }

      public int Read(byte[] bytes, int offset, int length) {
        try {
          return Math.Max(0, this.stream.Read(bytes, offset, length));
        } catch (IOException ex) {
          throw new InvalidOperationException(ex.Message, ex);
        }
      }
    }
  }
}
