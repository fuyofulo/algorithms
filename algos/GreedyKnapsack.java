import java.util.*;
class GreedyKnapsack{
    public static void Knapsack(float m, int n, float w[], float p[]) {
        float x[] = new float[n+1];
        float totalWeight = 0;
        float totalProfit = 0;

        for (int i=1; i<=n; i++) {
            if (totalWeight + w[i] <= m) {
                x[i] = 1;
                totalWeight += w[i];
                totalProfit += p[i];
            } else {
                x[i] = (m-totalWeight)/w[i];
                totalProfit += x[i]*p[i];
                break;
            }
        }

        for(int i=1; i<=n; i++) {
            System.out.println("Item " + i + ": " + x[i]);
        }

        System.out.println("Total Profit: " + totalProfit);
    }

    public static void sortObject(int n, float p[], float w[]) {
        float ratio[] = new float[n+1];
        for (int i=1; i<=n; i++) {
            ratio[i] = p[i]/w[i];
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<n; j++) {
                if (ratio[j] < ratio[j+1]) {
                    float temp = p[j];
                    p[j] = p[j+1];
                    p[j+1] = temp;

                    float temp2 = w[j];
                    w[j] = w[j+1];
                    w[j+1] = temp2;

                    float temp3 = ratio[j];
                    ratio[j] = ratio[j+1];
                    ratio[j+1] = temp3;
                }
            }
        }
    }

    public static void main(String args[]) {
        Random r = new Random();
        int n = r.nextInt(5)+1;
        float m = r.nextInt(50)+10;
        float p[] = new float[n+1];
        float w[] = new float[n+1];

        for (int i=1; i<=n; i++) {
            p[i] = r.nextInt(50)+10;
            w[i] = r.nextInt(20)+5;
        }

        sortObject(n, p, w);
        System.out.println("No of objects: "+n);
        System.out.println("Knapsack Capacity: "+m);
        System.out.println("Profits: ");
        for (int i=1; i<=n; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println("\nWeights: ");
        for (int i=1; i<=n; i++) {
            System.out.print(w[i] + " ");
        }

        System.out.println();
        System.out.println("\n\nKnapsack Solution: ");
        Knapsack(m, n, w, p);
    }

}