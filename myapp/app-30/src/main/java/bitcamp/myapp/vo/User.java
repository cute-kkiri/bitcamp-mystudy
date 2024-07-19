package bitcamp.myapp.vo;

import java.io.Serializable;
import java.util.Objects;

// Serializable 인터페이스
// - 추상 메서드가 없다.
// - 직렬화/역직렬화를 승인한다는 표시로 사용한다.
// - 유사한 예) Cloneable 인터페이스
public class User implements Serializable {

  private static int seqNo;

  private int no;
  private String name;
  private String email;
  private String password;
  private String tel;

  public User() {
  }

  public User(int no) {
    this.no = no;
  }

  public static int getNextSeqNo() {
    return ++seqNo;
  }

  public static void initSeqNo(int no) {
    seqNo = no;
  }

  public static int getSeqNo() {
    return seqNo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return no == user.no;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(no);
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }
}
