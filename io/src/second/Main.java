package second;

import java.util.Scanner;

/**
 * 定长和定个数输入
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int count = in.nextInt();
            if(count == 0){
                return;
            }
            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum += in.nextInt();
            }
            System.out.println(sum);
        }

    }
}
