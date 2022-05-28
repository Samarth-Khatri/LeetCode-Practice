class Solution {
    public int singleNumber(int[] nums) {
        // XOR property x^x=0, x^0=x
        int x=0;
        for(int i=0;i<nums.length;i++)
            x^=nums[i];
        return x;
    }
}