package Medium;

public class M413ArithmeticSlice {
    public int numberOfArithmeticSlices(int[] A) {
        int [] diffA = new int [A.length - 1];
        for (int i = 0 ;i < A.length - 1; i++){
            diffA[i] = A[i+1] - A[i];
        }

        // find consecutives more than 2
        int prev = 20000;
        int len = 1;
        int res = 0;
        for (int i = 0 ; i < diffA.length; i++){
            int cur = diffA[i];
            if (cur != prev) {
                if (len != 1) {
                    res += len * (len - 1) / 2;
                }
                prev = cur;
                len = 1;

            } else {
                len ++;
            }
        }
        res += len * (len - 1) / 2;
        return res;
    }
}
