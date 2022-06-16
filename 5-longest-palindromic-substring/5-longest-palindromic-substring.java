class Solution {
    // BRUTE FORCE -> TLE
    public String longestPalindrome(String s) {
        String ans = "";
        int len = 0;
        for(int i=0;i<s.length();i++) {
		    for(int j=i+1;j<=s.length();j++) {
			    String sub = s.substring(i,j);
			    if(isPalindrome(sub)==true) 
                    if(sub.length()>=ans.length())
                        ans = sub;
            }
		}
        return ans;
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
    
// BETTER OPTIMIZED -> EXPAND AROND CENTER
    public String longestPalindrome(String s) {
        if (s.length()<=1) 
            return s;

        String result = "";
        for (int i=0;i<s.length();++i) {
            String odd = expandRange(s,i-1,i+1);
            if (odd.length() > result.length()) 
                result = odd;

            String even = expandRange(s,i,i+1);
            if (even.length() > result.length()) 
                result = even;
        }
        return result;
    }


    private String expandRange(String s, int left, int right) {

        String string = s;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return string.substring(left + 1, right); 
    }
}
