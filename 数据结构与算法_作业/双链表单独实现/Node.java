package 数据结构与算法.数据结构与算法_作业.双链表单独实现;

public class Node {
  public Node lfet;
  public Data data;
  public Node reft;


  // 添加数据
  public void add(Node node) {
    if (this.reft != null) {
      this.reft.add(node);
    }
    if (this.reft == null) {
      this.reft = node;
      node.lfet = this;
    }
  }

  public Node(Data data) {  // 创建结点 数据
    this.data = data;
  }

  public Node() {
  }

  @Override
  public String toString() {
    return "Node{" +
        "data=" + data +
        '}';
  }
}
