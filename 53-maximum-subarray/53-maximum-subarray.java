class Solution {
    public int maxSubArray(int[] nums) {
        int newsum = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;++i) {
            newsum = Math.max(newsum+nums[i], nums[i]);
            max = Math.max(max, newsum);
        }
        return max;
    }
}