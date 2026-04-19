package dsa.array_hashing.prefix_sum;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // if subarray starts from index 0
        int prefix = 0;
        int ans = 0;

        for (int num : nums) {
            prefix += (num % 2);

            if (map.containsKey(prefix - k)) {
                ans += map.get(prefix - k);
            }

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return ans;
    }
}


public class CountNoOfNiceSubarray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int arr[] = {1, 1, 2, 1};
        int k = 2;
        int res = sol.numberOfSubarrays(arr, k);
        System.out.println("ans=" + res);
    }
}
