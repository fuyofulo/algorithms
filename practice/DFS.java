class DFS {
    static boolean [] visited;

    public static void main(String [] args) {
        int n = 6;

        int [][] g1 = new int[][] {
            {0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0},
            {1, 0, 0, 1, 0, 0}
        };

        int [][] g2 = new int[][] {
            {0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0}
        };

        int [][] g3 = new int[][] {
            {0, 1, 0, 0, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0}
        };

        visited = new boolean[n];
        System.out.println("DFS of graph 1: ");
        dfs(g1, 0);

        visited = new boolean[n];
        System.out.println("DFS of graph 2: ");
        dfs(g2, 0);

        visited = new boolean[n];
        System.out.println("DFS of graph 3: ");
        dfs(g3, 0);
    }

    public static void dfs ( int [][] graph, int v) {
        visited[v] = true;
        System.out.println(v+" ");
        for(int i =0; i<graph.length; i++){
            if(graph[v][i] == 1 && !visited[i]) {
                dfs(graph, i);
            }
        }
    }
}