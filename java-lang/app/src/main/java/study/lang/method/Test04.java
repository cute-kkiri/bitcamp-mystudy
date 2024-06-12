package study.lang.method;

public class Test04 {
  public static void main(String[] args) {
    // String message = m1("홍길동", 20);
    // System.out.println(message);
    System.out.println(m1("홍길동", 20));
  }

  static String m1(String name, int age) {
    // String message = name + "(" + age + ")님 반가워요!";
    // String message = String.format("%s(%d)님 반가워요", name, age); // String 도구함(class)에 format이 있음.
    return String.format("%s(%d)님 반가워요", name, age);
  }
}
