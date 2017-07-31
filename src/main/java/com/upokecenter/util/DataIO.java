package com.upokecenter.util;
/*
Written by Peter O. in 2014.
Any copyright is dedicated to the Public Domain.
http://creativecommons.org/publicdomain/zero/1.0/
If you like this, you should donate to Peter O.
at: http://peteroupc.github.io/
 */

import java.io.*;

    /**
     *
     */
  public final class DataIO {
private DataIO() {
}
    /**
     *
     */
    public static IReader ToReader(byte[] bytes) {
      if (bytes == null) {
        throw new NullPointerException("bytes");
      }
      return new ByteArrayTransform(bytes, 0, bytes.length);
    }

    /**
     *
     */
    public static IReader ToReader(
  byte[] bytes,
  int offset,
  int length) {
      if (bytes == null) {
        throw new NullPointerException("bytes");
      }
      if (offset < 0) {
        throw new IllegalArgumentException("offset (" + offset +
          ") is less than 0");
      }
      if (offset > bytes.length) {
        throw new IllegalArgumentException("offset (" + offset + ") is more than " +
          bytes.length);
      }
      if (length < 0) {
        throw new IllegalArgumentException("length (" + length +
          ") is less than 0");
      }
      if (length > bytes.length) {
        throw new IllegalArgumentException("length (" + length + ") is more than " +
          bytes.length);
      }
      if (bytes.length - offset < length) {
        throw new IllegalArgumentException("bytes's length minus " + offset + " (" +
          (bytes.length - offset) + ") is less than " + length);
      }
      return new ByteArrayTransform(bytes, offset, length);
    }

    /**
     *
     */
    public static IReader ToReader(InputStream input) {
      if (input == null) {
        throw new NullPointerException("input");
      }
      return new WrappedStream(input);
    }

    /**
     *
     * @deprecated Use ToReader instead.
 */
@Deprecated
    public static IByteReader ToByteReader(
  byte[] bytes,
  int offset,
  int length) {
  return (IByteReader)ToReader(bytes, offset, length);
}

    /**
     *
     * @deprecated Use ToReader instead.
 */
@Deprecated
    public static IByteReader ToByteReader(InputStream input) {
  return (IByteReader)ToReader(input);
    }

    /**
     *
     * @deprecated Use ToReader instead.
 */
@Deprecated
    public static IByteReader ToByteReader(byte[] bytes) {
  return (IByteReader)ToReader(bytes);
    }

    /**
     *
     */
    public static IWriter ToWriter(OutputStream output) {
      if (output == null) {
        throw new NullPointerException("output");
      }
      return new WrappedOutputStream(output);
    }

    /**
     *
     */
    public static IWriter ToWriter(IByteWriter output) {
      if (output == null) {
        throw new NullPointerException("output");
      }
      return new WrappedOutputStreamFromByteWriter(output);
    }

    private static final class ByteArrayTransform implements IReader {
      private final byte[] bytes;
      private final int endOffset;
      private int offset;

      public ByteArrayTransform(byte[] bytes, int offset, int length) {
        this.bytes = bytes;
        this.offset = offset;
        this.endOffset = offset + length;
      }

    /**
     *
     */
      public int read() {
        if (this.offset >= this.endOffset) {
          return -1;
        }
        int b = this.bytes[this.offset];
        ++this.offset;
        return ((int)b) & 0xff;
      }

    /**
     *
     */
      public int Read(byte[] bytes, int offset, int length) {
        if (bytes == null) {
  throw new NullPointerException("bytes");
}
if (offset < 0) {
  throw new IllegalArgumentException("offset (" + offset +
    ") is less than 0");
}
if (offset > bytes.length) {
  throw new IllegalArgumentException("offset (" + offset +
    ") is more than " + bytes.length);
}
if (length < 0) {
  throw new IllegalArgumentException("length (" + length +
    ") is less than 0");
}
if (length > bytes.length) {
  throw new IllegalArgumentException("length (" + length +
    ") is more than " + bytes.length);
}
if (bytes.length - offset < length) {
  throw new IllegalArgumentException("bytes's length minus " + offset + " (" +
    (bytes.length - offset) + ") is less than " + length);
}
        int count = 0;
        for (int i = 0; i < length; ++i) {
          int c = this.read();
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

    private static final class WrappedOutputStream implements IWriter {
      private final OutputStream output;

      public WrappedOutputStream(OutputStream output) {
        this.output = output;
      }

    /**
     *
     */
      public void write(int byteValue) {
        try {
          this.output.write((byte)byteValue);
        } catch (IOException ex) {
          throw new IllegalStateException(ex.getMessage(), ex);
        }
      }

    /**
     *
     */
      public void write(byte[] bytes, int offset, int length) {
        try {
          this.output.write(bytes, offset, length);
        } catch (IOException ex) {
          throw new IllegalStateException(ex.getMessage(), ex);
        }
      }
    }

    private static final class WrappedOutputStreamFromByteWriter implements IWriter {
      private final IByteWriter output;

      public WrappedOutputStreamFromByteWriter(IByteWriter output) {
        this.output = output;
      }

    /**
     *
     */
      public void write(int byteValue) {
        this.output.write((byte)byteValue);
      }

    /**
     *
     */
      public void write(byte[] bytes, int offset, int length) {
        if (bytes == null) {
          throw new NullPointerException("bytes");
        }
        if (offset < 0) {
          throw new IllegalArgumentException("offset (" + offset +
            ") is less than 0");
        }
        if (offset > bytes.length) {
          throw new IllegalArgumentException("offset (" + offset + ") is more than " +
            bytes.length);
        }
        if (length < 0) {
          throw new IllegalArgumentException("length (" + length +
            ") is less than 0");
        }
        if (length > bytes.length) {
          throw new IllegalArgumentException("length (" + length + ") is more than " +
            bytes.length);
        }
        if (bytes.length - offset < length) {
          throw new IllegalArgumentException("bytes's length minus " + offset + " (" +
            (bytes.length - offset) + ") is less than " + length);
        }
        for (int i = 0; i < length; ++i) {
          this.output.write((byte)bytes[i]);
        }
      }
    }

    private static final class WrappedStream implements IReader {
      private final InputStream stream;

      public WrappedStream(InputStream stream) {
        this.stream = stream;
      }

    /**
     *
     */
      public int read() {
        try {
          return this.stream.read();
        } catch (IOException ex) {
          throw new IllegalStateException(ex.getMessage(), ex);
        }
      }

      public int Read(byte[] bytes, int offset, int length) {
        try {
          return Math.max(0, this.stream.read(bytes, offset, length));
        } catch (IOException ex) {
          throw new IllegalStateException(ex.getMessage(), ex);
        }
      }
    }
  }
