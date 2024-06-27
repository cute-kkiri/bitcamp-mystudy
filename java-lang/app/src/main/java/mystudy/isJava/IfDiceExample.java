package mystudy.isJava;

public class IfDiceExample {
  public static void main(String[] args) {
    // 주사위를 굴려서 나올 수 있는 수를 뽑아서 출력.
    // start부터 시작하는 n개의 정수 중에서 하나의 정수를 얻기 위한 코드.
    // int num = (int) (Math.random() * n) + start;

    int num = (int) (Math.random() * 6) + 1; // 주사위 번호 뽑기. (랜덤)

    if (num == 1) {
      System.out.println("1번이 나왔습니다.");
    } else if (num == 2) {
      System.out.println("2번이 나왔습니다.");
    } else if (num == 3) {
      System.out.println("3번이 나왔습니다.");
    } else if (num == 4) {
      System.out.println("4번이 나왔습니다.");
    } else if (num == 5) {
      System.out.println("5번이 나왔습니다.");
    } else {
      System.out.println("6번이 나왔습니다.");
    }

  }
}
