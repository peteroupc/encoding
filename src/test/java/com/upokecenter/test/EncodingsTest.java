package com.upokecenter.test; import com.upokecenter.util.*;

import org.junit.Assert;
import org.junit.Test;
import com.upokecenter.util.*;
import com.upokecenter.text.*;

  public class EncodingsTest {
    @Test
    public void TestDecodeToString() {
      // not implemented yet
    }
    @Test
    public void TestEncodeToBytes() {
      try {
        ICharacterInput ici = null;
        Encodings.EncodeToBytes(ici, Encodings.UTF8);
        Assert.fail("Should have failed");
      } catch (NullPointerException ex) {
        // NOTE: Intentionally empty
      } catch (Exception ex) {
        Assert.fail(ex.toString());
        throw new IllegalStateException("", ex);
      }
      try {
        Encodings.EncodeToBytes("test", null);
        Assert.fail("Should have failed");
      } catch (NullPointerException ex) {
        // NOTE: Intentionally empty
      } catch (Exception ex) {
        Assert.fail(ex.toString());
        throw new IllegalStateException("", ex);
      }
    }
    @Test
    public void TestEncodeToWriter() {
      // not implemented yet
    }
    @Test
    public void TestGetDecoderInput() {
      // not implemented yet
    }
    @Test
    public void TestGetDecoderInputSkipBom() {
ICharacterInput input;
IByteReader reader;
ICharacterEncoding wenc = Encodings.GetEncoding("windows-1252");
reader = DataIO.ToReader(new byte[] { (byte)0xef, (byte)0xbb, (byte)0xbf, 0x41, 0x42, 0x43 });
input = Encodings.GetDecoderInputSkipBom(wenc, reader);
{
String stringTemp = Encodings.InputToString(input);
Assert.assertEquals(
  "ABC",
  stringTemp);
}
reader = DataIO.ToReader(new byte[] { (byte)0xff, (byte)0xfe, 0x41, 0, 0x42, 0, 0x43, 0 });
input = Encodings.GetDecoderInputSkipBom(wenc, reader);
{
String stringTemp = Encodings.InputToString(input);
Assert.assertEquals(
  "ABC",
  stringTemp);
}
reader = DataIO.ToReader(new byte[] { (byte)0xfe, (byte)0xff, 0, 0x41, 0, 0x42, 0, 0x43 });
input = Encodings.GetDecoderInputSkipBom(wenc, reader);
{
String stringTemp = Encodings.InputToString(input);
Assert.assertEquals(
  "ABC",
  stringTemp);
}
reader = DataIO.ToReader(new byte[] { 0x41, 0x42, 0x43 });
input = Encodings.GetDecoderInputSkipBom(wenc, reader);
{
String stringTemp = Encodings.InputToString(input);
Assert.assertEquals(
  "ABC",
  stringTemp);
}
    }
    @Test
    public void TestGetEncoding() {
      if (Encodings.GetEncoding("utf-8") == null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding("Utf-8") == null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding("uTf-8") == null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding("utF-8") == null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding("UTF-8") == null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding("utg-8") != null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding("utf-9") != null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding(" utf-8 ") == null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding(" utf-8") == null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding("utf-8 ") == null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding("\t\tutf-8\t\t") == null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding(" \r\n utf-8 \r ") == null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding("\nutf-8\n") == null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding("\tutf-8\t") == null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding("\rutf-8\r") == null) {
        Assert.fail();
      }
      if (Encodings.GetEncoding("\futf-8\f") == null) {
        Assert.fail();
      }
    }
    @Test
    public void TestInputToString() {
      // not implemented yet
    }
    @Test
    public void TestResolveAlias() {
      Assert.assertEquals("", Encodings.ResolveAlias(null));
      Assert.assertEquals("", Encodings.ResolveAlias(""));
      {
String stringTemp = Encodings.ResolveAlias("unicode-1-1-utf-8");
Assert.assertEquals(
  "UTF-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("UNICODE-1-1-UTF-8");
Assert.assertEquals(
  "UTF-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("utf-8");
Assert.assertEquals(
  "UTF-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("UTF-8");
Assert.assertEquals(
  "UTF-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("utf8");
Assert.assertEquals(
  "UTF-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("UTF8");
Assert.assertEquals(
  "UTF-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("866");
Assert.assertEquals(
  "IBM866",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cp866");
Assert.assertEquals(
  "IBM866",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CP866");
Assert.assertEquals(
  "IBM866",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csibm866");
Assert.assertEquals(
  "IBM866",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSIBM866");
Assert.assertEquals(
  "IBM866",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ibm866");
Assert.assertEquals(
  "IBM866",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("IBM866");
Assert.assertEquals(
  "IBM866",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csisolatin2");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISOLATIN2");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-2");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-2");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-ir-101");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-IR-101");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-2");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-2");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso88592");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO88592");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-2");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-2");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-2:1987");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-2:1987");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("l2");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("L2");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("latin2");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("LATIN2");
Assert.assertEquals(
  "ISO-8859-2",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csisolatin3");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISOLATIN3");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-3");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-3");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-ir-109");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-IR-109");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-3");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-3");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso88593");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO88593");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-3");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-3");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-3:1988");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-3:1988");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("l3");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("L3");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("latin3");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("LATIN3");
Assert.assertEquals(
  "ISO-8859-3",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csisolatin4");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISOLATIN4");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-4");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-4");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-ir-110");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-IR-110");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-4");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-4");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso88594");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO88594");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-4");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-4");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-4:1988");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-4:1988");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("l4");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("L4");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("latin4");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("LATIN4");
