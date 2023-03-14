package 数据结构与算法.算法系统练习.面试算法;

import java.util.Arrays;

public class 选择排序 {
  public static void main(String[] args) {
    int[] a = {5, 3, 7, 2, 1, 9, 8, 4};
//    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    selection(a);
  }

  private static void selection(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      // i 代表每轮选择最小元素要交换到的目标索引
      int min = i; // 代表最小元素的索引
      for (int j = i + 1; j < a.length; j++) {
        if (a[min] > a[j]) {
          min = j;
        }
      }
      if (min != i) {
        swap(a, min, i);
      }
      System.out.println(Arrays.toString(a));
    }
  }

  private static void swap(int[] a, int min, int i) {
    int t = a[min];
    a[min] = a[i];
    a[i] = t;
  }
}
