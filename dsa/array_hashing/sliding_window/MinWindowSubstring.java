package dsa.array_hashing.sliding_window;

import java.util.*;

// v.v.v.imp question


class Solution {
    public String minWindow(String s, String t) {


        int n = s.length(), m = t.length();

        Map<Character, Integer> map = new HashMap<>(); // to store the freq of t string

        for (int i = 0; i < m; i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;


        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    count--;

                }
                map.put(ch, map.get(ch) - 1);
            }

            while (count == 0) { // because may be we have some duplicate or extra character which
                                 // is not required as we are looking for min window size
                // need to shrink the current window

                // update answer
                int windowLen = i - left + 1;

                if (windowLen < minLen) {
                    minLen = windowLen;
                    start = left; // it will be used to build ans string (substring)

                }

                char leftChar = s.charAt(left);

                // if present else move left

                if (map.containsKey(leftChar)) {

                    map.put(leftChar, map.get(leftChar) + 1); // rebuild up
                    if (map.get(leftChar) > 0) {
                        count++;
                    }

                }
                left++;



            }


        }
        if (minLen == Integer.MAX_VALUE) {
            return "";// did not get any solution
        }
        return s.substring(start, start + minLen);


    }
}


public class MinWindowSubstring {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "DAAADOBEC";
        String t = "ABC";

        String res = sol.minWindow(s, t);

        System.out.println("ans=" + res);

    }
}
