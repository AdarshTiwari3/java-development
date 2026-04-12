package dsa.array_hashing.sliding_window;

class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int windowSum = 0;
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];

            if (i >= k - 1) {
                // we get the min required window size
                ans = Math.max(ans, windowSum);
                // shrink the left window part

                windowSum -= arr[i - k + 1];
            }
        }
        return ans;

    }

    public int maxSubarraySumClean(int[] arr, int k) {
        if (arr.length < k) { // not possible
            return 0;
        }

        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            // get first window of size k
            windowSum += arr[i];

        }
        int ans = windowSum; // atleast one we got

        // now traverse from kth index till end of the array and maintain the window sum by adding
        // next element and removing last from window

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];// add next but remove last from window from left
            ans = Math.max(ans, windowSum);
        }

        return ans;
    }
}


public class MaxSubArraySumK {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {100, 200, 300, 400};
        int res = sol.maxSubarraySum(arr, 2);

        System.out.println("ans=" + res); // 700
        res = sol.maxSubarraySumClean(arr, 2);
        System.out.println("ans=" + res); // 700


    }

}
