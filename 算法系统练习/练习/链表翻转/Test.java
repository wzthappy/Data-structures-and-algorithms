package 数据结构与算法.算法系统练习.练习.链表翻转;

public class Test {
  public static void main(String[] args) {
    //           伪代码
    ListNode node5 = new ListNode(5, null);
    ListNode node4 = new ListNode(4, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode node1 = new ListNode(1, node2);  // 第一个结点  没有定义头结点

    // 使用断点的方式查看  (迭代的方式)
    ListNode prev = ReverseList.iterate(node1);
    System.out.println(prev);


    // (迭代的方式)
    ListNode prev2 = ReverseList.recursion(node1);
    System.out.println(prev2);
  }
}
