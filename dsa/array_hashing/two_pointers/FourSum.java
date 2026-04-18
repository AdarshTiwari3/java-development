package dsa.array_hashing.two_pointers;

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                // here we will use two pointers for k and l elements
                int k = j + 1, l = n - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        List<Integer> list =
                                new ArrayList(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        ans.add(list);
                        k++;
                        l--;
                        // avoid the duplicates

                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    } else if (sum < target) {
                        // increment k
                        k++;
                    } else {
                        l--;
                    }

                }
            }
        }
        return ans;

    }
}


public class FourSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {1, 0, -1, 0, 2, -2};
        int target = 0;

        List<List<Integer>> res = sol.fourSum(arr, target);

        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }


}
