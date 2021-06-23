package test01;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/11 15:41
 * @Version: 1.0
 */
public class Main {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        long maxSum = deal(nums);
        System.out.print(maxSum + " " + count);
    }

    private static long deal(int[] nums) {
        int n = nums.length;
        int maxNum = nums[n-1];
        long sum = maxNum;
        for (int i = n-2; i >=0 ; --i) {
            if (nums[i] < maxNum){
                nums[i] = nums[i+1];
                count++;
            }
            maxNum = Math.max(maxNum, nums[i]);
            sum += nums[i];
        }
        return sum;
    }
}
