class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
    
        for(int i=0;i<n;++i)  // transpose of matrix
            for(int j=i+1;j<n;j++) {
                 int temp=matrix[i][j];
                 matrix[i][j]=matrix[j][i];
                 matrix[j][i]=temp; 
        }

        for(int i=0;i<n;++i) {  //Reverse rows of the matrix
            int low=0,high=n-1;
            while(low<high) {
                int temp=matrix[i][low];
                matrix[i][low]=matrix[i][high];
                matrix[i][high]=temp;
                low++;  high--; 
            }
        }
    }
}