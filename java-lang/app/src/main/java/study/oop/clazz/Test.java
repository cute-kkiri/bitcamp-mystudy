package study.oop.clazz;

public class Test {
  // 인스턴스를 사용하지 않는 메서드는 static으로 생성.
  static void m1(int a) {
    int b;
    b = 200;
  }

  // 인스턴스 변수를 사용할 때 인스턴스 메서드를 생성.
  void m2(int a) {
    // Test this; // 내장 변수 this
    int b;
    b = 300;
  }
}


class TestOk {
  public static void main(String[] args) {
    Test.m1(100);

    // String s = "hello";
    // s.m2(100);

    // 컴파일은 통과되지만 null 오류.
    Test objn = null;
    objn.m2(100); // null point exception error

    Test obj = new Test();
    obj.m2(100);

    // 오류는 아님. // 문법적으로 문제는 없음.
    obj.m1(100); // static 메서드를 인스턴스 메서드처럼 보이게 짜면 헷갈리니까 하지마.
  }
}
