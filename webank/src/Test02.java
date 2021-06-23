import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/15 21:33
 * @Version: 1.0
 */
public class Test02 {
    static boolean[][] visited;
    static int[][] values;
    static int ansValue;
    static int n;
    static int m;
    static int x;
    static int y;
    static int k;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        x = scanner.nextInt();
        y = scanner.nextInt();
        x--;
        y--;
        visited = new boolean[n][m];
        values = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                values[i][j] = scanner.nextInt();
            }
        }
        int ans = maxValue(x, y, k);
        System.out.println(ans);
    }

    private static int maxValue(int x, int y, int k) {
        ansValue = 0;
        dfs(x, y, 0, k);
        return ansValue;
    }

    private static void dfs(int row, int col, int curValue, int step) {
        if (row < 0 || row >= n || col < 0 || col > m){
            return;
        }
        if (values[row][col] == -1){
            return;
        }
        if (!visited[row][col]){
            curValue += values[row][col];
            visited[row][col] = true;
        }
        if (step == 0){
            if (row == x && col == y){
                ansValue = Math.max(ansValue, curValue);
                return;
            }else {
                return;
            }
        }
        dfs(row+1, col, curValue, step - 1);
        dfs(row+1, col, curValue, step - 1);
        dfs(row, col + 1, curValue, step - 1);
        dfs(row, col - 1, curValue, step - 1);
    }
}
