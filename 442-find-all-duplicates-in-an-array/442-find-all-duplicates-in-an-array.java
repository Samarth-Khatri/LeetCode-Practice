class Solution {
    public List<Integer> findDuplicates(int[] nums) {
    List<Integer> list = new ArrayList<>();
    Arrays.sort(nums); // To sort Array -> Complexity O(NlogN)

    for(int i=0;i<=nums.length-2;++i) 
      if(nums[i]==nums[i+1]) {
        list.add(nums[i]);
      }
    return list;
    }
}