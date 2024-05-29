import java.util.Scanner;

public class Knapsack {
    public static void knapsack(int[] weights, int[] values, int num, int maxW) {
        int[][] dp = new int[num + 1][maxW + 1];
        for (int i = 1; i <= num; i++) {
            for (int w = 1; w <= maxW; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        System.out.println("Dynamic Programming Table:");
        for (int i = 0; i <= num; i++) {
            for (int w = 0; w <= maxW; w++) {
                System.out.print(dp[i][w] + "\t");
            }
            System.out.println();
        }
        System.out.println("Items selected (weight, value):");
        for (int i = num; i > 0 && maxW > 0; i--) {
            if (dp[i][maxW] != dp[i - 1][maxW]) {
                System.out.println("(" + weights[i - 1] + ", " + values[i - 1] + ")");
                maxW = maxW - weights[i - 1];
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input number of items: ");
        int num = scanner.nextInt();
        System.out.print("enter max weight: ");
        int maxW = scanner.nextInt();
        int[] weights = new int[num];
        int[] values = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("enter weight and value of item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        scanner.close();
        knapsack(weights, values, num, maxW);
    }
}
