package study.oop.clazz;

// 컴파일러를 위해서 패키지 명을 명확하게 적어줘야하기 때문에 import를 사용.
// java.lang 패키지 안에 있는 클래스는 워낙 기본 적인 것이라서 안적어줘도 됐었다.(ex. String(=java.lang.String))
import study.oop.clazz.util.Calculator;

// 연습: 클래스 문법을 메서드 분류하는 용도로 사용.
// 1) 메서드 분류
// 2) static 필드 사용
// 3) non-static 필드 사용
// 4) 인스턴스 메서드 사용
// 5) private, getter 사용
// 6) 인스턴스 메서드 사용: clear()

public class Test01 {

  public static void main(String[] args) {

    Calculator c1 = new Calculator();

    c1.plus(2);
    c1.plus(3);
    c1.minus(1);
    c1.multiple(7);
    c1.divide(3);

    System.out.printf("result = %d\n", c1.getResult());

    c1.clear();

    c1.plus(5);
    System.out.printf("result = %d\n", c1.getResult());
  }
}
