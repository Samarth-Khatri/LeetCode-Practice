class Solution {
    
    public int furthestBuilding(int[] h, int b, int l) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min
        for(int i=0;i<h.length-1;++i) {
            int diff = h[i+1] - h[i];
            if(diff>0)
                pq.add(diff);
            if(pq.size()>l) // ladder can't resolve now
                b-=pq.poll(); // using bricks
            if(b<0)
                return i; // return if we are out of bricks also
        }
        return h.length-1; // Descending array we reached at the end 
    }
}