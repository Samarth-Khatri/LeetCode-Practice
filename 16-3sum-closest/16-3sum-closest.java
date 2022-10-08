class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, ans = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            int first = nums[i];
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = first + nums[low] + nums[high];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < min) {
                    ans = sum;
                    min = Math.abs(sum - target);
                }
                if (sum > target) high--; 
                else low++;
            }
        }
        return ans;
    }
}
