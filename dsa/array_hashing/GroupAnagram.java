package dsa.array_hashing;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);

            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                // create an array for value of key
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public int[] getFreq(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        return freq;

    }

    public List<List<String>> groupAnagramsFreq(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int freq[] = getFreq(s);
            String key = Arrays.toString(freq);


            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }

        }
        List<List<String>> ans = new ArrayList<>(map.values());
        return ans;
    }
}


public class GroupAnagram {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = sol.groupAnagrams(strs);
        List<List<String>> resTwo = sol.groupAnagramsFreq(strs);

        System.out.println("Sorting approach:");
        for (List<String> group : res) {
            System.out.println(group);
        }

        System.out.println("Frequency approach:");
        for (List<String> group : resTwo) {
            System.out.println(group);
        }

        /*
         * 
         * Sorting approach: [eat, tea, ate] [bat] [tan, nat] Frequency approach: [eat, tea, ate]
         * [bat] [tan, nat]
         */
    }

}
