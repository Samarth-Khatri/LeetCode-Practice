// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = new String[N];
            
            for(int i=0; i<N; i++)
                arr[i] = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.palindromepair(N,arr));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int palindromepair(int N, String arr[]) {
       // BRUTE FORCE NOT OPTIMIZED
       String temp;
       for(int i=0;i<N-1;++i) 
           for(int j=i+1;j<N;++j) {
               if(isPalindrome(arr[i]+arr[j])) 
                    return 1;
               if(isPalindrome(arr[j]+arr[i])) 
                    return 1;
           }
       return 0;
   }
   
   static boolean isPalindrome(String s) {
       int n = s.length();
       for(int i=0;i<(n/2);++i) 
           if(s.charAt(i)!=s.charAt(n-1-i)) 
                return false;
       return true;
    }
};