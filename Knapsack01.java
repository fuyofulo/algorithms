public class Knapsack01 {

    public static int knapsack(int[] weights, int[] values, int n, int W) {
        int[][] dp = new int[n+1][W+1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i-1] <= w) {
                    dp[i][w] = Math.max(dp[i-1][w], values[i-1] + dp[i-1][w-weights[i-1]]);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] values1 = {60, 100, 120};
        int[] weights1 = {10, 20, 30};
        int W1 = 50;
        int n1 = values1.length;
        System.out.println("Maximum value in knapsack for input 1 = " + knapsack(weights1, values1, n1, W1));

        int[] values2 = {10, 40, 30, 50};
        int[] weights2 = {5, 4, 6, 3};
        int W2 = 10;
        int n2 = values2.length;
        System.out.println("Maximum value in knapsack for input 2 = " + knapsack(weights2, values2, n2, W2));

        int[] values3 = {1, 2, 3};
        int[] weights3 = {4, 5, 1};
        int W3 = 4;
        int n3 = values3.length;
        System.out.println("Maximum value in knapsack for input 3 = " + knapsack(weights3, values3, n3, W3));
    }
}
