class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
      long mod = (long)1e9+7; // modulo
      Arrays.sort(horizontalCuts); //sorting in increasing
      Arrays.sort(verticalCuts); //sorting in icreasing
      
      long hor = Math.max(horizontalCuts[0], h-horizontalCuts[horizontalCuts.length-1]);
      long ver = Math.max(verticalCuts[0], w-verticalCuts[verticalCuts.length-1]);
      
      for(int i=1;i<horizontalCuts.length;++i) 
          hor = Math.max(hor, horizontalCuts[i]-horizontalCuts[i-1]);
      for(int i=1;i<verticalCuts.length;++i) 
          ver = Math.max(ver, verticalCuts[i]-verticalCuts[i-1]);
      
      return (int)((hor*ver)%mod);
    } 
}