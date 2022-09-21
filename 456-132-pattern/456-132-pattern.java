class Solution {

    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) 
            min[i] = Math.min(min[i - 1], nums[i]);

        Stack<Integer> st = new Stack<>();
        // checking from behind to find values nums[i] < nums[k] < nums[j]
        for (int j = nums.length - 1; j >= 0; --j) {
            while (!st.isEmpty() && st.peek() <= min[j]) 
                st.pop(); // pop until the answer is of no need or we did not find greater value than nums[i]
            
            // now if still some elements remaining in the stack 
            // this implies that value is greater than nums[i], just check nums[j]
            if (!st.isEmpty() && st.peek() < nums[j]) 
                return true;
            
            st.push(nums[j]);
        }
        return false;
    }
}
