//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int N, int M, int arr[][])
    {
        int[][] dp = new int[N+1][M+1];
        int[][] dir = {{-1,1},{0,1},{1,1}};
        
        for(int sc=M-1;sc>=0;--sc) {
          for(int sr=N-1;sr>=0;--sr) {
            if(sc == M-1) { // last column remains same
              dp[sr][sc] = arr[sr][sc];
              continue;
            }
            
            int maxGold = 0;
            for(int d=0;d<dir.length;++d) { // for rest of the cells
              int r = sr + dir[d][0];
              int c = sc + dir[d][1];
              if(r>=0 && c>=0 && r<N && c<M)
                maxGold = Math.max(maxGold, dp[r][c] + arr[sr][sc]);
            }
            dp[sr][sc] = maxGold;
          }
        }
    
        int ans = 0;
        for(int r=0;r<N;++r) ans = Math.max(ans, dp[r][0]);
        return ans;
    }
}