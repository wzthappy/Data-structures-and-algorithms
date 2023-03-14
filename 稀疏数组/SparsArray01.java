package 数据结构与算法.稀疏数组;

import java.io.*;

public class SparsArray01 {
  public static void main(String[] args) throws IOException {
    // TODO: 创建一个原始的二位数组 11 * 11
    // 0: 表示没有棋子  1: 表示 黑子   2: 表示 百字
    int[][] chessArr1 = new int[11][11];
    chessArr1[1][2] = 1;
    chessArr1[2][3] = 2;
    chessArr1[4][5] = 2;
    // 输出原始的二维数组
    System.out.println("原始的二维数组: ");
    for (int[] row : chessArr1) {
      for (int data : row) {
        System.out.printf("%d\t", data);
      }
      System.out.println();
    }

    // TODO: 将二维数组 转 稀疏数组的思路
    // 1. 先遍历二维数组 等到非0数据个数
    int sum = 0;
    for (int[] ints : chessArr1) {
      for (int data : ints) {
        if (data != 0) {
          sum++;
        }
      }
    }
    // 2. 创建对应的稀疏数组
    int sparseArr[][] = new int[sum + 1][3];
    // 给稀疏数组赋值
    sparseArr[0][0] = 11;
    sparseArr[0][1] = 11;
    sparseArr[0][2] = sum;  // 第一行的数据

    // 遍历二维数组，将非0的值存放到 sparseArr数组中
    int count = 0;  // count 用于
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        if (chessArr1[i][j] != 0) {
          count++;
          sparseArr[count][0] = i;  // 他的行
          sparseArr[count][1] = j;  // 他的列
          sparseArr[count][2] = chessArr1[i][j]; // 他的值
        }
      }
    }

    // 输出稀疏数组的形式
    System.out.println("对应的稀疏数组为: ");
    for (int i = 0; i < sparseArr.length; i++) {
      System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
    }


    // TODO: 将稀疏数组 --> 恢复成 原始的二维数组
    // 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
    int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

    // 2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可
    for (int i = 1; i < sparseArr.length; i++) {
      chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
    }

    // 输出恢复后的二维数组
    System.out.println();
    System.out.println("恢复后的二维数组: ");
    for (int[] row : chessArr2) {
      for (int data : row) {
        System.out.printf("%d\t", data);
      }
      System.out.println();
    }




    System.out.println("-------------------");
    // TODO: 把稀疏数组存储到文件中(磁盘)
    String file = "src/数据结构与算法/数据结构/稀疏数组/正则表达式.txt";
    // 创建 字节输出流(缓冲流)
//    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file, true));
//    for (int i = 0; i < sparseArr.length; i++) {
//      for (int j = 0; j < sparseArr[0].length; j++) {
//        byte[] bytes = (sparseArr[i][j] + " ").getBytes();
//        out.write(bytes);
//      }
//      out.write("\n".getBytes());
//    }
//    out.flush();  // 刷新
//    out.close();  // 关闭流
    // TODO: 把稀疏数组读取出来
    // 创建 字节输入流
    String s = null;
    BufferedInputStream inp = new BufferedInputStream(new FileInputStream(file));
    byte[] b = new byte[1024];
    int len;
    while ((len = inp.read(b)) != -1) {
      s = new String(b, 0, len);
      System.out.println(s);
    }
    // 恢复原始数组
    String[] split = s.split("\n");
    String[] s1 = split[0].split(" ");
    int sparseArray[][] = new int[Integer.parseInt(s1[0])][Integer.parseInt(s1[1])];
    for (int i = 1; i < split.length; i++) {
      String[] s2 = split[i].split(" ");
      sparseArray[Integer.parseInt(s2[0])][Integer.parseInt(s2[1])] = Integer.parseInt(s2[2]);
    }

    for (int[] ints : sparseArray) {
      for (int data : ints) {
        System.out.printf("%d\t", data);
      }
      System.out.println();
    }
  }
}
