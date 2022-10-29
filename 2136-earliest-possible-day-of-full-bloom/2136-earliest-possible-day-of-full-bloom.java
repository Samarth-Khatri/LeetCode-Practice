class Solution {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int[][] arr = new int[plantTime.length][2];
        for (int i = 0; i < plantTime.length; ++i) {
            arr[i][0] = plantTime[i];
            arr[i][1] = growTime[i];
        }
        Arrays.sort(arr, (a, b) -> (b[1] - a[1])); // growtime in descending 
        int max = 0;
        int plant = 0;
        for (int i = 0; i < arr.length; ++i) {
            plant += arr[i][0];
            max = Math.max(max, plant + arr[i][1]);
        }
        return max;
    }
}
