// package 먼저 선언 후 import 순서 지키기.

package study.oop.clazz;

import study.oop.clazz.domain.Score;

// import study.oop.clazz.vo.Score;

// 연습: 클래스 문법을 데이터 타입 정의하는 용도로 사용
public class Test02 {
  static Score[] scores =
      {new Score("홍길동", 100, 90, 85), new Score("임꺽정", 90, 80, 75), new Score("유관순", 80, 70, 65),};

  public static void main(String[] args) {

    printScore();

    // printScore(scores[0]);
    // printScore(scores[1]);
    // printScore(scores[2]);

    // for (int i = 0; i < scores.length; i++) {
    // printScore(scores[i]);
    // }

    // for (Score score : scores) {
    // printScore(score);
    // }

    // Score s1 = new Score("홍길동", 100, 90, 85);
    // s1.kor = 200; // 값이 왜곡될 수 있다.
    // s1.name = "홍길똥";
    // s1.setName("홍낄똥");
    // s1.setKor(20);

    // Score s2 = new Score("임꺽정", 90, 80, 75);
    // printScore(s2);

    // Score s3 = new Score("유관순", 80, 70, 65);
    // printScore(s3);
  }

  static void printScore() {
    for (Score score : scores) {
      System.out.printf("%s: %d, %d, %d, %d, %.1f\n", score.getName(), score.getKor(),
          score.getEng(), score.getMath(), score.getSum(), score.getAver());
    }
  }
}
