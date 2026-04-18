package dsa.array_hashing.sliding_window;

import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int ans = 0;

        int left = 0, n = s.length();
        int maxFreq = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // idea is to get current window - maxFreq <= k , is valid ans
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            while ((i - left + 1) - maxFreq > k) {
                // remove element from left

                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);
                left++;

            }
            ans = Math.max(ans, i - left + 1);



        }
        return ans;
    }
}


public class LongestRepCharReplace {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "ABAB";
        int k = 2;
        int res = sol.characterReplacement(s, k);
        System.out.println("ans = " + res);
    }
}
