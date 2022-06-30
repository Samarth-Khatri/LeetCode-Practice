class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums); // sort the array
        
        // find the median
        int median = nums.length%2==0 ? (nums[nums.length/2]+nums[nums.length/2-1])/2 : nums[nums.length/2];
        
        // calculating steps
        int steps=0;
        for(int num : nums)
            steps += Math.abs(num-median);
        
        return steps;
    }
}