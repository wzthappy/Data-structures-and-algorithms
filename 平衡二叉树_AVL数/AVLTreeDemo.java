package 数据结构与算法.平衡二叉树_AVL数;

public class AVLTreeDemo {
  public static void main(String[] args) {
//    int[] arr = {4, 3, 6, 5, 7, 8};
//    int[] arr = {10, 12, 8, 9, 7, 6};
    int[] arr = {10, 11, 7, 6, 8, 9};
    // 创建一个AVLTree对象
    AVLTree avlTree = new AVLTree();
    // 添加结点
    for (int j : arr) {
      avlTree.add(new Node(j));
    }

    // 遍历
    System.out.println("中序遍历");
    avlTree.infixOreder();

//    System.out.println("------- 二叉排序数 在没有做平衡处理前 的高度 -------");
//    System.out.println("树的高度 = " + 4);
//    System.out.println("数的左子树的高度 = " + 1);
//    System.out.println("数的右子树的高度 = " + 3);

    System.out.println("------- 在平衡处理后 的高度 -------");
    System.out.println("树的高度 = " + avlTree.getRoot().height());
    System.out.println("数的左子树的高度 = " + avlTree.getRoot().leftHeight());
    System.out.println("数的右子树的高度 = " + avlTree.getRoot().rightHeight());
    System.out.println("当前的根结点 = " + avlTree.getRoot());
    System.out.println("根结点的左子结点 = " + avlTree.getRoot().left);
  }
}
