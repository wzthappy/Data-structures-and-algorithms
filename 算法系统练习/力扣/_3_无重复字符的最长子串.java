package 数据结构与算法.算法系统练习.力扣;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符最长子串的长度。
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 */
public class _3_无重复字符的最长子串 {
  public static void main(String[] args) {
    int i = new _3_无重复字符的最长子串().lengthOfLongestSubstring(" ");
    System.out.println(i);
  }

  public int lengthOfLongestSubstring(String s) {
    LinkedList<Integer> countList = new LinkedList<>();
    HashMap<Integer, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (map.containsValue(s.charAt(i))) {
        i = i - map.size();
        countList.add(map.size());
//        System.out.println(map.size());
        map.clear();
      } else {
//        System.out.println(s.charAt(i));
        map.put(i, s.charAt(i));
      }
    }
    countList.add(map.size()); // 加上最后一次
    countList.sort((i1, i2) -> i2 - i1);
    if (countList.size() == 0) {
      return 0;
    }
    return countList.get(0);
  }
}
