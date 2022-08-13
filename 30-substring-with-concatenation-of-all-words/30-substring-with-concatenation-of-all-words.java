class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        
        int len = words[0].length(); // length of each word
		Map<String, Integer> map = new HashMap<>();
		
        for (String word : words) 
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        for (int i=0;i<=s.length()-len*words.length;++i) {
			Map<String, Integer> cMap = new HashMap<>(map); // Copy Map
			
            for (int j=0;j<words.length;++j) {
				String str = s.substring(i+j*len, i+j*len+len);
				
                if(cMap.containsKey(str)) { // substring is in remaining words
					int cnt = cMap.get(str);
					
                    if (cnt == 1) // last remaining one so remove
                        cMap.remove(str);
					else 
                        cMap.put(str, cnt - 1); // othervise decrease freq
					
                    if (cMap.isEmpty()) { // substring matches
						res.add(i);
						break;
					}
				} 
                
                else break; // map does not contain the substring
			}
		}
        
		return res;
    }
}