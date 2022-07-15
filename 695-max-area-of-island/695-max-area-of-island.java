class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, maxArea = 0;
        for(int i=0;i<rows;++i)
            for(int j=0;j<cols;++j)
                if(grid[i][j]==1)
                    maxArea = Math.max(maxArea,currArea(i,j,grid));
        return maxArea;
    }
    
    private int currArea(int i, int j, int [][]grid) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
            return 0;
        
        grid[i][j]=0;
        int up = currArea(i-1,j,grid);
        int right = currArea(i,j+1,grid);
        int down = currArea(i+1,j,grid);
        int left = currArea(i,j-1,grid);
        
        return up+right+down+left+1;
    }
}