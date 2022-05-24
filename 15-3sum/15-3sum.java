class Solution {
public List<List<Integer>> threeSum(int[] nums) {
    HashSet<List<Integer>> result = new HashSet<>();
    int target=0;
    Arrays.sort(nums); // Complexity O(NlogN)

    for(int i=0;i<=nums.length-3;++i) { // Complexity O(N^2)
        
        int utarget = target - nums[i];
        int k=i+1;
        int j=nums.length-1;

        while(k<j) { 
            
            List<Integer> list = new ArrayList<>();
            
            if(nums[j]+nums[k]>utarget) 
              j--;
            
            else if(nums[j]+nums[k]<utarget)
              k++;
            
            else {
              list.add(nums[i]);
              list.add(nums[k]);
              list.add(nums[j]);
              j--;
              k++;
              result.add(list);
            }
        }
    }
     return new ArrayList<>(result);
}
}