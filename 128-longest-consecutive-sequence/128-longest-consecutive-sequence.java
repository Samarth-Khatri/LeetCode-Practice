class Solution {
    
    // Approach 1 -> Using Sorting
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums); // sorting
        if(nums.length<2) 
            return nums.length;
        int cnt=1, lcs=1;
        for(int i=1;i<nums.length;++i) {
            if(nums[i-1]==nums[i])  // duplicate check
                continue;
            else if(nums[i-1]+1 == nums[i]) // consecutive check
                cnt++;
            else 
                cnt=1;     // if consecutive sequence breaks reset count 

            lcs = Math.max(lcs,cnt); // max of count and prev longest consecutive subsequence
        }
        
    return lcs;
        
    }
    
    
    // Approach 2 -> Using HashSet
    public int longestConsecutive(int[] nums) {
        if(nums.length<2) 
            return nums.length;
        Set<Integer> hashSet = new HashSet<Integer>();
        for(int num : nums)  // adding to hashset
            hashSet.add(num);
        int lcs=1;
        for (int num: hashSet)
            // check if element is the start of a sequence: (element-1) does not exist in set
            if (!hashSet.contains(num-1)) {
                int cnt=1;
                while (hashSet.contains(num+cnt)) 
                    cnt++;
                lcs = Math.max(lcs,cnt); // max of count and prev longest consecutive subsequence
            }
        return lcs;
    }
    
    
    // Approach 3 -> Using HashMap
    public int longestConsecutive(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int val : arr)
            map.put(val, true);

        for(int val : arr)
            if(map.containsKey(val-1))
                map.put(val, false);

        int msp = 0; // max starting point
        int mlen = 0; // max length
        for(int val : arr) {
            if(map.get(val)) {
                int tsp = val; // temp sp
                int tlen = 1; // temp length

                while(map.containsKey(tsp+tlen)) // increasing length
                    tlen++;

                if(tlen > mlen) { // updating maximums
                    mlen = tlen;
                    msp = tsp;
                }
            }
        }
        
        int []ans = new int[mlen];
        for(int i=0;i<mlen;++i)
            ans[i] = msp + i;
        
        return ans.length;
    }
}
