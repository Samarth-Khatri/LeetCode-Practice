class Solution {

    public void sortColors(int[] nums) {
        int blue = nums.length - 1;
        int red = 0;
        int i = 0;
        while(i<=blue) {
            if (nums[i] == 2) 
                swap(nums,i,blue--);
            else if(nums[i]==0) 
                swap(nums,i++,red++);
            else i++;
        }
    }

    public void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
