package dsa.array_hashing.two_pointers;

class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        int i = 0, j = n - 1;

        while (i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);

            if (!Character.isLetterOrDigit(left)) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(right)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }

            i++;
            j--;
        }
        return true;

    }
}


public class ValidPalindrome {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "A man, a plan, a canal: Panama";
        boolean res = sol.isPalindrome(s);
        System.out.println("isPalin=" + res); // true
    }

}
