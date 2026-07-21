class Solution {
    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) return 0;

        int n = needle.length();
        int[] lps = new int[n];

        // Build LPS Array
        int len = 0;
        int i = 1;

        while (i < n) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // KMP Search
        i = 0; // haystack pointer
        int j = 0; // needle pointer

        while (i < haystack.length()) {

            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == n) {
                return i - j;
            }

            else if (i < haystack.length() &&
                     haystack.charAt(i) != needle.charAt(j)) {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }
}