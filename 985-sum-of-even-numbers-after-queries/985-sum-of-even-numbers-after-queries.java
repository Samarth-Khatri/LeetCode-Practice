class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) 
            if (nums[i] % 2 == 0) // sum of all even numbers
                sum += nums[i];

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int val = queries[i][0]; // query value
            int pos = queries[i][1]; // query position
            if (nums[pos] % 2 == 0) // if the position to be modified is even value 
                sum -= nums[pos]; // subtract the value from the sum
             
            nums[pos] += val; // update the value at the position
            if (nums[pos] % 2 == 0) // If updated value is even
                sum += nums[pos]; // update the sum and add the value 

            res[i] = sum; // save in result array
        }
        
        return res; 
    }
}