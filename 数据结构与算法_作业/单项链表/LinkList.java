package 数据结构与算法.数据结构与算法_作业.单项链表;

import java.util.Scanner;

public class LinkList {
    private Node head; // 定义单链表的头指针

    // 初始化头结点
    public LinkList() {
        head = new Node();
    }

    // 构造长度为n的单列表
    public LinkList(int n) throws Exception {
        this();
        crete(n);
    }

    // 插入x作为链表表中第i个元素
    public void insert(int i, Object x) throws Exception {
        Node p = head;
        int j = -1;
        // 寻找第i个结点的前驱
        while (p != null && j < i - 1) {
            p = p.next;
            j++;
        }
        if (j > i - 1 || p == null) {
            throw new Exception("插入位置不合法!");
        }
        Node s = new Node(x);
        s.next = p.next;
        p.next = s;
    }

    // 头插入逆序单链表
    public void crete(int n) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            insert(length(), sc.next());
        }
        sc.close();
    }

    // 返回链表的长度
    public int length() {
        Node p = head.next;
        int length = 0;
        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }

    // 将链表制空
    public void clear() {
        head.data = null;
        head.next = null;
    }

    // 判断列表是否为空
    public boolean isEmpty() {
        return head.next == null;
    }

    // 读取并返回地i个位置的数据元素
    public Object get(int i) throws Exception {
        Node p = head.next;
        int j;
        // 从开始结点开始向后找，直到p指向第i个结点或者p为null
        for (j = 0; j < i && p != null; j++) {
            p = p.next;

        }
        if (j > i || p == null) {
            throw new Exception("找不到第i个元素");
        }
        return p.data;
    }

    // 移除单链表中第i 个元素
    public void remove(int i) throws Exception {
        Node p = head;
        int j = -1;
        while (p != null && j < i - 1) {
            p = p.next;
            j++;
        }
        if (j > i - 1 || p.next == null) {
            throw new Exception("删除位置不合法!");
        }
        p.next = p.next.next;

    }

    // 返回元素x首次出现的位序号
    public int indexOf(Object x) {
        Node p = head.next;
        int j = 0;
        while (p != null && !p.data.equals(x)) {
            p = p.next;
            j++;
        }
        if (p != null) {
            return j;
        } else {
            return -1;
        }
    }

    // 打印单链表
    public void display() {
        Node p = head.next;
        while (p != null) {
            System.out.print(p.data + "   ");
            p = p.next;
        }
    }
}
