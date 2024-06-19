package study.oop.clazz;

public class Test04 {
  public static void main(String[] args) {
    X.m1();

    X obj = new X();
    obj.m1();
    obj.m2();
  }
}


class X {

  static int v1 = 100;
  int v2 = 200;

  static class N1 {
  }
  class N2 {
  }

  static void f1() {}

  void f2() {}

  static void m1() {
    System.out.println("m1()----------------");
    System.out.println(v1);
    // System.out.println(this.v2);
    N1 r1 = new N1();
    // N2 r2 = this.new N2();
    f1();
    // this.f2();
  }

  void m2() {
    System.out.println("m2()----------------");
    System.out.println(v1);
    System.out.println(this.v2);
    N1 r1 = new N1();
    N2 r2 = this.new N2();
    f1();
    this.f2();
  }
}
