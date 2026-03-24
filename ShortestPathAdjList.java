// Dijkstra using Adjacency List
import java.util.*;

class ShortestPathAdjList {

    static class Pair {
        int v, weight;

        Pair(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    static final int INF = Integer.MAX_VALUE;

    static int[] dijkstra(List<List<Pair>> graph, int src) {

        int V = graph.size();
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {

            int u = -1;
            int min = INF;

            // find minimum distance vertex
            for (int j = 0; j < V; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }

            visited[u] = true;

            // traverse adjacency list
            for (Pair p : graph.get(u)) {
                int v = p.v;
                int weight = p.weight;

                if (!visited[v] && dist[u] != INF &&
                        dist[u] + weight < dist[v]) {

                    dist[v] = dist[u] + weight;
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no.of vertices:");
        int n = sc.nextInt();

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        System.out.println("Enter number of edges:");
        int e = sc.nextInt();

        System.out.println("Enter u v weight:");

        for (int i = 0; i < e; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w)); // remove if directed
        }

        System.out.println("Enter source:");
        int src = sc.nextInt();

        int[] result = dijkstra(graph, src);

        System.out.println("Shortest distances:");

        for (int i = 0; i < result.length; i++) {
            if (result[i] == INF)
                System.out.print("INF ");
            else
                System.out.print(result[i] + " ");
        }
    }
}