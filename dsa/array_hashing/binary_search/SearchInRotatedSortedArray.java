package dsa.array_hashing.binary_search;

class Solution {
    public int search(int[] nums, int target) {
        // here the tricky part is if nums[low] <= nums[mid]
        // means first part is sorted if not means rotation would have been done on right side so
        // right will be sorted

        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                // left part is sorted and try to find target if lies in this portion
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right part is sorted and find the target in this portion if lies in it
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}


public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {4, 5, 6, 8, 0, 1, 2, 5, 6};
        int target = 2;
        int ans = sol.search(arr, target);
        System.out.println("ans=" + ans); // 6
    }

}
