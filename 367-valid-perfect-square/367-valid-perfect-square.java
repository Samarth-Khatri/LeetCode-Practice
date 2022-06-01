class Solution {
    public boolean isPerfectSquare(int num) {
        long low=0,high=num,mid,res;
        while(low<=high){
            mid = low + (high-low)/2;
            res = mid*mid;
            if(res==num)
                return true;
            else if(res<num)
                low = mid+1;
            else
                high = mid-1;
        }
        return false;   
    }
}