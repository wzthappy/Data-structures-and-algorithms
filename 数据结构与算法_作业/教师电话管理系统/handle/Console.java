package 数据结构与算法.数据结构与算法_作业.教师电话管理系统.handle;

import 数据结构与算法.数据结构与算法_作业.教师电话管理系统.pojo.Teacher;
import 数据结构与算法.数据结构与算法_作业.教师电话管理系统.service.TeacherLinkedList;
import 数据结构与算法.数据结构与算法_作业.教师电话管理系统.service.impl.TeacherLinkedListImpl;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author happy
 * 返回信息处理类
 */
public class Console {
  private TeacherLinkedList teacherLinkedList = new TeacherLinkedListImpl();
  private Scanner scanner = TeacherLinkedListDemo.scanner;
  private ExecutorService executor = (ExecutorService) TeacherLinkedListDemo.threadPool;

  public void consoleRun() {
    CompletableFuture.runAsync(() -> {
      for (int i = 0; i < new Random().nextInt(4); i++) {
        System.err.println("正在启动中....");
        try {
          TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
      System.out.println("-----欢迎您的使用------");
      boolean n = true;
      while (n) {
        template();
        System.out.print("输入序号: ");
        switch (scanner.nextLine()) {
          case "1": teacherAdd(); break; // 添加
          case "2": queryHead(); break; // 查看所有
          case "3": teacherDel(); break; // 根据工号删除
          case "4": queryOnThread(); break; // 根据工号查询教师
          case "5": sortByAge(); break; // 按年龄排序
          case "0": {  // 退出
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
            System.out.println("控制台安全退出");
            n = false;
          }
          break;
          default: System.out.println("请输入正确的数字"); break;
        }
      }
    }, executor);
    executor.shutdown();
  }

  String[] arr = {"姓名: ", "性别: ", "年龄: ", "电话号: ", "个人信息: "};
  private void teacherAdd() {
    System.out.println("--------- 添加教师 ---------");
    Teacher t = new Teacher().setJobNo(UUID.randomUUID().toString()
        .replaceAll("-", "").substring(0, 7));
    for (int i = 0; i <= 4; i++) {
      System.out.print(arr[i]);
      if (i == 0) {
        t.setName(scanner.nextLine());
      } else if (i == 1) {
        t.setGender(scanner.nextLine().charAt(0));
      } else if (i == 2) {
        t.setAge(Integer.parseInt(scanner.nextLine()));
      } else if (i == 3) {
        t.setTelephoneNo(scanner.nextLine());
      } else {
        t.setPersonalInformation(scanner.nextLine());
      }
    }
    teacherLinkedList.teacherAdd(t);
    System.out.println("\t添加成功！");
  }

  private void teacherDel() {
    System.out.print("--------- 删除指定教师 ---------\n" + "请输入要删除教师的工号: ");
    teacherLinkedList.teacherDel(scanner.nextLine());
    System.out.println("删除成功");
  }

  private void queryOnThread() {
    System.out.print("--------- 查询指定教师 ---------\n" + "请输入要查询教师的工号: ");
    Teacher teacher = teacherLinkedList.queryOnThread(scanner.nextLine());
    onTeacher(teacher, 1);
  }

  private void queryHead() {
    System.out.println("--------- 查询所有教师 ---------");
    Teacher rightThread = teacherLinkedList.queryHead().getRightThread();
    int i = 1;
    while (rightThread != null) {
      onTeacher(rightThread, i);
      rightThread = rightThread.getRightThread();
      i++;
    }
  }

  private void sortByAge() {
    System.out.println("--------- 教师按年龄进行排序 ---------");
    teacherLinkedList.sortByAge();
    System.out.println("排序完成");
  }

  private void onTeacher(Teacher t, int z) {
    if (t == null) {
      System.out.println("查询失败！");
    }
    System.out.println("-----------" + z + "-----------");
    System.out.println("工号: " + t.getJobNo());
    System.out.println("姓名: " + t.getName());
    System.out.println("性别: " + t.getGender());
    System.out.println("年龄: " + t.getAge());
    System.out.println("手机号: " + t.getTelephoneNo());
    Object pif = t.getPersonalInformation();
    System.out.println("个人描述: " + pif);
  }

  private void template() {
    System.out.println("-------------------------");
    System.out.println("\t1. 添加教师信息");
    System.out.println("\t2. 查询所有教师信息");
    System.out.println("\t3. 根据工号删除教师");
    System.out.println("\t4. 根据工号查询指定教师");
    System.out.println("\t5. 排序当前的教师(按年龄排序)");
    System.out.println("\t0. 安全退出教师控制台");
    System.out.println("-------------------------");
  }
}
