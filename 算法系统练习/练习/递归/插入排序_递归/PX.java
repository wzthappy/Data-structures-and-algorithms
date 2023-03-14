package 数据结构与算法.算法系统练习.练习.递归.插入排序_递归;

import java.util.Arrays;

public class PX {
  public static void main(String[] args) {
    int[] arr = {23, 12, 45, 1, 0, -12, 444, -2, 1};
    insertSort(arr, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  static void insertSort(int[] arr, int k) {
    if (k == 0) {
      return;
    }
    // 对前k - 1个元素排序
    insertSort(arr, k - 1);
    // 把位置k的元素插入到前面的部分
    int x = arr[k];
    int index = k - 1;
    while (index > -1 && x < arr[index]) {
      arr[index + 1] = arr[index];
      index--;
    }
    arr[index + 1] = x;
  }
}
