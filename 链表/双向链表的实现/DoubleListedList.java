package 数据结构与算法.链表.双向链表的实现;

// 创建一个双向链表的类
public class DoubleListedList {
  // 先初始化一个头节点，头节点不要动，不存放具体的数据
  private HeroNode head = new HeroNode(0, "", "");

  // 返回头节点
  public HeroNode getHead() {
    return head;
  }

  // TODO: 思路: 当不考虑编号的顺序是
  // 添加一个节点到双向链表的最后
  public void add(HeroNode heroNode) {
    HeroNode temp = head;
    // 遍历链表，找到最后
    while (true) {
      // 找到链表的最后
      if (temp.next == null) {
        break;
      }
      // 如果没有找到最后，将temp后移
      temp = temp.next;
    }
    // 当退出while循环时，temp就指向了链表的最后
    // 形成一个双向链表
    temp.next = heroNode;
    heroNode.pre = temp;
  }

  // TODO: 修改节点的信息，根据no编号来修改，即no编号不能改    修改内容双向链表和单向链表一样
  // 说明
  // 1. 根据 newHeroNode 的 no 来修改即可
  public void update(HeroNode newHeroNode) {
    // 判断是否为空
    if (head.next == null) {
      System.out.println("链表为空~~~");
      return;
    }
    // 找到需要修改的节点，根据no编号
    // 定义一个辅助变量
    HeroNode temp = head.next;
    boolean flag = false;  // 表示是否找到该节点
    while (true) {
      if (temp.next == null) {
        break; // 已经遍历完链表
      }
      if (temp.next.no == newHeroNode.no) {
        // 找到了
        flag = true;
        break;
      }
      temp = temp.next;
    }
    // 根据flag 判断是否找到要修改的节点
    if (flag) {
      // 找到了
      temp.next.name = newHeroNode.name;
      temp.next.nickname = newHeroNode.nickname;
    } else {  //没有找到
      System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
    }
  }

  // TODO: 从双向链表中删除一个节点
  // 说明:
  // 1. 对于双向链表，我们可以直接找到要删除的这个节点
  // 2. 找到后，自我删除即可
  public void del(int no) {
    // 判断当前链表是否为空
    if (head.next == null) {  // 空链表
      System.out.println("链表为空，无法删除");
      return;
    }
    HeroNode temp = head.next;  // 辅助变量(指针)
    boolean flag = false;  // 标识是否找到待删除的前一个节点
    while (true) {
      if (temp == null) {  // 已经找到链表的最后
        break;
      }
      if (temp.no == no) {
        // 找到了待删除节点temp
        flag = true;
        break;
      }
      temp = temp.next;  // temp后移，遍历
    }
    // 判断flag
    if (flag) { // 找到
      // 可以删除
//      temp.next = temp.next.next;  [单向链表]
      temp.pre.next = temp.next;
      if (temp.next != null) {  // 如果是最后一个节点，就不需要执行下面这句话，否则会出现空指针异常
        temp.next.pre = temp.pre;
      }
    } else {
      System.out.printf("要删除的%d 节点不存在\n", no);
    }
  }

  // 遍历双向链表
  // TODO: 显示链表【遍历】
  public void list() {
    // 先判断链表是否为空
    if (head.next == null) {
      System.out.println("链表为空");
      return;
    }
    // 因为头节点，不能动，因此我们需要一个辅助变量来变量
    HeroNode temp = head.next;
    while (true) {
      // 判断是否到链表最后
      if (temp == null) {
        break;
      }
      // 输出节点的信息
      System.out.println(temp);
      // 将temp后移，一定小心
      temp = temp.next;
    }
  }
}
