package dsa.array_hashing.prefix_sum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefix = 0;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            if (map.containsKey(prefix - goal)) {
                ans += map.get(prefix - goal);
            }

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return ans;
    }
}


public class BinaryNumSubarraySumGoal {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {1, 0, 1, 0, 1};
        int goal = 2;
        int res = sol.numSubarraysWithSum(arr, goal);
        System.out.println("ans=" + res); // ans=4
    }
}
