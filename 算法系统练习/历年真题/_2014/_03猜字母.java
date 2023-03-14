package 数据结构与算法.算法系统练习.历年真题._2014;

import org.junit.rules.Stopwatch;

import java.util.*;

/**
 *把 abcd...sabcd...s 共19个字母组成的序列重复拼接 106 次，得到长度为 2014 的串。
 * 接下来删除第 1 个字母（即开头的字母 a），以及第 3 个，第 5 个等所有奇数位置的字母。
 * 得到的新串再进行删除奇数位置字母的动作。如此下去，最后只剩下一个字母，请输出该字母。
 *
 * 运行限制
 *     最大运行时间：1s
 *     最大运行内存: 128M
 */
public class _03猜字母 {
  public static void main(String[] args) {
    test1();

    test2();

  }

  private static void test2() {
    char[] arr = new char[2014];
    int index = 0;
    for (int j = 0; j < 106; j++) {
      for (int i = 0; i < 19; i++) {
        arr[index++] = (char) ('a' + i);
      }
    }
    int len = 2014;
    while (len != 1) {
      int k = 0;
      for (int i = 1; i < len; i += 2) {
        arr[k++] = arr[i];
      }
      len = k;
    }
    System.out.println(arr[0]);
  }



  private static void test1() {
    char a;
    List<Character> chars = new ArrayList<>();
    for (int z = 0; z < 106; z++) {
      for (int i = 0; i < 19; i++) {
        a = (char) ('a' + i);
        chars.add(a);
      }
    }
    a1(chars);
  }

  public static void a1 (List<Character> s) {
    if (s.size() == 1) {
      System.out.println(s.get(0));
      return;
    }
    for (int i = 0; i < s.size(); i++) {
      s.remove(i); // 每次删除都会向前移动
    }
    a1(s);
  }
}
