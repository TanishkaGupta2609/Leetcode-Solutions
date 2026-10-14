class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9L * num) return "";
        
        int q = sum / 9;
        int r = sum % 9;
        
        StringBuilder ans = new StringBuilder(num);
        
        // Append q nines
        for (int i = 0; i < q; i++) {
            ans.append('9');
        }
        
        // Append the remainder digit if it exists
        if (r > 0) {
            ans.append((char) ('0' + r));
        }
        
        // Fill the rest with zeros
        while (ans.length() < num) {
            ans.append('0');
        }
        
        return ans.toString();
    }
}