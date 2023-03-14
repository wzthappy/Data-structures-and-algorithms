package 数据结构与算法.排序算法.O_nk.基数排序_83毫秒_不能负数;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RadixSort {
  public static void main(String[] args) {
//    int arr[] = {53, 3, 542, 748, 14, 214};
//    radixSort(arr);

    // O(n * k)
//    排序前的时间是=2022-07-21 13:24:55 054
//    排序前的时间是=2022-07-21 13:24:55 137

    // 创建一个80000个随机数组
    int arr[] = new int[80000];
    for (int i = 0; i < 80000; i++) {
      arr[i] = (int) (Math.random() * 800000);  // 生成一个[0，800000) 数
    }

    Date date1 = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
    String date1Str = simpleDateFormat.format(date1);
    System.out.println("排序前的时间是=" + date1Str);

    // 测试选择排序
    radixSort(arr);

    Date date2 = new Date();
    String date2Str = simpleDateFormat.format(date2);
    System.out.println("排序前的时间是=" + date2Str);
  }

  // 基数排序方法
  public static void radixSort(int[] arr) {

    int[][] bucket = new int[10][arr.length];
    // 为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次放入的个数
    // 可以这样理解
    // bucketElementCounts[0]，记录的就是 bucket[0] 桶的放入数据的个数
    int[] bucketElementCounts = new int[10];
    // 1. 得到数组中最大的位数
    int max = arr[0];  // 假设第一个数就是最大数
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    // 得到最大数是几位数
    int maxLength = String.valueOf(max).length();

    // 这里使用循环将代码处理
    for (int i = 0, n = 1 ; i < maxLength; i++, n *= 10) {
      // (针对每个元素的对应位进行排序处理)，第一次个位，第二次是十位，第三位是百位...
      for (int j = 0; j < arr.length; j++) {
        // 取出每个元素个位
        int digitOfElement = arr[j] / n  % 10;
        // 放入到对应的桶中
        bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
        bucketElementCounts[digitOfElement]++;
      }
      // 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
      int index = 0;
      // 遍历每一个桶，并将桶中的数据，放入到原来数组
      for (int k = 0; k < bucketElementCounts.length; k++) {
        // 如果桶中有数据，我们才放入到原数组
        if (bucketElementCounts[k] != 0) {
          // 循环该桶，即第k桶(即第k个一维数组)，放入
          for (int l = 0; l < bucketElementCounts[k]; l++) {
            // 取出元素放入到arr中
            arr[index] = bucket[k][l];
            index++;
          }
          // 第i+1轮后，需要将每个 bucketElementCounts[k] = 0 !!!
          bucketElementCounts[k] = 0;
        }
      }
//      System.out.println("第" + (i + 1) + "轮后=" + Arrays.toString(arr));
    }



    /*
    // 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
    // 说明
    // 1. 二维数组包含10个一维数组
    // 2. 为了防止放入数的时候，数据溢出，则每个一维数组(桶)，大小定位arr.length
    // 3. 很明显，基数排序是使用空间换时间的经典算法
    int[][] bucket = new int[10][arr.length];
    // 为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次放入的个数
    // 可以这样理解
    // bucketElementCounts[0]，记录的就是 bucket[0] 桶的放入数据的个数
    int[] bucketElementCounts = new int[10];

    // 第一轮(针对每个元素的个位进行排序处理)
    for (int j = 0; j < arr.length; j++) {
      // 取出每个元素个位
      int digitOfElement = arr[j] % 10;
      // 放入到对应的桶中
      bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
      bucketElementCounts[digitOfElement]++;
    }
    // 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
    int index = 0;
    // 遍历每一个桶，并将桶中的数据，放入到原来数组
    for (int k = 0; k < bucketElementCounts.length; k++) {
      // 如果桶中有数据，我们才放入到原数组
      if (bucketElementCounts[k] != 0) {
        // 循环该桶，即第k桶(即第k个一维数组)，放入
        for (int l = 0; l < bucketElementCounts[k]; l++) {
          // 取出元素放入到arr中
          arr[index] = bucket[k][l];
          index++;
        }
        // 第一轮后，需要将每个 bucketElementCounts[k] = 0 !!!
        bucketElementCounts[k] = 0;
      }
    }
    System.out.println("第一轮后=" + Arrays.toString(arr));  // [542, 53, 3, 14, 214, 748]

    System.out.println("===============================");

    // 第二轮(针对每个元素的个位进行排序处理)
    for (int j = 0; j < arr.length; j++) {
      // 取出每个元素个位
      int digitOfElement = arr[j] / 10 % 10;
      // 放入到对应的桶中
      bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
      bucketElementCounts[digitOfElement]++;
    }
    // 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
    index = 0;
    // 遍历每一个桶，并将桶中的数据，放入到原来数组
    for (int k = 0; k < bucketElementCounts.length; k++) {
      // 如果桶中有数据，我们才放入到原数组
      if (bucketElementCounts[k] != 0) {
        // 循环该桶，即第k桶(即第k个一维数组)，放入
        for (int l = 0; l < bucketElementCounts[k]; l++) {
          // 取出元素放入到arr中
          arr[index] = bucket[k][l];
          index++;
        }
        bucketElementCounts[k] = 0;
      }
    }
    System.out.println("第二轮后=" + Arrays.toString(arr));  // [3, 14, 214, 542, 748, 53]

    System.out.println("==========================");

    // 第三轮(针对每个元素的个位进行排序处理)
    for (int j = 0; j < arr.length; j++) {
      // 取出每个元素个位
      int digitOfElement = arr[j] / 100 % 10;
      // 放入到对应的桶中
      bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
      bucketElementCounts[digitOfElement]++;
    }
    // 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
    index = 0;
    // 遍历每一个桶，并将桶中的数据，放入到原来数组
    for (int k = 0; k < bucketElementCounts.length; k++) {
      // 如果桶中有数据，我们才放入到原数组
      if (bucketElementCounts[k] != 0) {
        // 循环该桶，即第k桶(即第k个一维数组)，放入
        for (int l = 0; l < bucketElementCounts[k]; l++) {
          // 取出元素放入到arr中
          arr[index] = bucket[k][l];
          index++;
        }
        bucketElementCounts[k] = 0;
      }
    }
    System.out.println("第三轮后=" + Arrays.toString(arr));  // [3, 14, 53, 214, 542, 748]
     */
  }
}
