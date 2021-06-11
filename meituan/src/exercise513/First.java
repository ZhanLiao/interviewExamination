package exercise513;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            integers.add(scanner.nextInt());
        }
        Collections.sort(integers);
        int res = Integer.MAX_VALUE;
        for (int i = x; i <= y; i++) {
            int m = integers.get(i-1);
            if (n-i <= y && i <= n - i){
                res = Math.min(m, res);
            }
        }
        System.out.println(res);
    }

}
