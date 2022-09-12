class Solution {

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int start = 0, end = tokens.length - 1, score = 0, max = 0;
        while (start <= end) {
            if (power >= tokens[start]) {
                power -= tokens[start];
                start++;
                score++;
            } else if (score >= 1) {
                power += tokens[end];
                end--;
                score--;
            } else break;
            max = Math.max(max, score);
        }
        return max;
    }
}
