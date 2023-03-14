package 数据结构与算法.算法系统练习.练习.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200
 * 输入格式
 * 　　第一行为一个整数n。
 * 　　第二行包含n个整数，为待排序的数，每个整数的绝对值小于10000。
 * 输出格式
 * 　　输出一行，按从小到大的顺序输出排序后的数列。
 * 样例输入
 * 5
 * 8 3 6 4 9
 * 样例输出
 * 3 4 6 8 9
 */

public class 数列排序 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    if (!(n >= 1 && n <= 200)) {
      return;
    }
    String[] s = scanner.nextLine().split(" ");

    int insertVal;
    int insertIndex;
    for (int i = 0; i < s.length - 1; i++) {
      insertVal = Integer.parseInt(s[i + 1]);
      insertIndex = i;  // 即arr[i + 1]的前面这个数的下标
      while (insertIndex >= 0 && insertVal < Integer.parseInt(s[insertIndex])) {
        s[insertIndex + 1] = s[insertIndex];  // 后移
        insertIndex--;
      }
      if (insertIndex != i) {
        s[insertIndex + 1] = String.valueOf(insertVal);
      }
    }

    StringBuilder ss = new StringBuilder();
    for (String s1 : s) {
      ss.append(s1).append(" ");
    }
    System.out.println(ss);
  }
}
