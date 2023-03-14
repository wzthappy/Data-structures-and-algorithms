package 数据结构与算法.算法系统练习.练习.基础练习;

import java.util.Scanner;

/**
 * 问题描述
 * 　　给定n个十六进制正整数，输出它们对应的八进制数。
 *
 * 输入格式
 * 　　输入的第一行为一个正整数n （1<=n<=10）。
 * 　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。
 *
 * 输出格式
 * 　　输出n行，每行为输入对应的八进制正整数。
 *
 * 　　【注意】
 * 　　输入的十六进制数不会有前导0，比如012A。
 * 　　输出的八进制数也不能有前导0。
 *
 * 样例输入
 * 　　2
 * 　　39
 * 　　123ABC
 *
 * 样例输出
 * 　　71
 * 　　4435274
 *
 * 　　【提示】
 * 　　先将十六进制数转换成某进制数，再由某进制数转换成八进制。
 */
public class 十六进制转八进制 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    if(!(n >= 1 && n <= 10)) {
      return;
    }
    String[] list = new String[n];
    for (int i = 0; i < n; i++) {
      list[i] = scanner.nextLine();
    }

    for (String i : list) {
      StringBuilder s = new StringBuilder();
      for (int i1 = 0; i1 < i.length(); i1++) {  // 十六转二
        switch (i.charAt(i1)) {
          case '1': s.append("0001");break;
          case '2': s.append("0010");break;
          case '3': s.append("0011");break;
          case '4': s.append("0100");break;
          case '5': s.append("0101");break;
          case '6': s.append("0110");break;
          case '7': s.append("0111");break;
          case '8': s.append("1000");break;
          case '9': s.append("1001");break;
          case 'A': s.append("1010");break;
          case 'B': s.append("1011");break;
          case 'C': s.append("1100");break;
          case 'D': s.append("1101");break;
          case 'E': s.append("1110");break;
          case 'F': s.append("1111");break;
        }
      }

      String s1 = s.toString();
      int a = s1.length() % 3;
      if (a != 0) {
        int aa = 3 - a;
        while (aa != 0) {
          s1 = "0" + s1;
          aa--;
        }
      }

      StringBuilder zhi = new StringBuilder();

      for (int i1 = 1; i1 <= s1.length(); i1 += 3) {
        switch (s1.substring(i1 - 1, i1 + 2)) {
          case "000": zhi.append("0");break;
          case "001": zhi.append("1");break;
          case "010": zhi.append("2");break;
          case "011": zhi.append("3");break;
          case "100": zhi.append("4");break;
          case "101": zhi.append("5");break;
          case "110": zhi.append("6");break;
          case "111": zhi.append("7");break;
        }
      }
      System.out.println(zhi.toString().replaceAll("^(0+)", ""));
    }

  }
}
