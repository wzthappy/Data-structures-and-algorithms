package 数据结构与算法.算法系统练习.历年真题._2014;

import java.util.Scanner;

/**
 * 题目描述：
 * 小明先把硬币摆成了一个 n 行 m 列的矩阵。
 * 随后，小明对每一个硬币分别进行一次 Q 操作。
 * 对第x行第y列的硬币进行 Q 操作的定义：将所有第 ix 行，第 jy 列的硬币进行翻转。
 * 其中i和j为任意使操作可行的正整数，行号和列号都是从1开始。
 * 当小明对所有硬币都进行了一次 Q 操作后，他发现了一个奇迹——所有硬币均为正面朝上。
 * 小明想知道最开始有多少枚硬币是反面朝上的。于是，他向他的好朋友小M寻求帮助。
 * 聪明的小M告诉小明，只需要对所有硬币再进行一次Q操作，即可恢复到最开始的状态。然而小明很懒，不愿意照做。
 *     于是小明希望你给出他更好的方法。帮他计算出答案。
 * 【数据格式】
 * 输入数据包含一行，两个正整数 n m，含义见题目描述。
 * 输出一个正整数，表示最开始有多少枚硬币是反面朝上的。
 * 【样例输入】
 * 2 3
 * 【样例输出】
 * 1
 * 【数据规模】
 * 对于10%的数据，n、m <= 10^3；
 * 对于20%的数据，n、m <= 10^7；
 * 对于40%的数据，n、m <= 10^15；
 * 对于100%的数据，n、m <= 10^1000（10的1000次方）。
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗 < 2000ms
 */
public class _10矩阵翻硬币 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] s = sc.nextLine().split(" ");
    int n = Integer.parseInt(s[0]);
    int m = Integer.parseInt(s[1]);
    int[][] a = new int[n][m];

    for (int x = 0; x < a.length; x++) {
      for (int y = 0; y < a[0].length; y++) {
        System.out.print(a[x][y] + "\t");
      }
      System.out.println();
    }


  }
}
