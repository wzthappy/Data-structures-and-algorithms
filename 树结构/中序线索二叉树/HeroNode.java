package 数据结构与算法.树结构.中序线索二叉树;

// 创建结点
public class HeroNode {
  private int no;
  private String name;
  private HeroNode left;  // 默认null  左
  private HeroNode right;  // 默认null  右
  // 说明:
  // 1. 如果leftType == 0 表示指向的是左子树，如果为1则表示指向前驱结点
  // 2. 如果rightType == 0 表示指向的是右子树，如果为1则表示指向后续结点
  private int leftType;
  private int rightType;

  public HeroNode(int no, String name) {
    this.no = no;
    this.name = name;
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

  public int getLeftType() {
    return leftType;
  }

  public void setLeftType(int leftType) {
    this.leftType = leftType;
  }

  public int getRightType() {
    return rightType;
  }

  public void setRightType(int rightType) {
    this.rightType = rightType;
  }

  @Override
  public String toString() {
    return "HeroNode{" +
        "no=" + no +
        ", name='" + name + '\'' +
        '}';
  }
}
