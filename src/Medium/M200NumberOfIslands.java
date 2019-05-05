package Medium;

public class M200NumberOfIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        if (col == 0) return 0;


        int result = 0;
        boolean [][] visited = new boolean[row][col];

        for (int i = 0 ; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0 ; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // start searching from here
                    result ++;
                    span(grid, visited, i, j, row, col);
                }
            }
        }
        return result;
    }

    public void span(char[][] grid, boolean[][] visited, int i, int j, int row, int col) {
        int []dx = {-1,0,1,0};
        int []dy = {0,1,0,-1};
        int x, y;
        visited[i][j] = true;
        for (int k = 0 ; k < 4; k ++) {
            x = i + dx[k];
            y = j + dy[k];
            if (x >= 0 && x < row && y >=0 && y < col && grid[x][y] == '1' && !visited[x][y])
                span(grid, visited, x, y, row, col);
        }
    }
}
