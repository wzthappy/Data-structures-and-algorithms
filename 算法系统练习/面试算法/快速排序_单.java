package 数据结构与算法.算法系统练习.面试算法;

import java.util.Arrays;

import static 数据结构与算法.算法系统练习.面试算法.冒泡排序.swap;

/**
 * 1. 单边循环快排
 * 1.1 选择最右元素作为基准点元素
 * 1.2 j 指针负责找到比基准点的元素，一旦找到则与 i 进行交换
 * 1.3 i 指针维护小于基准点元素的边界，也是每次交换的目标索引
 * 1.4 最后基准点与 i 交换，i 即为分区位置
 * <p>
 * 2. 双边循环快排
 * 2.1 选择最左元素为基准点元素
 * 2.2 j 指针负责从右向左找比基准点小的元素，i 指针负责从左向右找比基准点大的元素，一旦找到二者交换，直到 i, j 相交
 * 2.3 最后基准点与 i (此时 i 与 j 相等) 交换，i 即为分区位置
 */
public class 快速排序_单 {
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

  private static int partition (int[] a, int l, int h) {
    int pv = a[h]; // 基准点元素
    int i = l;
    for (int j = l; j < h; j++) {
      if (pv > a[j]) {
        if (i != j) {
          swap(a, i, j);
        }
        i++;
      }
    }
    if (i != h) {
      swap(a, i, h);
    }
    System.out.println(Arrays.toString(a) + " i = " + i);
    // 返回值代表了 基准点元素所在的正确索引，用他确定下一轮分区的边界
    return i;
  }
}
