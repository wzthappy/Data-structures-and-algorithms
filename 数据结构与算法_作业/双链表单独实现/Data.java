package 数据结构与算法.数据结构与算法_作业.双链表单独实现;

public class Data {
  private final String id; // 唯一标识
  private String name; // 名字
  private String age; // 年龄

  public Data(String id, String name, String age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Data{" +
        "name='" + name + '\'' +
        ", age='" + age + '\'' +
        '}';
  }
}
