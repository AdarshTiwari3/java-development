package dsa.array_hashing.sliding_window;

import java.util.*;

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int ans = 0;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();



        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() == 3) {
                // valid window
                ans += n - i;

                char charLeft = s.charAt(left);
                int val = map.get(charLeft);

                if (val == 1) {
                    map.remove(charLeft);
                } else {
                    map.put(charLeft, val - 1);
                }
                left++;

            }

        }
        return ans;

    }
}


public class NoOfSubstrContainingAllThree {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "abcabc";
        int res = sol.numberOfSubstrings(s);

        System.out.println("ans=" + res); // ans = 10
    }
}
