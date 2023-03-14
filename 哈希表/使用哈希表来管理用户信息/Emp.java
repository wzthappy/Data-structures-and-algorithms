package 数据结构与算法.哈希表.使用哈希表来管理用户信息;

/**
 * 表示一个用户
 */
public class Emp {
  public int id;
  public String name;
  public Emp next; // 默认为空

  public Emp(int id, String name) {
    this.id = id;
    this.name = name;
  }
}
