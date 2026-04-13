package dsa.array_hashing.prefix_sum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int[] prefixSum;

    public Solution(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        } else {
            return prefixSum[right] - prefixSum[left - 1]; // why left-1 because we want to remove
                                                           // the left sum to left to get correct
                                                           // range
        }

    }
}


/**
 * Your NumArray object will be instantiated and called as such: NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

public class RangeSum {

    public static void main(String[] args) {
        int arr[] = {-2, 0, 3, -5, 2, -1};
        Solution sol = new Solution(arr);
        List<Integer> ans = new ArrayList<>();

        int res1 = sol.sumRange(0, 2);
        int res2 = sol.sumRange(2, 5);
        int res3 = sol.sumRange(0, 5);

        ans.add(res1);
        ans.add(res2);
        ans.add(res3);

        System.out.println("ans[]=" + ans);


    }

}
