public class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        // Iterating from 1 to compare second with first day i-1
        for(int i=1;i<prices.length;++i) 
            ans+=Math.max(0,prices[i]-prices[i-1]);
        return ans;
    }
}