package 数据结构与算法.算法系统练习.力扣;

/**
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 * <p>
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 */
public class 合并两个链表 {
  public static void main(String[] args) {
    ListNode list1 = new ListNode(0,
        new ListNode(1,
            new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5, null))))));
    ListNode list2 = new ListNode(1000000,
        new ListNode(1000001,
                new ListNode(1000002)));
    ListNode listNode = mergeInBetween(list1, 3, 4, list2);
    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }
  }

  public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode t1 = list1;
    for (int i = 0; i < a - 1; i++) {
      t1 = t1.next;
    }
    ListNode t2 = t1;
    for (int i = a; i <= b + 1; i++) {
      t2 = t2.next;
    }
    t1.next = list2;
    ListNode l1 = list2;
    while (l1.next != null) {
      l1 = l1.next;
    }
    l1.next = t2;
    return list1;
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
      return val  + "," + next;
    }
  }
}
