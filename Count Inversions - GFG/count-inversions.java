// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // BRUTE FORCE O[N^2] -> TLE
        // long inv=0;
        // for(int i=0;i<arr.length;++i)
        //     for(int j=i;j<arr.length;++j)
        //         if(arr[i]>arr[j] && i<j)
        //             cnt++;
        // return inv;
        
        // OPTIMISED APPROACH - MERGE SORT
        long res = mergesort(arr,0,arr.length-1);
        return res;
        
    }
    public static long mergesort(long arr[], int l, int r){
        long count = 0;
        if(l < r){
            int mid = l + (r - l)/2;
            count += mergesort(arr, l, mid);
            count += mergesort(arr, mid+1, r);
            count += merge(arr, l, mid, r);
        }
        return count;
    }
    public static long merge(long arr[], int l , int mid, int r){
        long count = 0;
        int n1 = mid - l + 1;
        int n2 = r - mid;
        long[]left = new long[n1];
        long[]right = new long[n2];
        for(int i = 0; i < n1; i++)
            left[i] = arr[l+i];
            
        for(int j = 0; j < n2; j++)
            right[j] = arr[mid+1+j];
    
        int i = 0;
        int j = 0;
        int k = l;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                count += (left.length-i);
                arr[k] = right[j];
                j++;
               
            }
            k++;
        }
        while(i < n1){
           arr[k] = left[i];
           i++;
           k++;
        }
        while(j < n2){
           arr[k] = right[j];
           j++;
           k++;
        }
        return count;
    }
}