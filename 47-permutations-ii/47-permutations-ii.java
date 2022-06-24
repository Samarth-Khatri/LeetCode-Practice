class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        rres(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public void rres(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length)
            list.add(new ArrayList<>(tempList));
        else {
            for(int i=0;i<nums.length;++i) {
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) 
                    continue;
                used[i] = true; // to avoid duplicates
                tempList.add(nums[i]);
                rres(list, tempList, nums, used);
                used[i] = false; 
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}