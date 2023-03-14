package 数据结构与算法.数据结构与算法_作业.单项链表;

public class Node {
    public Object data; // 存放结点数值
    public Node next; // 存放结点指针域

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}
