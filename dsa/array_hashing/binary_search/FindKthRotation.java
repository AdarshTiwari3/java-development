package dsa.array_hashing.binary_search;

class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        // find the point where left and right portion both are sorted
        // find the minimum element using binary search
        // index of min is ans
        int n = arr.length;
        int low = 0, high = n - 1;
        // here we are just shrinking the search space
        while (low < high) {
            int mid = low + (high - low) / 2;


            if (arr[mid] > arr[high]) {
                // go in right half
                low = mid + 1;
            } else if (arr[mid] <= arr[high]) {
                high = mid;
            }
        }
        return low;
    }
}


public class FindKthRotation {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {6, 9, 2, 4};
        int ans = sol.findKRotation(arr);
        System.out.println("ans=" + ans); // 2
    }
}
