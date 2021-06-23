package Test01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/17 20:10
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<String>();
        while(scanner.hasNext()){
            arrayList.add(scanner.next());
        }
        int count  = 0;
        for (String s : arrayList) {
            if (s.contains("7")){
                count++;
            }else {
                long val = Integer.valueOf(s);
                if(val % 7 == 0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
