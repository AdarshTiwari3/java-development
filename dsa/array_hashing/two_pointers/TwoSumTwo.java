package dsa.array_hashing.two_pointers;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int i = 0, j = n - 1;

        while (i < j) {
            int curr = nums[i] + nums[j];
            if (curr < target) {
                i++;
            } else if (curr > target) {
                j--;
            } else {
                return new int[] {i + 1, j + 1};
            }
        }
        return new int[] {};
    }
}


public class TwoSumTwo {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {2, 7, 11, 15};
        int target = 9;
        int ans[] = sol.twoSum(arr, target);

        for (int num : ans) {
            System.out.println("num=" + num);
        }

    }
}
