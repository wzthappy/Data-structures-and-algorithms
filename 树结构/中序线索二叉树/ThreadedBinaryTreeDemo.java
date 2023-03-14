package 数据结构与算法.树结构.中序线索二叉树;

public class ThreadedBinaryTreeDemo {
  public static void main(String[] args) {
    // 测试一把中序线索二叉树的功能
    HeroNode root = new HeroNode(1, "代码");
    HeroNode node2 = new HeroNode(3, "自己打");
    HeroNode node3 = new HeroNode(6, "史密斯");
    HeroNode node4 = new HeroNode(8, "玛丽");
    HeroNode node5 = new HeroNode(10, "pink");
    HeroNode node6 = new HeroNode(14, "迪迦");
    // 二叉树，后面我们要递归创建，现在简单处理使用手动创建
    root.setLeft(node2);
    root.setRight(node3);
    node2.setLeft(node4);
    node2.setRight(node5);
    node3.setLeft(node6);

    // 测试中序线索化
    ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
    threadedBinaryTree.setRoot(root);
    threadedBinaryTree.threadedNode();

    // 测试: 以10号结点测试
    HeroNode leftNode = node5.getLeft();
    HeroNode rightNode = node5.getRight();
    System.out.println("10号结点的前驱结点是" + leftNode);
    System.out.println("10号结点的后继结点是" + rightNode);

    System.out.println("====================");
    // 当线索化二叉树后，不能在使用原来的遍历方式
    System.out.println("使用线索化的方式遍历 线索化二叉树");
    threadedBinaryTree.threadedList();
  }
}
