class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=0, right = nums.length-1;
        int[] res = bSearch(nums,left,right,target); // Binary Search
        return res;
    }


    public int[] bSearch(int[] nums, int left, int right, int target) {
        int[] result = {-1, -1};
        
        if (left<=right) {   
            int mid = (left+right)/2;

            if (target==nums[mid]) { // mid is one of the two index
                int i=mid;
                while (i>=0 && target==nums[i])  // finding first towards left of mid
                    i--;
                result[0] = i+1; // adding to result
                
                i=mid;
                while (i<nums.length && target==nums[i]) // finding last towards right of mid
                    i++;
                result[1] = i-1; // adding to result
                
                return result; 
            } 
            
            else if (target<nums[mid]) // both first and last exists towards left of mid
                return bSearch(nums,left,mid-1,target);
            else                       // both first and last exists towards right of mid
                return bSearch(nums,mid+1,right,target); 
            
        }

        return result;

    }
}