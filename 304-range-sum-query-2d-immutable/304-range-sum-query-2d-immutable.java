class NumMatrix {
    // APPROACH 1
//     public int[][] mat;
//     public NumMatrix(int[][] matrix) {
//         mat = matrix;
//     }
    
//     public int sumRegion(int row1, int col1, int row2, int col2) {
//         int res = 0;
//         for(int i = row1; i <= row2; i++)
//             for(int j = col1; j <= col2; j++)
//                 res+=mat[i][j];
//         return res;

//     }
    
    // OPTIMISED APPROACH ( PREFIX SUM )
    private int[][] ourMatrix;
    public NumMatrix(int[][] matrix) {
        ourMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < ourMatrix.length; i++)
            for(int j = 0; j < ourMatrix[i].length; j++)
                if (i == 0 || j == 0)
                    ourMatrix[i][j] = 0;
                else
                    ourMatrix[i][j] = matrix[i-1][j-1] + ourMatrix[i][j-1] + ourMatrix[i-1][j] - ourMatrix[i-1][j-1];  
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        return (ourMatrix[row2][col2] - ourMatrix[row1-1][col2] - ourMatrix[row2][col1-1] + ourMatrix[row1-1][col1-1]);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */