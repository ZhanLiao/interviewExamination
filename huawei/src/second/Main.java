package second;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输出AES的速度
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> tempList = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            tempList.add(scanner.nextInt());
        }
        int[] num = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            num[i] = tempList.get(i);
        }
        int[] ans = printFast(num);
        for (int i = 0; i < ans.length-1; i++) {
            System.out.print(ans[i] + ",");
        }
        System.out.println(ans[ans.length-1]);

    }

    private static int[] printFast(int[] num) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] dp = new int[100001];

        for (int i = 0; i < num.length; i++) {
            if(i >= 4 && num[i-1] - num[i] >= 9){
                if((dp[i-2] == 1 && dp[i-1] == 1 && dp[i-3] == 1) || dp[i-1] == 2){
                    dp[i] = 2;
                    list.add(i);
                }else {
                    dp[i] = 1;
                }
            }else if(num[i - 1] - num[i] < 9){
                dp[i] = 0;
            }else if (i < 4 && num[i - 1] - num[i] >= 9){
                dp[i] = 1;
            }
        }
        int[] ans = new int[list.size()];
        for(Integer i : list){
            ans[i] = num[Integer.valueOf(i)];
        }
        return ans;
    }
}
