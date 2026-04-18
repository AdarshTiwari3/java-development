package dsa.array_hashing;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                int j = i;
                int k = map.get(target - nums[i]);
                return new int[] {j, k};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}


public class TwoSumUnsorted {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int ans[] = sol.twoSum(nums, target);

        for (int num : ans) {
            System.out.println("num=" + num);
        }
    }
}
