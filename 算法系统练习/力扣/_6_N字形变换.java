package 数据结构与算法.算法系统练习.力扣;

import java.util.Arrays;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 * 比如输入字符串为 "PAY P ALI S HIR I NG"行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：    PAYP AL ISHI RI NG
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 * 提示：
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 */
public class _6_N字形变换 {
  public static void main(String[] args) {
    System.out.println(new _6_N字形变换().convert("PAYPALISHIRING", 4));
  }

  public String convert(String s, int numRows) {
    // PINALSIGYAHRPI
    // PAYP
    //  AL
    // ISHI
    //  RI
    // NG
    StringBuilder str = new StringBuilder();
    int count = 0;
    int num = numRows - 2;
    String substring1;
    int length  = s.length();
    for (int i = 1; i <= (length / numRows); i++) {
      int ide = (i - 1) * numRows + count * num;
      int zhang = ide + numRows > length ? ide - length : 0;
      StringBuilder substring = new StringBuilder(s.substring(ide, ide + numRows + zhang));
      System.out.println("-->" + substring);
      if (zhang < 0) {
        for (int i1 = 0; i1 < Math.abs(zhang); i1++) {
          substring.append("_");
        }
      }
      substring1 = "";
      int z = numRows * i + count * num;
      if (z < length) {
        substring1 = "_" + new StringBuffer(s.substring(z, numRows * i + num + count * num)).reverse().toString() + "_";
      }
      if (!"".equals(substring.toString())) {
        str.append(substring);
      }
      if (!"".equals(substring1)) {
        str.append(substring1);
      }
      count++;
    }
    StringBuilder newStr = new StringBuilder();
    String s1 = str.toString();
    for (int i = 0; i < numRows; i++) {
      for (int i1 = 0; i1 < s1.length() / 4; i1++) {
        System.out.println(s1.charAt(i1 * 4 + i));
      }
    }

    System.out.println(str);
    for (int i = 0; i < numRows; i++) {
      for (int i1 = 0; i1 < str.length() / numRows; i1++) {
        newStr.append(str.charAt(i + i1 * numRows));
      }
    }
    System.out.println(newStr);
    return newStr.toString().replaceAll("_", "");
  }
}
