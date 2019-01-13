package Problems.Google;

/**
 * Created by shuhanliu on 1/10/19.
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 Example:

 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */
public class SurroundedRegions {

    public static void main (String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        solve(board);
        System.out.println("-------------");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;

        // dfs top and bot row
        for (int n = 0; n < board[0].length; n++) {
            dfs(board, 0, n);
            dfs(board, board.length-1, n);
        }

        // dfs left and right col
        for (int n = 0; n < board.length; n++) {
            dfs(board, n, 0);
            dfs(board, n, board[0].length-1);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '1')
                    board[i][j] = 'O';
            }
        }
    }

    public static void dfs(char[][] board, int i, int j) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0)
            return;
        if (board[i][j] != 'O')
            return;
        board[i][j] = '1';
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}
