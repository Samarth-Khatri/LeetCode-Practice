class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<matrix.length;++i)
            for(int j=0;j<matrix.length;++j) 
                pq.add(matrix[i][j]);
        int ans = 0;
        for(int i=0;i<k;++i)
            ans = pq.remove();
        return ans;
    }
}