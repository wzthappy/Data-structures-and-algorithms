package 数据结构与算法.算法系统练习.练习.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　从键盘输入一个不超过8位的正的十六进制数字符串，将它转换为正的十进制数后输出。
 * 　　注：十六进制数中的10~15分别用大写的英文字母A、B、C、D、E、F表示。
 *
 * 样例输入
 * FFFF
 *
 * 样例输出
 * 65535
 */
public class 十六进制转十进制 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(Integer.parseInt(scanner.nextLine(), 16));
  }
}
