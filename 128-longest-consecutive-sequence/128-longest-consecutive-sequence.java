class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0) 
            return 0;
        int count=1, lcs=1;
        for(int i=1;i<nums.length;++i) {
            if(nums[i-1]==nums[i]) 
                continue;
            else if(nums[i-1]+1 == nums[i]) 
                count++;
            else 
                count=1;

            lcs = Math.max(lcs, count);
        }
        
    return lcs;
        
    }
}