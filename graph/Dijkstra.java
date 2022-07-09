package graph;

public class Dijkstra {
    int[][] graph;
    int totalNodes;

    public Dijkstra (int[][] graph) {
        this.graph = graph;
        this.totalNodes = graph.length;
    }

    private int minDistance(int[] dist, Boolean[] splSet) {
        return 0;
    }

    private void findShortestPath(int source) {
        int[] dist = new int[totalNodes];
        Boolean[] splSet = new Boolean[totalNodes];
        for (int i=0;i<totalNodes;i++) {
            dist[i] = Integer.MAX_VALUE;
            splSet[i] = false;
        }
        dist[source] = 0;
        for (int count = 0;count<totalNodes - 1;count++) {
            int u = minDistance (dist, splSet);
            splSet[u] = true;

        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Dijkstra dijkstra = new Dijkstra(graph);
        dijkstra.findShortestPath(0);
    }
}
