package third;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        /*ArrayList<Integer> list = new ArrayList<>(new Com);
//        ArrayList<Integer> list = new ArrayList<>();
        int[] dis = new int[total];
        for (int i = 0; i < total; i++) {
//            dis[i] = scanner.nextInt();
            list.add(scanner.nextInt());
        }
       *//* Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });*//*
        int count = 0;
        for(Integer i : list){
            if(total <= 0){
                break;
            }
            count++;
            total -= i;
        }*/
        int[] num = new int[total];
        for (int i = 0; i < num.length; i++) {
            num[i] = scanner.nextInt();
        }
        int count = step(num);
        System.out.println(count);
    }

    private static int step(int[] num) {
        if (num.length == 1){
            return 0;
        }
        int reach = 0;
        int nextReach = num[0];
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            nextReach = Math.max(i + num[i], nextReach);
            if(nextReach >= num.length - 1){
                return count + 1;
            }
            if(i == reach){
                count++;
                reach = nextReach;
            }
        }
        return count;
    }
}
