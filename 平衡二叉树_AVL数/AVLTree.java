package 数据结构与算法.平衡二叉树_AVL数;

// 创建 AVLTree
public class AVLTree {
  private Node root;

  // 查找要删除的结点
  public Node search(int value) {
    if (root == null) {
      return null;
    } else {
      return root.search(value);
    }
  }

  // 查找要删除的父结点
  public Node searchParent(int value) {
    if (root == null) {
      return null;
    } else {
      return root.searchParent(value);
    }
  }

  /**
   * 编写方法
   * 1. 返回的 以node 为根结点的二叉排序树的最小结点的值
   * 2. 删除node 为根结点的二叉树排序数的最小结点
   *
   * @param node node 传入的结点(当做二叉树的根结点)    他是要删除结点 的 右子结点
   * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
   */
  public int delRightTreeMin(Node node) {
    Node target = node;
    // 循环的查找左结点，就会找到最小值
    while (target.left != null) {
      target = target.left;
    }
    // 这是 target 就指向了最小结点
    delNode(target.value); // 删除最小结点
    return target.value;
  }

  // 删除结点
  public void delNode(int value) {
    if (root == null) {
      return;
    } else {
      // 1. 需求先去找到要删除的结点
      Node targetNode = search(value);
      // 如果没有找到要删除的结点
      if (targetNode == null) {
        return;
      }
      // 如果我们发现当前这颗二叉树只有一个结点
      if (root.left == null && root.right == null) {
        root = null;
      }
      // 找到要删除的父结点
      Node parent = searchParent(value);
      if (targetNode.left == null && targetNode.right == null) { // 如果删除的结点是叶子结点
        if (parent == null) { // 没有找到要删除结点没有父结点  他就是根结点
          targetNode = null;
        } else {
          // 判断要删除的结点是 父结点的左子结点，还是右子结点
          if (parent.left != null && parent.left.value == value) { // 是左子结点
            parent.left = null;
          } else if (parent.right != null && parent.right.value == value) { // 是右子结点
            parent.right = null;
          }
        }
      } else if (targetNode.left != null && targetNode.right != null) { //  删除右两颗子树的结点
        int minVal = delRightTreeMin(targetNode.right);
        targetNode.value = minVal;
      } else { // 删除只右一颗子树的结点
        // 如果要删除的结点 有 左子结点
        if (targetNode.left != null) {
          if (parent == null) {  // 没有找到要删除结点没有父结点  他就是根结点
            root = targetNode.left;
          } else {
            // 如果 要删除的结点 是 父结点的左子结点
            if (parent.left.value == value) {
              parent.left = targetNode.left;
            } else { // 要删除的结点 是 父结点的右子结点
              parent.right = targetNode.left;
            }
          }
        } else { // 如果要删除的结点 有 右子结点
          if (parent == null) {  // 没有找到要删除结点没有父结点  他就是根结点
            root = targetNode.right;
          } else {
            // 如果要删除的结点 是 父结点的左子结点
            if (parent.left.value == value) {
              parent.left = targetNode.right;
            } else { // 如果 要删除的结点是 父节点的右子结点
              parent.right = targetNode.right;
            }
          }
        }
      }
    }
  }

  // 添加结点的方法
  public void add(Node node) {
    if (root == null) {
      root = node; // 如果root为空则直接让root指向node
    } else {
      root.add(node);
    }
  }

  // 中序遍历
  public void infixOreder() {
    if (root != null) {
      root.infixOrder();
    } else {
      System.out.println("二叉排序树为空，不能遍历");
    }
  }

  public Node getRoot() {
    return root;
  }
}
