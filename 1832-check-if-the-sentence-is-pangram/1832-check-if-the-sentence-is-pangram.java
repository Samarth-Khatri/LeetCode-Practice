class Solution {

    public boolean checkIfPangram(String sentence) {
        HashMap<Character, Integer> dmap = new HashMap<>(); // default map
        HashMap<Character, Integer> cmap = new HashMap<>(); // check map
        for (char ch = 'a'; ch <= 'z'; ++ch) dmap.put(ch, 1);
        for (int i = 0; i < sentence.length(); ++i) cmap.put(sentence.charAt(i), 1);
        return dmap.equals(cmap);
    }
}
