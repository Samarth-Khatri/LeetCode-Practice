class Solution {

    public String breakPalindrome(String s) {
        if (s.length() == 1) 
            return "";
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length() / 2; ++i) {
            if (c[i] != 'a') {
                c[i] = 'a';
                return new String(c);
            }
        }
        c[s.length() - 1] = 'b';
        return new String(c);
    }
}
