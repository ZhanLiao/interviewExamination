package first;

import java.util.*;

/**
 * 美团第一道：网格，从左上角到右下角所需要的最少能量
 */

public class Main {
    static int minCost = Integer.MAX_VALUE;
    static Map<Node, ArrayList<Map<Node, Integer>>> infoMap;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String[] info = new String[5];
        infoMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            info = scanner.nextLine().split(" ");
            Node source = new Node(Integer.valueOf(info[0]), Integer.valueOf(info[1]));
            Node desNode = new Node(Integer.valueOf(info[2]), Integer.valueOf(info[3]));
            HashMap<Node, Integer> nodeIntegerHashMap = new HashMap<>();
            nodeIntegerHashMap.put(desNode, Integer.valueOf(info[4]));

            if (!infoMap.containsKey(source)){
                // 不存在map里面，直接新建一个存储目的节点的列表，将目的节点的map添加进去。
                ArrayList<Map<Node, Integer>> mapArrayList = new ArrayList<>();
                mapArrayList.add(nodeIntegerHashMap);
                infoMap.put(source, mapArrayList);
            }else {
                //已存在map里面的源节点，直接将目的节点和能量值添加到map里面。
                infoMap.get(source).add(nodeIntegerHashMap);
            }
        }
        Node cur = new Node(1, 1);
        ArrayList<Map<Node, Integer>> curDesList = infoMap.get(cur);
        Node target = new Node(n, m);
        int cost = 0;
        dfs(cur, curDesList, target, cost);
        System.out.println(minCost);
    }
    private static int getDesCost(Map<Node, Integer> nodeIntegerMap) {
        for (Map.Entry entry : nodeIntegerMap.entrySet()){
            return (int) entry.getValue();
        }
        return 0;
    }

    private static Node getDesNode(Map<Node, Integer> nodeIntegerMap) {

        for (Map.Entry entry : nodeIntegerMap.entrySet()){
            return (Node) entry.getKey();
        }
        return new Node();
    }

    private static void dfs(Node cur, ArrayList<Map<Node, Integer>> mapArrayList, Node target, int cost) {
        if (cur.equals(target)){
            minCost = Math.min(minCost, cost);
        }
        if (mapArrayList == null){
            return;
        }
        for (Map<Node, Integer> curDesMap : mapArrayList){
            //做出选择
            cost += getDesCost(curDesMap);
            // 下一层决策
            dfs(getDesNode(curDesMap), infoMap.get(getDesNode(curDesMap)), target, cost);
            cost -= getDesCost(curDesMap);
        }
    }
}
class Node{
    int x;
    int y;
    Node(){ }
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x &&
                y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

