class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums); // sort the array
        
        // find the median
        int n = nums.length;
        int median = n%2==0 ? (nums[n/2]+nums[n/2-1])/2 : nums[n/2];
        
        // calculating steps
        int steps=0;
        for(int num : nums)
            steps += Math.abs(num-median);
        
        return steps;
    }
}