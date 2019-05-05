package Medium;

public class M313SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int curN = 0;
        int cur = 1;
        int curUgly = 0;
        while ( curN < n) {
            if (isSuperUgly(cur)) {
                n++;
                curUgly = cur;
            }
            cur ++;
        }


        return 0;
    }

    private boolean isSuperUgly(int cur) {
        if (cur == 1) return true;
        else {
            boolean res = true;

        }


        return true;
        // something is wrong
    }
}
