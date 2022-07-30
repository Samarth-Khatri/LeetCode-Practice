class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int []farr = new int[26];
        for(String word : words2) {
            int []temp = new int[26];
            for(char ch : word.toCharArray()) {
                temp[ch-'a']++;
                farr[ch-'a'] = Math.max(farr[ch-'a'], temp[ch-'a']);
            }
        }
        
        for(String word : words1) {
            int []farr2 = new int[26];
            for(char ch : word.toCharArray())
                farr2[ch-'a']++;
            if(subset(farr2,farr))
                ans.add(word);
        }
        return ans;
    }
    
    private boolean subset(int []src, int []dest) {
        for(int i=0;i<26;++i)
            if(dest[i]>src[i])
                return false;
        return true;
    }
}