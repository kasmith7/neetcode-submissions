class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowBuckets = new boolean[9][9];
        boolean[][] colBuckets = new boolean[9][9];
        boolean[][] subBuckets = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int subIdx = 3 * (i / 3) + (j/3);
                int c = board[i][j] - '1';
                
                if (rowBuckets[i][c] 
                || colBuckets[j][c] 
                || subBuckets[subIdx][c]) {
                    return false;
                }
                rowBuckets[i][c] = true;
                colBuckets[j][c] = true;
                subBuckets[subIdx][c] = true;
            }
        }
        return true;

    }

}
