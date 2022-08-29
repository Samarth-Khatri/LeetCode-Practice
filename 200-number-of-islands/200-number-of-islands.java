public class Solution {

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for(int i=0;i<grid.length;++i) 
            for(int j=0;j<grid[i].length;++j) 
                if(grid[i][j]=='1') {
                    cnt++;
                    clearRestOfLand(grid,i,j);
                }
        return cnt;
    }

    private void clearRestOfLand(char[][] grid, int i, int j) {
        if (i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]=='0')     
            return;
        grid[i][j] = '0';
        clearRestOfLand(grid,i+1,j);
        clearRestOfLand(grid,i-1,j);
        clearRestOfLand(grid,i,j+1);
        clearRestOfLand(grid,i,j-1);
    }
}
