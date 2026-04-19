package dsa.array_hashing.two_pointers;

class Solution {
    public int maxAreaBruteForce(int[] height) {
        // Brute Force Solution
        int ans = 0, n = height.length;

        for (int left = 0; left < n; left++) {
            for (int right = left + 1; right < n; right++) {
                int area = (right - left) * (Math.min(height[left], height[right])); // we can store
                                                                                     // the water
                                                                                     // till size
                                                                                     // min of left
                                                                                     // or right ,
                                                                                     // more will
                                                                                     // spill out

                ans = Math.max(ans, area);
            }
        }
        return ans;
    }
}


public class ContainerWithMostWater {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int res = sol.maxAreaBruteForce(arr);

        System.out.println("ans:" + res); // 49
    }

}
