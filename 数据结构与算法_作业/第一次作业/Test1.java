package 数据结构与算法.数据结构与算法_作业.第一次作业;

import java.io.FileInputStream;
import java.util.*;

import static java.util.Comparator.*;

/**
 * 1、实现两个集合合并（集合可以用数组实现，集合中数据从键盘上输入），并进行排序。
 * 注意：如果合并中有重复的数据仅保留一个，去重操作
 */
public class Test1 {
  Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    try {
      // 定义两个集合
      List<Integer> arrayList1 = new ArrayList<>();
      List<Integer> arrayList2 = new ArrayList<>();
      Test1 test = new Test1();
      // 输入数据
      test.add1(arrayList1);
      test.add2(arrayList2);

      // 合并
      System.out.println("---------- 合并 并 去重 后 的 集合 ----------");
      List<Integer> com = test.com(arrayList1, arrayList2);
      System.out.println(com.toString());

      // 排序
      System.out.println("----------- 排序后 --------");
      test.px(com);
    } catch (Exception e) {
      System.out.println("系统繁忙、稍后重试~~");
      // 把错误消息记录下来 并 保存到文档中
      //  .......
    }
  }

  // 排序
  public void px(List<Integer> arrayList) {
    if (arrayList.size() != 0) {
      arrayList.sort((comparingInt(o -> o)));
      System.out.println(arrayList);
    } else System.out.println("集合为空！");
  }

  // 合并 并 去重
  public List<Integer> com(List<Integer> arrayList1, List<Integer> arrayList2) {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    HashMap<Integer, String> map = new HashMap<>();
    arrayList.addAll(arrayList1);
    arrayList.addAll(arrayList2);

    for (Integer integer : arrayList) map.put(integer, null);

    return new ArrayList<Integer>(map.keySet());
  }

  public void add1(List<Integer> arrayList1) {
    System.out.println("---- 请输入第一个数组的 数字 以空格隔开 ----");
    String str = scanner.nextLine();
    String[] s = str.split(" ");
    for (String value : s)
      if (!"".equals(value.trim()))  // 当取出多余空格时  发现不为空  就添加到的集合中
        arrayList1.add(Integer.parseInt(value));
  }

  public void add2(List<Integer> arrayList2) {
    System.out.println("---- 请输入第二个数组的 数字 以空格隔开 ----");
    String str = scanner.nextLine();
    String[] s = str.split(" ");
    for (String value : s)
      if (!"".equals(value.trim()))  // 当取出多余空格时  发现不为空  就添加到的集合中
        arrayList2.add(Integer.parseInt(value));
    // 输入完毕关闭流
    scanner.close();
  }
}
