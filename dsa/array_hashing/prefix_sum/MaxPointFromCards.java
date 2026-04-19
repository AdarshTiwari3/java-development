package dsa.array_hashing.prefix_sum;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // idea is to calculate left prefix sum and right prefix sum because we have to choose
        // either from left or right side in continous order, then try iterating from k to 0 for
        // left sum and calculate the right sum and get the max
        int leftSum = 0, rightSum = 0;

        int n = cardPoints.length;



        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        int ans = leftSum;
        // rightSum=cardPoints[n-1];

        for (int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[n - k + i];
            int profit = leftSum + rightSum;

            ans = Math.max(ans, profit);

        }

        return ans;
    }

}


public class MaxPointFromCards {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = {1, 2, 3, 4, 5, 6, 1};

        int k = 3;

        int res = sol.maxScore(arr, k);

        System.out.println("ans=" + res); // ans = 12 (1+5+6)
        // TC=> O(k) SC=>O(1)
    }
}
