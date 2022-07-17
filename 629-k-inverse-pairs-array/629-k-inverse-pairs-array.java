
// TLE -> Top Down Approach

// class Solution {
//     Integer [][]dp = new Integer[1001][1001];
//     public int kInversePairs(int n, int k) {
//         if(n==0)
//             return 0;
//         if(k==0)
//             return 1;
//         if(dp[n][k]!=null)
//             return dp[n][k];
//         int inv = 0;
//         for(int i=0;i<=Math.min(k,n-1);++i)
//             inv = (inv + kInversePairs(n-1,k-i)) % 1000000007;
//         dp[n][k]=inv;
//         return inv;
//     }
// }


// Second Approach -> TLE

// class Solution {
//     public int kInversePairs(int n, int k) {
        
//         int mod = 1000000007;
//         int[][] dp = new int[n+1][k+1];
        
//         for(int i=1;i<=n;++i) 
//             for(int j=0;j<=k;++j) {
//                 if(j==0) // returns sorted array
//                     dp[i][j] = 1;
                
//                 else {
//                     int min = Math.min(j,i-1);
//                     for(int l=0;l<=min;++l)
//                         dp[i][j] = (dp[i][j] + dp[i-1][j-l]) % mod;
//                 }
//             }
        
//         return dp[n][k];
//     }
// }


// Third Approach -> maintaining cummulative sum 

class Solution {
    public int kInversePairs(int n, int k) {
        
        int mod = 1000000007;
        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 1;
        
        for(int i=1;i<=n;++i) {
            
            int sum = 0;
            for(int j=0;j<=k;++j) {
                
                sum = (sum + dp[i-1][j]) % mod;
                if(j-i >= 0)
                    sum = (sum - dp[i-1][j-i] + mod) % mod; 
                
                dp[i][j] = (dp[i][j] % mod + sum % mod) % mod;
            }
        }
        
        return dp[n][k];
    }
}