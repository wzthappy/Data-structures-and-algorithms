package 数据结构与算法.排序算法.O_nlogn.归并排序_73毫秒_递归;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MergetSort {
  public static void main(String[] args) {
//    int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};     // 8 -> merge 7次 .  80000 -> merge 79999次
//    int temp[] = new int[arr.length];  // 归并排序需要一个额外空间
//    mergeSort(arr, 0, arr.length - 1, temp);

    // O(nlog n)
//    排序前的时间是=2022-07-20 22:26:58 348
//    排序前的时间是=2022-07-20 22:26:58 421

    // 创建一个80000个随机数组
    int arr[] = new int[80000];
    for (int i = 0; i < 80000; i++) {
      arr[i] = (int) (Math.random() * 800000);  // 生成一个[0，800000) 数
    }
    int temp[] = new int[arr.length];

    Date date1 = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
    String date1Str = simpleDateFormat.format(date1);
    System.out.println("排序前的时间是=" + date1Str);

    // 测试选择排序
    mergeSort(arr, 0, arr.length - 1, temp);

    Date date2 = new Date();
    String date2Str = simpleDateFormat.format(date2);
    System.out.println("排序前的时间是=" + date2Str);

//    System.out.println("归并排序后=" + Arrays.toString(arr));
  }

  // 分 + 合方法
  public static void mergeSort(int[] arr, int left, int right, int[] temp) {
    if (left < right) {
      int mid = (left + right) / 2;  // 中间索引
      // 向左递归进行分解
      mergeSort(arr, left, mid, temp);
      // 向右递归分解
      mergeSort(arr, mid + 1, right, temp);    // 先会压入栈中，然后再依次出栈调用merge()


      // 到合并
      merge(arr, left, mid, right, temp);
    }
  }

  /**
   *   合并的方法
   * @param arr   排序的原始数组
   * @param left  左边有序列的初始索引
   * @param mid   中间索引
   * @param right 右边索引
   * @param temp  做中转的数组
   */
  public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
    int i = left;  // 初始化i，左边有序列的初始索引
    int j = mid + 1; // 初始化j，右边有序列的初始索引
    int t = 0;  // 指向temp数组的当前索引

    // (一)
    // 先把左右两边(有序)的数据按照规则填充到temp数组
    // 直到左右两边的有序列，有一边处理完毕为止
    while (i <= mid && j <= right) {  // 继续
      // 如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
      // 即将左边的当前元素，拷贝到 temp数组
      // 然后 t++，i++
      if (arr[i] <= arr[j]) {
        temp[t] = arr[i];
        t++;
        i++;
      } else { // 反之，将右边有序序列的当前元素，填充到temp数组
        temp[t] = arr[j];
        t++;
        j++;
      }
    }

    // (二)
    // 将把有剩余一边的数据依次全部填充到temp中
    // 只有一边会有剩余元素
    while (i <= mid) { // 左边的有序序列还有剩余的元素，就全部填充到temp
      temp[t] = arr[i];
      t++;
      i++;
    }
    while (j <= right) { // 左边的有序序列还有剩余的元素，就全部填充到temp
      temp[t] = arr[j];
      t++;
      j++;
    }

    // (三)
    // 将temp数组的元素拷贝到arr
    // 注意，并不是每次都要拷贝所有
    t = 0;
    int tempLeft = left;  // 第一次合并 tempLeft = 0，right = 1  // tempLeft = 2，right = 3 //  tL = 0，ri = 3
    // 最后一次   tempLeft = 0，right = 7
    while (tempLeft <= right) {
      arr[tempLeft] = temp[t];
      t++;
      tempLeft++;
    }
  }
}
