package Medium;

import java.util.HashMap;

public class M079WordSearch {
    public boolean exist(char[][] board, String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (map.get(ch) == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        return false;
    }

    public boolean exist2(char[][] board, String word) {
        int row = board.length;
        if (row == 0) return false;
        int col = board[0].length;
        if (col == 0) return false;
        int index = 0;
        int lenght = word.length();
        for (int i = 0 ; i < row; i++) {
            for (int j = 0 ; j < col; j++) {
                if(board[i][j] == word.charAt(0)) {
                    int[][] visited = new int[row][col];
                    boolean result = searchFrom(board, visited, i, j, word, 0);
                    if (result) return result;
                }
            }
        }
        return false;

    }

    public boolean searchFrom(char[][] board, int [][] visited, int r, int c, String word, int index) {

        int[] dr = {0, 1, 0 ,-1};
        int[] dc = {1, 0, -1, 0};
        int curRow = r;
        int curCol = c;
        if (index == word.length() - 1) return true;
        for (int i = 0; i < 4; i++) {
            int nextRow = curRow + dr[i];
            int nextCol = curCol + dc[i];
            visited[curRow][curCol] = 1;
            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length && visited[nextRow][nextCol] != 1) {
                if (board[nextRow][nextCol] == word.charAt(index + 1)) {
                    boolean result = searchFrom(board, visited, nextRow, nextCol, word, index + 1);
                    if (result) return true;
                }
            }
            // here it means it failed
            visited[curRow][curCol] = 0;
        }
        return false;
    }
}
