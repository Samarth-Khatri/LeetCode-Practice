class Solution {
    public int searchInsert(int[] arr, int target) {
         int count = 0 ;
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]==target || arr[i]>target)
                return i;
        }
        return (arr.length);
    }
}