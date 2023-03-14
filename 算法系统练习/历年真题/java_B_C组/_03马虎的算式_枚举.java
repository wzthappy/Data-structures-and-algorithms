package 数据结构与算法.算法系统练习.历年真题.java_B_C组;

/**
 * 标题: 马虎的算式
 *
 * 小明是个急性子，上小学的时候经常把老师写在黑板上的题目炒错了。
 * 有一次，老师出的题目是: 36 * 495 = ？
 * 他却炒成了: 396 * 45 = ?
 * 但结果却很戏剧性，他的答案居然对的！
 * 因为 36 * 495 = 396 * 45 = 17820
 * 类似这样的巧合情况可能还有很多，比如: 27 * 594 = 297 * 54
 * 假设 a b c d e 代表1~9不同的5个数字(注意是各不相同的数字，且不含0)
 * 能满足形式如: ab * cde = adb * ce 这样的算式一共有多少种呢？
 **/
public class _03马虎的算式_枚举 {
  public static void main(String[] args) {
    自己写的(); // 和老师一样
  }


  private static void 自己写的() {
    int count = 0;
    for (int a = 1; a < 10; a++) {
      for (int b = 1; b < 10; b++) {
        if (a != b) {
          for (int c = 1; c < 10; c++) {
            if (a != c && c != b) {
              for (int d = 1; d < 10; d++) {
               if (d != a && d != b && d != c) {
                 for (int e = 1; e < 10; e++) {
                   if (e != a && e != b && e != c && e != d) {
                     if ((a * 10 + b) * (c * 100 + d * 10 + e) == (a * 100 + d * 10 + b) * (c * 10 + e)) {
                       count++;
                     }
//                     System.out.println("" + a + b + " * " + c + d + e);
                   }
                 }
               }
              }
            }
          }
        }
      }
    }
    System.out.println(count);
  }
}
