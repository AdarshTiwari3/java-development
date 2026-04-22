package dsa.array_hashing.binary_search;

class Solution {
    public int findFirstOcc(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                res = mid;
                // stil continue in left of mid to get left side occurance if any that would be our
                // first occurance
                high = mid - 1;
            }

        }
        return res;
    }

    public int findLastOcc(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                res = mid;
                // stil continue in right of mid to get last side occurance if any that would be our
                // last occurance
                low = mid + 1;
            }

        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {

        int first = findFirstOcc(nums, target);
        int last = findLastOcc(nums, target);

        return new int[] {first, last};

    }
}


public class FindFirstAndLastOccurance {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {5, 7, 7, 7, 7, 8, 11};

        int target = 7;

        int res[] = sol.searchRange(arr, target);

        for (int num : res) {
            System.out.println("num=" + num);
        }

    }
}
