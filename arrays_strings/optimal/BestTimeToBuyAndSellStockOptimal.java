package dsa.arrays_strings.optimal;

public class BestTimeToBuyAndSellStockOptimal {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];  // Update to better buying price
            } else {
                int profit = prices[i] - buy;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockOptimal solution = new BestTimeToBuyAndSellStockOptimal();

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

/*Takeaways for Best Time to Buy and Sell Stock
1. Core Concept

Buy low, sell high

Must buy BEFORE selling (only one transaction)

2. Key Insight

Track minimum price seen so far

Max profit = current price - minimum price seen before

3. Pattern

Single pass with state tracking (minPrice)

Update profit at each step

4. Time & Space

Time: O(n) - one pass

Space: O(1) - constant variables

5. Edge Cases

Empty array → 0

Single element → 0

Always decreasing → 0*/