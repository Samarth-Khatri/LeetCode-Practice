class Solution {

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    int gold = path(grid, i, j, m, n, visited);
                    max = Math.max(max, gold);
                }
            }
        }
        return max;
    }

    private int path(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n) return 0;
        if (grid[i][j] == 0) return 0;
        if (visited[i][j]) return 0;
        visited[i][j] = true;
        int left = path(grid, i, j - 1, m, n, visited);
        int right = path(grid, i, j + 1, m, n, visited);
        int up = path(grid, i - 1, j, m, n, visited);
        int down = path(grid, i + 1, j, m, n, visited);
        visited[i][j] = false;
        return grid[i][j] + Math.max(left, Math.max(right, Math.max(up, down)));
    }
}
