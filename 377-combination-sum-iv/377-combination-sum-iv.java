class Solution {
    
    // Recursive Approach -> TLE
    // public int combinationSum4(int[] nums, int target) {
    //     if(target==0) return 1;
    //     int ans = 0;
    //     for(int val:nums)
    //         if(val<=target)
    //             ans += combinationSum4(nums,target-val);
    //     return ans;
    // }
    
    // Using DP -> Memoization
    int []dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        rres(nums,target);
        return dp[target];
    }
    
    public int rres(int[] arr, int tar) {
        int ans = 0;
        if(dp[tar] > -1)
                return dp[tar];
        for(int val:arr)
            if(val<=tar)
                ans += rres(arr,tar-val);
        dp[tar] = ans;
        return dp[tar];
    }
}