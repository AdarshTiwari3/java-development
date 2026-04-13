package dsa.array_hashing.sliding_window;

import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        int k = p.length();
        int count = k;
        int left = 0; // need to get left window as we will be refilling the values
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    count--;
                }
                map.put(ch, map.get(ch) - 1);
            }

            // shrink the window and refill the values of map for p char
            if (i - left + 1 > k) {
                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count++;
                    }

                }
                left++;
            }

            if (i - left + 1 == k && count == 0) {
                ans.add(left);
            }
        }
        return ans;
    }
}


public class FinaAllAnagrams {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String txt = "forxxorfxdofr", pat = "for";
        List<Integer> res = sol.findAnagrams(pat, txt);

        res.forEach(num -> System.out.println("num=" + num));
    }
}
