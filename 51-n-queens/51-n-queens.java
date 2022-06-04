class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char [][]chess = new char[n][n];
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < n; j++) 
                chess[i][j] = '.';
        nQueens(chess,0,res);
        return res;
    }
     
    public static void nQueens(char[][] chess, int row, List<List<String>> ans) {
        if(row==chess.length) {
            List<String> list = display(chess);
            ans.add(list);
            return;
        }

        for(int col=0;col<chess.length;++col) {
            if(isQueenSafe(chess,row,col)==true) {
                chess[row][col]='Q';
                nQueens(chess,row+1,ans);
                chess[row][col]='.';
            }
        }
    }
    
    public static boolean isQueenSafe(char[][] chess, int r, int c) {
        for(int i=r-1,j=c ;i>=0; --i) 
            if(chess[i][j]=='Q')
                return false;

        for(int i=r-1,j=c-1; i>=0 && j>=0; --i,--j)
            if(chess[i][j]=='Q')
                return false;

        for(int i=r-1,j=c+1; i>=0 && j<chess.length; --i,++j)
            if(chess[i][j]=='Q')
                return false;
        
        return true;
    }
    
    public static List display(char[][] matrix) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) 
            list.add(new String(matrix[i]));
        return list;
    }
    
}