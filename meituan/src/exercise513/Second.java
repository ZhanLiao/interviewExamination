package exercise513;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n+1];
        HashSet<Integer> integers = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ints[i] = scanner.nextInt();
            list.add(ints[i]);
            if (ints[i] >= 1 && ints[i] <= n){
                integers.add(ints[i]);
            }

        }
        int count = 0;
        /*for (int i = 1; i <= n; i++){
            if (ints[i] <= 0){
                while (true){
                    ints[i]++;
                    count++;
                    if (!integers.contains(ints[i]) && ints[i] >= 1){
                        integers.add(ints[i]);
                        break;
                    }
                }
            }else if (ints[i] > n){
                while (ints[i] > 0){
                    ints[i]--;
                    count++;
                    if (!integers.contains(ints[i]) && ints[i] <= n && 1 <= ints[i]) {
                        integers.add(ints[i]);
                        break;
                    }

                }
            }
        }

        HashSet<Integer> integers1 = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (!integers1.contains(ints[i]) && ints[i] > 0 && ints[i] <= n){
                integers1.add(ints[i]);
            }else if (integers1.contains(ints[i]) && ints[i] > 0 && ints[i] <= n){
                int tempCount = 0;
                while (ints[i] <= n){
                    if (!integers1.contains(ints[i])){
                        integers1.add(ints[i]);
                        break;
                    }
                    ints[i]++;
                    tempCount++;
                }
                if (ints[i] > n){
                    ints[i] -= tempCount;
                    tempCount = 0;
                    while (ints[i] > 0){
                        if (!integers1.contains(ints[i])){
                            integers1.add(ints[i]);
                            break;
                        }
                        ints[i]--;
                        tempCount++;
                    }
                }
                count += tempCount;
            }else if (ints[i] < 0){

                while (true){
                    ints[i]++;
                    count++;
                    if (!integers1.contains(ints[i]) && ints[i] >= 1){
                        integers1.add(ints[i]);
                        break;
                    }
                }
            }else {
                while (ints[i] > 0){
                    ints[i]--;
                    count++;
                    if (!integers1.contains(ints[i]) && ints[i] <= n && 1 <= ints[i]) {
                        integers1.add(ints[i]);
                        break;
                    }
                }
            }

        }*/

        Collections.sort(list);
        for (int i = 1; i <= n; i++) {
            if (list.get(i-1) != i){
                count += Math.abs(i - list.get(i-1));
            }
        }
        System.out.println(count);
    }
}
