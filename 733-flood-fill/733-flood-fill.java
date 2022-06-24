class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        rres(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    
    public void rres(int[][] image, int i, int j, int color, int prevColor){
        if((i<0 || i>=image.length) || (j<0 || j>=image[0].length))
            return;

        if(image[i][j] != prevColor || image[i][j] == color)
            return;

        prevColor = image[i][j];
        image[i][j] = color;

        rres(image,i-1,j,color,prevColor);
        rres(image,i+1,j,color,prevColor);
        rres(image,i,j-1,color,prevColor);
        rres(image,i,j+1,color,prevColor);
    }
}