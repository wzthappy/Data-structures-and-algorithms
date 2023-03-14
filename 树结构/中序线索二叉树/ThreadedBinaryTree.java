package 数据结构与算法.树结构.中序线索二叉树;

/**
 *  实现了线索化功能的二叉树
 */
public class ThreadedBinaryTree {
  private HeroNode root;

  public void setRoot(HeroNode root) {
    this.root = root;
  }
  // 为了实现线索化，需要创建要指向当前结点的前驱结点的指针
  // 在递归进行线索化时，pre 总是保留前一个结点
  private HeroNode pre = null;

  // 遍历线索二叉树的方法
  public void threadedList() {
    // 定义一个变量，存储当前变量的结点，从root开始
    HeroNode node = root;
    while (node != null) {
      // 循环的找到leftType == 1的结点
      // 后面随着遍历而变化
      // leftType == 1，说明该节点是按照线索化处理后的有效结点
      while (node.getLeftType() == 0) {
        node = node.getLeft();
      }
      // 打印当前这个结点
      System.out.println(node);
      // 如果当前结点的右指针指向的是后继结点，就一直输出
      while (node.getRightType() == 1) {
        // 获取到当前结点的后继结点
        node = node.getRight();
        System.out.println(node);
      }
      // 替换这个遍历的结点
      node = node.getRight();
    }
  }

  // 重载线索化
  public void threadedNode() {
    this.threadedNode(this.root);
  }

  // 编写对二叉树进行中序线序化的方法
  // node  就是当前需要线序化的结点
  public void threadedNode(HeroNode node) {
    // 如果 node == null，不能线索化
    if (node == null) {
      return;
    }
    // (一) 先线索化左子树
    threadedNode(node.getLeft());

    // (二) 线索化当前结点
    // 处理当前结点的前驱结点
    if (node.getLeft() == null) {
      // 让当前结点的左指针指向前驱结点
      node.setLeft(pre);
      // 修改当前结点的左指针的类型，指向前驱结点
      node.setLeftType(1);
    }
    // 处理后续结点
    if (pre != null && pre.getRight() == null) {
      // 让前驱结点的右指针指向当前结点
      pre.setRight(node);
      // 修改前驱结点的右指针类型
      pre.setRightType(1);
    }
    // ！！！每处理一个结点后，让当前结点是下一个结点的前驱结点
    pre = node;

    // (三) 在线索化右子树
    threadedNode(node.getRight());
  }

}
