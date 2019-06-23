package Medium;

public class M397IntegerReplace {
    public int integerReplacement(int n) {
        int cnt = 0;
        long newn = n;
        while (newn != 1) {
            if (newn == 1) return cnt + 0;
            if (newn == 2) return cnt + 1;
            if (newn == 3) return cnt + 2;
            long mod = newn % 4;
            if (mod == 0 || mod == 2) {
                newn = newn / 2;
                cnt ++;
            } else if (mod == 1) {
                newn = newn - 1;
                cnt ++;

            } else{
                newn = newn + 1;
                cnt ++;
            }
        }
        return cnt;
    }
}
