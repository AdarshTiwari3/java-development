package dsa.array_hashing.sliding_window;

import java.util.HashMap;
import java.util.Map;

// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < pat.length(); i++) {
            char ch = pat.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int ans = 0;
        int k = pat.length();
        int count = k;
        int left = 0; // need to get left window as we will be refilling the values
        for (int i = 0; i < txt.length(); i++) {
            char ch = txt.charAt(i);

            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    count--;
                }
                map.put(ch, map.get(ch) - 1);
            }

            // shrink the window and refill the values of map for pat char
            if (i - left + 1 > k) {
                char leftChar = txt.charAt(left);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count++; // it will only be incremented when we lose a required char
                    }

                }
                left++;
            }

            if (count == 0) {
                ans += 1;
            }
        }
        return ans;


    }
}


public class CountOccurAnagram {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String txt = "forxxorfxdofr", pat = "for";
        System.out.println("ans=" + sol.search(pat, txt)); // ans=3

        String txt1 = "aabaabaa", pat1 = "aaba";
        System.out.println("ans=" + sol.search(pat1, txt1)); // 4
    }

}
