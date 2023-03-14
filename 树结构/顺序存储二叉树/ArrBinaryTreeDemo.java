package 数据结构与算法.树结构.顺序存储二叉树;

public class ArrBinaryTreeDemo {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    // 创建一个ArrayBinaryTree
    ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
//    arrayBinaryTree.preOrder(0);
    arrayBinaryTree.preOrder();
  }
}
