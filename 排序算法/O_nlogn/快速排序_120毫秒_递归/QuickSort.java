package 数据结构与算法.排序算法.O_nlogn.快速排序_120毫秒_递归;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
  public static void main(String[] args) {
    int[] arr = {12, 2, 16, 30, 28, 10, 16, 20, 6, 18};
//    quickSort(arr, 0, arr.length - 1);
//    System.out.println(Arrays.toString(arr));


//    排序前的时间是=2022-07-20 20:24:39 751
//    排序前的时间是=2022-07-20 20:24:39 871

    // 创建一个80000个随机数组
//    int arr[] = new int[80000];
//    for (int i = 0; i < 80000; i++) {
//      arr[i] = (int) (Math.random() * 800000);  // 生成一个[0，800000) 数
//    }

    Date date1 = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
    String date1Str = simpleDateFormat.format(date1);
    System.out.println("排序前的时间是=" + date1Str);

    // 测试选择排序
    quickSort(arr, 0, arr.length -1);

    Date date2 = new Date();
    String date2Str = simpleDateFormat.format(date2);
    System.out.println("排序前的时间是=" + date2Str);
  }

  public static void quickSort(int[] arr, int left, int right) {
    int l = left; // 左下标
    int r = right;  // 右下标
    // pivot 中轴值
    int pivot = arr[(left + right) / 2];
    int temp = 0;  // 临时变量，作为交换时使用
    // while 循环的目的是让比pivot 值小的放在左边
    // 比pivot 值大的放在右边
    while (l < r) {
      // 在pivot的左边一直找，直到找到大于等于pivot值，才退出
      while (arr[l] < pivot) {
        l += 1;
      }
      // 在pivot的右边一直找，直到找到小于等于pivot值，才退出
      while (arr[r] > pivot) {
        r -= 1;
      }
      // 如果l >= r 声明pivot 的左右两边的值，已经按照左边全是小于等于pivot的值
      //                                        右边全是大于等于pivot的值
      if (l >= r) {
        break;
      }

      // 直到两个都找到  就交换
      temp = arr[l];
      arr[l] = arr[r];
      arr[r] = temp;


      // 如果交换完后，发现这个arr[l] == pivot值 相等。 就 r-- 前移
      if (arr[l] == pivot) {
        r -= 1;
      }

      // 如果交换完后，发现这个arr[r] == pivot值 相等。 就 l++ 后移
      if (arr[r] == pivot) {
        l += 1;
      }
    }
    // 如果 l == r， 必须l++，r--，否则会出现栈溢出
    if (l == r) {
      l += 1;
      r -= 1;
    }

    System.out.println(Arrays.toString(arr));

    // 向左递归
    if (left < r) {
      quickSort(arr, left, r);
    }
    // 向右递归
    if (right > l) {
      quickSort(arr, l, right);
    }
  }
}
