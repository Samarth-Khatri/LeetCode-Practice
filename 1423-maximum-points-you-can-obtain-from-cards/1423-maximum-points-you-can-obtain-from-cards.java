class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        for(int i:cardPoints)
            sum+=i;  // total sum
        int ans=0,window=0,n=cardPoints.length;
        if(n==k)
            return sum;  // n=k
        
        for(int i=0;i<n-k-1;++i) 
            window += cardPoints[i]; // sum of sliding window of n-k-1 starting from 0
        
        for(int i=n-k-1;i<n;++i) { // maximizing sum by shifiting window 
            window += cardPoints[i];
            ans = Math.max(ans,sum-window);
            window -= cardPoints[i-(n-k-1)];
        }
        
        return ans;
    }
}