package five;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description: 华为的笔试的第三道编程题：面试者匹配面试官
 * @Date: 2021/4/29 15:20
 * @Version: 1.0
 */
public class Main {
    static ArrayList<int[][]> ans;
    static int x;
    static int m;
    static int n;
    static ArrayList<String[]> intervieweeList;
    static ArrayList<String> interviewerList;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();  //m个面试官
        n = scanner.nextInt();  //n个面试者
        x = scanner.nextInt();  //一个面试官不能匹配超过x个面试者
        scanner.nextLine();
        intervieweeList = new ArrayList<>();    // 存储面试官会的语言
        interviewerList = new ArrayList<>();    // 面试者熟悉的语言
        for (int i = 0; i < m; i++) {
            intervieweeList.add(scanner.nextLine().split(" "));
//            System.out.println(Arrays.toString(intervieweeList.get(i)));
        }
        for (int i = 0; i < n; i++) {
            interviewerList.add(scanner.nextLine());
//            System.out.println(Arrays.toString(intervieweeList.get(i)));
        }
        int[][] temp = new int[m][n];
        ans = new ArrayList<>();

        if (backTrack(temp, 0, n,0)){
            System.out.println("true");
            int[][] tempAns = ans.get(0);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(tempAns[i][j] + " ");
                }
                System.out.println();
            }
        }else {
            System.out.println("false");
        }

    }

    private static boolean backTrack(int[][] temp, int row, int n, int count) {
        //结束条件
        if(temp.length == row){
            if (count >= 2*n){
                ans.add(temp);
                return true;
            }
            return false;
        }
        for (int col = 0; col < n; col++) {
            //排除不合法的选择
            if (!isValid(temp, row, col)){
                continue;
            }
            //做出选择
            temp[row][col] = 1;
            count++;
            //下一个面试官的决策
            if (backTrack(temp, row+1, n, count)){
                return true;
            }
            //取消选择
//            temp[row][col] = 0;
//            count--;
        }
        return false;
    }

    private static boolean isValid(int[][] temp, int row, int col) {
        //判断列是否满足条件：面试官不得面试超过x个面试者
        int countRow = 0;
        for (int i = 0; i < n; i++) {
            if (temp[row][i] == 1){
                countRow++;
            }
            if (countRow > x){
                return false;
            }
        }
        // 面试官是否熟悉面试者的语言
        ArrayList<String> strings = new ArrayList<>();
        for (String str : intervieweeList.get(row)) {
            strings.add(str);
        }
        if (!strings.contains(interviewerList.get(col))){
            return false;
        }
        return true;
    }
}
