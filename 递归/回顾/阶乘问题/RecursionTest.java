package 数据结构与算法.递归.回顾.阶乘问题;

public class RecursionTest {
  public static void main(String[] args) {
    int res = factorial(2);
    System.out.println(res);
  }

  // 阶乘问题
  public static int factorial(int n) {
    if (n == 1) {
      return 1;
    } else {
      return factorial(n - 1) * n;
    }
  }
}
