class Solution {
    public int countPrimes(int n) {

        boolean []arr = new boolean[n+1];
        int cnt=0;
        for(int i=2;i*i<arr.length-1;++i)
          if(arr[i]==false)
            for(int j=i;j*i<arr.length-1;++j)
              arr[j*i]=true;

        for(int i=2;i<arr.length-1;++i)
          if(arr[i]==false)
            cnt++;
        
        return cnt;
    }
}