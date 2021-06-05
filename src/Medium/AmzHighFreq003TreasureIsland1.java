package Medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class AmzHighFreq003TreasureIsland1 {
    public int shortestPath(char [][] ocean) {

        int row = ocean.length;
        int col = ocean[0].length;
        int [][]  visited = new int [row][col];
        visited[0][0] = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        int answer = 0;
        queue.add(new int[]{0,0});
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size; i++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                visited[r][c] = 1;
                char curChar = ocean[r][c];
                if (curChar == 'D') {
                    // impossible
                    return  -1;
                } else if (curChar == 'X') {
                    return answer;
                }
                for (int j = 0 ; j < 4; j ++) {
                    int nextR = r + dr[j];
                    int nextC = c + dc[j];
                    if (isValid(nextR, nextC, visited)) {
                        queue.add(new  int[] {nextR, nextC});
                    }
                }
            }
        };
        return -1;
    }

    public boolean isValid(int r,int c, int [][] visited) {
        int row = visited.length;
        int col = visited[0].length;
        return (r >= 0 && r < row && c >= 0 && c < row && visited[r][c] != 1);
    }

}
