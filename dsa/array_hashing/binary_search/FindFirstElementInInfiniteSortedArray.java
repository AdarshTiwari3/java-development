package dsa.array_hashing.binary_search;


class Solution {
    int findInInfiniteSortedArray(int arr[], int key) {
        // as we can't create the infinite array so we are supposing arr is infinite here
        int low = 0, high = 1;

        // we have to put high < arr.length because high went to out of the size but in question we
        // have inf array so need not to worry this is just for java problem
        while (high < arr.length && key > arr[high]) { // assuming we have infinite array otherwise
                                                       // high can go beyond
            // length of arr
            low = high;
            high = high * 2;
            // expands and try to put key in our low and high portion.

        }
        if (high >= arr.length) {
            high = arr.length - 1;
        }
        return binarySearch(arr, low, high, key);

    }

    private int binarySearch(int arr[], int low, int high, int target) {
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                res = mid;
                // still go left to get first index if it has
                high = mid - 1;
            }
        }
        return res;
    }
}



public class FindFirstElementInInfiniteSortedArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // we have binary array of infinite size and we have to find the first occurance index of 1
        int arr[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int target = 1;
        int ans = sol.findInInfiniteSortedArray(arr, target);
        System.out.println("ans found at index=" + ans);
    }
}
