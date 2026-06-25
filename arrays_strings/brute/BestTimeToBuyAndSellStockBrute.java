package dsa.arrays_strings.brute;

public class BestTimeToBuyAndSellStockBrute {
//121
//Take index 0 as buy. Go to next element — if it's smaller than buy, update buy.
// If it's greater than buy, calculate profit and update maxProfit if better.
// Keep going till end, return maxProfit.

        public int maxProfit(int[] prices) {
            int maxProfit = 0;

            // Try every possible buy/sell pair
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    int profit = prices[j] - prices[i];
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }

            return maxProfit;
        }
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockBrute solution = new BestTimeToBuyAndSellStockBrute();

        // Test Case 1: Normal case
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test 1: " + solution.maxProfit(prices1)); // 5

        // Test Case 2: Decreasing prices
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test 2: " + solution.maxProfit(prices2)); // 0

        // Test Case 3: Increasing prices
        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.println("Test 3: " + solution.maxProfit(prices3)); // 4

        // Test Case 4: Single element
        int[] prices4 = {5};
        System.out.println("Test 4: " + solution.maxProfit(prices4)); // 0

        // Test Case 5: Empty array
        int[] prices5 = {};
        System.out.println("Test 5: " + solution.maxProfit(prices5)); // 0
    }


}
