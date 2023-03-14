package 数据结构与算法.算法系统练习.面试算法;

/**
 * 二分查找:
 *    1. 前提 -> 数组以排序 A
 *    2. 定义左边界L、右边界R，确定搜索访问，循环执行二分查找(3、4两步)
 *    3. 获取中间索引 M = Floor((L + R) / 2)
 *    4. 中间索引的值 A[M] 与待搜索的值 T 进行比较
 *         4.1 A[M] == T 表示找到，返回中间索引
 *         4.2 A[M] > T 中间值右侧的其他元素都大于T，无需比较，中间索引左边去找，M - 1 设置为右边界，重新查找
 *         4.3 A[M] < T 中间值左侧的其他元素都小于T，无须比较，中间索引右边去找，M + 1 设置为左边界，重新查找
 *    5. 当 L > R 时，表示没有找到，应结束循环
 */
public class 二分查找 {
  public static void main(String[] args) {
    int[] array = {1, 5, 8, 11, 19, 22, 31, 35, 40, 45, 48, 49, 50};
    int target = 48;
    int idx = binarySearch (array, target);
    System.out.println(idx);
    System.out.println("查询的次数: " + count);
  }

  static int count = 0; // 次数
  // 二分查找，找到返回元素索引，找不到返回 -1
  private static int binarySearch(int[] a, int t) {
    int l = 0, r = a.length - 1, m;
    while (l <= r) {
      count++;
//      m = (l + r) / 2;  // l / 2 + r / 2  ==> l + (- l / 2 + r / 2) ==> l + (r - l) / 2    避免数字溢出
//      m = l + (r - l) / 2;
      m = (l + r) >>> 1;  // 不会有溢出的情况， 而且效率更快
      if (a[m] == t) {
        return m;
      } else if (a[m] > t) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }
    return -1;
  }
}
