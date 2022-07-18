class Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0) 
                    matrix[i][j] += matrix[i - 1][j];
                if (j > 0) 
                    matrix[i][j] += matrix[i][j - 1];
                if (i > 0 && j > 0) 
                    matrix[i][j] -= matrix[i - 1][j - 1];
            }
        }
        
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int p = -1; p < i; p++) {
                    for (int q = -1; q < j; q++) {
                        int cursum = matrix[i][j];
                        if (p >= 0) 
                            cursum -= matrix[p][j];
                        if (q >= 0) 
                            cursum -= matrix[i][q];
                        if (p >= 0 && q >= 0) 
                            cursum += matrix[p][q];
                        if (cursum == target) 
                            res++;
                    }
                }
            }
        }
        return res;
    }
}
