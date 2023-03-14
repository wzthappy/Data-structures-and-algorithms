package 数据结构与算法.排序算法.O_n2.插入排序_700毫秒;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
  public static void main(String[] args) {
    int[] arr = {15,13,20,18,12,60};
//    insertSort(arr);
//    System.out.println(Arrays.toString(arr));


    // 插入排序时间复杂度是O(n^2)
//    排序前的时间是=2022-07-20 14:43:50
//    排序前的时间是=2022-07-20 14:43:51

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
    insertSort(arr);

    Date date2 = new Date();
    String date2Str = simpleDateFormat.format(date2);
    System.out.println("排序前的时间是=" + date2Str);
  }

  // 插入排序
  public static void insertSort(int[] arr) {
    int insertVal;
    int insertIndex;
    // 使用for循环来把代码简化
    for (int i = 0; i < arr.length - 1; i++) {
      // 定义待插入的数
      insertVal = arr[i + 1];
      insertIndex = i;  // 即arr[i + 1]的前面这个数的下标
      // 给insertVal 找到插入的位置
      // 说明
      // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
      // 2. insertVal < arr[insertIndex] 说明待插入的数，还没有找到插入的位置
      // 3. 就需要将 arr[insertIndex] 后移
      while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
        arr[insertIndex + 1] = arr[insertIndex];  // 后移
        insertIndex--;
      }
      // 当退出while循环时，说明插入的位置找到，insertIndex + 1
      // 这里我们判断是否需要赋值
      if (insertIndex != i) {
        arr[insertIndex + 1] = insertVal;
      }
      System.out.println(Arrays.toString(arr));
    }

    /*
    // 使用逐步推导的方式来解决
    // 第一轮 {101, 34, 119, 1}  =>  {34, 101, 119, 1}
    // 定义待插入的数
    int insertVal = arr[1];
    int insertIndex = 0;  // 即arr[1]的前面这个数的下标
    // 给insertVal 找到插入的位置
    // 说明
    // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
    // 2. insertVal < arr[insertIndex] 说明待插入的数，还没有找到插入的位置
    // 3. 就需要将 arr[insertIndex] 后移
    while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
      arr[insertIndex + 1] = arr[insertIndex];  // 后移
      insertIndex--;
    }
    // 当退出while循环时，说明插入的位置找到，insertIndex + 1
    arr[insertIndex + 1] = insertVal;
    System.out.println("第一轮插入");
    System.out.println(Arrays.toString(arr));

    // 第二轮
    // 定义待插入的数
    insertVal = arr[2];
    insertIndex = 1;  // 即arr[1]的前面这个数的下标
    // 给insertVal 找到插入的位置
    // 说明
    // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
    // 2. insertVal < arr[insertIndex] 说明待插入的数，还没有找到插入的位置
    // 3. 就需要将 arr[insertIndex] 后移
    while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
      arr[insertIndex + 1] = arr[insertIndex];  // 后移
      insertIndex--;
    }
    // 当退出while循环时，说明插入的位置找到，insertIndex + 1
    arr[insertIndex + 1] = insertVal;
    System.out.println("第二轮插入");
    System.out.println(Arrays.toString(arr));

    // 第三轮
    // 定义待插入的数
    insertVal = arr[3];
    insertIndex = 2;  // 即arr[1]的前面这个数的下标
    // 给insertVal 找到插入的位置
    // 说明
    // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
    // 2. insertVal < arr[insertIndex] 说明待插入的数，还没有找到插入的位置
    // 3. 就需要将 arr[insertIndex] 后移
    while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
      arr[insertIndex + 1] = arr[insertIndex];  // 后移
      insertIndex--;
    }
    // 当退出while循环时，说明插入的位置找到，insertIndex + 1
    arr[insertIndex + 1] = insertVal;
    System.out.println("第三轮插入");
    System.out.println(Arrays.toString(arr));
     */
  }
}
