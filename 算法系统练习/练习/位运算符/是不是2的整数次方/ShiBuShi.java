package 数据结构与算法.算法系统练习.练习.位运算符.是不是2的整数次方;

import java.util.Scanner;

/**
 * 用一条语句判断一个整数是不是2的整数次方
 */
public class ShiBuShi {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int i = scanner.nextInt();
    System.out.println(Integer.toString(i, 2));

    if (((i - 1) & i) == 0) {
      System.out.println(i + "是2的整数次方");
    } else {
      System.out.println(i + "不是2的整数次方");
    }
  }
}
