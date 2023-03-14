package 数据结构与算法.赫夫曼编码_压缩_解压;

import java.io.*;
import java.util.*;

public class HuffmanCode {
  public static void main(String[] args) {
//    String a = "10101000";
//    System.out.println((byte)Integer.parseInt(a, 2));

    String content = "i like like like java do you like a java";
    System.out.println(content);
    byte[] contentBytes = content.getBytes(); // [...]   a --> 9// 7
    System.out.println("源数据 = " + content);
    System.out.println("源数据的字节数组 = " + Arrays.toString(contentBytes) + " 长度 = " + contentBytes.length);

    System.out.println("--------赫夫曼编码 压缩--------");
    byte[] huffmanCodesBytes = huffmanZip(contentBytes);
    System.out.println("压缩后的结果是 = " + Arrays.toString(huffmanCodesBytes) + " 长度 = " + huffmanCodesBytes.length);

    System.out.println("---------解压 后-------");
    byte[] sourceBytes = decode(huffmanCodes, huffmanCodesBytes);
    System.out.println("原来的字符串 = " + new String(sourceBytes));


    System.out.println("-------文件压缩  生成------");
    String srcFile = "F:\\Java\\untitled\\src\\数据结构与算法\\赫夫曼编码_压缩_解压\\要压缩的文件\\big157000.jpg";
    String dstFile = "F:\\Java\\untitled\\src\\数据结构与算法\\赫夫曼编码_压缩_解压\\压缩文件\\big157000.zip";
    zipFile(srcFile, dstFile);
    System.out.println("压缩文件ok");
    System.out.println("-------文件解压  生成--------");
    String zipFile = "F:\\Java\\untitled\\src\\数据结构与算法\\赫夫曼编码_压缩_解压\\压缩文件\\big157000.zip";
    String dstFile2 = "F:\\Java\\untitled\\src\\数据结构与算法\\赫夫曼编码_压缩_解压\\压缩文件\\解压后\\big157000.jpg";
    unZipFile(zipFile, dstFile2);
    System.out.println("解压缩文件ok");

    // 分步过程
    /**
     List<Node> nodes = getNodes(contentBytes);
     System.out.println("nodes =" + nodes); // [Node{data=32, weight=9},....]

     // 测试一把，创建的二叉树
     System.out.println("-------------赫夫曼树 为--------------");
     Node huffmanTreeRoot = createHuffmanTree(nodes);
     System.out.println("前序遍历: ");
     preOrder(huffmanTreeRoot);

     // 测试一把是否生成了对应的赫夫曼编码
     System.out.println("-------赫夫曼编码 表-------");
     //    getCodes(huffmanTreeRoot, "", stringBuilder);
     Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
     System.out.println("生成的赫夫曼编码表" + huffmanCodes);

     // 测试
     System.out.println("-------- 赫夫曼编码(压缩) 后的 byte[]  17个 ---------");
     byte[] huffmanCodeByte = zip(contentBytes, huffmanCodes);
     System.out.println("huffmanCodeByte = " + Arrays.toString(huffmanCodeByte)); // 17个
     **/

    // 发送huffmanCodeBytes 数组
  }

  /**
   *    编写一个方法，完成对压缩文件的解压
   * @param zipFile 准备压缩的文件
   * @param dstFile 将文件压缩到哪个路径
   */
  public static void unZipFile(String zipFile, String dstFile) {
    // 定义文件输入流
    InputStream is = null;
    // 定义一个对象输入流
    ObjectInputStream ois = null;
    // 定义文件的输出流
    OutputStream os = null;
    try {
      // 创建文件输入流
      is = new FileInputStream(zipFile);
      // 创建一个和 is 关联的对象输入流
      ois = new ObjectInputStream(is);
      // 读取byte数组 huffmanBytes    赫夫曼压缩的 字节数组
      byte[] huffmanBytes = (byte[]) ois.readObject();
      // 读取 赫夫曼编码表
      Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
      // 解码
      byte[] bytes = decode(huffmanCodes, huffmanBytes);

      // 将bytes 数组写入到目标文件
      os = new FileOutputStream(dstFile);
      // 写数据到 dstFile 中
      os.write(bytes);

    } catch (Exception e) {
      System.out.println("错误1");
      System.out.println(e.getMessage());
    } finally {
      try {
        if (os != null) {
          os.close();
          ois.close();
          is.close();
        }
      } catch (IOException e) {
        System.out.println("错误2");
        System.out.println(e.getMessage());
      }
    }
  }

