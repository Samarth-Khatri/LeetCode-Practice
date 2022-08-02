class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // Using Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<matrix.length;++i)
            for(int j=0;j<matrix.length;++j) 
                pq.add(matrix[i][j]);
        
        for(int i=0;i<k-1;++i)
            pq.remove();
        
        return pq.peek();
    }
}