package 数据结构与算法.递归.回顾.打印问题;

public class RecursionTest {
  public static void main(String[] args) {
    // 通过打印问题，回顾递归调用机制
    test(4);
//    n=2
//    n=3
//    n=4
  }

  public static void test(int n) {
    if (n > 2) {
      test(n - 1);
    }
    System.out.println("n=" + n);
  }
}
