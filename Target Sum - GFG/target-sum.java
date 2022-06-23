// { Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] A , int N, int target) {
        if(N==0 && target==0) 
            return 1;
        if(N==0) 
            return 0;
         int ch1 = findTargetSumWays(A,N-1,target-A[N-1]);
         int ch2 = findTargetSumWays(A,N-1,target+A[N-1]);
         return ch1+ch2;
    }
};