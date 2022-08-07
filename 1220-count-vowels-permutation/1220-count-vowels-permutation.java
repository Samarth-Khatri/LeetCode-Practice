class Solution {
    
    private int MOD = 1000000007;
    
    public int countVowelPermutation(int n) {
        int a, e, i, o, u;
        a = e = i = o = u = 1;
        for(int j=1;j<n;++j) {
            int na = e;
            int ne = (a + i) % MOD;
            int ni = ((a + e) % MOD + (o + u) % MOD) % MOD;
            int no = (i + u) % MOD;
            int nu = a;

            a = na;
            e = ne;
            i = ni;
            o = no;
            u = nu;
        }
        return ((a + e) % MOD + ((i + o) % MOD + u) % MOD) % MOD;    
    }
}