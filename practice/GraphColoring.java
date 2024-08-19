class GraphColoring {
    public static void main (String [] args) {
  
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
    
   public static void graphColoring(int [][] graph, int n) {
       int [] result = new int [graph.length];
       
       for (int i=0; i<result.length; i++) {
           result[i] = 0;
       }
       
        if(!graphColorUtil(graph, n, result, 0)) {
               System.out.println("no solution");
        } else {
            printSolution(result);
        }
   }
   
   public static boolean graphColorUtil(int [][] graph, int n, int [] result, int v) {
       
       if(v == graph.length) {
           return true;
       }
       
       for (int c = 1; c <= n; c++) {
           if(isSafe(graph, result, v, c)) {
               result[v] = c;
               if(graphColorUtil(graph, n, result, v+1)) {
                   return true;
               }
               result[v] = 0;
           }
           
        }
        return false;
    }

    public static boolean isSafe(int [][] graph, int [] result, int v, int c) {
       for (int i=0; i<graph.length; i++) {
           if(graph[v][i] == 1 && result[i] == c) {
               return false;
           }
       }
       return true;
   }
   
   public static void printSolution(int [] result) {
       for(int i=0; i<result.length; i++) {
           System.out.print(result[i]+" ");
       }
       System.out.println();
   }

    
    
    
}