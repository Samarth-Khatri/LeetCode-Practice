class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Approach 1
        String longPrefix = strs[0];
        for(int i=1;i<strs.length;i++) {
            if(strs[i].length() == 0) 
                return "";

            while(!strs[i].startsWith(longPrefix)) 
                longPrefix = longPrefix.substring(0,longPrefix.length()-1);
        }
        return longPrefix;
    }
}