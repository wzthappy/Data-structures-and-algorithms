package 数据结构与算法.数据结构与算法_作业.教师电话管理系统.handle;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author happy
 * 测试类
 */
public class TeacherLinkedListDemo {
  static Executor threadPool = Executors.newFixedThreadPool(3);
  static Scanner scanner = new Scanner(System.in);


  public static void main(String[] args) {
    new Console().consoleRun();
    System.out.println("作者: happy");
  }
}
