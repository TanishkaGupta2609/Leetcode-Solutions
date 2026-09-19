class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Find the closest x-coordinate on/in the rectangle to xCenter
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        
        // Find the closest y-coordinate on/in the rectangle to yCenter
        int closestY = Math.max(y1, Math.min(yCenter, y2));
        
        // Calculate squared distance between closest point and circle center
        int dx = closestX - xCenter;
        int dy = closestY - yCenter;
        
        return dx * dx + dy * dy <= radius * radius;
    }
}