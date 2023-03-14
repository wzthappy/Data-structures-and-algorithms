package 数据结构与算法.算法系统练习.历年真题.java_B_C组;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 标题: 组素数
 * <p>
 * 素数就是不能在进行等分的数。比如: 2 3 5 7 11 等。
 * 9 = 3 * 3 说明他可以3等分，因而不是素数。
 * <p>
 * 我们国家在1949年建国。如果只给你 1 9 4 9 这4个数字卡片，可以随意摆放他们的先后顺序 (但卡片不能倒着摆放啊，我们不是在脑筋急转弯!)
 * 那么，你能组成多少个4位的素数呢?
 * <p>
 * 比如: 1949，4919 都符合要求。
 * <p>
 * 请你提交: 能组成的4位素数的个数
 */
public class _02组素数 {
  public static void main(String[] args) {
    自己写的();

    老师写的 (new int[]{1, 4, 9, 9}, 0);
    System.out.println(set.size());
  }

  /**
   * 处理从k开始的排列
   * @param arr
   * @param k
   */
  static void 老师写的(int[] arr, int k) {
    if (k == 4) { // 前面都已确认
      check(arr);
    }
    for (int i = k; i < 4; i++) {
      // 交换
      int t = arr[k];
      arr[k] = arr[i];
      arr[i] = t;

      老师写的(arr, k + 1);

      t = arr[k];
      arr[k] = arr[i];
      arr[i] = t;
    }
  }

  static Set<Integer> set = new HashSet<>();
  private static void check(int[] arr) {
    int x = arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
    boolean flag = true;
    for (int i = 2; i <= Math.sqrt(x); i++) {
      if (x % i == 0) {
        flag = false;
        break;
      }
    }
    if (flag) {
      set.add(x);
    }
  }

  private static void 自己写的() {
    AtomicInteger count = new AtomicInteger();
    int[] a = {1, 9, 4, 9};
    Set<String> set = new HashSet<>();
    while (true) {
      String s = "";
      while (true) {
        int iiu = new Random().nextInt(4);
        String ii = String.valueOf(iiu);
        if (s.indexOf(ii) == -1) {
          s += ii;
        }
        if (s.length() == 4) {
          set.add(s);
          break;
        }
      }
      if (set.size() == 24) {
        break;
      }
    }
    Set<Integer> set1 = new HashSet<>();
    set.forEach(ii -> {
      String s = "";
      for (int o = 0; o < ii.length(); o++) {
        s += a[ii.charAt(o) - '0'];
      }
      int x = Integer.parseInt(s);
      set1.add(x);
    });
    set1.forEach(x -> {
      for (int i = 2; i < x; i++) {
        if (x % i == 0) {
          break;
        }
        if (x == i + 1) {
//          System.out.println(x);
          count.getAndIncrement();
        }
      }
    });
    System.out.println(count.get());
  }
}
