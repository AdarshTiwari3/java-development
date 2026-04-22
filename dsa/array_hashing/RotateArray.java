package dsa.array_hashing;

class Solution {
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            // swap both arrays
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;


        }
    }

    public void rotate(int[] nums, int k) {
        // reverse whole array then reverse first k and then reverse remaining
        int n = nums.length;

        k = k % n;

        reverse(nums, 0, n - 1);

        reverse(nums, 0, k - 1);

        reverse(nums, k, n - 1);



    }
}


public class RotateArray {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        sol.rotate(arr, k);

        for (int num : arr) {
            System.out.println("num:" + num);
        }
    }
}
