package 数据结构与算法.排序算法.O_n2.选择排序_3秒;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
  public static void main(String[] args) {
        int[] arr = {12,2,16,30,28,10,16,20,6,18};
//    System.out.println("排序前");
//    System.out.println(Arrays.toString(arr));
//
//    selectSort(arr);
//
//    System.out.println("排序后");
//    System.out.println(Arrays.toString(arr));

    // 选择排序时间复杂度是O(n^2)
//    排序前的时间是=2022-07-20 13:17:23
//    排序前的时间是=2022-07-20 13:17:26

    // 创建一个80000个随机数组
//    int arr[] = new int[80000];
//    for (int i = 0; i < 80000; i++) {
//      arr[i] = (int) (Math.random() * 800000);  // 生成一个[0，800000) 数
//    }

    Date date1 = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String date1Str = simpleDateFormat.format(date1);
    System.out.println("排序前的时间是=" + date1Str);

    // 测试选择排序
    selectSort(arr);

    Date date2 = new Date();
    String date2Str = simpleDateFormat.format(date2);
    System.out.println("排序前的时间是=" + date2Str);
  }

  // 选择排序
  public static void selectSort(int[] arr) {
    int minIndex;
    int min;
    for (int i = 0; i < arr.length - 1; i++) {
      minIndex = i;
      min = arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        if (min > arr[j]) {  // 说明假定的最小值，并不是最小
          min = arr[j];  // 重置min
          minIndex = j;  // 重置minIndex
        }
      }
      // 将最小值，放在arr[0]，即交换
      if (minIndex != i) {
        arr[minIndex] = arr[i];
        arr[i] = min;
      }
      System.out.println(Arrays.toString(arr));
    }

    /*
    // 算法 先简单 --> 在复杂，就是可以把一个复杂的算法，拆分成简单的问题 -> 逐步解决
    // 使用逐步推导的方式来讲解排序
    // 原始的数组:  101，34，119，1
    // 第一轮排序:   1，34，119，101

    // 第一轮
    int minIndex = 0;
    int min = arr[0];
    for (int j = 1; j < arr.length; j++) {
      if (min > arr[j]) {  // 说明假定的最小值，并不是最小
        min = arr[j];  // 重置min
        minIndex = j;  // 重置minIndex
      }
    }
    // 将最小值，放在arr[0]，即交换
    if (minIndex != 0) {
      arr[minIndex] = arr[0];
      arr[0] = min;
    }

    System.out.println("第一轮~~");
    System.out.println(Arrays.toString(arr));  // [1, 34, 119, 101]

    // 第二轮
    minIndex = 1;
    min = arr[1];
    for (int j = 2; j < arr.length; j++) {
      if (min > arr[j]) {  // 说明假定的最小值，并不是最小
        min = arr[j];  // 重置min
        minIndex = j;  // 重置minIndex

      }
    }
    // 将最小值，放在arr[1]，即交换
    if (minIndex != 1) {
      arr[minIndex] = arr[0];
      arr[0] = min;
    }
    System.out.println("第二轮~~");
    System.out.println(Arrays.toString(arr));  // [1, 34, 119, 101]

    // 第三轮
    minIndex = 2;
    min = arr[2];
    for (int j = 3; j < arr.length; j++) {
      if (min > arr[j]) {  // 说明假定的最小值，并不是最小
        min = arr[j];  // 重置min
        minIndex = j;  // 重置minIndex

      }
    }
    // 将最小值，放在arr[0]，即交换
    if (minIndex != 2) {
      arr[minIndex] = arr[2];
      arr[2] = min;
    }
    System.out.println("第三轮~~");
    System.out.println(Arrays.toString(arr));  // [1, 34, 101, 119]
     */
  }
}
