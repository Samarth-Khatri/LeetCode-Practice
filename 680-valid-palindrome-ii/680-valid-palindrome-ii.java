class Solution {

    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) 
                return (isPalindrome(s,i,j-1) || isPalindrome(s,i+1,j));
            i++; j--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) 
                return false;
            l++; r--;
        }
        return true;
    }
}
