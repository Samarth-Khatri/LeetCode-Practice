class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        int min = s.length();
        for(Map.Entry<Character, Integer> hm : map.entrySet()){
            if(hm.getValue() == 1)
                min = Math.min(min, s.indexOf(hm.getKey()));
        }
        return (min == s.length()) ? -1 : min;
    }
}