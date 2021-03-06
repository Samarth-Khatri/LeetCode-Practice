class Solution {
    public int candy(int[] ratings) {
        int candies=0, n=ratings.length;
        int []left = new int[n];
        int []right = new int[n];
        
        Arrays.fill(left,1); // filling left array with at least 1 candy
        Arrays.fill(right,1); // filling right array with at least 1 candy
        
        // Left relative array
        for(int i=1;i<n;++i)
            if(ratings[i]>ratings[i-1])
                left[i]=left[i-1]+1;
        
        // right relative array
        for(int i=n-2;i>=0;--i)
            if(ratings[i]>ratings[i+1])
                right[i]=right[i+1]+1;
        
        // Merge both sides
        for(int i=0;i<n;++i)
            candies += Math.max(left[i],right[i]); // taking the max candies
        
        return candies;
    }
}