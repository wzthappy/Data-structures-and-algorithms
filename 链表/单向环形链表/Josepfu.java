package 数据结构与算法.链表.单向环形链表;

/**
 * 约瑟夫问题:
 *    设编号为1，2，...n的n个人围坐一圈，约定编号为k(1<=k<=n)的人从1开始报数，数到m的那个人出列，
 *    他的下一位又从1开始报数，数到m的那个人又出列，以此类推，直到所有人出列为止，由此产生一个出列编号的队列
 *
 *    n = 5; 既有5个人
 *    k = 1; 从第一个人开始报数
 *    m = 2; 数2下
 */
public class Josepfu {
  public static void main(String[] args) {
    // 测试，看看构建环形链表，和遍历是否正确
    CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
    circleSingleLinkedList.addBoy(5);  // 加入5个小孩节点
    circleSingleLinkedList.showBoy();
    System.out.println("----------------------");
    // 参数小孩出圈是否正确            从第几个谁开始   每次数几下  有多少个小孩在圈中
    circleSingleLinkedList.countBoy(1, 2, 5);
  }
}
