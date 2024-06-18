package study.oop.clazz;

public class CalculatorlMy {

  // 계산 결과를 담을 변수를 준비한다.
  // int result = 0; // non-static 필드(변수) // 인스턴스 필드
  private int result = 0; // 접근 제어 문법 사용.

  // 메서드를 호출하여 작업을 수행하고,
  // 리턴 결과는 로컬 변수에 저장한다.
  /*
   * static void plus(Calculator that, int a) { // Calculator that => 인스턴스 변수 that.result += a; }
   *
   * static void minus(Calculator that, int a) { that.result -= a; }
   *
   * static void multiple(Calculator that, int a) { that.result *= a; }
   *
   * static void divide(Calculator that, int a) { that.result /= a; }
   */
  // 인스턴스 필드를 사용할 때는 파라미터로 표현?

  // 인스턴스 메서드를 사용할 때는 static을 사용하면 안된다.
  void plus(int a) {
    this.result += a;
  }

  void minus(int a) {
    this.result -= a;
  }

  void multiple(int a) {
    this.result *= a;
  }

  void divide(int a) {
    this.result /= a;
  }

  // private 변수에 대한 조회를 위한 메서드
  int getResult() { // getter 사용.
    return this.result;
  }

  // 다시 사용하고 싶을 때 사용하기 위한 초기화 메서드.
  void clear() { // 인스턴스 메서드 사용.
    this.result = 0;
  }
}
