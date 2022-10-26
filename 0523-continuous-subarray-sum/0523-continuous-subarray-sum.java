class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int currSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            currSum += nums[i];
            currSum %= k;
            if (!map.containsKey(currSum)) map.put(currSum, i);
            else if (map.containsKey(currSum) && i - map.get(currSum) >= 2) return true;
        }
        return false;
    }
}
