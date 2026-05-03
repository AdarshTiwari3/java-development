package dsa.array_hashing.binary_search;

class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }
            // check if left part is sorted
            if (nums[low] <= nums[mid]) {
                // left sorted portion
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;// move right to mid as we are shrinking search space
                } else {
                    low = mid + 1;
                }

            } else {
                // right sorted portion
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;// move left to mid + 1
                } else {
                    high = mid - 1;
                }

            }
        }
        return false;
    }
}


public class SearchInRotatedArrayTwo {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {1, 0, 1, 1, 1};
        int target = 0;
        boolean ans = sol.search(arr, target);
        System.out.println("ans=" + ans); // true
    }
}
