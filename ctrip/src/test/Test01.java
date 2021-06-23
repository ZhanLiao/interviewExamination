package test;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description: leetCode1049题
 * @Date: 2021/6/10 18:42
 * @Version: 1.0
 */
public class Test01 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int collide(int[] numbers) {
        int sum = 0;
        for(int s : numbers){
            sum += s;
        }
        int value = sum/2;
        int[] dp = new int[value+1];
        for (int s : numbers){
            for (int i = value; i >= s; i--) {
                dp[i] = Math.max(dp[i], dp[i-s] + s);
            }
        }
        return sum - 2 * dp[value];
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] stringArray = str.split("\\,");
        int[] numbers = new int[stringArray.length];
        for(int i=0;i<stringArray.length;i++){
            numbers[i] = Integer.parseInt(stringArray[i]);
        }

        int res = collide(numbers);
        System.out.println(String.valueOf(res));
    }
}
