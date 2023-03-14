package 数据结构与算法.算法系统练习.历年真题._2013;

import java.util.Scanner;

/**
 * 100 可以表示为带分数的形式：100 = 3 + 69258 / 714
 * 还可以表示为：100 = 82 + 3546 / 197
 * 注意特征：带分数中，数字 1∼9
 * 分别出现且只出现一次（不包含 0）。
 * 类似这样的带分数，100有 11种表示法。
 * 输入格式
 * 一个正整数。
 * 输出格式
 * 输出输入数字用数码 1∼9
 * 不重复不遗漏地组成带分数表示的全部种数。
 * 数据范围
 * 1≤N<106
 * 输入样例1：
 * 100
 * 输出样例1：
 * 11
 * 输入样例2：
 * 105
 * 输出样例2：
 * 6
 */
public class _09带分数 {
  static int N;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    f(arr, 0);
    System.out.println(ans);
  }


  static int ans;

  // 确认某一个排列的第k位
  private static void f(int[] arr, int k) {
    if (k == arr.length) {
      // 全部确认
      check(arr);
      return;
//      System.out.println(Arrays.toString(arr));
    }

    // 选定第k位
    for (int i = k; i < arr.length; i++) {
      // 将第i位和第k位交换
      int t = arr[i];
      arr[i] = arr[k];
      arr[k] = t;

      // 移交下一层去确认k+1位
      f(arr, k + 1);

      // 回溯(换回来)
      t = arr[i];
      arr[i] = arr[k];
      arr[k] = t;
    }
  }

  /**
   * 枚举加号和除号的位置
   */
  private static void check(int[] arr) {
    // + 前的字符数最多是7
    for (int i = 1; i <= 7; i++) {
      // 如果此时+号的数额已经超过了N，没必要验算了
      int num1 = toInt(arr, 0, i); // +前面的整数
      if (num1 >= N) {
        continue;
      }
      // / 前面的字符数最多是
      for (int j = 1; j <= 8 - i; j++) {
        int num2 = toInt(arr, i, j);
        int num3 = toInt(arr, i + j, 9 - i - j);
        if (num2 % num3 == 0 && num1 + num2 / num3 == N) {
          ans++;
        }
      }
    }
  }

  private static int toInt(int[] arr, int pos, int len) {
    int t = 1;
    int ans = 0;
    for (int i = pos + len - 1; i >= pos; i--) {
      ans += arr[i] * t;
      t *= 10;
    }
    return ans;
  }


}
