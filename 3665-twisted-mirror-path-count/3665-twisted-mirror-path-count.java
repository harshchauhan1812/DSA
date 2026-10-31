class Solution {
    public int uniquePaths(int[][] grid) {
        int mod = (int) 1e9 + 7;

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] movingRight = new int[rows][cols];
        int[][] movingDown = new int[rows][cols];

        movingRight[0][0] = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    int ways = (movingRight[row][col] + movingDown[row][col]) % mod;

                    if (row == rows - 1 && col == cols - 1) {
                        return ways;
                    }

                    if (col + 1 < cols) {
                        movingRight[row][col + 1] = (movingRight[row][col + 1] + ways) % mod;
                    }

                    if (row + 1 < rows) {
                        movingDown[row + 1][col] = (movingDown[row + 1][col] + ways) % mod;
                    }
                } else {
                    if (row + 1 < rows) {
                        movingDown[row + 1][col] = (movingDown[row + 1][col] + movingRight[row][col]) % mod;
                    }

                    if (col + 1 < cols) {
                        movingRight[row][col + 1] = (movingRight[row][col + 1] + movingDown[row][col]) % mod;
                    }
                }
            }
        }

        return 0;
    }
}