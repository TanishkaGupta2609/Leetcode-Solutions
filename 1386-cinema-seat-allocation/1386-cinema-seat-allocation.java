
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowMasks = new HashMap<>();

        // Build a bitmask of reserved seats for affected rows
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            rowMasks.put(row, rowMasks.getOrDefault(row, 0) | (1 << col));
        }

        // Unreserved rows can accommodate 2 families each
        int maxFamilies = (n - rowMasks.size()) * 2;

        // Bitmasks for seat ranges 2-5, 4-7, and 6-9
        int leftMask = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);   // 0b0000111100
        int middleMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7); // 0b0011110000
        int rightMask = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);  // 0b1111000000

        for (int mask : rowMasks.values()) {
            boolean leftAvailable = (mask & leftMask) == 0;
            boolean rightAvailable = (mask & rightMask) == 0;

            if (leftAvailable && rightAvailable) {
                maxFamilies += 2;
            } else if (leftAvailable || rightAvailable || (mask & middleMask) == 0) {
                maxFamilies += 1;
            }
        }

        return maxFamilies;
    }
}