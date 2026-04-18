package dsa.array_hashing.prefix_sum;

class Solution {
    public int pivotIndex(int[] nums) {

        // calculate the total sum

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int right = sum - left - nums[i];

            if (left == right)
                return i;
            left += nums[i];
        }
        return -1;

    }
}


public class PivotIndex {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int nums[] = {1, 7, 3, 6, 5, 6};

        int res = sol.pivotIndex(nums);
        System.out.println("ans=" + res);
    }
}
