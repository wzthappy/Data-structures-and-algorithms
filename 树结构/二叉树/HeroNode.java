package 数据结构与算法.树结构.二叉树;

// 创建结点
public class HeroNode {
  private int no;
  private String name;
  private HeroNode left;  // 默认null  左
  private HeroNode right;  // 默认null  右

  public HeroNode(int no, String name) {
    this.no = no;
    this.name = name;
  }

  // 递归删除结点
  // 1. 如果删除的结点是叶子结点，则删除该结点
  // 2. 如果删除的结点是非叶子结点，则删除该子树
  public void delNode(int no) {
    // 1. 因为我们的二叉树是单向的，所有我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点
    // 2. 如果当前结点的左子结点不为空，并且左子结点，就是要删除的结点，就将this.left = null; 并且就返回(结束递归删除)
    if (this.left != null && this.left.no == no) {
      this.left = null;
      return;
    }
    // 3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除的结点，就将this.right = null; 并且就返回(结束递归删除)
    if (this.right != null && this.right.no == no) {
      this.right = null;
      return;
    }
    // 4. 我们会需要向左子树进行递归删除
    if (this.left != null) {
      this.left.delNode(no);
    }
    // 5. 则应该向右子树进行递归删除
    if (this.right != null) {
      this.right.delNode(no);
    }
  }

  // 编写前序遍历的方法    中 左 右
  public void preOrder() {
    System.out.println(this); // 先输出父结点
    // 递归向左子树前序遍历
    if (this.left != null) {
      this.left.preOrder();
    }
    // 递归向右子树前序遍历
    if (this.right != null) {
      this.right.preOrder();
    }
  }

  // 中序遍历   左 中 右
  public void infixOrder() {
    // 递归向左子树中序遍历
    if (this.left != null) {
      this.left.infixOrder();
    }
    // 输出父结点
    System.out.println(this);
    // 递归向右子树中序遍历
    if (this.right != null) {
      this.right.infixOrder();
    }
  }

  // 后序遍历   左 右 中
  public void postOrder() {
    if (this.left != null) {
      this.left.postOrder();
    }
    if (this.right != null) {
      this.right.postOrder();
    }
    System.out.println(this);
  }

  /**
   * 前序遍历查找
   *
   * @param no 查找的no
   * @return 如果查找到就返回该Node，如果没有找到就返回null
   */
  public HeroNode preOrderSearch(int no) {
    System.out.println("运行了~次");
    // 比较当前结点是不是
    if (this.no == no) {
      return this;
    }
    // 1. 则判断当前结点的左子节点是否为空，如果不为空，则递归查找
    // 2. 如果左递归查找，找到结点，则返回
    HeroNode resNode = null;
    if (this.left != null) {
      resNode = this.left.preOrderSearch(no);
    }
    if (resNode != null) {  // 声明我们左子树找到
      return resNode;
    }

    // 1. 左递归前序查找，找到结点，则返回，否则继续
    // 2. 当前的结点的右子节点是否为空，如果不空，则继续向右递归前序查找
    if (this.right != null) {
      resNode = this.right.preOrderSearch(no);
    }

    return resNode;  // 不管右序是否找到，直接返回
  }

  // 中序遍历查找
  public HeroNode infixOrderSearch(int no) {
    HeroNode resNode = null;
    // 判断当前结点的左子节点是否为空，如果不为空，则递归中序查找
    if (this.left != null) {
      resNode = this.left.infixOrderSearch(no);
    }
    if (resNode != null) {
      return resNode;
    }

    // 如果没有找到，就和当前结点比较，如果是则返回当前结点比较，如果是则返回当前结点
    System.out.println("运行了~次");
    if (this.no == no) {
      return this;
    }

    // 否则继续进行右递归的中序查找
    if (this.right != null) {
      resNode = this.right.infixOrderSearch(no);
    }
    return resNode;
  }

  // 后续遍历查找
  public HeroNode postOrderSearch(int no) {
    HeroNode resNode = null;
    // 判断当前结点的左节点是否为空，如果不为空，则递归后查找
    if (this.left != null) {
      resNode = this.left.postOrderSearch(no);
    }
    if (resNode != null) { // 说明在左子树找到
      return resNode;
    }

    // 如果左子树没有找到，则向右子树递归进行后序遍历查找
    if (this.right != null) {
      resNode = this.right.postOrderSearch(no);
    }
    if (this.right != null) {
      return resNode;
    }

    // 如果左右子树都没有找到，就比较当前节点是不是
    System.out.println("运行了~次");
    if (this.no == no) {
      return this;
    }

    return resNode;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HeroNode getLeft() {
    return left;
  }

  public void setLeft(HeroNode left) {
    this.left = left;
  }

  public HeroNode getRight() {
    return right;
  }

  public void setRight(HeroNode right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return "HeroNode{" +
        "no=" + no +
        ", name='" + name + '\'' +
        '}';
  }
}
