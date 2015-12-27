using System;

namespace PeterO.Text {
    /// <include file='docs.xml'
    /// path='docs/doc[@name="T:PeterO.Text.ICharacterInput"]'/>
  public interface ICharacterInput {
    /// <include file='docs.xml'
    /// path='docs/doc[@name="M:PeterO.Text.ICharacterInput.ReadChar"]'/>
    int ReadChar();

    /// <include file='docs.xml'
    /// path='docs/doc[@name="M:PeterO.Text.ICharacterInput.Read(System.Int32[],System.Int32,System.Int32)"]'
    /// />
    int Read(int[] chars, int index, int length);
  }
}
