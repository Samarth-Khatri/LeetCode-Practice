class Solution {
    int k = 0;

    public int[] findBall(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int j = 0; j < n; j++) {
            dfs(arr, 0, j, m, n, ans);
            k++;
        }
        return ans;
    }

    private void dfs(int[][] arr, int i, int j, int m, int n, int[] ans) {
        if (i == m) { // ball fallen save ans
            ans[k] = j;
            return;
        }

        //if 1 is being traversed and its RIGHT neighbour is wall or RIGHT neighbour is -1
        //ball will get stuck
        if (arr[i][j] == 1 && (j + 1 >= n || arr[i][j + 1] == -1)) return;
        
        //if -1 is being traversed and its LEFT neighbour is wall or LEFT neighbour is 1
        //ball will get stuck
        else if (arr[i][j] == -1 && (j - 1 < 0 || arr[i][j - 1] == 1)) return;
        
        // if 1 is being traversed so take me to RIGHT diagonal because 1
        else if (arr[i][j] == 1) dfs(arr, i + 1, j + 1, m, n, ans); // travel further
        
        // if -1 is being traversed so take me to LEFT diagonal because -1
        else if (arr[i][j] == -1) dfs(arr, i + 1, j - 1, m, n, ans); // travel further
    }
}
