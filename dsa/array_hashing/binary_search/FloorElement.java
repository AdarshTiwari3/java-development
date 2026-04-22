package dsa.array_hashing.binary_search;

class Solution {
    public int findFloor(int[] arr, int target) {
        // code here
        int n = arr.length;

        int low = 0, high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {

                high = mid - 1;
            } else if (arr[mid] <= target) {

                ans = mid;

                low = mid + 1;
            }
        }
        return ans;
    }
}


public class FloorElement {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {1, 2, 8, 10, 10, 11};
        int x = 11;
        int ans = sol.findFloor(arr, x);

        System.out.println("ans=" + ans);
    }
}
