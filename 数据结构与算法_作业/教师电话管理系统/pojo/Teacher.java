package 数据结构与算法.数据结构与算法_作业.教师电话管理系统.pojo;

/**
 * @author happy
 * 教师信息
 */
public class Teacher {
  private String jobNo; // 工号
  private String name; // 姓名
  private char gender; // 性别
  private int age; // 年龄
  private String telephoneNo; // 电话号
  private Object personalInformation; // 个人信息

  private Teacher leftThread; // 左
  private Teacher rightThread; // 右
  private Teacher lastNode; // 最后一个结点

  public Teacher() {
  }
  public String getJobNo() {
    return jobNo;
  }

  public Teacher setJobNo(String jobNo) {
    this.jobNo = jobNo;
    return this;
  }

  public String getName() {
    return name;
  }

  public Teacher setName(String name) {
    this.name = name;
    return this;
  }

  public char getGender() {
    return gender;
  }

  public Teacher setGender(char gender) {
    this.gender = gender;
    return this;
  }

  public int getAge() {
    return age;
  }

  public Teacher setAge(int age) {
    this.age = age;
    return this;
  }

  public String getTelephoneNo() {
    return telephoneNo;
  }

  public Teacher setTelephoneNo(String telephoneNo) {
    this.telephoneNo = telephoneNo;
    return this;
  }

  public Object getPersonalInformation() {
    return personalInformation;
  }

  public Teacher setPersonalInformation(Object personalInformation) {
    this.personalInformation = personalInformation;
    return this;
  }

  public Teacher getLeftThread() {
    return leftThread;
  }

  public void setLeftThread(Teacher leftThread) {
    this.leftThread = leftThread;
  }

  public Teacher getRightThread() {
    return rightThread;
  }

  public void setRightThread(Teacher rightThread) {
    this.rightThread = rightThread;
  }

  public Teacher getLastNode() {
    return lastNode;
  }

  public void setLastNode(Teacher lastNode) {
    this.lastNode = lastNode;
  }

  @Override
  public String toString() {
    return "Teacher{" +
        "jobNo='" + jobNo + '\'' +
        ", name='" + name + '\'' +
        ", gender=" + gender +
        ", age=" + age +
        ", telephoneNo='" + telephoneNo + '\'' +
        ", personalInformation=" + personalInformation +
        ", rightThread=" + rightThread +
        '}';
  }
}
