package test1;

import java.util.LinkedList;
import java.util.List;

class Node{
    int val;
    Node node;
    Node next;
    public Node() {
    }
    public Node(int val){
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(6);
        int num = 6;

        Node newHead = remove(head, num);

        while (newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public static Node remove(Node head, int num){
        Node curNode = head;
        Node pre = new Node(-1);
        pre.next = curNode;
        while (curNode != null){
            if ((curNode.val == num)){
                pre.next = pre.next.next; //
            }
            pre = pre.next;
            curNode = curNode.next;
        }
        return head;
    }

}
