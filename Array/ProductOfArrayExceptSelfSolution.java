// 238. Product of Array Except Self
// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

public class ProductOfArrayExceptSelfSolution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefixProduct = 1;
        int suffixProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            res[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        for (int i = nums.length-1; i >= 0; i--) {
            res[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelfSolution sol = new ProductOfArrayExceptSelfSolution();
        int[] nums = new int[] { 1, 2, 3, 4 };
        int[] res = sol.productExceptSelf(nums);
        for (int i : res) {
            System.out.println("productExceptSelf is: " + i);
        }
    }
}
