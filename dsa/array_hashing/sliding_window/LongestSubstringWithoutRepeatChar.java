package dsa.array_hashing.sliding_window;

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int ans = 0;
        int n = s.length();
        int left = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            while (map.containsKey(ch)) {
                char charLeft = s.charAt(left);
                map.remove(charLeft);
                left++;
            }

            map.put(ch, 1);

            ans = Math.max(ans, i - left + 1);

        }

        return ans;
    }

    public int lengthOfLongestSubstringSolTwo(String s) {
        Set<Character> set = new HashSet<>();

        int ans = 0;
        int n = s.length();
        int left = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // we will remove the element untill duplicate is not gone because that window will be
            // invailid

            while (set.contains(ch)) {
                char leftChar = s.charAt(left);
                set.remove(leftChar);
                left++;
            }

            set.add(ch);

            ans = Math.max(ans, i - left + 1); // current window size

        }

        return ans;
    }


    public int lengthOfLongestSubstringSolThree(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int ans = 0;
        int n = s.length();
        int left = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // jump left
            if (map.containsKey(ch)) {
                // move left to last seen of that element index + 1
                left = Math.max(left, map.get(ch) + 1); // we are checking here with max because
                                                        // left can be in between and what if we get
                                                        // any element which is backward to current
                                                        // left so this breaks the window size
            }

            // Update last seen index
            map.put(ch, i);

            ans = Math.max(ans, i - left + 1);

        }

        return ans;

    }
}


public class LongestSubstringWithoutRepeatChar {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "abcabcbb";

        int res = sol.lengthOfLongestSubstring(s);

        System.out.println("Ans=" + res);

        int setAns = sol.lengthOfLongestSubstringSolTwo(s);

        System.out.println("SetAns=" + setAns);

        int jumpSol = sol.lengthOfLongestSubstringSolTwo(s);

        System.out.println("SetAns=" + jumpSol);

    }

}
