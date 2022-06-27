class Solution {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length-1;
        
        while(left<=right) {
            int middle = (left+right)/2;
            
            int leftNum = nums[left];
            int rightNum = nums[right];
            int middleNum = nums[middle];
            
            if(target==leftNum) 
                return left;
            if(target==rightNum) 
                return right;
            if(target==middleNum) 
                return middle;
            
            if(target>leftNum && target<middleNum) 
                right = middle-1;
            else if(target>middleNum && target<rightNum) 
                left = middle+1;
            else { 
                right--;
                left++;
            }
        }
        return -1;
    }
}