class Solution {
    // RECURSIVE APPROACH -> TLE
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - (2 * lcs(word1, 0, word2, 0));
    }

    public int lcs(String a, int i, String b, int j) {
        if(i==a.length() || j==b.length()) 
            return 0;
        if(a.charAt(i)==b.charAt(j)) {
            return 1 + lcs(a,i+1,b,j+1);
        } else 
            return Math.max(lcs(a,i,b,j+1), lcs(a,i+1,b,j));
    }
    
    // DP APPROACH 
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<m+1;++i){
            for(int j=0;j<n+1;++j){
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else if(i>0 && j>0 && word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else if(i>0 && j>0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return (word1.length()-dp[m][n]) + (word2.length()-dp[m][n]);
    }
}
