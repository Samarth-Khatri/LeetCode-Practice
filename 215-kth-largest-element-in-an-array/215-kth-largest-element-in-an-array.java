class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length - 1, nums.length-k);
    }
    
    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        int pivot = arr[hi];
        int pidx = partition(arr,pivot,lo,hi);
        if(pidx==k)
          return pivot;
        else if(k>pidx)
          return quickSelect(arr,pidx+1,hi,k);
        else
          return quickSelect(arr,lo,pidx-1,k);
    }
    
    public static int partition(int[] arr, int pivot, int lo, int hi) {
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            }
            else 
                i++;
        }
        return (j - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}