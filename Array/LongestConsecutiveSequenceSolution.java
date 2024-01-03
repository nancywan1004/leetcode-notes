// 128. Longest Consecutive Sequence
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
// You must write an algorithm that runs in O(n) time.

// Input: nums = [100,4,200,1,3,2]
// Outpus: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

// Hashset solution
// TC: O(N) - One for loop to add array items to a hashset, the other for loop to identify consequtive sequence
// SC: O(N) - Hashset
import java.util.HashSet;

public class LongestConsecutiveSequenceSolution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> numsSet = new HashSet<Integer>();
        for (int i : nums) {
            numsSet.add(i);
        }

        for (Integer currInt : numsSet) {
            // Continue when currInt is not the starting num for the current sequence - currInt-1 also exists in the numsSet
            if (numsSet.contains(currInt - 1)) {
                continue;
            }

            int startInt = currInt;
            int currLen = 1;
            while (numsSet.contains(startInt + 1)) {
                currLen += 1;
                startInt += 1;
            }

            res = Math.max(currLen, res);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequenceSolution sol = new LongestConsecutiveSequenceSolution();
        int[] nums = new int[] { 100, 4, 200, 1, 3, 2 };
        int res = sol.longestConsecutive(nums);
        System.out.println("longest consequtive sequence has length of: " + res);
    }
}
