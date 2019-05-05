package Medium;

public class M221MaximalSquare {
    public int maximalSquare1(char[][] matrix) {
        // this is a search problem
        int width = matrix.length;
        if (width <= 0) return 0;
        int length = matrix[0].length;
        if (length <= 0) return 0;

        int smallerLen = Math.min(width, length);
        for (int n = smallerLen; n >= 1; n--) {
            // begin search
            for (int i = 0; i <= width - n; i ++) {
                for (int j = 0; j <= length - n; j++) {
                    boolean result = search(matrix, i, j, n);
                    if (result) return n*n ;
                }
            }
        }
        return 0;
    }

    public boolean search(char[][] matrix, int x, int y, int len) {

        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (matrix[i][j] != '1') return false;
            }
        }
        return true;
    }


    // can use DP, use DP instead
    public int maximalSquare(char[][] matrix) {
        return 0;
    }
}
