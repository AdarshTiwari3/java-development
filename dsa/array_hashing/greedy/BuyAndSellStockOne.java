package dsa.array_hashing.greedy;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int profit = 0;

        for (int i = 1; i < n; i++) {
            buy = Math.min(buy, prices[i]);
            // will sell at max profit

            profit = Math.max(prices[i] - buy, profit);
        }

        return profit;

    }
}


public class BuyAndSellStockOne {
    public static void main(String[] args) {

        Solution sol = new Solution();

        int arr[] = {7, 1, 5, 3, 6, 4};
        int res = sol.maxProfit(arr);

        System.out.println("Ans=" + res); // Ans=5

    }
}
