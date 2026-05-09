package dsa.array_hashing.binary_search;

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;


        while (low < high) {
            int mid = low + (high - low) / 2;



            // check only mid and observer the slope of increasing and decreasing order

            if (nums[mid] < nums[mid + 1]) {
                // increasing order slope so peak will be on right of mid
                low = mid + 1;
            } else {
                high = mid;
            }

        }
        return low;
    }
}


public class FindPeakElement {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {1, 2, 3, 4, 5};
        int arr2[] = {5, 4, 2, 1};
        int arr3[] = {1, 2, 6, 5, 4, 3, 0};
        int arr4[] = {1, 2, 1, 4, 3, 0};
        int ans1 = sol.findPeakElement(arr);
        int ans2 = sol.findPeakElement(arr2);
        int ans3 = sol.findPeakElement(arr3);
        int ans4 = sol.findPeakElement(arr4);
        // ans will be indexes
        System.out.println(
                "\nans1=" + ans1 + " \nans2=" + ans2 + " \nans3=" + ans3 + " \nans4=" + ans4);
    }

}
