class TravellingSalesman {
    static final int INF = Integer.MAX_VALUE;
    int [][] graph;
    boolean [] visited;
    int v;
    int minCost;
    int [] bestPath;
    int [] currentpath;
    TravellingSalesman(int [][] graph) {
        this.graph = graph;
        this.v = graph.length;
        this.visited = new boolean[v];
        this.minCost = INF;
        this.bestPath = new int[v+1];
        this.currentpath = new int[v+1];
    }

    void TravellingSalesman (int currentPosition, int count, int cost) {
        if(count == v && graph[currentPosition][0] > 0) {
            int totalCost = cost + graph[currentPosition][0];
            if(totalCost < minCost) {
                minCost = totalCost;
                System.arraycopy(currentpath, 0, bestPath, 0, v);
                bestPath[v] = 0;
            }
            return;
        }
        for (int i=0; i<v; i++) {
            if (!visited[i] && graph[currentPosition][i] > 0) {
                visited[i] = true;
                currentpath[count] = i;
                TravellingSalesman(i, count+1, cost+graph[currentPosition][i]);
                visited[i] = false;
            }
        }
    }

    void findBestpath () {
        visited[0] = true;
        currentpath[0] = 0;
        TravellingSalesman(0, 1, 0);
        printSolution();
    }

    void printSolution() {
        if(minCost == INF) {
            System.out.println("No solution");
            return;
        } else {
            System.out.println("Minimum cost: " + minCost);
            System.out.println("Path: ");
            for(int i=0; i<=v; i++) {
                System.out.print(bestPath[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph1 = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        int[][] graph2 = {
            {0, 29, 20, 21},
            {29, 0, 15, 17},
            {20, 15, 0, 28},
            {21, 17, 28, 0}
        };

        int[][] graph3 = {
            {0, 12, 10, 19},
            {12, 0, 8, 27},
            {10, 8, 0, 16},
            {19, 27, 16, 0}
        };


        System.out.println("Graph 1");
        TravellingSalesman ts1 = new TravellingSalesman(graph1);
        ts1.findBestpath();

        System.out.println("Graph 2");
        TravellingSalesman ts2 = new TravellingSalesman(graph2);
        ts2.findBestpath();

        System.out.println("Graph 3");
        TravellingSalesman ts3 = new TravellingSalesman(graph3);
        ts3.findBestpath();
    }
}