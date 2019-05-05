package Medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            List<List<Integer>> result = wrapped(k, n, i);
            if (result != null ) ans.addAll(result);
        }
        return ans;
    }

    // return an answer with max as its max element
    public List<List<Integer>> wrapped(int k, int n, int max) {
        int left = n - max;
        if (k == 0) return null;
        if (k == 1 && left == 0) {
            List<Integer> oneSol = new ArrayList<>();
            oneSol.add(max);
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(oneSol);
            return ans;
        }
        else if ( k== 1 && left != 0) return null;
        else {
            if (left <= 0) return null;
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = max - 1; i >= 1; i--) {
                List<List<Integer>> result = wrapped(k - 1, n - max, i);
                if (result != null) {
                    for (int j = 0; j < result.size(); j++) {
                        result.get(j).add(max);
                    }
                    ans.addAll(result);
                }
            }
            return ans;
        }
    }

}
