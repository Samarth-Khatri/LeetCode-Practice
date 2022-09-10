class Solution {

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[102][1005]; 
        for (int[] row : dp) 
            Arrays.fill(row, -1); // initialize dp array with -1 

        int max = 0;
        for (int i = 0; i < prices.length; ++i) 
            max = Math.max(max, maxProfitHelper(prices, i, k, dp));

        return max;
    }

    public int maxProfitHelper(int[] prices, int idx, int k, int[][] dp) {
        if (idx == -1) 
            return 0;
        
        if (k == 0) {
            dp[k][idx] = 0; 
            return 0;
        }

        if (dp[k][idx] != -1) 
            return dp[k][idx]; // the value is computed

        int max = 0;
        for (int i = 0; i < idx; ++i) 
            if (prices[i] < prices[idx]) 
                max = Math.max(max, maxProfitHelper(prices, i-1, k-1, dp) + (prices[idx] - prices[i]));
            else 
                max = Math.max(max, maxProfitHelper(prices, i, k, dp));

        return dp[k][idx] = max; // saving the result and return
    }
}
