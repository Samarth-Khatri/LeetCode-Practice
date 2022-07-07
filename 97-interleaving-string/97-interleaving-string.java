class Solution {
    
    // Backtracking Solution -> TLE
//     public boolean isInterleave(String s1, String s2, String s3) {
//         if(s1.length() + s2.length() != s3.length())
//             return false;
//         return rres(s1,s2,s3,0,0,0);
//     }
    
//     private boolean rres(String s1, String s2, String s3, int i, int j, int k) {
//         if(k==s3.length())
//             return true;
        
//         if(i<s1.length() && s1.charAt(i)==s3.charAt(k))
//             if(rres(s1,s2,s3,i+1,j,k+1))
//                 return true;
        
//         if(j<s2.length() && s2.charAt(j)==s3.charAt(k))
//             if(rres(s1,s2,s3,i,j+1,k+1))
//                 return true;
        
//         return false;
//     }
    
    // DP Approach with 2 pointers only
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        return rres(s1, s2, s3, 0, 0, new Boolean [s1.length()+1][s2.length()+1]);
    }
    
    private boolean rres(String s1, String s2, String s3, int i, int j, Boolean [][]dp) {
        if(i==s1.length() && j==s2.length())
            return true;
        
        if(dp[i][j]!=null)
            return dp[i][j];
        
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)) {
            boolean f1 = rres(s1,s2,s3,i+1,j,dp);
            dp[i][j] = f1;
            if(f1)
                return true;
        }
        
        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j)) {
            boolean f2 = rres(s1,s2,s3,i,j+1,dp);
            dp[i][j] = f2;
            if(f2)
                return true;
        }
        
        dp[i][j] = false;
        return false;
    }
}