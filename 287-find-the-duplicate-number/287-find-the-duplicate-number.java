class Solution {
    public int findDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // int ans=0;
        // for(int i=0;i<nums.length-1;++i) 
        //     if(nums[i]==nums[i+1])
        //         ans=nums[i+1];
        // return ans;
        
        int len = nums.length;
        int[] cnt = new int[len + 1];
        for (int i = 0; i < len; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] > 1) {
                return nums[i];
            }
        }

        return len;
    }
}