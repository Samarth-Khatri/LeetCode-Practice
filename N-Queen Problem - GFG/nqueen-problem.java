// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> res;
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        res=new ArrayList<>();
        ArrayList<int[]> queens = new ArrayList<>();
        int [][]chess = new int[n][n];
        nQueens(chess,0,queens);
        return res;
    }
     
    public static void nQueens(int[][] chess, int row, ArrayList<int[]> ans) {
        if(row==chess.length) {
            ArrayList<Integer> arr=new ArrayList<>();
           for(int[] a:chess)
               for(int i=0;i<a.length;i++)
                   if(a[i]==1)
                       arr.add(i+1);
           res.add(arr);
        }

        for(int col=0;col<chess.length;++col) {
            if(isQueenSafe(chess,row,col)==true) {
                chess[row][col]=1;
                nQueens(chess,row+1,ans);
                chess[row][col]=0;
            }
        }
    }
    
    public static boolean isQueenSafe(int[][] chess, int r, int c) {
        for(int i=r-1,j=c ;i>=0; --i) 
            if(chess[i][j]>0)
                return false;

        for(int i=r-1,j=c-1; i>=0 && j>=0; --i,--j)
            if(chess[i][j]>0)
                return false;

        for(int i=r-1,j=c+1; i>=0 && j<chess.length; --i,++j)
            if(chess[i][j]>0)
                return false;
        
        return true;
    }
}