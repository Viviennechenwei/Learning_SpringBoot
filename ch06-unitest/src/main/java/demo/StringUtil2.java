package demo;

public class StringUtil2 {

    //isBlank(null) == true
    //isBlank(" ") == true //tab
    //isBlank("") == true
    //isBlank(" ") == true
    //isBlank("  ") == true
    //isBlank("a") == false
    //isBlank(" a") == false
    //isBlank("a ") == false
    //isBlank(" a ") == false

    public static boolean isBlank(String s) {
        if (null == s || s.length() == 0 || s.indexOf("\t") >= 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!" ".equals(s.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlank2(String s) {
        if (null == s || s.length() == 0 || s.indexOf("\t") >= 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (' ' != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }

}