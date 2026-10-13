import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        // Square each element and take absolute value (though squares are already non-negative)
        long[] squares = new long[n];
        for (int i = 0; i < n; i++) {
            long val = nums[i];
            squares[i] = val * val;
        }
        
        // Sort the squared values in ascending order
        Arrays.sort(squares);
        
        long totalScore = 0;
        
        // Subtract the smaller half, add the larger half
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                totalScore -= squares[i];
            } else {
                totalScore += squares[i];
            }
        }
        
        return totalScore;
    }
}