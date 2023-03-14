package 数据结构与算法.算法系统练习.练习.递归.什么是递归;

public class TiGui {
  public static void main(String[] args) {
    f (10);
    System.out.println("------------------");
    System.out.println(f1(10));
    System.out.println("-----------------");
    f2(4, 9);
  }

  // 注意死循环
  static void f (int i) {
    System.out.println(i + "-----------------");
    if (i == 0) return;
    // 自己调用自己
    f (i - 1);
    System.out.println(i);
  }

  /**
   * f1(n):求n的阶乘 --> 那么 f1(n - 1) 就是求 n - 1 的阶乘
   * 找重复 n * (n -1) 的阶乘，  求 n - 1 的阶乘是问题的重复 (规模更小) -- 子问题
   * 找变化: 变化的量应该作为参数
   * 找边界: 出口
   */
  static int f1 (int n) {
    if (n == 1) return 1;

    return n * f1(n - 1);
  }

  /**
   * 打印 i ~ j
   */
  static void f2 (int i, int j) {
    if (i > j) return;
    System.out.println(i);
    f2(i + 1, j);
  }
}
