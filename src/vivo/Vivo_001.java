package vivo;

import java.util.Scanner;

/**
 * 单链表逆序
 */
public class Vivo_001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();//n个节点
            //构建n个节点的链表head->1->2->3->4->5->null;
            Node head = new Node();
            Node cur = head;
            for (int i = 0; i < n; i++) {
                cur.next = new Node(sc.nextInt());
                cur = cur.next;
            }
            show(head);
            reverse(head);
            show(head);
        }

        sc.close();
    }

    public static void reverse(Node head) {
        //如果链表中没有节点或只有一个节点直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        Node newFirstNode = head.next;//已完成逆序的节点,新链表的第一个节点
        Node nextNode = newFirstNode.next;//将要完成逆序的节点

        while (nextNode != null) {
            //...<-newFirstNode nextNode->next->...
            Node next = nextNode.next;//保存即将要逆序的节点的后续节点
            //...<-newFirst<-nextNode next->...
            nextNode.next = newFirstNode;
            newFirstNode = nextNode;
            nextNode = next;
        }

        //将原链表的第一个节点的尾节点置为null
        head.next.next = null;
        //将新链表的第一个节点连接到head节点后
        head.next = newFirstNode;
    }

    public static void show(Node head) {
        Node cur = head.next;
        System.out.print("head->");
        while (cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }
}

class Node {
    int data;
    Node next;

    Node() {

    }

    Node(int data) {
        this.data = data;
    }
}
