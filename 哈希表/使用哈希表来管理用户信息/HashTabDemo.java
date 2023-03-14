package 数据结构与算法.哈希表.使用哈希表来管理用户信息;

import java.util.Scanner;

public class HashTabDemo {
  public static void main(String[] args) {
    // 创建哈希表
    HashTab hashTab = new HashTab(7);

    // 写一个简单的菜单
    Scanner scanner = new Scanner(System.in);
    char key = ' ';
    while (true) {
      System.out.println("add: 添加用户");
      System.out.println("list: 显示用户");
      System.out.println("find: 查找用户");
      System.out.println("select: 删除用户");
      System.out.println("exit: 退出系统");

      key = scanner.next().charAt(0);
      switch (key) {
        case 'a':
          System.out.println("输入id");
          int id = scanner.nextInt();
          System.out.println("输入名字");
          String name = scanner.next();
          // 创建 用户
          Emp emp = new Emp(id, name);
          hashTab.add(emp);
          break;
        case 'l':
          hashTab.list();
          break;
        case 'e':
          scanner.close();
          System.exit(0);
          break;
        case 'f':
          System.out.println("请输入要查找的id");
          id = scanner.nextInt();
          hashTab.findEmpById(id);
          break;
        case 's':
          System.out.println("请输入要删除的id");
          id = scanner.nextInt();
          hashTab.delete(id);
          break;
        default:
          break;
      }
    }
  }
}
