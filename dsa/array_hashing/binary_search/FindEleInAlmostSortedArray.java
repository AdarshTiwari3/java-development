package dsa.array_hashing.binary_search;

// User function Template for Java
class Solution {
    public int findTarget(int arr[], int target) {
        // code here
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            // check nearly means i , i-1 and i + 1

            if (low < mid && arr[mid - 1] == target) {
                return mid - 1;
            }
            if (high > mid && arr[mid + 1] == target) {
                return mid + 1;
            }

            // move low and high by 2 steps because mid mid-1 and mid + 1 already checked
            if (target > arr[mid]) {
                low = mid + 2;
            } else {
                high = mid - 2;
            }
        }
        return -1;
    }
}


public class FindEleInAlmostSortedArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {0, 3, 40, 20, 50, 80, 70};
        int target = 20;
        int ans = sol.findTarget(arr, target); // TC => O(logn)
        System.out.println("ans=" + ans); // 3
    }
}
