package examination0603;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description: 小强现在有个物品,每个物品有两种属性x 和 y.
 *               他想要从中挑出尽可能多的物品满足以下条件:
 *               对于任意两个物品,满足x,y要么都小于，要不都大于.问最多能挑出多少物品.
 * @Date: 2021/6/3 11:07
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            int m = scanner.nextInt();
            Node[] nodes = new Node[m];
            scanner.nextLine();
            String[] x = scanner.nextLine().split(" ");
            String[] y = scanner.nextLine().split(" ");

            for(int j = 0; j < m; j++){
                Node node = new Node(Integer.valueOf(x[j]), Integer.valueOf(y[j]));
                nodes[j] = node;

            }
            int ans = countSubSet(nodes);
            System.out.println(ans);
        }
    }

    private static int countSubSet(Node[] nodes) {
        Arrays.sort(nodes);
        Node temp = nodes[0];
        ArrayList<Node> list = new ArrayList<>();
        list.add(temp);
        for (int i = 1; i < nodes.length; i++) {
            if (temp.y < nodes[i].y){
                list.add(nodes[i]);
                temp = nodes[i];
            }
        }
        return list.size();
    }

    private static boolean isLegal(Node node, Node node1) {
        if ((node.x > node1.x && node.y > node1.y) || (node.x < node1.x && node.y < node1.y)){
            return true;
        }
        return false;
    }
}
class Node implements Comparable<Node>{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Node o) {
        if (o.x > this.x){
            return -1;
        }
        if (o.x < this.x){
            return 1;
        }
        return 0;
    }
}
