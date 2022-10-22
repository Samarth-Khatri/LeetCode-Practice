class Solution {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return ""; 
        String ans = "";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char ch : t.toCharArray()) 
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        int mct = 0; // match count
        int dmct = t.length(); // desired match count
        int i = -1, j = -1;
        while (true) {
            boolean f1 = false, f2 = false;

            // acquire
            while (i < s.length() - 1 && mct < dmct) {
                i++;
                char ch = s.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
                if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) mct++;
                f1 = true;
            }

            // collect ans and release
            while (j < i && mct == dmct) {
                String temp = s.substring(j + 1, i + 1);
                if (ans.length() == 0 || temp.length() < ans.length()) ans = temp;
                j++;
                char ch = s.charAt(j);
                if (map1.get(ch) == 1) map1.remove(ch); 
                else map1.put(ch, map1.get(ch) - 1);
                if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) mct--;
                f2 = true;
            }

            if (!f1 && !f2) break;
        }
        return ans;
    }
}
