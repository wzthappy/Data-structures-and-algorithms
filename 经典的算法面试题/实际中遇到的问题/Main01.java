package 数据结构与算法.经典的算法面试题.实际中遇到的问题;

public class Main01 {
  public static void main(String[] args) {
    String str = "Java,Java,hello,world!";
    String newStr = str.replaceAll("Java", "尚硅谷~"); // 算法
    System.out.println("newStr = " + newStr);
  }
  /*
      问题: 试写出用单链表表示的字符串类及字符串结点类的定义，并依次实现它的构造函数、以及计算串长度、串赋值、判断两串相等、
          求子串、两串连接、求在串中位置等7个成员函数。
   */
}
