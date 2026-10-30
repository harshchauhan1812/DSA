class Solution {
    static class State {
        int node;
        int cnt;
        int dist;

        State(int node, int cnt, int dist) {
            this.node = node;
            this.cnt = cnt;
            this.dist = dist;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] e : edges)
            graph[e[0]].add(new int[] { e[1], e[2] });
        int INF = Integer.MAX_VALUE / 4;
        int[][] dist = new int[n][k + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], INF);
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        dist[0][1] = 0;
        pq.offer(new State(0, 1, 0));
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.dist != dist[cur.node][cur.cnt])
                continue;
            if (cur.node == n - 1)
                return cur.dist;
            for (int[] edge : graph[cur.node]) {
                int v = edge[0];
                int w = edge[1];
                int nextCnt;
                if (labels.charAt(v) == labels.charAt(cur.node)) {
                    nextCnt = cur.cnt + 1;
                    if (nextCnt > k)
                        continue;
                } else
                    nextCnt = 1;
                int nd = cur.dist + w;
                if (nd < dist[v][nextCnt]) {
                    dist[v][nextCnt] = nd;
                    pq.offer(new State(v, nextCnt, nd));
                }
            }
        }
        return -1;
    }
}