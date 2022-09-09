class Solution {

    public int consecutiveNumbersSum(int N) {
        int cnt = 1;
        for (int i=2; i*(i-1)/2 < N; ++i) 
            if ((N - i*(i-1)/2) % i == 0) 
                cnt++;
        return cnt;
    }
}
