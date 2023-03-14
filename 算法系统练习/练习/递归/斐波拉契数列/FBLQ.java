package 数据结构与算法.算法系统练习.练习.递归.斐波拉契数列;

public class FBLQ {
  public static void main(String[] args) {
    System.out.println(f(4));
  }

  static int f (int n) {
    if (n == 1 || n == 2) {
      return 1;
    }
    return f(n - 1) + f(n - 2);
  }
}
