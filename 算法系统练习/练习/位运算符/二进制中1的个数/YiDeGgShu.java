package 数据结构与算法.算法系统练习.练习.位运算符.二进制中1的个数;

import java.util.Scanner;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 *    例: 9的二进制表示为1001，有2位是1
 */
public class YiDeGgShu {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    System.out.println(Integer.toString(N, 2)); // 展示他的二进制数
    int length = Integer.toString(N, 2).length();
    int count = 0;
    System.out.println("---------- <<左移的方式 ----------");
    for (int i = 0; i < length; i++) {  // 比对每一位
      if ((N & (1 << i)) == (1 << i)) {
        count++;
      }
    }
    System.out.println(count);
    System.out.println("---------- >>右移的方式 ----------");
    count = 0;
    for (int i = 0; i < length; i++) {
      if ((1 & (N >> i)) == 1) {
        count++;
      }
    }
    System.out.println(count);
    System.out.println("----------- (N - 1) & x 的方式 -----------");
    count = 0;
    while (N != 0) {
      N = (N - 1) & N;
      count++;
    }
    System.out.println(count);
  }
}
