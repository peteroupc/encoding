using System;
using System.IO;
using PeterO;
using PeterO.Text;

namespace PeterO.Text.Encoders {
  internal class EncodingGBK2 : ICharacterEncoding {
    private readonly ICharacterEncoder enc = EncodingGB18030.GetEncoder3(true);

    public ICharacterDecoder GetDecoder() {
      return EncodingGB18030.GetDecoder3();
    }

    public ICharacterEncoder GetEncoder() {
      return this.enc;
    }
  }
}
