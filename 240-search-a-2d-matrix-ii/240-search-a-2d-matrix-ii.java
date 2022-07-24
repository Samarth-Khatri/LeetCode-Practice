class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=0, c=matrix[0].length-1;
        boolean ans = false;
        while(r<matrix.length && c>=0) {
            if(matrix[r][c] == target) {
                ans = true;
                break;
            }
            else if(matrix[r][c] < target) 
                r++;
            else
                c--;
        }
        return ans;
    }
}