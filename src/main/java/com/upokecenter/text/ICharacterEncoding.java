package com.upokecenter.text;

import java.io.*;
import com.upokecenter.util.*;

/// <summary>
/// Defines methods that can be implemented by classes
/// that convert to and from bytes and character code points.
/// </summary>
public interface ICharacterEncoding {
    /**
     *
     */

    ICharacterEncoder GetEncoder();

    /**
     *
     */

    ICharacterDecoder GetDecoder();
}
