package Splunk;

public class Splunk001ParseString {
    public static void main(String[] args) {
        String test = "2[a[3[d]2[c]]]";
        String res = parseString(test);
        System.out.println(res);
    }
    public static String parseString(String s) {
            if (s == null || s.length() == 0) {
                return "";
            }
            return parseStringAll(s);
    }



    public  static String parseStringAll(String s) {
        if (s.length() == 0) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            if (isDigit(s.charAt(i)) || s.charAt(i) == '[') {
                return s.substring(0, i) + parseStringB(s.substring(i, s.length()));
            }
        }

        return s;
    }

    public  static String parseStringB(String s) {
        if (s.length() == 0) {
            return "";
        }

        int repeat = 0;

        int bracketStart = -1;

        for (int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                bracketStart = i;
                if (i == 0) {
                    repeat = 1;
                } else {
                    repeat = parseRepeat(s.substring(0, i));
                }

                break;
            }
        }

        int leftBracketCnt = 0;
        int bracketEnd = -1;
        for (int i = bracketStart; i < s.length(); i++) {
            if(s.charAt(i) == '[') {
                leftBracketCnt++;
            } else if(s.charAt(i) == ']') {
                leftBracketCnt--;
                if(leftBracketCnt == 0) {
                    bracketEnd = i;
                    break;
                }
            }
        }

        String res = "";
        for (int i = 0 ; i < repeat; i++) {
            res += parseStringAll(s.substring(bracketStart + 1, bracketEnd));
        }

        res += parseStringAll(s.substring(bracketEnd + 1));
        return res;

    }

    public static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static  int parseRepeat(String s) {
        return Integer.parseInt(s);
    }
}
