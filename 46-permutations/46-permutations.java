class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        rres(ans, new ArrayList<>(), nums);
        return ans;
    }

    public void rres(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length)
            list.add(new ArrayList<>(tempList));
        else {
            for(int i=0;i<nums.length;++i) { 
                if(tempList.contains(nums[i]))  // element already exists, skip 
                    continue; 
                tempList.add(nums[i]);
                rres(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    } 
}