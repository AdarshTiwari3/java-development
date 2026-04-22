package dsa.array_hashing.binary_search;

class Solution {
    int upperBound(int[] arr, int target) {
        // code here
        int n = arr.length;

        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target < arr[mid]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}


public class UpperBound {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = {2, 3, 7, 10, 11, 11, 25};
        int target = 11;
        int upper = sol.upperBound(arr, target);

        System.out.println("upper=" + upper); // 6
    }
}
