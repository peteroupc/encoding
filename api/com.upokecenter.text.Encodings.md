# com.upokecenter.text.Encodings

    public final class Encodings extends Object

## Fields

* `static ICharacterEncoding UTF8`<br>

## Methods

* `static String DecodeToString(ICharacterEncoding enc,
              byte[] bytes)`<br>
* `static String DecodeToString(ICharacterEncoding enc,
              byte[] bytes,
              int offset,
              int length)`<br>
* `static String DecodeToString(ICharacterEncoding encoding,
              IByteReader input)`<br>
* `static String DecodeToString(ICharacterEncoding enc,
              InputStream input)`<br>
* `static byte[] EncodeToBytes(ICharacterInput input,
             ICharacterEncoder encoder)`<br>
* `static byte[] EncodeToBytes(ICharacterInput input,
             ICharacterEncoding encoding)`<br>
* `static byte[] EncodeToBytes(String str,
             ICharacterEncoding enc)`<br>
* `static void EncodeToWriter(ICharacterInput input,
              ICharacterEncoder encoder,
              IWriter writer)`<br>
* `static void EncodeToWriter(ICharacterInput input,
              ICharacterEncoder encoder,
              OutputStream output)`<br>
* `static void EncodeToWriter(ICharacterInput input,
              ICharacterEncoding encoding,
              IWriter writer)`<br>
* `static void EncodeToWriter(ICharacterInput input,
              ICharacterEncoding encoding,
              OutputStream output)`<br>
* `static void EncodeToWriter(String str,
              ICharacterEncoding enc,
              IWriter writer)`<br>
* `static void EncodeToWriter(String str,
              ICharacterEncoding enc,
              OutputStream output)`<br>
* `static ICharacterInput GetDecoderInput(ICharacterEncoding encoding,
               IByteReader stream)`<br>
* `static ICharacterInput GetDecoderInput(ICharacterEncoding encoding,
               InputStream input)`<br>
* `static ICharacterInput GetDecoderInputSkipBom(ICharacterEncoding encoding,
                      IByteReader stream)`<br>
* `static ICharacterInput GetDecoderInputSkipBom(ICharacterEncoding encoding,
                      InputStream input)`<br>
* `static ICharacterEncoding GetEncoding(String name)`<br>
* `static ICharacterEncoding GetEncoding(String name,
           boolean forEmail)`<br>
* `static ICharacterEncoding GetEncoding(String name,
           boolean forEmail,
           boolean allowReplacement)`<br>
* `static String InputToString(ICharacterInput reader)`<br>
* `static String ResolveAlias(String name)`<br>
* `static String ResolveAliasForEmail(String name)`<br>
* `static byte[] StringToBytes(ICharacterEncoder encoder,
             String str)`<br>
* `static byte[] StringToBytes(ICharacterEncoding encoding,
             String str)`<br>
* `static ICharacterInput StringToInput(String str)`<br>
* `static ICharacterInput StringToInput(String str,
             int offset,
             int length)`<br>

## Field Details

### UTF8
    public static final ICharacterEncoding UTF8
## Method Details

### DecodeToString
    public static String DecodeToString(ICharacterEncoding encoding, IByteReader input)
### DecodeToString
    public static String DecodeToString(ICharacterEncoding enc, InputStream input)
### DecodeToString
    public static String DecodeToString(ICharacterEncoding enc, byte[] bytes)
### DecodeToString
    public static String DecodeToString(ICharacterEncoding enc, byte[] bytes, int offset, int length)
### EncodeToBytes
    public static byte[] EncodeToBytes(ICharacterInput input, ICharacterEncoding encoding)
### EncodeToBytes
    public static byte[] EncodeToBytes(ICharacterInput input, ICharacterEncoder encoder)
### EncodeToBytes
    public static byte[] EncodeToBytes(String str, ICharacterEncoding enc)
### EncodeToWriter
    public static void EncodeToWriter(ICharacterInput input, ICharacterEncoding encoding, IWriter writer)
### EncodeToWriter
    public static void EncodeToWriter(ICharacterInput input, ICharacterEncoder encoder, IWriter writer)
### EncodeToWriter
    public static void EncodeToWriter(String str, ICharacterEncoding enc, IWriter writer)
### EncodeToWriter
    public static void EncodeToWriter(ICharacterInput input, ICharacterEncoding encoding, OutputStream output) throws IOException

**Throws:**

* <code>IOException</code>

### EncodeToWriter
    public static void EncodeToWriter(ICharacterInput input, ICharacterEncoder encoder, OutputStream output) throws IOException

**Throws:**

* <code>IOException</code>

### EncodeToWriter
    public static void EncodeToWriter(String str, ICharacterEncoding enc, OutputStream output) throws IOException

**Throws:**

* <code>IOException</code>

### GetDecoderInput
    public static ICharacterInput GetDecoderInput(ICharacterEncoding encoding, IByteReader stream)
### GetDecoderInput
    public static ICharacterInput GetDecoderInput(ICharacterEncoding encoding, InputStream input)
### GetDecoderInputSkipBom
    public static ICharacterInput GetDecoderInputSkipBom(ICharacterEncoding encoding, IByteReader stream)
### GetDecoderInputSkipBom
    public static ICharacterInput GetDecoderInputSkipBom(ICharacterEncoding encoding, InputStream input)
### GetEncoding
    public static ICharacterEncoding GetEncoding(String name)
### GetEncoding
    public static ICharacterEncoding GetEncoding(String name, boolean forEmail)
### GetEncoding
    public static ICharacterEncoding GetEncoding(String name, boolean forEmail, boolean allowReplacement)
### InputToString
    public static String InputToString(ICharacterInput reader)
### ResolveAlias
    public static String ResolveAlias(String name)
### ResolveAliasForEmail
    public static String ResolveAliasForEmail(String name)
### StringToBytes
    public static byte[] StringToBytes(ICharacterEncoding encoding, String str)
### StringToBytes
    public static byte[] StringToBytes(ICharacterEncoder encoder, String str)
### StringToInput
    public static ICharacterInput StringToInput(String str)
### StringToInput
    public static ICharacterInput StringToInput(String str, int offset, int length)
