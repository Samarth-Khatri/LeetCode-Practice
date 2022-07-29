class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for(String str : words)
            if(check(str,pattern))
                ans.add(str);
        return ans;
    }
    
    private boolean check(String str, String pattern) {
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<str.length();++i) {
            if(!map.containsKey(pattern.charAt(i))) {
                if(map.containsValue(str.charAt(i)))
                    return false;
                map.put(pattern.charAt(i), str.charAt(i));
            }
            else if(map.get(pattern.charAt(i)) != str.charAt(i))
                return false;
        }
        
        return true;
    }
}