package Medium;

import java.util.ArrayList;
import java.util.List;

public class M077Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = k; i <= n; i++) {
            result.addAll(wrappedCombine(i, k));
        }
        return result;
    }
    public List<List<Integer>> wrappedCombine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 1) {
            List<Integer> one = new ArrayList<>();
            one.add(n);
            result.add(one);
            return result;
        }
        for (int i = k-1; i < n; i ++) {
            List<List<Integer>> subCombinination = wrappedCombine(i, k - 1);
            for(List<Integer> one : subCombinination) {
                one.add(n);
            }
            result.addAll(subCombinination);
        }
        return result;
    }
}
