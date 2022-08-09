class Solution {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for(int val : nums) 
            res ^= val;
        return res;
    }
}