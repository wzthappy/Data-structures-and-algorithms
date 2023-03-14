package 数据结构与算法.算法系统练习.历年真题.java_B_C组;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 问题描述
 * 　　有N根木棍，需要将其粘贴成M个长木棍，使得最长的和最短的的差距最小。
 * <p>
 * 输入格式
 * 　　第一行两个整数N,M。
 * 　　一行N个整数，表示木棍的长度。
 * <p>
 * 输出格式
 * 　　一行一个整数，表示最小的差距
 * <p>
 * 样例输入
3 2
10 20 40
 * 样例输出
 * 10
 * 数据规模和约定
 * 　　N, M<=7
 */
public class 粘木棍 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] s = scanner.nextLine().split(" ");
    int N_CONUT = Integer.parseInt(s[0]);  // 初始木棍个数
    int M_CONUT = Integer.parseInt(s[1]);  // 最终木棍
    List<Integer> collect = Arrays.stream(scanner.nextLine().split(" "))
        .map(Integer::parseInt).sorted(Comparator.comparingInt(i -> i)).collect(Collectors.toList());// 初始木棍  排序好了  从小到大

//    aaa(list, collect, M_CONUT, collect.get(0));
    if (M_CONUT == 1) {
      System.out.println(0);
      return;
    }
    if (N_CONUT == M_CONUT) {
      System.out.println(collect.get(M_CONUT - 1) - collect.get(0));
      return;
    }
//5 3
//34 47 53 31 77
    for (int m = 0; m < N_CONUT - 2; m++) {
      if (M_CONUT < collect.size()) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.comparingInt(i -> i));
        for (int c = 1; c < collect.size() - 1; c++) {
          map.put(Math.abs(collect.get(collect.size() - 1) - collect.get(0) - collect.get(c)), c);
        }
        int xiabiao_Index = 0;
        for (Integer v : map.values()) {
          xiabiao_Index = v;
          break;
        }
        collect.set(0, collect.get(0) + collect.get(xiabiao_Index));
        collect.remove(xiabiao_Index);
        collect.sort(Comparator.comparingInt(i -> i));
      } else {
        break;
      }
    }
    System.out.println(collect.get(M_CONUT - 1) - collect.get(0));
  }

//  private static void aaa(List<Integer> list, List<Integer> collect, int m_conut, int zhi) {
//    if (m_conut == list.size()) {
//      List<Integer> list1 = list.stream().sorted(Comparator.comparingInt(i -> i)).toList();
//      System.out.println(list1.get(m_conut) - list1.get(0));
//      return;
//    }
//
//    for () {
//
//    }
//  }
}
