class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Two rectangles overlap if they overlap on both X-axis and Y-axis projections.
        // Check if there is an overlap along the X-axis: min(rec1[2], rec2[2]) > max(rec1[0], rec2[0])
        // Check if there is an overlap along the Y-axis: min(rec1[3], rec2[3]) > max(rec1[1], rec2[1])
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])) &&
               (Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    
    }
}