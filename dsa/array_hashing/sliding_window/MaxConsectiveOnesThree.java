package dsa.array_hashing.sliding_window;

class Solution {
    public int longestOnes(int[] nums, int k) {
        // count the zero and one and check the valid window if zero > k remove from window of count
        // one
        int ans = 0, n = nums.length;

        int left = 0, zeros = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                zeros++;
            }
            // more than window needs shrink here
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;


            }
            // if(map.containsKey(1)){
            ans = Math.max(ans, i - left + 1);
            // }

        }
        return ans;
    }
}


public class MaxConsectiveOnesThree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        int res = sol.longestOnes(arr, k);
        System.out.println("ans=" + res); // ans = 6 ,{0, 0, 1, 1, 1, 1}

    }
}
