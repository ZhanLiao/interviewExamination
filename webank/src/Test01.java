import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/15 20:50
 * @Version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] ans = deal(nums);
        System.out.println(ans.length);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

    private static int[] deal(int[] nums) {
        ArrayList<Integer> resList = new ArrayList<Integer>();
        int c = 0;
        for (int i = nums.length - 1; i >= 0; i--) {

            int j = i - 1;
            while (j >= 0){
                int b = nums[i] - nums[j];
                if (b > 0){
                    nums[j] = 0;
                    c++;
                }else {
                    break;
                }
                j++;
            }
        }
        int[] res = new int[nums.length - c];
        int k = 0;
        for (int num : nums) {
            if (num != 0){
//                resList.add(num);
                res[k] = num;
                k++;
            }
        }
//        int[] res = new int[resList.size()];
//        for (int i = 0; i < resList.size(); i++) {
//            res[i] = resList.get(i);
//        }
        return res;

    }

    /*private static int[] deal(int[] nums) {
        ArrayList<Integer> resList = new ArrayList<Integer>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]){
                nums[i-1] = 0;
            }
        }
        for (int num : nums) {
            if (num != 0){
                resList.add(num);
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }*/
}
