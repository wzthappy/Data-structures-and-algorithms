package 数据结构与算法.排序算法.O_nlogn.希尔排序_交换法_7秒;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
  public static void main(String[] args) {
    int[] arr = {12, 2, 16, 30, 28, 10, 16, 20, 6, 18};
//    shellSort(arr);

//    排序前的时间是=2022-07-20 16:51:08
//    排序前的时间是=2022-07-20 16:51:15

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

  // 使用逐步推导的方式来编写希尔排序
  public static void shellSort(int[] arr) {
    // 希尔排序中的交换法， 效率不好
    int temp;
    int count = 0;
    for (int gap = arr.length / 2; gap > 0; gap /= 2) {
      // 因为第一轮排序，是将10个数据分成了5组
      for (int i = gap; i < arr.length; i++) {
        // 遍历各组中所有的元素(共gap组，每组有arr/gap元素)，步长gap
        for (int j = i - gap; j >= 0; j -= gap) {
          // 如果当前元素大于加上步长后的那个元素，说明需要交换
          if (arr[j] > arr[j + gap]) {
            temp = arr[j];
            arr[j] = arr[j + gap];
            arr[j + gap] = temp;
          }
//          else {  // 加上 65毫秒
//            break;
//          }
        }
      }
      System.out.println("希尔排序第" + (++count) + "轮后=" + Arrays.toString(arr));
    }

    /*
    int temp;
    // 希尔排序的第一轮排序
    // 因为第一轮排序，是将10个数据分成了5组
    for (int i = 5; i < arr.length; i++) {
      // 遍历各组中所有的元素(共5组，每组有2个元素)，步长5
      for (int j = i - 5; j >= 0; j -= 5) {
        // 如果当前元素大于加上步长后的那个元素，说明需要交换
        if (arr[j] > arr[j + 5]) {
          temp = arr[j];
          arr[j] = arr[j + 5];
          arr[j + 5] = temp;
        }
      }
    }
    System.out.println("希尔排序1轮后 = " + Arrays.toString(arr));  // [3, 5, 1, 6, 0, 8, 9, 4, 7, 2]

    // 希尔排序的第二轮排序
    // 因为第二轮排序，是将10个数据分成了5 / 2 = 2组
    for (int i = 2; i < arr.length; i++) {
      // 遍历各组中所有的元素(共2组，每组有5个元素)，步长2
      for (int j = i - 2; j >= 0; j -= 2) {
        // 如果当前元素大于加上步长后的那个元素，说明需要交换
        if (arr[j] > arr[j + 2]) {
          temp = arr[j];
          arr[j] = arr[j + 2];
          arr[j + 2] = temp;
        }
      }
    }
    System.out.println("希尔排序2轮后 = " + Arrays.toString(arr));  // [0, 2, 1, 4, 3, 5, 7, 6, 9, 8]


    // 希尔排序的第三轮排序
    // 因为第三轮排序，是将10个数据分成了2 / 2 = 1组
    for (int i = 1; i < arr.length; i++) {
      // 遍历各组中所有的元素(共1组，每组有10个元素)，步长1
      for (int j = i - 1; j >= 0; j -= 1) {
        // 如果当前元素大于加上步长后的那个元素，说明需要交换
        if (arr[j] > arr[j + 1]) {
          temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    System.out.println("希尔排序3轮后 = " + Arrays.toString(arr));  // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
     */
  }
}
