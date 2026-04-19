package dsa.array_hashing.sliding_window;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        // we will use set and when a new item is added we will check if that is present or not if
        // present already means we will have to remove it.
        // we can use map also and a map size must be 2 representing 2 baskets and if window size is
        // more than 2 means we need to remove from left untill we dont get size 2

        Map<Integer, Integer> map = new HashMap<>();

        int n = fruits.length;

        int left = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int key = fruits[i];
            map.put(key, map.getOrDefault(key, 0) + 1);

            while (map.size() > 2) {
                // because we can have only two baskets it will be a kind of window size

                int leftKey = fruits[left];
                int leftValue = map.get(leftKey);
                if (leftValue == 1) {
                    map.remove(leftKey);
                } else {
                    map.put(leftKey, leftValue - 1);
                }
                left++;
            }

            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}


public class FruitIntoBasket {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};

        int res = sol.totalFruit(arr);

        System.out.println("ans=" + res); // ans=5
    }

}
