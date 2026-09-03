class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = nums1[0];

        for (int num : nums1) {
            min = Math.min(min, num);
        }

        // If minimum is odd, every even number can be made odd
        if (min % 2 != 0) {
            return true;
        }

        // Minimum is even, so every element must already be even
        for (int num : nums1) {
            if (num % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}