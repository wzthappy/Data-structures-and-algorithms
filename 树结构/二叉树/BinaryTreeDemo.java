package 数据结构与算法.树结构.二叉树;

public class BinaryTreeDemo {
  public static void main(String[] args) {
    // 先需要创建一颗二叉树
    BinaryTree binaryTree = new BinaryTree();
    // 创建需要的节点
    HeroNode root = new HeroNode(1, "卡卡");
    HeroNode node2 = new HeroNode(2, "小小");
    HeroNode node3 = new HeroNode(3, "凤凤");
    HeroNode node4 = new HeroNode(4, "西西");
    HeroNode node5 = new HeroNode(5, "哈哈");

    // 声明: 我们先手动创建二叉树，后面我们学习递归的方式创建二叉树
    root.setLeft(node2);
    root.setRight(node3);
    node3.setLeft(node5);
    node3.setRight(node4);

    binaryTree.setRoot(root);

    // 测试
    System.out.println("前序遍历");
    binaryTree.preOrder(); // 1，2，3，5，4  中 左 右

    // 测试
    System.out.println("中序遍历");
    binaryTree.infixOrder();  // 2，1，5，3，4  左 中 右

    // 测试
    System.out.println("后序遍历");
    binaryTree.postOrder();  // 2，5，4，3，1  左 右 中

    System.out.println("======================");

    // 前序查找 5(左叶子节点)
    //     前序遍历的次数 4
    System.out.println("前序查找~~~~");
    HeroNode resNode = binaryTree.preOrderSearch(5);
    if (resNode != null) {
      System.out.printf("找到了，信息为no=%d name=%s", resNode.getNo(), resNode.getName());
    } else {
      System.out.println("没有找到no=5的用户");
    }
    System.out.println();
    System.out.println("==================");

    // 中序查找 5(左叶子节点)
    // 中序查找的次数 3
    System.out.println("中序查找~~~~");
    resNode = binaryTree.infixOrderSearch(5);
    if (resNode != null) {
      System.out.printf("找到了，信息为no=%d name=%s", resNode.getNo(), resNode.getName());
    } else {
      System.out.println("没有找到no=5的用户");
    }
    System.out.println();
    System.out.println("==================");

    // 后序查找 5(左叶子节点)
    // 后序查找的次数 2
    System.out.println("后序查找~~~~");
    resNode = binaryTree.postOrderSearch(5);
    if (resNode != null) {
      System.out.printf("找到了，信息为no=%d name=%s", resNode.getNo(), resNode.getName());
    } else {
      System.out.println("没有找到no=5的用户");
    }

    System.out.println("==========================");
    // 测试删除
    System.out.println("删除前，前序遍历");
    binaryTree.preOrder();
//    binaryTree.delNode(5);
    binaryTree.delNode(3);
    System.out.println("删除后，前序遍历");
    binaryTree.preOrder();
  }
}
