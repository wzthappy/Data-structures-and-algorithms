package 数据结构与算法.算法系统练习.练习.基础练习;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 问题描述
 *   输入A、B，输出A+B。
 *
 * 输入格式
 *   输入的第一行包括两个整数，由空格分隔，分别表示A、B。
 *
 * 输出格式
 *   输出一行，包括一个整数，表示A+B的值。
 *
 * 样例输入
 * 12 45
 *
 * 样例输出
 * 57
 */
public class A_B问题 {
  public static void main(String[] args) {
    AtomicInteger sum = new AtomicInteger();
    Arrays.stream(new Scanner(System.in).nextLine().split(" ")).forEach(i -> {
      sum.addAndGet(Integer.parseInt(i));
    });
    System.out.println(sum);
  }
}
