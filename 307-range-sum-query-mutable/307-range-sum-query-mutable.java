class NumArray {
    // Prefix Sum Approach -> TLE
    //     private int[] prefixSum;
    //     private int[] nums;
    //     public NumArray(int[] nums) {
    //         this.nums = nums;
    //         prefixSum = new int[nums.length + 1];
    //         for(int i=1;i<=nums.length;++i)
    //             prefixSum[i] = nums[i-1] + prefixSum[i-1];
    //     }

    //     public void update(int index, int val) {
    //         int prevVal = nums[index];
    //         nums[index] = val;
    //         for(int i=index+1;i<prefixSum.length;++i)
    //             prefixSum[i] += val - prevVal;
    //     }

    //     public int sumRange(int left, int right) {
    //         return prefixSum[right + 1] - prefixSum[left];
    //     }

    // Segment Trees
    int tree[];
    int nums[];
    int len;

    public NumArray(int[] nums) {
        this.nums = nums;
        len = nums.length;
        tree = new int[4 * len];

        build(1, 0, len - 1);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }

        int mid = start + (end - start) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public void update(int index, int val) {
        update(1, 0, len - 1, index, val - nums[index]);
        nums[index] = val;
    }

    private void update(int node, int start, int end, int index, int toAdd) {
        if (start == end) {
            tree[node] += toAdd;
            return;
        }

        int mid = start + (end - start) / 2;
        if (index <= mid) 
            update(node * 2, start, mid, index, toAdd); 
        else 
            update(node * 2 + 1, mid + 1, end, index, toAdd);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public int sumRange(int left, int right) {
        return query(1, 0, len - 1, left, right);
    }

    private int query(int node, int start, int end, int left, int right) {
        if (start > right || end < left) 
            return 0;
        if (start >= left && end <= right) 
            return tree[node];

        int mid = start + (end - start) / 2;
        return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
