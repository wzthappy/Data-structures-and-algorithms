package 数据结构与算法.算法系统练习.练习.基础练习;

/**
 * 问题描述
 * 　　153是一个非常特殊的数，它等于它的每位数字的立方和，即153=1*1*1+5*5*5+3*3*3。编程求所有满足这种条件的三位十进制数。
 * 输出格式
 * 　　按从小到大的顺序输出满足条件的三位十进制数，每个数占一行。
 */
public class 特殊的数字 {
  public static void main(String[] args) {
    int i1;
    int i2;
    int i3;
    for (int i = 100; i < 1000; i++) {
      i1 = i / 100;
      i2 = i / 10 % 10;
      i3 = i % 10;
      if (i == i1 * i1 * i1 + i2 * i2 * i2 + i3 * i3 * i3) {
        System.out.println(i);
      }
    }
  }
}
