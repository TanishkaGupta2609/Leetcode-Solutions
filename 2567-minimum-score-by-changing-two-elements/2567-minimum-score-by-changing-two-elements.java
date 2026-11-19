import java.util.Arrays;

class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if (n <= 3) {
            return 0;
        }

        Arrays.sort(nums);

        // 1. Change the two largest elements (effective range: nums[0] to nums[n - 3])
        int changeTwoLargest = nums[n - 3] - nums[0];

        // 2. Change the two smallest elements (effective range: nums[2] to nums[n - 1])
        int changeTwoSmallest = nums[n - 1] - nums[2];

        // 3. Change one smallest and one largest (effective range: nums[1] to nums[n - 2])
        int changeOneEach = nums[n - 2] - nums[1];

        return Math.min(changeTwoLargest, Math.min(changeTwoSmallest, changeOneEach));
    }
}