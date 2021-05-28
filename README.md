Encoding
=======

[![NuGet Status](http://img.shields.io/nuget/v/PeterO.Encoding.svg?style=flat)](https://www.nuget.org/packages/PeterO.Encoding)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.peteroupc/encoding.svg?style=plastic)](https://search.maven.org/#search|ga|1|g%3A%22com.github.peteroupc%22%20AND%20a%3A%22encoding%22)

**Download source code: [ZIP file](https://github.com/peteroupc/MailLib/archive/master.zip)**

----

A portable library in C# and Java that implements character encodings used in Web pages and email.

It implements the Encoding Standard, which is currently a candidate recommendation at the time of this writing.

How to Install
---------
The C# implementation is available in the
NuGet Package Gallery under the name
[PeterO.Encoding](https://www.nuget.org/packages/PeterO.Encoding). To install
this library as a NuGet package, enter `Install-Package PeterO.Encoding` in the
NuGet Package Manager Console.

The Java implementation is available
as an [artifact](https://search.maven.org/#search|ga|1|g%3A%22com.github.peteroupc%22%20AND%20a%3A%22encoding%22) in the Central Repository. To add this library to a Maven
project, add the following to the `dependencies` section in your `pom.xml` file:

    <dependency>
      <groupId>com.github.peteroupc</groupId>
      <artifactId>encoding</artifactId>
      <version>0.6.0</version>
    </dependency>

In other Java-based environments, the library can be referred to by its
group ID (`com.github.peteroupc`), artifact ID (`encoding`), and version, as given above.

Documentation
------------

**See the [Java API documentation](https://peteroupc.github.io/Encoding/api/).**

**See the [C# (.NET) API documentation](https://peteroupc.github.io/Encoding/docs/).**

Examples
-------------

In C#.

```
    // Reads text from a UTF-8/UTF-16/UTF-32 file
    public static string ReadTextFromFile(string filename) {
      using (var stream = new FileStream(filename, FileMode.Open)) {
        return new CharacterReader(stream, 2).InputToString();
      }
    }
```

```
    // Reads text from a SHIFT-JIS stream, but uses UTF-8/UTF-16
    // instead if it detects byte order marks
      using (var stream = new FileStream(filename, FileMode.Open)) {
        return Encodings.GetEncoding("shift_jis")
           .GetDecoderInputSkipBom(stream).InputToString();
      }
```

```
    // Writes text in UTF-8 to a file
      using (var stream = new FileStream(filename, FileMode.Create)) {
        var str="Hello world!"
        str.EncodeToWriter(Encodings.UTF8,stream);
      }
```

History
-----------

Version 0.6.0:

- Bug fixes

Version 0.5.1:

- Fixed issue in .NET 2.0 and 4.0 assemblies where resources were inadvertently left out of build.

Version 0.5.0:

- Separate aliases and encodings for email are used, for better conformance to MIME.
- New methods added to Encodings class.
- Endian-independent UTF-16 encoding added for email.
- ISO-2022-JP-2 and ISO-2022-KR encodings added for email.
- .NET 2 and .NET 4 assemblies added to NuGet package.

Version 0.4.0:

- Updated to latest Encoding Standard draft as of Jun. 28, 2018, except for a bug fix in one encoding.

Version 0.3.2:

- Version change needed to properly refer to version.

Version 0.3.1:

- Marked assembly as CLS-compliant.

Version 0.3:

- Converted project to .NET Standard

Version 0.2.1:

- Fix ResolveAliasForEmail method to conform to new behavior
in version 0.2.0

Version 0.2.0:

- Update implementation to latest candidate recommendation of Encoding Standard
- ResolveAlias may return a mixed-case encoding name (as opposed to a lower-case one).
- Add overloads to CharacterReader constructor
- Add IReader interface
- Deprecated some methods of DataIO
- Add a few overloads in Encodings class, especially EncodeToWriter
- Bug fixes

Version 0.1.0:

- First release

About
-----------

Written by Peter O.

Any copyright to this work is released to the Public Domain.
In case this is not possible, this work is also
licensed under Creative Commons Zero (CC0):
[https://creativecommons.org/publicdomain/zero/1.0/](https://creativecommons.org/publicdomain/zero/1.0/)
