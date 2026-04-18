package dsa.array_hashing;

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;

        for (int num : set) {
            if (!(set.contains(num - 1))) {
                int len = 1; // length found, this becomes index
                while (set.contains(num + len)) {
                    len++;
                }
                ans = Math.max(ans, len);


            }
        }
        return ans;
    }
}


public class LongestConsectives {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = {100, 4, 200, 1, 1, 3, 2};

        int res = sol.longestConsecutive(arr);

        System.out.println("ans=" + res); // 4

    }
}
