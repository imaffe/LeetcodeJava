package Medium;

import java.util.ArrayList;
import java.util.List;

public class M060PermutationSeq {
    public String getPermutation(int n, int k) {
        // find an interval
        List<Character> remain = new ArrayList<>();
        String result = new String();
        int digit = 1;
        int acc = 1;
        for (int i = 1; i <= n; i++) {
            remain.add((char)('0' + i));
        }
        for (int i = 1; i <= n; i++) {
            acc *= i;
        }
        result = getPermutationFrom(remain, acc, n, k);
        return result;
    }
    public String getPermutationFrom(List<Character> remain, int acc, int n, int k) {
        if (n <= 0) return "";
        int nextAcc = acc / n;
        int order = (k - 1) / nextAcc;
        char nextDigit = remain.get(order);
        String result = "";
        result += nextDigit;
        remain.remove(order);
        result += getPermutationFrom(remain, nextAcc, n-1, k - nextAcc * order);
        return result;
    }

}
