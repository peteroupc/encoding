using System;
using System.IO;
using PeterO;
using PeterO.Text;

namespace PeterO.Text.Encoders {
  internal class EncodingUtf16BE : ICharacterEncoding {
    public ICharacterDecoder GetDecoder() {
      return EncodingUtf16.GetDecoder2(1);
    }

    public ICharacterEncoder GetEncoder() {
      return EncodingUtf16.GetEncoder2(1);
    }
  }
}
