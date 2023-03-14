package 数据结构与算法.算法系统练习.练习.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　给定一些字符串(只包含小写字母)，要求将他们串起来构成一个字典序最小的字符串。
 *
 * 输入格式
 * 　　第一行T,表示有T组数据。
 * 　　接下来T组数据
 * 　　每组第一行一个正整数n，表示字符串个数。
 * 　　接下来n行，每行一个字符串(长度不超过100)。
 * 输出格式
 * 　　T行，每行一个字符串。
 * 样例输入
 * 1
 * 3
 * a
 * b
 * c
 * 样例输出
 * abc
 * 数据规模和约定
 * 　　T<=7000，n<=100；
 */
public class 最小字符串 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = Integer.parseInt(scanner.nextLine());
    int n = Integer.parseInt(scanner.nextLine());
    char[] c = new char[n];
    for (int i = 0; i < n; i++) {
      c[i] = scanner.nextLine().charAt(0);
    }
    StringBuilder stringBuilder;
    for (int i = 0; i < T; i++) {
      stringBuilder = new StringBuilder();
      for (char c1 : c) {
        stringBuilder.append(c1);
      }
      System.out.println(stringBuilder);
    }
  }
}
