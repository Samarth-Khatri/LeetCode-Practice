class Solution {
    public int divide(int dividend, int divisor) {
        // LOL
        int n;
        n=dividend/divisor;
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        return n;
    }
}