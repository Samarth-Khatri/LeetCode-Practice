class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result =new ArrayList<>();
        long val=1;
        int i=rowIndex;
        for(int j=0;j<=i;j++){
            result.add((int)val);
            val=val*(i-j)/(j+1);
        }
        return result;
    }
}