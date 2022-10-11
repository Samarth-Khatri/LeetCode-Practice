class Solution {

    public boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if(num <= left) left = num; 
            else if(num <= mid) mid = num; 
            else return true;
        }
        return false;
    }
}