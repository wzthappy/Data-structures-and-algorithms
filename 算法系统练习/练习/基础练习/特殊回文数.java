package 数据结构与算法.算法系统练习.练习.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　123321是一个非常特殊的数，它从左边读和从右边读是一样的。
 * 　　输入一个正整数n， 编程求所有这样的 五位和六位 十进制数，满足各位数字之和等于n 。
 * 输入格式
 * 　　输入一行，包含一个正整数n。
 * 输出格式
 * 　　按从小到大的顺序输出满足条件的整数，每个整数占一行。
 * <p>
 * 样例输入
 * 52
 * 样例输出
 * 899998
 * 989989
 * 998899
 * <p>
 * 数据规模和约定
 * 　　1<=n<=54。
 */
public class 特殊回文数 {
  public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();
    for (int i1 = 1; i1 <= 9; i1++) {
      for (int i2 = 0; i2 <= 9; i2++) {
        for (int i3 = 0; i3 <= 9; i3++) {
          for (int i4 = 0; i4 <= 9; i4++) {
            for (int i5 = 0; i5 <= 9; i5++) {
              extracted(n, i1, i2, i3, i4, i5, 0, 5);

            }
          }
        }
      }
    }
    for (int i1 = 1; i1 <= 9; i1++) {
      for (int i2 = 0; i2 <= 9; i2++) {
        for (int i3 = 0; i3 <= 9; i3++) {
          for (int i4 = 0; i4 <= 9; i4++) {
            for (int i5 = 0; i5 <= 9; i5++) {
              for (int i6 = 0; i6 <= 9; i6++) {

                extracted(n, i1, i2, i3, i4, i5, i6, 6);

              }
            }
          }
        }
      }
    }
  }

  private static void extracted(int n, int i1, int i2, int i3, int i4, int i5, int i6, int innn) {
    StringBuilder str = new StringBuilder();
    if (innn == 6) {
      str.append(i1).append(i2).append(i3).append(i4).append(i5).append(i6);
    } else {
      str.append(i1).append(i2).append(i3).append(i4).append(i5);
    }

    String s = str.toString();
    int length = s.length();
    boolean flag = true;
    for (int i = 0; i < length; i++) {
      if (s.charAt(i) != s.charAt(length - i - 1)) {
        flag = false;
        break;
      }
    }
    if (flag) {
      int z = 0;
      for (int i = 0; i < s.length(); i++) {
        z += s.charAt(i) - '0';
      }
      if (z == n) {
        System.out.println(s);
      }
    }
  }
}
