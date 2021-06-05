package Medium;

import java.util.*;

public class AmzHighFreq001OptimalSolution {
    public List<int[]> optimalSolution(List<int[]> a, List<int[]> b, int target) {
        Collections.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return x[1] - y[1];
            }
        });

        Collections.sort(b, new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return x[1] - y[1];
            }
        });

        int lenA = a.size();
        int lenB = b.size();
        int lowerBound = -1;
        int curAns = 0;
        List<int[]> res = new ArrayList<>();
        for (int i = lenA - 1; i >= 0; i--) {
            if (lowerBound == lenB - 1) break;
            while (lowerBound + 1 < lenB && a.get(i)[1] + b.get(lowerBound + 1)[1] <= target) lowerBound ++;
            int ans = a.get(i)[1] + b.get(lowerBound)[1];
            if (ans > curAns) {
                curAns = ans;
                res.clear();
                res.add(new int[]{i, lowerBound});
            } else if (ans == curAns) {
                res.add(new int[]{i, lowerBound});
            } else ;

        }
        return res;
    }
}
