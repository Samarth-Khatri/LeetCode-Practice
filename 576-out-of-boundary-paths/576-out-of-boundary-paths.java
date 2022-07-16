class Solution {
    
    private int mod = 1000000007;
    private Long [][][] dp = null;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Long[m+1][n+1][maxMove+1];
        return (int)(rres(m,n,maxMove,startRow,startColumn));
    }
    
    private long rres(int m, int n, int maxMove, int rows, int cols) {
        if(maxMove<0) // out of moves
            return 0;
        
        if(rows<0 || cols<0 || rows==m || cols==n) // boundary condition
            return 1;
        
        if(dp[rows][cols][maxMove] != null) // Memoization
            return dp[rows][cols][maxMove];
        
        long up = rres(m,n,maxMove-1,rows-1,cols); // call for upwards move
        long right = rres(m,n,maxMove-1,rows,cols+1); // call for right move
        long down = rres(m,n,maxMove-1,rows+1,cols); // call for downwards move
        long left = rres(m,n,maxMove-1,rows,cols-1); // call for left move
        
        return dp[rows][cols][maxMove] = (up+right+down+left)%mod;
    }
}