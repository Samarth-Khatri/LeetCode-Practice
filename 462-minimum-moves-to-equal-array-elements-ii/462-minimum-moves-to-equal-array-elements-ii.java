class Solution {
    public int minMoves2(int[] nums) {
        
        // Approach 1
        Arrays.sort(nums); // sort the array
        int n = nums.length; // find the median
        int median = n%2==0 ? (nums[n/2]+nums[n/2-1])/2 : nums[n/2];
        int steps=0; // calculating steps
        for(int num : nums)
            steps += Math.abs(num-median);
        return steps;
        
        // Aproach 2
        Arrays.sort(nums); // sort the array 
        int i=0, j=nums.length-1, steps=0; // two pointer
        while(i<j) {
            steps += (nums[j]-nums[i]);
            i++; j--;
        }
        return steps;
    }
}
