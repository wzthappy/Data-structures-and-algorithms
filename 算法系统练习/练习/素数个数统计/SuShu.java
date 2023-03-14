package 数据结构与算法.算法系统练习.练习.素数个数统计;

import java.util.Arrays;

/**
 * 素数个数统计
 *  素数: 只能被1和自身整除的自然数，0、1除外
 *
 *  例如: 输入100   输出25
 */
public class SuShu {
  public static void main(String[] args) {
    System.out.println(bf (100));
    System.out.println(eratosthenes(100));
  }

  // 暴力算法
  public static int bf (int n) {
    int count = 0;
    for (int i = 2; i < n; i++) {
      count += isPrime(i) ? 1 : 0;
    }
    return count;
  }
  private static boolean isPrime(int x) {
    for (int i = 2; i * i <= x; i++) {
      if (x % i == 0) {
        return false;
      }
    }
    return true;
  }

  // 埃筛法 素数   非素数 -> 合数 -> 12 = 2 * 6   2,6就是这个数的因子
  public static int eratosthenes(int n) {
    boolean[] isPrime = new boolean[n];  // 标记  默认都是false   false代表素数
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (!isPrime[i]) { // 是素数
        count++;
        for (int j = i * i; j < n; j += i) { // j就是合数的标记位   2 * i    + i   => 2、3、4... * i
          isPrime[j] = true; // 改为true非素数
        }
      }
    }

    return count;
  }
}
