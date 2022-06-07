// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.primeDivision(N);
            System.out.println(ans.get(0) + " " + ans.get(1));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> primeDivision(int N){
        ArrayList<Integer> prime = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        boolean []arr = new boolean[N+1];
        for(int i=2;i*i<arr.length;++i)
          if(arr[i]==false)
            for(int j=i;j*i<arr.length;++j)
              arr[j*i]=true;
    
        for(int i=2;i<arr.length;++i)
          if(arr[i]==false)
            prime.add(i);
        
        int i=0,j=prime.size()-1;
        while(i<=j) {
            if(prime.get(i)+prime.get(j)==N) {
                ans.add(prime.get(i));
                ans.add(prime.get(j));
                return ans;
            } else if(prime.get(i)+prime.get(j)>N)
                j--;
            else
                i++;
        }
        return ans;
    }
}