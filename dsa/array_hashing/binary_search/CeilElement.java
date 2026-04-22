package dsa.array_hashing.binary_search;

// User function Template for Java
class Solution {
    public int findCeil(int[] arr, int target) {
        // code here
        int n = arr.length;

        int low = 0, high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {

                low = mid + 1;
            }
        }
        return ans;
    }
}


public class CeilElement {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {1, 2, 8, 10, 10, 11};
        int x = 9;
        int ans = sol.findCeil(arr, x);

        System.out.println("ans=" + ans); // 3rd index
    }
}
