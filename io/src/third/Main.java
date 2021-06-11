package third;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int i = 0; i < s; i++) {
            int a = in.nextInt();
            int sum = 0;
            for (int i1 = 0; i1 < a; i1++) {
                sum += in.nextInt();
            }
            System.out.println(sum);
        }
    }
}
