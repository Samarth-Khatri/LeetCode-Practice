// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
   static double medianOfArrays(int n, int m, int a[], int b[]) 
   {
       double median;
       int medIndex;
       int nArr[] = new int[n+m];
       for(int i=0;i<n;++i)
           nArr[i]=a[i];
       for (int i=0;i<m;++i)
           nArr[n+i]=b[i];

       Arrays.sort(nArr);
       medIndex = nArr.length/2;
       if(nArr.length%2==0){
           double temp = nArr[medIndex-1]+nArr[medIndex];
           median=temp/2;
       } 
       else 
            median = nArr[medIndex];
       
       return median;
   }
}