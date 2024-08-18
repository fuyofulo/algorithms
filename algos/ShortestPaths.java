import java.util.Arrays;
public class ShortestPaths {
    static final double INF = 99999;
    static int minDistance (double [] dist, boolean [] s, int n) {
        double min = INF;
        int minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (!s[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void ShortestPaths (double [][]cost, int v, int n) {
        double [] dist = new double[n];
        boolean [] s = new boolean[n];
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
            s[i] = false;
        }
        dist[v] = 0;
        for (int i = 0; i < n; i++) {
            if (i != v) {
                dist [i] = cost[v][i];
            }
        }
        s[v] = true;
        for (int count = 1; count < n-1; count++) {
            int u = minDistance(dist, s, n);
            s[u] = true;
            for (int w = 0; w < n; w++) {
                if (!s[w] && dist[u] + cost[u][w] < dist[w]) {
                    dist[w] = dist[u] + cost[u][w];
                }
            }
        }
        printSolution(dist, n);
    }

    static void printSolution(double [] dist, int n) {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + dist[i]);
        }
    }

    public static void main (String [] args) {
        int n = 5;
        int v = 0;

        double [][] cost1 = {{0, 2, 0, INF, INF},
                             {2, 0, 3, 8, INF},
                             {INF, 3, 0, 0, 7},
                             {INF, INF, INF, 0, 9},
                             {INF, INF, INF, 9, 0}};

        System.out.println("Input 1:");
        ShortestPaths(cost1, v, n);

        double [][] cost2 = {{0, 2, INF, 6, INF, 4},
                             {2, 0, 3, 8, 5, INF},
                             {INF, 3, 0, INF, 7, INF},
                             {6, 8, INF, 0, 9, INF},
                             {INF, 5, 7, 9, 0, INF}};

        System.out.println("Input 2:");
        ShortestPaths(cost2, v, n);

        double [][] cost3 = {{0, 2, INF, 1, INF},
                             {2, 0, 3, 2, INF},
                             {INF, 3, 0, INF, 1},
                             {1, 2, INF, 0, 4},
                             {INF, INF, 1, 4, 0}};

        System.out.println("Input 3:");
        ShortestPaths(cost3, v, n);
    }
}