package 数据结构与算法.算法系统练习.练习.链表翻转;

public class ReverseList {

  // 迭代 的方式  (链表翻转)
  public static ListNode iterate(ListNode head) {  // 第一个结点
    ListNode prev = null, next;
    ListNode curr = head;
    while (curr != null) {
      next = curr.next; // next指向下一个结点
      curr.next = prev; // 当前结点中的next赋值为上一个结点
      prev = curr;  // 保存上一个结点  还没有后移动结点
      curr = next; // 向后移
    }
    return prev;
  }

  // 递归 的方式  (链表翻转)
  public static ListNode recursion(ListNode head) {
    if (head == null || head.next == null) {
      return head;   // 最终结果
    }
    ListNode new_head = recursion(head.next); // 依次向后 递归

    head.next.next = head;  // 依次两两翻转
    head.next = null; // 前面的哪一个置为空

    return new_head; // 结束每次的递归循环
  }
}
