package huawei0507.first;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) {
        int topN, m;
        Scanner scanner = new Scanner(System.in);
        topN = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        String[] titles = new String[200001];
        String[] content = new String[20001];
        for (int i = 0; i < 2*m; i++) {
            if (i % 2 == 0){
                titles = scanner.nextLine().split(" ");
//                System.out.println(titles[0]);
            }else {
                content = scanner.nextLine().split(" ");
//                System.out.println(content[0]);
            }
        }

        Map<String, Integer> titlesHashMap = new HashMap<>();
        Map<String, Integer> allHashMap = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        getTopWord(titles, content, topN, titlesHashMap, allHashMap);

    }

    private static void getTopWord(String[] titles, String[] content, int topN, Map<String, Integer> titlesHashMap, Map<String, Integer> allHashMap) {
        for (String s : titles) {
            titlesHashMap.put(s, titlesHashMap.getOrDefault(s, 0) + 1);
            allHashMap.put(s, allHashMap.getOrDefault(s, 0) + 1);
        }
        for (String c : content) {
            allHashMap.put(c, allHashMap.getOrDefault(c, 0) + 1);
        }

        Map<String, Integer> titlesSorted = titlesHashMap
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        Map<String, Integer> allSorted = allHashMap
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        ArrayList<String> tempList = new ArrayList<>();
        HashMap<String, Integer> temMap = new HashMap<>();
        int temp = allHashMap.get(res.get(topN-1));
        String temStr = " ";
        for (String str : allHashMap.keySet()) {
            if (i < topN){
                res.add(str);
                i++;
            }
            if (i == topN){
                temStr = str;
            }
            if (i >= topN && temp == allHashMap.get(str)){
                tempList.add(str);
                temMap.put(str, titlesHashMap.get(str));
            }else {
                break;
            }

        }
        for (int j = res.size()-2; j >= 0 ; j--) {
            if (temp == allHashMap.get(res.get(j))){
                tempList.add(res.get(j));
                temMap.put(res.get(j), titlesHashMap.get(res.get(j)));
                res.remove(j);

            }else {
                break;
            }
        }

        if (tempList.size() != 0){
            res.remove(topN);
            tempList.add(temStr);
            temMap.put(temStr, titlesHashMap.get(temStr));
            Map<String, Integer> temMapSorted = temMap
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(comparingByValue()))
                    .collect(
                            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                    LinkedHashMap::new));
            for (int j = 0; j < topN; j++) {
            }

        }


        
        


    }
}
