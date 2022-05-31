class Solution {
    public int divide(int dividend, int divisor) {
    
        long res = solve(dividend, divisor);
        
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
    }
    
    long solve(long dividend, long divisor){
        
        if(dividend < 0 || divisor < 0){
            
            if(dividend < 0 && divisor < 0)
                return  solve(Math.abs(dividend),  Math.abs(divisor));
            
            long ans = solve(Math.abs(dividend),  Math.abs(divisor));
            return 0 - ans;
        }
        
        if(dividend < divisor)
            return 0;
        
        if(divisor == 1)
            return dividend;
        
        long multiples = 1;
        long sum = divisor;
        
        while(sum < dividend){
            multiples += multiples;
            sum += sum;
        }
        
        if(sum == dividend){
            return multiples;
        }
        
        while(sum > dividend){
            sum -= divisor;
            multiples -= 1;
        }
        return multiples;
    }
}