class NumArray {
    // Normal Approach
    List<Integer> arr = new ArrayList<>();
    int totalSum = 0;

    public NumArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
            totalSum += nums[i];
        }
    }

    public void update(int index, int val) {
        totalSum = totalSum + val - arr.get(index);
        arr.set(index, val);
    }

    public int sumRange(int left, int right) {
        int sum = totalSum;
        for (int i = 0; i < left; i++) 
            sum = sum - arr.get(i);
        for (int i = right + 1; i < arr.size(); i++) 
            sum = sum - arr.get(i);
        return sum;
    }
    
    // Segment Trees
    //     int tree[];
    //     int nums[];
    //     int len;

    //     public NumArray(int[] nums) {
    //         this.nums = nums;
    //         len = nums.length;
    //         tree = new int[4 * len];

    //         build(1, 0, len - 1);
    //     }

    //     private void build(int node, int start, int end) {
    //         if (start == end) {
    //             tree[node] = nums[start];
    //             return;
    //         }

    //         int mid = start + (end - start) / 2;
    //         build(node * 2, start, mid);
    //         build(node * 2 + 1, mid + 1, end);

    //         tree[node] = tree[node * 2] + tree[node * 2 + 1];
    //     }

    //     public void update(int index, int val) {
    //         update(1, 0, len - 1, index, val - nums[index]);
    //         nums[index] = val;
    //     }

    //     private void update(int node, int start, int end, int index, int toAdd) {
    //         if (start == end) {
    //             tree[node] += toAdd;
    //             return;
    //         }

    //         int mid = start + (end - start) / 2;
    //         if (index <= mid)
    //             update(node * 2, start, mid, index, toAdd);
    //         else
    //             update(node * 2 + 1, mid + 1, end, index, toAdd);

    //         tree[node] = tree[node * 2] + tree[node * 2 + 1];
    //     }

    //     public int sumRange(int left, int right) {
    //         return query(1, 0, len - 1, left, right);
    //     }

    //     private int query(int node, int start, int end, int left, int right) {
    //         if (start > right || end < left)
    //             return 0;
    //         if (start >= left && end <= right)
    //             return tree[node];

    //         int mid = start + (end - start) / 2;
    //         return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
    //     }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
