package 数据结构与算法.栈.逆波兰计算器_后缀表达式.中缀表达式转后缀表达式;

/**
 * 编写一个类 Operation 可以放回一个运算符 对应的优先级
 */
public class Operation {
  private static int ADD = 1;
  private static int SUB = 1;
  private static int DUL = 2;
  private static int DIV = 2;

  // 写一个方法，放回对应的优先级数字
  public static int getValue(String operation) {
    int result = 0;
    switch (operation) {
      case "+":
        result = ADD;
        break;
      case "-":
        result = SUB;
        break;
      case "*":
        result = DUL;
        break;
      case "/":
        result = DIV;
        break;
      default:
        System.out.println("不存在该运算符");
        break;
    }
    return result;
  }
}
