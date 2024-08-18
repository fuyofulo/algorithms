public class DFS {
    static boolean [] visited;
    public static void main(String args []) {
        int n = 6;
        int [][] graph1;
        int [][] graph2;
        int [][] graph3;

        graph1 = new int[][] {
            {0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0},
            {1, 0, 0, 1, 0, 0}
        };

        graph2 = new int[][] {
            {0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0}
        };

        graph3 = new int[][] {
            {0, 1, 0, 0, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0}
        };

        System.out.println("DFS transversal of Graph 1 from vertex 0");
        visited = new boolean[n];
        dfs(0, graph1);
        System.out.println();

        System.out.println("\nDFS transversal of Graph 2 from vertex 2");
        visited = new boolean[n];
        dfs(2, graph2);
        System.out.println();

        System.out.println("\nDFS transversal of Graph 3 from vertex 3");
        visited = new boolean[n];
        dfs(3, graph3);
        System.out.println();
    }

    public static void dfs(int v, int [][] graph) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < graph[v].length; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfs(i, graph);
            }
        }
    }

}