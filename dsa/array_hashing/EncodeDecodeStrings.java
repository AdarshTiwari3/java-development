package dsa.array_hashing;

import java.util.*;

class Solution {

    public String encode(List<String> strs) {


        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length());
            sb.append("$");
            sb.append(str);
        }

        String s = sb.toString();

        System.out.println("S=" + s);
        return s;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < str.length();) {
            // will move i manually to have better control over indexes

            int j = i;
            while (str.charAt(j) != '$') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));

            String word = str.substring(j + 1, j + 1 + len);
            ans.add(word);

            i = j + 1 + len;
        }
        return ans;
    }
}


public class EncodeDecodeStrings {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> input = new ArrayList<>();
        input.add("Hello");
        input.add("World");

        String encodedString = sol.encode(input);
        List<String> res = sol.decode(encodedString);

        for (String string : res) {
            System.out.println("str=" + string);
        }

    }
}
