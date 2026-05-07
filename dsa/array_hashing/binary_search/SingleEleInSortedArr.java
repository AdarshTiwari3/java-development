package dsa.array_hashing.binary_search;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        // it just checks the odd even pairs

        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mid % 2 == 0) {

                if (nums[mid] == nums[mid + 1]) {
                    low = mid + 2;
                } else {
                    high = mid; // move left
                }
            }

            else if (mid % 2 == 1) {

                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1;

                } else {
                    high = mid; // move right
                }

            }

        }
        return nums[low];
    }
}


public class SingleEleInSortedArr {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {1, 1, 2, 3, 3, 4, 4, 5, 5};
        int ans = sol.singleNonDuplicate(arr); // TC=> O(log n) SC=>O(1)
        System.out.println("ans=" + ans); // 2
    }

}
