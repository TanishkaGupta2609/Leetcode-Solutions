class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        // Count characters in s
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[n];

        // Try to construct answer equal to target from left to right
        for (int i = 0; i < n; i++) {

            int x = target.charAt(i) - 'a';

            if (freq[x] > 0) {
                // Keep same character
                ans[i] = target.charAt(i);
                freq[x]--;
            } else {
                // Cannot continue equal.
                // Find smallest character greater than target[i].
                for (int j = x + 1; j < 26; j++) {

                    if (freq[j] > 0) {
                        ans[i] = (char) ('a' + j);
                        freq[j]--;

                        // Fill remaining positions with smallest characters
                        int pos = i + 1;

                        for (int k = 0; k < 26; k++) {
                            while (freq[k] > 0) {
                                ans[pos++] = (char) ('a' + k);
                                freq[k]--;
                            }
                        }

                        return new String(ans);
                    }
                }

                // No greater character here.
                break;
            }
        }

        // We need to backtrack.
        // Try changing the rightmost possible position.
        for (int i = n - 1; i >= 0; i--) {

            // Recreate frequency array
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Match target[0 ... i-1]
            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';

                if (count[x] == 0) {
                    possible = false;
                    break;
                }

                count[x]--;
            }

            if (!possible) {
                continue;
            }

            // At position i, choose smallest character > target[i]
            int x = target.charAt(i) - 'a';

            for (int j = x + 1; j < 26; j++) {

                if (count[j] > 0) {

                    char[] result = new char[n];

                    // Prefix same as target
                    for (int k = 0; k < i; k++) {
                        result[k] = target.charAt(k);
                    }

                    // Make current character greater
                    result[i] = (char) ('a' + j);
                    count[j]--;

                    // Remaining characters in sorted order
                    int pos = i + 1;

                    for (int k = 0; k < 26; k++) {
                        while (count[k] > 0) {
                            result[pos++] = (char) ('a' + k);
                            count[k]--;
                        }
                    }

                    return new String(result);
                }
            }
        }

        return "";
    }
}