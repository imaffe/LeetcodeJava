package Medium;

public class M005LongestPa {
    public String longestPalindrome(String s) {
        int n = s.length();
        int ans = 0;
        String res = "";
        int ansLeft = 0 , ansRight = 0;
        for (int i = 0 ; i < n ; i++) {
            String cur = longestPalindromeAt(s, i ,n);
            if (cur.length() > ans){
                ans = cur.length();
                res = cur;
            }
        }
        return res;
    }

    public String longestPalindromeAt(String s, int loc, int length) {
        int left = loc, right = loc;
        while (left >= 0 && right < length) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left --; right ++;
        }
        return s.substring(left + 1, right);
    }


    /**
     * The above doesn't work, I want to sliding window instead.
     */

    public String longestPalindrome2(String s) {
        int n = s.length();
        int right = 0, left = 0;
        int ans = 0;
        int resLeft = 0, resRight = 0;
        return "any";
    }

    public boolean isPalindrome(String s, int left, int right) {
        boolean res = true;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right - 1)) {
                res = false;
                break;
            }
            left ++;
            right --;
        }
        return res;
    }
}
