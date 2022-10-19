class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) // Put in Map
            map.put(word, map.getOrDefault(word, 0) + 1);
        ArrayList<String> res = new ArrayList<>(map.keySet()); // Ans List
        Collections.sort(res, (a,b) -> map.get(b) != map.get(a) ? (map.get(b)-map.get(a)) : a.compareTo(b));
        return res.subList(0, k);
    }
}
