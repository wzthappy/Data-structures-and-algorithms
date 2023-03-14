package 数据结构与算法.算法系统练习.历年真题._2014;

import java.util.*;

/**
 * 题目描述：
 * A A 2 2 3 3 4 4， 一共4对扑克牌。请你把它们排成一行。
 * 要求：两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌。
 * 请填写出所有符合要求的排列中，字典序最小的那个。
 * 例如：22AA3344 比 A2A23344 字典序小。当然，它们都不是满足要求的答案。
 * 请通过浏览器提交答案。“A”一定不要用小写字母a，也不要用“1”代替。字符间一定不要留空格。
 */
public class _07扑克排序 {
  public static void main(String[] args) {
    char[] a = {'A', 'A', '2', '2', '3', '3', '4', '4'};
    f(a, 0);
    System.out.println(Arrays.toString(set.toArray()));
  }

  static Set<String> set = new HashSet<>();
  private static void f(char[] a, int k) {
    if (k == a.length) {
      String s = new String(a);
      if (check(s)) {
//        System.out.println(s);
        set.add(s);
      }
      return;
    }

    for (int i = k; i < a.length; i++) {
      char t = a[k];
      a[k] = a[i];
      a[i] = t;

      f(a, k + 1);

      t = a[k];
      a[k] = a[i];
      a[i] = t;
    }
  }

  private static boolean check(String s) {
    if (s.lastIndexOf('A') - s.indexOf('A') == 2 &&
        s.lastIndexOf('2') - s.indexOf('2') == 3 &&
        s.lastIndexOf('3') - s.indexOf('3') == 4 &&
        s.lastIndexOf('4') - s.indexOf('4') == 5) {
      return true;
    }
    return false;
  }
}
