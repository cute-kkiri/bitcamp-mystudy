package study.oop.lambda;

public class Test01 {

  interface Player {
    void play();
  }
  // 추상 클래스는 람다문법을 사용할 수 없다.

  public static void main(String[] args) {
    // 1) 일반 클래스
    class MyPlayer implements Player {
      @Override
      public void play() {
        System.out.println("일반 클래스!");
      }
    }
    Player p1 = new MyPlayer();
    p1.play();

    // 2) 익명 클래스
    Player p2 = new Player() {
      @Override
      public void play() {
        System.out.println("익명 클래스");
      }
    };
    p2.play();

    // 3) 익명 클래스 + 메서드 호출
    new Player() {
      @Override
      public void play() {
        System.out.println("익명 클래스 2");
      }
    }.play();

    // 4) 람다
    Player p3 = () -> {
      System.out.println("람다");
    };
    p3.play();

    // 5) 람다 + 중괄호 생략
    Player p4 = () -> System.out.println("람다2");
    p4.play();

  }
}
