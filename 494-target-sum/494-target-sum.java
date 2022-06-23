class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return rres(nums,nums.length,target);
    }
    private int rres(int[] A, int N, int target) {
        if(N==0 && target==0) 
            return 1;
        if(N==0) 
            return 0;
         return rres(A,N-1,target-A[N-1]) + rres(A,N-1,target+A[N-1]);
    }
}