class Solution {
    
    class Pair {
      int vtx;
      int lvl;

      Pair(int vtx, int lvl) {
         this.vtx = vtx;
         this.lvl = lvl;
      }
   }

    public boolean isBipartite(int[][] graph) {
        Integer[] visited = new Integer[graph.length];
        for (int i = 0; i < graph.length; ++i) 
            if (visited[i] == null) 
                if (!isCompBipartite(graph, visited, i)) 
                    return false;
        return true;
    }

    public boolean isCompBipartite(int[][] graph, Integer[] visited, int src) {
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(src, 0));
        while (!que.isEmpty()) {
            Pair rem = que.remove();
            if (visited[rem.vtx] != null) 
                if (visited[rem.vtx] != rem.lvl % 2) 
                    return false;
            visited[rem.vtx] = rem.lvl % 2; // 0 for even, 1 for odd and null if not visited
            for (int nbr : graph[rem.vtx]) 
                if (visited[nbr] == null) 
                    que.add(new Pair(nbr, rem.lvl + 1));
        }
        return true;
    }
}
