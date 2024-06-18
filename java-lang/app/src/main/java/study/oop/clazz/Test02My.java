// package 먼저 선언 후 import 순서 지키기.

package study.oop.clazz;

import study.oop.clazz.domain.Score;

// 연습: 클래스 문법을 데이터 타입 정의하는 용도로 사용
public class Test02My {
  public static void main(String[] args) {

    // 다른 패키지는 쓸 때마다 선언해줘야 한다.
    // 하지만 import를 해주어서 줄일 수 있다.
    // study.oop.clazz.vo.Score s1 = new Score();

    // Score s = new Score(); // 기본 생성자가 없을 때 그냥 호출하면 오류.

    Score s1 = new Score("홍길동", 100, 90, 85);
    // 직접 손대면 안되는 변수를 건드리지 않게 한다.
    // s1.sum = 100;
    s1.setName("홍길순");
    s1.setKor(55);

    // s1.name = "홍길동";
    // s1.kor = 100;
    // s1.eng = 90;
    // s1.math = 85;
    // s1.compute();
    printScore(s1);

    // study.oop.clazz.vo.Score s2 = new Score();
    Score s2 = new Score("임꺽정", 90, 80, 90);

    // s2.name = "임꺽정";
    // s2.kor = 90;
    // s2.eng = 80;
    // s2.math = 75;
    // s2.compute();
    printScore(s2);

    // study.oop.clazz.vo.Score s3 = new Score();
    Score s3 = new Score("유관순", 80, 70, 65);

    // s3.name = "유관순";
    // s3.kor = 80;
    // s3.eng = 70;
    // s3.math = 65;
    // s3.compute();
    printScore(s3);
  }

  // 하나의 메서드는 하나의 기능만 수행한다.
  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.getName(), s.getKor(), s.getEng(),
        s.getMath(), s.getSum(), s.getAver());
  }


}
