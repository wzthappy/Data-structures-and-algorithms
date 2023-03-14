package 数据结构与算法.赫夫曼树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
  public static void main(String[] args) {
    int arr[] = {13, 7, 8, 3, 29, 6, 1};

    Node root = createHuffmanTree(arr);

    System.out.println("---------------");
    // 测试一把
    preOrder(root);
  }

  // 编写一个前序遍历的方法
  public static void preOrder(Node root) {
    if (root != null) {
      root.preOrder();
    } else {
      System.out.println("是空数，不能遍历~~");
    }
  }

  /**
   *   创建赫夫曼树的方法
   * @param arr 需要创建赫夫曼树的数组
   * @return 创建好后的赫夫曼树的root结点
   */
  public static Node createHuffmanTree(int[] arr) {
    // 第一步为了操作方便
    // 1. 遍历 arr 数组
    // 2. 将arr的每一个元素构成一个Node
    // 3. 将Node 放入到ArrayList中
    List<Node> nodes = new ArrayList<>();
    for (int value : arr) {
      nodes.add(new Node(value));
    }

    // 我们处理的过程是一个循环的过程
    while (nodes.size() > 1) {

      Collections.sort(nodes);   // 排序 从小到大

      System.out.println("nodes = " + nodes);  // nodes = [Node{value=1}, Node{value=3}, Node{value=6}, Node{value=7}, Node{value=8}, Node{value=13}, Node{value=29}]

      // 取出根结点权值最小的两个二叉树
      // 1. 取出权值最小的结点 (二叉树)
      Node leftNode = nodes.get(0);
      // 2. 取出权值第二小的结点 (二叉树)
      Node rightNode = nodes.get(1);

      // 3. 构建一颗新的二叉树
      Node parent = new Node(leftNode.value + rightNode.value);
      parent.left = leftNode;
      parent.right = rightNode;

      // 4. 从ArrayList 删除 处理过 的二叉树
      nodes.remove(leftNode);
      nodes.remove(rightNode);

      // 5. 将parent加入到nodes
      nodes.add(parent);

//    Collections.sort(nodes); // 排序
      System.out.println("第一次处理后 " + nodes);  // 第一次处理后 [Node{value=6}, Node{value=7}, Node{value=8}, Node{value=13}, Node{value=29}, Node{value=4}]
    }
    // 返回赫夫曼树的root结点
    return nodes.get(0);
  }
}
