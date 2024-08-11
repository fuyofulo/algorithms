import java.io.*;
import java.util.*;

class Prims{
    int mainkey(int key[], boolean mstSet[], int V){
        int min = Integer.MAX_VALUE, min_index = -1;
        for(int v = 0; v < V; v++){
            if(mstSet[v] == false && key[v] < min){
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void printMST(int parent[], int graph[][], int V){
        int totalWeight = 0;
        System.out.println("Edge \tWeight");
        for(int i = 1; i < V; i++){
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalWeight += graph[i][parent[i]];
        }
        System.out.println("Total min cost: " + totalWeight);
    }

    void primMST(int graph[][], int V){
        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];
        for(int i = 0; i < V; i++){
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for(int count = 0; count < V - 1; count++){
            int u = mainkey(key, mstSet, V);
            mstSet[u] = true;
            for(int v = 0; v < V; v++){
                if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]){
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph, V);
    }

    public static void main(String[] args){

        Prims t = new Prims();

        int graph1[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                       { 2, 0, 3, 8, 5 },
                                       { 0, 3, 0, 0, 7 },
                                       { 6, 8, 0, 0, 9 },
                                       { 0, 5, 7, 9, 0 } };

        int graph2[][] = new int[][] { { 0, 1, 0, 0, 0, 0},
                                       { 1, 0, 2, 0, 3, 0},
                                       { 0, 2, 0, 4, 0, 0},
                                       { 0, 0, 4, 0, 5, 6},
                                       { 0, 3, 0, 5, 0, 7},
                                       { 0, 0, 0, 6, 7, 0}};

        int graph3[][] = new int[][] { { 0, 9, 0, 0, 0, 0, 0, 0, 0 },
                                       { 9, 0, 10, 0, 0, 0, 0, 0, 0 },
                                       { 0, 0, 1, 0, 2, 3, 0, 0, 0 },
                                       { 0, 0, 0, 2, 0, 4, 0, 0, 0 },
                                       { 0, 0, 0, 3, 4, 0, 5, 0, 0 },
                                       { 0, 0, 0, 0, 0, 5, 0, 6, 0 },
                                       { 0, 0, 0, 0, 0, 0, 6, 0, 7 },
                                       { 0, 0, 0, 0, 0, 0, 0, 7, 0 }};

        System.out.println("Graph 1");
        t.primMST(graph1, graph1.length);
        System.out.println("Graph 2");
        t.primMST(graph2, graph2.length);
        System.out.println("Graph 3");
        t.primMST(graph3, graph3.length);
    }
}