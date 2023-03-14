package 数据结构与算法.算法系统练习.练习.递归.递归基础练习;

import java.util.Arrays;

public class LX {
  public static void main(String[] args) {
    int[] arr = {2, 5, 2, 5, 7, 8, 233, 34};
    System.out.println(Arrays.stream(arr).sum());
    System.out.println(f3(arr, 0));

    System.out.println(reverse("123456", 0));
  }

  /**
   * 数组求和:
   *    找重复、找变化、找边界
   */
  static int f3 (int[] arr, int begin) {
    if (begin == arr.length - 1) return arr[begin];
    return arr[begin] + f3 (arr, begin + 1);
  }

  /**
   * 翻转字符串
   */
  static String reverse (String str, int i) {
    if (i == str.length() - 1) {
      return str.charAt(i) + "";
    }
    return reverse(str, i + 1) + str.charAt(i);
  }
}
