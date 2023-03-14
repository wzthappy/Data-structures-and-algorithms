package 数据结构与算法.链表.单向环形链表;

// 创建一个环形的单向列表
public class CircleSingleLinkedList {
  // 创建一个first节点，当前没有编号
  private Boy first = null;

  // 添加小孩节点，构建成一个环形的列表
  public void addBoy(int nums) {
    // nums 做一个数据校验
    if (nums < 1) {
      System.out.println("nums的值不正确");
      return;
    }
    Boy curBoy = null;   // 赋值指针，帮助构建环形列表
    // 使用for来创建我们的环形列表
    for (int i = 1; i <= nums; i++) {
      // 根据编号，创建小孩节点
      Boy boy = new Boy(i);
      // 如果是第一个小孩
      if (i == 1) {
        first = boy;
        first.setNext(first);  // 构成环
        curBoy = first;  // 让curBoy指向第一个小孩
      } else {
        curBoy.setNext(boy);
        boy.setNext(first);
        curBoy = boy;
      }
    }
  }

  // 遍历当前的环形列表
  public void showBoy() {
    // 判断列表是否为空
    if (first == null) {
      System.out.println("没有任何小孩~~~");
      return;
    }
    // 因为first不能动，因此我们仍然使用一个辅助指针完成遍历
    Boy curBoy = first;
    while (true) {
      System.out.printf("小孩的编号 %d\n", curBoy.getNo());
      if (curBoy.getNext() == first) {  // 说明已经遍历完毕
        break;
      }
      curBoy = curBoy.getNext();  // curBoy后移
    }
  }

  /**
   * 根据用户的输入，计算出小孩出圈的顺序
   *
   * @param startNo  表示从第几个小孩开始数数
   * @param countNum 表示数几下
   * @param nums     表示最初有多少小孩在圈中
   */
  public void countBoy(int startNo, int countNum, int nums) {
    // 先对数据进行校验
    if (first == null || startNo < 1 || startNo > nums) {
      System.out.println("参数输入有误，请重新输入");
      return;
    }
    // 创建一个辅助指针，帮助完成小孩出圈, 事先应该指向环形链表的最后这个节点
    Boy helper = first;
    while (true) {
      if (helper.getNext() == first) {  // 说明helper指向最后小孩节点
        break;
      }
      helper = helper.getNext();
    }
    // 小孩报数前，先让 first 和 helper 移动 k -1 次
    for (int i = 0; i < startNo - 1; i++) {
      first = first.getNext();
      helper = helper.getNext();
    }
    // 当小孩报数时，让first 和 helper 指针同时 的移动 m - 1次，然后出圈
    // 这里是一个循环操作，直到圈中只有一个节点
    while (true) {
      if (helper == first) {  // 说明圈中只有一个节点
        break;
      }
      // 让 first 和 helper 指针同时 的移动 countNum - 1
      for (int i = 0; i < countNum - 1; i++) {
        first = first.getNext();
        helper = helper.getNext();
      }
      // 这时 first 指向的节点，就是要出圈的小孩节点
      System.out.printf("小孩%d出圈了\n", first.getNo());
      // 这时将 first 指向的小孩节点出圈
      first = first.getNext();
      helper.setNext(first);
    }
    System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
  }
}
