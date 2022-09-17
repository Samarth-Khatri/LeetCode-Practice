class Solution {

    public int largestRectangleArea(int[] a) {
        
        // Left Boundary
        int[] lb = new int[a.length];
        Stack<Integer> ls = new Stack<>();
        ls.push(0);
        lb[0] = -1;
        for (int i = 1; i < a.length; ++i) {
            while (!ls.isEmpty() && a[i] <= a[ls.peek()]) 
                ls.pop();
            if (ls.isEmpty()) lb[i] = -1; 
            else lb[i] = ls.peek();
            ls.push(i);
        }

        // Right Boundary
        int[] rb = new int[a.length];
        Stack<Integer> rs = new Stack<>();
        rs.push(a.length - 1);
        rb[a.length - 1] = a.length;
        for (int i = a.length - 2; i >= 0; --i) {
            while (!rs.isEmpty() && a[i] <= a[rs.peek()]) 
                rs.pop();
            if (rs.isEmpty()) rb[i] = a.length; 
            else rb[i] = rs.peek();
            rs.push(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; ++i) {
            int height = a[i];
            int width = rb[i] - lb[i] - 1;
            int area = height * width;
            max = Math.max(max, area);
        }

        return max;
    }
}
