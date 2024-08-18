public class BFS {
    static int [] visited;
    static int [] queue;
    static int front;
    static int rear;

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

        int graph2 [][] = new int[][] {
            {0,0,1,1,0,0},
            {1,0,1,0,1,0},
            {1,1,0,0,1,1},
            {1,0,0,0,0,1},
            {0,1,1,1,0,0},
            {0,0,1,1,0,0}
        };

        int graph3 [][] = new int [][] {
            {0,1,0,0,1,0},
            {1,0,1,0,1,0},
            {0,1,0,1,0,1},
            {0,0,1,0,1,0},
            {1,1,0,1,0,0},
            {0,0,1,0,0,0}
        };

        System.out.println("BFS transversal of graph1 from vertex 0");
        bfs(0, graph1, n);
        System.out.println();

        System.out.println("BFS transversal of graph2 from vertex 2");
        bfs(2, graph2, n);
        System.out.println();
        
        System.out.println("BFS transversal of graph3 from vertex 3");
        bfs(3, graph3, n);
        System.out.println();
    }

    public static void bfs(int v, int [][] graph, int n) {
        
        visited = new int [n];
        queue = new int [n];
        front = 0;
        rear = -1;
        int u = v;
        visited[v] = 1;
        queue[++rear] = v;

        while (front <= rear) {
            u = queue[front++];
            System.out.print(u + " ");
            for (int w=0; w < graph.length; w++) {
                if (graph[u][w] == 1 && visited[w] == 0) {
                    queue[++rear] = w;
                    visited[w] = 1;
                }
            }
        }
    }
}