package dsa.array_hashing.prefix_sum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            int remainder = ((prefixSum % k) + k) % k; // to avoid negative numbers remainder

            if (map.containsKey(remainder)) {
                ans += map.get(remainder);
            }

            // stores the remainder in map if two has same remainder means it is divisible
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return ans;
    }
}


public class SubarraySumDivisibleK {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {4, 5, 0, -2, -3, 1};
        int k = 5;

        int res = sol.subarraysDivByK(arr, k);

        System.out.println("Ans=" + res); // Ans=7
    }

}
