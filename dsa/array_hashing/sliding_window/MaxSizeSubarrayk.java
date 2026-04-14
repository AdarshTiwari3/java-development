package dsa.array_hashing.sliding_window;

import java.util.*;

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();

        Deque<Integer> dq = new ArrayDeque<>();

        int n = arr.length;


        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[i] > arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        ans.add(arr[dq.peekFirst()]); // first maximum from 1st window

        for (int i = k; i < n; i++) {
            // if window size exceeds

            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && arr[i] > arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);

            ans.add(arr[dq.peekFirst()]);

        }
        return ans;
    }

}


public class MaxSizeSubarrayk {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;

        ArrayList<Integer> ans = sol.maxOfSubarrays(arr, k);

        ans.forEach(num -> System.out.println("num:" + num));

        /*
         * Output: [3, 3, 4, 5, 5, 5, 6]
         * 
         */
    }
}
