package dsa.array_hashing.sliding_window;

// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        // here if we want to use sliding window, the window size will be sum which is k
        int ans = 0;
        int left = 0;
        int windowSum = 0; // this will be window
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            windowSum += arr[i];

            // window getting exceeded
            if (windowSum > k) {
                windowSum -= arr[left];
                left++;
            }

            if (windowSum == k) {
                // found a valid ans
                ans = Math.max(ans, i - left + 1);
            }
        }
        return ans;
    }
}


public class LongestSubarraySumkPositive {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // this solution will only work if there is a positive number
        // because sliding window is reliable for positive numbers as window size shrinks from left
        // and adds from right so in case of negative it is not reliable

        int arr[] = {1, 2, 1, 1, 1}, k = 3;

        int res = sol.longestSubarray(arr, k);

        System.out.println("Ans=" + res); // Ans= 3

    }
}
