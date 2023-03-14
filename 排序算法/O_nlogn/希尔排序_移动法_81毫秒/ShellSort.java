package 数据结构与算法.排序算法.O_nlogn.希尔排序_移动法_81毫秒;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
  public static void main(String[] args) {
    int[] arr = {15,13,20,18,12,60};
//    shellSort(arr);

//    排序前的时间是=2022-07-20 22:32:07 751
//    排序前的时间是=2022-07-20 22:32:07 832


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
    shellSort(arr);

    Date date2 = new Date();
    String date2Str = simpleDateFormat.format(date2);
    System.out.println("排序前的时间是=" + date2Str);
  }

  // 对交换式的希尔排序进行优化 -> 移位法
  public static void shellSort(int[] arr) {
    // O(nlog2(n))
    // 增量gap，并逐步的缩小增量
    for (int gap = arr.length / 2; gap > 0; gap /= 2) {
      // 从第gap个元素，逐个对其所在的组进行  直接  插入排序
      for (int i = gap; i < arr.length; i++) {
        int j = i;
        int temp = arr[j];
        if (arr[j] < arr[j - gap]) {
          while (j - gap >= 0 && temp < arr[j - gap]) {
            // 移动
            arr[j] = arr[j - gap];
            j -= gap;
          }
          // 当退出while后，就给temp找到插入的位置
          arr[j] = temp;
        }
      }
      System.out.println(Arrays.toString(arr));
    }
  }
}
