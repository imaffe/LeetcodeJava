package Medium;

import java.util.ArrayList;
import java.util.List;

public class M073SetMartrixZeros {
    public void setZeroes(int[][] matrix) {
        wrappedSetZeroes(matrix);
    }

    public void wrappedSetZeroes(int[][]matrix){
        int row = matrix.length;
        if (row == 0) return;
        int col = matrix[0].length;
        List<Integer> rowIndex = new ArrayList<>();
        List<Integer> colIndex = new ArrayList<>();

        for (int i = 0 ; i < row; i ++) {
            for (int j = 0 ; j < col; j++) {
                if (matrix[i][j] == 0) {
                    if (!rowIndex.contains(i)) rowIndex.add(i);
                    if (!colIndex.contains(j)) colIndex.add(j);
                }
            }
        }

        for (Integer r : rowIndex) {
            for (int j = 0 ; j < col; j++) matrix[r][j] = 0;
        }
        for (Integer c : colIndex) {
            for (int i = 0 ; i < row; i++) matrix[i][c] = 0;
        }
    }
}


