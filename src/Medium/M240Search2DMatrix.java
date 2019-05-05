package Medium;

public class M240Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        if (height == 0) return false;
        int width = matrix[0].length;
        if (width == 0) return false;


        int low = 0;
        int high = width;
        for (int i = 0; i < height; i++) {
            int result = searchRow(matrix, i, low, high, target);
            if (result == -2) return true; //use -2 to denote found
            else {
                int index = result;
                if(index == -1) return false; // impossible in this matrix
                else {
                    high = index + 1;
                }
            }
        }
        return false;
    }

    private int searchRow(int[][] matrix, int row, int low, int high, int target) {
        // use binary search here
        return binarySearch(matrix, row, low, high, target);
    }

    private int binarySearch(int[][] matrix, int row, int low, int high, int target) {
        if (high - low == 1) {
            if (matrix[row][low] == target) return -2;
            else if (matrix[row][low] < target) return low;
            else return low - 1;
        }
        int mid = (low + high) / 2;

        if (matrix[row][mid] == target) return -2;
        else if (matrix[row][mid] > target) return binarySearch(matrix, row, low, mid, target);
        else return binarySearch(matrix, row, mid, high, target);
    }

}
