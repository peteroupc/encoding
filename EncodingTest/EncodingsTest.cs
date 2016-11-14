using NUnit.Framework;
using PeterO;
using PeterO.Text;
using System;

namespace MailLibTest {
  [TestFixture]
  public partial class EncodingsTest {
    [Test]
    public void TestDecodeToString() {
      // not implemented yet
    }
    [Test]
    public void TestEncodeToBytes() {
      try {
        ICharacterInput ici = null;
        Encodings.EncodeToBytes(ici, Encodings.UTF8);
        Assert.Fail("Should have failed");
      } catch (ArgumentNullException) {
        new Object();
      } catch (Exception ex) {
        Assert.Fail(ex.ToString());
        throw new InvalidOperationException(String.Empty, ex);
      }
      try {
        Encodings.EncodeToBytes("test", null);
        Assert.Fail("Should have failed");
      } catch (ArgumentNullException) {
        new Object();
      } catch (Exception ex) {
        Assert.Fail(ex.ToString());
        throw new InvalidOperationException(String.Empty, ex);
      }
    }
    [Test]
    public void TestEncodeToWriter() {
      // not implemented yet
    }
    [Test]
    public void TestGetDecoderInput() {
      // not implemented yet
    }
    [Test]
    public void TestGetDecoderInputSkipBom() {
ICharacterInput input;
IByteReader reader;
ICharacterEncoding wenc=Encodings.GetEncoding("windows-1252");
reader = DataIO.ToReader(new byte[] { 0xef, 0xbb, 0xbf, 0x41, 0x42, 0x43 });
input = Encodings.GetDecoderInputSkipBom(wenc, reader);
{
string stringTemp = Encodings.InputToString(input);
Assert.AreEqual(
  "ABC",
  stringTemp);
}
reader = DataIO.ToReader(new byte[] { 0xff, 0xfe, 0x41, 0, 0x42, 0, 0x43, 0 });
input = Encodings.GetDecoderInputSkipBom(wenc, reader);
{
string stringTemp = Encodings.InputToString(input);
Assert.AreEqual(
  "ABC",
  stringTemp);
}
reader = DataIO.ToReader(new byte[] { 0xfe, 0xff, 0, 0x41, 0, 0x42, 0, 0x43 });
input = Encodings.GetDecoderInputSkipBom(wenc, reader);
{
string stringTemp = Encodings.InputToString(input);
Assert.AreEqual(
  "ABC",
  stringTemp);
}
reader = DataIO.ToReader(new byte[] { 0x41, 0x42, 0x43 });
input = Encodings.GetDecoderInputSkipBom(wenc, reader);
{
string stringTemp = Encodings.InputToString(input);
Assert.AreEqual(
  "ABC",
  stringTemp);
}
    }
    [Test]
    public void TestGetEncoding() {
      if ((Encodings.GetEncoding("utf-8")) == null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("Utf-8")) == null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("uTf-8")) == null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("utF-8")) == null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("UTF-8")) == null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("utg-8")) != null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("utf-9")) != null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("   utf-8    ")) == null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("   utf-8")) == null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("utf-8    ")) == null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("\t\tutf-8\t\t")) == null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding(" \r\n utf-8 \r ")) == null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("\nutf-8\n")) == null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("\tutf-8\t")) == null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("\rutf-8\r")) == null) {
        Assert.Fail();
      }
      if ((Encodings.GetEncoding("\futf-8\f")) == null) {
        Assert.Fail();
      }
    }
    [Test]
    public void TestInputToString() {
      // not implemented yet
    }
    [Test]
    public void TestResolveAlias() {
      Assert.AreEqual(String.Empty, Encodings.ResolveAlias(null));
      Assert.AreEqual(String.Empty, Encodings.ResolveAlias(String.Empty));
      {
string stringTemp = Encodings.ResolveAlias("unicode-1-1-utf-8");
Assert.AreEqual(
  "UTF-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("UNICODE-1-1-UTF-8");
Assert.AreEqual(
  "UTF-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("utf-8");
Assert.AreEqual(
  "UTF-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("UTF-8");
Assert.AreEqual(
  "UTF-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("utf8");
Assert.AreEqual(
  "UTF-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("UTF8");
Assert.AreEqual(
  "UTF-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("866");
Assert.AreEqual(
  "IBM866",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cp866");
Assert.AreEqual(
  "IBM866",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CP866");
Assert.AreEqual(
  "IBM866",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csibm866");
Assert.AreEqual(
  "IBM866",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSIBM866");
Assert.AreEqual(
  "IBM866",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ibm866");
Assert.AreEqual(
  "IBM866",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("IBM866");
Assert.AreEqual(
  "IBM866",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csisolatin2");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISOLATIN2");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-2");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-2");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-ir-101");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-IR-101");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-2");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-2");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso88592");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO88592");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-2");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-2");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-2:1987");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-2:1987");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("l2");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("L2");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("latin2");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("LATIN2");
Assert.AreEqual(
  "ISO-8859-2",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csisolatin3");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISOLATIN3");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-3");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-3");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-ir-109");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-IR-109");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-3");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-3");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso88593");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO88593");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-3");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-3");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-3:1988");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-3:1988");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("l3");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("L3");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("latin3");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("LATIN3");
Assert.AreEqual(
  "ISO-8859-3",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csisolatin4");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISOLATIN4");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-4");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-4");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-ir-110");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-IR-110");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-4");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-4");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso88594");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO88594");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-4");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-4");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-4:1988");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-4:1988");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("l4");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("L4");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("latin4");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("LATIN4");
