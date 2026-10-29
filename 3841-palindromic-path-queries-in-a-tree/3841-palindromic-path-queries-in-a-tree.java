import java.util.*;

class Solution {
    private int[] head, to, next, edgeHead, edgeTo, edgeNext, edgeIndex;
    private int edgeCount, treeEdgeCount;
    private char[] chars;
    private int[] parent, depth, heavy, headNode, pos;
    private int curPos;
    private int[] tree;
    private int n;

    private void addEdge(int u, int v) {
        to[edgeCount] = v;
        next[edgeCount] = head[u];
        head[u] = edgeCount++;
    }

    private int dfs(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        int size = 1, maxSubtree = 0;
        heavy[u] = -1;
        for (int i = head[u]; i != -1; i = next[i]) {
            int v = to[i];
            if (v != p) {
                int subSize = dfs(v, u, d + 1);
                size += subSize;
                if (subSize > maxSubtree) {
                    maxSubtree = subSize;
                    heavy[u] = v;
                }
            }
        }
        return size;
    }

    private void decompose(int u, int h) {
        headNode[u] = h;
        pos[u] = ++curPos;
        if (heavy[u] != -1) {
            decompose(heavy[u], h);
        }
        for (int i = head[u]; i != -1; i = next[i]) {
            int v = to[i];
            if (v != parent[u] && v != heavy[u]) {
                decompose(v, v);
            }
        }
    }

    private void updateTree(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            updateTree(2 * node, start, mid, idx, val);
        } else {
            updateTree(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = tree[2 * node] ^ tree[2 * node + 1];
    }

    private int queryTree(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        return queryTree(2 * node, start, mid, l, r) ^ queryTree(2 * node + 1, mid + 1, end, l, r);
    }

    private int queryPath(int u, int v) {
        int res = 0;
        while (headNode[u] != headNode[v]) {
            if (depth[headNode[u]] < depth[headNode[v]]) {
                int temp = u; u = v; v = temp;
            }
            res ^= queryTree(1, 1, n, pos[headNode[u]], pos[u]);
            u = parent[headNode[u]];
        }
        if (depth[u] > depth[v]) {
            int temp = u; u = v; v = temp;
        }
        res ^= queryTree(1, 1, n, pos[u], pos[v]);
        return res;
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        this.chars = s.toCharArray();
        
        // Initialize graph arrays (each undirected edge has 2 directed entries)
        head = new int[n];
        Arrays.fill(head, -1);
        to = new int[2 * edges.length];
        next = new int[2 * edges.length];
        edgeCount = 0;

        for (int[] e : edges) {
            addEdge(e[0], e[1]);
            addEdge(e[1], e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        headNode = new int[n];
        pos = new int[n];
        curPos = 0;

        dfs(0, -1, 0);
        decompose(0, 0);

        tree = new int[4 * n + 1];
        for (int i = 0; i < n; i++) {
            int mask = 1 << (chars[i] - 'a');
            updateTree(1, 1, n, pos[i], mask);
        }

        List<Boolean> answer = new ArrayList<>();
        for (String qStr : queries) {
            String[] parts = qStr.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                chars[u] = c;
                updateTree(1, 1, n, pos[u], 1 << (c - 'a'));
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int pathMask = queryPath(u, v);
                answer.add((pathMask & (pathMask - 1)) == 0);
            }
        }
        return answer;
    }
}