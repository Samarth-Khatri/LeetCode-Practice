// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * n + j]);
                }
            }

            new Solution().rotateMatrix(arr, n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print(arr[i][j] + " ");
                }
            }
            out.println();
        }
        out.flush();
    }
}// } Driver Code Ends


//User function Template for Java



class Solution {
    void rotateMatrix(int Mat[][], int n) {
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++){
                int temp=Mat[i][j];
                Mat[i][j]=Mat[j][i];
                Mat[j][i]=temp;
            }
        int r=n-1;
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp=Mat[i][j];
                Mat[i][j]=Mat[r][j];
                Mat[r][j]=temp;
            }
            r--;
        }
    }
}