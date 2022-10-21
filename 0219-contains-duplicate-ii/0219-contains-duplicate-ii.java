class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) 
                if (i - map.get(nums[i]) <= k) // No need for abs as i is increasing only
                    return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
