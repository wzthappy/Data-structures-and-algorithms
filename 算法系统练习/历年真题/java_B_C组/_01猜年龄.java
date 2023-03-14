package 数据结构与算法.算法系统练习.历年真题.java_B_C组;

import java.util.HashSet;
import java.util.Set;

/**
 * 标题: 猜年龄
 * <p>
 * 美国数学家维拉(N.Wiener)智力早熟，11岁就上了大学。他曾在1935~1936年应邀来中国清华大学讲学。
 * 一次，他参加某个重要会议，年轻的脸孔引入注目。于是有人询问他的年龄，他回答说:
 * <p>
 * "我年龄的立方是个4位数。我年龄的4次方是个6位数。这10个数字正好包含了从0到9这10个数字，每个都恰好出现1次。"
 * <p>
 * 请你推算一下，他当时到底有多年轻。
 */
public class _01猜年龄 {
  public static void main(String[] args) {
    自己的();
    老师的();
  }

  private static void 老师的() {
    for (int i = 10; i < 100; i++) {
      int i1 = i * i * i;
      int i2 = i1 * i;
      String s1 = i1 + "";
      String s2 = i2 + "";
      if (s1.length() == 4 && s2.length() == 6 && check(s1 + s2)) {
        System.out.println(i);
        break;
      }
    }
  }

  private static boolean check(String s) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      set.add(s.charAt(i));
    }
    return set.size() == 10;
  }

  private static void 自己的() {
    Set<Character> a = new HashSet<>();
    for (int x = 1; x < 100; x++) {
      a = new HashSet<>();
      if (x * x * x / 1000 > 0 && x * x * x / 1000 < 10 && x * x * x * x / 100000 < 10 && x * x * x * x / 100000 > 0) {
        String s = x * x * x + "" + x * x * x * x;
        for (int i = 0; i < 10; i++) {
          a.add(s.charAt(i));
          if (a.size() == 10) {
            System.out.println(x);
          }
        }
      }
    }
  }
}
