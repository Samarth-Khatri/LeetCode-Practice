class Solution {
    public int totalNQueens(int n) {
        int [][]chess = new int[n][n];
        int ans = nQueens(chess,0);
        return ans;
    }

    public static int nQueens(int[][] chess, int row) {
        if(row==chess.length) {
            return 1;
        }
        int cnt = 0;
        for(int col=0;col<chess.length;++col) {
            if(isQueenSafe(chess,row,col)==true) {
                chess[row][col]=1;
                cnt+=nQueens(chess,row+1);
                chess[row][col]=0;
            }
        }
        return cnt;
    }
    
     public static boolean isQueenSafe(int[][] chess, int r, int c) {
        for(int i=r-1,j=c ;i>=0; --i) 
            if(chess[i][j]>0)
                return false;

        for(int i=r-1,j=c-1; i>=0 && j>=0; --i,--j)
            if(chess[i][j]>0)
                return false;

        for(int i=r-1,j=c+1; i>=0 && j<chess.length; --i,++j)
            if(chess[i][j]>0)
                return false;
        
        return true;
    }
}