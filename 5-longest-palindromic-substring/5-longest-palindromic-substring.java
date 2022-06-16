class Solution {
    // BRUTE FORCE -> TLE
//     public String longestPalindrome(String s) {
//         String ans = "";
//         int len = 0;
//         for(int i=0;i<s.length();i++) {
// 		    for(int j=i+1;j<=s.length();j++) {
// 			    String sub = s.substring(i,j);
// 			    if(isPalindrome(sub)==true) 
//                     if(sub.length()>=ans.length())
//                         ans = sub;
//             }
// 		}
//         return ans;
//     }
    
//     public static boolean isPalindrome(String ans){
// 		int i = 0;
// 		int j = ans.length()-1;
// 		while(j>i) {
// 			if(ans.charAt(i) != ans.charAt(j))
// 				return false;
// 			i++; j--;
// 		}
// 		return true;
// 	}
    
    // BETTER OPTIMIZED
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1)
            return " ";
        int start=0, end=0;
        for(int i=0;i<s.length();++i) {
            int len1 = check(s,i,i);
            int len2 = check(s,i,i+1);
            int flen = Math.max(len1,len2);
            if(flen>end-start) {
                start=i-(flen-1)/2;
                end=i+flen/2;
            }
        }
        return s.substring(start,end+1);
    }
    
    public int check(String s, int l, int r) {
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
            l--; r++;
        }
        return r-l-1;
    }
}