package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] row = {0, 1, 0, -1};
        int[] col = {1, 0, -1, 0};
        int dir = 0;
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int curRow = 0, curCol = 0;
        int nextRow = 0, nextCol = 0;
        List<Integer> result = new ArrayList<>();
        boolean [][] visited = new boolean[rowLength][colLength];
        for (int i= 0 ; i < rowLength * colLength; i++) {
            nextRow = curRow + row[dir];
            nextCol = curCol + col[dir];
            visited[curRow][curCol] = true;
            result.add(matrix[curRow][curCol]);
            if (nextRow >= rowLength || nextCol >= colLength || nextRow < 0 || nextCol < 0 || visited[nextRow][nextCol]) {
                dir = (dir + 1) % 4;
                curRow = curRow + row[dir];
                curCol = curCol + col[dir];

            } else {
                curRow = nextRow;
                curCol = nextCol;
            }
        }
        return result;
    }
}
