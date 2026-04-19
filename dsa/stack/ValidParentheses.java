package dsa.stack;

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            if (!stack.isEmpty() && ((ch == ')' && stack.peek() == '(')
                    || (ch == '}' && stack.peek() == '{') || (ch == ']' && stack.peek() == '['))) {

                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}


public class ValidParentheses {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "()[]{}";
        boolean res = sol.isValid(s);

        System.out.println("ans=" + res); // true
    }
}
