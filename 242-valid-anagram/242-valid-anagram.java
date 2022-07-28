class Solution {
    
    // Using Freq Array
    // public boolean isAnagram(String s, String t) {
    //     int[] alphabets=new int[26];
    //     for (char c : s.toCharArray()) 
    //         alphabets[c - 'a']++;
    //     for (char c : t.toCharArray()) {
    //         alphabets[c - 'a']--;
    //         if (alphabets[c - 'a'] == -1) 
    //             return false;
    //     }
    //     for (int a : alphabets) 
    //         if (a!=0) 
    //             return false;
    //     return true;
    // }
    
    // Using HashMap
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hs = new HashMap<>(); // freq of each letter of the string S
        HashMap<Character, Integer> h = new HashMap<>(); // freq of each letter fo the string T
        if(s.length() > t.length())
            return false;
        
        for(Character ch: s.toCharArray())
            if(h.containsKey(ch))
		        h.put(ch, h.get(ch) + 1); 
            else
                h.put(ch,1);
        
        for(Character c: t.toCharArray()) 
            if(hs.containsKey(c))
		        hs.put(c, hs.get(c) + 1); 
            else
                hs.put(c,1);
        
        if(h.equals(hs) == true) 
            return true;

        return false;
        
    }
}