package 数据结构与算法.算法系统练习.练习;


import java.util.Scanner;
import java.util.Stack;

public class 二分查找算法 {
  public static void main(String[] args) {
    int i = new Scanner(System.in).nextInt();
    System.out.println("十进制数: " + i);
    System.out.println("二进制数: " + er(i));
    System.out.println("9进制是: " + ba(i));
  }

  public static int er(int x) {
    Stack<Integer> a = new Stack<>();
    int res = 0;
    while (x != 0) {
      a.push(x % 2);
      x /= 2;
    }
    while (!a.empty()) {
      res = res * 10 + a.peek();
      a.pop();
    }
    return res;
  }

  public static String ba(int a) {
    Stack<Integer> s = new Stack<>();
    String str = "";
    while (a > 0) {
      s.push(a % 9);
      a = a / 9;
    }
    while (!s.isEmpty()) {
      str = str + s.pop();
    }
    return str;
  }
}
