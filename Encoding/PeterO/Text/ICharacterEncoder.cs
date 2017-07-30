using System;
using System.IO;
using PeterO;

namespace PeterO.Text {
    /// <include file='../../docs.xml'
    /// path='docs/doc[@name="T:PeterO.Text.ICharacterEncoder"]/*'/>
  public interface ICharacterEncoder {
    /// <include file='../../docs.xml'
    /// path='docs/doc[@name="M:PeterO.Text.ICharacterEncoder.Encode(System.Int32,PeterO.IWriter)"]/*'/>
    int Encode(int c, IWriter output);
  }
}
