using System;
using System.IO;
using PeterO;

namespace PeterO.Text {
    /// <include file='../../docs.xml'
  /// path='docs/doc[@name="T:PeterO.Text.ICharacterDecoder"]/*'/>
public interface ICharacterDecoder {
    /// <include file='../../docs.xml'
  /// path='docs/doc[@name="M:PeterO.Text.ICharacterDecoder.ReadChar(PeterO.IByteReader)"]/*'/>
  int ReadChar(IByteReader input);
}
}
