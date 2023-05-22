// 347. Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

import java.util.*;

public class TopKFrequentElementsSolution {
    // Priority Queue + Hashmap solution
    // TC: O(nlog(k)) - log(k) is the time when inserting to a priority queue
    // SC: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elemToFreqMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            elemToFreqMap.put(nums[i], elemToFreqMap.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> {
            return entry1.getValue().compareTo(entry2.getValue());
        });
        for (Map.Entry<Integer, Integer> entry: elemToFreqMap.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        for (int i = k-1; i >= 0; i--) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }

    // Bucket with Hashmap solution
    // TC: O(n)
    // SC: O(n)
    public int[] topKFrequentBucket(int[] nums, int k) {
        Map<Integer, Integer> elemToFreqMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            elemToFreqMap.put(nums[i], elemToFreqMap.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList<Integer>[] freqToValMap = new ArrayList[nums.length+1]; // using +1 here because the index(frequency) can be the length of the array(nums.length), thus the array should be at least of size nums.length+1 
        for (int elem: elemToFreqMap.keySet()) {
            int freq = elemToFreqMap.get(elem);
            if (freqToValMap[freq] == null) {
                freqToValMap[freq] = new ArrayList<Integer>();
            }
            freqToValMap[freq].add(elem);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length - 1; i >=0; i--) {
            if (freqToValMap[i] != null) {
                for (int elem: freqToValMap[i]) {
                    res[index] = elem;
                    index++;
                    if (index == k) {
                        return res;
                    }
                }
            }
        }

        return null;

    }

    public static void main(String[] args) {
        TopKFrequentElementsSolution rs = new TopKFrequentElementsSolution();
        int[] topFrequentInts = rs.topKFrequentBucket(new int[]{1,1,1,2,2,3}, 2);
        for (int i: topFrequentInts) {
            System.out.println("top k Frequent elements is this:" + i);
        }
    }
}

