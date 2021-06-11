package four;

import java.util.Scanner;

public class Main {
    static int n, m;    // 方格大小
    static int[][] visit;   // 记录走过的路
    static int countObs = 0;    //统计遇到的障碍【障碍小于p的时候才能算一次成功到达】
    static int c = 0;   // 统计消耗能量值
    static int minP = Integer.MAX_VALUE;    // 最少能量值
    static int p = 1;   // 一次击破机会
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        String[] str = new String[n];
        visit = new int[n][m];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            str[i] = scanner.nextLine();
        }
        int[] initIndex = {0, 0};
        visit[initIndex[0]][initIndex[1]] = -1;
        getMinPath(str, initIndex);
        if (Integer.compare(minP, Integer.MAX_VALUE) < 0) {
            System.out.println(minP);
        }else {
            System.out.println(-1);
        }

    }


    private static void getMinPath(String[] str, int[] curIndex) {
        if (curIndex[0] == n-1 && curIndex[1] == m-1){
            if (countObs <= 1){
                minP = Math.min(minP, c);
            }
            return;
        }


        for (int k = 0; k < 4; k++) {
            int[] next = nextPoint(curIndex, k);
            if (!checkLegal(next[0], next[1])){
                continue;
            }
            visit[next[0]][next[1]] = -1;
            c++;
            if (str[next[0]].charAt(next[1]) == '*'){
                countObs++;
            }
            getMinPath(str, next);
            if (str[next[0]].charAt(next[1]) == '*'){
                countObs--;
            }
            visit[next[0]][next[1]] = 0;
            c--;
        }
    }

    private static int[] nextPoint(int[] curIndex, int j) {
        int[] res = new int[2];
        switch (j){
            case 0 :
                res = new int[]{curIndex[0]-1, curIndex[1]};
                break;
            case 1 :
                res = new int[]{curIndex[0]+1, curIndex[1]};
                break;
            case 2 :
                res = new int[]{curIndex[0], curIndex[1]-1};
                break;
            case 3 :
                res = new int[]{curIndex[0], curIndex[1]+1};
            default:
                break;
        }
        return res;
    }

    private static boolean checkLegal(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || visit[i][j] == -1){
            return false;
        }else {
            return true;
        }
    }
}