Assert.AreEqual(
  "ISO-8859-4",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csisolatincyrillic");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISOLATINCYRILLIC");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cyrillic");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CYRILLIC");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-5");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-5");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-ir-144");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-IR-144");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-5");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-5");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso88595");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO88595");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-5");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-5");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-5:1988");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-5:1988");
Assert.AreEqual(
  "ISO-8859-5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("arabic");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ARABIC");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("asmo-708");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ASMO-708");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csiso88596e");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISO88596E");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csiso88596i");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISO88596I");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csisolatinarabic");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISOLATINARABIC");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ecma-114");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ECMA-114");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-6");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-6");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-6-e");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-6-E");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-6-i");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-6-I");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-ir-127");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-IR-127");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-6");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-6");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso88596");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO88596");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-6");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-6");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-6:1987");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-6:1987");
Assert.AreEqual(
  "ISO-8859-6",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csisolatingreek");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISOLATINGREEK");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ecma-118");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ECMA-118");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("elot_928");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ELOT_928");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("greek");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("GREEK");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("greek8");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("GREEK8");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-7");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-7");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-ir-126");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-IR-126");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-7");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-7");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso88597");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO88597");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-7");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-7");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-7:1987");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-7:1987");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("sun_eu_greek");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("SUN_EU_GREEK");
Assert.AreEqual(
  "ISO-8859-7",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csiso88598e");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISO88598E");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csisolatinhebrew");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISOLATINHEBREW");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("hebrew");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("HEBREW");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-8");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-8");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-8-e");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-8-E");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-ir-138");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-IR-138");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-8");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-8");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso88598");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO88598");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-8");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-8");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-8:1988");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-8:1988");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("visual");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("VISUAL");
