package 数据结构与算法.二叉排序树;

public class BinarySortTreeDemo {
  public static void main(String[] args) {
    int[] arr = {7, 3, 10, 12, 5, 1, 9, 0};
    BinarySortTree binarySortTree = new BinarySortTree();
    // 循环的添加结点搭配二叉排序树
    for (int i = 0; i < arr.length; i++) {
      binarySortTree.add(new Node(arr[i]));
    }

    // 中序排序二叉排序树
    System.out.println("中序遍历二叉排序树~~");
    binarySortTree.infixOreder();

    // 测试一下删除叶子结点
//    binarySortTree.delNode(2);
//    binarySortTree.delNode(5);
//    binarySortTree.delNode(1);
//    binarySortTree.delNode(0);
//    binarySortTree.delNode(7);
    binarySortTree.delNode(10);

    System.out.println("--------------");
    System.out.println("root结点的值 = " + binarySortTree.getRoot());

    System.out.println("-------删除结点后-------");
    binarySortTree.infixOreder();
  }
}
