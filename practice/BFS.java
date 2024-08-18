class BFS {
    
    static int [] visited;
    static int [] queue;
    static int front;
    static int rear;
    
    public static void main (String [] args) {
        int n = 6;
        int g1 [][] = {
            {0,1,0,0,0,1},
            {1,0,1,1,0,0},
            {0,1,0,0,0,0},
            {0,1,0,0,1,1},
            {0,0,0,1,0,0},
            {1,0,0,1,0,0}
        };
        
        int g2 [][] = {
            {0,0,1,1,0,0},
            {1,0,1,0,1,0},
            {1,1,0,0,1,1},
            {1,0,0,0,0,1},
            {0,1,1,1,0,0},
            {0,0,1,1,0,0}
        };

        int g3 [][] = {
            {0,1,0,0,1,0},
            {1,0,1,0,1,0},
            {0,1,0,1,0,1},
            {0,0,1,0,1,0},
            {1,1,0,1,0,0},
            {0,0,1,0,0,0}
        };
        
        System.out.print("BFS of h1 from vertex 0: ");
        bfs(n, g1, 0);
        System.out.println();
        
        System.out.print("BFS of h1 from vertex 1: ");
        bfs(n, g2, 1);
        System.out.println();
        
        System.out.print("BFS of h1 from vertex 2: ");
        bfs(n, g3, 2);
        System.out.println();
    }
    
    
    public static void bfs (int n, int [][] graph, int v) {
        visited = new int [n];
        queue = new int [n];
        front = 0;
        rear = -1;
        
        queue [++rear] = v;
        visited[v] = 1;
        
        while(front <= rear) {
            v = queue[front++];
            System.out.print(v+" ");
            for(int i=0; i<graph.length; i++) {
                if(graph[v][i] == 1 && visited[i] == 0) {
                    queue[++rear] = i;
                    visited[i] = 1;
                }
            }
        }
    }
}