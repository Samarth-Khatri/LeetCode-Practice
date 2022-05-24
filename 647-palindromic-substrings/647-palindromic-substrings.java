class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<=s.length();j++) {
				String sub = s.substring(i,j);
				if(isPalindrome(sub)==true)
                    cnt++;
			}
		}
        return cnt;
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