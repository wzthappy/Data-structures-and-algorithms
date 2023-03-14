package 数据结构与算法.算法系统练习.练习.位运算符.找出唯一成对的数;

import java.util.Arrays;
import java.util.Random;

/**
 * 1~1000这1000个数放在含有1001个元素的数组中，只有唯一的一个元素值重复，其他均只出现一次。每次数组元素
 * 只能访问一次，设计一个算法，将他找出来；不用辅助存储空间
 */
public class WeYi {
  public static void main(String[] args) {
//    int N = 1001;
    int N = 11; // 好看一点
    int[] arr = new int[N];
    for (int i = 0; i < arr.length - 1; i++) {
      arr[i] = i + 1;
    }
    // 最后一个是随机数
    arr[arr.length - 1] = new Random().nextInt(N - 1) + 1;
    // 随机下表
    int index = new Random().nextInt(N);
    int v = arr[index]; // 替换一下
    arr[index] = arr[arr.length - 1];
    arr[arr.length - 1] = v;
    System.out.println(Arrays.toString(arr));


    int x1 = 0;
    for (int i = 1; i <= N - 1; i++) {  // (1 ~ N) 的 ^
      x1 = x1 ^ i;
    }
    for (int i = 0; i < N; i++) {   // (1 ~ ^ ~ N) ^ (1 ~ ^ ~ N - 1)
      x1 = x1 ^ arr[i];
    }
    System.out.println(x1);


    System.out.println("========= 对比一下 - 使用额外空间的方式: 这种方式慢 =========");
    int[] heloer = new int[N];
    for (int i = 0; i < N; i++) {
      heloer[arr[i]]++; // 在相同下表++
      if (heloer[arr[i]] == 2) { // 下表为2的就表示有两个相同的数
        System.out.println(arr[i]);
        break;
      }
    }
  }
}
