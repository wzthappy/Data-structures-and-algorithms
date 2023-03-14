package 数据结构与算法.查找算法.插值查找_优化_数组必须是有序的;

public class InsetValueSearch {
  public static void main(String[] args) {
    int[] arr = new int[100];
    for (int i = 0; i < 100; i++) {
      arr[i] = i + 1;
    }

    int index = insertValueSearch(arr, 0, arr.length - 1, 74);
    System.out.println("index=" + index);

    System.out.println("====================");

    int arr2[] = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
    int index2 = insertValueSearch(arr2, 0, arr2.length - 1, 89);
    System.out.println(index2);

//    System.out.println(Arrays.toString(arr));
  }

  /**
   *   编写插值查找
   *   说明: 插值查找算法，也要求数组是有序的
   * @param arr  数组
   * @param left  左边索引
   * @param right  右边索引
   * @param findVal  查找值
   * @return 如果找到，就返回对应的下标。 如果没有找到，就返回-1
   */
  static int count = 0;  // 统计查找的次数
  public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
    count++;
    // 注意: findVal < arr[0] || findVal > arr[arr.length - 1] 必须需要
    // 否则我们得到的 mid 可能越界
    if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {  // 没有找到
      return -1;
    }
    // 求出mid          就这里的公式不一样      自适应
    int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);

    int midVal = arr[mid];

    if (findVal > midVal) {  // 说明应该向右边递归
      return insertValueSearch(arr, mid + 1, right, findVal);
    } else if (findVal < midVal) {  // 说明应该向左边递归
      return insertValueSearch(arr, left, mid - 1, findVal);
    } else {  // 说明找到了
      System.out.println("查找了" + count + "次");
      return mid;
    }
  }
}