Assert.AreEqual(
  "ISO-8859-8",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csiso88598i");
Assert.AreEqual(
  "ISO-8859-8-I",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISO88598I");
Assert.AreEqual(
  "ISO-8859-8-I",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-8-i");
Assert.AreEqual(
  "ISO-8859-8-I",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-8-I");
Assert.AreEqual(
  "ISO-8859-8-I",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("logical");
Assert.AreEqual(
  "ISO-8859-8-I",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("LOGICAL");
Assert.AreEqual(
  "ISO-8859-8-I",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csisolatin6");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISOLATIN6");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-10");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-10");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-ir-157");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-IR-157");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-10");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-10");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso885910");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO885910");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("l6");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("L6");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("latin6");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("LATIN6");
Assert.AreEqual(
  "ISO-8859-10",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-13");
Assert.AreEqual(
  "ISO-8859-13",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-13");
Assert.AreEqual(
  "ISO-8859-13",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-13");
Assert.AreEqual(
  "ISO-8859-13",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-13");
Assert.AreEqual(
  "ISO-8859-13",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso885913");
Assert.AreEqual(
  "ISO-8859-13",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO885913");
Assert.AreEqual(
  "ISO-8859-13",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-14");
Assert.AreEqual(
  "ISO-8859-14",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-14");
Assert.AreEqual(
  "ISO-8859-14",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-14");
Assert.AreEqual(
  "ISO-8859-14",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-14");
Assert.AreEqual(
  "ISO-8859-14",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso885914");
Assert.AreEqual(
  "ISO-8859-14",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO885914");
Assert.AreEqual(
  "ISO-8859-14",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csisolatin9");
Assert.AreEqual(
  "ISO-8859-15",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISOLATIN9");
Assert.AreEqual(
  "ISO-8859-15",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-15");
Assert.AreEqual(
  "ISO-8859-15",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-15");
Assert.AreEqual(
  "ISO-8859-15",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-15");
Assert.AreEqual(
  "ISO-8859-15",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-15");
Assert.AreEqual(
  "ISO-8859-15",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso885915");
Assert.AreEqual(
  "ISO-8859-15",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO885915");
Assert.AreEqual(
  "ISO-8859-15",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-15");
Assert.AreEqual(
  "ISO-8859-15",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-15");
Assert.AreEqual(
  "ISO-8859-15",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("l9");
Assert.AreEqual(
  "ISO-8859-15",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("L9");
Assert.AreEqual(
  "ISO-8859-15",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-16");
Assert.AreEqual(
  "ISO-8859-16",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-16");
Assert.AreEqual(
  "ISO-8859-16",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cskoi8r");
Assert.AreEqual(
  "KOI8-R",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSKOI8R");
Assert.AreEqual(
  "KOI8-R",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("koi");
Assert.AreEqual(
  "KOI8-R",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("KOI");
Assert.AreEqual(
  "KOI8-R",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("koi8");
Assert.AreEqual(
  "KOI8-R",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("KOI8");
Assert.AreEqual(
  "KOI8-R",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("koi8-r");
Assert.AreEqual(
  "KOI8-R",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("KOI8-R");
Assert.AreEqual(
  "KOI8-R",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("koi8_r");
Assert.AreEqual(
  "KOI8-R",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("KOI8_R");
Assert.AreEqual(
  "KOI8-R",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("koi8-ru");
Assert.AreEqual(
  "KOI8-U",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("KOI8-RU");
Assert.AreEqual(
  "KOI8-U",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("koi8-u");
Assert.AreEqual(
  "KOI8-U",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("KOI8-U");
Assert.AreEqual(
  "KOI8-U",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csmacintosh");
Assert.AreEqual(
  "macintosh",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSMACINTOSH");
Assert.AreEqual(
  "macintosh",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("mac");
Assert.AreEqual(
  "macintosh",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("MAC");
Assert.AreEqual(
  "macintosh",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("macintosh");
Assert.AreEqual(
  "macintosh",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("MACINTOSH");
Assert.AreEqual(
  "macintosh",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-mac-roman");
Assert.AreEqual(
  "macintosh",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-MAC-ROMAN");
Assert.AreEqual(
  "macintosh",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("dos-874");
Assert.AreEqual(
  "windows-874",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("DOS-874");
Assert.AreEqual(
  "windows-874",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-11");
Assert.AreEqual(
  "windows-874",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-11");
Assert.AreEqual(
  "windows-874",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-11");
Assert.AreEqual(
  "windows-874",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-11");
Assert.AreEqual(
  "windows-874",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso885911");
Assert.AreEqual(
  "windows-874",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO885911");
Assert.AreEqual(
  "windows-874",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("tis-620");
Assert.AreEqual(
  "windows-874",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("TIS-620");
Assert.AreEqual(
  "windows-874",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("windows-874");
Assert.AreEqual(
  "windows-874",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("WINDOWS-874");
Assert.AreEqual(
  "windows-874",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cp1250");
Assert.AreEqual(
  "windows-1250",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CP1250");
Assert.AreEqual(
  "windows-1250",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("windows-1250");
Assert.AreEqual(
  "windows-1250",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("WINDOWS-1250");
Assert.AreEqual(
  "windows-1250",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-cp1250");
Assert.AreEqual(
  "windows-1250",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-CP1250");
Assert.AreEqual(
  "windows-1250",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cp1251");
Assert.AreEqual(
  "windows-1251",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CP1251");
Assert.AreEqual(
  "windows-1251",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("windows-1251");
Assert.AreEqual(
  "windows-1251",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("WINDOWS-1251");
Assert.AreEqual(
  "windows-1251",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-cp1251");
Assert.AreEqual(
  "windows-1251",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-CP1251");
Assert.AreEqual(
  "windows-1251",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ansi_x3.4-1968");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ANSI_X3.4-1968");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ascii");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ASCII");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cp1252");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CP1252");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cp819");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CP819");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csisolatin1");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISOLATIN1");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ibm819");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("IBM819");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-1");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-1");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-ir-100");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-IR-100");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-1");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-1");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso88591");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO88591");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-1");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-1");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-1:1987");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-1:1987");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("l1");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("L1");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("latin1");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("LATIN1");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("us-ascii");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("US-ASCII");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("windows-1252");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("WINDOWS-1252");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-cp1252");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-CP1252");
Assert.AreEqual(
  "windows-1252",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cp1253");
Assert.AreEqual(
  "windows-1253",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CP1253");
Assert.AreEqual(
  "windows-1253",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("windows-1253");
Assert.AreEqual(
  "windows-1253",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("WINDOWS-1253");
Assert.AreEqual(
  "windows-1253",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-cp1253");
Assert.AreEqual(
  "windows-1253",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-CP1253");
Assert.AreEqual(
  "windows-1253",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cp1254");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CP1254");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csisolatin5");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISOLATIN5");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-8859-9");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-8859-9");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-ir-148");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-IR-148");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso8859-9");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO8859-9");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso88599");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO88599");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-9");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-9");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso_8859-9:1989");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO_8859-9:1989");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("l5");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("L5");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("latin5");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("LATIN5");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("windows-1254");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("WINDOWS-1254");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-cp1254");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-CP1254");
Assert.AreEqual(
  "windows-1254",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cp1255");
Assert.AreEqual(
  "windows-1255",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CP1255");
Assert.AreEqual(
  "windows-1255",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("windows-1255");
Assert.AreEqual(
  "windows-1255",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("WINDOWS-1255");
Assert.AreEqual(
  "windows-1255",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-cp1255");
Assert.AreEqual(
  "windows-1255",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-CP1255");
Assert.AreEqual(
  "windows-1255",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cp1256");
Assert.AreEqual(
  "windows-1256",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CP1256");
Assert.AreEqual(
  "windows-1256",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("windows-1256");
Assert.AreEqual(
  "windows-1256",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("WINDOWS-1256");
Assert.AreEqual(
  "windows-1256",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-cp1256");
Assert.AreEqual(
  "windows-1256",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-CP1256");
Assert.AreEqual(
  "windows-1256",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cp1257");
Assert.AreEqual(
  "windows-1257",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CP1257");
Assert.AreEqual(
  "windows-1257",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("windows-1257");
Assert.AreEqual(
  "windows-1257",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("WINDOWS-1257");
Assert.AreEqual(
  "windows-1257",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-cp1257");
Assert.AreEqual(
  "windows-1257",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-CP1257");
Assert.AreEqual(
  "windows-1257",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cp1258");
Assert.AreEqual(
  "windows-1258",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CP1258");
Assert.AreEqual(
  "windows-1258",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("windows-1258");
Assert.AreEqual(
  "windows-1258",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("WINDOWS-1258");
Assert.AreEqual(
  "windows-1258",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-cp1258");
Assert.AreEqual(
  "windows-1258",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-CP1258");
Assert.AreEqual(
  "windows-1258",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-mac-cyrillic");
Assert.AreEqual(
  "x-mac-cyrillic",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-MAC-CYRILLIC");
Assert.AreEqual(
  "x-mac-cyrillic",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-mac-ukrainian");
Assert.AreEqual(
  "x-mac-cyrillic",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-MAC-UKRAINIAN");
Assert.AreEqual(
  "x-mac-cyrillic",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("chinese");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CHINESE");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csgb2312");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSGB2312");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csiso58gb231280");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISO58GB231280");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("gb2312");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("GB2312");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("gb_2312");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("GB_2312");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("gb_2312-80");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("GB_2312-80");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("gbk");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("GBK");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-ir-58");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-IR-58");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-gbk");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-GBK");
Assert.AreEqual(
  "GBK",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("gb18030");
Assert.AreEqual(
  "gb18030",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("GB18030");
Assert.AreEqual(
  "gb18030",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("big5");
Assert.AreEqual(
  "Big5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("BIG5");
Assert.AreEqual(
  "Big5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("big5-hkscs");
Assert.AreEqual(
  "Big5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("BIG5-HKSCS");
Assert.AreEqual(
  "Big5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cn-big5");
Assert.AreEqual(
  "Big5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CN-BIG5");
Assert.AreEqual(
  "Big5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csbig5");
Assert.AreEqual(
  "Big5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSBIG5");
Assert.AreEqual(
  "Big5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-x-big5");
Assert.AreEqual(
  "Big5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-X-BIG5");
Assert.AreEqual(
  "Big5",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cseucpkdfmtjapanese");
Assert.AreEqual(
  "EUC-JP",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSEUCPKDFMTJAPANESE");
Assert.AreEqual(
  "EUC-JP",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("euc-jp");
Assert.AreEqual(
  "EUC-JP",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("EUC-JP");
Assert.AreEqual(
  "EUC-JP",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-euc-jp");
Assert.AreEqual(
  "EUC-JP",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-EUC-JP");
Assert.AreEqual(
  "EUC-JP",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csiso2022jp");
Assert.AreEqual(
  "ISO-2022-JP",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISO2022JP");
Assert.AreEqual(
  "ISO-2022-JP",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-2022-jp");
Assert.AreEqual(
  "ISO-2022-JP",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-2022-JP");
Assert.AreEqual(
  "ISO-2022-JP",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csshiftjis");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSSHIFTJIS");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ms932");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("MS932");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ms_kanji");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("MS_KANJI");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("shift-jis");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("SHIFT-JIS");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("shift_jis");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("SHIFT_JIS");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("sjis");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("SJIS");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("windows-31j");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("WINDOWS-31J");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-sjis");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-SJIS");
Assert.AreEqual(
  "Shift_JIS",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("cseuckr");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSEUCKR");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csksc56011987");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSKSC56011987");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("euc-kr");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("EUC-KR");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-ir-149");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-IR-149");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("korean");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("KOREAN");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ks_c_5601-1987");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("KS_C_5601-1987");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ks_c_5601-1989");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("KS_C_5601-1989");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ksc5601");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("KSC5601");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ksc_5601");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("KSC_5601");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("windows-949");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("WINDOWS-949");
Assert.AreEqual(
  "EUC-KR",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("csiso2022kr");
Assert.AreEqual(
  "replacement",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("CSISO2022KR");
Assert.AreEqual(
  "replacement",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("hz-gb-2312");
Assert.AreEqual(
  "replacement",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("HZ-GB-2312");
Assert.AreEqual(
  "replacement",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-2022-cn");
Assert.AreEqual(
  "replacement",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-2022-CN");
Assert.AreEqual(
  "replacement",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-2022-cn-ext");
Assert.AreEqual(
  "replacement",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-2022-CN-EXT");
Assert.AreEqual(
  "replacement",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("iso-2022-kr");
Assert.AreEqual(
  "replacement",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("ISO-2022-KR");
Assert.AreEqual(
  "replacement",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("utf-16be");
Assert.AreEqual(
  "UTF-16BE",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("UTF-16BE");
Assert.AreEqual(
  "UTF-16BE",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("utf-16");
Assert.AreEqual(
  "UTF-16LE",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("UTF-16");
Assert.AreEqual(
  "UTF-16LE",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("utf-16le");
Assert.AreEqual(
  "UTF-16LE",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("UTF-16LE");
Assert.AreEqual(
  "UTF-16LE",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("x-user-defined");
Assert.AreEqual(
  "x-user-defined",
  stringTemp);
}
{
string stringTemp = Encodings.ResolveAlias("X-USER-DEFINED");
Assert.AreEqual(
  "x-user-defined",
  stringTemp);
}
      {
        string stringTemp = Encodings.ResolveAlias("iso-8859-1");
        Assert.AreEqual(
        "windows-1252",
        stringTemp);
      }
            {
                string stringTemp = Encodings.ResolveAlias ("big5");
                Assert.AreEqual (
                "Big5",
                stringTemp);
            }
            {
        string stringTemp = Encodings.ResolveAlias("windows-1252");
        Assert.AreEqual(
        "windows-1252",
        stringTemp);
      }
      {
        string stringTemp = Encodings.ResolveAlias("us-ascii");
        Assert.AreEqual(
        "windows-1252",
        stringTemp);
      }
      Assert.AreEqual(String.Empty, Encodings.ResolveAlias("utf-7"));
      Assert.AreEqual(String.Empty, Encodings.ResolveAlias("replacement"));
      {
        string stringTemp = Encodings.ResolveAlias("hz-gb-2312");
        Assert.AreEqual(
        "replacement",
        stringTemp);
      }
    }
    [Test]
    public void TestResolveAliasForEmail() {
      Assert.AreEqual(String.Empty, Encodings.ResolveAliasForEmail(null));
      Assert.AreEqual(String.Empty,
           Encodings.ResolveAliasForEmail(String.Empty));
      {
        string stringTemp = Encodings.ResolveAliasForEmail("iso-8859-1");
        Assert.AreEqual(
        "ISO-8859-1",
        stringTemp);
      }
      {
        string stringTemp = Encodings.ResolveAliasForEmail("windows-1252");
        Assert.AreEqual(
        "windows-1252",
        stringTemp);
      }
      {
        string stringTemp = Encodings.ResolveAliasForEmail("us-ascii");
        Assert.AreEqual(
        "US-ASCII",
        stringTemp);
      }
      {
        string stringTemp = Encodings.ResolveAliasForEmail("utf-7");
        Assert.AreEqual(
        "UTF-7",
        stringTemp);
      }
      {
object objectTemp = String.Empty;
object objectTemp2 = Encodings.ResolveAliasForEmail(
    "replacement");
Assert.AreEqual(objectTemp, objectTemp2);
}
      {
        string stringTemp = Encodings.ResolveAliasForEmail("hz-gb-2312");
        Assert.AreEqual(
        "replacement",
        stringTemp);
      }
    }

    [Test]
    public void TestStringToBytes() {
      // not implemented yet
    }
    [Test]
    public void TestStringToInput() {
      try {
        Encodings.StringToInput(null, 0, 0);
        Assert.Fail("Should have failed");
      } catch (ArgumentNullException) {
        new Object();
      } catch (Exception ex) {
        Assert.Fail(ex.ToString());
        throw new InvalidOperationException(String.Empty, ex);
      }
      try {
        Encodings.StringToInput("t", -1, 1);
        Assert.Fail("Should have failed");
      } catch (ArgumentException) {
        new Object();
      } catch (Exception ex) {
        Assert.Fail(ex.ToString());
        throw new InvalidOperationException(String.Empty, ex);
      }
      try {
        Encodings.StringToInput("t", 5, 1);
        Assert.Fail("Should have failed");
      } catch (ArgumentException) {
        new Object();
      } catch (Exception ex) {
        Assert.Fail(ex.ToString());
        throw new InvalidOperationException(String.Empty, ex);
      }
      try {
        Encodings.StringToInput("t", 0, -1);
        Assert.Fail("Should have failed");
      } catch (ArgumentException) {
        new Object();
      } catch (Exception ex) {
        Assert.Fail(ex.ToString());
        throw new InvalidOperationException(String.Empty, ex);
      }
      try {
        Encodings.StringToInput("t", 0, 5);
        Assert.Fail("Should have failed");
      } catch (ArgumentException) {
        new Object();
      } catch (Exception ex) {
        Assert.Fail(ex.ToString());
        throw new InvalidOperationException(String.Empty, ex);
      }
      try {
        Encodings.StringToInput("tt", 1, 2);
        Assert.Fail("Should have failed");
      } catch (ArgumentException) {
        new Object();
      } catch (Exception ex) {
        Assert.Fail(ex.ToString());
        throw new InvalidOperationException(String.Empty, ex);
      }
    }
  }
}
