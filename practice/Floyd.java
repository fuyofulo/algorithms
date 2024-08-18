class Floyd {
    public static void AllPairsShortestPath (int [][] matrix, int [][] A, int n) {
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                A [i][j] = matrix [i][j];
            }
        }
        
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    A[i][j] = Math.min (A[i][j], A[i][k] + A[k][j]);
                }
            }
        }
    }
    
    public static void main (String [] args) {
        
        int INF = 99999;
        int[][] g1 = {{0, 3, INF, 7},
                      {8, 0, 2, INF},
                      {5, INF, 0, 1},
                      {2, INF, INF, 0}};
        
        int n = g1.length;
        int [][] A = new int [n][n];
        AllPairsShortestPath(g1, A, n);
        printMatrix(A);
    }
    
    public static void printMatrix (int [][] matrix) {
        
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if(matrix[i][j] == 99999) {
                    System.out.print("INF"+" ");
                } else {
                    System.out.print(matrix[i][j]+" ");
                }
            }
            System.out.println();
        } 
            
    }
    
    
    
    
    
    
    
    
}