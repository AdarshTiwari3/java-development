package dsa.array_hashing.sliding_window;

import java.util.*;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int odd = 0;
        int n = nums.length;
        int left = 0, ans = 0;
        // lets use sliding window first

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                // means odd
                odd++;

            }

            while (odd > k) {
                // shrink the left

                if (nums[left] % 2 != 0) {
                    odd--; // overflow of odd numbers
                }
                left++;
            }

            if (odd == k) {
                int tempLeft = left;
                // there is possibility that same k is possible in small size of subarray of this
                // subarray

                // count how many evens we can skip
                int evenCount = 0; // reset per window size
                while (tempLeft < n && nums[tempLeft] % 2 == 0) {
                    tempLeft++;
                    evenCount++;
                }


                ans += evenCount + 1;



            }


        }
        return ans;
    }
}


public class CountNoOfNiceSubarray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {1, 1, 2, 1};
        int k = 2;
        int res = sol.numberOfSubarrays(arr, k);
        System.out.println("ans=" + res); // ans=3
    }
}
