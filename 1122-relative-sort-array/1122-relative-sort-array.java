class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int []farr = new int[10001];
        for(int i=0;i<arr1.length;i++) 
            farr[arr1[i]]++;
        
        int j=0;
        for(int i=0;i<arr2.length;i++)
           while(farr[arr2[i]]>0){
               arr1[j] = arr2[i];
               farr[arr2[i]]--; j++;
           }
        
        for(int i=0;i<farr.length;i++)
            while(farr[i]>0){
                arr1[j] = i;
                farr[i]--; j++;
            }

        return arr1;
    }
}