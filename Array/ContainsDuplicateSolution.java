//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
import java.util.*;
// Hashset Solution 
// TC: O(n)
// SC: O(n)
public class ContainsDuplicateSolution {
    public boolean ContainsDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (uniqueNums.contains(nums[i])) {
                return true;
            }
            uniqueNums.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateSolution rs = new ContainsDuplicateSolution();
        int[] testNums = new int[] {1, 2, 4, 3, 6, 3};
        boolean res = rs.ContainsDuplicate(testNums);
        System.out.printf("Contains duplicate or not: " + res);
    }
}

// Sort Solution - sort first and then compare neighbours
// TC: O(nlogn)
// SC: O(1)


