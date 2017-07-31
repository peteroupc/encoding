# com.upokecenter.text.CharacterReader

    public final class CharacterReader extends Object implements ICharacterInput

## Methods

* `CharacterReader(InputStream stream)`<br>
* `CharacterReader(InputStream stream,
               int mode)`<br>
* `CharacterReader(InputStream stream,
               int mode,
               boolean errorThrow)`<br>
* `CharacterReader(InputStream stream,
               int mode,
               boolean errorThrow,
               boolean dontSkipUtf8Bom)`<br>
* `CharacterReader(String str)`<br>
* `CharacterReader(String str,
               boolean skipByteOrderMark)`<br>
* `CharacterReader(String str,
               boolean skipByteOrderMark,
               boolean errorThrow)`<br>
* `CharacterReader(String str,
               int offset,
               int length)`<br>
* `CharacterReader(String str,
               int offset,
               int length,
               boolean skipByteOrderMark,
               boolean errorThrow)`<br>
* `int Read(int[] chars,
    int index,
    int length)`<br>
* `int ReadChar()`<br>

## Constructors

* `CharacterReader(InputStream stream)`<br>
* `CharacterReader(InputStream stream,
               int mode)`<br>
* `CharacterReader(InputStream stream,
               int mode,
               boolean errorThrow)`<br>
* `CharacterReader(InputStream stream,
               int mode,
               boolean errorThrow,
               boolean dontSkipUtf8Bom)`<br>
* `CharacterReader(String str)`<br>
* `CharacterReader(String str,
               boolean skipByteOrderMark)`<br>
* `CharacterReader(String str,
               boolean skipByteOrderMark,
               boolean errorThrow)`<br>
* `CharacterReader(String str,
               int offset,
               int length)`<br>
* `CharacterReader(String str,
               int offset,
               int length,
               boolean skipByteOrderMark,
               boolean errorThrow)`<br>

## Method Details

### CharacterReader
    public CharacterReader(String str)
### CharacterReader
    public CharacterReader(String str, boolean skipByteOrderMark)
### CharacterReader
    public CharacterReader(String str, boolean skipByteOrderMark, boolean errorThrow)
### CharacterReader
    public CharacterReader(String str, int offset, int length)
### CharacterReader
    public CharacterReader(String str, int offset, int length, boolean skipByteOrderMark, boolean errorThrow)
### CharacterReader
    public CharacterReader(InputStream stream)
### CharacterReader
    public CharacterReader(InputStream stream, int mode, boolean errorThrow)
### CharacterReader
    public CharacterReader(InputStream stream, int mode)
### CharacterReader
    public CharacterReader(InputStream stream, int mode, boolean errorThrow, boolean dontSkipUtf8Bom)
### Read
    public int Read(int[] chars, int index, int length)

**Specified by:**

* <code>Read</code>&nbsp;in interface&nbsp;<code>ICharacterInput</code>

### ReadChar
    public int ReadChar()

**Specified by:**

* <code>ReadChar</code>&nbsp;in interface&nbsp;<code>ICharacterInput</code>
