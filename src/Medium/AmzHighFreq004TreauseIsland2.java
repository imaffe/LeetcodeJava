package Medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class AmzHighFreq004TreauseIsland2 {
    public int shortest( int[][] mat) {
        int row = mat.length;
        if(row == 0) return -1;
        int col = mat[0].length;
        if(col == 0) return -1;

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int[row][col];
        for (int i = 0 ; i < row; i ++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 'S') {
                    queue.add(new int[] {i,j});
                    visited[i][j] = 1;
                }
            }
        }

        int ans = 0;
        int[] dr = {1, 0 , -1, 0};
        int[] dc = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size; i++) {
                int[] point = queue.poll();
                int r = point[0];
                int c = point[1];
                for(int j = 0 ; j < 4; j ++) {
                    int newR = r + dr[j];
                    int newC = c + dc[j];
                    if (newR >= 0 && newR < row && newC >= 0 && newC < col && visited[newR][newC] != 1) {
                        if (mat[newR][newC] == 'X') return ans + 1;
                        else if (mat[newR][newC] == 'O') {
                            queue.add(new int[]{newR, newC});
                        }
                        visited[newR][newC] = 1;
                    }
                }
            }
            ans ++;
        }

    return -1;
    }
}
