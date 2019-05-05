package Medium;

public class M074SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;
        int rowIndex = -1;
        while (rowIndex + 1 < row && matrix[rowIndex + 1][0] <= target) {
            rowIndex ++;
        }

        if (rowIndex == -1) return false;

        for (int j = 0 ; j < col; j++) {
            if (target == matrix[rowIndex][j]) {
                return true;
            }
        }

        return false;
    }
}