  /**
   *    编写方法，将一个文件进行压缩
   * @param srcFile 你传入的希望压缩的文件的全路径
   * @param dstFile 我们压缩后将压缩文件放到哪个目录
   */
  public static void zipFile(String srcFile, String dstFile) {
    // 创建输出流
    FileOutputStream os = null;
    ObjectOutputStream oos = null;
    // 创建文件的输入流
    FileInputStream is = null;
    try {
      is = new FileInputStream(srcFile);
      // 创建一个和源文件大小一样的byte[]
      byte[] b = new byte[is.available()];
      // 读取文件  到 byte[] 中
      is.read(b);
      // 直接对 源文件 压缩
      byte[] huffmanBytes = huffmanZip(b);
      // 创建文件的输出流，存放压缩文件
      os = new FileOutputStream(dstFile);
      // 创建一个和文件输出流相关联的ObjectOutputStream
      oos = new ObjectOutputStream(os); // 对象输出流
      // 把赫夫曼编码后的字节数组写入压缩文件
      oos.writeObject(huffmanBytes);
      // 这里我们以对象流的方式写入 赫夫曼编码，是为了以后我们恢复源文件时使用
      // 注意一定要把赫夫曼编码表 写入压缩文件
      oos.writeObject(huffmanCodes);

    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        is.close();
        oos.close();
        os.close();
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }

  }


  // 完成数据的解压
  // 思路
  // 1. 将huffmanCodeBytes  [-88, -65, -56, -65,...]
  //      重新先转成 赫夫曼编码对应的二进制的字符串 “10101000101111...”
  // 2. 赫夫曼编码对应的二进制的字符串 “10101000101111...” => 对照赫夫曼编码表 => 转成对应的字符串

