package 数据结构与算法.算法系统练习.力扣;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class 两数相加 {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(9, null);
    ListNode l2 = new ListNode(1, new ListNode(9,
        new ListNode(9, new ListNode(9,
            new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, null))))))))));
    ListNode newLN = addTwoNumbers(l1, l2);
    System.out.println(newLN);
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode k1 = l1, k2 = l2, h = l1;
    int i1 = 0, i1w = 1;
    int i2 = 0, i2w = 1;
    while (l1 != null) {
      i1 += l1.val * i1w;
      i1w = i1w * 10;
      if (l1.next == null) {
        break;
      }
      l1 = l1.next;
    }
    while (l2 != null) {
      i2 += l2.val * i2w;
      i2w = i2w * 10;
      l2 = l2.next;
    }
    int sum = i1 + i2;
    if (sum == 0) {
      return h;
    }
    l1.next = k2;
    int z;
    int i = 1;
    int s = sum;
    while (s != 0) {
      z = sum / i % 10;
      i = i * 10;
      s = s / 10;
      k1.val = z;
      if (s == 0) {
        k1.next = null;
        break;
      }
      k1 = k1.next;
    }
    return h;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      return val + ", " + next;
    }
  }
}
