package dsa.array_hashing.binary_search;

class Solution {
    public int findElement(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;

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

    public int findElementInDecreArr(int[] arr, int target) {

        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < target) {
                // move high to mid -1
                high = mid - 1;
            } else if (arr[mid] > target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}


public class BinarySearch {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = {1, 2, 4, 5, 7, 8, 11, 12, 14};
        int target = 11;

        int res = sol.findElement(arr, target);
        System.out.println("ans found at index:" + (res + 1));

        int arr2[] = {10, 9, 8, 5, 3, 2, 1};
        int target2 = 2;
        System.out.println("Array is in decreasing order");

        int res2 = sol.findElementInDecreArr(arr2, target2);
        System.out.println("ans2 found at index:" + (res2 + 1));

        // TC => O(log n )

    }

}
