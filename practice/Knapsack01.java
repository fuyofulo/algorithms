class Knapsack01 {
    public static void main (String [] args) {
        int [] weights = {10, 20, 30};
        int [] values = {60, 100, 120};

        int n = weights.length;
        int w = 50;

        System.out.println("Max input of knapsack for input = "+ knapsack(weights, values, n, w));
    }

    public static int knapsack(int [] weights, int [] values, int n, int w) {
        int dp [][] = new int [n+1][w+1];

        for(int i=1; i<=n; i++) {
            for(int j=0; j<=w; j++) {
                if(weights[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], values[i-1]+dp[i-1][j-weights[i-1]]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}