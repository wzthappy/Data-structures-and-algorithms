package 数据结构与算法.算法系统练习.面试算法;

import java.util.Arrays;

public class 冒泡排序 {
  public static void main(String[] args) {
    int[] a = {5, 9, 7, 4, 1, 3, 2, 8};
//    int[] a = {5, 2, 7, 4, 1, 3, 8, 9};
//    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    bubble_v2(a);
  }

  private static void bubble_v2(int[] a) {
    int n = a.length - 1;
    do {
      int last = 0; // 表示最后一次交换索引位置
      for (int i = 0; i < n; i++) {
        System.out.println("比较次数 " + (i + 1));
        if (a[i] > a[i + 1]) {
          swap(a, i, i + 1);
          last = i;
        }
      }
      n = last;
      System.out.println(Arrays.toString(a));
    } while (n != 0);
  }

  private static void bubble(int[] a) {
    for (int j = 0; j < a.length - 1; j++) {
      boolean swapped = false; // 是否发生了交换
      // 一轮冒泡
      for (int i = 0; i < a.length - j - 1; i++) {
        System.out.println("比较次数 " + (i + 1));
        if (a[i] > a[i + 1]) {
          swap(a, i, i + 1);
          swapped = true;
        }
      }
      System.out.println("第" + (j + 1) + "轮冒泡" + Arrays.toString(a));
      if (!swapped) {
        break;
      }
    }
  }

  public static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}
