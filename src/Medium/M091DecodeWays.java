package Medium;

public class M091DecodeWays {
    public int numDecodings(String s) {
        // can be solved using DP
        int length = s.length();
        int[] DP = new int[length + 1];
        for (int i = 0; i < length + 1; i++) DP[i] = -1;
        int result = wrappedDP(s, DP, 0);
        return result;
    }

    public int wrappedDP(String s, int[] DP, int start) {
        int length = s.length();
        if (start >= s.length()) {
            DP[start] = 1;
            return 1;
        }
        int digit = s.charAt(start) - '0';
        if (DP[start] != -1) return DP[start];
        if (digit == 0) {
            DP[start] = 0;
            return 0;
        } else if (digit == 2) {
            int sum = wrappedDP(s, DP, start + 1);
            if (start + 1 < length && (s.charAt(start + 1) - '0') <= 6) {
                sum += wrappedDP(s, DP, start + 2);
            }
            DP[start] = sum;
            return sum;
        } else if (digit == 1) {
            int sum = wrappedDP(s, DP, start + 1);
            if (start + 1 < length) {
                sum += wrappedDP(s, DP, start + 2);
            }
            DP[start] = sum;
            return sum;
        }else {
            DP[start] = wrappedDP(s, DP , start + 1);
            return wrappedDP(s, DP , start + 1);
        }
    }
}
