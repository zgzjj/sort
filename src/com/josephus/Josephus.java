package com.josephus;

//回溯算法
public class Josephus {
    public static int N = 20;
    public static int M = 5;//数到M就杀掉

    class Node {
        int val;//下标
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public void killNode() {
        Node header = new Node(1);//第一个节点
        Node x = header;//目前被点到的人
        for (int i = 2; i <= N; i++) {
            x = (x.next = new Node(i));
        }
        x.next = header;//头尾相接
        System.out.println("被杀掉的顺序为：");
        while (x != x.next) {
            //仍然还有两人，仍然报数杀掉
            for (int i = 1; i < M; i++) {
                x = x.next;
            }
            System.out.println(x.next.val + "被杀掉");
            x.next = x.next.next;
        }
        System.out.println("最后的幸存者是：" + x.val);
    }

    public static void main(String[] args) {
        Josephus josephus = new Josephus();
        josephus.killNode();
    }
}
