import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        Arrays.fill(minLen, Integer.MAX_VALUE);
        
        int left = 0;
        int currentSum = 0;
        int minResult = Integer.MAX_VALUE;
        int bestSoFar = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            currentSum += arr[right];
            
            // Shrink window if sum exceeds target
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            
            // Found a sub-array matching the target sum
            if (currentSum == target) {
                int currentLen = right - left + 1;
                
                // Check if a non-overlapping sub-array exists to the left
                if (left > 0 && minLen[left - 1] != Integer.MAX_VALUE) {
                    minResult = Math.min(minResult, currentLen + minLen[left - 1]);
                }
                
                bestSoFar = Math.min(bestSoFar, currentLen);
            }
            
            // Store the best sub-array length up to index right
            minLen[right] = bestSoFar;
        }
        
        return minResult == Integer.MAX_VALUE ? -1 : minResult;
    }
}