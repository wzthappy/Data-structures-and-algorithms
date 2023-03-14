package 数据结构与算法.算法系统练习.历年真题._2013;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 标题: 幸运数
 * 幸运数是波兰数学家乌拉姆命名的，他采用与生成素数类似的"筛选"生成。
 * 首先从1开始她写出自然数1，2，3，4，5，6.....
 * <p>
 * 1 就是第一个幸运数。
 * 我们从2这个数开始，把所有序号能被2整除的项删除，变为:
 * 1 _ 3 _ 5 _ 7 _ 9 .....
 * 把它们握紧，重新记序，为:
 * 1 3 5 7 9 ....。 这时，3为第2个幸运数，然后把所有能被3整除的序号位置的数删除。
 * 注意，时序号位置，不是那个数本身能否被3整除!!删除的应该是5, 11, 17,....
 * 此时7为第3个幸运数，然后在删去序号位置能被7整除的(19,39,....)
 * 最后剩下的序号类似:
 * 1，3，7，9，13，15，21，25，31，33，37，43，49，51，63，67，69，73，75，79.....
 * <p>
 * 本题要求:
 * 输入两个正整数m,n。用空格分开(m < N < 1000 * 1000)
 * 程序输出 位于m和n之间的幸运数的个数(不包含m和n)。
 * <p>
 * 例如:
 * 用户输入:
 * 1 20
 * 程序输出:
 * 5
 */
public class _08幸运数 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    int[] a = new int[n]; // 存储数据的数组
    for (int i = 0; i < n; i++) {
      a[i] = 2 * i + 1;
    }
    // 把2的倍数 (位置) 删除了
    int l = 1; /// 幸运数的下标,a[] 是幸运数
    while (true) {
      int p = l + 1; // 数字向前挪动的坑位
      for (int i = l + 1; i < n; i++) {
        if (((i + 1) % a[l]) == 0) {

        } else {
          a[p] = a[i];
          p++;
        }
        if (a[i] > n) break;
      }
      l++;
      if (a[l] >= n)break;
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      if (a[i] >= n) break;
      if (a[i] > m) ans++;
    }
    System.out.println(ans);
  }
}
