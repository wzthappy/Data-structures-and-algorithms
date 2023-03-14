package 数据结构与算法.数据结构与算法_作业.第一次作业;

import java.util.ArrayList;
import java.util.List;

/**
 * 2、修改从顺序存储的集合中删除元素的算法，要求当删除一个元素后检查数组的空间大小，若空间利用率小于40%  同时数组长度
 * 大于maxSize时则释放数组的一半存储空间。
 */
public class Test2 {
  public static void main(String[] args) throws Exception {
    Runtime r = Runtime.getRuntime();
    r.gc(); // 先GC一下
    long startMem = r.freeMemory(); // 开始时的剩余内存
    System.out.println(startMem);

    // 创建集合
    List<byte[]> list = new ArrayList<>();

    // 随机添加不同大小的数据 10个
    byte[] bytes;
    for (int i = 0; i < 10; i++) {
      bytes = new byte[(int) (Math.random() * 1024)];
      list.add(bytes);
    }
    System.out.println("集合长度" + list.size());


    // 添加集合完的内存
    long orz = startMem - r.freeMemory();
    System.out.println("添加集合完的剩余内存 : " + orz);

    // 随机删除一个集合数据
    list.remove((int) (Math.random() * 10));

    // 堵塞一下
    Thread.sleep(100);

    // 剩余内存 现在
    long orz2 = startMem - r.freeMemory();
    System.out.println("删除一个集合数据 剩余内存大小 : " + orz2);

    // 若空间利用率小于40%    (同时数组长度大于maxSize时则释放数组的一半存储空间) -> 不理解
    int a = list.size();
    if ((orz / (double) orz2) < 0.4) {
      for (int i = list.size() / 2 + 1; i > 1; i--) {
        int rem = (int) (Math.random() * (a--));
        list.remove(rem);
      }
      System.out.println("进行了，一半删除");
    }

    System.out.println("集合长度" + list.size());
    // 堵塞一下
    Thread.sleep(100);

    // 剩余内存 现在
    long orz3 = startMem - r.freeMemory();
    System.out.println("剩余内存 现在 = " + orz3);
  }

}

