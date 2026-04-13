package dsa.array_hashing.prefix_sum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int prefixSum = 0;
        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);// to count the length if starts from Oth index

        for (int i = 0; i < nums.length; i++) {
            // treat 0 as -1 and 1 as +1 when we get prefix sum ==0 or get repeated prefix sum back
            // then we get a subarray of max length

            if (nums[i] == 1) {
                prefixSum += 1;
            } else {
                prefixSum -= 1;
            }

            if (map.containsKey(prefixSum)) {
                int possibleLength = i - map.get(prefixSum);
                ans = Math.max(ans, possibleLength);
            } else {
                // store the first occurance as we want to maximize the length
                map.put(prefixSum, i);
            }

        }
        return ans;
    }
}


public class ContiguousArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        int res = sol.findMaxLength(arr);
        System.out.println("ans=" + res); // ans=6
    }
}
