package strSecond;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            String[] strList = s.split(" ");
            Arrays.sort(strList);
            for(int i = 0; i < strList.length - 1; i++){
                System.out.print(strList[i] + " ");
            }
            System.out.println(strList[strList.length - 1]);
        }
    }
}
