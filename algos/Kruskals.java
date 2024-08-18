import java.util.*;

class Edge implements Comparable<Edge> {   
    int src, dest, weight;
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Subset {
    int parent, rank;
}

public class Kruskals {

    int V, E;
    Edge edge[];

    Kruskals(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalMST() {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; i++) {
            result[i] = new Edge();
        }
        Arrays.sort(edge);
        Subset subsets[] = new Subset[V];
        for (i = 0; i < V; i++) {
            subsets[i] = new Subset();
        }
        for (i = 0; i < V; i++) {
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        i = 0;
        while (e < V - 1) {
            Edge next_edge = edge[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }
        System.out.println("Following are the edges in the constructed MST");
        int totalCost = 0;
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
            totalCost += result[i].weight;
        }
        System.out.println("Total min cost: " + totalCost);
    }

    public static void main(String[] args) {

        int[][] graph1 = new int[][]{{0, 2, 0, 6, 0},
                                     {2, 0, 3, 8, 5},
                                     {0, 3, 0, 0, 7},
                                     {6, 8, 0, 0, 9},
                                     {0, 5, 7, 9, 0}};

        int[][] graph2 = new int[][]{{0, 2, 0, 6, 0, 4},
                                     {2, 0, 3, 8, 5, 0},
                                     {0, 3, 0, 0, 7, 0},
                                     {6, 8, 0, 0, 9, 0},
                                     {0, 5, 7, 9, 0, 0},
                                     {4, 0, 0, 0, 0, 0}};

        int[][] graph3 = new int[][]{{0, 4, 0, 0, 0, 0, 0, 0, 0},
                                     {4, 0, 8, 0, 0, 0, 0, 0, 0},
                                     {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                     {0, 0, 7, 0, 9, 1, 0, 0, 0},
                                     {0, 0, 0, 9, 0, 0, 0, 0, 0},
                                     {0, 0, 4, 4, 1, 0, 2, 0, 0},
                                     {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                     {0, 0, 0, 0, 0, 0, 1, 0, 7},
                                     {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        System.out.println("Graph 1");
        Kruskals g1 = new Kruskals(graph1.length, getEdgeCount(graph1));
        createEdges(g1, graph1);
        g1.KruskalMST();

        System.out.println("Graph 2");
        Kruskals g2 = new Kruskals(graph2.length, getEdgeCount(graph2));
        createEdges(g2, graph2);
        g2.KruskalMST();

        System.out.println("Graph 3");
        Kruskals g3 = new Kruskals(graph3.length, getEdgeCount(graph3));
        createEdges(g3, graph3);
        g3.KruskalMST();
    }

    public static int getEdgeCount(int[][] graph) {
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph[i].length; j++) {
                if (graph[i][j] != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void createEdges(Kruskals g, int[][] graph) {
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph[i].length; j++) {
                if (graph[i][j] != 0) {
                    g.edge[count].src = i;
                    g.edge[count].dest = j;
                    g.edge[count].weight = graph[i][j];
                    count++;
                }
            }
        }
    }
}