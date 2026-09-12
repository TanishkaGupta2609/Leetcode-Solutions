import java.util.*;

class Solution {
    // Move State to class scope so helper methods can access it
    static class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        
        // Store interval indices
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        
        // Sort indices by right endpoint
        Arrays.sort(order, (a, b) -> Integer.compare(intervals.get(a).get(1), intervals.get(b).get(1)));
        
        // Extract sorted right endpoints array for binary search
        int[] rights = new int[n];
        for (int i = 0; i < n; i++) {
            rights[i] = intervals.get(order[i]).get(1);
        }

        // prev[p] stores the state picking (k-1) intervals considering the first p sorted intervals
        State[] prev = new State[n + 1];
        for (int i = 0; i <= n; i++) {
            prev[i] = new State(0, new ArrayList<>());
        }

        // At most 4 intervals
        for (int k = 1; k <= 4; k++) {
            State[] cur = new State[n + 1];
            cur[0] = new State(0, new ArrayList<>());

            for (int p = 1; p <= n; p++) {
                int i = order[p - 1];
                int l = intervals.get(i).get(0);
                int w = intervals.get(i).get(2);

                // Find largest prefix ending strictly before current interval's start
                int j = binarySearch(rights, l);

                // Option 1: Take current interval i
                State prevState = prev[j];
                long takeScore = prevState.score + w;
                List<Integer> takeIndices = new ArrayList<>(prevState.indices);
                takeIndices.add(i);
                Collections.sort(takeIndices);
                State takeState = new State(takeScore, takeIndices);

                // Option 2: Skip current interval i
                State skipState = cur[p - 1];

                // Compare options: maximize score, tie-break by lexicographically smaller index list
                cur[p] = compareStates(takeState, skipState);
            }
            prev = cur;
        }

        // Convert result list to array
        List<Integer> resList = prev[n].indices;
        int[] result = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            result[i] = resList.get(i);
        }
        return result;
    }

    // Binary search to find count of intervals ending strictly before target left boundary
    private int binarySearch(int[] rights, int target) {
        int low = 0, high = rights.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (rights[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Custom comparator to maximize score and pick lexicographically smallest indices on tie
    private State compareStates(State a, State b) {
        if (a.score > b.score) return a;
        if (b.score > a.score) return b;

        // Tie-break with lexicographical comparison
        int minSize = Math.min(a.indices.size(), b.indices.size());
        for (int i = 0; i < minSize; i++) {
            int cmp = Integer.compare(a.indices.get(i), b.indices.get(i));
            if (cmp != 0) return cmp < 0 ? a : b;
        }
        return a.indices.size() <= b.indices.size() ? a : b;
    }
}