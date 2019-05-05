package Medium;

import java.util.List;

public class M120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][]DP = new int[height][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0 ;j < height; j++) {
                DP[i][j] = 1000000;
            }
        }
        int min = findMin(triangle, 0,0, DP);
        return min;
    }

    public int findMin(List<List<Integer>> tri, int level, int x, int DP[][]) {
        if (level >= tri.size()) return 0;
        if (DP[level][x] < 1000000) return DP[level][x];
        int curValue = tri.get(level).get(x);

        int min = Math.min(findMin(tri, level + 1, x, DP), findMin(tri, level + 1, x + 1, DP));
        DP[level][x] = min + curValue;
        return min + curValue;
    }
}
