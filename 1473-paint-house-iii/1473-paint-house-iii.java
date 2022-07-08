class Solution {
    
    // Recursion -> TLE
    // DP Approach
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int price = minCost(houses, cost, m, n, target, 0, 0, 0, new Integer[m][n + 1][target + 1]);
        return (price == Integer.MAX_VALUE) ? -1 : price;
    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target, int i, int prev, int hoods, Integer[][][] dp) {
        if (hoods > target) 
            return Integer.MAX_VALUE;
        
        if (i == m) 
            return (hoods == target) ? 0 : Integer.MAX_VALUE;
        
        if (dp[i][prev][hoods] != null) // memoization
            return dp[i][prev][hoods];

        int minPrice = Integer.MAX_VALUE;

        if (houses[i] == 0) 
            for (int j = 0; j < n; j++) {
                int newHoods = (prev == j + 1) ? hoods : hoods + 1;
                int price = minCost(houses, cost, m, n, target, i + 1, j + 1, newHoods, dp);
                if (price != Integer.MAX_VALUE) 
                    minPrice = Math.min(minPrice, cost[i][j] + price);
            }
        
        else {
            int newHoods = (houses[i] == prev) ? hoods : hoods + 1;
            minPrice = Math.min(minPrice, minCost(houses, cost, m, n, target, i + 1, houses[i], newHoods, dp));
        }
        
        return dp[i][prev][hoods] = minPrice;
    }
}
