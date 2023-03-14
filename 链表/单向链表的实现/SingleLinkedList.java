package 数据结构与算法.链表.单向链表的实现;

// 定义SingleLinkedList 管理我们的人物
public class SingleLinkedList {
  // 先初始化一个头节点，头节点不要动，不存放具体的数据
  private HeroNode head = new HeroNode(0, "", "");

  // 返回头节点
  public HeroNode getHead() {
    return head;
  }

  // 添加节点到单向链表
  // TODO: 思路: 当不考虑编号的顺序是
  // 1. 找到当前链表的最后节点
  // 2. 将最后这个节点的next 指向 新的节点
  public void add(HeroNode heroNode) {
    // 因为head节点不能动，因此我们需要一个辅助遍历 temp
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
    // 将最后这个节点的next 指向 新的节点
    temp.next = heroNode;
  }

  // TODO: 第二种方式在添加人物时，根据排名将人物插入到指定位置
  // (如果没有这个排名，则添加失败，并给出提示)
  public void addByOrder(HeroNode heroNode) {
    // 因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
    // 因为这是一个单链表,因此我们找的temp 是位于 添加位置的前一个节点，否则插入不了
    HeroNode temp = head;
    boolean flag = false; // flag标识添加的编号是否存在，默认为false
    while (true) {
      if (temp.next == null) {  // 说明temp已经在链表的最后
        break;
      }
      if (temp.next.no > heroNode.no) {  // 位置找到，就在temp的后面插入
        break;
      } else if (temp.next.no == heroNode.no) {  // 说明希望添加的heroNode的编号已然存在
        flag = true;  // 说明编号存在
        break;
      }
      temp = temp.next;  // 后移，遍历当前链表
    }
    // 判断flag 的值
    if (flag) {  // 不能添加，说明编号存在
      System.out.printf("准备插入的人物的编号 %d 已经存在了，不能加入\n", heroNode.no);
    } else {
      // 加入到链表中，temp的后面
      heroNode.next = temp.next;
      temp.next = heroNode;
    }
  }

  // TODO: 删除节点
  // 思路
  // 1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
  // 2. 说明我们在比较时，是temp.next.no 和 需要删除节点的no比较
  public void del(int no) {
    HeroNode temp = head;
    boolean flag = false;  // 标识是否找到待删除的前一个节点
    while (true) {
      if (temp.next == null) {  // 已经找到链表的最后
        break;
      }
      if (temp.next.no == no) {
        // 找到了待删除节点的前一个节点temp
        flag = true;
        break;
      }
      temp = temp.next;  // temp后移，遍历
    }
    // 判断flag
    if (flag) { // 找到
      // 可以删除
      temp.next = temp.next.next;
    } else {
      System.out.printf("要删除的%d 节点不存在\n", no);
    }
  }

  // TODO: 修改节点的信息，根据no编号来修改，即no编号不能改
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
