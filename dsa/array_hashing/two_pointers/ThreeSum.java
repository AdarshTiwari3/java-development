package dsa.array_hashing.two_pointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.sort(null);
                        set.add(temp);
                    }
                }
            }
        }
        ans.addAll(set);
        return ans;

    }

    public List<List<Integer>> threeSumBetter(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            Set<Integer> tempSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {

                int thirdEle = -(nums[i] + nums[j]);
                // because a+b+c=0 means c = -(a+b)
                if (tempSet.contains(thirdEle)) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], thirdEle);
                    Collections.sort(list);
                    set.add(list);
                }
                tempSet.add(nums[j]); // next iteration check


            }
        }
        ans.addAll(set);
        return ans;

    }

    public List<List<Integer>> threeSumOptimal(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // now array is sort so we can use two pointers here to get a + b + c =0

            int j = i + 1, k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(list);
                    j++;
                    k--;
                    // to avoid duplicate triplets again
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                } else if (sum < 0) {
                    // incease the j
                    j++;
                } else if (sum > 0) {
                    // decrease k
                    k--;
                }
            }


        }


        return ans;

    }
}


public class ThreeSum {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> res = sol.threeSumBruteForce(arr); // TC=>O(n^3) SC=>O(n)

        for (List<Integer> list : res) {
            System.out.println(list);
        }
        System.out.println("using two hashset:");
        // due to Arrays.sort() the actual input will be sorted but it is ok
        res = sol.threeSumBetter(arr); // using two hashset // TC=>O(n^2) SC=>O(n)
        for (List<Integer> list : res) {
            System.out.println(list);
        }

        System.out.println("using two pointers:");
        res = sol.threeSumOptimal(arr); // using two pointers // TC=>O(n^2) SC=>O(1) if we dont
                                        // consider ans array as it was expected from ans
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }


}
