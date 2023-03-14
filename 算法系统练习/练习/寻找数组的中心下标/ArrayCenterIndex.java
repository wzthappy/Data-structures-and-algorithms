package 数据结构与算法.算法系统练习.练习.寻找数组的中心下标;

import java.util.Arrays;

/**
 * 给定一个整数数组nums，请编写一个能够返回数组"中心下标"的方法
 * <p>
 * 中心下标是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和
 * 如果数据不存在中心下标，返回-1. 如果数组有多个中心下标，应该返回最靠近右侧的那一个
 * <p>
 * 注意: 中心下标可能出现在数组的两端
 */
public class ArrayCenterIndex {
  public static void main(String[] args) {
    // 1 + 7 + 3 = 11  +  6=17     6 是数中心的数，返回3     5 + 6 = 11  +  6=17
    System.out.println(pivotIndex(new int[]{1, 7, 3, 6 ,5, 6}));
    System.out.println(prIndex(new int[]{1, 7, 3, 6 ,5, 6}));
  }

  public static int pivotIndex(int[] nums) {
    int sum1 = Arrays.stream(nums).sum();  // 流式 求和
    int total = 0;
    for (int i = 0; i < nums.length; i++) {
      total += nums[i];
      if (total == sum1) {
        return i;
      }
      sum1 -= nums[i];
    }
    return -1;
  }

  public static int prIndex(int[] nums) {
    int sum1 = Arrays.stream(nums).sum();
    int total = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      total += nums[i];
      if (2 * total + nums[i + 1] == sum1) {
        return i + 1;
      }
    }
    return -1;
  }
}
