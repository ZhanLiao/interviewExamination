package strFirst;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        String[] str = new String[a];
        for (int i = 0; i < a; i++) {
            String s = in.next();
            str[i] = s;
        }
        Arrays.sort(str);
        for (int i = 0; i < str.length - 1; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.print(str[str.length - 1]);

    }
}
