import java.util.*;

class Solution {
    private static final long M1 = 1_000_000_007L;
    private static final long M2 = 1_000_000_009L;
    private static final long B1 = 911_382_323L;
    private static final long B2 = 972_663_749L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int lo = 1, hi = n, ans = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (hasUnique(nums, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean hasUnique(int[] nums, int len) {
        int n = nums.length;
        long h1 = 0, h2 = 0, p1 = 1, p2 = 1;

        for (int i = 0; i < len; i++) {
            long val = nums[i] + 1_000_000_007L;
            h1 = (h1 * B1 + val) % M1;
            h2 = (h2 * B2 + val) % M2;
            if (i > 0) {
                p1 = (p1 * B1) % M1;
                p2 = (p2 * B2) % M2;
            }
        }

        Map<Long, Integer> freq = new HashMap<>();
        freq.put(pack(h1, h2), 1);

        for (int i = len; i < n; i++) {
            long outVal = nums[i - len] + 1_000_000_007L;
            long inVal = nums[i] + 1_000_000_007L;

            h1 = (h1 - (outVal * p1) % M1 + M1) % M1;
            h1 = (h1 * B1 + inVal) % M1;

            h2 = (h2 - (outVal * p2) % M2 + M2) % M2;
            h2 = (h2 * B2 + inVal) % M2;

            long key = pack(h1, h2);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) return true;
        }
        return false;
    }

    private long pack(long a, long b) {
        return (a << 32) | (b & 0xffffffffL);
    }
}