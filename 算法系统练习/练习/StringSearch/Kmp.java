package 数据结构与算法.算法系统练习.练习.StringSearch;

import java.util.Arrays;

/**
 * 给定两个字符串A、B，判断B在A中是否存在，存在返回A中的下标，不存在返回-1
 *  例如:
 *    A: "ABCABC A ABCABCD"
 *    B: "ABCABC D"
 *  返回值是: 7
 *
 *        不能使用indexOf
 *        不能使用暴力匹配
 */
public class Kmp {
  public static void main(String[] args) {
    String str1 = "ABCABCAABCABCD";
    String setPattern = "ABCABCD";
    int[] next = new int[setPattern.length()];
    getNext(setPattern.toCharArray(), next);
    int i = search(str1.toCharArray(), setPattern.toCharArray(), next);
    System.out.println(Arrays.toString(next));
    System.out.println(i);

//    System.out.println(str1.indexOf(setPattern));
  }

  // kmp算法          // 传入两个要的比较的数组          next 不是空表，是下面匹配上来的值，用来记录的表
  static int search (char[] str, char[] pattern, int[] next) {
    int i = 0;
    int j = 0;

    while (i < str.length && j < pattern.length) {
      if (j == -1 || str[i] == pattern[j]) { // 如果匹配上来就++，在比较后面的值
        i++;
        j++;
      } else {
        j = next[j]; // next 中的值--
      }
    }

    if (j == pattern.length) {
      return i - j; // 匹配的字符串的位置
    } else {
      return -1; // 没有匹配上
    }
  }


  // Next 算法
  static void getNext(char[] pattern, int[] next) {  // 生成一个 next 数组
    next[0] = -1;  // 从 -1开始的     也是每次初始化的值
    int i = 0, j = -1;
//    ABCABC        i = ABC = 3     pmt
//       ABCABC    j = -1 + 3 = 2  next
    while (i < pattern.length) {
      if (j == -1) {
        i++;
        j++;
      } else if (pattern[i] == pattern[j]) { // 相等记录一下 匹配的个数
        i++;
        j++;
        next[i] = j;  // 如果匹配上来就加一
      } else {
        j = next[j]; // 不匹配，依次的向后-1
      }
    }
  }
}
