package dsa.array_hashing.prefix_sum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumK {
    public int subarraySum(int[] nums, int k) {
        int prefix = 0;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int key = prefix - k;

            if (map.containsKey(key)) {
                ans += map.get(key);
            }

            if (map.containsKey(prefix)) {
                map.put(prefix, map.get(prefix) + 1);
            } else {
                map.put(prefix, 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarraySumK sol = new SubarraySumK();
        int nums[] = {1, 2, 3, -2, 2};
        int k = 3;
        int res = sol.subarraySum(nums, k);
        System.out.println("ans=" + res);
    }
}
