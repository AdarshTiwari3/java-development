package dsa.array_hashing;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // use min heap here - based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll(); // remove the smallest freq
            }
        }
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i] = pq.poll().getKey(); // get the top k keys
            i++;
        }
        return ans;

    }


    public int[] topKFrequentBucketSort(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // use bucket sort

        List<Integer>[] bucket = new ArrayList[nums.length + 1]; // array of list, internally it
                                                                 // stores null

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    ans[index] = num;
                    index++;
                    if (index == k)
                        break;
                }
            }
        }


        return ans;


    }

}


public class TopKFreq {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int arr[] = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int res[] = sol.topKFrequent(arr, k); // TC=> O(n log k ) SC=>O(n)
        int resBucket[] = sol.topKFrequentBucketSort(arr, k);// TC=>O(n) SC=>O(n)

        for (int num : res) {
            System.out.println("num=" + num);
        }
        System.out.println("using bucket sort");

        for (int num : resBucket) {
            System.out.println("arr=" + num);
        }
    }

}
