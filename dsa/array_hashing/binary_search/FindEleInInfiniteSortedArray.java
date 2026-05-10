package dsa.array_hashing.binary_search;

class Solution {
    int findInInfiniteSortedArray(int arr[], int key) {
        // as we can't create the infinite array so we are supposing arr is infinite here
        int low = 0, high = 1;

        while (key > arr[high]) { // assuming we have infinite array otherwise high can go beyond
                                  // length of arr
            low = high;
            high = high * 2;
            // expands and try to put key in our low and high portion.

        }
        return binarySearch(arr, low, high, key);

    }

    private int binarySearch(int arr[], int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}


public class FindEleInInfiniteSortedArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int key = 7;
        int ans = sol.findInInfiniteSortedArray(arr, key);
        System.out.println("ans found at index=" + ans);

    }
}
