package 数据结构与算法.数据结构与算法_作业.双链表单独实现;

import java.util.Objects;
import java.util.UUID;

public class LinkList {
  private Node hade = null; // 根结点

  public LinkList() {
    hade = new Node(new Data(null, null, null));
  }

  // 添加数据
  public void add(Node node) {
    Node p = hade;
    p.add(node);
  }

  public static void main(String[] args) {
    LinkList l = new LinkList();
    l.add(new Node(new Data("2", "2", "2")));
    l.add(new Node(new Data("3", "3", "3")));
    System.out.println(l.hade.data);
    System.out.println(l.hade.reft);
    System.out.println(l.hade.reft.reft);
  }

  private String getUUId() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
}
