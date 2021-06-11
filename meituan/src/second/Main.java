package second;

import java.util.Scanner;

/**
 * 美团第二道：围栏，固定长度的家具跨过围栏。围栏高度小于指定高度才能过去。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 围栏个数
        int m = scanner.nextInt();  // 家具宽度
        int h = scanner.nextInt();  // 最高能跨上的高度
        int[] highs = new int[100000+1];
        for (int i = 0; i < n; i++) {
            highs[i] = scanner.nextInt();
        }
        int resVal = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i <= n - m; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (highs[i+j] > h){
                    flag = false;
                    break;
                }
            }
            if (flag){
                if (resVal > highs[i]){
                    index = i;
                    resVal = highs[i];
                }
            }
        }
        if (resVal < Integer.MAX_VALUE){
            System.out.println(index);
        }else {
            System.out.println(-1);
        }

    }
}
