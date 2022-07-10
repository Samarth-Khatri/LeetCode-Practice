class Solution {
    // Iterative Solution
    public int tribonacci(int n) {
        int a=0,b=1,c=1;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 1;
        int d=0;
        for(int i=3;i<=n;++i) {
            d=a+b+c;
            a=b;
            b=c;
            c=d;
        }
        return d;
    }
    
    // Recursive Solution -> TLE
    public int tribonacci(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 1;
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }
}
