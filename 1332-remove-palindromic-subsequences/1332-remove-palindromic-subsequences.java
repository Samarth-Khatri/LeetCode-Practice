class Solution {
    public int removePalindromeSub(String s) {
        return isPalindrome(s)?1:2;
    }
    
    public static boolean isPalindrome(String ans){
		int i = 0;
		int j = ans.length()-1;
		while(j>i) {
			if(ans.charAt(i) != ans.charAt(j))
				return false;
			i++; j--;
		}
		return true;
	}
}