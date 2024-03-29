class Solution {

    class Pair implements Comparable<Pair> {
        int vtx;
        int wt;

        Pair(int vtx, int wt) {
            this.vtx = vtx;
            this.wt = wt;
        }

        public int compareTo(Pair other) {
            return this.wt - other.wt;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        boolean visited[] = new boolean[n];
        int count = n;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k-1, 0));
        
        while (!pq.isEmpty()) {
            Pair rem = pq.remove();
            
            if(visited[rem.vtx])  
                continue;
            count--;
            if(count == 0)  
                return rem.wt;
            visited[rem.vtx] = true;
            
            for(int i = 0; i < times.length; ++i) 
                if(times[i][0] - 1 == rem.vtx) 
                    if(!visited[times[i][1] - 1]) 
                        pq.add(new Pair(times[i][1] - 1, rem.wt + times[i][2]));
        }
        return -1;
    }
}
