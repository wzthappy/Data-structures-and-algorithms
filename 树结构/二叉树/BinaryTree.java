package 数据结构与算法.树结构.二叉树;

/**
 * 定义 二叉树
 */
public class BinaryTree {
  private HeroNode root;

  public void setRoot(HeroNode root) {
    this.root = root;
  }

  // 删除结点
  public void delNode(int no) {
    if (this.root != null) {
      // 如果只有一个root结点，这里立即判断root是不是就是要删除的结点
      if (this.root.getNo() == no) {
        this.root = null;
      } else {
        this.root.delNode(no);
      }
    } else {
      System.out.println("二叉树为空，无法删除");
    }
  }

  // 前序遍历
  public void preOrder() {
    if (this.root != null) {
      this.root.preOrder();
    } else {
      System.out.println("二叉树为空，无法遍历");
    }
  }

  // 中序遍历
  public void infixOrder() {
    if (this.root != null) {
      this.root.infixOrder();
    } else {
      System.out.println("二叉树为空，无法遍历");
    }
  }

  // 后续遍历
  public void postOrder() {
    if (this.root != null) {
      this.root.postOrder();
    } else {
      System.out.println("二叉树为空，无法遍历");
    }
  }

  // 前序查找
  public HeroNode preOrderSearch(int no) {
    if (root != null) {
      return root.preOrderSearch(no);
    } else {
      return null;
    }
  }

  // 中序查找
  public HeroNode infixOrderSearch(int no) {
    if (root != null) {
      return root.infixOrderSearch(no);
    } else {
      return null;
    }
  }

  // 后序查找
  public HeroNode postOrderSearch(int no) {
    if (root != null) {
      return root.postOrderSearch(no);
    } else {
      return null;
    }
  }
}
