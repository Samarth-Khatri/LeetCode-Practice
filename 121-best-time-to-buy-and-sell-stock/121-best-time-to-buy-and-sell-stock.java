class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        int i=0;
        while(i<prices.length){
           min=Math.min(min,prices[i]);
           max=Math.max(max,prices[i]-min);
            i++;
          }
        return max;
    }
}