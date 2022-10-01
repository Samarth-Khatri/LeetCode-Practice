class Solution {
    int res = 0;
    HashMap<String, Integer> map;

    public int numDecodings(String s) {
        map = new HashMap<>();
        rres(s);
        return res;
    }

    private void rres(String s) {
        if (s.startsWith("0")) return;
        if (s.length() < 2) {
            res++;
            return;
        }

        if (map.containsKey(s)) {
            res += map.get(s);
            return;
        }

        for (int i = 0; i < Math.min(s.length(), 2); ++i) {
            int val = Integer.valueOf(s.substring(0, i + 1));
            if (val >= 1 && val <= 26) rres(s.substring(i + 1));
            map.put(s.substring(i + 1), res);
        }
    }
}
