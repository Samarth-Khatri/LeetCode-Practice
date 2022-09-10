class Solution {
    List<Integer>[] graph;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        if (quiet == null || n == 0) 
            return new int[0];

        //initialize graph with adjacency list
        graph = new ArrayList[n];

        for (int node = 0; node < graph.length; ++node) 
            graph[node] = new ArrayList<>();

        //build graph: poor -> rich
        for (int i = 0; i < richer.length; ++i) 
            graph[richer[i][1]].add(richer[i][0]);

        //answer array
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; ++i) 
            dfs(i, ans, quiet);

        return ans;
    }

    public int dfs(int node, int[] res, int[] quiet) {
        //filling result array with -1 initially will avoid repetion here
        if (res[node] == -1) {
            res[node] = node;

            //depthwise check for every richer person if they are quieter
            for (int child : graph[node]) {
                int curr = dfs(child, res, quiet);

                //quieter person
                if (quiet[curr] < quiet[res[node]]) 
                    res[node] = curr;
            }
        }
        return res[node];
    }
}
