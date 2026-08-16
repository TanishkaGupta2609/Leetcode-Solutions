class Solution {

    public boolean stoneGameIX(int[] stones) {

        int[] cnt = new int[3];

        // Count stones according to remainder
        // 0 -> divisible by 3
        // 1 -> remainder 1
        // 2 -> remainder 2
        for (int stone : stones) {
            cnt[stone % 3]++;
        }

        // Try Alice starting with remainder 1
        // and remainder 2
        int[] swapped = {cnt[0], cnt[2], cnt[1]};

        return check(cnt) || check(swapped);
    }

    private boolean check(int[] cnt) {

        // Alice starts by taking a remainder-1 stone
        if (--cnt[1] < 0) {
            return false;
        }

        // After Alice's first move:
        // 1,2,1,2,1,2...
        int moves = 1 + Math.min(cnt[1], cnt[2]) * 2;

        // If there is an extra remainder-1 stone,
        // it can be taken once more.
        if (cnt[1] > cnt[2]) {
            cnt[1]--;
            moves++;
        }

        // Remainder-0 stones can be taken without
        // changing the modulo of the sum.
        moves += cnt[0];

        // Alice wins if the final useful move is odd
        // and the two non-zero groups aren't equal.
        return moves % 2 == 1 && cnt[1] != cnt[2];
    }
}