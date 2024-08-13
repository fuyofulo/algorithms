public class GraphColoring {
    final static int V = 4;  // Number of vertices
    static int color[];

    static boolean isSafe(int vertex, int graph[][], int color[], int c) {
        for (int i = 0; i < V; i++) {
            if (graph[vertex][i] == 1 && c == color[i]) {
                return false;
            }
        }
        return true;
    }

    static boolean graphColoringUtil(int graph[][], int m, int color[], int vertex) {
        if (vertex == V) {  // Base case: If all vertices are assigned a color then return true
            return true;
        }

        for (int c = 1; c <= m; c++) {  // Consider this vertex and try different colors
            if (isSafe(vertex, graph, color, c)) {
                color[vertex] = c;

                if (graphColoringUtil(graph, m, color, vertex + 1)) {
                    return true;
                }

                color[vertex] = 0; // Backtrack
            }
        }

        return false; // If no color can be assigned to this vertex
    }

    static boolean graphColoring(int graph[][], int m) {
        color = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = 0;
        }

        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(color);
        return true;
    }

    static void printSolution(int color[]) {
        System.out.println("Solution Exists: Following are the assigned colors");
        for (int i = 0; i < V; i++) {
            System.out.print(" " + color[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int graph1[][] = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };

        int m1 = 3;
        System.out.println("Coloring of graph 1");
        graphColoring(graph1, m1);

        int graph2[][] = {
            {0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };

        int m2 = 3;
        System.out.println("Coloring of graph 2");
        graphColoring(graph2, m2);
    }
}
