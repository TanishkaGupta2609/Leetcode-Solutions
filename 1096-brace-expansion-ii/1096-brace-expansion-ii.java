import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> resultSet = evaluate(expression);
        List<String> sortedList = new ArrayList<>(resultSet);
        Collections.sort(sortedList);
        return sortedList;
    }

    private Set<String> evaluate(String expr) {
        Set<String> unionSet = new HashSet<>();
        List<Set<String>> concatGroup = new ArrayList<>();

        int i = 0;
        int n = expr.length();

        while (i < n) {
            char c = expr.charAt(i);

            if (c == '{') {
                // Find matching closing brace
                int j = i, braceCount = 0;
                while (j < n) {
                    if (expr.charAt(j) == '{') braceCount++;
                    if (expr.charAt(j) == '}') braceCount--;
                    if (braceCount == 0) break;
                    j++;
                }
                // Recursively evaluate inner expression
                Set<String> innerResult = evaluate(expr.substring(i + 1, j));
                concatGroup.add(innerResult);
                i = j + 1;
            } else if (Character.isLowerCase(c)) {
                // Read continuous letters
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isLowerCase(expr.charAt(i))) {
                    sb.append(expr.charAt(i));
                    i++;
                }
                Set<String> letterSet = new HashSet<>();
                letterSet.add(sb.toString());
                concatGroup.add(letterSet);
            } else if (c == ',') {
                // Product of current concatenation group added to union
                unionSet.addAll(cartesianProduct(concatGroup));
                concatGroup.clear();
                i++;
            }
        }

        // Add remaining group after processing expression
        if (!concatGroup.isEmpty()) {
            unionSet.addAll(cartesianProduct(concatGroup));
        }

        return unionSet;
    }

    private Set<String> cartesianProduct(List<Set<String>> groups) {
        Set<String> result = new HashSet<>();
        result.add("");

        for (Set<String> group : groups) {
            Set<String> temp = new HashSet<>();
            for (String prefix : result) {
                for (String suffix : group) {
                    temp.add(prefix + suffix);
                }
            }
            result = temp;
        }

        return result;
    }
}