class Solution {

    public int concatenatedBinary(int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= n; ++i) 
            str.append(Integer.toBinaryString(i));
        int MAX = 1000000007;
        int ans = 0;
        String s = str.reverse().toString();
        int c = 1;
        for (int i = 0; i < s.length(); ++i) {
            ans += (s.charAt(i) - '0') * c;
            ans %= MAX;
            c *= 2;
            c %= MAX;
        }
        return ans;
    }
}
