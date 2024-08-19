class Ham
{
    static boolean hasCycle;
    // Method to check if the current vertex can be added to the Hamiltonian Cycle
    static boolean isSafe(int graph[][], int path[], int v, int pos) {
        // Check if this vertex is an adjacent vertex of the previously added vertex
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }

        // Check if the vertex has already been included in the path
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }

        return true;
    }

    // A recursive utility function to solve the Hamiltonian Cycle problem
    static boolean hamCycleUtil(int graph[][], int path[], int pos) {
        // Base case: If all vertices are included in the cycle and there's an edge from the last to the first vertex
        if (pos == graph.length) {
            if(graph[path[pos - 1]][path[0]] != 0)
            {
                hasCycle = true;
                return true;
            }
        }

        // Try different vertices as the next candidate in the Hamiltonian Cycle
        for (int v = 1; v < graph.length; v++) {
            if (isSafe(graph, path, v, pos)) {
                path[pos] = v;

                if (hamCycleUtil(graph, path, pos + 1)) 
                {
                    // If a Hamiltonian Cycle is found, print it
                    printCycle(path);
                }

                // Backtrack
                path[pos] = -1;
            }
        }

        return false;
    }

    // Method to print the Hamiltonian Cycle
    static void printCycle(int[] path) {
        for (int i = 0; i < path.length; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]);  // To form a cycle, print the first vertex again
    }

    // Method to find all Hamiltonian Cycles
    static void findHamiltonianCycles(int graph[][]) {
        hasCycle = false;
        int path[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            path[i] = -1;  // Initialize path array
        }

        path[0] = 0;  // Start the cycle with vertex 0

        if(!(hamCycleUtil(graph, path, 1) || hasCycle))
        {
            System.out.println("No Solution");
        }
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int[][] graph = {
			{ 0, 1, 1, 0, 0, 1 },
			{ 1, 0, 1, 0, 1, 1 },
			{ 1, 1, 0, 1, 0, 0 },
			{ 0, 0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0, 1 },
			{ 1, 1, 0, 0, 1, 0 },
		};

        findHamiltonianCycles(graph);
    }
}