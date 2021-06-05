package Medium;

public class E008Atoi {
    public int myAtoi(String str) {
        int len = str.length();
        if(len == 0) return 0;
        int i = 0;
        while(i != len && str.charAt(i) == ' ') i++;
        if (i == len) return 0;
        if(!isValidFirstChar(str, i)) return 0;
        long sign = 1;
        if (isSign(str, i)) {
            // record the signs
            if(str.charAt(i) == '+') sign = 1;
            else sign = -1;
            i++;
        }
        if (i == len) return 0;
        while (i != len && str.charAt(i) == '0') i++;
        if (i == len ) return 0;
        long res = 0;
        int maxlen = 0;
        while (i != len && isValidBody(str, i) && maxlen < 11) {
            res = res * 10 + str.charAt(i) - '0';
            i++;
            maxlen++;
        }

        if (res > 2147483647 && sign == -1) return -2147483648;
        else if (res >= 2147483647 && sign == 1 ) return 2147483647;
        return (int)(res * sign);
    }

    public boolean isValidFirstChar(String s, int i) {
        char ch = s.charAt(i);
        if (ch == '+' || ch == '-' || (ch >= '0' && ch <= '9')) return true;
        else return false;
    }

    public boolean isSign(String s, int i) {
        char ch = s.charAt(i);
        if (ch == '+' || ch == '-' ) return true;
        else return false;
    }

    public boolean isValidBody(String s, int i) {
        char ch = s.charAt(i);
        if (ch >= '0' && ch <= '9') return true;
        else return false;
    }
}
