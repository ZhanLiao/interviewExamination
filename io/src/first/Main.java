package first;

import java.util.*;

/**
 * 输入：1， 2
 *      2, 4
 *      0，0
 *  以0， 0 结束
 */
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();

            if(a==0 && b==0){
                break;
            }
            else{
                System.out.println(a+b);
            }
        }
        sc.close();
    }
}