class Solution {
    public int wiggleMaxLength(int[] nums) {
        int up=1, down=1, n=nums.length;
        if(n<=1) 
            return n;
        for(int i=0;i<n-1;++i) {
            if(nums[i]<nums[i+1]) // up hill case
                up = down+1;
            else if(nums[i]>nums[i+1]) // down hill case
                down = up+1;
            else // equals
                continue;
        }
        return Math.max(up,down);
    }
}