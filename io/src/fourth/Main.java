package fourth;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            String[] strings = str.split(" ");
            int sum = 0;
            for (int i = 0; i < strings.length; i++) {
                sum += Integer.valueOf(strings[i]);
            }
            System.out.println(sum);
        }
    }
}
