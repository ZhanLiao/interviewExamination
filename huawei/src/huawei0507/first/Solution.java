package huawei0507.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Exist {
    int t1;
    int t2;
    int t3;
    int t4;

    Exist(int tt1, int tt2, int tt3, int tt4) {
        t1 = tt1;
        t2 = tt2;
        t3 = tt3;
        t4 = tt4;
    }

    Exist() {
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] lines = new String[200005];
        scanner.nextLine();
        for (int i = 0; i < m * 2; i++) {
            lines[i] = scanner.nextLine();
        }
        //第一个是头出现的次数 第二个是段落出现的次数，第三个是头出现的位置，第四个是段落出现的位置
        HashMap<String, Exist> num = new HashMap<String, Exist>();
        int frontPos = 0;
        int textPos = 0;
        for (int i = 0; i < m * 2; i++) {
            String[] tmp = lines[i].split(" ");
            if (i % 2 == 0) {
                for (String s : tmp) {
                    frontPos++;
                    if (!num.containsKey(s)) {
                        num.put(s, new Exist(1, 0, frontPos, 99999999));
                    } else {
                        Exist exist = num.get(s);
                        Exist newExist = new Exist(exist.t1 + 1, exist.t2, exist.t3, exist.t4);
                        num.put(s, newExist);
                    }
                }
            } else {
                for (String s : tmp) {
                    textPos++;
                    if (!num.containsKey(s)) {
                        num.put(s, new Exist(0, 1, 99999999, textPos));
                    } else {
                        Exist exist = num.get(s);
                        Exist newExist = new Exist(exist.t1, exist.t2 + 1, exist.t3, exist.t4);
                        num.put(s, newExist);
                    }
                }
            }
        }
        List<Map.Entry<String, Exist>> list = new ArrayList<Map.Entry<String, Exist>>(num.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Exist>>() {

            @Override
            public int compare(Map.Entry<String, Exist> o1, Map.Entry<String, Exist> o2) {
                Exist e1 = o1.getValue();
                Exist e2 = o2.getValue();
                int ans1 = e1.t1 * 3 + e1.t2;
                int ans2 = e2.t1 * 3 + e2.t2;
                if (ans1 != ans2) {
                    return ans2 - ans1;
                } else {
                    if (e1.t3 == e2.t3) {
                        return e1.t4 - e2.t4;
                    } else {
                        return e1.t3 - e2.t3;
                    }
                }

            }
        });

        int cnt = 0;
        for (Map.Entry<String, Exist> mapping : list) {
            if(cnt ==0){
                System.out.print(mapping.getKey());
            }
            else{
                System.out.print(" "+mapping.getKey());
            }
            cnt++;
            if (cnt == n) {
                break;
            }
        }
    }
}
