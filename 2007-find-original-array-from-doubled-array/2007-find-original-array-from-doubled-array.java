class Solution {
    public int[] findOriginalArray(int[] changed) {
        int[] temp = new int[changed.length/2];
        Queue<Integer> que = new ArrayDeque<>();
        Arrays.sort(changed);
        int i = 0;
        for(int num : changed) {
            if(!que.isEmpty() && que.peek() == num) {
                temp[i] = que.remove()/2;
                i++;
            }
            else que.add(num*2);
        }
        return que.size() > 0 ? new int[]{} : temp;
    }
}