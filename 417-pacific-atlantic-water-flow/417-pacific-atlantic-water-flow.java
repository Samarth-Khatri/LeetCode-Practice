class Solution {
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        boolean pacificVisited[][] = new boolean[heights.length][heights[0].length];
        boolean atlanticVisited[][] = new boolean[heights.length][heights[0].length];
        
        for(int i = 0; i < heights.length; ++i)
            dfs(heights, i, 0, heights[i][0], pacificVisited);
        
        for(int i = 0; i < heights[0].length; ++i)
            dfs(heights, 0, i, heights[0][i], pacificVisited);
        
        
        for(int i = 0; i < heights.length; ++i)
            dfs(heights, i, heights[0].length-1, heights[i][heights[0].length-1], atlanticVisited);
        
            
        for(int i = 0; i < heights[0].length ; ++i)
            dfs(heights, heights.length-1, i, heights[heights.length-1][i], atlanticVisited);
        
        
        for(int i = 0; i < heights.length; ++i)
            for(int j = 0; j < heights[0].length; ++j)
                if(pacificVisited[i][j] && atlanticVisited[i][j])
                    res.add(new ArrayList<>(Arrays.asList(i,j)));
                
        return res;
    }
    
    public void dfs(int heights[][], int i, int j, int height,boolean visited[][]){
        if(i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || heights[i][j] < height)
            return;
        
        if(visited[i][j]) 
            return;
        
        visited[i][j] = true;
        dfs(heights, i+1, j, heights[i][j],visited);
        dfs(heights, i, j+1, heights[i][j], visited);
        dfs(heights, i-1, j, heights[i][j],visited);
        dfs(heights, i, j-1, heights[i][j],visited);
    }
}