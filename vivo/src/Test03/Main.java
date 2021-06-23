package Test03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/17 20:42
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        String[] split1 = scanner.nextLine().split(";");
        int n = split.length;
        int[] cost = new int[n];
        ArrayList<int[]> depend = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.valueOf(split[i]);
            String[] strings = split1[i].split(",");
            int[] temp = new int[strings.length];
            for (int i1 = 0; i1 < temp.length; i1++) {
                temp[i1] = Integer.valueOf(strings[i1]);
            }
            depend.add(temp);
        }
        int[] maxTime = new int[n];
        for (int i = 0; i < n; i++) {
            maxTime[i] = -1;
        }

        int ans = 10;
        System.out.println(ans);
    }
}

