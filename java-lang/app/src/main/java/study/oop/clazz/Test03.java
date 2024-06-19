package study.oop.clazz;

// public class 명과 파일이름이 같아야한다.
public class Test03 {

  // Test03을 컴파일 했을 때 Test03클래스 안에 중첩 클래스가 같이 포함되는건 아니다.
  // nested class
  class B {
  } // non-static nested class
  static class C {
  } // static nested class

  // Object를 상속받은 익명클래스
  Object obj1 = new Object() {}; // anonymous class

  void m1() {
    class D {
    } // local class
    Object obj2 = new Object() {}; // anonymous class
  }
}


// package member class
class A {
}
