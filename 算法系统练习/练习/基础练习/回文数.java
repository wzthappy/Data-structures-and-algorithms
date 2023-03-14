package 数据结构与算法.算法系统练习.练习.基础练习;

/**
 * 问题描述
 * 　　1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
 * 输出格式
 * 　　按从小到大的顺序输出满足条件的四位十进制数。
 */
public class 回文数 {
  public static void main(String[] args) {
    StringBuilder s;

    for (int i = 1; i < 10; i++) {
      for (int i1 = 0; i1 < 10; i1++) {
        for (int i2 = 0; i2 < 10; i2++) {
          for (int i3 = 0; i3 < 10; i3++) {

            s = new StringBuilder();
            s.append(i).append(i1).append(i2).append(i3);
            String s1 = s.toString();
            int length = s1.length();
            boolean flag = true;
            for (int i4 = 0; i4 < length; i4++) {
              if(s1.charAt(i4) != s1.charAt(length - i4 - 1)) {
                flag = false;
              }
            }
            if (flag) {
              System.out.println(s1);
            }

          }
        }
      }
    }

  }
}
