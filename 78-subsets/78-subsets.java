class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>()); // adding empty []
        
        for(int i=0;i<nums.length;++i) {
            int k = res.size();
            for(int j=0;j<k;++j) {
                List<Integer> temp = new ArrayList<>(res.get(j)); // copy of existing subset
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        
        return res;
    }
}