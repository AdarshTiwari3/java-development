package dsa.array_hashing.sliding_window;

import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer> ans = new ArrayList<>();

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                // store in deque
                deque.addLast(i);
            }
        }

        // if deque has something just remove the element from front to get first negative here

        if (!deque.isEmpty()) {

            ans.add(arr[deque.peekFirst()]);
        } else {
            ans.add(0);
        }

        for (int i = k; i < arr.length; i++) {
            // remove if window size is out of reach to that element in deque
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                // remove this
                deque.removeFirst();
            }
            if (arr[i] < 0) {
                deque.addLast(i);
            }
            if (!deque.isEmpty()) {

                ans.add(arr[deque.peekFirst()]);
            } else {
                ans.add(0);
            }
        }
        return ans;
    }
}


public class FirstNegInWindowK {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = {-8, 2, 3, -6, 10};

        int k = 2;

        var res = sol.firstNegInt(arr, k);

        // System.out.println("res=" + res);
        res.forEach(num -> System.out.println("num=" + num));
        /*
         * Output: num=-8 num=0 num=-6 num=-6
         */
    }
}
