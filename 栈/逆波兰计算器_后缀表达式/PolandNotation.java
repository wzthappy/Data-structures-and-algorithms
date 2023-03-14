package 数据结构与算法.栈.逆波兰计算器_后缀表达式;

import 数据结构与算法.栈.逆波兰计算器_后缀表达式.中缀表达式转后缀表达式.InfixTurnSuffix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
  public static void main(String[] args) {
    // 先定义一个逆波兰表达式
    // (30+4)*5-6  =>  3 4 + 5 * 6 -
    // 4 * 5 -8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +
    // 为了方便，逆波兰表达式 的数字和符号使用空格隔开
//    String suffixExpression = "30 4 + 5 * 6 -";
    String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
    // 思路
    // 1. 先将"3 4 + 5 * 6 -" => 放到ArrayList中
    // 2. 将 ArrayList 传递给一个方法，遍历ArrayList 配合栈 完成计算

    List<String> rpnList = getListString(suffixExpression);
    System.out.println("rpnList=" + rpnList);

    int res = calculate(rpnList);
    System.out.println("计算的结果是=" + res);

    System.out.println("===================================");

    String expression = "1+((2+3)*4)-5";  // 中缀
    List<String> list = InfixTurnSuffix.toInfixExpressionList(expression);
    System.out.println("中缀表达式对应的List" + list);
    List<String> list1 = InfixTurnSuffix.parseSuffixExpressionList(list);
    System.out.println("后缀表达式对应的List" + list1);
    int calculate = calculate(list1);
    System.out.println("计算的结果是=" + calculate);
  }
  // 将一个逆波兰表达式，依次将数据和运算符 放入到 ArrayList中
  public static List<String> getListString(String suffixExpression) {
    // 将suffixExpression 分割
    String[] split = suffixExpression.split(" ");
    List<String> list = new ArrayList<String>();
    for (String ele : split) {
      list.add(ele);
    }
    return list;
  }

  // 完成对逆波兰表达式的运算
  public static int calculate(List<String> ls) {
    // 创建一个栈，只需要一个栈即可
    Stack<String> stack = new Stack<>();
    // 遍历 ls
    for (String item : ls) {
      // 这里使用正则表达式来取出数
      if (item.matches("\\d+")) {  // 匹配的是多位数
        // 入栈
        stack.push(item);
      } else {
        // pop出两个数，并运算，在入栈
        int num2 = Integer.parseInt(stack.pop());
        int num1 = Integer.parseInt(stack.pop());
        int res = 0;
        if (item.equals("+")) {
          res = num1 + num2;
        } else if (item.equals("-")) {
          res = num1 - num2;
        } else if (item.equals("*")) {
          res = num1 * num2;
        } else if (item.equals("/")) {
          res = num1 / num2;
        } else {
          throw new RuntimeException("运算符有误");
        }
        // 把res 入栈
        stack.push(res + "");
      }
    }
    // 最后留在stack中的数据是运算符结果
    return Integer.parseInt(stack.pop());
  }
}
