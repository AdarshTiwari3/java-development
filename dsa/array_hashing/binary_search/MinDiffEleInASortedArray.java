package dsa.array_hashing.binary_search;

class Solution {
    int findMinDiff(int arr[], int target) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                // arr[mid] == target
                return arr[mid];
            }

        }
        // if target is not in arr then we have to find ceil and floor
        // after while(low<=high) as low and high have crossed each other so now we have ceil = low
        // and floor=high

        // if target smaller than all element means our high(floor) will be -1
        if (high < 0)
            return arr[low]; // ceil will be have min diff
        // if low goes beyond length or target is greater than all elements so it means last element
        // will have the min diff ans

        if (low >= n)
            return arr[high]; // means floor will be ans

        int floor = high;
        int ceil = low;
        int floorDiff = Math.abs(arr[floor] - target);
        int ceilDiff = Math.abs(arr[ceil] - target);



        return floorDiff < ceilDiff ? arr[floor] : arr[ceil];

    }
}


public class MinDiffEleInASortedArray {
    // find min diff element in a sorted array
    // we have to find min abs diff from target of each element
    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = {1, 3, 8, 10, 15};
        // two cases here if arr has target then we will return 0 because abs diff will be so return
        // that index
        // else find the closest to target which will be ceil and floor and get the min abs sum and
        // return the index
        int target = 12;
        int arr2[] = {1, 3, 8, 10, 12, 15};
        int ans = sol.findMinDiff(arr2, target);

        System.out.println("ans=" + ans);

    }
}
