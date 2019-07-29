package Medium;

public class M424LongestRepeatingCharactor {
    public int characterReplacement(String s, int k) {
        int max = 0;
        for (int i = 0 ; i < 26; i++) {
            if (s.indexOf(('A' + i)) >= 0) {
                int newmax = targetAt(s, k, (char)('A' + i));
                max = newmax > max ? newmax : max;
            }
        }
        return max;
    }
    public int targetAt(String s, int k, Character target) {
        if (k >= s.length()) {
            return s.length();
        }
        int left = 0;
        int right = 0;
        int remaining = k;
        int max = 0;
        while (right != s.length()) {
            right = left;
            remaining = k;
            int continents = 0;
            while (right != s.length()) { // what if it encounter the wall
                // go as far as it can go
                if (s.charAt(right) == target) {
                    right ++;
                    continents++;
                } else if(s.charAt(right) != target && remaining == 0) {
                    break;
                } else {
                    right++;
                    continents++;
                    remaining--;
                }
            }
            // calculate : problem here
            int left_extension = s.length() - continents;
            left_extension = (left_extension > remaining) ? remaining : left_extension;
            int cur = right - left + left_extension;
            max = cur > max ? cur : max;
            // left goes next continent
            if (left != s.length() && s.charAt(left) == target) {
                while(left != s.length() && s.charAt(left) == target) {
                    left ++;
                }
            }

            while (left != s.length() && s.charAt(left) != target) {
                left++;
            }
        }
        return max;
    }
}
