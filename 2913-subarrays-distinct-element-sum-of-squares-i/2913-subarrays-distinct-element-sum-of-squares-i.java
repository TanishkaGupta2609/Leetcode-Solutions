import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int totalSum = 0;
        
        // Fix the starting point of the subarray
        for (int l = 0; l < n; l++) {
            Set<Integer> distinctElements = new HashSet<>();
            
            // Expand the ending point of the subarray
            for (int r = l; r < n; r++) {
                distinctElements.add(nums.get(r));
                
                int distinctCount = distinctElements.size();
                totalSum += distinctCount * distinctCount;
            }
        }
        
        return totalSum;
    }
}