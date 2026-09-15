class Solution {
    public int maxPalindromes(String s, int k) {
        int count = 0;
        int lastEnd = -1; // End index of the last selected palindrome
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // Check for odd-length palindrome centered at i (length k)
            // and even-length palindrome centered around (i, i+1) (length k+1 or k)
            for (int len = k; len <= k + 1; len++) {
                int left = i - (len - 1) / 2;
                int right = i + len / 2;

                if (left > lastEnd && isPalindrome(s, left, right)) {
                    count++;
                    lastEnd = right; // Update end marker greedily
                    break;
                }
            }
        }
        return count;
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (left < 0 || right >= s.length()) return false;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}