// class Solution {
//     public int candy(int[] ratings) {
//         int n=ratings.length;
//         int sum=n;
//         int i=1;
//         while(i<n){
//             if(ratings[i]==ratings[i-1]){
//                 i++;
//                 continue;
//             }
//             int peak=1;
//             while(i<n && ratings[i]>ratings[i-1]){
//                 peak++;
//                 sum+=peak;
//                 i++;
//             }
//             int down=1;
//             while(i<n && ratings[i]<ratings[i-1]){
//                 down++;
//                 sum+=down;
//                 i++;
//             }
//            sum-=Math.min(peak,down);
//         }
//         return sum;
//     }
// }

class Solution {
    // Function to calculate the minimum number of candies 
    public int candy(int[] ratings) {

        // Get number of children
        int n = ratings.length;

        // Initially give 1 candy to each child
        int candies = n;

        // Start from second child
        int i = 1;

        while (i < n) {

            // Skip equal ratings
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            // Initialize increasing slope counter
            int peak = 0;

            // Traverse strictly increasing ratings
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                candies += peak;
                i++;
            }

            // Initialize decreasing slope counter
            int valley = 0;

            // Traverse strictly decreasing ratings
            while (i < n && ratings[i] < ratings[i - 1]) {
                valley++;
                candies += valley;
                i++;
            }

            // Remove overlapping candy at the peak
            candies -= Math.min(peak, valley);
        }

        // Return total candies required
        return candies;
    }
}
