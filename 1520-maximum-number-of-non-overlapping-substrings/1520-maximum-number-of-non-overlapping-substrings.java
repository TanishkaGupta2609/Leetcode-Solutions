
import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);

        // Find first and last occurrence of every character
        for (int i = 0; i < s.length(); i++) {

            int ch = s.charAt(i) - 'a';

            if (first[ch] == -1) {
                first[ch] = i;
            }

            last[ch] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Try to create a valid substring for every character
        for (int c = 0; c < 26; c++) {

            if (first[c] == -1) {
                continue;
            }

            int l = first[c];
            int r = last[c];

            boolean valid = true;

            for (int i = l; i <= r; i++) {

                int ch = s.charAt(i) - 'a';

                // This character occurred before l
                if (first[ch] < l) {
                    valid = false;
                    break;
                }

                // Need to include all occurrences of this character
                r = Math.max(r, last[ch]);
            }

            if (valid) {
                intervals.add(new int[]{l, r});
            }
        }

        // Sort according to ending position
        Collections.sort(intervals, (a, b) -> a[1] - b[1]);

        List<String> ans = new ArrayList<>();

        int prevEnd = -1;

        // Greedy: choose interval ending earliest
        for (int[] interval : intervals) {

            int l = interval[0];
            int r = interval[1];

            if (l > prevEnd) {

                ans.add(s.substring(l, r + 1));

                prevEnd = r;
            }
        }

        return ans;
    }
}
