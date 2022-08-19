class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
		HashMap<Integer,Integer> vacancyMap = new HashMap<>();

		for(int val : nums) 
			map1.put(val, map1.getOrDefault(val,0)+1);

		for(int i=0;i<nums.length;i++) {
			if(map1.get(nums[i]) <= 0)
				continue;

			else if(vacancyMap.getOrDefault(nums[i],0) > 0) {
				map1.put(nums[i], map1.getOrDefault(nums[i],0)-1);
				vacancyMap.put(nums[i], vacancyMap.getOrDefault(nums[i],0)-1);
				vacancyMap.put(nums[i]+1, vacancyMap.getOrDefault(nums[i]+1,0)+1);
			}
			
            else if(map1.getOrDefault(nums[i],0) > 0 && map1.getOrDefault(nums[i]+1,0) > 0 && map1.getOrDefault(nums[i]+2,0) > 0) {

				map1.put(nums[i], map1.getOrDefault(nums[i],0)-1);
				map1.put(nums[i]+1, map1.getOrDefault(nums[i]+1,0)-1);
				map1.put(nums[i]+2, map1.getOrDefault(nums[i]+2,0)-1);
				vacancyMap.put(nums[i]+3, vacancyMap.getOrDefault(nums[i]+3,0)+1);
			}

			else
				return false;
		}

		return true;
    }
}