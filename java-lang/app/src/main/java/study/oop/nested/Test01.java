package study.oop.nested;

public class Test01 {
  interface Printer {
    void print();
  }

  public static void main(String[] args) {

    // class PrinterImpl implements Printer {
    // @Override
    // public void print() {
    // System.out.println("Hello!");
    // }
    // }

    // 익명 클래스 선언 방법.
    // new Printer() {
    // @Override
    // public void print() {
    // System.out.println("Hello!");
    // }
    // }.print();

    // Printer obj = new Printer() {
    // @Override
    // public void print() {
    // System.out.println("Hello!");
    // }
    // };
    // obj.print();

    // Printer obj = new Printer() {
    // @Override
    // public void print() {
    // System.out.println("Hello!");
    // }
    // };

    // 람다 문법. - 추상 메서드가 하나만 있어서 이름을 명시하지 않아도 override 할 수 있다.
    // => 이걸 람다문법으로 사용한다.
    // () -> {System.out.println("Hello!");}.print(); 이렇게는 사용할 수 없다.
    Printer obj;
    obj = () -> {
      System.out.println("Hello!");
    };

    obj.print();

  }
}
