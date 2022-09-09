class Solution {
    public int numberOfWeakCharacters(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
           if(a[0] != b[0]){ 
			   // if two characters have different attack status, we sort them descendingly
               return b[0] - a[0];
           } else {
			   // if two characters have the same attack status, we sort them ascendingly
               return a[1] - b[1];
           }
        });
        
		// initialize max defence as the first character in the sorted array
		// that character will have highest attack status and lowest defence status 
        int cnt = 0, maxDef = arr[0][1];
        for (int i = 1; i < arr.length; ++i){
            if (arr[i][1] < maxDef) 
                cnt++;
            maxDef = Math.max(maxDef, arr[i][1]);
        }
        return cnt;
    }
}