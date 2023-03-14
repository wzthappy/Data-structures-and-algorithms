package 数据结构与算法.算法系统练习.练习.基础练习;

/**
 * 问题描述
 * 　　实现一个函数，函数包含两个参数t和v。当t=0时，记录下v，当t=1时，返回所有已记录的v的和。
 * 输入格式
 * 　　无。
 * 输出格式
 * 　　无。
 * 数据规模和约定
 * 　　函数调用次数不大于10000次，0<=v<=10000。
 */
public class 求和器 {

  public static void main(String[] args) {
    求和器 求和器 = new 求和器();
    System.out.println(求和器.func(0, 4));
    System.out.println(求和器.func(0, 4));
    System.out.println(求和器.func(1, 4));
  }
  public int func(int t, int v) {
    ThreadLocal<Integer> a = new ThreadLocal<>();

    if (t == 1) {
      return a.get();
    }
    a.set(v + a.get());
    return 0;
  }
}
