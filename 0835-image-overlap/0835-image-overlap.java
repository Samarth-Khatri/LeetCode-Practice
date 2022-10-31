class Solution {

    public int largestOverlap(int[][] A, int[][] B) {
        int maxCount = 0;
        int n = A.length;

        for (int i = 1 - n; i < n; ++i) 
            for (int j = 1 - n; j < n; ++j) 
                maxCount = Math.max(maxCount, getCount(A, B, i, j));

        return maxCount;
    }

    private int getCount(int[][] A, int[][] B, int rowOff, int colOff) {
        int count = 0;
        int n = A.length;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i + rowOff < 0 || i + rowOff >= n) || (j + colOff < 0 || j + colOff >= n)) 
                    continue;
                if (A[i][j] + B[i + rowOff][j + colOff] == 2) count++;
            }
        }
        return count;
    }
}
