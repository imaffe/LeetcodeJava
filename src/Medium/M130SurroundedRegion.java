package Medium;


import java.util.ArrayList;
import java.util.List;

public class M130SurroundedRegion {
    public void solve(char[][] board) {
        int row = board.length;
        if (row == 0) return;
        int col = board[0].length;
        if (col == 0) return;

        // collect the board elements
        List<Integer> escapeX = new ArrayList<>();
        List<Integer> escapeY = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                escapeX.add(0);
                escapeY.add(i);
            }

            if (board[row - 1][i] == 'O') {
                escapeX.add(row - 1);
                escapeY.add(i);
            }
        }

        for (int i = 1; i < row - 1; i++) {
            if (board[i][0] == 'O') {
                escapeX.add(i);
                escapeY.add(0);
            }

            if (board[i][col - 1] == 'O') {
                escapeX.add(i);
                escapeY.add(col - 1);
            }
        }

        // start searching from these points
        int [][] undead = new int[row][col];
        for (int i = 0 ; i < escapeX.size(); i++) {
            searchFrom(escapeX.get(i), escapeY.get(i), undead, board);
        }


        for (int i = 0 ; i < row; i ++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && undead[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void searchFrom(int x, int y, int [][] undead, char [][] board) {
        if (undead[x][y] == 1) return ; //already searched
        int row = undead.length;
        int col = undead[0].length;
        int[] dx = {-1, 0 ,1, 0};
        int[] dy = {0, 1, 0, -1};
        undead[x][y] = 1;
        for (int i = 0 ; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];

            if (newx >= 0 && newx < row && newy >= 0 && newy < col && board[x][y] == 'O') {
                searchFrom(newx, newy, undead, board);
            }
        }
    }
}
