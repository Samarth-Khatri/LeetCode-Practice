class Solution {

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ansList = new ArrayList<>();
        for (int i = 1; i < 10; ++i) 
            helper(n, k, i, 1, i, ansList);
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); ++i) 
            ans[i] = ansList.get(i);
        return ans;
    }

    public void helper(int n, int k, int prevDigit, int digitCount, int num, List<Integer> ans) {
        if (digitCount == n) {
            ans.add(num);
            return;
        }
        
        if (k == 0) 
            helper(n, k, prevDigit, digitCount + 1, num * 10 + (prevDigit), ans); 
        
        else {
            if (prevDigit - k >= 0) 
                helper(n, k, prevDigit - k, digitCount + 1, num * 10 + (prevDigit - k), ans);
            if (prevDigit + k < 10) 
                helper(n, k, prevDigit + k, digitCount + 1, num * 10 + (prevDigit + k), ans);
        }
    }
}
