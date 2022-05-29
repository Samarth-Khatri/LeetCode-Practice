class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Approach 1
//         String longPrefix = strs[0];
//         for(int i=1;i<strs.length;i++) {
//             if(strs[i].length() == 0) 
//                 return "";

//             while(!strs[i].startsWith(longPrefix)) 
//                 longPrefix = longPrefix.substring(0,longPrefix.length()-1);
//         }
//         return longPrefix;
        
        // Approach 2
        String ans = strs[0];
        for(int i=1;i<strs.length;i++)
            while(strs[i].indexOf(ans)!=0)
                ans = ans.substring(0,ans.length()-1);
        return ans;
    }
}