class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // max fuel in decreasing
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        int cnt = 0, idx = 0;
        
        while(startFuel < target) {
            
            while(idx < stations.length && stations[idx][0] <= startFuel) {
                pq.add(stations[idx]);
                idx++;
            }
            
            if(pq.size() == 0)
                return -1;
            
            startFuel += pq.remove()[1];
            cnt++;
        }
        
        return cnt;
    }
}