package 数据结构与算法.算法系统练习.历年真题._2014;

/**
     一根高筋拉面，中间切一刀，可以得到2根面条。
     如果先对折1次，中间切一刀，可以得到3根面条。
     如果连续对折2次，中间切一刀，可以得到5根面条。 那么，连续对折10次，中间切一刀，会得到多少面条呢？
                                9

 */
public class _02切面条 {
  public static void main(String[] args) {
    int f = f(10, 2);
    System.out.println(f);
  }

  private static int f(int i, int s) {
    if (i == 1) {
      return s + 1;
    }
    return f(i - 1, s * 2);
  }
}