  /**
   * 编写一个方法，完成对 压缩数据 的 解码
   *
   * @param huffmanCodes   赫夫曼编码 表 map
   * @param huffmanByBytes 赫夫曼编码得到的字节数组
   * @return 返回的是源来的字符串对应的数组
   */
  private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanByBytes) {
    // 1. 先得到 huffmanByBytes 对应的二进制的字符串， 形式“1010100010111....”
    StringBuilder stringBuilder = new StringBuilder();
    // 将byte数组转成二进制的字符串
    for (int i = 0; i < huffmanByBytes.length; i++) {
      byte b = huffmanByBytes[i];
      // 判断是不是最后一个字节
      boolean flag = (i == huffmanByBytes.length - 1);
      stringBuilder.append(byteToBitString(!flag, b));
    }

    // 把字符串按照指定的赫夫曼编码进行解码
    // 把赫夫曼编码 表 进行调换，因为反向查询 a -> 100   100 -> a
    Map<String, Byte> map = new HashMap<>();
    for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
      map.put(entry.getValue(), entry.getKey());
    }
    // 创建一个集合，存放byte
    List<Byte> list = new ArrayList<>();
    // i 可以理解成就是索引，扫描 stringBuilder
    for (int i = 0; i < stringBuilder.length(); ) {
      int count = 1; // 小的计数器
      boolean flag = true;
      Byte b = null;
      while (flag) {
        // 1010100010111....
        // 递增的取出 key 1...
        String key = stringBuilder.substring(i, i + count); // i 不动，让count移动，指定匹配到一个字符
        b = map.get(key);
        if (b == null) { // 说明没有匹配到
          count++;
        } else {
          // 匹配到
          flag = false;
        }
      }
      list.add(b);
      i += count; // i 直接移动到 count
    }
    // 当for循环结束后，我们list中就存放了所有字符
    // 把list 中的数据放入到byte[] 并返回
    byte[] b = new byte[list.size()];
    for (int i = 0; i < b.length; i++) {
      b[i] = list.get(i);
    }

    return b;
  }

  /**
   * 将一个byte 转成一个二进制的字符串，
   * @param b    要转换的byte
   * @param flag 标识是否需要补高位，如果是true表示需要补高位，如果是false表示不补，如果是最后一个字节无需补高位
   * @return 是该b 对应的二进制的字符串，(注意是按补码返回)
   */
  private static String byteToBitString(boolean flag, byte b) {
    // 使用一个变量保存 b
    int temp = b; // 将 b 转成 int
    // 如果是正数我们还存在补高位
    if (flag) {
      temp |= 256; // 按位与 256  1 0000 0000  |  0000 0001  ==>  1 0000 0001
    }
    String str = Integer.toBinaryString(temp); // 放回的是temp对应的二进制的补码

    if (flag || temp < 0) {
      return str.substring(str.length() - 8);
    } else {
      return str;
    }
  }


  /**
   * 使用一个方法，将前面的方法封装起来，便于我们的调用
   * @param byteps 原始的字符串对应的字节数组
   * @return 返回的是 经过 赫夫曼编码 处理 后的字节数组 (压缩后的数组)
   */
  private static byte[] huffmanZip(byte[] byteps) {
    //  将字节数组 以 List 形式存储 => [new Node(byte，个数)，...]
    List<Node> nodes = getNodes(byteps);
    // 根据 nodes 创建赫夫曼树
    Node huffmanTreeRoot = createHuffmanTree(nodes);
    // 生成对应的赫夫曼编码 (根据 赫夫曼树)
    Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
    // 根据生成的赫夫曼编码，压缩得到压缩后的 赫夫曼编码 字节数组
    byte[] huffmanCodeBytes = zip(byteps, huffmanCodes);

    return huffmanCodeBytes;
  }

  /**
   * 编写一个方法，将字符串对应的byte[] 数组，通过生成的赫夫曼表，返回一个赫夫曼编码 压缩后的byte[];
   * @param bytes        这是原始的字符串对应的 byte[]
   * @param huffmanCodes 生成的赫夫曼编码map
   * @return 返回赫夫曼处理后的 byte[] ， 返回的是字符串对应的 ==> ['10101000'，....]
   * 即8位对应一个byte，放入到 huffmanCodeBytes
   * huffmanCodeBytes[0]  => 10101000(补码) => byte [推导 10101000 => 10101000 - 1 =>
   * 10100111(反码) => 11011000 = -88]
   */
  private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
    // 1. 利用 huffmanCodes 将 bytes 转成 赫夫曼编码对应的字符串
    StringBuilder stringBuilder = new StringBuilder();
    // 遍历 bytes 数组
    for (byte b : bytes) {
      stringBuilder.append(huffmanCodes.get(b)); // 这个就是形成了 赫夫曼编码 ==> “10101000101111...”
    }
    //    System.out.println("测试 stringBuilder = " + stringBuilder);
    // 将“10101000101111...” 转成 byte[]
    // 统计返回 byte[] huffmanCodeBytes 长度
    // 一句话 int len = (stringBuilder.length + 7) / 8
    int len;
    if (stringBuilder.length() % 8 == 0) {
      len = stringBuilder.length() / 8;
    } else {
      len = stringBuilder.length() / 8 + 1;
    }
    // 创建 存储压缩后的 byte数组
    byte[] huffmanCodeBytes = new byte[len];

    int index = 0; // 记录是第几个byte
    for (int i = 0; i < stringBuilder.length(); i += 8) { // 因为是每8位对应一个byte，所以步长 +8
      String strByte;
      if (i + 8 > stringBuilder.length()) {  // 不够8位
        strByte = stringBuilder.substring(i);
      } else {
        strByte = stringBuilder.substring(i, i + 8);
      }
      // 将strByte 转成一个byte，放入到huffmanCodeBytes
      huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
      index++;
    }

    return huffmanCodeBytes;
  }

  // 生成 赫夫曼树 对应的 赫夫曼编码
  // 思路:
  // 1. 将 赫夫曼编码 表存放在 Map<Byte, String> ==> {32=01, 97=100, 100=11000,....}
  static Map<Byte, String> huffmanCodes = new HashMap<>();  // 赫夫曼编码
  // 2. 在生成赫夫曼编码表时，需要去拼接路径，定义一个StringBuilder 存储某个叶子结点的路径
  static StringBuilder stringBuilder = new StringBuilder();


  // 为了调用方便，我们重载 getCodes
  private static Map<Byte, String> getCodes(Node root) {
    if (root == null) {
      return null;
    }
    // 处理root 的左子树
    getCodes(root.left, "0", stringBuilder);
    // 处理root的右子树
    getCodes(root.right, "1", stringBuilder);
    return huffmanCodes;
  }

  /**
   * 功能: 将传入的node结点的所有叶子结点的赫夫曼编码，并放入到huffmanCodes集合中
   *
   * @param node          传入根结点
   * @param code          路径: 左子结点是 0，右子结点是 1
   * @param stringBuilder 用于并接路径
   */
  private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
    StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
    // 将code 加入到 stringBuilder2
    stringBuilder2.append(code);
    if (node != null) { // 如果node == null 不处理
      // 判断当前node 是叶子结点还是非叶子结点
      if (node.data == null) { // 非叶子结点
        // 递归处理
        // 向左递归
        getCodes(node.left, "0", stringBuilder2);
        // 向右递归
        getCodes(node.right, "1", stringBuilder2);
      } else { // 说明是一个叶子结点
        // 就表示找到某个结点的最后
        huffmanCodes.put(node.data, stringBuilder2.toString());
      }
    }
  }

  /**
   * @param bytes 接收字节数组
   * @return 放回的就是 List 形式 | [Node[date=97, weight=5],....]
   */
  private static List<Node> getNodes(byte[] bytes) {
    // 创建一个ArrayList
    List<Node> nodes = new ArrayList<>();

    // 遍历 bytes，存储每个byte出现的次数 -> map[key，value]
    Map<Byte, Integer> counts = new HashMap<>();
    for (byte b : bytes) {
      Integer count = counts.get(b);
      if (count == null) { // Map还没有这个字符数据
        counts.put(b, 1);
      } else {
        counts.put(b, count + 1);
      }
    }

    // 把每一个键值对转成一个Node 对象，并加入到nodes集合
    // 遍历map                   counts.entrySet();获取键值对
    for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
      nodes.add(new Node(entry.getKey(), entry.getValue()));
    }

    return nodes;
  }

  // 可以通过List 创建对应的  赫夫曼树
  private static Node createHuffmanTree(List<Node> nodes) {
    while (nodes.size() > 1) {
      // 排序， 从小到大
      Collections.sort(nodes);
      // 取出第一颗最小的二叉树
      Node leftNode = nodes.get(0);
      // 取出第二颗最小的二叉树
      Node rightNode = nodes.get(1);
      // 创建一颗新的二叉树，他的根节点 没有data，只有权值
      Node parent = new Node(null, leftNode.weight + rightNode.weight);
      parent.left = leftNode;
      parent.right = rightNode;

      // 将已经处理的两颗二叉树从node删除
      nodes.remove(leftNode);
      nodes.remove(rightNode);
      // 将新的二叉树，加入到nodes
      nodes.add(parent);
    }
    // nodes 最后的结点，就是赫夫曼树的根节点
    return nodes.get(0);
  }

  /**
   * 前序遍历
   */
  private static void preOrder(Node root) {
    if (root != null) {
      root.preOrder();
    } else {
      System.out.println("赫夫曼树为空");
    }
  }
}
