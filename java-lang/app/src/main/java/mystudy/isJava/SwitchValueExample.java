package mystudy.isJava;

// 스위치된 값을 변수에 바로 대입할 수도 있다.
public class SwitchValueExample {
  public static void main(String[] args) {
    String grade = "B";

    // Java 11 이전 문법
    int score1 = 0;
    switch (grade) {
      case "A":
        score1 = 100;
        break;
      case "B":
        int result = 100 - 29;
        score1 = result;
        break;
      default:
        score1 = 60;
    }
    System.out.println("score1: " + score1);

    // Java 13부터 가능
    int score2 = switch (grade) {
      case "A" -> 100; // 단일 값일 경우에 화살표 오른쪽에 값을 기술
      case "B" -> {
        int result = 100 - 20;
        yield result; // 중괄호를 사용할 경우에는 yield키워드로 값을 지정.
      }
      default -> 60; // default가 반드시 존재해야 한다.
    };
    System.out.println("score2: " + score2);
  }
}
