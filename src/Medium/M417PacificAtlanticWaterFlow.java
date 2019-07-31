package Medium;

import java.util.ArrayList;
import java.util.List;

public class M417PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = matrix.length;
        if (rows == 0) return result;
        int cols = matrix[0].length;
        if (cols == 0) return result;


        int [][] pacificMap = new int[rows][cols];
        int [][] atlanticMap = new int[rows][cols];

        // init
        for (int i = 0; i < rows; i ++) {
            pacificMap[i][0] = 1;
            atlanticMap[i][cols - 1] = 1;
        }

        for (int i = 0 ; i < cols; i++) {
            pacificMap[0][i] = 1;
            atlanticMap[rows - 1][i] = 1;
        }

        // traverse
        for (int i = 0 ; i < rows; i++) {
            //
            DFS(i, 0, pacificMap, matrix);
            DFS(i, cols - 1, atlanticMap, matrix);
        }

        for (int i = 0 ; i < cols; i++) {
            //
            DFS(0, i, pacificMap, matrix);
            DFS(rows - 1, i, atlanticMap, matrix);
        }

        for (int i = 0 ; i < rows; i ++) {
            for (int j = 0 ; j < cols; j++) {
                if (pacificMap[i][j] == 1 && atlanticMap[i][j] == 1) {
                     List<Integer> pair = new ArrayList<>();
                     pair.add(i);
                     pair.add(j);
                     result.add(pair);
                }
            }
        }

        return result;
    }

    public void DFS(int r, int c, int [][] map, int[][] matrix) {
        map[r][c] = 1;
        int rows = map.length;
        int cols = map[0].length;
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0 ; i < 4; i++) {
            int newr = r + dx[i];
            int newc = c + dy[i];
            if (isInRange(newr, newc, rows, cols) && map[newr][newc] == 0 && matrix[r][c] <= matrix[newr][newc]) {
                // System.out.printf(Integer.toString(newr) + Integer.toString(newc) + "\n");
                DFS(newr, newc, map, matrix);
            }
        }
        return;
    }

    public boolean isInRange(int r, int c, int rows, int cols) {
        return (r >=0 && r < rows && c >= 0 && c < cols);
    }


}
