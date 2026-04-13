package dsa.array_hashing.prefix_sum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int prefixSum = 0;

        boolean ans = false;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            int remainder = ((prefixSum % k) + k) % k;

            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return ans;
    }
}


public class ContiguousSubarraySum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {23, 2, 4, 6, 7};
        int k = 6;

        boolean res = sol.checkSubarraySum(arr, k);
        System.out.println("Ans=" + res); // true

    }
}
