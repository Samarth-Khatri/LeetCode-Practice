class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=-1;
        int sum=0;
        for(int[] i:accounts){
            sum=0;
            for(int j:i)
                sum+=j;
            max=Math.max(max,sum);
        }
        return max;
    }
}