package Medium;

public class M201BitwiseAndOfRange {
    public int rangeBitwiseAnd(int m, int n) {
        int ruler = 1 << 30;
        int result = 0;
        while ( ruler != 0 && (m >= ruler && n >= ruler) || (m < ruler && n < ruler)) {
            if (m >= ruler && n >= ruler) {
                result += ruler;
                m -= ruler;
                n -= ruler;
            }
            ruler = ruler >> 1;
        }
        return result;
    }
}
