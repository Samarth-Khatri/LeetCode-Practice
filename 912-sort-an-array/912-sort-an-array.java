class Solution {
    public int[] sortArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=0;i<arr.length;++i) {
          max = Math.max(max, arr[i]);
          min = Math.min(min, arr[i]);
        }
        
        int []farr = new int[max-min+1];
        int []ans = new int[arr.length];

        // collecting the frequencies
        for(int i=0;i<arr.length;++i) 
          farr[arr[i]-min]++;

        // convert frequencies to prefix sum array
        for(int i=1;i<farr.length;++i) 
          farr[i] += farr[i-1];

        // fill the ans array from farr
        for(int i=arr.length-1;i>=0;--i) {
          int val = arr[i];
          int pos = farr[val-min];
          ans[pos-1] = val;
          farr[val-min]--;
        }
        
        return ans;
    }
}