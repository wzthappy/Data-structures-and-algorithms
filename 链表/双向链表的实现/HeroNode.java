package 数据结构与算法.链表.双向链表的实现;

public class HeroNode {
  public int no;
  public String name;
  public String nickname;

  public HeroNode next;  // 指向下一个节点，默认为null

  public HeroNode pre;  // 指向前一个节点，默认为null

  // 构造器
  public HeroNode(int no, String name, String nickname) {
    this.no = no;
    this.name = name;
    this.nickname = nickname;
  }

  // 为了显示方便，我们重写toString
  @Override
  public String toString() {
    return "HeroNode{" +
        "no=" + no +
        ", name='" + name + '\'' +
        ", nickname='" + nickname + '\'' +
        '}';
  }
}
