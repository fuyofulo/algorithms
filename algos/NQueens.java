public class NQueens {
    int []x;
    boolean place (int k, int i) {
        for (int j=1; j<k; j++) {
            if(x[j] == i || Math.abs(x[j]-i) == Math.abs(j-k)) {
                return false;
            }
        }
        return true;
    }

    void NQueens(int k, int n) {
        for (int i=1; i<=n; i++) {
            if(place(k, i)) {
                x[k] = i;
                if(k == n) {
                    printSolution(n);
                } else {
                    NQueens(k+1, n);
                }
            }
        }
    }

    void printSolution(int n) {
        for (int i=1; i<=n; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int [] boardsizes = {1, 4, 6};
        for (int n: boardsizes) {
            System.out.println("Solutions for " + n + " queens:");
            NQueens nq = new NQueens();
            nq.x = new int[n+1];
            nq.NQueens(1, n);
            System.out.println();
        } 
    }
}