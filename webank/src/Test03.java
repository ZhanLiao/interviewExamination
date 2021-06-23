
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/15 21:50
 * @Version: 1.0
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Builder builder = new Builder();
        ArrayList<String[]> strings = new ArrayList<String[]>();
        for (int i = 0; i < n; i++) {
            String[] strArr = scanner.nextLine().split(" ");
            strings.add(strArr);
        }
        for (String[] strArr : strings) {
            if (strArr[0].equals("Add")){
                builder.add(strArr[1], Integer.valueOf(strArr[2]), Integer.valueOf(strArr[3]));
            }else if (strArr[0].equals("Query")){
                builder.query(strArr[1]);
            }else if (strArr[0].equals("Change")){
                builder.change(strArr[1], Integer.valueOf(strArr[2]), Integer.valueOf(strArr[3]));
            }else if (strArr[0].equals("Delete")){
                builder.delete(strArr[1]);
            }
            n--;
        }
    }
}

class Builder{
    Map<String, int[]> hasMap;

    public Builder(){
        hasMap = new HashMap<String, int[]>();
    }

    public void add(String name, int x, int y){
        int[] temp = new int[2];
        temp[0] = x;
        temp[1] = y;
        hasMap.put(name, temp);
    }

    public void query(String name){
        if (!hasMap.containsKey(name)){
            System.out.println("no");
        }else {
            System.out.println("yes");
            System.out.println(hasMap.get(name)[0] + " " + hasMap.get(name)[1]);
        }
    }

    public void change(String name, int x, int y){
        int[] temp = new int[2];
        temp[0] = x;
        temp[1] = y;
        if (hasMap.containsKey(name)){
            hasMap.put(name, temp);
        }
    }

    public void delete(String name){
        if (hasMap.containsKey(name)){
            hasMap.remove(name);
        }
    }
}
