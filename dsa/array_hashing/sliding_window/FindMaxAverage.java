package dsa.array_hashing.sliding_window;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int ans = windowSum; // atleast one sum we got

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k]; // add next to the window and remove from left
            ans = Math.max(ans, windowSum);
        }


        return (double) ans / k;
    }
}


public class FindMaxAverage {
    public static void main(String[] args) {
        int arr[] = {1, 12, -5, -6, 50, 3};
        int k = 4;
        Solution sol = new Solution();
        double res = sol.findMaxAverage(arr, k);
        System.out.println("Ans=" + res); // Ans=12.75


    }
}
