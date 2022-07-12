class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum=0;
        for(int m:matchsticks) 
            sum+=m;
        if(sum%4!=0) 
            return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks,matchsticks.length);
        return solve(matchsticks,sum/4,0,0,new boolean[matchsticks.length],4);
    }
    
    private boolean solve(int[] match, int target, int curr, int idx, boolean used[], int k) {
        if(k==1) 
            return true;
        if(curr>target) 
            return false;
        if(curr==target) 
            return solve(match,target,0,0,used,k-1);
        
        for(int i=idx;i<match.length;++i) {
            if(used[i]) 
                continue;
            used[i] = true;
            if(solve(match,target,curr+match[i],i+1,used,k)) 
                return true;
            used[i] = false;
        }
        
        return false;
    }
    
    private static void reverse(int a[], int n) {
        int i,k,t;
        for (i=0;i<n/2;++i) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }
}