class Solution {
    public char findTheDifference(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        for(int i=0 ; i<s.length() ; i++){
            if(sarr[i] != tarr[i])
                return tarr[i];
        }
        return tarr[tarr.length-1];
    }
    
}