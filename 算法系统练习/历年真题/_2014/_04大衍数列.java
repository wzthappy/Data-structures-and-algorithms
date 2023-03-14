package 数据结构与算法.算法系统练习.历年真题._2014;

/**
 * 大衍数列:
 *     中国古代文献中，曾记载过“大衍数列”, 主要用于解释中国传统文化中的太极衍生原理。
 *     它的前几项是：0、2、4、8、12、18、24、32、40、50 …
 *     其规律是：对偶数项，是序号平方再除2，奇数项，是序号平方减1再除2。
 *     用代码打印出了大衍数列的前 100 项。
 */
public class _04大衍数列 {
  public static void main(String[] args) {
//    Double count = 1.0;
    for (int count = 1; count <= 100; count++) {
      if (count % 2 == 0) {
        // 偶数
        if (count == 100) {
          System.out.print(count * count / 2);
        } else {
          System.out.print(count * count / 2 + "、");
        }
      } else {
        // 奇数
        System.out.print((count * count - 1) / 2 + "、");
      }
    }
  }
}
