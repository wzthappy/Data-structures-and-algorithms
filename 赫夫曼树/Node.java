package 数据结构与算法.赫夫曼树;

/**
 * 创建结点类
 * 为了让Node 对象持续排序Collections集合排序
 * 让Node 实现Complement接口
 */
public class Node implements Comparable<Node> {
  int value; // 结点权值
  Node left; // 指向左子结点
  Node right; // 指向右子结点

  // 写一个前序遍历
  public void preOrder() {
    System.out.println(this);
    if (this.left != null) {
      this.left.preOrder();
    }
    if (this.right != null) {
      this.right.preOrder();
    }
  }

  public Node(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Node{" +
        "value=" + value +
        '}';
  }

  @Override
  public int compareTo(Node o) {  // 自动 排序
    // 表示从小到大排序
    return this.value - o.value;
  }
}