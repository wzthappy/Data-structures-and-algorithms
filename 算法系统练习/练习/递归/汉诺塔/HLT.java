package 数据结构与算法.算法系统练习.练习.递归.汉诺塔;

public class HLT {
  public static void main(String[] args) {
    printHanoiTowe(3, "A", "B", "C");
  }

  /**
   * 将N个盘子从source移动到target的路径的打印
   *
   * @param N    初始的N从小到大的盘子，N是最大编号
   * @param from 原始柱子
   * @param to   目标柱子
   * @param hell 辅助的柱子
   */
  static void printHanoiTowe(int N, String from, String to, String hell) {
    if (N == 1) {
      System.out.println("move " + N + "from " + from + "to " + to);
      return;
    }

    printHanoiTowe(N - 1, from, hell, to); // 先把前N-1个盘子挪到辅助空间上去
    System.out.println("move " + N + "from " + from + "to " + to); // N可以顺利到达target
    printHanoiTowe(N - 1, hell, to, from); // 让N-1从辅助空间问题到源空间上去
  }
}
