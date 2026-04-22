package dsa.array_hashing.binary_search;

class Solution {
    int lowerBound(int[] nums, int target) {
        // code here
        int n = nums.length;
        int low = 0, high = n - 1;

        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target <= nums[mid]) {
                ans = mid;
                high = mid - 1;
            } else if (target > nums[mid]) {

                low = mid + 1;
            }



        }
        return ans;
    }
}


public class LowerBound {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = {2, 3, 7, 10, 11, 11, 25};
        int target = 9;

        int res = sol.lowerBound(arr, target);
        System.out.println("lower_bound=" + res);
    }
}
