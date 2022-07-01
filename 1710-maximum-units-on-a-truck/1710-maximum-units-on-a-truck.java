class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->{ // sort in decreasing order of number of units / box
            return b[1]-a[1];
        });
        int maxUnits=0;
        for(int i=0;i<boxTypes.length;++i) { // iterate in array
            if(truckSize<boxTypes[i][0]) // if trucksize is less than no. of boxes
                return maxUnits + (truckSize*boxTypes[i][1]); // take remaining trucksize no. of boxes 
            maxUnits += boxTypes[i][0] * boxTypes[i][1]; // trucksize avialble than take all boxes
            truckSize -= boxTypes[i][0]; // decrease the trucksize
        }
        return maxUnits;
    }
}