class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        int[] freq = new int[51];

        for (int num : nums) {
            freq[num]++;
        }

        // k == 1: only elements appearing once are valid
        if (k == 1) {
            int ans = -1;

            for (int num : nums) {
                if (freq[num] == 1) {
                    ans = Math.max(ans, num);
                }
            }

            return ans;
        }

        // k == n: the whole array is the only subarray
        if (k == n) {
            int ans = 0;

            for (int num : nums) {
                ans = Math.max(ans, num);
            }

            return ans;
        }

        // 1 < k < n:
        // Only first and last elements can occur in exactly one subarray
        int ans = -1;

        if (freq[nums[0]] == 1) {
            ans = Math.max(ans, nums[0]);
        }

        if (freq[nums[n - 1]] == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}