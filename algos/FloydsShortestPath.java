public class FloydsShortestPath {
    public static void allPairsShortestPaths(int[][] cost, int[][] A, int n) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = cost[i][j];
        
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    A[i][j] = Math.min(A[i][j], A[i][k] + A[k][j]);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                if (val == 99999) {
                    System.out.print("INF ");
                } else {
                    System.out.print(val + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int INF = 99999;
        int[][] cost1 = {{0, 5, INF, 10},
                         {INF, 0, 3, INF},
                         {INF, INF, 0, 1},
                         {INF, INF, INF, 0}};

        int n1 = cost1.length;
        int[][] A1 = new int[n1][n1];
        allPairsShortestPaths(cost1, A1, n1);
        System.out.println("Shortest path matrix for graph 1:");
        printMatrix(A1);

        int[][] cost2 = {{0, 3, INF, 7},
                         {8, 0, 2, INF},
                         {5, INF, 0, 1},
                         {2, INF, INF, 0}};

        int n2 = cost2.length;
        int[][] A2 = new int[n2][n2];
        allPairsShortestPaths(cost2, A2, n2);
        System.out.println("Shortest path matrix for graph 2:");
        printMatrix(A2);

        int[][] cost3 = {{0, 3, INF, 7},
                         {8, 0, 2, INF},
                         {5, INF, 0, 1},
                         {2, INF, INF, 0}};

        int n3 = cost3.length;
        int[][] A3 = new int[n3][n3];
        allPairsShortestPaths(cost3, A3, n3);
        System.out.println("Shortest path matrix for graph 3:");
        printMatrix(A3);
    }
}
