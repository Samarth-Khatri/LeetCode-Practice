class Solution {

    private class Pair implements Comparable<Pair> {
        int idx;
        int diff;

        Pair(int idx, int diff) {
            this.idx = idx;
            this.diff = diff;
        }

        public int compareTo(Pair other) {
            if (this.diff == other.diff) return other.idx - this.idx; 
            else return other.diff - this.diff;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; ++i) {
            pq.add(new Pair(i, Math.abs(arr[i] - x)));
            if (pq.size() > k) pq.remove();
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) ans.add(arr[pq.remove().idx]);
        Collections.sort(ans);
        return ans;
    }
}
