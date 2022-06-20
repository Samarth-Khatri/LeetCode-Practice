class Solution {
    public int fib(int n) {
        if(n==0||n==1)
            return n;
        // int []arr = new int[n+1];
        int a=0;
        int b=1;
        int ans=0;
        for(int i=2;i<=n;i++) {
            ans = a+b;
            a=b;
            b=ans;
        }
        return ans;
    }
}