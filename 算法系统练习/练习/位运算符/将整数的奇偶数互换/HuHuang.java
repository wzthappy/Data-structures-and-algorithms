package 数据结构与算法.算法系统练习.练习.位运算符.将整数的奇偶数互换;

public class HuHuang {
  public static void main(String[] args) {
    System.out.println(Integer.toString(0xaaaaaaaa, 2));
    System.out.println(Integer.toString(0x55555555, 2));
    System.out.println("---------------------");
//    int a = 6;
    int a = 0b01000000_00000000_00000000_00000000; // jdk8以后可以直接写二进制表示0b   _
    System.out.println(a);
    int b = m(a);
    System.out.println(b);
  }
  private static int m (int i) {
    int ou = i & 0xaaaaaaaa; // 和1010 1010 1010.... 做与运算取出偶数位
    int ji = i & 0x55555555; // 和0101 0101 0101.... 做或运算取出偶数位
    return (ou >> 1) ^ (ji << 1); // 连起来
  }
}
