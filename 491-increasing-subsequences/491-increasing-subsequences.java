class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        rres(0,nums,res,new ArrayList<>());
        return res;
    }

    public void rres(int curr, int[] nums, List<List<Integer>> ans, List<Integer> temp){
        if (curr==nums.length){
            if (temp.size() > 1)
                ans.add(new ArrayList<>(temp));
            return;
        }

        if (curr==0 || temp.isEmpty() || temp.get(temp.size()-1)!=nums[curr])
            rres(curr+1,nums,ans,temp); // not-pick 
            
        if (temp.isEmpty() || temp.get(temp.size()-1)<=nums[curr]){
            temp.add(nums[curr]);
            rres(curr+1,nums,ans,temp); // pick 
            temp.remove(temp.size()-1);
        }
    }
}