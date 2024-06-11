package study.lang.variable;

public class Test03 {
  public static void main(String[] args) {
    String s;
    // s = null; // 레퍼런스 변수라서 null이 가능.

    s = new String("aaa");

    String s2 = new String("aaa");

    System.out.println(s == s2); // 레퍼런스에 들어 있는 값을 비교한다.

  }

}
