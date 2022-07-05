class Solution {
    
    // Approach 1 -> Using Sorting
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<2) 
            return nums.length;
        int cnt=1, lcs=1;
        for(int i=1;i<nums.length;++i) {
            if(nums[i-1]==nums[i]) 
                continue;
            else if(nums[i-1]+1 == nums[i]) 
                cnt++;
            else 
                cnt=1;

            lcs = Math.max(lcs,cnt);
        }
        
    return lcs;
        
    }
    
    // Approach 2 -> Using HashSet
}