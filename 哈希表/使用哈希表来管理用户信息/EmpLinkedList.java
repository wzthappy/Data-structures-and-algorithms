package 数据结构与算法.哈希表.使用哈希表来管理用户信息;

/**
 * 创建 列表
 */
public class EmpLinkedList {
  // 头指针，指向第一个Emp，因此我们这个列表的head 是直接指向第一个Emp
  private Emp head; // 默认为空 null

  // 添加用户到列表
  // 说明:
  // 1. 假定，当添加用户时，id 是自增长，即id的分配总是从小到大
  //      因此我们将该雇员直接加入到列表的最后即可
  public void add(Emp emp) {
    // 如果是添加第一个用户
    if (head == null) {
      head = emp;
      return;
    }
    // 如果不是第一个用户，则使用一个辅助的指针，帮助定位到最后
    Emp curEmp = head;
    while (true) {
      if (curEmp.next == null) {  // 说明链表到最后
        break;
      }
      curEmp = curEmp.next;  // 后移
    }
    // 退出时直接将emp 加入链表
    curEmp.next = emp;
  }

  // 遍历链表得到用户信息
  public void list(int no) {
    no++;
    if (head == null) {  // 说明链表为空
      System.out.println("第" + no + "链表为空");
      return;
    }
    System.out.print("第" + no + "链表的消息为:");
    Emp curEmp = head;  // 辅助指针
    while (true) {
      System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
      if (curEmp.next == null) { // 说明curEmp已经是最后结点
        break;
      }
      curEmp = curEmp.next;  // 后移，遍历
    }
    System.out.println();
  }

  // 根据id 查找用户
  // 如果查找到，就返回Emp，如果没有找到，就返回null
  public Emp findFmpById(int id) {
    // 判断链表是否为空
    if (head == null) {
      System.out.println("链表为空");
      return null;
    }
    // 辅助指针
    Emp curEmp = head;
    while (true) {
      if (curEmp.id == id) { // 找到
        break; // 这时curEmp就指向要找到用户
      }
      // 退出
      if (curEmp.next == null) {  // 声明遍历当前链表没有找到用户
        curEmp = null;
        break;
      }
      curEmp = curEmp.next;
    }
    return curEmp;
  }

  // 通过id删除对应用户
  public void delete(int id) {
    // 判断链表是否有值
    if (head == null) {
      System.out.println("没有一条数值");
      return;
    }
    Emp temp = head;
    while (true) {
      if (head.id == id) { // 判断是否要删除的是头结点
        head = head.next;
        break;
      }

      if (temp.next == null) {  // 没有找到
        System.out.println("没有你要删除的数据");
        break;
      }

      if (temp.next.id == id) { // 找到了
        temp.next = temp.next.next;
        break;
      }

      temp = temp.next; // 后移
    }
  }
}
