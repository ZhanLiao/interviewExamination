package Test02;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/17 20:25
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        scanner.nextLine();
        String[] split = scanner.nextLine().split(",");
        String[] split1 = scanner.nextLine().split(",");
        int[] w = new int[split.length];
        int[] v = new int[split1.length];
        for (int i = 0; i < w.length; i++) {
            w[i] = Integer.valueOf(split[i]);
            v[i] = Integer.valueOf(split1[i]);
        }
        int[][] dp = new int[w.length + 1][total+1];
        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= total; j++) {
                dp[i][j] = j - w[i-1] >= 0 ? Math.max(dp[i-1][j-w[i-1]] + v[i-1], dp[i-1][j]) : dp[i-1][j];
            }
        }
        System.out.println(dp[w.length][total]);
    }
}
