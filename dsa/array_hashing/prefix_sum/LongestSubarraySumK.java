package dsa.array_hashing.prefix_sum;

import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int prefix = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);// if subarray starts from 0
        for (int i = 0; i < arr.length; i++) {

            prefix += arr[i];
            int checkKey = prefix - k;
            if (map.containsKey(checkKey)) {
                ans = Math.max(ans, i - map.get(checkKey));
            }
            if (!map.containsKey(prefix)) {
                map.put(prefix, i);

            }

        }

        return ans;
    }
}


public class LongestSubarraySumK {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = {10, 5, 2, 7, 1, -10};
        int k = 15;
        int res = sol.longestSubarray(arr, k);
        System.out.println("Ans=" + res);
    }

}
