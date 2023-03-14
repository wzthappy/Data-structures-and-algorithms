package 数据结构与算法.算法系统练习.历年真题._2014;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述：
 * 有n个小朋友围坐成一圈。老师给每个小朋友 随机发 偶数 个糖果 ，然后进行下面的游戏：
 * 每个小朋友都 把自己的糖果分一半给左手边的孩子。
 * 一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。
 * 反复进行这个游戏，直到所有小朋友的糖果数都相同为止。
 * 你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。
 * 【格式要求】
 * 程序首先读入一个整数N(2<N<100)，表示小朋友的人数。
 * 接着是一行用空格分开的N个偶数（每个偶数不大于1000，不小于2）
 * 要求程序输出一个整数，表示老师需要补发的糖果数。
 * 例如：输入
 * 3
 * 2 2 4
 * 程序应该输出：
 * 4
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗 < 1000ms
 */
public class _08分糖果 {
  public static void main(String[] args) {
//    test1();
    test2();
  }

  private static void test2() {
    Scanner sc = new Scanner(System.in);
    Integer n = Integer.parseInt(sc.nextLine());
    String[] s1 = sc.nextLine().split(" ");
    Integer[] a = new Integer[n];

    for (int i = 0; i < s1.length; i++) {
      a[i] = Integer.parseInt(s1[i]);
    }
    int ans = 0;
    while (true) {
      int t = a[0];
      for (int i = 0; i <= n - 2; i++) {
        a[i] -= a[i] / 2;
        a[i] += a[i + 1] / 2;
        if ((a[i] & 1) == 1) {
          ans++;
          a[i]++;
        }
      }

      a[n - 1] -= a[n - 1] / 2;
      a[n - 1] += t / 2;
      if ((a[n - 1] & 1) == 1) {
        ans++;
        a[n - 1]++;
      }
      if (check(a, n)) {
        System.out.println(ans);
        return;
      }
    }
  }

  private static boolean check(Integer[] a, int n) {
    int t = a[0];
    for (int i = 1; i < n; i++) {
      if (a[i] != t) return false;
    }
    return true;
  }

  private static void test1() {
    Scanner sc = new Scanner(System.in);
    Integer s = Integer.parseInt(sc.nextLine());
    String[] s1 = sc.nextLine().split(" ");
    Integer[] ints = new Integer[s];

    for (int i = 0; i < s1.length; i++) {
      ints[i] = Integer.parseInt(s1[i]);
    }

    f(s, ints);
  }

  static Integer count = 0;

  private static void f(Integer s, Integer[] ints) {
    int[] fs = new int[s];
    for (int i = 0; i < ints.length - 1; i++) {
      int f = ints[i] / 2;
      ints[i] -= f;
      fs[i + 1] = f;
    }
    fs[0] = ints[s - 1] / 2;
    ints[s - 1] /= 2;

    for (int i = 0; i < ints.length; i++) {
      ints[i] += fs[i];
    }

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < ints.length; i++) { // 补糖果 / 判断孩子手上的糖果是否都一样了

      set.add(ints[i]); // 在补糖果之前添加

      if (ints[i] % 2 != 0) { // 这个数字不是偶数
        ints[i] += 1;
        count++;
      }
    }

    if (set.size() == 1) {
      System.out.println(count);
      return;
    }

    f(s, ints);
  }
}
