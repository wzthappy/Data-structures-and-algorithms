package 数据结构与算法.算法系统练习.力扣;

import java.util.regex.Pattern;

/**
 *给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 示例 1：
 * 输入：s = "aa", p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * 输入：s = "aa", p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 * 输入：s = "ab", p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 */
public class _10_正则表达式匹配 {
  public static void main(String[] args) {
    System.out.println(new _10_正则表达式匹配().isMatch2("aab", "c*a*b"));
  }
  public boolean isMatch2(String s, String p) {
    return Pattern.matches(p, s);
  }
  public boolean isMatch(String s, String p) {
    for (int i = 0; i < p.length(); i++) {
      char c = p.charAt(i);
      if (c == '.') {

      } else if (c == '*') {
        return true;
      } else {
        if (c != s.charAt(i)) {
          return false;
        }
      }
    }
    return s.length() == p.length();
  }
}
