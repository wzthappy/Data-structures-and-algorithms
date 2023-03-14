package 数据结构与算法.算法系统练习.历年真题.java_B_C组;

/**
 * 标题: 第39级台阶
 *
 * 小明刚刚看完电影《第39级台阶》，离开电影院的时候，他数了数礼堂前的台阶数，恰好是39级！
 *
 * 站在台阶前，他突然又想着一个问题:
 * 如果我每一步只迈上1个或2个台阶。先迈左脚，如何左右交替，最后一步是迈右脚，也就是说一共要走偶数步。
 * 那么，上完39级台阶，有多少种不同的上法呢？
 */
public class _04第39级台阶 {
  public static void main(String[] args) {
    f (39, 0);
    System.out.println(ans);
  }
  static int ans = 0;

  // n -> 剩下的台阶       step -> 已走的步数
  private static void f(int n, int step) {
    if (n < 0) {
      return;
    }
    if (n == 0 && step % 2 == 0) {
      ans++;
      return;
    }
    f(n - 1, step + 1);
    f(n - 2, step + 1);
  }
}
