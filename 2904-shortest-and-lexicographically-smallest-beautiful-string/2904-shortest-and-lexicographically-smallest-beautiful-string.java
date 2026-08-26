class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";

        for (int left = 0; left < s.length(); left++) {
            int ones = 0;

            for (int right = left; right < s.length(); right++) {

                if (s.charAt(right) == '1') {
                    ones++;
                }

                if (ones == k) {
                    String curr = s.substring(left, right + 1);

                    if (ans.equals("") ||
                        curr.length() < ans.length() ||
                        (curr.length() == ans.length() && curr.compareTo(ans) < 0)) {
                        
                        ans = curr;
                    }

                    break;
                }
            }
        }

        return ans;
    }
}