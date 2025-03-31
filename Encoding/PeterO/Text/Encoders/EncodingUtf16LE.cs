using System;
using System.IO;
using PeterO;
using PeterO.Text;

namespace PeterO.Text.Encoders {
  internal class EncodingUtf16LE : ICharacterEncoding {
    public ICharacterDecoder GetDecoder() {
      return EncodingUtf16.GetDecoder2(0);
    }

    public ICharacterEncoder GetEncoder() {
      return EncodingUtf16.GetEncoder2(0);
    }
  }
}
