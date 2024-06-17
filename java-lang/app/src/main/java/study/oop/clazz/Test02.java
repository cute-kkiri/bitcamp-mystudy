// package 먼저 선언 후 import 순서 지키기.

package study.oop.clazz;

import study.oop.clazz.vo.Score;

// 연습: 클래스 문법을 데이터 타입 정의하는 용도로 사용
public class Test02 {
  public static void main(String[] args) {
    Score s1 = new Score("홍길동", 100, 90, 85);
    s1.setKor(10);
    printScore(s1);

    Score s2 = new Score("임꺽정", 90, 80, 75);
    s2.setName("임걱정");
    printScore(s2);

    Score s3 = new Score("유관순", 80, 70, 65);
    printScore(s3);
  }


  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.getName(), s.getKor(), s.getEng(),
        s.getMath(), s.getSum(), s.getAver());
  }
}
