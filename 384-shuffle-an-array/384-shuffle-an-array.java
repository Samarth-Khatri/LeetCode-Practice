class Solution {
    
    int[] arr;
    int[] original;
    Random rand;
    
    public Solution(int[] nums) {
        this.arr = nums;
        this.original = Arrays.copyOfRange(nums, 0, nums.length);
        this.rand = new Random();
    }
    
    public int[] reset() {
        return original;
    }
    
    public int[] shuffle() {
        //push the random selected val to the end and decrease end bound
        for (int i=arr.length-1;i>=0;--i) {
            int j = rand.nextInt(i+1);
            swap(arr,j,i);
        }
        return arr;
    }
    
    public void swap (int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */