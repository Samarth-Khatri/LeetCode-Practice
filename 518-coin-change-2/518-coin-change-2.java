class Solution {

    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length + 1][amount + 1];
        return dpres(amount, coins, 0, dp);
    }

    private int dpres(int amount, int[] coins, int idx, Integer[][] dp) {
        if (idx >= coins.length) return 0;
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        
        if (dp[idx][amount] != null) 
            return dp[idx][amount];
        
        int ans = dpres(amount - coins[idx], coins, idx, dp) + dpres(amount, coins, idx + 1, dp);
        
        return dp[idx][amount] = ans;
    }
}
