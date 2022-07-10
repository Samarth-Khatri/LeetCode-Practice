class Solution {
    public int search(int[] nums, int target) {
        return findNum(nums,target,0,nums.length-1);
    }
    
    public int findNum(int[] nums,int target, int beg,int end){
        int mid=(end+beg)/2;
        if(nums[mid]==target)
            return mid;
        
        if(beg>end)
            return -1;
    
        if(target>nums[mid])
            return findNum(nums,target,mid+1,end);
    
        return findNum(nums,target,beg,mid-1);
    }
}