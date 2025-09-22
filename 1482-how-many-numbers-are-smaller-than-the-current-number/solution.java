class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];              // values 0..100
        for (int x : nums) freq[x]++;

        // prefix sums: freq[i] = count of numbers <= i
        for (int i = 1; i < 101; i++) freq[i] += freq[i - 1];

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            ans[i] = (x == 0) ? 0 : freq[x - 1];
        }
        return ans;
    }
}
