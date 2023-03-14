package 数据结构与算法.算法系统练习.力扣;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class 全排列 {
  public static void main(String[] args) {
    List<List<Integer>> permute = new 全排列().permute2(new int[]{1, 2, 3});
    System.out.println(permute);
  }


  List<List<Integer>> list = new ArrayList<List<Integer>>();

  public List<List<Integer>> permute2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return list;
    }

    quangBuang(nums, list, new ArrayList<Integer>());

    return list;
  }

  private void quangBuang(int[] nums, List<List<Integer>> list, List<Integer> newList) {
    if (newList.size() == nums.length) {
      list.add(new ArrayList<>(newList));
      return;
    }
    for (int num : nums) {
      if (newList.contains(num)) {
        continue;
      }
      newList.add(num);
      quangBuang(nums, list, newList);
      newList.remove(newList.size() - 1);
    }
  }


  List<List<Integer>> res = new ArrayList<List<Integer>>();

  public List<List<Integer>> permute(int[] nums) {
    if (nums == null || nums.length == 0) {
      return res;
    }
    backtrack(nums, new ArrayList<Integer>());
    return res;
  }

  private void backtrack(int[] nums, ArrayList<Integer> curr) {
    if (nums.length == curr.size()) {
      res.add(new ArrayList<Integer>(curr));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (curr.contains(nums[i])) {
        continue;
      }
      curr.add(nums[i]);
      backtrack(nums, curr);
      curr.remove(curr.size() - 1); // 回归到上一步状态，这叫回溯
    }
  }


}
