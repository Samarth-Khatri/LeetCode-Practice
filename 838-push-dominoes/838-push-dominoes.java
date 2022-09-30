class Solution {

    public String pushDominoes(String dominoes) {
        
        // Iteration from right for left domino
        int n = dominoes.length();
        int[] left = new int[n];
        int nearestLeftIndex = -1;
        for (int i = n - 1; i >= 0; --i) {
            char ch = dominoes.charAt(i);
            if (ch == 'L') nearestLeftIndex = i;
            else if (ch == 'R') nearestLeftIndex = -1;
            left[i] = nearestLeftIndex;
        }

        // Iteration from left for right domino
        int[] right = new int[n];
        int nearestRigtIndex = -1;
        for (int i = 0; i < n; ++i) {
            char ch = dominoes.charAt(i);
            if (ch == 'L') nearestRigtIndex = -1;
            else if (ch == 'R') nearestRigtIndex = i;
            right[i] = nearestRigtIndex;
        }
        
        char[] ans = new char[n];
        for (int i = 0; i < n; ++i) {
            if (dominoes.charAt(i) == '.') {
                int nearestLeft = left[i];
                int nearestRight = right[i];

                int leftDiff = nearestLeft == -1 ? Integer.MAX_VALUE : Math.abs(nearestLeft - i);
                int rightDiff = nearestRight == -1 ? Integer.MAX_VALUE : Math.abs(nearestRight - i);

                if (leftDiff == rightDiff) ans[i] = '.';
                else if (leftDiff < rightDiff) ans[i] = 'L';
                else if (leftDiff > rightDiff) ans[i] = 'R';
            }

            else ans[i] = dominoes.charAt(i);
        }
        
        return new String(ans);
    }
}
