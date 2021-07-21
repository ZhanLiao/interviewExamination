import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/19 14:32
 * @Version: 1.0
 */
public class Shopee {
    public static void main(String[] args) {
        String source = "b";
        String target = "c";
        System.out.println(Shopee.findMinOverrideSubString(source, target));;
    }
    static public String findMinOverrideSubString(String source, String target) {
        // write code here
        /*String res = " ";
        int size = target.length();
        for (int i = 0; i <= source.length()-size; i++) {
            if (source.substring(i, i+size).equals(target)){
                res = target;
                break;
            }
        }
        return res;*/

        HashMap<Character, Integer> oMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> cMap = new HashMap<Character, Integer>();
        int tLength = target.length();
        for (int i = 0; i < tLength; i++) {
            char c = target.charAt(i);
            oMap.put(c, oMap.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        int r = -1;
        int len = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;
        int sLen = source.length();
        while (r < sLen){
            r++;
            if (r < sLen && oMap.containsKey(source.charAt(r))){
                cMap.put(source.charAt(r), cMap.getOrDefault(source.charAt(r), 0) + 1);
            }
            while (check(oMap, cMap) && l <= r){
                if (r - l + 1 < len){
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (oMap.containsKey(source.charAt(l))){
                    cMap.put(source.charAt(l), cMap.getOrDefault(source.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? " " : source.substring(ansL, ansR);


       /*int[] map = new int[];
        for (int i = 0; i < target.length(); i++) {
            map[target.charAt(i)]++;
        }
        int begin = 0;
        int end = 0;
        int dMax = Integer.MAX_VALUE;
        int counter = target.length();
        int head = 0;
        while (end < source.length()){
            if (map[source.charAt(end++)]-- > 0){
                counter++;
            }
            while (counter == 0){
                if (end - begin < dMax){
                    dMax = end - (head = begin);
                }
                if (map[source.charAt(begin++)]++ == 0){
                    counter++;
                }
            }
        }
        return dMax == Integer.MAX_VALUE ? " " : source.substring(head, head+dMax);*/
    }

    private static boolean check(HashMap<Character, Integer> oMap, HashMap<Character, Integer> cMap) {
        Iterator<Map.Entry<Character, Integer>> iterator = oMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            if (cMap.getOrDefault(key, 0) < value){
                return false;
            }
        }
        return true;
    }

    public int getValue(int rowIndex, int columnIndex) {
        // write code here
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = null;
        for (int i = 0; i < rowIndex; i++) {
            ArrayList<Integer> subAns = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i){
                    subAns.add(1);
                }else {
                    subAns.add(temp.get(j-1) + temp.get(j));
                }
            }
            ans.add(subAns);
            temp = subAns;
        }
        return ans.get(rowIndex - 1).get(columnIndex - 1);

    }

    public int[] GetEndPoint(String order) {
        // write code here

        HashMap<Character, int[]> map = new HashMap<Character, int[]>();
        map.put('W', new int[]{0, 1});
        map.put('w', new int[]{0, 1});
        map.put('S', new int[]{0, -1});
        map.put('s', new int[]{0, -1});
        map.put('D', new int[]{1, 0});
        map.put('d', new int[]{1, 0});
        map.put('A', new int[]{-1, 0});
        map.put('a', new int[]{-1, 0});
        int row = 0;
        int col = 0;
//        int num = 1;
        String num = "";
        for (int i = 0; i < order.length(); i++) {
            if (order.charAt(i) >= '0' && order.charAt(i) <= '9'){
                num += order.charAt(i);
            }else {
                int[] index = map.get(order.charAt(i));
                int x = num.equals("") ? 1 : Integer.valueOf(num);
                row += index[0]*x;
                col += index[1]*x;
                num = "";
            }
        }
        return new int[]{row, col};

        /*int i = 0;
        int x = 0;
        int y = 0;
        int step = 1;
        while (i < order.length()){
            char cur = order.charAt(i);
            cur = Character.toUpperCase(cur);
            if (cur == 'W'){
                y += step;
                step = 1;
            }else if (cur == 'S'){
                y -= step;
                step = 1;
            }else if (cur == 'D'){
                x += step;
                step = 1;
            }else if (cur == 'A'){
                x -= step;
                step = 1;
            }else {
                step = cur - '0';
                while(i + 1 < order.length() && (order.charAt(i+1) >= '0' && order.charAt(i+1) <= '9')){
                    step += step * 10 + (order.charAt(i + 1) - '0');
                    i++;
                }
                *//*if (i -1 > 0 && (order.charAt(i+1) >= '0' && order.charAt(i+1) > '9')){
                    step = step * 10 + cur - '0';
                }else {
                    step = cur - '0';
                }*//*
            }
            i++;
        }
        return new int[]{x, y};*/
    }
}
