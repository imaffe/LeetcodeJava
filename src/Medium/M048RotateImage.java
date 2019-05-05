package Medium;

public class M048RotateImage {
    public void rotate(int[][] matrix) {
        wrappedRotate(matrix, 0, matrix.length);
    }

    public void wrappedRotate(int[][] matrix, int start, int end) {
        if (end - start <= 1) {
            // this means do nothing
            return;
        }

        int sizeLength = end - start;
        // then rotate the outer most circle
        for (int i = 0; i < sizeLength - 1; i++) {
            // do the swap
            int temp = matrix[start][start + i];  //
            matrix[start][start + i] = matrix[end - 1 - i][start];
            matrix[end - 1 - i][start] = matrix[end - 1][end - 1 - i];
            matrix[end - 1][end - 1 - i] = matrix[start + i][end - 1];
            matrix[start + i][end - 1] = temp;
        }
        wrappedRotate(matrix, start + 1, end - 1);
    }
}
