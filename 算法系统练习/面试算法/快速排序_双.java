package 数据结构与算法.算法系统练习.面试算法;

import java.util.Arrays;

import static 数据结构与算法.算法系统练习.面试算法.冒泡排序.swap;

public class 快速排序_双 {
  public static void main(String[] args) {
    int[] a = {5, 3, 7, 2, 9, 8, 1, 4};
    quick(a, 0, a.length - 1);
  }

  public static void quick (int[] a, int l, int h) {
    if (l >= h) {
      return;
    }
    int p = partition(a, l, h); // p 索引值
    quick(a, l, p - 1); // 左边分区的范围确定
    quick(a, p + 1, h); // 右边分区的范围确定
  }

  private static int partition(int[] a, int l, int h) {
    int pv = a[l];
    int i = l;
    int j = h;
    while (i < j) {
      // j 从右找小的
      while (i < j && a[j] > pv) {
        j--;
      }
      // i 从左找大的
      while (i < j && a[i] <= pv){
        i++;
      }
      swap(a, i, j);
    }
    swap(a, l, j);
    System.out.println(Arrays.toString(a) + " j = " + j);
    return j;
  }
}
