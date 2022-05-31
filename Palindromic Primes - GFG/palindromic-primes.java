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
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.palPrimes(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int palPrimes(int n) {
        boolean []arr = new boolean[n+1];
        int cnt=0;
        
        for(int i=2;i*i<arr.length;++i)
          if(arr[i]==false)
            for(int j=i;j*i<arr.length;++j) 
              arr[j*i]=true;
              
        for(int i=2;i<arr.length;++i) {
            
            if(arr[i]==false) {
                boolean ans = isPalindrome(Integer.toString(i));
                
                if(ans==true)
                    cnt++;
            }
        }
        return cnt;
    }
    public static boolean isPalindrome(String ans){
		int i = 0;
		int j = ans.length()-1;
		
		while(j>i) {
		    
			if(ans.charAt(i) != ans.charAt(j))
				return false;
				
			i++; j--;
		}
		return true;
	}
};