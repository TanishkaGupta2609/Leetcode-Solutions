import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Build adjacency list: u -> list of [v, w]
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        // Min-heap storing: {weight, node, consecutive_count}
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        
        // dist[u][count] stores the minimum weight to reach node u with a given consecutive count
        long[][] dist = new long[n][k + 1];
        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        // Start at node 0
        int startCount = 1;
        pq.offer(new long[]{0, 0, startCount});
        dist[0][startCount] = 0;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long w = curr[0];
            int u = (int) curr[1];
            int count = (int) curr[2];

            // If we reached target node n - 1, return the weight
            if (u == n - 1) {
                return (int) w;
            }

            if (w > dist[u][count]) {
                continue;
            }

            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];

                int nextCount;
                if (labels.charAt(u) == labels.charAt(v)) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }

                if (nextCount <= k && w + weight < dist[v][nextCount]) {
                    dist[v][nextCount] = w + weight;
                    pq.offer(new long[]{w + weight, v, nextCount});
                }
            }
        }

        // Find the minimum weight among all valid counts at node n - 1
        long minWeight = Long.MAX_VALUE;
        for (int count = 1; count <= k; count++) {
            minWeight = Math.min(minWeight, dist[n - 1][count]);
        }

        return minWeight == Long.MAX_VALUE ? -1 : (int) minWeight;
    }
}