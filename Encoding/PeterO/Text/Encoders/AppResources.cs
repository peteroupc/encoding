using System.Resources;

#pragma warning disable CA1801

namespace PeterO.Text.Encoders {
  internal sealed class AppResources {
    private readonly ResourceManager mgr;

    public AppResources(string name) {
      this.mgr = new ResourceManager(this.GetType());
    }

    public short[] GetShortArray(string name) {
      string str = this.mgr.GetString(name,
          System.Globalization.CultureInfo.InvariantCulture);
      if (str == null || (str.Length & 3) != 0) {
        return null;
      }
      var ret = new short[str.Length >> 2];
      var k = 0;
      for (var i = 0; i < str.Length; i += 4) {
        var c = 0;
        var shift = 12;
        for (var j = 0; j < 4; j++, shift -= 4) {
          int d = str[i + j];
          if (d >= '0' && d <= '9') {
            d = (int)(d - '0');
          } else if (d >= 'a' && d <= 'f') {
            d = (int)(d - 'a') + 10;
          } else if (d >= 'A' && d <= 'F') {
            d = (int)(d - 'A') + 10;
          } else {
            return null;
          }
          c |= d << shift;
        }
        ret[k++] = unchecked((short)c);
      }
      return ret;
    }

    public int[] GetIntArray(string name) {
      string str = this.mgr.GetString(name,
          System.Globalization.CultureInfo.InvariantCulture);
      if (str == null || (str.Length & 7) != 0) {
        return null;
      }
      var ret = new int[str.Length >> 3];
      var k = 0;
      for (var i = 0; i < str.Length; i += 8) {
        var c = 0;
        var shift = 28;
        for (var j = 0; j < 8; j++, shift -= 4) {
          int d = str[i + j];
          if (d >= '0' && d <= '9') {
            d = (int)(d - '0');
          } else if (d >= 'a' && d <= 'f') {
            d = (int)(d - 'a') + 10;
          } else if (d >= 'A' && d <= 'F') {
            d = (int)(d - 'A') + 10;
          } else {
            return null;
          }
          c |= d << shift;
        }
        ret[k++] = c;
      }
      return ret;
    }

    public string GetString(string name) {
      return this.mgr.GetString(name,
          System.Globalization.CultureInfo.InvariantCulture);
    }
  }
}
