class test {
    static boolean [] visited;
    
    public static void main (String [] args) {
        int n = 6;
        int graph1 [][] = new int [][] {
            {0,1,0,0,0,1},
            {1,0,1,1,0,0},
            {0,1,0,0,0,0},
            {0,1,0,0,1,1},
            {0,0,0,1,0,0},
            {1,0,0,1,0,0}
        };

        System.out.println("DFS transversal of graph1 from vertex 0");
        visited = new boolean[n];
        dfs(0, graph1);
        System.out.println();

    }
    
    public static void dfs(int v, int [][] graph) {
        
        visited [v] = true;
        System.out.print(v + " ");

        for(int i = 0; i < graph[v].length; i++) {
            if(graph[v][i] == 1 && !visited[i]) {
                dfs(i, graph);
            }
        }
    }
}