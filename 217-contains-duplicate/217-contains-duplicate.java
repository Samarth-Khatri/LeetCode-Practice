class Solution {
    public boolean containsDuplicate(int[] nums) {
        // using sorting
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;++i)
            if (nums[i + 1] == nums[i]) 
                return true;
        return false;
    }
}