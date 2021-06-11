package three;

import java.util.ArrayList;
import java.util.Scanner;

class Node{
    int state;
    int time;
    int a;
    int b;
    public Node(){};

    public Node(int state, int time, int a, int b) {
        this.state = state;
        this.time = time;
        this.a = a;
        this.b = b;
    }
}
public class Main {
    static int maxIncome;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            String[] s = scanner.nextLine().split(" ");
            int a = Integer.valueOf(s[1]);
            int b = Integer.valueOf(s[2]);
            Node node = new Node(Integer.valueOf(s[0]), Integer.valueOf(s[3]), a, b);
            nodes.add(node);

        }
        for (Node node : nodes) {
            maxIncome = Integer.MIN_VALUE;
            dfs(node.state, node.time, 0, node.a, node.b);
            System.out.println(maxIncome);
        }

    }

    private static void dfs(int state, int time, int curIncome, int a, int b) {
        if (time == 0){
            maxIncome = Math.max(maxIncome, curIncome);
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i == 1){
                curIncome += state;
                int tempState = state;
                state =  state - b < 0 ? 0 : state - b;
                time -= 1;
                dfs(state, time, curIncome, a, b);
                state = state + tempState;
                curIncome -= state;
                time += 1;

            }else {
                state += a;
                time -= 1;
                dfs(state, time, curIncome, a, b);
                time += 1;
                state -= a;
            }
        }
    }
}

