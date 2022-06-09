class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
       List<Boolean> ans = new ArrayList<>();
        int maxcandies = 0;
        for(int i=0;i<candies.length;++i)
            if(candies[i]>maxcandies)
                maxcandies=candies[i];
        for(int i=0;i<candies.length;++i) {
            if(maxcandies<candies[i]+extraCandies || maxcandies==candies[i]+extraCandies)
                ans.add(true);
            else
                ans.add(false);
         }
        return ans;
    }
}