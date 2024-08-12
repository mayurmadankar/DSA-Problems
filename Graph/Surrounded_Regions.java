class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        // Convert all 'O's to '1's that are on the boundary or connected to boundary 'O's using DFS.
        // Check the first and last column for each row.
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][col - 1] == 'O') dfs(board, i, col - 1);
        }
        // Check the first and last row for each column.
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[row - 1][j] == 'O') dfs(board, row - 1, j);
        }

        // Convert all remaining 'O's to 'X'.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        // Convert all '1's back to 'O'.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '1') board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        // Mark the boundary 'O' to '1'.
        board[i][j] = '1';

        // Perform DFS in all four directions.
        dfs(board, i - 1, j); // Up
        dfs(board, i + 1, j); // Down
        dfs(board, i, j - 1); // Left
        dfs(board, i, j + 1); // Right
    }
}