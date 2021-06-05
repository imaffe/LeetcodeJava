package Medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class AmzHighFreq005ZombieMatrix {

    public int infections(int[][] mat) {
        int row = mat.length;
        if(row == 0) return 0;
        int col = mat[0].length;
        if(col == 0) return 0;

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int [row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0 ; j < col; j++) {
                if (mat[i][j] == 1) {
                    visited[i][j] = 1;
                    queue.add(new int[] {i,j});
                }
            }
        }
        // will the queue be empty after init ?
        int [] dr = {0, 1, 0, -1};
        int [] dc = {1, 0 , -1, 0};
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i  < size; i++) {
                int [] point  = queue.poll();
                int r = point[0];
                int c = point[1];
                for (int j = 0 ; j < 4; j++) {
                    int newR = r + dr[j];
                    int newC = c + dc[j];
                    if (isValidNext(newR, newC, visited)) {
                        queue.add(new int[] {newR, newC});
                        visited[newR][newC] = 1;
                    }
                }
            }
            cnt ++;
        }
        return cnt;
    }

    public boolean isValidNext(int r, int c, int[][] visited) {
        int row = visited.length;
        int col = visited[0].length;
        return (r >=0 && r < row && c >= 0 &&  c < col && visited[r][c] != 1);
    }
}
