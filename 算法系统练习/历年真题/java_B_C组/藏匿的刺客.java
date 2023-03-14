package 数据结构与算法.算法系统练习.历年真题.java_B_C组;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 问题描述
 * 　　强大的kAc建立了强大的帝国，但人民深受其学霸及23文化的压迫，于是勇敢的鹏决心反抗。
 * 　　kAc帝国防守森严，鹏带领着小伙伴们躲在城外的草堆叶子中，称为叶子鹏。
 * 　　kAc帝国的 派出的n个看守员 都发现了这一问题，第i个人会告诉你在 第li个草堆到第ri个草堆 里面有人，要求你计算所有草堆中最少的人数，以商议应对。
 * 　　“你为什么这么厉害”，得到过kAc衷心赞美的你必将全力以赴。
 * <p>
 * 输入格式
 * 　　第一行一个数字n，接下来2到n+1行，每行两个数li和ri，如题。
 * <p>
 * 输出格式
 * 　　输出一个数，表示最少人数。
 * <p>
 * 样例输入
 * 5
 * 2 4
 * 1 3
 * 5 7
 * 1 8
 * 8 8
 * 样例输出
 * 3
 */
public class 藏匿的刺客 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int i = Integer.parseInt(scanner.nextLine());
    int[][] arr = new int[i][3];
    for (int i1 = 0; i1 < i; i1++) {
      String[] s = scanner.nextLine().split(" ");
      arr[i1][0] = Integer.parseInt(s[0]);
      arr[i1][1] = Integer.parseInt(s[1]);
      arr[i1][2] = -i1;  // 标志位
    }
    aaa.fu.add(999);
    藏匿的刺客 藏匿的刺客 = new 藏匿的刺客();
    for (int[] as : arr) {
//      System.out.println(as[0] + " " + as[1] + " " + as[2]);
      藏匿的刺客.aa(as);
    }

    List<CopyOnWriteArraySet<Integer>> list = new ArrayList<>();
    aaa.map.forEach((k, v) -> {
      System.out.println(k + ", " + v.count + ", " + v.fu);
      list.add(v.fu);
    });
    int zhi = 0;
    Set<Integer> list1 = new HashSet<>();
    for (int i1 = 0; i1 < list.size() - 1; i1++) {
      int zzz = list.get(i1).size();
      int ccc = 0;
      for (Integer i2 : list.get(i1)) {
        for (Integer i3 : list.get(i1 + 1)) {

          list1.add(i2);

          if (i2.intValue() == i3.intValue()) {
            ccc++;
          }
        }
      }

      if (ccc != zzz) {
        zhi++;
      }

    }

    System.out.println(list1);
    System.out.println(zhi);
  }

  static aaa aaa = new aaa();

  int count222 = 0;

  public void aa(int[] as) {
    int size = aaa.fu.size();
    int count = 0;
    for (int i : aaa.fu) {
      count++;
      if (i != as[2] && count == size) {
        aaa.getAddFu(as[2]); // 加入自己的标识位
        for (int i2 = as[0]; i2 <= as[1]; i2++) {
          b b = aaa.map.get(i2);
          if (b == null) {
            b = new b();
            b.count = 1;
          } else {
            b.count++;
          }
          b.fu.add(as[2]);
          aaa.map.put(i2, b);
        }
        continue;
      }
    }
  }

  static class aaa {
    Map<Integer, b> map = new TreeMap<>();
    CopyOnWriteArrayList<Integer> fu = new CopyOnWriteArrayList<Integer>(); // 父标识位 的集合

    public void getAddFu(Integer i) {
      fu.add(i);
    }
  }

  class b {
    Integer count;
    CopyOnWriteArraySet<Integer> fu = new CopyOnWriteArraySet<Integer>(); // 自己享有的标识位
  }
}
