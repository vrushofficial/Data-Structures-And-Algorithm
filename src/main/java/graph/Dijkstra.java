package graph;

class Dijkstra {
    static final int V = 9;

    public static void main(String[] args) {
        int graph[][] = new int[][] {
                { 0, 0, 1, 2, 0, 0, 0 },
                { 0, 0, 2, 0, 0, 3, 0 },
                { 1, 2, 0, 1, 3, 0, 0 },
                { 2, 0, 1, 0, 0, 0, 1 },
                { 0, 0, 3, 0, 0, 2, 0 },
                { 0, 3, 0, 0, 2, 0, 1 },
                { 0, 0, 0, 1, 0, 1, 0 } };
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph, 0);
    }

    int getMin(int[] dist, Boolean[] visited) {

        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < V; i++)
            if (visited[i] == false && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }

        return min_index;
    }

    int[] dijkstra(int[][] graph, int src) {
        int[] dist = new int[V];
        Boolean[] visited = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        for (int count = 1; count < V - 1; count++) {

            int each = getMin(dist, visited);

            visited[each] = true;

            for (int i = 0; i < V; i++)

                if (!visited[i] && graph[each][i] != 0 && dist[each] != Integer.MAX_VALUE && dist[each] + graph[each][i] < dist[i])
                    dist[i] = dist[each] + graph[each][i];
        }

        return dist;
    }
}