package dsa.array_hashing.binary_search;

class Solution {
    int findLeftCnt(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int cnt = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                cnt = mid;
                high = mid - 1; // still check the left

            }
        }
        return cnt;
    }

    int findRightCnt(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int cnt = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                cnt = mid;
                low = mid + 1; // still check the right

            }
        }
        return cnt;
    }

    int countFreq(int[] arr, int target) {
        // code here
        // find the number and still get the index of left side and right side index equal to that
        // number
        int leftIndex = findLeftCnt(arr, target);
        int rightIndex = findRightCnt(arr, target);
        if (leftIndex != -1 && rightIndex != -1) {
            return rightIndex - leftIndex + 1;
        }
        return 0;



    }
}


public class NumberOfOccur {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 3, 8, 11, 11, 11};
        int target = 11;
        int ans = sol.countFreq(arr, target);
        System.out.println("ans=" + ans); // 3
    }

}
