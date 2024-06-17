package study.oop.clazz;

// 연습: 클래스 문법을 메서드 분류하는 용도로 사용.

public class Test01My {
  public static void main(String[] args) {
    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 2 + 3 - 1 * 7 / 3 = 9
    // 3 * 4 / 2 + 6 = 12

    // 계산을 Calculator가 하기 때문에 결과를 직접 가지고 있는 것이 유지보수에 용이하다.
    // Calculator.result = 0; // Calculator의 result를 0으로 초기화.

    // 메서드가 사용할 result 변수를 생성
    // static이 아닌 Heap 영역에 생성될 변수 생성.
    /*
     * Calculator c1 = new Calculator(); // 첫번째 계산식의 결과를 저장할 변수 생성. Calculator c2 = new
     * Calculator(); // 두번째 계산식의 결과를 저장할 변수 생성.
     *
     * Calculator.plus(c1, 2); // 2 (계산식1) Calculator.plus(c2, 3); // 3 (계산식2)
     *
     * Calculator.plus(c1, 3); // 2 + 3 (계산식1) Calculator.multiple(c2, 4); // 3 * 4 (계산식2)
     *
     * Calculator.minus(c1, 1); // 2 + 3 - 1 (계산식1) Calculator.divide(c2, 2); // 3 * 4 / 2 (계산식2)
     *
     * Calculator.multiple(c1, 7); // 2 + 3 - 1 * 7 (계산식1) Calculator.plus(c2, 6); // 3 * 4 / 2 + 6
     * (계산식2)
     *
     * Calculator.divide(c1, 3); // 2 + 3 - 1 * 7 / 3 (계산식1)
     *
     *
     * System.out.printf("result1 = %d\n", c1.result); System.out.printf("result2 = %d\n",
     * c2.result);
     */

    /*
     * Calculator c1 = new Calculator(); // 첫번째 계산식의 결과를 저장할 변수 생성. Calculator c2 = new
     * Calculator(); // 두번째 계산식의 결과를 저장할 변수 생성.
     *
     * c1.plus(2); // 2 (계산식1) c2.plus(3); // 3 (계산식2)
     *
     * c1.plus(3); // 2 + 3 (계산식1) c2.multiple(4); // 3 * 4 (계산식2)
     *
     * c1.minus(1); // 2 + 3 - 1 (계산식1) c2.divide(2); // 3 * 4 / 2 (계산식2)
     *
     * c1.multiple(7); // 2 + 3 - 1 * 7 (계산식1) c2.plus(6); // 3 * 4 / 2 + 6 (계산식2)
     *
     * c1.divide(3); // 2 + 3 - 1 * 7 / 3 (계산식1)
     *
     *
     * System.out.printf("result1 = %d\n", c1.result); System.out.printf("result2 = %d\n",
     * c2.result);
     */

    CalculatorlMy c1 = new CalculatorlMy();

    c1.plus(2); // 2 (계산식1)
    c1.plus(3); // 2 + 3 (계산식1)
    c1.minus(1); // 2 + 3 - 1 (계산식1)
    c1.multiple(7); // 2 + 3 - 1 * 7 (계산식1)
    c1.divide(3); // 2 + 3 - 1 * 7 / 3 (계산식1)
    // c1.result = 100; // 이렇게 임의로 변경하지 못 하게 result를 private으로 접근 제어를 했다.

    System.out.printf("result1 = %d\n", c1.getResult());

    // 새 계산식: 8 * 2 - 3 = 13
    c1.clear();
    c1.plus(8);
    c1.multiple(2);
    c1.minus(3);

    System.out.printf("result2 = %d\n", c1.getResult());
  }
}
