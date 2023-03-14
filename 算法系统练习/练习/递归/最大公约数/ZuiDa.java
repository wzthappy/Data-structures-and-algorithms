package 数据结构与算法.算法系统练习.练习.递归.最大公约数;

public class ZuiDa {
  public static void main(String[] args) {
    System.out.println(gcd(12, 9));
  }

  /**
   * m 和 n 的 最大公约数
   *    m % n = 0    n 就是m的最大公约数
   *
   *    m % n = k   k != 0
   *    n % k = f   f != 0
   *    k % f = 0   f 就是m的最大公约数
   */
  static int gcd (int m, int n) {
    if (n == 0) return m;

    return gcd(n, m % n);
  }
}
