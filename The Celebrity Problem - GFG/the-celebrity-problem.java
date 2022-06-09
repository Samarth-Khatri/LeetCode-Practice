// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
   // NOT OPTIMIZED O(N^2)
   int celebrity(int arr[][], int n) {
        int pc=-1;
        for(int i=0;i<n;i++) {
            boolean flag=true;
            for(int j=0;j<n;j++) {
                if(arr[i][j]!=0) {
                    flag=false;
                    break;
                }
            }
            if(flag) {
                pc=i;
                boolean a=seccheck(arr,i);//second check for column
                if(a)
                    return i;
            }
        }
        return -1;
   }
   public static boolean seccheck(int[][]arr,int c) {
       for(int j=0;j<arr.length;j++) {
           if(j==c)
                continue;
           else
               if(arr[j][c]!=1)
                    return false;
       }
       return true;
   }
}