Assert.assertEquals(
  "ISO-8859-4",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csisolatincyrillic");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISOLATINCYRILLIC");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cyrillic");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CYRILLIC");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-5");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-5");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-ir-144");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-IR-144");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-5");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-5");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso88595");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO88595");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-5");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-5");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-5:1988");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-5:1988");
Assert.assertEquals(
  "ISO-8859-5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("arabic");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ARABIC");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("asmo-708");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ASMO-708");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csiso88596e");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISO88596E");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csiso88596i");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISO88596I");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csisolatinarabic");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISOLATINARABIC");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ecma-114");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ECMA-114");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-6");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-6");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-6-e");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-6-E");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-6-i");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-6-I");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-ir-127");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-IR-127");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-6");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-6");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso88596");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO88596");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-6");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-6");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-6:1987");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-6:1987");
Assert.assertEquals(
  "ISO-8859-6",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csisolatingreek");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISOLATINGREEK");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ecma-118");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ECMA-118");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("elot_928");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ELOT_928");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("greek");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("GREEK");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("greek8");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("GREEK8");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-7");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-7");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-ir-126");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-IR-126");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-7");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-7");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso88597");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO88597");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-7");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-7");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-7:1987");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-7:1987");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("sun_eu_greek");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("SUN_EU_GREEK");
Assert.assertEquals(
  "ISO-8859-7",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csiso88598e");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISO88598E");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csisolatinhebrew");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISOLATINHEBREW");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("hebrew");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("HEBREW");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-8");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-8");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-8-e");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-8-E");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-ir-138");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-IR-138");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-8");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-8");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso88598");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO88598");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-8");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-8");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-8:1988");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-8:1988");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("visual");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("VISUAL");
