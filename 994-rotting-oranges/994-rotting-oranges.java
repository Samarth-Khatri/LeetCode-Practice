class Solution {
    static int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) 
                    q.add(new int[] { i, j });
                if (grid[i][j] == 1) 
                    fresh++;
            }
        }

        if (fresh == 0)  return 0;

        int min = -1;
        while (!q.isEmpty()) {
            int s = q.size();
            while (s-- > 0) {
                int[] top = q.poll();
                for (int[] dir : dirs) {
                    int r = top[0] + dir[0];
                    int c = top[1] + dir[1];

                    if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] == 0 || grid[r][c] == 2) 
                        continue;

                    grid[r][c] = 0;
                    q.add(new int[] { r, c });
                    fresh--;
                }
            }
            
            min++;
        }

        if (fresh == 0)  return min;
        return -1;
    }
}
