package 数据结构与算法.算法系统练习.面试算法;

import java.util.Arrays;

public class 插入排序 {
  public static void main(String[] args) {
    int[] a = {9, 3, 7, 2, 5, 8, 1, 4};
    insert(a);
  }

  private static void insert(int[] a) {
    // i 代表待插入元素的索引
    for (int i = 1; i < a.length; i++) {
      int t = a[i]; // 代表待插入的元素值
      int j = i - 1; // 代表已排序区域的元素索引
      while (j >= 0) {
        if (t < a[j]) {
          a[j + 1] = a[j];
        } else {
          break; // 退出循环，减少比较次数
        }
        j--;
      }
      a[j + 1] = t;
      System.out.println(Arrays.toString(a));
    }
  }
}
