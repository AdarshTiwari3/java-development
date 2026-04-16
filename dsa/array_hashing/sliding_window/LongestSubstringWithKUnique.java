package dsa.array_hashing.sliding_window;

import java.util.*;

class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        Map<Character, Integer> map = new HashMap<>();

        int n = s.length();
        int ans = -1;
        int left = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);


            map.put(ch, map.getOrDefault(ch, 0) + 1);
            // map size is more than k unique element

            while (map.size() > k) {
                // remove from left
                char charKey = s.charAt(left);
                int val = map.get(charKey);

                // if val of left char is 1 means we need to remove char key also
                // decrement first from left

                if (val - 1 == 0) {
                    map.remove(charKey);
                } else {
                    map.put(charKey, val - 1);
                }
                left++;

            }


            if (map.size() == k) {
                ans = Math.max(ans, i - left + 1);
            }

        }
        return ans;
    }

}


public class LongestSubstringWithKUnique {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aabacbebebe";
        int k = 3;
        int res = sol.longestKSubstr(s, k);
        System.out.println("ans=" + res);

    }
}
