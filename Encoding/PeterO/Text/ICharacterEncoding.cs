using System;
using System.IO;
using PeterO;

namespace PeterO.Text {
/// <summary>
/// Defines methods that can be implemented by classes
/// that convert to and from bytes and character code points.
/// </summary>
public interface ICharacterEncoding {
    /// <include file='../../docs.xml'
  /// path='docs/doc[@name="M:PeterO.Text.ICharacterEncoding.GetEncoder"]/*'/>
    #if CODE_ANALYSIS
    [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design",
      "CA1024:UsePropertiesWhereAppropriate",
      Justification =
        "Some implementations can return the same object, others won't.")]
#endif
    ICharacterEncoder GetEncoder();

    /// <include file='../../docs.xml'
  /// path='docs/doc[@name="M:PeterO.Text.ICharacterEncoding.GetDecoder"]/*'/>
#if CODE_ANALYSIS
    [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design",
      "CA1024:UsePropertiesWhereAppropriate",
      Justification =
        "Some implementations can return the same object, others won't.")]
#endif
    ICharacterDecoder GetDecoder();
}
}
