class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans=new ArrayList<>();
        if(intervals.length==0 || intervals==null)
            return new int[0][];
        
        //sorting intervals by starting values
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        int l = intervals[0][0], r = intervals[0][1];
        
        for (int i=1;i<intervals.length;i++) {
            if (intervals[i][0] <= r)
                r = Math.max(r, intervals[i][1]);
            else {
                ans.add(new int[]{l, r});
                l=intervals[i][0];
                r=intervals[i][1];
            }
        }
        ans.add(new int[]{l, r});
        return ans.toArray(new int[0][]);
    }
}