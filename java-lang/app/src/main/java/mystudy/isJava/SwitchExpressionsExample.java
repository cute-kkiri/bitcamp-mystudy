package mystudy.isJava;

public class SwitchExpressionsExample {
  public static void main(String[] args) {
    char grade = 'B';

    // switch Expressions(표현식) ->(화살표)와 {}(중괄호)를 이용한 break문을 없애는 switch문.
    switch (grade) {
      case 'A', 'a' -> {
        System.out.println("우수 회원입니다.");
      }
      case 'B', 'b' -> {
        System.out.println("일반 회원입니다.");
      }
      default -> {
        System.out.println("손님입니다.");
      }
    }

    switch (grade) {
      case 'A', 'a' -> System.out.println("우수 회원입니다.");
      case 'B', 'b' -> System.out.println("일반 회원입니다.");
      default -> System.out.println("손님입니다.");
    }
  }

}