Assert.assertEquals(
  "ISO-8859-8",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csiso88598i");
Assert.assertEquals(
  "ISO-8859-8-I",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISO88598I");
Assert.assertEquals(
  "ISO-8859-8-I",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-8-i");
Assert.assertEquals(
  "ISO-8859-8-I",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-8-I");
Assert.assertEquals(
  "ISO-8859-8-I",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("logical");
Assert.assertEquals(
  "ISO-8859-8-I",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("LOGICAL");
Assert.assertEquals(
  "ISO-8859-8-I",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csisolatin6");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISOLATIN6");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-10");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-10");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-ir-157");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-IR-157");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-10");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-10");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso885910");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO885910");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("l6");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("L6");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("latin6");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("LATIN6");
Assert.assertEquals(
  "ISO-8859-10",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-13");
Assert.assertEquals(
  "ISO-8859-13",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-13");
Assert.assertEquals(
  "ISO-8859-13",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-13");
Assert.assertEquals(
  "ISO-8859-13",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-13");
Assert.assertEquals(
  "ISO-8859-13",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso885913");
Assert.assertEquals(
  "ISO-8859-13",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO885913");
Assert.assertEquals(
  "ISO-8859-13",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-14");
Assert.assertEquals(
  "ISO-8859-14",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-14");
Assert.assertEquals(
  "ISO-8859-14",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-14");
Assert.assertEquals(
  "ISO-8859-14",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-14");
Assert.assertEquals(
  "ISO-8859-14",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso885914");
Assert.assertEquals(
  "ISO-8859-14",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO885914");
Assert.assertEquals(
  "ISO-8859-14",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csisolatin9");
Assert.assertEquals(
  "ISO-8859-15",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISOLATIN9");
Assert.assertEquals(
  "ISO-8859-15",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-15");
Assert.assertEquals(
  "ISO-8859-15",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-15");
Assert.assertEquals(
  "ISO-8859-15",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-15");
Assert.assertEquals(
  "ISO-8859-15",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-15");
Assert.assertEquals(
  "ISO-8859-15",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso885915");
Assert.assertEquals(
  "ISO-8859-15",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO885915");
Assert.assertEquals(
  "ISO-8859-15",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-15");
Assert.assertEquals(
  "ISO-8859-15",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-15");
Assert.assertEquals(
  "ISO-8859-15",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("l9");
Assert.assertEquals(
  "ISO-8859-15",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("L9");
Assert.assertEquals(
  "ISO-8859-15",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-16");
Assert.assertEquals(
  "ISO-8859-16",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-16");
Assert.assertEquals(
  "ISO-8859-16",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cskoi8r");
Assert.assertEquals(
  "KOI8-R",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSKOI8R");
Assert.assertEquals(
  "KOI8-R",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("koi");
Assert.assertEquals(
  "KOI8-R",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("KOI");
Assert.assertEquals(
  "KOI8-R",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("koi8");
Assert.assertEquals(
  "KOI8-R",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("KOI8");
Assert.assertEquals(
  "KOI8-R",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("koi8-r");
Assert.assertEquals(
  "KOI8-R",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("KOI8-R");
Assert.assertEquals(
  "KOI8-R",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("koi8_r");
Assert.assertEquals(
  "KOI8-R",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("KOI8_R");
Assert.assertEquals(
  "KOI8-R",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("koi8-ru");
Assert.assertEquals(
  "KOI8-U",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("KOI8-RU");
Assert.assertEquals(
  "KOI8-U",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("koi8-u");
Assert.assertEquals(
  "KOI8-U",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("KOI8-U");
Assert.assertEquals(
  "KOI8-U",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csmacintosh");
Assert.assertEquals(
  "macintosh",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSMACINTOSH");
Assert.assertEquals(
  "macintosh",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("mac");
Assert.assertEquals(
  "macintosh",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("MAC");
Assert.assertEquals(
  "macintosh",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("macintosh");
Assert.assertEquals(
  "macintosh",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("MACINTOSH");
Assert.assertEquals(
  "macintosh",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-mac-roman");
Assert.assertEquals(
  "macintosh",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-MAC-ROMAN");
Assert.assertEquals(
  "macintosh",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("dos-874");
Assert.assertEquals(
  "windows-874",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("DOS-874");
Assert.assertEquals(
  "windows-874",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-11");
Assert.assertEquals(
  "windows-874",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-11");
Assert.assertEquals(
  "windows-874",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-11");
Assert.assertEquals(
  "windows-874",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-11");
Assert.assertEquals(
  "windows-874",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso885911");
Assert.assertEquals(
  "windows-874",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO885911");
Assert.assertEquals(
  "windows-874",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("tis-620");
Assert.assertEquals(
  "windows-874",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("TIS-620");
Assert.assertEquals(
  "windows-874",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("windows-874");
Assert.assertEquals(
  "windows-874",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("WINDOWS-874");
Assert.assertEquals(
  "windows-874",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cp1250");
Assert.assertEquals(
  "windows-1250",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CP1250");
Assert.assertEquals(
  "windows-1250",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("windows-1250");
Assert.assertEquals(
  "windows-1250",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("WINDOWS-1250");
Assert.assertEquals(
  "windows-1250",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-cp1250");
Assert.assertEquals(
  "windows-1250",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-CP1250");
Assert.assertEquals(
  "windows-1250",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cp1251");
Assert.assertEquals(
  "windows-1251",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CP1251");
Assert.assertEquals(
  "windows-1251",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("windows-1251");
Assert.assertEquals(
  "windows-1251",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("WINDOWS-1251");
Assert.assertEquals(
  "windows-1251",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-cp1251");
Assert.assertEquals(
  "windows-1251",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-CP1251");
Assert.assertEquals(
  "windows-1251",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ansi_x3.4-1968");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ANSI_X3.4-1968");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ascii");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ASCII");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cp1252");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CP1252");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cp819");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CP819");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csisolatin1");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISOLATIN1");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ibm819");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("IBM819");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-1");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-1");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-ir-100");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-IR-100");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-1");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-1");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso88591");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO88591");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-1");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-1");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-1:1987");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-1:1987");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("l1");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("L1");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("latin1");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("LATIN1");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("us-ascii");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("US-ASCII");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("windows-1252");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("WINDOWS-1252");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-cp1252");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-CP1252");
Assert.assertEquals(
  "windows-1252",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cp1253");
Assert.assertEquals(
  "windows-1253",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CP1253");
Assert.assertEquals(
  "windows-1253",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("windows-1253");
Assert.assertEquals(
  "windows-1253",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("WINDOWS-1253");
Assert.assertEquals(
  "windows-1253",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-cp1253");
Assert.assertEquals(
  "windows-1253",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-CP1253");
Assert.assertEquals(
  "windows-1253",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cp1254");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CP1254");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csisolatin5");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISOLATIN5");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-8859-9");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-8859-9");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-ir-148");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-IR-148");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso8859-9");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO8859-9");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso88599");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO88599");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-9");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-9");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso_8859-9:1989");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO_8859-9:1989");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("l5");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("L5");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("latin5");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("LATIN5");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("windows-1254");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("WINDOWS-1254");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-cp1254");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-CP1254");
Assert.assertEquals(
  "windows-1254",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cp1255");
Assert.assertEquals(
  "windows-1255",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CP1255");
Assert.assertEquals(
  "windows-1255",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("windows-1255");
Assert.assertEquals(
  "windows-1255",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("WINDOWS-1255");
Assert.assertEquals(
  "windows-1255",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-cp1255");
Assert.assertEquals(
  "windows-1255",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-CP1255");
Assert.assertEquals(
  "windows-1255",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cp1256");
Assert.assertEquals(
  "windows-1256",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CP1256");
Assert.assertEquals(
  "windows-1256",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("windows-1256");
Assert.assertEquals(
  "windows-1256",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("WINDOWS-1256");
Assert.assertEquals(
  "windows-1256",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-cp1256");
Assert.assertEquals(
  "windows-1256",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-CP1256");
Assert.assertEquals(
  "windows-1256",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cp1257");
Assert.assertEquals(
  "windows-1257",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CP1257");
Assert.assertEquals(
  "windows-1257",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("windows-1257");
Assert.assertEquals(
  "windows-1257",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("WINDOWS-1257");
Assert.assertEquals(
  "windows-1257",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-cp1257");
Assert.assertEquals(
  "windows-1257",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-CP1257");
Assert.assertEquals(
  "windows-1257",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cp1258");
Assert.assertEquals(
  "windows-1258",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CP1258");
Assert.assertEquals(
  "windows-1258",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("windows-1258");
Assert.assertEquals(
  "windows-1258",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("WINDOWS-1258");
Assert.assertEquals(
  "windows-1258",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-cp1258");
Assert.assertEquals(
  "windows-1258",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-CP1258");
Assert.assertEquals(
  "windows-1258",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-mac-cyrillic");
Assert.assertEquals(
  "x-mac-cyrillic",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-MAC-CYRILLIC");
Assert.assertEquals(
  "x-mac-cyrillic",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-mac-ukrainian");
Assert.assertEquals(
  "x-mac-cyrillic",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-MAC-UKRAINIAN");
Assert.assertEquals(
  "x-mac-cyrillic",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("chinese");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CHINESE");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csgb2312");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSGB2312");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csiso58gb231280");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISO58GB231280");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("gb2312");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("GB2312");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("gb_2312");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("GB_2312");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("gb_2312-80");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("GB_2312-80");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("gbk");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("GBK");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-ir-58");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-IR-58");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-gbk");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-GBK");
Assert.assertEquals(
  "GBK",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("gb18030");
Assert.assertEquals(
  "gb18030",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("GB18030");
Assert.assertEquals(
  "gb18030",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("big5");
Assert.assertEquals(
  "Big5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("BIG5");
Assert.assertEquals(
  "Big5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("big5-hkscs");
Assert.assertEquals(
  "Big5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("BIG5-HKSCS");
Assert.assertEquals(
  "Big5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cn-big5");
Assert.assertEquals(
  "Big5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CN-BIG5");
Assert.assertEquals(
  "Big5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csbig5");
Assert.assertEquals(
  "Big5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSBIG5");
Assert.assertEquals(
  "Big5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-x-big5");
Assert.assertEquals(
  "Big5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-X-BIG5");
Assert.assertEquals(
  "Big5",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cseucpkdfmtjapanese");
Assert.assertEquals(
  "EUC-JP",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSEUCPKDFMTJAPANESE");
Assert.assertEquals(
  "EUC-JP",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("euc-jp");
Assert.assertEquals(
  "EUC-JP",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("EUC-JP");
Assert.assertEquals(
  "EUC-JP",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-euc-jp");
Assert.assertEquals(
  "EUC-JP",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-EUC-JP");
Assert.assertEquals(
  "EUC-JP",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csiso2022jp");
Assert.assertEquals(
  "ISO-2022-JP",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISO2022JP");
Assert.assertEquals(
  "ISO-2022-JP",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-2022-jp");
Assert.assertEquals(
  "ISO-2022-JP",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-2022-JP");
Assert.assertEquals(
  "ISO-2022-JP",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csshiftjis");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSSHIFTJIS");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ms932");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("MS932");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ms_kanji");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("MS_KANJI");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("shift-jis");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("SHIFT-JIS");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("shift_jis");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("SHIFT_JIS");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("sjis");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("SJIS");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("windows-31j");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("WINDOWS-31J");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-sjis");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-SJIS");
Assert.assertEquals(
  "Shift_JIS",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("cseuckr");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSEUCKR");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csksc56011987");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSKSC56011987");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("euc-kr");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("EUC-KR");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-ir-149");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-IR-149");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("korean");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("KOREAN");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ks_c_5601-1987");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("KS_C_5601-1987");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ks_c_5601-1989");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("KS_C_5601-1989");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ksc5601");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("KSC5601");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ksc_5601");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("KSC_5601");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("windows-949");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("WINDOWS-949");
Assert.assertEquals(
  "EUC-KR",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("csiso2022kr");
Assert.assertEquals(
  "replacement",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("CSISO2022KR");
Assert.assertEquals(
  "replacement",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("hz-gb-2312");
Assert.assertEquals(
  "replacement",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("HZ-GB-2312");
Assert.assertEquals(
  "replacement",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-2022-cn");
Assert.assertEquals(
  "replacement",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-2022-CN");
Assert.assertEquals(
  "replacement",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-2022-cn-ext");
Assert.assertEquals(
  "replacement",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-2022-CN-EXT");
Assert.assertEquals(
  "replacement",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-2022-kr");
Assert.assertEquals(
  "replacement",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("ISO-2022-KR");
Assert.assertEquals(
  "replacement",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("utf-16be");
Assert.assertEquals(
  "UTF-16BE",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("UTF-16BE");
Assert.assertEquals(
  "UTF-16BE",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("utf-16");
Assert.assertEquals(
  "UTF-16LE",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("UTF-16");
Assert.assertEquals(
  "UTF-16LE",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("utf-16le");
Assert.assertEquals(
  "UTF-16LE",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("UTF-16LE");
Assert.assertEquals(
  "UTF-16LE",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("iso-2022-jp-2");
Assert.assertEquals(
  "",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("x-user-defined");
Assert.assertEquals(
  "x-user-defined",
  stringTemp);
}
{
String stringTemp = Encodings.ResolveAlias("X-USER-DEFINED");
Assert.assertEquals(
  "x-user-defined",
  stringTemp);
}
      {
        String stringTemp = Encodings.ResolveAlias("iso-8859-1");
        Assert.assertEquals(
        "windows-1252",
        stringTemp);
      }
            {
                String stringTemp = Encodings.ResolveAlias("big5");
                Assert.assertEquals(
                "Big5",
                stringTemp);
            }
            {
        String stringTemp = Encodings.ResolveAlias("windows-1252");
        Assert.assertEquals(
        "windows-1252",
        stringTemp);
      }
      {
        String stringTemp = Encodings.ResolveAlias("us-ascii");
        Assert.assertEquals(
        "windows-1252",
        stringTemp);
      }
      Assert.assertEquals("", Encodings.ResolveAlias("utf-7"));
      Assert.assertEquals("", Encodings.ResolveAlias("replacement"));
      {
        String stringTemp = Encodings.ResolveAlias("hz-gb-2312");
        Assert.assertEquals(
        "replacement",
        stringTemp);
      }
    }
    @Test
    public void TestResolveAliasForEmail() {
      Assert.assertEquals("", Encodings.ResolveAliasForEmail(null));
      Assert.assertEquals(
  "",
  Encodings.ResolveAliasForEmail(""));
      {
        String stringTemp = Encodings.ResolveAliasForEmail("iso-8859-1");
        Assert.assertEquals(
        "ISO-8859-1",
        stringTemp);
      }
      {
        String stringTemp = Encodings.ResolveAliasForEmail("iso-2022-jp");
        Assert.assertEquals(
        "ISO-2022-JP",
        stringTemp);
      }
      {
        String stringTemp = Encodings.ResolveAliasForEmail("iso-2022-jp-2");
        Assert.assertEquals(
        "ISO-2022-JP",
        stringTemp);
      }
       {
        String stringTemp = Encodings.ResolveAliasForEmail("iso-2022-JP-2");
        Assert.assertEquals(
        "ISO-2022-JP",
        stringTemp);
      }
     {
        String stringTemp = Encodings.ResolveAliasForEmail("windows-1252");
        Assert.assertEquals(
        "windows-1252",
        stringTemp);
      }
      {
        String stringTemp = Encodings.ResolveAliasForEmail("us-ascii");
        Assert.assertEquals(
        "US-ASCII",
        stringTemp);
      }
      {
        String stringTemp = Encodings.ResolveAliasForEmail("utf-7");
        Assert.assertEquals(
        "UTF-7",
        stringTemp);
      }
      {
Object objectTemp = "";
Object objectTemp2 = Encodings.ResolveAliasForEmail(
    "replacement");
Assert.assertEquals(objectTemp, objectTemp2);
}
      {
        String stringTemp = Encodings.ResolveAliasForEmail("hz-gb-2312");
        Assert.assertEquals(
        "replacement",
        stringTemp);
      }
    }

    @Test
    public void TestStringToBytes() {
      // not implemented yet
    }
    @Test
    public void TestStringToInput() {
      try {
        Encodings.StringToInput(null, 0, 0);
        Assert.fail("Should have failed");
      } catch (NullPointerException ex) {
        // NOTE: Intentionally empty
      } catch (Exception ex) {
        Assert.fail(ex.toString());
        throw new IllegalStateException("", ex);
      }
      try {
        Encodings.StringToInput("t", -1, 1);
        Assert.fail("Should have failed");
      } catch (IllegalArgumentException ex) {
        // NOTE: Intentionally empty
      } catch (Exception ex) {
        Assert.fail(ex.toString());
        throw new IllegalStateException("", ex);
      }
      try {
        Encodings.StringToInput("t", 5, 1);
        Assert.fail("Should have failed");
      } catch (IllegalArgumentException ex) {
        // NOTE: Intentionally empty
      } catch (Exception ex) {
        Assert.fail(ex.toString());
        throw new IllegalStateException("", ex);
      }
      try {
        Encodings.StringToInput("t", 0, -1);
        Assert.fail("Should have failed");
      } catch (IllegalArgumentException ex) {
        // NOTE: Intentionally empty
      } catch (Exception ex) {
        Assert.fail(ex.toString());
        throw new IllegalStateException("", ex);
      }
      try {
        Encodings.StringToInput("t", 0, 5);
        Assert.fail("Should have failed");
      } catch (IllegalArgumentException ex) {
        // NOTE: Intentionally empty
      } catch (Exception ex) {
        Assert.fail(ex.toString());
        throw new IllegalStateException("", ex);
      }
      try {
        Encodings.StringToInput("tt", 1, 2);
        Assert.fail("Should have failed");
      } catch (IllegalArgumentException ex) {
        // NOTE: Intentionally empty
      } catch (Exception ex) {
        Assert.fail(ex.toString());
        throw new IllegalStateException("", ex);
      }
    }
  }
