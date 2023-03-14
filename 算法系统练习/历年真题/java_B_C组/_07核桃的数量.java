package 数据结构与算法.算法系统练习.历年真题.java_B_C组;

import java.util.Scanner;

/**
 * 标题: 核桃的数量
 * <p>
 * 小张是软件项目经理，他带领3个开发组。工期紧，今天都在加班呢。为鼓舞士气，小张打算给每个组发一袋核桃(据传言能补脑)。
 * 他的要求是:
 * 1. 各组的核桃数量必须相同
 * 2. 各组内必须能平均核桃(当然是不能打碎的)
 * 3. 尽量通过满足1,2条件的最小数量(节约闹革命嘛)
 * <p>
 * 程序从标准输入读入:
 * a b c
 * a,b,c都是正整数，表示每个组正在加班的人数，用空格分开 (a,b,c<30)
 * <p>
 * 程序输出:
 * 一个正整数，表示每袋核桃的数量。
 * <p>
 * 例如:
 * 用户输入:
 * 2 4 5
 * <p>
 * 程序输出:
 * 20
 * <p>
 * 在例如:
 * 用户输入:
 * 3 1 1
 * <p>
 * 程序输出:
 * 3
 */
public class _07核桃的数量 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    String[] a = s.split(" ");
    int i1 = Integer.parseInt(a[0]);
    int i2 = Integer.parseInt(a[1]);
    int i3 = Integer.parseInt(a[2]);

    int b = 1;
    while (b % i1 != 0 || b % i2 != 0 || b % i3 != 0) {
      b++;
    }

    System.out.println(b);
  }
}
