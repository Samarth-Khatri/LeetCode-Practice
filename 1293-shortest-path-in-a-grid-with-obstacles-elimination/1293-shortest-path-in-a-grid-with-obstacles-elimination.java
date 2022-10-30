class Solution {

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int steps = 0;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] { 0, 0, k });

        while (!que.isEmpty()) {
            int size = que.size();

            while (size-- > 0) {
                int[] curr = que.remove();
                
                //If curr is the destination -> return steps
                if (curr[0] == m - 1 && curr[1] == n - 1) return steps;
                
                //Else go in all valid directions
                for (int[] d : dir) {
                    int i = curr[0] + d[0];
                    int j = curr[1] + d[1];
                    int obs = curr[2];

                    //Traverse through the valid cells
                    if (i >= 0 && j >= 0 && i < m && j < n) {
                        //If cell is empty visit the cell and add in queue
                        if (grid[i][j] == 0 && !visited[i][j][obs]) {
                            que.offer(new int[] { i, j, obs });
                            visited[i][j][obs] = true;
                        } 
                        else if (grid[i][j] == 1 && obs > 0 && !visited[i][j][obs - 1]) {
                            que.offer(new int[] { i, j, obs - 1 });
                            visited[i][j][obs - 1] = true;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
