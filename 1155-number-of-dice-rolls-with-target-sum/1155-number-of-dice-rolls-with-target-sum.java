class Solution {

    // Recursive Solution -> TLE
//     public int numRollsToTarget(int n, int k, int target) {
//         if (target <= 0) 
//             return 0;
//         if (n == 1) {
//             if (target > k) return 0; 
//             else if (target > 0 && target <= k) return 1;
//         }
        
//         int ans = 0;
//         for (int i = 1; i <= k; ++i) 
//             ans += numRollsToTarget(n - 1, k, target - i);
//         return ans;
//     }
    
    int[][] dp;
    int mod = 1000000007;
    
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];
        for(int i = 0; i <= n; i++) 
            Arrays.fill(dp[i], -1);
        rres(n, k, target);
        return dp[n][target];
    }
    
    public int rres(int n, int k, int target) {
        if(target <= 0) 
            return 0;
        if(dp[n][target] >= 0) // memoization 
            return dp[n][target] % mod;
        if(n == 1) {
            if(target > k) return dp[n][target] = 0;
            else if(target > 0 && target <= k) return dp[n][target] = 1;
        }
        
        dp[n][target] = 0;
        for(int i = 1; i <= k; ++i) 
            dp[n][target] = (dp[n][target] + rres(n - 1, k, target - i)) % mod;
        return dp[n][target];
    }
}
