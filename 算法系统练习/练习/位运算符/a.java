package 数据结构与算法.算法系统练习.练习.位运算符;

public class a {
  public static void main(String[] args) {
    System.out.println(1<<35);  // int 类型只有32位，所以每32位会截取   8
    System.out.println(1<<3);  // 8

    System.out.println(1>>35);
    System.out.println(221 & 1);
  }
}
