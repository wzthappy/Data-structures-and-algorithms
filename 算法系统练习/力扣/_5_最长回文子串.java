package 数据结构与算法.算法系统练习.力扣;

import java.sql.Array;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 */
public class _5_最长回文子串 {
  public static void main(String[] args) {
    String babad = new _5_最长回文子串().longestPalindrome("abcba");
    System.out.println(babad);
  }

  public String longestPalindrome(String s) {
    LinkedHashMap<Integer, String> lMap = new LinkedHashMap<>();
    List<Character> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      for (int i1 = i; i1 < s.length(); i1++) {
        list.add(s.charAt(i1));
        boolean start = true;
        for (int i2 = 0; i2 < list.size(); i2++) {
          if (!list.get(i2).equals(list.get(list.size() - 1 - i2))) {
            start = false;
            break;
          }
        }
        if (start) {
          lMap.put(list.size(), list.toString());
        }
      }
      list.clear();
    }
    TreeSet<Integer> ssss = new TreeSet<>((i1, i2) -> i2 - i1);
    for (Integer value : lMap.keySet()) {
      ssss.add(value);
    }
    for (Integer integer : ssss) {
      return lMap.get(integer).replaceAll("\\[", "").replaceAll(", ", "").replaceAll("\\]", "");
    }
    return null;
  }
}
