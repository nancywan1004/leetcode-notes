// Hashset Solution 
// TC: O(n)
// SC: O(n)
public class Solution {
    public bool ContainsDuplicate(int[] nums) {
        HashSet<int> uniqueNums = new HashSet<int>();
        for (int i = 0; i < nums.Length; i++) {
            if (uniqueNums.Contains(nums[i])) {
                return true;
            }
            uniqueNums.Add(nums[i]);
        }
        return false;
    }
}

// Sort Solution - sort first and then compare neighbours
// TC: O(nlogn)
// SC: O(1)