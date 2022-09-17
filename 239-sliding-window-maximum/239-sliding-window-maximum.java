class Solution {

    // Priority Queue Approach -> T.C. -> O(NlogK) -> TLE
    //     public int[] maxSlidingWindow(int[] arr, int k) {
    //         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    //         int n = arr.length;
    //         ArrayList<Integer> ans = new ArrayList<>();
    //         for (int i = 0; i < k; i++)
    //             pq.add(arr[i]);

    //         ans.add(pq.peek());
    //         pq.remove(arr[0]);

    //         for (int i = k; i < n; i++) {
    //             pq.add(arr[i]);
    //             ans.add(pq.peek());
    //             pq.remove(arr[i - k + 1]);
    //         }

    //         int a[] = new int[ans.size()];
    //         for (int j = 0; j < ans.size(); j++)
    //             a[j] = ans.get(j);

    //         return a;
    //     }

    // Stack Approach -> T.C. -> O(N)
    public int[] maxSlidingWindow(int[] arr, int k) {
        
        // For Finding Next Greater Element
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; --i) {
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) 
                st.pop();
            if (st.isEmpty()) nge[i] = arr.length; 
            else nge[i] = st.peek();
            st.push(i);
        }

        int[] ans = new int[arr.length - k + 1];
        int j = 0; // To travel in nge
        for (int i = 0; i <= arr.length - k; ++i) {
            if (j < i) j = i;
            while (nge[j] < i + k) j = nge[j];
            ans[i] = arr[j];
        }
        
        return ans;
    }
}
