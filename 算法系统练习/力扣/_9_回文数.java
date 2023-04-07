package 数据结构与算法.算法系统练习.力扣;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 提示：
 * -231 <= x <= 231 - 1
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 */
public class _9_回文数 {
  public static void main(String[] args) {
    System.out.println(new _9_回文数().isPalindrome2(9121));
  }
  public boolean isPalindrome(int x) {
    String s = new StringBuilder(x + "").reverse().toString();
    return s.equals(String.valueOf(x));
  }
  public boolean isPalindrome2(int x) {
    if (x < 0) {
      return false;
    }
    int z = x;
    int n = 0;
    while (x != 0) {
      n = n * 10 + x % 10;
      x /= 10;
    }
    return n == z;
  }
}
