package 数据结构与算法.算法系统练习.练习.位运算符.零到一之间浮点数的二进制表示;

/**
 * 给定一个介于0和1之间的实数，(如0.625)，类型为double，打印他的二进制表示(0.101，因为小数点的二进制分别
 *  表示0.625 * 2 => 1.250 , 0.25 * 2 => 0.5, 0.5 * 2 => 1.0)
 *             0  .  1              0                1        => 0.10.
 *
 *    如果该数字无法精确的用32位以内的二进制表示，则打印"ERROR"
 */
public class LianDaoYi {
  public static void main(String[] args) {
    double num = 0.625;
    StringBuilder sb = new StringBuilder("0.");
    while (num > 0) {
      // 乘2: 挪整
      double r = num * 2;
      // 判断整数部分
      if (r >= 1) {
        sb.append(1);
        // 消除整数部分
        num = r - 1;
      } else {
        sb.append(0);
        num = r;
      }

      if (sb.length() > 34) {
        System.out.println("ERROR");
        return;
      }
    }
    System.out.println(sb);
  }
}
