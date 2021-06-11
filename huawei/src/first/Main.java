package first;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  s = scanner.nextLine();
        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) != ')'){
                stack.push(s.charAt(i));
            }else {
                List<Character> list = new ArrayList<>();
                while(true){
                    char t = stack.pop();
                    if(t == '('){
                        break;
                    }
                    list.add(t);
                }
                for (char c : list){
                    stack.push(c);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.insert(0, stack.pop());
        }
        System.out.println(stringBuilder.toString());
    }
}
