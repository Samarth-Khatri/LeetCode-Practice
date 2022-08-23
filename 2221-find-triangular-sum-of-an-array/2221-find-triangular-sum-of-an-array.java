class Solution {

    public int triangularSum(int[] nums) {
        int n = nums.length;
        if (n == 1) 
            return nums[0];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            list.add(nums[i]);
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < list.size() - 1; j++) 
                list.set(j, (list.get(j) + list.get(j + 1)) % 10);
            n--;
            if (list.size() > 2) 
                list.remove(list.size() - 1);
        }
        return list.get(0);
    }
}
