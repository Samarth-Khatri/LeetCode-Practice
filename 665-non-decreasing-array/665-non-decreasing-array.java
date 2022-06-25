class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        int min = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;++i) {
            if(nums[i] <= nums[i+1])
                min = nums[i];
            else {
                if(nums[i+1] < min)
                    nums[i+1] = nums[i];
                cnt++;
                if(cnt>1) 
                    return false;
            }
        }
        return true;
    }
}