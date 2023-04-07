package 数据结构与算法.算法系统练习.力扣;

import java.math.BigInteger;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 */
public class _7_整数反转 {
  public static void main(String[] args) {
    System.out.println(new _7_整数反转().reverse(153423646));
  }

  public int reverse(int x) {
    long n = 0;
    while (x != 0) {
      n = n * 10 + x % 10;
      x /= 10;
    }
    return (int) n == n ? (int) n : 0;
  }
}
