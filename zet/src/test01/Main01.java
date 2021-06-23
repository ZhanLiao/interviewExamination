package test01;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:  中兴笔试第二道编程题，打怪兽暴利DFS
 * @Date: 2021/6/11 16:00
 * @Version: 1.0
 */
public class Main01 {
    static int count = 0;
    static int minCount = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        for (int i = 0; i < total; i++) {
            int n = scanner.nextInt();
            int poster = scanner.nextInt();
            int[] energy = new int[n];
            int[] threshold = new int[n];
            for (int j = 0; j < n; j++) {
                energy[j] = scanner.nextInt();
                threshold[j] = scanner.nextInt();
            }
            int ans = deal(energy, threshold, poster);
            System.out.println(ans);
        }
    }

    private static int deal(int[] energy, int[] threshold, int poster) {
        int star = 0;
        boolean[] visit = new boolean[energy.length];
        dfs(energy, threshold, star, poster, visit);
        return minCount;
    }

    private static void dfs(int[] energy, int[] threshold, int star, int poster, boolean[] visit) {
        if (poster <= 0){
            minCount = Math.min(count, minCount);
            return;
        }else if (star == energy.length){
            return;
        }

        for (int i = 0; i < energy.length; i++) {
            if (visit[i]){
                continue;
            }
            int num = 0;
            if (poster <= threshold[i]){
                num = 2 * energy[i];
            }else {
                num = energy[i];
            }
            count++;
            visit[i] = true;
            poster -= num;
            dfs(energy, threshold, star+1, poster, visit);
            poster += num;
            visit[i] = false;
            count--;
        }

    }
}
