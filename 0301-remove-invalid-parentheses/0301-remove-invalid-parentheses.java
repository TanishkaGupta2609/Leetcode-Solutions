import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftRem = 0, rightRem = 0;

        // Step 1: Calculate the minimum number of '(' and ')' to remove
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                if (leftRem > 0) {
                    leftRem--; // Found a matching '('
                } else {
                    rightRem++; // Unmatched ')'
                }
            }
        }

        Set<String> result = new HashSet<>();
        backtrack(s, 0, 0, 0, leftRem, rightRem, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private void backtrack(String s, int index, int openCount, int closeCount, 
                           int leftRem, int rightRem, StringBuilder current, Set<String> result) {
        // Base case: processed the entire string
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0 && openCount == closeCount) {
                result.add(current.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int len = current.length();

        // Option 1: Remove the character (if it's an invalid parenthesis)
        if (c == '(' && leftRem > 0) {
            backtrack(s, index + 1, openCount, closeCount, leftRem - 1, rightRem, current, result);
        } else if (c == ')' && rightRem > 0) {
            backtrack(s, index + 1, openCount, closeCount, leftRem, rightRem - 1, current, result);
        }

        // Option 2: Keep the character
        current.append(c);
        if (c != '(' && c != ')') {
            // Regular character
            backtrack(s, index + 1, openCount, closeCount, leftRem, rightRem, current, result);
        } else if (c == '(') {
            backtrack(s, index + 1, openCount + 1, closeCount, leftRem, rightRem, current, result);
        } else if (c == ')' && openCount > closeCount) {
            // Only keep ')' if there is a matching open '('
            backtrack(s, index + 1, openCount, closeCount + 1, leftRem, rightRem, current, result);
        }

        // Backtrack step
        current.setLength(len);
    }
}