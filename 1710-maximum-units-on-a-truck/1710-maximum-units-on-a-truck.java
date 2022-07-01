class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->{ // sort in decreasing order of number of units / box
            return b[1]-a[1];
        });
        int maxUnits=0;
        for(int i=0;i<boxTypes.length;++i) {
            if(truckSize<boxTypes[i][0])
                return maxUnits + (truckSize*boxTypes[i][1]);
            maxUnits += boxTypes[i][0] * boxTypes[i][1];   
            truckSize -= boxTypes[i][0];
        }
        return maxUnits;
    }
}