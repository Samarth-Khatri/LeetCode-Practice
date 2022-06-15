class Solution {
    int[][] cache;
    
    public int lengthOfLIS(int[] nums) {
        cache = new int[nums.length + 1][nums.length];
        for(int[] row : cache)
            Arrays.fill(row, - 1);
        return lengthOfLIS(nums, -1, 0);
    }
    
    public int lengthOfLIS(int[] nums, int prevIndex, int currIndex) {
        if(currIndex == nums.length) 
            return 0;
        
        if(cache[prevIndex + 1][currIndex] > -1) //take the already computed result
            return cache[prevIndex + 1][currIndex];
        
        int taken =  0;
        if(prevIndex < 0 || nums[currIndex] > nums[prevIndex]) //when current element is considered 
            taken = 1 + lengthOfLIS(nums, currIndex, currIndex + 1);
        
        //when current element is ignored 
        int notTaken = lengthOfLIS(nums, prevIndex, currIndex + 1);
        
        cache[prevIndex + 1][currIndex] = Math.max(notTaken, taken); //store the result
        
        return cache[prevIndex + 1][currIndex];
    }
}